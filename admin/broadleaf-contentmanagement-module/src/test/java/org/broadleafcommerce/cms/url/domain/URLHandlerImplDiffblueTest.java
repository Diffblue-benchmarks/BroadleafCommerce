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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class URLHandlerImplDiffblueTest {
  @Autowired private URLHandlerImpl uRLHandlerImpl;

  /**
   * Test {@link URLHandlerImpl#getUrlRedirectType()}.
   *
   * <p>Method under test: {@link URLHandlerImpl#getUrlRedirectType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"URLRedirectType URLHandlerImpl.getUrlRedirectType()"})
  public void testGetUrlRedirectType() {
    // Arrange, Act and Assert
    assertNull(uRLHandlerImpl.getUrlRedirectType());
  }

  /**
   * Test {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}.
   *
   * <ul>
   *   <li>When {@link URLRedirectType#FORWARD}.
   *   <li>Then {@link URLHandlerImpl} {@link URLHandlerImpl#urlRedirectType} is {@code FORWARD}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLHandlerImpl.setUrlRedirectType(URLRedirectType)"})
  public void testSetUrlRedirectType_whenForward_thenURLHandlerImplUrlRedirectTypeIsForward() {
    // Arrange and Act
    uRLHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Assert
    assertEquals("FORWARD", uRLHandlerImpl.urlRedirectType);
    assertSame(URLRedirectType.FORWARD, uRLHandlerImpl.getUrlRedirectType());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   *
   * <ul>
   *   <li>Given {@link URLHandlerImpl} RegexHandler is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.isRegexHandler()"})
  public void testIsRegexHandler_givenURLHandlerImplRegexHandlerIsTrue_thenReturnTrue() {
    // Arrange
    uRLHandlerImpl.setRegexHandler(true);
    uRLHandlerImpl.setIncomingURL(".");

    // Act and Assert
    assertTrue(uRLHandlerImpl.isRegexHandler());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   *
   * <ul>
   *   <li>Given {@link URLHandlerImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.isRegexHandler()"})
  public void testIsRegexHandler_givenURLHandlerImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(uRLHandlerImpl.isRegexHandler());
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLHandlerImpl.setRegexHandler(boolean)"})
  public void testSetRegexHandlerWithBoolean() {
    // Arrange and Act
    uRLHandlerImpl.setRegexHandler(true);

    // Assert
    assertTrue(uRLHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then not {@link URLHandlerImpl} {@link URLHandlerImpl#isRegex}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLHandlerImpl.setRegexHandler(Boolean)"})
  public void testSetRegexHandlerWithBoolean_whenNull_thenNotURLHandlerImplIsRegex() {
    // Arrange and Act
    uRLHandlerImpl.setRegexHandler(null);

    // Assert that nothing has changed
    assertFalse(uRLHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link URLHandlerImpl} {@link URLHandlerImpl#isRegex}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLHandlerImpl.setRegexHandler(Boolean)"})
  public void testSetRegexHandlerWithBoolean_whenTrue_thenURLHandlerImplIsRegex() {
    // Arrange and Act
    uRLHandlerImpl.setRegexHandler((Boolean) true);

    // Assert
    assertTrue(uRLHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String URLHandlerImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(uRLHandlerImpl.getMainEntityName());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link URLHandlerImpl} RegexHandler is {@code false}.
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String URLHandlerImpl.getLocation()"})
  public void testGetLocation_givenURLHandlerImplRegexHandlerIsFalse_thenReturnDot() {
    // Arrange
    uRLHandlerImpl.setIncomingURL(".");
    uRLHandlerImpl.setRegexHandler(false);

    // Act and Assert
    assertEquals(".", uRLHandlerImpl.getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link URLHandlerImpl} RegexHandler is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String URLHandlerImpl.getLocation()"})
  public void testGetLocation_givenURLHandlerImplRegexHandlerIsTrue_thenReturnNull() {
    // Arrange
    uRLHandlerImpl.setIncomingURL(".");
    uRLHandlerImpl.setRegexHandler(true);

    // Act and Assert
    assertNull(uRLHandlerImpl.getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link URLHandlerImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String URLHandlerImpl.getLocation()"})
  public void testGetLocation_givenURLHandlerImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(uRLHandlerImpl.getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("*"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenBackslash_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("\\"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ^}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenCircumflexAccent_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("^"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code $}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenDollarSign_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("$"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenLeftCurlyBracket_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("{"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenLeftParenthesis_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("("));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code [}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenLeftSquareBracket_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("["));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Location}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenLocation_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(uRLHandlerImpl.hasRegExCharacters("Location"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code +}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenPlusSign_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("+"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenQuestionMark_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("?"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenRightParenthesis_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters(")"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code |}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_whenVerticalLine_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uRLHandlerImpl.hasRegExCharacters("|"));
  }

  /**
   * Test {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse URLHandlerImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new NullURLHandler(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<URLHandler> actualCreateOrRetrieveCopyInstanceResult =
        uRLHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse URLHandlerImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new NullURLHandler(), false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<URLHandler> actualCreateOrRetrieveCopyInstanceResult =
        uRLHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse URLHandlerImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);
    CreateResponse<Object> createResponse = new CreateResponse<>(urlHandlerImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<URLHandler> actualCreateOrRetrieveCopyInstanceResult =
        urlHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse URLHandlerImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new NullURLHandler(), false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<URLHandler> actualCreateOrRetrieveCopyInstanceResult =
        urlHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and {@link URLHandlerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
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
    assertEquals(urlHandlerImpl.hashCode(), urlHandlerImpl2.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and {@link URLHandlerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URLHandlerImpl.<init>()",
    "Long URLHandlerImpl.getId()",
    "String URLHandlerImpl.getIncomingURL()",
    "String URLHandlerImpl.getNewURL()",
    "void URLHandlerImpl.setId(Long)",
    "void URLHandlerImpl.setIncomingURL(String)",
    "void URLHandlerImpl.setNewURL(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    URLHandlerImpl actualUrlHandlerImpl = new URLHandlerImpl();
    actualUrlHandlerImpl.setId(1L);
    actualUrlHandlerImpl.setIncomingURL("https://example.org/example");
    actualUrlHandlerImpl.setNewURL("https://example.org/example");
    Long actualId = actualUrlHandlerImpl.getId();
    String actualIncomingURL = actualUrlHandlerImpl.getIncomingURL();

    // Assert
    assertEquals("https://example.org/example", actualIncomingURL);
    assertEquals("https://example.org/example", actualUrlHandlerImpl.getNewURL());
    assertEquals(1L, actualId.longValue());
  }
}
