/**
 * 
 */
package net.leadware.leadfaces.core.view;

/**
 * Enumération des différents types de vues
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public enum ViewType {
	
	/**
	 * Vue de création
	 */
	CREATION("Creation"),

	/**
	 * Vue de consultation ou de détails
	 */
	DETAILS("Details"),
	
	/**
	 * Modal panel
	 */
	DIALOG("Dialog"),
	
	/**
	 * Vue d'édition (création / modification)
	 */
	EDITION("Edition"),
	
	/**
	 * Vue de liste
	 */
	LIST("List"),
	
	/**
	 * Vue de modification
	 */
	MODIFICATION("Modification"),

	/**
	 * Vue de sélection
	 */
	SELECTION("selection"),

	/**
	 * 
	 */
	VIEW("View");
	
	/**
	 * Type de la vue
	 */
	private final String type; 
	

	/**
	 * Constructeur paramétré
	 * @param type Identifiant de la vue
	 */
	private ViewType(String type){
		this.type = type;
	}
	
	/**
	 * Retourne la valeur de la propriété type
	 * @return La propriété type
	 */
	public String getType() {
		return type;
	}	
	
	/**
	 * Méthode de construction du nom d'une vue <br/>
	 * Concatène l'identifiant de la vue et son type
	 * @param viewIdentifier   Identifiant de la vue (role, utilisateur, ...)
	 * @param viewType Type de la vue
	 * @return Nom de la vue
	 */
	public static String buildViewName(String viewIdentifier, ViewType viewType){
		
		if(viewType != null && viewIdentifier != null && ! viewIdentifier.isEmpty())
			
			return new StringBuilder(viewIdentifier).append(viewType.getType()).toString();
		
		return null;
	}
	
}
