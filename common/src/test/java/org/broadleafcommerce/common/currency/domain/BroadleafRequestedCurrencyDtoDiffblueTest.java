package org.broadleafcommerce.common.currency.domain;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafRequestedCurrencyDtoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafRequestedCurrencyDto#BroadleafRequestedCurrencyDto(BroadleafCurrency,
   *       BroadleafCurrency)}
   *   <li>{@link BroadleafRequestedCurrencyDto#getCurrencyToUse()}
   *   <li>{@link BroadleafRequestedCurrencyDto#getRequestedCurrency()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestedCurrencyDto.<init>(BroadleafCurrency, BroadleafCurrency)",
    "BroadleafCurrency BroadleafRequestedCurrencyDto.getCurrencyToUse()",
    "BroadleafCurrency BroadleafRequestedCurrencyDto.getRequestedCurrency()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafCurrencyImpl currencyToUse = new BroadleafCurrencyImpl();
    BroadleafCurrencyImpl requestedCurrency = new BroadleafCurrencyImpl();

    // Act
    BroadleafRequestedCurrencyDto actualBroadleafRequestedCurrencyDto =
        new BroadleafRequestedCurrencyDto(currencyToUse, requestedCurrency);
    BroadleafCurrency actualCurrencyToUse = actualBroadleafRequestedCurrencyDto.getCurrencyToUse();

    // Assert
    assertSame(currencyToUse, actualCurrencyToUse);
    assertSame(requestedCurrency, actualBroadleafRequestedCurrencyDto.getRequestedCurrency());
  }
}
