package net.leadware.leadfaces.extensions.primefaces.util;

import org.primefaces.context.RequestContext;

/**
 * Ensemble de méthodes utilitaires pour Primefaces
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public class PFUtils {
	
	/**
	 * Méthode d'affichage d'une boîte de dialogue
	 * @param widgetVar Nom du widget de la boite de dialogue
	 */
	public static void showDialog(String widgetVar){		
		RequestContext.getCurrentInstance().execute("PF('" + widgetVar + "').show()");
	}
	
	/**
	 * Méthode de fermeture d'une boîte de dialogue
	 * @param widgetVar Nom du widget de la boite de dialogue
	 */
	public static void hideDialog(String widgetVar){		
		RequestContext.getCurrentInstance().execute("PF('" + widgetVar + "').hide()");
	}

	/**
	 * Méthode d'exécution d'un script
	 * @param script Script à executer
	 */
	public static void executeScript(String script){		
		RequestContext.getCurrentInstance().execute(script);
	}


}
