package org.broadleafcommerce.openadmin.server.security.extension;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultAdminSecurityServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultAdminSecurityServiceExtensionHandlerDiffblueTest {
  @MockBean(name = "blAdminSecurityServiceExtensionManager")
  private AdminSecurityServiceExtensionManager adminSecurityServiceExtensionManager;

  @Autowired
  private DefaultAdminSecurityServiceExtensionHandler defaultAdminSecurityServiceExtensionHandler;

  /**
   * Test {@link DefaultAdminSecurityServiceExtensionHandler#hasPrivilegesForOperation(AdminUser,
   * PermissionType, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * DefaultAdminSecurityServiceExtensionHandler#hasPrivilegesForOperation(AdminUser,
   * PermissionType, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType DefaultAdminSecurityServiceExtensionHandler.hasPrivilegesForOperation(AdminUser, PermissionType, ExtensionResultHolder)"
  })
  public void testHasPrivilegesForOperation() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        defaultAdminSecurityServiceExtensionHandler.hasPrivilegesForOperation(
            adminUser, PermissionType.ALL, erh));
  }
}
