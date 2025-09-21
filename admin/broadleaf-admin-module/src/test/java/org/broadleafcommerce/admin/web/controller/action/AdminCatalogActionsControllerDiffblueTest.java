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
package org.broadleafcommerce.admin.web.controller.action;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.admin.server.service.AdminCatalogService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class AdminCatalogActionsControllerDiffblueTest {
  @InjectMocks private AdminCatalogActionsController adminCatalogActionsController;

  @Mock private AdminCatalogService adminCatalogService;

  /**
   * Test {@link AdminCatalogActionsController#generateSkus(HttpServletRequest, HttpServletResponse,
   * Model, Long, String)}.
   *
   * <p>Method under test: {@link AdminCatalogActionsController#generateSkus(HttpServletRequest,
   * HttpServletResponse, Model, Long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AdminCatalogActionsController.generateSkus(HttpServletRequest, HttpServletResponse, Model, Long, String)"
  })
  public void testGenerateSkus() throws Exception {
    // Arrange
    when(adminCatalogService.generateSkus(Mockito.<Long>any())).thenReturn(new HashMap<>());

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminCatalogActionsController)
        .build()
        .perform(
            MockMvcRequestBuilders.get(
                "/product/{productId}/{skusFieldName}/generate-skus", 1L, "Skus Field Name"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"listGridUrl\":\"http://localhost/product/1/Skus%20Field%20Name\"}"));
  }
}
