package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomerUserDetailsDiffblueTest {
  /**
   * Test {@link CustomerUserDetails#CustomerUserDetails(Long, String, String, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities size is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomerUserDetails#CustomerUserDetails(Long, String, String,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerUserDetails.<init>(Long, String, String, Collection)"})
  public void testNewCustomerUserDetails_thenReturnAuthoritiesSizeIsOne() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    CustomerUserDetails actualCustomerUserDetails =
        new CustomerUserDetails(1L, "janedoe", "iloveyou", authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualCustomerUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualCustomerUserDetails.getPassword());
    assertEquals("janedoe", actualCustomerUserDetails.getUsername());
    assertEquals(1L, actualCustomerUserDetails.getId().longValue());
    assertTrue(actualCustomerUserDetails.isAccountNonExpired());
    assertTrue(actualCustomerUserDetails.isAccountNonLocked());
    assertTrue(actualCustomerUserDetails.isCredentialsNonExpired());
    assertTrue(actualCustomerUserDetails.isEnabled());
  }

  /**
   * Test {@link CustomerUserDetails#CustomerUserDetails(Long, String, String, boolean, boolean,
   * boolean, boolean, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities size is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomerUserDetails#CustomerUserDetails(Long, String, String,
   * boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerUserDetails.<init>(Long, String, String, boolean, boolean, boolean, boolean, Collection)"
  })
  public void testNewCustomerUserDetails_thenReturnAuthoritiesSizeIsOne2() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    CustomerUserDetails actualCustomerUserDetails =
        new CustomerUserDetails(1L, "janedoe", "iloveyou", true, true, true, true, authorities);

    // Assert
    Collection<GrantedAuthority> authorities2 = actualCustomerUserDetails.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertEquals("iloveyou", actualCustomerUserDetails.getPassword());
    assertEquals("janedoe", actualCustomerUserDetails.getUsername());
    assertEquals(1L, actualCustomerUserDetails.getId().longValue());
    assertTrue(actualCustomerUserDetails.isAccountNonExpired());
    assertTrue(actualCustomerUserDetails.isAccountNonLocked());
    assertTrue(actualCustomerUserDetails.isCredentialsNonExpired());
    assertTrue(actualCustomerUserDetails.isEnabled());
  }

  /**
   * Test {@link CustomerUserDetails#CustomerUserDetails(Long, String, String, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Authorities Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomerUserDetails#CustomerUserDetails(Long, String, String,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerUserDetails.<init>(Long, String, String, Collection)"})
  public void testNewCustomerUserDetails_whenArrayList_thenReturnAuthoritiesEmpty() {
    // Arrange and Act
    CustomerUserDetails actualCustomerUserDetails =
        new CustomerUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities = actualCustomerUserDetails.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertEquals("iloveyou", actualCustomerUserDetails.getPassword());
    assertEquals("janedoe", actualCustomerUserDetails.getUsername());
    assertEquals(1L, actualCustomerUserDetails.getId().longValue());
    assertTrue(authorities.isEmpty());
    assertTrue(actualCustomerUserDetails.isAccountNonExpired());
    assertTrue(actualCustomerUserDetails.isAccountNonLocked());
    assertTrue(actualCustomerUserDetails.isCredentialsNonExpired());
    assertTrue(actualCustomerUserDetails.isEnabled());
  }

  /**
   * Test {@link CustomerUserDetails#CustomerUserDetails(Long, String, String, boolean, boolean,
   * boolean, boolean, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Authorities Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomerUserDetails#CustomerUserDetails(Long, String, String,
   * boolean, boolean, boolean, boolean, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerUserDetails.<init>(Long, String, String, boolean, boolean, boolean, boolean, Collection)"
  })
  public void testNewCustomerUserDetails_whenArrayList_thenReturnAuthoritiesEmpty2() {
    // Arrange and Act
    CustomerUserDetails actualCustomerUserDetails =
        new CustomerUserDetails(
            1L, "janedoe", "iloveyou", true, true, true, true, new ArrayList<>());

    // Assert
    Collection<GrantedAuthority> authorities = actualCustomerUserDetails.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertEquals("iloveyou", actualCustomerUserDetails.getPassword());
    assertEquals("janedoe", actualCustomerUserDetails.getUsername());
    assertEquals(1L, actualCustomerUserDetails.getId().longValue());
    assertTrue(authorities.isEmpty());
    assertTrue(actualCustomerUserDetails.isAccountNonExpired());
    assertTrue(actualCustomerUserDetails.isAccountNonLocked());
    assertTrue(actualCustomerUserDetails.isCredentialsNonExpired());
    assertTrue(actualCustomerUserDetails.isEnabled());
  }

  /**
   * Test {@link CustomerUserDetails#withId(Long)}.
   *
   * <p>Method under test: {@link CustomerUserDetails#withId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerUserDetails CustomerUserDetails.withId(Long)"})
  public void testWithId() {
    // Arrange
    CustomerUserDetails customerUserDetails =
        new CustomerUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    // Act
    CustomerUserDetails actualWithIdResult = customerUserDetails.withId(1L);

    // Assert
    assertSame(customerUserDetails, actualWithIdResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerUserDetails#setId(Long)}
   *   <li>{@link CustomerUserDetails#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomerUserDetails.getId()", "void CustomerUserDetails.setId(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    CustomerUserDetails customerUserDetails =
        new CustomerUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    // Act
    customerUserDetails.setId(1L);

    // Assert
    assertEquals(1L, customerUserDetails.getId().longValue());
  }
}
