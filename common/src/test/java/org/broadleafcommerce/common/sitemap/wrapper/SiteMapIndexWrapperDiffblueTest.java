package org.broadleafcommerce.common.sitemap.wrapper;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapIndexWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapIndexWrapper}
   *   <li>{@link SiteMapIndexWrapper#setSiteMapWrappers(List)}
   *   <li>{@link SiteMapIndexWrapper#getSiteMapWrappers()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapIndexWrapper.<init>()",
    "List SiteMapIndexWrapper.getSiteMapWrappers()",
    "void SiteMapIndexWrapper.setSiteMapWrappers(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapIndexWrapper actualSiteMapIndexWrapper = new SiteMapIndexWrapper();
    ArrayList<SiteMapWrapper> siteMapWrappers = new ArrayList<>();
    actualSiteMapIndexWrapper.setSiteMapWrappers(siteMapWrappers);
    List<SiteMapWrapper> actualSiteMapWrappers = actualSiteMapIndexWrapper.getSiteMapWrappers();

    // Assert
    assertTrue(actualSiteMapWrappers.isEmpty());
    assertSame(siteMapWrappers, actualSiteMapWrappers);
  }
}
