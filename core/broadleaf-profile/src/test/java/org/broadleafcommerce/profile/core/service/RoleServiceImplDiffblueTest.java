package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.dao.RoleDao;
import org.broadleafcommerce.profile.core.domain.CustomerRole;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplDiffblueTest {
  @Mock private RoleDao roleDao;

  @InjectMocks private RoleServiceImpl roleServiceImpl;

  /**
   * Test {@link RoleServiceImpl#findCustomerRolesByCustomerId(Long)}.
   *
   * <p>Method under test: {@link RoleServiceImpl#findCustomerRolesByCustomerId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoleServiceImpl.findCustomerRolesByCustomerId(Long)"})
  public void testFindCustomerRolesByCustomerId() {
    // Arrange
    when(roleDao.readCustomerRolesByCustomerId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<CustomerRole> actualFindCustomerRolesByCustomerIdResult =
        roleServiceImpl.findCustomerRolesByCustomerId(1L);

    // Assert
    verify(roleDao).readCustomerRolesByCustomerId(1L);
    assertTrue(actualFindCustomerRolesByCustomerIdResult.isEmpty());
  }
}
