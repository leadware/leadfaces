package net.leadware.leadfaces.core.exception;

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
