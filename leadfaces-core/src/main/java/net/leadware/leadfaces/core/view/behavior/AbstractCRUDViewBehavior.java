package net.leadware.leadfaces.core.view.behavior;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;

import net.leadware.leadfaces.core.exception.BusinessValidationException;
import net.leadware.leadfaces.core.exception.LeadfacesException;
import net.leadware.leadfaces.core.util.DataManager;
import net.leadware.leadfaces.core.util.JSFUtils;
import net.leadware.leadfaces.core.view.CrudViewContext;
import net.leadware.leadfaces.core.view.EditionMode;
import net.leadware.leadfaces.core.view.ViewType;


/**
 * Classe abstraite implémentant une logique fonctionnelle de base pour les vues de type CRUD
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 * 
 * @param <T> Donnée ou Entité à manager
 */
public abstract class AbstractCRUDViewBehavior <T> extends AbstractBaseViewBehavior {

	/**
	 * ID de sérialisation
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Objet à éditer sur la vue d'édition (Création, Modificaton)
	 */
	protected T editionObject;

	/**
	 * Objet courant 
	 */
	protected T currentObject;

	/**
	 * Critères de recherche de la vue de recherche
	 */
	protected T criteriaObject;
	
	/**
	 * Mode d'édition (Création, Modification)
	 */
	protected EditionMode editionMode;
	
	/**
	 * Contexte d'une vue mutualisée pour les opérations de CRUD
	 */
	protected CrudViewContext crudViewContext;

	/**
	 * Gestionnaire de données
	 */
	protected DataManager<T> dataManager = new DataManager<T>();

	
	/**
	 * Méthode de post-construction
	 */
	@PostConstruct
	public void postConstruct(){
				
		// Initialisation des critères de recherche
		this.initializeCriteria();
	}
	

	/**
	 * Retourne la valeur de la propriété editionMode
	 * @return La propriété editionMode
	 */
	public EditionMode getEditionMode() {
		return editionMode;
	}

	/**
	 * Met à jour la propriété editionMode
	 * @param editionMode Nouvelle valeur de la propriété editionMode
	 */
	public void setEditionMode(EditionMode editionMode) {
		this.editionMode = editionMode;
	}	
	
	/**
	 * Retourne la valeur de la propriété crudViewContext
	 * @return La propriété crudViewContext
	 */
	public CrudViewContext getCrudViewContext() {
		return crudViewContext;
	}

	/**
	 * Met à jour la propriété crudViewContext
	 * @param crudViewContext Nouvelle valeur de la propriété crudViewContext
	 */
	public void setCrudViewContext(CrudViewContext crudViewContext) {
		this.crudViewContext = crudViewContext;
	}


	/**
	 * Retourne la valeur de la propriété editionObject
	 * @return La propriété editionObject
	 */
	public T getEditionObject() {
		return editionObject;
	}

	/**
	 * Met à jour la propriété editionObject
	 * @param editionObject Nouvelle valeur de la propriété editionObject
	 */
	public void setEditionObject(T editionObject) {
		this.editionObject = editionObject;
	}	

	/**
	 * Retourne la valeur de la propriété currentObject
	 * @return La propriété currentObject
	 */
	public T getCurrentObject() {
		return currentObject;	
	}

	/**
	 * Met à jour la propriété currentObject
	 * @param currentObject Nouvelle valeur de la propriété currentObject
	 */
	public void setCurrentObject(T currentObject) {
		this.currentObject = currentObject;
	}
	
	
	/**
	 * Méthode d'obtention de la donnée sélectionnée sur la vue de liste des données
	 * @return La donnée sélectionnée
	 */
	public T getSelectedObject() {
		return this.getDataManager().getSelectedData();	
	}

	/**
	 * Méthode de mise à jour de la donnée sélectionnée sur la vue de liste des données
	 * @param selectedObject Nouvelle donnée sélectionnée
	 */
	public void setSelectedObject(T selectedObject) {
		
		this.getDataManager().setSelectedData(selectedObject);
		
		// TODO Implémentation à optimiser par la détermination de l'objet courant en fonction de la vue
		this.setCurrentObject(selectedObject);
	}	
	
	/**
	 * Retourne la valeur de la propriété criteriaObject
	 * @return La propriété criteriaObject
	 */
	public T getCriteriaObject() {
		return criteriaObject;
	}

	/**
	 * Met à jour la propriété criteriaObject
	 * @param criteriaObject Nouvelle valeur de la propriété criteriaObject
	 */
	public void setCriteriaObject(T criteriaObject) {
		this.criteriaObject = criteriaObject;
	}	
		
	/**
	 * Méthode d'obtention de l'objet à créer <br/>
	 * Retourne (par défaut) la valeur de la propriété <code> editionObject </code>
	 * @return Objet à créer
	 */
	public T getCreationObject() {
		
		// Retourne l'objet à éditer par défaut
		return getEditionObject();
	}

	/**
	 * Méthode de mise à jour de l'objet à créer
	 * Mets à jour (par défaut) la valeur de la propriété <code> editionObject </code>
	 * @param creationObject Instance de l'objet à créer
	 */
	public void setCreationObject(T creationObject) {
		
		// Mise à jour de l'objet à editer par défaut
		this.setEditionObject(creationObject);
	}		

	/**
	 * Méthode d'obtention de l'objet à modifier <br/>
	 * Retourne (par défaut) la valeur de la propriété <code> editionObject </code>
	 * @return Objet à modifier
	 */
	public T getModificationObject() {
		
		// Retourne l'objet à éditer par défaut
		return getEditionObject();
	}

	/**
	 * Méthode de mise à jour de l'objet à modifier
	 * Mets à jour (par défaut) la valeur de la propriété <code> editionObject </code>
	 * @param modificationObject Instance de l'objet à modifier
	 */
	public void setModificationObject(T modificationObject) {
		
		// Mise à jour de l'objet à editer par défaut
		this.setEditionObject(modificationObject);
	}
	
	
	/**
	 * Retourne la valeur de la propriété dataManager
	 * @return La propriété dataManager
	 */
	public DataManager<T> getDataManager() {
		return dataManager;
	}

	/**
	 * Met à jour la propriété dataManager
	 * @param datas Nouvelle valeur de la propriété dataManager
	 */
	public void setDatas(DataManager<T> dataManager) {
		this.dataManager = dataManager;
	}	
	
	/**
	 * Service de demande création (ajout) d'un nouvel objet
	 * @param object Objet à créer
	 * @return La navigation vers la vue de création
	 */
	protected String create(T object){
		
		// Si le template de création est null, l'on initialise 
		if(object == null) object = this.getCreationTemplateInstance();

		// Définition du mode d'édition dans le cas d'un couplage CREATION/MODIFICATION
		this.setEditionMode(EditionMode.CREATION);
		
		// Définition du contexte
		this.setCrudViewContext(CrudViewContext.CREATION);

		// Mise à jour de l'objet à créer
		this.setCreationObject(object);
						
		// Navigation vers la vue de création
		return this.getCreationViewOutcome(this.getRedirectionStatus());
	}	

	/**
	 * Action de demande de création(ajout) d'un nouvel objet
	 * @return La navigation vers la vue de création
	 */
	public String create(){
		
		// Règle de navigation
		String outcome = null;
				
		try{			
			// Demande de création à partir d'une nouvelle instance d'objet
			outcome =  this.create(this.getCreationTemplateInstance());					
		}
		catch(Exception e){
			//  Gestion de l'exception			
			this.handleViewException(e);
		}
		
		// Retour de l'outcome
		return outcome;
	}
	
	/**
	 * Action de demande de création(ajout) d'un nouvel objet
	 * @param event Evènement
	 */
	public void create(ActionEvent event){

		// Demande de création
		this.create();	
	}	
		
	/**
	 * Service de demande de création (ajout) d'un nouvel objet par copie
	 * @param object Objet devant être copié pour création
	 * @return La navigation vers la vue de création
	 */
	protected String copy(T object){
		
		// Si aucun objet n'est défini
		if(object == null) 						
			// L'on propage une exception
			throw new LeadfacesException(this.getFacesMessage(FacesMessage.SEVERITY_ERROR,"net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.COPY_NO_DATA", (Object [])null));					
							
		// Demande de création sur la base d'une copie
		return this.create(this.getCreationTemplateInstance(object));
	}
	
	
	/**
	 * Action de demande de création(ajout) d'un nouvel objet par copie
	 * @return La navigation vers la vue de création
	 */
	public String copy(){
		
		// Règle de navigation
		String outcome = null;
				
		try{			
			// Demande de création par copie sur la base de l'objet courant
			outcome = this.copy(this.getCurrentObject());			
		}
		catch(Exception e){
			//  Gestion de l'exception			
			this.handleViewException(e);
		}
		
		// Retour de l'outcome
		return outcome;
	}
	
	/**
	 * Action de demande de création(ajout) d'un nouvel objet par copie
	 * @param event Evènement
	 */
	public void copy(ActionEvent event){

		// Demande de création par copie
		this.copy();				
	}	

	
	/**
	 * Service de demande de consultation des informations
	 * @param object Objet à consulter
	 * @return Navigation vers la vue de consultation
	 */
	protected String display(T object){
		
		// Si l'objet est indéfini
		if(object == null)			
			// L'on propage une exception
			throw new LeadfacesException(this.getFacesMessage(FacesMessage.SEVERITY_ERROR, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.DISPLAY_NO_DATA", (Object[]) null));		

		// Définition du contexte
		this.setCrudViewContext(CrudViewContext.CONSULTATION);

		// Mise à jour de l'objet courant
		this.setCurrentObject(this.reload(object));
				
		// Navigation vers la vue de consultation
		return this.getDetailsViewOutcome(this.getRedirectionStatus());
	}
	
	
	/**
	 * Action de demande de consultation des détails
	 * @return La navigation vers la vue de consultation
	 */
	public String display(){

		// Règle de navigation
		String outcome = null;

		try{			
			// Demande de consultation de l'objet courant
			outcome = this.display(this.getCurrentObject());					
		}
		catch(Exception e){
			// Gestion de l'exception			
			this.handleViewException(e);
		}
		
		// Retour de l'outcome
		return outcome;
	}
		
	/**
	 * Action de demande de consultation des détails
	 * @param event Evènement
	 */
	public void display(ActionEvent event){

		// Demande de consultation
		this.display();			
	}	
	
	/**
	 * Service de demande de modification
	 * @param object Objet à modifier
	 * @return Navigation vers la vue de modification
	 */
	protected String modify(T object){
		
		// Si l'objet est indéfini
		if(object == null)			
			// L'on propage une exception
			throw new LeadfacesException(this.getFacesMessage(FacesMessage.SEVERITY_ERROR, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.MODIFY_NO_DATA", (Object[]) null));		

		// Définition du mode d'édition dans le cas d'un couplage CREATION/MODIFICATION
		this.setEditionMode(EditionMode.MODIFICATION);

		// Définition du contexte
		this.setCrudViewContext(CrudViewContext.MODIFICATION);

		// Mise à jour de l'objet à créer
		this.setModificationObject(object);
						
		// Navigation vers la vue de modification
		return this.getModificationViewOutcome(this.getRedirectionStatus());
	}
	
		
	/**
	 * Action de demande de modification
	 * @return La navigation vers la vue de modification
	 */
	public String modify(){

		// Règle de navigation
		String outcome = null;

		try{			
			// Demande de modification de l'objet courant
			outcome =  this.modify(this.getCurrentObject());					
		}
		catch(Exception e){
			// Gestion de l'exception			
			this.handleViewException(e);
		}
		
		// Retour de l'outcome
		return outcome;
	}
	
	
	/**
	 * Action de demande de modification
	 * @param event Evènement
	 */
	public void modify(ActionEvent event){
				
		// Demande de modification
		this.modify();			
	}	
	
	
	/**
	 * Service de persistence d'un nouvel objet
	 * @param object Objet à persister
	 * @return La navigation vers la vue de consultation
	 */
	protected String save(T object){
		
		// Validation des données
		this.checkEditedObject(object);
				
		// Persistence éffective
		T savedObject = this.businessSave(object);
		
		// Demande de consultation de l'objet
		String outcome = this.display(savedObject);

		// Retour de l'outcome
		return outcome;
	}	

	/**
	 * Action de persistence d'un nouvel objet
	 * @return La navigation vers la vue de consultation
	 */
	public String save(){

		// Règle de navigation
		String outcome = null;

		try{			
			// Persistence effective
			outcome = this.save(this.getCreationObject());	
			
			// Message
			this.displayMessage(this.getFacesMessage(FacesMessage.SEVERITY_INFO, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.SAVE_SUCCES", (Object[]) null));									
		}
		catch(Exception e){			
			// Gestion de l'exception
			this.handleViewException(e);
		}	
		
		// Retour de l'outcome
		return outcome;
	}
	
	/**
	 * Action de persistence d'un nouvel objet
	 * @param event Evènement
	 */
	public  void save(ActionEvent event){

		// Persistence effective
		this.save();					
	}	
	
	/**
	 * Service de persistence d'un objet modifié
	 * 
	 * @param object Objet modifié à persister
	 * 
	 * @return La navigation vers la vue de consultation
	 */
	protected String update(T object){
		
		// Validation des données
		this.checkEditedObject(object);
				
		// Mise à jour éffective
		T updatedObject = this.businessUpdate(object);
		
		// Met à jour l'objet dans la liste des données
		this.updateInDatatable(object, updatedObject);
			
		// Demande de consultation de l'objet
		String outcome = this.display(updatedObject);
				
		// Retour de l'outcome
		return outcome;		
	}	

	/**
	 * Action de persistence d'un objet modifié
	 * @return La navigation vers la vue de consultation
	 */
	public String update(){

		// Règle de navigation
		String outcome = null;

		try{			
			// Mise à jour effective
			outcome = this.update(this.getModificationObject());	
			
			// Message
			this.displayMessage(this.getFacesMessage(FacesMessage.SEVERITY_INFO, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.UPDATE_SUCCES", (Object[]) null));									
		}
		catch(Exception e){			
			// Gestion de l'exception
			this.handleViewException(e);
		}	
		
		// Retour de l'outcome
		return outcome;
	}
	
	
	/**
	 * Action de persistence d'un objet modifié
	 * @param event Evènement
	 */
	public  void update(ActionEvent event){

		// Mise à jour effective
		update();						
	}	

	/**
	 * Service de persistence d'un objet
	 * @param object Objet à supprimer
	 * @return La navigation vers la vue de liste
	 */
	protected String delete(T object){
		
		// Si l'objet est indéfini
		if(object == null)			
			// L'on propage une exception
			throw new LeadfacesException(this.getFacesMessage(FacesMessage.SEVERITY_ERROR, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.DELETE_NO_DATA", (Object[])null));		
		
		// Suppression effective
		this.businessDelete(object);	
		
		// Suppression logique dans la liste des données
		this.removeInDatatable(object);
				
		// Navigation vers la vue de liste
		return this.getListViewOutcome(this.getRedirectionStatus());
	}
	
	/**
	 * Action de suppression d'un objet
	 * @return La navigation vers la vue de liste
	 */
	public String delete(){

		// Règle de navigation
		String outcome = null;

		try{			
			// Mise à jour effective
			outcome = this.delete(this.getCurrentObject());	
			
			// Message
			this.displayMessage(this.getFacesMessage(FacesMessage.SEVERITY_INFO, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.DELETE_SUCCES", (Object[]) null));									
		}
		catch(Exception e){			
			// Gestion de l'exception
			this.handleViewException(e);
		}	
		
		// Retour de l'outcome
		return outcome;
	}
	
	
	/**
	 * Action de suppression d'un objet
	 * @param event Evènement
	 */
	public  void delete(ActionEvent event){

		// Suppression effective
		delete();						
	}
	
	
	/**
	 * Service de sélection d'un objet
	 * @param object Objet à supprimer
	 * @return La navigation vers la vue (source) à l'origine de la sélection
	 */
	protected abstract String select(T object);
	
	
	/**
	 * Action de sélection d'un objet
	 * @return La navigation vers la vue (source) à l'origine de la sélection
	 */
	public String select(){

		// Règle de navigation
		String outcome = null;

		try{			
			// Mise à jour effective
			outcome = this.select(this.getCurrentObject());				
		}
		catch(Exception e){			
			// Gestion de l'exception
			this.handleViewException(e);
		}	
		
		// Retour de l'outcome
		return outcome;
	}
	
	
	/**
	 * Action de sélection d'un objet
	 * @param event Evènement
	 */
	public  void select(ActionEvent event){

		// Sélection effective
		select();						
	}	
	
	
	/**
	 * Service de prévisualisation d'un objet
	 * @param object Objet à prévisualiser
	 */
	protected abstract void preview(T object);
	
	
	/**
	 * Action de prévisualisation d'un objet
	 * @param event Evènement
	 */
	public void preview(ActionEvent event){

		try{			
			// Prévisualisation de l'objet courant
			this.preview(this.getCurrentObject());				
		}
		catch(Exception e){			
			// Gestion de l'exception
			this.handleViewException(e);
		}	
	}		
	
	
	/**
	 * Action de (ré)initialisation des critères de recherche <br/>
	 * L'implémentation par défaut initialise l'objet  <code>criteriaObject</code>
	 */
	public void initializeCriteria(){
		
		// Initialisation des critérias
		this.criteriaObject = this.getParameterizedClassInstance();
	}
	
	/**
	 * Méthode d'obtention du type de la donnée (en paramètre) à manager
	 * @return Type de la donnée (en paramètre) à manager
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getParameterizedClass(){
		
		// Retour du type de la donnée en paramètre
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];						
	}
	
	/**
	 * Retourne une nouvelle instance de la donnée (en paramètre) à manager
	 * @return Nouvelle instance de la donnée (en paramètre) à manager
	 */
	protected T getParameterizedClassInstance(){
		
		// Instance
		T _instance = null;
		
		try{
			// Nouvelle instance
			_instance =  this.getParameterizedClass().newInstance();
		}
		catch(Exception e){
			
			// Relance de l'exception 
			throw new LeadfacesException(this.getFacesMessage(FacesMessage.SEVERITY_ERROR, "net.leadware.leadfaces.core.view.behavior.AbstractCRUDViewBehavior.getParameterizedClassInstance_instance_fail", this.getParameterizedClass().getSimpleName()), e);					
		}
	
		return _instance;
	}
	
	/**
	 * Méthode d'obtention d'une nouvelle instance initialisée de l'objet à créer
	 * @return Nouvelle instance initialisée de l'objet à créer
	 */
	protected T getCreationTemplateInstance(){
		return this.getParameterizedClassInstance();
	}	

	/**
	 * Retourne à partir d'un modèle, une nouvelle instance d'objet pour la vue de création
	 * @param model Modèle à copier
	 * @return Nouvelle instance initialisée à partir du modèle 
	 */
	protected abstract T getCreationTemplateInstance(T model);
	
	/**
	 * Méthode d'obtention d'une instance du modèle de données de la grille de données
	 * @return Nouvelle isntance du modèle de données 
	 */
	protected abstract DataModel<T> getDataModelInstance();

	/**
	 * Vérifie les données issues de l'édition (création ou modification)
	 * @param object Objet édité
	 * @throws BusinessValidationException Exception de validation levée
	 */
	protected abstract void checkEditedObject(T object) throws BusinessValidationException;
	
	
	/**
	 * Retourne la règle de navigation vers la vue d'edition (création / modification)
	 * 
	 * @param redirect Indique s'il faut inclure ou pas la redirection
	 * @return Règle de navigation vers la vue d'édition
	 */
	public String getEditionViewOutcome(boolean redirect){
		
		// Outcome
		String outcome = this.buildViewName(ViewType.EDITION);
		
		// Intégration de la redirection si elle est activée
		return redirect ? JSFUtils.addRedirectionParameter(outcome) : outcome;
	}	

	/**
	 * Retourne la règle de navigation vers la vue de création </br>
	 * Par défaut la règle de navigation de la vue de création est équivalente à celle de la vue d'edition
	 * 
	 * @param redirect Indique s'il faut inclure ou pas la redirection
	 * @return Règle de navigation vers la vue de création
	 */	
	public String getCreationViewOutcome(boolean redirect){
		return getEditionViewOutcome(redirect);
	}	
	
	/**
	 * Retourne la règle de navigation vers la vue de modification </br>
	 * Par défaut la règle de navigation de la vue de modification est équivalente à celle de la vue d'edition
	 * 
	 * @param redirect Indique s'il faut inclure ou pas la redirection
	 * @return Règle de navigation vers la vue de modification
	 */
	public String getModificationViewOutcome(boolean redirect){
		return getEditionViewOutcome(redirect);
	}	
	
	/**
	 * Retourne la règle de navigation vers la vue de consultation
	 * 
	 * @param redirect Indique s'il faut inclure ou pas la redirection
	 * @return Règle de navigation vers la vue de consultation
	 */
	public String getDetailsViewOutcome(boolean redirect){
		
		// Outcome
		String outcome = this.buildViewName(ViewType.DETAILS);
		
		// Intégration de la redirection si elle est activée
		return redirect ? JSFUtils.addRedirectionParameter(outcome) : outcome;		
	}		

	/**
	 * Retourne la règle de navigation vers la vue de liste
	 * 
	 * @param redirect Indique s'il faut inclure ou pas la redirection
	 * @return Règle de navigation vers la vue de liste
	 */
	public String getListViewOutcome(boolean redirect){
		
		// Outcome
		String outcome = this.buildViewName(ViewType.LIST);
		
		// Intégration de la redirection si elle est activée
		return redirect ? JSFUtils.addRedirectionParameter(outcome) : outcome;		
	}	
	
	
	/**
	 * Retourne le nom du widget de la boîte de dialogue
	 * @return Nom du widget de la boîte de dialogue
	 */
	public String getDialogViewOutcome(){
		return this.buildViewName(ViewType.DIALOG);
	}	

	
	/**
	 * Méthode d'obtention de la configuration d'activation de la redirection <br/>
	 * L'implémentation par défaut retourne <code>false</code> : Redirection non activée
	 * 
	 * @return True si la redirection est active et false sinon
	 */
	protected boolean getRedirectionStatus(){
		
		return false;
	}
	
	/**
	 * Méthode de rafraîchissement/recharge/mise à jour d'un objet <br/>
	 * Par défaut c'est l'objet passé en paramètre qui est retourné
	 * @param object Objet à rafraîchir
	 * @return Nouvelle instance rafraîchie
	 */
	protected T reload(T object){
		return object;
	}

	/**
	 * Méthode de remplacement d'un objet dans le tableau de données
	 * Uniquement les collections de type <code>List</code> sont supportées par cette implémentation
	 * @param old  Objet à remplacer
	 * @param new_ Objet de remplacement
	 */
	protected void updateInDatatable(T old, T new_){
				
		// Si l'objet à remplacer existe dans la collection
		if(this.getDataManager().getDataCollection() != null && this.getDataManager().getDataCollection().contains(old)){
			
			// Si la collection est une liste
			if(this.getDataManager().getDataCollection() instanceof List){
				
				// Cast
				List<T> list = (List<T>) this.getDataManager().getDataCollection();
				
				// Index de l'objet à remplacer
				int index = list.indexOf(old);

				// Insertion du nouvel objet à cet index
				list.add(index, new_);			

				// Retrait de l'objet à remplacer
				list.remove(index + 1);				
			}			
		}			
	}

	/**
	 * Méthode de suppression d'un objet du tableau de données
	 * @param object Objet à supprimer
	 */
	protected void removeInDatatable(T object){
								
		// Si l'objet à supprimer est dans la collection
		if(this.getDataManager().getDataCollection() != null && this.getDataManager().getDataCollection().contains(object)){
			
			// Suppression effective
			this.getDataManager().getDataCollection().remove(object);
		}			
	}

	/* (non-Javadoc)
	 * @see net.leadware.leadfaces.core.view.behavior.AbstractBaseViewBehavior#openDefaultView()
	 */
	@Override
	public String openDefaultView() {
		
		// Par défaut, l'on ouvre la vue de liste
		return openListView();
	}
	
	/**
	 * Méthode d'ouverture de la vue de liste de données
	 * 
	 * @return La navigation vers la vue de liste
	 */
	public String openListView(){
				
		// Navigation vers la vue de liste
		return this.getListViewOutcome(this.getRedirectionStatus());
	}
		
	/**
	 * Action de fermeture de la vue de liste des données
	 * @return
	 */
	public  abstract String closeListView();	
	
	/**
	 * Action de recherche des données
	 */
	public abstract  void search();

	/**
	 * Service métier de persistence d'un nouvel objet
	 * @param object Objet à créer
	 * @return Objet créé
	 */
	protected abstract T businessSave (T object);

	/**
	 * Service métier de mise à jour objet modifié
	 * @param object Objet à modifier
	 * @return Objet modifié
	 */
	protected abstract T businessUpdate(T object);

	/**
	 * Service métier de suppression d'un objet
	 * @param object Objet à supprimer
	 */
	protected abstract void businessDelete(T object);
	
	/**
	 * Service métier de recherche des données à base d'une position de début et d'un nombre maximal
	 * @param offset Index de début de la pagination 
	 * @param size Nombre maximal de lignes(tuples) à rechercher		
	 * @return Liste des données trouvées
	 */
	protected abstract Collection<T> businessSearchByCriteria(int offset, int size);

	/**
	 * Service métier de décompte  du nombre de données sur la base des critères
	 * @return Nombre total de données
	 */
	protected abstract  long businessCountByCriteria();
	
	
}
