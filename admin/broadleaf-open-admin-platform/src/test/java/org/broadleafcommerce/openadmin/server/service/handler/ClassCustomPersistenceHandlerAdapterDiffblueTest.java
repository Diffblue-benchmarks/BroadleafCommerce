package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.junit.Test;

public class ClassCustomPersistenceHandlerAdapterDiffblueTest {
  /**
   * Test
   * {@link ClassCustomPersistenceHandlerAdapter#ClassCustomPersistenceHandlerAdapter(Class[])}.
   * <p>
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#ClassCustomPersistenceHandlerAdapter(Class[])}
   */
  @Test
  public void testNewClassCustomPersistenceHandlerAdapter() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    ClassCustomPersistenceHandlerAdapter actualClassCustomPersistenceHandlerAdapter = new ClassCustomPersistenceHandlerAdapter(
        forNameResult);

    // Assert
    List<Class<?>> resultClassList = actualClassCustomPersistenceHandlerAdapter.handledClasses;
    assertEquals(1, resultClassList.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, resultClassList.get(0));
    assertEquals(CustomPersistenceHandler.DEFAULT_ORDER, actualClassCustomPersistenceHandlerAdapter.getOrder());
  }

  /**
   * Test
   * {@link ClassCustomPersistenceHandlerAdapter#classMatches(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#classMatches(PersistencePackage)}
   */
  @Test
  public void testClassMatches_givenJavaLangObject_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = new ClassCustomPersistenceHandlerAdapter(
        forNameResult);

    // Act and Assert
    assertFalse(classCustomPersistenceHandlerAdapter.classMatches(new PersistencePackage()));
  }

  /**
   * Test
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}
   */
  @Test
  public void testClassIsAssignableFrom() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = new ClassCustomPersistenceHandlerAdapter(
        forNameResult);
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(classCustomPersistenceHandlerAdapter.classIsAssignableFrom(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.lang.Class}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}
   */
  @Test
  public void testClassIsAssignableFrom_givenJavaLangClass_thenReturnFalse() {
    // Arrange
    Class<Class> forNameResult = Class.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = new ClassCustomPersistenceHandlerAdapter(
        forNameResult);
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(classCustomPersistenceHandlerAdapter.classIsAssignableFrom(new PersistencePackage("java.util.List",
        entity, new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}
   */
  @Test
  public void testClassIsAssignableFrom_thenReturnTrue() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = new ClassCustomPersistenceHandlerAdapter(
        forNameResult);
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(classCustomPersistenceHandlerAdapter.classIsAssignableFrom(new PersistencePackage("java.util.List",
        entity, new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }
}
