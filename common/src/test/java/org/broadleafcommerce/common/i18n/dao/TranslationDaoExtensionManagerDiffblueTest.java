package org.broadleafcommerce.common.i18n.dao;

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

@ContextConfiguration(classes = {TranslationDaoExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationDaoExtensionManagerDiffblueTest {
  @Autowired private TranslationDaoExtensionManager translationDaoExtensionManager;

  /**
   * Test {@link TranslationDaoExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link TranslationDaoExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationDaoExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(translationDaoExtensionManager.continueOnHandled());
  }
}
