package org.broadleafcommerce.common.config.service;

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

@ContextConfiguration(classes = {SystemPropertyServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemPropertyServiceExtensionManagerDiffblueTest {
  @Autowired private SystemPropertyServiceExtensionManager systemPropertyServiceExtensionManager;

  /**
   * Test {@link SystemPropertyServiceExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link SystemPropertyServiceExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemPropertyServiceExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertFalse(systemPropertyServiceExtensionManager.continueOnHandled());
  }
}
