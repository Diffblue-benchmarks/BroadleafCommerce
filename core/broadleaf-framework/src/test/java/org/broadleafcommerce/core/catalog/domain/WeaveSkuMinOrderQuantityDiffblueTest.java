package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WeaveSkuMinOrderQuantityDiffblueTest {
  /**
   * Test {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor)
   * HasMinOrderQuantity is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity_givenWeaveSkuMinOrderQuantityHasMinOrderQuantityIsNull() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setHasMinOrderQuantity(null);

    // Act and Assert
    assertFalse(weaveSkuMinOrderQuantity.hasMinOrderQuantity());
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity_givenWeaveSkuMinOrderQuantity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new WeaveSkuMinOrderQuantity()).hasMinOrderQuantity());
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity_thenReturnTrue() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setHasMinOrderQuantity(true);

    // Act and Assert
    assertTrue(weaveSkuMinOrderQuantity.hasMinOrderQuantity());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WeaveSkuMinOrderQuantity#setHasMinOrderQuantity(Boolean)}
   *   <li>{@link WeaveSkuMinOrderQuantity#setMinOrderQuantity(Integer)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     WeaveSkuMinOrderQuantity.hasMinOrderQuantity
    //     WeaveSkuMinOrderQuantity.minOrderQuantity

    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();

    // Act
    weaveSkuMinOrderQuantity.setHasMinOrderQuantity(true);
    weaveSkuMinOrderQuantity.setMinOrderQuantity(1);
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}
   */
  @Test
  public void testGetMinOrderQuantity_givenWeaveSkuMinOrderQuantity() {
    // Arrange, Act and Assert
    assertEquals(1, (new WeaveSkuMinOrderQuantity()).getMinOrderQuantity().intValue());
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor)
   * MinOrderQuantity is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}
   */
  @Test
  public void testGetMinOrderQuantity_givenWeaveSkuMinOrderQuantityMinOrderQuantityIsOne() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setMinOrderQuantity(1);

    // Act and Assert
    assertEquals(1, weaveSkuMinOrderQuantity.getMinOrderQuantity().intValue());
  }

  /**
   * Test new {@link WeaveSkuMinOrderQuantity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link WeaveSkuMinOrderQuantity}
   */
  @Test
  public void testNewWeaveSkuMinOrderQuantity() {
    // Arrange and Act
    WeaveSkuMinOrderQuantity actualWeaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();

    // Assert
    assertNull(actualWeaveSkuMinOrderQuantity.minOrderQuantity);
    assertEquals(1, actualWeaveSkuMinOrderQuantity.getMinOrderQuantity().intValue());
    assertFalse(actualWeaveSkuMinOrderQuantity.hasMinOrderQuantity);
  }
}
