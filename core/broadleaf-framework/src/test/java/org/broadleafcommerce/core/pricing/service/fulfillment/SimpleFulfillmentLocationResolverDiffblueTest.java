package org.broadleafcommerce.core.pricing.service.fulfillment;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext-entity.xml", "/bl-framework-applicationContext-persistence.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleFulfillmentLocationResolverDiffblueTest {
  @Autowired
  private SimpleFulfillmentLocationResolver simpleFulfillmentLocationResolver;

  /**
   * Test
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveLocationForFulfillmentGroup() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service.fulfillment;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3606 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.fulfillment.SimpleFulfillmentLocationResolver simpleFulfillmentLocationResolver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    simpleFulfillmentLocationResolver.resolveLocationForFulfillmentGroup(new FulfillmentGroupImpl());
  }

  /**
   * Test
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testResolveLocationForFulfillmentGroup_whenFulfillmentGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleFulfillmentLocationResolver simpleFulfillmentLocationResolver = new SimpleFulfillmentLocationResolver();

    // Act and Assert
    assertNull(simpleFulfillmentLocationResolver.resolveLocationForFulfillmentGroup(new FulfillmentGroupImpl()));
  }

  /**
   * Test
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleFulfillmentLocationResolver#resolveLocationForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testResolveLocationForFulfillmentGroup_whenFulfillmentGroupImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new SimpleFulfillmentLocationResolver()).resolveLocationForFulfillmentGroup(mock(FulfillmentGroupImpl.class)));
  }

  /**
   * Test getters and setters.
   * <p>
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
}
