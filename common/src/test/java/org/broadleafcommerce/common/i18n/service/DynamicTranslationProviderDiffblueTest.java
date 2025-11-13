package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DynamicTranslationProviderDiffblueTest {
  /**
   * Test {@link DynamicTranslationProvider#getValue(Object, String, String)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicTranslationProvider#getValue(Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicTranslationProvider.getValue(Object, String, String)"})
  public void testGetValue_whenNull_field() {
    // Arrange and Act
    String actualValue =
        DynamicTranslationProvider.getValue(BLCFieldUtils.NULL_FIELD, "Field", "42");

    // Assert
    assertEquals("42", actualValue);
  }

  /**
   * Test {@link DynamicTranslationProvider#getValue(Object, String, String)}.
   *
   * <ul>
   *   <li>When {@link TranslationConsiderationContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DynamicTranslationProvider#getValue(Object, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicTranslationProvider.getValue(Object, String, String)"})
  public void testGetValue_whenTranslationConsiderationContext() {
    // Arrange and Act
    String actualValue =
        DynamicTranslationProvider.getValue(new TranslationConsiderationContext(), "Field", "42");

    // Assert
    assertEquals("42", actualValue);
  }
}
