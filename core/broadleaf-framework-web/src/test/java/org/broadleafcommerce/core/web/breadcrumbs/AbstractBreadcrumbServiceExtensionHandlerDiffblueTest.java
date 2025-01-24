package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class AbstractBreadcrumbServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractBreadcrumbServiceExtensionHandler abstractBreadcrumbServiceExtensionHandler;

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given 'ThreadLocalManager.notify.orphans'")
  void testModifyBreadcrumbList_givenThreadLocalManagerNotifyOrphans() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("ThreadLocalManager.notify.orphans", mock(BiFunction.class));

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); when HashMap()")
  void testModifyBreadcrumbList_whenHashMap() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Disabled("TODO: Complete this test")
  void testGetPriority() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass969 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.AbstractBreadcrumbServiceExtensionHandler abstractBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategoryBreadcrumbServiceExtensionHandler()).getPriority();
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   * <ul>
   *   <li>Given {@link CategoryBreadcrumbServiceExtensionHandler} (default
   * constructor).</li>
   *   <li>Then return {@code 2000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority(); given CategoryBreadcrumbServiceExtensionHandler (default constructor); then return '2000'")
  void testGetPriority_givenCategoryBreadcrumbServiceExtensionHandler_thenReturn2000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(2000, (new CategoryBreadcrumbServiceExtensionHandler()).getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getParentCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority(); then calls getParentCategory()")
  void testGetPriority_thenCallsGetParentCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    int actualPriority = categoryBreadcrumbServiceExtensionHandler.getPriority();

    // Assert
    verify(category).getParentCategory();
    assertEquals(2000, actualPriority);
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority(); then return one")
  void testGetPriority_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Act and Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}.
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}
   */
  @Test
  @DisplayName("Test setPriority(Integer)")
  void testSetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.priority.intValue());
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}.
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}
   */
  @Test
  @DisplayName("Test setPriority(Integer)")
  @Disabled("TODO: Complete this test")
  void testSetPriority2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass981 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.AbstractBreadcrumbServiceExtensionHandler abstractBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategoryBreadcrumbServiceExtensionHandler()).setPriority(1);
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getParentCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}
   */
  @Test
  @DisplayName("Test setPriority(Integer); then calls getParentCategory()")
  void testSetPriority_thenCallsGetParentCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Assert
    verify(category).getParentCategory();
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.priority.intValue());
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map)")
  @Disabled("TODO: Complete this test")
  void testBuildLink() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass954 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.AbstractBreadcrumbServiceExtensionHandler abstractBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act
    categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", new HashMap<>());
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code https://example.org/example?foo=foo&42=foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); given '42'; then return 'https://example.org/example?foo=foo&42=foo'")
  void testBuildLink_given42_thenReturnHttpsExampleOrgExampleFooFoo42Foo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("42", new String[]{"foo"});
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("https://example.org/example?foo=foo&42=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); given BiFunction; when HashMap() computeIfPresent 'foo' and BiFunction")
  void testBuildLink_givenBiFunction_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("foo", mock(BiFunction.class));
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("https://example.org/example?foo=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code ?foo=foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); given 'foo'; when empty string; then return '?foo=foo'")
  void testBuildLink_givenFoo_whenEmptyString_thenReturnFooFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("?foo=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("", params));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code Url?foo=foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); given 'foo'; when 'Url'; then return 'Url?foo=foo'")
  void testBuildLink_givenFoo_whenUrl_thenReturnUrlFooFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("Url?foo=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", params));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example?foo=foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); then return 'https://example.org/example?foo=foo'")
  void testBuildLink_thenReturnHttpsExampleOrgExampleFooFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("https://example.org/example?foo=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when empty string; then return empty string")
  void testBuildLink_whenEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("", categoryBreadcrumbServiceExtensionHandler.buildLink("", new HashMap<>()));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when HashMap(); then return 'https://example.org/example'")
  void testBuildLink_whenHashMap_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("https://example.org/example",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", new HashMap<>()));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when 'null'; then return 'https://example.org/example'")
  void testBuildLink_whenNull_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new CategoryBreadcrumbServiceExtensionHandler()).buildLink("https://example.org/example", null));
  }

  /**
   * Test
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when 'Url'; then return 'Url'")
  void testBuildLink_whenUrl_thenReturnUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("Url", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled()")
  @Disabled("TODO: Complete this test")
  void testIsEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass973 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.AbstractBreadcrumbServiceExtensionHandler abstractBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategoryBreadcrumbServiceExtensionHandler()).isEnabled();
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   * <ul>
   *   <li>Given {@link CategoryBreadcrumbServiceExtensionHandler} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled(); given CategoryBreadcrumbServiceExtensionHandler (default constructor); then return 'true'")
  void testIsEnabled_givenCategoryBreadcrumbServiceExtensionHandler_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryBreadcrumbServiceExtensionHandler()).isEnabled());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled(); then return 'false'")
  void testIsEnabled_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setEnabled(false);
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    boolean actualIsEnabledResult = categoryBreadcrumbServiceExtensionHandler.isEnabled();

    // Assert
    verify(category).getParentCategory();
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled(); then return 'true'")
  void testIsEnabled_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    boolean actualIsEnabledResult = categoryBreadcrumbServiceExtensionHandler.isEnabled();

    // Assert
    verify(category).getParentCategory();
    assertTrue(actualIsEnabledResult);
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#setEnabled(boolean)}.
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setEnabled(boolean)")
  @Disabled("TODO: Complete this test")
  void testSetEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass977 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.AbstractBreadcrumbServiceExtensionHandler abstractBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategoryBreadcrumbServiceExtensionHandler()).setEnabled(true);
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#setEnabled(boolean)}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getParentCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setEnabled(boolean); then calls getParentCategory()")
  void testSetEnabled_thenCallsGetParentCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    categoryBreadcrumbServiceExtensionHandler.setEnabled(true);

    // Assert
    verify(category).getParentCategory();
  }
}
