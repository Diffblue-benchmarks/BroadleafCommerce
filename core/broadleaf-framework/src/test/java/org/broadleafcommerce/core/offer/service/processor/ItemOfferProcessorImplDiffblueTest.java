package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ItemOfferProcessorImplDiffblueTest {
  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_thenReturnBigDecimalWith0() {
    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl =
        new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = new Money();

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_thenReturnBigDecimalWith000() {
    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl =
        new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Money itemSubTotal = mock(Money.class);
    when(itemSubTotal.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    verify(itemSubTotal).getAmount();
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 100.0}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_thenReturnBigDecimalWith1000() {
    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl =
        new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Money itemSubTotal = mock(Money.class);
    when(itemSubTotal.getAmount()).thenReturn(new BigDecimal("2.3"));

    Money itemSavings = mock(Money.class);
    when(itemSavings.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, itemSavings);

    // Assert
    verify(itemSubTotal).getAmount();
    verify(itemSavings).getAmount();
    assertEquals(new BigDecimal("100.0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_whenMoneyWithAmountIsTen_thenReturnBigDecimalWith000() {
    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl =
        new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = new Money(10.0d);

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_whenZero_thenReturnBigDecimalWith0() {
    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl =
        new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(Money.ZERO, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }
}
