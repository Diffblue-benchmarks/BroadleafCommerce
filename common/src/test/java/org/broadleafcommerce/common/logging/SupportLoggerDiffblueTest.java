package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SupportLoggerDiffblueTest {
  /**
   * Test {@link SupportLogger#getSupportLoggerAdapterFQCN()}.
   *
   * <p>Method under test: {@link SupportLogger#getSupportLoggerAdapterFQCN()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SupportLogger.getSupportLoggerAdapterFQCN()"})
  public void testGetSupportLoggerAdapterFQCN() {
    // Arrange, Act and Assert
    assertNull(SupportLogger.getSupportLoggerAdapterFQCN());
  }
}
