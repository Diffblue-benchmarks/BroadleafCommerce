package org.broadleafcommerce.openadmin.server.service.persistence.module.extension;

import static org.junit.Assert.assertEquals;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule;
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
public class DefaultBasicPersistenceModuleExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultBasicPersistenceModuleExtensionHandler defaultBasicPersistenceModuleExtensionHandler;

  /**
   * Test {@link DefaultBasicPersistenceModuleExtensionHandler#init()}.
   * <p>
   * Method under test:
   * {@link DefaultBasicPersistenceModuleExtensionHandler#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultBasicPersistenceModuleExtensionHandler defaultBasicPersistenceModuleExtensionHandler = new DefaultBasicPersistenceModuleExtensionHandler();
    defaultBasicPersistenceModuleExtensionHandler.setEnabled(false);

    // Act
    defaultBasicPersistenceModuleExtensionHandler.init();

    // Assert
    assertEquals(BasicPersistenceModuleExtensionHandler.DEFAULT_PRIORITY,
        defaultBasicPersistenceModuleExtensionHandler.getPriority());
  }

  /**
   * Test {@link DefaultBasicPersistenceModuleExtensionHandler#init()}.
   * <p>
   * Method under test:
   * {@link DefaultBasicPersistenceModuleExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10800 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.extension.DefaultBasicPersistenceModuleExtensionHandler defaultBasicPersistenceModuleExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultBasicPersistenceModuleExtensionHandler()).init();
  }

  /**
   * Test
   * {@link DefaultBasicPersistenceModuleExtensionHandler#rebalanceForAdd(BasicPersistenceModule, PersistencePackage, Serializable, Map, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DefaultBasicPersistenceModuleExtensionHandler#rebalanceForAdd(BasicPersistenceModule, PersistencePackage, Serializable, Map, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRebalanceForAdd() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10803 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.extension.DefaultBasicPersistenceModuleExtensionHandler defaultBasicPersistenceModuleExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultBasicPersistenceModuleExtensionHandler defaultBasicPersistenceModuleExtensionHandler2 = new DefaultBasicPersistenceModuleExtensionHandler();
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    ExtensionResultHolder<Serializable> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new SimpleDateFormat("yyyy/mm/dd"));
    resultHolder.setThrowable(new Throwable());

    // Act
    defaultBasicPersistenceModuleExtensionHandler2.rebalanceForAdd(basicPersistenceModule, persistencePackage, instance,
        mergedProperties, resultHolder);
  }

  /**
   * Test
   * {@link DefaultBasicPersistenceModuleExtensionHandler#rebalanceForUpdate(BasicPersistenceModule, PersistencePackage, Serializable, Map, Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DefaultBasicPersistenceModuleExtensionHandler#rebalanceForUpdate(BasicPersistenceModule, PersistencePackage, Serializable, Map, Object, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRebalanceForUpdate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11016 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.extension.DefaultBasicPersistenceModuleExtensionHandler defaultBasicPersistenceModuleExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultBasicPersistenceModuleExtensionHandler defaultBasicPersistenceModuleExtensionHandler2 = new DefaultBasicPersistenceModuleExtensionHandler();
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    ExtensionResultHolder<Serializable> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new SimpleDateFormat("yyyy/mm/dd"));
    resultHolder.setThrowable(new Throwable());

    // Act
    defaultBasicPersistenceModuleExtensionHandler2.rebalanceForUpdate(basicPersistenceModule, persistencePackage,
        instance, mergedProperties, "Primary Key", resultHolder);
  }
}
