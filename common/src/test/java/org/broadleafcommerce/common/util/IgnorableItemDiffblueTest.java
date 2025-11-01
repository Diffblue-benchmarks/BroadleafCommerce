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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IgnorableItemDiffblueTest {
  /**
   * Method under test: {@link IgnorableItem#getCompiled()}
   */
  @Test
  public void testGetCompiled() {
    // Arrange
    IgnorableItem ignorableItem = new IgnorableItem();
    ignorableItem.setValue("42");

    // Act and Assert
    assertEquals("42", ignorableItem.getCompiled().pattern());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IgnorableItem}
   *   <li>{@link IgnorableItem#setKey(String)}
   *   <li>{@link IgnorableItem#setValue(String)}
   *   <li>{@link IgnorableItem#getKey()}
   *   <li>{@link IgnorableItem#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IgnorableItem actualIgnorableItem = new IgnorableItem();
    actualIgnorableItem.setKey("Key");
    actualIgnorableItem.setValue("42");
    String actualKey = actualIgnorableItem.getKey();

    // Assert that nothing has changed
    assertEquals("42", actualIgnorableItem.getValue());
    assertEquals("Key", actualKey);
  }
}
