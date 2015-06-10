/**
 * 
 */
package net.leadware.leadfaces.core.i18n;

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

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Classe de gestion des ressources internationalisées
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public class Messages {
	
	/**
	 * Nom du fichier par défaut de collection de ressources 
	 */
	private final static String DEFAULT_BUNDLE_NAME = "net.leadware.leadfaces.messages";

	/**
	 * Méthode d'obtention d'une ressource localisée associée à un identifiant <br/>
	 * 
	 * @param severity		Sévérité du message
	 * @param summaryID		Identifiant de l'entête du message
	 * @param params		Paramètres
	 * 
	 * @return	Messahe JSF localisé
	 */
	public static FacesMessage getFacesMessage(Severity severity, String summaryID) {
				
		// Obtention du message
		return getFacesMessage(severity, summaryID, (Object[])null);	
	}


	/**
	 * Méthode d'obtention d'un message JSF à partir d'une ressource localisée associée à un identifiant <br/>
	 * 
	 * @param severity		Sévérité du message
	 * @param summaryID		Identifiant de l'entête du message
	 * @param params		Paramètres
	 * 
	 * @return	Messahe JSF localisée
	 */
	public static FacesMessage getFacesMessage(Severity severity, String summaryID, Object...params) {
				
		// Obtention de l'entête du message
		String summary = getString(summaryID, params);
		
		// Construction de l'id du detail du message
		String detailMessageID = summaryID + "_detail";
		
		// Obtention du detail du message
		String detailMessage = getString(detailMessageID, params);
		
		// Si le détail du message n'existe pas, il sera considéré comme null
		if(getNotFoundedResourceTemplate(detailMessageID).equals(detailMessage)) detailMessage = null;
		
		// Contruction et retour du message
		return new FacesMessage(severity, summary, detailMessage);
	}

	
	
	/**
	 * Méthode d'obtention d'une ressource localisée associée à un identifiant <br/>
	 * 
	 * @param resourceID	Identifiant de la ressource
	 * 
	 * @return	Ressource localisée et formatée
	 */
	public static String getString(String resourceID) {
				
		// Obtention de la ressource
		return getString(resourceID, (Object[]) null);
	}



	/**
	 * Méthode d'obtention d'une ressource localisée associée à un identifiant <br/>
	 * 
	 * @param resourceID	Identifiant de la ressource
	 * @param params		Paramètres
	 * 
	 * @return	Ressource localisée et formatée
	 */
	public static String getString(String resourceID, Object...params) {
				
		// Obtention de la ressource
		return getString(resourceID, getLocale(), getClassLoader(), params);
	}

	
	/**
	 * Méthode d'obtention d'une ressource localisée associée à un identifiant <br/>
	 * Si la ressource n'est pas trouvée dans la collection de ressources en paramètre, elle sera recherchée le fichier par défaut
	 * 
	 * @param resourceID	Identifiant de la ressource
	 * @param loader		ClassLoader à utiliser
	 * @param params		Paramètres
	 * 
	 * @return	Ressource localisée et formatée
	 */
	public static String getString(String resourceID, Locale locale, ClassLoader loader, Object...params) {
		
		// Collection de ressources applicative
		String bundleName = null;
		
		// Obtention du context JSF
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		// Obtention du fichier de collection de ressources applicatif
		if(facesContext != null) bundleName = facesContext.getApplication().getMessageBundle();
		
		// Obtention de la ressource
		return getString(bundleName, DEFAULT_BUNDLE_NAME, resourceID, locale, loader, params);
	}


	/**
	 * Méthode d'obtention d'une ressource localisée associée à un identifiant <br/>
	 * Si la ressource n'est pas trouvée dans la collection de ressources en paramètre, elle sera recherchée le fichier par défaut
	 * 
	 * @param bundleName	Nom de la collection de ressources
	 * @param resourceID	Identifiant de la ressource
	 * @param loader		ClassLoader à utiliser
	 * @param params		Paramètres
	 * 
	 * @return	Ressource localisée et formatée
	 */
	public static String getString(String bundleName, String resourceID, Locale locale, ClassLoader loader, Object...params) {

		// Obtention de la ressource
		return getString(bundleName, DEFAULT_BUNDLE_NAME, resourceID, locale, loader, params);
	}
        		

	
	/**
	 * Méthode d'obtention d'une ressource localisée associée à un identifiant  <br/>
	 * La ressource sera premièrement recherchée dans la collection de ressources 1, si elle n'y est pas, dans la collection de ressources 2
	 * 
	 * @param bundleName1	Nom de la collection de ressources 1
	 * @param bundleName2	Nom de la collection de ressources 2
	 * @param resourceID	Identifiant de la ressource
	 * @param locale		Locale à utiliser
	 * @param loader		ClassLoader à utiliser
	 * @param params		Paramètres
	 * 
	 * @return	Ressource localisée et formatée
	 */
	public static String getString(String bundleName1, String bundleName2, String resourceID, Locale locale, ClassLoader loader, Object...params) {
		
		// Collection de ressources
		ResourceBundle resourceBundle = null;
		
		// Ressource associée
		String resource = null;
		
		// Initialisation de la locale au besoin
		locale = (locale != null) ? locale : getLocale();
		
		// Initialisation du loader au besoin
		loader = (loader != null) ? loader : getClassLoader();
			
		try{
			
			// Si le nom du bundle 1 est défini
			if(bundleName1 != null) {
				
				// Obtention de la collection de ressources 1
				resourceBundle = ResourceBundle.getBundle(bundleName1, locale, loader);
				
				// Si la collection de ressources 1 existe
				if(resourceBundle != null){
					
					// Obtention de la ressource
					resource = resourceBundle.getString(resourceID);
				}
			}
			
			// Si la ressource n'existe pas dans la première collection
			if(resource == null){
				
				// Obtention de la collection de ressources 2
				resourceBundle = ResourceBundle.getBundle(bundleName2, locale, loader);

				// Si la collection de ressources 2 existe
				if(resourceBundle != null){

					// Obtention de la ressource
					resource = resourceBundle.getString(resourceID);
				}				
			}	
						
			// S'il existe des paramètres
			if(resource != null && params != null && params.length > 0 ) {

				// Formatteur du message
				MessageFormat formatter = new MessageFormat(resource, locale);
				
				// Formattage du message
				resource = formatter.format(params);											
			}							
		}
		catch(Exception e){		
			// Trace
			e.printStackTrace();
		}
			
		// L'on retourne la ressource
		return (resource != null)? resource : getNotFoundedResourceTemplate(resourceID);
	}		
	
	/**
	 * Méthode d'obtention du ClassLoader
	 * 
	 * @return ClassLoader
	 */
   private static ClassLoader getClassLoader() {
	   
	   // Obtention du ClassLoader du thread courant
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      
      // S'il n'existe pas, obtention du ClassLoader système
      if (loader == null) loader = ClassLoader.getSystemClassLoader();
      
      // Retour du classloader
      return loader;
   }
   
   
   /**
    * Méthode d'obtention de la locale
    * @return Locale
    */
   private static Locale getLocale(){
	   
	   // Locale de l'application
	   Locale locale = null;
	   
	   // Obtention du context JSF
	   FacesContext facesContext = FacesContext.getCurrentInstance();
	   
	   // Si le contexte JSF existe
	   if(facesContext != null) {
		   
		   // Si le viewRoot existe
		   if(facesContext.getViewRoot() != null)		   
			   // Obtention de la locale
			   locale =  facesContext.getViewRoot().getLocale();
		   
		   // Si le viewRoot n'exite pas
		   else 			   
			   // Obtention de la locale par défaut
			   locale =  facesContext.getApplication().getDefaultLocale();		   
	   } 
		      	   
	   // Retour de la valeur de la locale
	   return (locale != null)? locale : Locale.getDefault();
   }

   
   /**
    * Retourne un template pour les ressources non trouvées via leur identifiant
    * 
    * @param resourceID Identifiant de la ressource
    * 
    * @return ???<code>resourceId</code>???
    */
   public static String getNotFoundedResourceTemplate(String resourceID){
	   
	   // Convention JSF pour les ressources introuvables
	   return "???" + resourceID + "???";
   }   
	
}
