package net.leadware.leadfaces.core.exception;

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

import javax.faces.application.FacesMessage;


/**
 * Classe d'exception associée aux validations métier
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public class BusinessValidationException extends LeadfacesException {
	
	
	/**
	 * ID Généré par Eclipse
	 */
	private static final long serialVersionUID = 1L;
		
	
	/**
	 * Constructeur par défaut
	 */
	public BusinessValidationException() {
		
		// Appel du super constructeur
		super();
	}
	
	
	/**
	 * Constructeur avec Message
	 * 
	 * @param message	Message de l'exception
	 */
	public BusinessValidationException(String message){
		
		// Appel du constructeur de RuntimeException
		super(message);
	}
	
	/**
	 * Constructeur avec Message et la cause de l'exception
	 * 
	 * @param message	Message de l'exception
	 * @param cause	Cause de l'exception
	 */
	public BusinessValidationException(String message, Throwable cause) {
		
		// Appel du constructeur de Runtime
		super(message, cause);
	}
	
	/**
	 * Constructeur avec la cause de l'exception
	 * @param cause	Cause de l'exception
	 */
	public BusinessValidationException(Throwable cause) {
		
		// Appel du constructeur de Runtime
		super(cause);
	}
	
	/**
	 * Constructeur avec Message JSF
	 * @param facesMessage Message JSF 
	 */
	public BusinessValidationException(FacesMessage facesMessage){
		
		// Appel du constructeur parent
		super(facesMessage);
		
	}

	/**
	 * Constructeur avec Message JSF et la cause de l'exception
	 * 
	 * @param message	Message JSF
	 * @param cause	Cause de l'exception
	 */
	public BusinessValidationException(FacesMessage facesMessage, Throwable cause){
		
		// Appel du constructeur parent
		super(facesMessage, cause);		
	}
	
}
