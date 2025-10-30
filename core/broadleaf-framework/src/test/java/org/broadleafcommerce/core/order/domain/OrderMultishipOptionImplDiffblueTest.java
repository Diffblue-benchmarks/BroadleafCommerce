/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderMultishipOptionImplDiffblueTest {
  @Autowired
  private OrderMultishipOptionImpl orderMultishipOptionImpl;

  /**
   * Test {@link OrderMultishipOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link OrderMultishipOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse OrderMultishipOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl2 = new OrderMultishipOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderMultishipOption> actualCreateOrRetrieveCopyInstanceResult = orderMultishipOptionImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderMultishipOptionImpl}
   *   <li>{@link OrderMultishipOptionImpl#setAddress(Address)}
   *   <li>{@link OrderMultishipOptionImpl#setFulfillmentOption(FulfillmentOption)}
   *   <li>{@link OrderMultishipOptionImpl#setId(Long)}
   *   <li>{@link OrderMultishipOptionImpl#setOrder(Order)}
   *   <li>{@link OrderMultishipOptionImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderMultishipOptionImpl#getAddress()}
   *   <li>{@link OrderMultishipOptionImpl#getFulfillmentOption()}
   *   <li>{@link OrderMultishipOptionImpl#getId()}
   *   <li>{@link OrderMultishipOptionImpl#getOrder()}
   *   <li>{@link OrderMultishipOptionImpl#getOrderItem()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionImpl.<init>()", "Address OrderMultishipOptionImpl.getAddress()",
      "FulfillmentOption OrderMultishipOptionImpl.getFulfillmentOption()", "Long OrderMultishipOptionImpl.getId()",
      "Order OrderMultishipOptionImpl.getOrder()", "OrderItem OrderMultishipOptionImpl.getOrderItem()",
      "void OrderMultishipOptionImpl.setAddress(Address)",
      "void OrderMultishipOptionImpl.setFulfillmentOption(FulfillmentOption)",
      "void OrderMultishipOptionImpl.setId(Long)", "void OrderMultishipOptionImpl.setOrder(Order)",
      "void OrderMultishipOptionImpl.setOrderItem(OrderItem)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderMultishipOptionImpl actualOrderMultishipOptionImpl = new OrderMultishipOptionImpl();
    AddressImpl address = new AddressImpl();
    actualOrderMultishipOptionImpl.setAddress(address);
    FulfillmentOptionImpl fulfillmentOption = new FulfillmentOptionImpl();
    actualOrderMultishipOptionImpl.setFulfillmentOption(fulfillmentOption);
    actualOrderMultishipOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    actualOrderMultishipOptionImpl.setOrder(order);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderMultishipOptionImpl.setOrderItem(orderItem);
    Address actualAddress = actualOrderMultishipOptionImpl.getAddress();
    FulfillmentOption actualFulfillmentOption = actualOrderMultishipOptionImpl.getFulfillmentOption();
    Long actualId = actualOrderMultishipOptionImpl.getId();
    Order actualOrder = actualOrderMultishipOptionImpl.getOrder();
    OrderItem actualOrderItem = actualOrderMultishipOptionImpl.getOrderItem();

    // Assert
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
    assertSame(fulfillmentOption, actualFulfillmentOption);
    assertSame(address, actualAddress);
    assertSame(order, actualOrder);
  }
}
