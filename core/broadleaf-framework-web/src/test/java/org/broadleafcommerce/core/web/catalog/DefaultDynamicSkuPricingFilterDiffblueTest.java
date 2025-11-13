package org.broadleafcommerce.core.web.catalog;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.ServletRequest;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPricingService;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultDynamicSkuPricingFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultDynamicSkuPricingFilterDiffblueTest {
  @MockBean(name = "blCustomerState")
  private CustomerState customerState;

  @Autowired private DefaultDynamicSkuPricingFilter defaultDynamicSkuPricingFilter;

  @MockBean(name = "blDynamicSkuPricingService")
  private DynamicSkuPricingService dynamicSkuPricingService;

  /**
   * Test {@link DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicSkuPricingService DefaultDynamicSkuPricingFilter.getDynamicSkuPricingService(ServletRequest)"
  })
  public void testGetDynamicSkuPricingService() {
    // Arrange and Act
    DynamicSkuPricingService actualDynamicSkuPricingService =
        defaultDynamicSkuPricingFilter.getDynamicSkuPricingService(new MockHttpServletRequest());

    // Assert
    assertSame(defaultDynamicSkuPricingFilter.skuPricingService, actualDynamicSkuPricingService);
  }

  /**
   * Test new {@link DefaultDynamicSkuPricingFilter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DefaultDynamicSkuPricingFilter}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingFilter.<init>()"})
  public void testNewDefaultDynamicSkuPricingFilter() {
    // Arrange and Act
    DefaultDynamicSkuPricingFilter actualDefaultDynamicSkuPricingFilter =
        new DefaultDynamicSkuPricingFilter();

    // Assert
    assertNull(actualDefaultDynamicSkuPricingFilter.skuPricingService);
    assertNull(actualDefaultDynamicSkuPricingFilter.customerState);
  }
}
