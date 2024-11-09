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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemFeePrice;
import org.junit.Test;

public class DiscreteOrderItemRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}
   *   <li>{@link DiscreteOrderItemRequest#setBundleOrderItem(BundleOrderItem)}
   *   <li>{@link DiscreteOrderItemRequest#setDiscreteOrderItemFeePrices(List)}
   *   <li>{@link DiscreteOrderItemRequest#getBundleOrderItem()}
   *   <li>{@link DiscreteOrderItemRequest#getDiscreteOrderItemFeePrices()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DiscreteOrderItemRequest actualDiscreteOrderItemRequest = new DiscreteOrderItemRequest();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    actualDiscreteOrderItemRequest.setBundleOrderItem(bundleOrderItem);
    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePrices = new ArrayList<>();
    actualDiscreteOrderItemRequest.setDiscreteOrderItemFeePrices(discreteOrderItemFeePrices);
    BundleOrderItem actualBundleOrderItem = actualDiscreteOrderItemRequest.getBundleOrderItem();
    List<DiscreteOrderItemFeePrice> actualDiscreteOrderItemFeePrices = actualDiscreteOrderItemRequest
        .getDiscreteOrderItemFeePrices();

    // Assert that nothing has changed
    assertEquals(0, actualDiscreteOrderItemRequest.getQuantity());
    assertTrue(actualDiscreteOrderItemFeePrices.isEmpty());
    assertTrue(actualDiscreteOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualDiscreteOrderItemRequest.getItemAttributes().isEmpty());
    assertSame(discreteOrderItemFeePrices, actualDiscreteOrderItemFeePrices);
    assertSame(bundleOrderItem, actualBundleOrderItem);
  }

  /**
   * Test
   * {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest(AbstractOrderItemRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest(AbstractOrderItemRequest)}
   */
  @Test
  public void testNewDiscreteOrderItemRequest_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest request = new DiscreteOrderItemRequest();
    request.setItemAttributes(itemAttributes);

    // Act and Assert
    assertEquals(request, new DiscreteOrderItemRequest(request));
  }

  /**
   * Test
   * {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest(AbstractOrderItemRequest)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest(AbstractOrderItemRequest)}
   */
  @Test
  public void testNewDiscreteOrderItemRequest_whenDiscreteOrderItemRequest() {
    // Arrange
    DiscreteOrderItemRequest request = new DiscreteOrderItemRequest();

    // Act and Assert
    assertEquals(request, new DiscreteOrderItemRequest(request));
  }

  /**
   * Test {@link DiscreteOrderItemRequest#clone()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemRequest#clone()}
   */
  @Test
  public void testClone_givenDiscreteOrderItemRequest() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest.clone());
  }

  /**
   * Test {@link DiscreteOrderItemRequest#clone()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemRequest#clone()}
   */
  @Test
  public void testClone_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest.clone());
  }
}
