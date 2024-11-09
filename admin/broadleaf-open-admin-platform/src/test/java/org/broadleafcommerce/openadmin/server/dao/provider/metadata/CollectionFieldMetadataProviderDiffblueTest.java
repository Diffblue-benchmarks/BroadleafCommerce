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
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentationCollection;
import org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class CollectionFieldMetadataProviderDiffblueTest {
  /**
   * Test
   * {@link CollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(
        collectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertFalse(
        collectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        collectionFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        collectionFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        collectionFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        collectionFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideCollectionMergeMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
    assertNull(actualOverrideCollectionMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeys());
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
   * Test
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideCollectionMergeMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
   * Test
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return CurrencyCodeField is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideCollectionMergeMetadata_thenReturnCurrencyCodeFieldIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
    assertNull(actualOverrideCollectionMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeys());
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
   * Test
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return SelectizeVisibleField is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#overrideCollectionMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideCollectionMergeMetadata_thenReturnSelectizeVisibleFieldIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
    assertNull(actualOverrideCollectionMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideCollectionMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideCollectionMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideCollectionMergeMetadataResult.getKeys());
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
   * Test
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  public void testConstructBasicCollectionMetadataOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicCollectionMetadataOverrideResult
        .getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
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
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeys());
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
    assertArrayEquals(new String[]{"Custom Criteria"},
        actualConstructBasicCollectionMetadataOverrideResult.getCustomCriteria());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  public void testConstructBasicCollectionMetadataOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
   * Test
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  public void testConstructBasicCollectionMetadataOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
   * Test
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <ul>
   *   <li>Then return ShowIfFieldEquals is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  public void testConstructBasicCollectionMetadataOverride_thenReturnShowIfFieldEqualsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
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
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicCollectionMetadataOverrideResult.getKeys());
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
    assertArrayEquals(new String[]{"Custom Criteria"},
        actualConstructBasicCollectionMetadataOverrideResult.getCustomCriteria());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#constructBasicCollectionMetadataOverride(AdminPresentationCollection)}
   */
  @Test
  public void testConstructBasicCollectionMetadataOverride_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new CollectionFieldMetadataProvider()).constructBasicCollectionMetadataOverride(null));
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(true);
    when(collectionMetadata.getUseServerSideInspectionCache()).thenReturn(null);
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
    verify(collectionMetadata).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    when(field.getOneToManyMappedBy()).thenReturn("One To Many Mapped By");
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
    when(collectionMetadata.getManyToField()).thenReturn(null);
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
    verify(collectionMetadata).getManyToField();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyMappedBy();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Mapped By", ((ForeignKey) getResult2).getManyToField());
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getAddType()).thenReturn(null);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(collectionMetadata, atLeast(1)).getAddFriendlyName();
    verify(collectionMetadata, atLeast(1)).getAddMethodType();
    verify(collectionMetadata).getAddType();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective = ((BasicCollectionMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertEquals(OperationType.BASIC, persistencePerspective.getOperationTypes().getAddType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getFetchType()).thenReturn(null);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

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
    verify(collectionMetadata).getFetchType();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective = ((BasicCollectionMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertEquals(OperationType.BASIC, persistencePerspective.getOperationTypes().getFetchType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getInspectType()).thenReturn(null);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

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
    verify(collectionMetadata).getInspectType();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective = ((BasicCollectionMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertEquals(OperationType.BASIC, persistencePerspective.getOperationTypes().getInspectType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getRemoveType()).thenReturn(null);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

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
    verify(collectionMetadata).getRemoveType();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective = ((BasicCollectionMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertEquals(OperationType.BASIC, persistencePerspective.getOperationTypes().getRemoveType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getUpdateType()).thenReturn(null);

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
    verify(collectionMetadata).getUpdateType();
    verify(collectionMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective = ((BasicCollectionMetadata) getResult).getPersistencePerspective();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertEquals(OperationType.BASIC, persistencePerspective.getOperationTypes().getUpdateType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getOneToManyTargetEntity()).thenReturn("");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getName();
    verify(field).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("Many To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(false);
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertTrue(((BasicCollectionMetadata) getResult).isMutable());
    assertTrue(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Given {@code LOOKUP}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} AddMethodType is
   * {@code LOOKUP}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_givenLookup_thenHashMapNameAddMethodTypeIsLookup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getAddMethodType()).thenReturn(AddMethodType.LOOKUP);
    when(collectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.LOOKUP, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Given {@code void}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_givenVoid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getOneToManyTargetEntity()).thenReturn("void");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("Many To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} AddFriendlyName is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameAddFriendlyNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(true);
    when(collectionMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(collectionMetadata.isSortAscending()).thenReturn(true);
    when(collectionMetadata.getTabOrder()).thenReturn(1);
    when(collectionMetadata.getOrder()).thenReturn(1);
    when(collectionMetadata.getAddFriendlyName()).thenReturn(null);
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

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(collectionMetadata).getAddFriendlyName();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getAddFriendlyName());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} AddMethodType is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameAddMethodTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getAddMethodType()).thenReturn(null);
    when(collectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(collectionMetadata, atLeast(1)).getAddFriendlyName();
    verify(collectionMetadata).getAddMethodType();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} AddMethodType is
   * {@code SELECTIZE_LOOKUP}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameAddMethodTypeIsSelectizeLookup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getAddMethodType()).thenReturn(AddMethodType.SELECTIZE_LOOKUP);
    when(collectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.SELECTIZE_LOOKUP, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} CurrencyCodeField is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameCurrencyCodeFieldIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getCurrencyCodeField()).thenReturn(null);
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

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(collectionMetadata, atLeast(1)).getAddFriendlyName();
    verify(collectionMetadata, atLeast(1)).getAddMethodType();
    verify(collectionMetadata, atLeast(1)).getAddType();
    verify(collectionMetadata).getCurrencyCodeField();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getCurrencyCodeField());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} CustomCriteria is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameCustomCriteriaIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getCustomCriteria()).thenReturn(null);
    when(collectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(collectionMetadata.getAddMethodType()).thenReturn(AddMethodType.PERSIST);
    when(collectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(collectionMetadata, atLeast(1)).getAddFriendlyName();
    verify(collectionMetadata, atLeast(1)).getAddMethodType();
    verify(collectionMetadata, atLeast(1)).getAddType();
    verify(collectionMetadata, atLeast(1)).getCurrencyCodeField();
    verify(collectionMetadata).getCustomCriteria();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(((BasicCollectionMetadata) getResult).getCustomCriteria());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} Excluded is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameExcludedIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(null);
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

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(parentClass, targetClass, attributes, field,
        collectionMetadata, "Prefix");

    // Assert
    verify(collectionMetadata, atLeast(1)).getAddFriendlyName();
    verify(collectionMetadata, atLeast(1)).getAddMethodType();
    verify(collectionMetadata, atLeast(1)).getAddType();
    verify(collectionMetadata, atLeast(1)).getCurrencyCodeField();
    verify(collectionMetadata, atLeast(1)).getCustomCriteria();
    verify(collectionMetadata).getExcluded();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getExcluded());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} FriendlyName is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameFriendlyNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getFriendlyName()).thenReturn(null);
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
    verify(collectionMetadata).getFriendlyName();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getFriendlyName());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} Group is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameGroupIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getGroup()).thenReturn(null);
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
    verify(collectionMetadata).getGroup();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getGroup());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} LazyFetch is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameLazyFetchIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(null);
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
    verify(collectionMetadata).getLazyFetch();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getLazyFetch());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} Order is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameOrderIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(true);
    when(collectionMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(collectionMetadata.isSortAscending()).thenReturn(true);
    when(collectionMetadata.getTabOrder()).thenReturn(1);
    when(collectionMetadata.getOrder()).thenReturn(null);
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
    verify(collectionMetadata).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getOrder());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} SecurityLevel is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameSecurityLevelIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getSecurityLevel()).thenReturn(null);
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
    verify(collectionMetadata).getSecurityLevel();
    verify(collectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(collectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(collectionMetadata, atLeast(1)).getShowIfProperty();
    verify(collectionMetadata, atLeast(1)).getSortProperty();
    verify(collectionMetadata, atLeast(1)).getTab();
    verify(collectionMetadata, atLeast(1)).getTabOrder();
    verify(collectionMetadata, atLeast(1)).getUpdateType();
    verify(collectionMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getSecurityLevel());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} SelectizeVisibleField is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameSelectizeVisibleFieldIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getSelectizeVisibleField()).thenReturn(null);
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
    verify(collectionMetadata).getSelectizeVisibleField();
    verify(collectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(collectionMetadata, atLeast(1)).getShowIfProperty();
    verify(collectionMetadata, atLeast(1)).getSortProperty();
    verify(collectionMetadata, atLeast(1)).getTab();
    verify(collectionMetadata, atLeast(1)).getTabOrder();
    verify(collectionMetadata, atLeast(1)).getUpdateType();
    verify(collectionMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(((BasicCollectionMetadata) getResult).getSelectizeVisibleField());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} ShowIfProperty is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameShowIfPropertyIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getShowIfProperty()).thenReturn(null);
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
    verify(collectionMetadata).getShowIfProperty();
    verify(collectionMetadata, atLeast(1)).getSortProperty();
    verify(collectionMetadata, atLeast(1)).getTab();
    verify(collectionMetadata, atLeast(1)).getTabOrder();
    verify(collectionMetadata, atLeast(1)).getUpdateType();
    verify(collectionMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getShowIfProperty());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} SortProperty is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameSortPropertyIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getSortProperty()).thenReturn(null);
    when(collectionMetadata.getTab()).thenReturn("Tab");
    when(collectionMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(collectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(collectionMetadata.getAddMethodType()).thenReturn(AddMethodType.PERSIST);
    when(collectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(((BasicCollectionMetadata) getResult).getSortProperty());
    assertNull(((ForeignKey) getResult2).getSortField());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} Tab is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameTabIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    when(collectionMetadata.getTab()).thenReturn(null);
    when(collectionMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(collectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(collectionMetadata.getAddMethodType()).thenReturn(AddMethodType.PERSIST);
    when(collectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(collectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

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
    verify(collectionMetadata).getTab();
    verify(collectionMetadata, atLeast(1)).getTabOrder();
    verify(collectionMetadata, atLeast(1)).getUpdateType();
    verify(collectionMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getTab());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name} TabOrder is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenHashMapNameTabOrderIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(true);
    when(collectionMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(collectionMetadata.isSortAscending()).thenReturn(true);
    when(collectionMetadata.getTabOrder()).thenReturn(null);
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
    verify(collectionMetadata).getTabOrder();
    verify(collectionMetadata, atLeast(1)).getUpdateType();
    verify(collectionMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(collectionMetadata, atLeast(1)).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertNull(getResult.getTabOrder());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>Then not {@link HashMap#HashMap()} {@code Name} ManualFetch.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_thenNotHashMapNameManualFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(null);
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
    verify(collectionMetadata).getManualFetch();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(getResult.getManualFetch());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>When {@link FieldInfo} {@link FieldInfo#getOneToManyTargetEntity()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_whenFieldInfoGetOneToManyTargetEntityReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getManyToManyTargetEntity()).thenReturn("Many To Many Target Entity");
    when(field.getOneToManyTargetEntity()).thenReturn(null);
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getManyToManyTargetEntity();
    verify(field, atLeast(1)).getName();
    verify(field).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("Many To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>When {@link FieldMetadataOverride}
   * {@link FieldMetadataOverride#getReadOnly()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_whenFieldMetadataOverrideGetReadOnlyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(null);
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
    verify(collectionMetadata).getReadOnly();
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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertTrue(((BasicCollectionMetadata) getResult).isMutable());
    assertTrue(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>When {@link FieldMetadataOverride}
   * {@link FieldMetadataOverride#isSortAscending()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_whenFieldMetadataOverrideIsSortAscendingReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride collectionMetadata = mock(FieldMetadataOverride.class);
    when(collectionMetadata.getExcluded()).thenReturn(true);
    when(collectionMetadata.getLazyFetch()).thenReturn(true);
    when(collectionMetadata.getManualFetch()).thenReturn(true);
    when(collectionMetadata.getReadOnly()).thenReturn(true);
    when(collectionMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(collectionMetadata.isSortAscending()).thenReturn(null);
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
    verify(collectionMetadata).isSortAscending();
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#buildCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, String)}
   */
  @Test
  public void testBuildCollectionMetadata_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getOneToManyTargetEntity()).thenReturn("One To Many Target Entity");
    when(field.getGenericType()).thenReturn(new TypePlaceHolder(1));
    when(field.getName()).thenReturn("Name");
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

    // Act
    collectionFieldMetadataProvider.buildCollectionMetadata(null, targetClass, attributes, field, collectionMetadata,
        "Prefix");

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
    verify(collectionMetadata, atLeast(1)).getOrder();
    verify(field).getGenericType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyTargetEntity();
    assertEquals(1, attributes.size());
    FieldMetadata getResult = attributes.get("Name");
    assertTrue(getResult instanceof BasicCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = ((BasicCollectionMetadata) getResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult2 = persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult2 instanceof ForeignKey);
    assertEquals("One To Many Target Entity", ((BasicCollectionMetadata) getResult).getCollectionCeilingEntity());
    assertEquals(AddMethodType.PERSIST, ((BasicCollectionMetadata) getResult).getAddMethodType());
    assertFalse(((BasicCollectionMetadata) getResult).isMutable());
    assertFalse(((ForeignKey) getResult2).getMutable());
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls {@link FieldValueConfiguration#fieldValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenCallsFieldValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    collectionFieldMetadataProvider
        .processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration}, override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Test
   * {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenThrowNoSuchBeanDefinitionException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CollectionFieldMetadataProvider collectionFieldMetadataProvider = new CollectionFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> collectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
            new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Test {@link CollectionFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link CollectionFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.COLLECTION, (new CollectionFieldMetadataProvider()).getOrder());
  }
}
