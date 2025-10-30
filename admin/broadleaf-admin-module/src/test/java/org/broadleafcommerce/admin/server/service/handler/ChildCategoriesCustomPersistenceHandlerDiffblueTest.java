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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryXref;
import org.broadleafcommerce.core.catalog.domain.CategoryXrefImpl;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
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
public class ChildCategoriesCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private ChildCategoriesCustomPersistenceHandler childCategoriesCustomPersistenceHandler;

  @Mock
  private CategoryDao categoryDao;

  @Mock
  private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code allChildCategoryXrefs}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ChildCategoriesCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_givenAllChildCategoryXrefs_thenReturnTrue() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionEntityField("allChildCategoryXrefs");

    // Act and Assert
    assertTrue(childCategoriesCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ChildCategoriesCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(childCategoriesCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link AdornedTargetListPersistenceModule} {@link AdornedTargetListPersistenceModule#add(PersistencePackage)} return {@link Entity} (default constructor).</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenAdornedTargetListPersistenceModuleAddReturnEntity_thenReturnEntity()
      throws ServiceException {
    // Arrange
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
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property(String, String)} with name is {@code category.id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityFindPropertyReturnPropertyWithNameIsCategoryIdAndValueIs42() throws ServiceException {
    // Arrange
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
   * Test {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ChildCategoriesCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException() throws ServiceException {
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
    assertThrows(ValidationException.class, () -> childCategoriesCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_givenPropertyGetValueReturn42() throws ValidationException {
    // Arrange
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
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_givenPropertyGetValueReturnNull_thenCallsGetValue() throws ValidationException {
    // Arrange
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
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code category.id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_givenPropertyWithNameIsCategoryIdAndValueIs42() throws ValidationException {
    // Arrange
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
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateChildCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateChildCategory(Entity)"})
  public void testValidateChildCategory_givenProperty_whenEntityFindPropertyReturnProperty()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateChildCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyGetValueReturn42_thenCallsGetValue() throws ValidationException {
    // Arrange
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
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code category.id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyWithNameIsCategoryIdAndValueIs42() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class, () -> childCategoriesCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addGlobalValidationError(eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenProperty_whenEntityFindPropertyReturnProperty() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateSelfLink(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateDuplicateChild(Entity)"})
  public void testValidateDuplicateChild_givenPropertyGetValueReturn42_thenCallsGetValue() throws ValidationException {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(entity);

    // Assert
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateDuplicateChild(Entity)"})
  public void testValidateDuplicateChild_givenProperty_whenEntityFindPropertyReturnProperty()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}.
   * <ul>
   *   <li>Then calls {@link CategoryDao#readCategoryById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateDuplicateChild(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateDuplicateChild(Entity)"})
  public void testValidateDuplicateChild_thenCallsReadCategoryById() throws ValidationException {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act
    childCategoriesCustomPersistenceHandler.validateDuplicateChild(entity);

    // Assert
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship() throws ValidationException {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenArrayListAddCategoryXrefImpl() throws ValidationException {
    // Arrange
    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getChildCategoryXrefs()).thenReturn(categoryXrefList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category).getChildCategoryXrefs();
    verify(category, atLeast(1)).getName();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getSubCategory()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenCategoryXrefImplGetSubCategoryReturnNull()
      throws ValidationException {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getSubCategory()).thenReturn(null);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getChildCategoryXrefs()).thenReturn(categoryXrefList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category).getChildCategoryXrefs();
    verify(category, atLeast(1)).getName();
    verify(categoryXrefImpl).getSubCategory();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenProperty() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Then calls {@link org.broadleafcommerce.core.catalog.domain.Category#getChildCategoryXrefs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_thenCallsGetChildCategoryXrefs() throws ValidationException {
    // Arrange
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getChildCategoryXrefs()).thenReturn(new ArrayList<>());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category).getChildCategoryXrefs();
    verify(category, atLeast(1)).getName();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getChildCategoryXrefs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_thenCallsGetChildCategoryXrefs2() throws ValidationException {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.getName()).thenReturn("Name");
    when(categoryImpl.getChildCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getSubCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getChildCategoryXrefs()).thenReturn(categoryXrefList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("category.id", "42"));

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category).getChildCategoryXrefs();
    verify(category, atLeast(1)).getName();
    verify(categoryImpl).getChildCategoryXrefs();
    verify(categoryImpl).getId();
    verify(categoryImpl).getName();
    verify(categoryXrefImpl).getSubCategory();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_thenCallsGetValue() throws ValidationException {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.getName()).thenReturn("Name");
    when(categoryImpl.getChildCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getSubCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getChildCategoryXrefs()).thenReturn(categoryXrefList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    childCategoriesCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category).getChildCategoryXrefs();
    verify(category, atLeast(1)).getName();
    verify(categoryImpl).getChildCategoryXrefs();
    verify(categoryImpl).getId();
    verify(categoryImpl).getName();
    verify(categoryXrefImpl).getSubCategory();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link ChildCategoriesCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code fooCategory Name ->}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildCategoriesCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChildCategoriesCustomPersistenceHandler.addCategoryLink(StringBuilder, String)"})
  public void testAddCategoryLink_thenStringBuilderWithFooToStringIsFooCategoryName() {
    // Arrange
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    childCategoriesCustomPersistenceHandler.addCategoryLink(productLinks, "Category Name");

    // Assert
    assertEquals("fooCategory Name -> ", productLinks.toString());
  }
}
