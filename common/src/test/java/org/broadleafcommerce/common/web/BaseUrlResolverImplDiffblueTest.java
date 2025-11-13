package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BaseUrlResolverImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseUrlResolverImplDiffblueTest {
  @Autowired private BaseUrlResolverImpl baseUrlResolverImpl;

  @MockBean private Environment environment;

  /**
   * Test {@link BaseUrlResolverImpl#getSiteBaseUrl()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code
   *       Property}.
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link BaseUrlResolverImpl#getSiteBaseUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseUrlResolverImpl.getSiteBaseUrl()"})
  public void testGetSiteBaseUrl_givenEnvironmentGetPropertyReturnProperty_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteBaseUrl = baseUrlResolverImpl.getSiteBaseUrl();

    // Assert
    verify(environment).getProperty("site.baseurl");
    assertEquals("Property", actualSiteBaseUrl);
  }

  /**
   * Test {@link BaseUrlResolverImpl#getAdminBaseUrl()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code
   *       Property}.
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link BaseUrlResolverImpl#getAdminBaseUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseUrlResolverImpl.getAdminBaseUrl()"})
  public void testGetAdminBaseUrl_givenEnvironmentGetPropertyReturnProperty_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualAdminBaseUrl = baseUrlResolverImpl.getAdminBaseUrl();

    // Assert
    verify(environment).getProperty("admin.baseurl");
    assertEquals("Property", actualAdminBaseUrl);
  }

  /**
   * Test new {@link BaseUrlResolverImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BaseUrlResolverImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseUrlResolverImpl.<init>()"})
  public void testNewBaseUrlResolverImpl() {
    // Arrange, Act and Assert
    assertNull(new BaseUrlResolverImpl().env);
  }
}
