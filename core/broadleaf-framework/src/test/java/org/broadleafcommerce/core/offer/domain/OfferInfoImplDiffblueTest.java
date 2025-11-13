package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferInfoImplDiffblueTest {
  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    assertEquals(offerInfoImpl.hashCode(), offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(null);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    assertEquals(offerInfoImpl.hashCode(), offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(null);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    assertEquals(offerInfoImpl.hashCode(), offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl);
    int expectedHashCodeResult = offerInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerInfoImpl.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(2L);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, offerInfoImpl2);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> fieldValues = new HashMap<>();
    fieldValues.put("foo", "foo");

    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(fieldValues);
    offerInfoImpl.setId(null);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, offerInfoImpl2);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, null);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, "Different type to OfferInfoImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferInfoImpl}
   *   <li>{@link OfferInfoImpl#setFieldValues(Map)}
   *   <li>{@link OfferInfoImpl#setId(Long)}
   *   <li>{@link OfferInfoImpl#getFieldValues()}
   *   <li>{@link OfferInfoImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferInfoImpl.<init>()",
    "Map OfferInfoImpl.getFieldValues()",
    "Long OfferInfoImpl.getId()",
    "void OfferInfoImpl.setFieldValues(Map)",
    "void OfferInfoImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferInfoImpl actualOfferInfoImpl = new OfferInfoImpl();
    HashMap<String, String> fieldValues = new HashMap<>();
    actualOfferInfoImpl.setFieldValues(fieldValues);
    actualOfferInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    Map<String, String> actualFieldValues = actualOfferInfoImpl.getFieldValues();
    Long actualId = actualOfferInfoImpl.getId();

    // Assert
    assertTrue(actualFieldValues.isEmpty());
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldValues, actualFieldValues);
  }
}
