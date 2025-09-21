/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.admin.server.service.extension.AbstractOfferCustomServiceExtensionHandler;
import org.broadleafcommerce.admin.server.service.extension.OfferCustomServiceExtensionManager;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferCustomPersistenceHandlerDiffblueTest {
  @InjectMocks private OfferCustomPersistenceHandler offerCustomPersistenceHandler;

  @Mock private OfferCustomServiceExtensionManager offerCustomServiceExtensionManager;

  @Mock private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link OfferCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(offerCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(offerCustomPersistenceHandler.canHandleFetch(persistencePackage));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(offerCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsFieldMetaData()}.
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsFieldMetaData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldMetadata OfferCustomPersistenceHandler.buildAdvancedVisibilityOptionsFieldMetaData()"
  })
  public void testBuildAdvancedVisibilityOptionsFieldMetaData() {
    // Arrange and Act
    FieldMetadata actualBuildAdvancedVisibilityOptionsFieldMetaDataResult =
        offerCustomPersistenceHandler.buildAdvancedVisibilityOptionsFieldMetaData();

    // Assert
    assertTrue(
        actualBuildAdvancedVisibilityOptionsFieldMetaDataResult instanceof BasicFieldMetadata);
    assertEquals(
        "OfferImpl_Activity_Range",
        actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getGroup());
    assertEquals(
        "OfferImpl_View_Visibility_Options",
        actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getFriendlyName());
    assertEquals(
        "test",
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult).getName());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getCanLinkToExternalEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getEnableTypeaheadLookup());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getForcePopulateChildProperties());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getGroupCollapsed());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getHideEnumerationIfEmpty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getIsDerived());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getIsFilter());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getMutable());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getOptionCanEditValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getOptionHideIfEmpty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getReadOnly());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getRequiredOverride());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getSearchable());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getToOneLookupCreatedViaAnnotation());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getTranslatable());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult).getUnique());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getUseServerSideInspectionCache());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .isLargeEntry());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .isProminent());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getChildrenExcluded());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getExcluded());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getLazyFetch());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getGridOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult).getLength());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getPrecision());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult).getScale());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getGroupOrder());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getTabOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getAssociatedFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getBroadleafEnumeration());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getColumnWidth());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getEnumerationClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getFieldComponentRendererTemplate());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getForeignKeyClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getForeignKeyDisplayValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getForeignKeyProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getGridFieldComponentRendererTemplate());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getHelpText());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult).getHint());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getLookupDisplayProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getManyToField());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getMapFieldValueClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getMapKeyValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getOptionDisplayFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getOptionListEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getOptionValueFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getRuleIdentifier());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getToOneParentProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getToOneTargetProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getTooltip());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getAddFriendlyName());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getCurrencyCodeField());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getFieldName());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getInheritedFromType());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getOwningClass());
    assertNull(
        actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getOwningClassFriendlyName());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getPrefix());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getSecurityLevel());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getShowIfProperty());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getTab());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getTargetClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getCustomCriteria());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getAvailableToTypes());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getEnumerationValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getOptionFilterParams());
    assertNull(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getShowIfFieldEquals());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getLookupType());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getDisplayType());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getExplicitFieldType());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getGridFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getVisibility());
    assertEquals(
        5000, actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getOrder().intValue());
    assertEquals(
        SupportedFieldType.BOOLEAN_LINK,
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getFieldType());
    assertEquals(
        SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getSecondaryType());
    assertEquals(
        MergedPropertyType.PRIMARY,
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getMergedPropertyType());
    assertFalse(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getAllowNoValueEnumOption());
    assertFalse(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getForeignKeyCollection());
    assertFalse(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getRequired());
    assertFalse(actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getManualFetch());
    assertTrue(
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getValidationConfigurations()
            .isEmpty());
    assertTrue(
        actualBuildAdvancedVisibilityOptionsFieldMetaDataResult.getAdditionalMetadata().isEmpty());
    assertEquals(
        Boolean.TRUE.toString(),
        ((BasicFieldMetadata) actualBuildAdvancedVisibilityOptionsFieldMetaDataResult)
            .getDefaultValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildIsActiveFieldMetaData()}.
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#buildIsActiveFieldMetaData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata OfferCustomPersistenceHandler.buildIsActiveFieldMetaData()"})
  public void testBuildIsActiveFieldMetaData() {
    // Arrange and Act
    FieldMetadata actualBuildIsActiveFieldMetaDataResult =
        offerCustomPersistenceHandler.buildIsActiveFieldMetaData();

    // Assert
    assertTrue(actualBuildIsActiveFieldMetaDataResult instanceof BasicFieldMetadata);
    assertEquals("OfferImpl_Is_Active", actualBuildIsActiveFieldMetaDataResult.getFriendlyName());
    assertEquals(
        "isActive", ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getName());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getCanLinkToExternalEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getEnableTypeaheadLookup());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getGroupCollapsed());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getIsDerived());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getIsFilter());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getMutable());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getOptionCanEditValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getReadOnly());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getRequiredOverride());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getSearchable());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getTranslatable());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getUnique());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).isLargeEntry());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getChildrenExcluded());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getExcluded());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getLazyFetch());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getLength());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getPrecision());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getScale());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getGroupOrder());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getOrder());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getTabOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getAssociatedFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getColumnWidth());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getDefaultValue());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getEnumerationClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getForeignKeyClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getForeignKeyDisplayValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getForeignKeyProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getHelpText());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getHint());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getManyToField());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getMapFieldValueClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getMapKeyValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getOptionListEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getRuleIdentifier());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getToOneParentProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getTooltip());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getAddFriendlyName());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getCurrencyCodeField());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getFieldName());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getGroup());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getInheritedFromType());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getOwningClass());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getOwningClassFriendlyName());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getPrefix());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getSecurityLevel());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getShowIfProperty());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getTab());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getTargetClass());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getCustomCriteria());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getAvailableToTypes());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getEnumerationValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getOptionFilterParams());
    assertNull(actualBuildIsActiveFieldMetaDataResult.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getLookupType());
    assertNull(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getDisplayType());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getExplicitFieldType());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getGridFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getMergedPropertyType());
    assertEquals(
        999999,
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getGridOrder().intValue());
    assertEquals(
        SupportedFieldType.BOOLEAN,
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getFieldType());
    assertEquals(
        SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getSecondaryType());
    assertEquals(
        VisibilityEnum.FORM_HIDDEN,
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getVisibility());
    assertFalse(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getRequired());
    assertFalse(actualBuildIsActiveFieldMetaDataResult.getManualFetch());
    assertTrue(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult)
            .getValidationConfigurations()
            .isEmpty());
    assertTrue(actualBuildIsActiveFieldMetaDataResult.getAdditionalMetadata().isEmpty());
    assertTrue(
        ((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) actualBuildIsActiveFieldMetaDataResult).isProminent());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersFieldMetaData()}.
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersFieldMetaData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldMetadata OfferCustomPersistenceHandler.buildQualifiersCanBeQualifiersFieldMetaData()"
  })
  public void testBuildQualifiersCanBeQualifiersFieldMetaData() {
    // Arrange and Act
    FieldMetadata actualBuildQualifiersCanBeQualifiersFieldMetaDataResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeQualifiersFieldMetaData();

    // Assert
    assertTrue(
        actualBuildQualifiersCanBeQualifiersFieldMetaDataResult instanceof BasicFieldMetadata);
    assertEquals(
        "OfferImpl_Qualifier_Rule_Restriction",
        actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getGroup());
    assertEquals(
        "OfferImpl_Qualifiers_Can_Be_Qualifiers",
        actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getFriendlyName());
    assertEquals(
        "qualifiersCanBeQualifiers",
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult).getName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getCanLinkToExternalEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getEnableTypeaheadLookup());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getForcePopulateChildProperties());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getGroupCollapsed());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getHideEnumerationIfEmpty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getIsDerived());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getIsFilter());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getMutable());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getOptionCanEditValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getOptionHideIfEmpty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getReadOnly());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getRequiredOverride());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getSearchable());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getToOneLookupCreatedViaAnnotation());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getTranslatable());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult).getUnique());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getUseServerSideInspectionCache());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .isLargeEntry());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .isProminent());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getChildrenExcluded());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getExcluded());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getLazyFetch());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getGridOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult).getLength());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getPrecision());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult).getScale());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getGroupOrder());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getTabOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getAssociatedFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getBroadleafEnumeration());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getColumnWidth());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getEnumerationClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getFieldComponentRendererTemplate());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getForeignKeyClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getForeignKeyDisplayValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getForeignKeyProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getGridFieldComponentRendererTemplate());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getHelpText());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult).getHint());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getLookupDisplayProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getManyToField());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getMapFieldValueClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getMapKeyValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getOptionDisplayFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getOptionListEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getOptionValueFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getRuleIdentifier());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getToOneParentProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getToOneTargetProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getTooltip());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getAddFriendlyName());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getCurrencyCodeField());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getFieldName());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getInheritedFromType());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getOwningClass());
    assertNull(
        actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getOwningClassFriendlyName());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getPrefix());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getSecurityLevel());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getShowIfProperty());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getTab());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getTargetClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getCustomCriteria());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getAvailableToTypes());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getEnumerationValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getOptionFilterParams());
    assertNull(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getShowIfFieldEquals());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getLookupType());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getDisplayType());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getExplicitFieldType());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getGridFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getVisibility());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getMergedPropertyType());
    assertEquals(
        2000, actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getOrder().intValue());
    assertEquals(
        SupportedFieldType.BOOLEAN,
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getFieldType());
    assertEquals(
        SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getSecondaryType());
    assertFalse(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getAllowNoValueEnumOption());
    assertFalse(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getForeignKeyCollection());
    assertFalse(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getRequired());
    assertFalse(actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getManualFetch());
    assertTrue(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getValidationConfigurations()
            .isEmpty());
    assertTrue(
        actualBuildQualifiersCanBeQualifiersFieldMetaDataResult.getAdditionalMetadata().isEmpty());
    assertEquals(
        Boolean.FALSE.toString(),
        ((BasicFieldMetadata) actualBuildQualifiersCanBeQualifiersFieldMetaDataResult)
            .getDefaultValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsFieldMetaData()}.
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsFieldMetaData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldMetadata OfferCustomPersistenceHandler.buildQualifiersCanBeTargetsFieldMetaData()"
  })
  public void testBuildQualifiersCanBeTargetsFieldMetaData() {
    // Arrange and Act
    FieldMetadata actualBuildQualifiersCanBeTargetsFieldMetaDataResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeTargetsFieldMetaData();

    // Assert
    assertTrue(actualBuildQualifiersCanBeTargetsFieldMetaDataResult instanceof BasicFieldMetadata);
    assertEquals(
        "OfferImpl_Qualifier_Rule_Restriction",
        actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getGroup());
    assertEquals(
        "OfferImpl_Qualifiers_Can_Be_Targets",
        actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getFriendlyName());
    assertEquals(
        "qualifiersCanBeTargets",
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getCanLinkToExternalEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getEnableTypeaheadLookup());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getForcePopulateChildProperties());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getGroupCollapsed());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getHideEnumerationIfEmpty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getIsDerived());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getIsFilter());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getMutable());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getOptionCanEditValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getOptionHideIfEmpty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getReadOnly());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getRequiredOverride());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getSearchable());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getToOneLookupCreatedViaAnnotation());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getTranslatable());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getUnique());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getUseServerSideInspectionCache());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).isLargeEntry());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).isProminent());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getChildrenExcluded());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getExcluded());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getLazyFetch());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getGridOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getLength());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getPrecision());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getScale());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getGroupOrder());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getTabOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getAssociatedFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getBroadleafEnumeration());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getColumnWidth());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getEnumerationClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getFieldComponentRendererTemplate());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getForeignKeyClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getForeignKeyDisplayValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getForeignKeyProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getGridFieldComponentRendererTemplate());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getHelpText());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getHint());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getLookupDisplayProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getManyToField());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getMapFieldValueClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getMapKeyValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getOptionDisplayFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getOptionListEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getOptionValueFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getRuleIdentifier());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getToOneParentProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getToOneTargetProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getTooltip());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getAddFriendlyName());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getCurrencyCodeField());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getFieldName());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getInheritedFromType());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getOwningClass());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getOwningClassFriendlyName());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getPrefix());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getSecurityLevel());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getShowIfProperty());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getTab());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getTargetClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getCustomCriteria());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getAvailableToTypes());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getEnumerationValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getOptionFilterParams());
    assertNull(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getShowIfFieldEquals());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getLookupType());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getDisplayType());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getExplicitFieldType());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getGridFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getVisibility());
    assertNull(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getMergedPropertyType());
    assertEquals(3000, actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getOrder().intValue());
    assertEquals(
        SupportedFieldType.BOOLEAN,
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getFieldType());
    assertEquals(
        SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getSecondaryType());
    assertFalse(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getAllowNoValueEnumOption());
    assertFalse(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getForeignKeyCollection());
    assertFalse(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult).getRequired());
    assertFalse(actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getManualFetch());
    assertTrue(
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getValidationConfigurations()
            .isEmpty());
    assertTrue(
        actualBuildQualifiersCanBeTargetsFieldMetaDataResult.getAdditionalMetadata().isEmpty());
    assertEquals(
        Boolean.FALSE.toString(),
        ((BasicFieldMetadata) actualBuildQualifiersCanBeTargetsFieldMetaDataResult)
            .getDefaultValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildStackableFieldMetaData()}.
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#buildStackableFieldMetaData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata OfferCustomPersistenceHandler.buildStackableFieldMetaData()"})
  public void testBuildStackableFieldMetaData() {
    // Arrange and Act
    FieldMetadata actualBuildStackableFieldMetaDataResult =
        offerCustomPersistenceHandler.buildStackableFieldMetaData();

    // Assert
    assertTrue(actualBuildStackableFieldMetaDataResult instanceof BasicFieldMetadata);
    assertEquals("OfferImpl_Combine_Stack", actualBuildStackableFieldMetaDataResult.getGroup());
    assertEquals("OfferImpl_Stackable", actualBuildStackableFieldMetaDataResult.getFriendlyName());
    assertEquals(
        "OfferImpl_Stackable_tooltip",
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getTooltip());
    assertEquals(
        "stackableWithOtherOffers",
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getName());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getCanLinkToExternalEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getEnableTypeaheadLookup());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getGroupCollapsed());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getIsDerived());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getIsFilter());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getMutable());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getOptionCanEditValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getReadOnly());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getRequiredOverride());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getSearchable());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getTranslatable());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getUnique());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).isLargeEntry());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).isProminent());
    assertNull(actualBuildStackableFieldMetaDataResult.getChildrenExcluded());
    assertNull(actualBuildStackableFieldMetaDataResult.getExcluded());
    assertNull(actualBuildStackableFieldMetaDataResult.getLazyFetch());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getGridOrder());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getLength());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getPrecision());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getScale());
    assertNull(actualBuildStackableFieldMetaDataResult.getGroupOrder());
    assertNull(actualBuildStackableFieldMetaDataResult.getTabOrder());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getAssociatedFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getColumnWidth());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getEnumerationClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getForeignKeyClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getForeignKeyDisplayValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getForeignKeyProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getHelpText());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getHint());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getManyToField());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getMapFieldValueClass());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getMapKeyValueProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getOptionDisplayFieldName());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getOptionListEntity());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getRuleIdentifier());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getToOneParentProperty());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getToOneTargetProperty());
    assertNull(actualBuildStackableFieldMetaDataResult.getAddFriendlyName());
    assertNull(actualBuildStackableFieldMetaDataResult.getCurrencyCodeField());
    assertNull(actualBuildStackableFieldMetaDataResult.getFieldName());
    assertNull(actualBuildStackableFieldMetaDataResult.getInheritedFromType());
    assertNull(actualBuildStackableFieldMetaDataResult.getOwningClass());
    assertNull(actualBuildStackableFieldMetaDataResult.getOwningClassFriendlyName());
    assertNull(actualBuildStackableFieldMetaDataResult.getPrefix());
    assertNull(actualBuildStackableFieldMetaDataResult.getSecurityLevel());
    assertNull(actualBuildStackableFieldMetaDataResult.getShowIfProperty());
    assertNull(actualBuildStackableFieldMetaDataResult.getTab());
    assertNull(actualBuildStackableFieldMetaDataResult.getTargetClass());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getCustomCriteria());
    assertNull(actualBuildStackableFieldMetaDataResult.getAvailableToTypes());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getEnumerationValues());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getOptionFilterParams());
    assertNull(actualBuildStackableFieldMetaDataResult.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getLookupType());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getDisplayType());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getExplicitFieldType());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getFieldComponentRenderer());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getVisibility());
    assertNull(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getMergedPropertyType());
    assertEquals(2000, actualBuildStackableFieldMetaDataResult.getOrder().intValue());
    assertEquals(
        SupportedFieldType.BOOLEAN,
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getFieldType());
    assertEquals(
        SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getSecondaryType());
    assertFalse(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getAllowNoValueEnumOption());
    assertFalse(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getRequired());
    assertFalse(actualBuildStackableFieldMetaDataResult.getManualFetch());
    assertTrue(
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult)
            .getValidationConfigurations()
            .isEmpty());
    assertTrue(actualBuildStackableFieldMetaDataResult.getAdditionalMetadata().isEmpty());
    assertEquals(
        Boolean.FALSE.toString(),
        ((BasicFieldMetadata) actualBuildStackableFieldMetaDataResult).getDefaultValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#stripTrailingZeros(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#stripTrailingZeros(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferCustomPersistenceHandler.stripTrailingZeros(String, String)"})
  public void testStripTrailingZeros_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", offerCustomPersistenceHandler.stripTrailingZeros("42", "Decimal Separator"));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildIsActiveProperty(boolean)}.
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#buildIsActiveProperty(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Property OfferCustomPersistenceHandler.buildIsActiveProperty(boolean)"})
  public void testBuildIsActiveProperty() {
    // Arrange and Act
    Property actualBuildIsActivePropertyResult =
        offerCustomPersistenceHandler.buildIsActiveProperty(true);

    // Assert
    assertTrue(actualBuildIsActivePropertyResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("isActive", actualBuildIsActivePropertyResult.getName());
    assertNull(actualBuildIsActivePropertyResult.getDisplayValue());
    assertNull(actualBuildIsActivePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildIsActivePropertyResult.getOriginalValue());
    assertNull(actualBuildIsActivePropertyResult.getDeployDate());
    assertFalse(actualBuildIsActivePropertyResult.getIsDirty());
    assertFalse(actualBuildIsActivePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildIsActivePropertyResult.getEnabled());
    assertEquals(Boolean.TRUE.toString(), actualBuildIsActivePropertyResult.getRawValue());
    assertEquals(
        Boolean.TRUE.toString(), actualBuildIsActivePropertyResult.getUnHtmlEncodedValue());
    assertEquals(Boolean.TRUE.toString(), actualBuildIsActivePropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildAdvancedVisibilityOptionsProperty(Property)"
  })
  public void testBuildAdvancedVisibilityOptionsProperty_givenNull_thenCallsGetValue() {
    // Arrange
    Property timeRule = mock(Property.class);
    when(timeRule.getValue()).thenReturn(null);

    // Act
    Property actualBuildAdvancedVisibilityOptionsPropertyResult =
        offerCustomPersistenceHandler.buildAdvancedVisibilityOptionsProperty(timeRule);

    // Assert
    verify(timeRule).getValue();
    assertTrue(
        actualBuildAdvancedVisibilityOptionsPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "showAdvancedVisibilityOptions",
        actualBuildAdvancedVisibilityOptionsPropertyResult.getName());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getDisplayValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getOriginalValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getDeployDate());
    assertFalse(actualBuildAdvancedVisibilityOptionsPropertyResult.getIsDirty());
    assertFalse(actualBuildAdvancedVisibilityOptionsPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildAdvancedVisibilityOptionsPropertyResult.getEnabled());
    assertEquals(
        Boolean.TRUE.toString(), actualBuildAdvancedVisibilityOptionsPropertyResult.getRawValue());
    assertEquals(
        Boolean.TRUE.toString(),
        actualBuildAdvancedVisibilityOptionsPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.TRUE.toString(), actualBuildAdvancedVisibilityOptionsPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsProperty(Property)}.
   *
   * <ul>
   *   <li>Then return RawValue is {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildAdvancedVisibilityOptionsProperty(Property)"
  })
  public void testBuildAdvancedVisibilityOptionsProperty_thenReturnRawValueIsFalseToString() {
    // Arrange and Act
    Property actualBuildAdvancedVisibilityOptionsPropertyResult =
        offerCustomPersistenceHandler.buildAdvancedVisibilityOptionsProperty(
            new Property("Name", "42"));

    // Assert
    assertTrue(
        actualBuildAdvancedVisibilityOptionsPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "showAdvancedVisibilityOptions",
        actualBuildAdvancedVisibilityOptionsPropertyResult.getName());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getDisplayValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getOriginalValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getDeployDate());
    assertFalse(actualBuildAdvancedVisibilityOptionsPropertyResult.getIsDirty());
    assertFalse(actualBuildAdvancedVisibilityOptionsPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildAdvancedVisibilityOptionsPropertyResult.getEnabled());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildAdvancedVisibilityOptionsPropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(),
        actualBuildAdvancedVisibilityOptionsPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildAdvancedVisibilityOptionsPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsProperty(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildAdvancedVisibilityOptionsProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildAdvancedVisibilityOptionsProperty(Property)"
  })
  public void testBuildAdvancedVisibilityOptionsProperty_whenProperty() {
    // Arrange and Act
    Property actualBuildAdvancedVisibilityOptionsPropertyResult =
        offerCustomPersistenceHandler.buildAdvancedVisibilityOptionsProperty(new Property());

    // Assert
    assertTrue(
        actualBuildAdvancedVisibilityOptionsPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "showAdvancedVisibilityOptions",
        actualBuildAdvancedVisibilityOptionsPropertyResult.getName());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getDisplayValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getOriginalValue());
    assertNull(actualBuildAdvancedVisibilityOptionsPropertyResult.getDeployDate());
    assertFalse(actualBuildAdvancedVisibilityOptionsPropertyResult.getIsDirty());
    assertFalse(actualBuildAdvancedVisibilityOptionsPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildAdvancedVisibilityOptionsPropertyResult.getEnabled());
    assertEquals(
        Boolean.TRUE.toString(), actualBuildAdvancedVisibilityOptionsPropertyResult.getRawValue());
    assertEquals(
        Boolean.TRUE.toString(),
        actualBuildAdvancedVisibilityOptionsPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.TRUE.toString(), actualBuildAdvancedVisibilityOptionsPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildQualifiersCanBeQualifiersProperty(Property)"
  })
  public void testBuildQualifiersCanBeQualifiersProperty_given42_whenPropertyGetValueReturn42() {
    // Arrange
    Property offerItemQualifierRuleType = mock(Property.class);
    when(offerItemQualifierRuleType.getValue()).thenReturn("42");

    // Act
    Property actualBuildQualifiersCanBeQualifiersPropertyResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeQualifiersProperty(
            offerItemQualifierRuleType);

    // Assert
    verify(offerItemQualifierRuleType, atLeast(1)).getValue();
    assertTrue(
        actualBuildQualifiersCanBeQualifiersPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "qualifiersCanBeQualifiers", actualBuildQualifiersCanBeQualifiersPropertyResult.getName());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getDisplayValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getOriginalValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getDeployDate());
    assertFalse(actualBuildQualifiersCanBeQualifiersPropertyResult.getIsDirty());
    assertFalse(actualBuildQualifiersCanBeQualifiersPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildQualifiersCanBeQualifiersPropertyResult.getEnabled());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeQualifiersPropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(),
        actualBuildQualifiersCanBeQualifiersPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeQualifiersPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersProperty(Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildQualifiersCanBeQualifiersProperty(Property)"
  })
  public void testBuildQualifiersCanBeQualifiersProperty_whenNull() {
    // Arrange and Act
    Property actualBuildQualifiersCanBeQualifiersPropertyResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeQualifiersProperty(null);

    // Assert
    assertTrue(
        actualBuildQualifiersCanBeQualifiersPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "qualifiersCanBeQualifiers", actualBuildQualifiersCanBeQualifiersPropertyResult.getName());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getDisplayValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getOriginalValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getDeployDate());
    assertFalse(actualBuildQualifiersCanBeQualifiersPropertyResult.getIsDirty());
    assertFalse(actualBuildQualifiersCanBeQualifiersPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildQualifiersCanBeQualifiersPropertyResult.getEnabled());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeQualifiersPropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(),
        actualBuildQualifiersCanBeQualifiersPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeQualifiersPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersProperty(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeQualifiersProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildQualifiersCanBeQualifiersProperty(Property)"
  })
  public void testBuildQualifiersCanBeQualifiersProperty_whenProperty() {
    // Arrange and Act
    Property actualBuildQualifiersCanBeQualifiersPropertyResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeQualifiersProperty(new Property());

    // Assert
    assertTrue(
        actualBuildQualifiersCanBeQualifiersPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "qualifiersCanBeQualifiers", actualBuildQualifiersCanBeQualifiersPropertyResult.getName());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getDisplayValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getOriginalValue());
    assertNull(actualBuildQualifiersCanBeQualifiersPropertyResult.getDeployDate());
    assertFalse(actualBuildQualifiersCanBeQualifiersPropertyResult.getIsDirty());
    assertFalse(actualBuildQualifiersCanBeQualifiersPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildQualifiersCanBeQualifiersPropertyResult.getEnabled());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeQualifiersPropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(),
        actualBuildQualifiersCanBeQualifiersPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeQualifiersPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildQualifiersCanBeTargetsProperty(Property)"
  })
  public void testBuildQualifiersCanBeTargetsProperty_given42_whenPropertyGetValueReturn42() {
    // Arrange
    Property offerItemQualifierRuleType = mock(Property.class);
    when(offerItemQualifierRuleType.getValue()).thenReturn("42");

    // Act
    Property actualBuildQualifiersCanBeTargetsPropertyResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeTargetsProperty(
            offerItemQualifierRuleType);

    // Assert
    verify(offerItemQualifierRuleType, atLeast(1)).getValue();
    assertTrue(
        actualBuildQualifiersCanBeTargetsPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "qualifiersCanBeTargets", actualBuildQualifiersCanBeTargetsPropertyResult.getName());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getDisplayValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getOriginalValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getDeployDate());
    assertFalse(actualBuildQualifiersCanBeTargetsPropertyResult.getIsDirty());
    assertFalse(actualBuildQualifiersCanBeTargetsPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildQualifiersCanBeTargetsPropertyResult.getEnabled());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeTargetsPropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(),
        actualBuildQualifiersCanBeTargetsPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeTargetsPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsProperty(Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildQualifiersCanBeTargetsProperty(Property)"
  })
  public void testBuildQualifiersCanBeTargetsProperty_whenNull() {
    // Arrange and Act
    Property actualBuildQualifiersCanBeTargetsPropertyResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeTargetsProperty(null);

    // Assert
    assertTrue(
        actualBuildQualifiersCanBeTargetsPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "qualifiersCanBeTargets", actualBuildQualifiersCanBeTargetsPropertyResult.getName());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getDisplayValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getOriginalValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getDeployDate());
    assertFalse(actualBuildQualifiersCanBeTargetsPropertyResult.getIsDirty());
    assertFalse(actualBuildQualifiersCanBeTargetsPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildQualifiersCanBeTargetsPropertyResult.getEnabled());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeTargetsPropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(),
        actualBuildQualifiersCanBeTargetsPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeTargetsPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsProperty(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildQualifiersCanBeTargetsProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildQualifiersCanBeTargetsProperty(Property)"
  })
  public void testBuildQualifiersCanBeTargetsProperty_whenProperty() {
    // Arrange and Act
    Property actualBuildQualifiersCanBeTargetsPropertyResult =
        offerCustomPersistenceHandler.buildQualifiersCanBeTargetsProperty(new Property());

    // Assert
    assertTrue(
        actualBuildQualifiersCanBeTargetsPropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "qualifiersCanBeTargets", actualBuildQualifiersCanBeTargetsPropertyResult.getName());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getDisplayValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getOriginalValue());
    assertNull(actualBuildQualifiersCanBeTargetsPropertyResult.getDeployDate());
    assertFalse(actualBuildQualifiersCanBeTargetsPropertyResult.getIsDirty());
    assertFalse(actualBuildQualifiersCanBeTargetsPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildQualifiersCanBeTargetsPropertyResult.getEnabled());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeTargetsPropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(),
        actualBuildQualifiersCanBeTargetsPropertyResult.getUnHtmlEncodedValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildQualifiersCanBeTargetsPropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildStackableProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#buildStackableProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Property OfferCustomPersistenceHandler.buildStackableProperty(Property)"})
  public void testBuildStackableProperty_given42_whenPropertyGetValueReturn42() {
    // Arrange
    Property offerItemTargetRuleType = mock(Property.class);
    when(offerItemTargetRuleType.getValue()).thenReturn("42");

    // Act
    Property actualBuildStackablePropertyResult =
        offerCustomPersistenceHandler.buildStackableProperty(offerItemTargetRuleType);

    // Assert
    verify(offerItemTargetRuleType, atLeast(1)).getValue();
    assertTrue(actualBuildStackablePropertyResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("stackableWithOtherOffers", actualBuildStackablePropertyResult.getName());
    assertNull(actualBuildStackablePropertyResult.getDisplayValue());
    assertNull(actualBuildStackablePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildStackablePropertyResult.getOriginalValue());
    assertNull(actualBuildStackablePropertyResult.getDeployDate());
    assertFalse(actualBuildStackablePropertyResult.getIsDirty());
    assertFalse(actualBuildStackablePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildStackablePropertyResult.getEnabled());
    assertEquals(Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getUnHtmlEncodedValue());
    assertEquals(Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildStackableProperty(Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Metadata return {@link BasicFieldMetadata}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#buildStackableProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Property OfferCustomPersistenceHandler.buildStackableProperty(Property)"})
  public void testBuildStackableProperty_whenNull_thenMetadataReturnBasicFieldMetadata() {
    // Arrange and Act
    Property actualBuildStackablePropertyResult =
        offerCustomPersistenceHandler.buildStackableProperty(null);

    // Assert
    assertTrue(actualBuildStackablePropertyResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("stackableWithOtherOffers", actualBuildStackablePropertyResult.getName());
    assertNull(actualBuildStackablePropertyResult.getDisplayValue());
    assertNull(actualBuildStackablePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildStackablePropertyResult.getOriginalValue());
    assertNull(actualBuildStackablePropertyResult.getDeployDate());
    assertFalse(actualBuildStackablePropertyResult.getIsDirty());
    assertFalse(actualBuildStackablePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildStackablePropertyResult.getEnabled());
    assertEquals(Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getUnHtmlEncodedValue());
    assertEquals(Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildStackableProperty(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then Metadata return {@link BasicFieldMetadata}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#buildStackableProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Property OfferCustomPersistenceHandler.buildStackableProperty(Property)"})
  public void testBuildStackableProperty_whenProperty_thenMetadataReturnBasicFieldMetadata() {
    // Arrange and Act
    Property actualBuildStackablePropertyResult =
        offerCustomPersistenceHandler.buildStackableProperty(new Property());

    // Assert
    assertTrue(actualBuildStackablePropertyResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("stackableWithOtherOffers", actualBuildStackablePropertyResult.getName());
    assertNull(actualBuildStackablePropertyResult.getDisplayValue());
    assertNull(actualBuildStackablePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildStackablePropertyResult.getOriginalValue());
    assertNull(actualBuildStackablePropertyResult.getDeployDate());
    assertFalse(actualBuildStackablePropertyResult.getIsDirty());
    assertFalse(actualBuildStackablePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildStackablePropertyResult.getEnabled());
    assertEquals(Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getRawValue());
    assertEquals(
        Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getUnHtmlEncodedValue());
    assertEquals(Boolean.FALSE.toString(), actualBuildStackablePropertyResult.getValue());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isQualifierType(Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isQualifierType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isQualifierType(Property)"})
  public void testIsQualifierType_given42_whenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    Property offerItemQualifierRuleType = mock(Property.class);
    when(offerItemQualifierRuleType.getValue()).thenReturn("42");

    // Act
    boolean actualIsQualifierTypeResult =
        offerCustomPersistenceHandler.isQualifierType(offerItemQualifierRuleType);

    // Assert
    verify(offerItemQualifierRuleType).getValue();
    assertFalse(actualIsQualifierTypeResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isQualifierType(Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isQualifierType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isQualifierType(Property)"})
  public void testIsQualifierType_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCustomPersistenceHandler.isQualifierType(null));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isQualifierType(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isQualifierType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isQualifierType(Property)"})
  public void testIsQualifierType_whenProperty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCustomPersistenceHandler.isQualifierType(new Property()));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isTargetType(Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isTargetType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isTargetType(Property)"})
  public void testIsTargetType_given42_whenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    Property offerItemQualifierRuleType = mock(Property.class);
    when(offerItemQualifierRuleType.getValue()).thenReturn("42");

    // Act
    boolean actualIsTargetTypeResult =
        offerCustomPersistenceHandler.isTargetType(offerItemQualifierRuleType);

    // Assert
    verify(offerItemQualifierRuleType).getValue();
    assertFalse(actualIsTargetTypeResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isTargetType(Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isTargetType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isTargetType(Property)"})
  public void testIsTargetType_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCustomPersistenceHandler.isTargetType(null));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isTargetType(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isTargetType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isTargetType(Property)"})
  public void testIsTargetType_whenProperty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCustomPersistenceHandler.isTargetType(new Property()));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isQualifierTargetType(Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isQualifierTargetType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isQualifierTargetType(Property)"})
  public void testIsQualifierTargetType_given42_whenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    Property offerItemQualifierRuleType = mock(Property.class);
    when(offerItemQualifierRuleType.getValue()).thenReturn("42");

    // Act
    boolean actualIsQualifierTargetTypeResult =
        offerCustomPersistenceHandler.isQualifierTargetType(offerItemQualifierRuleType);

    // Assert
    verify(offerItemQualifierRuleType).getValue();
    assertFalse(actualIsQualifierTargetTypeResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isQualifierTargetType(Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isQualifierTargetType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isQualifierTargetType(Property)"})
  public void testIsQualifierTargetType_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCustomPersistenceHandler.isQualifierTargetType(null));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#isQualifierTargetType(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#isQualifierTargetType(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomPersistenceHandler.isQualifierTargetType(Property)"})
  public void testIsQualifierTargetType_whenProperty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCustomPersistenceHandler.isQualifierTargetType(new Property()));
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code AMOUNT_OFF}.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnAmountOff_thenReturnEntity()
      throws ServiceException {
    // Arrange
    when(sandBoxHelper.isPromote()).thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("AMOUNT_OFF");
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    doNothing().when(entity).addProperty(Mockito.<Property>any());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.update(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualUpdateResult =
        offerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(sandBoxHelper).isPromote();
    verify(entity, atLeast(1)).addProperty(Mockito.<Property>any());
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(property, atLeast(1)).setIsDirty(true);
    verify(adornedTargetListPersistenceModule).update(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualUpdateResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code
   *       embeddableAdvancedOffer.isTieredOffer}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnEmbeddableAdvancedOfferIsTieredOffer()
      throws ServiceException {
    // Arrange
    when(sandBoxHelper.isPromote()).thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("embeddableAdvancedOffer.isTieredOffer");
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    doNothing().when(entity).addProperty(Mockito.<Property>any());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.update(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualUpdateResult =
        offerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(sandBoxHelper).isPromote();
    verify(entity, atLeast(1)).addProperty(Mockito.<Property>any());
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(property, atLeast(1)).setIsDirty(true);
    verify(adornedTargetListPersistenceModule).update(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualUpdateResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@link Boolean#FALSE} toString.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnFalseToString_thenReturnEntity()
      throws ServiceException {
    // Arrange
    when(sandBoxHelper.isPromote()).thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(Boolean.FALSE.toString());
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    doNothing().when(entity).addProperty(Mockito.<Property>any());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.update(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualUpdateResult =
        offerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(sandBoxHelper).isPromote();
    verify(entity, atLeast(1)).addProperty(Mockito.<Property>any());
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(property, atLeast(1)).setIsDirty(true);
    verify(adornedTargetListPersistenceModule).update(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualUpdateResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code FIX_PRICE}.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnFixPrice_thenReturnEntity()
      throws ServiceException {
    // Arrange
    when(sandBoxHelper.isPromote()).thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("FIX_PRICE");
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    doNothing().when(entity).addProperty(Mockito.<Property>any());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.update(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualUpdateResult =
        offerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(sandBoxHelper).isPromote();
    verify(entity, atLeast(1)).addProperty(Mockito.<Property>any());
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(property, atLeast(1)).setIsDirty(true);
    verify(adornedTargetListPersistenceModule).update(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualUpdateResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnNull_thenReturnEntity()
      throws ServiceException {
    // Arrange
    when(sandBoxHelper.isPromote()).thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    doNothing().when(entity).addProperty(Mockito.<Property>any());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.update(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualUpdateResult =
        offerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(sandBoxHelper).isPromote();
    verify(entity, atLeast(1)).addProperty(Mockito.<Property>any());
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(property, atLeast(1)).setIsDirty(true);
    verify(adornedTargetListPersistenceModule).update(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualUpdateResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@link Boolean#TRUE} toString.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnTrueToString_thenReturnEntity()
      throws ServiceException {
    // Arrange
    when(sandBoxHelper.isPromote()).thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(Boolean.TRUE.toString());
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    doNothing().when(entity).addProperty(Mockito.<Property>any());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.update(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualUpdateResult =
        offerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(sandBoxHelper).isPromote();
    verify(entity, atLeast(1)).addProperty(Mockito.<Property>any());
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(property, atLeast(1)).setIsDirty(true);
    verify(adornedTargetListPersistenceModule).update(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualUpdateResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueThrowNumberFormatException() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NumberFormatException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            offerCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty("embeddableAdvancedOffer.isTieredOffer");
    verify(property).getValue();
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#isPromote()} return {@code false}.
   *   <li>Then calls {@link OfferCustomServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenSandBoxHelperIsPromoteReturnFalse_thenCallsGetProxy()
      throws ServiceException {
    // Arrange
    when(offerCustomServiceExtensionManager.getProxy())
        .thenReturn(new AbstractOfferCustomServiceExtensionHandler());
    when(sandBoxHelper.isPromote()).thenReturn(false);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    doNothing().when(entity).addProperty(Mockito.<Property>any());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.update(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualUpdateResult =
        offerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(offerCustomServiceExtensionManager).getProxy();
    verify(sandBoxHelper).isPromote();
    verify(entity, atLeast(1)).addProperty(Mockito.<Property>any());
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(property, atLeast(1)).setIsDirty(true);
    verify(adornedTargetListPersistenceModule).update(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualUpdateResult);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#isPromote()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenSandBoxHelperIsPromoteThrowNumberFormatException()
      throws ServiceException {
    // Arrange
    when(sandBoxHelper.isPromote()).thenThrow(new NumberFormatException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"embeddableAdvancedOffer.isTieredOffer"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            offerCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(sandBoxHelper).isPromote();
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_givenNull_whenEntityFindPropertyReturnNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(entity);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code AMOUNT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_givenPropertyGetValueReturnAmountOff()
      throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("AMOUNT_OFF");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(entity);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_givenPropertyGetValueReturnNull() throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(entity);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_givenPropertyWithNameAndValueIs42()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    // Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(entity);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       AMOUNT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_givenPropertyWithNameAndValueIsAmountOff()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "AMOUNT_OFF"));

    // Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(entity);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       FIX_PRICE}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_givenPropertyWithNameAndValueIsFixPrice()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "FIX_PRICE"));

    // Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(entity);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(entity);
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomPersistenceHandler#validateOfferValue(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCustomPersistenceHandler.validateOfferValue(Entity)"})
  public void testValidateOfferValue_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    offerCustomPersistenceHandler.validateOfferValue(new Entity());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property,
   * Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(Property, Property)"
  })
  public void testBuildOfferItemQualifierRuleTypeProperty_given42_whenNull() {
    // Arrange
    Property qualifiersCanBeQualifiers = mock(Property.class);
    when(qualifiersCanBeQualifiers.getValue()).thenReturn("42");

    // Act
    Property actualBuildOfferItemQualifierRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(
            qualifiersCanBeQualifiers, null);

    // Assert
    verify(qualifiersCanBeQualifiers).getValue();
    assertTrue(
        actualBuildOfferItemQualifierRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getRawValue());
    assertEquals(
        "NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemQualifierRuleType",
        actualBuildOfferItemQualifierRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemQualifierRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property,
   * Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(Property, Property)"
  })
  public void testBuildOfferItemQualifierRuleTypeProperty_given42_whenPropertyGetValueReturn42() {
    // Arrange
    Property qualifiersCanBeQualifiers = mock(Property.class);
    when(qualifiersCanBeQualifiers.getValue()).thenReturn("42");

    // Act
    Property actualBuildOfferItemQualifierRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(
            qualifiersCanBeQualifiers, new Property());

    // Assert
    verify(qualifiersCanBeQualifiers).getValue();
    assertTrue(
        actualBuildOfferItemQualifierRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getRawValue());
    assertEquals(
        "NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemQualifierRuleType",
        actualBuildOfferItemQualifierRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemQualifierRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property,
   * Property)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(Property, Property)"
  })
  public void testBuildOfferItemQualifierRuleTypeProperty_given42_whenPropertyGetValueReturn422() {
    // Arrange
    Property qualifiersCanBeQualifiers = mock(Property.class);
    when(qualifiersCanBeQualifiers.getValue()).thenReturn("42");

    Property qualifiersCanBeTargets = mock(Property.class);
    when(qualifiersCanBeTargets.getValue()).thenReturn("42");

    // Act
    Property actualBuildOfferItemQualifierRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(
            qualifiersCanBeQualifiers, qualifiersCanBeTargets);

    // Assert
    verify(qualifiersCanBeQualifiers).getValue();
    verify(qualifiersCanBeTargets).getValue();
    assertTrue(
        actualBuildOfferItemQualifierRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getRawValue());
    assertEquals(
        "NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemQualifierRuleType",
        actualBuildOfferItemQualifierRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemQualifierRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property,
   * Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(Property, Property)"
  })
  public void testBuildOfferItemQualifierRuleTypeProperty_whenNull() {
    // Arrange and Act
    Property actualBuildOfferItemQualifierRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(null, new Property());

    // Assert
    assertTrue(
        actualBuildOfferItemQualifierRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getRawValue());
    assertEquals(
        "NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemQualifierRuleType",
        actualBuildOfferItemQualifierRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemQualifierRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property,
   * Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemQualifierRuleTypeProperty(Property, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(Property, Property)"
  })
  public void testBuildOfferItemQualifierRuleTypeProperty_whenProperty() {
    // Arrange
    Property qualifiersCanBeQualifiers = new Property();

    // Act
    Property actualBuildOfferItemQualifierRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemQualifierRuleTypeProperty(
            qualifiersCanBeQualifiers, new Property());

    // Assert
    assertTrue(
        actualBuildOfferItemQualifierRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getRawValue());
    assertEquals(
        "NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("NONE", actualBuildOfferItemQualifierRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemQualifierRuleType",
        actualBuildOfferItemQualifierRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemQualifierRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemQualifierRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemQualifierRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}.
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(Property)"
  })
  public void testBuildOfferItemTargetRuleTypeProperty() {
    // Arrange
    Property stackable = new Property("Name", Boolean.TRUE.toString());

    // Act
    Property actualBuildOfferItemTargetRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(stackable);

    // Assert
    assertTrue(
        actualBuildOfferItemTargetRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "QUALIFIER_TARGET", actualBuildOfferItemTargetRuleTypePropertyResult.getRawValue());
    assertEquals(
        "QUALIFIER_TARGET",
        actualBuildOfferItemTargetRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("QUALIFIER_TARGET", actualBuildOfferItemTargetRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemTargetRuleType", actualBuildOfferItemTargetRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemTargetRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(Property)"
  })
  public void testBuildOfferItemTargetRuleTypeProperty_givenTrueToString() {
    // Arrange
    Property stackable = mock(Property.class);
    when(stackable.getValue()).thenReturn(Boolean.TRUE.toString());

    // Act
    Property actualBuildOfferItemTargetRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(stackable);

    // Assert
    verify(stackable).getValue();
    assertTrue(
        actualBuildOfferItemTargetRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals(
        "QUALIFIER_TARGET", actualBuildOfferItemTargetRuleTypePropertyResult.getRawValue());
    assertEquals(
        "QUALIFIER_TARGET",
        actualBuildOfferItemTargetRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("QUALIFIER_TARGET", actualBuildOfferItemTargetRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemTargetRuleType", actualBuildOfferItemTargetRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemTargetRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return RawValue is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(Property)"
  })
  public void testBuildOfferItemTargetRuleTypeProperty_whenNull_thenReturnRawValueIsNone() {
    // Arrange and Act
    Property actualBuildOfferItemTargetRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(null);

    // Assert
    assertTrue(
        actualBuildOfferItemTargetRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals("NONE", actualBuildOfferItemTargetRuleTypePropertyResult.getRawValue());
    assertEquals("NONE", actualBuildOfferItemTargetRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("NONE", actualBuildOfferItemTargetRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemTargetRuleType", actualBuildOfferItemTargetRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemTargetRuleTypePropertyResult.getEnabled());
  }

  /**
   * Test {@link OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then return RawValue is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCustomPersistenceHandler#buildOfferItemTargetRuleTypeProperty(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property OfferCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(Property)"
  })
  public void testBuildOfferItemTargetRuleTypeProperty_whenProperty_thenReturnRawValueIsNone() {
    // Arrange and Act
    Property actualBuildOfferItemTargetRuleTypePropertyResult =
        offerCustomPersistenceHandler.buildOfferItemTargetRuleTypeProperty(new Property());

    // Assert
    assertTrue(
        actualBuildOfferItemTargetRuleTypePropertyResult.getMetadata()
            instanceof BasicFieldMetadata);
    assertEquals("NONE", actualBuildOfferItemTargetRuleTypePropertyResult.getRawValue());
    assertEquals("NONE", actualBuildOfferItemTargetRuleTypePropertyResult.getUnHtmlEncodedValue());
    assertEquals("NONE", actualBuildOfferItemTargetRuleTypePropertyResult.getValue());
    assertEquals(
        "offerItemTargetRuleType", actualBuildOfferItemTargetRuleTypePropertyResult.getName());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getOriginalValue());
    assertNull(actualBuildOfferItemTargetRuleTypePropertyResult.getDeployDate());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.getIsDirty());
    assertFalse(actualBuildOfferItemTargetRuleTypePropertyResult.isAdvancedCollection());
    assertTrue(actualBuildOfferItemTargetRuleTypePropertyResult.getEnabled());
  }
}
