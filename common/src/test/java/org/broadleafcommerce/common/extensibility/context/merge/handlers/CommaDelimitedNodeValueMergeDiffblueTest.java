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

public class CommaDelimitedNodeValueMergeDiffblueTest {
  /**
   * Test {@link CommaDelimitedNodeValueMerge#getDelimiter()}.
   * <p>
   * Method under test: {@link CommaDelimitedNodeValueMerge#getDelimiter()}
   */
  @Test
  public void testGetDelimiter() {
    // Arrange, Act and Assert
    assertEquals(",", (new CommaDelimitedNodeValueMerge()).getDelimiter());
  }

  /**
   * Test {@link CommaDelimitedNodeValueMerge#getRegEx()}.
   * <p>
   * Method under test: {@link CommaDelimitedNodeValueMerge#getRegEx()}
   */
  @Test
  public void testGetRegEx() {
    // Arrange, Act and Assert
    assertEquals(",", (new CommaDelimitedNodeValueMerge()).getRegEx());
  }

  /**
   * Test new {@link CommaDelimitedNodeValueMerge} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CommaDelimitedNodeValueMerge}
   */
  @Test
  public void testNewCommaDelimitedNodeValueMerge() {
    // Arrange and Act
    CommaDelimitedNodeValueMerge actualCommaDelimitedNodeValueMerge = new CommaDelimitedNodeValueMerge();

    // Assert
    assertEquals(",", actualCommaDelimitedNodeValueMerge.getDelimiter());
    assertEquals(",", actualCommaDelimitedNodeValueMerge.getRegEx());
    assertNull(actualCommaDelimitedNodeValueMerge.getName());
    assertNull(actualCommaDelimitedNodeValueMerge.getXPath());
    assertEquals(0, actualCommaDelimitedNodeValueMerge.getPriority());
    assertEquals(0, actualCommaDelimitedNodeValueMerge.getChildren().length);
  }
}
