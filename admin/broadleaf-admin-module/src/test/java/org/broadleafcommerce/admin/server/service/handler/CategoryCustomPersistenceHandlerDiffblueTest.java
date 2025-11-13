package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryXref;
import org.broadleafcommerce.core.catalog.domain.CategoryXrefImpl;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
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
public class CategoryCustomPersistenceHandlerDiffblueTest {
  @InjectMocks private CategoryCustomPersistenceHandler categoryCustomPersistenceHandler;

  @Mock private CategoryDao categoryDao;

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd2() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd3() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_thenReturnTrue() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Category",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect2() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect3() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_thenReturnTrue() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Category",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate2() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate3() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenReturnTrue() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Category",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link CategoryCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CategoryCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_givenCategoryCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addValidationError(String, String)} does nothing.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityAddValidationErrorDoesNothing_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addValidationError(String, String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityAddValidationErrorThrowRuntimeException() throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException())
        .when(entity)
        .addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property(String, String)} with {@code Name} and value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityFindPropertyReturnPropertyWithNameAndValueIsNull()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturnNull_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

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
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addValidationError(String, String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenEntityAddValidationErrorThrowRuntimeException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException())
        .when(entity)
        .addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnNull_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            categoryCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
    verify(property, atLeast(1)).getValue();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.Category"), isNull());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

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
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_thenThrowValidationException() throws ServiceException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenArrayListAddCategoryImpl_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    ArrayList<org.broadleafcommerce.core.catalog.domain.Category> categoryList = new ArrayList<>();
    categoryList.add(new CategoryImpl());
    when(categoryDao.readAllSubCategories(Mockito.<Long>any())).thenReturn(categoryList);

    Property property = new Property();
    property.setValue("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("id", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(categoryDao).readAllSubCategories(42L);
    verify(entity).getPMap();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default
   *       constructor).
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenArrayListAddCategoryProductXrefImpl_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    when(categoryDao.findXrefByCategoryWithDefaultReference(Mockito.<Long>any()))
        .thenReturn(categoryProductXrefList);
    when(categoryDao.readAllSubCategories(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    Property property = new Property();
    property.setValue("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("id", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(categoryDao).findXrefByCategoryWithDefaultReference(42L);
    verify(categoryDao).readAllSubCategories(42L);
    verify(entity).getPMap();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_thenCallsGetOperationTypes() throws ServiceException {
    // Arrange
    when(categoryDao.findXrefByCategoryWithDefaultReference(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(categoryDao.readAllSubCategories(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    doNothing().when(property).setValue(Mockito.<String>any());
    property.setValue("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("id", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    categoryCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(categoryDao).findXrefByCategoryWithDefaultReference(42L);
    verify(categoryDao).readAllSubCategories(42L);
    verify(entity).getPMap();
    verify(persistencePerspective).getOperationTypes();
    verify(property).getValue();
    verify(property).setValue("42");
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        ValidationException.class, () -> categoryCustomPersistenceHandler.validateCategory(entity));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyGetValueReturnNull_thenCallsGetValue()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyWithNameAndValueIs42() throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    // Act and Assert
    assertThrows(
        ValidationException.class, () -> categoryCustomPersistenceHandler.validateCategory(entity));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategory(new Entity());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyGetValueReturn42_thenCallsGetValue()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        ValidationException.class, () -> categoryCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyWithNameAndValueIs42() throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    // Act and Assert
    assertThrows(
        ValidationException.class, () -> categoryCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateSelfLink(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    categoryCustomPersistenceHandler.validateSelfLink(new Entity());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_thenCallsGetValue() throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_whenEntity_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    categoryCustomPersistenceHandler.validateRecursiveRelationship(new Entity());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategories(Entity, Category, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code defaultParentCategory} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.validateCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateCategories_givenHashMapDefaultParentCategoryIsArrayList()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.put("defaultParentCategory", new ArrayList<>());

    Entity entity = new Entity();
    entity.setPropertyValidationErrors(validationErrors);

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategories(entity, null, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategories(Entity, Category, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link CategoryImpl#getParentCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.validateCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateCategories_givenNull_thenCallsGetParentCategory()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(null);

    // Act
    categoryCustomPersistenceHandler.validateCategories(
        entity, category, 1L, new StringBuilder("foo"));

    // Assert
    verify(category).getParentCategory();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategories(Entity, Category, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.validateCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateCategories_whenCategoryImpl_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategories(
        entity, category, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       fooCategory Name ->}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.addCategoryLink(StringBuilder, String)"
  })
  public void testAddCategoryLink_thenStringBuilderWithFooToStringIsFooCategoryName() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    categoryCustomPersistenceHandler.addCategoryLink(productLinks, "Category Name");

    // Assert
    assertEquals("fooCategory Name -> ", productLinks.toString());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#isDefaultCategoryLegacyMode()}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryCustomPersistenceHandler.isDefaultCategoryLegacyMode()"})
  public void testIsDefaultCategoryLegacyMode() {
    // Arrange, Act and Assert
    assertFalse(new CategoryCustomPersistenceHandler().isDefaultCategoryLegacyMode());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getExistingDefaultCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryCustomPersistenceHandler.getExistingDefaultCategory(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetExistingDefaultCategory_thenReturnNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertNull(categoryCustomPersistenceHandler.getExistingDefaultCategory(new CategoryImpl()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("defaultParentCategory");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(new FulfillmentType());
    category.setId(1L);
    category.setInventoryType(new InventoryType());
    category.setLongDescription("defaultParentCategory");
    category.setMetaDescription("defaultParentCategory");
    category.setMetaTitle("Dr");
    category.setName("defaultParentCategory");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("defaultParentCategory");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("defaultParentCategory");
    category.setUpSaleProducts(new ArrayList<>());
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(category);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayListAddCategoryXrefImpl() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayListAddCategoryXrefImpl_whenEntity() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link CategoryXrefImpl} (default constructor).
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenCategoryXrefImpl_thenCallsGetValue() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenEntity() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenNull_thenCallsGetValue() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, null, entity);

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXref} {@link CategoryXref#getCategory()} return {@link CategoryImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXref} {@link CategoryXref#getDefaultReference()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefGetDefaultReferenceReturnFalse() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryImpl categoryImpl2 = mock(CategoryImpl.class);
    when(categoryImpl2.isActive()).thenReturn(true);
    doNothing().when(categoryImpl2).setActiveStartDate(Mockito.<Date>any());
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getDefaultReference()).thenReturn(false);
    when(categoryXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setSubCategory(null);
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
    verify(categoryImpl2).isActive();
    verify(categoryImpl).isActive();
    verify(categoryImpl2).setActiveStartDate(isA(Date.class));
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXref).getCategory();
    verify(categoryXref, atLeast(1)).getDefaultReference();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()} return {@link
   *       CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnFalse() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnTrue() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link CategoryXrefImpl} (default constructor) Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenNull_whenCategoryXrefImplCategoryIsNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>When {@link CategoryXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyGetValueReturn42_whenCategoryXrefImpl() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = mock(CategoryXrefImpl.class);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIs42() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIsEmptyString() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIsNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>When {@link CategoryXrefImpl} (default constructor) Category is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_whenCategoryXrefImplCategoryIsCategoryImpl() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(mock(CategoryImpl.class));

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>When {@link CategoryXrefImpl} (default constructor) SubCategory is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_whenCategoryXrefImplSubCategoryIsCategoryImpl() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    doNothing().when(categoryImpl).setActiveStartDate(Mockito.<Date>any());
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getDefaultReference()).thenReturn(true);
    when(categoryXref.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(mock(CategoryXrefImpl.class));

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setSubCategory(mock(CategoryImpl.class));
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryImpl).setActiveStartDate(isA(Date.class));
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXref).getCategory();
    verify(categoryXref, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenArrayListAddCategoryXrefImpl_thenReturnNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenArrayList_thenReturnNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()} return {@link
   *       CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnFalse() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl).getDefaultReference();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnTrue() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_whenCategoryImpl_thenReturnNull() {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertNull(categoryCustomPersistenceHandler.getCurrentDefaultXref(new CategoryImpl()));
  }
}
