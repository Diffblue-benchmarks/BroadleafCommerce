package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConfigVariableProcessorDiffblueTest {
  /**
   * Test {@link ConfigVariableProcessor#getName()}.
   *
   * <p>Method under test: {@link ConfigVariableProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ConfigVariableProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("config", new ConfigVariableProcessor().getName());
  }

  /**
   * Test {@link ConfigVariableProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ConfigVariableProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigVariableProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new ConfigVariableProcessor().getPrecedence());
  }
}
