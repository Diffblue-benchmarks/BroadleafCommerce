package org.broadleafcommerce.common.demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ImportConditionDiffblueTest {
  /**
   * Test {@link ImportCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link StandardReactiveWebEnvironment#StandardReactiveWebEnvironment()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImportCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImportCondition.matches(ConditionContext, AnnotatedTypeMetadata)"})
  public void testMatches_givenStandardReactiveWebEnvironment_thenReturnTrue() {
    // Arrange
    ImportCondition importCondition = new ImportCondition();

    ConditionContext context = mock(ConditionContext.class);
    when(context.getEnvironment()).thenReturn(new StandardReactiveWebEnvironment());

    // Act
    boolean actualMatchesResult =
        importCondition.matches(context, mock(AnnotatedTypeMetadata.class));

    // Assert
    verify(context).getEnvironment();
    assertTrue(actualMatchesResult);
  }
}
