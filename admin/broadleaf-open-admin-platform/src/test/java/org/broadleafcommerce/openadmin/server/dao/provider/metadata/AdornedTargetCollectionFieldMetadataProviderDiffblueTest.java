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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection;
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
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
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
public class AdornedTargetCollectionFieldMetadataProviderDiffblueTest {
  @InjectMocks
  private AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;

  @Mock
  private Map map;

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdornedTargetCollectionFieldMetadataProvider.canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)"})
  public void testCanHandleAnnotationOverride_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(adornedTargetCollectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest,
        new HashMap<>()));
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse AdornedTargetCollectionFieldMetadataProvider.overrideViaAnnotation(OverrideViaAnnotationRequest, Map)"})
  public void testOverrideViaAnnotation_whenJavaLangObject_thenReturnNotHandled() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, adornedTargetCollectionFieldMetadataProvider
        .overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse AdornedTargetCollectionFieldMetadataProvider.overrideViaXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideViaXml_givenMapGetReturnHashMap_thenReturnHandled() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    MetadataProviderResponse actualOverrideViaXmlResult = adornedTargetCollectionFieldMetadataProvider
        .overrideViaXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED, actualOverrideViaXmlResult);
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse AdornedTargetCollectionFieldMetadataProvider.overrideViaXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideViaXml_givenMapGetReturnNull_thenReturnHandled() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    MetadataProviderResponse actualOverrideViaXmlResult = adornedTargetCollectionFieldMetadataProvider
        .overrideViaXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED, actualOverrideViaXmlResult);
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideAdornedTargetMergeMetadata() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideAdornedTargetMergeMetadataResult = adornedTargetCollectionFieldMetadataProvider
        .overrideAdornedTargetMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExcluded());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequired());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSearchable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUnique());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isProminent());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLength());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getPrecision());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getScale());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHelpText());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHint());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManyToField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMediaField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTab());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTooltip());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFetchType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getInspectType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getVisibility());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideAdornedTargetMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideAdornedTargetMergeMetadata_thenReturnArrayLengthIsOne() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.stringArrayOverrideValue()).thenReturn(new String[]{"42"});
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("customCriteria");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideAdornedTargetMergeMetadataResult = adornedTargetCollectionFieldMetadataProvider
        .overrideAdornedTargetMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(adminPresentationMergeEntry).stringArrayOverrideValue();
    verify(merge).mergeEntries();
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExcluded());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequired());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSearchable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUnique());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isProminent());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLength());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getPrecision());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getScale());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHelpText());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHint());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManyToField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMediaField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTab());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTooltip());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFetchType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getInspectType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getVisibility());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMergedPropertyType());
    assertEquals(1, actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria().length);
    assertEquals(SupportedFieldType.INTEGER, actualOverrideAdornedTargetMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return CurrencyCodeField is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideAdornedTargetMergeMetadata_thenReturnCurrencyCodeFieldIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("currencyCodeField");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideAdornedTargetMergeMetadataResult = adornedTargetCollectionFieldMetadataProvider
        .overrideAdornedTargetMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideAdornedTargetMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExcluded());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequired());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSearchable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUnique());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isProminent());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLength());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getPrecision());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getScale());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHelpText());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHint());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManyToField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMediaField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTab());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTooltip());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFetchType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getInspectType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getVisibility());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideAdornedTargetMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)"})
  public void testConstructAdornedTargetCollectionMetadataOverride() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adornedTargetCollectionFieldMetadataProvider.constructAdornedTargetCollectionMetadataOverride(null));
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)"})
  public void testConstructAdornedTargetCollectionMetadataOverride2() {
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
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.lazyFetch()).thenReturn(true);
    when(adornedTargetCollection.manualFetch()).thenReturn(true);
    when(adornedTargetCollection.currencyCodeField()).thenReturn("GBP");
    when(adornedTargetCollection.showIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollection.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(adornedTargetCollection.addType()).thenReturn(AdornedTargetAddMethodType.LOOKUP);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act
    FieldMetadataOverride actualConstructAdornedTargetCollectionMetadataOverrideResult = adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection);

    // Assert
    verify(adornedTargetCollection).addType();
    verify(adornedTargetCollection).currencyCodeField();
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).lazyFetch();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).manualFetch();
    verify(adornedTargetCollection, atLeast(1)).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection, atLeast(1)).showIfFieldEquals();
    verify(adornedTargetCollection).showIfProperty();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    assertEquals("Friendly Name", actualConstructAdornedTargetCollectionMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructAdornedTargetCollectionMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroup());
    assertEquals("Join Entity Class",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getJoinEntityClass());
    assertEquals("Parent Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectIdProperty());
    assertEquals("Parent Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectProperty());
    assertEquals("Security Level", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecurityLevel());
    assertEquals("Selectize Visible Field",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSelectizeVisibleField());
    assertEquals("Show If Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getShowIfProperty());
    assertEquals("Sort Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSortProperty());
    assertEquals("Tab", actualConstructAdornedTargetCollectionMetadataOverrideResult.getTab());
    assertEquals("Target Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectIdProperty());
    assertEquals("Target Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequired());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSearchable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUnique());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isProminent());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLength());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getPrecision());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getScale());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHelpText());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHint());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManyToField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMediaField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTooltip());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getVisibility());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getOrder().intValue());
    Map<String, List<String>> showIfFieldEquals = actualConstructAdornedTargetCollectionMetadataOverrideResult
        .getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getCustomCriteria().length);
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridVisibleFields().length);
    assertEquals(1,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields().length);
    assertEquals(AdornedTargetAddMethodType.LOOKUP,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecondaryType());
    assertTrue(showIfFieldEquals.containsKey("Field Name"));
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isIgnoreAdornedProperties());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isSortAscending());
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)"})
  public void testConstructAdornedTargetCollectionMetadataOverride3() {
    // Arrange
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection));
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)"})
  public void testConstructAdornedTargetCollectionMetadataOverride4() {
    // Arrange
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.lazyFetch()).thenReturn(true);
    when(adornedTargetCollection.manualFetch()).thenReturn(true);
    when(adornedTargetCollection.currencyCodeField()).thenReturn("GBP");
    when(adornedTargetCollection.showIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollection.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{});
    when(adornedTargetCollection.addType()).thenReturn(AdornedTargetAddMethodType.LOOKUP);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act
    FieldMetadataOverride actualConstructAdornedTargetCollectionMetadataOverrideResult = adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection);

    // Assert
    verify(adornedTargetCollection).addType();
    verify(adornedTargetCollection).currencyCodeField();
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).lazyFetch();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).manualFetch();
    verify(adornedTargetCollection, atLeast(1)).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection).showIfFieldEquals();
    verify(adornedTargetCollection).showIfProperty();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    assertEquals("Friendly Name", actualConstructAdornedTargetCollectionMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructAdornedTargetCollectionMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroup());
    assertEquals("Join Entity Class",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getJoinEntityClass());
    assertEquals("Parent Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectIdProperty());
    assertEquals("Parent Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectProperty());
    assertEquals("Security Level", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecurityLevel());
    assertEquals("Selectize Visible Field",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSelectizeVisibleField());
    assertEquals("Show If Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getShowIfProperty());
    assertEquals("Sort Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSortProperty());
    assertEquals("Tab", actualConstructAdornedTargetCollectionMetadataOverrideResult.getTab());
    assertEquals("Target Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectIdProperty());
    assertEquals("Target Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequired());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSearchable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUnique());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isProminent());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLength());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getPrecision());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getScale());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHelpText());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHint());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManyToField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMediaField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTooltip());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getShowIfFieldEquals());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getVisibility());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getOrder().intValue());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getCustomCriteria().length);
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridVisibleFields().length);
    assertEquals(1,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields().length);
    assertEquals(AdornedTargetAddMethodType.LOOKUP,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecondaryType());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isIgnoreAdornedProperties());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isSortAscending());
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride AdornedTargetCollectionFieldMetadataProvider.constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)"})
  public void testConstructAdornedTargetCollectionMetadataOverride5() {
    // Arrange
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.lazyFetch()).thenReturn(true);
    when(adornedTargetCollection.manualFetch()).thenReturn(true);
    when(adornedTargetCollection.currencyCodeField()).thenReturn("GBP");
    when(adornedTargetCollection.showIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollection.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(adornedTargetCollection.addType()).thenReturn(AdornedTargetAddMethodType.LOOKUP);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection));
    verify(adornedTargetCollection).addType();
    verify(adornedTargetCollection).currencyCodeField();
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).lazyFetch();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).manualFetch();
    verify(adornedTargetCollection, atLeast(1)).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection, atLeast(1)).showIfFieldEquals();
    verify(adornedTargetCollection).showIfProperty();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)"})
  public void testBuildAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass,
            targetClass, attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class)));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)"})
  public void testBuildAdornedTargetCollectionMetadata_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass,
            targetClass, attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class)));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AdornedTargetCollectionFieldMetadataProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.ADORNED_TARGET, adornedTargetCollectionFieldMetadataProvider.getOrder());
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
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
    adornedTargetCollectionFieldMetadataProvider
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
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadataOverride#getShowIfFieldEquals()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
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
        () -> adornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
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
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
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
        () -> adornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
            new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
  }
}
