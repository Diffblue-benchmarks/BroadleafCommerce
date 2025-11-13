package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderMultishipOptionImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderMultishipOptionImpl.<init>()",
    "Address OrderMultishipOptionImpl.getAddress()",
    "FulfillmentOption OrderMultishipOptionImpl.getFulfillmentOption()",
    "Long OrderMultishipOptionImpl.getId()",
    "Order OrderMultishipOptionImpl.getOrder()",
    "OrderItem OrderMultishipOptionImpl.getOrderItem()",
    "void OrderMultishipOptionImpl.setAddress(Address)",
    "void OrderMultishipOptionImpl.setFulfillmentOption(FulfillmentOption)",
    "void OrderMultishipOptionImpl.setId(Long)",
    "void OrderMultishipOptionImpl.setOrder(Order)",
    "void OrderMultishipOptionImpl.setOrderItem(OrderItem)"
  })
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
    FulfillmentOption actualFulfillmentOption =
        actualOrderMultishipOptionImpl.getFulfillmentOption();
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
