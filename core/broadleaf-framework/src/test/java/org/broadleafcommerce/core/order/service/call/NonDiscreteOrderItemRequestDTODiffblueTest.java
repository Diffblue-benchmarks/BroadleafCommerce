/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NonDiscreteOrderItemRequestDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NonDiscreteOrderItemRequestDTODiffblueTest {
  @Autowired
  private NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}
   *   <li>{@link NonDiscreteOrderItemRequestDTO#setItemName(String)}
   *   <li>{@link NonDiscreteOrderItemRequestDTO#getItemName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NonDiscreteOrderItemRequestDTO actualNonDiscreteOrderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    actualNonDiscreteOrderItemRequestDTO.setItemName("Item Name");

    // Assert that nothing has changed
    assertEquals("Item Name", actualNonDiscreteOrderItemRequestDTO.getItemName());
    assertTrue(actualNonDiscreteOrderItemRequestDTO.getChildOrderItems().isEmpty());
    assertTrue(actualNonDiscreteOrderItemRequestDTO.getAdditionalAttributes().isEmpty());
    assertTrue(actualNonDiscreteOrderItemRequestDTO.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO(String, Integer, Money)}.
   * <ul>
   *   <li>Then return OverrideRetailPrice is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO(String, Integer, Money)}
   */
  @Test
  public void testNewNonDiscreteOrderItemRequestDTO_thenReturnOverrideRetailPriceIsMoney() {
    // Arrange
    Money overrideRetailPrice = new Money();

    // Act and Assert
    assertSame(overrideRetailPrice,
        (new NonDiscreteOrderItemRequestDTO("Item Name", 1, overrideRetailPrice)).getOverrideRetailPrice());
  }

  /**
   * Test
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO(String, Integer, Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then return {@code Item Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO(String, Integer, Money)}
   */
  @Test
  public void testNewNonDiscreteOrderItemRequestDTO_whenMoney_thenReturnItemName() {
    // Arrange
    Money overrideRetailPrice = mock(Money.class);

    // Act
    NonDiscreteOrderItemRequestDTO actualNonDiscreteOrderItemRequestDTO = new NonDiscreteOrderItemRequestDTO(
        "Item Name", 1, overrideRetailPrice);

    // Assert
    assertEquals("Item Name", actualNonDiscreteOrderItemRequestDTO.getItemName());
    assertNull(actualNonDiscreteOrderItemRequestDTO.getCategoryId());
    assertNull(actualNonDiscreteOrderItemRequestDTO.getOrderItemId());
    assertNull(actualNonDiscreteOrderItemRequestDTO.getParentOrderItemId());
    assertNull(actualNonDiscreteOrderItemRequestDTO.getProductId());
    assertNull(actualNonDiscreteOrderItemRequestDTO.getSkuId());
    assertNull(actualNonDiscreteOrderItemRequestDTO.getOverrideSalePrice());
    assertEquals(1, actualNonDiscreteOrderItemRequestDTO.getQuantity().intValue());
    assertFalse(actualNonDiscreteOrderItemRequestDTO.getHasConfigurationError());
    assertTrue(actualNonDiscreteOrderItemRequestDTO.getChildOrderItems().isEmpty());
    assertTrue(actualNonDiscreteOrderItemRequestDTO.getAdditionalAttributes().isEmpty());
    assertTrue(actualNonDiscreteOrderItemRequestDTO.getItemAttributes().isEmpty());
    assertSame(overrideRetailPrice, actualNonDiscreteOrderItemRequestDTO.getOverrideRetailPrice());
  }
}
