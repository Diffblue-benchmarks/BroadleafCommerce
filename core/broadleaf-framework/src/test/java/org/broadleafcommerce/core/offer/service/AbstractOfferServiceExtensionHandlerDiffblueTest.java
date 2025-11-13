package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractOfferServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractOfferServiceExtensionHandlerDiffblueTest {
  @Autowired private AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler;

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.applyAdditionalFilters(List, Order)"
  })
  public void testApplyAdditionalFilters_whenArrayList() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(Customer, List)"
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
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(Customer, List)"
  })
  public void testBuildOfferCodeListForCustomer_whenArrayList() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(
            customer, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.addAdditionalOffersForCode(List, OfferCode)"
  })
  public void testAddAdditionalOffersForCode_whenArrayList() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(
            offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}.
   *
   * <p>Method under test: {@link
   * AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(OfferCode, Order)"
  })
  public void testRemoveOfferCodeFromOrder() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler =
        new AbstractOfferServiceExtensionHandler();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(
            offerCode, new NullOrderImpl()));
  }

  /**
   * Test new {@link AbstractOfferServiceExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractOfferServiceExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractOfferServiceExtensionHandler.<init>()"})
  public void testNewAbstractOfferServiceExtensionHandler() {
    // Arrange and Act
    AbstractOfferServiceExtensionHandler actualAbstractOfferServiceExtensionHandler =
        new AbstractOfferServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOfferServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractOfferServiceExtensionHandler.isEnabled());
  }
}
