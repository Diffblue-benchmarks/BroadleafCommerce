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
