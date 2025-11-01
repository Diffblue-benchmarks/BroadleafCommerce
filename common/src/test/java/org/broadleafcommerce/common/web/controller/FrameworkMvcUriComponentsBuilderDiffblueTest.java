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
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromController(UriComponentsBuilder, Class)}
   */
  @Test
  public void testFromController() {
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
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  public void testFromMethodName() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  public void testFromMethodName2() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])}
   */
  @Test
  public void testFromMethodName3() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodName(controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  public void testFromMethodName4() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  public void testFromMethodName5() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  public void testFromMethodName6() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FrameworkMvcUriComponentsBuilder
        .fromMethodName(uriComponentsBuilder, controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#fromMethod(UriComponentsBuilder, Class, Method, Object[])}
   */
  @Test
  public void testFromMethod() {
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
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withController(Class)}
   */
  @Test
  public void testWithController() {
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
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName2() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName3() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "invoke", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}
   */
  @Test
  public void testWithMethodName4() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenReturn(uriComponentsBuilder);
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodName(controllerType, "equals", BLCFieldUtils.NULL_FIELD));
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Method under test:
   * {@link FrameworkMvcUriComponentsBuilder#withMethod(Class, Method, Object[])}
   */
  @Test
  public void testWithMethod() {
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
