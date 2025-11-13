package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultLinkedDataGeneratorExtensionHandlerDiffblueTest {
  /**
   * Test {@link DefaultLinkedDataGeneratorExtensionHandler#getPriority()}.
   *
   * <p>Method under test: {@link DefaultLinkedDataGeneratorExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultLinkedDataGeneratorExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, new DefaultLinkedDataGeneratorExtensionHandler().getPriority());
  }
}
