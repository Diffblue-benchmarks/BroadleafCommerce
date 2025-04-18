/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StandardCacheItemDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StandardCacheItem.<init>()", "Object StandardCacheItem.getCacheItem()",
      "ItemStatus StandardCacheItem.getItemStatus()", "String StandardCacheItem.getKey()",
      "void StandardCacheItem.setCacheItem(Object)", "void StandardCacheItem.setItemStatus(ItemStatus)",
      "void StandardCacheItem.setKey(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    StandardCacheItem actualStandardCacheItem = new StandardCacheItem();
    Object object = BLCFieldUtils.NULL_FIELD;
    actualStandardCacheItem.setCacheItem(object);
    actualStandardCacheItem.setItemStatus(ItemStatus.DELETED);
    actualStandardCacheItem.setKey("Key");
    Object actualCacheItem = actualStandardCacheItem.getCacheItem();
    ItemStatus actualItemStatus = actualStandardCacheItem.getItemStatus();

    // Assert
    assertEquals("Key", actualStandardCacheItem.getKey());
    assertEquals(ItemStatus.DELETED, actualItemStatus);
    assertSame(object, actualCacheItem);
  }
}
