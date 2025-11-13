package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomUrlSiteMapGeneratorConfigurationImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       CustomUrlSiteMapGeneratorConfigurationImpl}
   *   <li>{@link CustomUrlSiteMapGeneratorConfigurationImpl#setCustomURLEntries(List)}
   *   <li>{@link CustomUrlSiteMapGeneratorConfigurationImpl#getCustomURLEntries()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGeneratorConfigurationImpl.<init>()",
    "List CustomUrlSiteMapGeneratorConfigurationImpl.getCustomURLEntries()",
    "void CustomUrlSiteMapGeneratorConfigurationImpl.setCustomURLEntries(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomUrlSiteMapGeneratorConfigurationImpl actualCustomUrlSiteMapGeneratorConfigurationImpl =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    actualCustomUrlSiteMapGeneratorConfigurationImpl.setCustomURLEntries(customURLEntries);
    List<SiteMapUrlEntry> actualCustomURLEntries =
        actualCustomUrlSiteMapGeneratorConfigurationImpl.getCustomURLEntries();

    // Assert
    assertNull(actualCustomUrlSiteMapGeneratorConfigurationImpl.getId());
    assertNull(actualCustomUrlSiteMapGeneratorConfigurationImpl.getSiteMapConfiguration());
    assertFalse(actualCustomUrlSiteMapGeneratorConfigurationImpl.isDisabled());
    assertTrue(actualCustomURLEntries.isEmpty());
    assertSame(customURLEntries, actualCustomURLEntries);
  }
}
