package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractSiteMapExtensionHandlerDiffblueTest {
  /**
   * Test new {@link AbstractSiteMapExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractSiteMapExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSiteMapExtensionHandler.<init>()"})
  public void testNewAbstractSiteMapExtensionHandler() {
    // Arrange and Act
    AbstractSiteMapExtensionHandler actualAbstractSiteMapExtensionHandler =
        new AbstractSiteMapExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractSiteMapExtensionHandler.getPriority());
    assertTrue(actualAbstractSiteMapExtensionHandler.isEnabled());
  }
}
