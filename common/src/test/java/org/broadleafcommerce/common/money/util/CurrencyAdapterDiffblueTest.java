package org.broadleafcommerce.common.money.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Currency;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CurrencyAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CurrencyAdapterDiffblueTest {
  @Autowired private CurrencyAdapter currencyAdapter;

  /**
   * Test {@link CurrencyAdapter#unmarshal(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code GBP}.
   *   <li>Then return DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link CurrencyAdapter#unmarshal(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency CurrencyAdapter.unmarshal(String)"})
  public void testUnmarshalWithString_whenGbp_thenReturnDisplayNameIsBritishPoundSterling()
      throws Exception {
    // Arrange and Act
    Currency actualUnmarshalResult = currencyAdapter.unmarshal("GBP");

    // Assert
    assertEquals("British Pound Sterling", actualUnmarshalResult.getDisplayName());
    assertEquals("GBP", actualUnmarshalResult.getCurrencyCode());
    assertEquals("GBP", actualUnmarshalResult.getSymbol());
    assertEquals("GBP", actualUnmarshalResult.toString());
    assertEquals(2, actualUnmarshalResult.getDefaultFractionDigits());
    assertEquals(826, actualUnmarshalResult.getNumericCode());
  }
}
