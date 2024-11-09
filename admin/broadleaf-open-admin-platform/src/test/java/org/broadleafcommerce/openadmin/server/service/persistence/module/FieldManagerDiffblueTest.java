/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
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
}
