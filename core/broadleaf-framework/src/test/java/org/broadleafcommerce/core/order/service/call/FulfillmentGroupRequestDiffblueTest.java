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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;

public class FulfillmentGroupRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentGroupRequest}
   *   <li>{@link FulfillmentGroupRequest#setAddress(Address)}
   *   <li>{@link FulfillmentGroupRequest#setFulfillmentGroupItemRequests(List)}
   *   <li>{@link FulfillmentGroupRequest#setFulfillmentType(FulfillmentType)}
   *   <li>{@link FulfillmentGroupRequest#setMethod(String)}
   *   <li>{@link FulfillmentGroupRequest#setOption(FulfillmentOption)}
   *   <li>{@link FulfillmentGroupRequest#setOrder(Order)}
   *   <li>{@link FulfillmentGroupRequest#setPhone(Phone)}
   *   <li>{@link FulfillmentGroupRequest#setService(String)}
   *   <li>{@link FulfillmentGroupRequest#getAddress()}
   *   <li>{@link FulfillmentGroupRequest#getFulfillmentGroupItemRequests()}
   *   <li>{@link FulfillmentGroupRequest#getFulfillmentType()}
   *   <li>{@link FulfillmentGroupRequest#getMethod()}
   *   <li>{@link FulfillmentGroupRequest#getOption()}
   *   <li>{@link FulfillmentGroupRequest#getOrder()}
   *   <li>{@link FulfillmentGroupRequest#getPhone()}
   *   <li>{@link FulfillmentGroupRequest#getService()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupRequest actualFulfillmentGroupRequest = new FulfillmentGroupRequest();
    AddressImpl address = new AddressImpl();
    actualFulfillmentGroupRequest.setAddress(address);
    ArrayList<FulfillmentGroupItemRequest> fulfillmentGroupItemRequests = new ArrayList<>();
    actualFulfillmentGroupRequest.setFulfillmentGroupItemRequests(fulfillmentGroupItemRequests);
    actualFulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    actualFulfillmentGroupRequest.setMethod("Method");
    FulfillmentOptionImpl option = new FulfillmentOptionImpl();
    actualFulfillmentGroupRequest.setOption(option);
    NullOrderImpl order = new NullOrderImpl();
    actualFulfillmentGroupRequest.setOrder(order);
    PhoneImpl phone = new PhoneImpl();
    actualFulfillmentGroupRequest.setPhone(phone);
    actualFulfillmentGroupRequest.setService("Service");
    Address actualAddress = actualFulfillmentGroupRequest.getAddress();
    List<FulfillmentGroupItemRequest> actualFulfillmentGroupItemRequests = actualFulfillmentGroupRequest
        .getFulfillmentGroupItemRequests();
    FulfillmentType actualFulfillmentType = actualFulfillmentGroupRequest.getFulfillmentType();
    String actualMethod = actualFulfillmentGroupRequest.getMethod();
    FulfillmentOption actualOption = actualFulfillmentGroupRequest.getOption();
    Order actualOrder = actualFulfillmentGroupRequest.getOrder();
    Phone actualPhone = actualFulfillmentGroupRequest.getPhone();

    // Assert that nothing has changed
    assertTrue(actualPhone instanceof PhoneImpl);
    assertEquals("Method", actualMethod);
    assertEquals("Service", actualFulfillmentGroupRequest.getService());
    assertTrue(actualFulfillmentGroupItemRequests.isEmpty());
    assertSame(fulfillmentGroupItemRequests, actualFulfillmentGroupItemRequests);
    assertSame(option, actualOption);
    assertSame(order, actualOrder);
    assertSame(address, actualAddress);
    assertSame(phone, actualPhone);
    assertSame(actualFulfillmentType.DIGITAL, actualFulfillmentType);
  }
}
