/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.rulebuilder.grouping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.junit.Test;

public class GroupDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Group}
   *   <li>{@link Group#setIsTopGroup(Boolean)}
   *   <li>{@link Group#setOperatorType(BLCOperator)}
   *   <li>{@link Group#getIsTopGroup()}
   *   <li>{@link Group#getOperatorType()}
   *   <li>{@link Group#getPhrases()}
   *   <li>{@link Group#getSubGroups()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Group actualGroup = new Group();
    actualGroup.setIsTopGroup(true);
    actualGroup.setOperatorType(BLCOperator.EQUALS);
    Boolean actualIsTopGroup = actualGroup.getIsTopGroup();
    BLCOperator actualOperatorType = actualGroup.getOperatorType();
    List<String> actualPhrases = actualGroup.getPhrases();
    List<Group> actualSubGroups = actualGroup.getSubGroups();

    // Assert that nothing has changed
    assertEquals(BLCOperator.EQUALS, actualOperatorType);
    assertTrue(actualPhrases.isEmpty());
    assertTrue(actualSubGroups.isEmpty());
    assertTrue(actualIsTopGroup);
  }
}
