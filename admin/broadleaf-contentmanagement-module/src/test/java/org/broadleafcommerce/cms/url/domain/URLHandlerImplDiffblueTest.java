/*-
 * #%L
 * BroadleafCommerce CMS Module
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
   * Method under test: {@link URLHandlerImpl#getUrlRedirectType()}
   */
  @Test
  public void testGetUrlRedirectType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getUrlRedirectType());
  }

  /**
   * Method under test: {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}
   */
  @Test
  public void testSetUrlRedirectType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    URLRedirectType redirectType = URLRedirectType.FORWARD;

    // Act
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Assert
    assertEquals("FORWARD", urlHandlerImpl.urlRedirectType);
    URLRedirectType expectedUrlRedirectType = redirectType.FORWARD;
    assertSame(expectedUrlRedirectType, urlHandlerImpl.getUrlRedirectType());
  }

  /**
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new URLHandlerImpl()).isRegexHandler());
  }

  /**
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler2() {
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
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler3() {
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
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();

    // Act
    urlHandlerImpl.setRegexHandler((Boolean) true);

    // Assert
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandler2() {
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
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandler3() {
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
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  public void testSetRegexHandler4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();

    // Act
    urlHandlerImpl.setRegexHandler(true);

    // Assert
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  public void testSetRegexHandler5() {
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
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
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
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getLocation());
  }

  /**
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation2() {
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
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setIncomingURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", urlHandlerImpl.getLocation());
  }

  /**
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation4() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new URLHandlerImpl()).hasRegExCharacters("https://example.org/example"));
    assertFalse((new URLHandlerImpl()).hasRegExCharacters("Location"));
  }

  /**
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters2() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters3() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters4() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters5() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters6() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters7() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters8() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters9() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters10() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters11() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters12() {
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
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters13() {
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
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
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
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
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
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(redirectType);

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
