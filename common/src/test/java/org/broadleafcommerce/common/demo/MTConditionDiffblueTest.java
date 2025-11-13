package org.broadleafcommerce.common.demo;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MTConditionDiffblueTest {
  /**
   * Test {@link MTCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   *
   * <p>Method under test: {@link MTCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MTCondition.matches(ConditionContext, AnnotatedTypeMetadata)"})
  public void testMatches() {
    // Arrange
    MTCondition mtCondition = new MTCondition();

    ConditionContext context = mock(ConditionContext.class);
    when(context.getClassLoader()).thenReturn(new JarClassLoader());

    // Act
    boolean actualMatchesResult = mtCondition.matches(context, mock(AnnotatedTypeMetadata.class));

    // Assert
    verify(context).getClassLoader();
    assertFalse(actualMatchesResult);
  }
}
