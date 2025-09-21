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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExceptionHelperDiffblueTest {
  /**
   * Test {@link ExceptionHelper#refineException(Throwable)} with {@code e}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Throwable)"})
  public void testRefineExceptionWithE_thenReturnLocalizedMessageIsJavaLangThrowable() {
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
   * Test {@link ExceptionHelper#refineException(Throwable)} with {@code e}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable: foo}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Throwable)"})
  public void testRefineExceptionWithE_thenReturnLocalizedMessageIsJavaLangThrowableFoo() {
    // Arrange
    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    InvocationTargetException invocationTargetException = new InvocationTargetException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(new InvocationTargetException(invocationTargetException));

    // Assert
    assertEquals("java.lang.Throwable: foo", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable: foo", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Throwable)} with {@code e}.
   *
   * <ul>
   *   <li>Then return {@link UndeclaredThrowableException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Throwable)"})
  public void testRefineExceptionWithE_thenReturnUndeclaredThrowableException() {
    // Arrange
    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    UndeclaredThrowableException undeclaredThrowableException =
        new UndeclaredThrowableException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(
            new InvocationTargetException(undeclaredThrowableException));

    // Assert
    assertTrue(actualRefineExceptionResult instanceof UndeclaredThrowableException);
    assertNull(actualRefineExceptionResult.getLocalizedMessage());
    assertNull(actualRefineExceptionResult.getMessage());
    assertSame(
        throwable,
        ((UndeclaredThrowableException) actualRefineExceptionResult).getUndeclaredThrowable());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Class, Throwable)"})
  public void testRefineExceptionWithRefineTypeWrapTypeE() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(refineType, wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Class, Throwable)"})
  public void testRefineExceptionWithRefineTypeWrapTypeE2() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;

    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    InvocationTargetException invocationTargetException = new InvocationTargetException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(
            refineType, wrapType, new UndeclaredThrowableException(invocationTargetException));

    // Assert
    assertTrue(actualRefineExceptionResult instanceof UndeclaredThrowableException);
    assertNull(actualRefineExceptionResult.getLocalizedMessage());
    assertNull(actualRefineExceptionResult.getMessage());
    assertSame(invocationTargetException, actualRefineExceptionResult.getCause());
    assertSame(
        invocationTargetException,
        ((UndeclaredThrowableException) actualRefineExceptionResult).getUndeclaredThrowable());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Class, Throwable)"})
  public void testRefineExceptionWithRefineTypeWrapTypeE3() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(refineType, wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Class, Throwable)"})
  public void testRefineExceptionWithRefineTypeWrapTypeE_thenThrowRuntimeException() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, null, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Class, Throwable)"})
  public void testRefineExceptionWithRefineTypeWrapTypeE_whenNull_thenThrowRuntimeException() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, null, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable(String, Throwable)} with {@code foo} and {@link
   *       Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Class, Throwable)"})
  public void testRefineExceptionWithRefineTypeWrapTypeE_whenThrowableWithFooAndThrowable() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable throwable = new Throwable();
    Throwable e = new Throwable("foo", throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(refineType, wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable(String, Throwable)} with {@code foo} and {@link
   *       Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Class, Throwable)"})
  public void testRefineExceptionWithRefineTypeWrapTypeE_whenThrowableWithFooAndThrowable2() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Throwable e = new Throwable("foo", new Throwable());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> ExceptionHelper.refineException(refineType, null, e));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(refineType, wrapType, "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE2() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;

    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    InvocationTargetException invocationTargetException = new InvocationTargetException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(
            refineType, wrapType, "", new InvocationTargetException(invocationTargetException));

    // Assert
    Throwable cause = actualRefineExceptionResult.getCause();
    assertTrue(cause.getCause() instanceof InvocationTargetException);
    assertTrue(cause instanceof InvocationTargetException);
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE3() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;

    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    InvocationTargetException invocationTargetException = new InvocationTargetException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(
            refineType, wrapType, "", new UndeclaredThrowableException(invocationTargetException));

    // Assert
    assertTrue(actualRefineExceptionResult instanceof UndeclaredThrowableException);
    assertNull(actualRefineExceptionResult.getLocalizedMessage());
    assertNull(actualRefineExceptionResult.getMessage());
    assertSame(invocationTargetException, actualRefineExceptionResult.getCause());
    assertSame(
        invocationTargetException,
        ((UndeclaredThrowableException) actualRefineExceptionResult).getUndeclaredThrowable());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE4() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;

    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    InvocationTargetException invocationTargetException = new InvocationTargetException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(
            refineType, wrapType, null, new InvocationTargetException(invocationTargetException));

    // Assert
    Throwable cause = actualRefineExceptionResult.getCause();
    assertTrue(cause.getCause() instanceof InvocationTargetException);
    assertTrue(cause instanceof InvocationTargetException);
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE5() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(refineType, wrapType, "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualRefineExceptionResult.getMessage());
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE6() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExceptionHelper.refineException(
                refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE7() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExceptionHelper.refineException(
                refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE8() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable throwable = new Throwable();
    Throwable e = new Throwable("foo", throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(refineType, wrapType, "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuntimeException ExceptionHelper.refineException(Class, Class, String, Throwable)"
  })
  public void testRefineExceptionWithRefineTypeWrapTypeMessageE9() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;
    Throwable e = new Throwable("foo", new Throwable());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, wrapType, "An error occurred", e));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with {@code wrapType}, {@code
   * e}.
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Throwable)"})
  public void testRefineExceptionWithWrapTypeE() {
    // Arrange
    Class<RuntimeException> wrapType = RuntimeException.class;

    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    InvocationTargetException invocationTargetException = new InvocationTargetException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(
            wrapType, new InvocationTargetException(invocationTargetException));

    // Assert
    assertEquals("java.lang.Throwable: foo", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable: foo", actualRefineExceptionResult.getMessage());
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with {@code wrapType}, {@code
   * e}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Throwable)"})
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
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with {@code wrapType}, {@code
   * e}.
   *
   * <ul>
   *   <li>Then return {@link UndeclaredThrowableException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Throwable)"})
  public void testRefineExceptionWithWrapTypeE_thenReturnUndeclaredThrowableException() {
    // Arrange
    Class<RuntimeException> wrapType = RuntimeException.class;

    Throwable throwable = new Throwable("foo");
    throwable.initCause(null);
    UndeclaredThrowableException undeclaredThrowableException =
        new UndeclaredThrowableException(throwable);

    // Act
    RuntimeException actualRefineExceptionResult =
        ExceptionHelper.refineException(
            wrapType, new InvocationTargetException(undeclaredThrowableException));

    // Assert
    assertTrue(actualRefineExceptionResult instanceof UndeclaredThrowableException);
    assertNull(actualRefineExceptionResult.getLocalizedMessage());
    assertNull(actualRefineExceptionResult.getMessage());
    assertSame(
        throwable,
        ((UndeclaredThrowableException) actualRefineExceptionResult).getUndeclaredThrowable());
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with {@code wrapType}, {@code
   * e}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable(String, Throwable)} with {@code foo} and {@link
   *       Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Throwable)"})
  public void testRefineExceptionWithWrapTypeE_whenThrowableWithFooAndThrowable() {
    // Arrange
    Throwable e = new Throwable("foo", new Throwable());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.refineException(null, e));
  }

  /**
   * Test {@link ExceptionHelper#refineException(Class, Throwable)} with {@code wrapType}, {@code
   * e}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeException ExceptionHelper.refineException(Class, Throwable)"})
  public void testRefineExceptionWithWrapTypeE_whenThrowable_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ExceptionHelper.refineException(null, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#processException(Class, Class, Throwable)} with {@code refineType},
   * {@code wrapType}, {@code e}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#processException(Class, Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExceptionHelper.processException(Class, Class, Throwable)"})
  public void testProcessExceptionWithRefineTypeWrapTypeE_whenNull_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ExceptionHelper.processException(refineType, null, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#processException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <p>Method under test: {@link ExceptionHelper#processException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExceptionHelper.processException(Class, Class, String, Throwable)"})
  public void testProcessExceptionWithRefineTypeWrapTypeMessageE() throws Throwable {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExceptionHelper.processException(
                refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#processException(Class, Class, String, Throwable)} with {@code
   * refineType}, {@code wrapType}, {@code message}, {@code e}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#processException(Class, Class, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExceptionHelper.processException(Class, Class, String, Throwable)"})
  public void testProcessExceptionWithRefineTypeWrapTypeMessageE_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ExceptionHelper.processException(refineType, null, null, new Throwable()));
  }

  /**
   * Test {@link ExceptionHelper#processException(Class, Throwable)} with {@code wrapType}, {@code
   * e}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionHelper#processException(Class, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExceptionHelper.processException(Class, Throwable)"})
  public void testProcessExceptionWithWrapTypeE_whenNull_thenThrowRuntimeException()
      throws Throwable {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ExceptionHelper.processException(null, new Throwable()));
  }
}
