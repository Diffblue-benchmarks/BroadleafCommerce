package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;

public class DynamicSkuPricesDiffblueTest {
  /**
   * Test {@link DynamicSkuPrices#getPriceForQuantity(long)}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor) RetailPrice is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity_givenDynamicSkuPricesRetailPriceIsNull_thenReturnMoney() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(null);

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPriceForQuantity(1L));
  }

  /**
   * Test {@link DynamicSkuPrices#getPriceForQuantity(long)}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor) SalePrice is
   * {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity_givenDynamicSkuPricesSalePriceIsMoneyWithAmountIsTen() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setSalePrice(new Money(10.0d));
    Money retailPrice = new Money();
    dynamicSkuPrices.setRetailPrice(retailPrice);

    // Act and Assert
    assertSame(retailPrice, dynamicSkuPrices.getPriceForQuantity(1L));
  }

  /**
   * Test {@link DynamicSkuPrices#getPriceForQuantity(long)}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity_givenDynamicSkuPricesSalePriceIsMoney_thenReturnMoney() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(new Money());

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPriceForQuantity(1L));
  }

  /**
   * Test {@link DynamicSkuPrices#getPriceForQuantity(long)}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity_givenDynamicSkuPrices_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DynamicSkuPrices()).getPriceForQuantity(1L));
  }

  /**
   * Test {@link DynamicSkuPrices#getPrice()}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor) RetailPrice is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice_givenDynamicSkuPricesRetailPriceIsNull_thenReturnMoney() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(null);

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPrice());
  }

  /**
   * Test {@link DynamicSkuPrices#getPrice()}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor) SalePrice is
   * {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice_givenDynamicSkuPricesSalePriceIsMoneyWithAmountIsTen() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setSalePrice(new Money(10.0d));
    Money retailPrice = new Money();
    dynamicSkuPrices.setRetailPrice(retailPrice);

    // Act and Assert
    assertSame(retailPrice, dynamicSkuPrices.getPrice());
  }

  /**
   * Test {@link DynamicSkuPrices#getPrice()}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice_givenDynamicSkuPricesSalePriceIsMoney_thenReturnMoney() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(new Money());

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPrice());
  }

  /**
   * Test {@link DynamicSkuPrices#getPrice()}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice_givenDynamicSkuPrices_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DynamicSkuPrices()).getPrice());
  }

  /**
   * Test {@link DynamicSkuPrices#getDidOverride()}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor) PriceAdjustment is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getDidOverride()}
   */
  @Test
  public void testGetDidOverride_givenDynamicSkuPricesPriceAdjustmentIsMoney_thenReturnTrue() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    dynamicSkuPrices.setDidOverride(true);

    // Act and Assert
    assertTrue(dynamicSkuPrices.getDidOverride());
  }

  /**
   * Test {@link DynamicSkuPrices#getDidOverride()}.
   * <ul>
   *   <li>Given {@link DynamicSkuPrices} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSkuPrices#getDidOverride()}
   */
  @Test
  public void testGetDidOverride_givenDynamicSkuPrices_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DynamicSkuPrices()).getDidOverride());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DynamicSkuPrices}
   *   <li>{@link DynamicSkuPrices#setDidOverride(Boolean)}
   *   <li>{@link DynamicSkuPrices#setPriceAdjustment(Money)}
   *   <li>{@link DynamicSkuPrices#setRetailPrice(Money)}
   *   <li>{@link DynamicSkuPrices#setSalePrice(Money)}
   *   <li>{@link DynamicSkuPrices#getPriceAdjustment()}
   *   <li>{@link DynamicSkuPrices#getRetailPrice()}
   *   <li>{@link DynamicSkuPrices#getSalePrice()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicSkuPrices actualDynamicSkuPrices = new DynamicSkuPrices();
    actualDynamicSkuPrices.setDidOverride(true);
    Money priceAdjustment = new Money();
    actualDynamicSkuPrices.setPriceAdjustment(priceAdjustment);
    Money retailPrice = new Money();
    actualDynamicSkuPrices.setRetailPrice(retailPrice);
    Money salePrice = new Money();
    actualDynamicSkuPrices.setSalePrice(salePrice);
    Money actualPriceAdjustment = actualDynamicSkuPrices.getPriceAdjustment();
    Money actualRetailPrice = actualDynamicSkuPrices.getRetailPrice();

    // Assert that nothing has changed
    assertSame(priceAdjustment, actualPriceAdjustment);
    assertSame(retailPrice, actualRetailPrice);
    assertSame(salePrice, actualDynamicSkuPrices.getSalePrice());
  }
}
