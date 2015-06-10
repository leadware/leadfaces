package net.leadware.leadfaces.core.view;

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
