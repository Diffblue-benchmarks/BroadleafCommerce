package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferQualifyingCriteriaXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getId()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferQualifyingCriteriaXrefImpl.<init>()",
    "void OfferQualifyingCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferQualifyingCriteriaXrefImpl.getId()",
    "Offer OfferQualifyingCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferQualifyingCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferQualifyingCriteriaXrefImpl.setId(Long)",
    "void OfferQualifyingCriteriaXrefImpl.setOffer(Offer)",
    "void OfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferQualifyingCriteriaXrefImpl actualOfferQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    actualOfferQualifyingCriteriaXrefImpl.setId(
        CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOffer(offer);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferQualifyingCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferQualifyingCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferQualifyingCriteriaXrefImpl.getOfferItemCriteria();

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
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl(Offer,
   *       OfferItemCriteria)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getId()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferQualifyingCriteriaXrefImpl.<init>()",
    "void OfferQualifyingCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferQualifyingCriteriaXrefImpl.getId()",
    "Offer OfferQualifyingCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferQualifyingCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferQualifyingCriteriaXrefImpl.setId(Long)",
    "void OfferQualifyingCriteriaXrefImpl.setOffer(Offer)",
    "void OfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters_whenOfferImpl() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferQualifyingCriteriaXrefImpl actualOfferQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl(offer, new OfferItemCriteriaImpl());
    actualOfferQualifyingCriteriaXrefImpl.setId(
        CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer2 = new OfferImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOffer(offer2);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferQualifyingCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferQualifyingCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferQualifyingCriteriaXrefImpl.getOfferItemCriteria();

    // Assert
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferQualifyingCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl2 =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerQualifyingCriteriaXrefImpl, offerQualifyingCriteriaXrefImpl2);
    assertEquals(
        offerQualifyingCriteriaXrefImpl.hashCode(), offerQualifyingCriteriaXrefImpl2.hashCode());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferQualifyingCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerQualifyingCriteriaXrefImpl, offerQualifyingCriteriaXrefImpl);
    int expectedHashCodeResult = offerQualifyingCriteriaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerQualifyingCriteriaXrefImpl.hashCode());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(2L);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl2 =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerQualifyingCriteriaXrefImpl, offerQualifyingCriteriaXrefImpl2);
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerQualifyingCriteriaXrefImpl, null);
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(
        offerQualifyingCriteriaXrefImpl, "Different type to OfferQualifyingCriteriaXrefImpl");
  }
}
