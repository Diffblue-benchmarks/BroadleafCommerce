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
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractOfferValueModifierExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractOfferValueModifierExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractOfferValueModifierExtensionHandler abstractOfferValueModifierExtensionHandler;

  /**
   * Test {@link AbstractOfferValueModifierExtensionHandler#modifyOfferValues(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOfferValueModifierExtensionHandler#modifyOfferValues(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractOfferValueModifierExtensionHandler.modifyOfferValues(List, Order)"})
  public void testModifyOfferValues_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferValueModifierExtensionHandler.modifyOfferValues(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOfferValueModifierExtensionHandler#modifyOfferValues(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOfferValueModifierExtensionHandler#modifyOfferValues(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractOfferValueModifierExtensionHandler.modifyOfferValues(List, Order)"})
  public void testModifyOfferValues_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferValueModifierExtensionHandler.modifyOfferValues(offers, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOfferValueModifierExtensionHandler#modifyOfferValues(List, Order)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOfferValueModifierExtensionHandler#modifyOfferValues(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractOfferValueModifierExtensionHandler.modifyOfferValues(List, Order)"})
  public void testModifyOfferValues_whenArrayList() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferValueModifierExtensionHandler.modifyOfferValues(offers, new NullOrderImpl()));
  }

  /**
   * Test new {@link AbstractOfferValueModifierExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AbstractOfferValueModifierExtensionHandler}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractOfferValueModifierExtensionHandler.<init>()"})
  public void testNewAbstractOfferValueModifierExtensionHandler() {
    // Arrange and Act
    AbstractOfferValueModifierExtensionHandler actualAbstractOfferValueModifierExtensionHandler = new AbstractOfferValueModifierExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOfferValueModifierExtensionHandler.getPriority());
    assertTrue(actualAbstractOfferValueModifierExtensionHandler.isEnabled());
  }
}
