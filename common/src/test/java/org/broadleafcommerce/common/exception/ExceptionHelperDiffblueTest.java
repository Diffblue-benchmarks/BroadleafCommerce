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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.lang.reflect.UndeclaredThrowableException;
import org.junit.Ignore;
import org.junit.Test;

public class ExceptionHelperDiffblueTest {
  /**
   * Test {@link ExceptionHelper#refineException(Throwable)} with {@code e}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()} initCause {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  public void testRefineExceptionWithE_givenThrowableInitCauseNull() {
    // Arrange
    Throwable throwable = new Throwable();
    throwable.initCause(null);

    Throwable e = new Throwable();
    e.initCause(throwable);

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Throwable)} with {@code e}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  public void testRefineExceptionWithE_thenReturnLocalizedMessageIsFoo() {
    // Arrange and Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(new IllegalStateException("foo"));

    // Assert
    assertEquals("foo", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualRefineExceptionResult.getMessage());
    assertNull(actualRefineExceptionResult.getCause());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link ExceptionHelper#refineException(Throwable)} with {@code e}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  public void testRefineExceptionWithE_whenThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeE() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeE2() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeE_thenReturnLocalizedMessageIsFoo() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType,
        new IllegalStateException("foo"));

    // Assert
    assertEquals("foo", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualRefineExceptionResult.getMessage());
    assertNull(actualRefineExceptionResult.getCause());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeE_thenThrowRuntimeException() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.refineException(refineType, wrapType, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeE_thenThrowRuntimeException2() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.refineException(refineType, wrapType, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <ul>
   *   <li>When {@link Throwable#Throwable(String, Throwable)} with {@code foo} and
   * {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeE_whenThrowableWithFooAndThrowable() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable throwable = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType,
        new Throwable("foo", throwable));

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <ul>
   *   <li>When {@link Throwable#Throwable(String, Throwable)} with {@code foo} and
   * {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeE_whenThrowableWithFooAndThrowable2() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, wrapType, new Throwable("foo", new Throwable())));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType,
        "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE2() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType,
        "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE3() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE4() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, "", e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE5() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType,
        "An error occurred", new IllegalStateException("foo"));

    // Assert
    assertEquals("foo", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualRefineExceptionResult.getMessage());
    assertNull(actualRefineExceptionResult.getCause());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE6() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE7() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, null, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE8() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable throwable = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType,
        "An error occurred", new Throwable("foo", throwable));

    // Assert
    assertEquals("An error occurred", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE9() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, wrapType, "", new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE10() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.refineException(refineType, wrapType,
        "An error occurred", new Throwable("foo", new Throwable())));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with
   * {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()} initCause {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithWrapTypeE_givenThrowableInitCauseNull() {
    // Arrange
    Class<RuntimeException> wrapType = RuntimeException.class;

    Throwable throwable = new Throwable();
    throwable.initCause(null);

    Throwable throwable2 = new Throwable();
    throwable2.initCause(throwable);

    Throwable e = new Throwable();
    e.initCause(throwable2);

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with
   * {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithWrapTypeE_thenReturnLocalizedMessageIsFoo() {
    // Arrange
    Class<RuntimeException> wrapType = RuntimeException.class;

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(wrapType,
        new IllegalStateException("foo"));

    // Assert
    assertEquals("foo", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualRefineExceptionResult.getMessage());
    assertNull(actualRefineExceptionResult.getCause());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with
   * {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithWrapTypeE_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with
   * {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithWrapTypeE_thenThrowRuntimeException() {
    // Arrange
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.refineException(wrapType, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with
   * {@code wrapType}, {@code e}.
   * <ul>
   *   <li>When {@link Throwable#Throwable(String, Throwable)} with {@code foo} and
   * {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineExceptionWithWrapTypeE_whenThrowableWithFooAndThrowable() {
    // Arrange
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.refineException(wrapType, new Throwable("foo", new Throwable())));
  }

  /**
   * Test {@link ExceptionHelper#processException(Throwable)} with {@code e}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#processException(Throwable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessExceptionWithE_whenThrowable() throws Throwable {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: java.lang.Throwable
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.wrapException(ExceptionHelper.java:96)
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.processException(ExceptionHelper.java:75)
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.processException(ExceptionHelper.java:87)
    //   java.lang.Throwable
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    ExceptionHelper.processException(new Throwable());
  }

  /**
   * Test {@link ExceptionHelper#processException(Class, Class, Throwable)} with
   * {@code refineType}, {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExceptionHelper#processException(Class, Class, Throwable)}
   */
  @Test
  public void testProcessExceptionWithRefineTypeWrapTypeE_thenThrowRuntimeException() throws Throwable {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.processException(refineType, wrapType, new Throwable()));
  }

  /**
   * Test
   * {@link ExceptionHelper#processException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#processException(Class, Class, String, Throwable)}
   */
  @Test
  public void testProcessExceptionWithRefineTypeWrapTypeMessageE() throws Throwable {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.processException(refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Test
   * {@link ExceptionHelper#processException(Class, Class, String, Throwable)}
   * with {@code refineType}, {@code wrapType}, {@code message}, {@code e}.
   * <p>
   * Method under test:
   * {@link ExceptionHelper#processException(Class, Class, String, Throwable)}
   */
  @Test
  public void testProcessExceptionWithRefineTypeWrapTypeMessageE2() throws Throwable {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.processException(refineType, wrapType, null, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#processException(Class, Throwable)} with
   * {@code wrapType}, {@code e}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHelper#processException(Class, Throwable)}
   */
  @Test
  public void testProcessExceptionWithWrapTypeE_thenThrowRuntimeException() throws Throwable {
    // Arrange
    Class<ExceptionHelper> wrapType = ExceptionHelper.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.processException(wrapType, new Throwable()));
  }
}
