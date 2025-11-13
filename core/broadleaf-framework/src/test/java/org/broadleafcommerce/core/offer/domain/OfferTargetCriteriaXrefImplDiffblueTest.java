package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferTargetCriteriaXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getId()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferTargetCriteriaXrefImpl.<init>()",
    "void OfferTargetCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferTargetCriteriaXrefImpl.getId()",
    "Offer OfferTargetCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferTargetCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferTargetCriteriaXrefImpl.setId(Long)",
    "void OfferTargetCriteriaXrefImpl.setOffer(Offer)",
    "void OfferTargetCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferTargetCriteriaXrefImpl actualOfferTargetCriteriaXrefImpl =
        new OfferTargetCriteriaXrefImpl();
    actualOfferTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    actualOfferTargetCriteriaXrefImpl.setOffer(offer);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferTargetCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferTargetCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferTargetCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferTargetCriteriaXrefImpl.getOfferItemCriteria();

    // Assert
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
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
   *   <li>{@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl(Offer, OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getId()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferTargetCriteriaXrefImpl.<init>()",
    "void OfferTargetCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferTargetCriteriaXrefImpl.getId()",
    "Offer OfferTargetCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferTargetCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferTargetCriteriaXrefImpl.setId(Long)",
    "void OfferTargetCriteriaXrefImpl.setOffer(Offer)",
    "void OfferTargetCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters_whenOfferImpl() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferTargetCriteriaXrefImpl actualOfferTargetCriteriaXrefImpl =
        new OfferTargetCriteriaXrefImpl(offer, new OfferItemCriteriaImpl());
    actualOfferTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer2 = new OfferImpl();
    actualOfferTargetCriteriaXrefImpl.setOffer(offer2);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferTargetCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferTargetCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferTargetCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferTargetCriteriaXrefImpl.getOfferItemCriteria();

    // Assert
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferTargetCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerTargetCriteriaXrefImpl, offerTargetCriteriaXrefImpl2);
    assertEquals(offerTargetCriteriaXrefImpl.hashCode(), offerTargetCriteriaXrefImpl2.hashCode());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferTargetCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerTargetCriteriaXrefImpl, offerTargetCriteriaXrefImpl);
    int expectedHashCodeResult = offerTargetCriteriaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerTargetCriteriaXrefImpl.hashCode());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(2L);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerTargetCriteriaXrefImpl, offerTargetCriteriaXrefImpl2);
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerTargetCriteriaXrefImpl, null);
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerTargetCriteriaXrefImpl, "Different type to OfferTargetCriteriaXrefImpl");
  }
}
