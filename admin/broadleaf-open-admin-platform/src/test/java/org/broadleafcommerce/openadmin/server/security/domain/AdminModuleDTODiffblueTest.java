package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminModuleDTODiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminModuleDTO.<init>()",
    "Integer AdminModuleDTO.getDisplayOrder()",
    "String AdminModuleDTO.getIcon()",
    "Long AdminModuleDTO.getId()",
    "String AdminModuleDTO.getModuleKey()",
    "String AdminModuleDTO.getName()",
    "List AdminModuleDTO.getSections()",
    "void AdminModuleDTO.setDisplayOrder(Integer)",
    "void AdminModuleDTO.setIcon(String)",
    "void AdminModuleDTO.setId(Long)",
    "void AdminModuleDTO.setModuleKey(String)",
    "void AdminModuleDTO.setName(String)",
    "void AdminModuleDTO.setSections(List)"
  })
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
