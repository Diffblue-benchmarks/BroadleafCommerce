/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.LinkedMultiValueMap;

public class OnBroadleafModuleConditionDiffblueTest {
  /**
   * Test
   * {@link OnBroadleafModuleCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   * <ul>
   *   <li>Given {@link LinkedMultiValueMap#LinkedMultiValueMap()} addAll
   * {@code value} and {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OnBroadleafModuleCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  public void testMatches_givenLinkedMultiValueMapAddAllValueAndArrayList_thenReturnTrue() {
    // Arrange
    OnBroadleafModuleCondition onBroadleafModuleCondition = new OnBroadleafModuleCondition();
    ConditionContext context = mock(ConditionContext.class);

    LinkedMultiValueMap<String, Object> stringObjectMap = new LinkedMultiValueMap<>();
    stringObjectMap.addAll("value", new ArrayList<>());
    AnnotatedTypeMetadata metadata = mock(AnnotatedTypeMetadata.class);
    when(metadata.getAllAnnotationAttributes(Mockito.<String>any())).thenReturn(stringObjectMap);

    // Act
    boolean actualMatchesResult = onBroadleafModuleCondition.matches(context, metadata);

    // Assert
    verify(metadata)
        .getAllAnnotationAttributes(eq("org.broadleafcommerce.common.condition.ConditionalOnBroadleafModule"));
    assertTrue(actualMatchesResult);
  }
}
