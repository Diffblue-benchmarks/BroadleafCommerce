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
package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.common.service.PersistenceService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.test.mock.mockito.MockBean;

public class PersistenceManagerFactoryDiffblueTest {
  @MockBean
  private PersistenceService persistenceService;

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager()}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#getPersistenceManager()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager()"})
  public void testGetPersistenceManager() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> PersistenceManagerFactory.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(String)} with {@code className}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#getPersistenceManager(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager(String)"})
  public void testGetPersistenceManagerWithClassName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getPersistenceManager("Class Name"));
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(String, TargetModeType)} with {@code className}, {@code targetModeType}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#getPersistenceManager(String, TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager(String, TargetModeType)"})
  public void testGetPersistenceManagerWithClassNameTargetModeType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getPersistenceManager("Class Name",
        new TargetModeType("Type", "Friendly Type")));
  }

  /**
   * Test {@link PersistenceManagerFactory#startPersistenceManager(String, TargetModeType)} with {@code entityClassName}, {@code targetModeType}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#startPersistenceManager(String, TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PersistenceManagerFactory.startPersistenceManager(String, TargetModeType)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Class PersistenceManagerFactory.getClassForName(String)"})
  public void testGetClassForName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getClassForName("Class Name"));
  }
}
