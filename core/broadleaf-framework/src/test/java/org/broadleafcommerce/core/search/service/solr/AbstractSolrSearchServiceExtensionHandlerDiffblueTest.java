/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.IndexFieldType;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractSolrSearchServiceExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetRangeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.filterSearchFacetRanges(SearchFacetDTO, List)"
  })
  public void testFilterSearchFacetRanges_givenSearchFacetRangeImpl() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    ArrayList<SearchFacetRange> ranges = new ArrayList<>();
    ranges.add(new SearchFacetRangeImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.filterSearchFacetRanges(dto, ranges));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetRangeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.filterSearchFacetRanges(SearchFacetDTO, List)"
  })
  public void testFilterSearchFacetRanges_givenSearchFacetRangeImpl2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    ArrayList<SearchFacetRange> ranges = new ArrayList<>();
    ranges.add(new SearchFacetRangeImpl());
    ranges.add(new SearchFacetRangeImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.filterSearchFacetRanges(dto, ranges));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.filterSearchFacetRanges(SearchFacetDTO, List)"
  })
  public void testFilterSearchFacetRanges_whenArrayList() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.filterSearchFacetRanges(dto, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO,
   * SolrQuery, String, List, SearchCriteria, String)} with {@code context}, {@code query}, {@code
   * qualifiedSolrQuery}, {@code facets}, {@code searchCriteria}, {@code defaultSort}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String,
   * List, SearchCriteria, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)"
  })
  public void
      testModifySolrQueryWithContextQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchContextDTO context = new SearchContextDTO();
    context.setAttributes(new HashMap<>());
    SolrQuery query = new SolrQuery("foo");
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySolrQuery(
            context, query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO,
   * SolrQuery, String, List, SearchCriteria, String)} with {@code context}, {@code query}, {@code
   * qualifiedSolrQuery}, {@code facets}, {@code searchCriteria}, {@code defaultSort}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String,
   * List, SearchCriteria, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)"
  })
  public void
      testModifySolrQueryWithContextQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchContextDTO context = new SearchContextDTO();
    context.setAttributes(new HashMap<>());
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySolrQuery(
            context, query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO,
   * SolrQuery, String, List, SearchCriteria, String)} with {@code context}, {@code query}, {@code
   * qualifiedSolrQuery}, {@code facets}, {@code searchCriteria}, {@code defaultSort}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String,
   * List, SearchCriteria, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)"
  })
  public void
      testModifySolrQueryWithContextQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort3() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchContextDTO context = new SearchContextDTO();
    context.setAttributes(new HashMap<>());
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    SearchFacetDTO searchFacetDTO2 = new SearchFacetDTO();
    searchFacetDTO2.setAbbreviation("42");
    searchFacetDTO2.setActive(false);
    searchFacetDTO2.setFacet(new SearchFacetImpl());
    searchFacetDTO2.setFacetValues(new ArrayList<>());
    searchFacetDTO2.setShowQuantity(false);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO2);
    facets.add(searchFacetDTO);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySolrQuery(
            context, query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List,
   * SearchCriteria, String)} with {@code query}, {@code qualifiedSolrQuery}, {@code facets}, {@code
   * searchCriteria}, {@code defaultSort}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List,
   * SearchCriteria, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)"
  })
  public void testModifySolrQueryWithQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySolrQuery(
            query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List,
   * SearchCriteria, String)} with {@code query}, {@code qualifiedSolrQuery}, {@code facets}, {@code
   * searchCriteria}, {@code defaultSort}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List,
   * SearchCriteria, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)"
  })
  public void testModifySolrQueryWithQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySolrQuery(
            query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List,
   * SearchCriteria, String)} with {@code query}, {@code qualifiedSolrQuery}, {@code facets}, {@code
   * searchCriteria}, {@code defaultSort}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List,
   * SearchCriteria, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)"
  })
  public void testModifySolrQueryWithQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort3() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    SearchFacetDTO searchFacetDTO2 = new SearchFacetDTO();
    searchFacetDTO2.setAbbreviation("42");
    searchFacetDTO2.setActive(false);
    searchFacetDTO2.setFacet(new SearchFacetImpl());
    searchFacetDTO2.setFacetValues(new ArrayList<>());
    searchFacetDTO2.setShowQuantity(false);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO2);
    facets.add(searchFacetDTO);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySolrQuery(
            query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getQueryField(SolrQuery, SearchCriteria,
   * IndexFieldType, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AbstractSolrSearchServiceExtensionHandler#getQueryField(SolrQuery,
   * SearchCriteria, IndexFieldType, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getQueryField(SolrQuery, SearchCriteria, IndexFieldType, ExtensionResultHolder)"
  })
  public void testGetQueryField() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");
    SearchCriteria searchCriteria = new SearchCriteria();
    IndexFieldTypeImpl indexFieldType = new IndexFieldTypeImpl();

    ExtensionResultHolder<List<String>> queryFieldsResult = new ExtensionResultHolder<>();
    queryFieldsResult.setResult(new ArrayList<>());
    queryFieldsResult.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getQueryField(
            query, searchCriteria, indexFieldType, queryFieldsResult));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySearchResults(List, List)"
  })
  public void testModifySearchResults_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, products));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySearchResults(List, List)"
  })
  public void testModifySearchResults_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, products));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   *
   * <ul>
   *   <li>Given {@link SolrDocument#SolrDocument()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link SolrDocument#SolrDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySearchResults(List, List)"
  })
  public void testModifySearchResults_givenSolrDocument_whenArrayListAddSolrDocument() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();
    responseDocuments.add(new SolrDocument());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(
            responseDocuments, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   *
   * <ul>
   *   <li>Given {@link SolrDocument#SolrDocument()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link SolrDocument#SolrDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySearchResults(List, List)"
  })
  public void testModifySearchResults_givenSolrDocument_whenArrayListAddSolrDocument2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();
    responseDocuments.add(new SolrDocument());
    responseDocuments.add(new SolrDocument());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(
            responseDocuments, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.modifySearchResults(List, List)"
  })
  public void testModifySearchResults_whenArrayList() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(
            responseDocuments, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getSearchFacets(List)"
  })
  public void testGetSearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchFacets(searchFacets));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getSearchFacets(List)"
  })
  public void testGetSearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchFacets(searchFacets));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getSearchFacets(List)"
  })
  public void testGetSearchFacets_whenArrayList() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchFacets(new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String,
   * SearchFacetDTO)} with {@code query}, {@code indexField}, {@code dto}.
   *
   * <p>Method under test: {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery,
   * String, SearchFacetDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.attachFacet(SolrQuery, String, SearchFacetDTO)"
  })
  public void testAttachFacetWithQueryIndexFieldDto() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.attachFacet(query, "Index Field", dto));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String,
   * SearchFacetDTO, SearchCriteria)} with {@code query}, {@code indexField}, {@code dto}, {@code
   * searchCriteria}.
   *
   * <p>Method under test: {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery,
   * String, SearchFacetDTO, SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.attachFacet(SolrQuery, String, SearchFacetDTO, SearchCriteria)"
  })
  public void testAttachFacetWithQueryIndexFieldDtoSearchCriteria() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.attachFacet(
            query, "Index Field", dto, new SearchCriteria()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#setFacetResults(Map, QueryResponse)}.
   *
   * <p>Method under test: {@link AbstractSolrSearchServiceExtensionHandler#setFacetResults(Map,
   * QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.setFacetResults(Map, QueryResponse)"
  })
  public void testSetFacetResults() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.setFacetResults(namedFacetMap, new QueryResponse()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity,
   * String, String[], List)} with {@code entityType}, {@code solrKey}, {@code selectedValues},
   * {@code valueStrings}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[],
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.buildActiveFacetFilter(FieldEntity, String, String[], List)"
  })
  public void testBuildActiveFacetFilterWithEntityTypeSolrKeySelectedValuesValueStrings() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.buildActiveFacetFilter(
            FieldEntity.CATEGORY, "Solr Key", new String[] {"42"}, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity,
   * String, String[], List)} with {@code entityType}, {@code solrKey}, {@code selectedValues},
   * {@code valueStrings}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[],
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.buildActiveFacetFilter(FieldEntity, String, String[], List)"
  })
  public void testBuildActiveFacetFilterWithEntityTypeSolrKeySelectedValuesValueStrings2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("foo");

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.buildActiveFacetFilter(
            FieldEntity.CATEGORY, "Solr Key", new String[] {"42"}, valueStrings));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity,
   * String, String[], List)} with {@code entityType}, {@code solrKey}, {@code selectedValues},
   * {@code valueStrings}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[],
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.buildActiveFacetFilter(FieldEntity, String, String[], List)"
  })
  public void testBuildActiveFacetFilterWithEntityTypeSolrKeySelectedValuesValueStrings3() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("42");
    valueStrings.add("foo");

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.buildActiveFacetFilter(
            FieldEntity.CATEGORY, "Solr Key", new String[] {"42"}, valueStrings));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet,
   * String[], List)} with {@code facet}, {@code selectedValues}, {@code valueStrings}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.buildActiveFacetFilter(SearchFacet, String[], List)"
  })
  public void testBuildActiveFacetFilterWithFacetSelectedValuesValueStrings() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    // Act
    ExtensionResultStatusType actualBuildActiveFacetFilterResult =
        i18nSolrSearchServiceExtensionHandler.buildActiveFacetFilter(
            facet, new String[] {"42"}, new ArrayList<>());

    // Assert
    verify(facet, atLeast(1)).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildActiveFacetFilterResult);
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet,
   * String[], List)} with {@code facet}, {@code selectedValues}, {@code valueStrings}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.buildActiveFacetFilter(SearchFacet, String[], List)"
  })
  public void testBuildActiveFacetFilterWithFacetSelectedValuesValueStrings_given42() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("42");
    valueStrings.add("foo");

    // Act
    ExtensionResultStatusType actualBuildActiveFacetFilterResult =
        i18nSolrSearchServiceExtensionHandler.buildActiveFacetFilter(
            facet, new String[] {"42"}, valueStrings);

    // Assert
    verify(facet, atLeast(1)).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildActiveFacetFilterResult);
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet,
   * String[], List)} with {@code facet}, {@code selectedValues}, {@code valueStrings}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.buildActiveFacetFilter(SearchFacet, String[], List)"
  })
  public void testBuildActiveFacetFilterWithFacetSelectedValuesValueStrings_givenFoo() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("foo");

    // Act
    ExtensionResultStatusType actualBuildActiveFacetFilterResult =
        i18nSolrSearchServiceExtensionHandler.buildActiveFacetFilter(
            facet, new String[] {"42"}, valueStrings);

    // Assert
    verify(facet, atLeast(1)).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildActiveFacetFilterResult);
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category,
   * SearchCriteria, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria, List)"
  })
  public void testAddAdditionalCategoryIds_givenOne_whenArrayListAddOne() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<Long> categoryIds = new ArrayList<>();
    categoryIds.add(1L);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(
            category, searchCriteria, categoryIds));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category,
   * SearchCriteria, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria, List)"
  })
  public void testAddAdditionalCategoryIds_givenZero_whenArrayListAddZero() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<Long> categoryIds = new ArrayList<>();
    categoryIds.add(0L);
    categoryIds.add(1L);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(
            category, searchCriteria, categoryIds));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category,
   * SearchCriteria, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria, List)"
  })
  public void testAddAdditionalCategoryIds_whenArrayList() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(
            category, searchCriteria, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(org.broadleafcommerce.core.catalog.domain.Category,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getCategorySearchFacets(org.broadleafcommerce.core.catalog.domain.Category, List)"
  })
  public void testGetCategorySearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategorySearchFacets(category, searchFacets));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(org.broadleafcommerce.core.catalog.domain.Category,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getCategorySearchFacets(org.broadleafcommerce.core.catalog.domain.Category, List)"
  })
  public void testGetCategorySearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategorySearchFacets(category, searchFacets));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(org.broadleafcommerce.core.catalog.domain.Category,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getCategorySearchFacets(org.broadleafcommerce.core.catalog.domain.Category, List)"
  })
  public void testGetCategorySearchFacets_whenArrayList() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategorySearchFacets(category, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getSearchableIndexFields(List)"
  })
  public void testGetSearchableIndexFields_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(fields));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getSearchableIndexFields(List)"
  })
  public void testGetSearchableIndexFields_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(fields));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getSearchableIndexFields(List)"
  })
  public void testGetSearchableIndexFields_whenArrayList() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getCategoryId(Category, Long[])}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getCategoryId(org.broadleafcommerce.core.catalog.domain.Category,
   * Long[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getCategoryId(org.broadleafcommerce.core.catalog.domain.Category, Long[])"
  })
  public void testGetCategoryId() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategoryId(new CategoryImpl(), new Long[] {1L}));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.batchFetchCatalogData(List)"
  })
  public void testBatchFetchCatalogData_givenProductBundleImpl() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.batchFetchCatalogData(products));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.batchFetchCatalogData(List)"
  })
  public void testBatchFetchCatalogData_givenProductBundleImpl2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.batchFetchCatalogData(products));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.batchFetchCatalogData(List)"
  })
  public void testBatchFetchCatalogData_whenArrayList() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.batchFetchCatalogData(new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#attachSortField(SolrQuery, String,
   * ORDER)}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#attachSortField(SolrQuery, String, SolrQuery.ORDER)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.attachSortField(SolrQuery, String, SolrQuery.ORDER)"
  })
  public void testAttachSortField() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.attachSortField(
            new SolrQuery("foo"), "Requested Sort Field Name", ORDER.desc));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getPropertyNameForIndexField(IndexField,
   * FieldType, String, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractSolrSearchServiceExtensionHandler#getPropertyNameForIndexField(IndexField, FieldType,
   * String, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(IndexField, FieldType, String, ExtensionResultHolder)"
  })
  public void testGetPropertyNameForIndexField() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        new I18nSolrSearchServiceExtensionHandler();
    IndexFieldImpl field = new IndexFieldImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(
            field, FieldType.BOOLEAN, "Prefix", erh));
  }
}
