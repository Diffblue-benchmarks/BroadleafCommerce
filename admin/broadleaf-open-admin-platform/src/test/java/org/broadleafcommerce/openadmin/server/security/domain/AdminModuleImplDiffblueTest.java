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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminModuleImplDiffblueTest {
  /**
   * Test {@link AdminModuleImpl#getAdminModuleDTO()}.
   * <p>
   * Method under test: {@link AdminModuleImpl#getAdminModuleDTO()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminModuleDTO AdminModuleImpl.getAdminModuleDTO()"})
  public void testGetAdminModuleDTO() {
    // Arrange and Act
    AdminModuleDTO actualAdminModuleDTO = (new AdminModuleImpl()).getAdminModuleDTO();

    // Assert
    assertNull(actualAdminModuleDTO.getDisplayOrder());
    assertNull(actualAdminModuleDTO.getId());
    assertNull(actualAdminModuleDTO.getIcon());
    assertNull(actualAdminModuleDTO.getModuleKey());
    assertNull(actualAdminModuleDTO.getName());
    assertTrue(actualAdminModuleDTO.getSections().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminModuleImpl}
   *   <li>{@link AdminModuleImpl#setDisplayOrder(Integer)}
   *   <li>{@link AdminModuleImpl#setIcon(String)}
   *   <li>{@link AdminModuleImpl#setId(Long)}
   *   <li>{@link AdminModuleImpl#setModuleKey(String)}
   *   <li>{@link AdminModuleImpl#setName(String)}
   *   <li>{@link AdminModuleImpl#setSections(List)}
   *   <li>{@link AdminModuleImpl#getDisplayOrder()}
   *   <li>{@link AdminModuleImpl#getIcon()}
   *   <li>{@link AdminModuleImpl#getId()}
   *   <li>{@link AdminModuleImpl#getModuleKey()}
   *   <li>{@link AdminModuleImpl#getName()}
   *   <li>{@link AdminModuleImpl#getSections()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminModuleImpl.<init>()", "Integer AdminModuleImpl.getDisplayOrder()",
      "String AdminModuleImpl.getIcon()", "Long AdminModuleImpl.getId()", "String AdminModuleImpl.getModuleKey()",
      "String AdminModuleImpl.getName()", "List AdminModuleImpl.getSections()",
      "void AdminModuleImpl.setDisplayOrder(Integer)", "void AdminModuleImpl.setIcon(String)",
      "void AdminModuleImpl.setId(Long)", "void AdminModuleImpl.setModuleKey(String)",
      "void AdminModuleImpl.setName(String)", "void AdminModuleImpl.setSections(List)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminModuleImpl actualAdminModuleImpl = new AdminModuleImpl();
    actualAdminModuleImpl.setDisplayOrder(1);
    actualAdminModuleImpl.setIcon("Icon");
    actualAdminModuleImpl.setId(1L);
    actualAdminModuleImpl.setModuleKey("Module Key");
    actualAdminModuleImpl.setName("Name");
    ArrayList<AdminSection> sections = new ArrayList<>();
    actualAdminModuleImpl.setSections(sections);
    Integer actualDisplayOrder = actualAdminModuleImpl.getDisplayOrder();
    String actualIcon = actualAdminModuleImpl.getIcon();
    Long actualId = actualAdminModuleImpl.getId();
    String actualModuleKey = actualAdminModuleImpl.getModuleKey();
    String actualName = actualAdminModuleImpl.getName();
    List<AdminSection> actualSections = actualAdminModuleImpl.getSections();

    // Assert
    assertEquals("Icon", actualIcon);
    assertEquals("Module Key", actualModuleKey);
    assertEquals("Name", actualName);
    assertEquals(1, actualDisplayOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualSections.isEmpty());
    assertSame(sections, actualSections);
  }
}
