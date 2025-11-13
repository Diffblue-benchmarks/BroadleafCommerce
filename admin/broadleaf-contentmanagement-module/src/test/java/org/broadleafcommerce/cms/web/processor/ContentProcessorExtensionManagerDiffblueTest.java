package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContentProcessorExtensionManagerDiffblueTest {
  /**
   * Test {@link ContentProcessorExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link ContentProcessorExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContentProcessorExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(new ContentProcessorExtensionManager().continueOnHandled());
  }
}
