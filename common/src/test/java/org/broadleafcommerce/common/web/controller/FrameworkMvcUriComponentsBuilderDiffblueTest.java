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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
  @MockBean
  private UriComponentsBuilder uriComponentsBuilder;

  @Autowired
  private FrameworkMvcUriComponentsBuilder frameworkMvcUriComponentsBuilder;

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromController(UriComponentsBuilder, Class)} with {@code builder}, {@code controllerType}.
   * <ul>
   *   <li>Then clone return {@link UriComponentsBuilder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromController(UriComponentsBuilder, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromController(UriComponentsBuilder, Class)"})
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
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])} with {@code builder}, {@code controllerType}, {@code methodName}, {@code args}.
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(UriComponentsBuilder, Class, String, Object[])"})
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])} with {@code builder}, {@code controllerType}, {@code methodName}, {@code args}.
   * <ul>
   *   <li>When {@code invoke}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(UriComponentsBuilder, Class, String, Object[])"})
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs_whenInvoke() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])} with {@code builder}, {@code controllerType}, {@code methodName}, {@code args}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(UriComponentsBuilder, Class, String, Object[])"})
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])} with {@code controllerType}, {@code methodName}, {@code args}.
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(Class, String, Object[])"})
  public void testFromMethodNameWithControllerTypeMethodNameArgs() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])} with {@code controllerType}, {@code methodName}, {@code args}.
   * <ul>
   *   <li>When {@code invoke}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(Class, String, Object[])"})
  public void testFromMethodNameWithControllerTypeMethodNameArgs_whenInvoke() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])} with {@code controllerType}, {@code methodName}, {@code args}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(Class, String, Object[])"})
  public void testFromMethodNameWithControllerTypeMethodNameArgs_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethod(UriComponentsBuilder, Class, Method, Object[])} with {@code baseUrl}, {@code controllerType}, {@code method}, {@code args}.
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethod(UriComponentsBuilder, Class, Method, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethod(UriComponentsBuilder, Class, Method, Object[])"})
  public void testFromMethodWithBaseUrlControllerTypeMethodArgs() {
    // Arrange
    UriComponentsBuilder baseUrl = mock(UriComponentsBuilder.class);
    when(baseUrl.cloneBuilder()).thenThrow(new IllegalArgumentException("foo"));
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethod(baseUrl, controllerType, null, BLCFieldUtils.NULL_FIELD));
    verify(baseUrl).cloneBuilder();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withController(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then clone return {@link UriComponentsBuilder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#withController(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withController(Class)"})
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
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"})
  public void testWithMethodName() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenThrow(new IllegalArgumentException("invoke"));
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "equals", BLCFieldUtils.NULL_FIELD));
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>Given {@link UriComponentsBuilder}.</li>
   *   <li>When {@code invoke}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"})
  public void testWithMethodName_givenUriComponentsBuilder_whenInvoke() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>Given {@link UriComponentsBuilder}.</li>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"})
  public void testWithMethodName_givenUriComponentsBuilder_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>Given {@link UriComponentsBuilder}.</li>
   *   <li>When {@code Method Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"})
  public void testWithMethodName_givenUriComponentsBuilder_whenMethodName() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   * <ul>
   *   <li>Then calls {@link UriComponentsBuilder#cloneBuilder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"})
  public void testWithMethodName_thenCallsCloneBuilder() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenReturn(UriComponentsBuilder.newInstance());
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "equals", BLCFieldUtils.NULL_FIELD));
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethod(Class, Method, Object[])}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethod(Class, Method, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethod(Class, Method, Object[])"})
  public void testWithMethod_thenThrowIllegalArgumentException() {
    // Arrange
    UriComponentsBuilder baseUrl = mock(UriComponentsBuilder.class);
    when(baseUrl.cloneBuilder()).thenThrow(new IllegalArgumentException("foo"));
    FrameworkMvcUriComponentsBuilder relativeToResult = FrameworkMvcUriComponentsBuilder.relativeTo(baseUrl);
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> relativeToResult.withMethod(controllerType, null, BLCFieldUtils.NULL_FIELD));
    verify(baseUrl).cloneBuilder();
  }
}
