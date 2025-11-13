package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnEhCacheMissingConditionDiffblueTest {
  /**
   * Test {@link OnEhCacheMissingCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   *
   * <p>Method under test: {@link OnEhCacheMissingCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OnEhCacheMissingCondition.matches(ConditionContext, AnnotatedTypeMetadata)"
  })
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse(
        new OnEhCacheMissingCondition()
            .matches(mock(ConditionContext.class), mock(AnnotatedTypeMetadata.class)));
  }
}
