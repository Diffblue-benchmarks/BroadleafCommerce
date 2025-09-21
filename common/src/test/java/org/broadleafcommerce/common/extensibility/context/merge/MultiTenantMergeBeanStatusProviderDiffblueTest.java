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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MultiTenantMergeBeanStatusProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MultiTenantMergeBeanStatusProviderDiffblueTest {
  @Autowired private MultiTenantMergeBeanStatusProvider multiTenantMergeBeanStatusProvider;

  /**
   * Test {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object, String,
   * ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object,
   * String, ApplicationContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultiTenantMergeBeanStatusProvider.isProcessingEnabled(Object, String, ApplicationContext)"
  })
  public void testIsProcessingEnabled_givenFalse_thenReturnFalse() {
    // Arrange
    ApplicationContext appCtx = mock(ApplicationContext.class);
    when(appCtx.containsBean(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsProcessingEnabledResult =
        multiTenantMergeBeanStatusProvider.isProcessingEnabled(
            BLCFieldUtils.NULL_FIELD, "Bean Name", appCtx);

    // Assert
    verify(appCtx).containsBean("blMultiTenantFilterClassTransformer");
    assertFalse(actualIsProcessingEnabledResult);
  }

  /**
   * Test {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object, String,
   * ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantMergeBeanStatusProvider#isProcessingEnabled(Object,
   * String, ApplicationContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultiTenantMergeBeanStatusProvider.isProcessingEnabled(Object, String, ApplicationContext)"
  })
  public void testIsProcessingEnabled_givenTrue_thenReturnTrue() {
    // Arrange
    ApplicationContext appCtx = mock(ApplicationContext.class);
    when(appCtx.containsBean(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsProcessingEnabledResult =
        multiTenantMergeBeanStatusProvider.isProcessingEnabled(
            BLCFieldUtils.NULL_FIELD, "Bean Name", appCtx);

    // Assert
    verify(appCtx).containsBean("blMultiTenantFilterClassTransformer");
    assertTrue(actualIsProcessingEnabledResult);
  }
}
