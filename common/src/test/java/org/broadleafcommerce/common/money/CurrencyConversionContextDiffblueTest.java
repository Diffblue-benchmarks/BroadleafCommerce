package org.broadleafcommerce.common.money;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CurrencyConversionContextDiffblueTest {
  /**
   * Test {@link CurrencyConversionContext#getCurrencyConversionContext()}.
   *
   * <p>Method under test: {@link CurrencyConversionContext#getCurrencyConversionContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.HashMap CurrencyConversionContext.getCurrencyConversionContext()"})
  public void testGetCurrencyConversionContext() {
    // Arrange, Act and Assert
    assertTrue(CurrencyConversionContext.getCurrencyConversionContext().isEmpty());
  }
}
