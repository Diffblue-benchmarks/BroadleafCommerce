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
package org.broadleafcommerce.common.demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ImportConditionDiffblueTest {
  /**
   * Test
   * {@link ImportCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   * <ul>
   *   <li>Given
   * {@link StandardReactiveWebEnvironment#StandardReactiveWebEnvironment()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImportCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  public void testMatches_givenStandardReactiveWebEnvironment_thenReturnTrue() {
    // Arrange
    ImportCondition importCondition = new ImportCondition();
    ConditionContext context = mock(ConditionContext.class);
    when(context.getEnvironment()).thenReturn(new StandardReactiveWebEnvironment());

    // Act
    boolean actualMatchesResult = importCondition.matches(context, mock(AnnotatedTypeMetadata.class));

    // Assert
    verify(context).getEnvironment();
    assertTrue(actualMatchesResult);
  }
}
