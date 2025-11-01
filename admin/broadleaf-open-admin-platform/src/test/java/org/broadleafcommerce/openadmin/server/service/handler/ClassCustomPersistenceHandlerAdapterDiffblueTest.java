/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.junit.Test;

public class ClassCustomPersistenceHandlerAdapterDiffblueTest {
  /**
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#classMatches(PersistencePackage)}
   */
  @Test
  public void testClassMatches() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = new ClassCustomPersistenceHandlerAdapter(
        forNameResult);

    // Act and Assert
    assertFalse(classCustomPersistenceHandlerAdapter.classMatches(new PersistencePackage()));
  }

  /**
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
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}
   */
  @Test
  public void testClassIsAssignableFrom2() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = new ClassCustomPersistenceHandlerAdapter(
        forNameResult);
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(classCustomPersistenceHandlerAdapter.classIsAssignableFrom(new PersistencePackage("java.util.List",
        entity, new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Method under test:
   * {@link ClassCustomPersistenceHandlerAdapter#classIsAssignableFrom(PersistencePackage)}
   */
  @Test
  public void testClassIsAssignableFrom3() {
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
    Class<?> getResult = resultClassList.get(0);
    assertEquals(expectedGetResult, getResult);
    assertEquals(CustomPersistenceHandler.DEFAULT_ORDER, actualClassCustomPersistenceHandlerAdapter.getOrder());
    assertSame(forNameResult, getResult);
  }
}
