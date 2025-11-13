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

public class SiteMapURLSetWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapURLSetWrapper}
   *   <li>{@link SiteMapURLSetWrapper#setSiteMapUrlWrappers(List)}
   *   <li>{@link SiteMapURLSetWrapper#getSiteMapUrlWrappers()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapURLSetWrapper.<init>()",
    "List SiteMapURLSetWrapper.getSiteMapUrlWrappers()",
    "void SiteMapURLSetWrapper.setSiteMapUrlWrappers(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapURLSetWrapper actualSiteMapURLSetWrapper = new SiteMapURLSetWrapper();
    ArrayList<SiteMapURLWrapper> siteMapUrlWrappers = new ArrayList<>();
    actualSiteMapURLSetWrapper.setSiteMapUrlWrappers(siteMapUrlWrappers);
    List<SiteMapURLWrapper> actualSiteMapUrlWrappers =
        actualSiteMapURLSetWrapper.getSiteMapUrlWrappers();

    // Assert
    assertTrue(actualSiteMapUrlWrappers.isEmpty());
    assertSame(siteMapUrlWrappers, actualSiteMapUrlWrappers);
  }
}
