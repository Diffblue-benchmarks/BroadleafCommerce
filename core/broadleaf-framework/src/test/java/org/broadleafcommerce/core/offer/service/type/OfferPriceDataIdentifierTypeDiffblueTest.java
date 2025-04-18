/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferPriceDataIdentifierTypeDiffblueTest {
  @Autowired
  private OfferPriceDataIdentifierType offerPriceDataIdentifierType;

  /**
   * Test {@link OfferPriceDataIdentifierType#getInstance(String)}.
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#getInstance(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferPriceDataIdentifierType OfferPriceDataIdentifierType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualInstance = OfferPriceDataIdentifierType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType()}
   *   <li>{@link OfferPriceDataIdentifierType#setOrder(int)}
   *   <li>{@link OfferPriceDataIdentifierType#getFriendlyType()}
   *   <li>{@link OfferPriceDataIdentifierType#getOrder()}
   *   <li>{@link OfferPriceDataIdentifierType#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferPriceDataIdentifierType.<init>()",
      "String OfferPriceDataIdentifierType.getFriendlyType()", "int OfferPriceDataIdentifierType.getOrder()",
      "String OfferPriceDataIdentifierType.getType()", "void OfferPriceDataIdentifierType.setOrder(int)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualOfferPriceDataIdentifierType = new OfferPriceDataIdentifierType();
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
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType(String, String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferPriceDataIdentifierType.<init>(String, String, int)"})
  public void testNewOfferPriceDataIdentifierType() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualOfferPriceDataIdentifierType = new OfferPriceDataIdentifierType("Type",
        "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualOfferPriceDataIdentifierType.getFriendlyType());
    assertEquals("Type", actualOfferPriceDataIdentifierType.getType());
    assertEquals(1, actualOfferPriceDataIdentifierType.getOrder());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferPriceDataIdentifierType#PRODUCT_EXTERNAL_ID} Type is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#setType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferPriceDataIdentifierType.setType(String)"})
  public void testSetType_whenTypeType_thenProduct_external_idTypeIsTypeType() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act
    offerPriceDataIdentifierType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerPriceDataIdentifierType2.getType());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferPriceDataIdentifierType#PRODUCT_EXTERNAL_ID} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#setType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferPriceDataIdentifierType.setType(String)"})
  public void testSetType_whenType_thenProduct_external_idTypeIsType() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act
    offerPriceDataIdentifierType2.setType("Type");

    // Assert
    assertEquals("Type", offerPriceDataIdentifierType2.getType());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and {@link OfferPriceDataIdentifierType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferPriceDataIdentifierType.equals(Object)",
      "int OfferPriceDataIdentifierType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and {@link OfferPriceDataIdentifierType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferPriceDataIdentifierType.equals(Object)",
      "int OfferPriceDataIdentifierType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = new OfferPriceDataIdentifierType();
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = new OfferPriceDataIdentifierType();

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and {@link OfferPriceDataIdentifierType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferPriceDataIdentifierType.equals(Object)",
      "int OfferPriceDataIdentifierType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferPriceDataIdentifierType.equals(Object)",
      "int OfferPriceDataIdentifierType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferPriceDataIdentifierType.PRODUCT_ID, OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferPriceDataIdentifierType.equals(Object)",
      "int OfferPriceDataIdentifierType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OfferPriceDataIdentifierType(), OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferPriceDataIdentifierType.equals(Object)",
      "int OfferPriceDataIdentifierType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID, null);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferPriceDataIdentifierType.equals(Object)",
      "int OfferPriceDataIdentifierType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID, "Different type to OfferPriceDataIdentifierType");
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#compareTo(OfferPriceDataIdentifierType)} with {@code OfferPriceDataIdentifierType}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#compareTo(OfferPriceDataIdentifierType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OfferPriceDataIdentifierType.compareTo(OfferPriceDataIdentifierType)"})
  public void testCompareToWithOfferPriceDataIdentifierType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0,
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID.compareTo(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID));
  }
}
