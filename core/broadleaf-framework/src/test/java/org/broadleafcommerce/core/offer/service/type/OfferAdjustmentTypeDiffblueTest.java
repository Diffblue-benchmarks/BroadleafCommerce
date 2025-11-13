package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferAdjustmentType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferAdjustmentTypeDiffblueTest {
  @Autowired private OfferAdjustmentType offerAdjustmentType;

  /**
   * Test {@link OfferAdjustmentType#getInstance(String)}.
   *
   * <p>Method under test: {@link OfferAdjustmentType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferAdjustmentType OfferAdjustmentType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    OfferAdjustmentType actualInstance = OfferAdjustmentType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferAdjustmentType#OfferAdjustmentType()}
   *   <li>{@link OfferAdjustmentType#getFriendlyType()}
   *   <li>{@link OfferAdjustmentType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferAdjustmentType.<init>()",
    "String OfferAdjustmentType.getFriendlyType()",
    "String OfferAdjustmentType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferAdjustmentType actualOfferAdjustmentType = new OfferAdjustmentType();
    String actualFriendlyType = actualOfferAdjustmentType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferAdjustmentType.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#OfferAdjustmentType(String, String)}.
   *
   * <p>Method under test: {@link OfferAdjustmentType#OfferAdjustmentType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferAdjustmentType.<init>(String, String)"})
  public void testNewOfferAdjustmentType() {
    // Arrange and Act
    OfferAdjustmentType actualOfferAdjustmentType =
        new OfferAdjustmentType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferAdjustmentType.getFriendlyType());
    assertEquals("Type", actualOfferAdjustmentType.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#setType(String)}.
   *
   * <ul>
   *   <li>Then {@link OfferAdjustmentType} Type is {@code FUTURE_CREDIT42FUTURE_CREDIT}.
   * </ul>
   *
   * <p>Method under test: {@link OfferAdjustmentType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferAdjustmentType.setType(String)"})
  public void testSetType_thenOfferAdjustmentTypeTypeIsFutureCredit42futureCredit() {
    // Arrange and Act
    offerAdjustmentType.setType("FUTURE_CREDIT42FUTURE_CREDIT");

    // Assert
    assertEquals("FUTURE_CREDIT42FUTURE_CREDIT", offerAdjustmentType.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link OfferAdjustmentType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link OfferAdjustmentType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferAdjustmentType.setType(String)"})
  public void testSetType_whenType_thenOfferAdjustmentTypeTypeIsType() {
    // Arrange and Act
    offerAdjustmentType.setType("Type");

    // Assert
    assertEquals("Type", offerAdjustmentType.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}, and {@link OfferAdjustmentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferAdjustmentType#equals(Object)}
   *   <li>{@link OfferAdjustmentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferAdjustmentType.equals(Object)",
    "int OfferAdjustmentType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.FUTURE_CREDIT;
    OfferAdjustmentType offerAdjustmentType2 = OfferAdjustmentType.FUTURE_CREDIT;

    // Act and Assert
    assertEquals(offerAdjustmentType, offerAdjustmentType2);
    assertEquals(offerAdjustmentType.hashCode(), offerAdjustmentType2.hashCode());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}, and {@link OfferAdjustmentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferAdjustmentType#equals(Object)}
   *   <li>{@link OfferAdjustmentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferAdjustmentType.equals(Object)",
    "int OfferAdjustmentType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType = new OfferAdjustmentType();
    OfferAdjustmentType offerAdjustmentType2 = new OfferAdjustmentType();

    // Act and Assert
    assertEquals(offerAdjustmentType, offerAdjustmentType2);
    assertEquals(offerAdjustmentType.hashCode(), offerAdjustmentType2.hashCode());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}, and {@link OfferAdjustmentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferAdjustmentType#equals(Object)}
   *   <li>{@link OfferAdjustmentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferAdjustmentType.equals(Object)",
    "int OfferAdjustmentType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.FUTURE_CREDIT;

    // Act and Assert
    assertEquals(offerAdjustmentType, offerAdjustmentType);
    int expectedHashCodeResult = offerAdjustmentType.hashCode();
    assertEquals(expectedHashCodeResult, offerAdjustmentType.hashCode());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferAdjustmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferAdjustmentType.equals(Object)",
    "int OfferAdjustmentType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferAdjustmentType.ORDER_DISCOUNT, OfferAdjustmentType.FUTURE_CREDIT);
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferAdjustmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferAdjustmentType.equals(Object)",
    "int OfferAdjustmentType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OfferAdjustmentType(), OfferAdjustmentType.FUTURE_CREDIT);
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferAdjustmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferAdjustmentType.equals(Object)",
    "int OfferAdjustmentType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferAdjustmentType.FUTURE_CREDIT, null);
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferAdjustmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferAdjustmentType.equals(Object)",
    "int OfferAdjustmentType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferAdjustmentType.FUTURE_CREDIT, "Different type to OfferAdjustmentType");
  }
}
