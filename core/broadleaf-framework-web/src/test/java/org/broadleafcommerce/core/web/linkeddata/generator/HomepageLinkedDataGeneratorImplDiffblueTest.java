/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;

@ExtendWith(MockitoExtension.class)
class HomepageLinkedDataGeneratorImplDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @Mock private Environment environment;

  @InjectMocks private HomepageLinkedDataGeneratorImpl homepageLinkedDataGeneratorImpl;

  @Mock private LinkedDataGeneratorExtensionManager linkedDataGeneratorExtensionManager;

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given '/'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_givenSlash_thenReturnTrue() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setRequestURI("/");

    // Act and Assert
    assertTrue(homepageLinkedDataGeneratorImpl.canHandle(request));
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        homepageLinkedDataGeneratorImpl.canHandle(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); given Environment getProperty(String) return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_givenEnvironmentGetPropertyReturnEmptyString()
      throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        homepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertEquals(2, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Then {@link JSONArray#JSONArray(int)} with capacity is three length is two.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); then JSONArray(int) with capacity is three length is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_thenJSONArrayWithCapacityIsThreeLengthIsTwo()
      throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        homepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertEquals(2, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#addOrganizationData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return length is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * HomepageLinkedDataGeneratorImpl#addOrganizationData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test addOrganizationData(HttpServletRequest); then return length is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addOrganizationData(HttpServletRequest)"
  })
  void testAddOrganizationData_thenReturnLengthIsFive() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddOrganizationDataResult =
        homepageLinkedDataGeneratorImpl.addOrganizationData(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertEquals(5, actualAddOrganizationDataResult.length());
    assertEquals(500, actualAddOrganizationDataResult.getRecursionDepthLimit());
    assertTrue(actualAddOrganizationDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#addOrganizationData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return length is seven.
   * </ul>
   *
   * <p>Method under test: {@link
   * HomepageLinkedDataGeneratorImpl#addOrganizationData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test addOrganizationData(HttpServletRequest); then return length is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addOrganizationData(HttpServletRequest)"
  })
  void testAddOrganizationData_thenReturnLengthIsSeven() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddOrganizationDataResult =
        homepageLinkedDataGeneratorImpl.addOrganizationData(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertEquals(500, actualAddOrganizationDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddOrganizationDataResult.length());
    assertTrue(actualAddOrganizationDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#addContactData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return length is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * HomepageLinkedDataGeneratorImpl#addContactData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test addContactData(HttpServletRequest); then return length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.addContactData(HttpServletRequest)"
  })
  void testAddContactData_thenReturnLengthIsOne() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONArray actualAddContactDataResult =
        homepageLinkedDataGeneratorImpl.addContactData(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(environment).getProperty("site.customerService.number");
    assertEquals(1, actualAddContactDataResult.length());
    assertTrue(actualAddContactDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#addWebSiteData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return length is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * HomepageLinkedDataGeneratorImpl#addWebSiteData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test addWebSiteData(HttpServletRequest); then return length is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addWebSiteData(HttpServletRequest)"
  })
  void testAddWebSiteData_thenReturnLengthIsFive() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddWebSiteDataResult =
        homepageLinkedDataGeneratorImpl.addWebSiteData(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    assertEquals(5, actualAddWebSiteDataResult.length());
    assertEquals(500, actualAddWebSiteDataResult.getRecursionDepthLimit());
    assertTrue(actualAddWebSiteDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getLogoUrl()}.
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getLogoUrl()}
   */
  @Test
  @DisplayName("Test getLogoUrl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getLogoUrl()"})
  void testGetLogoUrl() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualLogoUrl = homepageLinkedDataGeneratorImpl.getLogoUrl();

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("site.logo");
    assertEquals("https://example.org/exampleProperty", actualLogoUrl);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#addSocialMediaData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return length is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * HomepageLinkedDataGeneratorImpl#addSocialMediaData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test addSocialMediaData(HttpServletRequest); then return length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.addSocialMediaData(HttpServletRequest)"
  })
  void testAddSocialMediaData_thenReturnLengthIsOne() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONArray actualAddSocialMediaDataResult =
        homepageLinkedDataGeneratorImpl.addSocialMediaData(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(environment).getProperty("site.social.accounts");
    assertEquals(1, actualAddSocialMediaDataResult.length());
    assertTrue(actualAddSocialMediaDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#addPotentialActions(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return length is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * HomepageLinkedDataGeneratorImpl#addPotentialActions(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test addPotentialActions(HttpServletRequest); then return length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addPotentialActions(HttpServletRequest)"
  })
  void testAddPotentialActions_thenReturnLengthIsThree() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddPotentialActionsResult =
        homepageLinkedDataGeneratorImpl.addPotentialActions(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("site.search");
    assertEquals(3, actualAddPotentialActionsResult.length());
    assertEquals(500, actualAddPotentialActionsResult.getRecursionDepthLimit());
    assertTrue(actualAddPotentialActionsResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#siteHasCustomerServiceNumber()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#siteHasCustomerServiceNumber()}
   */
  @Test
  @DisplayName("Test siteHasCustomerServiceNumber(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasCustomerServiceNumber()"})
  void testSiteHasCustomerServiceNumber_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");

    // Act
    boolean actualSiteHasCustomerServiceNumberResult =
        homepageLinkedDataGeneratorImpl.siteHasCustomerServiceNumber();

    // Assert
    verify(environment).getProperty("site.customerService.number");
    assertFalse(actualSiteHasCustomerServiceNumberResult);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#siteHasCustomerServiceNumber()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#siteHasCustomerServiceNumber()}
   */
  @Test
  @DisplayName("Test siteHasCustomerServiceNumber(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasCustomerServiceNumber()"})
  void testSiteHasCustomerServiceNumber_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    boolean actualSiteHasCustomerServiceNumberResult =
        homepageLinkedDataGeneratorImpl.siteHasCustomerServiceNumber();

    // Assert
    verify(environment).getProperty("site.customerService.number");
    assertTrue(actualSiteHasCustomerServiceNumberResult);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#siteHasSocialLinks()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code
   *       Property}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#siteHasSocialLinks()}
   */
  @Test
  @DisplayName(
      "Test siteHasSocialLinks(); given Environment getProperty(String) return 'Property'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasSocialLinks()"})
  void testSiteHasSocialLinks_givenEnvironmentGetPropertyReturnProperty_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    boolean actualSiteHasSocialLinksResult = homepageLinkedDataGeneratorImpl.siteHasSocialLinks();

    // Assert
    verify(environment).getProperty("site.social.accounts");
    assertTrue(actualSiteHasSocialLinksResult);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#siteHasSocialLinks()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#siteHasSocialLinks()}
   */
  @Test
  @DisplayName("Test siteHasSocialLinks(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasSocialLinks()"})
  void testSiteHasSocialLinks_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");

    // Act
    boolean actualSiteHasSocialLinksResult = homepageLinkedDataGeneratorImpl.siteHasSocialLinks();

    // Assert
    verify(environment).getProperty("site.social.accounts");
    assertFalse(actualSiteHasSocialLinksResult);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getSiteLogo()}.
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getSiteLogo()}
   */
  @Test
  @DisplayName("Test getSiteLogo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteLogo()"})
  void testGetSiteLogo() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteLogo = homepageLinkedDataGeneratorImpl.getSiteLogo();

    // Assert
    verify(environment).getProperty("site.logo");
    assertEquals("Property", actualSiteLogo);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getSiteCustomerServiceNumber()}.
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getSiteCustomerServiceNumber()}
   */
  @Test
  @DisplayName("Test getSiteCustomerServiceNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteCustomerServiceNumber()"})
  void testGetSiteCustomerServiceNumber() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteCustomerServiceNumber =
        homepageLinkedDataGeneratorImpl.getSiteCustomerServiceNumber();

    // Assert
    verify(environment).getProperty("site.customerService.number");
    assertEquals("Property", actualSiteCustomerServiceNumber);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getSiteSocialAccounts()}.
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getSiteSocialAccounts()}
   */
  @Test
  @DisplayName("Test getSiteSocialAccounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteSocialAccounts()"})
  void testGetSiteSocialAccounts() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteSocialAccounts = homepageLinkedDataGeneratorImpl.getSiteSocialAccounts();

    // Assert
    verify(environment).getProperty("site.social.accounts");
    assertEquals("Property", actualSiteSocialAccounts);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getSiteSearchUri()}.
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getSiteSearchUri()}
   */
  @Test
  @DisplayName("Test getSiteSearchUri()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteSearchUri()"})
  void testGetSiteSearchUri() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteSearchUri = homepageLinkedDataGeneratorImpl.getSiteSearchUri();

    // Assert
    verify(environment).getProperty("site.search");
    assertEquals("/Property", actualSiteSearchUri);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getSiteName()}.
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getSiteName()}
   */
  @Test
  @DisplayName("Test getSiteName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteName()"})
  void testGetSiteName() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteName = homepageLinkedDataGeneratorImpl.getSiteName();

    // Assert
    verify(environment).getProperty("site.name");
    assertEquals("Property", actualSiteName);
  }
}
