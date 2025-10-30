/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferServiceExtensionManagerDiffblueTest {
  @Autowired
  private OfferServiceExtensionManager offerServiceExtensionManager;

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"})
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"})
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferServiceExtensionManager.applyAdditionalFilters(List, Order)"})
  public void testApplyAdditionalFilters_whenArrayList() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"})
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"})
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"})
  public void testBuildOfferCodeListForCustomer_whenArrayList() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.buildOfferCodeListForCustomer(Customer, List)"})
  public void testBuildOfferCodeListForCustomer_whenNull() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(null, new ArrayList<>()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"})
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"})
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.addAdditionalOffersForCode(List, OfferCode)"})
  public void testAddAdditionalOffersForCode_whenArrayList() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"})
  public void testRemoveOfferCodeFromOrder_whenNull() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(null, new NullOrderImpl()));
  }

  /**
   * Test {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <ul>
   *   <li>When {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OfferServiceExtensionManager.removeOfferCodeFromOrder(OfferCode, Order)"})
  public void testRemoveOfferCodeFromOrder_whenOfferCodeImpl() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferServiceExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OfferServiceExtensionManager()).isEnabled());
  }
}
