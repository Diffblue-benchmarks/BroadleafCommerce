/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.mockito.Mockito;

public class URLHandlerImplDiffblueTest {
  /**
   * Test {@link URLHandlerImpl#getUrlRedirectType()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getUrlRedirectType()}
   */
  @Test
  public void testGetUrlRedirectType_givenURLHandlerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getUrlRedirectType());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler_givenURLHandlerImplUrlRedirectTypeIsForward_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setIncomingURL(".");

    // Act and Assert
    assertTrue(urlHandlerImpl.isRegexHandler());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler_givenURLHandlerImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new URLHandlerImpl()).isRegexHandler());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(redirectType);
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setIncomingURL(".");

    // Act
    boolean actualIsRegexHandlerResult = urlHandlerImpl.isRegexHandler();

    // Assert
    verify(redirectType).getType();
    assertTrue(actualIsRegexHandlerResult);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_givenURLHandlerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();

    // Act
    urlHandlerImpl.setRegexHandler(true);

    // Assert
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_givenURLHandlerImplUrlRedirectTypeIsForward() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act
    urlHandlerImpl.setRegexHandler(null);

    // Assert
    assertFalse(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then {@link URLHandlerImpl} (default constructor)
   * {@link URLHandlerImpl#isRegex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_givenURLHandlerImpl_thenURLHandlerImplIsRegex() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();

    // Act
    urlHandlerImpl.setRegexHandler((Boolean) true);

    // Assert
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    urlHandlerImpl.setRegexHandler(null);

    // Assert
    verify(redirectType).getType();
    assertFalse(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_thenCallsGetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    urlHandlerImpl.setRegexHandler(true);

    // Assert
    verify(redirectType).getType();
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenURLHandlerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getMainEntityName());
  }

  /**
   * Test {@link URLHandlerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    String actualMainEntityName = urlHandlerImpl.getMainEntityName();

    // Assert
    verify(redirectType).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) IncomingURL is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenURLHandlerImplIncomingURLIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setIncomingURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", urlHandlerImpl.getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenURLHandlerImplUrlRedirectTypeIsForward() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);
    urlHandlerImpl.setIncomingURL(".");
    urlHandlerImpl.setRegexHandler(true);

    // Act and Assert
    assertEquals("https://example.org/example", urlHandlerImpl.getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenURLHandlerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(redirectType);
    urlHandlerImpl.setIncomingURL(".");
    urlHandlerImpl.setRegexHandler(true);

    // Act
    String actualLocation = urlHandlerImpl.getLocation();

    // Assert
    verify(redirectType).getType();
    assertEquals("https://example.org/example", actualLocation);
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>When {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImplUrlRedirectTypeIsForward_whenAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("*"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>When {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImplUrlRedirectTypeIsForward_whenBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("\\"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>When {@code +}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImplUrlRedirectTypeIsForward_whenPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("+"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImpl_whenHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new URLHandlerImpl()).hasRegExCharacters("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>When {@code Location}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImpl_whenLocation_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new URLHandlerImpl()).hasRegExCharacters("Location"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    boolean actualHasRegExCharactersResult = urlHandlerImpl.hasRegExCharacters("(");

    // Assert
    verify(redirectType).getType();
    assertTrue(actualHasRegExCharactersResult);
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code ^}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenCircumflexAccent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("^"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenDollarSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("$"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("{"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("("));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("["));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("?"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters(")"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenVerticalLine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("|"));
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<URLHandler> actualCreateOrRetrieveCopyInstanceResult = urlHandlerImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link CreateResponse} {@link CreateResponse#getClone()} return
   * {@link NullURLHandler#NullURLHandler()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenCreateResponseGetCloneReturnNullURLHandler()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new NullURLHandler());
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    urlHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetType() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new NullURLHandler());
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    urlHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(redirectType).getType();
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and
   * {@link URLHandlerImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertEquals(urlHandlerImpl, urlHandlerImpl2);
    int expectedHashCodeResult = urlHandlerImpl.hashCode();
    assertEquals(expectedHashCodeResult, urlHandlerImpl2.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and
   * {@link URLHandlerImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertEquals(urlHandlerImpl, urlHandlerImpl);
    int expectedHashCodeResult = urlHandlerImpl.hashCode();
    assertEquals(expectedHashCodeResult, urlHandlerImpl.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(2L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, urlHandlerImpl2);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, null);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, "Different type to URLHandlerImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link URLHandlerImpl}
   *   <li>{@link URLHandlerImpl#setId(Long)}
   *   <li>{@link URLHandlerImpl#setIncomingURL(String)}
   *   <li>{@link URLHandlerImpl#setNewURL(String)}
   *   <li>{@link URLHandlerImpl#getId()}
   *   <li>{@link URLHandlerImpl#getIncomingURL()}
   *   <li>{@link URLHandlerImpl#getNewURL()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    URLHandlerImpl actualUrlHandlerImpl = new URLHandlerImpl();
    actualUrlHandlerImpl.setId(1L);
    actualUrlHandlerImpl.setIncomingURL("https://example.org/example");
    actualUrlHandlerImpl.setNewURL("https://example.org/example");
    Long actualId = actualUrlHandlerImpl.getId();
    String actualIncomingURL = actualUrlHandlerImpl.getIncomingURL();

    // Assert that nothing has changed
    assertEquals("https://example.org/example", actualIncomingURL);
    assertEquals("https://example.org/example", actualUrlHandlerImpl.getNewURL());
    assertEquals(1L, actualId.longValue());
  }
}
