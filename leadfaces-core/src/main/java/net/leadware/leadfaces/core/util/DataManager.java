package net.leadware.leadfaces.core.util;

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

import java.util.Collection;

import javax.faces.component.UIData;
import javax.faces.model.DataModel;


/**
 * Classe de gestion des composants de présentation de collection de données
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 * 
 * @param <T> Type de données
 */
public class DataManager<T> {
	
	/**
	 * Collection de données
	 */
	protected Collection<T> dataCollection;
	
	/**
	 * Composant d'interface
	 */
	protected UIData dataComponent;
	
	/**
	 * Modèle de données
	 */
	protected DataModel<T> dataModel;
	
	/**
	 * Donnée sélectionnée
	 */
	protected T selectedData;
	
	
	/**
	 * Constructeur par défaut
	 */
	public DataManager() {
		
		super();			
	}
	

	/**
	 * Retourne la valeur de la propriété dataCollection
	 * @return La propriété dataCollection
	 */
	public Collection<T> getDataCollection() {
		return dataCollection;		
	}


	/**
	 * Met à jour la propriété dataCollection
	 * @param dataCollection Nouvelle valeur de la propriété dataCollection
	 */
	public void setDataCollection(Collection<T> dataCollection) {
		this.dataCollection = dataCollection;
	}


	/**
	 * Retourne la valeur de la propriété dataComponent
	 * @return La propriété dataComponent
	 */
	public UIData getDataComponent() {
		return dataComponent;
	}


	/**
	 * Met à jour la propriété dataComponent
	 * @param dataComponent Nouvelle valeur de la propriété dataComponent
	 */
	public void setDataComponent(UIData dataComponent) {
		this.dataComponent = dataComponent;
	}


	/**
	 * Retourne la valeur de la propriété dataModel
	 * @return La propriété dataModel
	 */
	public DataModel<T> getDataModel() {
		return dataModel;
	}


	/**
	 * Met à jour la propriété dataModel
	 * @param dataModel Nouvelle valeur de la propriété dataModel
	 */
	public void setDataModel(DataModel<T> dataModel) {
		this.dataModel = dataModel;
	}

	/**
	 * Retourne la valeur de la propriété selectedData
	 * @return La propriété selectedData
	 */
	public T getSelectedData() {
		return selectedData;
	}

	/**
	 * Met à jour la propriété selectedData
	 * @param selectedData Nouvelle valeur de la propriété selectedData
	 */
	public void setSelectedData(T selectedData) {
		this.selectedData = selectedData;
	}
		
}
