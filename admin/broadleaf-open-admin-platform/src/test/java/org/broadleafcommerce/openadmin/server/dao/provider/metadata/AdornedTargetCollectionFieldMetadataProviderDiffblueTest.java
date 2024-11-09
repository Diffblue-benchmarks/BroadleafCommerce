/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection;
import org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
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
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class AdornedTargetCollectionFieldMetadataProviderDiffblueTest {
  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(adornedTargetCollectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest,
        new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertFalse(adornedTargetCollectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest,
        new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, adornedTargetCollectionFieldMetadataProvider
        .overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, adornedTargetCollectionFieldMetadataProvider
        .overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        adornedTargetCollectionFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        adornedTargetCollectionFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideAdornedTargetMergeMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
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
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideAdornedTargetMergeMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
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
    assertArrayEquals(new String[]{"42"}, actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return CurrencyCodeField is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideAdornedTargetMergeMetadata_thenReturnCurrencyCodeFieldIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
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
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AdornedTargetCollectionFieldMetadataProvider())
        .constructAdornedTargetCollectionMetadataOverride(null));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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
    Map<String, List<String>> showIfFieldEquals = actualConstructAdornedTargetCollectionMetadataOverrideResult
        .getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
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
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeys());
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
    assertArrayEquals(new String[]{"Custom Criteria"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Grid Visible Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridVisibleFields());
    assertArrayEquals(new String[]{"Maintained Adorned Target Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeys());
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
    assertArrayEquals(new String[]{"Custom Criteria"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Grid Visible Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridVisibleFields());
    assertArrayEquals(new String[]{"Maintained Adorned Target Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.ADORNED_TARGET, (new AdornedTargetCollectionFieldMetadataProvider()).getOrder());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls {@link FieldValueConfiguration#fieldValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenCallsFieldValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    adornedTargetCollectionFieldMetadataProvider
        .processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration}, override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenThrowNoSuchBeanDefinitionException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> adornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
            new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }
}
