package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferRuleImplDiffblueTest {
  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    assertEquals(offerRuleImpl.hashCode(), offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    assertNotEquals(offerRuleImpl.hashCode(), offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(null);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    assertNotEquals(offerRuleImpl.hashCode(), offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl);
    int expectedHashCodeResult = offerRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerRuleImpl.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(2L);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, offerRuleImpl2);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule("42");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, offerRuleImpl2);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, null);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, "Different type to OfferRuleImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferRuleImpl}
   *   <li>{@link OfferRuleImpl#setId(Long)}
   *   <li>{@link OfferRuleImpl#setMatchRule(String)}
   *   <li>{@link OfferRuleImpl#getId()}
   *   <li>{@link OfferRuleImpl#getMatchRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferRuleImpl.<init>()",
    "Long OfferRuleImpl.getId()",
    "String OfferRuleImpl.getMatchRule()",
    "void OfferRuleImpl.setId(Long)",
    "void OfferRuleImpl.setMatchRule(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferRuleImpl actualOfferRuleImpl = new OfferRuleImpl();
    actualOfferRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualOfferRuleImpl.setMatchRule("Match Rule");
    Long actualId = actualOfferRuleImpl.getId();

    // Assert
    assertEquals("Match Rule", actualOfferRuleImpl.getMatchRule());
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
  }
}
