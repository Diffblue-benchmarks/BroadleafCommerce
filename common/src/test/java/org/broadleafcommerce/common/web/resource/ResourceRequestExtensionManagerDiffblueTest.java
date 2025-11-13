package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ResourceRequestExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceRequestExtensionManagerDiffblueTest {
  @Autowired private ResourceRequestExtensionManager resourceRequestExtensionManager;

  /**
   * Test {@link ResourceRequestExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link ResourceRequestExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceRequestExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertFalse(resourceRequestExtensionManager.continueOnHandled());
  }
}
