package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AbstractBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
            "https://example.org/example", params, holder));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   *
   * <ul>
   *   <li>Given {@link CategoryBreadcrumbServiceExtensionHandler} (default constructor).
   *   <li>Then return {@code 2000}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBreadcrumbServiceExtensionHandler.getPriority()"})
  public void testGetPriority_givenCategoryBreadcrumbServiceExtensionHandler_thenReturn2000() {
    // Arrange, Act and Assert
    assertEquals(2000, new CategoryBreadcrumbServiceExtensionHandler().getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBreadcrumbServiceExtensionHandler.getPriority()"})
  public void testGetPriority_thenReturnOne() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Act and Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}.
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractBreadcrumbServiceExtensionHandler.setPriority(Integer)"})
  public void testSetPriority() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    // Act
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.priority.intValue());
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code https://example.org/example?foo=foo&42=foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_given42_thenReturnHttpsExampleOrgExampleFooFoo42Foo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("42", new String[] {"foo"});
    params.put("foo", new String[] {"foo"});

    // Act and Assert
    assertEquals(
        "https://example.org/example?foo=foo&42=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code null}.
   *   <li>Then return {@code https://example.org/example?foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_givenArrayOfStringWithNull_thenReturnHttpsExampleOrgExampleFoo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[] {null});

    // Act and Assert
    assertEquals(
        "https://example.org/example?foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@code ?=foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_givenEmptyString_thenReturnFoo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("", new String[] {"foo"});

    // Act and Assert
    assertEquals("?=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@code Url}.
   *   <li>Then return {@code Url?foo=foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_givenFoo_whenUrl_thenReturnUrlFooFoo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[] {"foo"});

    // Act and Assert
    assertEquals("Url?foo=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?foo=foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_thenReturnHttpsExampleOrgExampleFooFoo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[] {"foo"});

    // Act and Assert
    assertEquals(
        "https://example.org/example?foo=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_whenEmptyString_thenReturnEmptyString() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("", categoryBreadcrumbServiceExtensionHandler.buildLink("", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_whenHashMap_thenReturnHttpsExampleOrgExample() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        "https://example.org/example",
        categoryBreadcrumbServiceExtensionHandler.buildLink(
            "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_whenNull_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        new CategoryBreadcrumbServiceExtensionHandler()
            .buildLink("https://example.org/example", null));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   *
   * <ul>
   *   <li>When {@code Url}.
   *   <li>Then return {@code Url}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  public void testBuildLink_whenUrl_thenReturnUrl() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        "Url", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   *
   * <ul>
   *   <li>Given {@link CategoryBreadcrumbServiceExtensionHandler} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractBreadcrumbServiceExtensionHandler.isEnabled()"})
  public void testIsEnabled_givenCategoryBreadcrumbServiceExtensionHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new CategoryBreadcrumbServiceExtensionHandler().isEnabled());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractBreadcrumbServiceExtensionHandler.isEnabled()"})
  public void testIsEnabled_thenReturnFalse() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setEnabled(false);

    // Act and Assert
    assertFalse(categoryBreadcrumbServiceExtensionHandler.isEnabled());
  }
}
