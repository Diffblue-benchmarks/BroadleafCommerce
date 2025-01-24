package org.broadleafcommerce.profile.core.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

public class BaseResponseDiffblueTest {
  /**
   * Test {@link BaseResponse#BaseResponse(Object, String)}.
   * <ul>
   *   <li>Then first element ReadMethod GenericExceptionTypes return
   * {@code Class[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResponse#BaseResponse(Object, String)}
   */
  @Test
  public void testNewBaseResponse_thenFirstElementReadMethodGenericExceptionTypesReturnClass() {
    // Arrange and Act
    BaseResponse actualBaseResponse = new BaseResponse("Target", "Object Name");

    // Assert
    Errors errors = actualBaseResponse.getErrors();
    PropertyEditorRegistry propertyEditorRegistry = ((BindException) errors).getPropertyEditorRegistry();
    PropertyDescriptor[] propertyDescriptors = ((BeanWrapperImpl) propertyEditorRegistry).getPropertyDescriptors();
    PropertyDescriptor propertyDescriptor = propertyDescriptors[0];
    Method readMethod = propertyDescriptor.getReadMethod();
    Type[] genericExceptionTypes = readMethod.getGenericExceptionTypes();
    assertTrue(genericExceptionTypes instanceof Class<Object>[]);
    PropertyDescriptor propertyDescriptor2 = propertyDescriptors[1];
    Method readMethod2 = propertyDescriptor2.getReadMethod();
    Type[] genericExceptionTypes2 = readMethod2.getGenericExceptionTypes();
    assertTrue(genericExceptionTypes2 instanceof Class<Object>[]);
    PropertyDescriptor propertyDescriptor3 = propertyDescriptors[2];
    Method readMethod3 = propertyDescriptor3.getReadMethod();
    Type[] genericExceptionTypes3 = readMethod3.getGenericExceptionTypes();
    assertTrue(genericExceptionTypes3 instanceof Class<Object>[]);
    PropertyDescriptor propertyDescriptor4 = propertyDescriptors[3];
    Method readMethod4 = propertyDescriptor4.getReadMethod();
    Type[] genericExceptionTypes4 = readMethod4.getGenericExceptionTypes();
    assertTrue(genericExceptionTypes4 instanceof Class<Object>[]);
    Type[] genericParameterTypes = readMethod.getGenericParameterTypes();
    assertTrue(genericParameterTypes instanceof Class<Object>[]);
    Type[] genericParameterTypes2 = readMethod2.getGenericParameterTypes();
    assertTrue(genericParameterTypes2 instanceof Class<Object>[]);
    Type[] genericParameterTypes3 = readMethod4.getGenericParameterTypes();
    assertTrue(genericParameterTypes3 instanceof Class<Object>[]);
    assertTrue(propertyEditorRegistry instanceof BeanWrapperImpl);
    BindingResult bindingResult = ((BindException) errors).getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertTrue(errors instanceof BindException);
    assertEquals("", ((BeanWrapperImpl) propertyEditorRegistry).getNestedPath());
    assertEquals("", errors.getNestedPath());
    assertEquals("Object Name", errors.getObjectName());
    Map<String, Object> model = ((BindException) errors).getModel();
    assertEquals(2, model.size());
    assertEquals("Target", model.get("Object Name"));
    assertEquals("Target", ((BeanWrapperImpl) propertyEditorRegistry).getRootInstance());
    assertEquals("Target", ((BeanWrapperImpl) propertyEditorRegistry).getWrappedInstance());
    assertEquals("Target", ((BindException) errors).getTarget());
    Class<?> propertyType = propertyDescriptor2.getPropertyType();
    assertEquals("[B", propertyType.getName());
    assertEquals("blank", propertyDescriptor.getDisplayName());
    assertEquals("blank", propertyDescriptor.getName());
    assertEquals("blank", propertyDescriptor.getShortDescription());
    Class<?> propertyType2 = propertyDescriptor.getPropertyType();
    assertEquals("boolean", propertyType2.getName());
    assertEquals("bytes", propertyDescriptor2.getDisplayName());
    assertEquals("bytes", propertyDescriptor2.getName());
    assertEquals("bytes", propertyDescriptor2.getShortDescription());
    assertEquals("class", propertyDescriptor3.getDisplayName());
    assertEquals("class", propertyDescriptor3.getName());
    assertEquals("class", propertyDescriptor3.getShortDescription());
    assertEquals("empty", propertyDescriptor4.getDisplayName());
    assertEquals("empty", propertyDescriptor4.getName());
    assertEquals("empty", propertyDescriptor4.getShortDescription());
    assertEquals("getBytes", readMethod2.getName());
    assertEquals("getClass", readMethod3.getName());
    assertEquals("isBlank", readMethod.getName());
    assertEquals("isEmpty", readMethod4.getName());
    assertEquals("java.lang.Class<?>", readMethod3.getGenericReturnType().getTypeName());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        ((BindException) errors).getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        ((BindException) errors).getMessage());
    assertNull(propertyDescriptor.getPropertyEditorClass());
    assertNull(propertyDescriptor2.getPropertyEditorClass());
    assertNull(propertyDescriptor3.getPropertyEditorClass());
    assertNull(propertyDescriptor4.getPropertyEditorClass());
    assertNull(readMethod.getDefaultValue());
    assertNull(readMethod2.getDefaultValue());
    assertNull(readMethod3.getDefaultValue());
    assertNull(readMethod4.getDefaultValue());
    assertNull(((BindException) errors).getCause());
    assertNull(propertyDescriptor.getWriteMethod());
    assertNull(propertyDescriptor2.getWriteMethod());
    assertNull(propertyDescriptor3.getWriteMethod());
    assertNull(propertyDescriptor4.getWriteMethod());
    assertNull(((BeanWrapperImpl) propertyEditorRegistry).getSecurityContext());
    assertNull(((BeanWrapperImpl) propertyEditorRegistry).getConversionService());
    assertNull(errors.getFieldError());
    assertNull(errors.getGlobalError());
    assertEquals(0, readMethod.getParameterCount());
    assertEquals(0, readMethod2.getParameterCount());
    assertEquals(0, readMethod3.getParameterCount());
    assertEquals(0, readMethod4.getParameterCount());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getFieldErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, ((BindException) errors).getSuppressed().length);
    Annotation[] annotations = readMethod.getAnnotations();
    assertEquals(0, annotations.length);
    assertEquals(0, readMethod.getAnnotatedExceptionTypes().length);
    assertEquals(0, readMethod2.getAnnotatedExceptionTypes().length);
    assertEquals(0, readMethod3.getAnnotatedExceptionTypes().length);
    assertEquals(0, readMethod4.getAnnotatedExceptionTypes().length);
    assertEquals(0, readMethod.getAnnotatedParameterTypes().length);
    assertEquals(0, readMethod2.getAnnotatedParameterTypes().length);
    assertEquals(0, readMethod3.getAnnotatedParameterTypes().length);
    assertEquals(0, readMethod4.getAnnotatedParameterTypes().length);
    assertEquals(0, readMethod.getParameters().length);
    assertEquals(0, readMethod2.getParameters().length);
    assertEquals(0, readMethod3.getParameters().length);
    assertEquals(0, readMethod4.getParameters().length);
    assertEquals(0, readMethod.getExceptionTypes().length);
    assertEquals(0, readMethod2.getExceptionTypes().length);
    assertEquals(0, readMethod3.getExceptionTypes().length);
    assertEquals(0, readMethod4.getExceptionTypes().length);
    assertEquals(0, readMethod3.getGenericParameterTypes().length);
    assertEquals(0, readMethod.getParameterAnnotations().length);
    assertEquals(0, readMethod2.getParameterAnnotations().length);
    assertEquals(0, readMethod3.getParameterAnnotations().length);
    assertEquals(0, readMethod4.getParameterAnnotations().length);
    assertEquals(0, readMethod.getParameterTypes().length);
    assertEquals(0, readMethod2.getParameterTypes().length);
    assertEquals(0, readMethod3.getParameterTypes().length);
    assertEquals(0, readMethod4.getParameterTypes().length);
    assertEquals(0, readMethod.getTypeParameters().length);
    assertEquals(0, readMethod2.getTypeParameters().length);
    assertEquals(0, readMethod3.getTypeParameters().length);
    assertEquals(0, readMethod4.getTypeParameters().length);
    assertEquals(0, ((BindException) errors).getSuppressedFields().length);
    assertEquals(0, genericExceptionTypes.length);
    assertEquals(0, genericExceptionTypes2.length);
    assertEquals(0, genericExceptionTypes3.length);
    assertEquals(0, genericExceptionTypes4.length);
    assertEquals(0, genericParameterTypes.length);
    assertEquals(0, genericParameterTypes2.length);
    assertEquals(0, genericParameterTypes3.length);
    assertEquals(1, readMethod.getModifiers());
    assertEquals(1, readMethod2.getModifiers());
    assertEquals(1, readMethod4.getModifiers());
    Annotation[] annotations2 = readMethod3.getAnnotations();
    assertEquals(1, annotations2.length);
    Annotation[] declaredAnnotations = readMethod3.getDeclaredAnnotations();
    assertEquals(1, declaredAnnotations.length);
    assertEquals(273, readMethod3.getModifiers());
    assertEquals(4, propertyDescriptors.length);
    assertFalse(propertyDescriptor.isExpert());
    assertFalse(propertyDescriptor2.isExpert());
    assertFalse(propertyDescriptor3.isExpert());
    assertFalse(propertyDescriptor4.isExpert());
    assertFalse(propertyDescriptor.isHidden());
    assertFalse(propertyDescriptor2.isHidden());
    assertFalse(propertyDescriptor3.isHidden());
    assertFalse(propertyDescriptor4.isHidden());
    assertFalse(propertyDescriptor.isPreferred());
    assertFalse(propertyDescriptor2.isPreferred());
    assertFalse(propertyDescriptor3.isPreferred());
    assertFalse(propertyDescriptor4.isPreferred());
    assertFalse(propertyDescriptor.isBound());
    assertFalse(propertyDescriptor2.isBound());
    assertFalse(propertyDescriptor3.isBound());
    assertFalse(propertyDescriptor4.isBound());
    assertFalse(propertyDescriptor.isConstrained());
    assertFalse(propertyDescriptor2.isConstrained());
    assertFalse(propertyDescriptor3.isConstrained());
    assertFalse(propertyDescriptor4.isConstrained());
    assertFalse(readMethod.isAccessible());
    assertFalse(readMethod2.isAccessible());
    assertFalse(readMethod3.isAccessible());
    assertFalse(readMethod4.isAccessible());
    assertFalse(readMethod.isBridge());
    assertFalse(readMethod2.isBridge());
    assertFalse(readMethod3.isBridge());
    assertFalse(readMethod4.isBridge());
    assertFalse(readMethod.isDefault());
    assertFalse(readMethod2.isDefault());
    assertFalse(readMethod3.isDefault());
    assertFalse(readMethod4.isDefault());
    assertFalse(readMethod.isSynthetic());
    assertFalse(readMethod2.isSynthetic());
    assertFalse(readMethod3.isSynthetic());
    assertFalse(readMethod4.isSynthetic());
    assertFalse(readMethod.isVarArgs());
    assertFalse(readMethod2.isVarArgs());
    assertFalse(readMethod3.isVarArgs());
    assertFalse(readMethod4.isVarArgs());
    assertFalse(actualBaseResponse.hasErrors());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasFieldErrors());
    assertFalse(errors.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getFieldErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(((BeanWrapperImpl) propertyEditorRegistry).isAutoGrowNestedPaths());
    assertTrue(((BeanWrapperImpl) propertyEditorRegistry).isExtractOldValueForEditor());
    Class<Class> expectedPropertyType = Class.class;
    Class<?> propertyType3 = propertyDescriptor3.getPropertyType();
    assertEquals(expectedPropertyType, propertyType3);
    Class<Object> expectedDeclaringClass = Object.class;
    assertEquals(expectedDeclaringClass, readMethod3.getDeclaringClass());
    Class<String> expectedRootClass = String.class;
    Class<?> rootClass = ((BeanWrapperImpl) propertyEditorRegistry).getRootClass();
    assertEquals(expectedRootClass, rootClass);
    assertEquals(Integer.MAX_VALUE, ((BeanWrapperImpl) propertyEditorRegistry).getAutoGrowCollectionLimit());
    assertEquals(errors, bindingResult);
    assertSame(propertyType2, propertyDescriptor4.getPropertyType());
    assertSame(propertyType2, readMethod.getGenericReturnType());
    assertSame(propertyType2, readMethod4.getGenericReturnType());
    assertSame(propertyType2, readMethod.getReturnType());
    assertSame(propertyType2, readMethod4.getReturnType());
    assertSame(propertyType, readMethod2.getGenericReturnType());
    assertSame(propertyType, readMethod2.getReturnType());
    assertSame(propertyType3, readMethod3.getReturnType());
    assertSame(annotations, readMethod2.getAnnotations());
    assertSame(annotations, readMethod4.getAnnotations());
    assertSame(annotations, readMethod.getDeclaredAnnotations());
    assertSame(annotations, readMethod2.getDeclaredAnnotations());
    assertSame(annotations, readMethod4.getDeclaredAnnotations());
    assertSame(rootClass, readMethod.getDeclaringClass());
    assertSame(rootClass, readMethod2.getDeclaringClass());
    assertSame(rootClass, readMethod4.getDeclaringClass());
    assertSame(rootClass, ((BeanWrapperImpl) propertyEditorRegistry).getWrappedClass());
    assertSame(annotations2[0], declaredAnnotations[0]);
    assertSame(bindingResult, model.get("org.springframework.validation.BindingResult.Object Name"));
  }

  /**
   * Test {@link BaseResponse#hasErrors()}.
   * <p>
   * Method under test: {@link BaseResponse#hasErrors()}
   */
  @Test
  public void testHasErrors() {
    // Arrange, Act and Assert
    assertFalse((new BaseResponse("Target", "Object Name")).hasErrors());
  }

  /**
   * Test {@link BaseResponse#getErrors()}.
   * <p>
   * Method under test: {@link BaseResponse#getErrors()}
   */
  @Test
  public void testGetErrors() {
    // Arrange, Act and Assert
    assertTrue((new BaseResponse("Target", "Object Name")).getErrors() instanceof BindException);
  }
}
