package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferItemCriteriaImplDiffblueTest {
  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}, and {@link
   * OfferItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferItemCriteriaImpl#equals(Object)}
   *   <li>{@link OfferItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemCriteriaImpl.equals(Object)",
    "int OfferItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    OfferItemCriteriaImpl offerItemCriteriaImpl2 = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl2.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl2.setMatchRule("Match Rule");
    offerItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(offerItemCriteriaImpl, offerItemCriteriaImpl2);
    assertEquals(offerItemCriteriaImpl.hashCode(), offerItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}, and {@link
   * OfferItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferItemCriteriaImpl#equals(Object)}
   *   <li>{@link OfferItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemCriteriaImpl.equals(Object)",
    "int OfferItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertEquals(offerItemCriteriaImpl, offerItemCriteriaImpl);
    int expectedHashCodeResult = offerItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerItemCriteriaImpl.hashCode());
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemCriteriaImpl.equals(Object)",
    "int OfferItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(2L);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    OfferItemCriteriaImpl offerItemCriteriaImpl2 = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl2.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl2.setMatchRule("Match Rule");
    offerItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerItemCriteriaImpl, offerItemCriteriaImpl2);
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemCriteriaImpl.equals(Object)",
    "int OfferItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerItemCriteriaImpl, null);
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemCriteriaImpl.equals(Object)",
    "int OfferItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerItemCriteriaImpl, "Different type to OfferItemCriteriaImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferItemCriteriaImpl}
   *   <li>{@link OfferItemCriteriaImpl#setId(Long)}
   *   <li>{@link OfferItemCriteriaImpl#setMatchRule(String)}
   *   <li>{@link OfferItemCriteriaImpl#setQuantity(Integer)}
   *   <li>{@link OfferItemCriteriaImpl#getId()}
   *   <li>{@link OfferItemCriteriaImpl#getMatchRule()}
   *   <li>{@link OfferItemCriteriaImpl#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferItemCriteriaImpl.<init>()",
    "Long OfferItemCriteriaImpl.getId()",
    "String OfferItemCriteriaImpl.getMatchRule()",
    "Integer OfferItemCriteriaImpl.getQuantity()",
    "void OfferItemCriteriaImpl.setId(Long)",
    "void OfferItemCriteriaImpl.setMatchRule(String)",
    "void OfferItemCriteriaImpl.setQuantity(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferItemCriteriaImpl actualOfferItemCriteriaImpl = new OfferItemCriteriaImpl();
    actualOfferItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    actualOfferItemCriteriaImpl.setMatchRule("Match Rule");
    actualOfferItemCriteriaImpl.setQuantity(1);
    Long actualId = actualOfferItemCriteriaImpl.getId();
    String actualMatchRule = actualOfferItemCriteriaImpl.getMatchRule();

    // Assert
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualOfferItemCriteriaImpl.getQuantity().intValue());
    assertEquals(OfferItemCriteriaImpl.serialVersionUID, actualId.longValue());
  }
}
