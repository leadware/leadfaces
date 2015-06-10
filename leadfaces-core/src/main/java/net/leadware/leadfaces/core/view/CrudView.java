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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Classe de gestion d'une vue mutualisée pour les opération de CRUD
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
@Named
@ApplicationScoped
public class CrudView {
	
	/**
	 * Méthode spécifiant s'il s'agit du contexte de CREATION
	 * 
	 * @param context Contexte de la vue 
	 * @return True or False
	 */
	public boolean isCreation(String context){
				
		if(context == null || context.trim().isEmpty()) return false;
				
		return CrudViewContext.CREATION.equals(CrudViewContext.valueOf(context));	
	}
	
	
	/**
	 * Méthode spécifiant s'il s'agit du contexte de MODIFICATION
	 * 
	 * @param context Contexte de la vue 
	 * @return True or False
	 */
	public boolean isModification(String context){

		if(context == null || context.trim().isEmpty()) return false;

		return CrudViewContext.MODIFICATION.equals(CrudViewContext.valueOf(context));	
	}	
	
	
	/**
	 * Méthode spécifiant s'il s'agit du contexte de CONSULTATION
	 * 
	 * @param context Contexte de la vue 
	 * @return True or False
	 */
	public boolean isConsultation(String context){

		if(context == null || context.trim().isEmpty()) return false;

		return CrudViewContext.CONSULTATION.equals(CrudViewContext.valueOf(context));	
	}
	
	
	/**
	 * Méthode spécifiant s'il s'agit du contexte CREATION ou MODIFICATION
	 * 
	 * @param context Contexte de la vue 
	 * @return True or False
	 */
	public boolean isEdition(String context){
				
		return (this.isCreation(context) || this.isModification(context));
	}
	
}
