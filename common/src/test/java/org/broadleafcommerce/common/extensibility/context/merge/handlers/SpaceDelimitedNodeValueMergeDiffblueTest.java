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
package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SpaceDelimitedNodeValueMergeDiffblueTest {
  /**
   * Test {@link SpaceDelimitedNodeValueMerge#getDelimiter()}.
   * <p>
   * Method under test: {@link SpaceDelimitedNodeValueMerge#getDelimiter()}
   */
  @Test
  public void testGetDelimiter() {
    // Arrange, Act and Assert
    assertEquals(" ", (new SpaceDelimitedNodeValueMerge()).getDelimiter());
  }

  /**
   * Test new {@link SpaceDelimitedNodeValueMerge} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SpaceDelimitedNodeValueMerge}
   */
  @Test
  public void testNewSpaceDelimitedNodeValueMerge() {
    // Arrange and Act
    SpaceDelimitedNodeValueMerge actualSpaceDelimitedNodeValueMerge = new SpaceDelimitedNodeValueMerge();

    // Assert
    assertEquals(" ", actualSpaceDelimitedNodeValueMerge.getDelimiter());
    assertEquals("[\\s\\n\\r]+", actualSpaceDelimitedNodeValueMerge.getRegEx());
    assertNull(actualSpaceDelimitedNodeValueMerge.getName());
    assertNull(actualSpaceDelimitedNodeValueMerge.getXPath());
    assertEquals(0, actualSpaceDelimitedNodeValueMerge.getPriority());
    assertEquals(0, actualSpaceDelimitedNodeValueMerge.getChildren().length);
  }
}
