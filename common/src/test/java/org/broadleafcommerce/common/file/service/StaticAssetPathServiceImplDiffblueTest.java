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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StaticAssetPathServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticAssetPathServiceImplDiffblueTest {
  @Autowired
  private StaticAssetPathServiceImpl staticAssetPathServiceImpl;

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAllAssetPathsInContent(String, boolean)"})
  public void testConvertAllAssetPathsInContent_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
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
   * <ul>
   *   <li>Then return {@code ${asset.server.url.prefix.secure}/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnAssetServerUrlPrefixSecure() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix.secure}/",
        staticAssetPathServiceImpl.convertAssetPath("${asset.server.url.prefix.internal}", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>When {@code Asset Path}.</li>
   *   <li>Then return {@code ${asset.server.url.prefix.secure}/Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenAssetPath_thenReturnAssetServerUrlPrefixSecureAssetPath() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix.secure}/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(staticAssetPathServiceImpl.convertAssetPath(null, null, false));
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code ${asset.server.url.prefix}/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_whenSlash_thenReturnAssetServerUrlPrefix() {
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix}/", staticAssetPathServiceImpl.convertAssetPath("/", null, false));
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
    // Arrange, Act and Assert
    assertEquals("${asset.server.url.prefix}/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
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
   * Test {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}.
   * <p>
   * Method under test: {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetPathServiceImpl.addThemeContextIfNeeded(String)"})
  public void testAddThemeContextIfNeeded() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example"));
  }
}
