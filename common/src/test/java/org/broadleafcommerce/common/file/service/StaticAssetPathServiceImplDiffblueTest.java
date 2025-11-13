package org.broadleafcommerce.common.file.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StaticAssetPathServiceImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticAssetPathServiceImplDiffblueTest {
  @Autowired private StaticAssetPathServiceImpl staticAssetPathServiceImpl;

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent2() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent3() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix(" ");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent4() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent5() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(null);

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent6() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent7() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent8() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(
        "https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent9() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(null);
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent10() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent11() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals(
        "https://example.org/example//example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent12() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(
        "Static Asset Environment Url Prefix");

    // Act and Assert
    assertEquals(
        "Static Asset Environment Url Prefix//example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent13() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(
        "org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl");

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code 42/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturn42() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("42");

    // Act and Assert
    assertEquals(
        "42/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code 42//example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturn42ExampleOrgExample() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("42");

    // Act and Assert
    assertEquals(
        "42//example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code /example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnExampleOrgExample() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code //example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnExampleOrgExample2() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("//");

    // Act and Assert
    assertEquals(
        "//example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code http:/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnHttp() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals(
        "http:/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code http://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnHttpExampleOrgExample() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals(
        "http://example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code https:/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnHttps() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https:");

    // Act and Assert
    assertEquals(
        "https:/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnHttpsExampleOrgExample() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals(
        "https://example.org/example/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code https:/example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnHttpsExampleOrgExample2() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "https:/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code //}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnSlashSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("//");

    // Act and Assert
    assertEquals(
        "//", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Static Asset Environment Url Prefix/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnStaticAssetEnvironmentUrlPrefix() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(
        "Static Asset Environment Url Prefix");

    // Act and Assert
    assertEquals(
        "Static Asset Environment Url Prefix/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code themeChangeStatus/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnThemeChangeStatus() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");

    // Act and Assert
    assertEquals(
        "themeChangeStatus/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code themeChangeStatus//example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_thenReturnThemeChangeStatusExampleOrgExample() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");

    // Act and Assert
    assertEquals(
        "themeChangeStatus//example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent(
            "https://example.org/example", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return space.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_whenSpace_thenReturnSpace() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals(" ", staticAssetPathServiceImpl.convertAllAssetPathsInContent(" ", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"
  })
  public void testConvertAllAssetPathsInContent_whenTrue() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("not blank");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "not blank", staticAssetPathServiceImpl.convertAllAssetPathsInContent("not blank", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath2() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(null);

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath3() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath4() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(null);
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath5() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals(
        "https:/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ${asset.server.url.prefix.secure}/Asset Path}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnAssetServerUrlPrefixSecureAssetPath() {
    // Arrange, Act and Assert
    assertEquals(
        "${asset.server.url.prefix.secure}/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code /Context Path/Asset Path}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnContextPathAssetPath() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals(
        "/Context Path/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code http:/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnHttp() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals("http:/", staticAssetPathServiceImpl.convertAssetPath("/", "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code https:/Asset Path}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnHttpsAssetPath() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals(
        "https:/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code not blank/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnNotBlank() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("not blank");

    // Act and Assert
    assertEquals("not blank/", staticAssetPathServiceImpl.convertAssetPath("/", "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnSlash2() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "/", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code http:}.
   *   <li>Then return {@code ${asset.server.url.prefix.secure}/http:}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenHttp_thenReturnAssetServerUrlPrefixSecureHttp() {
    // Arrange, Act and Assert
    assertEquals(
        "${asset.server.url.prefix.secure}/http:",
        staticAssetPathServiceImpl.convertAssetPath("http:", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code http:}.
   *   <li>Then return {@code http:}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenHttp_thenReturnHttp() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("http:", staticAssetPathServiceImpl.convertAssetPath("http:", "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then return {@code ${asset.server.url.prefix.secure}/not blank}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenNotBlank_thenReturnAssetServerUrlPrefixSecureNotBlank() {
    // Arrange, Act and Assert
    assertEquals(
        "${asset.server.url.prefix.secure}/not blank",
        staticAssetPathServiceImpl.convertAssetPath("not blank", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenNull_thenReturnNull() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.convertAssetPath(null, "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenNull_thenReturnSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@code / /}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenSpaceSpace_thenReturnSlashSpaceSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/  /", staticAssetPathServiceImpl.convertAssetPath("/", "  ", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code themeChangeStatus}.
   *   <li>Then return {@code /themeChangeStatus}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenThemeChangeStatus_thenReturnThemeChangeStatus() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals(
        "/themeChangeStatus",
        staticAssetPathServiceImpl.convertAssetPath("themeChangeStatus", "", false));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StaticAssetPathServiceImpl#setStaticAssetEnvironmentSecureUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#setStaticAssetEnvironmentUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#setStaticAssetUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#getStaticAssetUrlPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetUrlPrefix()",
    "void StaticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(String)",
    "void StaticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(String)",
    "void StaticAssetPathServiceImpl.setStaticAssetUrlPrefix(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();

    // Act
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(
        "https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");

    // Assert
    assertEquals(
        "https://example.org/example", staticAssetPathServiceImpl.getStaticAssetUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix2() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(null);

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix3() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(
        "${asset.server.url.prefix.internal}");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   *
   * <ul>
   *   <li>Then return {@code ${asset.server.url.prefix}/}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix_thenReturnAssetServerUrlPrefix() {
    // Arrange, Act and Assert
    assertEquals(
        "${asset.server.url.prefix}/",
        staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   *
   * <ul>
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix_thenReturnSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix() {
    // Arrange, Act and Assert
    assertEquals(
        "${asset.server.url.prefix.secure}/",
        staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix2() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(null);

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix3() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("  ");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix4() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(null);
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix5() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(
        "${asset.server.url.prefix.internal}");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix6() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <ul>
   *   <li>Then return {@code https:/}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnHttps() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals("https:/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   *
   * <ul>
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"
  })
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.addThemeContextIfNeeded(String)"})
  public void testAddThemeContextIfNeeded_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}.
   *
   * <ul>
   *   <li>Then return {@code ThreadLocalManager.notify.orphans}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.addThemeContextIfNeeded(String)"})
  public void testAddThemeContextIfNeeded_thenReturnThreadLocalManagerNotifyOrphans() {
    // Arrange, Act and Assert
    assertEquals(
        "ThreadLocalManager.notify.orphans",
        staticAssetPathServiceImpl.addThemeContextIfNeeded("ThreadLocalManager.notify.orphans"));
  }
}
