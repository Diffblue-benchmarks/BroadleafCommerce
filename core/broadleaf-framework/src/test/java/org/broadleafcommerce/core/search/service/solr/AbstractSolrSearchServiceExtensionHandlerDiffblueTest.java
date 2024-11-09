/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Category;
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
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractSolrSearchServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}.
   * <ul>
   *   <li>Given {@link SearchFacetRangeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}
   */
  @Test
  public void testFilterSearchFacetRanges_givenSearchFacetRangeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchFacetDTO dto = mock(SearchFacetDTO.class);
    doNothing().when(dto).setAbbreviation(Mockito.<String>any());
    doNothing().when(dto).setActive(anyBoolean());
    doNothing().when(dto).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(dto).setFacetValues(Mockito.<List<SearchFacetResultDTO>>any());
    doNothing().when(dto).setShowQuantity(anyBoolean());
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    ArrayList<SearchFacetRange> ranges = new ArrayList<>();
    ranges.add(new SearchFacetRangeImpl());

    // Act
    ExtensionResultStatusType actualFilterSearchFacetRangesResult = i18nSolrSearchServiceExtensionHandler
        .filterSearchFacetRanges(dto, ranges);

    // Assert
    verify(dto).setAbbreviation(eq("Abbreviation"));
    verify(dto).setActive(eq(true));
    verify(dto).setFacet(isA(SearchFacet.class));
    verify(dto).setFacetValues(isA(List.class));
    verify(dto).setShowQuantity(eq(true));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFilterSearchFacetRangesResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}.
   * <ul>
   *   <li>Given {@link SearchFacetRangeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}
   */
  @Test
  public void testFilterSearchFacetRanges_givenSearchFacetRangeImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchFacetDTO dto = mock(SearchFacetDTO.class);
    doNothing().when(dto).setAbbreviation(Mockito.<String>any());
    doNothing().when(dto).setActive(anyBoolean());
    doNothing().when(dto).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(dto).setFacetValues(Mockito.<List<SearchFacetResultDTO>>any());
    doNothing().when(dto).setShowQuantity(anyBoolean());
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    ArrayList<SearchFacetRange> ranges = new ArrayList<>();
    ranges.add(new SearchFacetRangeImpl());
    ranges.add(new SearchFacetRangeImpl());

    // Act
    ExtensionResultStatusType actualFilterSearchFacetRangesResult = i18nSolrSearchServiceExtensionHandler
        .filterSearchFacetRanges(dto, ranges);

    // Assert
    verify(dto).setAbbreviation(eq("Abbreviation"));
    verify(dto).setActive(eq(true));
    verify(dto).setFacet(isA(SearchFacet.class));
    verify(dto).setFacetValues(isA(List.class));
    verify(dto).setShowQuantity(eq(true));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFilterSearchFacetRangesResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link SearchFacetDTO#setAbbreviation(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}
   */
  @Test
  public void testFilterSearchFacetRanges_whenArrayList_thenCallsSetAbbreviation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchFacetDTO dto = mock(SearchFacetDTO.class);
    doNothing().when(dto).setAbbreviation(Mockito.<String>any());
    doNothing().when(dto).setActive(anyBoolean());
    doNothing().when(dto).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(dto).setFacetValues(Mockito.<List<SearchFacetResultDTO>>any());
    doNothing().when(dto).setShowQuantity(anyBoolean());
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act
    ExtensionResultStatusType actualFilterSearchFacetRangesResult = i18nSolrSearchServiceExtensionHandler
        .filterSearchFacetRanges(dto, new ArrayList<>());

    // Assert
    verify(dto).setAbbreviation(eq("Abbreviation"));
    verify(dto).setActive(eq(true));
    verify(dto).setFacet(isA(SearchFacet.class));
    verify(dto).setFacetValues(isA(List.class));
    verify(dto).setShowQuantity(eq(true));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFilterSearchFacetRangesResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}.
   * <ul>
   *   <li>When {@link SearchFacetDTO} (default constructor) Abbreviation is
   * {@code Abbreviation}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#filterSearchFacetRanges(SearchFacetDTO, List)}
   */
  @Test
  public void testFilterSearchFacetRanges_whenSearchFacetDTOAbbreviationIsAbbreviation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.filterSearchFacetRanges(dto, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   * with {@code context}, {@code query}, {@code qualifiedSolrQuery},
   * {@code facets}, {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithContextQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    SearchContextDTO context = new SearchContextDTO();
    context.setAttributes(new HashMap<>());
    SolrQuery query = new SolrQuery("foo");
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler.modifySolrQuery(context,
        query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   * with {@code context}, {@code query}, {@code qualifiedSolrQuery},
   * {@code facets}, {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithContextQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchContextDTO context = mock(SearchContextDTO.class);
    doNothing().when(context).setAttributes(Mockito.<Map<String, Object>>any());
    context.setAttributes(new HashMap<>());
    SolrQuery query = new SolrQuery("foo");
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualModifySolrQueryResult = i18nSolrSearchServiceExtensionHandler
        .modifySolrQuery(context, query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort");

    // Assert
    verify(context).setAttributes(isA(Map.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifySolrQueryResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   * with {@code context}, {@code query}, {@code qualifiedSolrQuery},
   * {@code facets}, {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithContextQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchContextDTO context = mock(SearchContextDTO.class);
    doNothing().when(context).setAttributes(Mockito.<Map<String, Object>>any());
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

    // Act
    ExtensionResultStatusType actualModifySolrQueryResult = i18nSolrSearchServiceExtensionHandler
        .modifySolrQuery(context, query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort");

    // Assert
    verify(context).setAttributes(isA(Map.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifySolrQueryResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   * with {@code context}, {@code query}, {@code qualifiedSolrQuery},
   * {@code facets}, {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SearchContextDTO, SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithContextQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchContextDTO context = mock(SearchContextDTO.class);
    doNothing().when(context).setAttributes(Mockito.<Map<String, Object>>any());
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

    // Act
    ExtensionResultStatusType actualModifySolrQueryResult = i18nSolrSearchServiceExtensionHandler
        .modifySolrQuery(context, query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort");

    // Assert
    verify(context).setAttributes(isA(Map.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifySolrQueryResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   * with {@code query}, {@code qualifiedSolrQuery}, {@code facets},
   * {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler.modifySolrQuery(query,
        "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   * with {@code query}, {@code qualifiedSolrQuery}, {@code facets},
   * {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = mock(SolrQuery.class);
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler.modifySolrQuery(query,
        "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   * with {@code query}, {@code qualifiedSolrQuery}, {@code facets},
   * {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
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
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler.modifySolrQuery(query,
        "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   * with {@code query}, {@code qualifiedSolrQuery}, {@code facets},
   * {@code searchCriteria}, {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  public void testModifySolrQueryWithQueryQualifiedSolrQueryFacetsSearchCriteriaDefaultSort4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
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
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler.modifySolrQuery(query,
        "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort"));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getQueryField(SolrQuery, SearchCriteria, IndexFieldType, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SolrQuery}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getQueryField(SolrQuery, SearchCriteria, IndexFieldType, ExtensionResultHolder)}
   */
  @Test
  public void testGetQueryField_whenSolrQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = mock(SolrQuery.class);
    SearchCriteria searchCriteria = new SearchCriteria();
    IndexFieldTypeImpl indexFieldType = new IndexFieldTypeImpl();

    ExtensionResultHolder<List<String>> queryFieldsResult = new ExtensionResultHolder<>();
    queryFieldsResult.setResult(new ArrayList<>());
    queryFieldsResult.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getQueryField(query, searchCriteria, indexFieldType, queryFieldsResult));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getQueryField(SolrQuery, SearchCriteria, IndexFieldType, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SolrQuery#SolrQuery(String)} with q is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getQueryField(SolrQuery, SearchCriteria, IndexFieldType, ExtensionResultHolder)}
   */
  @Test
  public void testGetQueryField_whenSolrQueryWithQIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");
    SearchCriteria searchCriteria = new SearchCriteria();
    IndexFieldTypeImpl indexFieldType = new IndexFieldTypeImpl();

    ExtensionResultHolder<List<String>> queryFieldsResult = new ExtensionResultHolder<>();
    queryFieldsResult.setResult(new ArrayList<>());
    queryFieldsResult.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getQueryField(query, searchCriteria, indexFieldType, queryFieldsResult));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  public void testModifySearchResults_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, products));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  public void testModifySearchResults_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, products));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  public void testModifySearchResults_givenProductBundleImpl_whenArrayListAddProductBundleImpl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(mock(ProductBundleImpl.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, products));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   * <ul>
   *   <li>Given {@link SolrDocument#SolrDocument()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link SolrDocument#SolrDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  public void testModifySearchResults_givenSolrDocument_whenArrayListAddSolrDocument() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();
    responseDocuments.add(new SolrDocument());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   * <ul>
   *   <li>Given {@link SolrDocument#SolrDocument()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link SolrDocument#SolrDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  public void testModifySearchResults_givenSolrDocument_whenArrayListAddSolrDocument2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();
    responseDocuments.add(new SolrDocument());
    responseDocuments.add(new SolrDocument());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#modifySearchResults(List, List)}
   */
  @Test
  public void testModifySearchResults_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    ArrayList<SolrDocument> responseDocuments = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.modifySearchResults(responseDocuments, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}
   */
  @Test
  public void testGetSearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchFacets(searchFacets));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}
   */
  @Test
  public void testGetSearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchFacets(searchFacets));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}
   */
  @Test
  public void testGetSearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(mock(SearchFacetImpl.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchFacets(searchFacets));
  }

  /**
   * Test {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchFacets(List)}
   */
  @Test
  public void testGetSearchFacets_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchFacets(new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO, SearchCriteria)}
   * with {@code query}, {@code indexField}, {@code dto}, {@code searchCriteria}.
   * <ul>
   *   <li>When {@link SolrQuery}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO, SearchCriteria)}
   */
  @Test
  public void testAttachFacetWithQueryIndexFieldDtoSearchCriteria_whenSolrQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = mock(SolrQuery.class);

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.attachFacet(query, "Index Field", dto, new SearchCriteria()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO, SearchCriteria)}
   * with {@code query}, {@code indexField}, {@code dto}, {@code searchCriteria}.
   * <ul>
   *   <li>When {@link SolrQuery#SolrQuery(String)} with q is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO, SearchCriteria)}
   */
  @Test
  public void testAttachFacetWithQueryIndexFieldDtoSearchCriteria_whenSolrQueryWithQIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.attachFacet(query, "Index Field", dto, new SearchCriteria()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO)}
   * with {@code query}, {@code indexField}, {@code dto}.
   * <ul>
   *   <li>When {@link SolrQuery}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO)}
   */
  @Test
  public void testAttachFacetWithQueryIndexFieldDto_whenSolrQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = mock(SolrQuery.class);

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.attachFacet(query, "Index Field", dto));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO)}
   * with {@code query}, {@code indexField}, {@code dto}.
   * <ul>
   *   <li>When {@link SolrQuery#SolrQuery(String)} with q is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String, SearchFacetDTO)}
   */
  @Test
  public void testAttachFacetWithQueryIndexFieldDto_whenSolrQueryWithQIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SolrQuery query = new SolrQuery("foo");

    SearchFacetDTO dto = new SearchFacetDTO();
    dto.setAbbreviation("Abbreviation");
    dto.setActive(true);
    dto.setFacet(new SearchFacetImpl());
    dto.setFacetValues(new ArrayList<>());
    dto.setShowQuantity(true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.attachFacet(query, "Index Field", dto));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#setFacetResults(Map, QueryResponse)}.
   * <ul>
   *   <li>When {@link QueryResponse#QueryResponse()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#setFacetResults(Map, QueryResponse)}
   */
  @Test
  public void testSetFacetResults_whenQueryResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.setFacetResults(namedFacetMap, new QueryResponse()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#setFacetResults(Map, QueryResponse)}.
   * <ul>
   *   <li>When {@link QueryResponse}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#setFacetResults(Map, QueryResponse)}
   */
  @Test
  public void testSetFacetResults_whenQueryResponse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.setFacetResults(new HashMap<>(), mock(QueryResponse.class)));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   * with {@code entityType}, {@code solrKey}, {@code selectedValues},
   * {@code valueStrings}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   */
  @Test
  public void testBuildActiveFacetFilterWithEntityTypeSolrKeySelectedValuesValueStrings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler
        .buildActiveFacetFilter(FieldEntity.CATEGORY, "Solr Key", new String[]{"42"}, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   * with {@code entityType}, {@code solrKey}, {@code selectedValues},
   * {@code valueStrings}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   */
  @Test
  public void testBuildActiveFacetFilterWithEntityTypeSolrKeySelectedValuesValueStrings2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    FieldEntity entityType = mock(FieldEntity.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler
        .buildActiveFacetFilter(entityType, "Solr Key", new String[]{"42"}, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   * with {@code entityType}, {@code solrKey}, {@code selectedValues},
   * {@code valueStrings}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   */
  @Test
  public void testBuildActiveFacetFilterWithEntityTypeSolrKeySelectedValuesValueStrings3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("foo");

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler
        .buildActiveFacetFilter(FieldEntity.CATEGORY, "Solr Key", new String[]{"42"}, valueStrings));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   * with {@code entityType}, {@code solrKey}, {@code selectedValues},
   * {@code valueStrings}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(FieldEntity, String, String[], List)}
   */
  @Test
  public void testBuildActiveFacetFilterWithEntityTypeSolrKeySelectedValuesValueStrings4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("42");
    valueStrings.add("foo");

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler
        .buildActiveFacetFilter(FieldEntity.CATEGORY, "Solr Key", new String[]{"42"}, valueStrings));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   * with {@code facet}, {@code selectedValues}, {@code valueStrings}.
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   */
  @Test
  public void testBuildActiveFacetFilterWithFacetSelectedValuesValueStrings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    // Act
    ExtensionResultStatusType actualBuildActiveFacetFilterResult = i18nSolrSearchServiceExtensionHandler
        .buildActiveFacetFilter(facet, new String[]{"42"}, new ArrayList<>());

    // Assert
    verify(facet, atLeast(1)).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildActiveFacetFilterResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   * with {@code facet}, {@code selectedValues}, {@code valueStrings}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   */
  @Test
  public void testBuildActiveFacetFilterWithFacetSelectedValuesValueStrings_given42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("42");
    valueStrings.add("foo");

    // Act
    ExtensionResultStatusType actualBuildActiveFacetFilterResult = i18nSolrSearchServiceExtensionHandler
        .buildActiveFacetFilter(facet, new String[]{"42"}, valueStrings);

    // Assert
    verify(facet, atLeast(1)).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildActiveFacetFilterResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   * with {@code facet}, {@code selectedValues}, {@code valueStrings}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#buildActiveFacetFilter(SearchFacet, String[], List)}
   */
  @Test
  public void testBuildActiveFacetFilterWithFacetSelectedValuesValueStrings_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    ArrayList<String> valueStrings = new ArrayList<>();
    valueStrings.add("foo");

    // Act
    ExtensionResultStatusType actualBuildActiveFacetFilterResult = i18nSolrSearchServiceExtensionHandler
        .buildActiveFacetFilter(facet, new String[]{"42"}, valueStrings);

    // Assert
    verify(facet, atLeast(1)).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildActiveFacetFilterResult);
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}
   */
  @Test
  public void testAddAdditionalCategoryIds_givenOne_whenArrayListAddOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<Long> categoryIds = new ArrayList<>();
    categoryIds.add(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(category, searchCriteria, categoryIds));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}
   */
  @Test
  public void testAddAdditionalCategoryIds_givenZero_whenArrayListAddZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<Long> categoryIds = new ArrayList<>();
    categoryIds.add(0L);
    categoryIds.add(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(category, searchCriteria, categoryIds));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}
   */
  @Test
  public void testAddAdditionalCategoryIds_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(category, searchCriteria, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria, List)}
   */
  @Test
  public void testAddAdditionalCategoryIds_whenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = mock(CategoryImpl.class);
    SearchCriteria searchCriteria = new SearchCriteria();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(category, searchCriteria, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}
   */
  @Test
  public void testGetCategorySearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategorySearchFacets(category, searchFacets));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}
   */
  @Test
  public void testGetCategorySearchFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    ArrayList<SearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new SearchFacetImpl());
    searchFacets.add(new SearchFacetImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategorySearchFacets(category, searchFacets));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}
   */
  @Test
  public void testGetCategorySearchFacets_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategorySearchFacets(category, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategorySearchFacets(Category, List)}
   */
  @Test
  public void testGetCategorySearchFacets_whenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    CategoryImpl category = mock(CategoryImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategorySearchFacets(category, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}
   */
  @Test
  public void testGetSearchableIndexFields_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(fields));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}
   */
  @Test
  public void testGetSearchableIndexFields_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(fields));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}
   */
  @Test
  public void testGetSearchableIndexFields_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(mock(IndexFieldImpl.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(fields));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}
   */
  @Test
  public void testGetSearchableIndexFields_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategoryId(Category, Long[])}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategoryId(Category, Long[])}
   */
  @Test
  public void testGetCategoryId_whenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getCategoryId(new CategoryImpl(), new Long[]{1L}));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategoryId(Category, Long[])}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getCategoryId(Category, Long[])}
   */
  @Test
  public void testGetCategoryId_whenCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new I18nSolrSearchServiceExtensionHandler()).getCategoryId(mock(CategoryImpl.class), new Long[]{1L}));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}
   */
  @Test
  public void testBatchFetchCatalogData_givenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.batchFetchCatalogData(products));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}
   */
  @Test
  public void testBatchFetchCatalogData_givenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.batchFetchCatalogData(products));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}
   */
  @Test
  public void testBatchFetchCatalogData_givenProductBundleImpl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    ArrayList<Product> products = new ArrayList<>();
    products.add(mock(ProductBundleImpl.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.batchFetchCatalogData(products));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#batchFetchCatalogData(List)}
   */
  @Test
  public void testBatchFetchCatalogData_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.batchFetchCatalogData(new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#attachSortField(SolrQuery, String, ORDER)}.
   * <ul>
   *   <li>When {@link SolrQuery}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#attachSortField(SolrQuery, String, SolrQuery.ORDER)}
   */
  @Test
  public void testAttachSortField_whenSolrQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, (new I18nSolrSearchServiceExtensionHandler())
        .attachSortField(mock(SolrQuery.class), "Requested Sort Field Name", SolrQuery.ORDER.desc));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#attachSortField(SolrQuery, String, ORDER)}.
   * <ul>
   *   <li>When {@link SolrQuery#SolrQuery(String)} with q is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#attachSortField(SolrQuery, String, SolrQuery.ORDER)}
   */
  @Test
  public void testAttachSortField_whenSolrQueryWithQIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrSearchServiceExtensionHandler
        .attachSortField(new SolrQuery("foo"), "Requested Sort Field Name", SolrQuery.ORDER.desc));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getPropertyNameForIndexField(IndexField, FieldType, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getPropertyNameForIndexField(IndexField, FieldType, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetPropertyNameForIndexField_whenIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    IndexFieldImpl field = new IndexFieldImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(field, FieldType.BOOLEAN, "Prefix", erh));
  }

  /**
   * Test
   * {@link AbstractSolrSearchServiceExtensionHandler#getPropertyNameForIndexField(IndexField, FieldType, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link IndexFieldImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrSearchServiceExtensionHandler#getPropertyNameForIndexField(IndexField, FieldType, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetPropertyNameForIndexField_whenIndexFieldImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    IndexFieldImpl field = mock(IndexFieldImpl.class);

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(field, FieldType.BOOLEAN, "Prefix", erh));
  }
}
