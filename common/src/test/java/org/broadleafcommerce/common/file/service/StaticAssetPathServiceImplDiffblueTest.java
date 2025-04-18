/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.file.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StaticAssetPathServiceImplDiffblueTest {
  @Autowired
  private StaticAssetPathServiceImpl staticAssetPathServiceImpl;

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent2() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent3() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent4() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent5() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent_givenStaticAssetPathServiceImpl() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent_givenStaticAssetPathServiceImpl2() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new StaticAssetPathServiceImpl()).convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent_thenReturnHttpsExampleOrgExample() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", staticAssetPathServiceImpl.convertAllAssetPathsInContent("", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(staticAssetPathServiceImpl.convertAllAssetPathsInContent(null, true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath2() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(null);

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath3() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", null, true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   *   <li>When {@code http:}.</li>
   *   <li>Then return {@code http:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_givenStaticAssetPathServiceImpl_whenHttp_thenReturnHttp() {
    // Arrange, Act and Assert
    assertEquals("http:", (new StaticAssetPathServiceImpl()).convertAssetPath("http:", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnAssetPath() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code /${asset.server.url.prefix.internal}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnAssetServerUrlPrefixInternal() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("${asset.server.url.prefix.internal}");

    // Act and Assert
    assertEquals("/${asset.server.url.prefix.internal}",
        staticAssetPathServiceImpl.convertAssetPath("${asset.server.url.prefix.internal}", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ${asset.server.url.prefix.secure}/Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnAssetServerUrlPrefixSecureAssetPath() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix.secure}/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code /Context Path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnContextPath() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/Context Path/", staticAssetPathServiceImpl.convertAssetPath("/", "Context Path", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code /Context Path/Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnContextPathAssetPath() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/Context Path/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnHttpsExampleOrgExample() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/", staticAssetPathServiceImpl.convertAssetPath("/", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnHttpsExampleOrgExample2() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/",
        staticAssetPathServiceImpl.convertAssetPath("${asset.server.url.prefix.internal}", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnNull() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.convertAssetPath(null, null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@code Asset Path}.</li>
   *   <li>Then return {@code /Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenAssetPath_thenReturnAssetPath() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>When {@code ${asset.server.url.prefix}/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenAssetServerUrlPrefix() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix.secure}/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "${asset.server.url.prefix}/", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenEmptyString_thenReturnSlash() {
    // Arrange
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "", false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>When {@code http:}.</li>
   *   <li>Then return {@code ${asset.server.url.prefix.secure}/http:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenHttp_thenReturnAssetServerUrlPrefixSecureHttp() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix.secure}/http:",
        staticAssetPathServiceImpl.convertAssetPath("http:", "Context Path", true));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StaticAssetPathServiceImpl#setStaticAssetEnvironmentSecureUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#setStaticAssetEnvironmentUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#setStaticAssetUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#getStaticAssetUrlPrefix()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetUrlPrefix()",
      "void StaticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix(String)",
      "void StaticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix(String)",
      "void StaticAssetPathServiceImpl.setStaticAssetUrlPrefix(String)"})
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();

    // Act
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", staticAssetPathServiceImpl.getStaticAssetUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix2() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix_givenStaticAssetPathServiceImpl() {
    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code ${asset.server.url.prefix}/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix_thenReturnAssetServerUrlPrefix() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix}/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix_thenReturnSlash() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix.secure}/",
        staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix2() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix3() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix4() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_givenStaticAssetPathServiceImpl() {
    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code https:/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnHttps() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals("https:/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnSlash() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.addThemeContextIfNeeded(String)"})
  public void testAddThemeContextIfNeeded() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.addThemeContextIfNeeded(String)"})
  public void testAddThemeContextIfNeeded_givenStaticAssetPathServiceImpl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example"));
  }
}
