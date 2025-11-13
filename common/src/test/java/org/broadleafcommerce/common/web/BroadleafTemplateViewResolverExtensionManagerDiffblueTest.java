package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafTemplateViewResolverExtensionManagerDiffblueTest {
  /**
   * Test {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}.
   *
   * <p>Method under test: {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List BroadleafTemplateViewResolverExtensionManager.getHandlers()"})
  public void testGetHandlers() {
    // Arrange, Act and Assert
    assertTrue(new BroadleafTemplateViewResolverExtensionManager().getHandlers().isEmpty());
  }

  /**
   * Test {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafTemplateViewResolverExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(new BroadleafTemplateViewResolverExtensionManager().continueOnHandled());
  }
}
