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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.broadleafcommerce.common.config.service.SystemPropertiesService;
import org.broadleafcommerce.common.dao.GenericEntityDao;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.search.dao.IndexFieldDao;
import org.broadleafcommerce.core.search.dao.SearchFacetDao;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.IndexFieldType;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.broadleafcommerce.core.search.domain.RequiredFacet;
import org.broadleafcommerce.core.search.domain.RequiredFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SolrHelperServiceImplDiffblueTest {
  @Mock private GenericEntityDao genericEntityDao;

  @Mock private IndexFieldDao indexFieldDao;

  @Mock private SearchFacetDao searchFacetDao;

  @InjectMocks private SolrHelperServiceImpl solrHelperServiceImpl;

  @Mock private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  @Mock private SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;

  @Mock private SystemPropertiesService systemPropertiesService;

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType, String)}
   * with {@code field}, {@code fieldType}, {@code prefix}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType, String)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldFieldTypePrefix() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);
    fieldImpl.setAbbreviation("");

    IndexField field = mock(IndexField.class);
    when(field.getField()).thenReturn(fieldImpl);

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field, FieldType.BOOLEAN, "Prefix");

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(field, atLeast(1)).getField();
    assertEquals("PrefixProperty Name_b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType, String)}
   * with {@code field}, {@code fieldType}, {@code prefix}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType, String)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldFieldTypePrefix2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(
            Mockito.<IndexField>any(),
            Mockito.<FieldType>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);
    fieldImpl.setAbbreviation("");

    IndexField field = mock(IndexField.class);
    when(field.getField()).thenReturn(fieldImpl);

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field, FieldType.BOOLEAN, "Prefix");

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(field, atLeast(1)).getField();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getPropertyNameForIndexField(
            isA(IndexField.class),
            isA(FieldType.class),
            eq("Prefix"),
            isA(ExtensionResultHolder.class));
    assertEquals("PrefixProperty Name_b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType, String)}
   * with {@code field}, {@code fieldType}, {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code PrefixField_b}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType, String)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldFieldTypePrefix_thenReturnPrefixFieldB() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);
    fieldImpl.setAbbreviation("Field");

    IndexField field = mock(IndexField.class);
    when(field.getField()).thenReturn(fieldImpl);

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field, FieldType.BOOLEAN, "Prefix");

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(field).getField();
    assertEquals("PrefixField_b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType, String)}
   * with {@code field}, {@code fieldType}, {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixnull_b}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType, String)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldFieldTypePrefix_thenReturnPrefixnullB() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    IndexFieldImpl field = new IndexFieldImpl();
    field.setField(new FieldImpl());

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field, FieldType.BOOLEAN, "Prefix");

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    assertEquals("Prefixnull_b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType)} with
   * {@code field}, {@code searchableFieldType}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldSearchableFieldType() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    IndexFieldImpl field = new IndexFieldImpl();
    field.setField(new FieldImpl());

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field, FieldType.BOOLEAN);

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    assertEquals("null_b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType)} with
   * {@code field}, {@code searchableFieldType}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldSearchableFieldType2() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(
            Mockito.<IndexField>any(),
            Mockito.<FieldType>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrSearchServiceExtensionHandler.buildPrefixListForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    FieldImpl field = new FieldImpl();
    field.setAbbreviation("");

    IndexFieldImpl field2 = new IndexFieldImpl();
    field2.setField(field);

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field2, FieldType.BOOLEAN);

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getPropertyNameForIndexField(
            isA(IndexField.class), isA(FieldType.class), eq(""), isA(ExtensionResultHolder.class));
    verify(i18nSolrSearchServiceExtensionHandler)
        .buildPrefixListForIndexField(isA(IndexField.class), isA(FieldType.class), isA(List.class));
    assertEquals("null_b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType)} with
   * {@code field}, {@code searchableFieldType}.
   *
   * <ul>
   *   <li>Then return {@code __b}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldSearchableFieldType_thenReturnB() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(
            Mockito.<IndexField>any(),
            Mockito.<FieldType>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrSearchServiceExtensionHandler.buildPrefixListForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    FieldImpl field = new FieldImpl();
    field.setAbbreviation("_");

    IndexFieldImpl field2 = new IndexFieldImpl();
    field2.setField(field);

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field2, FieldType.BOOLEAN);

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getPropertyNameForIndexField(
            isA(IndexField.class), isA(FieldType.class), eq(""), isA(ExtensionResultHolder.class));
    verify(i18nSolrSearchServiceExtensionHandler)
        .buildPrefixListForIndexField(isA(IndexField.class), isA(FieldType.class), isA(List.class));
    assertEquals("__b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType)} with
   * {@code field}, {@code searchableFieldType}.
   *
   * <ul>
   *   <li>Then return {@code null_b}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField,
   * FieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getPropertyNameForIndexField(IndexField, FieldType)"
  })
  public void testGetPropertyNameForIndexFieldWithFieldSearchableFieldType_thenReturnNullB() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(
            Mockito.<IndexField>any(),
            Mockito.<FieldType>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrSearchServiceExtensionHandler.buildPrefixListForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    IndexFieldImpl field = new IndexFieldImpl();
    field.setField(new FieldImpl());

    // Act
    String actualPropertyNameForIndexField =
        solrHelperServiceImpl.getPropertyNameForIndexField(field, FieldType.BOOLEAN);

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getPropertyNameForIndexField(
            isA(IndexField.class), isA(FieldType.class), eq(""), isA(ExtensionResultHolder.class));
    verify(i18nSolrSearchServiceExtensionHandler)
        .buildPrefixListForIndexField(isA(IndexField.class), isA(FieldType.class), isA(List.class));
    assertEquals("null_b", actualPropertyNameForIndexField);
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.convertPrefixListToString(List)"})
  public void testConvertPrefixListToString_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("");

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code foo_}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.convertPrefixListToString(List)"})
  public void testConvertPrefixListToString_givenFoo_whenArrayListAddFoo_thenReturnFoo() {
    // Arrange
    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("foo");

    // Act and Assert
    assertEquals("foo_", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code foo_foo_}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.convertPrefixListToString(List)"})
  public void testConvertPrefixListToString_givenFoo_whenArrayListAddFoo_thenReturnFooFoo() {
    // Arrange
    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("foo");
    prefixList.add("foo");

    // Act and Assert
    assertEquals("foo_foo_", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.convertPrefixListToString(List)"})
  public void testConvertPrefixListToString_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add(null);

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.convertPrefixListToString(List)"})
  public void testConvertPrefixListToString_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(new ArrayList<>()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategoryId(Category)} with {@code Category}.
   *
   * <ul>
   *   <li>Then calls {@link I18nSolrSearchServiceExtensionHandler#getCategoryId(Category, Long[])}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrHelperServiceImpl#getCategoryId(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrHelperServiceImpl.getCategoryId(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCategoryIdWithCategory_thenCallsGetCategoryId() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getCategoryId(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<Long[]>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    // Act
    Long actualCategoryId = solrHelperServiceImpl.getCategoryId(new CategoryImpl());

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getCategoryId(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class), isA(Long[].class));
    assertNull(actualCategoryId);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategoryId(Category)} with {@code Category}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrHelperServiceImpl#getCategoryId(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrHelperServiceImpl.getCategoryId(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCategoryIdWithCategory_thenReturnNull() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    // Act
    Long actualCategoryId = solrHelperServiceImpl.getCategoryId(new CategoryImpl());

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    assertNull(actualCategoryId);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategoryId(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getCategoryId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SolrHelperServiceImpl.getCategoryId(Long)"})
  public void testGetCategoryIdWithLong_thenReturnLongValueIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    when(genericEntityDao.readGenericEntity(
            Mockito.<Class<CategoryImpl>>any(), Mockito.<Object>any()))
        .thenReturn(categoryImpl);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    // Act
    Long actualCategoryId = solrHelperServiceImpl.getCategoryId(1L);

    // Assert
    verify(genericEntityDao).readGenericEntity(isA(Class.class), isA(Object.class));
    verify(solrSearchServiceExtensionManager).getProxy();
    assertEquals(1L, actualCategoryId.longValue());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategoryId(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getCategoryId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SolrHelperServiceImpl.getCategoryId(Long)"})
  public void testGetCategoryIdWithLong_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    when(genericEntityDao.readGenericEntity(
            Mockito.<Class<CategoryImpl>>any(), Mockito.<Object>any()))
        .thenReturn(categoryImpl);

    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getCategoryId(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<Long[]>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    // Act
    Long actualCategoryId = solrHelperServiceImpl.getCategoryId(1L);

    // Assert
    verify(genericEntityDao).readGenericEntity(isA(Class.class), isA(Object.class));
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getCategoryId(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class), isA(Long[].class));
    assertNull(actualCategoryId);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getIndexableId(Indexable)}.
   *
   * <ul>
   *   <li>Then calls {@link I18nSolrIndexServiceExtensionHandler#getIndexableId(Indexable,
   *       Long[])}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getIndexableId(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SolrHelperServiceImpl.getIndexableId(Indexable)"})
  public void testGetIndexableId_thenCallsGetIndexableId() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.getIndexableId(
            Mockito.<Indexable>any(), Mockito.<Long[]>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);

    // Act
    Long actualIndexableId = solrHelperServiceImpl.getIndexableId(new ProductBundleImpl());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler)
        .getIndexableId(isA(Indexable.class), isA(Long[].class));
    assertNull(actualIndexableId);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getIndexableId(Indexable)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getIndexableId(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SolrHelperServiceImpl.getIndexableId(Indexable)"})
  public void testGetIndexableId_thenReturnNull() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());

    // Act
    Long actualIndexableId = solrHelperServiceImpl.getIndexableId(new ProductBundleImpl());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    assertNull(actualIndexableId);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPrimaryDocumentType()}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPrimaryDocumentType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.getPrimaryDocumentType()"})
  public void testGetPrimaryDocumentType() {
    // Arrange, Act and Assert
    assertEquals("PRODUCT", solrHelperServiceImpl.getPrimaryDocumentType());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   *   <li>Then calls {@link SkuImpl#getProduct()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SolrHelperServiceImpl.getCurrentProductId(Indexable)"})
  public void testGetCurrentProductId_givenProductBundleImpl_thenCallsGetProduct() {
    // Arrange
    SkuImpl indexable = mock(SkuImpl.class);
    when(indexable.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    Long actualCurrentProductId = solrHelperServiceImpl.getCurrentProductId(indexable);

    // Assert
    verify(indexable).getProduct();
    assertNull(actualCurrentProductId);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SolrHelperServiceImpl.getCurrentProductId(Indexable)"})
  public void testGetCurrentProductId_whenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(solrHelperServiceImpl.getCurrentProductId(new ProductBundleImpl()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product SolrHelperServiceImpl.getProductForIndexable(Indexable)"})
  public void testGetProductForIndexable_whenProductBundleImpl_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();

    // Act
    Product actualProductForIndexable = solrHelperServiceImpl.getProductForIndexable(indexable);

    // Assert
    assertSame(indexable, actualProductForIndexable);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product SolrHelperServiceImpl.getProductForIndexable(Indexable)"})
  public void testGetProductForIndexable_whenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(solrHelperServiceImpl.getProductForIndexable(new SkuImpl()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getTypeFieldName()}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getTypeFieldName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.getTypeFieldName()"})
  public void testGetTypeFieldName() {
    // Arrange, Act and Assert
    assertEquals("type_s", solrHelperServiceImpl.getTypeFieldName());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getDocumentType(Indexable)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code PRODUCT}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getDocumentType(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.getDocumentType(Indexable)"})
  public void testGetDocumentType_whenProductBundleImpl_thenReturnProduct() {
    // Arrange, Act and Assert
    assertEquals("PRODUCT", solrHelperServiceImpl.getDocumentType(new ProductBundleImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SolrHelperServiceImpl#getCatalogFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getCatalogOverridesFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getCategoryFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getExplicitCategoryFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getGlobalFacetTagField()}
   *   <li>{@link SolrHelperServiceImpl#getIdFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getIndexableIdFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getNamespaceFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxChangeTypeFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxPriorityFieldName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getCatalogFieldName()",
    "String SolrHelperServiceImpl.getCatalogOverridesFieldName()",
    "String SolrHelperServiceImpl.getCategoryFieldName()",
    "String SolrHelperServiceImpl.getExplicitCategoryFieldName()",
    "String SolrHelperServiceImpl.getGlobalFacetTagField()",
    "String SolrHelperServiceImpl.getIdFieldName()",
    "String SolrHelperServiceImpl.getIndexableIdFieldName()",
    "String SolrHelperServiceImpl.getNamespaceFieldName()",
    "String SolrHelperServiceImpl.getSandBoxChangeTypeFieldName()",
    "String SolrHelperServiceImpl.getSandBoxFieldName()",
    "String SolrHelperServiceImpl.getSandBoxPriorityFieldName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act
    String actualCatalogFieldName = solrHelperServiceImpl.getCatalogFieldName();
    String actualCatalogOverridesFieldName = solrHelperServiceImpl.getCatalogOverridesFieldName();
    String actualCategoryFieldName = solrHelperServiceImpl.getCategoryFieldName();
    String actualExplicitCategoryFieldName = solrHelperServiceImpl.getExplicitCategoryFieldName();
    String actualGlobalFacetTagField = solrHelperServiceImpl.getGlobalFacetTagField();
    String actualIdFieldName = solrHelperServiceImpl.getIdFieldName();
    String actualIndexableIdFieldName = solrHelperServiceImpl.getIndexableIdFieldName();
    String actualNamespaceFieldName = solrHelperServiceImpl.getNamespaceFieldName();
    String actualSandBoxChangeTypeFieldName = solrHelperServiceImpl.getSandBoxChangeTypeFieldName();
    String actualSandBoxFieldName = solrHelperServiceImpl.getSandBoxFieldName();

    // Assert
    assertEquals("a", actualGlobalFacetTagField);
    assertEquals("catalog_overrides", actualCatalogOverridesFieldName);
    assertEquals("catalog_s", actualCatalogFieldName);
    assertEquals("category", actualCategoryFieldName);
    assertEquals("explicitCategory", actualExplicitCategoryFieldName);
    assertEquals("id", actualIdFieldName);
    assertEquals("namespace", actualNamespaceFieldName);
    assertEquals("productId", actualIndexableIdFieldName);
    assertEquals("sandboxChangeType_s", actualSandBoxChangeTypeFieldName);
    assertEquals("sandboxId", actualSandBoxFieldName);
    assertEquals("sandboxPriority", solrHelperServiceImpl.getSandBoxPriorityFieldName());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategorySortFieldName(Long)} with {@code categoryId}.
   *
   * <ul>
   *   <li>Then return {@code category_1_sort}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getCategorySortFieldName(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.getCategorySortFieldName(Long)"})
  public void testGetCategorySortFieldNameWithCategoryId_thenReturnCategory1Sort() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    when(genericEntityDao.readGenericEntity(
            Mockito.<Class<CategoryImpl>>any(), Mockito.<Object>any()))
        .thenReturn(categoryImpl);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    // Act
    String actualCategorySortFieldName = solrHelperServiceImpl.getCategorySortFieldName(1L);

    // Assert
    verify(genericEntityDao).readGenericEntity(isA(Class.class), isA(Object.class));
    verify(solrSearchServiceExtensionManager).getProxy();
    assertEquals("category_1_sort", actualCategorySortFieldName);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategorySortFieldName(Long)} with {@code categoryId}.
   *
   * <ul>
   *   <li>Then return {@code category_null_sort}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getCategorySortFieldName(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.getCategorySortFieldName(Long)"})
  public void testGetCategorySortFieldNameWithCategoryId_thenReturnCategoryNullSort() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    when(genericEntityDao.readGenericEntity(
            Mockito.<Class<CategoryImpl>>any(), Mockito.<Object>any()))
        .thenReturn(categoryImpl);

    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getCategoryId(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<Long[]>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    // Act
    String actualCategorySortFieldName = solrHelperServiceImpl.getCategorySortFieldName(1L);

    // Assert
    verify(genericEntityDao).readGenericEntity(isA(Class.class), isA(Object.class));
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getCategoryId(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class), isA(Long[].class));
    assertEquals("category_null_sort", actualCategorySortFieldName);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategorySortFieldName(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then calls {@link I18nSolrSearchServiceExtensionHandler#getCategoryId(Category, Long[])}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrHelperServiceImpl#getCategorySortFieldName(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getCategorySortFieldName(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCategorySortFieldNameWithCategory_thenCallsGetCategoryId() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getCategoryId(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<Long[]>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    // Act
    String actualCategorySortFieldName =
        solrHelperServiceImpl.getCategorySortFieldName(new CategoryImpl());

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getCategoryId(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class), isA(Long[].class));
    assertEquals("category_null_sort", actualCategorySortFieldName);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategorySortFieldName(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then return {@code category_null_sort}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrHelperServiceImpl#getCategorySortFieldName(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getCategorySortFieldName(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCategorySortFieldNameWithCategory_thenReturnCategoryNullSort() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    // Act
    String actualCategorySortFieldName =
        solrHelperServiceImpl.getCategorySortFieldName(new CategoryImpl());

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    assertEquals("category_null_sort", actualCategorySortFieldName);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)} with {@code object}, {@code
   * field}.
   *
   * <ul>
   *   <li>Given {@code Property Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SolrHelperServiceImpl.getPropertyValue(Object, Field)"})
  public void testGetPropertyValueWithObjectField_givenPropertyName_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    FieldImpl field = mock(FieldImpl.class);
    when(field.getPropertyName()).thenReturn("Property Name");

    // Act
    Object actualPropertyValue = solrHelperServiceImpl.getPropertyValue("Object", field);

    // Assert
    verify(field).getPropertyName();
    assertNull(actualPropertyValue);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)} with {@code object}, {@code
   * field}.
   *
   * <ul>
   *   <li>Given {@code Property Name}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SolrHelperServiceImpl.getPropertyValue(Object, Field)"})
  public void testGetPropertyValueWithObjectField_givenPropertyName_whenNull_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    FieldImpl field = mock(FieldImpl.class);
    when(field.getPropertyName()).thenReturn("Property Name");

    // Act
    Object actualPropertyValue = solrHelperServiceImpl.getPropertyValue(null, field);

    // Assert
    verify(field).getPropertyName();
    assertNull(actualPropertyValue);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, String)} with {@code object}, {@code
   * propertyName}.
   *
   * <ul>
   *   <li>When {@code \.}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SolrHelperServiceImpl.getPropertyValue(Object, String)"})
  public void testGetPropertyValueWithObjectPropertyName_whenBackslashDot_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertNull(solrHelperServiceImpl.getPropertyValue("\\.", "Property Name"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, String)} with {@code object}, {@code
   * propertyName}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SolrHelperServiceImpl.getPropertyValue(Object, String)"})
  public void testGetPropertyValueWithObjectPropertyName_whenNull_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertNull(solrHelperServiceImpl.getPropertyValue(null, "Property Name"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, String)} with {@code object}, {@code
   * propertyName}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SolrHelperServiceImpl.getPropertyValue(Object, String)"})
  public void testGetPropertyValueWithObjectPropertyName_whenObject_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertNull(solrHelperServiceImpl.getPropertyValue("Object", "Property Name"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\||", solrHelperServiceImpl.scrubFacetValue("\\||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue2() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\\\\?", solrHelperServiceImpl.scrubFacetValue("\\\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue3() {
    // Arrange, Act and Assert
    assertEquals("\\+\\\\\\?", solrHelperServiceImpl.scrubFacetValue("+\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue4() {
    // Arrange, Act and Assert
    assertEquals("\\-\\\\\\?", solrHelperServiceImpl.scrubFacetValue("-\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue5() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\&&", solrHelperServiceImpl.scrubFacetValue("&&&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue6() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\||", solrHelperServiceImpl.scrubFacetValue("&&||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue7() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\!", solrHelperServiceImpl.scrubFacetValue("&&!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue8() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\(", solrHelperServiceImpl.scrubFacetValue("&&("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue9() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\)", solrHelperServiceImpl.scrubFacetValue("&&)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue10() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\{", solrHelperServiceImpl.scrubFacetValue("&&{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue11() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\\\\\?", solrHelperServiceImpl.scrubFacetValue("&&\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue12() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\}", solrHelperServiceImpl.scrubFacetValue("&&}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue13() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\]", solrHelperServiceImpl.scrubFacetValue("&&]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue14() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\[", solrHelperServiceImpl.scrubFacetValue("&&["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue15() {
    // Arrange, Act and Assert
    assertEquals("\\||\\\\", solrHelperServiceImpl.scrubFacetValue("||\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue16() {
    // Arrange, Act and Assert
    assertEquals("\\||\\&&", solrHelperServiceImpl.scrubFacetValue("||&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue17() {
    // Arrange, Act and Assert
    assertEquals("\\||\\||", solrHelperServiceImpl.scrubFacetValue("||||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue18() {
    // Arrange, Act and Assert
    assertEquals("\\||\\!", solrHelperServiceImpl.scrubFacetValue("||!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue19() {
    // Arrange, Act and Assert
    assertEquals("\\||\\(", solrHelperServiceImpl.scrubFacetValue("||("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue20() {
    // Arrange, Act and Assert
    assertEquals("\\||\\)", solrHelperServiceImpl.scrubFacetValue("||)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue21() {
    // Arrange, Act and Assert
    assertEquals("\\||\\{", solrHelperServiceImpl.scrubFacetValue("||{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue22() {
    // Arrange, Act and Assert
    assertEquals("\\||\\\\\\?", solrHelperServiceImpl.scrubFacetValue("||\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue23() {
    // Arrange, Act and Assert
    assertEquals("\\||\\}", solrHelperServiceImpl.scrubFacetValue("||}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue24() {
    // Arrange, Act and Assert
    assertEquals("\\||\\]", solrHelperServiceImpl.scrubFacetValue("||]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue25() {
    // Arrange, Act and Assert
    assertEquals("\\||\\[", solrHelperServiceImpl.scrubFacetValue("||["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue26() {
    // Arrange, Act and Assert
    assertEquals("\\!\\&&", solrHelperServiceImpl.scrubFacetValue("!&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue27() {
    // Arrange, Act and Assert
    assertEquals("\\!\\||", solrHelperServiceImpl.scrubFacetValue("!||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue28() {
    // Arrange, Act and Assert
    assertEquals("\\!\\\\\\?", solrHelperServiceImpl.scrubFacetValue("!\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue29() {
    // Arrange, Act and Assert
    assertEquals("\\!\\]", solrHelperServiceImpl.scrubFacetValue("!]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue30() {
    // Arrange, Act and Assert
    assertEquals("\\(\\&&", solrHelperServiceImpl.scrubFacetValue("(&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue31() {
    // Arrange, Act and Assert
    assertEquals("\\(\\||", solrHelperServiceImpl.scrubFacetValue("(||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue32() {
    // Arrange, Act and Assert
    assertEquals("\\(\\\\\\?", solrHelperServiceImpl.scrubFacetValue("(\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue33() {
    // Arrange, Act and Assert
    assertEquals("\\(\\]", solrHelperServiceImpl.scrubFacetValue("(]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue34() {
    // Arrange, Act and Assert
    assertEquals("\\*\\\\\\?", solrHelperServiceImpl.scrubFacetValue("*\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue35() {
    // Arrange, Act and Assert
    assertEquals("\\)\\&&", solrHelperServiceImpl.scrubFacetValue(")&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue36() {
    // Arrange, Act and Assert
    assertEquals("\\)\\||", solrHelperServiceImpl.scrubFacetValue(")||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue37() {
    // Arrange, Act and Assert
    assertEquals("\\)\\\\\\?", solrHelperServiceImpl.scrubFacetValue(")\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue38() {
    // Arrange, Act and Assert
    assertEquals("\\)\\}", solrHelperServiceImpl.scrubFacetValue(")}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue39() {
    // Arrange, Act and Assert
    assertEquals("\\)\\]", solrHelperServiceImpl.scrubFacetValue(")]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue40() {
    // Arrange, Act and Assert
    assertEquals("\\)\\[", solrHelperServiceImpl.scrubFacetValue(")["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue41() {
    // Arrange, Act and Assert
    assertEquals("\\:\\\\\\?", solrHelperServiceImpl.scrubFacetValue(":\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue42() {
    // Arrange, Act and Assert
    assertEquals("\\{\\&&", solrHelperServiceImpl.scrubFacetValue("{&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue43() {
    // Arrange, Act and Assert
    assertEquals("\\{\\||", solrHelperServiceImpl.scrubFacetValue("{||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue44() {
    // Arrange, Act and Assert
    assertEquals("\\{\\\\\\?", solrHelperServiceImpl.scrubFacetValue("{\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue45() {
    // Arrange, Act and Assert
    assertEquals("\\{\\}", solrHelperServiceImpl.scrubFacetValue("{}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue46() {
    // Arrange, Act and Assert
    assertEquals("\\{\\]", solrHelperServiceImpl.scrubFacetValue("{]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue47() {
    // Arrange, Act and Assert
    assertEquals("\\{\\[", solrHelperServiceImpl.scrubFacetValue("{["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue48() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\\\", solrHelperServiceImpl.scrubFacetValue("\\?\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue49() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\+", solrHelperServiceImpl.scrubFacetValue("\\?+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue50() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\-", solrHelperServiceImpl.scrubFacetValue("\\?-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue51() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\&&", solrHelperServiceImpl.scrubFacetValue("\\?&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue52() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\||", solrHelperServiceImpl.scrubFacetValue("\\?||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue53() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\!", solrHelperServiceImpl.scrubFacetValue("\\?!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue54() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\(", solrHelperServiceImpl.scrubFacetValue("\\?("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue55() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\*", solrHelperServiceImpl.scrubFacetValue("\\?*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue56() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\)", solrHelperServiceImpl.scrubFacetValue("\\?)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue57() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\:", solrHelperServiceImpl.scrubFacetValue("\\?:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue58() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\{", solrHelperServiceImpl.scrubFacetValue("\\?{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue59() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\\\\\?", solrHelperServiceImpl.scrubFacetValue("\\?\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue60() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\}", solrHelperServiceImpl.scrubFacetValue("\\?}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue61() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\]", solrHelperServiceImpl.scrubFacetValue("\\?]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue62() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?\\[", solrHelperServiceImpl.scrubFacetValue("\\?["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue63() {
    // Arrange, Act and Assert
    assertEquals("\\}\\&&", solrHelperServiceImpl.scrubFacetValue("}&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue64() {
    // Arrange, Act and Assert
    assertEquals("\\}\\||", solrHelperServiceImpl.scrubFacetValue("}||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue65() {
    // Arrange, Act and Assert
    assertEquals("\\}\\)", solrHelperServiceImpl.scrubFacetValue("})"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue66() {
    // Arrange, Act and Assert
    assertEquals("\\}\\{", solrHelperServiceImpl.scrubFacetValue("}{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue67() {
    // Arrange, Act and Assert
    assertEquals("\\}\\\\\\?", solrHelperServiceImpl.scrubFacetValue("}\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue68() {
    // Arrange, Act and Assert
    assertEquals("\\}\\}", solrHelperServiceImpl.scrubFacetValue("}}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue69() {
    // Arrange, Act and Assert
    assertEquals("\\}\\]", solrHelperServiceImpl.scrubFacetValue("}]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue70() {
    // Arrange, Act and Assert
    assertEquals("\\}\\[", solrHelperServiceImpl.scrubFacetValue("}["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue71() {
    // Arrange, Act and Assert
    assertEquals("\\]\\&&", solrHelperServiceImpl.scrubFacetValue("]&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue72() {
    // Arrange, Act and Assert
    assertEquals("\\]\\||", solrHelperServiceImpl.scrubFacetValue("]||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue73() {
    // Arrange, Act and Assert
    assertEquals("\\]\\!", solrHelperServiceImpl.scrubFacetValue("]!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue74() {
    // Arrange, Act and Assert
    assertEquals("\\]\\(", solrHelperServiceImpl.scrubFacetValue("]("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue75() {
    // Arrange, Act and Assert
    assertEquals("\\]\\)", solrHelperServiceImpl.scrubFacetValue("])"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue76() {
    // Arrange, Act and Assert
    assertEquals("\\]\\{", solrHelperServiceImpl.scrubFacetValue("]{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue77() {
    // Arrange, Act and Assert
    assertEquals("\\]\\\\\\?", solrHelperServiceImpl.scrubFacetValue("]\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue78() {
    // Arrange, Act and Assert
    assertEquals("\\]\\}", solrHelperServiceImpl.scrubFacetValue("]}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \&&\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\*", solrHelperServiceImpl.scrubFacetValue("&&*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \&&\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\\\", solrHelperServiceImpl.scrubFacetValue("&&\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \&&\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\:", solrHelperServiceImpl.scrubFacetValue("&&:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \&&\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\-", solrHelperServiceImpl.scrubFacetValue("&&-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \&&\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\&&\\+", solrHelperServiceImpl.scrubFacetValue("&&+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("\\*\\&&", solrHelperServiceImpl.scrubFacetValue("*&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\*\\*", solrHelperServiceImpl.scrubFacetValue("**"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\*\\\\", solrHelperServiceImpl.scrubFacetValue("*\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\*\\!", solrHelperServiceImpl.scrubFacetValue("*!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\*\\{", solrHelperServiceImpl.scrubFacetValue("*{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\*\\(", solrHelperServiceImpl.scrubFacetValue("*("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\*\\[", solrHelperServiceImpl.scrubFacetValue("*["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\*\\+", solrHelperServiceImpl.scrubFacetValue("*+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\*\\}", solrHelperServiceImpl.scrubFacetValue("*}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\*\\)", solrHelperServiceImpl.scrubFacetValue("*)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\*\\]", solrHelperServiceImpl.scrubFacetValue("*]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*\||}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("\\*\\||", solrHelperServiceImpl.scrubFacetValue("*||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\&&", solrHelperServiceImpl.scrubFacetValue("\\&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\*", solrHelperServiceImpl.scrubFacetValue("\\*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\\", solrHelperServiceImpl.scrubFacetValue("\\\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\:", solrHelperServiceImpl.scrubFacetValue("\\:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\!", solrHelperServiceImpl.scrubFacetValue("\\!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\{", solrHelperServiceImpl.scrubFacetValue("\\{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\(", solrHelperServiceImpl.scrubFacetValue("\\("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\[", solrHelperServiceImpl.scrubFacetValue("\\["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\+", solrHelperServiceImpl.scrubFacetValue("\\+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\?}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?", solrHelperServiceImpl.scrubFacetValue("\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\}", solrHelperServiceImpl.scrubFacetValue("\\}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\)", solrHelperServiceImpl.scrubFacetValue("\\)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\]", solrHelperServiceImpl.scrubFacetValue("\\]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("\\:\\&&", solrHelperServiceImpl.scrubFacetValue(":&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\:\\\\", solrHelperServiceImpl.scrubFacetValue(":\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\:\\!", solrHelperServiceImpl.scrubFacetValue(":!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\:\\{", solrHelperServiceImpl.scrubFacetValue(":{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\:\\(", solrHelperServiceImpl.scrubFacetValue(":("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\:\\[", solrHelperServiceImpl.scrubFacetValue(":["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\:\\}", solrHelperServiceImpl.scrubFacetValue(":}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\:\\)", solrHelperServiceImpl.scrubFacetValue(":)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\:\\]", solrHelperServiceImpl.scrubFacetValue(":]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:\||}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashColonBackslashVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("\\:\\||", solrHelperServiceImpl.scrubFacetValue(":||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("\\-\\&&", solrHelperServiceImpl.scrubFacetValue("-&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\-\\!", solrHelperServiceImpl.scrubFacetValue("-!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\-\\{", solrHelperServiceImpl.scrubFacetValue("-{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\-\\(", solrHelperServiceImpl.scrubFacetValue("-("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\-\\[", solrHelperServiceImpl.scrubFacetValue("-["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\-\\}", solrHelperServiceImpl.scrubFacetValue("-}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\-\\)", solrHelperServiceImpl.scrubFacetValue("-)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\-\\]", solrHelperServiceImpl.scrubFacetValue("-]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-\||}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashDashBackslashVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("\\-\\||", solrHelperServiceImpl.scrubFacetValue("-||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\!\\*", solrHelperServiceImpl.scrubFacetValue("!*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\!\\\\", solrHelperServiceImpl.scrubFacetValue("!\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\!\\:", solrHelperServiceImpl.scrubFacetValue("!:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\!\\-", solrHelperServiceImpl.scrubFacetValue("!-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\!\\!", solrHelperServiceImpl.scrubFacetValue("!!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\!\\{", solrHelperServiceImpl.scrubFacetValue("!{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\!\\(", solrHelperServiceImpl.scrubFacetValue("!("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\!\\[", solrHelperServiceImpl.scrubFacetValue("!["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\!\\+", solrHelperServiceImpl.scrubFacetValue("!+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\!\\}", solrHelperServiceImpl.scrubFacetValue("!}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\!\\)", solrHelperServiceImpl.scrubFacetValue("!)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\{\\*", solrHelperServiceImpl.scrubFacetValue("{*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\{\\\\", solrHelperServiceImpl.scrubFacetValue("{\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\{\\:", solrHelperServiceImpl.scrubFacetValue("{:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\{\\-", solrHelperServiceImpl.scrubFacetValue("{-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\{\\!", solrHelperServiceImpl.scrubFacetValue("{!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\{\\{", solrHelperServiceImpl.scrubFacetValue("{{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\{\\(", solrHelperServiceImpl.scrubFacetValue("{("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\{\\+", solrHelperServiceImpl.scrubFacetValue("{+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\{\\)", solrHelperServiceImpl.scrubFacetValue("{)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\(\\*", solrHelperServiceImpl.scrubFacetValue("(*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\(\\\\", solrHelperServiceImpl.scrubFacetValue("(\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\(\\:", solrHelperServiceImpl.scrubFacetValue("(:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\(\\-", solrHelperServiceImpl.scrubFacetValue("(-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\(\\!", solrHelperServiceImpl.scrubFacetValue("(!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\(\\{", solrHelperServiceImpl.scrubFacetValue("({"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\(\\(", solrHelperServiceImpl.scrubFacetValue("(("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\(\\[", solrHelperServiceImpl.scrubFacetValue("(["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\(\\+", solrHelperServiceImpl.scrubFacetValue("(+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\(\\}", solrHelperServiceImpl.scrubFacetValue("(}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\(\\)", solrHelperServiceImpl.scrubFacetValue("()"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("\\+\\&&", solrHelperServiceImpl.scrubFacetValue("+&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\+\\*", solrHelperServiceImpl.scrubFacetValue("+*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\+\\\\", solrHelperServiceImpl.scrubFacetValue("+\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\+\\!", solrHelperServiceImpl.scrubFacetValue("+!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\+\\{", solrHelperServiceImpl.scrubFacetValue("+{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\+\\(", solrHelperServiceImpl.scrubFacetValue("+("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\+\\[", solrHelperServiceImpl.scrubFacetValue("+["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\+\\+", solrHelperServiceImpl.scrubFacetValue("++"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\+\\}", solrHelperServiceImpl.scrubFacetValue("+}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\+\\)", solrHelperServiceImpl.scrubFacetValue("+)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\+\\]", solrHelperServiceImpl.scrubFacetValue("+]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+\||}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("\\+\\||", solrHelperServiceImpl.scrubFacetValue("+||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\}\\*", solrHelperServiceImpl.scrubFacetValue("}*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\}\\\\", solrHelperServiceImpl.scrubFacetValue("}\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\}\\:", solrHelperServiceImpl.scrubFacetValue("}:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\}\\-", solrHelperServiceImpl.scrubFacetValue("}-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\}\\!", solrHelperServiceImpl.scrubFacetValue("}!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\}\\(", solrHelperServiceImpl.scrubFacetValue("}("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\}\\+", solrHelperServiceImpl.scrubFacetValue("}+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\)\\*", solrHelperServiceImpl.scrubFacetValue(")*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\)\\\\", solrHelperServiceImpl.scrubFacetValue(")\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\)\\:", solrHelperServiceImpl.scrubFacetValue("):"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\)\\-", solrHelperServiceImpl.scrubFacetValue(")-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\)\\!", solrHelperServiceImpl.scrubFacetValue(")!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\)\\{", solrHelperServiceImpl.scrubFacetValue("){"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\)\\(", solrHelperServiceImpl.scrubFacetValue(")("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\)\\+", solrHelperServiceImpl.scrubFacetValue(")+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\)\\)", solrHelperServiceImpl.scrubFacetValue("))"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \]\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\]\\*", solrHelperServiceImpl.scrubFacetValue("]*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \]\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\]\\\\", solrHelperServiceImpl.scrubFacetValue("]\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \]\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\]\\:", solrHelperServiceImpl.scrubFacetValue("]:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \]\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\]\\-", solrHelperServiceImpl.scrubFacetValue("]-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \]\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\]\\+", solrHelperServiceImpl.scrubFacetValue("]+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \||}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("\\||", solrHelperServiceImpl.scrubFacetValue("||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \||\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\||\\*", solrHelperServiceImpl.scrubFacetValue("||*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \||\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\||\\:", solrHelperServiceImpl.scrubFacetValue("||:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \||\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\||\\-", solrHelperServiceImpl.scrubFacetValue("||-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \||\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\||\\+", solrHelperServiceImpl.scrubFacetValue("||+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("\\exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \+exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\+exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("+exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \-exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled3() {
    // Arrange, Act and Assert
    assertEquals(
        "\\-exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("-exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \&&exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled4() {
    // Arrange, Act and Assert
    assertEquals(
        "\\&&exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("&&exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \||exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled5() {
    // Arrange, Act and Assert
    assertEquals(
        "\\||exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("||exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled6() {
    // Arrange, Act and Assert
    assertEquals(
        "\\!exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("!exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \(exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled7() {
    // Arrange, Act and Assert
    assertEquals(
        "\\(exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("(exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled8() {
    // Arrange, Act and Assert
    assertEquals(
        "\\*exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("*exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \)exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled9() {
    // Arrange, Act and Assert
    assertEquals(
        "\\)exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue(")exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled10() {
    // Arrange, Act and Assert
    assertEquals(
        "\\:exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue(":exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{exploitProtection.xssEnabled}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled11() {
    // Arrange, Act and Assert
    assertEquals(
        "\\{exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("{exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\?exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled12() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\?exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("\\?exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code \}exploitProtection.xssEnabled}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled13() {
    // Arrange, Act and Assert
    assertEquals(
        "\\}exploitProtection.xssEnabled",
        solrHelperServiceImpl.scrubFacetValue("}exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", solrHelperServiceImpl.scrubFacetValue("42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42\}.
   *   <li>Then return {@code 42\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42\\\\", solrHelperServiceImpl.scrubFacetValue("42\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42+}.
   *   <li>Then return {@code 42\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42\\+", solrHelperServiceImpl.scrubFacetValue("42+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42-}.
   *   <li>Then return {@code 42\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42\\-", solrHelperServiceImpl.scrubFacetValue("42-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42&&}.
   *   <li>Then return {@code 42\&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42\\&&", solrHelperServiceImpl.scrubFacetValue("42&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42||}.
   *   <li>Then return {@code 42\||}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("42\\||", solrHelperServiceImpl.scrubFacetValue("42||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42!}.
   *   <li>Then return {@code 42\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42\\!", solrHelperServiceImpl.scrubFacetValue("42!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42(}.
   *   <li>Then return {@code 42\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("42\\(", solrHelperServiceImpl.scrubFacetValue("42("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42*}.
   *   <li>Then return {@code 42\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("42\\*", solrHelperServiceImpl.scrubFacetValue("42*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42)}.
   *   <li>Then return {@code 42\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4210() {
    // Arrange, Act and Assert
    assertEquals("42\\)", solrHelperServiceImpl.scrubFacetValue("42)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42:}.
   *   <li>Then return {@code 42\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4211() {
    // Arrange, Act and Assert
    assertEquals("42\\:", solrHelperServiceImpl.scrubFacetValue("42:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code 42{}.</li>
   *   <li>Then return {@code 42\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4212() {
    // Arrange, Act and Assert
    assertEquals("42\\{", solrHelperServiceImpl.scrubFacetValue("42{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42\?}.
   *   <li>Then return {@code 42\\\?}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4213() {
    // Arrange, Act and Assert
    assertEquals("42\\\\\\?", solrHelperServiceImpl.scrubFacetValue("42\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}}.
   *   <li>Then return {@code 42\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4214() {
    // Arrange, Act and Assert
    assertEquals("42\\}", solrHelperServiceImpl.scrubFacetValue("42}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42]}.
   *   <li>Then return {@code 42\]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4215() {
    // Arrange, Act and Assert
    assertEquals("42\\]", solrHelperServiceImpl.scrubFacetValue("42]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42[}.
   *   <li>Then return {@code 42\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4216() {
    // Arrange, Act and Assert
    assertEquals("42\\[", solrHelperServiceImpl.scrubFacetValue("42["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \42}.
   *   <li>Then return {@code \\42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4217() {
    // Arrange, Act and Assert
    assertEquals("\\\\42", solrHelperServiceImpl.scrubFacetValue("\\42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code +42}.
   *   <li>Then return {@code \+42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4218() {
    // Arrange, Act and Assert
    assertEquals("\\+42", solrHelperServiceImpl.scrubFacetValue("+42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return {@code \-42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4219() {
    // Arrange, Act and Assert
    assertEquals("\\-42", solrHelperServiceImpl.scrubFacetValue("-42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code &&42}.
   *   <li>Then return {@code \&&42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4220() {
    // Arrange, Act and Assert
    assertEquals("\\&&42", solrHelperServiceImpl.scrubFacetValue("&&42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code ||42}.
   *   <li>Then return {@code \||42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4221() {
    // Arrange, Act and Assert
    assertEquals("\\||42", solrHelperServiceImpl.scrubFacetValue("||42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code !42}.
   *   <li>Then return {@code \!42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4222() {
    // Arrange, Act and Assert
    assertEquals("\\!42", solrHelperServiceImpl.scrubFacetValue("!42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code (42}.
   *   <li>Then return {@code \(42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4223() {
    // Arrange, Act and Assert
    assertEquals("\\(42", solrHelperServiceImpl.scrubFacetValue("(42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code *42}.
   *   <li>Then return {@code \*42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4224() {
    // Arrange, Act and Assert
    assertEquals("\\*42", solrHelperServiceImpl.scrubFacetValue("*42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code )42}.
   *   <li>Then return {@code \)42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4225() {
    // Arrange, Act and Assert
    assertEquals("\\)42", solrHelperServiceImpl.scrubFacetValue(")42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code :42}.
   *   <li>Then return {@code \:42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4226() {
    // Arrange, Act and Assert
    assertEquals("\\:42", solrHelperServiceImpl.scrubFacetValue(":42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code {42}.</li>
   *   <li>Then return {@code \{42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4227() {
    // Arrange, Act and Assert
    assertEquals("\\{42", solrHelperServiceImpl.scrubFacetValue("{42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \?42}.
   *   <li>Then return {@code \\\?42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4228() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?42", solrHelperServiceImpl.scrubFacetValue("\\?42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code }42}.
   *   <li>Then return {@code \}42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4229() {
    // Arrange, Act and Assert
    assertEquals("\\}42", solrHelperServiceImpl.scrubFacetValue("}42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code ]42}.
   *   <li>Then return {@code \]42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_when42_thenReturn4230() {
    // Arrange, Act and Assert
    assertEquals("\\]42", solrHelperServiceImpl.scrubFacetValue("]42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return {@code \&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenAmpersandAmpersand_thenReturnBackslashAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("\\&&", solrHelperServiceImpl.scrubFacetValue("&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code *:}.
   *   <li>Then return {@code \*\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenAsteriskColon_thenReturnBackslashAsteriskBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\*\\:", solrHelperServiceImpl.scrubFacetValue("*:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code *-}.
   *   <li>Then return {@code \*\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenAsteriskDash_thenReturnBackslashAsteriskBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\*\\-", solrHelperServiceImpl.scrubFacetValue("*-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return {@code \*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenAsterisk_thenReturnBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\*", solrHelperServiceImpl.scrubFacetValue("*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \-}.
   *   <li>Then return {@code \\\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenBackslashDash_thenReturnBackslashBackslashBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\-", solrHelperServiceImpl.scrubFacetValue("\\-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \}.
   *   <li>Then return {@code \\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenBackslash_thenReturnBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\\\", solrHelperServiceImpl.scrubFacetValue("\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code :*}.
   *   <li>Then return {@code \:\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenColonAsterisk_thenReturnBackslashColonBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\:\\*", solrHelperServiceImpl.scrubFacetValue(":*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code ::}.
   *   <li>Then return {@code \:\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenColonColon_thenReturnBackslashColonBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\:\\:", solrHelperServiceImpl.scrubFacetValue("::"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code :-}.
   *   <li>Then return {@code \:\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenColonDash_thenReturnBackslashColonBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\:\\-", solrHelperServiceImpl.scrubFacetValue(":-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code :+}.
   *   <li>Then return {@code \:\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenColonPlusSign_thenReturnBackslashColonBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\:\\+", solrHelperServiceImpl.scrubFacetValue(":+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return {@code \:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenColon_thenReturnBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\:", solrHelperServiceImpl.scrubFacetValue(":"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -*}.
   *   <li>Then return {@code \-\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDashAsterisk_thenReturnBackslashDashBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\-\\*", solrHelperServiceImpl.scrubFacetValue("-*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -\}.
   *   <li>Then return {@code \-\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDashBackslash_thenReturnBackslashDashBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\-\\\\", solrHelperServiceImpl.scrubFacetValue("-\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -:}.
   *   <li>Then return {@code \-\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDashColon_thenReturnBackslashDashBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\-\\:", solrHelperServiceImpl.scrubFacetValue("-:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code --}.
   *   <li>Then return {@code \-\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDashDash_thenReturnBackslashDashBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\-\\-", solrHelperServiceImpl.scrubFacetValue("--"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -+}.
   *   <li>Then return {@code \-\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDashPlusSign_thenReturnBackslashDashBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\-\\+", solrHelperServiceImpl.scrubFacetValue("-+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code \-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDash_thenReturnBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\-", solrHelperServiceImpl.scrubFacetValue("-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \desc}.
   *   <li>Then return {@code \\desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc() {
    // Arrange, Act and Assert
    assertEquals("\\\\desc", solrHelperServiceImpl.scrubFacetValue("\\desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code +desc}.
   *   <li>Then return {@code \+desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc2() {
    // Arrange, Act and Assert
    assertEquals("\\+desc", solrHelperServiceImpl.scrubFacetValue("+desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -desc}.
   *   <li>Then return {@code \-desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc3() {
    // Arrange, Act and Assert
    assertEquals("\\-desc", solrHelperServiceImpl.scrubFacetValue("-desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code &&desc}.
   *   <li>Then return {@code \&&desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc4() {
    // Arrange, Act and Assert
    assertEquals("\\&&desc", solrHelperServiceImpl.scrubFacetValue("&&desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code ||desc}.
   *   <li>Then return {@code \||desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc5() {
    // Arrange, Act and Assert
    assertEquals("\\||desc", solrHelperServiceImpl.scrubFacetValue("||desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code !desc}.
   *   <li>Then return {@code \!desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc6() {
    // Arrange, Act and Assert
    assertEquals("\\!desc", solrHelperServiceImpl.scrubFacetValue("!desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code (desc}.
   *   <li>Then return {@code \(desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc7() {
    // Arrange, Act and Assert
    assertEquals("\\(desc", solrHelperServiceImpl.scrubFacetValue("(desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code *desc}.
   *   <li>Then return {@code \*desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc8() {
    // Arrange, Act and Assert
    assertEquals("\\*desc", solrHelperServiceImpl.scrubFacetValue("*desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code )desc}.
   *   <li>Then return {@code \)desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc9() {
    // Arrange, Act and Assert
    assertEquals("\\)desc", solrHelperServiceImpl.scrubFacetValue(")desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code :desc}.
   *   <li>Then return {@code \:desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc10() {
    // Arrange, Act and Assert
    assertEquals("\\:desc", solrHelperServiceImpl.scrubFacetValue(":desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code {desc}.</li>
   *   <li>Then return {@code \{desc}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc11() {
    // Arrange, Act and Assert
    assertEquals("\\{desc", solrHelperServiceImpl.scrubFacetValue("{desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \?desc}.
   *   <li>Then return {@code \\\?desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc12() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?desc", solrHelperServiceImpl.scrubFacetValue("\\?desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code }desc}.
   *   <li>Then return {@code \}desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenDesc_thenReturnDesc13() {
    // Arrange, Act and Assert
    assertEquals("\\}desc", solrHelperServiceImpl.scrubFacetValue("}desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code !}.
   *   <li>Then return {@code \!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenExclamationMark_thenReturnBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\!", solrHelperServiceImpl.scrubFacetValue("!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \Facet Value}.
   *   <li>Then return {@code \\Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue() {
    // Arrange, Act and Assert
    assertEquals("\\\\Facet Value", solrHelperServiceImpl.scrubFacetValue("\\Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code +Facet Value}.
   *   <li>Then return {@code \+Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue2() {
    // Arrange, Act and Assert
    assertEquals("\\+Facet Value", solrHelperServiceImpl.scrubFacetValue("+Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code -Facet Value}.
   *   <li>Then return {@code \-Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue3() {
    // Arrange, Act and Assert
    assertEquals("\\-Facet Value", solrHelperServiceImpl.scrubFacetValue("-Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code &&Facet Value}.
   *   <li>Then return {@code \&&Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue4() {
    // Arrange, Act and Assert
    assertEquals("\\&&Facet Value", solrHelperServiceImpl.scrubFacetValue("&&Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code ||Facet Value}.
   *   <li>Then return {@code \||Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue5() {
    // Arrange, Act and Assert
    assertEquals("\\||Facet Value", solrHelperServiceImpl.scrubFacetValue("||Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code !Facet Value}.
   *   <li>Then return {@code \!Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue6() {
    // Arrange, Act and Assert
    assertEquals("\\!Facet Value", solrHelperServiceImpl.scrubFacetValue("!Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value\}.
   *   <li>Then return {@code Facet Value\\}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue7() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\\\", solrHelperServiceImpl.scrubFacetValue("Facet Value\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value+}.
   *   <li>Then return {@code Facet Value\+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue8() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\+", solrHelperServiceImpl.scrubFacetValue("Facet Value+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value-}.
   *   <li>Then return {@code Facet Value\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue9() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\-", solrHelperServiceImpl.scrubFacetValue("Facet Value-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value&&}.
   *   <li>Then return {@code Facet Value\&&}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue10() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\&&", solrHelperServiceImpl.scrubFacetValue("Facet Value&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value||}.
   *   <li>Then return {@code Facet Value\||}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue11() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\||", solrHelperServiceImpl.scrubFacetValue("Facet Value||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value!}.
   *   <li>Then return {@code Facet Value\!}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue12() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\!", solrHelperServiceImpl.scrubFacetValue("Facet Value!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value(}.
   *   <li>Then return {@code Facet Value\(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue13() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\(", solrHelperServiceImpl.scrubFacetValue("Facet Value("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value*}.
   *   <li>Then return {@code Facet Value\*}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue14() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\*", solrHelperServiceImpl.scrubFacetValue("Facet Value*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value)}.
   *   <li>Then return {@code Facet Value\)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue15() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\)", solrHelperServiceImpl.scrubFacetValue("Facet Value)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value:}.
   *   <li>Then return {@code Facet Value\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue16() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\:", solrHelperServiceImpl.scrubFacetValue("Facet Value:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code Facet Value{}.</li>
   *   <li>Then return {@code Facet Value\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue17() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\{", solrHelperServiceImpl.scrubFacetValue("Facet Value{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value\?}.
   *   <li>Then return {@code Facet Value\\\?}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue18() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\\\\\?", solrHelperServiceImpl.scrubFacetValue("Facet Value\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value}}.
   *   <li>Then return {@code Facet Value\}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue19() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\}", solrHelperServiceImpl.scrubFacetValue("Facet Value}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value]}.
   *   <li>Then return {@code Facet Value\]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue20() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\]", solrHelperServiceImpl.scrubFacetValue("Facet Value]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code Facet Value[}.
   *   <li>Then return {@code Facet Value\[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue21() {
    // Arrange, Act and Assert
    assertEquals("Facet Value\\[", solrHelperServiceImpl.scrubFacetValue("Facet Value["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code (Facet Value}.
   *   <li>Then return {@code \(Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue22() {
    // Arrange, Act and Assert
    assertEquals("\\(Facet Value", solrHelperServiceImpl.scrubFacetValue("(Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code *Facet Value}.
   *   <li>Then return {@code \*Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue23() {
    // Arrange, Act and Assert
    assertEquals("\\*Facet Value", solrHelperServiceImpl.scrubFacetValue("*Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code )Facet Value}.
   *   <li>Then return {@code \)Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue24() {
    // Arrange, Act and Assert
    assertEquals("\\)Facet Value", solrHelperServiceImpl.scrubFacetValue(")Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code :Facet Value}.
   *   <li>Then return {@code \:Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue25() {
    // Arrange, Act and Assert
    assertEquals("\\:Facet Value", solrHelperServiceImpl.scrubFacetValue(":Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code {Facet Value}.</li>
   *   <li>Then return {@code \{Facet Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue26() {
    // Arrange, Act and Assert
    assertEquals("\\{Facet Value", solrHelperServiceImpl.scrubFacetValue("{Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code \?Facet Value}.
   *   <li>Then return {@code \\\?Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue27() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\?Facet Value", solrHelperServiceImpl.scrubFacetValue("\\?Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code }Facet Value}.
   *   <li>Then return {@code \}Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue28() {
    // Arrange, Act and Assert
    assertEquals("\\}Facet Value", solrHelperServiceImpl.scrubFacetValue("}Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code ]Facet Value}.
   *   <li>Then return {@code \]Facet Value}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue29() {
    // Arrange, Act and Assert
    assertEquals("\\]Facet Value", solrHelperServiceImpl.scrubFacetValue("]Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   *   <li>Then return {@code \{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenLeftCurlyBracket_thenReturnBackslashLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\{", solrHelperServiceImpl.scrubFacetValue("{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then return {@code \(}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenLeftParenthesis_thenReturnBackslashLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\(", solrHelperServiceImpl.scrubFacetValue("("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code [}.
   *   <li>Then return {@code \[}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenLeftSquareBracket_thenReturnBackslashLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\[", solrHelperServiceImpl.scrubFacetValue("["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code +:}.
   *   <li>Then return {@code \+\:}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenPlusSignColon_thenReturnBackslashPlusSignBackslashColon() {
    // Arrange, Act and Assert
    assertEquals("\\+\\:", solrHelperServiceImpl.scrubFacetValue("+:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code +-}.
   *   <li>Then return {@code \+\-}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenPlusSignDash_thenReturnBackslashPlusSignBackslashDash() {
    // Arrange, Act and Assert
    assertEquals("\\+\\-", solrHelperServiceImpl.scrubFacetValue("+-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code +}.
   *   <li>Then return {@code \+}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenPlusSign_thenReturnBackslashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("\\+", solrHelperServiceImpl.scrubFacetValue("+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code }}.
   *   <li>Then return {@code \}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenRightCurlyBracket_thenReturnBackslashRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("\\}", solrHelperServiceImpl.scrubFacetValue("}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@code \)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenRightParenthesis_thenReturnBackslashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\)", solrHelperServiceImpl.scrubFacetValue(")"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.scrubFacetValue(String)"})
  public void testScrubFacetValue_whenRightSquareBracket_thenReturnBackslashRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("\\]", solrHelperServiceImpl.scrubFacetValue("]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#sanitizeQuery(String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#sanitizeQuery(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.sanitizeQuery(String)"})
  public void testSanitizeQuery() {
    // Arrange, Act and Assert
    assertEquals("Query", solrHelperServiceImpl.sanitizeQuery("Query"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RequiredFacetImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SolrHelperServiceImpl.isFacetAvailable(SearchFacet, Map)"})
  public void testIsFacetAvailable_givenArrayListAddRequiredFacetImpl_thenReturnFalse() {
    // Arrange
    ArrayList<RequiredFacet> requiredFacets = new ArrayList<>();
    requiredFacets.add(new RequiredFacetImpl());

    SearchFacetImpl facet = new SearchFacetImpl();
    facet.setCanMultiselect(true);
    facet.setFieldType(new IndexFieldTypeImpl());
    facet.setId(1L);
    facet.setLabel("Label");
    facet.setName("Name");
    facet.setRequiresAllDependentFacets(true);
    facet.setSearchDisplayPriority(1);
    facet.setSearchFacetRanges(new ArrayList<>());
    facet.setShowOnSearch(true);
    facet.setUseFacetRanges(true);
    facet.setRequiredFacets(requiredFacets);

    // Act and Assert
    assertFalse(solrHelperServiceImpl.isFacetAvailable(facet, null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RequiredFacetImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SolrHelperServiceImpl.isFacetAvailable(SearchFacet, Map)"})
  public void testIsFacetAvailable_givenArrayListAddRequiredFacetImpl_thenReturnFalse2() {
    // Arrange
    ArrayList<RequiredFacet> requiredFacets = new ArrayList<>();
    requiredFacets.add(new RequiredFacetImpl());

    SearchFacetImpl facet = new SearchFacetImpl();
    facet.setCanMultiselect(true);
    facet.setFieldType(new IndexFieldTypeImpl());
    facet.setId(1L);
    facet.setLabel("Label");
    facet.setName("Name");
    facet.setRequiresAllDependentFacets(true);
    facet.setSearchDisplayPriority(1);
    facet.setSearchFacetRanges(new ArrayList<>());
    facet.setShowOnSearch(true);
    facet.setUseFacetRanges(true);
    facet.setRequiredFacets(requiredFacets);

    // Act and Assert
    assertFalse(solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link SearchFacetImpl} (default constructor) RequiredFacets is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SolrHelperServiceImpl.isFacetAvailable(SearchFacet, Map)"})
  public void testIsFacetAvailable_givenNull_whenSearchFacetImplRequiredFacetsIsNull() {
    // Arrange
    SearchFacetImpl facet = new SearchFacetImpl();
    facet.setCanMultiselect(true);
    facet.setFieldType(new IndexFieldTypeImpl());
    facet.setId(1L);
    facet.setLabel("Label");
    facet.setName("Name");
    facet.setRequiresAllDependentFacets(true);
    facet.setSearchDisplayPriority(1);
    facet.setSearchFacetRanges(new ArrayList<>());
    facet.setShowOnSearch(true);
    facet.setUseFacetRanges(true);
    facet.setRequiredFacets(null);

    // Act and Assert
    assertTrue(solrHelperServiceImpl.isFacetAvailable(facet, null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   *
   * <ul>
   *   <li>When {@link SearchFacetImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SolrHelperServiceImpl.isFacetAvailable(SearchFacet, Map)"})
  public void testIsFacetAvailable_whenSearchFacetImpl_thenReturnTrue() {
    // Arrange
    SearchFacetImpl facet = new SearchFacetImpl();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@code Field Name:[2.3 TO 2.3]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrRangeString(String, BigDecimal, BigDecimal)"
  })
  public void testGetSolrRangeString_whenBigDecimalWith23_thenReturnFieldName23To23() {
    // Arrange
    BigDecimal minValue = new BigDecimal("2.3");

    // Act and Assert
    assertEquals(
        "Field Name:[2.3 TO 2.3]",
        solrHelperServiceImpl.getSolrRangeString("Field Name", minValue, new BigDecimal("2.3")));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Field Name:[* TO *]}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrRangeString(String, BigDecimal, BigDecimal)"
  })
  public void testGetSolrRangeString_whenNull_thenReturnFieldNameTo() {
    // Arrange, Act and Assert
    assertEquals(
        "Field Name:[* TO *]", solrHelperServiceImpl.getSolrRangeString("Field Name", null, null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}.
   *
   * <ul>
   *   <li>Then return {@code frange incl=false l=2.3 u=2.3}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrRangeFunctionString(BigDecimal, BigDecimal)"
  })
  public void testGetSolrRangeFunctionString_thenReturnFrangeInclFalseL23U23() {
    // Arrange
    BigDecimal minValue = new BigDecimal("2.3");

    // Act
    String actualSolrRangeFunctionString =
        solrHelperServiceImpl.getSolrRangeFunctionString(minValue, new BigDecimal("2.3"));

    // Assert
    assertEquals("frange incl=false l=2.3 u=2.3", actualSolrRangeFunctionString);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code frange incl=false l=2.3}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrRangeFunctionString(BigDecimal, BigDecimal)"
  })
  public void testGetSolrRangeFunctionString_whenNull_thenReturnFrangeInclFalseL23() {
    // Arrange, Act and Assert
    assertEquals(
        "frange incl=false l=2.3",
        solrHelperServiceImpl.getSolrRangeFunctionString(new BigDecimal("2.3"), null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>Then return {@code {!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldTag(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrFieldTag(String, String, SearchFacetRange)"
  })
  public void testGetSolrFieldTag_thenReturnExFieldNameParamFieldName23FrangeInclFalseL23() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals(
        "{!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}",
        solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>Then return {@code {!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3
   *       u=2.3}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldTag(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrFieldTag(String, String, SearchFacetRange)"
  })
  public void testGetSolrFieldTag_thenReturnExFieldNameParamFieldName2323FrangeInclFalseL23U23() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(
        "{!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When {@code Param}.
   *   <li>Then return {@code {!Param=Field Name}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldTag(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrFieldTag(String, String, SearchFacetRange)"
  })
  public void testGetSolrFieldTag_whenParam_thenReturnParamFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "{!Param=Field Name}", solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldTag(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrFieldTag(String, String, SearchFacetRange)"
  })
  public void testGetSolrFieldTag_whenSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", solrHelperServiceImpl.getSolrFieldTag(" ", " ", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldTag(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrFieldTag(String, String, SearchFacetRange)"
  })
  public void testGetSolrFieldTag_whenSpace_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", solrHelperServiceImpl.getSolrFieldTag(null, " ", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldTag(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrFieldTag(String, String, SearchFacetRange)"
  })
  public void testGetSolrFieldTag_whenSpace_thenReturnEmptyString3() {
    // Arrange, Act and Assert
    assertEquals("", solrHelperServiceImpl.getSolrFieldTag("Field Name", " ", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code {!ex=Field Name}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.buildSolrFacetField(String, String)"})
  public void testBuildSolrFacetField_whenNull_thenReturnExFieldName() {
    // Arrange, Act and Assert
    assertEquals("{!ex=Field Name}", solrHelperServiceImpl.buildSolrFacetField("Field Name", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}.
   *
   * <ul>
   *   <li>When {@code Param}.
   *   <li>Then return {@code {!Param=Field Name}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.buildSolrFacetField(String, String)"})
  public void testBuildSolrFacetField_whenParam_thenReturnParamFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "{!Param=Field Name}", solrHelperServiceImpl.buildSolrFacetField("Field Name", "Param"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@code {!ex=Field Name}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrHelperServiceImpl.buildSolrFacetField(String, String)"})
  public void testBuildSolrFacetField_whenSpace_thenReturnExFieldName() {
    // Arrange, Act and Assert
    assertEquals("{!ex=Field Name}", solrHelperServiceImpl.buildSolrFacetField("Field Name", " "));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#buildSolrFacetQuery(String,
   * SearchFacetRange, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)"
  })
  public void testBuildSolrFacetQuery() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(
        "{!ex=Field Name key=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true, " "));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code {!ex=Field Name key=Field Name[2.3:*] frange incl=false l=2.3}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#buildSolrFacetQuery(String,
   * SearchFacetRange, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)"
  })
  public void testBuildSolrFacetQuery_thenReturnExFieldNameKeyFieldName23FrangeInclFalseL23() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals(
        "{!ex=Field Name key=Field Name[2.3:*] frange incl=false l=2.3}",
        solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true, " "));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code {!ex=Field Name key=Field Name[2.3:*] frange incl=false l=2.3}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#buildSolrFacetQuery(String,
   * SearchFacetRange, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)"
  })
  public void testBuildSolrFacetQuery_thenReturnExFieldNameKeyFieldName23FrangeInclFalseL232() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals(
        "{!ex=Field Name key=Field Name[2.3:*] frange incl=false l=2.3}",
        solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true, null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code {!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#buildSolrFacetQuery(String,
   * SearchFacetRange, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)"
  })
  public void testBuildSolrFacetQuery_thenReturnExFieldNameParamFieldName23FrangeInclFalseL23() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals(
        "{!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}",
        solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true, "Param"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FacetField#FacetField(String)} with n is
   *       {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.setFacetResults(Map, QueryResponse)"})
  public void testSetFacetResults_givenArrayListAddFacetFieldWithNIsFoo() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    ArrayList<FacetField> facetFieldList = new ArrayList<>();
    facetFieldList.add(new FacetField("foo"));

    QueryResponse response = mock(QueryResponse.class);
    when(response.getFacetFields()).thenReturn(facetFieldList);
    when(response.getFacetQuery()).thenReturn(new HashMap<>());

    // Act
    solrHelperServiceImpl.setFacetResults(namedFacetMap, response);

    // Assert
    verify(response, atLeast(1)).getFacetFields();
    verify(response, atLeast(1)).getFacetQuery();
    verify(solrSearchServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link QueryResponse#getFacetFields()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.setFacetResults(Map, QueryResponse)"})
  public void testSetFacetResults_givenArrayList_thenCallsGetFacetFields() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    QueryResponse response = mock(QueryResponse.class);
    when(response.getFacetFields()).thenReturn(new ArrayList<>());
    when(response.getFacetQuery()).thenReturn(new HashMap<>());

    // Act
    solrHelperServiceImpl.setFacetResults(namedFacetMap, response);

    // Assert
    verify(response, atLeast(1)).getFacetFields();
    verify(response, atLeast(1)).getFacetQuery();
    verify(solrSearchServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.setFacetResults(Map, QueryResponse)"})
  public void testSetFacetResults_thenHashMapSizeIsOne() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(false);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(false);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    ArrayList<Count> countList = new ArrayList<>();
    Count count = new Count(new FacetField("foo"), "foo", 1L);
    countList.add(count);

    FacetField facetField = mock(FacetField.class);
    when(facetField.getValues()).thenReturn(countList);
    when(facetField.getName()).thenReturn("foo");

    ArrayList<FacetField> facetFieldList = new ArrayList<>();
    facetFieldList.add(facetField);

    QueryResponse response = mock(QueryResponse.class);
    when(response.getFacetFields()).thenReturn(facetFieldList);
    when(response.getFacetQuery()).thenReturn(new HashMap<>());

    // Act
    solrHelperServiceImpl.setFacetResults(namedFacetMap, response);

    // Assert
    verify(facetField).getName();
    verify(facetField).getValues();
    verify(response, atLeast(1)).getFacetFields();
    verify(response, atLeast(1)).getFacetQuery();
    verify(solrSearchServiceExtensionManager).getProxy();
    assertEquals(1, namedFacetMap.size());
    assertSame(facetValues, namedFacetMap.get("foo").getFacetValues());
  }

  /**
   * Test {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}.
   *
   * <ul>
   *   <li>When {@link QueryResponse#QueryResponse()}.
   *   <li>Then calls {@link SolrSearchServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#setFacetResults(Map, QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.setFacetResults(Map, QueryResponse)"})
  public void testSetFacetResults_whenQueryResponse_thenCallsGetProxy() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl.setFacetResults(namedFacetMap, new QueryResponse());

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrHelperServiceImpl#sortFacetResults(Map)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) MinValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#sortFacetResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.sortFacetResults(Map)"})
  public void testSortFacetResults_givenSearchFacetResultDTOMinValueIsNull() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("42");

    SearchFacetResultDTO searchFacetResultDTO2 = new SearchFacetResultDTO();
    searchFacetResultDTO2.setActive(false);
    searchFacetResultDTO2.setFacet(new SearchFacetImpl());
    searchFacetResultDTO2.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setMinValue(null);
    searchFacetResultDTO2.setQuantity(-1);
    searchFacetResultDTO2.setValue(null);

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO2);
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.sortFacetResults(namedFacetMap);

    // Assert that nothing has changed
    assertEquals(1, namedFacetMap.size());
    List<SearchFacetResultDTO> facetValues2 = namedFacetMap.get("foo").getFacetValues();
    assertEquals(2, facetValues2.size());
    SearchFacetResultDTO getResult = facetValues2.get(1);
    assertEquals("42", getResult.getUnencodedValueKey());
    assertEquals("42", getResult.getValue());
    assertEquals("42", getResult.getValueKey());
    assertEquals(1, getResult.getQuantity().intValue());
    assertTrue(getResult.isActive());
  }

  /**
   * Test {@link SolrHelperServiceImpl#sortFacetResults(Map)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) MinValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#sortFacetResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.sortFacetResults(Map)"})
  public void testSortFacetResults_givenSearchFacetResultDTOMinValueIsNull2() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(null);
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("42");

    SearchFacetResultDTO searchFacetResultDTO2 = new SearchFacetResultDTO();
    searchFacetResultDTO2.setActive(false);
    searchFacetResultDTO2.setFacet(new SearchFacetImpl());
    searchFacetResultDTO2.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setQuantity(-1);
    searchFacetResultDTO2.setValue(null);

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO2);
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.sortFacetResults(namedFacetMap);

    // Assert that nothing has changed
    assertEquals(1, namedFacetMap.size());
    List<SearchFacetResultDTO> facetValues2 = namedFacetMap.get("foo").getFacetValues();
    assertEquals(2, facetValues2.size());
    SearchFacetResultDTO getResult = facetValues2.get(1);
    assertEquals("42", getResult.getUnencodedValueKey());
    assertEquals("42", getResult.getValue());
    assertEquals("42", getResult.getValueKey());
    assertEquals(1, getResult.getQuantity().intValue());
    assertTrue(getResult.isActive());
  }

  /**
   * Test {@link SolrHelperServiceImpl#sortFacetResults(Map)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} FacetValues first UnencodedValueKey is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#sortFacetResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.sortFacetResults(Map)"})
  public void testSortFacetResults_thenHashMapFooFacetValuesFirstUnencodedValueKeyIs42() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("42");

    SearchFacetResultDTO searchFacetResultDTO2 = new SearchFacetResultDTO();
    searchFacetResultDTO2.setActive(false);
    searchFacetResultDTO2.setFacet(new SearchFacetImpl());
    searchFacetResultDTO2.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setQuantity(-1);
    searchFacetResultDTO2.setValue("Value");

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO2);
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.sortFacetResults(namedFacetMap);

    // Assert
    assertEquals(1, namedFacetMap.size());
    List<SearchFacetResultDTO> facetValues2 = namedFacetMap.get("foo").getFacetValues();
    assertEquals(2, facetValues2.size());
    SearchFacetResultDTO getResult = facetValues2.get(0);
    assertEquals("42", getResult.getUnencodedValueKey());
    assertEquals("42", getResult.getValue());
    assertEquals("42", getResult.getValueKey());
    SearchFacetResultDTO getResult2 = facetValues2.get(1);
    assertEquals("Value", getResult2.getUnencodedValueKey());
    assertEquals("Value", getResult2.getValue());
    assertEquals("Value", getResult2.getValueKey());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertFalse(getResult2.isActive());
    assertTrue(getResult.isActive());
  }

  /**
   * Test {@link SolrHelperServiceImpl#sortFacetResults(Map)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} FacetValues second UnencodedValueKey is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#sortFacetResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.sortFacetResults(Map)"})
  public void testSortFacetResults_thenHashMapFooFacetValuesSecondUnencodedValueKeyIs42() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("42");

    SearchFacetResultDTO searchFacetResultDTO2 = new SearchFacetResultDTO();
    searchFacetResultDTO2.setActive(false);
    searchFacetResultDTO2.setFacet(new SearchFacetImpl());
    searchFacetResultDTO2.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setQuantity(-1);
    searchFacetResultDTO2.setValue(null);

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO2);
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.sortFacetResults(namedFacetMap);

    // Assert that nothing has changed
    assertEquals(1, namedFacetMap.size());
    List<SearchFacetResultDTO> facetValues2 = namedFacetMap.get("foo").getFacetValues();
    assertEquals(2, facetValues2.size());
    SearchFacetResultDTO getResult = facetValues2.get(1);
    assertEquals("42", getResult.getUnencodedValueKey());
    assertEquals("42", getResult.getValue());
    assertEquals("42", getResult.getValueKey());
    assertEquals(1, getResult.getQuantity().intValue());
    assertTrue(getResult.isActive());
  }

  /**
   * Test {@link SolrHelperServiceImpl#sortFacetResults(Map)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} FacetValues second ValueKey is {@code
   *       range%5B2.3%3A2.3%5D}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#sortFacetResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.sortFacetResults(Map)"})
  public void testSortFacetResults_thenHashMapFooFacetValuesSecondValueKeyIsRange5b233a235d() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue(null);

    SearchFacetResultDTO searchFacetResultDTO2 = new SearchFacetResultDTO();
    searchFacetResultDTO2.setActive(false);
    searchFacetResultDTO2.setFacet(new SearchFacetImpl());
    searchFacetResultDTO2.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setQuantity(-1);
    searchFacetResultDTO2.setValue("Value");

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO2);
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.sortFacetResults(namedFacetMap);

    // Assert that nothing has changed
    assertEquals(1, namedFacetMap.size());
    List<SearchFacetResultDTO> facetValues2 = namedFacetMap.get("foo").getFacetValues();
    assertEquals(2, facetValues2.size());
    SearchFacetResultDTO getResult = facetValues2.get(1);
    assertEquals("range%5B2.3%3A2.3%5D", getResult.getValueKey());
    assertEquals("range[2.3:2.3]", getResult.getUnencodedValueKey());
    assertEquals(1, getResult.getQuantity().intValue());
    assertTrue(getResult.isActive());
  }

  /**
   * Test {@link SolrHelperServiceImpl#sortFacetResults(Map)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} FacetValues size is three.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#sortFacetResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.sortFacetResults(Map)"})
  public void testSortFacetResults_thenHashMapFooFacetValuesSizeIsThree() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("42");

    SearchFacetResultDTO searchFacetResultDTO2 = new SearchFacetResultDTO();
    searchFacetResultDTO2.setActive(false);
    searchFacetResultDTO2.setFacet(new SearchFacetImpl());
    searchFacetResultDTO2.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO2.setQuantity(-1);
    searchFacetResultDTO2.setValue("Value");

    SearchFacetResultDTO searchFacetResultDTO3 = new SearchFacetResultDTO();
    searchFacetResultDTO3.setActive(true);
    searchFacetResultDTO3.setFacet(new SearchFacetImpl());
    searchFacetResultDTO3.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO3.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO3.setQuantity(-1);
    searchFacetResultDTO3.setValue("");

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO3);
    facetValues.add(searchFacetResultDTO2);
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.sortFacetResults(namedFacetMap);

    // Assert
    assertEquals(1, namedFacetMap.size());
    List<SearchFacetResultDTO> facetValues2 = namedFacetMap.get("foo").getFacetValues();
    assertEquals(3, facetValues2.size());
    SearchFacetResultDTO getResult = facetValues2.get(1);
    assertEquals("42", getResult.getUnencodedValueKey());
    assertEquals("42", getResult.getValue());
    assertEquals("42", getResult.getValueKey());
    SearchFacetResultDTO getResult2 = facetValues2.get(2);
    assertEquals("Value", getResult2.getUnencodedValueKey());
    assertEquals("Value", getResult2.getValue());
    assertEquals("Value", getResult2.getValueKey());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertFalse(getResult2.isActive());
    assertTrue(getResult.isActive());
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)} with {@code
   * query}, {@code namedFacetMap}, {@code searchCriteria}.
   *
   * <ul>
   *   <li>Then calls {@link SolrQuery#addFacetField(String[])}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.attachFacets(SolrQuery, Map, SearchCriteria)"})
  public void testAttachFacetsWithQueryNamedFacetMapSearchCriteria_thenCallsAddFacetField() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    when(searchFacetDao.readSearchFacetRangesForSearchFacet(Mockito.<SearchFacet>any()))
        .thenReturn(new ArrayList<>());

    SolrQuery query = mock(SolrQuery.class);
    when(query.addFacetField((String[]) Mockito.any())).thenReturn(new SolrQuery("foo"));
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.attachFacets(query, namedFacetMap, new SearchCriteria());

    // Assert
    verify(query).addFacetField((String[]) Mockito.any());
    verify(query).setFacet(true);
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(searchFacetDao).readSearchFacetRangesForSearchFacet(isA(SearchFacet.class));
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)} with {@code
   * query}, {@code namedFacetMap}, {@code searchCriteria}.
   *
   * <ul>
   *   <li>Then calls {@link I18nSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String,
   *       SearchFacetDTO, SearchCriteria)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.attachFacets(SolrQuery, Map, SearchCriteria)"})
  public void testAttachFacetsWithQueryNamedFacetMapSearchCriteria_thenCallsAttachFacet() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.attachFacet(
            Mockito.<SolrQuery>any(),
            Mockito.<String>any(),
            Mockito.<SearchFacetDTO>any(),
            Mockito.<SearchCriteria>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    SolrQuery query = mock(SolrQuery.class);
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.attachFacets(query, namedFacetMap, new SearchCriteria());

    // Assert
    verify(query).setFacet(true);
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .attachFacet(
            isA(SolrQuery.class), eq("foo"), isA(SearchFacetDTO.class), isA(SearchCriteria.class));
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)} with {@code
   * query}, {@code namedFacetMap}, {@code searchCriteria}.
   *
   * <ul>
   *   <li>Then calls {@link SolrQuery#setFacet(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.attachFacets(SolrQuery, Map, SearchCriteria)"})
  public void testAttachFacetsWithQueryNamedFacetMapSearchCriteria_thenCallsSetFacet() {
    // Arrange
    SolrQuery query = mock(SolrQuery.class);
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl.attachFacets(query, namedFacetMap, new SearchCriteria());

    // Assert
    verify(query).setFacet(true);
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)} with {@code query}, {@code
   * namedFacetMap}.
   *
   * <ul>
   *   <li>Then calls {@link SolrQuery#addFacetField(String[])}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.attachFacets(SolrQuery, Map)"})
  public void testAttachFacetsWithQueryNamedFacetMap_thenCallsAddFacetField() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    when(searchFacetDao.readSearchFacetRangesForSearchFacet(Mockito.<SearchFacet>any()))
        .thenReturn(new ArrayList<>());

    SolrQuery query = mock(SolrQuery.class);
    when(query.addFacetField((String[]) Mockito.any())).thenReturn(new SolrQuery("foo"));
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.attachFacets(query, namedFacetMap);

    // Assert
    verify(query).addFacetField((String[]) Mockito.any());
    verify(query).setFacet(true);
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(searchFacetDao).readSearchFacetRangesForSearchFacet(isA(SearchFacet.class));
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)} with {@code query}, {@code
   * namedFacetMap}.
   *
   * <ul>
   *   <li>Then calls {@link I18nSolrSearchServiceExtensionHandler#attachFacet(SolrQuery, String,
   *       SearchFacetDTO, SearchCriteria)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.attachFacets(SolrQuery, Map)"})
  public void testAttachFacetsWithQueryNamedFacetMap_thenCallsAttachFacet() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.attachFacet(
            Mockito.<SolrQuery>any(),
            Mockito.<String>any(),
            Mockito.<SearchFacetDTO>any(),
            Mockito.<SearchCriteria>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    SolrQuery query = mock(SolrQuery.class);
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put("foo", searchFacetDTO);

    // Act
    solrHelperServiceImpl.attachFacets(query, namedFacetMap);

    // Assert
    verify(query).setFacet(true);
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .attachFacet(isA(SolrQuery.class), eq("foo"), isA(SearchFacetDTO.class), isNull());
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)} with {@code query}, {@code
   * namedFacetMap}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link SolrQuery#setFacet(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.attachFacets(SolrQuery, Map)"})
  public void testAttachFacetsWithQueryNamedFacetMap_whenHashMap_thenCallsSetFacet() {
    // Arrange
    SolrQuery query = mock(SolrQuery.class);
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));

    // Act
    solrHelperServiceImpl.attachFacets(query, new HashMap<>());

    // Assert
    verify(query).setFacet(true);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrTaggedFieldString(String, String, SearchFacetRange)"
  })
  public void testGetSolrTaggedFieldString() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals(
        "{!ex=Index Field Tag=Index Field[2.3:*] frange incl=false l=2.3}field(Index Field)",
        solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrTaggedFieldString(String, String, SearchFacetRange)"
  })
  public void testGetSolrTaggedFieldString2() {
    // Arrange
    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(
        "{!ex=Index Field Tag=Index Field[2.3:2.3] frange incl=false l=2.3 u=2.3}field(Index Field)",
        solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrTaggedFieldString(String, String, SearchFacetRange)"
  })
  public void testGetSolrTaggedFieldString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", solrHelperServiceImpl.getSolrTaggedFieldString(null, " ", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When {@link SearchFacetRangeImpl} (default constructor).
   *   <li>Then return {@code field( )}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrTaggedFieldString(String, String, SearchFacetRange)"
  })
  public void testGetSolrTaggedFieldString_whenSearchFacetRangeImpl_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals(
        "field( )",
        solrHelperServiceImpl.getSolrTaggedFieldString(" ", " ", new SearchFacetRangeImpl()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@code Index Field}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrTaggedFieldString(String, String, SearchFacetRange)"
  })
  public void testGetSolrTaggedFieldString_whenSpace_thenReturnIndexField() {
    // Arrange, Act and Assert
    assertEquals(
        "Index Field", solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", " ", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return space.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrTaggedFieldString(String, String, SearchFacetRange)"
  })
  public void testGetSolrTaggedFieldString_whenSpace_thenReturnSpace() {
    // Arrange, Act and Assert
    assertEquals(" ", solrHelperServiceImpl.getSolrTaggedFieldString(" ", " ", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   *
   * <ul>
   *   <li>When {@code Tag}.
   *   <li>Then return {@code {!Tag=Index Field}Index Field}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String,
   * SearchFacetRange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SolrHelperServiceImpl.getSolrTaggedFieldString(String, String, SearchFacetRange)"
  })
  public void testGetSolrTaggedFieldString_whenTag_thenReturnTagIndexFieldIndexField() {
    // Arrange, Act and Assert
    assertEquals(
        "{!Tag=Index Field}Index Field",
        solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrHelperServiceImpl.getResponseDocuments(QueryResponse)"})
  public void testGetResponseDocuments_thenReturnEmpty() {
    // Arrange
    GroupCommand command = new GroupCommand("Name", 1);
    Group group = new Group("42", new SolrDocumentList());
    command.add(group);

    GroupResponse groupResponse = new GroupResponse();
    groupResponse.add(command);

    QueryResponse response = mock(QueryResponse.class);
    when(response.getGroupResponse()).thenReturn(groupResponse);

    // Act
    List<SolrDocument> actualResponseDocuments =
        solrHelperServiceImpl.getResponseDocuments(response);

    // Assert
    verify(response, atLeast(1)).getGroupResponse();
    assertTrue(actualResponseDocuments.isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}.
   *
   * <ul>
   *   <li>Then return {@link SolrDocumentList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrHelperServiceImpl.getResponseDocuments(QueryResponse)"})
  public void testGetResponseDocuments_thenReturnSolrDocumentList() {
    // Arrange
    SolrDocumentList result = new SolrDocumentList();
    result.add(new SolrDocument());
    Group group = new Group("42", result);

    GroupCommand command = new GroupCommand("Name", 1);
    command.add(group);

    GroupResponse groupResponse = new GroupResponse();
    groupResponse.add(command);

    QueryResponse response = mock(QueryResponse.class);
    when(response.getGroupResponse()).thenReturn(groupResponse);

    // Act
    List<SolrDocument> actualResponseDocuments =
        solrHelperServiceImpl.getResponseDocuments(response);

    // Assert
    verify(response, atLeast(1)).getGroupResponse();
    assertEquals(result, actualResponseDocuments);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}.
   *
   * <ul>
   *   <li>When {@link QueryResponse#QueryResponse()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrHelperServiceImpl.getResponseDocuments(QueryResponse)"})
  public void testGetResponseDocuments_whenQueryResponse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(solrHelperServiceImpl.getResponseDocuments(new QueryResponse()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortableFieldTypes()}.
   *
   * <ul>
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSortableFieldTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrHelperServiceImpl.getSortableFieldTypes()"})
  public void testGetSortableFieldTypes_thenReturnSizeIsFive() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act
    List<String> actualSortableFieldTypes = solrHelperServiceImpl.getSortableFieldTypes();

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("solr.sortable.field.types");
    assertEquals(5, actualSortableFieldTypes.size());
    assertEquals("i", actualSortableFieldTypes.get(3));
    assertEquals("l", actualSortableFieldTypes.get(4));
    assertEquals("p", actualSortableFieldTypes.get(2));
    assertEquals("s", actualSortableFieldTypes.get(1));
    assertEquals("sort", actualSortableFieldTypes.get(0));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortableFieldTypes()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSortableFieldTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrHelperServiceImpl.getSortableFieldTypes()"})
  public void testGetSortableFieldTypes_thenReturnSizeIsOne() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenReturn("Resolve System Property");

    // Act
    List<String> actualSortableFieldTypes = solrHelperServiceImpl.getSortableFieldTypes();

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("solr.sortable.field.types");
    assertEquals(1, actualSortableFieldTypes.size());
    assertEquals("Resolve System Property", actualSortableFieldTypes.get(0));
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   *   <li>When {@link SearchCriteria} (default constructor) SortQuery is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachSortClause(SolrQuery, SearchCriteria, String)"
  })
  public void testAttachSortClause_givenComma_whenSearchCriteriaSortQueryIsComma() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenReturn("Resolve System Property");
    SolrQuery query = mock(SolrQuery.class);

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery(",");

    // Act
    solrHelperServiceImpl.attachSortClause(query, searchCriteria, "Default Sort");

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("solr.sortable.field.types");
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   *
   * <ul>
   *   <li>Given {@code desc}.
   *   <li>Then {@link SolrQuery#SolrQuery(String)} with q is {@code foo} SortField is {@code ,
   *       desc,Default asc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachSortClause(SolrQuery, SearchCriteria, String)"
  })
  public void testAttachSortClause_givenDesc_thenSolrQueryWithQIsFooSortFieldIsDescDefaultAsc() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviation(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenReturn("Resolve System Property");

    SolrQuery query = new SolrQuery("foo");
    query.addSort(",", ORDER.desc);

    // Act
    solrHelperServiceImpl.attachSortClause(query, new SearchCriteria(), "Default Sort");

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("solr.sortable.field.types");
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviation("Default");
    assertEquals(", desc,Default asc", query.getSortField());
    SolrQuery copy = query.getCopy();
    assertEquals(", desc,Default asc", copy.getSortField());
    SolrQuery copy2 = copy.getCopy();
    assertEquals(", desc,Default asc", copy2.getSortField());
    SolrQuery copy3 = copy2.getCopy();
    assertEquals(", desc,Default asc", copy3.getSortField());
    SolrQuery copy4 = copy3.getCopy();
    assertEquals(", desc,Default asc", copy4.getSortField());
    assertEquals(", desc,Default asc", copy4.getCopy().getSortField());
    List<SortClause> sorts = query.getSorts();
    assertEquals(2, sorts.size());
    SortClause getResult = sorts.get(1);
    assertEquals("Default", getResult.getItem());
    Map<String, String[]> map = query.getMap();
    assertEquals(2, map.size());
    assertEquals(ORDER.asc, getResult.getOrder());
    assertTrue(map.containsKey("q"));
    assertArrayEquals(new String[] {", desc,Default asc"}, map.get("sort"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   *
   * <ul>
   *   <li>Given {@link SolrQuery#SolrQuery(String)} with q is {@code foo}.
   *   <li>Then calls {@link SolrQuery#addSort(SortClause)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachSortClause(SolrQuery, SearchCriteria, String)"
  })
  public void testAttachSortClause_givenSolrQueryWithQIsFoo_thenCallsAddSort() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviation(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenReturn("Resolve System Property");

    SolrQuery query = mock(SolrQuery.class);
    when(query.addSort(Mockito.<SortClause>any())).thenReturn(new SolrQuery("foo"));

    // Act
    solrHelperServiceImpl.attachSortClause(query, new SearchCriteria(), "Default Sort");

    // Assert
    verify(query).addSort(isA(SortClause.class));
    verify(systemPropertiesService).resolveSystemProperty("solr.sortable.field.types");
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviation("Default");
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   *
   * <ul>
   *   <li>Given {@link SolrQuery#SolrQuery(String)} with q is {@code foo}.
   *   <li>Then calls {@link SolrQuery#addSort(SortClause)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachSortClause(SolrQuery, SearchCriteria, String)"
  })
  public void testAttachSortClause_givenSolrQueryWithQIsFoo_thenCallsAddSort2() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviation(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenReturn("Resolve System Property");

    SolrQuery query = mock(SolrQuery.class);
    when(query.addSort(Mockito.<SortClause>any())).thenReturn(new SolrQuery("foo"));

    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getSortQuery()).thenReturn("foo,bar");

    // Act
    solrHelperServiceImpl.attachSortClause(query, searchCriteria, "Default Sort");

    // Assert
    verify(query, atLeast(1)).addSort(Mockito.<SortClause>any());
    verify(systemPropertiesService).resolveSystemProperty("solr.sortable.field.types");
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldDao, atLeast(1)).getIndexFieldTypesByAbbreviation(Mockito.<String>any());
    verify(searchCriteria).getSortQuery();
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   *
   * <ul>
   *   <li>Then calls {@link I18nSolrSearchServiceExtensionHandler#attachSortField(SolrQuery,
   *       String, ORDER)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachSortClause(SolrQuery, SearchCriteria, String)"
  })
  public void testAttachSortClause_thenCallsAttachSortField() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.attachSortField(
            Mockito.<SolrQuery>any(), Mockito.<String>any(), Mockito.<ORDER>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenReturn("Resolve System Property");
    SolrQuery query = mock(SolrQuery.class);

    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getSortQuery()).thenReturn("foo,bar");

    // Act
    solrHelperServiceImpl.attachSortClause(query, searchCriteria, "Default Sort");

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("solr.sortable.field.types");
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(searchCriteria).getSortQuery();
    verify(i18nSolrSearchServiceExtensionHandler, atLeast(1))
        .attachSortField(isA(SolrQuery.class), Mockito.<String>any(), eq(ORDER.asc));
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then {@link SolrQuery#SolrQuery(String)} with q is {@code foo} Sorts Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachSortClause(SolrQuery, SearchCriteria, String)"
  })
  public void testAttachSortClause_whenEmptyString_thenSolrQueryWithQIsFooSortsEmpty() {
    // Arrange
    SolrQuery query = new SolrQuery("foo");

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery(" ");

    // Act
    solrHelperServiceImpl.attachSortClause(query, searchCriteria, "");

    // Assert that nothing has changed
    assertTrue(query.getSorts().isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortOrder(String[], String)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSortOrder(String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrQuery.ORDER SolrHelperServiceImpl.getSortOrder(String[], String)"})
  public void testGetSortOrder() {
    // Arrange, Act and Assert
    assertEquals(
        ORDER.asc,
        solrHelperServiceImpl.getSortOrder(
            new String[] {
              "Solr sortquery received was ", ", but no sorting tokens could be extracted."
            },
            "Sort Query"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortOrder(String[], String)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Sort Fields Segments} and {@code desc}.
   *   <li>Then return {@code desc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSortOrder(String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrQuery.ORDER SolrHelperServiceImpl.getSortOrder(String[], String)"})
  public void testGetSortOrder_whenArrayOfStringWithSortFieldsSegmentsAndDesc_thenReturnDesc() {
    // Arrange, Act and Assert
    assertEquals(
        ORDER.desc,
        solrHelperServiceImpl.getSortOrder(new String[] {"Sort Fields Segments", "desc"}, null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortOrder(String[], String)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Sort Fields Segments}.
   *   <li>Then return {@code asc}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSortOrder(String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrQuery.ORDER SolrHelperServiceImpl.getSortOrder(String[], String)"})
  public void testGetSortOrder_whenArrayOfStringWithSortFieldsSegments_thenReturnAsc() {
    // Arrange, Act and Assert
    assertEquals(
        ORDER.asc,
        solrHelperServiceImpl.getSortOrder(new String[] {"Sort Fields Segments"}, "Sort Query"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrHelperServiceImpl.getSolrFieldKeyMap(SearchCriteria, List)"})
  public void testGetSolrFieldKeyMap_givenIndexFieldImpl_thenReturnEmpty() {
    // Arrange
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrHelperServiceImpl.getSolrFieldKeyMap(SearchCriteria, List)"})
  public void testGetSolrFieldKeyMap_givenIndexFieldImpl_thenReturnEmpty2() {
    // Arrange
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       I18nSolrSearchServiceExtensionHandler#getPropertyNameForIndexField(IndexField, FieldType,
   *       String, ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrHelperServiceImpl.getSolrFieldKeyMap(SearchCriteria, List)"})
  public void testGetSolrFieldKeyMap_thenCallsGetPropertyNameForIndexField() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getPropertyNameForIndexField(
            Mockito.<IndexField>any(),
            Mockito.<FieldType>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrSearchServiceExtensionHandler.buildPrefixListForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);
    SearchCriteria searchCriteria = new SearchCriteria();

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    Map<String, String> actualSolrFieldKeyMap =
        solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields);

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldTypeImpl).getFieldType();
    verify(i18nSolrSearchServiceExtensionHandler)
        .getPropertyNameForIndexField(
            isA(IndexField.class), isA(FieldType.class), eq(""), isA(ExtensionResultHolder.class));
    verify(i18nSolrSearchServiceExtensionHandler)
        .buildPrefixListForIndexField(isA(IndexField.class), isA(FieldType.class), isA(List.class));
    assertEquals(1, actualSolrFieldKeyMap.size());
    assertEquals("null_b", actualSolrFieldKeyMap.get(null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   *
   * <ul>
   *   <li>Then return {@code null} is {@code null_b}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrHelperServiceImpl.getSolrFieldKeyMap(SearchCriteria, List)"})
  public void testGetSolrFieldKeyMap_thenReturnNullIsNullB() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    SearchCriteria searchCriteria = new SearchCriteria();

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    Map<String, String> actualSolrFieldKeyMap =
        solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields);

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldTypeImpl).getFieldType();
    assertEquals(1, actualSolrFieldKeyMap.size());
    assertEquals("null_b", actualSolrFieldKeyMap.get(null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   *
   * <ul>
   *   <li>Then return {@code _} is {@code __b}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrHelperServiceImpl.getSolrFieldKeyMap(SearchCriteria, List)"})
  public void testGetSolrFieldKeyMap_thenReturnUnderscoreIsB() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    SearchCriteria searchCriteria = new SearchCriteria();

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    FieldImpl field = new FieldImpl();
    field.setAbbreviation("_");

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(field);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    Map<String, String> actualSolrFieldKeyMap =
        solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields);

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldTypeImpl).getFieldType();
    assertEquals(1, actualSolrFieldKeyMap.size());
    assertEquals("__b", actualSolrFieldKeyMap.get("_"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrHelperServiceImpl.getSolrFieldKeyMap(SearchCriteria, List)"})
  public void testGetSolrFieldKeyMap_whenArrayList_thenReturnEmpty() {
    // Arrange
    SearchCriteria searchCriteria = new SearchCriteria();

    // Act and Assert
    assertTrue(
        solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrHelperServiceImpl.getNamedFacetMap(List, SearchCriteria)"})
  public void testGetNamedFacetMap_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getNamedFacetMap(facets, new SearchCriteria()).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getAbbreviation()} return {@code Abbreviation}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)"
  })
  public void testAttachActiveFacetFilters_givenFieldImplGetAbbreviationReturnAbbreviation() {
    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = new SolrQuery("foo");

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getAbbreviation()).thenReturn("Abbreviation");

    SearchFacet facet = mock(SearchFacet.class);
    when(facet.getField()).thenReturn(fieldImpl);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(facet);
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put(null, searchFacetDTO);

    TreeMap<String, String[]> filterCriteria = new TreeMap<>();
    filterCriteria.put("foo", new String[] {"foo"});

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setFilterCriteria(filterCriteria);

    // Act
    solrHelperServiceImpl.attachActiveFacetFilters(query, namedFacetMap, searchCriteria);

    // Assert
    verify(fieldImpl).getAbbreviation();
    verify(facet).getField();
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldImpl#getAbbreviation()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrHelperServiceImpl.attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)"
  })
  public void testAttachActiveFacetFilters_thenCallsGetAbbreviation() {
    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = new SolrQuery("foo");

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getAbbreviation()).thenReturn("foo");

    SearchFacet facet = mock(SearchFacet.class);
    when(facet.getField()).thenReturn(fieldImpl);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(facet);
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();
    namedFacetMap.put(null, searchFacetDTO);

    TreeMap<String, String[]> filterCriteria = new TreeMap<>();
    filterCriteria.put("foo", new String[] {"foo"});

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setFilterCriteria(filterCriteria);

    // Act
    solrHelperServiceImpl.attachActiveFacetFilters(query, namedFacetMap, searchCriteria);

    // Assert
    verify(fieldImpl).getAbbreviation();
    verify(facet).getField();
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}.
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[],
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object SolrHelperServiceImpl.getPropertyValueInternal(Object, String[], int)"
  })
  public void testGetPropertyValueInternal()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertNull(
        solrHelperServiceImpl.getPropertyValueInternal(
            "Object", new String[] {"Components", "exploitProtection.xssEnabled"}, 1));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[],
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object SolrHelperServiceImpl.getPropertyValueInternal(Object, String[], int)"
  })
  public void testGetPropertyValueInternal_whenNull_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertNull(
        solrHelperServiceImpl.getPropertyValueInternal(null, new String[] {"Components"}, 1));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[],
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object SolrHelperServiceImpl.getPropertyValueInternal(Object, String[], int)"
  })
  public void testGetPropertyValueInternal_whenZero_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertNull(
        solrHelperServiceImpl.getPropertyValueInternal("Object", new String[] {"Components"}, 0));
  }

  /**
   * Test {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.copyPropertyToCollection(Collection, Object)"})
  public void testCopyPropertyToCollection_given42_whenArrayListAdd42_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, "42");

    // Assert
    assertEquals(2, collection.size());
    assertEquals("42", collection.get(0));
    assertEquals("42", collection.get(1));
  }

  /**
   * Test {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.copyPropertyToCollection(Collection, Object)"})
  public void testCopyPropertyToCollection_whenArrayList_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, "42");

    // Assert
    assertEquals(1, collection.size());
    assertEquals("42", collection.get(0));
  }

  /**
   * Test {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrHelperServiceImpl.copyPropertyToCollection(Collection, Object)"})
  public void testCopyPropertyToCollection_whenNull_thenArrayListEmpty() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, null);

    // Assert that nothing has changed
    assertTrue(collection.isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSearchableIndexFields()}.
   *
   * <ul>
   *   <li>Then calls {@link I18nSolrSearchServiceExtensionHandler#getSearchableIndexFields(List)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSearchableIndexFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrHelperServiceImpl.getSearchableIndexFields()"})
  public void testGetSearchableIndexFields_thenCallsGetSearchableIndexFields() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.getSearchableIndexFields(
            Mockito.<List<IndexField>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);

    // Act
    List<IndexField> actualSearchableIndexFields = solrHelperServiceImpl.getSearchableIndexFields();

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler).getSearchableIndexFields(isA(List.class));
    assertTrue(actualSearchableIndexFields.isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSearchableIndexFields()}.
   *
   * <ul>
   *   <li>Then calls {@link IndexFieldDao#readSearchableFieldsByEntityType(FieldEntity)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrHelperServiceImpl#getSearchableIndexFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrHelperServiceImpl.getSearchableIndexFields()"})
  public void testGetSearchableIndexFields_thenCallsReadSearchableFieldsByEntityType() {
    // Arrange
    when(indexFieldDao.readSearchableFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());

    // Act
    List<IndexField> actualSearchableIndexFields = solrHelperServiceImpl.getSearchableIndexFields();

    // Assert
    verify(solrSearchServiceExtensionManager).getProxy();
    verify(indexFieldDao).readSearchableFieldsByEntityType(isA(FieldEntity.class));
    assertTrue(actualSearchableIndexFields.isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategoryFilterIds(Category, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       I18nSolrSearchServiceExtensionHandler#addAdditionalCategoryIds(Category, SearchCriteria,
   *       List)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrHelperServiceImpl#getCategoryFilterIds(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SolrHelperServiceImpl.getCategoryFilterIds(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testGetCategoryFilterIds_thenCallsAddAdditionalCategoryIds() {
    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler =
        mock(I18nSolrSearchServiceExtensionHandler.class);
    when(i18nSolrSearchServiceExtensionHandler.addAdditionalCategoryIds(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<SearchCriteria>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrSearchServiceExtensionHandler.getCategoryId(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<Long[]>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrSearchServiceExtensionHandler);
    CategoryImpl category = new CategoryImpl();

    // Act
    List<Long> actualCategoryFilterIds =
        solrHelperServiceImpl.getCategoryFilterIds(category, new SearchCriteria());

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    verify(i18nSolrSearchServiceExtensionHandler)
        .addAdditionalCategoryIds(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class),
            isA(SearchCriteria.class),
            isA(List.class));
    verify(i18nSolrSearchServiceExtensionHandler)
        .getCategoryId(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class), isA(Long[].class));
    assertEquals(1, actualCategoryFilterIds.size());
    assertNull(actualCategoryFilterIds.get(0));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategoryFilterIds(Category, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrHelperServiceImpl#getCategoryFilterIds(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SolrHelperServiceImpl.getCategoryFilterIds(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testGetCategoryFilterIds_thenReturnSizeIsOne() {
    // Arrange
    when(solrSearchServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrSearchServiceExtensionHandler());
    CategoryImpl category = new CategoryImpl();

    // Act
    List<Long> actualCategoryFilterIds =
        solrHelperServiceImpl.getCategoryFilterIds(category, new SearchCriteria());

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getProxy();
    assertEquals(1, actualCategoryFilterIds.size());
    assertNull(actualCategoryFilterIds.get(0));
  }
}
