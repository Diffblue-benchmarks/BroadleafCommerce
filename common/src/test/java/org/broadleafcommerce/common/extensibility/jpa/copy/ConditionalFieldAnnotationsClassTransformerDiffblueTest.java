package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConditionalFieldAnnotationsClassTransformerDiffblueTest {
  /**
   * Test {@link
   * ConditionalFieldAnnotationsClassTransformer#ConditionalFieldAnnotationsClassTransformer(String)}.
   *
   * <p>Method under test: {@link
   * ConditionalFieldAnnotationsClassTransformer#ConditionalFieldAnnotationsClassTransformer(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConditionalFieldAnnotationsClassTransformer.<init>(String)"})
  public void testNewConditionalFieldAnnotationsClassTransformer() {
    // Arrange and Act
    ConditionalFieldAnnotationsClassTransformer actualConditionalFieldAnnotationsClassTransformer =
        new ConditionalFieldAnnotationsClassTransformer("Module Name");

    // Assert
    assertEquals("Module Name", actualConditionalFieldAnnotationsClassTransformer.moduleName);
    assertNull(actualConditionalFieldAnnotationsClassTransformer.manager);
    assertTrue(
        actualConditionalFieldAnnotationsClassTransformer.preLoadClassNamePatterns.isEmpty());
  }
}
