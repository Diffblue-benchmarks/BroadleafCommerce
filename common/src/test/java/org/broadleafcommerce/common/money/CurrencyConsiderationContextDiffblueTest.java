package org.broadleafcommerce.common.money;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CurrencyConsiderationContextDiffblueTest {
  /**
   * Test {@link CurrencyConsiderationContext#getCurrencyConsiderationContext()}.
   *
   * <p>Method under test: {@link CurrencyConsiderationContext#getCurrencyConsiderationContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.HashMap CurrencyConsiderationContext.getCurrencyConsiderationContext()"
  })
  public void testGetCurrencyConsiderationContext() {
    // Arrange, Act and Assert
    assertTrue(CurrencyConsiderationContext.getCurrencyConsiderationContext().isEmpty());
  }
}
