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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AdminModuleDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminModuleDTO}
   *   <li>{@link AdminModuleDTO#setDisplayOrder(Integer)}
   *   <li>{@link AdminModuleDTO#setIcon(String)}
   *   <li>{@link AdminModuleDTO#setId(Long)}
   *   <li>{@link AdminModuleDTO#setModuleKey(String)}
   *   <li>{@link AdminModuleDTO#setName(String)}
   *   <li>{@link AdminModuleDTO#setSections(List)}
   *   <li>{@link AdminModuleDTO#getDisplayOrder()}
   *   <li>{@link AdminModuleDTO#getIcon()}
   *   <li>{@link AdminModuleDTO#getId()}
   *   <li>{@link AdminModuleDTO#getModuleKey()}
   *   <li>{@link AdminModuleDTO#getName()}
   *   <li>{@link AdminModuleDTO#getSections()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminModuleDTO actualAdminModuleDTO = new AdminModuleDTO();
    actualAdminModuleDTO.setDisplayOrder(1);
    actualAdminModuleDTO.setIcon("Icon");
    actualAdminModuleDTO.setId(1L);
    actualAdminModuleDTO.setModuleKey("Module Key");
    actualAdminModuleDTO.setName("Name");
    ArrayList<AdminSection> sections = new ArrayList<>();
    actualAdminModuleDTO.setSections(sections);
    Integer actualDisplayOrder = actualAdminModuleDTO.getDisplayOrder();
    String actualIcon = actualAdminModuleDTO.getIcon();
    Long actualId = actualAdminModuleDTO.getId();
    String actualModuleKey = actualAdminModuleDTO.getModuleKey();
    String actualName = actualAdminModuleDTO.getName();
    List<AdminSection> actualSections = actualAdminModuleDTO.getSections();

    // Assert that nothing has changed
    assertEquals("Icon", actualIcon);
    assertEquals("Module Key", actualModuleKey);
    assertEquals("Name", actualName);
    assertEquals(1, actualDisplayOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualSections.isEmpty());
    assertSame(sections, actualSections);
  }
}
