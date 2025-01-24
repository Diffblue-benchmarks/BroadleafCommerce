package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.lang.reflect.Field;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.engine.spi.SessionImplementor;
import org.junit.Ignore;
import org.junit.Test;
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

  @MockBean
  private EntityManager entityManager;

  @Autowired
  private FieldManager fieldManager;

  /**
   * Test {@link FieldManager#FieldManager(EntityConfiguration, EntityManager)}.
   * <ul>
   *   <li>When {@link EntityConfiguration}.</li>
   *   <li>Then return {@link FieldManager#entityManager} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldManager#FieldManager(EntityConfiguration, EntityManager)}
   */
  @Test
  public void testNewFieldManager_whenEntityConfiguration_thenReturnEntityManagerIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);

    // Act
    FieldManager actualFieldManager = new FieldManager(entityConfiguration, null);

    // Assert
    assertNull(actualFieldManager.entityManager);
    assertTrue(actualFieldManager.middleFields.isEmpty());
    assertSame(entityConfiguration, actualFieldManager.getEntityConfiguration());
  }

  /**
   * Test {@link FieldManager#getSingleField(Class, String)}.
   * <p>
   * Method under test: {@link FieldManager#getSingleField(Class, String)}
   */
  @Test
  public void testGetSingleField() throws IllegalStateException {
    // Arrange
    Class<FieldManager> clazz = FieldManager.class;

    // Act and Assert
    assertNull(FieldManager.getSingleField(clazz, "Field Name"));
  }

  /**
   * Test {@link FieldManager#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getSingleField(Class, String)}
   */
  @Test
  public void testGetSingleField_whenJavaLangObject_thenReturnNull() throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(FieldManager.getSingleField(clazz, "Field Name"));
  }

  /**
   * Test {@link FieldManager#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@link FieldManager#MAPFIELDSEPARATOR}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getSingleField(Class, String)}
   */
  @Test
  public void testGetSingleField_whenMapfieldseparator_thenReturnNull() throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(FieldManager.getSingleField(clazz, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link FieldManager#getField(Class, String)}.
   * <ul>
   *   <li>Given
   * {@link SessionDelegatorBaseImpl#SessionDelegatorBaseImpl(SessionImplementor)}
   * with delegate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getField(Class, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetField_givenSessionDelegatorBaseImplWithDelegateIsNull() throws IllegalStateException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager.isPersistentClass(FieldManager.java:256)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager.getPersistenceManager(FieldManager.java:243)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager.getField(FieldManager.java:73)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);
    FieldManager fieldManager = new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
    Class<Object> clazz = Object.class;

    // Act
    fieldManager.getField(clazz, "Field Name");
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code Bean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  public void testGetFieldValue_whenDot_thenReturnBean() throws IllegalAccessException, FieldNotAvailableException {
    // Arrange, Act and Assert
    assertEquals("Bean", fieldManager.getFieldValue("Bean", "."));
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then throw {@link FieldNotAvailableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  public void testGetFieldValue_whenFieldName_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange, Act and Assert
    assertThrows(FieldNotAvailableException.class, () -> fieldManager.getFieldValue("Bean", "Field Name"));
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   * <ul>
   *   <li>When {@link FieldManager#MAPFIELDSEPARATOR}.</li>
   *   <li>Then throw {@link FieldNotAvailableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  public void testGetFieldValue_whenMapfieldseparator_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange, Act and Assert
    assertThrows(FieldNotAvailableException.class,
        () -> fieldManager.getFieldValue("Bean", FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link FieldManager#getFieldValue(Object, String)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link FieldNotAvailableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getFieldValue(Object, String)}
   */
  @Test
  public void testGetFieldValue_whenOne_thenThrowFieldNotAvailableException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange, Act and Assert
    assertThrows(FieldNotAvailableException.class, () -> fieldManager.getFieldValue(1, "Field Name"));
  }

  /**
   * Test {@link FieldManager#setFieldValue(Object, String, Object)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code Bean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#setFieldValue(Object, String, Object)}
   */
  @Test
  public void testSetFieldValue_whenDot_thenReturnBean() throws IllegalAccessException, InstantiationException {
    // Arrange, Act and Assert
    assertEquals("Bean", fieldManager.setFieldValue("Bean", ".", "New Value"));
  }

  /**
   * Test {@link FieldManager#getFieldType(Field)}.
   * <ul>
   *   <li>Given
   * {@link SessionDelegatorBaseImpl#SessionDelegatorBaseImpl(SessionImplementor)}
   * with delegate is {@link SessionImplementor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#getFieldType(Field)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldType_givenSessionDelegatorBaseImplWithDelegateIsSessionImplementor() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:100)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(mock(SessionImplementor.class));

    // Act
    (new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(mock(SessionImplementor.class)))))
            .getFieldType(null);
  }

  /**
   * Test {@link FieldManager#persistMiddleEntities()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#persistMiddleEntities()}
   */
  @Test
  public void testPersistMiddleEntities_thenReturnEmpty() throws IllegalAccessException, InstantiationException {
    // Arrange, Act and Assert
    assertTrue((new FieldManager(new EntityConfiguration(), null)).persistMiddleEntities().isEmpty());
  }

  /**
   * Test {@link FieldManager#getPersistenceManager(Class)}.
   * <p>
   * Method under test: {@link FieldManager#getPersistenceManager(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPersistenceManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:100)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(mock(SessionImplementor.class));
    FieldManager fieldManager = new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(mock(SessionImplementor.class))));
    Class<Object> entityClass = Object.class;

    // Act
    fieldManager.getPersistenceManager(entityClass);
  }

  /**
   * Test {@link FieldManager#isPersistentClass(Class)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldManager#isPersistentClass(Class)}
   */
  @Test
  public void testIsPersistentClass_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertFalse(fieldManager.isPersistentClass(entityClass));
  }

  /**
   * Test
   * {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String, String)}.
   * <ul>
   *   <li>When {@code Field Name Part}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldManager#handleMapFieldExtraction(Object, String, Class, Object, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleMapFieldExtraction_whenFieldNamePart()
      throws IllegalAccessException, FieldNotAvailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.StringIndexOutOfBoundsException: begin 0, end -1, length 10
    //       at java.base/java.lang.String.checkBoundsBeginEnd(String.java:3319)
    //       at java.base/java.lang.String.substring(String.java:1874)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager.handleMapFieldExtraction(FieldManager.java:269)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> componentClass = Object.class;

    // Act
    fieldManager.handleMapFieldExtraction("Bean", "Field Name", componentClass, "Value", "Field Name Part", "Map Key");
  }

  /**
   * Test
   * {@link FieldManager#handleMapFieldPopulation(Object, String, Object, Class, Field, Object, String, String)}.
   * <ul>
   *   <li>When {@code Field Name Part}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldManager#handleMapFieldPopulation(Object, String, Object, Class, Field, Object, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleMapFieldPopulation_whenFieldNamePart() throws IllegalAccessException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.StringIndexOutOfBoundsException: begin 0, end -1, length 10
    //       at java.base/java.lang.String.checkBoundsBeginEnd(String.java:3319)
    //       at java.base/java.lang.String.substring(String.java:1874)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager.handleMapFieldPopulation(FieldManager.java:315)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> componentClass = Object.class;

    // Act
    fieldManager.handleMapFieldPopulation("Bean", "Field Name", "New Value", componentClass, null, "Value",
        "Field Name Part", "Map Key");
  }

  /**
   * Test {@link FieldManager#clearMiddleFields()}.
   * <p>
   * Method under test: {@link FieldManager#clearMiddleFields()}
   */
  @Test
  public void testClearMiddleFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new FieldManager(new EntityConfiguration(), null)).clearMiddleFields();
  }

  /**
   * Test {@link FieldManager#clearMiddleFields()}.
   * <p>
   * Method under test: {@link FieldManager#clearMiddleFields()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearMiddleFields2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:100)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(mock(SessionImplementor.class));

    // Act
    (new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(mock(SessionImplementor.class)))))
            .clearMiddleFields();
  }
}
