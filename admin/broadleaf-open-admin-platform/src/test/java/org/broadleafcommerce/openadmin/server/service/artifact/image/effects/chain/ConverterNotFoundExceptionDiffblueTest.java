/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConverterNotFoundExceptionDiffblueTest {
  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConverterNotFoundException#ConverterNotFoundException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConverterNotFoundException.<init>()", "void ConverterNotFoundException.<init>(String)",
      "void ConverterNotFoundException.<init>(String, Throwable)", "void ConverterNotFoundException.<init>(Throwable)"})
  public void testNewConverterNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConverterNotFoundException.getMessage());
    assertNull(actualConverterNotFoundException.getCause());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConverterNotFoundException#ConverterNotFoundException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConverterNotFoundException.<init>()", "void ConverterNotFoundException.<init>(String)",
      "void ConverterNotFoundException.<init>(String, Throwable)", "void ConverterNotFoundException.<init>(Throwable)"})
  public void testNewConverterNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualConverterNotFoundException.getMessage());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
    assertSame(cause, actualConverterNotFoundException.getCause());
  }

  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConverterNotFoundException#ConverterNotFoundException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConverterNotFoundException.<init>()", "void ConverterNotFoundException.<init>(String)",
      "void ConverterNotFoundException.<init>(String, Throwable)", "void ConverterNotFoundException.<init>(Throwable)"})
  public void testNewConverterNotFoundException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualConverterNotFoundException.getMessage());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
    assertSame(cause, actualConverterNotFoundException.getCause());
  }

  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConverterNotFoundException#ConverterNotFoundException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConverterNotFoundException.<init>()", "void ConverterNotFoundException.<init>(String)",
      "void ConverterNotFoundException.<init>(String, Throwable)", "void ConverterNotFoundException.<init>(Throwable)"})
  public void testNewConverterNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException();

    // Assert
    assertNull(actualConverterNotFoundException.getMessage());
    assertNull(actualConverterNotFoundException.getCause());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
  }
}
