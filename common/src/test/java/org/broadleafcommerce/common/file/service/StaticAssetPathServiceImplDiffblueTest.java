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
import org.junit.Test;

public class StaticAssetPathServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new StaticAssetPathServiceImpl()).convertAllAssetPathsInContent("Not all who wander are lost", true));
    assertNull((new StaticAssetPathServiceImpl()).convertAllAssetPathsInContent(null, true));
    assertEquals("", (new StaticAssetPathServiceImpl()).convertAllAssetPathsInContent("", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", false));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:https://example.org/example/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:https:/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:themeChangeStatus/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", false));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/https://exampleUorg/example/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:/https://exampleUorg/example/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent18() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("Static Asset Environment Secure Url Prefix");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:Static Asset Environment Secure Url Prefix/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent19() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("42");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:42/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent20() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("http:");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:http:/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent21() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("//", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent22() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/https:https://example.org/example/exampleUorg/example/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("/https://exampleUorg/example/", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("//", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent24() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("/https:/", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent25() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/themeChangeStatus/");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:/themeChangeStatus/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", false));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent26() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("Static Asset Environment Url Prefix");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https:Static Asset Environment Url Prefix/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", false));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent27() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("themeChangeStatus/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("//", false));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent28() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("themeChangeStatus/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("/themeChangeStatus/", false));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent29() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https:");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/example.org/example",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent30() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/https://exampleUorg/example/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/https://exampleUorg/example/", staticAssetPathServiceImpl.convertAllAssetPathsInContent("//", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent31() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/https://exampleUorg/example/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/https://exampleUorg/example/https:/https://exampleUorg/example/exampleUorg/example/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("//https://exampleUorg/example/", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent32() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/https://exampleUorg/example/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/https:/https://exampleUorg/example/exampleUorg/example/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("/https://exampleUorg/example/", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent33() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("Static Asset Environment Secure Url Prefix");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Static Asset Environment Secure Url Prefix/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("//", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent34() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("Static Asset Environment Secure Url Prefix");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("themeChangeStatus");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Static Asset Environment Secure Url Prefix/",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("/Static Asset Environment Secure Url Prefix/", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/Context Path/Asset Path",
        (new StaticAssetPathServiceImpl()).convertAssetPath("Asset Path", "Context Path", true));
    assertNull((new StaticAssetPathServiceImpl()).convertAssetPath(null, null, false));
    assertEquals("/", (new StaticAssetPathServiceImpl()).convertAssetPath("/", null, false));
    assertEquals("/", (new StaticAssetPathServiceImpl()).convertAssetPath("/", "", false));
    assertEquals("/", (new StaticAssetPathServiceImpl()).convertAssetPath("/", "/", false));
    assertEquals("http:", (new StaticAssetPathServiceImpl()).convertAssetPath("http:", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/Context Path/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/Context Path/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/Context Path/", staticAssetPathServiceImpl.convertAssetPath("/", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.convertAssetPath("/", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl
        .setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/examplehttps://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("https://example.org/example", staticAssetPathServiceImpl.convertAssetPath("/", "Context Path", true));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals("https:/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  public void testAddThemeContextIfNeeded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new StaticAssetPathServiceImpl()).addThemeContextIfNeeded("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  public void testAddThemeContextIfNeeded2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link StaticAssetPathServiceImpl#setStaticAssetEnvironmentSecureUrlPrefix(String)}
   *   <li>
   * {@link StaticAssetPathServiceImpl#setStaticAssetEnvironmentUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#setStaticAssetUrlPrefix(String)}
   *   <li>{@link StaticAssetPathServiceImpl#getStaticAssetUrlPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();

    // Act
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");

    // Assert that nothing has changed
    assertEquals("https://example.org/example", staticAssetPathServiceImpl.getStaticAssetUrlPrefix());
  }
}
