/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extensibility.cache.OnEhCacheMissingCondition;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnEhCacheConditionDiffblueTest {
  /**
   * Test {@link OnEhCacheCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link OnEhCacheCondition} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OnEhCacheCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnEhCacheCondition.matches(ConditionContext, AnnotatedTypeMetadata)"})
  public void testMatches_givenOnEhCacheCondition_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new OnEhCacheCondition()
            .matches(mock(ConditionContext.class), mock(AnnotatedTypeMetadata.class)));
  }

  /**
   * Test {@link OnEhCacheCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link OnEhCacheMissingCondition} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OnEhCacheCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnEhCacheCondition.matches(ConditionContext, AnnotatedTypeMetadata)"})
  public void testMatches_givenOnEhCacheMissingCondition_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new OnEhCacheMissingCondition()
            .matches(mock(ConditionContext.class), mock(AnnotatedTypeMetadata.class)));
  }
}
