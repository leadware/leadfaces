/**
 * 
 */
package net.leadware.leadfaces.core.view;

/*
 * #%L
 * Leadfaces
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2013 - 2015 Leadware
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
