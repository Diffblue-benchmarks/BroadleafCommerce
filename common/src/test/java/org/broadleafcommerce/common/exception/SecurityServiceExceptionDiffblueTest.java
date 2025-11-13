package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SecurityServiceExceptionDiffblueTest {
  /**
   * Test {@link SecurityServiceException#SecurityServiceException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityServiceException#SecurityServiceException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityServiceException.<init>()",
    "void SecurityServiceException.<init>(String)",
    "void SecurityServiceException.<init>(String, Throwable)",
    "void SecurityServiceException.<init>(Throwable)"
  })
  public void testNewSecurityServiceException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    SecurityServiceException actualSecurityServiceException =
        new SecurityServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSecurityServiceException.getMessage());
    assertNull(actualSecurityServiceException.getCause());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
  }

  /**
   * Test {@link SecurityServiceException#SecurityServiceException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityServiceException#SecurityServiceException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityServiceException.<init>()",
    "void SecurityServiceException.<init>(String)",
    "void SecurityServiceException.<init>(String, Throwable)",
    "void SecurityServiceException.<init>(Throwable)"
  })
  public void testNewSecurityServiceException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SecurityServiceException actualSecurityServiceException =
        new SecurityServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSecurityServiceException.getMessage());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
    assertSame(cause, actualSecurityServiceException.getCause());
  }

  /**
   * Test {@link SecurityServiceException#SecurityServiceException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityServiceException#SecurityServiceException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityServiceException.<init>()",
    "void SecurityServiceException.<init>(String)",
    "void SecurityServiceException.<init>(String, Throwable)",
    "void SecurityServiceException.<init>(Throwable)"
  })
  public void testNewSecurityServiceException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SecurityServiceException actualSecurityServiceException = new SecurityServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSecurityServiceException.getMessage());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
    assertSame(cause, actualSecurityServiceException.getCause());
  }

  /**
   * Test {@link SecurityServiceException#SecurityServiceException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityServiceException#SecurityServiceException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityServiceException.<init>()",
    "void SecurityServiceException.<init>(String)",
    "void SecurityServiceException.<init>(String, Throwable)",
    "void SecurityServiceException.<init>(Throwable)"
  })
  public void testNewSecurityServiceException_thenReturnMessageIsNull() {
    // Arrange and Act
    SecurityServiceException actualSecurityServiceException = new SecurityServiceException();

    // Assert
    assertNull(actualSecurityServiceException.getMessage());
    assertNull(actualSecurityServiceException.getCause());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
  }
}
