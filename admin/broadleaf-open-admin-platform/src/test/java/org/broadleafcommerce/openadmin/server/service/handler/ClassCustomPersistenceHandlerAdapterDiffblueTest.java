package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassCustomPersistenceHandlerAdapterDiffblueTest {
  /**
   * Test {@link
   * ClassCustomPersistenceHandlerAdapter#ClassCustomPersistenceHandlerAdapter(Class[])}.
   *
   * <p>Method under test: {@link
   * ClassCustomPersistenceHandlerAdapter#ClassCustomPersistenceHandlerAdapter(Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassCustomPersistenceHandlerAdapter.<init>(Class[])"})
  public void testNewClassCustomPersistenceHandlerAdapter() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    ClassCustomPersistenceHandlerAdapter actualClassCustomPersistenceHandlerAdapter =
        new ClassCustomPersistenceHandlerAdapter(forNameResult);

    // Assert
    List<Class<?>> resultClassList = actualClassCustomPersistenceHandlerAdapter.handledClasses;
    assertEquals(1, resultClassList.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, resultClassList.get(0));
    assertEquals(
        CustomPersistenceHandler.DEFAULT_ORDER,
        actualClassCustomPersistenceHandlerAdapter.getOrder());
  }

  /**
   * Test {@link ClassCustomPersistenceHandlerAdapter#classMatches(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ClassCustomPersistenceHandlerAdapter#classMatches(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassCustomPersistenceHandlerAdapter.classMatches(PersistencePackage)"
  })
  public void testClassMatches() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter =
        new ClassCustomPersistenceHandlerAdapter(forNameResult);

    // Act and Assert
    assertFalse(classCustomPersistenceHandlerAdapter.classMatches(new PersistencePackage()));
  }

  /**
   * Test {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassCustomPersistenceHandlerAdapter.classIsAssignableFrom(PersistencePackage)"
  })
  public void testClassIsAssignableFrom_thenReturnFalse() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter =
        new ClassCustomPersistenceHandlerAdapter(forNameResult);
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage pkg =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    boolean actualClassIsAssignableFromResult =
        classCustomPersistenceHandlerAdapter.classIsAssignableFrom(pkg);

    // Assert
    assertFalse(actualClassIsAssignableFromResult);
  }

  /**
   * Test {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassCustomPersistenceHandlerAdapter.classIsAssignableFrom(PersistencePackage)"
  })
  public void testClassIsAssignableFrom_thenReturnTrue() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter =
        new ClassCustomPersistenceHandlerAdapter(forNameResult);
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage pkg =
        new PersistencePackage(
            "java.util.List", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    boolean actualClassIsAssignableFromResult =
        classCustomPersistenceHandlerAdapter.classIsAssignableFrom(pkg);

    // Assert
    assertTrue(actualClassIsAssignableFromResult);
  }
}
