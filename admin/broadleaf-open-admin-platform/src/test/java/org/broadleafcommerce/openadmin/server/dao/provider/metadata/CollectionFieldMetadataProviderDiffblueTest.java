/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentationCollection;
import org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.UnspecifiedBooleanType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

@RunWith(MockitoJUnitRunner.class)
public class CollectionFieldMetadataProviderDiffblueTest {
  @InjectMocks
  private CollectionFieldMetadataProvider collectionFieldMetadataProvider;

  @Mock
  private Map map;

  /**
   * Test {@link CollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean CollectionFieldMetadataProvider.canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)"})
  public void testCanHandleAnnotationOverride_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(
        collectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse CollectionFieldMetadataProvider.overrideViaAnnotation(OverrideViaAnnotationRequest, Map)"})
  public void testOverrideViaAnnotation_whenJavaLangObject_thenReturnNotHandled() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        collectionFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse CollectionFieldMetadataProvider.overrideViaXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideViaXml_givenMapGetReturnHashMap_thenReturnHandled() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    MetadataProviderResponse actualOverrideViaXmlResult = collectionFieldMetadataProvider
        .overrideViaXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED, actualOverrideViaXmlResult);
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse CollectionFieldMetadataProvider.overrideViaXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideViaXml_givenMapGetReturnNull_thenReturnHandled() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    MetadataProviderResponse actualOverrideViaXmlResult = collectionFieldMetadataProvider
        .overrideViaXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED, actualOverrideViaXmlResult);
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.overrideCollectionMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideCollectionMergeMetadata() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideCollectionMergeMetadataResult = collectionFieldMetadataProvider
        .overrideCollectionMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideCollectionMergeMetadataResult.getExcluded());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideCollectionMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRequired());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSearchable());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUnique());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideCollectionMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideCollectionMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideCollectionMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideCollectionMergeMetadataResult.isProminent());
    assertNull(actualOverrideCollectionMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLength());
    assertNull(actualOverrideCollectionMergeMetadataResult.getPrecision());
    assertNull(actualOverrideCollectionMergeMetadataResult.getScale());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideCollectionMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroup());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHelpText());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHint());
    assertNull(actualOverrideCollectionMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getManyToField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMediaField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTab());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTooltip());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValueClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeys());
    assertNull(actualOverrideCollectionMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLookupType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFetchType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getInspectType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideCollectionMergeMetadataResult.getVisibility());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideCollectionMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.overrideCollectionMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideCollectionMergeMetadata2() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.stringArrayOverrideValue()).thenReturn(new String[]{"42"});
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("customCriteria");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideCollectionMergeMetadataResult = collectionFieldMetadataProvider
        .overrideCollectionMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(adminPresentationMergeEntry).stringArrayOverrideValue();
    verify(merge).mergeEntries();
    assertNull(actualOverrideCollectionMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSelectizeVisibleField());
    assertArrayEquals(new String[]{"42"}, actualOverrideCollectionMergeMetadataResult.getCustomCriteria());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return CurrencyCodeField is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.overrideCollectionMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideCollectionMergeMetadata_thenReturnCurrencyCodeFieldIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("currencyCodeField");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideCollectionMergeMetadataResult = collectionFieldMetadataProvider
        .overrideCollectionMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideCollectionMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideCollectionMergeMetadataResult.getExcluded());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideCollectionMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRequired());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSearchable());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUnique());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideCollectionMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideCollectionMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideCollectionMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideCollectionMergeMetadataResult.isProminent());
    assertNull(actualOverrideCollectionMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLength());
    assertNull(actualOverrideCollectionMergeMetadataResult.getPrecision());
    assertNull(actualOverrideCollectionMergeMetadataResult.getScale());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideCollectionMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideCollectionMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroup());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHelpText());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHint());
    assertNull(actualOverrideCollectionMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getManyToField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMediaField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTab());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTooltip());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValueClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeys());
    assertNull(actualOverrideCollectionMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLookupType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFetchType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getInspectType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideCollectionMergeMetadataResult.getVisibility());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideCollectionMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return SelectizeVisibleField is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.overrideCollectionMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideCollectionMergeMetadata_thenReturnSelectizeVisibleFieldIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("selectizeVisibleField");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideCollectionMergeMetadataResult = collectionFieldMetadataProvider
        .overrideCollectionMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideCollectionMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideCollectionMergeMetadataResult.getExcluded());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideCollectionMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRequired());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSearchable());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUnique());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideCollectionMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideCollectionMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideCollectionMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideCollectionMergeMetadataResult.isProminent());
    assertNull(actualOverrideCollectionMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLength());
    assertNull(actualOverrideCollectionMergeMetadataResult.getPrecision());
    assertNull(actualOverrideCollectionMergeMetadataResult.getScale());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOrder());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideCollectionMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGroup());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHelpText());
    assertNull(actualOverrideCollectionMergeMetadataResult.getHint());
    assertNull(actualOverrideCollectionMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getManyToField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMediaField());
    assertNull(actualOverrideCollectionMergeMetadataResult.getName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideCollectionMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTab());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideCollectionMergeMetadataResult.getTooltip());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValueClass());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideCollectionMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeys());
    assertNull(actualOverrideCollectionMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideCollectionMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getLookupType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getAddType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFetchType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getInspectType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideCollectionMergeMetadataResult.getFieldType());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideCollectionMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideCollectionMergeMetadataResult.getVisibility());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideCollectionMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(AdminPresentationCollection)"})
  public void testConstructBasicCollectionMetadataOverride() {
    // Arrange
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    AdminPresentationCollection annotColl = mock(AdminPresentationCollection.class);
    when(annotColl.lazyFetch()).thenReturn(true);
    when(annotColl.manualFetch()).thenReturn(true);
    when(annotColl.currencyCodeField()).thenReturn("GBP");
    when(annotColl.showIfProperty()).thenReturn("Show If Property");
    when(annotColl.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annotColl.excluded()).thenReturn(true);
    when(annotColl.readOnly()).thenReturn(true);
    when(annotColl.sortAscending()).thenReturn(true);
    when(annotColl.useServerSideInspectionCache()).thenReturn(true);
    when(annotColl.order()).thenReturn(1);
    when(annotColl.tabOrder()).thenReturn(1);
    when(annotColl.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annotColl.friendlyName()).thenReturn("Friendly Name");
    when(annotColl.group()).thenReturn("Group");
    when(annotColl.manyToField()).thenReturn("Many To Field");
    when(annotColl.securityLevel()).thenReturn("Security Level");
    when(annotColl.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(annotColl.sortProperty()).thenReturn("Sort Property");
    when(annotColl.tab()).thenReturn("Tab");
    when(annotColl.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(annotColl.operationTypes()).thenReturn(adminPresentationOperationTypes);
    when(annotColl.addType()).thenReturn(AddMethodType.PERSIST);

    // Act
    FieldMetadataOverride actualConstructBasicCollectionMetadataOverrideResult = collectionFieldMetadataProvider
        .constructBasicCollectionMetadataOverride(annotColl);

    // Assert
    verify(annotColl).addFriendlyName();
    verify(annotColl).addType();
    verify(annotColl).currencyCodeField();
    verify(annotColl).customCriteria();
    verify(annotColl).excluded();
    verify(annotColl).friendlyName();
    verify(annotColl).group();
    verify(annotColl).lazyFetch();
    verify(annotColl).manualFetch();
    verify(annotColl).manyToField();
    verify(annotColl, atLeast(1)).operationTypes();
    verify(annotColl).order();
    verify(annotColl).readOnly();
    verify(annotColl).securityLevel();
    verify(annotColl).selectizeVisibleField();
    verify(annotColl, atLeast(1)).showIfFieldEquals();
    verify(annotColl).showIfProperty();
    verify(annotColl).sortAscending();
    verify(annotColl).sortProperty();
    verify(annotColl).tab();
    verify(annotColl).tabOrder();
    verify(annotColl).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    assertEquals("Add Friendly Name", actualConstructBasicCollectionMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Friendly Name", actualConstructBasicCollectionMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicCollectionMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructBasicCollectionMetadataOverrideResult.getGroup());
    assertEquals("Many To Field", actualConstructBasicCollectionMetadataOverrideResult.getManyToField());
    assertEquals("Security Level", actualConstructBasicCollectionMetadataOverrideResult.getSecurityLevel());
    assertEquals("Selectize Visible Field",
        actualConstructBasicCollectionMetadataOverrideResult.getSelectizeVisibleField());
    assertEquals("Show If Property", actualConstructBasicCollectionMetadataOverrideResult.getShowIfProperty());
    assertEquals("Sort Property", actualConstructBasicCollectionMetadataOverrideResult.getSortProperty());
    assertEquals("Tab", actualConstructBasicCollectionMetadataOverrideResult.getTab());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isProminent());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getHelpText());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getHint());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTooltip());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getLookupType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getFieldType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getVisibility());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicCollectionMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicCollectionMetadataOverrideResult.getOrder().intValue());
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicCollectionMetadataOverrideResult
        .getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    assertEquals(1, actualConstructBasicCollectionMetadataOverrideResult.getCustomCriteria().length);
    assertEquals(AddMethodType.PERSIST, actualConstructBasicCollectionMetadataOverrideResult.getAddMethodType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructBasicCollectionMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicCollectionMetadataOverrideResult.getSecondaryType());
    assertTrue(showIfFieldEquals.containsKey("Field Name"));
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.isSortAscending());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(AdminPresentationCollection)"})
  public void testConstructBasicCollectionMetadataOverride2() {
    // Arrange
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    AdminPresentationCollection annotColl = mock(AdminPresentationCollection.class);
    when(annotColl.excluded()).thenReturn(true);
    when(annotColl.readOnly()).thenReturn(true);
    when(annotColl.sortAscending()).thenReturn(true);
    when(annotColl.useServerSideInspectionCache()).thenReturn(true);
    when(annotColl.order()).thenReturn(1);
    when(annotColl.tabOrder()).thenReturn(1);
    when(annotColl.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annotColl.friendlyName()).thenReturn("Friendly Name");
    when(annotColl.group()).thenReturn("Group");
    when(annotColl.manyToField()).thenReturn("Many To Field");
    when(annotColl.securityLevel()).thenReturn("Security Level");
    when(annotColl.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(annotColl.sortProperty()).thenReturn("Sort Property");
    when(annotColl.tab()).thenReturn("Tab");
    when(annotColl.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(annotColl.operationTypes()).thenReturn(adminPresentationOperationTypes);
    when(annotColl.addType()).thenReturn(AddMethodType.PERSIST);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> collectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(annotColl));
    verify(annotColl).addFriendlyName();
    verify(annotColl).addType();
    verify(annotColl).customCriteria();
    verify(annotColl).excluded();
    verify(annotColl).friendlyName();
    verify(annotColl).group();
    verify(annotColl).manyToField();
    verify(annotColl).operationTypes();
    verify(annotColl).order();
    verify(annotColl).readOnly();
    verify(annotColl).securityLevel();
    verify(annotColl).selectizeVisibleField();
    verify(annotColl).sortAscending();
    verify(annotColl).sortProperty();
    verify(annotColl).tab();
    verify(annotColl).tabOrder();
    verify(annotColl).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(AdminPresentationCollection)"})
  public void testConstructBasicCollectionMetadataOverride3() {
    // Arrange
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    AdminPresentationCollection annotColl = mock(AdminPresentationCollection.class);
    when(annotColl.showIfProperty()).thenReturn("Show If Property");
    when(annotColl.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(annotColl.excluded()).thenReturn(true);
    when(annotColl.readOnly()).thenReturn(true);
    when(annotColl.sortAscending()).thenReturn(true);
    when(annotColl.useServerSideInspectionCache()).thenReturn(true);
    when(annotColl.order()).thenReturn(1);
    when(annotColl.tabOrder()).thenReturn(1);
    when(annotColl.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annotColl.friendlyName()).thenReturn("Friendly Name");
    when(annotColl.group()).thenReturn("Group");
    when(annotColl.manyToField()).thenReturn("Many To Field");
    when(annotColl.securityLevel()).thenReturn("Security Level");
    when(annotColl.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(annotColl.sortProperty()).thenReturn("Sort Property");
    when(annotColl.tab()).thenReturn("Tab");
    when(annotColl.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(annotColl.operationTypes()).thenReturn(adminPresentationOperationTypes);
    when(annotColl.addType()).thenReturn(AddMethodType.PERSIST);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> collectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(annotColl));
    verify(annotColl).addFriendlyName();
    verify(annotColl).addType();
    verify(annotColl).customCriteria();
    verify(annotColl).excluded();
    verify(annotColl).friendlyName();
    verify(annotColl).group();
    verify(annotColl).manyToField();
    verify(annotColl, atLeast(1)).operationTypes();
    verify(annotColl).order();
    verify(annotColl).readOnly();
    verify(annotColl).securityLevel();
    verify(annotColl).selectizeVisibleField();
    verify(annotColl, atLeast(1)).showIfFieldEquals();
    verify(annotColl).showIfProperty();
    verify(annotColl).sortAscending();
    verify(annotColl).sortProperty();
    verify(annotColl).tab();
    verify(annotColl).tabOrder();
    verify(annotColl).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <ul>
   *   <li>Then return ShowIfFieldEquals is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(AdminPresentationCollection)"})
  public void testConstructBasicCollectionMetadataOverride_thenReturnShowIfFieldEqualsIsNull() {
    // Arrange
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    AdminPresentationCollection annotColl = mock(AdminPresentationCollection.class);
    when(annotColl.lazyFetch()).thenReturn(true);
    when(annotColl.manualFetch()).thenReturn(true);
    when(annotColl.currencyCodeField()).thenReturn("GBP");
    when(annotColl.showIfProperty()).thenReturn("Show If Property");
    when(annotColl.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{});
    when(annotColl.excluded()).thenReturn(true);
    when(annotColl.readOnly()).thenReturn(true);
    when(annotColl.sortAscending()).thenReturn(true);
    when(annotColl.useServerSideInspectionCache()).thenReturn(true);
    when(annotColl.order()).thenReturn(1);
    when(annotColl.tabOrder()).thenReturn(1);
    when(annotColl.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annotColl.friendlyName()).thenReturn("Friendly Name");
    when(annotColl.group()).thenReturn("Group");
    when(annotColl.manyToField()).thenReturn("Many To Field");
    when(annotColl.securityLevel()).thenReturn("Security Level");
    when(annotColl.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(annotColl.sortProperty()).thenReturn("Sort Property");
    when(annotColl.tab()).thenReturn("Tab");
    when(annotColl.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(annotColl.operationTypes()).thenReturn(adminPresentationOperationTypes);
    when(annotColl.addType()).thenReturn(AddMethodType.PERSIST);

    // Act
    FieldMetadataOverride actualConstructBasicCollectionMetadataOverrideResult = collectionFieldMetadataProvider
        .constructBasicCollectionMetadataOverride(annotColl);

    // Assert
    verify(annotColl).addFriendlyName();
    verify(annotColl).addType();
    verify(annotColl).currencyCodeField();
    verify(annotColl).customCriteria();
    verify(annotColl).excluded();
    verify(annotColl).friendlyName();
    verify(annotColl).group();
    verify(annotColl).lazyFetch();
    verify(annotColl).manualFetch();
    verify(annotColl).manyToField();
    verify(annotColl, atLeast(1)).operationTypes();
    verify(annotColl).order();
    verify(annotColl).readOnly();
    verify(annotColl).securityLevel();
    verify(annotColl).selectizeVisibleField();
    verify(annotColl).showIfFieldEquals();
    verify(annotColl).showIfProperty();
    verify(annotColl).sortAscending();
    verify(annotColl).sortProperty();
    verify(annotColl).tab();
    verify(annotColl).tabOrder();
    verify(annotColl).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    assertEquals("Add Friendly Name", actualConstructBasicCollectionMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Friendly Name", actualConstructBasicCollectionMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicCollectionMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructBasicCollectionMetadataOverrideResult.getGroup());
    assertEquals("Many To Field", actualConstructBasicCollectionMetadataOverrideResult.getManyToField());
    assertEquals("Security Level", actualConstructBasicCollectionMetadataOverrideResult.getSecurityLevel());
    assertEquals("Selectize Visible Field",
        actualConstructBasicCollectionMetadataOverrideResult.getSelectizeVisibleField());
    assertEquals("Show If Property", actualConstructBasicCollectionMetadataOverrideResult.getShowIfProperty());
    assertEquals("Sort Property", actualConstructBasicCollectionMetadataOverrideResult.getSortProperty());
    assertEquals("Tab", actualConstructBasicCollectionMetadataOverrideResult.getTab());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.isProminent());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getHelpText());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getHint());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getTooltip());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getShowIfFieldEquals());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getLookupType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getFieldType());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getVisibility());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicCollectionMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicCollectionMetadataOverrideResult.getOrder().intValue());
    assertEquals(1, actualConstructBasicCollectionMetadataOverrideResult.getCustomCriteria().length);
    assertEquals(AddMethodType.PERSIST, actualConstructBasicCollectionMetadataOverrideResult.getAddMethodType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructBasicCollectionMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructBasicCollectionMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicCollectionMetadataOverrideResult.getSecondaryType());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicCollectionMetadataOverrideResult.isSortAscending());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride CollectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(AdminPresentationCollection)"})
  public void testConstructBasicCollectionMetadataOverride_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> collectionFieldMetadataProvider.constructBasicCollectionMetadataOverride(null));
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CollectionFieldMetadataProvider.buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)"})
  public void testBuildCollectionMetadata() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getName()).thenReturn("Name");
    when(field.getOneToManyTargetEntity()).thenReturn("");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    doNothing().when(field).setGenericType(Mockito.<Type>any());
    doNothing().when(field).setManyToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setManyToManyTargetEntity(Mockito.<String>any());
    doNothing().when(field).setMapKey(Mockito.<String>any());
    doNothing().when(field).setName(Mockito.<String>any());
    doNothing().when(field).setOneToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setOneToManyTargetEntity(Mockito.<String>any());
    field.setGenericType(new TypePlaceHolder(1));
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");

    FieldMetadataOverride collectionMetadata = new FieldMetadataOverride();
    collectionMetadata.setAddFriendlyName("Add Friendly Name");
    collectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    collectionMetadata.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    collectionMetadata.setAllowNoValueEnumOption(true);
    collectionMetadata.setAssociatedFieldName("Associated Field Name");
    collectionMetadata.setBroadleafEnumeration("Broadleaf Enumeration");
    collectionMetadata.setCanLinkToExternalEntity(true);
    collectionMetadata.setColumnWidth("Column Width");
    collectionMetadata.setCurrencyCodeField("GBP");
    collectionMetadata.setCustomCriteria(new String[]{"Custom Criteria"});
    collectionMetadata.setDeleteEntityUponRemove(true);
    collectionMetadata.setDerived(true);
    collectionMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);
    collectionMetadata.setEnableTypeaheadLookup(true);
    collectionMetadata.setEnumerationClass("Enumeration Class");
    collectionMetadata.setEnumerationValues(new String[][]{new String[]{"42"}});
    collectionMetadata.setExcluded(true);
    collectionMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");
    collectionMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setForceFreeFormKeys(true);
    collectionMetadata.setForcePopulateChildProperties(true);
    collectionMetadata.setForeignKeyClass("Foreign Key Class");
    collectionMetadata.setForeignKeyCollection(true);
    collectionMetadata.setForeignKeyDisplayValueProperty("42");
    collectionMetadata.setForeignKeyProperty("Foreign Key Property");
    collectionMetadata.setFriendlyName("Friendly Name");
    collectionMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    collectionMetadata.setGridOrder(1);
    collectionMetadata.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    collectionMetadata.setGroup("Group");
    collectionMetadata.setGroupCollapsed(true);
    collectionMetadata.setGroupOrder(1);
    collectionMetadata.setHelpText("Help Text");
    collectionMetadata.setHideEnumerationIfEmpty(true);
    collectionMetadata.setHint("Hint");
    collectionMetadata.setIgnoreAdornedProperties(true);
    collectionMetadata.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setJoinEntityClass("Join Entity Class");
    collectionMetadata.setKeyClass("Key Class");
    collectionMetadata.setKeyPropertyFriendlyName("Key Property Friendly Name");
    collectionMetadata.setKeys(new String[][]{new String[]{"Keys"}});
    collectionMetadata.setLargeEntry(true);
    collectionMetadata.setLazyFetch(true);
    collectionMetadata.setLength(3);
    collectionMetadata.setLookupDisplayProperty("Lookup Display Property");
    collectionMetadata.setLookupType(LookupType.STANDARD);
    collectionMetadata.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    collectionMetadata.setManualFetch(true);
    collectionMetadata.setManyToField("Many To Field");
    collectionMetadata.setMapFieldValueClass("42");
    collectionMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    collectionMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    collectionMetadata.setMapKeyOptionEntityValueField("42");
    collectionMetadata.setMapKeyValueProperty("42");
    collectionMetadata.setMediaField("Media Field");
    collectionMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);
    collectionMetadata.setName("Name");
    collectionMetadata.setOptionCanEditValues(true);
    collectionMetadata.setOptionDisplayFieldName("Option Display Field Name");
    collectionMetadata
        .setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    collectionMetadata.setOptionListEntity("Option List Entity");
    collectionMetadata.setOptionValueFieldName("42");
    collectionMetadata.setOrder(1);
    collectionMetadata.setParentObjectIdProperty("Parent Object Id Property");
    collectionMetadata.setParentObjectProperty("Parent Object Property");
    collectionMetadata.setPrecision(1);
    collectionMetadata.setProminent(true);
    collectionMetadata.setReadOnly(true);
    collectionMetadata.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setRequired(true);
    collectionMetadata.setRequiredOverride(true);
    collectionMetadata.setRuleIdentifier("42");
    collectionMetadata.setScale(1);
    collectionMetadata.setSearchable(true);
    collectionMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setSecurityLevel("Security Level");
    collectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();
    collectionMetadata.setShowIfFieldEquals(showIfFieldEquals);
    collectionMetadata.setShowIfProperty("Show If Property");
    collectionMetadata.setSimpleValue(UnspecifiedBooleanType.TRUE);
    collectionMetadata.setSortAscending(true);
    collectionMetadata.setSortProperty("Sort Property");
    collectionMetadata.setTab("Tab");
    collectionMetadata.setTabOrder(1);
    collectionMetadata.setTargetObjectIdProperty("Target Object Id Property");
    collectionMetadata.setTargetObjectProperty("Target Object Property");
    collectionMetadata.setToOneLookupCreatedViaAnnotation(true);
    collectionMetadata.setToOneParentProperty("To One Parent Property");
    collectionMetadata.setToOneTargetProperty("To One Target Property");
    collectionMetadata.setTooltip("127.0.0.1");
    collectionMetadata.setTranslatable(true);
    collectionMetadata.setUnique(true);
    collectionMetadata.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setUseServerSideInspectionCache(true);
    collectionMetadata.setValidationConfigurations(new HashMap<>());
    collectionMetadata.setValueClass("42");
    collectionMetadata.setValuePropertyFriendlyName("42");
    collectionMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(field).getGenericType();
    verify(field, atLeast(1)).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getName();
    verify(field).getOneToManyTargetEntity();
    verify(field).setGenericType(isA(Type.class));
    verify(field).setManyToManyMappedBy(eq("Many To Many Mapped By"));
    verify(field).setManyToManyTargetEntity(eq("Many To Many Target Entity"));
    verify(field).setMapKey(eq("Map Key"));
    verify(field).setName(eq("Name"));
    verify(field).setOneToManyMappedBy(eq("One To Many Mapped By"));
    verify(field).setOneToManyTargetEntity(eq("One To Many Target Entity"));
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    assertEquals("Many To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertSame(showIfFieldEquals, collectionMetadata.getShowIfFieldEquals());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadataOverride#getAddFriendlyName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CollectionFieldMetadataProvider.buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)"})
  public void testBuildCollectionMetadata_thenCallsGetAddFriendlyName() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    doNothing().when(field).setGenericType(Mockito.<Type>any());
    doNothing().when(field).setManyToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setManyToManyTargetEntity(Mockito.<String>any());
    doNothing().when(field).setMapKey(Mockito.<String>any());
    doNothing().when(field).setName(Mockito.<String>any());
    doNothing().when(field).setOneToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setOneToManyTargetEntity(Mockito.<String>any());
    field.setGenericType(new TypePlaceHolder(1));
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(true);
    when(collectionMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(collectionMetadata.isSortAscending()).thenReturn(true);
    when(collectionMetadata.getTabOrder()).thenReturn(1);
    when(collectionMetadata.getOrder()).thenReturn(1);
    when(collectionMetadata.getAddFriendlyName()).thenReturn("Add Friendly Name");
    when(collectionMetadata.getCurrencyCodeField()).thenReturn("GBP");
    when(collectionMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(collectionMetadata.getGroup()).thenReturn("Group");
    when(collectionMetadata.getManyToField()).thenReturn("Many To Field");
    when(collectionMetadata.getSecurityLevel()).thenReturn("Security Level");
    when(collectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(collectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(collectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(collectionMetadata.getTab()).thenReturn("Tab");
    when(collectionMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(collectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(collectionMetadata.getAddMethodType()).thenReturn(AddMethodType.PERSIST);
    when(collectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    doNothing().when(collectionMetadata).setAddFriendlyName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setAddMethodType(Mockito.<AddMethodType>any());
    doNothing().when(collectionMetadata).setAddType(Mockito.<OperationType>any());
    doNothing().when(collectionMetadata).setAdornedTargetAddMethodType(Mockito.<AdornedTargetAddMethodType>any());
    doNothing().when(collectionMetadata).setAllowNoValueEnumOption(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setAssociatedFieldName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setBroadleafEnumeration(Mockito.<String>any());
    doNothing().when(collectionMetadata).setCanLinkToExternalEntity(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setColumnWidth(Mockito.<String>any());
    doNothing().when(collectionMetadata).setCurrencyCodeField(Mockito.<String>any());
    doNothing().when(collectionMetadata).setCustomCriteria(Mockito.<String[]>any());
    doNothing().when(collectionMetadata).setDeleteEntityUponRemove(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setDerived(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setDisplayType(Mockito.<RuleBuilderDisplayType>any());
    doNothing().when(collectionMetadata).setEnableTypeaheadLookup(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setEnumerationClass(Mockito.<String>any());
    doNothing().when(collectionMetadata).setEnumerationValues(Mockito.<String[][]>any());
    doNothing().when(collectionMetadata).setExcluded(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setExplicitFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(collectionMetadata).setFetchType(Mockito.<OperationType>any());
    doNothing().when(collectionMetadata).setFieldComponentRenderer(Mockito.<SupportedFieldType>any());
    doNothing().when(collectionMetadata).setFieldComponentRendererTemplate(Mockito.<String>any());
    doNothing().when(collectionMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(collectionMetadata).setForceFreeFormKeys(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setForcePopulateChildProperties(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(collectionMetadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setForeignKeyDisplayValueProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setForeignKeyProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setFriendlyName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setGridFieldComponentRenderer(Mockito.<SupportedFieldType>any());
    doNothing().when(collectionMetadata).setGridFieldComponentRendererTemplate(Mockito.<String>any());
    doNothing().when(collectionMetadata).setGridOrder(Mockito.<Integer>any());
    doNothing().when(collectionMetadata).setGridVisibleFields(Mockito.<String[]>any());
    doNothing().when(collectionMetadata).setGroup(Mockito.<String>any());
    doNothing().when(collectionMetadata).setGroupCollapsed(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setGroupOrder(Mockito.<Integer>any());
    doNothing().when(collectionMetadata).setHelpText(Mockito.<String>any());
    doNothing().when(collectionMetadata).setHideEnumerationIfEmpty(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setHint(Mockito.<String>any());
    doNothing().when(collectionMetadata).setIgnoreAdornedProperties(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setInspectType(Mockito.<OperationType>any());
    doNothing().when(collectionMetadata).setJoinEntityClass(Mockito.<String>any());
    doNothing().when(collectionMetadata).setKeyClass(Mockito.<String>any());
    doNothing().when(collectionMetadata).setKeyPropertyFriendlyName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setKeys(Mockito.<String[][]>any());
    doNothing().when(collectionMetadata).setLargeEntry(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setLazyFetch(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setLength(Mockito.<Integer>any());
    doNothing().when(collectionMetadata).setLookupDisplayProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setLookupType(Mockito.<LookupType>any());
    doNothing().when(collectionMetadata).setMaintainedAdornedTargetFields(Mockito.<String[]>any());
    doNothing().when(collectionMetadata).setManualFetch(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setManyToField(Mockito.<String>any());
    doNothing().when(collectionMetadata).setMapFieldValueClass(Mockito.<String>any());
    doNothing().when(collectionMetadata).setMapKeyOptionEntityClass(Mockito.<String>any());
    doNothing().when(collectionMetadata).setMapKeyOptionEntityDisplayField(Mockito.<String>any());
    doNothing().when(collectionMetadata).setMapKeyOptionEntityValueField(Mockito.<String>any());
    doNothing().when(collectionMetadata).setMapKeyValueProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setMediaField(Mockito.<String>any());
    doNothing().when(collectionMetadata).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(collectionMetadata).setName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setOptionCanEditValues(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setOptionDisplayFieldName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setOptionFilterValues(Mockito.<Serializable[][]>any());
    doNothing().when(collectionMetadata).setOptionListEntity(Mockito.<String>any());
    doNothing().when(collectionMetadata).setOptionValueFieldName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setParentObjectIdProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setParentObjectProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setPrecision(Mockito.<Integer>any());
    doNothing().when(collectionMetadata).setProminent(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setReadOnly(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setRemoveType(Mockito.<OperationType>any());
    doNothing().when(collectionMetadata).setRequired(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setRequiredOverride(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setRuleIdentifier(Mockito.<String>any());
    doNothing().when(collectionMetadata).setScale(Mockito.<Integer>any());
    doNothing().when(collectionMetadata).setSearchable(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setSecondaryType(Mockito.<SupportedFieldType>any());
    doNothing().when(collectionMetadata).setSecurityLevel(Mockito.<String>any());
    doNothing().when(collectionMetadata).setSelectizeVisibleField(Mockito.<String>any());
    doNothing().when(collectionMetadata).setShowIfFieldEquals(Mockito.<Map<String, List<String>>>any());
    doNothing().when(collectionMetadata).setShowIfProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setSimpleValue(Mockito.<UnspecifiedBooleanType>any());
    doNothing().when(collectionMetadata).setSortAscending(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setSortProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setTab(Mockito.<String>any());
    doNothing().when(collectionMetadata).setTabOrder(Mockito.<Integer>any());
    doNothing().when(collectionMetadata).setTargetObjectIdProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setTargetObjectProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setToOneLookupCreatedViaAnnotation(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setToOneParentProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setToOneTargetProperty(Mockito.<String>any());
    doNothing().when(collectionMetadata).setTooltip(Mockito.<String>any());
    doNothing().when(collectionMetadata).setTranslatable(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setUnique(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata).setUpdateType(Mockito.<OperationType>any());
    doNothing().when(collectionMetadata).setUseServerSideInspectionCache(Mockito.<Boolean>any());
    doNothing().when(collectionMetadata)
        .setValidationConfigurations(Mockito.<Map<String, List<Map<String, String>>>>any());
    doNothing().when(collectionMetadata).setValueClass(Mockito.<String>any());
    doNothing().when(collectionMetadata).setValuePropertyFriendlyName(Mockito.<String>any());
    doNothing().when(collectionMetadata).setVisibility(Mockito.<VisibilityEnum>any());
    doNothing().when(collectionMetadata).setOrder(Mockito.<Integer>any());
    collectionMetadata.setAddFriendlyName("Add Friendly Name");
    collectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    collectionMetadata.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    collectionMetadata.setAllowNoValueEnumOption(true);
    collectionMetadata.setAssociatedFieldName("Associated Field Name");
    collectionMetadata.setBroadleafEnumeration("Broadleaf Enumeration");
    collectionMetadata.setCanLinkToExternalEntity(true);
    collectionMetadata.setColumnWidth("Column Width");
    collectionMetadata.setCurrencyCodeField("GBP");
    collectionMetadata.setCustomCriteria(new String[]{"Custom Criteria"});
    collectionMetadata.setDeleteEntityUponRemove(true);
    collectionMetadata.setDerived(true);
    collectionMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);
    collectionMetadata.setEnableTypeaheadLookup(true);
    collectionMetadata.setEnumerationClass("Enumeration Class");
    collectionMetadata.setEnumerationValues(new String[][]{new String[]{"42"}});
    collectionMetadata.setExcluded(true);
    collectionMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");
    collectionMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setForceFreeFormKeys(true);
    collectionMetadata.setForcePopulateChildProperties(true);
    collectionMetadata.setForeignKeyClass("Foreign Key Class");
    collectionMetadata.setForeignKeyCollection(true);
    collectionMetadata.setForeignKeyDisplayValueProperty("42");
    collectionMetadata.setForeignKeyProperty("Foreign Key Property");
    collectionMetadata.setFriendlyName("Friendly Name");
    collectionMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    collectionMetadata.setGridOrder(1);
    collectionMetadata.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    collectionMetadata.setGroup("Group");
    collectionMetadata.setGroupCollapsed(true);
    collectionMetadata.setGroupOrder(1);
    collectionMetadata.setHelpText("Help Text");
    collectionMetadata.setHideEnumerationIfEmpty(true);
    collectionMetadata.setHint("Hint");
    collectionMetadata.setIgnoreAdornedProperties(true);
    collectionMetadata.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setJoinEntityClass("Join Entity Class");
    collectionMetadata.setKeyClass("Key Class");
    collectionMetadata.setKeyPropertyFriendlyName("Key Property Friendly Name");
    collectionMetadata.setKeys(new String[][]{new String[]{"Keys"}});
    collectionMetadata.setLargeEntry(true);
    collectionMetadata.setLazyFetch(true);
    collectionMetadata.setLength(3);
    collectionMetadata.setLookupDisplayProperty("Lookup Display Property");
    collectionMetadata.setLookupType(LookupType.STANDARD);
    collectionMetadata.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    collectionMetadata.setManualFetch(true);
    collectionMetadata.setManyToField("Many To Field");
    collectionMetadata.setMapFieldValueClass("42");
    collectionMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    collectionMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    collectionMetadata.setMapKeyOptionEntityValueField("42");
    collectionMetadata.setMapKeyValueProperty("42");
    collectionMetadata.setMediaField("Media Field");
    collectionMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);
    collectionMetadata.setName("Name");
    collectionMetadata.setOptionCanEditValues(true);
    collectionMetadata.setOptionDisplayFieldName("Option Display Field Name");
    collectionMetadata
        .setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    collectionMetadata.setOptionListEntity("Option List Entity");
    collectionMetadata.setOptionValueFieldName("42");
    collectionMetadata.setOrder(1);
    collectionMetadata.setParentObjectIdProperty("Parent Object Id Property");
    collectionMetadata.setParentObjectProperty("Parent Object Property");
    collectionMetadata.setPrecision(1);
    collectionMetadata.setProminent(true);
    collectionMetadata.setReadOnly(true);
    collectionMetadata.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setRequired(true);
    collectionMetadata.setRequiredOverride(true);
    collectionMetadata.setRuleIdentifier("42");
    collectionMetadata.setScale(1);
    collectionMetadata.setSearchable(true);
    collectionMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setSecurityLevel("Security Level");
    collectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    collectionMetadata.setShowIfFieldEquals(new HashMap<>());
    collectionMetadata.setShowIfProperty("Show If Property");
    collectionMetadata.setSimpleValue(UnspecifiedBooleanType.TRUE);
    collectionMetadata.setSortAscending(true);
    collectionMetadata.setSortProperty("Sort Property");
    collectionMetadata.setTab("Tab");
    collectionMetadata.setTabOrder(1);
    collectionMetadata.setTargetObjectIdProperty("Target Object Id Property");
    collectionMetadata.setTargetObjectProperty("Target Object Property");
    collectionMetadata.setToOneLookupCreatedViaAnnotation(true);
    collectionMetadata.setToOneParentProperty("To One Parent Property");
    collectionMetadata.setToOneTargetProperty("To One Target Property");
    collectionMetadata.setTooltip("127.0.0.1");
    collectionMetadata.setTranslatable(true);
    collectionMetadata.setUnique(true);
    collectionMetadata.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setUseServerSideInspectionCache(true);
    collectionMetadata.setValidationConfigurations(new HashMap<>());
    collectionMetadata.setValueClass("42");
    collectionMetadata.setValuePropertyFriendlyName("42");
    collectionMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(collectionMetadata, atLeast(1)).getAddFriendlyName();
    verify(collectionMetadata, atLeast(1)).getAddMethodType();
    verify(collectionMetadata, atLeast(1)).getAddType();
    verify(collectionMetadata, atLeast(1)).getCurrencyCodeField();
    verify(collectionMetadata, atLeast(1)).getCustomCriteria();
    verify(collectionMetadata, atLeast(1)).getExcluded();
    verify(collectionMetadata, atLeast(1)).getFetchType();
    verify(collectionMetadata, atLeast(1)).getFriendlyName();
    verify(collectionMetadata, atLeast(1)).getGroup();
    verify(collectionMetadata, atLeast(1)).getInspectType();
    verify(collectionMetadata, atLeast(1)).getLazyFetch();
    verify(collectionMetadata, atLeast(1)).getManualFetch();
    verify(collectionMetadata, atLeast(1)).getManyToField();
    verify(collectionMetadata, atLeast(1)).getReadOnly();
    verify(collectionMetadata, atLeast(1)).getRemoveType();
    verify(collectionMetadata, atLeast(1)).getSecurityLevel();
    verify(collectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(collectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(collectionMetadata, atLeast(1)).getShowIfProperty();
    verify(collectionMetadata, atLeast(1)).getSortProperty();
    verify(collectionMetadata, atLeast(1)).getTab();
    verify(collectionMetadata, atLeast(1)).getTabOrder();
    verify(collectionMetadata, atLeast(1)).getUpdateType();
    verify(collectionMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata).setAddFriendlyName(eq("Add Friendly Name"));
    verify(collectionMetadata).setAddMethodType(eq(AddMethodType.PERSIST));
    verify(collectionMetadata).setAddType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(collectionMetadata).setAdornedTargetAddMethodType(eq(AdornedTargetAddMethodType.LOOKUP));
    verify(collectionMetadata).setAllowNoValueEnumOption(eq(true));
    verify(collectionMetadata).setAssociatedFieldName(eq("Associated Field Name"));
    verify(collectionMetadata).setBroadleafEnumeration(eq("Broadleaf Enumeration"));
    verify(collectionMetadata).setCanLinkToExternalEntity(eq(true));
    verify(collectionMetadata).setColumnWidth(eq("Column Width"));
    verify(collectionMetadata).setCurrencyCodeField(eq("GBP"));
    verify(collectionMetadata).setCustomCriteria(isA(String[].class));
    verify(collectionMetadata).setDeleteEntityUponRemove(eq(true));
    verify(collectionMetadata).setDerived(eq(true));
    verify(collectionMetadata).setDisplayType(eq(RuleBuilderDisplayType.NORMAL));
    verify(collectionMetadata).setEnableTypeaheadLookup(eq(true));
    verify(collectionMetadata).setEnumerationClass(eq("Enumeration Class"));
    verify(collectionMetadata).setEnumerationValues(isA(String[][].class));
    verify(collectionMetadata).setExcluded(eq(true));
    verify(collectionMetadata).setExplicitFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(collectionMetadata).setFetchType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(collectionMetadata).setFieldComponentRenderer(eq(SupportedFieldType.UNKNOWN));
    verify(collectionMetadata).setFieldComponentRendererTemplate(eq("Field Component Renderer Template"));
    verify(collectionMetadata).setFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(collectionMetadata).setForceFreeFormKeys(eq(true));
    verify(collectionMetadata).setForcePopulateChildProperties(eq(true));
    verify(collectionMetadata).setForeignKeyClass(eq("Foreign Key Class"));
    verify(collectionMetadata).setForeignKeyCollection(eq(true));
    verify(collectionMetadata).setForeignKeyDisplayValueProperty(eq("42"));
    verify(collectionMetadata).setForeignKeyProperty(eq("Foreign Key Property"));
    verify(collectionMetadata).setFriendlyName(eq("Friendly Name"));
    verify(collectionMetadata).setGridFieldComponentRenderer(eq(SupportedFieldType.UNKNOWN));
    verify(collectionMetadata).setGridFieldComponentRendererTemplate(eq("Grid Field Component Renderer Template"));
    verify(collectionMetadata).setGridOrder(eq(1));
    verify(collectionMetadata).setGridVisibleFields(isA(String[].class));
    verify(collectionMetadata).setGroup(eq("Group"));
    verify(collectionMetadata).setGroupCollapsed(eq(true));
    verify(collectionMetadata).setGroupOrder(eq(1));
    verify(collectionMetadata).setHelpText(eq("Help Text"));
    verify(collectionMetadata).setHideEnumerationIfEmpty(eq(true));
    verify(collectionMetadata).setHint(eq("Hint"));
    verify(collectionMetadata).setIgnoreAdornedProperties(eq(true));
    verify(collectionMetadata).setInspectType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(collectionMetadata).setJoinEntityClass(eq("Join Entity Class"));
    verify(collectionMetadata).setKeyClass(eq("Key Class"));
    verify(collectionMetadata).setKeyPropertyFriendlyName(eq("Key Property Friendly Name"));
    verify(collectionMetadata).setKeys(isA(String[][].class));
    verify(collectionMetadata).setLargeEntry(eq(true));
    verify(collectionMetadata).setLazyFetch(eq(true));
    verify(collectionMetadata).setLength(eq(3));
    verify(collectionMetadata).setLookupDisplayProperty(eq("Lookup Display Property"));
    verify(collectionMetadata).setLookupType(eq(LookupType.STANDARD));
    verify(collectionMetadata).setMaintainedAdornedTargetFields(isA(String[].class));
    verify(collectionMetadata).setManualFetch(eq(true));
    verify(collectionMetadata).setManyToField(eq("Many To Field"));
    verify(collectionMetadata).setMapFieldValueClass(eq("42"));
    verify(collectionMetadata).setMapKeyOptionEntityClass(eq("Map Key Option Entity Class"));
    verify(collectionMetadata).setMapKeyOptionEntityDisplayField(eq("Map Key Option Entity Display Field"));
    verify(collectionMetadata).setMapKeyOptionEntityValueField(eq("42"));
    verify(collectionMetadata).setMapKeyValueProperty(eq("42"));
    verify(collectionMetadata).setMediaField(eq("Media Field"));
    verify(collectionMetadata).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(collectionMetadata).setName(eq("Name"));
    verify(collectionMetadata).setOptionCanEditValues(eq(true));
    verify(collectionMetadata).setOptionDisplayFieldName(eq("Option Display Field Name"));
    verify(collectionMetadata).setOptionFilterValues(isA(Serializable[][].class));
    verify(collectionMetadata).setOptionListEntity(eq("Option List Entity"));
    verify(collectionMetadata).setOptionValueFieldName(eq("42"));
    verify(collectionMetadata).setParentObjectIdProperty(eq("Parent Object Id Property"));
    verify(collectionMetadata).setParentObjectProperty(eq("Parent Object Property"));
    verify(collectionMetadata).setPrecision(eq(1));
    verify(collectionMetadata).setProminent(eq(true));
    verify(collectionMetadata).setReadOnly(eq(true));
    verify(collectionMetadata).setRemoveType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(collectionMetadata).setRequired(eq(true));
    verify(collectionMetadata).setRequiredOverride(eq(true));
    verify(collectionMetadata).setRuleIdentifier(eq("42"));
    verify(collectionMetadata).setScale(eq(1));
    verify(collectionMetadata).setSearchable(eq(true));
    verify(collectionMetadata).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    verify(collectionMetadata).setSecurityLevel(eq("Security Level"));
    verify(collectionMetadata).setSelectizeVisibleField(eq("Selectize Visible Field"));
    verify(collectionMetadata).setShowIfFieldEquals(isA(Map.class));
    verify(collectionMetadata).setShowIfProperty(eq("Show If Property"));
    verify(collectionMetadata).setSimpleValue(eq(UnspecifiedBooleanType.TRUE));
    verify(collectionMetadata).setSortAscending(eq(true));
    verify(collectionMetadata).setSortProperty(eq("Sort Property"));
    verify(collectionMetadata).setTab(eq("Tab"));
    verify(collectionMetadata).setTabOrder(eq(1));
    verify(collectionMetadata).setTargetObjectIdProperty(eq("Target Object Id Property"));
    verify(collectionMetadata).setTargetObjectProperty(eq("Target Object Property"));
    verify(collectionMetadata).setToOneLookupCreatedViaAnnotation(eq(true));
    verify(collectionMetadata).setToOneParentProperty(eq("To One Parent Property"));
    verify(collectionMetadata).setToOneTargetProperty(eq("To One Target Property"));
    verify(collectionMetadata).setTranslatable(eq(true));
    verify(collectionMetadata).setUnique(eq(true));
    verify(collectionMetadata).setUpdateType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(collectionMetadata).setUseServerSideInspectionCache(eq(true));
    verify(collectionMetadata).setValidationConfigurations(isA(Map.class));
    verify(collectionMetadata).setValueClass(eq("42"));
    verify(collectionMetadata).setValuePropertyFriendlyName(eq("42"));
    verify(collectionMetadata).setVisibility(eq(VisibilityEnum.HIDDEN_ALL));
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(collectionMetadata).setOrder(eq(1));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    verify(field).setGenericType(isA(Type.class));
    verify(field).setManyToManyMappedBy(eq("Many To Many Mapped By"));
    verify(field).setManyToManyTargetEntity(eq("Many To Many Target Entity"));
    verify(field).setMapKey(eq("Map Key"));
    verify(field).setName(eq("Name"));
    verify(field).setOneToManyMappedBy(eq("One To Many Mapped By"));
    verify(field).setOneToManyTargetEntity(eq("One To Many Target Entity"));
    assertEquals(1, attributes.size());
    assertTrue(attributes.get("Name") instanceof BasicCollectionMetadata);
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link FieldInfo} (default constructor) GenericType {@link TypePlaceHolder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CollectionFieldMetadataProvider.buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)"})
  public void testBuildCollectionMetadata_thenFieldInfoGenericTypeTypePlaceHolder() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();

    FieldInfo field = new FieldInfo();
    field.setGenericType(new TypePlaceHolder(1));
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");

    FieldMetadataOverride collectionMetadata = new FieldMetadataOverride();
    collectionMetadata.setAddFriendlyName("Add Friendly Name");
    collectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    collectionMetadata.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    collectionMetadata.setAllowNoValueEnumOption(true);
    collectionMetadata.setAssociatedFieldName("Associated Field Name");
    collectionMetadata.setBroadleafEnumeration("Broadleaf Enumeration");
    collectionMetadata.setCanLinkToExternalEntity(true);
    collectionMetadata.setColumnWidth("Column Width");
    collectionMetadata.setCurrencyCodeField("GBP");
    collectionMetadata.setCustomCriteria(new String[]{"Custom Criteria"});
    collectionMetadata.setDeleteEntityUponRemove(true);
    collectionMetadata.setDerived(true);
    collectionMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);
    collectionMetadata.setEnableTypeaheadLookup(true);
    collectionMetadata.setEnumerationClass("Enumeration Class");
    collectionMetadata.setEnumerationValues(new String[][]{new String[]{"42"}});
    collectionMetadata.setExcluded(true);
    collectionMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");
    collectionMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setForceFreeFormKeys(true);
    collectionMetadata.setForcePopulateChildProperties(true);
    collectionMetadata.setForeignKeyClass("Foreign Key Class");
    collectionMetadata.setForeignKeyCollection(true);
    collectionMetadata.setForeignKeyDisplayValueProperty("42");
    collectionMetadata.setForeignKeyProperty("Foreign Key Property");
    collectionMetadata.setFriendlyName("Friendly Name");
    collectionMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    collectionMetadata.setGridOrder(1);
    collectionMetadata.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    collectionMetadata.setGroup("Group");
    collectionMetadata.setGroupCollapsed(true);
    collectionMetadata.setGroupOrder(1);
    collectionMetadata.setHelpText("Help Text");
    collectionMetadata.setHideEnumerationIfEmpty(true);
    collectionMetadata.setHint("Hint");
    collectionMetadata.setIgnoreAdornedProperties(true);
    collectionMetadata.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setJoinEntityClass("Join Entity Class");
    collectionMetadata.setKeyClass("Key Class");
    collectionMetadata.setKeyPropertyFriendlyName("Key Property Friendly Name");
    collectionMetadata.setKeys(new String[][]{new String[]{"Keys"}});
    collectionMetadata.setLargeEntry(true);
    collectionMetadata.setLazyFetch(true);
    collectionMetadata.setLength(3);
    collectionMetadata.setLookupDisplayProperty("Lookup Display Property");
    collectionMetadata.setLookupType(LookupType.STANDARD);
    collectionMetadata.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    collectionMetadata.setManualFetch(true);
    collectionMetadata.setManyToField("Many To Field");
    collectionMetadata.setMapFieldValueClass("42");
    collectionMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    collectionMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    collectionMetadata.setMapKeyOptionEntityValueField("42");
    collectionMetadata.setMapKeyValueProperty("42");
    collectionMetadata.setMediaField("Media Field");
    collectionMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);
    collectionMetadata.setName("Name");
    collectionMetadata.setOptionCanEditValues(true);
    collectionMetadata.setOptionDisplayFieldName("Option Display Field Name");
    collectionMetadata
        .setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    collectionMetadata.setOptionListEntity("Option List Entity");
    collectionMetadata.setOptionValueFieldName("42");
    collectionMetadata.setOrder(1);
    collectionMetadata.setParentObjectIdProperty("Parent Object Id Property");
    collectionMetadata.setParentObjectProperty("Parent Object Property");
    collectionMetadata.setPrecision(1);
    collectionMetadata.setProminent(true);
    collectionMetadata.setReadOnly(true);
    collectionMetadata.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setRequired(true);
    collectionMetadata.setRequiredOverride(true);
    collectionMetadata.setRuleIdentifier("42");
    collectionMetadata.setScale(1);
    collectionMetadata.setSearchable(true);
    collectionMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setSecurityLevel("Security Level");
    collectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();
    collectionMetadata.setShowIfFieldEquals(showIfFieldEquals);
    collectionMetadata.setShowIfProperty("Show If Property");
    collectionMetadata.setSimpleValue(UnspecifiedBooleanType.TRUE);
    collectionMetadata.setSortAscending(true);
    collectionMetadata.setSortProperty("Sort Property");
    collectionMetadata.setTab("Tab");
    collectionMetadata.setTabOrder(1);
    collectionMetadata.setTargetObjectIdProperty("Target Object Id Property");
    collectionMetadata.setTargetObjectProperty("Target Object Property");
    collectionMetadata.setToOneLookupCreatedViaAnnotation(true);
    collectionMetadata.setToOneParentProperty("To One Parent Property");
    collectionMetadata.setToOneTargetProperty("To One Target Property");
    collectionMetadata.setTooltip("127.0.0.1");
    collectionMetadata.setTranslatable(true);
    collectionMetadata.setUnique(true);
    collectionMetadata.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setUseServerSideInspectionCache(true);
    collectionMetadata.setValidationConfigurations(new HashMap<>());
    collectionMetadata.setValueClass("42");
    collectionMetadata.setValuePropertyFriendlyName("42");
    collectionMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    Type genericType = field.getGenericType();
    assertTrue(genericType instanceof TypePlaceHolder);
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    Class<Object> expectedErasedType = Object.class;
    assertEquals(expectedErasedType, ((TypePlaceHolder) genericType).getErasedType());
    assertSame(showIfFieldEquals, collectionMetadata.getShowIfFieldEquals());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FieldInfo} (default constructor) GenericType {@link TypePlaceHolder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CollectionFieldMetadataProvider.buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)"})
  public void testBuildCollectionMetadata_whenNull_thenFieldInfoGenericTypeTypePlaceHolder() {
    // Arrange
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();

    FieldInfo field = new FieldInfo();
    field.setGenericType(new TypePlaceHolder(1));
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");

    FieldMetadataOverride collectionMetadata = new FieldMetadataOverride();
    collectionMetadata.setAddFriendlyName("Add Friendly Name");
    collectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    collectionMetadata.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    collectionMetadata.setAllowNoValueEnumOption(true);
    collectionMetadata.setAssociatedFieldName("Associated Field Name");
    collectionMetadata.setBroadleafEnumeration("Broadleaf Enumeration");
    collectionMetadata.setCanLinkToExternalEntity(true);
    collectionMetadata.setColumnWidth("Column Width");
    collectionMetadata.setCurrencyCodeField("GBP");
    collectionMetadata.setCustomCriteria(new String[]{"Custom Criteria"});
    collectionMetadata.setDeleteEntityUponRemove(true);
    collectionMetadata.setDerived(true);
    collectionMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);
    collectionMetadata.setEnableTypeaheadLookup(true);
    collectionMetadata.setEnumerationClass("Enumeration Class");
    collectionMetadata.setEnumerationValues(new String[][]{new String[]{"42"}});
    collectionMetadata.setExcluded(true);
    collectionMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");
    collectionMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setForceFreeFormKeys(true);
    collectionMetadata.setForcePopulateChildProperties(true);
    collectionMetadata.setForeignKeyClass("Foreign Key Class");
    collectionMetadata.setForeignKeyCollection(true);
    collectionMetadata.setForeignKeyDisplayValueProperty("42");
    collectionMetadata.setForeignKeyProperty("Foreign Key Property");
    collectionMetadata.setFriendlyName("Friendly Name");
    collectionMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    collectionMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    collectionMetadata.setGridOrder(1);
    collectionMetadata.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    collectionMetadata.setGroup("Group");
    collectionMetadata.setGroupCollapsed(true);
    collectionMetadata.setGroupOrder(1);
    collectionMetadata.setHelpText("Help Text");
    collectionMetadata.setHideEnumerationIfEmpty(true);
    collectionMetadata.setHint("Hint");
    collectionMetadata.setIgnoreAdornedProperties(true);
    collectionMetadata.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setJoinEntityClass("Join Entity Class");
    collectionMetadata.setKeyClass("Key Class");
    collectionMetadata.setKeyPropertyFriendlyName("Key Property Friendly Name");
    collectionMetadata.setKeys(new String[][]{new String[]{"Keys"}});
    collectionMetadata.setLargeEntry(true);
    collectionMetadata.setLazyFetch(true);
    collectionMetadata.setLength(3);
    collectionMetadata.setLookupDisplayProperty("Lookup Display Property");
    collectionMetadata.setLookupType(LookupType.STANDARD);
    collectionMetadata.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    collectionMetadata.setManualFetch(true);
    collectionMetadata.setManyToField("Many To Field");
    collectionMetadata.setMapFieldValueClass("42");
    collectionMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    collectionMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    collectionMetadata.setMapKeyOptionEntityValueField("42");
    collectionMetadata.setMapKeyValueProperty("42");
    collectionMetadata.setMediaField("Media Field");
    collectionMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);
    collectionMetadata.setName("Name");
    collectionMetadata.setOptionCanEditValues(true);
    collectionMetadata.setOptionDisplayFieldName("Option Display Field Name");
    collectionMetadata
        .setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    collectionMetadata.setOptionListEntity("Option List Entity");
    collectionMetadata.setOptionValueFieldName("42");
    collectionMetadata.setOrder(1);
    collectionMetadata.setParentObjectIdProperty("Parent Object Id Property");
    collectionMetadata.setParentObjectProperty("Parent Object Property");
    collectionMetadata.setPrecision(1);
    collectionMetadata.setProminent(true);
    collectionMetadata.setReadOnly(true);
    collectionMetadata.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setRequired(true);
    collectionMetadata.setRequiredOverride(true);
    collectionMetadata.setRuleIdentifier("42");
    collectionMetadata.setScale(1);
    collectionMetadata.setSearchable(true);
    collectionMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    collectionMetadata.setSecurityLevel("Security Level");
    collectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();
    collectionMetadata.setShowIfFieldEquals(showIfFieldEquals);
    collectionMetadata.setShowIfProperty("Show If Property");
    collectionMetadata.setSimpleValue(UnspecifiedBooleanType.TRUE);
    collectionMetadata.setSortAscending(true);
    collectionMetadata.setSortProperty("Sort Property");
    collectionMetadata.setTab("Tab");
    collectionMetadata.setTabOrder(1);
    collectionMetadata.setTargetObjectIdProperty("Target Object Id Property");
    collectionMetadata.setTargetObjectProperty("Target Object Property");
    collectionMetadata.setToOneLookupCreatedViaAnnotation(true);
    collectionMetadata.setToOneParentProperty("To One Parent Property");
    collectionMetadata.setToOneTargetProperty("To One Target Property");
    collectionMetadata.setTooltip("127.0.0.1");
    collectionMetadata.setTranslatable(true);
    collectionMetadata.setUnique(true);
    collectionMetadata.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    collectionMetadata.setUseServerSideInspectionCache(true);
    collectionMetadata.setValidationConfigurations(new HashMap<>());
    collectionMetadata.setValueClass("42");
    collectionMetadata.setValuePropertyFriendlyName("42");
    collectionMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(null, targetClass, attributes, field, collectionMetadata,
        "Prefix");

    // Assert
    Type genericType = field.getGenericType();
    assertTrue(genericType instanceof TypePlaceHolder);
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    Class<Object> expectedErasedType = Object.class;
    assertEquals(expectedErasedType, ((TypePlaceHolder) genericType).getErasedType());
    assertSame(showIfFieldEquals, collectionMetadata.getShowIfFieldEquals());
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
  public void testProcessShowIfFieldEqualsAnnotations() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();
    override.setShowIfFieldEquals(showIfFieldEquals);
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    collectionFieldMetadataProvider
        .processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration}, override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    Map<String, List<String>> showIfFieldEquals2 = override.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals2.size());
    List<String> getResult = showIfFieldEquals2.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    assertSame(showIfFieldEquals, showIfFieldEquals2);
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadataOverride#getShowIfFieldEquals()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
  public void testProcessShowIfFieldEqualsAnnotations_thenCallsGetShowIfFieldEquals() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    doNothing().when(override).setAddFriendlyName(Mockito.<String>any());
    doNothing().when(override).setAddMethodType(Mockito.<AddMethodType>any());
    doNothing().when(override).setAddType(Mockito.<OperationType>any());
    doNothing().when(override).setAdornedTargetAddMethodType(Mockito.<AdornedTargetAddMethodType>any());
    doNothing().when(override).setAllowNoValueEnumOption(Mockito.<Boolean>any());
    doNothing().when(override).setAssociatedFieldName(Mockito.<String>any());
    doNothing().when(override).setBroadleafEnumeration(Mockito.<String>any());
    doNothing().when(override).setCanLinkToExternalEntity(Mockito.<Boolean>any());
    doNothing().when(override).setColumnWidth(Mockito.<String>any());
    doNothing().when(override).setCurrencyCodeField(Mockito.<String>any());
    doNothing().when(override).setCustomCriteria(Mockito.<String[]>any());
    doNothing().when(override).setDeleteEntityUponRemove(Mockito.<Boolean>any());
    doNothing().when(override).setDerived(Mockito.<Boolean>any());
    doNothing().when(override).setDisplayType(Mockito.<RuleBuilderDisplayType>any());
    doNothing().when(override).setEnableTypeaheadLookup(Mockito.<Boolean>any());
    doNothing().when(override).setEnumerationClass(Mockito.<String>any());
    doNothing().when(override).setEnumerationValues(Mockito.<String[][]>any());
    doNothing().when(override).setExcluded(Mockito.<Boolean>any());
    doNothing().when(override).setExplicitFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setFetchType(Mockito.<OperationType>any());
    doNothing().when(override).setFieldComponentRenderer(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setFieldComponentRendererTemplate(Mockito.<String>any());
    doNothing().when(override).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setForceFreeFormKeys(Mockito.<Boolean>any());
    doNothing().when(override).setForcePopulateChildProperties(Mockito.<Boolean>any());
    doNothing().when(override).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(override).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(override).setForeignKeyDisplayValueProperty(Mockito.<String>any());
    doNothing().when(override).setForeignKeyProperty(Mockito.<String>any());
    doNothing().when(override).setFriendlyName(Mockito.<String>any());
    doNothing().when(override).setGridFieldComponentRenderer(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setGridFieldComponentRendererTemplate(Mockito.<String>any());
    doNothing().when(override).setGridOrder(Mockito.<Integer>any());
    doNothing().when(override).setGridVisibleFields(Mockito.<String[]>any());
    doNothing().when(override).setGroup(Mockito.<String>any());
    doNothing().when(override).setGroupCollapsed(Mockito.<Boolean>any());
    doNothing().when(override).setGroupOrder(Mockito.<Integer>any());
    doNothing().when(override).setHelpText(Mockito.<String>any());
    doNothing().when(override).setHideEnumerationIfEmpty(Mockito.<Boolean>any());
    doNothing().when(override).setHint(Mockito.<String>any());
    doNothing().when(override).setIgnoreAdornedProperties(Mockito.<Boolean>any());
    doNothing().when(override).setInspectType(Mockito.<OperationType>any());
    doNothing().when(override).setJoinEntityClass(Mockito.<String>any());
    doNothing().when(override).setKeyClass(Mockito.<String>any());
    doNothing().when(override).setKeyPropertyFriendlyName(Mockito.<String>any());
    doNothing().when(override).setKeys(Mockito.<String[][]>any());
    doNothing().when(override).setLargeEntry(Mockito.<Boolean>any());
    doNothing().when(override).setLazyFetch(Mockito.<Boolean>any());
    doNothing().when(override).setLength(Mockito.<Integer>any());
    doNothing().when(override).setLookupDisplayProperty(Mockito.<String>any());
    doNothing().when(override).setLookupType(Mockito.<LookupType>any());
    doNothing().when(override).setMaintainedAdornedTargetFields(Mockito.<String[]>any());
    doNothing().when(override).setManualFetch(Mockito.<Boolean>any());
    doNothing().when(override).setManyToField(Mockito.<String>any());
    doNothing().when(override).setMapFieldValueClass(Mockito.<String>any());
    doNothing().when(override).setMapKeyOptionEntityClass(Mockito.<String>any());
    doNothing().when(override).setMapKeyOptionEntityDisplayField(Mockito.<String>any());
    doNothing().when(override).setMapKeyOptionEntityValueField(Mockito.<String>any());
    doNothing().when(override).setMapKeyValueProperty(Mockito.<String>any());
    doNothing().when(override).setMediaField(Mockito.<String>any());
    doNothing().when(override).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(override).setName(Mockito.<String>any());
    doNothing().when(override).setOptionCanEditValues(Mockito.<Boolean>any());
    doNothing().when(override).setOptionDisplayFieldName(Mockito.<String>any());
    doNothing().when(override).setOptionFilterValues(Mockito.<Serializable[][]>any());
    doNothing().when(override).setOptionListEntity(Mockito.<String>any());
    doNothing().when(override).setOptionValueFieldName(Mockito.<String>any());
    doNothing().when(override).setParentObjectIdProperty(Mockito.<String>any());
    doNothing().when(override).setParentObjectProperty(Mockito.<String>any());
    doNothing().when(override).setPrecision(Mockito.<Integer>any());
    doNothing().when(override).setProminent(Mockito.<Boolean>any());
    doNothing().when(override).setReadOnly(Mockito.<Boolean>any());
    doNothing().when(override).setRemoveType(Mockito.<OperationType>any());
    doNothing().when(override).setRequired(Mockito.<Boolean>any());
    doNothing().when(override).setRequiredOverride(Mockito.<Boolean>any());
    doNothing().when(override).setRuleIdentifier(Mockito.<String>any());
    doNothing().when(override).setScale(Mockito.<Integer>any());
    doNothing().when(override).setSearchable(Mockito.<Boolean>any());
    doNothing().when(override).setSecondaryType(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setSecurityLevel(Mockito.<String>any());
    doNothing().when(override).setSelectizeVisibleField(Mockito.<String>any());
    doNothing().when(override).setShowIfFieldEquals(Mockito.<Map<String, List<String>>>any());
    doNothing().when(override).setShowIfProperty(Mockito.<String>any());
    doNothing().when(override).setSimpleValue(Mockito.<UnspecifiedBooleanType>any());
    doNothing().when(override).setSortAscending(Mockito.<Boolean>any());
    doNothing().when(override).setSortProperty(Mockito.<String>any());
    doNothing().when(override).setTab(Mockito.<String>any());
    doNothing().when(override).setTabOrder(Mockito.<Integer>any());
    doNothing().when(override).setTargetObjectIdProperty(Mockito.<String>any());
    doNothing().when(override).setTargetObjectProperty(Mockito.<String>any());
    doNothing().when(override).setToOneLookupCreatedViaAnnotation(Mockito.<Boolean>any());
    doNothing().when(override).setToOneParentProperty(Mockito.<String>any());
    doNothing().when(override).setToOneTargetProperty(Mockito.<String>any());
    doNothing().when(override).setTooltip(Mockito.<String>any());
    doNothing().when(override).setTranslatable(Mockito.<Boolean>any());
    doNothing().when(override).setUnique(Mockito.<Boolean>any());
    doNothing().when(override).setUpdateType(Mockito.<OperationType>any());
    doNothing().when(override).setUseServerSideInspectionCache(Mockito.<Boolean>any());
    doNothing().when(override).setValidationConfigurations(Mockito.<Map<String, List<Map<String, String>>>>any());
    doNothing().when(override).setValueClass(Mockito.<String>any());
    doNothing().when(override).setValuePropertyFriendlyName(Mockito.<String>any());
    doNothing().when(override).setVisibility(Mockito.<VisibilityEnum>any());
    doNothing().when(override).setOrder(Mockito.<Integer>any());
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> collectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
            new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
    verify(override).setAddFriendlyName(eq("Add Friendly Name"));
    verify(override).setAddMethodType(eq(AddMethodType.PERSIST));
    verify(override).setAddType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setAdornedTargetAddMethodType(eq(AdornedTargetAddMethodType.LOOKUP));
    verify(override).setAllowNoValueEnumOption(eq(true));
    verify(override).setAssociatedFieldName(eq("Associated Field Name"));
    verify(override).setBroadleafEnumeration(eq("Broadleaf Enumeration"));
    verify(override).setCanLinkToExternalEntity(eq(true));
    verify(override).setColumnWidth(eq("Column Width"));
    verify(override).setCurrencyCodeField(eq("GBP"));
    verify(override).setCustomCriteria(isA(String[].class));
    verify(override).setDeleteEntityUponRemove(eq(true));
    verify(override).setDerived(eq(true));
    verify(override).setDisplayType(eq(RuleBuilderDisplayType.NORMAL));
    verify(override).setEnableTypeaheadLookup(eq(true));
    verify(override).setEnumerationClass(eq("Enumeration Class"));
    verify(override).setEnumerationValues(isA(String[][].class));
    verify(override).setExcluded(eq(true));
    verify(override).setExplicitFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(override).setFetchType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setFieldComponentRenderer(eq(SupportedFieldType.UNKNOWN));
    verify(override).setFieldComponentRendererTemplate(eq("Field Component Renderer Template"));
    verify(override).setFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(override).setForceFreeFormKeys(eq(true));
    verify(override).setForcePopulateChildProperties(eq(true));
    verify(override).setForeignKeyClass(eq("Foreign Key Class"));
    verify(override).setForeignKeyCollection(eq(true));
    verify(override).setForeignKeyDisplayValueProperty(eq("42"));
    verify(override).setForeignKeyProperty(eq("Foreign Key Property"));
    verify(override).setFriendlyName(eq("Friendly Name"));
    verify(override).setGridFieldComponentRenderer(eq(SupportedFieldType.UNKNOWN));
    verify(override).setGridFieldComponentRendererTemplate(eq("Grid Field Component Renderer Template"));
    verify(override).setGridOrder(eq(1));
    verify(override).setGridVisibleFields(isA(String[].class));
    verify(override).setGroup(eq("Group"));
    verify(override).setGroupCollapsed(eq(true));
    verify(override).setGroupOrder(eq(1));
    verify(override).setHelpText(eq("Help Text"));
    verify(override).setHideEnumerationIfEmpty(eq(true));
    verify(override).setHint(eq("Hint"));
    verify(override).setIgnoreAdornedProperties(eq(true));
    verify(override).setInspectType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setJoinEntityClass(eq("Join Entity Class"));
    verify(override).setKeyClass(eq("Key Class"));
    verify(override).setKeyPropertyFriendlyName(eq("Key Property Friendly Name"));
    verify(override).setKeys(isA(String[][].class));
    verify(override).setLargeEntry(eq(true));
    verify(override).setLazyFetch(eq(true));
    verify(override).setLength(eq(3));
    verify(override).setLookupDisplayProperty(eq("Lookup Display Property"));
    verify(override).setLookupType(eq(LookupType.STANDARD));
    verify(override).setMaintainedAdornedTargetFields(isA(String[].class));
    verify(override).setManualFetch(eq(true));
    verify(override).setManyToField(eq("Many To Field"));
    verify(override).setMapFieldValueClass(eq("42"));
    verify(override).setMapKeyOptionEntityClass(eq("Map Key Option Entity Class"));
    verify(override).setMapKeyOptionEntityDisplayField(eq("Map Key Option Entity Display Field"));
    verify(override).setMapKeyOptionEntityValueField(eq("42"));
    verify(override).setMapKeyValueProperty(eq("42"));
    verify(override).setMediaField(eq("Media Field"));
    verify(override).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(override).setName(eq("Name"));
    verify(override).setOptionCanEditValues(eq(true));
    verify(override).setOptionDisplayFieldName(eq("Option Display Field Name"));
    verify(override).setOptionFilterValues(isA(Serializable[][].class));
    verify(override).setOptionListEntity(eq("Option List Entity"));
    verify(override).setOptionValueFieldName(eq("42"));
    verify(override).setParentObjectIdProperty(eq("Parent Object Id Property"));
    verify(override).setParentObjectProperty(eq("Parent Object Property"));
    verify(override).setPrecision(eq(1));
    verify(override).setProminent(eq(true));
    verify(override).setReadOnly(eq(true));
    verify(override).setRemoveType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setRequired(eq(true));
    verify(override).setRequiredOverride(eq(true));
    verify(override).setRuleIdentifier(eq("42"));
    verify(override).setScale(eq(1));
    verify(override).setSearchable(eq(true));
    verify(override).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    verify(override).setSecurityLevel(eq("Security Level"));
    verify(override).setSelectizeVisibleField(eq("Selectize Visible Field"));
    verify(override).setShowIfFieldEquals(isA(Map.class));
    verify(override).setShowIfProperty(eq("Show If Property"));
    verify(override).setSimpleValue(eq(UnspecifiedBooleanType.TRUE));
    verify(override).setSortAscending(eq(true));
    verify(override).setSortProperty(eq("Sort Property"));
    verify(override).setTab(eq("Tab"));
    verify(override).setTabOrder(eq(1));
    verify(override).setTargetObjectIdProperty(eq("Target Object Id Property"));
    verify(override).setTargetObjectProperty(eq("Target Object Property"));
    verify(override).setToOneLookupCreatedViaAnnotation(eq(true));
    verify(override).setToOneParentProperty(eq("To One Parent Property"));
    verify(override).setToOneTargetProperty(eq("To One Target Property"));
    verify(override).setTranslatable(eq(true));
    verify(override).setUnique(eq(true));
    verify(override).setUpdateType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setUseServerSideInspectionCache(eq(true));
    verify(override).setValidationConfigurations(isA(Map.class));
    verify(override).setValueClass(eq("42"));
    verify(override).setValuePropertyFriendlyName(eq("42"));
    verify(override).setVisibility(eq(VisibilityEnum.HIDDEN_ALL));
    verify(override).setOrder(eq(1));
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
  public void testProcessShowIfFieldEqualsAnnotations_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> collectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
            new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CollectionFieldMetadataProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.COLLECTION, collectionFieldMetadataProvider.getOrder());
  }
}
