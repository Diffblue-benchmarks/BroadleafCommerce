package org.broadleafcommerce.core.web.order;

import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderPersistedEvent;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class CartStateRefresherDiffblueTest {
  @Autowired
  private CartStateRefresher cartStateRefresher;

  /**
   * Test {@link CartStateRefresher#onApplicationEvent(OrderPersistedEvent)} with
   * {@code OrderPersistedEvent}.
   * <p>
   * Method under test:
   * {@link CartStateRefresher#onApplicationEvent(OrderPersistedEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(OrderPersistedEvent) with 'OrderPersistedEvent'")
  @Disabled("TODO: Complete this test")
  void testOnApplicationEventWithOrderPersistedEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7443 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.CartStateRefresher cartStateRefresher;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateRefresher cartStateRefresher2 = new CartStateRefresher();

    // Act
    cartStateRefresher2.onApplicationEvent(new OrderPersistedEvent(new NullOrderImpl()));
  }
}
