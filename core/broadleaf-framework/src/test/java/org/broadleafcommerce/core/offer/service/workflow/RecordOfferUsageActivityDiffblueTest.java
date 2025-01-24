package org.broadleafcommerce.core.offer.service.workflow;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
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
public class RecordOfferUsageActivityDiffblueTest {
  @Autowired
  private RecordOfferUsageActivity recordOfferUsageActivity;

  /**
   * Test {@link RecordOfferUsageActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link RecordOfferUsageActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9587 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.workflow.RecordOfferUsageActivity recordOfferUsageActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RecordOfferUsageActivity recordOfferUsageActivity2 = new RecordOfferUsageActivity(
        new RecordOfferUsageRollbackHandler());

    // Act
    recordOfferUsageActivity2.execute((ProcessContext<CheckoutSeed>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}.
   * <p>
   * Method under test:
   * {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}
   */
  @Test
  public void testSaveOfferIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RecordOfferUsageActivity recordOfferUsageActivity = new RecordOfferUsageActivity(
        mock(RecordOfferUsageRollbackHandler.class));
    HashSet<Offer> offers = new HashSet<>();
    HashMap<Offer, OfferCode> offerToCodeMapping = new HashMap<>();

    // Act and Assert
    assertTrue(recordOfferUsageActivity.saveOfferIds(offers, offerToCodeMapping, new NullOrderImpl()).isEmpty());
  }

  /**
   * Test {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}.
   * <p>
   * Method under test:
   * {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveOfferIds2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9603 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.workflow.RecordOfferUsageActivity recordOfferUsageActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RecordOfferUsageActivity recordOfferUsageActivity2 = new RecordOfferUsageActivity(
        new RecordOfferUsageRollbackHandler());
    HashSet<Offer> offers = new HashSet<>();
    HashMap<Offer, OfferCode> offerToCodeMapping = new HashMap<>();

    // Act
    recordOfferUsageActivity2.saveOfferIds(offers, offerToCodeMapping, new NullOrderImpl());
  }

  /**
   * Test {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}
   */
  @Test
  public void testSaveOfferIds_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RecordOfferUsageActivity recordOfferUsageActivity = new RecordOfferUsageActivity(
        new RecordOfferUsageRollbackHandler());
    HashSet<Offer> offers = new HashSet<>();
    HashMap<Offer, OfferCode> offerToCodeMapping = new HashMap<>();

    // Act and Assert
    assertTrue(recordOfferUsageActivity.saveOfferIds(offers, offerToCodeMapping, new NullOrderImpl()).isEmpty());
  }
}
