package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MVELTranslationExceptionDiffblueTest {
  /**
   * Test {@link MVELTranslationException#MVELTranslationException(int, String)}.
   *
   * <p>Method under test: {@link MVELTranslationException#MVELTranslationException(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MVELTranslationException.<init>(int, String)"})
  public void testNewMVELTranslationException() {
    // Arrange and Act
    MVELTranslationException actualMvelTranslationException =
        new MVELTranslationException(1, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualMvelTranslationException.getMessage());
    assertNull(actualMvelTranslationException.getMessageParameters());
    assertNull(actualMvelTranslationException.getCause());
    assertEquals(0, actualMvelTranslationException.getSuppressed().length);
    assertEquals(1, actualMvelTranslationException.getCode());
  }
}
