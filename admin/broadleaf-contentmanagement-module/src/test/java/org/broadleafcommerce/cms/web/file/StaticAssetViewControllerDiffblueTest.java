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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.springframework.core.env.PropertyResolver;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StaticAssetViewControllerDiffblueTest {
  @Mock
  private ApplicationContext applicationContext;

  @Mock
  private BroadleafSiteResolver broadleafSiteResolver;

  @Mock
  private Environment environment;

  @Mock
  private NamedOperationManager namedOperationManager;

  @Mock
  private StaticAssetStorageService staticAssetStorageService;

  @InjectMocks
  private StaticAssetViewController staticAssetViewController;

  /**
   * Test {@link StaticAssetViewController#init()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetViewController.init()"})
  public void testInit_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(false);

    // Act
    staticAssetViewController.init();

    // Assert
    verify(environment).getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetViewController#init()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetViewController.init()"})
  public void testInit_givenEnvironmentGetPropertyReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);

    // Act
    staticAssetViewController.init();

    // Assert
    verify(environment).getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetViewController#init()}.
   * <ul>
   *   <li>Then throw {@link AssetNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetViewController.init()"})
  public void testInit_thenThrowAssetNotFoundException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenThrow(new AssetNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(AssetNotFoundException.class, () -> staticAssetViewController.init());
    verify(environment).getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   * <ul>
   *   <li>Given {@link Environment}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_givenEnvironment_whenHashMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(staticAssetViewController.convertParameterMap(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map StaticAssetViewController.convertParameterMap(Map)"})
  public void testConvertParameterMap_thenReturnSizeIsOne() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    HashMap<String, String[]> parameterMap = new HashMap<>();
    parameterMap.put("foo", new String[]{"foo"});

    // Act
    Map<String, String> actualConvertParameterMapResult = staticAssetViewController.convertParameterMap(parameterMap);

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    verify(environment).getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertEquals(1, actualConvertParameterMapResult.size());
    assertEquals("foo", actualConvertParameterMapResult.get("foo"));
  }

  /**
   * Test {@link StaticAssetViewController#isAllowedUrlParameter(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperationComponent}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#isAllowedUrlParameter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StaticAssetViewController.isAllowedUrlParameter(String)"})
  public void testIsAllowedUrlParameter_givenArrayListAddNamedOperationComponent() {
    // Arrange
    ArrayList<NamedOperationComponent> namedOperationComponentList = new ArrayList<>();
    namedOperationComponentList.add(mock(NamedOperationComponent.class));
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(namedOperationComponentList);

    // Act
    boolean actualIsAllowedUrlParameterResult = staticAssetViewController
        .isAllowedUrlParameter("https://example.org/example");

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    assertFalse(actualIsAllowedUrlParameterResult);
  }

  /**
   * Test {@link StaticAssetViewController#isAllowedUrlParameter(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#isAllowedUrlParameter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StaticAssetViewController.isAllowedUrlParameter(String)"})
  public void testIsAllowedUrlParameter_thenReturnFalse() {
    // Arrange
    when(namedOperationManager.getNamedOperationComponents()).thenReturn(new ArrayList<>());

    // Act
    boolean actualIsAllowedUrlParameterResult = staticAssetViewController
        .isAllowedUrlParameter("https://example.org/example");

    // Assert
    verify(namedOperationManager).getNamedOperationComponents();
    assertFalse(actualIsAllowedUrlParameterResult);
  }

  /**
   * Test {@link StaticAssetViewController#isAllowedUrlParameter(String)}.
   * <ul>
   *   <li>Then throw {@link AssetNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#isAllowedUrlParameter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StaticAssetViewController.isAllowedUrlParameter(String)"})
  public void testIsAllowedUrlParameter_thenThrowAssetNotFoundException() {
    // Arrange
    when(namedOperationManager.getNamedOperationComponents())
        .thenThrow(new AssetNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(AssetNotFoundException.class,
        () -> staticAssetViewController.isAllowedUrlParameter("https://example.org/example"));
    verify(namedOperationManager).getNamedOperationComponents();
  }

  /**
   * Test {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return ViewName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ModelAndView StaticAssetViewController.handleRequestInternal(HttpServletRequest, HttpServletResponse)"})
  public void testHandleRequestInternal_thenReturnViewNameIsNull() throws Exception {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), Mockito.<Class<View>>any())).thenReturn(mock(View.class));
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(staticAssetStorageService.getCacheFileModel(Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleRequestInternalResult = staticAssetViewController.handleRequestInternal(request, response);

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
   * <ul>
   *   <li>Given {@link StaticAssetViewController}.</li>
   *   <li>Then return {@code Request URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetViewController.removeAssetPrefix(String)"})
  public void testRemoveAssetPrefix_givenStaticAssetViewController_thenReturnRequestUri() {
    // Arrange, Act and Assert
    assertEquals("Request URI", staticAssetViewController.removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Then return {@code /quest URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetViewController.removeAssetPrefix(String)"})
  public void testRemoveAssetPrefix_thenReturnQuestUri() {
    // Arrange
    staticAssetViewController.setAssetServerUrlPrefix("foo");

    // Act and Assert
    assertEquals("/quest URI", staticAssetViewController.removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetViewController.removeAssetPrefix(String)"})
  public void testRemoveAssetPrefix_thenReturnSlash() {
    // Arrange
    staticAssetViewController.setAssetServerUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetViewController.removeAssetPrefix("/"));
  }

  /**
   * Test {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StaticAssetViewController.getAllowUnnamedImageManipulation()"})
  public void testGetAllowUnnamedImageManipulation_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(false);

    // Act
    boolean actualAllowUnnamedImageManipulation = staticAssetViewController.getAllowUnnamedImageManipulation();

    // Assert
    verify(environment).getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertFalse(actualAllowUnnamedImageManipulation);
  }

  /**
   * Test {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StaticAssetViewController.getAllowUnnamedImageManipulation()"})
  public void testGetAllowUnnamedImageManipulation_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);

    // Act
    boolean actualAllowUnnamedImageManipulation = staticAssetViewController.getAllowUnnamedImageManipulation();

    // Assert
    verify(environment).getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
    assertTrue(actualAllowUnnamedImageManipulation);
  }

  /**
   * Test {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}.
   * <ul>
   *   <li>Then throw {@link AssetNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StaticAssetViewController.getAllowUnnamedImageManipulation()"})
  public void testGetAllowUnnamedImageManipulation_thenThrowAssetNotFoundException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenThrow(new AssetNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(AssetNotFoundException.class, () -> staticAssetViewController.getAllowUnnamedImageManipulation());
    verify(environment).getProperty(eq("asset.server.allow.unnamed.image.manipulation"), isA(Class.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StaticAssetViewController#setAssetServerUrlPrefix(String)}
   *   <li>{@link StaticAssetViewController#setViewResolverName(String)}
   *   <li>{@link StaticAssetViewController#getAssetServerUrlPrefix()}
   *   <li>{@link StaticAssetViewController#getViewResolverName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetViewController.getAssetServerUrlPrefix()",
      "String StaticAssetViewController.getViewResolverName()",
      "void StaticAssetViewController.setAssetServerUrlPrefix(String)",
      "void StaticAssetViewController.setViewResolverName(String)"})
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();

    // Act
    staticAssetViewController.setAssetServerUrlPrefix("https://example.org/example");
    staticAssetViewController.setViewResolverName("View Resolver Name");
    String actualAssetServerUrlPrefix = staticAssetViewController.getAssetServerUrlPrefix();

    // Assert
    assertEquals("View Resolver Name", staticAssetViewController.getViewResolverName());
    assertEquals("https://example.org/example", actualAssetServerUrlPrefix);
  }

  /**
   * Test new {@link StaticAssetViewController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link StaticAssetViewController}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetViewController.<init>()"})
  public void testNewStaticAssetViewController() {
    // Arrange and Act
    StaticAssetViewController actualStaticAssetViewController = new StaticAssetViewController();

    // Assert
    assertNull(actualStaticAssetViewController.getAssetServerUrlPrefix());
    assertNull(actualStaticAssetViewController.getViewResolverName());
    assertNull(actualStaticAssetViewController.getVaryByRequestHeaders());
    assertNull(actualStaticAssetViewController.staticAssetStorageService);
    assertNull(actualStaticAssetViewController.namedOperationManager);
    assertNull(actualStaticAssetViewController.siteResolver);
    assertNull(actualStaticAssetViewController.appCtx);
    assertNull(actualStaticAssetViewController.env);
    assertNull(actualStaticAssetViewController.getCacheControl());
    assertEquals(-1, actualStaticAssetViewController.getCacheSeconds());
    assertEquals(3, actualStaticAssetViewController.getSupportedMethods().length);
    assertFalse(actualStaticAssetViewController.isSynchronizeOnSession());
    assertFalse(actualStaticAssetViewController.isAlwaysMustRevalidate());
    assertFalse(actualStaticAssetViewController.isRequireSession());
    assertFalse(actualStaticAssetViewController.isUseExpiresHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlNoStore());
  }
}
