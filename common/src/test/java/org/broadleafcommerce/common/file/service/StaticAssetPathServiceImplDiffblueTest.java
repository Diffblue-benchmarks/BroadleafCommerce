/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent2() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent3() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent4() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent5() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent6() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent7() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent8() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent9() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent10() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent11() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent12() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent13() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent14() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent15() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent16() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_givenStaticAssetPathServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new StaticAssetPathServiceImpl()).convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code /example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnExampleOrgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https:/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttps() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https:42/example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttps42ExampleOrgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttpsExampleOrgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttpsExampleOrgExample2() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttpsExampleOrgExample3() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code /https://exampleUorg/example/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttpsExampleUorgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https:http:/example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttpsHttpExampleOrgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code https:https:/example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnHttpsHttpsExampleOrgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnNotAllWhoWanderAreLost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("Not all who wander are lost",
        staticAssetPathServiceImpl.convertAllAssetPathsInContent("Not all who wander are lost", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnNotAllWhoWanderAreLost2() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_thenReturnNotAllWhoWanderAreLost3() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_whenEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new StaticAssetPathServiceImpl()).convertAllAssetPathsInContent("", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_whenFalse_thenReturnHttpsExampleOrgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When {@code /https:/}.</li>
   *   <li>Then return {@code https:/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_whenHttps_thenReturnHttps() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).convertAllAssetPathsInContent(null, true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When {@code //}.</li>
   *   <li>Then return {@code themeChangeStatus/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_whenSlashSlash_thenReturnThemeChangeStatus() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When {@code /Static Asset Environment Secure Url Prefix/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_whenStaticAssetEnvironmentSecureUrlPrefix() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}.
   * <ul>
   *   <li>When {@code /themeChangeStatus/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAllAssetPathsInContent(String, boolean)}
   */
  @Test
  public void testConvertAllAssetPathsInContent_whenThemeChangeStatus() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.addThemeContextIfNeeded("https://example.org/example");

    // Act and Assert
    assertEquals("/Context Path/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertEquals("/Context Path/Asset Path",
        staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath5() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath6() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_givenStaticAssetPathServiceImpl_whenFalse_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/", (new StaticAssetPathServiceImpl()).convertAssetPath("/", "/", false));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   *   <li>When {@code http:}.</li>
   *   <li>Then return {@code http:}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_givenStaticAssetPathServiceImpl_whenHttp_thenReturnHttp() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("http:", (new StaticAssetPathServiceImpl()).convertAssetPath("http:", "Context Path", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_givenStaticAssetPathServiceImpl_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).convertAssetPath(null, null, false));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_givenStaticAssetPathServiceImpl_whenNull_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/", (new StaticAssetPathServiceImpl()).convertAssetPath("/", null, false));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_thenReturnAssetPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("Asset Path", staticAssetPathServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code /Context Path/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_thenReturnContextPath() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code /Context Path/Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_thenReturnContextPathAssetPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/Context Path/Asset Path",
        (new StaticAssetPathServiceImpl()).convertAssetPath("Asset Path", "Context Path", true));
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_thenReturnHttpsExampleOrgExample() {
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
   * Test
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  public void testConvertAssetPath_whenEmptyString_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/", (new StaticAssetPathServiceImpl()).convertAssetPath("/", "", false));
  }

  /**
   * Test getters and setters.
   * <p>
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

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix_givenStaticAssetPathServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentUrlPrefix_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentUrlPrefix());
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetUrlPrefix("https://example.org/example");
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");

    // Act and Assert
    assertNull(staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_givenStaticAssetPathServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetPathServiceImpl()).getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code https:/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnHttps() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentUrlPrefix("http:");

    // Act and Assert
    assertEquals("https:/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetPathServiceImpl staticAssetPathServiceImpl = new StaticAssetPathServiceImpl();
    staticAssetPathServiceImpl.setStaticAssetEnvironmentSecureUrlPrefix("/");

    // Act and Assert
    assertEquals("/", staticAssetPathServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
  }

  /**
   * Test {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  public void testAddThemeContextIfNeeded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link StaticAssetPathServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetPathServiceImpl#addThemeContextIfNeeded(String)}
   */
  @Test
  public void testAddThemeContextIfNeeded_givenStaticAssetPathServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new StaticAssetPathServiceImpl()).addThemeContextIfNeeded("https://example.org/example"));
  }
}
