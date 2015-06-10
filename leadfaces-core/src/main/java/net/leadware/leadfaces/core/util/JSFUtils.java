/**
 * 
 */
package net.leadware.leadfaces.core.util;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Ensemble de méthodes utilitaires pour JSF
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public class JSFUtils {
	
	/**
	 * Paramètre de redirection
	 */
	private static final String REDIRECTION_PARAMETER = "?faces-redirect=true";

	
	/**
	 * Retourne le contexte courant JSF d'une requête
	 * 
	 * @return Instance courante du contexte
	 */
	public static FacesContext getFacesContext(){
		
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Indique si le contexte JSF existe
	 * 
	 * @return VRAI si le contexte JSF existe , FAUX sinon
	 */
	public static boolean isFacesContextExist(){
		
		return (getFacesContext() != null);
	}
	
	
	/**
	 * Retourne le contexte application
	 * 
	 * @return Le contexte application
	 */
	public static Application getFacesApplication(){
		
		return getFacesContext().getApplication();
	}
	
	
	/**
	 * Retourne la (première) valeur d'un paramètre dans une requete 
	 * 
	 * @param param	Nom du paramètre 
	 * @return		La valeur du  paramètre concerné ou <code>null</code> s'il n'existe pas
	 */
	 public static String getRequestParameterValue(String param) {
		 return (String) getFacesContext().getExternalContext().getRequestParameterMap().get(param);
	 }
	
	
	/**
	 * Recherche et retourne une instance d'un bean managé à partir de son nom<br>
	 * Si ce dernier n'existe pas, il sera créé
	 * 
	 * @param beanName	Nom du bean managé
	 * @param beanClass	Classe du bean managé
	 * @return			Instance du bean managé typé
	 */
	public static <T> T getManagedBean(String beanName, Class<T> beanClass){
			
		return getFacesApplication().evaluateExpressionGet(getFacesContext(), "#{" + beanName + "}", beanClass);
	}
	
	
	/**
	 * Recherche et retourne une instance d'un bean managé à partir de son nom<br>
	 * Si ce dernier n'existe pas, il sera créé
	 * 
	 * @param beanName	Nom du bean managé
	 * @return			Instance du bean managé non typé
	 */	
	public static Object getManagedBean(String beanName){
		
		return getManagedBean(beanName, Object.class);		
	}	
	
	/**
	 * Intègre le paramètre de redirection à une règle de navigation
	 * 
	 * @param outcome Règle de navigation
	 * @return La règle de navigation avec le paramètre de redirection intégrée
	 */
	public static String addRedirectionParameter(String outcome){
		
		// Si l'outcome est indéfini l'on retourn null
		if(outcome == null || outcome.trim().isEmpty()) return null;
		
		return outcome + REDIRECTION_PARAMETER;
	}
	

	 /***
	  * Ajout d'un message applicatif 
	  * 
	  * @param id			Id du composant graphique affichant le message 
	  * @param facesMessage	Message à afficher du message 
	  */
	public static void addMessage(String id, FacesMessage facesMessage){
         
		// Ajout du message
		getFacesContext().addMessage(id, facesMessage);
	}	

	
	 /***
	  * Ajout d'un message applicatif 
	  * 
	  * @param id		Id du composant graphique affichant le message 
	  * @param summary	Entête du message 
	  * @param detail	Détails du message 
	  * @param severity	Sévérité du message
	  */
	public static void addMessage(String id, String summary, String detail, Severity severity){
      
	  // Création d'un nouveau message
      FacesMessage facesMessage = new FacesMessage(severity, summary, detail);
      
      // Ajout du message
      getFacesContext().addMessage(id, facesMessage);
	}	
	
	
	/**
	 * Ajout d'un message de sévérité INFO
	 * 
	 * @param id		Id du composant graphique affichant le message  
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addInfoMessage(String id, String summary, String detail){
        
        addMessage(id, summary, detail, FacesMessage.SEVERITY_INFO);
	}	
	
	
	/**
	 * Ajout d'un message de sévérité INFO
	 * 
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addInfoMessage(String summary,String detail){
        
		addInfoMessage(null, summary, detail);
	}	
	
	
	/**
	 * Ajout d'un message de sévérité WARNING
	 * 
	 * @param id		Id du composant graphique affichant le message  
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addWarningMessage(String id, String summary,String detail){
        
        addMessage(id, summary, detail, FacesMessage.SEVERITY_WARN);
	}	
	
	
	/**
	 * Ajout d'un message de sévérité WARNING
	 * 
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addWarningMessage(String summary,String detail){
        
		addWarningMessage(null, summary, detail);
	}	
	
	
	/***
	 * Ajout d'un message de sévérité ERROR
	 * 
	 * @param id		Id du composant graphique affichant le message 
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addErrorMessage(String id, String summary,String detail){
        
        addMessage(id, summary, detail, FacesMessage.SEVERITY_ERROR);
	}
	
	
	/***
	 * Ajout d'un message de sévérité ERROR
	 * 
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addErrorMessage(String summary,String detail){
        
		addErrorMessage(null, summary, detail);
	}	

}
