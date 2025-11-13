package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;

@RunWith(MockitoJUnitRunner.class)
public class HomepageLinkedDataGeneratorImplDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  public void testCanHandle_givenSlash_thenReturnTrue() {
    // Arrange
    HomepageLinkedDataGeneratorImpl homepageLinkedDataGeneratorImpl =
        new HomepageLinkedDataGeneratorImpl();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setRequestURI("/");

    // Act
    boolean actualCanHandleResult = homepageLinkedDataGeneratorImpl.canHandle(request);

    // Assert
    assertTrue(actualCanHandleResult);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  public void testCanHandle_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    HomepageLinkedDataGeneratorImpl homepageLinkedDataGeneratorImpl =
        new HomepageLinkedDataGeneratorImpl();

    // Act and Assert
    assertFalse(homepageLinkedDataGeneratorImpl.canHandle(new MockHttpServletRequest()));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  public void testGetLinkedDataJsonInternal_givenEnvironmentGetPropertyReturnEmptyString()
      throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    MockHttpServletRequest request = new MockHttpServletRequest();

    JSONArray schemaObjects = mock(JSONArray.class);
    when(schemaObjects.put(Mockito.<Object>any())).thenReturn(new JSONArray());

    // Act
    JSONArray actualLinkedDataJsonInternal =
        homepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(schemaObjects, atLeast(1)).put(Mockito.<Object>any());
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link JSONArray#JSONArray()}.
   *   <li>Then return {@link JSONArray}.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  public void testGetLinkedDataJsonInternal_givenJSONArray_thenReturnJSONArray()
      throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    MockHttpServletRequest request = new MockHttpServletRequest();

    JSONArray schemaObjects = mock(JSONArray.class);
    when(schemaObjects.put(Mockito.<Object>any())).thenReturn(new JSONArray());

    // Act
    JSONArray actualLinkedDataJsonInternal =
        homepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(schemaObjects, atLeast(1)).put(Mockito.<Object>any());
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>When {@link JSONArray#JSONArray()}.
   *   <li>Then {@link JSONArray#JSONArray()} length is two.
   * </ul>
   *
   * <p>Method under test: {@link HomepageLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  public void testGetLinkedDataJsonInternal_whenJSONArray_thenJSONArrayLengthIsTwo()
      throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    MockHttpServletRequest request = new MockHttpServletRequest();
    JSONArray schemaObjects = new JSONArray();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addOrganizationData(HttpServletRequest)"
  })
  public void testAddOrganizationData_thenReturnLengthIsFive() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddOrganizationDataResult =
        homepageLinkedDataGeneratorImpl.addOrganizationData(new MockHttpServletRequest());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addOrganizationData(HttpServletRequest)"
  })
  public void testAddOrganizationData_thenReturnLengthIsSeven() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddOrganizationDataResult =
        homepageLinkedDataGeneratorImpl.addOrganizationData(new MockHttpServletRequest());

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
   * Test {@link HomepageLinkedDataGeneratorImpl#addOrganizationData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link JSONException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * HomepageLinkedDataGeneratorImpl#addOrganizationData(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addOrganizationData(HttpServletRequest)"
  })
  public void testAddOrganizationData_thenThrowJSONException() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");

    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler =
        mock(DefaultLinkedDataGeneratorExtensionHandler.class);
    when(defaultLinkedDataGeneratorExtensionHandler.addOrganizationData(
            Mockito.<HttpServletRequest>any(), Mockito.<JSONObject>any()))
        .thenThrow(new JSONException("An error occurred"));
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(defaultLinkedDataGeneratorExtensionHandler);

    // Act and Assert
    assertThrows(
        JSONException.class,
        () -> homepageLinkedDataGeneratorImpl.addOrganizationData(new MockHttpServletRequest()));
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(baseUrlResolver, atLeast(1)).getSiteBaseUrl();
    verify(defaultLinkedDataGeneratorExtensionHandler)
        .addOrganizationData(isA(HttpServletRequest.class), isA(JSONObject.class));
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.addContactData(HttpServletRequest)"
  })
  public void testAddContactData_thenReturnLengthIsOne() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONArray actualAddContactDataResult =
        homepageLinkedDataGeneratorImpl.addContactData(new MockHttpServletRequest());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addWebSiteData(HttpServletRequest)"
  })
  public void testAddWebSiteData_thenReturnLengthIsFive() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddWebSiteDataResult =
        homepageLinkedDataGeneratorImpl.addWebSiteData(new MockHttpServletRequest());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getLogoUrl()"})
  public void testGetLogoUrl() throws JSONException {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray HomepageLinkedDataGeneratorImpl.addSocialMediaData(HttpServletRequest)"
  })
  public void testAddSocialMediaData_thenReturnLengthIsOne() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONArray actualAddSocialMediaDataResult =
        homepageLinkedDataGeneratorImpl.addSocialMediaData(new MockHttpServletRequest());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject HomepageLinkedDataGeneratorImpl.addPotentialActions(HttpServletRequest)"
  })
  public void testAddPotentialActions_thenReturnLengthIsThree() throws JSONException {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    // Act
    JSONObject actualAddPotentialActionsResult =
        homepageLinkedDataGeneratorImpl.addPotentialActions(new MockHttpServletRequest());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasCustomerServiceNumber()"})
  public void testSiteHasCustomerServiceNumber_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasCustomerServiceNumber()"})
  public void testSiteHasCustomerServiceNumber_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasSocialLinks()"})
  public void testSiteHasSocialLinks_givenEnvironmentGetPropertyReturnProperty_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HomepageLinkedDataGeneratorImpl.siteHasSocialLinks()"})
  public void testSiteHasSocialLinks_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteLogo()"})
  public void testGetSiteLogo() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteCustomerServiceNumber()"})
  public void testGetSiteCustomerServiceNumber() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteSocialAccounts()"})
  public void testGetSiteSocialAccounts() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteSearchUri()"})
  public void testGetSiteSearchUri() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String HomepageLinkedDataGeneratorImpl.getSiteName()"})
  public void testGetSiteName() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteName = homepageLinkedDataGeneratorImpl.getSiteName();

    // Assert
    verify(environment).getProperty("site.name");
    assertEquals("Property", actualSiteName);
  }
}
