package org.broadleafcommerce.common.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class BroadleafExternalAuthenticationUserDetailsDiffblueTest {
  /**
   * Test {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafExternalAuthenticationUserDetails.<init>(String, String, Collection)"
  })
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesEmpty() {
    // Arrange and Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities =
        actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
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
   * Test {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, boolean, boolean, boolean, boolean, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafExternalAuthenticationUserDetails.<init>(String, String, boolean, boolean, boolean, boolean, Collection)"
  })
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesEmpty2() {
    // Arrange and Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails =
        new BroadleafExternalAuthenticationUserDetails(
            "janedoe", "iloveyou", true, true, true, true, new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities =
        actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
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
   * Test {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafExternalAuthenticationUserDetails.<init>(String, String, Collection)"
  })
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 =
        actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
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
   * Test {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafExternalAuthenticationUserDetails.<init>(String, String, Collection)"
  })
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne2() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 =
        actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
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
   * Test {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, boolean, boolean, boolean, boolean, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafExternalAuthenticationUserDetails.<init>(String, String, boolean, boolean, boolean, boolean, Collection)"
  })
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne3() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails =
        new BroadleafExternalAuthenticationUserDetails(
            "janedoe", "iloveyou", true, true, true, true, authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 =
        actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
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
   * Test {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, boolean, boolean, boolean, boolean, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafExternalAuthenticationUserDetails#BroadleafExternalAuthenticationUserDetails(String,
   * String, boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafExternalAuthenticationUserDetails.<init>(String, String, boolean, boolean, boolean, boolean, Collection)"
  })
  public void testNewBroadleafExternalAuthenticationUserDetails_thenReturnAuthoritiesSizeIsOne4() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    BroadleafExternalAuthenticationUserDetails actualBroadleafExternalAuthenticationUserDetails =
        new BroadleafExternalAuthenticationUserDetails(
            "janedoe", "iloveyou", true, true, true, true, authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 =
        actualBroadleafExternalAuthenticationUserDetails.getAuthorities();
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafExternalAuthenticationUserDetails.getEmail()",
    "String BroadleafExternalAuthenticationUserDetails.getFirstName()",
    "String BroadleafExternalAuthenticationUserDetails.getLastName()",
    "Site BroadleafExternalAuthenticationUserDetails.getSite()",
    "void BroadleafExternalAuthenticationUserDetails.setEmail(String)",
    "void BroadleafExternalAuthenticationUserDetails.setFirstName(String)",
    "void BroadleafExternalAuthenticationUserDetails.setLastName(String)",
    "void BroadleafExternalAuthenticationUserDetails.setSite(Site)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafExternalAuthenticationUserDetails broadleafExternalAuthenticationUserDetails =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act
    broadleafExternalAuthenticationUserDetails.setEmail("jane.doe@example.org");
    broadleafExternalAuthenticationUserDetails.setFirstName("Jane");
    broadleafExternalAuthenticationUserDetails.setLastName("Doe");
    SiteImpl site = new SiteImpl();
    broadleafExternalAuthenticationUserDetails.setSite(site);
    String actualEmail = broadleafExternalAuthenticationUserDetails.getEmail();
    String actualFirstName = broadleafExternalAuthenticationUserDetails.getFirstName();
    String actualLastName = broadleafExternalAuthenticationUserDetails.getLastName();

    // Assert
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertSame(site, broadleafExternalAuthenticationUserDetails.getSite());
  }
}
