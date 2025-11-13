package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FieldManagerDiffblueTest {
  @Mock private EntityManager entityManager;

  @InjectMocks private FieldManager fieldManager;

  /**
   * Test {@link FieldManager#FieldManager(EntityConfiguration, EntityManager)}.
   *
   * <p>Method under test: {@link FieldManager#FieldManager(EntityConfiguration, EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldManager.<init>(EntityConfiguration, EntityManager)"})
  public void testNewFieldManager() {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act
    FieldManager actualFieldManager = new FieldManager(entityConfiguration, null);

    // Assert
    assertNull(actualFieldManager.entityManager);
    assertTrue(actualFieldManager.middleFields.isEmpty());
    assertSame(entityConfiguration, actualFieldManager.getEntityConfiguration());
  }

  /**
   * Test {@link FieldManager#getSingleField(Class, String)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getSingleField(Class, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.reflect.Field FieldManager.getSingleField(Class, String)"})
  public void testGetSingleField_whenJavaLangObject_thenReturnNull() throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(FieldManager.getSingleField(clazz, "Field Name"));
  }

  /**
   * Test {@link FieldManager#getField(Class, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getField(Class, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.reflect.Field FieldManager.getField(Class, String)"})
  public void testGetField_thenThrowRuntimeException() throws IllegalStateException {
    // Arrange
    when(entityManager.getMetamodel()).thenThrow(new RuntimeException());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fieldManager.getField(clazz, "Field Name"));
    verify(entityManager).getMetamodel();
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   *
   * <ul>
   *   <li>Then throw {@link FieldNotAvailableException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FieldManager.getFieldValue(Object, String)"})
  public void testGetFieldValue_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    // Act and Assert
    assertThrows(
        FieldNotAvailableException.class, () -> fieldManager.getFieldValue("Bean", "Field Name"));
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code Bean}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FieldManager.getFieldValue(Object, String)"})
  public void testGetFieldValue_whenDot_thenReturnBean()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    // Act and Assert
    assertEquals("Bean", fieldManager.getFieldValue("Bean", "."));
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   *
   * <ul>
   *   <li>When {@link FieldManager#MAPFIELDSEPARATOR}.
   *   <li>Then throw {@link FieldNotAvailableException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FieldManager.getFieldValue(Object, String)"})
  public void testGetFieldValue_whenMapfieldseparator_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange, Act and Assert
    assertThrows(
        FieldNotAvailableException.class,
        () -> fieldManager.getFieldValue("Bean", FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link FieldManager#setFieldValue(Object, String, Object)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code Bean}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#setFieldValue(Object, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FieldManager.setFieldValue(Object, String, Object)"})
  public void testSetFieldValue_whenDot_thenReturnBean()
      throws IllegalAccessException, InstantiationException {
    // Arrange, Act and Assert
    assertEquals("Bean", fieldManager.setFieldValue("Bean", ".", "New Value"));
  }

  /**
   * Test {@link FieldManager#persistMiddleEntities()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#persistMiddleEntities()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map FieldManager.persistMiddleEntities()"})
  public void testPersistMiddleEntities_thenReturnEmpty()
      throws IllegalAccessException, InstantiationException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    // Act and Assert
    assertTrue(fieldManager.persistMiddleEntities().isEmpty());
  }

  /**
   * Test {@link FieldManager#getPersistenceManager(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getPersistenceManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager FieldManager.getPersistenceManager(Class)"
  })
  public void testGetPersistenceManager_thenThrowRuntimeException() {
    // Arrange
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    when(entityManager.getMetamodel()).thenThrow(new RuntimeException());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), entityManager);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fieldManager.getPersistenceManager(entityClass));
    verify(entityManager).getMetamodel();
  }

  /**
   * Test {@link FieldManager#isPersistentClass(Class)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#isPersistentClass(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldManager.isPersistentClass(Class)"})
  public void testIsPersistentClass_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertFalse(fieldManager.isPersistentClass(entityClass));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then throw {@link FieldNotAvailableException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenAString_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertThrows(
        FieldNotAvailableException.class,
        () ->
            fieldManager.handleMapFieldExtraction(
                "Bean",
                "A field containing a map field separator was requested (%s), but no Map type field or method returning"
                    + " a Map was found using the following tests (%s)",
                componentClass,
                new ArrayList<>(),
                ")",
                "Map Key"));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenArrayList_thenThrowIllegalArgumentException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fieldManager.handleMapFieldExtraction(
                "Bean", ")", componentClass, new ArrayList<>(), ")", "Map Key"));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then throw {@link FieldNotAvailableException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenComma_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertThrows(
        FieldNotAvailableException.class,
        () ->
            fieldManager.handleMapFieldExtraction(
                "Bean",
                "A field containing a map field separator was requested (%s), but no Map type field or method returning"
                    + " a Map was found using the following tests (%s)",
                componentClass,
                new ArrayList<>(),
                ",",
                "Map Key"));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenHashMap_thenReturnNull()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertNull(
        fieldManager.handleMapFieldExtraction(
            "Bean", ")", componentClass, new HashMap<>(), ")", "Map Key"));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenHashMap_thenReturnNull2()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertNull(
        fieldManager.handleMapFieldExtraction(
            objectObjectMap, ")", componentClass, new ArrayList<>(), ")", "Map Key"));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link LinkedList#LinkedList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenLinkedList_thenThrowIllegalArgumentException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fieldManager.handleMapFieldExtraction(
                "Bean", ")", componentClass, new LinkedList<>(), ")", "Map Key"));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenNull_thenReturnNull()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertNull(
        fieldManager.handleMapFieldExtraction("Bean", ")", componentClass, null, ")", "Map Key"));
  }

  /**
   * Test {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#handleMapFieldExtraction(Object, String, Class,
   * Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldManager.handleMapFieldExtraction(Object, String, Class, Object, String, String)"
  })
  public void testHandleMapFieldExtraction_whenValue_thenThrowIllegalArgumentException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Class<Object> componentClass = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fieldManager.handleMapFieldExtraction(
                "Bean", ")", componentClass, "Value", ")", "Map Key"));
  }
}
