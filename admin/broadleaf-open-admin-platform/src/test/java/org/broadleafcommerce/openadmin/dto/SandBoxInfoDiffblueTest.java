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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SandBoxInfoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SandBoxInfo}
   *   <li>{@link SandBoxInfo#setCommitImmediately(boolean)}
   *   <li>{@link SandBoxInfo#setName(String)}
   *   <li>{@link SandBoxInfo#setSandBox(Long)}
   *   <li>{@link SandBoxInfo#setSiteId(Long)}
   *   <li>{@link SandBoxInfo#getName()}
   *   <li>{@link SandBoxInfo#getSandBox()}
   *   <li>{@link SandBoxInfo#getSiteId()}
   *   <li>{@link SandBoxInfo#isCommitImmediately()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SandBoxInfo actualSandBoxInfo = new SandBoxInfo();
    actualSandBoxInfo.setCommitImmediately(true);
    actualSandBoxInfo.setName("Name");
    actualSandBoxInfo.setSandBox(1L);
    actualSandBoxInfo.setSiteId(1L);
    String actualName = actualSandBoxInfo.getName();
    Long actualSandBox = actualSandBoxInfo.getSandBox();
    Long actualSiteId = actualSandBoxInfo.getSiteId();
    boolean actualIsCommitImmediatelyResult = actualSandBoxInfo.isCommitImmediately();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1L, actualSandBox.longValue());
    assertEquals(1L, actualSiteId.longValue());
    assertTrue(actualIsCommitImmediatelyResult);
  }
}
