package net.leadware.leadfaces.extensions.primefaces.view.behavior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;

import net.leadware.leadfaces.core.exception.LeadfacesException;
import net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior;
import net.leadware.leadfaces.extensions.primefaces.model.pagination.IPagination;
import net.leadware.leadfaces.extensions.primefaces.model.pagination.PaginationDataModel;
import net.leadware.leadfaces.extensions.primefaces.util.DialogFramework;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;



/**
 * Classe abstraite implémentant une logique fonctionnelle de base pour les vues de type CRUD
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 * 
 * @param <T> Donnée ou Entité à manager
 */
public abstract class PrimeCRUDViewBehavior<T> extends AbstractCRUDViewBehavior<T> implements IPagination<T> {

	/**
	 * ID de sérialisation
	 */
	private static final long serialVersionUID = 1L;


	/* (non-Javadoc)
	 * @see net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior#postConstruct()
	 */
	@Override
	@PostConstruct
	public void postConstruct() {
		
		// Appel parent
		super.postConstruct();
		
		// Définition du modèle de données
		this.getDataManager().setDataModel(this.getDataModelInstance());
	}
	
	
	/**
	 * Action de demande de consultation des détails par évènement (double-click)
	 * @param event Evènement de sélection
	 */
	public void displayOnEvent(SelectEvent event) {
								
		// Appel de la méthode de consultation via un ActionEvent
		this.display((javax.faces.event.ActionEvent)null);
	}
	
	
	/* (non-Javadoc)
	 * @see net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior#getDataModelInstance()
	 */
	@Override
	protected DataModel<T> getDataModelInstance() {
		return new PaginationDataModel<T>(this);
	}
	
	/* (non-Javadoc)
	 * @see net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior#search()
	 */
	@Override
	public void search() {
				
		try{						
			// Obtention du modèle de données
			DataModel<T> dataModel = this.getDataManager().getDataModel();
			
			// Si la pagination est active
			if(dataModel != null && dataModel instanceof LazyDataModel){

				// Décompte du nombre total de données
				long rowCount = this.businessCountByCriteria();

				// Mise à jour du nombre total de données dans le modèle			
				((LazyDataModel<T>)dataModel).setRowCount((int) rowCount);
				
				// Réinitialisation de l'offset à 0
				this.getDataManager().getDataComponent().setFirst(0);
				
				// Obtention de la liste partielle des agents indirectement par le composant dataTable
			}
			
			// Si la pagination n'est pas active
			else {
				
				// Recherche des données sans pagination				
				this.getDataManager().setDataCollection(this.businessSearchByCriteria(IPagination.PAGINATION_BEGINNING_OFFSET_INDEX_VALUE, IPagination.PAGINATION_DESACTIVATION_VALUE)); 
			}
			
		}
		catch(Exception e){
			
			// Gestion de l'exception
			this.handleViewException(e);
		}	
	}
	
	
	/* (non-Javadoc)
	 * @see net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior#select(java.lang.Object)
	 */
	@Override
	protected String select(T object) {

		// Si l'objet est indéfini
		if(object == null)			
			// L'on propage une exception
			throw new LeadfacesException(this.getFacesMessage(FacesMessage.SEVERITY_ERROR, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.SELECT_NO_DATA", (Object[]) null));		

		// Ferme la vue de sélection en passant en paramètre l'objet sélectionné
		DialogFramework.closeDialog(object);

		// Retour d'une valeur nulle, car il n'ya pas de navigation pour cette implémentation
		return null;
	}
	
	
	/**
	 * Méthode d'ouverture de la vue de sélection de données <br/>
	 * Par défaut c'est la vue de liste de données qui sera ouverte en mode modal <br/>
	 * Le paramètre <code> selectionMode </code> est postionné dans la vue avec pour valeur <code>true</code> pour indiquer le mode en sélection
	 * 
	 * @param event Evènement levé
	 */
	public void openSelectionView(ActionEvent event){

		// Paramètres de la vue de sélection
		Map<String,List<String>> params = new HashMap<String,List<String>>();

		// Paramètres indiquant le mode sélection
		List<String> selectionModeParameters = new ArrayList<String>();
		selectionModeParameters.add("true");
		params.put("selectionMode", selectionModeParameters);
		
		// Affichage de la vue de sélection des données
		DialogFramework.openDialog(this.getListViewOutcome(false), null /*options par defaut*/, params);					
	}	
	
	/**
	 * Méthode de gestion de l'évènement de sélection
	 * @param event Evènement de sélection
	 */
	public void handleSelectionEvent(SelectEvent event){
		
		this.handleSelection(event.getObject());
	}
	
	/**
	 * Méthode de gestion de l'objet sélectionné en mode sélection de données
	 * @param object Objet sélectionné
	 */
	protected abstract void handleSelection(Object object);
}
