package org.broadleafcommerce.core.offer.service.discount;

import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.broadleafcommerce.core.offer.domain.OfferPriceData;
import org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Ignore;
import org.junit.Test;

public class CandidatePromotionItemsDiffblueTest {
  /**
   * Test
   * {@link CandidatePromotionItems#addQualifier(OfferItemCriteria, PromotableOrderItem)}.
   * <ul>
   *   <li>Given {@link CandidatePromotionItems} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CandidatePromotionItems#addQualifier(OfferItemCriteria, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddQualifier_givenCandidatePromotionItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    CandidatePromotionItems candidatePromotionItems = new CandidatePromotionItems();
    OfferItemCriteriaImpl criteria = new OfferItemCriteriaImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    candidatePromotionItems.addQualifier(criteria, new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link CandidatePromotionItems#addTarget(OfferItemCriteria, PromotableOrderItem)}.
   * <ul>
   *   <li>Given {@link CandidatePromotionItems} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CandidatePromotionItems#addTarget(OfferItemCriteria, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddTarget_givenCandidatePromotionItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    CandidatePromotionItems candidatePromotionItems = new CandidatePromotionItems();
    OfferItemCriteriaImpl criteria = new OfferItemCriteriaImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    candidatePromotionItems.addTarget(criteria, new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link CandidatePromotionItems#addFixedTarget(OfferPriceData, PromotableOrderItem)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CandidatePromotionItems#addFixedTarget(OfferPriceData, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddFixedTarget_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    CandidatePromotionItems candidatePromotionItems = new CandidatePromotionItems();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    candidatePromotionItems.addFixedTarget(null, new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link CandidatePromotionItems#addFixedTarget(OfferPriceData, PromotableOrderItem)}.
   * <ul>
   *   <li>When {@link OfferPriceDataImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CandidatePromotionItems#addFixedTarget(OfferPriceData, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddFixedTarget_whenOfferPriceDataImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl.hashCode(OfferPriceDataImpl.java:310)
    //       at java.base/java.util.HashMap.hash(HashMap.java:340)
    //       at java.base/java.util.HashMap.get(HashMap.java:553)
    //       at org.broadleafcommerce.core.offer.service.discount.CandidatePromotionItems.addFixedTarget(CandidatePromotionItems.java:61)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CandidatePromotionItems candidatePromotionItems = new CandidatePromotionItems();
    OfferPriceDataImpl offerPriceData = new OfferPriceDataImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    candidatePromotionItems.addFixedTarget(offerPriceData, new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test {@link CandidatePromotionItems#getAllCandidateTargets()}.
   * <ul>
   *   <li>Given {@link CandidatePromotionItems} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidatePromotionItems#getAllCandidateTargets()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllCandidateTargets_givenCandidatePromotionItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new CandidatePromotionItems()).getAllCandidateTargets();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidatePromotionItems}
   *   <li>{@link CandidatePromotionItems#setMatchedQualifier(boolean)}
   *   <li>{@link CandidatePromotionItems#setMatchedTarget(boolean)}
   *   <li>{@link CandidatePromotionItems#getCandidateFixedTargetsMap()}
   *   <li>{@link CandidatePromotionItems#getCandidateQualifiersMap()}
   *   <li>{@link CandidatePromotionItems#getCandidateTargetsMap()}
   *   <li>{@link CandidatePromotionItems#isMatchedQualifier()}
   *   <li>{@link CandidatePromotionItems#isMatchedTarget()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidatePromotionItems actualCandidatePromotionItems = new CandidatePromotionItems();
    actualCandidatePromotionItems.setMatchedQualifier(true);
    actualCandidatePromotionItems.setMatchedTarget(true);
    HashMap<OfferPriceData, List<PromotableOrderItem>> actualCandidateFixedTargetsMap = actualCandidatePromotionItems
        .getCandidateFixedTargetsMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateQualifiersMap = actualCandidatePromotionItems
        .getCandidateQualifiersMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateTargetsMap = actualCandidatePromotionItems
        .getCandidateTargetsMap();
    boolean actualIsMatchedQualifierResult = actualCandidatePromotionItems.isMatchedQualifier();
    boolean actualIsMatchedTargetResult = actualCandidatePromotionItems.isMatchedTarget();

    // Assert that nothing has changed
    assertTrue(actualCandidateFixedTargetsMap.isEmpty());
    assertTrue(actualCandidateQualifiersMap.isEmpty());
    assertTrue(actualCandidateTargetsMap.isEmpty());
    assertTrue(actualIsMatchedQualifierResult);
    assertTrue(actualIsMatchedTargetResult);
  }
}
