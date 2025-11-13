package org.broadleafcommerce.common.sitemap.wrapper;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapWrapper}
   *   <li>{@link SiteMapWrapper#setLastmod(String)}
   *   <li>{@link SiteMapWrapper#setLoc(String)}
   *   <li>{@link SiteMapWrapper#getLastmod()}
   *   <li>{@link SiteMapWrapper#getLoc()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapWrapper.<init>()",
    "String SiteMapWrapper.getLastmod()",
    "String SiteMapWrapper.getLoc()",
    "void SiteMapWrapper.setLastmod(String)",
    "void SiteMapWrapper.setLoc(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapWrapper actualSiteMapWrapper = new SiteMapWrapper();
    actualSiteMapWrapper.setLastmod("Lastmod");
    actualSiteMapWrapper.setLoc("Loc");
    String actualLastmod = actualSiteMapWrapper.getLastmod();

    // Assert
    assertEquals("Lastmod", actualLastmod);
    assertEquals("Loc", actualSiteMapWrapper.getLoc());
  }
}
