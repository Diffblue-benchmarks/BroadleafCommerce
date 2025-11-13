package org.broadleafcommerce.cms.page.service;

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

@ContextConfiguration(classes = {PageServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageServiceExtensionManagerDiffblueTest {
  @Autowired private PageServiceExtensionManager pageServiceExtensionManager;

  /**
   * Test {@link PageServiceExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link PageServiceExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageServiceExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertFalse(pageServiceExtensionManager.continueOnHandled());
  }
}
