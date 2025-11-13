package org.broadleafcommerce.common.vendor.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TaxHostExceptionDiffblueTest {
  /**
   * Test {@link TaxHostException#TaxHostException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TaxHostException#TaxHostException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxHostException.<init>()",
    "void TaxHostException.<init>(String)",
    "void TaxHostException.<init>(String, Throwable)",
    "void TaxHostException.<init>(Throwable)"
  })
  public void testNewTaxHostException_thenReturnMessageIsNull() {
    // Arrange and Act
    TaxHostException actualTaxHostException = new TaxHostException();

    // Assert
    assertNull(actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getCause());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
  }

  /**
   * Test {@link TaxHostException#TaxHostException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TaxHostException#TaxHostException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxHostException.<init>()",
    "void TaxHostException.<init>(String)",
    "void TaxHostException.<init>(String, Throwable)",
    "void TaxHostException.<init>(Throwable)"
  })
  public void testNewTaxHostException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TaxHostException actualTaxHostException = new TaxHostException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getCause());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
  }

  /**
   * Test {@link TaxHostException#TaxHostException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TaxHostException#TaxHostException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxHostException.<init>()",
    "void TaxHostException.<init>(String)",
    "void TaxHostException.<init>(String, Throwable)",
    "void TaxHostException.<init>(Throwable)"
  })
  public void testNewTaxHostException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxHostException actualTaxHostException = new TaxHostException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
    assertSame(cause, actualTaxHostException.getCause());
  }

  /**
   * Test {@link TaxHostException#TaxHostException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link TaxHostException#TaxHostException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxHostException.<init>()",
    "void TaxHostException.<init>(String)",
    "void TaxHostException.<init>(String, Throwable)",
    "void TaxHostException.<init>(Throwable)"
  })
  public void testNewTaxHostException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxHostException actualTaxHostException = new TaxHostException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
    assertSame(cause, actualTaxHostException.getCause());
  }
}
