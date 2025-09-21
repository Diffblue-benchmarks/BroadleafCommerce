/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {BroadleafSkuController.class})
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class BroadleafSkuControllerDiffblueTest {
  @Autowired private BroadleafSkuController broadleafSkuController;

  @InjectMocks private BroadleafSkuController broadleafSkuController2;

  /**
   * Test {@link BroadleafSkuController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then Model {@code sku} return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSkuController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test handleRequest(HttpServletRequest, HttpServletResponse); given SkuImpl (default constructor); then Model 'sku' return SkuImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSkuController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  void testHandleRequest_givenSkuImpl_thenModelSkuReturnSkuImpl() throws Exception {
    // Arrange
    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    SkuImpl skuImpl = new SkuImpl();
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(skuImpl);
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setAttribute("currentSku", "42");
    request.setCharacterEncoding("currentSku");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafSkuController2.handleRequest(request2, new MockHttpServletResponse());

    // Assert
    verify(servletRequest)
        .addParameter("https://example.org/example", "https://example.org/example");
    verify(servletRequest).getAttribute("currentSku");
    verify(servletRequest).setAttribute(eq("currentSku"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentSku");
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertEquals(2, model.size());
    assertTrue(model.get("blcAllDisplayedSkus") instanceof Set);
    Object getResult = model.get("sku");
    assertTrue(getResult instanceof SkuImpl);
    assertSame(skuImpl, getResult);
  }

  /**
   * Test {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType BroadleafSkuController.getTemplateType(HttpServletRequest)"})
  void testGetTemplateType() {
    // Arrange, Act and Assert
    assertSame(
        TemplateType.SKU,
        broadleafSkuController.getTemplateType(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafSkuController}
   *   <li>{@link BroadleafSkuController#setDefaultSkuView(String)}
   *   <li>{@link BroadleafSkuController#getDefaultSkuView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafSkuController.<init>()",
    "String BroadleafSkuController.getDefaultSkuView()",
    "void BroadleafSkuController.setDefaultSkuView(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafSkuController actualBroadleafSkuController = new BroadleafSkuController();
    actualBroadleafSkuController.setDefaultSkuView("Default Sku View");

    // Assert
    assertEquals("Default Sku View", actualBroadleafSkuController.getDefaultSkuView());
  }
}
