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
package org.broadleafcommerce.openadmin.dto.override;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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

    // Assert that nothing has changed
    assertEquals(1, actualColumn.intValue());
    assertTrue(actualCollapsed);
    assertTrue(actualUntitled);
  }
}
