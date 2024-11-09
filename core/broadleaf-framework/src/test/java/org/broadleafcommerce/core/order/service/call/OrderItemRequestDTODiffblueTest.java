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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;

public class OrderItemRequestDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemRequestDTO#OrderItemRequestDTO()}
   *   <li>{@link OrderItemRequestDTO#setAdditionalAttributes(Map)}
   *   <li>{@link OrderItemRequestDTO#setCategoryId(Long)}
   *   <li>{@link OrderItemRequestDTO#setChildOrderItems(List)}
   *   <li>{@link OrderItemRequestDTO#setHasConfigurationError(Boolean)}
   *   <li>{@link OrderItemRequestDTO#setItemAttributes(Map)}
   *   <li>{@link OrderItemRequestDTO#setOrderItemId(Long)}
   *   <li>{@link OrderItemRequestDTO#setOverrideRetailPrice(Money)}
   *   <li>{@link OrderItemRequestDTO#setOverrideSalePrice(Money)}
   *   <li>{@link OrderItemRequestDTO#setParentOrderItemId(Long)}
   *   <li>{@link OrderItemRequestDTO#setProductId(Long)}
   *   <li>{@link OrderItemRequestDTO#setQuantity(Integer)}
   *   <li>{@link OrderItemRequestDTO#setSkuId(Long)}
   *   <li>{@link OrderItemRequestDTO#getAdditionalAttributes()}
   *   <li>{@link OrderItemRequestDTO#getCategoryId()}
   *   <li>{@link OrderItemRequestDTO#getChildOrderItems()}
   *   <li>{@link OrderItemRequestDTO#getItemAttributes()}
   *   <li>{@link OrderItemRequestDTO#getOrderItemId()}
   *   <li>{@link OrderItemRequestDTO#getOverrideRetailPrice()}
   *   <li>{@link OrderItemRequestDTO#getOverrideSalePrice()}
   *   <li>{@link OrderItemRequestDTO#getParentOrderItemId()}
   *   <li>{@link OrderItemRequestDTO#getProductId()}
   *   <li>{@link OrderItemRequestDTO#getQuantity()}
   *   <li>{@link OrderItemRequestDTO#getSkuId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemRequestDTO actualOrderItemRequestDTO = new OrderItemRequestDTO();
    HashMap<String, String> additionalAttributes = new HashMap<>();
    actualOrderItemRequestDTO.setAdditionalAttributes(additionalAttributes);
    OrderItemRequestDTO actualSetCategoryIdResult = actualOrderItemRequestDTO.setCategoryId(1L);
    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    actualOrderItemRequestDTO.setChildOrderItems(childOrderItems);
    actualOrderItemRequestDTO.setHasConfigurationError(true);
    HashMap<String, String> itemAttributes = new HashMap<>();
    OrderItemRequestDTO actualSetItemAttributesResult = actualOrderItemRequestDTO.setItemAttributes(itemAttributes);
    OrderItemRequestDTO actualSetOrderItemIdResult = actualOrderItemRequestDTO.setOrderItemId(1L);
    Money overrideRetailPrice = new Money();
    actualOrderItemRequestDTO.setOverrideRetailPrice(overrideRetailPrice);
    Money overrideSalePrice = new Money();
    actualOrderItemRequestDTO.setOverrideSalePrice(overrideSalePrice);
    actualOrderItemRequestDTO.setParentOrderItemId(1L);
    OrderItemRequestDTO actualSetProductIdResult = actualOrderItemRequestDTO.setProductId(1L);
    OrderItemRequestDTO actualSetQuantityResult = actualOrderItemRequestDTO.setQuantity(1);
    OrderItemRequestDTO actualSetSkuIdResult = actualOrderItemRequestDTO.setSkuId(1L);
    Map<String, String> actualAdditionalAttributes = actualOrderItemRequestDTO.getAdditionalAttributes();
    Long actualCategoryId = actualOrderItemRequestDTO.getCategoryId();
    List<OrderItemRequestDTO> actualChildOrderItems = actualOrderItemRequestDTO.getChildOrderItems();
    Map<String, String> actualItemAttributes = actualOrderItemRequestDTO.getItemAttributes();
    Long actualOrderItemId = actualOrderItemRequestDTO.getOrderItemId();
    Money actualOverrideRetailPrice = actualOrderItemRequestDTO.getOverrideRetailPrice();
    Money actualOverrideSalePrice = actualOrderItemRequestDTO.getOverrideSalePrice();
    Long actualParentOrderItemId = actualOrderItemRequestDTO.getParentOrderItemId();
    Long actualProductId = actualOrderItemRequestDTO.getProductId();
    Integer actualQuantity = actualOrderItemRequestDTO.getQuantity();
    Long actualSkuId = actualOrderItemRequestDTO.getSkuId();

    // Assert that nothing has changed
    assertEquals(1, actualQuantity.intValue());
    assertEquals(1L, actualCategoryId.longValue());
    assertEquals(1L, actualOrderItemId.longValue());
    assertEquals(1L, actualParentOrderItemId.longValue());
    assertEquals(1L, actualProductId.longValue());
    assertEquals(1L, actualSkuId.longValue());
    assertTrue(actualChildOrderItems.isEmpty());
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertTrue(actualItemAttributes.isEmpty());
    assertSame(childOrderItems, actualChildOrderItems);
    assertSame(additionalAttributes, actualAdditionalAttributes);
    assertSame(itemAttributes, actualItemAttributes);
    assertSame(overrideRetailPrice, actualOverrideRetailPrice);
    assertSame(overrideSalePrice, actualOverrideSalePrice);
    assertSame(actualOrderItemRequestDTO, actualSetCategoryIdResult);
    assertSame(actualOrderItemRequestDTO, actualSetItemAttributesResult);
    assertSame(actualOrderItemRequestDTO, actualSetOrderItemIdResult);
    assertSame(actualOrderItemRequestDTO, actualSetProductIdResult);
    assertSame(actualOrderItemRequestDTO, actualSetQuantityResult);
    assertSame(actualOrderItemRequestDTO, actualSetSkuIdResult);
  }

  /**
   * Test {@link OrderItemRequestDTO#OrderItemRequestDTO(Long, Integer)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestDTO#OrderItemRequestDTO(Long, Integer)}
   */
  @Test
  public void testNewOrderItemRequestDTO() {
    // Arrange and Act
    OrderItemRequestDTO actualOrderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Assert
    assertNull(actualOrderItemRequestDTO.getCategoryId());
    assertNull(actualOrderItemRequestDTO.getOrderItemId());
    assertNull(actualOrderItemRequestDTO.getParentOrderItemId());
    assertNull(actualOrderItemRequestDTO.getSkuId());
    assertNull(actualOrderItemRequestDTO.getOverrideRetailPrice());
    assertNull(actualOrderItemRequestDTO.getOverrideSalePrice());
    assertEquals(1, actualOrderItemRequestDTO.getQuantity().intValue());
    assertEquals(1L, actualOrderItemRequestDTO.getProductId().longValue());
    assertFalse(actualOrderItemRequestDTO.getHasConfigurationError());
    assertTrue(actualOrderItemRequestDTO.getChildOrderItems().isEmpty());
    assertTrue(actualOrderItemRequestDTO.getAdditionalAttributes().isEmpty());
    assertTrue(actualOrderItemRequestDTO.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemRequestDTO#OrderItemRequestDTO(Long, Long, Integer)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestDTO#OrderItemRequestDTO(Long, Long, Integer)}
   */
  @Test
  public void testNewOrderItemRequestDTO2() {
    // Arrange and Act
    OrderItemRequestDTO actualOrderItemRequestDTO = new OrderItemRequestDTO(1L, 1L, 1);

    // Assert
    assertNull(actualOrderItemRequestDTO.getCategoryId());
    assertNull(actualOrderItemRequestDTO.getOrderItemId());
    assertNull(actualOrderItemRequestDTO.getParentOrderItemId());
    assertNull(actualOrderItemRequestDTO.getOverrideRetailPrice());
    assertNull(actualOrderItemRequestDTO.getOverrideSalePrice());
    assertEquals(1, actualOrderItemRequestDTO.getQuantity().intValue());
    assertEquals(1L, actualOrderItemRequestDTO.getProductId().longValue());
    assertEquals(1L, actualOrderItemRequestDTO.getSkuId().longValue());
    assertFalse(actualOrderItemRequestDTO.getHasConfigurationError());
    assertTrue(actualOrderItemRequestDTO.getChildOrderItems().isEmpty());
    assertTrue(actualOrderItemRequestDTO.getAdditionalAttributes().isEmpty());
    assertTrue(actualOrderItemRequestDTO.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemRequestDTO#OrderItemRequestDTO(Long, Long, Long, Integer)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestDTO#OrderItemRequestDTO(Long, Long, Long, Integer)}
   */
  @Test
  public void testNewOrderItemRequestDTO3() {
    // Arrange and Act
    OrderItemRequestDTO actualOrderItemRequestDTO = new OrderItemRequestDTO(1L, 1L, 1L, 1);

    // Assert
    assertNull(actualOrderItemRequestDTO.getOrderItemId());
    assertNull(actualOrderItemRequestDTO.getParentOrderItemId());
    assertNull(actualOrderItemRequestDTO.getOverrideRetailPrice());
    assertNull(actualOrderItemRequestDTO.getOverrideSalePrice());
    assertEquals(1, actualOrderItemRequestDTO.getQuantity().intValue());
    assertEquals(1L, actualOrderItemRequestDTO.getCategoryId().longValue());
    assertEquals(1L, actualOrderItemRequestDTO.getProductId().longValue());
    assertEquals(1L, actualOrderItemRequestDTO.getSkuId().longValue());
    assertFalse(actualOrderItemRequestDTO.getHasConfigurationError());
    assertTrue(actualOrderItemRequestDTO.getChildOrderItems().isEmpty());
    assertTrue(actualOrderItemRequestDTO.getAdditionalAttributes().isEmpty());
    assertTrue(actualOrderItemRequestDTO.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemRequestDTO#getHasConfigurationError()}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestDTO#getHasConfigurationError()}
   */
  @Test
  public void testGetHasConfigurationError_givenOrderItemRequestDTO_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderItemRequestDTO()).getHasConfigurationError());
  }

  /**
   * Test {@link OrderItemRequestDTO#getHasConfigurationError()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestDTO#getHasConfigurationError()}
   */
  @Test
  public void testGetHasConfigurationError_thenReturnTrue() {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setHasConfigurationError(true);

    // Act and Assert
    assertTrue(orderItemRequestDTO.getHasConfigurationError());
  }
}
