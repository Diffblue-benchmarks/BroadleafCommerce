package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminPermissionQualifiedEntityImplDiffblueTest {
  /**
   * Test {@link AdminPermissionQualifiedEntityImpl#clone()}.
   *
   * <p>Method under test: {@link AdminPermissionQualifiedEntityImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminPermissionQualifiedEntity AdminPermissionQualifiedEntityImpl.clone()"})
  public void testClone() {
    // Arrange and Act
    AdminPermissionQualifiedEntity actualCloneResult =
        new AdminPermissionQualifiedEntityImpl().clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionQualifiedEntityImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getCeilingEntityFullyQualifiedName());
    assertNull(actualCloneResult.getAdminPermission());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminPermissionQualifiedEntityImpl}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#setAdminPermission(AdminPermission)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#setCeilingEntityFullyQualifiedName(String)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#setId(Long)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getAdminPermission()}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getCeilingEntityFullyQualifiedName()}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionQualifiedEntityImpl.<init>()",
    "AdminPermission AdminPermissionQualifiedEntityImpl.getAdminPermission()",
    "String AdminPermissionQualifiedEntityImpl.getCeilingEntityFullyQualifiedName()",
    "Long AdminPermissionQualifiedEntityImpl.getId()",
    "void AdminPermissionQualifiedEntityImpl.setAdminPermission(AdminPermission)",
    "void AdminPermissionQualifiedEntityImpl.setCeilingEntityFullyQualifiedName(String)",
    "void AdminPermissionQualifiedEntityImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminPermissionQualifiedEntityImpl actualAdminPermissionQualifiedEntityImpl =
        new AdminPermissionQualifiedEntityImpl();
    AdminPermissionImpl adminPermission = new AdminPermissionImpl();
    actualAdminPermissionQualifiedEntityImpl.setAdminPermission(adminPermission);
    actualAdminPermissionQualifiedEntityImpl.setCeilingEntityFullyQualifiedName("Dr Jane Doe");
    actualAdminPermissionQualifiedEntityImpl.setId(1L);
    AdminPermission actualAdminPermission =
        actualAdminPermissionQualifiedEntityImpl.getAdminPermission();
    String actualCeilingEntityFullyQualifiedName =
        actualAdminPermissionQualifiedEntityImpl.getCeilingEntityFullyQualifiedName();

    // Assert
    assertEquals("Dr Jane Doe", actualCeilingEntityFullyQualifiedName);
    assertEquals(1L, actualAdminPermissionQualifiedEntityImpl.getId().longValue());
    assertSame(adminPermission, actualAdminPermission);
  }
}
