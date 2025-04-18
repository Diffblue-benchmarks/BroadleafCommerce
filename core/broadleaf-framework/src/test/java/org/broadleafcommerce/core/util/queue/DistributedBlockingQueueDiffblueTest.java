/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.util.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.util.queue.DistributedBlockingQueue.DistributedQueueException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DistributedBlockingQueueDiffblueTest {
  /**
   * Test DistributedQueueException {@link DistributedQueueException#DistributedQueueException()}.
   * <p>
   * Method under test: {@link DistributedQueueException#DistributedQueueException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DistributedQueueException.<init>()", "void DistributedQueueException.<init>(String)",
      "void DistributedQueueException.<init>(String, Throwable)",
      "void DistributedQueueException.<init>(String, Throwable, boolean, boolean)",
      "void DistributedQueueException.<init>(Throwable)"})
  public void testDistributedQueueExceptionNewDistributedQueueException() {
    // Arrange and Act
    DistributedQueueException actualDistributedQueueException = new DistributedQueueException();

    // Assert
    assertNull(actualDistributedQueueException.getMessage());
    assertNull(actualDistributedQueueException.getCause());
    assertEquals(0, actualDistributedQueueException.getSuppressed().length);
  }

  /**
   * Test DistributedQueueException {@link DistributedQueueException#DistributedQueueException(String, Throwable)}.
   * <p>
   * Method under test: {@link DistributedQueueException#DistributedQueueException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DistributedQueueException.<init>()", "void DistributedQueueException.<init>(String)",
      "void DistributedQueueException.<init>(String, Throwable)",
      "void DistributedQueueException.<init>(String, Throwable, boolean, boolean)",
      "void DistributedQueueException.<init>(Throwable)"})
  public void testDistributedQueueExceptionNewDistributedQueueException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedQueueException actualDistributedQueueException = new DistributedQueueException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualDistributedQueueException.getMessage());
    assertEquals(0, actualDistributedQueueException.getSuppressed().length);
    assertSame(cause, actualDistributedQueueException.getCause());
  }

  /**
   * Test DistributedQueueException {@link DistributedQueueException#DistributedQueueException(Throwable)}.
   * <p>
   * Method under test: {@link DistributedQueueException#DistributedQueueException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DistributedQueueException.<init>()", "void DistributedQueueException.<init>(String)",
      "void DistributedQueueException.<init>(String, Throwable)",
      "void DistributedQueueException.<init>(String, Throwable, boolean, boolean)",
      "void DistributedQueueException.<init>(Throwable)"})
  public void testDistributedQueueExceptionNewDistributedQueueException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedQueueException actualDistributedQueueException = new DistributedQueueException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDistributedQueueException.getMessage());
    assertEquals(0, actualDistributedQueueException.getSuppressed().length);
    assertSame(cause, actualDistributedQueueException.getCause());
  }

  /**
   * Test DistributedQueueException {@link DistributedQueueException#DistributedQueueException(String)}.
   * <ul>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DistributedQueueException#DistributedQueueException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DistributedQueueException.<init>()", "void DistributedQueueException.<init>(String)",
      "void DistributedQueueException.<init>(String, Throwable)",
      "void DistributedQueueException.<init>(String, Throwable, boolean, boolean)",
      "void DistributedQueueException.<init>(Throwable)"})
  public void testDistributedQueueExceptionNewDistributedQueueException_thenReturnCauseIsNull() {
    // Arrange and Act
    DistributedQueueException actualDistributedQueueException = new DistributedQueueException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDistributedQueueException.getMessage());
    assertNull(actualDistributedQueueException.getCause());
    assertEquals(0, actualDistributedQueueException.getSuppressed().length);
  }

  /**
   * Test DistributedQueueException {@link DistributedQueueException#DistributedQueueException(String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DistributedQueueException#DistributedQueueException(String, Throwable, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DistributedQueueException.<init>()", "void DistributedQueueException.<init>(String)",
      "void DistributedQueueException.<init>(String, Throwable)",
      "void DistributedQueueException.<init>(String, Throwable, boolean, boolean)",
      "void DistributedQueueException.<init>(Throwable)"})
  public void testDistributedQueueExceptionNewDistributedQueueException_whenTrue() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedQueueException actualDistributedQueueException = new DistributedQueueException("An error occurred",
        cause, true, true);

    // Assert
    assertEquals("An error occurred", actualDistributedQueueException.getMessage());
    assertEquals(0, actualDistributedQueueException.getSuppressed().length);
    assertSame(cause, actualDistributedQueueException.getCause());
  }
}
