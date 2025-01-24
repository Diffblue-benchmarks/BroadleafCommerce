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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnMissingBroadleafModuleConditionDiffblueTest {
  /**
   * Test
   * {@link OnMissingBroadleafModuleCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   * <p>
   * Method under test:
   * {@link OnMissingBroadleafModuleCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMatches() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.matches(OnMissingBroadleafModuleCondition.java:38)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OnMissingBroadleafModuleCondition onMissingBroadleafModuleCondition = new OnMissingBroadleafModuleCondition();
    ConditionContext context = mock(ConditionContext.class);
    AnnotatedTypeMetadata metadata = mock(AnnotatedTypeMetadata.class);
    when(metadata.getAnnotationAttributes(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    onMissingBroadleafModuleCondition.matches(context, metadata);
  }

  /**
   * Test new {@link OnMissingBroadleafModuleCondition} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OnMissingBroadleafModuleCondition}
   */
  @Test
  public void testNewOnMissingBroadleafModuleCondition() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new OnMissingBroadleafModuleCondition();
  }
}
