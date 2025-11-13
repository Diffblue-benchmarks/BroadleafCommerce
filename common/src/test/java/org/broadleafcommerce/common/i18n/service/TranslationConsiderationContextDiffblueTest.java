package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationConsiderationContextDiffblueTest {
  /**
   * Test {@link TranslationConsiderationContext#getTranslationConsiderationContext()}.
   *
   * <p>Method under test: {@link
   * TranslationConsiderationContext#getTranslationConsiderationContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TranslationConsiderationContext TranslationConsiderationContext.getTranslationConsiderationContext()"
  })
  public void testGetTranslationConsiderationContext() {
    // Arrange and Act
    TranslationConsiderationContext actualTranslationConsiderationContext =
        TranslationConsiderationContext.getTranslationConsiderationContext();

    // Assert
    assertNull(actualTranslationConsiderationContext.service);
    assertFalse(actualTranslationConsiderationContext.enabled);
  }

  /**
   * Test {@link TranslationConsiderationContext#hasTranslation()}.
   *
   * <p>Method under test: {@link TranslationConsiderationContext#hasTranslation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationConsiderationContext.hasTranslation()"})
  public void testHasTranslation() {
    // Arrange, Act and Assert
    assertFalse(TranslationConsiderationContext.hasTranslation());
  }

  /**
   * Test {@link TranslationConsiderationContext#isTranslationConsiderationContextEnabled()}.
   *
   * <p>Method under test: {@link
   * TranslationConsiderationContext#isTranslationConsiderationContextEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TranslationConsiderationContext.isTranslationConsiderationContextEnabled()"
  })
  public void testIsTranslationConsiderationContextEnabled() {
    // Arrange, Act and Assert
    assertFalse(TranslationConsiderationContext.isTranslationConsiderationContextEnabled());
  }

  /**
   * Test {@link TranslationConsiderationContext#getTranslationService()}.
   *
   * <p>Method under test: {@link TranslationConsiderationContext#getTranslationService()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.i18n.service.TranslationService TranslationConsiderationContext.getTranslationService()"
  })
  public void testGetTranslationService() {
    // Arrange, Act and Assert
    assertNull(TranslationConsiderationContext.getTranslationService());
  }

  /**
   * Test new {@link TranslationConsiderationContext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TranslationConsiderationContext}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TranslationConsiderationContext.<init>()"})
  public void testNewTranslationConsiderationContext() {
    // Arrange and Act
    TranslationConsiderationContext actualTranslationConsiderationContext =
        new TranslationConsiderationContext();

    // Assert
    assertNull(actualTranslationConsiderationContext.service);
    assertFalse(actualTranslationConsiderationContext.enabled);
  }
}
