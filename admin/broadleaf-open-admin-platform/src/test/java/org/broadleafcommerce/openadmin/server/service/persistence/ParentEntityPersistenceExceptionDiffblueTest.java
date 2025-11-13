package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ParentEntityPersistenceExceptionDiffblueTest {
  /**
   * Test {@link ParentEntityPersistenceException#ParentEntityPersistenceException(String)}.
   *
   * <ul>
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ParentEntityPersistenceException#ParentEntityPersistenceException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParentEntityPersistenceException.<init>(String)",
    "void ParentEntityPersistenceException.<init>(String, Throwable)",
    "void ParentEntityPersistenceException.<init>(Throwable)"
  })
  public void testNewParentEntityPersistenceException_thenReturnCauseIsNull() {
    // Arrange and Act
    ParentEntityPersistenceException actualParentEntityPersistenceException =
        new ParentEntityPersistenceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualParentEntityPersistenceException.getMessage());
    assertNull(actualParentEntityPersistenceException.getCause());
    assertEquals(0, actualParentEntityPersistenceException.getSuppressed().length);
  }

  /**
   * Test {@link ParentEntityPersistenceException#ParentEntityPersistenceException(String,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ParentEntityPersistenceException#ParentEntityPersistenceException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParentEntityPersistenceException.<init>(String)",
    "void ParentEntityPersistenceException.<init>(String, Throwable)",
    "void ParentEntityPersistenceException.<init>(Throwable)"
  })
  public void testNewParentEntityPersistenceException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ParentEntityPersistenceException actualParentEntityPersistenceException =
        new ParentEntityPersistenceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualParentEntityPersistenceException.getMessage());
    assertEquals(0, actualParentEntityPersistenceException.getSuppressed().length);
    assertSame(cause, actualParentEntityPersistenceException.getCause());
  }

  /**
   * Test {@link ParentEntityPersistenceException#ParentEntityPersistenceException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ParentEntityPersistenceException#ParentEntityPersistenceException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParentEntityPersistenceException.<init>(String)",
    "void ParentEntityPersistenceException.<init>(String, Throwable)",
    "void ParentEntityPersistenceException.<init>(Throwable)"
  })
  public void testNewParentEntityPersistenceException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ParentEntityPersistenceException actualParentEntityPersistenceException =
        new ParentEntityPersistenceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualParentEntityPersistenceException.getMessage());
    assertEquals(0, actualParentEntityPersistenceException.getSuppressed().length);
    assertSame(cause, actualParentEntityPersistenceException.getCause());
  }
}
