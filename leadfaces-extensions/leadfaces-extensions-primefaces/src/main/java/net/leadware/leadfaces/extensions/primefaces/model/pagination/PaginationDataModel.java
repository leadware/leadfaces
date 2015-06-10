/**
 * 
 */
package net.leadware.leadfaces.extensions.primefaces.model.pagination;

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

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;


/**
 * Classe représentant un modèle de données spécialisé pour le chargement à la demande (lazy / pagination)
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 * 
 * @param <T> Type des données managées
 */
public class PaginationDataModel<T> extends LazyDataModel<T> {

	/**
	 * ID de sérialisation
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Composant implémentant l'interface de pagination
	 */
	private IPagination<T> paginationImpl;	
	
	
	/**
	 * Constructeur paramétré
	 * @param paginationImpl Composant implémentant la pagination
	 */
	public PaginationDataModel(IPagination<T> paginationImpl) {
		
		super();
		
		// initialisation du composant de pagination
		this.paginationImpl = paginationImpl;	
	}

	/* (non-Javadoc)
	 * @see org.primefaces.model.LazyDataModel#load(int, int, java.lang.String, org.primefaces.model.SortOrder, java.util.Map)
	 */
	@Override
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
			
		// Chargement des données
		return paginationImpl.load(first, pageSize, sortField, sortOrder, filters);
	}
	
	@Override
	public List<T> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
		
		// Chargement des données
		return paginationImpl.load(first, pageSize, multiSortMeta, filters);
	}
		
}
