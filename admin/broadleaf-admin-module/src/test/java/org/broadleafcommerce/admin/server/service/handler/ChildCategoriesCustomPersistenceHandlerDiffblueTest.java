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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryXref;
import org.broadleafcommerce.core.catalog.domain.CategoryXrefImpl;
import org.broadleafcommerce.openadmin.dto.Entity;
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
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChildCategoriesCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler;

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@code allChildCategoryXrefs}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean ChildCategoriesCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_givenAllChildCategoryXrefs_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setSectionEntityField("allChildCategoryXrefs");

    // Act and Assert
    assertTrue(childCategoriesCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean ChildCategoriesCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(childCategoriesCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addGlobalValidationError(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityAddGlobalValidationErrorThrowRuntimeException()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException()).when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            childCategoriesCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            childCategoriesCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturnNull_thenReturnEntity() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.add(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualAddResult =
        childCategoriesCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adornedTargetListPersistenceModule).add(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.ADORNEDTARGETLIST);
    assertSame(entity2, actualAddResult);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            childCategoriesCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowValidationException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            childCategoriesCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage} {@link PersistencePackage#getEntity()} return {@link
   *       Entity} (default constructor).
   *   <li>Then calls {@link PersistencePackage#getEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_whenPersistencePackageGetEntityReturnEntity_thenCallsGetEntity()
      throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    doNothing().when(persistencePackage).setEntity(Mockito.<Entity>any());
    persistencePackage.setEntity(mock(Entity.class));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity = new Entity();
    when(adornedTargetListPersistenceModule.add(Mockito.<PersistencePackage>any()))
        .thenReturn(entity);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualAddResult =
        childCategoriesCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(persistencePackage).getEntity();
    verify(persistencePackage).setEntity(isA(Entity.class));
    verify(adornedTargetListPersistenceModule).add(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.ADORNEDTARGETLIST);
    assertSame(entity, actualAddResult);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage} {@link PersistencePackage#getEntity()} return {@link
   *       Entity}.
   *   <li>Then calls {@link PersistencePackage#getEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_whenPersistencePackageGetEntityReturnEntity_thenCallsGetEntity2()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    doNothing().when(persistencePackage).setEntity(Mockito.<Entity>any());
    persistencePackage.setEntity(mock(Entity.class));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.add(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualAddResult =
        childCategoriesCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePackage).getEntity();
    verify(persistencePackage).setEntity(isA(Entity.class));
    verify(adornedTargetListPersistenceModule).add(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.ADORNEDTARGETLIST);
    assertSame(entity2, actualAddResult);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_givenNull_whenEntityFindPropertyReturnNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateChildCategory(entity);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_givenPropertyGetValueReturnNull()
      throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateChildCategory(entity);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateChildCategory(entity);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    childCategoriesCustomPersistenceHandler.validateChildCategory(new Entity());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenNull_whenEntityFindPropertyReturnNull_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateSelfLink(entity);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyGetValueReturnNull() throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateSelfLink(entity);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateSelfLink(entity);
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    childCategoriesCustomPersistenceHandler.validateSelfLink(new Entity());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateDuplicateChild(Entity)"})
  public void testValidateDuplicateChild_givenNull_whenEntityFindPropertyReturnNull()
      throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateDuplicateChild(Entity)"})
  public void testValidateDuplicateChild_givenPropertyGetValueReturnNull_thenCallsGetValue()
      throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateDuplicateChild(Entity)"})
  public void testValidateDuplicateChild_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateDuplicateChild(Entity)"})
  public void testValidateDuplicateChild_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(new Entity());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"
  })
  public void testValidateRecursiveRelationship_givenNull_whenEntityFindPropertyReturnNull()
      throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"
  })
  public void testValidateRecursiveRelationship_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"
  })
  public void testValidateRecursiveRelationship_thenCallsGetValue() throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"
  })
  public void testValidateRecursiveRelationship_whenEntity_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler =
        new ChildCategoriesCustomPersistenceHandler();

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(new Entity());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategories(Entity, Category,
   * Long, StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} (default constructor) SubCategory is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateChildCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.validateChildCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateChildCategories_givenCategoryXrefImplSubCategoryIsNull()
      throws ValidationException {
    // Arrange
    Entity entity = new Entity();

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(null);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getChildCategoryXrefs()).thenReturn(categoryXrefList);

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateChildCategories(
        entity, category, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategories(Entity, Category,
   * Long, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateChildCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.validateChildCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateChildCategories_whenCategoryImpl_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    Entity entity = new Entity();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateChildCategories(
        entity, category, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategories(Entity, Category,
   * Long, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#validateChildCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.validateChildCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateChildCategories_whenNull_thenDoesNotThrow() throws ValidationException {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    childCategoriesCustomPersistenceHandler.validateChildCategories(
        entity, null, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       fooCategory Name ->}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChildCategoriesCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChildCategoriesCustomPersistenceHandler.addCategoryLink(StringBuilder, String)"
  })
  public void testAddCategoryLink_thenStringBuilderWithFooToStringIsFooCategoryName() {
    // Arrange
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    childCategoriesCustomPersistenceHandler.addCategoryLink(productLinks, "Category Name");

    // Assert
    assertEquals("fooCategory Name -> ", productLinks.toString());
  }
}
