package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferOfferRuleXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()}
   *   <li>{@link OfferOfferRuleXrefImpl#setId(Long)}
   *   <li>{@link OfferOfferRuleXrefImpl#setKey(String)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOfferRule(OfferRule)}
   *   <li>{@link OfferOfferRuleXrefImpl#getId()}
   *   <li>{@link OfferOfferRuleXrefImpl#getKey()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOffer()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOfferRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferOfferRuleXrefImpl.<init>()",
    "void OfferOfferRuleXrefImpl.<init>(Offer, OfferRule, String)",
    "Long OfferOfferRuleXrefImpl.getId()",
    "String OfferOfferRuleXrefImpl.getKey()",
    "Offer OfferOfferRuleXrefImpl.getOffer()",
    "OfferRule OfferOfferRuleXrefImpl.getOfferRule()",
    "void OfferOfferRuleXrefImpl.setId(Long)",
    "void OfferOfferRuleXrefImpl.setKey(String)",
    "void OfferOfferRuleXrefImpl.setOffer(Offer)",
    "void OfferOfferRuleXrefImpl.setOfferRule(OfferRule)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferOfferRuleXrefImpl actualOfferOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    actualOfferOfferRuleXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualOfferOfferRuleXrefImpl.setKey("Key");
    OfferImpl offer = new OfferImpl();
    actualOfferOfferRuleXrefImpl.setOffer(offer);
    OfferRuleImpl offerRule = new OfferRuleImpl();
    actualOfferOfferRuleXrefImpl.setOfferRule(offerRule);
    Long actualId = actualOfferOfferRuleXrefImpl.getId();
    String actualKey = actualOfferOfferRuleXrefImpl.getKey();
    Offer actualOffer = actualOfferOfferRuleXrefImpl.getOffer();
    OfferRule actualOfferRule = actualOfferOfferRuleXrefImpl.getOfferRule();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(offerRule, actualOfferRule);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl(Offer, OfferRule, String)}
   *   <li>{@link OfferOfferRuleXrefImpl#setId(Long)}
   *   <li>{@link OfferOfferRuleXrefImpl#setKey(String)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOfferRule(OfferRule)}
   *   <li>{@link OfferOfferRuleXrefImpl#getId()}
   *   <li>{@link OfferOfferRuleXrefImpl#getKey()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOffer()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOfferRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferOfferRuleXrefImpl.<init>()",
    "void OfferOfferRuleXrefImpl.<init>(Offer, OfferRule, String)",
    "Long OfferOfferRuleXrefImpl.getId()",
    "String OfferOfferRuleXrefImpl.getKey()",
    "Offer OfferOfferRuleXrefImpl.getOffer()",
    "OfferRule OfferOfferRuleXrefImpl.getOfferRule()",
    "void OfferOfferRuleXrefImpl.setId(Long)",
    "void OfferOfferRuleXrefImpl.setKey(String)",
    "void OfferOfferRuleXrefImpl.setOffer(Offer)",
    "void OfferOfferRuleXrefImpl.setOfferRule(OfferRule)"
  })
  public void testGettersAndSetters_whenOfferImpl() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferOfferRuleXrefImpl actualOfferOfferRuleXrefImpl =
        new OfferOfferRuleXrefImpl(offer, new OfferRuleImpl(), "Key");
    actualOfferOfferRuleXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualOfferOfferRuleXrefImpl.setKey("Key");
    OfferImpl offer2 = new OfferImpl();
    actualOfferOfferRuleXrefImpl.setOffer(offer2);
    OfferRuleImpl offerRule = new OfferRuleImpl();
    actualOfferOfferRuleXrefImpl.setOfferRule(offerRule);
    Long actualId = actualOfferOfferRuleXrefImpl.getId();
    String actualKey = actualOfferOfferRuleXrefImpl.getKey();
    Offer actualOffer = actualOfferOfferRuleXrefImpl.getOffer();
    OfferRule actualOfferRule = actualOfferOfferRuleXrefImpl.getOfferRule();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerRule, actualOfferRule);
  }
}
