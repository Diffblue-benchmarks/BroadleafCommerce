package org.broadleafcommerce.cms.web.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.cms.common.AssetNotFoundException;
import org.broadleafcommerce.cms.file.service.StaticAssetStorageService;
import org.broadleafcommerce.cms.file.service.operation.NamedOperationComponent;
import org.broadleafcommerce.cms.file.service.operation.NamedOperationManager;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.web.BroadleafSiteResolver;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class StaticAssetViewControllerDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @Mock private BroadleafSiteResolver broadleafSiteResolver;

  @Mock private Environment environment;

  @Mock private NamedOperationManager namedOperationManager;

  @Mock private StaticAssetStorageService staticAssetStorageService;

  @InjectMocks private StaticAssetViewController staticAssetViewController;

  /**
   * Test {@link StaticAssetViewController#init()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   *   <li>Then calls {@link Environment#getProperty(String, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticAssetViewController.init()"})
  public void testInit_givenEnvironmentGetPropertyReturnFalse_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(false);

    // Act
    staticAssetViewController.init();

    // Assert
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetViewController#init()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       true}.
   *   <li>Then calls {@link Environment#getProperty(String, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticAssetViewController.init()"})
  public void testInit_givenEnvironmentGetPropertyReturnTrue_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    // Act
    staticAssetViewController.init();

    // Assert
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetViewController#init()}.
   *
   * <ul>
   *   <li>Then throw {@link AssetNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticAssetViewController.init()"})
  public void testInit_thenThrowAssetNotFoundException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class)))
        .thenThrow(new AssetNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(AssetNotFoundException.class, () -> staticAssetViewController.init());
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap() {
    // Arrange
    when(namedOperationManager.getNamedOperationComponents())
        .thenThrow(new AssetNotFoundException("An error occurred"));

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {"foo"});

    // Act and Assert
    assertThrows(
        AssetNotFoundException.class,
        () -> staticAssetViewController.convertParameterMap(parameterMap));
    verify(namedOperationManager).getNamedOperationComponents();
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {"asset.server.allow.unnamed.image.manipulation", "foo"});

    // Act
    Map<String, String> actualConvertParameterMapResult =
        staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertEquals(1, actualConvertParameterMapResult.size());
    assertEquals(
        "asset.server.allow.unnamed.image.manipulation,foo",
        actualConvertParameterMapResult.get("foo"));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class)))
        .thenThrow(new AssetNotFoundException("An error occurred"));
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {"foo"});

    // Act and Assert
    assertThrows(
        AssetNotFoundException.class,
        () -> staticAssetViewController.convertParameterMap(parameterMap));
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperationComponent}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenArrayListAddNamedOperationComponent_thenReturnFoo() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    ArrayList<NamedOperationComponent> namedOperationComponentList = new ArrayList<>();
    namedOperationComponentList.add(mock(NamedOperationComponent.class));
    when(namedOperationManager.getNamedOperationComponents())
        .thenReturn(namedOperationComponentList);

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {"foo"});

    // Act
    Map<String, String> actualConvertParameterMapResult =
        staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertEquals(1, actualConvertParameterMapResult.size());
    assertEquals("foo", actualConvertParameterMapResult.get("foo"));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenArrayOfStringWithEmptyString() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {""});

    // Act
    Map<String, String> actualConvertParameterMapResult =
        staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertEquals(1, actualConvertParameterMapResult.size());
    assertEquals("", actualConvertParameterMapResult.get("foo"));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with empty string and {@code foo}.
   *   <li>Then return {@code ,foo}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenArrayOfStringWithEmptyStringAndFoo_thenReturnFoo() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {"", "foo"});

    // Act
    Map<String, String> actualConvertParameterMapResult =
        staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertEquals(1, actualConvertParameterMapResult.size());
    assertEquals(",foo", actualConvertParameterMapResult.get("foo"));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenArrayOfStringWithFoo_thenReturnFoo() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {"foo"});

    // Act
    Map<String, String> actualConvertParameterMapResult =
        staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertEquals(1, actualConvertParameterMapResult.size());
    assertEquals("foo", actualConvertParameterMapResult.get("foo"));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <ul>
   *   <li>Given empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenEmptyArrayOfString() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {});

    // Act
    Map<String, String> actualConvertParameterMapResult =
        staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertEquals(1, actualConvertParameterMapResult.size());
    assertEquals("", actualConvertParameterMapResult.get("foo"));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenEnvironmentGetPropertyReturnFalse_thenReturnEmpty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(false);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[] {"foo"});

    // Act
    Map<String, String> actualConvertParameterMapResult =
        staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertTrue(actualConvertParameterMapResult.isEmpty());
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   *
   * <ul>
   *   <li>Given {@link StaticAssetViewController} (default constructor).
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenStaticAssetViewController_whenHashMap() {
    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();

    // Act and Assert
    assertTrue(staticAssetViewController.convertParameterMap(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticAssetViewController#isAllowedUrlParameter(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperationComponent}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#isAllowedUrlParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetViewController.isAllowedUrlParameter(String)"})
  public void testIsAllowedUrlParameter_givenArrayListAddNamedOperationComponent() {
    // Arrange
    ArrayList<NamedOperationComponent> namedOperationComponentList = new ArrayList<>();
    namedOperationComponentList.add(mock(NamedOperationComponent.class));
    when(namedOperationManager.getNamedOperationComponents())
        .thenReturn(namedOperationComponentList);

    // Act
    boolean actualIsAllowedUrlParameterResult =
        staticAssetViewController.isAllowedUrlParameter("https://example.org/example");

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    assertFalse(actualIsAllowedUrlParameterResult);
  }

  /**
   * Test {@link StaticAssetViewController#isAllowedUrlParameter(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#isAllowedUrlParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetViewController.isAllowedUrlParameter(String)"})
  public void testIsAllowedUrlParameter_thenReturnFalse() {
    // Arrange
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    // Act
    boolean actualIsAllowedUrlParameterResult =
        staticAssetViewController.isAllowedUrlParameter("https://example.org/example");

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    assertFalse(actualIsAllowedUrlParameterResult);
  }

  /**
   * Test {@link StaticAssetViewController#isAllowedUrlParameter(String)}.
   *
   * <ul>
   *   <li>Then throw {@link AssetNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#isAllowedUrlParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetViewController.isAllowedUrlParameter(String)"})
  public void testIsAllowedUrlParameter_thenThrowAssetNotFoundException() {
    // Arrange
    when(namedOperationManager.getNamedOperationComponents())
        .thenThrow(new AssetNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        AssetNotFoundException.class,
        () -> staticAssetViewController.isAllowedUrlParameter("https://example.org/example"));
    verify(namedOperationManager).getNamedOperationComponents();
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal() throws Exception {
    // Arrange
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetViewController.handleRequestInternal(
                request, new MockHttpServletResponse()));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal2() throws Exception {
    // Arrange
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenThrow(new AssetNotFoundException("An error occurred"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    assertNull(actualHandleRequestInternalResult);
    assertEquals(404, response.getStatus());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal3() throws Exception {
    // Arrange
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenThrow(new FileNotFoundException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    assertNull(actualHandleRequestInternalResult);
    assertEquals(404, response.getStatus());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal4() throws Exception {
    // Arrange
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenThrow(new Exception());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetViewController.handleRequestInternal(
                request, new MockHttpServletResponse()));
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal5() throws Exception {
    // Arrange
    when(namedOperationManager.getNamedOperationComponents())
        .thenThrow(new AssetNotFoundException("An error occurred"));
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    assertNull(actualHandleRequestInternalResult);
    assertEquals(404, response.getStatus());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal6() throws Exception {
    // Arrange
    when(namedOperationManager.getNamedOperationComponents()).thenThrow(new RuntimeException());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetViewController.handleRequestInternal(
                request, new MockHttpServletResponse()));
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal7() throws Exception {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class)))
        .thenThrow(new AssetNotFoundException("An error occurred"));
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult);
    assertEquals(404, response.getStatus());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperationComponent}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_givenArrayListAddNamedOperationComponent()
      throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    ArrayList<NamedOperationComponent> namedOperationComponentList = new ArrayList<>();
    namedOperationComponentList.add(mock(NamedOperationComponent.class));
    when(namedOperationManager.getNamedOperationComponents())
        .thenReturn(namedOperationComponentList);
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_givenArrayOfStringWith42() throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Boolean.TRUE.toString(), "42");
    request.addParameter("Name", "42");
    request.addParameter(Boolean.TRUE.toString(), "ThreadLocalManager.notify.orphans");
    request.addParameter("Name", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(namedOperationManager, atLeast(1)).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    verify(environment, atLeast(1))
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_givenEmptyString() throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_givenEnvironmentGetPropertyReturnFalse() throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(false);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_givenEnvironmentGetPropertyReturnTrue() throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_givenNull() throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", (String) null);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(namedOperationManager).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_givenTrueToString() throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");
    request.addParameter(Boolean.TRUE.toString(), "ThreadLocalManager.notify.orphans");
    request.addParameter("Name", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(namedOperationManager, atLeast(1)).getNamedOperationComponents();
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    verify(environment, atLeast(1))
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link AssetNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_thenThrowAssetNotFoundException() throws Exception {
    // Arrange
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any()))
        .thenThrow(new AssetNotFoundException("An error occurred"));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        AssetNotFoundException.class,
        () ->
            staticAssetViewController.handleRequestInternal(
                request, new MockHttpServletResponse()));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return ViewName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequestInternal_whenMockHttpServletRequest_thenReturnViewNameIsNull()
      throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(View.class)))
        .thenReturn(mock(View.class));
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(
            Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult =
        staticAssetViewController.handleRequestInternal(request, response);

    // Assert
    verify(staticAssetStorageService).getCacheFileModel(eq(""), isA(Map.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(applicationContext).getBean(isNull(), isA(Class.class));
    assertNull(actualHandleRequestInternalResult.getViewName());
    assertNull(actualHandleRequestInternalResult.getStatus());
    assertEquals(200, response.getStatus());
    assertFalse(actualHandleRequestInternalResult.isEmpty());
    assertFalse(actualHandleRequestInternalResult.isReference());
    Map<String, Object> model = actualHandleRequestInternalResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestInternalResult.hasView());
    assertSame(model, actualHandleRequestInternalResult.getModelMap());
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   *
   * <ul>
   *   <li>Given {@link StaticAssetViewController} (default constructor).
   *   <li>Then return {@code Request URI}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetViewController.removeAssetPrefix(String)"})
  public void testRemoveAssetPrefix_givenStaticAssetViewController_thenReturnRequestUri() {
    // Arrange, Act and Assert
    assertEquals("Request URI", new StaticAssetViewController().removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   *
   * <ul>
   *   <li>Then return {@code /quest URI}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetViewController.removeAssetPrefix(String)"})
  public void testRemoveAssetPrefix_thenReturnQuestUri() {
    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setAssetServerUrlPrefix("foo");

    // Act and Assert
    assertEquals("/quest URI", staticAssetViewController.removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   *
   * <ul>
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetViewController.removeAssetPrefix(String)"})
  public void testRemoveAssetPrefix_thenReturnSlash() {
    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setAssetServerUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetViewController.removeAssetPrefix("/"));
  }

  /**
   * Test {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetViewController.getAllowUnnamedImageManipulation()"})
  public void testGetAllowUnnamedImageManipulation_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(false);

    // Act
    boolean actualAllowUnnamedImageManipulation =
        staticAssetViewController.getAllowUnnamedImageManipulation();

    // Assert
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertFalse(actualAllowUnnamedImageManipulation);
  }

  /**
   * Test {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetViewController.getAllowUnnamedImageManipulation()"})
  public void testGetAllowUnnamedImageManipulation_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    // Act
    boolean actualAllowUnnamedImageManipulation =
        staticAssetViewController.getAllowUnnamedImageManipulation();

    // Assert
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertTrue(actualAllowUnnamedImageManipulation);
  }

  /**
   * Test {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}.
   *
   * <ul>
   *   <li>Then throw {@link AssetNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetViewController.getAllowUnnamedImageManipulation()"})
  public void testGetAllowUnnamedImageManipulation_thenThrowAssetNotFoundException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class)))
        .thenThrow(new AssetNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        AssetNotFoundException.class,
        () -> staticAssetViewController.getAllowUnnamedImageManipulation());
    verify(environment)
        .getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetViewController}
   *   <li>{@link StaticAssetViewController#setAssetServerUrlPrefix(String)}
   *   <li>{@link StaticAssetViewController#setViewResolverName(String)}
   *   <li>{@link StaticAssetViewController#getAssetServerUrlPrefix()}
   *   <li>{@link StaticAssetViewController#getViewResolverName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetViewController.<init>()",
    "String StaticAssetViewController.getAssetServerUrlPrefix()",
    "String StaticAssetViewController.getViewResolverName()",
    "void StaticAssetViewController.setAssetServerUrlPrefix(String)",
    "void StaticAssetViewController.setViewResolverName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetViewController actualStaticAssetViewController = new StaticAssetViewController();
    actualStaticAssetViewController.setAssetServerUrlPrefix("https://example.org/example");
    actualStaticAssetViewController.setViewResolverName("View Resolver Name");
    String actualAssetServerUrlPrefix = actualStaticAssetViewController.getAssetServerUrlPrefix();

    // Assert
    assertEquals("View Resolver Name", actualStaticAssetViewController.getViewResolverName());
    assertEquals("https://example.org/example", actualAssetServerUrlPrefix);
    assertNull(actualStaticAssetViewController.getVaryByRequestHeaders());
    assertNull(actualStaticAssetViewController.getCacheControl());
    assertEquals(-1, actualStaticAssetViewController.getCacheSeconds());
    assertFalse(actualStaticAssetViewController.isSynchronizeOnSession());
    assertFalse(actualStaticAssetViewController.isAlwaysMustRevalidate());
    assertFalse(actualStaticAssetViewController.isRequireSession());
    assertFalse(actualStaticAssetViewController.isUseExpiresHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlNoStore());
  }
}
