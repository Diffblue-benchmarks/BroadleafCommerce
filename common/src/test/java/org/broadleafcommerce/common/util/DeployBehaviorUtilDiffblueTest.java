package org.broadleafcommerce.common.util;

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

@ContextConfiguration(classes = {DeployBehaviorUtil.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DeployBehaviorUtilDiffblueTest {
  @Autowired private DeployBehaviorUtil deployBehaviorUtil;

  /**
   * Test {@link DeployBehaviorUtil#isProductionSandBoxMode()}.
   *
   * <p>Method under test: {@link DeployBehaviorUtil#isProductionSandBoxMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeployBehaviorUtil.isProductionSandBoxMode()"})
  public void testIsProductionSandBoxMode() {
    // Arrange, Act and Assert
    assertFalse(deployBehaviorUtil.isProductionSandBoxMode());
  }
}
