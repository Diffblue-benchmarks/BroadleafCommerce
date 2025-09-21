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
package org.broadleafcommerce.common.condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.module.BroadleafModuleRegistration;
import org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnMissingBroadleafModuleConditionDiffblueTest {
  /**
   * Test {@link OnMissingBroadleafModuleCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code value} is {@code ACCOUNT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OnMissingBroadleafModuleCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OnMissingBroadleafModuleCondition.matches(ConditionContext, AnnotatedTypeMetadata)"
  })
  public void testMatches_givenHashMapValueIsAccount_thenReturnTrue() {
    // Arrange
    OnMissingBroadleafModuleCondition onMissingBroadleafModuleCondition =
        new OnMissingBroadleafModuleCondition();
    ConditionContext context = mock(ConditionContext.class);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("value", BroadleafModuleEnum.ACCOUNT);

    AnnotatedTypeMetadata metadata = mock(AnnotatedTypeMetadata.class);
    when(metadata.getAnnotationAttributes(Mockito.<String>any())).thenReturn(stringObjectMap);

    // Act
    boolean actualMatchesResult = onMissingBroadleafModuleCondition.matches(context, metadata);

    // Assert
    verify(metadata)
        .getAnnotationAttributes(
            "org.broadleafcommerce.common.condition.ConditionalOnMissingBroadleafModule");
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link OnMissingBroadleafModuleCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code value} is {@link BroadleafModuleEnum#IGNORED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OnMissingBroadleafModuleCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OnMissingBroadleafModuleCondition.matches(ConditionContext, AnnotatedTypeMetadata)"
  })
  public void testMatches_givenHashMapValueIsIgnored_thenReturnFalse() {
    // Arrange
    OnMissingBroadleafModuleCondition onMissingBroadleafModuleCondition =
        new OnMissingBroadleafModuleCondition();
    ConditionContext context = mock(ConditionContext.class);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("value", BroadleafModuleEnum.IGNORED);

    AnnotatedTypeMetadata metadata = mock(AnnotatedTypeMetadata.class);
    when(metadata.getAnnotationAttributes(Mockito.<String>any())).thenReturn(stringObjectMap);

    // Act
    boolean actualMatchesResult = onMissingBroadleafModuleCondition.matches(context, metadata);

    // Assert
    verify(metadata)
        .getAnnotationAttributes(
            "org.broadleafcommerce.common.condition.ConditionalOnMissingBroadleafModule");
    assertFalse(actualMatchesResult);
  }
}
