package org.broadleafcommerce.common.vendor.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.vendor.service.message.FulfillmentPriceExceptionResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentPriceExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentPriceException#FulfillmentPriceException()}
   *   <li>{@link
   *       FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentPriceException.<init>()",
    "void FulfillmentPriceException.<init>(String)",
    "void FulfillmentPriceException.<init>(String, Throwable)",
    "void FulfillmentPriceException.<init>(Throwable)",
    "FulfillmentPriceExceptionResponse FulfillmentPriceException.getFulfillmentPriceExceptionResponse()",
    "void FulfillmentPriceException.setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)"
  })
  public void testGettersAndSetters_thenReturnMessageIsNull() {
    // Arrange and Act
    FulfillmentPriceException actualFulfillmentPriceException = new FulfillmentPriceException();
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse =
        mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(
        fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse =
        actualFulfillmentPriceException.getFulfillmentPriceExceptionResponse();

    // Assert
    assertNull(actualFulfillmentPriceException.getMessage());
    assertNull(actualFulfillmentPriceException.getCause());
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentPriceException#FulfillmentPriceException(String)}
   *   <li>{@link
   *       FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentPriceException.<init>()",
    "void FulfillmentPriceException.<init>(String)",
    "void FulfillmentPriceException.<init>(String, Throwable)",
    "void FulfillmentPriceException.<init>(Throwable)",
    "FulfillmentPriceExceptionResponse FulfillmentPriceException.getFulfillmentPriceExceptionResponse()",
    "void FulfillmentPriceException.setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)"
  })
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    FulfillmentPriceException actualFulfillmentPriceException =
        new FulfillmentPriceException("An error occurred");
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse =
        mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(
        fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse =
        actualFulfillmentPriceException.getFulfillmentPriceExceptionResponse();

    // Assert
    assertEquals("An error occurred", actualFulfillmentPriceException.getMessage());
    assertNull(actualFulfillmentPriceException.getCause());
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentPriceException#FulfillmentPriceException(String, Throwable)}
   *   <li>{@link
   *       FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentPriceException.<init>()",
    "void FulfillmentPriceException.<init>(String)",
    "void FulfillmentPriceException.<init>(String, Throwable)",
    "void FulfillmentPriceException.<init>(Throwable)",
    "FulfillmentPriceExceptionResponse FulfillmentPriceException.getFulfillmentPriceExceptionResponse()",
    "void FulfillmentPriceException.setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)"
  })
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FulfillmentPriceException actualFulfillmentPriceException =
        new FulfillmentPriceException("An error occurred", cause);
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse =
        mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(
        fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse =
        actualFulfillmentPriceException.getFulfillmentPriceExceptionResponse();

    // Assert
    assertEquals("An error occurred", actualFulfillmentPriceException.getMessage());
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(cause, actualFulfillmentPriceException.getCause());
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentPriceException#FulfillmentPriceException(Throwable)}
   *   <li>{@link
   *       FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentPriceException.<init>()",
    "void FulfillmentPriceException.<init>(String)",
    "void FulfillmentPriceException.<init>(String, Throwable)",
    "void FulfillmentPriceException.<init>(Throwable)",
    "FulfillmentPriceExceptionResponse FulfillmentPriceException.getFulfillmentPriceExceptionResponse()",
    "void FulfillmentPriceException.setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)"
  })
  public void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FulfillmentPriceException actualFulfillmentPriceException =
        new FulfillmentPriceException(cause);
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse =
        mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(
        fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse =
        actualFulfillmentPriceException.getFulfillmentPriceExceptionResponse();

    // Assert
    assertEquals("java.lang.Throwable", actualFulfillmentPriceException.getMessage());
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(cause, actualFulfillmentPriceException.getCause());
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }
}
