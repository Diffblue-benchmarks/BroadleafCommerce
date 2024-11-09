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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MultiTenantMergeBeanStatusProviderDiffblueTest {
  /**
   * Test
   * {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object, String, ApplicationContext)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object, String, ApplicationContext)}
   */
  @Test
  public void testIsProcessingEnabled_givenTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MultiTenantMergeBeanStatusProvider multiTenantMergeBeanStatusProvider = new MultiTenantMergeBeanStatusProvider();
    AnnotationConfigApplicationContext appCtx = mock(AnnotationConfigApplicationContext.class);
    when(appCtx.containsBean(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsProcessingEnabledResult = multiTenantMergeBeanStatusProvider
        .isProcessingEnabled(BLCFieldUtils.NULL_FIELD, "Bean Name", appCtx);

    // Assert
    verify(appCtx).containsBean(eq("blMultiTenantFilterClassTransformer"));
    assertTrue(actualIsProcessingEnabledResult);
  }

  /**
   * Test
   * {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object, String, ApplicationContext)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object, String, ApplicationContext)}
   */
  @Test
  public void testIsProcessingEnabled_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MultiTenantMergeBeanStatusProvider multiTenantMergeBeanStatusProvider = new MultiTenantMergeBeanStatusProvider();

    // Act and Assert
    assertFalse(multiTenantMergeBeanStatusProvider.isProcessingEnabled(BLCFieldUtils.NULL_FIELD, "Bean Name",
        new AnnotationConfigReactiveWebApplicationContext()));
  }
}
