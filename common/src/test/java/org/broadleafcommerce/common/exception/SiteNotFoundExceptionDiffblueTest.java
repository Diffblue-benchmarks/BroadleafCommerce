package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteNotFoundExceptionDiffblueTest {
  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link SiteNotFoundException#SiteNotFoundException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteNotFoundException.<init>()",
    "void SiteNotFoundException.<init>(String)",
    "void SiteNotFoundException.<init>(String, Throwable)",
    "void SiteNotFoundException.<init>(Throwable)"
  })
  public void testNewSiteNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    SiteNotFoundException actualSiteNotFoundException =
        new SiteNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSiteNotFoundException.getMessage());
    assertNull(actualSiteNotFoundException.getCause());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link SiteNotFoundException#SiteNotFoundException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteNotFoundException.<init>()",
    "void SiteNotFoundException.<init>(String)",
    "void SiteNotFoundException.<init>(String, Throwable)",
    "void SiteNotFoundException.<init>(Throwable)"
  })
  public void testNewSiteNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SiteNotFoundException actualSiteNotFoundException =
        new SiteNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSiteNotFoundException.getMessage());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
    assertSame(cause, actualSiteNotFoundException.getCause());
  }

  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteNotFoundException#SiteNotFoundException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteNotFoundException.<init>()",
    "void SiteNotFoundException.<init>(String)",
    "void SiteNotFoundException.<init>(String, Throwable)",
    "void SiteNotFoundException.<init>(Throwable)"
  })
  public void testNewSiteNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    SiteNotFoundException actualSiteNotFoundException = new SiteNotFoundException();

    // Assert
    assertNull(actualSiteNotFoundException.getMessage());
    assertNull(actualSiteNotFoundException.getCause());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link SiteNotFoundException#SiteNotFoundException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteNotFoundException.<init>()",
    "void SiteNotFoundException.<init>(String)",
    "void SiteNotFoundException.<init>(String, Throwable)",
    "void SiteNotFoundException.<init>(Throwable)"
  })
  public void testNewSiteNotFoundException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SiteNotFoundException actualSiteNotFoundException = new SiteNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSiteNotFoundException.getMessage());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
    assertSame(cause, actualSiteNotFoundException.getCause());
  }
}
