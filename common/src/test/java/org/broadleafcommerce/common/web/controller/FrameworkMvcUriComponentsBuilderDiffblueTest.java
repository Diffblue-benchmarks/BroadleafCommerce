package org.broadleafcommerce.common.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo;
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
  @Autowired private FrameworkMvcUriComponentsBuilder frameworkMvcUriComponentsBuilder;

  @MockBean private UriComponentsBuilder uriComponentsBuilder;

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromController(UriComponentsBuilder, Class)} with
   * {@code builder}, {@code controllerType}.
   *
   * <ul>
   *   <li>Then clone return {@link UriComponentsBuilder}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FrameworkMvcUriComponentsBuilder#fromController(UriComponentsBuilder, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromController(UriComponentsBuilder, Class)"
  })
  public void testFromControllerWithBuilderControllerType_thenCloneReturnUriComponentsBuilder() {
    // Arrange
    UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
    Class<Object> controllerType = Object.class;

    // Act
    UriComponentsBuilder actualFromControllerResult =
        FrameworkMvcUriComponentsBuilder.fromController(builder, controllerType);

    // Assert
    assertTrue(actualFromControllerResult.clone() instanceof UriComponentsBuilder);
    assertEquals("/", actualFromControllerResult.toUriString());
    UriComponents uriComponents = actualFromControllerResult.build();
    assertNull(uriComponents.getFragment());
    assertNull(uriComponents.getScheme());
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class,
   * String, Object[])} with {@code builder}, {@code controllerType}, {@code methodName}, {@code
   * args}.
   *
   * <p>Method under test: {@link
   * FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(UriComponentsBuilder, Class, String, Object[])"
  })
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FrameworkMvcUriComponentsBuilder.fromMethodName(
                uriComponentsBuilder,
                controllerType,
                "hasGenericInformation",
                BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class,
   * String, Object[])} with {@code builder}, {@code controllerType}, {@code methodName}, {@code
   * args}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(UriComponentsBuilder, Class, String, Object[])"
  })
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FrameworkMvcUriComponentsBuilder.fromMethodName(
                uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class,
   * String, Object[])} with {@code builder}, {@code controllerType}, {@code methodName}, {@code
   * args}.
   *
   * <ul>
   *   <li>When {@code Method Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FrameworkMvcUriComponentsBuilder#fromMethodName(UriComponentsBuilder, Class, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(UriComponentsBuilder, Class, String, Object[])"
  })
  public void testFromMethodNameWithBuilderControllerTypeMethodNameArgs_whenMethodName() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FrameworkMvcUriComponentsBuilder.fromMethodName(
                uriComponentsBuilder, controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])} with
   * {@code controllerType}, {@code methodName}, {@code args}.
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(Class, String, Object[])"
  })
  public void testFromMethodNameWithControllerTypeMethodNameArgs() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FrameworkMvcUriComponentsBuilder.fromMethodName(
                controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])} with
   * {@code controllerType}, {@code methodName}, {@code args}.
   *
   * <ul>
   *   <li>When {@code hasGenericInformation}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(Class, String, Object[])"
  })
  public void testFromMethodNameWithControllerTypeMethodNameArgs_whenHasGenericInformation() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FrameworkMvcUriComponentsBuilder.fromMethodName(
                controllerType, "hasGenericInformation", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String, Object[])} with
   * {@code controllerType}, {@code methodName}, {@code args}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodName(Class, String, Object[])"
  })
  public void testFromMethodNameWithControllerTypeMethodNameArgs_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FrameworkMvcUriComponentsBuilder.fromMethodName(
                controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethodCall(Object)} with {@code info}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethodCall(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethodCall(Object)"
  })
  public void testFromMethodCallWithInfo_thenThrowIllegalArgumentException() {
    // Arrange
    MethodInvocationInfo methodInvocationInfo = mock(MethodInvocationInfo.class);
    org.mockito.Mockito.<Class<?>>when(methodInvocationInfo.getControllerType())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> FrameworkMvcUriComponentsBuilder.fromMethodCall(methodInvocationInfo));
    verify(methodInvocationInfo).getControllerType();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#fromMethod(UriComponentsBuilder, Class, Method,
   * Object[])} with {@code baseUrl}, {@code controllerType}, {@code method}, {@code args}.
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#fromMethod(UriComponentsBuilder,
   * Class, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.fromMethod(UriComponentsBuilder, Class, Method, Object[])"
  })
  public void testFromMethodWithBaseUrlControllerTypeMethodArgs() {
    // Arrange
    UriComponentsBuilder baseUrl = mock(UriComponentsBuilder.class);
    when(baseUrl.cloneBuilder()).thenThrow(new IllegalArgumentException());
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FrameworkMvcUriComponentsBuilder.fromMethod(
                baseUrl, controllerType, null, BLCFieldUtils.NULL_FIELD));
    verify(baseUrl).cloneBuilder();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withController(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then clone return {@link UriComponentsBuilder}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withController(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withController(Class)"})
  public void testWithController_whenJavaLangObject_thenCloneReturnUriComponentsBuilder() {
    // Arrange
    FrameworkMvcUriComponentsBuilder relativeToResult =
        FrameworkMvcUriComponentsBuilder.relativeTo(UriComponentsBuilder.newInstance());
    Class<Object> controllerType = Object.class;

    // Act
    UriComponentsBuilder actualWithControllerResult =
        relativeToResult.withController(controllerType);

    // Assert
    assertTrue(actualWithControllerResult.clone() instanceof UriComponentsBuilder);
    assertEquals("/", actualWithControllerResult.toUriString());
    UriComponents uriComponents = actualWithControllerResult.build();
    assertNull(uriComponents.getFragment());
    assertNull(uriComponents.getScheme());
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"
  })
  public void testWithMethodName() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenThrow(new IllegalArgumentException());
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            frameworkMvcUriComponentsBuilder.withMethodName(
                controllerType, "equals", BLCFieldUtils.NULL_FIELD));
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@link UriComponentsBuilder}.
   *   <li>When {@code hasGenericInformation}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"
  })
  public void testWithMethodName_givenUriComponentsBuilder_whenHasGenericInformation() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            frameworkMvcUriComponentsBuilder.withMethodName(
                controllerType, "hasGenericInformation", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@link UriComponentsBuilder}.
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"
  })
  public void testWithMethodName_givenUriComponentsBuilder_whenJavaLangObject() {
    // Arrange
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            frameworkMvcUriComponentsBuilder.withMethodName(
                controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@link UriComponentsBuilder}.
   *   <li>When {@code Method Name}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"
  })
  public void testWithMethodName_givenUriComponentsBuilder_whenMethodName() {
    // Arrange
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            frameworkMvcUriComponentsBuilder.withMethodName(
                controllerType, "Method Name", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String, Object[])}.
   *
   * <ul>
   *   <li>Then calls {@link UriComponentsBuilder#cloneBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodName(Class, String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodName(Class, String, Object[])"
  })
  public void testWithMethodName_thenCallsCloneBuilder() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenReturn(UriComponentsBuilder.newInstance());
    Class<Method> controllerType = Method.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            frameworkMvcUriComponentsBuilder.withMethodName(
                controllerType, "equals", BLCFieldUtils.NULL_FIELD));
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodCall(Object)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodCall(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodCall(Object)"
  })
  public void testWithMethodCall_givenIllegalArgumentException() {
    // Arrange
    MethodInvocationInfo methodInvocationInfo = mock(MethodInvocationInfo.class);
    org.mockito.Mockito.<Class<?>>when(methodInvocationInfo.getControllerType())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodCall(methodInvocationInfo));
    verify(methodInvocationInfo).getControllerType();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethodCall(Object)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodInvocationInfo#getArgumentValues()}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethodCall(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethodCall(Object)"
  })
  public void testWithMethodCall_thenCallsGetArgumentValues() {
    // Arrange
    when(uriComponentsBuilder.cloneBuilder()).thenThrow(new IllegalArgumentException());

    MethodInvocationInfo methodInvocationInfo = mock(MethodInvocationInfo.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(methodInvocationInfo.getControllerType())
        .thenReturn(forNameResult);
    when(methodInvocationInfo.getArgumentValues())
        .thenReturn(new Object[] {BLCFieldUtils.NULL_FIELD});
    when(methodInvocationInfo.getControllerMethod()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> frameworkMvcUriComponentsBuilder.withMethodCall(methodInvocationInfo));
    verify(methodInvocationInfo).getArgumentValues();
    verify(methodInvocationInfo).getControllerMethod();
    verify(methodInvocationInfo).getControllerType();
    verify(uriComponentsBuilder).cloneBuilder();
  }

  /**
   * Test {@link FrameworkMvcUriComponentsBuilder#withMethod(Class, Method, Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkMvcUriComponentsBuilder#withMethod(Class, Method,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UriComponentsBuilder FrameworkMvcUriComponentsBuilder.withMethod(Class, Method, Object[])"
  })
  public void testWithMethod_thenThrowIllegalArgumentException() {
    // Arrange
    UriComponentsBuilder baseUrl = mock(UriComponentsBuilder.class);
    when(baseUrl.cloneBuilder()).thenThrow(new IllegalArgumentException());
    FrameworkMvcUriComponentsBuilder relativeToResult =
        FrameworkMvcUriComponentsBuilder.relativeTo(baseUrl);
    Class<Object> controllerType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relativeToResult.withMethod(controllerType, null, BLCFieldUtils.NULL_FIELD));
    verify(baseUrl).cloneBuilder();
  }
}
