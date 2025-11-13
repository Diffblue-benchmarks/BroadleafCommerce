package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapGeneratorConfigurationImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapGeneratorConfigurationImpl}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setDisabled(Boolean)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setId(Long)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setSiteMapConfiguration(SiteMapConfiguration)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#getId()}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#getSiteMapConfiguration()}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#isDisabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapGeneratorConfigurationImpl.<init>()",
    "Long SiteMapGeneratorConfigurationImpl.getId()",
    "SiteMapConfiguration SiteMapGeneratorConfigurationImpl.getSiteMapConfiguration()",
    "Boolean SiteMapGeneratorConfigurationImpl.isDisabled()",
    "void SiteMapGeneratorConfigurationImpl.setDisabled(Boolean)",
    "void SiteMapGeneratorConfigurationImpl.setId(Long)",
    "void SiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(SiteMapConfiguration)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapGeneratorConfigurationImpl actualSiteMapGeneratorConfigurationImpl =
        new SiteMapGeneratorConfigurationImpl();
    actualSiteMapGeneratorConfigurationImpl.setDisabled(true);
    actualSiteMapGeneratorConfigurationImpl.setId(1L);
    SiteMapConfigurationImpl siteMapConfiguration = new SiteMapConfigurationImpl();
    actualSiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(siteMapConfiguration);
    Long actualId = actualSiteMapGeneratorConfigurationImpl.getId();
    SiteMapConfiguration actualSiteMapConfiguration =
        actualSiteMapGeneratorConfigurationImpl.getSiteMapConfiguration();
    Boolean actualIsDisabledResult = actualSiteMapGeneratorConfigurationImpl.isDisabled();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertTrue(actualIsDisabledResult);
    assertSame(siteMapConfiguration, actualSiteMapConfiguration);
  }
}
