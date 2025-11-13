package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationFilterDiffblueTest {
  /**
   * Test {@link TranslationFilter#getOrder()}.
   *
   * <p>Method under test: {@link TranslationFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int TranslationFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FilterOrdered.POST_SECURITY_LOW, new TranslationFilter().getOrder());
  }
}
