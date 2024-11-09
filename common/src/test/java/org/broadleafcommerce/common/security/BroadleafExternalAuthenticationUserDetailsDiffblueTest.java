/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class BroadleafExternalAuthenticationUserDetailsDiffblueTest {
  @MockBean
  private BroadleafExternalAuthenticationUserDetails broadleafExternalAuthenticationUserDetails;

  /**
   * Test
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, Collection)}.
   * <ul>
   *   <li>Then return Authorities Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, Collection)}
   */
  @Test
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesEmpty() {
    // Arrange and Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails = new BroadleafExternalAuthenticationUserDetails(
        "janedoe", "iloveyou", new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities = actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertEquals("iloveyou", actualBroadleafExternalAuthenticationUserDetails.getPassword());
    assertEquals("janedoe", actualBroadleafExternalAuthenticationUserDetails.getUsername());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getEmail());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getFirstName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getLastName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getSite());
    assertTrue(authorities.isEmpty());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonLocked());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isCredentialsNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, boolean, boolean, boolean, boolean, Collection)}.
   * <ul>
   *   <li>Then return Authorities Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesEmpty2() {
    // Arrange and Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails = new BroadleafExternalAuthenticationUserDetails(
        "janedoe", "iloveyou", true, true, true, true, new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities = actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertEquals("iloveyou", actualBroadleafExternalAuthenticationUserDetails.getPassword());
    assertEquals("janedoe", actualBroadleafExternalAuthenticationUserDetails.getUsername());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getEmail());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getFirstName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getLastName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getSite());
    assertTrue(authorities.isEmpty());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonLocked());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isCredentialsNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, Collection)}
   */
  @Test
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails = new BroadleafExternalAuthenticationUserDetails(
        "janedoe", "iloveyou", authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualBroadleafExternalAuthenticationUserDetails.getPassword());
    assertEquals("janedoe", actualBroadleafExternalAuthenticationUserDetails.getUsername());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getEmail());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getFirstName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getLastName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getSite());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonLocked());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isCredentialsNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, Collection)}
   */
  @Test
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne2() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails = new BroadleafExternalAuthenticationUserDetails(
        "janedoe", "iloveyou", authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualBroadleafExternalAuthenticationUserDetails.getPassword());
    assertEquals("janedoe", actualBroadleafExternalAuthenticationUserDetails.getUsername());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getEmail());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getFirstName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getLastName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getSite());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonLocked());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isCredentialsNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, boolean, boolean, boolean, boolean, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne3() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails = new BroadleafExternalAuthenticationUserDetails(
        "janedoe", "iloveyou", true, true, true, true, authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualBroadleafExternalAuthenticationUserDetails.getPassword());
    assertEquals("janedoe", actualBroadleafExternalAuthenticationUserDetails.getUsername());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getEmail());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getFirstName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getLastName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getSite());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonLocked());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isCredentialsNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isEnabled());
  }

  /**
   * Test
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, boolean, boolean, boolean, boolean, Collection)}.
   * <ul>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String, String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne4() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails = new BroadleafExternalAuthenticationUserDetails(
        "janedoe", "iloveyou", true, true, true, true, authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualBroadleafExternalAuthenticationUserDetails.getPassword());
    assertEquals("janedoe", actualBroadleafExternalAuthenticationUserDetails.getUsername());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getEmail());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getFirstName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getLastName());
    assertNull(actualBroadleafExternalAuthenticationUserDetails.getSite());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isAccountNonLocked());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isCredentialsNonExpired());
    assertTrue(actualBroadleafExternalAuthenticationUserDetails.isEnabled());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#setEmail(String)}
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#setFirstName(String)}
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#setLastName(String)}
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#setSite(Site)}
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#getEmail()}
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#getFirstName()}
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#getLastName()}
   *   <li>{@link BroadleafExternalAuthenticationUserDetails#getSite()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafExternalAuthenticationUserDetails broadleafExternalAuthenticationUserDetails = new BroadleafExternalAuthenticationUserDetails(
        "janedoe", "iloveyou", new ArrayList<>());

    // Act
    broadleafExternalAuthenticationUserDetails.setEmail("jane.doe@example.org");
    broadleafExternalAuthenticationUserDetails.setFirstName("Jane");
    broadleafExternalAuthenticationUserDetails.setLastName("Doe");
    SiteImpl site = new SiteImpl();
    broadleafExternalAuthenticationUserDetails.setSite(site);
    String actualEmail = broadleafExternalAuthenticationUserDetails.getEmail();
    String actualFirstName = broadleafExternalAuthenticationUserDetails.getFirstName();
    String actualLastName = broadleafExternalAuthenticationUserDetails.getLastName();

    // Assert that nothing has changed
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertSame(site, broadleafExternalAuthenticationUserDetails.getSite());
  }
}
