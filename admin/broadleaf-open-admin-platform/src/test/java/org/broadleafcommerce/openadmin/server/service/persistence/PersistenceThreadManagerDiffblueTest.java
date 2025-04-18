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

import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersistenceThreadManagerDiffblueTest {
  @Autowired
  private PersistenceThreadManager persistenceThreadManager;

  /**
   * Test {@link PersistenceThreadManager#operation(TargetModeType, Persistable)}
   * with {@code targetModeType}, {@code persistable}.
   * <p>
   * Method under test:
   * {@link PersistenceThreadManager#operation(TargetModeType, Persistable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOperationWithTargetModeTypePersistable() throws Throwable {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass30 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceThreadManager persistenceThreadManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceThreadManager persistenceThreadManager2 = new PersistenceThreadManager();

    // Act
    persistenceThreadManager2.<Object, Throwable>operation(new TargetModeType("Type", "Friendly Type"),
        mock(Persistable.class));
  }

  /**
   * Test
   * {@link PersistenceThreadManager#operation(TargetModeType, PersistencePackage, Persistable)}
   * with {@code targetModeType}, {@code pkg}, {@code persistable}.
   * <p>
   * Method under test:
   * {@link PersistenceThreadManager#operation(TargetModeType, PersistencePackage, Persistable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOperationWithTargetModeTypePkgPersistable() throws Throwable {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceThreadManager persistenceThreadManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceThreadManager persistenceThreadManager2 = new PersistenceThreadManager();
    TargetModeType targetModeType = new TargetModeType("Type", "Friendly Type");

    // Act
    persistenceThreadManager2.<Object, Throwable>operation(targetModeType, new PersistencePackage(),
        mock(Persistable.class));
  }
}
