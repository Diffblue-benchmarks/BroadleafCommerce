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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnEhCacheMissingConditionDiffblueTest {
  /**
   * Test
   * {@link OnEhCacheMissingCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   * <p>
   * Method under test:
   * {@link OnEhCacheMissingCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse(
        (new OnEhCacheMissingCondition()).matches(mock(ConditionContext.class), mock(AnnotatedTypeMetadata.class)));
  }

  /**
   * Test new {@link OnEhCacheMissingCondition} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OnEhCacheMissingCondition}
   */
  @Test
  public void testNewOnEhCacheMissingCondition() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new OnEhCacheMissingCondition();
  }
}
