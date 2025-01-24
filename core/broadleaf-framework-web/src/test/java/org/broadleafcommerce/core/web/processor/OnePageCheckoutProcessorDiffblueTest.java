package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
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
class OnePageCheckoutProcessorDiffblueTest {
  @Autowired
  private OnePageCheckoutProcessor onePageCheckoutProcessor;

  /**
   * Test {@link OnePageCheckoutProcessor#getName()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("one_page_checkout", (new OnePageCheckoutProcessor()).getName());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new OnePageCheckoutProcessor()).getPrecedence());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Disabled("TODO: Complete this test")
  void testGetPrecedence2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10870 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OnePageCheckoutProcessor()).getPrecedence();
  }

  /**
   * Test {@link OnePageCheckoutProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#useGlobalScope()}
   */
  @Test
  @DisplayName("Test useGlobalScope()")
  void testUseGlobalScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OnePageCheckoutProcessor()).useGlobalScope());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#useGlobalScope()}
   */
  @Test
  @DisplayName("Test useGlobalScope()")
  @Disabled("TODO: Complete this test")
  void testUseGlobalScope2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11261 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OnePageCheckoutProcessor()).useGlobalScope();
  }

  /**
   * Test
   * {@link OnePageCheckoutProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testPopulateModelVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10917 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();

    // Act
    onePageCheckoutProcessor2.populateModelVariables("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link OnePageCheckoutProcessor#prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)}
   */
  @Test
  @DisplayName("Test prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)")
  @Disabled("TODO: Complete this test")
  void testPrepopulateCheckoutForms() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10954 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();
    NullOrderImpl cart = new NullOrderImpl();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");
    ShippingInfoForm shippingForm = new ShippingInfoForm();

    BillingInfoForm billingForm = new BillingInfoForm();
    billingForm.setAddress(new AddressImpl());
    billingForm.setCustomerPayment(new CustomerPaymentImpl());
    billingForm.setCustomerPaymentId(1L);
    billingForm.setPaymentName("Payment Name");
    billingForm.setSaveNewPayment(true);
    billingForm.setUseCustomerPayment(true);
    billingForm.setUseShippingAddress(true);

    // Act
    onePageCheckoutProcessor2.prepopulateCheckoutForms(cart, orderInfoForm, shippingForm, billingForm);
  }

  /**
   * Test
   * {@link OnePageCheckoutProcessor#calculateNumShippableFulfillmentGroups()}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#calculateNumShippableFulfillmentGroups()}
   */
  @Test
  @DisplayName("Test calculateNumShippableFulfillmentGroups()")
  @Disabled("TODO: Complete this test")
  void testCalculateNumShippableFulfillmentGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10869 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OnePageCheckoutProcessor()).calculateNumShippableFulfillmentGroups();
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateProcessingError(Map)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#populateProcessingError(Map)}
   */
  @Test
  @DisplayName("Test populateProcessingError(Map)")
  @Disabled("TODO: Complete this test")
  void testPopulateProcessingError() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10938 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();

    // Act
    onePageCheckoutProcessor2.populateProcessingError(new HashMap<>());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateSectionViewStates(Map)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#populateSectionViewStates(Map)}
   */
  @Test
  @DisplayName("Test populateSectionViewStates(Map)")
  @Disabled("TODO: Complete this test")
  void testPopulateSectionViewStates() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10946 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();

    // Act
    onePageCheckoutProcessor2.populateSectionViewStates(new HashMap<>());
  }

  /**
   * Test
   * {@link OnePageCheckoutProcessor#populateFulfillmentOptionsAndEstimationOnModel(Map)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#populateFulfillmentOptionsAndEstimationOnModel(Map)}
   */
  @Test
  @DisplayName("Test populateFulfillmentOptionsAndEstimationOnModel(Map)")
  @Disabled("TODO: Complete this test")
  void testPopulateFulfillmentOptionsAndEstimationOnModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10909 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();

    // Act
    onePageCheckoutProcessor2.populateFulfillmentOptionsAndEstimationOnModel(new HashMap<>());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedOrderInfo(Order)")
  @Disabled("TODO: Complete this test")
  void testHasPopulatedOrderInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10883 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();

    // Act
    onePageCheckoutProcessor2.hasPopulatedOrderInfo(new NullOrderImpl());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedBillingAddress(Order)")
  @Disabled("TODO: Complete this test")
  void testHasPopulatedBillingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10871 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();

    // Act
    onePageCheckoutProcessor2.hasPopulatedBillingAddress(new NullOrderImpl());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedShippingAddress(Order)")
  @Disabled("TODO: Complete this test")
  void testHasPopulatedShippingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10895 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OnePageCheckoutProcessor onePageCheckoutProcessor2 = new OnePageCheckoutProcessor();

    // Act
    onePageCheckoutProcessor2.hasPopulatedShippingAddress(new NullOrderImpl());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationMonths()}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#populateExpirationMonths()}
   */
  @Test
  @DisplayName("Test populateExpirationMonths()")
  void testPopulateExpirationMonths() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<String> actualPopulateExpirationMonthsResult = (new OnePageCheckoutProcessor()).populateExpirationMonths();

    // Assert
    assertEquals(12, actualPopulateExpirationMonthsResult.size());
    assertEquals("01 - January", actualPopulateExpirationMonthsResult.get(0));
    assertEquals("02 - February", actualPopulateExpirationMonthsResult.get(1));
    assertEquals("03 - March", actualPopulateExpirationMonthsResult.get(2));
    assertEquals("04 - April", actualPopulateExpirationMonthsResult.get(3));
    assertEquals("05 - May", actualPopulateExpirationMonthsResult.get(4));
    assertEquals("06 - June", actualPopulateExpirationMonthsResult.get(5));
    assertEquals("07 - July", actualPopulateExpirationMonthsResult.get(6));
    assertEquals("08 - August", actualPopulateExpirationMonthsResult.get(7));
    assertEquals("09 - September", actualPopulateExpirationMonthsResult.get(8));
    assertEquals("10 - October", actualPopulateExpirationMonthsResult.get(9));
    assertEquals("11 - November", actualPopulateExpirationMonthsResult.get(10));
    assertEquals("12 - December", actualPopulateExpirationMonthsResult.get(11));
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationMonths()}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#populateExpirationMonths()}
   */
  @Test
  @DisplayName("Test populateExpirationMonths()")
  @Disabled("TODO: Complete this test")
  void testPopulateExpirationMonths2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10907 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OnePageCheckoutProcessor()).populateExpirationMonths();
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationYears()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#populateExpirationYears()}
   */
  @Test
  @DisplayName("Test populateExpirationYears()")
  void testPopulateExpirationYears() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10, (new OnePageCheckoutProcessor()).populateExpirationYears().size());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationYears()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#populateExpirationYears()}
   */
  @Test
  @DisplayName("Test populateExpirationYears()")
  @Disabled("TODO: Complete this test")
  void testPopulateExpirationYears2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10908 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.OnePageCheckoutProcessor onePageCheckoutProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OnePageCheckoutProcessor()).populateExpirationYears();
  }
}
