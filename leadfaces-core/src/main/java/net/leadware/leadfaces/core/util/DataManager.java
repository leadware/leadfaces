package net.leadware.leadfaces.core.util;

import java.util.Collection;

import javax.faces.component.UIData;
import javax.faces.model.DataModel;


/**
 * Classe de gestion des composants de présentation de collection de données
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 * 
 * @param <T> Type de données
 */
public class DataManager<T> {
	
	/**
	 * Collection de données
	 */
	protected Collection<T> dataCollection;
	
	/**
	 * Composant d'interface
	 */
	protected UIData dataComponent;
	
	/**
	 * Modèle de données
	 */
	protected DataModel<T> dataModel;
	
	/**
	 * Donnée sélectionnée
	 */
	protected T selectedData;
	
	
	/**
	 * Constructeur par défaut
	 */
	public DataManager() {
		
		super();			
	}
	

	/**
	 * Retourne la valeur de la propriété dataCollection
	 * @return La propriété dataCollection
	 */
	public Collection<T> getDataCollection() {
		return dataCollection;		
	}


	/**
	 * Met à jour la propriété dataCollection
	 * @param dataCollection Nouvelle valeur de la propriété dataCollection
	 */
	public void setDataCollection(Collection<T> dataCollection) {
		this.dataCollection = dataCollection;
	}


	/**
	 * Retourne la valeur de la propriété dataComponent
	 * @return La propriété dataComponent
	 */
	public UIData getDataComponent() {
		return dataComponent;
	}


	/**
	 * Met à jour la propriété dataComponent
	 * @param dataComponent Nouvelle valeur de la propriété dataComponent
	 */
	public void setDataComponent(UIData dataComponent) {
		this.dataComponent = dataComponent;
	}


	/**
	 * Retourne la valeur de la propriété dataModel
	 * @return La propriété dataModel
	 */
	public DataModel<T> getDataModel() {
		return dataModel;
	}


	/**
	 * Met à jour la propriété dataModel
	 * @param dataModel Nouvelle valeur de la propriété dataModel
	 */
	public void setDataModel(DataModel<T> dataModel) {
		this.dataModel = dataModel;
	}

	/**
	 * Retourne la valeur de la propriété selectedData
	 * @return La propriété selectedData
	 */
	public T getSelectedData() {
		return selectedData;
	}

	/**
	 * Met à jour la propriété selectedData
	 * @param selectedData Nouvelle valeur de la propriété selectedData
	 */
	public void setSelectedData(T selectedData) {
		this.selectedData = selectedData;
	}
		
}
