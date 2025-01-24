package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
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
public class OfferTimeZoneProcessorImplDiffblueTest {
  @Autowired
  private OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl;

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTimeZone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3333 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl2 = new OfferTimeZoneProcessorImpl();

    // Act
    offerTimeZoneProcessorImpl2.getTimeZone(new OfferImpl());
  }

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link OfferImpl} (default constructor) QualifyingItemSubTotal is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  public void testGetTimeZone_givenMoney_whenOfferImplQualifyingItemSubTotalIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl = new OfferTimeZoneProcessorImpl();

    OfferImpl offer = new OfferImpl();
    offer.setQualifyingItemSubTotal(new Money());

    // Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(offer));
  }

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <ul>
   *   <li>When {@link Offer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  public void testGetTimeZone_whenOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferTimeZoneProcessorImpl()).getTimeZone(mock(Offer.class)));
  }

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  public void testGetTimeZone_whenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl = new OfferTimeZoneProcessorImpl();

    // Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(new OfferImpl()));
  }
}
