package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
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
public class ClassNameRequestParamValidationServiceImplDiffblueTest {
  @Autowired
  private ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl;

  /**
   * Test
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <p>
   * Method under test:
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateClassNameParams() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1020 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl2 = new ClassNameRequestParamValidationServiceImpl();

    // Act
    classNameRequestParamValidationServiceImpl2.validateClassNameParams(new HashMap<>(), "Persistence Unit Name");
  }

  /**
   * Test
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  public void testValidateClassNameParams_whenHashMapFooIsEmptyString_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl = new ClassNameRequestParamValidationServiceImpl();

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "");

    // Act and Assert
    assertTrue(classNameRequestParamValidationServiceImpl.validateClassNameParams(requestParamToClassName,
        "Persistence Unit Name"));
  }

  /**
   * Test
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  public void testValidateClassNameParams_whenHashMap_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl = new ClassNameRequestParamValidationServiceImpl();

    // Act and Assert
    assertFalse(
        classNameRequestParamValidationServiceImpl.validateClassNameParams(new HashMap<>(), "Persistence Unit Name"));
  }

  /**
   * Test
   * {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   * <p>
   * Method under test:
   * {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetClassNameForSection() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass502 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ClassNameRequestParamValidationServiceImpl()).getClassNameForSection("Section Key");
  }

  /**
   * Test
   * {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   * <p>
   * Method under test:
   * {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSectionCrumbs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass761 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ClassNameRequestParamValidationServiceImpl()).getSectionCrumbs("Crumb List");
  }
}
