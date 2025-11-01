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
import org.junit.Test;

public class ExceptionHelperDiffblueTest {
  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineException() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineException2() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineException3() {
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
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, Throwable)}
   */
  @Test
  public void testRefineException4() {
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
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineException5() {
    // Arrange
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(wrapType, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineException6() {
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
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test: {@link ExceptionHelper#refineException(Class, Throwable)}
   */
  @Test
  public void testRefineException7() {
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
   * Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  public void testRefineException8() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  public void testRefineException9() {
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
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test: {@link ExceptionHelper#refineException(Throwable)}
   */
  @Test
  public void testRefineException10() {
    // Arrange and Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(new IllegalStateException("foo"));

    // Assert
    assertEquals("foo", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualRefineExceptionResult.getMessage());
    assertNull(actualRefineExceptionResult.getCause());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException11() {
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
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException12() {
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
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException13() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException14() {
    // Arrange
    Class<Throwable> refineType = Throwable.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, "", e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException15() {
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
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException16() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.refineException(refineType, wrapType, "An error occurred", new Throwable()));
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException17() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<RuntimeException> wrapType = RuntimeException.class;
    Throwable e = new Throwable();

    // Act
    RuntimeException actualRefineExceptionResult = ExceptionHelper.refineException(refineType, wrapType, null, e);

    // Assert
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRefineExceptionResult.getMessage());
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(e, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException18() {
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
    assertEquals(0, actualRefineExceptionResult.getSuppressed().length);
    assertSame(throwable, actualRefineExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#refineException(Class, Class, String, Throwable)}
   */
  @Test
  public void testRefineException19() {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExceptionHelper.refineException(refineType, wrapType,
        "An error occurred", new Throwable("foo", new Throwable())));
  }

  /**
   * Method under test:
   * {@link ExceptionHelper#processException(Class, Class, String, Throwable)}
   */
  @Test
  public void testProcessException() throws Throwable {
    // Arrange
    Class<RuntimeException> refineType = RuntimeException.class;
    Class<UndeclaredThrowableException> wrapType = UndeclaredThrowableException.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExceptionHelper.processException(refineType, wrapType, "An error occurred", new Throwable()));
  }
}
