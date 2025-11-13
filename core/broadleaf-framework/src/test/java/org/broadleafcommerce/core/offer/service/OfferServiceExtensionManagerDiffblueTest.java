package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferServiceExtensionManager.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferServiceExtensionManagerDiffblueTest {
  @Autowired private OfferServiceExtensionManager offerServiceExtensionManager;

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters2() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters3() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.applyAdditionalFilters(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult =
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler)
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler)
        .applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters4() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.applyAdditionalFilters(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult =
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler)
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler)
        .applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters5() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult =
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters_givenOfferServiceExtensionManager() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer2() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer3() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(
            Mockito.<Customer>any(), Mockito.<List<OfferCode>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult =
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler)
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler)
        .buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer4() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(
            Mockito.<Customer>any(), Mockito.<List<OfferCode>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult =
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler)
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler)
        .buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer5() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult =
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer_givenOfferServiceExtensionManager() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode2() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode3() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult =
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler, atLeast(1))
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode4() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult =
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler, atLeast(1))
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode5() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult =
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode_givenOfferServiceExtensionManager() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder2() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder3() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(
            Mockito.<OfferCode>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult =
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler)
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler)
        .removeOfferCodeFromOrder(isA(OfferCode.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder4() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            Mockito.<List<Offer>>any(), Mockito.<OfferCode>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(
            Mockito.<OfferCode>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult =
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler)
        .addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler)
        .removeOfferCodeFromOrder(isA(OfferCode.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder5() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        mock(AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult =
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder_givenOfferServiceExtensionManager() {
    // Arrange
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder_thenReturnNotHandled() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#isEnabled()}.
   *
   * <p>Method under test: {@link OfferServiceExtensionManager#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue(new OfferServiceExtensionManager().isEnabled());
  }
}
