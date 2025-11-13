package org.broadleafcommerce.common.util.xml;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.BankersRounding;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BigDecimalRoundingAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BigDecimalRoundingAdapterDiffblueTest {
  @Autowired private BigDecimalRoundingAdapter bigDecimalRoundingAdapter;

  /**
   * Test {@link BigDecimalRoundingAdapter#unmarshal(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 2.3}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link BigDecimalRoundingAdapter#unmarshal(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal BigDecimalRoundingAdapter.unmarshal(String)"})
  public void testUnmarshalWithString_when23_thenReturnBigDecimalWith23() throws Exception {
    // Arrange and Act
    BigDecimal actualUnmarshalResult = bigDecimalRoundingAdapter.unmarshal("2.3");

    // Assert
    assertEquals(new BigDecimal("2.3"), actualUnmarshalResult);
  }

  /**
   * Test {@link BigDecimalRoundingAdapter#marshal(BigDecimal)} with {@code BigDecimal}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BigDecimalRoundingAdapter#marshal(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BigDecimalRoundingAdapter.marshal(BigDecimal)"})
  public void testMarshalWithBigDecimal_whenZero_thenReturn000() throws Exception {
    // Arrange, Act and Assert
    assertEquals("0.00", new BigDecimalRoundingAdapter().marshal(BankersRounding.ZERO));
  }
}
