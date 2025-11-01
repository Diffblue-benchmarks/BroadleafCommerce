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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration;
import org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup;
import org.broadleafcommerce.common.presentation.ConfigurationItem;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.OptionFilterParam;
import org.broadleafcommerce.common.presentation.OptionFilterParamType;
import org.broadleafcommerce.common.presentation.RequiredOverride;
import org.broadleafcommerce.common.presentation.ValidationConfiguration;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicFieldMetadataProviderDiffblueTest {
  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(basicFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertFalse(basicFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        basicFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        basicFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("friendlyName");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("addFriendlyName");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("securityLevel");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("group");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("tab");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("columnWidth");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("broadleafEnumeration");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("hideEnumerationIfEmpty");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMergeMetadataResult.getKeys());
    assertNull(actualOverrideMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMergeMetadataResult.getRequired());
    assertNull(actualOverrideMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMergeMetadataResult.getUnique());
    assertNull(actualOverrideMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMergeMetadataResult.isProminent());
    assertNull(actualOverrideMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMergeMetadataResult.getLength());
    assertNull(actualOverrideMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMergeMetadataResult.getScale());
    assertNull(actualOverrideMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMergeMetadataResult.getOrder());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMergeMetadataResult.getHint());
    assertNull(actualOverrideMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMergeMetadataResult.getName());
    assertNull(actualOverrideMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMergeMetadataResult.getAddType());
    assertNull(actualOverrideMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMergeMetadataResult.getSecondaryType());
    assertFalse(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new BasicFieldMetadataProvider()).constructBasicMetadataOverride(null, null, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Serializable[][] optionFilterValues = actualConstructBasicMetadataOverrideResult.getOptionFilterValues();
    Serializable[] serializableArray = optionFilterValues[0];
    Serializable serializable = serializableArray[2];
    assertTrue(serializable instanceof OptionFilterParamType);
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicMetadataOverrideResult.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult2 = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult2.size());
    Map<String, String> getResult3 = getResult2.get(0);
    assertEquals(1, getResult3.size());
    assertEquals("42", getResult3.get("Item Name"));
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getDefaultValue());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getOptionValueFieldName());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getRuleIdentifier());
    assertEquals("42", serializableArray[1]);
    assertEquals("Add Friendly Name", actualConstructBasicMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Associated Field Name", actualConstructBasicMetadataOverrideResult.getAssociatedFieldName());
    assertEquals("Broadleaf Enumeration", actualConstructBasicMetadataOverrideResult.getBroadleafEnumeration());
    assertEquals("Column Width", actualConstructBasicMetadataOverrideResult.getColumnWidth());
    assertEquals("Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertEquals("Friendly Name", actualConstructBasicMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Grid Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertEquals("Group", actualConstructBasicMetadataOverrideResult.getGroup());
    assertEquals("Help Text", actualConstructBasicMetadataOverrideResult.getHelpText());
    assertEquals("Hint", actualConstructBasicMetadataOverrideResult.getHint());
    assertEquals("Lookup Display Property", actualConstructBasicMetadataOverrideResult.getLookupDisplayProperty());
    assertEquals("Option Display Field Name", actualConstructBasicMetadataOverrideResult.getOptionDisplayFieldName());
    assertEquals("Param", serializableArray[0]);
    assertEquals("Security Level", actualConstructBasicMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructBasicMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructBasicMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructBasicMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicMetadataOverrideResult.getLazyFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getManualFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructBasicMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getManyToField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicMetadataOverrideResult.getName());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructBasicMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddType());
    assertNull(actualConstructBasicMetadataOverrideResult.getFetchType());
    assertNull(actualConstructBasicMetadataOverrideResult.getInspectType());
    assertNull(actualConstructBasicMetadataOverrideResult.getRemoveType());
    assertNull(actualConstructBasicMetadataOverrideResult.getUpdateType());
    assertNull(actualConstructBasicMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGridOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGroupOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getOrder().intValue());
    assertEquals(1, optionFilterValues.length);
    assertEquals(3, serializableArray.length);
    assertEquals(OptionFilterParamType.BOOLEAN, serializable);
    assertEquals(LookupType.STANDARD, actualConstructBasicMetadataOverrideResult.getLookupType());
    assertEquals(RuleBuilderDisplayType.NORMAL, actualConstructBasicMetadataOverrideResult.getDisplayType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION,
        actualConstructBasicMetadataOverrideResult.getExplicitFieldType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION, actualConstructBasicMetadataOverrideResult.getFieldType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicMetadataOverrideResult.getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, actualConstructBasicMetadataOverrideResult.getFieldComponentRenderer());
    assertEquals(SupportedFieldType.UNKNOWN,
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRenderer());
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualConstructBasicMetadataOverrideResult.getVisibility());
    assertTrue(actualConstructBasicMetadataOverrideResult.getAllowNoValueEnumOption());
    assertTrue(actualConstructBasicMetadataOverrideResult.getCanLinkToExternalEntity());
    assertTrue(actualConstructBasicMetadataOverrideResult.getEnableTypeaheadLookup());
    assertTrue(actualConstructBasicMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicMetadataOverrideResult.getForcePopulateChildProperties());
    assertTrue(actualConstructBasicMetadataOverrideResult.getGroupCollapsed());
    assertTrue(actualConstructBasicMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertTrue(actualConstructBasicMetadataOverrideResult.getOptionCanEditValues());
    assertTrue(actualConstructBasicMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
    assertTrue(actualConstructBasicMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertTrue(actualConstructBasicMetadataOverrideResult.getTranslatable());
    assertTrue(actualConstructBasicMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicMetadataOverrideResult.isLargeEntry());
    assertTrue(actualConstructBasicMetadataOverrideResult.isProminent());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualConstructBasicMetadataOverrideResult.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(null);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Serializable[][] optionFilterValues = actualConstructBasicMetadataOverrideResult.getOptionFilterValues();
    Serializable[] serializableArray = optionFilterValues[0];
    Serializable serializable = serializableArray[2];
    assertTrue(serializable instanceof OptionFilterParamType);
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicMetadataOverrideResult.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult2 = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult2.size());
    Map<String, String> getResult3 = getResult2.get(0);
    assertEquals(1, getResult3.size());
    assertEquals("42", getResult3.get("Item Name"));
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getDefaultValue());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getOptionValueFieldName());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getRuleIdentifier());
    assertEquals("42", serializableArray[1]);
    assertEquals("Add Friendly Name", actualConstructBasicMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Associated Field Name", actualConstructBasicMetadataOverrideResult.getAssociatedFieldName());
    assertEquals("Broadleaf Enumeration", actualConstructBasicMetadataOverrideResult.getBroadleafEnumeration());
    assertEquals("Column Width", actualConstructBasicMetadataOverrideResult.getColumnWidth());
    assertEquals("Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertEquals("Friendly Name", actualConstructBasicMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Grid Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertEquals("Group", actualConstructBasicMetadataOverrideResult.getGroup());
    assertEquals("Help Text", actualConstructBasicMetadataOverrideResult.getHelpText());
    assertEquals("Hint", actualConstructBasicMetadataOverrideResult.getHint());
    assertEquals("Lookup Display Property", actualConstructBasicMetadataOverrideResult.getLookupDisplayProperty());
    assertEquals("Option Display Field Name", actualConstructBasicMetadataOverrideResult.getOptionDisplayFieldName());
    assertEquals("Param", serializableArray[0]);
    assertEquals("Security Level", actualConstructBasicMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructBasicMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructBasicMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructBasicMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicMetadataOverrideResult.getLazyFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getManualFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructBasicMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getManyToField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicMetadataOverrideResult.getName());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructBasicMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddType());
    assertNull(actualConstructBasicMetadataOverrideResult.getFetchType());
    assertNull(actualConstructBasicMetadataOverrideResult.getInspectType());
    assertNull(actualConstructBasicMetadataOverrideResult.getRemoveType());
    assertNull(actualConstructBasicMetadataOverrideResult.getUpdateType());
    assertNull(actualConstructBasicMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGridOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGroupOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getOrder().intValue());
    assertEquals(1, optionFilterValues.length);
    assertEquals(3, serializableArray.length);
    assertEquals(OptionFilterParamType.BOOLEAN, serializable);
    assertEquals(LookupType.STANDARD, actualConstructBasicMetadataOverrideResult.getLookupType());
    assertEquals(RuleBuilderDisplayType.NORMAL, actualConstructBasicMetadataOverrideResult.getDisplayType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION,
        actualConstructBasicMetadataOverrideResult.getExplicitFieldType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION, actualConstructBasicMetadataOverrideResult.getFieldType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicMetadataOverrideResult.getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, actualConstructBasicMetadataOverrideResult.getFieldComponentRenderer());
    assertEquals(SupportedFieldType.UNKNOWN,
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRenderer());
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualConstructBasicMetadataOverrideResult.getVisibility());
    assertFalse(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
    assertTrue(actualConstructBasicMetadataOverrideResult.getAllowNoValueEnumOption());
    assertTrue(actualConstructBasicMetadataOverrideResult.getCanLinkToExternalEntity());
    assertTrue(actualConstructBasicMetadataOverrideResult.getEnableTypeaheadLookup());
    assertTrue(actualConstructBasicMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicMetadataOverrideResult.getForcePopulateChildProperties());
    assertTrue(actualConstructBasicMetadataOverrideResult.getGroupCollapsed());
    assertTrue(actualConstructBasicMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertTrue(actualConstructBasicMetadataOverrideResult.getOptionCanEditValues());
    assertTrue(actualConstructBasicMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertTrue(actualConstructBasicMetadataOverrideResult.getTranslatable());
    assertTrue(actualConstructBasicMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicMetadataOverrideResult.isLargeEntry());
    assertTrue(actualConstructBasicMetadataOverrideResult.isProminent());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualConstructBasicMetadataOverrideResult.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.IGNORED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Serializable[][] optionFilterValues = actualConstructBasicMetadataOverrideResult.getOptionFilterValues();
    Serializable[] serializableArray = optionFilterValues[0];
    Serializable serializable = serializableArray[2];
    assertTrue(serializable instanceof OptionFilterParamType);
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicMetadataOverrideResult.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult2 = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult2.size());
    Map<String, String> getResult3 = getResult2.get(0);
    assertEquals(1, getResult3.size());
    assertEquals("42", getResult3.get("Item Name"));
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getDefaultValue());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getOptionValueFieldName());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getRuleIdentifier());
    assertEquals("42", serializableArray[1]);
    assertEquals("Add Friendly Name", actualConstructBasicMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Associated Field Name", actualConstructBasicMetadataOverrideResult.getAssociatedFieldName());
    assertEquals("Broadleaf Enumeration", actualConstructBasicMetadataOverrideResult.getBroadleafEnumeration());
    assertEquals("Column Width", actualConstructBasicMetadataOverrideResult.getColumnWidth());
    assertEquals("Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertEquals("Friendly Name", actualConstructBasicMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Grid Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertEquals("Group", actualConstructBasicMetadataOverrideResult.getGroup());
    assertEquals("Help Text", actualConstructBasicMetadataOverrideResult.getHelpText());
    assertEquals("Hint", actualConstructBasicMetadataOverrideResult.getHint());
    assertEquals("Lookup Display Property", actualConstructBasicMetadataOverrideResult.getLookupDisplayProperty());
    assertEquals("Option Display Field Name", actualConstructBasicMetadataOverrideResult.getOptionDisplayFieldName());
    assertEquals("Param", serializableArray[0]);
    assertEquals("Security Level", actualConstructBasicMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructBasicMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructBasicMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructBasicMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicMetadataOverrideResult.getLazyFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getManualFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructBasicMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructBasicMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getManyToField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicMetadataOverrideResult.getName());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructBasicMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddType());
    assertNull(actualConstructBasicMetadataOverrideResult.getFetchType());
    assertNull(actualConstructBasicMetadataOverrideResult.getInspectType());
    assertNull(actualConstructBasicMetadataOverrideResult.getRemoveType());
    assertNull(actualConstructBasicMetadataOverrideResult.getUpdateType());
    assertNull(actualConstructBasicMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGridOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGroupOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getOrder().intValue());
    assertEquals(1, optionFilterValues.length);
    assertEquals(3, serializableArray.length);
    assertEquals(OptionFilterParamType.BOOLEAN, serializable);
    assertEquals(LookupType.STANDARD, actualConstructBasicMetadataOverrideResult.getLookupType());
    assertEquals(RuleBuilderDisplayType.NORMAL, actualConstructBasicMetadataOverrideResult.getDisplayType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION,
        actualConstructBasicMetadataOverrideResult.getExplicitFieldType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION, actualConstructBasicMetadataOverrideResult.getFieldType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicMetadataOverrideResult.getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, actualConstructBasicMetadataOverrideResult.getFieldComponentRenderer());
    assertEquals(SupportedFieldType.UNKNOWN,
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRenderer());
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualConstructBasicMetadataOverrideResult.getVisibility());
    assertTrue(actualConstructBasicMetadataOverrideResult.getAllowNoValueEnumOption());
    assertTrue(actualConstructBasicMetadataOverrideResult.getCanLinkToExternalEntity());
    assertTrue(actualConstructBasicMetadataOverrideResult.getEnableTypeaheadLookup());
    assertTrue(actualConstructBasicMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicMetadataOverrideResult.getForcePopulateChildProperties());
    assertTrue(actualConstructBasicMetadataOverrideResult.getGroupCollapsed());
    assertTrue(actualConstructBasicMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertTrue(actualConstructBasicMetadataOverrideResult.getOptionCanEditValues());
    assertTrue(actualConstructBasicMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertTrue(actualConstructBasicMetadataOverrideResult.getTranslatable());
    assertTrue(actualConstructBasicMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicMetadataOverrideResult.isLargeEntry());
    assertTrue(actualConstructBasicMetadataOverrideResult.isProminent());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualConstructBasicMetadataOverrideResult.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenReturn(new ConfigurationItem[]{configurationItem, mock(ConfigurationItem.class)});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(configurationItem).itemName();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    Serializable[][] optionFilterValues = actualConstructBasicMetadataOverrideResult.getOptionFilterValues();
    Serializable[] serializableArray = optionFilterValues[0];
    Serializable serializable = serializableArray[2];
    assertTrue(serializable instanceof OptionFilterParamType);
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicMetadataOverrideResult.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getDefaultValue());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getOptionValueFieldName());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getRuleIdentifier());
    assertEquals("42", serializableArray[1]);
    assertEquals("Add Friendly Name", actualConstructBasicMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Associated Field Name", actualConstructBasicMetadataOverrideResult.getAssociatedFieldName());
    assertEquals("Broadleaf Enumeration", actualConstructBasicMetadataOverrideResult.getBroadleafEnumeration());
    assertEquals("Column Width", actualConstructBasicMetadataOverrideResult.getColumnWidth());
    assertEquals("Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertEquals("Friendly Name", actualConstructBasicMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Grid Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertEquals("Group", actualConstructBasicMetadataOverrideResult.getGroup());
    assertEquals("Help Text", actualConstructBasicMetadataOverrideResult.getHelpText());
    assertEquals("Hint", actualConstructBasicMetadataOverrideResult.getHint());
    assertEquals("Lookup Display Property", actualConstructBasicMetadataOverrideResult.getLookupDisplayProperty());
    assertEquals("Option Display Field Name", actualConstructBasicMetadataOverrideResult.getOptionDisplayFieldName());
    assertEquals("Param", serializableArray[0]);
    assertEquals("Security Level", actualConstructBasicMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructBasicMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructBasicMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructBasicMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicMetadataOverrideResult.getLazyFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getManualFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructBasicMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getManyToField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicMetadataOverrideResult.getName());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructBasicMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddType());
    assertNull(actualConstructBasicMetadataOverrideResult.getFetchType());
    assertNull(actualConstructBasicMetadataOverrideResult.getInspectType());
    assertNull(actualConstructBasicMetadataOverrideResult.getRemoveType());
    assertNull(actualConstructBasicMetadataOverrideResult.getUpdateType());
    assertNull(actualConstructBasicMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGridOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGroupOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getOrder().intValue());
    assertEquals(1, optionFilterValues.length);
    assertEquals(3, serializableArray.length);
    assertEquals(OptionFilterParamType.BOOLEAN, serializable);
    assertEquals(LookupType.STANDARD, actualConstructBasicMetadataOverrideResult.getLookupType());
    assertEquals(RuleBuilderDisplayType.NORMAL, actualConstructBasicMetadataOverrideResult.getDisplayType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION,
        actualConstructBasicMetadataOverrideResult.getExplicitFieldType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION, actualConstructBasicMetadataOverrideResult.getFieldType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicMetadataOverrideResult.getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, actualConstructBasicMetadataOverrideResult.getFieldComponentRenderer());
    assertEquals(SupportedFieldType.UNKNOWN,
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRenderer());
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualConstructBasicMetadataOverrideResult.getVisibility());
    assertTrue(actualConstructBasicMetadataOverrideResult.getAllowNoValueEnumOption());
    assertTrue(actualConstructBasicMetadataOverrideResult.getCanLinkToExternalEntity());
    assertTrue(actualConstructBasicMetadataOverrideResult.getEnableTypeaheadLookup());
    assertTrue(actualConstructBasicMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicMetadataOverrideResult.getForcePopulateChildProperties());
    assertTrue(actualConstructBasicMetadataOverrideResult.getGroupCollapsed());
    assertTrue(actualConstructBasicMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertTrue(actualConstructBasicMetadataOverrideResult.getOptionCanEditValues());
    assertTrue(actualConstructBasicMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
    assertTrue(actualConstructBasicMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertTrue(actualConstructBasicMetadataOverrideResult.getTranslatable());
    assertTrue(actualConstructBasicMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicMetadataOverrideResult.isLargeEntry());
    assertTrue(actualConstructBasicMetadataOverrideResult.isProminent());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualConstructBasicMetadataOverrideResult.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations())
        .thenReturn(new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations())
        .thenReturn(new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName())
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot).visibility();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.broadleafEnumeration()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot, null, null));
    verify(annot).broadleafEnumeration();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessValidationAnnotations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getValidationConfigurations()).thenReturn(new HashMap<>());

    // Act
    basicFieldMetadataProvider.processValidationAnnotations(new ValidationConfiguration[]{validationConfiguration},
        override);

    // Assert
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    verify(override, atLeast(1)).getValidationConfigurations();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessValidationAnnotations2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenThrow(new IllegalArgumentException("foo"));
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenReturn(new ConfigurationItem[]{configurationItem, mock(ConfigurationItem.class)});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.processValidationAnnotations(
        new ValidationConfiguration[]{validationConfiguration}, mock(FieldMetadataOverride.class)));
    verify(configurationItem).itemName();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessValidationAnnotations3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    new IllegalArgumentException("foo");
    new IllegalArgumentException("foo");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicFieldMetadataProvider.processValidationAnnotations(
            new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)},
            mock(FieldMetadataOverride.class)));
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    basicFieldMetadataProvider
        .processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration}, override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildBasicMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride basicFieldMetadata = mock(FieldMetadataOverride.class);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getExcluded()).thenReturn(true);
    when(basicFieldMetadata.getForcePopulateChildProperties()).thenReturn(true);
    when(basicFieldMetadata.getGroupCollapsed()).thenReturn(true);
    when(basicFieldMetadata.getHideEnumerationIfEmpty()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getToOneLookupCreatedViaAnnotation()).thenReturn(true);
    when(basicFieldMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAddFriendlyName()).thenReturn("Add Friendly Name");
    when(basicFieldMetadata.getBroadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getCurrencyCodeField()).thenReturn("GBP");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getLookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(basicFieldMetadata.getOptionDisplayFieldName()).thenReturn(null);
    when(basicFieldMetadata.getOptionListEntity()).thenReturn("Option List Entity");
    when(basicFieldMetadata.getOptionValueFieldName()).thenReturn("42");
    when(basicFieldMetadata.getSecurityLevel()).thenReturn("Security Level");
    when(basicFieldMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(basicFieldMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getDisplayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(basicFieldMetadata.getExplicitFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getGridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.buildBasicMetadata(parentClass,
        targetClass, attributes, field, basicFieldMetadata, mock(DynamicEntityDao.class)));
    verify(basicFieldMetadata, atLeast(1)).getAddFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getBroadleafEnumeration();
    verify(basicFieldMetadata, atLeast(1)).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getCurrencyCodeField();
    verify(basicFieldMetadata, atLeast(1)).getCustomCriteria();
    verify(basicFieldMetadata, atLeast(1)).getDisplayType();
    verify(basicFieldMetadata, atLeast(1)).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getExcluded();
    verify(basicFieldMetadata, atLeast(1)).getExplicitFieldType();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForcePopulateChildProperties();
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getGridOrder();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata, atLeast(1)).getGroupCollapsed();
    verify(basicFieldMetadata, atLeast(1)).getGroupOrder();
    verify(basicFieldMetadata, atLeast(1)).getHelpText();
    verify(basicFieldMetadata, atLeast(1)).getHideEnumerationIfEmpty();
    verify(basicFieldMetadata, atLeast(1)).getHint();
    verify(basicFieldMetadata, atLeast(1)).getLookupDisplayProperty();
    verify(basicFieldMetadata).getOptionDisplayFieldName();
    verify(basicFieldMetadata, atLeast(1)).getOptionListEntity();
    verify(basicFieldMetadata, atLeast(1)).getOptionValueFieldName();
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(basicFieldMetadata, atLeast(1)).getSecurityLevel();
    verify(basicFieldMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(basicFieldMetadata, atLeast(1)).getShowIfProperty();
    verify(basicFieldMetadata, atLeast(1)).getTab();
    verify(basicFieldMetadata, atLeast(1)).getTabOrder();
    verify(basicFieldMetadata, atLeast(1)).getToOneLookupCreatedViaAnnotation();
    verify(basicFieldMetadata, atLeast(1)).getTooltip();
    verify(basicFieldMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isLargeEntry();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Method under test:
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildBasicMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride basicFieldMetadata = mock(FieldMetadataOverride.class);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getExcluded()).thenReturn(true);
    when(basicFieldMetadata.getForcePopulateChildProperties()).thenReturn(true);
    when(basicFieldMetadata.getGroupCollapsed()).thenReturn(true);
    when(basicFieldMetadata.getHideEnumerationIfEmpty()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getToOneLookupCreatedViaAnnotation()).thenReturn(true);
    when(basicFieldMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAddFriendlyName()).thenReturn("Add Friendly Name");
    when(basicFieldMetadata.getBroadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getCurrencyCodeField()).thenReturn("GBP");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getLookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(basicFieldMetadata.getOptionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(basicFieldMetadata.getOptionListEntity()).thenReturn("Option List Entity");
    when(basicFieldMetadata.getOptionValueFieldName()).thenReturn(null);
    when(basicFieldMetadata.getSecurityLevel()).thenReturn("Security Level");
    when(basicFieldMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(basicFieldMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getDisplayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(basicFieldMetadata.getExplicitFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getGridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.buildBasicMetadata(parentClass,
        targetClass, attributes, field, basicFieldMetadata, mock(DynamicEntityDao.class)));
    verify(basicFieldMetadata, atLeast(1)).getAddFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getBroadleafEnumeration();
    verify(basicFieldMetadata, atLeast(1)).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getCurrencyCodeField();
    verify(basicFieldMetadata, atLeast(1)).getCustomCriteria();
    verify(basicFieldMetadata, atLeast(1)).getDisplayType();
    verify(basicFieldMetadata, atLeast(1)).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getExcluded();
    verify(basicFieldMetadata, atLeast(1)).getExplicitFieldType();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForcePopulateChildProperties();
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getGridOrder();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata, atLeast(1)).getGroupCollapsed();
    verify(basicFieldMetadata, atLeast(1)).getGroupOrder();
    verify(basicFieldMetadata, atLeast(1)).getHelpText();
    verify(basicFieldMetadata, atLeast(1)).getHideEnumerationIfEmpty();
    verify(basicFieldMetadata, atLeast(1)).getHint();
    verify(basicFieldMetadata, atLeast(1)).getLookupDisplayProperty();
    verify(basicFieldMetadata, atLeast(1)).getOptionDisplayFieldName();
    verify(basicFieldMetadata, atLeast(1)).getOptionListEntity();
    verify(basicFieldMetadata).getOptionValueFieldName();
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(basicFieldMetadata, atLeast(1)).getSecurityLevel();
    verify(basicFieldMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(basicFieldMetadata, atLeast(1)).getShowIfProperty();
    verify(basicFieldMetadata, atLeast(1)).getTab();
    verify(basicFieldMetadata, atLeast(1)).getTabOrder();
    verify(basicFieldMetadata, atLeast(1)).getToOneLookupCreatedViaAnnotation();
    verify(basicFieldMetadata, atLeast(1)).getTooltip();
    verify(basicFieldMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isLargeEntry();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Method under test: {@link BasicFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new BasicFieldMetadataProvider()).getOrder());
  }
}
