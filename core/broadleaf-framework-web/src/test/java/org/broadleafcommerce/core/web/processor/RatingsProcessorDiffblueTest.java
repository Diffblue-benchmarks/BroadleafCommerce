package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RatingsProcessorDiffblueTest {
  /**
   * Test {@link RatingsProcessor#getName()}.
   *
   * <p>Method under test: {@link RatingsProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RatingsProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ratings", new RatingsProcessor().getName());
  }

  /**
   * Test {@link RatingsProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link RatingsProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RatingsProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new RatingsProcessor().getPrecedence());
  }
}
