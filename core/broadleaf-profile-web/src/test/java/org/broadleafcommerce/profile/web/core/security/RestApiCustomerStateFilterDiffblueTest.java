package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {RestApiCustomerStateFilter.class})
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class RestApiCustomerStateFilterDiffblueTest {
  @MockBean(name = "blCustomerService")
  private CustomerService customerService;

  @Autowired private RestApiCustomerStateFilter restApiCustomerStateFilter;

  /**
   * Test {@link RestApiCustomerStateFilter#getOrder()}.
   *
   * <p>Method under test: {@link RestApiCustomerStateFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RestApiCustomerStateFilter.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2000, restApiCustomerStateFilter.getOrder());
  }

  /**
   * Test {@link RestApiCustomerStateFilter#getCustomerIdAttributeName()}.
   *
   * <p>Method under test: {@link RestApiCustomerStateFilter#getCustomerIdAttributeName()}
   */
  @Test
  @DisplayName("Test getCustomerIdAttributeName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RestApiCustomerStateFilter.getCustomerIdAttributeName()"})
  void testGetCustomerIdAttributeName() {
    // Arrange, Act and Assert
    assertEquals(
        RestApiCustomerStateFilter.CUSTOMER_ID_ATTRIBUTE,
        new RestApiCustomerStateFilter().getCustomerIdAttributeName());
  }
}
