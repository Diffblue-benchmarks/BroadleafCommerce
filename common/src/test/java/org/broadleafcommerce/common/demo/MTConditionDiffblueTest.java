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

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import org.junit.Test;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MTConditionDiffblueTest {
  /**
   * Test {@link MTCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   * <p>
   * Method under test:
   * {@link MTCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
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
