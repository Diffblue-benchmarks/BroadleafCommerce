package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.admin.domain.TypedEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TypedEntityBasicEntityExtensionHandlerDiffblueTest {
  @Autowired
  private TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler;

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#init()}.
   * <p>
   * Method under test: {@link TypedEntityBasicEntityExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1074 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new TypedEntityBasicEntityExtensionHandler()).init();
  }

  /**
   * Test
   * {@link TypedEntityBasicEntityExtensionHandler#getDynamicEntityDao(String)}.
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDynamicEntityDao(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDynamicEntityDao() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass756 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new TypedEntityBasicEntityExtensionHandler()).getDynamicEntityDao("Class Name");
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  public void testGetDefaultType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntityBasicEntityExtensionHandler> implClass = TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass596 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler2 = new TypedEntityBasicEntityExtensionHandler();
    Class<Object> implClass = Object.class;

    // Act
    typedEntityBasicEntityExtensionHandler2.getDefaultType(implClass);
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  public void testGetDefaultType_whenJavaLangObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.admin.domain.TypedEntity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  public void testGetDefaultType_whenOrgBroadleafcommerceCommonAdminDomainTypedEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntity> implClass = TypedEntity.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  public void testGetTypeFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntityBasicEntityExtensionHandler> implClass = TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTypeFieldName2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass914 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler2 = new TypedEntityBasicEntityExtensionHandler();
    Class<Object> implClass = Object.class;

    // Act
    typedEntityBasicEntityExtensionHandler2.getTypeFieldName(implClass);
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  public void testGetTypeFieldName_whenJavaLangObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.admin.domain.TypedEntity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  public void testGetTypeFieldName_whenOrgBroadleafcommerceCommonAdminDomainTypedEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntity> implClass = TypedEntity.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }
}
