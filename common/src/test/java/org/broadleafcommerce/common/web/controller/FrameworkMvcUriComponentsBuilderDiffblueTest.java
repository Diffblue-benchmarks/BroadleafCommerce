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
package org.broadleafcommerce.common.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.Method;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@ContextConfiguration(classes = {FrameworkMvcUriComponentsBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrameworkMvcUriComponentsBuilderDiffblueTest {
  @Autowired
  private FrameworkMvcUriComponentsBuilder frameworkMvcUriComponentsBuilder;

  @MockBean
  private UriComponentsBuilder uriComponentsBuilder;

  /**
   * Test MethodArgumentBuilder {@link MethodArgumentBuilder#build()}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder#build()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMethodArgumentBuilderBuild() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Cannot lookup handler method mappings without WebApplicationContext
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getRequestMappingInfoHandlerMapping(FrameworkMvcUriComponentsBuilder.java:569)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMappingName(FrameworkMvcUriComponentsBuilder.java:356)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    FrameworkMvcUriComponentsBuilder.fromMappingName(UriComponentsBuilder.newInstance(), "Name").build();
  }

  /**
   * Test MethodArgumentBuilder
   * {@link MethodArgumentBuilder#buildAndExpand(Object[])}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder#buildAndExpand(Object[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMethodArgumentBuilderBuildAndExpand() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Cannot lookup handler method mappings without WebApplicationContext
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getRequestMappingInfoHandlerMapping(FrameworkMvcUriComponentsBuilder.java:569)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMappingName(FrameworkMvcUriComponentsBuilder.java:356)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    FrameworkMvcUriComponentsBuilder.fromMappingName(UriComponentsBuilder.newInstance(), "Name")
        .buildAndExpand(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test MethodArgumentBuilder
   * {@link MethodArgumentBuilder#MethodArgumentBuilder(Method)}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder#MethodArgumentBuilder(Method)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMethodArgumentBuilderNewMethodArgumentBuilder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder$MethodArgumentBuilder.<init>(FrameworkMvcUriComponentsBuilder.java:827)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    new FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder(null);
  }

  /**
   * Test MethodArgumentBuilder
   * {@link MethodArgumentBuilder#MethodArgumentBuilder(Class, Method)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder#MethodArgumentBuilder(Class, Method)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMethodArgumentBuilderNewMethodArgumentBuilder_whenJavaLangObject() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: 'method' is required
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder$MethodArgumentBuilder.<init>(FrameworkMvcUriComponentsBuilder.java:811)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder$MethodArgumentBuilder.<init>(FrameworkMvcUriComponentsBuilder.java:803)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> controllerType = Object.class;

    // Act
    new FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder(controllerType, null);

  }

  /**
   * Test MethodArgumentBuilder
   * {@link MethodArgumentBuilder#MethodArgumentBuilder(UriComponentsBuilder, Class, Method)}.
   * <ul>
   *   <li>When newInstance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder#MethodArgumentBuilder(UriComponentsBuilder, Class, Method)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMethodArgumentBuilderNewMethodArgumentBuilder_whenNewInstance() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: 'method' is required
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder$MethodArgumentBuilder.<init>(FrameworkMvcUriComponentsBuilder.java:811)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    UriComponentsBuilder baseUrl = UriComponentsBuilder.newInstance();
    Class<Object> controllerType = Object.class;

    // Act
    new FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder(baseUrl, controllerType, null);

  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#FrameworkMvcUriComponentsBuilder(UriComponentsBuilder)}.
   * <ul>
   *   <li>When newInstance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#FrameworkMvcUriComponentsBuilder(UriComponentsBuilder)}
   */
  @Test
  public void testNewFrameworkMvcUriComponentsBuilder_whenNewInstance() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     FrameworkMvcUriComponentsBuilder.baseUrl
    //     UriComponentsBuilder.charset
    //     UriComponentsBuilder.encodeTemplate
    //     UriComponentsBuilder.fragment
    //     UriComponentsBuilder.host
    //     UriComponentsBuilder.pathBuilder
    //     UriComponentsBuilder.port
    //     UriComponentsBuilder.queryParams
    //     UriComponentsBuilder.scheme
    //     UriComponentsBuilder.ssp
    //     UriComponentsBuilder.uriVariables
    //     UriComponentsBuilder.userInfo

    // Arrange and Act
    new FrameworkMvcUriComponentsBuilder(UriComponentsBuilder.newInstance());
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#FrameworkMvcUriComponentsBuilder(UriComponentsBuilder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#FrameworkMvcUriComponentsBuilder(UriComponentsBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewFrameworkMvcUriComponentsBuilder_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: 'baseUrl' is required
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.<init>(FrameworkMvcUriComponentsBuilder.java:150)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    new FrameworkMvcUriComponentsBuilder(null);
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#relativeTo(UriComponentsBuilder)}.
   * <ul>
   *   <li>When newInstance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#relativeTo(UriComponentsBuilder)}
   */
  @Test
  public void testRelativeTo_whenNewInstance() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     FrameworkMvcUriComponentsBuilder.baseUrl
    //     UriComponentsBuilder.charset
    //     UriComponentsBuilder.encodeTemplate
    //     UriComponentsBuilder.fragment
    //     UriComponentsBuilder.host
    //     UriComponentsBuilder.pathBuilder
    //     UriComponentsBuilder.port
    //     UriComponentsBuilder.queryParams
    //     UriComponentsBuilder.scheme
    //     UriComponentsBuilder.ssp
    //     UriComponentsBuilder.uriVariables
    //     UriComponentsBuilder.userInfo

    // Arrange and Act
    FrameworkMvcUriComponentsBuilder.relativeTo(UriComponentsBuilder.newInstance());
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#relativeTo(UriComponentsBuilder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#relativeTo(UriComponentsBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRelativeTo_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: 'baseUrl' is required
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.<init>(FrameworkMvcUriComponentsBuilder.java:150)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.relativeTo(FrameworkMvcUriComponentsBuilder.java:161)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    FrameworkMvcUriComponentsBuilder.relativeTo(null);
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromController(UriComponentsBuilder, Class)}
   * with {@code builder}, {@code controllerType}.
   * <ul>
   *   <li>Then clone return {@link UriComponentsBuilder}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromController(UriComponentsBuilder, Class)}
   */
  @Test
  public void testFromControllerWithBuilderControllerType_thenCloneReturnUriComponentsBuilder() {
    // Arrange
    UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
    Class<Object> controllerType = Object.class;

    // Act
    UriComponentsBuilder actualFromControllerResult = FrameworkMvcUriComponentsBuilder.fromController(builder,
        controllerType);

    // Assert
    assertTrue(actualFromControllerResult.clone() instanceof UriComponentsBuilder);
    assertEquals("/", actualFromControllerResult.toUriString());
    UriComponents buildResult = actualFromControllerResult.build();
    assertNull(buildResult.getFragment());
    assertNull(buildResult.getScheme());
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromController(Class)} with
   * {@code controllerType}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromController(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFromControllerWithControllerType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: No current ServletRequestAttributes
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getBaseUrlToUse(FrameworkMvcUriComponentsBuilder.java:438)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromController(FrameworkMvcUriComponentsBuilder.java:189)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromController(FrameworkMvcUriComponentsBuilder.java:173)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> controllerType = Object.class;

    // Act
    FrameworkMvcUriComponentsBuilder.fromController(controllerType);
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   * with {@code builder}, {@code controllerType}, {@code methodName},
   * {@code args}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   * with {@code builder}, {@code controllerType}, {@code methodName},
   * {@code args}.
   * <ul>
   *   <li>Then calls {@link UriComponentsBuilder#cloneBuilder()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs_thenCallsCloneBuilder() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenReturn(uriComponentsBuilder);
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "equals", BLCFieldUtils.NULL_FIELD));
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   * with {@code builder}, {@code controllerType}, {@code methodName},
   * {@code args}.
   * <ul>
   *   <li>When {@code invoke}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs_whenInvoke() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   * with {@code builder}, {@code controllerType}, {@code methodName},
   * {@code args}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   * with {@code controllerType}, {@code methodName}, {@code args}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  public void testFromMethodNameWithControllerTypeMethodNameArgs() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   * with {@code controllerType}, {@code methodName}, {@code args}.
   * <ul>
   *   <li>When {@code invoke}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  public void testFromMethodNameWithControllerTypeMethodNameArgs_whenInvoke() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   * with {@code controllerType}, {@code methodName}, {@code args}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  public void testFromMethodNameWithControllerTypeMethodNameArgs_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodCall(UriComponentsBuilder, Object)}
   * with {@code builder}, {@code info}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodCall(UriComponentsBuilder, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFromMethodCallWithBuilderInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: MethodInvocationInfo required: java.lang.Object
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodCall(FrameworkMvcUriComponentsBuilder.java:289)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    FrameworkMvcUriComponentsBuilder.fromMethodCall(uriComponentsBuilder, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodCall(Object)} with
   * {@code info}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodCall(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFromMethodCallWithInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: MethodInvocationInfo required: java.lang.Object
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodCall(FrameworkMvcUriComponentsBuilder.java:269)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    FrameworkMvcUriComponentsBuilder.fromMethodCall(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethod(UriComponentsBuilder, Class, Method, Object[])}
   * with {@code baseUrl}, {@code controllerType}, {@code method}, {@code args}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethod(UriComponentsBuilder, Class, Method, Object[])}
   */
  @Test
  public void testFromMethodWithBaseUrlControllerTypeMethodArgs() {
    // Arrange
    UriComponentsBuilder baseUrl = mock(UriComponentsBuilder.class);
    when(baseUrl.cloneBuilder()).thenThrow(new IllegalArgumentException("'controllerType' must not be null"));
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethod(baseUrl, controllerType, null, BLCFieldUtils.NULL_FIELD));
    verify(baseUrl).cloneBuilder();
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#fromMethod(Class, Method, Object[])}
   * with {@code controllerType}, {@code method}, {@code args}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethod(Class, Method, Object[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFromMethodWithControllerTypeMethodArgs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: No current ServletRequestAttributes
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getBaseUrlToUse(FrameworkMvcUriComponentsBuilder.java:438)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(FrameworkMvcUriComponentsBuilder.java:424)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethod(FrameworkMvcUriComponentsBuilder.java:386)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> controllerType = Object.class;

    // Act
    FrameworkMvcUriComponentsBuilder.fromMethod(controllerType, null, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethod(Method, Object[])}
   * with {@code method}, {@code args}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethod(Method, Object[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFromMethodWithMethodArgs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethod(FrameworkMvcUriComponentsBuilder.java:418)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    FrameworkMvcUriComponentsBuilder.fromMethod(null, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#on(Class)}.
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#on(Class)}
   */
  @Test
  public void testOn() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertTrue(FrameworkMvcUriComponentsBuilder.on(
        controllerType) instanceof FrameworkMvcUriComponentsBuilder$MethodInvocationInfo$$EnhancerBySpringCGLIB$$e0a0a821);
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#controller(Class)}.
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#controller(Class)}
   */
  @Test
  public void testController() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertTrue(FrameworkMvcUriComponentsBuilder.controller(
        controllerType) instanceof FrameworkMvcUriComponentsBuilder$MethodInvocationInfo$$EnhancerBySpringCGLIB$$e0a0a821);
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withController(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then clone return {@link UriComponentsBuilder}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withController(Class)}
   */
  @Test
  public void testWithController_whenJavaLangObject_thenCloneReturnUriComponentsBuilder() {
    // Arrange
    FrameworkMvcUriComponentsBuilder relativeToResult = FrameworkMvcUriComponentsBuilder
        .relativeTo(UriComponentsBuilder.newInstance());
    Class<Object> controllerType = Object.class;

    // Act
    UriComponentsBuilder actualWithControllerResult = relativeToResult.withController(controllerType);

    // Assert
    assertTrue(actualWithControllerResult.clone() instanceof UriComponentsBuilder);
    assertEquals("/", actualWithControllerResult.toUriString());
    UriComponents buildResult = actualWithControllerResult.build();
    assertNull(buildResult.getFragment());
    assertNull(buildResult.getScheme());
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>Then calls {@link UriComponentsBuilder#cloneBuilder()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName_thenCallsCloneBuilder() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenReturn(uriComponentsBuilder);
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "equals", BLCFieldUtils.NULL_FIELD));
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>When {@code invoke}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName_whenInvoke_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>When {@code java.lang.reflect.Method}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName_whenJavaLangReflectMethod_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodCall(Object)}.
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodCall(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testWithMethodCall() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: MethodInvocationInfo required: java.lang.Object
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodCall(FrameworkMvcUriComponentsBuilder.java:289)
    //       at org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.withMethodCall(FrameworkMvcUriComponentsBuilder.java:706)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    frameworkMvcUriComponentsBuilder.withMethodCall(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link FrameworkMvcUriComponentsBuilder#withMethod(Class, Method, Object[])}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethod(Class, Method, Object[])}
   */
  @Test
  public void testWithMethod_thenThrowIllegalArgumentException() {
    // Arrange
    UriComponentsBuilder baseUrl = mock(UriComponentsBuilder.class);
    when(baseUrl.cloneBuilder()).thenThrow(new IllegalArgumentException("'controllerType' must not be null"));
    FrameworkMvcUriComponentsBuilder relativeToResult = FrameworkMvcUriComponentsBuilder.relativeTo(baseUrl);
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> relativeToResult.withMethod(controllerType, null, BLCFieldUtils.NULL_FIELD));
    verify(baseUrl).cloneBuilder();
  }
}
