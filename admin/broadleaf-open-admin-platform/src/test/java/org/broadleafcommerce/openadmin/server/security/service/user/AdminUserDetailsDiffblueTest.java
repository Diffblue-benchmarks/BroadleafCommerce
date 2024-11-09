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
package org.broadleafcommerce.openadmin.server.security.service.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AdminUserDetailsDiffblueTest {
  @MockBean
  private AdminUserDetails adminUserDetails;

  /**
   * Test
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, Collection)}
   */
  @Test
  public void testNewAdminUserDetails_thenReturnAuthoritiesSizeIsOne() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    AdminUserDetails actualAdminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualAdminUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualAdminUserDetails.getPassword());
    assertEquals("janedoe", actualAdminUserDetails.getUsername());
    assertEquals(1L, actualAdminUserDetails.getId().longValue());
    assertTrue(actualAdminUserDetails.isAccountNonExpired());
    assertTrue(actualAdminUserDetails.isAccountNonLocked());
    assertTrue(actualAdminUserDetails.isCredentialsNonExpired());
    assertTrue(actualAdminUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, Collection)}
   */
  @Test
  public void testNewAdminUserDetails_thenReturnAuthoritiesSizeIsOne2() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    AdminUserDetails actualAdminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualAdminUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualAdminUserDetails.getPassword());
    assertEquals("janedoe", actualAdminUserDetails.getUsername());
    assertEquals(1L, actualAdminUserDetails.getId().longValue());
    assertTrue(actualAdminUserDetails.isAccountNonExpired());
    assertTrue(actualAdminUserDetails.isAccountNonLocked());
    assertTrue(actualAdminUserDetails.isCredentialsNonExpired());
    assertTrue(actualAdminUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, boolean, boolean, boolean, boolean, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  public void testNewAdminUserDetails_thenReturnAuthoritiesSizeIsOne3() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    AdminUserDetails actualAdminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", true, true, true, true,
        authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualAdminUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualAdminUserDetails.getPassword());
    assertEquals("janedoe", actualAdminUserDetails.getUsername());
    assertEquals(1L, actualAdminUserDetails.getId().longValue());
    assertTrue(actualAdminUserDetails.isAccountNonExpired());
    assertTrue(actualAdminUserDetails.isAccountNonLocked());
    assertTrue(actualAdminUserDetails.isCredentialsNonExpired());
    assertTrue(actualAdminUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, boolean, boolean, boolean, boolean, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  public void testNewAdminUserDetails_thenReturnAuthoritiesSizeIsOne4() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    AdminUserDetails actualAdminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", true, true, true, true,
        authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualAdminUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualAdminUserDetails.getPassword());
    assertEquals("janedoe", actualAdminUserDetails.getUsername());
    assertEquals(1L, actualAdminUserDetails.getId().longValue());
    assertTrue(actualAdminUserDetails.isAccountNonExpired());
    assertTrue(actualAdminUserDetails.isAccountNonLocked());
    assertTrue(actualAdminUserDetails.isCredentialsNonExpired());
    assertTrue(actualAdminUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Authorities Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, Collection)}
   */
  @Test
  public void testNewAdminUserDetails_whenArrayList_thenReturnAuthoritiesEmpty() {
    // Arrange and Act
    AdminUserDetails actualAdminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities = actualAdminUserDetails.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertEquals("iloveyou", actualAdminUserDetails.getPassword());
    assertEquals("janedoe", actualAdminUserDetails.getUsername());
    assertEquals(1L, actualAdminUserDetails.getId().longValue());
    assertTrue(authorities.isEmpty());
    assertTrue(actualAdminUserDetails.isAccountNonExpired());
    assertTrue(actualAdminUserDetails.isAccountNonLocked());
    assertTrue(actualAdminUserDetails.isCredentialsNonExpired());
    assertTrue(actualAdminUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, boolean, boolean, boolean, boolean, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Authorities Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserDetails#AdminUserDetails(Long, String, String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  public void testNewAdminUserDetails_whenArrayList_thenReturnAuthoritiesEmpty2() {
    // Arrange and Act
    AdminUserDetails actualAdminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", true, true, true, true,
        new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities = actualAdminUserDetails.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertEquals("iloveyou", actualAdminUserDetails.getPassword());
    assertEquals("janedoe", actualAdminUserDetails.getUsername());
    assertEquals(1L, actualAdminUserDetails.getId().longValue());
    assertTrue(authorities.isEmpty());
    assertTrue(actualAdminUserDetails.isAccountNonExpired());
    assertTrue(actualAdminUserDetails.isAccountNonLocked());
    assertTrue(actualAdminUserDetails.isCredentialsNonExpired());
    assertTrue(actualAdminUserDetails.isEnabled());
  }

  /**
   * Test {@link AdminUserDetails#withId(Long)}.
   * <p>
   * Method under test: {@link AdminUserDetails#withId(Long)}
   */
  @Test
  public void testWithId() {
    // Arrange
    AdminUserDetails adminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    // Act and Assert
    assertSame(adminUserDetails, adminUserDetails.withId(1L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserDetails#setId(Long)}
   *   <li>{@link AdminUserDetails#toString()}
   *   <li>{@link AdminUserDetails#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminUserDetails adminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    // Act
    adminUserDetails.setId(1L);
    String actualToStringResult = adminUserDetails.toString();

    // Assert that nothing has changed
    assertEquals("org.broadleafcommerce.openadmin.server.security.service.user.AdminUserDetails [Username=janedoe,"
        + " Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked"
        + "=true, Granted Authorities=[]]: Id: 1; ", actualToStringResult);
    assertEquals(1L, adminUserDetails.getId().longValue());
  }
}
