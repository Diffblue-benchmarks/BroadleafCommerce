/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.Test;

public class OfferProrationTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#OfferProrationType()}
   *   <li>{@link OfferProrationType#getFriendlyType()}
   *   <li>{@link OfferProrationType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferProrationType actualOfferProrationType = new OfferProrationType();
    String actualFriendlyType = actualOfferProrationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferProrationType.getType());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}, and
   * {@link OfferProrationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#equals(Object)}
   *   <li>{@link OfferProrationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferProrationType offerProrationType = OfferProrationType.TARGET_AND_QUALIFIER;
    OfferProrationType offerProrationType2 = OfferProrationType.TARGET_AND_QUALIFIER;

    // Act and Assert
    assertEquals(offerProrationType, offerProrationType2);
    int expectedHashCodeResult = offerProrationType.hashCode();
    assertEquals(expectedHashCodeResult, offerProrationType2.hashCode());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}, and
   * {@link OfferProrationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#equals(Object)}
   *   <li>{@link OfferProrationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferProrationType offerProrationType = new OfferProrationType();
    OfferProrationType offerProrationType2 = new OfferProrationType();

    // Act and Assert
    assertEquals(offerProrationType, offerProrationType2);
    int expectedHashCodeResult = offerProrationType.hashCode();
    assertEquals(expectedHashCodeResult, offerProrationType2.hashCode());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}, and
   * {@link OfferProrationType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#equals(Object)}
   *   <li>{@link OfferProrationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferProrationType offerProrationType = OfferProrationType.TARGET_AND_QUALIFIER;

    // Act and Assert
    assertEquals(offerProrationType, offerProrationType);
    int expectedHashCodeResult = offerProrationType.hashCode();
    assertEquals(expectedHashCodeResult, offerProrationType.hashCode());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferProrationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferProrationType.TARGET_ONLY, OfferProrationType.TARGET_AND_QUALIFIER);
    assertNotEquals(new OfferProrationType(), OfferProrationType.TARGET_AND_QUALIFIER);
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferProrationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferProrationType.TARGET_AND_QUALIFIER, null);
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferProrationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferProrationType.TARGET_AND_QUALIFIER, "Different type to OfferProrationType");
  }
}
