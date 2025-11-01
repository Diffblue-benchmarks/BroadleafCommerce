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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentationMap;
import org.broadleafcommerce.common.presentation.AdminPresentationMapKey;
import org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.client.ForeignKeyRestrictionType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.UnspecifiedBooleanType;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MapMetadata;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.SimpleValueMapStructure;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class MapFieldMetadataProviderDiffblueTest {
  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(mapFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertFalse(mapFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        mapFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        mapFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        mapFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        mapFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#overrideMapMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMapMergeMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMapMergeMetadataResult = mapFieldMetadataProvider
        .overrideMapMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMapMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMapMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMapMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMapMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMapMergeMetadataResult.getKeys());
    assertNull(actualOverrideMapMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMapMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMapMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMapMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMapMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMapMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMapMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMapMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMapMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMapMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMapMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMapMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMapMergeMetadataResult.getRequired());
    assertNull(actualOverrideMapMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMapMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMapMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMapMergeMetadataResult.getUnique());
    assertNull(actualOverrideMapMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMapMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMapMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMapMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMapMergeMetadataResult.isProminent());
    assertNull(actualOverrideMapMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMapMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getLength());
    assertNull(actualOverrideMapMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMapMergeMetadataResult.getScale());
    assertNull(actualOverrideMapMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMapMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMapMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMapMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMapMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMapMergeMetadataResult.getGroup());
    assertNull(actualOverrideMapMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMapMergeMetadataResult.getHint());
    assertNull(actualOverrideMapMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMapMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMapMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMapMergeMetadataResult.getName());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMapMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMapMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMapMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTab());
    assertNull(actualOverrideMapMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMapMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMapMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMapMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMapMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMapMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMapMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMapMergeMetadataResult.getAddType());
    assertNull(actualOverrideMapMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMapMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMapMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMapMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMapMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMapMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMapMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMapMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMapMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMapMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMapMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#overrideMapMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMapMergeMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("currencyCodeField");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMapMergeMetadataResult = mapFieldMetadataProvider
        .overrideMapMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMapMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMapMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideMapMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMapMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMapMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMapMergeMetadataResult.getKeys());
    assertNull(actualOverrideMapMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMapMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMapMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMapMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMapMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMapMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMapMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMapMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMapMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMapMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMapMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMapMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMapMergeMetadataResult.getRequired());
    assertNull(actualOverrideMapMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMapMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMapMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMapMergeMetadataResult.getUnique());
    assertNull(actualOverrideMapMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMapMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMapMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMapMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMapMergeMetadataResult.isProminent());
    assertNull(actualOverrideMapMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMapMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getLength());
    assertNull(actualOverrideMapMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMapMergeMetadataResult.getScale());
    assertNull(actualOverrideMapMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMapMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMapMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMapMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMapMergeMetadataResult.getGroup());
    assertNull(actualOverrideMapMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMapMergeMetadataResult.getHint());
    assertNull(actualOverrideMapMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMapMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMapMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMapMergeMetadataResult.getName());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMapMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMapMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMapMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTab());
    assertNull(actualOverrideMapMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMapMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMapMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMapMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMapMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMapMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMapMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMapMergeMetadataResult.getAddType());
    assertNull(actualOverrideMapMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMapMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMapMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMapMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMapMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMapMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMapMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMapMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMapMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMapMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMapMergeMetadataResult.getSecondaryType());
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#overrideMapMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMapMergeMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.stringArrayOverrideValue()).thenReturn(new String[]{"42"});
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("customCriteria");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMapMergeMetadataResult = mapFieldMetadataProvider
        .overrideMapMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(adminPresentationMergeEntry).stringArrayOverrideValue();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMapMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideMapMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideMapMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideMapMergeMetadataResult.getKeys());
    assertNull(actualOverrideMapMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideMapMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideMapMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideMapMergeMetadataResult.getExcluded());
    assertNull(actualOverrideMapMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideMapMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideMapMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideMapMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMapMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideMapMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideMapMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideMapMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideMapMergeMetadataResult.getRequired());
    assertNull(actualOverrideMapMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideMapMergeMetadataResult.getSearchable());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideMapMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideMapMergeMetadataResult.getUnique());
    assertNull(actualOverrideMapMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideMapMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideMapMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideMapMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideMapMergeMetadataResult.isProminent());
    assertNull(actualOverrideMapMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideMapMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getLength());
    assertNull(actualOverrideMapMergeMetadataResult.getPrecision());
    assertNull(actualOverrideMapMergeMetadataResult.getScale());
    assertNull(actualOverrideMapMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getOrder());
    assertNull(actualOverrideMapMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMapMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMapMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideMapMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideMapMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideMapMergeMetadataResult.getGroup());
    assertNull(actualOverrideMapMergeMetadataResult.getHelpText());
    assertNull(actualOverrideMapMergeMetadataResult.getHint());
    assertNull(actualOverrideMapMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideMapMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideMapMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getManyToField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideMapMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getMediaField());
    assertNull(actualOverrideMapMergeMetadataResult.getName());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideMapMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideMapMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideMapMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMapMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideMapMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTab());
    assertNull(actualOverrideMapMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideMapMergeMetadataResult.getTooltip());
    assertNull(actualOverrideMapMergeMetadataResult.getValueClass());
    assertNull(actualOverrideMapMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideMapMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideMapMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideMapMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideMapMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideMapMergeMetadataResult.getLookupType());
    assertNull(actualOverrideMapMergeMetadataResult.getAddType());
    assertNull(actualOverrideMapMergeMetadataResult.getFetchType());
    assertNull(actualOverrideMapMergeMetadataResult.getInspectType());
    assertNull(actualOverrideMapMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideMapMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideMapMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideMapMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideMapMergeMetadataResult.getFieldType());
    assertNull(actualOverrideMapMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideMapMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideMapMergeMetadataResult.getVisibility());
    assertNull(actualOverrideMapMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideMapMergeMetadataResult.getSecondaryType());
    assertArrayEquals(new String[]{"42"}, actualOverrideMapMergeMetadataResult.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#constructMapMetadataOverride(AdminPresentationMap)}
   */
  @Test
  public void testConstructMapMetadataOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new MapFieldMetadataProvider()).constructMapMetadataOverride(null));
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#constructMapMetadataOverride(AdminPresentationMap)}
   */
  @Test
  public void testConstructMapMetadataOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationMapKey adminPresentationMapKey = mock(AdminPresentationMapKey.class);
    when(adminPresentationMapKey.friendlyKeyName()).thenReturn("Friendly Key Name");
    when(adminPresentationMapKey.keyName()).thenReturn("Key Name");
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    AdminPresentationMap map = mock(AdminPresentationMap.class);
    when(map.forceFreeFormKeys()).thenReturn(true);
    when(map.lazyFetch()).thenReturn(true);
    when(map.manualFetch()).thenReturn(true);
    when(map.currencyCodeField()).thenReturn("GBP");
    when(map.manyToField()).thenReturn("Many To Field");
    when(map.showIfProperty()).thenReturn("Show If Property");
    when(map.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(map.excluded()).thenReturn(true);
    when(map.readOnly()).thenReturn(true);
    when(map.useServerSideInspectionCache()).thenReturn(true);
    when(map.order()).thenReturn(1);
    when(map.tabOrder()).thenReturn(1);
    when(map.friendlyName()).thenReturn("Friendly Name");
    when(map.group()).thenReturn("Group");
    when(map.securityLevel()).thenReturn("Security Level");
    when(map.tab()).thenReturn("Tab");
    when(map.valuePropertyFriendlyName()).thenReturn("42");
    when(map.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.operationTypes()).thenReturn(adminPresentationOperationTypes);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(map.valueClass()).thenReturn(forNameResult);
    when(map.mapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.mapKeyOptionEntityValueField()).thenReturn("42");
    when(map.mediaField()).thenReturn("Media Field");
    when(map.toOneTargetProperty()).thenReturn("One Target Property");
    when(map.isSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(map.mapKeyOptionEntityClass()).thenReturn(forNameResult2);
    when(map.keyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.mapKeyValueProperty()).thenReturn("42");
    when(map.keys()).thenReturn(new AdminPresentationMapKey[]{adminPresentationMapKey});
    when(map.deleteEntityUponRemove()).thenReturn(true);
    Class<Object> forNameResult3 = Object.class;
    Mockito.<Class<?>>when(map.keyClass()).thenReturn(forNameResult3);

    // Act
    FieldMetadataOverride actualConstructMapMetadataOverrideResult = mapFieldMetadataProvider
        .constructMapMetadataOverride(map);

    // Assert
    verify(map).currencyCodeField();
    verify(map).customCriteria();
    verify(map).deleteEntityUponRemove();
    verify(map).excluded();
    verify(map).forceFreeFormKeys();
    verify(map).friendlyName();
    verify(map).group();
    verify(map).isSimpleValue();
    verify(map).keyClass();
    verify(map).keyPropertyFriendlyName();
    verify(map, atLeast(1)).keys();
    verify(map).lazyFetch();
    verify(map).manualFetch();
    verify(map).manyToField();
    verify(map).mapKeyOptionEntityClass();
    verify(map).mapKeyOptionEntityDisplayField();
    verify(map).mapKeyOptionEntityValueField();
    verify(map).mapKeyValueProperty();
    verify(map).mediaField();
    verify(map, atLeast(1)).operationTypes();
    verify(map).order();
    verify(map).readOnly();
    verify(map).securityLevel();
    verify(map, atLeast(1)).showIfFieldEquals();
    verify(map).showIfProperty();
    verify(map).tab();
    verify(map).tabOrder();
    verify(map).toOneTargetProperty();
    verify(map).useServerSideInspectionCache();
    verify(map).valueClass();
    verify(map).valuePropertyFriendlyName();
    verify(adminPresentationMapKey).friendlyKeyName();
    verify(adminPresentationMapKey).keyName();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    Map<String, List<String>> showIfFieldEquals = actualConstructMapMetadataOverrideResult.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    assertEquals("42", actualConstructMapMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertEquals("42", actualConstructMapMetadataOverrideResult.getMapKeyValueProperty());
    assertEquals("42", actualConstructMapMetadataOverrideResult.getValuePropertyFriendlyName());
    assertEquals("Friendly Name", actualConstructMapMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructMapMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructMapMetadataOverrideResult.getGroup());
    assertEquals("Key Property Friendly Name", actualConstructMapMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertEquals("Many To Field", actualConstructMapMetadataOverrideResult.getManyToField());
    assertEquals("Map Key Option Entity Display Field",
        actualConstructMapMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", actualConstructMapMetadataOverrideResult.getMediaField());
    assertEquals("One Target Property", actualConstructMapMetadataOverrideResult.getToOneTargetProperty());
    assertEquals("Security Level", actualConstructMapMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructMapMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructMapMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructMapMetadataOverrideResult.getKeyClass());
    assertEquals("java.lang.Object", actualConstructMapMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertEquals("java.lang.Object", actualConstructMapMetadataOverrideResult.getValueClass());
    assertNull(actualConstructMapMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructMapMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructMapMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructMapMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructMapMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructMapMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructMapMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructMapMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructMapMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructMapMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructMapMetadataOverrideResult.getRequired());
    assertNull(actualConstructMapMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructMapMetadataOverrideResult.getSearchable());
    assertNull(actualConstructMapMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructMapMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructMapMetadataOverrideResult.getUnique());
    assertNull(actualConstructMapMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructMapMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructMapMetadataOverrideResult.isProminent());
    assertNull(actualConstructMapMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructMapMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructMapMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructMapMetadataOverrideResult.getLength());
    assertNull(actualConstructMapMetadataOverrideResult.getPrecision());
    assertNull(actualConstructMapMetadataOverrideResult.getScale());
    assertNull(actualConstructMapMetadataOverrideResult.getAddFriendlyName());
    assertNull(actualConstructMapMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructMapMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructMapMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructMapMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructMapMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructMapMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructMapMetadataOverrideResult.getHelpText());
    assertNull(actualConstructMapMetadataOverrideResult.getHint());
    assertNull(actualConstructMapMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructMapMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructMapMetadataOverrideResult.getName());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructMapMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructMapMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructMapMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getTooltip());
    assertNull(actualConstructMapMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructMapMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructMapMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructMapMetadataOverrideResult.getLookupType());
    assertNull(actualConstructMapMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructMapMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructMapMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructMapMetadataOverrideResult.getFieldType());
    assertNull(actualConstructMapMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructMapMetadataOverrideResult.getVisibility());
    assertNull(actualConstructMapMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructMapMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructMapMetadataOverrideResult.getOrder().intValue());
    String[][] keys = actualConstructMapMetadataOverrideResult.getKeys();
    assertEquals(1, keys.length);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructMapMetadataOverrideResult.getSecondaryType());
    assertEquals(UnspecifiedBooleanType.TRUE, actualConstructMapMetadataOverrideResult.getSimpleValue());
    assertTrue(actualConstructMapMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructMapMetadataOverrideResult.getForceFreeFormKeys());
    assertTrue(actualConstructMapMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructMapMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructMapMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructMapMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructMapMetadataOverrideResult.isDeleteEntityUponRemove());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualConstructMapMetadataOverrideResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Key Name", "Friendly Key Name"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#constructMapMetadataOverride(AdminPresentationMap)}
   */
  @Test
  public void testConstructMapMetadataOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationMapKey adminPresentationMapKey = mock(AdminPresentationMapKey.class);
    when(adminPresentationMapKey.keyName()).thenThrow(new IllegalArgumentException("foo"));
    AdminPresentationMap map = mock(AdminPresentationMap.class);
    when(map.keyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.mapKeyValueProperty()).thenReturn("42");
    when(map.keys()).thenReturn(new AdminPresentationMapKey[]{adminPresentationMapKey});
    when(map.deleteEntityUponRemove()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(map.keyClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapFieldMetadataProvider.constructMapMetadataOverride(map));
    verify(map).deleteEntityUponRemove();
    verify(map).keyClass();
    verify(map).keyPropertyFriendlyName();
    verify(map, atLeast(1)).keys();
    verify(map).mapKeyValueProperty();
    verify(adminPresentationMapKey).keyName();
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#constructMapMetadataOverride(AdminPresentationMap)}
   */
  @Test
  public void testConstructMapMetadataOverride4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationMapKey adminPresentationMapKey = mock(AdminPresentationMapKey.class);
    when(adminPresentationMapKey.friendlyKeyName()).thenReturn("Friendly Key Name");
    when(adminPresentationMapKey.keyName()).thenReturn("Key Name");
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    AdminPresentationMap map = mock(AdminPresentationMap.class);
    when(map.forceFreeFormKeys()).thenReturn(true);
    when(map.lazyFetch()).thenReturn(true);
    when(map.manualFetch()).thenReturn(true);
    when(map.currencyCodeField()).thenReturn("GBP");
    when(map.manyToField()).thenReturn("Many To Field");
    when(map.showIfProperty()).thenReturn("Show If Property");
    when(map.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{});
    when(map.excluded()).thenReturn(true);
    when(map.readOnly()).thenReturn(true);
    when(map.useServerSideInspectionCache()).thenReturn(true);
    when(map.order()).thenReturn(1);
    when(map.tabOrder()).thenReturn(1);
    when(map.friendlyName()).thenReturn("Friendly Name");
    when(map.group()).thenReturn("Group");
    when(map.securityLevel()).thenReturn("Security Level");
    when(map.tab()).thenReturn("Tab");
    when(map.valuePropertyFriendlyName()).thenReturn("42");
    when(map.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.operationTypes()).thenReturn(adminPresentationOperationTypes);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(map.valueClass()).thenReturn(forNameResult);
    when(map.mapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.mapKeyOptionEntityValueField()).thenReturn("42");
    when(map.mediaField()).thenReturn("Media Field");
    when(map.toOneTargetProperty()).thenReturn("One Target Property");
    when(map.isSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(map.mapKeyOptionEntityClass()).thenReturn(forNameResult2);
    when(map.keyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.mapKeyValueProperty()).thenReturn("42");
    when(map.keys()).thenReturn(new AdminPresentationMapKey[]{adminPresentationMapKey});
    when(map.deleteEntityUponRemove()).thenReturn(true);
    Class<Object> forNameResult3 = Object.class;
    Mockito.<Class<?>>when(map.keyClass()).thenReturn(forNameResult3);

    // Act
    FieldMetadataOverride actualConstructMapMetadataOverrideResult = mapFieldMetadataProvider
        .constructMapMetadataOverride(map);

    // Assert
    verify(map).currencyCodeField();
    verify(map).customCriteria();
    verify(map).deleteEntityUponRemove();
    verify(map).excluded();
    verify(map).forceFreeFormKeys();
    verify(map).friendlyName();
    verify(map).group();
    verify(map).isSimpleValue();
    verify(map).keyClass();
    verify(map).keyPropertyFriendlyName();
    verify(map, atLeast(1)).keys();
    verify(map).lazyFetch();
    verify(map).manualFetch();
    verify(map).manyToField();
    verify(map).mapKeyOptionEntityClass();
    verify(map).mapKeyOptionEntityDisplayField();
    verify(map).mapKeyOptionEntityValueField();
    verify(map).mapKeyValueProperty();
    verify(map).mediaField();
    verify(map, atLeast(1)).operationTypes();
    verify(map).order();
    verify(map).readOnly();
    verify(map).securityLevel();
    verify(map).showIfFieldEquals();
    verify(map).showIfProperty();
    verify(map).tab();
    verify(map).tabOrder();
    verify(map).toOneTargetProperty();
    verify(map).useServerSideInspectionCache();
    verify(map).valueClass();
    verify(map).valuePropertyFriendlyName();
    verify(adminPresentationMapKey).friendlyKeyName();
    verify(adminPresentationMapKey).keyName();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    assertEquals("42", actualConstructMapMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertEquals("42", actualConstructMapMetadataOverrideResult.getMapKeyValueProperty());
    assertEquals("42", actualConstructMapMetadataOverrideResult.getValuePropertyFriendlyName());
    assertEquals("Friendly Name", actualConstructMapMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructMapMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructMapMetadataOverrideResult.getGroup());
    assertEquals("Key Property Friendly Name", actualConstructMapMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertEquals("Many To Field", actualConstructMapMetadataOverrideResult.getManyToField());
    assertEquals("Map Key Option Entity Display Field",
        actualConstructMapMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", actualConstructMapMetadataOverrideResult.getMediaField());
    assertEquals("One Target Property", actualConstructMapMetadataOverrideResult.getToOneTargetProperty());
    assertEquals("Security Level", actualConstructMapMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructMapMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructMapMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructMapMetadataOverrideResult.getKeyClass());
    assertEquals("java.lang.Object", actualConstructMapMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertEquals("java.lang.Object", actualConstructMapMetadataOverrideResult.getValueClass());
    assertNull(actualConstructMapMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructMapMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructMapMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructMapMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructMapMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructMapMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructMapMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructMapMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructMapMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructMapMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructMapMetadataOverrideResult.getRequired());
    assertNull(actualConstructMapMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructMapMetadataOverrideResult.getSearchable());
    assertNull(actualConstructMapMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructMapMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructMapMetadataOverrideResult.getUnique());
    assertNull(actualConstructMapMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructMapMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructMapMetadataOverrideResult.isProminent());
    assertNull(actualConstructMapMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructMapMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructMapMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructMapMetadataOverrideResult.getLength());
    assertNull(actualConstructMapMetadataOverrideResult.getPrecision());
    assertNull(actualConstructMapMetadataOverrideResult.getScale());
    assertNull(actualConstructMapMetadataOverrideResult.getAddFriendlyName());
    assertNull(actualConstructMapMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructMapMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructMapMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructMapMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructMapMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructMapMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructMapMetadataOverrideResult.getHelpText());
    assertNull(actualConstructMapMetadataOverrideResult.getHint());
    assertNull(actualConstructMapMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructMapMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructMapMetadataOverrideResult.getName());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructMapMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructMapMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructMapMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructMapMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructMapMetadataOverrideResult.getTooltip());
    assertNull(actualConstructMapMetadataOverrideResult.getShowIfFieldEquals());
    assertNull(actualConstructMapMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructMapMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructMapMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructMapMetadataOverrideResult.getLookupType());
    assertNull(actualConstructMapMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructMapMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructMapMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructMapMetadataOverrideResult.getFieldType());
    assertNull(actualConstructMapMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructMapMetadataOverrideResult.getVisibility());
    assertNull(actualConstructMapMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructMapMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructMapMetadataOverrideResult.getOrder().intValue());
    String[][] keys = actualConstructMapMetadataOverrideResult.getKeys();
    assertEquals(1, keys.length);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualConstructMapMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructMapMetadataOverrideResult.getSecondaryType());
    assertEquals(UnspecifiedBooleanType.TRUE, actualConstructMapMetadataOverrideResult.getSimpleValue());
    assertTrue(actualConstructMapMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructMapMetadataOverrideResult.getForceFreeFormKeys());
    assertTrue(actualConstructMapMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructMapMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructMapMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructMapMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructMapMetadataOverrideResult.isDeleteEntityUponRemove());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualConstructMapMetadataOverrideResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Key Name", "Friendly Key Name"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#constructMapMetadataOverride(AdminPresentationMap)}
   */
  @Test
  public void testConstructMapMetadataOverride5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationMapKey adminPresentationMapKey = mock(AdminPresentationMapKey.class);
    when(adminPresentationMapKey.friendlyKeyName()).thenReturn("Friendly Key Name");
    when(adminPresentationMapKey.keyName()).thenReturn("Key Name");
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));
    AdminPresentationMap map = mock(AdminPresentationMap.class);
    when(map.showIfProperty()).thenReturn("Show If Property");
    when(map.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(map.excluded()).thenReturn(true);
    when(map.readOnly()).thenReturn(true);
    when(map.useServerSideInspectionCache()).thenReturn(true);
    when(map.order()).thenReturn(1);
    when(map.tabOrder()).thenReturn(1);
    when(map.friendlyName()).thenReturn("Friendly Name");
    when(map.group()).thenReturn("Group");
    when(map.securityLevel()).thenReturn("Security Level");
    when(map.tab()).thenReturn("Tab");
    when(map.valuePropertyFriendlyName()).thenReturn("42");
    when(map.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.operationTypes()).thenReturn(adminPresentationOperationTypes);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(map.valueClass()).thenReturn(forNameResult);
    when(map.mapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.mapKeyOptionEntityValueField()).thenReturn("42");
    when(map.mediaField()).thenReturn("Media Field");
    when(map.toOneTargetProperty()).thenReturn("One Target Property");
    when(map.isSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(map.mapKeyOptionEntityClass()).thenReturn(forNameResult2);
    when(map.keyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.mapKeyValueProperty()).thenReturn("42");
    when(map.keys()).thenReturn(new AdminPresentationMapKey[]{adminPresentationMapKey});
    when(map.deleteEntityUponRemove()).thenReturn(true);
    Class<Object> forNameResult3 = Object.class;
    Mockito.<Class<?>>when(map.keyClass()).thenReturn(forNameResult3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapFieldMetadataProvider.constructMapMetadataOverride(map));
    verify(map).customCriteria();
    verify(map).deleteEntityUponRemove();
    verify(map).excluded();
    verify(map).friendlyName();
    verify(map).group();
    verify(map).isSimpleValue();
    verify(map).keyClass();
    verify(map).keyPropertyFriendlyName();
    verify(map, atLeast(1)).keys();
    verify(map).mapKeyOptionEntityClass();
    verify(map).mapKeyOptionEntityDisplayField();
    verify(map).mapKeyOptionEntityValueField();
    verify(map).mapKeyValueProperty();
    verify(map).mediaField();
    verify(map, atLeast(1)).operationTypes();
    verify(map).order();
    verify(map).readOnly();
    verify(map).securityLevel();
    verify(map, atLeast(1)).showIfFieldEquals();
    verify(map).showIfProperty();
    verify(map).tab();
    verify(map).tabOrder();
    verify(map).toOneTargetProperty();
    verify(map).useServerSideInspectionCache();
    verify(map).valueClass();
    verify(map).valuePropertyFriendlyName();
    verify(adminPresentationMapKey).friendlyKeyName();
    verify(adminPresentationMapKey).keyName();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#constructMapMetadataOverride(AdminPresentationMap)}
   */
  @Test
  public void testConstructMapMetadataOverride6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));
    AdminPresentationMap map = mock(AdminPresentationMap.class);
    when(map.showIfProperty()).thenReturn("Show If Property");
    when(map.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(map.excluded()).thenReturn(true);
    when(map.readOnly()).thenReturn(true);
    when(map.useServerSideInspectionCache()).thenReturn(true);
    when(map.order()).thenReturn(1);
    when(map.tabOrder()).thenReturn(1);
    when(map.friendlyName()).thenReturn("Friendly Name");
    when(map.group()).thenReturn("Group");
    when(map.securityLevel()).thenReturn("Security Level");
    when(map.tab()).thenReturn("Tab");
    when(map.valuePropertyFriendlyName()).thenReturn("42");
    when(map.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.operationTypes()).thenReturn(adminPresentationOperationTypes);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(map.valueClass()).thenReturn(forNameResult);
    when(map.mapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.mapKeyOptionEntityValueField()).thenReturn("42");
    when(map.mediaField()).thenReturn("Media Field");
    when(map.toOneTargetProperty()).thenReturn("One Target Property");
    when(map.isSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(map.mapKeyOptionEntityClass()).thenReturn(forNameResult2);
    when(map.keyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.mapKeyValueProperty()).thenReturn("42");
    when(map.keys()).thenReturn(null);
    when(map.deleteEntityUponRemove()).thenReturn(true);
    Class<Object> forNameResult3 = Object.class;
    Mockito.<Class<?>>when(map.keyClass()).thenReturn(forNameResult3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapFieldMetadataProvider.constructMapMetadataOverride(map));
    verify(map).customCriteria();
    verify(map).deleteEntityUponRemove();
    verify(map).excluded();
    verify(map).friendlyName();
    verify(map).group();
    verify(map).isSimpleValue();
    verify(map).keyClass();
    verify(map).keyPropertyFriendlyName();
    verify(map).keys();
    verify(map).mapKeyOptionEntityClass();
    verify(map).mapKeyOptionEntityDisplayField();
    verify(map).mapKeyOptionEntityValueField();
    verify(map).mapKeyValueProperty();
    verify(map).mediaField();
    verify(map, atLeast(1)).operationTypes();
    verify(map).order();
    verify(map).readOnly();
    verify(map).securityLevel();
    verify(map, atLeast(1)).showIfFieldEquals();
    verify(map).showIfProperty();
    verify(map).tab();
    verify(map).tabOrder();
    verify(map).toOneTargetProperty();
    verify(map).useServerSideInspectionCache();
    verify(map).valueClass();
    verify(map).valuePropertyFriendlyName();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#constructMapMetadataOverride(AdminPresentationMap)}
   */
  @Test
  public void testConstructMapMetadataOverride7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));
    AdminPresentationMap map = mock(AdminPresentationMap.class);
    when(map.showIfProperty()).thenReturn("Show If Property");
    when(map.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(map.excluded()).thenReturn(true);
    when(map.readOnly()).thenReturn(true);
    when(map.useServerSideInspectionCache()).thenReturn(true);
    when(map.order()).thenReturn(1);
    when(map.tabOrder()).thenReturn(1);
    when(map.friendlyName()).thenReturn("Friendly Name");
    when(map.group()).thenReturn("Group");
    when(map.securityLevel()).thenReturn("Security Level");
    when(map.tab()).thenReturn("Tab");
    when(map.valuePropertyFriendlyName()).thenReturn("42");
    when(map.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.operationTypes()).thenReturn(adminPresentationOperationTypes);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(map.valueClass()).thenReturn(forNameResult);
    when(map.mapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.mapKeyOptionEntityValueField()).thenReturn("42");
    when(map.mediaField()).thenReturn("Media Field");
    when(map.toOneTargetProperty()).thenReturn("One Target Property");
    when(map.isSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(map.mapKeyOptionEntityClass()).thenReturn(forNameResult2);
    when(map.keyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.mapKeyValueProperty()).thenReturn("42");
    when(map.keys()).thenReturn(new AdminPresentationMapKey[]{});
    when(map.deleteEntityUponRemove()).thenReturn(true);
    Class<Object> forNameResult3 = Object.class;
    Mockito.<Class<?>>when(map.keyClass()).thenReturn(forNameResult3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapFieldMetadataProvider.constructMapMetadataOverride(map));
    verify(map).customCriteria();
    verify(map).deleteEntityUponRemove();
    verify(map).excluded();
    verify(map).friendlyName();
    verify(map).group();
    verify(map).isSimpleValue();
    verify(map).keyClass();
    verify(map).keyPropertyFriendlyName();
    verify(map).keys();
    verify(map).mapKeyOptionEntityClass();
    verify(map).mapKeyOptionEntityDisplayField();
    verify(map).mapKeyOptionEntityValueField();
    verify(map).mapKeyValueProperty();
    verify(map).mediaField();
    verify(map, atLeast(1)).operationTypes();
    verify(map).order();
    verify(map).readOnly();
    verify(map).securityLevel();
    verify(map, atLeast(1)).showIfFieldEquals();
    verify(map).showIfProperty();
    verify(map).tab();
    verify(map).tabOrder();
    verify(map).toOneTargetProperty();
    verify(map).useServerSideInspectionCache();
    verify(map).valueClass();
    verify(map).valuePropertyFriendlyName();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getReadOnly()).thenReturn(true);
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenThrow(new RuntimeException("name"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass,
        attributes, field, map, dynamicEntityDao, "Prefix"));
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field, atLeast(1)).getName();
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(null);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(getResult.getExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(null);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(getResult.getLazyFetch());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(null);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(getResult.getManualFetch());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(null);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(null);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(getResult.getTabOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(null);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(getResult.getOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn(null);
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getCurrencyCodeField());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn(null);
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn(null);
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getGroup());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyMappedBy()).thenReturn("Many To Many Mapped By");
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn(null);
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getManyToManyMappedBy();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Many Mapped By", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyMappedBy()).thenReturn("Many To Many Mapped By");
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getManyToManyMappedBy();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Many Mapped By", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn(null);
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(getResult.getSecurityLevel());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn(null);
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(getResult.getTab());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(null);
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(((MapMetadata) getResult).getCustomCriteria());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(null);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(((MapMetadata) getResult).getForceFreeFormKeys());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata18() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn(null);
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata19() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn(null);
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata20() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("void");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata21() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn(null);
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata22() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn(null);
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn(null);
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata24() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn(null);
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Map Key", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("Map Key", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata25() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn(null);
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(((MapMetadata) getResult).getMediaField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata26() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn(null);
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(getResult.getShowIfProperty());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata27() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn(null);
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(((MapMetadata) getResult).getToOneParentProperty());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata28() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn(null);
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(((MapMetadata) getResult).getToOneTargetProperty());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata29() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("void");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field, atLeast(1)).getGenericType();
    verify(field, atLeast(1)).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Many To Many Target Entity", ((MapMetadata) getResult).getValueClassName());
    assertEquals("Many To Many Target Entity", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata30() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn(null);
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field, atLeast(1)).getGenericType();
    verify(field, atLeast(1)).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Many To Many Target Entity", ((MapMetadata) getResult).getValueClassName());
    assertEquals("Many To Many Target Entity", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata31() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn(null);
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertNull(((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata32() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(null);
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(((MapMetadata) getResult).getKeys());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata33() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(null);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.MAP, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata34() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(null);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.MAP, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata35() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(null);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.MAP, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata36() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(null);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.MAP, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata37() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(null);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.TRUE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof SimpleValueMapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValueClassName());
    assertEquals("42", ((SimpleValueMapStructure) getResult3).getValuePropertyFriendlyName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((SimpleValueMapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((SimpleValueMapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((SimpleValueMapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((SimpleValueMapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((SimpleValueMapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertEquals("value", ((SimpleValueMapStructure) getResult3).getValuePropertyName());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.MAP, operationTypes.getUpdateType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((SimpleValueMapStructure) getResult3).getDeleteValueEntity());
    assertFalse(((SimpleValueMapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapMetadata) getResult).isSimpleValue());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata38() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(null);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field, atLeast(1)).getGenericType();
    verify(field).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof MapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((MapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((MapStructure) getResult3).getValueClassName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((MapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((MapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((MapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((MapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((MapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((MapMetadata) getResult).isSimpleValue());
    assertFalse(((MapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapStructure) getResult3).getDeleteValueEntity());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata39() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.FALSE);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field).getGenericType();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof MapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((MapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((MapStructure) getResult3).getValueClassName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((MapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((MapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((MapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((MapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((MapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((MapMetadata) getResult).isSimpleValue());
    assertFalse(((MapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapStructure) getResult3).getDeleteValueEntity());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#buildMapMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao, String)}
   */
  @Test
  public void testBuildMapMetadata40() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getMapKey()).thenReturn("Map Key");
    when(field.getName()).thenReturn("Name");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    FieldMetadataOverride map = mock(FieldMetadataOverride.class);
    when(map.getExcluded()).thenReturn(true);
    when(map.getLazyFetch()).thenReturn(true);
    when(map.getManualFetch()).thenReturn(true);
    when(map.getUseServerSideInspectionCache()).thenReturn(true);
    when(map.getTabOrder()).thenReturn(1);
    when(map.getOrder()).thenReturn(1);
    when(map.getCurrencyCodeField()).thenReturn("GBP");
    when(map.getFriendlyName()).thenReturn("Friendly Name");
    when(map.getGroup()).thenReturn("Group");
    when(map.getManyToField()).thenReturn("Many To Field");
    when(map.getSecurityLevel()).thenReturn("Security Level");
    when(map.getTab()).thenReturn("Tab");
    when(map.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(map.getForceFreeFormKeys()).thenReturn(true);
    when(map.getReadOnly()).thenReturn(true);
    when(map.isDeleteEntityUponRemove()).thenReturn(true);
    when(map.getKeyClass()).thenReturn("void");
    when(map.getKeyPropertyFriendlyName()).thenReturn("Key Property Friendly Name");
    when(map.getMapKeyOptionEntityClass()).thenReturn("Map Key Option Entity Class");
    when(map.getMapKeyOptionEntityDisplayField()).thenReturn("Map Key Option Entity Display Field");
    when(map.getMapKeyOptionEntityValueField()).thenReturn("42");
    when(map.getMapKeyValueProperty()).thenReturn("42");
    when(map.getMediaField()).thenReturn("Media Field");
    when(map.getShowIfProperty()).thenReturn("Show If Property");
    when(map.getToOneParentProperty()).thenReturn("To One Parent Property");
    when(map.getToOneTargetProperty()).thenReturn("To One Target Property");
    when(map.getValueClass()).thenReturn("42");
    when(map.getValuePropertyFriendlyName()).thenReturn("42");
    when(map.getKeys()).thenReturn(new String[][]{new String[]{"Keys"}});
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    when(map.getShowIfFieldEquals()).thenReturn(stringListMap);
    when(map.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(map.getSimpleValue()).thenReturn(UnspecifiedBooleanType.UNSPECIFIED);
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.buildMapMetadata(parentClass, targetClass, attributes, field, map, dynamicEntityDao,
        "Prefix");

    // Assert
    verify(map, atLeast(1)).getAddType();
    verify(map, atLeast(1)).getCurrencyCodeField();
    verify(map, atLeast(1)).getCustomCriteria();
    verify(map, atLeast(1)).getExcluded();
    verify(map, atLeast(1)).getFetchType();
    verify(map, atLeast(1)).getForceFreeFormKeys();
    verify(map, atLeast(1)).getFriendlyName();
    verify(map, atLeast(1)).getGroup();
    verify(map, atLeast(1)).getInspectType();
    verify(map, atLeast(1)).getKeyClass();
    verify(map, atLeast(1)).getKeyPropertyFriendlyName();
    verify(map, atLeast(1)).getKeys();
    verify(map, atLeast(1)).getLazyFetch();
    verify(map, atLeast(1)).getManualFetch();
    verify(map, atLeast(1)).getManyToField();
    verify(map, atLeast(1)).getMapKeyOptionEntityClass();
    verify(map, atLeast(1)).getMapKeyOptionEntityDisplayField();
    verify(map, atLeast(1)).getMapKeyOptionEntityValueField();
    verify(map, atLeast(1)).getMapKeyValueProperty();
    verify(map, atLeast(1)).getMediaField();
    verify(map, atLeast(1)).getReadOnly();
    verify(map, atLeast(1)).getRemoveType();
    verify(map, atLeast(1)).getSecurityLevel();
    verify(map, atLeast(1)).getShowIfFieldEquals();
    verify(map, atLeast(1)).getShowIfProperty();
    verify(map, atLeast(1)).getSimpleValue();
    verify(map, atLeast(1)).getTab();
    verify(map, atLeast(1)).getTabOrder();
    verify(map, atLeast(1)).getToOneParentProperty();
    verify(map, atLeast(1)).getToOneTargetProperty();
    verify(map, atLeast(1)).getUpdateType();
    verify(map, atLeast(1)).getUseServerSideInspectionCache();
    verify(map, atLeast(1)).getValueClass();
    verify(map, atLeast(1)).getValuePropertyFriendlyName();
    verify(map, atLeast(1)).isDeleteEntityUponRemove();
    verify(map, atLeast(1)).getOrder();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(field, atLeast(1)).getGenericType();
    verify(field).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getMapKey();
    verify(field, atLeast(1)).getName();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    PersistencePerspective persistencePerspective = ((MapMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertTrue(getResult instanceof MapMetadata);
    PersistencePerspectiveItem getResult3 = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.MAPSTRUCTURE);
    assertTrue(getResult3 instanceof MapStructure);
    assertEquals("42", ((MapMetadata) getResult).getMapKeyOptionEntityValueField());
    assertEquals("42", ((MapMetadata) getResult).getMapKeyValueProperty());
    assertEquals("42", ((MapMetadata) getResult).getValueClassName());
    assertEquals("42", ((MapStructure) getResult3).getMapKeyValueProperty());
    assertEquals("42", ((MapStructure) getResult3).getValueClassName());
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("GBP", getResult.getCurrencyCodeField());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Key Property Friendly Name", ((MapStructure) getResult3).getKeyPropertyFriendlyName());
    assertEquals("Many To Field", ((MapStructure) getResult3).getManyToField());
    assertEquals("Map Key Option Entity Class", ((MapMetadata) getResult).getMapKeyOptionEntityClass());
    assertEquals("Map Key Option Entity Display Field", ((MapMetadata) getResult).getMapKeyOptionEntityDisplayField());
    assertEquals("Media Field", ((MapMetadata) getResult).getMediaField());
    assertEquals("Name", getResult.getFieldName());
    assertEquals("Prefix", getResult.getPrefix());
    assertEquals("PrefixName", ((MapStructure) getResult3).getMapProperty());
    assertEquals("Security Level", getResult.getSecurityLevel());
    assertEquals("Show If Property", getResult.getShowIfProperty());
    assertEquals("Tab", getResult.getTab());
    assertEquals("To One Parent Property", ((MapMetadata) getResult).getToOneParentProperty());
    assertEquals("To One Target Property", ((MapMetadata) getResult).getToOneTargetProperty());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals("java.lang.Object", ((ForeignKey) getResult2).getForeignKeyClass());
    assertEquals("java.lang.String", ((MapStructure) getResult3).getKeyClassName());
    assertEquals("key", ((MapStructure) getResult3).getKeyPropertyName());
    assertEquals("name", ((ForeignKey) getResult2).getDisplayValueProperty());
    assertNull(getResult.getAvailableToTypes());
    assertNull(getResult.getChildrenExcluded());
    assertNull(((ForeignKey) getResult2).getSortAscending());
    assertNull(getResult.getGroupOrder());
    assertNull(((MapMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertNull(getResult.getInheritedFromType());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getOwningClassFriendlyName());
    assertNull(((ForeignKey) getResult2).getCurrentValue());
    assertNull(((ForeignKey) getResult2).getDataSourceName());
    assertNull(((ForeignKey) getResult2).getManyToField());
    assertNull(((ForeignKey) getResult2).getOriginatingField());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertNull(persistencePerspective.getConfigurationKey());
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective.getExcludeFields().length);
    assertEquals(0, persistencePerspective.getIncludeFields().length);
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1, getResult.getTabOrder().intValue());
    String[][] keys = ((MapMetadata) getResult).getKeys();
    assertEquals(1, keys.length);
    assertEquals(ForeignKeyRestrictionType.ID_EQ, ((ForeignKey) getResult2).getRestrictionType());
    OperationTypes operationTypes = persistencePerspective.getOperationTypes();
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
    assertFalse(((MapMetadata) getResult).isMutable());
    assertFalse(((MapMetadata) getResult).isSimpleValue());
    assertFalse(((MapStructure) getResult3).getMutable());
    assertFalse(persistencePerspective.getPopulateToOneFields());
    assertFalse(persistencePerspective.getShowArchivedFields());
    assertTrue(getResult.getAdditionalMetadata().isEmpty());
    Map<String, List<String>> showIfFieldEquals = getResult.getShowIfFieldEquals();
    assertTrue(showIfFieldEquals.isEmpty());
    assertTrue(getResult.getExcluded());
    assertTrue(getResult.getLazyFetch());
    assertTrue(getResult.getManualFetch());
    assertTrue(((ForeignKey) getResult2).getMutable());
    assertTrue(((MapMetadata) getResult).getForceFreeFormKeys());
    assertTrue(((MapStructure) getResult3).getDeleteValueEntity());
    assertTrue(persistencePerspective.getUseServerSideInspectionCache());
    assertSame(stringListMap, showIfFieldEquals);
    assertArrayEquals(new String[]{"Custom Criteria"}, ((MapMetadata) getResult).getCustomCriteria());
    assertArrayEquals(new String[]{"Keys"}, keys[0]);
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    mapFieldMetadataProvider.processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration},
        override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Method under test:
   * {@link MapFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapFieldMetadataProvider mapFieldMetadataProvider = new MapFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Method under test: {@link MapFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.MAP, (new MapFieldMetadataProvider()).getOrder());
  }
}
