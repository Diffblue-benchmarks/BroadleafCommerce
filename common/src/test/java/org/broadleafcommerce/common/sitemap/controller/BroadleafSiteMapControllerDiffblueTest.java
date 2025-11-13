package org.broadleafcommerce.common.sitemap.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;

public class BroadleafSiteMapControllerDiffblueTest {
  /**
   * Test {@link BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSiteMapController.getRequestURIWithoutContext(HttpServletRequest)"
  })
  public void testGetRequestURIWithoutContext_givenNull() {
    // Arrange
    BroadleafSiteMapController broadleafSiteMapController = new BroadleafSiteMapController();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath(null);

    // Act
    String actualRequestURIWithoutContext =
        broadleafSiteMapController.getRequestURIWithoutContext(request);

    // Assert
    assertEquals("", actualRequestURIWithoutContext);
  }

  /**
   * Test {@link BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSiteMapController.getRequestURIWithoutContext(HttpServletRequest)"
  })
  public void testGetRequestURIWithoutContext_whenMockHttpServletRequest_thenReturnEmptyString() {
    // Arrange
    BroadleafSiteMapController broadleafSiteMapController = new BroadleafSiteMapController();

    // Act and Assert
    assertEquals(
        "", broadleafSiteMapController.getRequestURIWithoutContext(new MockHttpServletRequest()));
  }

  /**
   * Test new {@link BroadleafSiteMapController} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafSiteMapController}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafSiteMapController.<init>()"})
  public void testNewBroadleafSiteMapController() {
    // Arrange, Act and Assert
    assertNull(new BroadleafSiteMapController().siteMapService);
  }
}
