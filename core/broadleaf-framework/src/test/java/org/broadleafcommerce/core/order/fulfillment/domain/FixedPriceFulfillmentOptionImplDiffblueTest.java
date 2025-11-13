package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FixedPriceFulfillmentOptionImplDiffblueTest {
  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(null);
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setCurrency(currency);
    fixedPriceFulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl2.setId(1L);
    fixedPriceFulfillmentOptionImpl2.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl2.setName("Name");
    fixedPriceFulfillmentOptionImpl2.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl2.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl2.setTaxable(true);
    fixedPriceFulfillmentOptionImpl2.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fixedPriceFulfillmentOptionImpl, fixedPriceFulfillmentOptionImpl2);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(null);
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(null);
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setCurrency(currency);
    fixedPriceFulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl2.setId(1L);
    fixedPriceFulfillmentOptionImpl2.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl2.setName("Name");
    fixedPriceFulfillmentOptionImpl2.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl2.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl2.setTaxable(true);
    fixedPriceFulfillmentOptionImpl2.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fixedPriceFulfillmentOptionImpl, fixedPriceFulfillmentOptionImpl2);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fixedPriceFulfillmentOptionImpl, null);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertEquals(fixedPriceFulfillmentOptionImpl, fixedPriceFulfillmentOptionImpl);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(
        fixedPriceFulfillmentOptionImpl, "Different type to FixedPriceFulfillmentOptionImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FixedPriceFulfillmentOptionImpl}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#getCurrency()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FixedPriceFulfillmentOptionImpl.<init>()",
    "BroadleafCurrency FixedPriceFulfillmentOptionImpl.getCurrency()",
    "void FixedPriceFulfillmentOptionImpl.setCurrency(BroadleafCurrency)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FixedPriceFulfillmentOptionImpl actualFixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    actualFixedPriceFulfillmentOptionImpl.setCurrency(currency);
    BroadleafCurrency actualCurrency = actualFixedPriceFulfillmentOptionImpl.getCurrency();

    // Assert
    assertNull(actualFixedPriceFulfillmentOptionImpl.getId());
    assertNull(actualFixedPriceFulfillmentOptionImpl.getTaxCode());
    assertFalse(actualFixedPriceFulfillmentOptionImpl.getTaxable());
    assertTrue(actualFixedPriceFulfillmentOptionImpl.getUseFlatRates());
    assertSame(currency, actualCurrency);
  }
}
