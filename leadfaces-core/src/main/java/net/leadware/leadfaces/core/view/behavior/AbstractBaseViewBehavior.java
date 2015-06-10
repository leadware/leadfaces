package net.leadware.leadfaces.core.view.behavior;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

import net.leadware.leadfaces.core.i18n.Messages;
import net.leadware.leadfaces.core.util.JSFUtils;
import net.leadware.leadfaces.core.view.ViewType;




/**
 * Classe abstraite de définissant les bases de la logique fonctionelle les vues 
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public abstract class AbstractBaseViewBehavior implements Serializable {

	/**
	 * ID de sérialisation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant par défaut des beans managés responsables de la gestion des vues
	 */
	private static final String DEFAULT_VIEW_MANAGER_IDENTIFIER = "Bean";

	/**
	 * Identifiant de la vue
	 */
	private String viewIdentifier = null;

	
	/**
	 * Retourne l'identifiant des gestionnaires de vues
	 * @return Identifiant des gestionnaires des vues
	 */
	protected String getViewManagerIdentifier(){
		
		return DEFAULT_VIEW_MANAGER_IDENTIFIER;
	}

	/**
	 * Retourne l'identifiant la vue <br/>
	 * Par défaut le nom de la classe (avec la première lettre en minuscule) privé de l'identifiant des gestionnaires de vues
	 * @return Identifiant de la vue
	 */
	protected String getViewIdentifier(){
		
		// Si l'identifiant de la vue n'est pas défini
		if(this.viewIdentifier == null){

			// Nom de la classe
			String _viewIdentifier = this.getClass().getSimpleName();
			
			// Index de l'identifiant des gestionnaires de vues
			int index = _viewIdentifier.indexOf(this.getViewManagerIdentifier());
						
			// Si l'identifiant des gestionnaires de  vues existe bel et bien
			if(index > -1){
				// L'on  extrait l'identifiant
				_viewIdentifier = _viewIdentifier.replaceFirst(this.getViewManagerIdentifier(), "");
			}
			
			// Conversion de la première lettre en miniscule			
			String firstLetter = _viewIdentifier.substring(0, 1);
			_viewIdentifier = _viewIdentifier.replaceFirst(firstLetter, firstLetter.toLowerCase());
				
			// Mise à jour
			this.viewIdentifier = _viewIdentifier;			
		}
		
		return viewIdentifier;
	}	

	/**
	 * Méthode de construction d'une vue à partir de son type <br/>
	 * Utilise implicitement l'identifiant de la vue pour construire le nom de la vue
	 * @param viewtype Type de la vue
	 * @return Nom de la vue
	 */
	public String buildViewName(ViewType viewtype){
		
		// Construction du nom de la vue
		return ViewType.buildViewName(this.getViewIdentifier(), viewtype);
	}

	/**
	 * Action d'ouverture de la vue par défaut
	 * @return La navigation vers la vue appropriée
	 */
	public abstract String openDefaultView();	
	
	/**
	 * Action de fermeture de la vue courante
	 * @return La navigation vers la vue appropriée
	 */
	public abstract String closeView();
	
	
	/**
	 * Méthode de gestion des exceptions à destination des vues
	 */
	public abstract void  handleViewException(Exception e);
	
	
	/**
	 * Méthode d'obtention d'un message localisé à partir d'un ID
	 * 
	 * @param messageID  ID du message
	 * @param params	 Paramètres
	 * 
	 * @return Message localisé
	 */	
	protected  String getMessage(String messageID, Object...params){
		
		return Messages.getString(messageID, params);
	}
	
	
	/**
	 * Méthode d'obtention d'un message JSF localisé à partir d'un ID
	 * 
	 * @param severity ID 	  	Sévérité du message
	 * @param summaryMessageID 	ID de l'entête du message
	 * @param params	 	  	Paramètres
	 * 
	 * @return Message JSF localisée
	 */	
	protected  FacesMessage getFacesMessage(Severity severity, String summaryMessageID, Object...params){
		
		return Messages.getFacesMessage(severity, summaryMessageID, params);
	}
	
	
	/**
	 * Méthode de gestion la politique d'affichage des messages <br/>
	 * L'implémentation par défaut affiche les messages avec comme id la valeur <code>null</code> <br/>
	 * La politique d'affichage des messages pourra être redéfinie au besoin 
	 * 
	 * @param facesMessage Message à afficher
	 */
	protected  void displayMessage(FacesMessage facesMessage){
		
		JSFUtils.addMessage(null, facesMessage);
	}
}
