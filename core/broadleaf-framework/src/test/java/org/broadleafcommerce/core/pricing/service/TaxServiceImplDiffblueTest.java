package org.broadleafcommerce.core.pricing.service;

import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.exception.TaxException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TaxServiceImplDiffblueTest {
  @Autowired
  private TaxServiceImpl taxServiceImpl;

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   * <p>
   * Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTaxForOrder() throws TaxException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3561 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.TaxServiceImpl taxServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TaxServiceImpl taxServiceImpl2 = new TaxServiceImpl();

    // Act
    taxServiceImpl2.calculateTaxForOrder(new NullOrderImpl());
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   * <p>
   * Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitTaxForOrder() throws TaxException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3591 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.TaxServiceImpl taxServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TaxServiceImpl taxServiceImpl2 = new TaxServiceImpl();

    // Act
    taxServiceImpl2.commitTaxForOrder(new NullOrderImpl());
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   * <p>
   * Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCancelTax() throws TaxException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3576 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.TaxServiceImpl taxServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TaxServiceImpl taxServiceImpl2 = new TaxServiceImpl();

    // Act
    taxServiceImpl2.cancelTax(new NullOrderImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaxServiceImpl#setMustCalculate(boolean)}
   *   <li>{@link TaxServiceImpl#setTaxProviders(List)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     TaxServiceImpl.moduleConfigService
    //     TaxServiceImpl.mustCalculate
    //     TaxServiceImpl.providers

    // Arrange
    TaxServiceImpl taxServiceImpl = new TaxServiceImpl();

    // Act
    taxServiceImpl.setMustCalculate(true);
    taxServiceImpl.setTaxProviders(new ArrayList<>());
  }
}
