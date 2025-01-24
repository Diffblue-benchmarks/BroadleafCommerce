package org.broadleafcommerce.core.web.order.service;

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
class CartStateServiceImplDiffblueTest {
  @Autowired
  private CartStateServiceImpl cartStateServiceImpl;

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedOrderInfo()}.
   * <p>
   * Method under test: {@link CartStateServiceImpl#cartHasPopulatedOrderInfo()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedOrderInfo()")
  @Disabled("TODO: Complete this test")
  void testCartHasPopulatedOrderInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9560 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasPopulatedOrderInfo();
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   * <p>
   * Method under test:
   * {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedBillingAddress()")
  @Disabled("TODO: Complete this test")
  void testCartHasPopulatedBillingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9559 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasPopulatedBillingAddress();
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedShippingAddress()}.
   * <p>
   * Method under test:
   * {@link CartStateServiceImpl#cartHasPopulatedShippingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedShippingAddress()")
  @Disabled("TODO: Complete this test")
  void testCartHasPopulatedShippingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9561 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasPopulatedShippingAddress();
  }

  /**
   * Test
   * {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   * <p>
   * Method under test:
   * {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String)")
  @Disabled("TODO: Complete this test")
  void testCartHasCreditCardPaymentWithSameToken() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasCreditCardPaymentWithSameToken("ABC123");
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}.
   * <p>
   * Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasTemporaryCreditCard()")
  @Disabled("TODO: Complete this test")
  void testCartHasTemporaryCreditCard() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9562 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasTemporaryCreditCard();
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPayment()}.
   * <p>
   * Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPayment()")
  @Disabled("TODO: Complete this test")
  void testCartHasCreditCardPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9299 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasCreditCardPayment();
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasThirdPartyPayment()}.
   * <p>
   * Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartHasThirdPartyPayment()")
  @Disabled("TODO: Complete this test")
  void testCartHasThirdPartyPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9563 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasThirdPartyPayment();
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   * <p>
   * Method under test:
   * {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasUnconfirmedCreditCard()")
  @Disabled("TODO: Complete this test")
  void testCartHasUnconfirmedCreditCard() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9564 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).cartHasUnconfirmedCreditCard();
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   * <p>
   * Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName("Test getUnconfirmedCCFromCart()")
  @Disabled("TODO: Complete this test")
  void testGetUnconfirmedCCFromCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9565 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.service.CartStateServiceImpl cartStateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateServiceImpl()).getUnconfirmedCCFromCart();
  }
}
