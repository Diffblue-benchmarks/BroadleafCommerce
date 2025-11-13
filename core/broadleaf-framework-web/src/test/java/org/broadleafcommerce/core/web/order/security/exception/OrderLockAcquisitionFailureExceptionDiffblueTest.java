package org.broadleafcommerce.core.web.order.security.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderLockAcquisitionFailureExceptionDiffblueTest {
  /**
   * Test {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderLockAcquisitionFailureException.<init>()",
    "void OrderLockAcquisitionFailureException.<init>(String)",
    "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
    "void OrderLockAcquisitionFailureException.<init>(Throwable)"
  })
  public void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException =
        new OrderLockAcquisitionFailureException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }

  /**
   * Test {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderLockAcquisitionFailureException.<init>()",
    "void OrderLockAcquisitionFailureException.<init>(String)",
    "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
    "void OrderLockAcquisitionFailureException.<init>(Throwable)"
  })
  public void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException =
        new OrderLockAcquisitionFailureException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }

  /**
   * Test {@link
   * OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderLockAcquisitionFailureException.<init>()",
    "void OrderLockAcquisitionFailureException.<init>(String)",
    "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
    "void OrderLockAcquisitionFailureException.<init>(Throwable)"
  })
  public void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException =
        new OrderLockAcquisitionFailureException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }

  /**
   * Test {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderLockAcquisitionFailureException.<init>()",
    "void OrderLockAcquisitionFailureException.<init>(String)",
    "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
    "void OrderLockAcquisitionFailureException.<init>(Throwable)"
  })
  public void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsNull() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException =
        new OrderLockAcquisitionFailureException();

    // Assert
    assertNull(actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }
}
