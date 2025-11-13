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

@ContextConfiguration(classes = {OfferPriceDataIdentifierType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferPriceDataIdentifierTypeDiffblueTest {
  @Autowired private OfferPriceDataIdentifierType offerPriceDataIdentifierType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType()}
   *   <li>{@link OfferPriceDataIdentifierType#setOrder(int)}
   *   <li>{@link OfferPriceDataIdentifierType#getFriendlyType()}
   *   <li>{@link OfferPriceDataIdentifierType#getOrder()}
   *   <li>{@link OfferPriceDataIdentifierType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferPriceDataIdentifierType.<init>()",
    "String OfferPriceDataIdentifierType.getFriendlyType()",
    "int OfferPriceDataIdentifierType.getOrder()",
    "String OfferPriceDataIdentifierType.getType()",
    "void OfferPriceDataIdentifierType.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualOfferPriceDataIdentifierType =
        new OfferPriceDataIdentifierType();
    actualOfferPriceDataIdentifierType.setOrder(1);
    String actualFriendlyType = actualOfferPriceDataIdentifierType.getFriendlyType();
    int actualOrder = actualOfferPriceDataIdentifierType.getOrder();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferPriceDataIdentifierType.getType());
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType(String, String, int)}.
   *
   * <p>Method under test: {@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType(String,
   * String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataIdentifierType.<init>(String, String, int)"})
  public void testNewOfferPriceDataIdentifierType() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualOfferPriceDataIdentifierType =
        new OfferPriceDataIdentifierType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualOfferPriceDataIdentifierType.getFriendlyType());
    assertEquals("Type", actualOfferPriceDataIdentifierType.getType());
    assertEquals(1, actualOfferPriceDataIdentifierType.getOrder());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypeType}.
   *   <li>Then {@link OfferPriceDataIdentifierType} Type is {@code TypeType}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataIdentifierType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataIdentifierType.setType(String)"})
  public void testSetType_whenTypeType_thenOfferPriceDataIdentifierTypeTypeIsTypeType() {
    // Arrange and Act
    offerPriceDataIdentifierType.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerPriceDataIdentifierType.getType());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link OfferPriceDataIdentifierType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataIdentifierType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataIdentifierType.setType(String)"})
  public void testSetType_whenType_thenOfferPriceDataIdentifierTypeTypeIsType() {
    // Arrange and Act
    offerPriceDataIdentifierType.setType("Type");

    // Assert
    assertEquals("Type", offerPriceDataIdentifierType.getType());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and {@link
   * OfferPriceDataIdentifierType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType =
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 =
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    assertEquals(offerPriceDataIdentifierType.hashCode(), offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and {@link
   * OfferPriceDataIdentifierType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType =
        OfferPriceDataIdentifierType.PRODUCT_ID;
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 =
        new OfferPriceDataIdentifierType("PRODUCT_ID", "PRODUCT_ID", 1);

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    assertEquals(offerPriceDataIdentifierType.hashCode(), offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and {@link
   * OfferPriceDataIdentifierType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = new OfferPriceDataIdentifierType();
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = new OfferPriceDataIdentifierType();

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    assertEquals(offerPriceDataIdentifierType.hashCode(), offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and {@link
   * OfferPriceDataIdentifierType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType =
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        OfferPriceDataIdentifierType.PRODUCT_ID, OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new OfferPriceDataIdentifierType(), OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID, null);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataIdentifierType.equals(Object)",
    "int OfferPriceDataIdentifierType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID,
        "Different type to OfferPriceDataIdentifierType");
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#compareTo(OfferPriceDataIdentifierType)} with {@code
   * OfferPriceDataIdentifierType}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferPriceDataIdentifierType#compareTo(OfferPriceDataIdentifierType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferPriceDataIdentifierType.compareTo(OfferPriceDataIdentifierType)"})
  public void testCompareToWithOfferPriceDataIdentifierType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID.compareTo(
            OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID));
  }
}
