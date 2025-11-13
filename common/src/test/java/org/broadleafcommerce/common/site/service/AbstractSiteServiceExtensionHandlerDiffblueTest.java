package org.broadleafcommerce.common.site.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractSiteServiceExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractSiteServiceExtensionHandler#contributeNonPersitentSiteProperties(Site,
   * Site)}.
   *
   * <p>Method under test: {@link
   * AbstractSiteServiceExtensionHandler#contributeNonPersitentSiteProperties(Site, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractSiteServiceExtensionHandler.contributeNonPersitentSiteProperties(Site, Site)"
  })
  public void testContributeNonPersitentSiteProperties() {
    // Arrange
    AbstractSiteServiceExtensionHandler abstractSiteServiceExtensionHandler =
        new AbstractSiteServiceExtensionHandler();
    SiteImpl from = new SiteImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractSiteServiceExtensionHandler.contributeNonPersitentSiteProperties(
            from, new SiteImpl()));
  }

  /**
   * Test new {@link AbstractSiteServiceExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractSiteServiceExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSiteServiceExtensionHandler.<init>()"})
  public void testNewAbstractSiteServiceExtensionHandler() {
    // Arrange and Act
    AbstractSiteServiceExtensionHandler actualAbstractSiteServiceExtensionHandler =
        new AbstractSiteServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractSiteServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractSiteServiceExtensionHandler.isEnabled());
  }
}
