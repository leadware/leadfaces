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

import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;


/**
 * Interface de pagination <br/>
 * Spécifie un ensemble de méthodes pour le chargement partiel des données
 * 
 * @author <a href="mailto:lkamhoua@leadware.net">Landry KAMHOUA (J. Enterprise Architect)</a>
 * @since  1.0.0
 * 
 * @param <T> Type des données managées
 */
public interface IPagination<T> {
	
	/**
	 * Valeur de l'index de début pour la pagination
	 */
	public static final int PAGINATION_BEGINNING_OFFSET_INDEX_VALUE = 0;

	/**
	 * Valeur permettant de désactiver la pagination
	 */
	public static final int PAGINATION_DESACTIVATION_VALUE = -1;
	
	
	/**
	 * Méthode de chargement (à la demande) d'un (sous) ensemble de données
	 * 
	 * @param first 	Index de début des données à charger
	 * @param size 		Nombre de données à charger
	 * @param sortField Critère de tri	
	 * @param sortOrder Sens du tri
	 * @param filters	Filtre
	 * 
	 * @return Liste (partielle) des données
	 */
	public List<T> load(int first, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters);

	/**
	 * Méthode de chargement (à la demande) d'un (sous) ensemble de données
	 * 
	 * @param first 		Index de début des données à charger
	 * @param size 			Nombre de données à charger
	 * @param multiSortMeta Collection de critères de tri
	 * @param filters		Filtres
	 * 
	 * @return Liste (partielle) des données
	 */
	public List<T> load(int first, int size, List<SortMeta> multiSortMeta, Map<String, Object> filters);

}
