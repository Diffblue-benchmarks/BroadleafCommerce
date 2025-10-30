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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BroadleafTemplateViewResolverExtensionManagerDiffblueTest {
  @InjectMocks
  private BroadleafTemplateViewResolverExtensionManager broadleafTemplateViewResolverExtensionManager;

  /**
   * Test {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}.
   * <p>
   * Method under test: {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List BroadleafTemplateViewResolverExtensionManager.getHandlers()"})
  public void testGetHandlers() {
    // Arrange, Act and Assert
    assertTrue(broadleafTemplateViewResolverExtensionManager.getHandlers().isEmpty());
  }

  /**
   * Test {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafTemplateViewResolverExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(broadleafTemplateViewResolverExtensionManager.continueOnHandled());
  }
}
