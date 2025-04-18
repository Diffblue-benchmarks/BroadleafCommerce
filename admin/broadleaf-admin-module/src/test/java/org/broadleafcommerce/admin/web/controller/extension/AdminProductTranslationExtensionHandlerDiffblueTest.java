/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.extension;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.web.controller.AdminTranslationControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AdminTranslationControllerExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminProductTranslationExtensionHandlerDiffblueTest {
  @InjectMocks
  private AdminProductTranslationExtensionHandler adminProductTranslationExtensionHandler;

  @Mock
  private AdminTranslationControllerExtensionManager adminTranslationControllerExtensionManager;

  @Mock
  private CatalogService catalogService;

  /**
   * Test {@link AdminProductTranslationExtensionHandler#init()}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#registerHandler(ExtensionHandler)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductTranslationExtensionHandler#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductTranslationExtensionHandler.init()"})
  public void testInit_thenCallsRegisterHandler() {
    // Arrange
    when(adminTranslationControllerExtensionManager
        .registerHandler(Mockito.<AdminTranslationControllerExtensionHandler>any())).thenReturn(true);

    // Act
    adminProductTranslationExtensionHandler.init();

    // Assert
    verify(adminTranslationControllerExtensionManager)
        .registerHandler(isA(AdminTranslationControllerExtensionHandler.class));
  }
}
