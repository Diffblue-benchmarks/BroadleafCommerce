package org.broadleafcommerce.core.web.resolver;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DatabaseResourceResolverExtensionManagerDiffblueTest {
  /**
   * Test {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DatabaseResourceResolverExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertFalse(new DatabaseResourceResolverExtensionManager().continueOnHandled());
  }
}
