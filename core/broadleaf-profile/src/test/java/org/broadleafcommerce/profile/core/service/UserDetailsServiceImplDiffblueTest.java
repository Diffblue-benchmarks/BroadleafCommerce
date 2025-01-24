package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.CustomerRole;
import org.broadleafcommerce.profile.core.domain.CustomerRoleImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailsServiceImplDiffblueTest {
  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImpl;

  /**
   * Test {@link UserDetailsServiceImpl#loadUserByUsername(String)}.
   * <p>
   * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLoadUserByUsername() throws DataAccessException, UsernameNotFoundException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4526 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.UserDetailsServiceImpl userDetailsServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UserDetailsServiceImpl()).loadUserByUsername("janedoe");
  }

  /**
   * Test {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}.
   * <p>
   * Method under test:
   * {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateGrantedAuthorities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4521 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.UserDetailsServiceImpl userDetailsServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UserDetailsServiceImpl userDetailsServiceImpl2 = new UserDetailsServiceImpl();

    // Act
    userDetailsServiceImpl2.createGrantedAuthorities(new ArrayList<>());
  }

  /**
   * Test {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}.
   * <ul>
   *   <li>Given {@link CustomerRoleImpl} {@link CustomerRoleImpl#getRoleName()}
   * return {@code ROLE_USER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}
   */
  @Test
  public void testCreateGrantedAuthorities_givenCustomerRoleImplGetRoleNameReturnRoleUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();
    CustomerRoleImpl customerRoleImpl = mock(CustomerRoleImpl.class);
    when(customerRoleImpl.getRoleName()).thenReturn("ROLE_USER");

    ArrayList<CustomerRole> customerRoles = new ArrayList<>();
    customerRoles.add(customerRoleImpl);

    // Act
    List<GrantedAuthority> actualCreateGrantedAuthoritiesResult = userDetailsServiceImpl
        .createGrantedAuthorities(customerRoles);

    // Assert
    verify(customerRoleImpl, atLeast(1)).getRoleName();
    assertEquals(1, actualCreateGrantedAuthoritiesResult.size());
    GrantedAuthority getResult = actualCreateGrantedAuthoritiesResult.get(0);
    assertTrue(getResult instanceof SimpleGrantedAuthority);
    assertEquals("ROLE_USER", getResult.toString());
    assertEquals("ROLE_USER", getResult.getAuthority());
  }

  /**
   * Test {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}
   */
  @Test
  public void testCreateGrantedAuthorities_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();
    CustomerRoleImpl customerRoleImpl = mock(CustomerRoleImpl.class);
    when(customerRoleImpl.getRoleName()).thenReturn("Role Name");

    ArrayList<CustomerRole> customerRoles = new ArrayList<>();
    customerRoles.add(customerRoleImpl);

    // Act
    List<GrantedAuthority> actualCreateGrantedAuthoritiesResult = userDetailsServiceImpl
        .createGrantedAuthorities(customerRoles);

    // Assert
    verify(customerRoleImpl, atLeast(1)).getRoleName();
    assertEquals(2, actualCreateGrantedAuthoritiesResult.size());
    GrantedAuthority getResult = actualCreateGrantedAuthoritiesResult.get(0);
    assertTrue(getResult instanceof SimpleGrantedAuthority);
    GrantedAuthority getResult2 = actualCreateGrantedAuthoritiesResult.get(1);
    assertTrue(getResult2 instanceof SimpleGrantedAuthority);
    assertEquals("ROLE_USER", getResult2.toString());
    assertEquals("ROLE_USER", getResult2.getAuthority());
    assertEquals("Role Name", getResult.toString());
    assertEquals("Role Name", getResult.getAuthority());
  }

  /**
   * Test {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}
   */
  @Test
  public void testCreateGrantedAuthorities_whenArrayList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();

    // Act
    List<GrantedAuthority> actualCreateGrantedAuthoritiesResult = userDetailsServiceImpl
        .createGrantedAuthorities(new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateGrantedAuthoritiesResult.size());
    GrantedAuthority getResult = actualCreateGrantedAuthoritiesResult.get(0);
    assertTrue(getResult instanceof SimpleGrantedAuthority);
    assertEquals("ROLE_USER", getResult.toString());
    assertEquals("ROLE_USER", getResult.getAuthority());
  }
}
