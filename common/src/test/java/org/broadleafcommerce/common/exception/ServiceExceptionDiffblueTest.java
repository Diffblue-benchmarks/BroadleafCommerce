package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ServiceExceptionDiffblueTest {
  /**
   * Test {@link ServiceException#ServiceException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceException#ServiceException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServiceException.<init>()",
    "void ServiceException.<init>(String)",
    "void ServiceException.<init>(String, Throwable)",
    "void ServiceException.<init>(Throwable)"
  })
  public void testNewServiceException_thenReturnMessageIsNull() {
    // Arrange and Act
    ServiceException actualServiceException = new ServiceException();

    // Assert
    assertNull(actualServiceException.getMessage());
    assertNull(actualServiceException.getCause());
    assertEquals(0, actualServiceException.getSuppressed().length);
  }

  /**
   * Test {@link ServiceException#ServiceException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceException#ServiceException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServiceException.<init>()",
    "void ServiceException.<init>(String)",
    "void ServiceException.<init>(String, Throwable)",
    "void ServiceException.<init>(Throwable)"
  })
  public void testNewServiceException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ServiceException actualServiceException = new ServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualServiceException.getMessage());
    assertNull(actualServiceException.getCause());
    assertEquals(0, actualServiceException.getSuppressed().length);
  }

  /**
   * Test {@link ServiceException#ServiceException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceException#ServiceException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServiceException.<init>()",
    "void ServiceException.<init>(String)",
    "void ServiceException.<init>(String, Throwable)",
    "void ServiceException.<init>(Throwable)"
  })
  public void testNewServiceException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServiceException actualServiceException = new ServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualServiceException.getMessage());
    assertEquals(0, actualServiceException.getSuppressed().length);
    assertSame(cause, actualServiceException.getCause());
  }

  /**
   * Test {@link ServiceException#ServiceException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceException#ServiceException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServiceException.<init>()",
    "void ServiceException.<init>(String)",
    "void ServiceException.<init>(String, Throwable)",
    "void ServiceException.<init>(Throwable)"
  })
  public void testNewServiceException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServiceException actualServiceException = new ServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualServiceException.getMessage());
    assertEquals(0, actualServiceException.getSuppressed().length);
    assertSame(cause, actualServiceException.getCause());
  }
}
