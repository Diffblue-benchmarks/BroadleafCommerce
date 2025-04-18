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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class URLHandlerImplDiffblueTest {
  @Autowired
  private URLHandlerImpl uRLHandlerImpl;

  /**
   * Test {@link URLHandlerImpl#getUrlRedirectType()}.
   * <p>
   * Method under test: {@link URLHandlerImpl#getUrlRedirectType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLRedirectType URLHandlerImpl.getUrlRedirectType()"})
  public void testGetUrlRedirectType() {
    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getUrlRedirectType());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.isRegexHandler()"})
  public void testIsRegexHandler_givenURLHandlerImplIdIsOne_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.isRegexHandler()"})
  public void testIsRegexHandler_givenURLHandlerImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new URLHandlerImpl()).isRegexHandler());
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void URLHandlerImpl.setRegexHandler(boolean)"})
  public void testSetRegexHandlerWithBoolean() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then {@link URLHandlerImpl} (default constructor) {@link URLHandlerImpl#isRegex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void URLHandlerImpl.setRegexHandler(Boolean)"})
  public void testSetRegexHandlerWithBoolean_givenURLHandlerImpl_thenURLHandlerImplIsRegex() {
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
   *   <li>Then not {@link URLHandlerImpl} (default constructor) {@link URLHandlerImpl#isRegex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void URLHandlerImpl.setRegexHandler(Boolean)"})
  public void testSetRegexHandlerWithBoolean_thenNotURLHandlerImplIsRegex() {
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
   * Test {@link URLHandlerImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getMainEntityName());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerImpl.getLocation()"})
  public void testGetLocation_givenURLHandlerImplIdIsOne_thenReturnHttpsExampleOrgExample() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) IncomingURL is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerImpl.getLocation()"})
  public void testGetLocation_givenURLHandlerImplIncomingURLIsHttpsExampleOrgExample() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setIncomingURL("https://example.org/example");

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerImpl.getLocation()"})
  public void testGetLocation_givenURLHandlerImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code *}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenAsterisk_thenReturnTrue() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code \}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenBackslash_thenReturnTrue() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code ^}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenCircumflexAccent() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code $}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenDollarSign_thenReturnTrue() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenLeftCurlyBracket() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenLeftParenthesis() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenLeftSquareBracket() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code +}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenPlusSign_thenReturnTrue() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenQuestionMark() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenRightParenthesis() {
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
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>When {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImplIdIsOne_whenVerticalLine() {
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
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImpl_whenHttpsExampleOrgExample() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean URLHandlerImpl.hasRegExCharacters(String)"})
  public void testHasRegExCharacters_givenURLHandlerImpl_whenLocation_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new URLHandlerImpl()).hasRegExCharacters("Location"));
  }

  /**
   * Test {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse URLHandlerImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
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
   * Test {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse URLHandlerImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
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
   * Test {@link URLHandlerImpl#equals(Object)}, and {@link URLHandlerImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
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
    int expectedHashCodeResult = urlHandlerImpl.hashCode();
    assertEquals(expectedHashCodeResult, urlHandlerImpl2.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and {@link URLHandlerImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void URLHandlerImpl.<init>()", "Long URLHandlerImpl.getId()",
      "String URLHandlerImpl.getIncomingURL()", "String URLHandlerImpl.getNewURL()", "void URLHandlerImpl.setId(Long)",
      "void URLHandlerImpl.setIncomingURL(String)", "void URLHandlerImpl.setNewURL(String)"})
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
