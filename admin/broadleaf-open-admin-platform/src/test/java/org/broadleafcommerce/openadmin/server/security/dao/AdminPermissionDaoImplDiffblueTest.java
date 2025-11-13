package org.broadleafcommerce.openadmin.server.security.dao;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminPermissionDaoImplDiffblueTest {
  @InjectMocks private AdminPermissionDaoImpl adminPermissionDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link AdminPermissionDaoImpl#readAdminPermissionById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionDaoImpl#readAdminPermissionById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.security.domain.AdminPermission AdminPermissionDaoImpl.readAdminPermissionById(Long)"
  })
  public void testReadAdminPermissionById_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminPermissionDaoImpl.readAdminPermissionById(1L));
    verify(entityConfiguration)
        .lookupEntityClass(
            "org.broadleafcommerce.openadmin.server.security.domain.AdminPermission");
  }

  /**
   * Test {@link AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntity(AdminUser,
   * PermissionType, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntity(AdminUser, PermissionType,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminPermissionDaoImpl.isUserQualifiedForOperationOnCeilingEntity(AdminUser, PermissionType, String)"
  })
  public void testIsUserQualifiedForOperationOnCeilingEntity_thenThrowRuntimeException() {
    // Arrange
    AdminPermissionDaoImpl adminPermissionDaoImpl = new AdminPermissionDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminPermissionDaoImpl.isUserQualifiedForOperationOnCeilingEntity(
                new AdminUserImpl(), PermissionType.ALL, "Dr Jane Doe"));
  }

  /**
   * Test {@link
   * AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions(String)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminPermissionDaoImpl.isUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions(String)"
  })
  public void testIsUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new AdminPermissionDaoImpl()
                .isUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminPermissionDaoImpl#doesOperationExistForCeilingEntity(PermissionType, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionDaoImpl#doesOperationExistForCeilingEntity(PermissionType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminPermissionDaoImpl.doesOperationExistForCeilingEntity(PermissionType, String)"
  })
  public void testDoesOperationExistForCeilingEntity_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new AdminPermissionDaoImpl()
                .doesOperationExistForCeilingEntity(PermissionType.ALL, "Dr Jane Doe"));
  }
}
