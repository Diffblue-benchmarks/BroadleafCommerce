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
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldManagerDiffblueTest {
  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @MockBean private EntityManager entityManager;

  @Autowired private FieldManager fieldManager;

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
   * <p>Method under test: {@link FieldManager#getSingleField(Class, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.reflect.Field FieldManager.getSingleField(Class, String)"})
  public void testGetSingleField() throws IllegalStateException {
    // Arrange
    Class<FieldManager> clazz = FieldManager.class;

    // Act and Assert
    assertNull(FieldManager.getSingleField(clazz, "Field Name"));
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
   * Test {@link FieldManager#getSingleField(Class, String)}.
   *
   * <ul>
   *   <li>When {@link FieldManager#MAPFIELDSEPARATOR}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getSingleField(Class, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.reflect.Field FieldManager.getSingleField(Class, String)"})
  public void testGetSingleField_whenMapfieldseparator_thenReturnNull()
      throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(FieldManager.getSingleField(clazz, FieldManager.MAPFIELDSEPARATOR));
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
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    when(entityManager.getMetamodel()).thenThrow(new RuntimeException());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), entityManager);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fieldManager.getField(clazz, "Field Name"));
    verify(entityManager).getMetamodel();
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
    // Arrange, Act and Assert
    assertEquals("Bean", fieldManager.getFieldValue("Bean", "."));
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then throw {@link FieldNotAvailableException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FieldManager.getFieldValue(Object, String)"})
  public void testGetFieldValue_whenFieldName_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange, Act and Assert
    assertThrows(
        FieldNotAvailableException.class, () -> fieldManager.getFieldValue("Bean", "Field Name"));
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
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link FieldNotAvailableException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FieldManager.getFieldValue(Object, String)"})
  public void testGetFieldValue_whenOne_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange, Act and Assert
    assertThrows(
        FieldNotAvailableException.class, () -> fieldManager.getFieldValue(1, "Field Name"));
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
}
