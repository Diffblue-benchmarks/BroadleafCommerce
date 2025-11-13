package org.broadleafcommerce.common.sitemap.wrapper;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapImageWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapImageWrapper}
   *   <li>{@link SiteMapImageWrapper#setLoc(String)}
   *   <li>{@link SiteMapImageWrapper#getLoc()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapImageWrapper.<init>()",
    "String SiteMapImageWrapper.getLoc()",
    "void SiteMapImageWrapper.setLoc(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapImageWrapper actualSiteMapImageWrapper = new SiteMapImageWrapper();
    actualSiteMapImageWrapper.setLoc("Loc");

    // Assert
    assertEquals("Loc", actualSiteMapImageWrapper.getLoc());
  }
}
