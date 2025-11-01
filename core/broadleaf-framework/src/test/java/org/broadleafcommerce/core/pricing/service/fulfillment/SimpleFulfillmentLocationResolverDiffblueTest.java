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
package org.broadleafcommerce.core.pricing.service.fulfillment;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;

public class SimpleFulfillmentLocationResolverDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SimpleFulfillmentLocationResolver}
   *   <li>{@link SimpleFulfillmentLocationResolver#setAddress(Address)}
   *   <li>{@link SimpleFulfillmentLocationResolver#getAddress()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SimpleFulfillmentLocationResolver actualSimpleFulfillmentLocationResolver = new SimpleFulfillmentLocationResolver();
    AddressImpl address = new AddressImpl();
    actualSimpleFulfillmentLocationResolver.setAddress(address);

    // Assert that nothing has changed
    assertSame(address, actualSimpleFulfillmentLocationResolver.getAddress());
  }

  /**
   * Method under test:
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testResolveLocationForFulfillmentGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleFulfillmentLocationResolver simpleFulfillmentLocationResolver = new SimpleFulfillmentLocationResolver();

    // Act and Assert
    assertNull(simpleFulfillmentLocationResolver.resolveLocationForFulfillmentGroup(new FulfillmentGroupImpl()));
  }

  /**
   * Method under test:
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testResolveLocationForFulfillmentGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new SimpleFulfillmentLocationResolver()).resolveLocationForFulfillmentGroup(mock(FulfillmentGroupImpl.class)));
  }
}
