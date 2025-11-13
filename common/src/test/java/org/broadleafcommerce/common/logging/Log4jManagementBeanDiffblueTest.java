package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Log4jManagementBean.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Log4jManagementBeanDiffblueTest {
  @Autowired private Log4jManagementBean log4jManagementBean;

  /**
   * Test {@link Log4jManagementBean#getLevel(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link AbstractSupportLoggerAdapter#INFO}.
   * </ul>
   *
   * <p>Method under test: {@link Log4jManagementBean#getLevel(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Log4jManagementBean.getLevel(String)"})
  public void testGetLevel_whenNull_thenReturnInfo() {
    // Arrange, Act and Assert
    assertEquals(AbstractSupportLoggerAdapter.INFO, log4jManagementBean.getLevel(null));
  }
}
