package org.broadleafcommerce.common.template;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TemplateOverrideExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TemplateOverrideExtensionManagerDiffblueTest {
  @Autowired private TemplateOverrideExtensionManager templateOverrideExtensionManager;

  /**
   * Test {@link TemplateOverrideExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link TemplateOverrideExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TemplateOverrideExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(templateOverrideExtensionManager.continueOnHandled());
  }
}
