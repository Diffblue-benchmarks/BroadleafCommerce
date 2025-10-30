/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto.override;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GroupMetadataOverrideDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GroupMetadataOverride}
   *   <li>{@link GroupMetadataOverride#setCollapsed(Boolean)}
   *   <li>{@link GroupMetadataOverride#setColumn(Integer)}
   *   <li>{@link GroupMetadataOverride#setTooltip(String)}
   *   <li>{@link GroupMetadataOverride#setUntitled(Boolean)}
   *   <li>{@link GroupMetadataOverride#getCollapsed()}
   *   <li>{@link GroupMetadataOverride#getColumn()}
   *   <li>{@link GroupMetadataOverride#getTooltip()}
   *   <li>{@link GroupMetadataOverride#getUntitled()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupMetadataOverride.<init>()", "Boolean GroupMetadataOverride.getCollapsed()",
      "Integer GroupMetadataOverride.getColumn()", "String GroupMetadataOverride.getTooltip()",
      "Boolean GroupMetadataOverride.getUntitled()", "void GroupMetadataOverride.setCollapsed(Boolean)",
      "void GroupMetadataOverride.setColumn(Integer)", "void GroupMetadataOverride.setTooltip(String)",
      "void GroupMetadataOverride.setUntitled(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    GroupMetadataOverride actualGroupMetadataOverride = new GroupMetadataOverride();
    actualGroupMetadataOverride.setCollapsed(true);
    actualGroupMetadataOverride.setColumn(1);
    actualGroupMetadataOverride.setTooltip("127.0.0.1");
    actualGroupMetadataOverride.setUntitled(true);
    Boolean actualCollapsed = actualGroupMetadataOverride.getCollapsed();
    Integer actualColumn = actualGroupMetadataOverride.getColumn();
    actualGroupMetadataOverride.getTooltip();
    Boolean actualUntitled = actualGroupMetadataOverride.getUntitled();

    // Assert
    assertNull(actualGroupMetadataOverride.getOrder());
    assertNull(actualGroupMetadataOverride.getName());
    assertEquals(1, actualColumn.intValue());
    assertTrue(actualCollapsed);
    assertTrue(actualUntitled);
  }
}
