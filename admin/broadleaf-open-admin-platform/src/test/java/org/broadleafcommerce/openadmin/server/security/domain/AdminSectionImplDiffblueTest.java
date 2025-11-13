package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminSectionImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSectionImpl#setCeilingEntity(String)}
   *   <li>{@link AdminSectionImpl#setDisplayController(String)}
   *   <li>{@link AdminSectionImpl#setDisplayOrder(Integer)}
   *   <li>{@link AdminSectionImpl#setId(Long)}
   *   <li>{@link AdminSectionImpl#setModule(AdminModule)}
   *   <li>{@link AdminSectionImpl#setName(String)}
   *   <li>{@link AdminSectionImpl#setPermissions(List)}
   *   <li>{@link AdminSectionImpl#setSectionKey(String)}
   *   <li>{@link AdminSectionImpl#setUrl(String)}
   *   <li>{@link AdminSectionImpl#setUseDefaultHandler(Boolean)}
   *   <li>{@link AdminSectionImpl#getCeilingEntity()}
   *   <li>{@link AdminSectionImpl#getDisplayController()}
   *   <li>{@link AdminSectionImpl#getDisplayOrder()}
   *   <li>{@link AdminSectionImpl#getId()}
   *   <li>{@link AdminSectionImpl#getModule()}
   *   <li>{@link AdminSectionImpl#getName()}
   *   <li>{@link AdminSectionImpl#getPermissions()}
   *   <li>{@link AdminSectionImpl#getSectionKey()}
   *   <li>{@link AdminSectionImpl#getUrl()}
   *   <li>{@link AdminSectionImpl#getUseDefaultHandler()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminSectionImpl.getCeilingEntity()",
    "String AdminSectionImpl.getDisplayController()",
    "Integer AdminSectionImpl.getDisplayOrder()",
    "Long AdminSectionImpl.getId()",
    "AdminModule AdminSectionImpl.getModule()",
    "String AdminSectionImpl.getName()",
    "List AdminSectionImpl.getPermissions()",
    "String AdminSectionImpl.getSectionKey()",
    "String AdminSectionImpl.getUrl()",
    "Boolean AdminSectionImpl.getUseDefaultHandler()",
    "void AdminSectionImpl.setCeilingEntity(String)",
    "void AdminSectionImpl.setDisplayController(String)",
    "void AdminSectionImpl.setDisplayOrder(Integer)",
    "void AdminSectionImpl.setId(Long)",
    "void AdminSectionImpl.setModule(AdminModule)",
    "void AdminSectionImpl.setName(String)",
    "void AdminSectionImpl.setPermissions(List)",
    "void AdminSectionImpl.setSectionKey(String)",
    "void AdminSectionImpl.setUrl(String)",
    "void AdminSectionImpl.setUseDefaultHandler(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();

    // Act
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setId(1L);
    AdminModuleDTO resultModule = new AdminModuleDTO();
    adminSectionImpl.setModule(resultModule);
    adminSectionImpl.setName("Name");
    ArrayList<AdminPermission> permissions = new ArrayList<>();
    adminSectionImpl.setPermissions(permissions);
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    String actualCeilingEntity = adminSectionImpl.getCeilingEntity();
    String actualDisplayController = adminSectionImpl.getDisplayController();
    Integer actualDisplayOrder = adminSectionImpl.getDisplayOrder();
    Long actualId = adminSectionImpl.getId();
    AdminModule actualModule = adminSectionImpl.getModule();
    String actualName = adminSectionImpl.getName();
    List<AdminPermission> actualPermissions = adminSectionImpl.getPermissions();
    String actualSectionKey = adminSectionImpl.getSectionKey();
    String actualUrl = adminSectionImpl.getUrl();
    Boolean actualUseDefaultHandler = adminSectionImpl.getUseDefaultHandler();

    // Assert
    assertEquals("Ceiling Entity", actualCeilingEntity);
    assertEquals("Display Controller", actualDisplayController);
    assertEquals("Name", actualName);
    assertEquals("Section Key", actualSectionKey);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1, actualDisplayOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualPermissions.isEmpty());
    assertTrue(actualUseDefaultHandler);
    assertSame(permissions, actualPermissions);
    assertSame(resultModule, actualModule);
  }

  /**
   * Test {@link AdminSectionImpl#isFolderable()}.
   *
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSectionImpl#isFolderable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSectionImpl.isFolderable()"})
  public void testIsFolderable_givenAdminSectionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AdminSectionImpl().isFolderable());
  }

  /**
   * Test {@link AdminSectionImpl#isFolderable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSectionImpl#isFolderable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSectionImpl.isFolderable()"})
  public void testIsFolderable_thenReturnTrue() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setPermissions(new ArrayList<>());
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setFolderable(true);

    // Act and Assert
    assertTrue(adminSectionImpl.isFolderable());
  }

  /**
   * Test {@link AdminSectionImpl#setFolderable(boolean)}.
   *
   * <p>Method under test: {@link AdminSectionImpl#setFolderable(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSectionImpl.setFolderable(boolean)"})
  public void testSetFolderable() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();

    // Act
    adminSectionImpl.setFolderable(true);

    // Assert
    assertTrue(adminSectionImpl.folderable);
  }

  /**
   * Test {@link AdminSectionImpl#isFolderedByDefault()}.
   *
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSectionImpl#isFolderedByDefault()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSectionImpl.isFolderedByDefault()"})
  public void testIsFolderedByDefault_givenAdminSectionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AdminSectionImpl().isFolderedByDefault());
  }

  /**
   * Test {@link AdminSectionImpl#isFolderedByDefault()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSectionImpl#isFolderedByDefault()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSectionImpl.isFolderedByDefault()"})
  public void testIsFolderedByDefault_thenReturnTrue() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setPermissions(new ArrayList<>());
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setFolderedByDefault(true);

    // Act and Assert
    assertTrue(adminSectionImpl.isFolderedByDefault());
  }

  /**
   * Test {@link AdminSectionImpl#setFolderedByDefault(boolean)}.
   *
   * <p>Method under test: {@link AdminSectionImpl#setFolderedByDefault(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSectionImpl.setFolderedByDefault(boolean)"})
  public void testSetFolderedByDefault() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();

    // Act
    adminSectionImpl.setFolderedByDefault(true);

    // Assert
    assertTrue(adminSectionImpl.folderedByDefault);
  }

  /**
   * Test new {@link AdminSectionImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AdminSectionImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSectionImpl.<init>()"})
  public void testNewAdminSectionImpl() {
    // Arrange and Act
    AdminSectionImpl actualAdminSectionImpl = new AdminSectionImpl();

    // Assert
    assertNull(actualAdminSectionImpl.folderable);
    assertNull(actualAdminSectionImpl.folderedByDefault);
    assertNull(actualAdminSectionImpl.getDisplayOrder());
    assertNull(actualAdminSectionImpl.getId());
    assertNull(actualAdminSectionImpl.getCeilingEntity());
    assertNull(actualAdminSectionImpl.getDisplayController());
    assertNull(actualAdminSectionImpl.getName());
    assertNull(actualAdminSectionImpl.getSectionKey());
    assertNull(actualAdminSectionImpl.getUrl());
    assertNull(actualAdminSectionImpl.getModule());
    assertTrue(actualAdminSectionImpl.getPermissions().isEmpty());
    assertTrue(actualAdminSectionImpl.getUseDefaultHandler());
  }
}
