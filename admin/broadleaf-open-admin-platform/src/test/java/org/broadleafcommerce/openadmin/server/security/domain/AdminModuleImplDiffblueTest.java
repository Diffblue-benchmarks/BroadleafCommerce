package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AdminModuleImplDiffblueTest {
  /**
   * Test {@link AdminModuleImpl#getAdminModuleDTO()}.
   * <p>
   * Method under test: {@link AdminModuleImpl#getAdminModuleDTO()}
   */
  @Test
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
