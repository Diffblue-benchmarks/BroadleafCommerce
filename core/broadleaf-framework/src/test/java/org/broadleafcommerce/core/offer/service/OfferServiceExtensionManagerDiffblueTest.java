package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferServiceExtensionManagerDiffblueTest {
  @Autowired
  private OfferServiceExtensionManager offerServiceExtensionManager;

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult = offerServiceExtensionManager
        .applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult = offerServiceExtensionManager
        .applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult = offerServiceExtensionManager
        .applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAdditionalFilters7() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6630 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    offerServiceExtensionManager2.applyAdditionalFilters(offers, new NullOrderImpl());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_givenOfferServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager} (default constructor).</li>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_givenOfferServiceExtensionManager_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(new ArrayList<>(), mock(NullOrderImpl.class)));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult = offerServiceExtensionManager
        .buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult = offerServiceExtensionManager
        .buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult = offerServiceExtensionManager
        .buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildOfferCodeListForCustomer7() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6883 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    // Act
    offerServiceExtensionManager2.buildOfferCodeListForCustomer(customer, new ArrayList<>());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_givenOfferServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_whenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#calculatePotentialSavings(PromotableCandidateItemOffer, PromotableOrderItem, int, Map)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#calculatePotentialSavings(PromotableCandidateItemOffer, PromotableOrderItem, int, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePotentialSavings() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6917 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl item = new PromotableOrderItemImpl(orderItem, promotableOrder2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    offerServiceExtensionManager2.calculatePotentialSavings(itemOffer, item, 1, new HashMap<>());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyItemOffer(PromotableOrder, PromotableCandidateItemOffer, Map)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyItemOffer(PromotableOrder, PromotableCandidateItemOffer, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyItemOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6759 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    offerServiceExtensionManager2.applyItemOffer(order2, itemOffer, new HashMap<>());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#chooseSaleOrRetailAdjustments(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#chooseSaleOrRetailAdjustments(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7114 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    offerServiceExtensionManager2.chooseSaleOrRetailAdjustments(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}
   */
  @Test
  public void testCreateOrderItemPriceDetailAdjustment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());

    ExtensionResultHolder<?> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, offerServiceExtensionManager
        .createOrderItemPriceDetailAdjustment(resultHolder, new OrderItemPriceDetailImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}
   */
  @Test
  public void testCreateOrderItemPriceDetailAdjustment2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());

    ExtensionResultHolder<?> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, offerServiceExtensionManager
        .createOrderItemPriceDetailAdjustment(resultHolder, new OrderItemPriceDetailImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrderItemPriceDetailAdjustment3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7146 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();

    ExtensionResultHolder<?> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act
    offerServiceExtensionManager2.createOrderItemPriceDetailAdjustment(resultHolder, new OrderItemPriceDetailImpl());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}.
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}
   */
  @Test
  public void testCreateOrderItemPriceDetailAdjustment_givenOfferServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ExtensionResultHolder<?> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, offerServiceExtensionManager
        .createOrderItemPriceDetailAdjustment(resultHolder, new OrderItemPriceDetailImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}
   */
  @Test
  public void testCreateOrderItemPriceDetailAdjustment_thenCallsSetResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ExtensionResultHolder<?> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualCreateOrderItemPriceDetailAdjustmentResult = offerServiceExtensionManager
        .createOrderItemPriceDetailAdjustment(resultHolder, new OrderItemPriceDetailImpl());

    // Assert
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualCreateOrderItemPriceDetailAdjustmentResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#applyAdditionalRuleVariablesForItemOfferEvaluation(PromotableOrderItem, HashMap)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalRuleVariablesForItemOfferEvaluation(PromotableOrderItem, HashMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAdditionalRuleVariablesForItemOfferEvaluation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6650 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl orderItem2 = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    offerServiceExtensionManager2.applyAdditionalRuleVariablesForItemOfferEvaluation(orderItem2, new HashMap<>());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult = offerServiceExtensionManager
        .addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).addAdditionalOffersForCode(isA(List.class),
        isA(OfferCode.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult = offerServiceExtensionManager
        .addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).addAdditionalOffersForCode(isA(List.class),
        isA(OfferCode.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult = offerServiceExtensionManager
        .addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddAdditionalOffersForCode7() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6608 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    offerServiceExtensionManager2.addAdditionalOffersForCode(offers, new OfferCodeImpl());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_givenOfferServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>When {@link OfferCodeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_whenOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(new ArrayList<>(), mock(OfferCodeImpl.class)));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(Mockito.<OfferCode>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult = offerServiceExtensionManager
        .removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).removeOfferCodeFromOrder(isA(OfferCode.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(Mockito.<OfferCode>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult = offerServiceExtensionManager
        .removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).removeOfferCodeFromOrder(isA(OfferCode.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult = offerServiceExtensionManager
        .removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveOfferCodeFromOrder6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7208 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    offerServiceExtensionManager2.removeOfferCodeFromOrder(offerCode, new NullOrderImpl());
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder_givenOfferServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager} (default constructor).</li>
   *   <li>When {@link OfferCodeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder_givenOfferServiceExtensionManager_whenOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OfferServiceExtensionManager()).isEnabled());
  }
}
