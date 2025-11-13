package org.broadleafcommerce.core.pricing.service.fulfillment;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private SimpleFulfillmentLocationResolver simpleFulfillmentLocationResolver;

  /**
   * Test {@link
   * SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address SimpleFulfillmentLocationResolver.resolveLocationForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testResolveLocationForFulfillmentGroup() {
    // Arrange, Act and Assert
    assertNull(
        simpleFulfillmentLocationResolver.resolveLocationForFulfillmentGroup(
            new FulfillmentGroupImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleFulfillmentLocationResolver}
   *   <li>{@link SimpleFulfillmentLocationResolver#setAddress(Address)}
   *   <li>{@link SimpleFulfillmentLocationResolver#getAddress()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleFulfillmentLocationResolver.<init>()",
    "Address SimpleFulfillmentLocationResolver.getAddress()",
    "void SimpleFulfillmentLocationResolver.setAddress(Address)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SimpleFulfillmentLocationResolver actualSimpleFulfillmentLocationResolver =
        new SimpleFulfillmentLocationResolver();
    AddressImpl address = new AddressImpl();
    actualSimpleFulfillmentLocationResolver.setAddress(address);

    // Assert
    assertSame(address, actualSimpleFulfillmentLocationResolver.getAddress());
  }
}
