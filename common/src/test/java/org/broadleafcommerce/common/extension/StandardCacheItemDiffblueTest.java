/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class StandardCacheItemDiffblueTest {
  /**
   * Test {@link StandardCacheItem#equals(Object)}, and
   * {@link StandardCacheItem#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StandardCacheItem#equals(Object)}
   *   <li>{@link StandardCacheItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    StandardCacheItem standardCacheItem2 = new StandardCacheItem();
    standardCacheItem2.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem2.setItemStatus(ItemStatus.DELETED);
    standardCacheItem2.setKey("Key");

    // Act and Assert
    assertEquals(standardCacheItem, standardCacheItem2);
    int expectedHashCodeResult = standardCacheItem.hashCode();
    assertEquals(expectedHashCodeResult, standardCacheItem2.hashCode());
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}, and
   * {@link StandardCacheItem#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StandardCacheItem#equals(Object)}
   *   <li>{@link StandardCacheItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    // Act and Assert
    assertEquals(standardCacheItem, standardCacheItem);
    int expectedHashCodeResult = standardCacheItem.hashCode();
    assertEquals(expectedHashCodeResult, standardCacheItem.hashCode());
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardCacheItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    StandardCacheItem standardCacheItem2 = new StandardCacheItem();
    standardCacheItem2.setCacheItem(standardCacheItem);
    standardCacheItem2.setItemStatus(ItemStatus.DELETED);
    standardCacheItem2.setKey("Key");

    StandardCacheItem standardCacheItem3 = new StandardCacheItem();
    standardCacheItem3.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem3.setItemStatus(ItemStatus.DELETED);
    standardCacheItem3.setKey("Key");

    // Act and Assert
    assertNotEquals(standardCacheItem2, standardCacheItem3);
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardCacheItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    // Act and Assert
    assertNotEquals(standardCacheItem, null);
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardCacheItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    // Act and Assert
    assertNotEquals(standardCacheItem, "Different type to StandardCacheItem");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StandardCacheItem}
   *   <li>{@link StandardCacheItem#setCacheItem(Object)}
   *   <li>{@link StandardCacheItem#setItemStatus(ItemStatus)}
   *   <li>{@link StandardCacheItem#setKey(String)}
   *   <li>{@link StandardCacheItem#getCacheItem()}
   *   <li>{@link StandardCacheItem#getItemStatus()}
   *   <li>{@link StandardCacheItem#getKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StandardCacheItem actualStandardCacheItem = new StandardCacheItem();
    Object object = BLCFieldUtils.NULL_FIELD;
    actualStandardCacheItem.setCacheItem(object);
    actualStandardCacheItem.setItemStatus(ItemStatus.DELETED);
    actualStandardCacheItem.setKey("Key");
    Object actualCacheItem = actualStandardCacheItem.getCacheItem();
    ItemStatus actualItemStatus = actualStandardCacheItem.getItemStatus();

    // Assert that nothing has changed
    assertEquals("Key", actualStandardCacheItem.getKey());
    assertEquals(ItemStatus.DELETED, actualItemStatus);
    assertSame(object, actualCacheItem);
  }
}
