package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class DefaultCustomerMergeExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link DefaultCustomerMergeExtensionHandler#merge(ExtensionResultHolder, WebRequest, Customer)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerMergeExtensionHandler#merge(ExtensionResultHolder, WebRequest, Customer)}
   */
  @Test
  @DisplayName("Test merge(ExtensionResultHolder, WebRequest, Customer)")
  void testMerge() {
    // Arrange
    DefaultCustomerMergeExtensionHandler defaultCustomerMergeExtensionHandler = new DefaultCustomerMergeExtensionHandler();

    ExtensionResultHolder<Customer> customerHolder = new ExtensionResultHolder<>();
    customerHolder.setResult(new CustomerImpl());
    customerHolder.setThrowable(new Throwable());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultCustomerMergeExtensionHandler.merge(customerHolder, request, new CustomerImpl()));
  }

  /**
   * Test new {@link DefaultCustomerMergeExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DefaultCustomerMergeExtensionHandler}
   */
  @Test
  @DisplayName("Test new DefaultCustomerMergeExtensionHandler (default constructor)")
  void testNewDefaultCustomerMergeExtensionHandler() {
    // Arrange and Act
    DefaultCustomerMergeExtensionHandler actualDefaultCustomerMergeExtensionHandler = new DefaultCustomerMergeExtensionHandler();

    // Assert
    assertEquals(0, actualDefaultCustomerMergeExtensionHandler.getPriority());
    assertTrue(actualDefaultCustomerMergeExtensionHandler.isEnabled());
  }
}
