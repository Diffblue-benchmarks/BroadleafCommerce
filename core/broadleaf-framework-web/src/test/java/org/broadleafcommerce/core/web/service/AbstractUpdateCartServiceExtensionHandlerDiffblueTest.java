package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.call.AddToCartItem;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
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
class AbstractUpdateCartServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractUpdateCartServiceExtensionHandler abstractUpdateCartServiceExtensionHandler;

  /**
   * Test
   * {@link AbstractUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order, ExtensionResultHolder)")
  void testUpdateAndValidateCart() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(cart, resultHolder));
  }

  /**
   * Test
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}.
   * <p>
   * Method under test:
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}
   */
  @Test
  @DisplayName("Test validateAddToCartItem(OrderItemRequestDTO, Order)")
  @Disabled("TODO: Complete this test")
  void testValidateAddToCartItem() throws IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3226 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.AbstractUpdateCartServiceExtensionHandler abstractUpdateCartServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act
    i18nUpdateCartServiceExtensionHandler.validateAddToCartItem(itemRequest, new NullOrderImpl());
  }

  /**
   * Test
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}.
   * <ul>
   *   <li>When {@link AddToCartItem}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}
   */
  @Test
  @DisplayName("Test validateAddToCartItem(OrderItemRequestDTO, Order); when AddToCartItem")
  void testValidateAddToCartItem_whenAddToCartItem() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    AddToCartItem itemRequest = mock(AddToCartItem.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nUpdateCartServiceExtensionHandler.validateAddToCartItem(itemRequest, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}
   */
  @Test
  @DisplayName("Test validateAddToCartItem(OrderItemRequestDTO, Order); when OrderItemRequestDTO()")
  void testValidateAddToCartItem_whenOrderItemRequestDTO() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nUpdateCartServiceExtensionHandler.validateAddToCartItem(itemRequest, new NullOrderImpl()));
  }
}
