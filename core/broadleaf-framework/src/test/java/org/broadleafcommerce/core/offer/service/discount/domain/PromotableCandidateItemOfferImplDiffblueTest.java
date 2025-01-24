package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.broadleafcommerce.core.offer.domain.OfferPriceData;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Ignore;
import org.junit.Test;

public class PromotableCandidateItemOfferImplDiffblueTest {
  /**
   * Test
   * {@link PromotableCandidateItemOfferImpl#PromotableCandidateItemOfferImpl(PromotableOrder, Offer)}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#PromotableCandidateItemOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewPromotableCandidateItemOfferImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

  }

  /**
   * Test
   * {@link PromotableCandidateItemOfferImpl#PromotableCandidateItemOfferImpl(PromotableOrder, Offer, boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#PromotableCandidateItemOfferImpl(PromotableOrder, Offer, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewPromotableCandidateItemOfferImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl(), true);

  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#getCurrency()}.
   * <p>
   * Method under test: {@link PromotableCandidateItemOfferImpl#getCurrency()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrency() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getCurrency();
  }

  /**
   * Test
   * {@link PromotableCandidateItemOfferImpl#calculateTargetQuantityForTieredOffer()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#calculateTargetQuantityForTieredOffer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTargetQuantityForTieredOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).calculateTargetQuantityForTieredOffer();
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#getPotentialSavings()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#getPotentialSavings()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPotentialSavings() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getPotentialSavings();
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#getPotentialSavings()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#getPotentialSavings()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPotentialSavings2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl.getOrderCurrency(PromotableOrderImpl.java:283)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl.getPotentialSavings(PromotableCandidateItemOfferImpl.java:135)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(null,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getPotentialSavings();
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#getPotentialSavingsQtyOne()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#getPotentialSavingsQtyOne()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPotentialSavingsQtyOne() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getPotentialSavingsQtyOne();
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#getPotentialSavingsQtyOne()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#getPotentialSavingsQtyOne()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPotentialSavingsQtyOne2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl.getOrderCurrency(PromotableOrderImpl.java:283)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl.getPotentialSavingsQtyOne(PromotableCandidateItemOfferImpl.java:148)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(null,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getPotentialSavingsQtyOne();
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#hasQualifyingItemCriteria()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#hasQualifyingItemCriteria()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasQualifyingItemCriteria() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).hasQualifyingItemCriteria();
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#calculateMaximumNumberOfUses()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#calculateMaximumNumberOfUses()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateMaximumNumberOfUses() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).calculateMaximumNumberOfUses();
  }

  /**
   * Test
   * {@link PromotableCandidateItemOfferImpl#calculateMaxUsesForItemCriteria(OfferItemCriteria, Offer)}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#calculateMaxUsesForItemCriteria(OfferItemCriteria, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateMaxUsesForItemCriteria() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOfferImpl = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());
    promotableCandidateItemOfferImpl.setCandidateTargetsMap(new HashMap<>());

    // Act
    promotableCandidateItemOfferImpl.calculateMaxUsesForItemCriteria(null, new OfferImpl());
  }

  /**
   * Test
   * {@link PromotableCandidateItemOfferImpl#calculateMaxUsesForItemCriteria(OfferItemCriteria, Offer)}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#calculateMaxUsesForItemCriteria(OfferItemCriteria, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateMaxUsesForItemCriteria2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOfferImpl = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());
    OfferItemCriteriaImpl itemCriteria = new OfferItemCriteriaImpl();

    // Act
    promotableCandidateItemOfferImpl.calculateMaxUsesForItemCriteria(itemCriteria, new OfferImpl());
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#getPriority()}.
   * <p>
   * Method under test: {@link PromotableCandidateItemOfferImpl#getPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriority() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getPriority();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setCandidateFixedTargetsMap(HashMap)}
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setCandidateQualifiersMap(HashMap)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setCandidateTargetsMap(HashMap)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setLegacyCandidateTargets(List)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setOriginalPrice(Money)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setPotentialSavings(Money)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setPotentialSavingsQtyOne(Money)}
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setUseQtyOnlyTierCalculation(boolean)}
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setWeightedPercentSaved(BigDecimal)}
   *   <li>{@link PromotableCandidateItemOfferImpl#addUse()}
   *   <li>{@link PromotableCandidateItemOfferImpl#resetUses()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getCandidateFixedTargetsMap()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getCandidateQualifiersMap()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getCandidateTargetsMap()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getLegacyCandidateTargets()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getOffer()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getOriginalPrice()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getUses()}
   *   <li>{@link PromotableCandidateItemOfferImpl#isUseQtyOnlyTierCalculation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = new OfferImpl();
    PromotableCandidateItemOfferImpl promotableCandidateItemOfferImpl = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);
    HashMap<OfferPriceData, List<PromotableOrderItem>> candidateFixedTargetsMap = new HashMap<>();

    // Act
    promotableCandidateItemOfferImpl.setCandidateFixedTargetsMap(candidateFixedTargetsMap);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> candidateItemsMap = new HashMap<>();
    promotableCandidateItemOfferImpl.setCandidateQualifiersMap(candidateItemsMap);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> candidateItemsMap2 = new HashMap<>();
    promotableCandidateItemOfferImpl.setCandidateTargetsMap(candidateItemsMap2);
    ArrayList<PromotableOrderItem> candidateTargets = new ArrayList<>();
    promotableCandidateItemOfferImpl.setLegacyCandidateTargets(candidateTargets);
    Money originalPrice = new Money();
    promotableCandidateItemOfferImpl.setOriginalPrice(originalPrice);
    promotableCandidateItemOfferImpl.setPotentialSavings(new Money());
    promotableCandidateItemOfferImpl.setPotentialSavingsQtyOne(new Money());
    promotableCandidateItemOfferImpl.setUseQtyOnlyTierCalculation(true);
    promotableCandidateItemOfferImpl.setWeightedPercentSaved(new BigDecimal("2.3"));
    promotableCandidateItemOfferImpl.addUse();
    promotableCandidateItemOfferImpl.resetUses();
    HashMap<OfferPriceData, List<PromotableOrderItem>> actualCandidateFixedTargetsMap = promotableCandidateItemOfferImpl
        .getCandidateFixedTargetsMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateQualifiersMap = promotableCandidateItemOfferImpl
        .getCandidateQualifiersMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateTargetsMap = promotableCandidateItemOfferImpl
        .getCandidateTargetsMap();
    List<PromotableOrderItem> actualLegacyCandidateTargets = promotableCandidateItemOfferImpl
        .getLegacyCandidateTargets();
    Offer actualOffer = promotableCandidateItemOfferImpl.getOffer();
    Money actualOriginalPrice = promotableCandidateItemOfferImpl.getOriginalPrice();
    int actualUses = promotableCandidateItemOfferImpl.getUses();
    boolean actualIsUseQtyOnlyTierCalculationResult = promotableCandidateItemOfferImpl.isUseQtyOnlyTierCalculation();

    // Assert that nothing has changed
    assertEquals(0, actualUses);
    assertTrue(actualLegacyCandidateTargets.isEmpty());
    assertTrue(actualIsUseQtyOnlyTierCalculationResult);
    assertSame(candidateTargets, actualLegacyCandidateTargets);
    assertSame(candidateFixedTargetsMap, actualCandidateFixedTargetsMap);
    assertSame(candidateItemsMap, actualCandidateQualifiersMap);
    assertSame(candidateItemsMap2, actualCandidateTargetsMap);
    assertSame(originalPrice, actualOriginalPrice);
    assertSame(offer, actualOffer);
  }

  /**
   * Test {@link PromotableCandidateItemOfferImpl#getWeightedPercentSaved()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#getWeightedPercentSaved()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWeightedPercentSaved() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getWeightedPercentSaved();
  }

  /**
   * Test
   * {@link PromotableCandidateItemOfferImpl#setMinimumTargetsRequired(Integer)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#setMinimumTargetsRequired(Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetMinimumTargetsRequired_whenOne() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).setMinimumTargetsRequired(1);
  }

  /**
   * Test
   * {@link PromotableCandidateItemOfferImpl#getMinimumRequiredTargetQuantity()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateItemOfferImpl#getMinimumRequiredTargetQuantity()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMinimumRequiredTargetQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl())).getMinimumRequiredTargetQuantity();
  }
}
