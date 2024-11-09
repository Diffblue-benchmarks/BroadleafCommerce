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
package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.extension.ItemStatus;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class LocalePairDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LocalePair}
   *   <li>{@link LocalePair#setGeneralItem(StandardCacheItem)}
   *   <li>{@link LocalePair#setSpecificItem(StandardCacheItem)}
   *   <li>{@link LocalePair#getGeneralItem()}
   *   <li>{@link LocalePair#getSpecificItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LocalePair actualLocalePair = new LocalePair();
    StandardCacheItem generalItem = new StandardCacheItem();
    generalItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    generalItem.setItemStatus(ItemStatus.DELETED);
    generalItem.setKey("Key");
    actualLocalePair.setGeneralItem(generalItem);
    StandardCacheItem specificItem = new StandardCacheItem();
    specificItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    specificItem.setItemStatus(ItemStatus.DELETED);
    specificItem.setKey("Key");
    actualLocalePair.setSpecificItem(specificItem);
    StandardCacheItem actualGeneralItem = actualLocalePair.getGeneralItem();

    // Assert that nothing has changed
    assertSame(generalItem, actualGeneralItem);
    assertSame(specificItem, actualLocalePair.getSpecificItem());
  }
}
