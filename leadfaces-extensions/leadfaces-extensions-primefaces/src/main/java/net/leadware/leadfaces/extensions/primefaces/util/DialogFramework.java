/**
 * 
 */
package net.leadware.leadfaces.extensions.primefaces.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.context.RequestContext;

/**
 * Classe de gestion des boites de dialogues dymaniques
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public class DialogFramework {
	
	/**
	 * Enumération des options de configuration
	 * 
	 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
	 * @since  1.0.0
	 */
	public enum Options {
		
		/**
		 * Option de configuration de la modalité
		 */
		MODAL("modal"),
		
		/**
		 * Option de configuration du déplacement/repositionnement
		 */
		DRAGGABLE("draggable"),

		/**
		 * Option de configuration du redimensionnement
		 */
		RESIZABLE("resizable"),

		/**
		 * Option de configuration de la hauteur du contenu
		 */
		CONTENT_HEIGHT("contentHeight"),

		/**
		 * Option de configuration de la largeur du contenu
		 */
		CONTENT_WIDTH("contentWidth"),

		/**
		 * Option de configuration de la hauteur de la boîte
		 */
		HEIGHT("height"),

		/**
		 * Option de configuration de la largeur de la boîte
		 */
		WIDTH("width"),

		/**
		 * Option de configuration de la fermeture de la boîte
		 */
		CLOSABLE("closable");

		/**
		 * Valeur de l'option
		 */
		private String value;
		
		/**
		 * Constructeur paramétré
		 * 
		 * @param value Valeur de l'option
		 */
		private Options (String value){
			this.value = value;
		}

		/**
		 * Retourne la valeur de la propriété value
		 * @return La propriété value
		 */
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * Options de paramétrage par défaut
	 */
	private static Map<String,Object> defaultOptions; 	
	
	/**
	 * Initialisation des paramètres d'affichage par défaut
	 */
	static {
		
		// Initialisation
		defaultOptions = new HashMap<String, Object>();

		// Spécification de la modalité
		defaultOptions.put(Options.MODAL.getValue(), true);
		
		// Spécification du déplacement/repositionnement
		defaultOptions.put(Options.DRAGGABLE.getValue(), true);
		
		// Spécification du redimensionnement
		defaultOptions.put(Options.RESIZABLE.getValue(), true);	
		
		// Spécification la hauteur du contenu
		defaultOptions.put(Options.CONTENT_HEIGHT.getValue(), "'100%'");
		
		// Spécification de la largeur du contenu
		defaultOptions.put(Options.CONTENT_WIDTH.getValue(), "'100%'");
		
		// Spécification de la largeur de la boîte
		defaultOptions.put(Options.WIDTH.getValue(), 1000);
		
		// Spécification de la hauteur de la boîte
		defaultOptions.put(Options.HEIGHT.getValue(), 500);		
	}
	
	
	/**
	 * Méthode d'obtention des paramètres d'affichage par défaut
	 * 
	 * @return Map des paramètres d'affichage par défaut
	 */
	public static Map<String,Object> getDefaultOptions(){
		
		// Retourne une nouvelle instance du Map pouvant être modifié
		return new HashMap<String, Object>(defaultOptions);
	}
	
	/**
	 * Méthode d'affichage d'une vue en modal
	 * @param outcome Règle de navigation utilisée pour résourdre l'accès à une vue
	 */
	public static void openDialog(String viewName){

		// Ouverture de la vue en boite de dialogue
		openDialog(viewName, getClientDialogOptions_());
	}

	/**
	 * Méthode d'affichage d'une vue en modal
	 * @param outcome Règle de navigation utilisée pour résourdre l'accès à une vue
	 * @param options Options de configuration de l'affichage
	 */
	public static void openDialog(String viewName, Map<String, Object> options){

		// Ouverture de la vue en boite de dialogue
		openDialog(viewName, options, null);
	}	

	/**
	 * Méthode d'affichage d'une vue en modal
	 * @param outcome Règle de navigation utilisée pour résourdre l'accès à une vue
	 * @param options Options de configuration de l'affichage
	 * @param params Paramètres à envoyer à la vue devant s'afficher
	 */
	public static void openDialog(String outcome, Map<String, Object> options, Map<String, List<String>> params){
		
		// Si les options de paramétrage sont indéfinies
		if(options == null || options.isEmpty())  options = getClientDialogOptions_();
			
		// Ouverture de la vue en boite de dialogue
		RequestContext.getCurrentInstance().openDialog(outcome, options, params);		
	}	

	/**
	 * Méthode d'affichage d'une vue en modal
	 * @param outcome Règle de navigation utilisée pour résourdre l'accès à une vue
	 */
	
	/**
	 * Méthode de fermture de la fenêtre ouverte en modal
	 * @param object Objet sélectionné
	 */
	public static void closeDialog(Object object){

		// Fermeture de la vue en boite de dialogue
		RequestContext.getCurrentInstance().closeDialog(object);		
	}
	 
	
	/**
	 * Méthode d'obtention des options de paramétrage des boites de dialogue dépendamment du poste client <br/>
	 * Si aucune option de paramétrage cliente n'est définie, elle retourne les options de paramétrage par défaut
	 * @return
	 */
	private static Map<String, Object> getClientDialogOptions_(){
		
		// TODO Intégrer la configuration du poste client
		return defaultOptions;
	}
	
	
	/**
	 * Méthode d'obtention des options de paramétrage des boites de dialogue dépendamment du poste client <br/>
	 * Si aucune option de paramétrage cliente n'est définie, elle retourne les options de paramétrage par défaut
	 * @return
	 */
	public static Map<String, Object> getClientDialogOptions(){
		
		// Retourne une nouvelle instance des options de paramétrage client pouvant être modifiées
		return new HashMap<String, Object>(getClientDialogOptions_()) ;
	}
	
}
