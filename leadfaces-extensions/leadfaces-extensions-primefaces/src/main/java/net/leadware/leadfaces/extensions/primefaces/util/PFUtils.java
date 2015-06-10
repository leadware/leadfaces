package net.leadware.leadfaces.extensions.primefaces.util;

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
