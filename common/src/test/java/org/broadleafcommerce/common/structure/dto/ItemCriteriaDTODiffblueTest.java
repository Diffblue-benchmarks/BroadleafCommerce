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
package org.broadleafcommerce.common.structure.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemCriteriaDTODiffblueTest {
  @Autowired
  private ItemCriteriaDTO itemCriteriaDTO;

  /**
   * Test {@link ItemCriteriaDTO#getClone()}.
   * <p>
   * Method under test: {@link ItemCriteriaDTO#getClone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ItemCriteriaDTO ItemCriteriaDTO.getClone()"})
  public void testGetClone() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ItemCriteriaDTO.<init>()", "String ItemCriteriaDTO.getMatchRule()",
      "Integer ItemCriteriaDTO.getQty()", "void ItemCriteriaDTO.setMatchRule(String)",
      "void ItemCriteriaDTO.setQty(Integer)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ItemCriteriaDTO actualItemCriteriaDTO = new ItemCriteriaDTO();
    actualItemCriteriaDTO.setMatchRule("Match Rule");
    actualItemCriteriaDTO.setQty(1);
    String actualMatchRule = actualItemCriteriaDTO.getMatchRule();

    // Assert
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualItemCriteriaDTO.getQty().intValue());
  }
}
