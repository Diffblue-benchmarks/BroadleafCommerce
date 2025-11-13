package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ToggleFacetLinkProcessorDiffblueTest {
  /**
   * Test {@link ToggleFacetLinkProcessor#getName()}.
   *
   * <p>Method under test: {@link ToggleFacetLinkProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ToggleFacetLinkProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("togglefacetlink", new ToggleFacetLinkProcessor().getName());
  }

  /**
   * Test {@link ToggleFacetLinkProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ToggleFacetLinkProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ToggleFacetLinkProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new ToggleFacetLinkProcessor().getPrecedence());
  }
}
