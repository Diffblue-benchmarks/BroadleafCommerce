package org.broadleafcommerce.cms.structure.service;

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

@ContextConfiguration(classes = {StructuredContentServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentServiceExtensionManagerDiffblueTest {
  @Autowired
  private StructuredContentServiceExtensionManager structuredContentServiceExtensionManager;

  /**
   * Test {@link StructuredContentServiceExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link StructuredContentServiceExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(structuredContentServiceExtensionManager.continueOnHandled());
  }
}
