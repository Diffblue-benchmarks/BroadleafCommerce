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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SimpleFulfillmentLocationResolver.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleFulfillmentLocationResolverDiffblueTest {
  @Autowired
  private SimpleFulfillmentLocationResolver simpleFulfillmentLocationResolver;

  /**
   * Test {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test: {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Address SimpleFulfillmentLocationResolver.resolveLocationForFulfillmentGroup(FulfillmentGroup)"})
  public void testResolveLocationForFulfillmentGroup() {
    // Arrange, Act and Assert
    assertNull(simpleFulfillmentLocationResolver.resolveLocationForFulfillmentGroup(new FulfillmentGroupImpl()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleFulfillmentLocationResolver}
   *   <li>{@link SimpleFulfillmentLocationResolver#setAddress(Address)}
   *   <li>{@link SimpleFulfillmentLocationResolver#getAddress()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleFulfillmentLocationResolver.<init>()",
      "Address SimpleFulfillmentLocationResolver.getAddress()",
      "void SimpleFulfillmentLocationResolver.setAddress(Address)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SimpleFulfillmentLocationResolver actualSimpleFulfillmentLocationResolver = new SimpleFulfillmentLocationResolver();
    AddressImpl address = new AddressImpl();
    actualSimpleFulfillmentLocationResolver.setAddress(address);

    // Assert
    assertSame(address, actualSimpleFulfillmentLocationResolver.getAddress());
  }
}
