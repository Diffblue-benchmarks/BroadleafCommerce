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
package org.broadleafcommerce.common.structure.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ItemCriteriaDTODiffblueTest {
  /**
   * Test {@link ItemCriteriaDTO#getClone()}.
   * <p>
   * Method under test: {@link ItemCriteriaDTO#getClone()}
   */
  @Test
  public void testGetClone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ItemCriteriaDTO actualClone = (new ItemCriteriaDTO()).getClone();

    // Assert
    assertNull(actualClone.getQty());
    assertNull(actualClone.getMatchRule());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ItemCriteriaDTO}
   *   <li>{@link ItemCriteriaDTO#setMatchRule(String)}
   *   <li>{@link ItemCriteriaDTO#setQty(Integer)}
   *   <li>{@link ItemCriteriaDTO#getMatchRule()}
   *   <li>{@link ItemCriteriaDTO#getQty()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ItemCriteriaDTO actualItemCriteriaDTO = new ItemCriteriaDTO();
    actualItemCriteriaDTO.setMatchRule("Match Rule");
    actualItemCriteriaDTO.setQty(1);
    String actualMatchRule = actualItemCriteriaDTO.getMatchRule();

    // Assert that nothing has changed
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualItemCriteriaDTO.getQty().intValue());
  }
}
