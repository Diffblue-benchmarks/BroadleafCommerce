/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class ChildCategoriesCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code allChildCategoryXrefs}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenAllChildCategoryXrefs_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionEntityField()).thenReturn("allChildCategoryXrefs");

    // Act
    Boolean actualCanHandleAddResult = childCategoriesCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getSectionEntityField();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Section Entity Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenSectionEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionEntityField()).thenReturn("Section Entity Field");

    // Act
    Boolean actualCanHandleAddResult = childCategoriesCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getSectionEntityField();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();

    // Act and Assert
    assertFalse(childCategoriesCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link AdornedTargetListPersistenceModule}
   * {@link AdornedTargetListPersistenceModule#add(PersistencePackage)} return
   * {@link Entity} (default constructor).</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenAdornedTargetListPersistenceModuleAddReturnEntity_thenReturnEntity()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.add(Mockito.<PersistencePackage>any())).thenReturn(entity2);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualAddResult = childCategoriesCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adornedTargetListPersistenceModule).add(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(eq(OperationType.ADORNEDTARGETLIST));
    assertSame(entity2, actualAddResult);
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property(String, String)} with name is {@code category.id}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityFindPropertyReturnPropertyWithNameIsCategoryIdAndValueIs42() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ValidationException.class, () -> childCategoriesCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ValidationException.class, () -> childCategoriesCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  public void testValidateChildCategory_givenPropertyGetValueReturn42() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> childCategoriesCustomPersistenceHandler.validateChildCategory(entity));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code null}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  public void testValidateChildCategory_givenPropertyGetValueReturnNull_thenCallsGetValue() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    childCategoriesCustomPersistenceHandler.validateChildCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is
   * {@code category.id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  public void testValidateChildCategory_givenPropertyWithNameIsCategoryIdAndValueIs42() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> childCategoriesCustomPersistenceHandler.validateChildCategory(entity));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  public void testValidateChildCategory_givenProperty_whenEntityFindPropertyReturnProperty()
      throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateChildCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink_givenPropertyGetValueReturn42_thenCallsGetValue() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(ValidationException.class, () -> childCategoriesCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is
   * {@code category.id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink_givenPropertyWithNameIsCategoryIdAndValueIs42() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class, () -> childCategoriesCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink_givenProperty_whenEntityFindPropertyReturnProperty() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateSelfLink(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then calls {@link Entity#findProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  public void testValidateDuplicateChild_givenProperty_thenCallsFindProperty() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then calls {@link Entity#findProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  public void testValidateRecursiveRelationship_givenProperty_thenCallsFindProperty() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link ChildCategoriesCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo}
   * toString is {@code fooCategory Name ->}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChildCategoriesCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}
   */
  @Test
  public void testAddCategoryLink_thenStringBuilderWithFooToStringIsFooCategoryName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler = new ChildCategoriesCustomPersistenceHandler();
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    childCategoriesCustomPersistenceHandler.addCategoryLink(productLinks, "Category Name");

    // Assert
    assertEquals("fooCategory Name -> ", productLinks.toString());
  }
}
