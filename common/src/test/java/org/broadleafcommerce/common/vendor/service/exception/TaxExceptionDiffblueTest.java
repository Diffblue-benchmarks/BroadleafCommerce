package org.broadleafcommerce.common.vendor.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.vendor.service.message.TaxResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TaxExceptionDiffblueTest {
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
   *   <li>{@link TaxException#TaxException()}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)",
    "TaxResponse TaxException.getTaxResponse()",
    "void TaxException.setTaxResponse(TaxResponse)"
  })
  public void testGettersAndSetters_thenReturnMessageIsNull() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException();
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertNull(actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(taxResponse, actualTaxResponse);
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
   *   <li>{@link TaxException#TaxException(String)}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)",
    "TaxResponse TaxException.getTaxResponse()",
    "void TaxException.setTaxResponse(TaxResponse)"
  })
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException("An error occurred");
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(taxResponse, actualTaxResponse);
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
   *   <li>{@link TaxException#TaxException(String, Throwable)}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)",
    "TaxResponse TaxException.getTaxResponse()",
    "void TaxException.setTaxResponse(TaxResponse)"
  })
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException("An error occurred", cause);
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
    assertSame(taxResponse, actualTaxResponse);
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
   *   <li>{@link TaxException#TaxException(Throwable)}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)",
    "TaxResponse TaxException.getTaxResponse()",
    "void TaxException.setTaxResponse(TaxResponse)"
  })
  public void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException(cause);
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertEquals("java.lang.Throwable", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
    assertSame(taxResponse, actualTaxResponse);
  }
}
