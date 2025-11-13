package org.broadleafcommerce.core.order.dao;

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

@ContextConfiguration(classes = {OrderDaoExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderDaoExtensionManagerDiffblueTest {
  @Autowired private OrderDaoExtensionManager orderDaoExtensionManager;

  /**
   * Test {@link OrderDaoExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link OrderDaoExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderDaoExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(orderDaoExtensionManager.continueOnHandled());
  }
}
