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
import org.junit.Test;

public class MetadataOverrideDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MetadataOverride}
   *   <li>{@link MetadataOverride#setName(String)}
   *   <li>{@link MetadataOverride#setOrder(Integer)}
   *   <li>{@link MetadataOverride#getName()}
   *   <li>{@link MetadataOverride#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MetadataOverride actualMetadataOverride = new MetadataOverride();
    actualMetadataOverride.setName("Name");
    actualMetadataOverride.setOrder(1);
    String actualName = actualMetadataOverride.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1, actualMetadataOverride.getOrder().intValue());
  }
}
