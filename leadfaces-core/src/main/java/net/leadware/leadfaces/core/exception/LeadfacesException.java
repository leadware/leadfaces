package net.leadware.leadfaces.core.exception;

import javax.faces.application.FacesMessage;


/**
 *
 * Classe de base des exceptions du Framework Leadfaces
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 */
public class LeadfacesException extends RuntimeException {
		
	/**
	 * ID Généré par Eclipse
	 */
	private static final long serialVersionUID = 1L;
		
	/**
	 * Message JSF
	 */
	private FacesMessage facesMessage;
	
	
	/**
	 * Constructeur par défaut
	 */
	public LeadfacesException() {
		
		// Appel du super constructeur
		super();
	}
	
	
	/**
	 * Constructeur avec Message
	 * 
	 * @param message	Message de l'exception
	 */
	public LeadfacesException(String message){
		
		// Appel du constructeur de RuntimeException
		super(message);
	}
	
	/**
	 * Constructeur avec Message et la cause de l'exception
	 * 
	 * @param message	Message de l'exception
	 * @param cause	Cause de l'exception
	 */
	public LeadfacesException(String message, Throwable cause) {
		
		// Appel du constructeur de Runtime
		super(message, cause);
	}
	
	/**
	 * Constructeur avec la cause de l'exception
	 * @param cause	Cause de l'exception
	 */
	public LeadfacesException(Throwable cause) {
		
		// Appel du constructeur de Runtime
		super(cause);
	}
	
	/**
	 * Constructeur avec Message JSF
	 * @param facesMessage Message JSF 
	 */
	public LeadfacesException(FacesMessage facesMessage){
		
		// Appel du constructeur parent
		super(facesMessage.getDetail());
		
		// Définition du message JSF
		this.facesMessage = facesMessage;
	}

	/**
	 * Constructeur avec Message JSF et la cause de l'exception
	 * 
	 * @param message	Message JSF
	 * @param cause	Cause de l'exception
	 */
	public LeadfacesException(FacesMessage facesMessage, Throwable cause){
		
		// Appel du constructeur parent
		super(facesMessage.getDetail(), cause);
		
		// Définition du message JSF
		this.facesMessage = facesMessage;
	}

	/**
	 * Retourne la valeur de la propriété facesMessage
	 * @return La propriété facesMessage
	 */
	public FacesMessage getFacesMessage() {
		
		return facesMessage;
	}	
}
