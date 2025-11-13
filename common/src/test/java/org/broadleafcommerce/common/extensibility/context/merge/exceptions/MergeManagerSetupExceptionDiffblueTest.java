package org.broadleafcommerce.common.extensibility.context.merge.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MergeManagerSetupExceptionDiffblueTest {
  /**
   * Test {@link MergeManagerSetupException#MergeManagerSetupException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManagerSetupException#MergeManagerSetupException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeManagerSetupException.<init>()",
    "void MergeManagerSetupException.<init>(String)",
    "void MergeManagerSetupException.<init>(String, Throwable)",
    "void MergeManagerSetupException.<init>(Throwable)"
  })
  public void testNewMergeManagerSetupException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable arg0 = new Throwable();

    // Act
    MergeManagerSetupException actualMergeManagerSetupException =
        new MergeManagerSetupException(arg0);

    // Assert
    assertEquals("java.lang.Throwable", actualMergeManagerSetupException.getMessage());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
    assertSame(arg0, actualMergeManagerSetupException.getCause());
  }

  /**
   * Test {@link MergeManagerSetupException#MergeManagerSetupException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManagerSetupException#MergeManagerSetupException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeManagerSetupException.<init>()",
    "void MergeManagerSetupException.<init>(String)",
    "void MergeManagerSetupException.<init>(String, Throwable)",
    "void MergeManagerSetupException.<init>(Throwable)"
  })
  public void testNewMergeManagerSetupException_thenReturnMessageIsNull() {
    // Arrange and Act
    MergeManagerSetupException actualMergeManagerSetupException = new MergeManagerSetupException();

    // Assert
    assertNull(actualMergeManagerSetupException.getMessage());
    assertNull(actualMergeManagerSetupException.getCause());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
  }

  /**
   * Test {@link MergeManagerSetupException#MergeManagerSetupException(String)}.
   *
   * <ul>
   *   <li>When {@code Arg0}.
   *   <li>Then return Message is {@code Arg0}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManagerSetupException#MergeManagerSetupException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeManagerSetupException.<init>()",
    "void MergeManagerSetupException.<init>(String)",
    "void MergeManagerSetupException.<init>(String, Throwable)",
    "void MergeManagerSetupException.<init>(Throwable)"
  })
  public void testNewMergeManagerSetupException_whenArg0_thenReturnMessageIsArg0() {
    // Arrange and Act
    MergeManagerSetupException actualMergeManagerSetupException =
        new MergeManagerSetupException("Arg0");

    // Assert
    assertEquals("Arg0", actualMergeManagerSetupException.getMessage());
    assertNull(actualMergeManagerSetupException.getCause());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
  }

  /**
   * Test {@link MergeManagerSetupException#MergeManagerSetupException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code Arg0}.
   *   <li>Then return Message is {@code Arg0}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManagerSetupException#MergeManagerSetupException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeManagerSetupException.<init>()",
    "void MergeManagerSetupException.<init>(String)",
    "void MergeManagerSetupException.<init>(String, Throwable)",
    "void MergeManagerSetupException.<init>(Throwable)"
  })
  public void testNewMergeManagerSetupException_whenArg0_thenReturnMessageIsArg02() {
    // Arrange
    Throwable arg1 = new Throwable();

    // Act
    MergeManagerSetupException actualMergeManagerSetupException =
        new MergeManagerSetupException("Arg0", arg1);

    // Assert
    assertEquals("Arg0", actualMergeManagerSetupException.getMessage());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
    assertSame(arg1, actualMergeManagerSetupException.getCause());
  }
}
