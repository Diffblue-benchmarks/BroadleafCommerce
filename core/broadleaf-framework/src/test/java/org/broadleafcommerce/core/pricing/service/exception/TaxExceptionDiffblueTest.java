package org.broadleafcommerce.core.pricing.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TaxExceptionDiffblueTest {
  /**
   * Test {@link TaxException#TaxException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TaxException#TaxException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)"
  })
  public void testNewTaxException_thenReturnMessageIsNull() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException();

    // Assert
    assertNull(actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
  }

  /**
   * Test {@link TaxException#TaxException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TaxException#TaxException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)"
  })
  public void testNewTaxException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
  }

  /**
   * Test {@link TaxException#TaxException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TaxException#TaxException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)"
  })
  public void testNewTaxException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
  }

  /**
   * Test {@link TaxException#TaxException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link TaxException#TaxException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxException.<init>()",
    "void TaxException.<init>(String)",
    "void TaxException.<init>(String, Throwable)",
    "void TaxException.<init>(Throwable)"
  })
  public void testNewTaxException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
  }
}
