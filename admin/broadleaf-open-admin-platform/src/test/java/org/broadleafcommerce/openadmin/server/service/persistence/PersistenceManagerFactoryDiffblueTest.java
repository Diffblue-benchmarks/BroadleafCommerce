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
package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.junit.Test;

public class PersistenceManagerFactoryDiffblueTest {
  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager()}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#getPersistenceManager()}
   */
  @Test
  public void testGetPersistenceManager() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> PersistenceManagerFactory.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(String)} with
   * {@code className}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getPersistenceManager(String)}
   */
  @Test
  public void testGetPersistenceManagerWithClassName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getPersistenceManager("Class Name"));
  }

  /**
   * Test
   * {@link PersistenceManagerFactory#getPersistenceManager(String, TargetModeType)}
   * with {@code className}, {@code targetModeType}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getPersistenceManager(String, TargetModeType)}
   */
  @Test
  public void testGetPersistenceManagerWithClassNameTargetModeType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getPersistenceManager("Class Name",
        new TargetModeType("Type", "Friendly Type")));
  }

  /**
   * Test
   * {@link PersistenceManagerFactory#startPersistenceManager(String, TargetModeType)}
   * with {@code entityClassName}, {@code targetModeType}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#startPersistenceManager(String, TargetModeType)}
   */
  @Test
  public void testStartPersistenceManagerWithEntityClassNameTargetModeType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.startPersistenceManager("Entity Class Name",
        new TargetModeType("Type", "Friendly Type")));
  }

  /**
   * Test {@link PersistenceManagerFactory#getClassForName(String)}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#getClassForName(String)}
   */
  @Test
  public void testGetClassForName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getClassForName("Class Name"));
  }
}
