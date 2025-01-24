package org.broadleafcommerce.openadmin.web.rulebuilder.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleBuilderEnumOptionsResourceHandlerDiffblueTest {
  @Autowired
  private RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler;

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}.
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.rulebuilder.enums;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.rulebuilder.enums.RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleBuilderEnumOptionsResourceHandler()).canHandle("Path");
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}.
   * <ul>
   *   <li>When {@code admin/components/ruleBuilder-options.js}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  public void testCanHandle_whenAdminComponentsRuleBuilderOptionsJs_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new RuleBuilderEnumOptionsResourceHandler()).canHandle("admin/components/ruleBuilder-options.js"));
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  public void testCanHandle_whenPath_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new RuleBuilderEnumOptionsResourceHandler()).canHandle("Path"));
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String, List)}.
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFileContents() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.rulebuilder.enums;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass42 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.rulebuilder.enums.RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler2 = new RuleBuilderEnumOptionsResourceHandler();

    // Act
    ruleBuilderEnumOptionsResourceHandler2.getFileContents("Path", new ArrayList<>());
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsCachedResourceExpired() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.rulebuilder.enums;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass50 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.rulebuilder.enums.RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler2 = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    // Act
    ruleBuilderEnumOptionsResourceHandler2.isCachedResourceExpired(cachedResource, "Path", new ArrayList<>());
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_givenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertFalse(ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", locations));
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_givenGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertFalse(ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", locations));
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", new ArrayList<>()));
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>When {@link GeneratedResource}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_whenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = mock(GeneratedResource.class);

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", new ArrayList<>()));
  }
}
