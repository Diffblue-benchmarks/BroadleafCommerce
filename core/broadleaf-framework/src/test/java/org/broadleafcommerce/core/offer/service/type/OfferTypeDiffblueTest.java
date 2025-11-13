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

@ContextConfiguration(classes = {OfferType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferTypeDiffblueTest {
  @Autowired private OfferType offerType;

  /**
   * Test {@link OfferType#getInstance(String)}.
   *
   * <p>Method under test: {@link OfferType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferType OfferType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    OfferType actualInstance = OfferType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferType#OfferType()}
   *   <li>{@link OfferType#setOrder(int)}
   *   <li>{@link OfferType#getFriendlyType()}
   *   <li>{@link OfferType#getOrder()}
   *   <li>{@link OfferType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferType.<init>()",
    "String OfferType.getFriendlyType()",
    "int OfferType.getOrder()",
    "String OfferType.getType()",
    "void OfferType.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferType actualOfferType = new OfferType();
    actualOfferType.setOrder(1);
    String actualFriendlyType = actualOfferType.getFriendlyType();
    int actualOrder = actualOfferType.getOrder();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferType.getType());
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link OfferType#OfferType(String, String, int)}.
   *
   * <p>Method under test: {@link OfferType#OfferType(String, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferType.<init>(String, String, int)"})
  public void testNewOfferType() {
    // Arrange and Act
    OfferType actualOfferType = new OfferType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualOfferType.getFriendlyType());
    assertEquals("Type", actualOfferType.getType());
    assertEquals(1, actualOfferType.getOrder());
  }

  /**
   * Test {@link OfferType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypeType}.
   *   <li>Then {@link OfferType} Type is {@code TypeType}.
   * </ul>
   *
   * <p>Method under test: {@link OfferType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferType.setType(String)"})
  public void testSetType_whenTypeType_thenOfferTypeTypeIsTypeType() {
    // Arrange and Act
    offerType.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerType.getType());
  }

  /**
   * Test {@link OfferType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link OfferType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link OfferType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferType.setType(String)"})
  public void testSetType_whenType_thenOfferTypeTypeIsType() {
    // Arrange and Act
    offerType.setType("Type");

    // Assert
    assertEquals("Type", offerType.getType());
  }

  /**
   * Test {@link OfferType#equals(Object)}, and {@link OfferType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferType offerType = OfferType.FULFILLMENT_GROUP;
    OfferType offerType2 = OfferType.FULFILLMENT_GROUP;

    // Act and Assert
    assertEquals(offerType, offerType2);
    assertEquals(offerType.hashCode(), offerType2.hashCode());
  }

  /**
   * Test {@link OfferType#equals(Object)}, and {@link OfferType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferType offerType = OfferType.ORDER;
    OfferType offerType2 = new OfferType("ORDER", "ORDER", 1);

    // Act and Assert
    assertEquals(offerType, offerType2);
    assertEquals(offerType.hashCode(), offerType2.hashCode());
  }

  /**
   * Test {@link OfferType#equals(Object)}, and {@link OfferType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferType offerType = new OfferType();
    OfferType offerType2 = new OfferType();

    // Act and Assert
    assertEquals(offerType, offerType2);
    assertEquals(offerType.hashCode(), offerType2.hashCode());
  }

  /**
   * Test {@link OfferType#equals(Object)}, and {@link OfferType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferType offerType = OfferType.FULFILLMENT_GROUP;

    // Act and Assert
    assertEquals(offerType, offerType);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType.hashCode());
  }

  /**
   * Test {@link OfferType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.ORDER, OfferType.FULFILLMENT_GROUP);
  }

  /**
   * Test {@link OfferType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OfferType(), OfferType.FULFILLMENT_GROUP);
  }

  /**
   * Test {@link OfferType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.FULFILLMENT_GROUP, null);
  }

  /**
   * Test {@link OfferType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferType.equals(Object)", "int OfferType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.FULFILLMENT_GROUP, "Different type to OfferType");
  }

  /**
   * Test {@link OfferType#compareTo(OfferType)} with {@code OfferType}.
   *
   * <ul>
   *   <li>When {@link OfferType#FULFILLMENT_GROUP}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OfferType#compareTo(OfferType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferType.compareTo(OfferType)"})
  public void testCompareToWithOfferType_whenFulfillment_group_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, OfferType.FULFILLMENT_GROUP.compareTo(OfferType.FULFILLMENT_GROUP));
  }
}
