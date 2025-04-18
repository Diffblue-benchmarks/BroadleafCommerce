/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.template.TemplateOverrideExtensionHandler;
import org.broadleafcommerce.common.template.TemplateOverrideExtensionManager;
import org.broadleafcommerce.common.template.TemplateType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {BroadleafPageController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafPageControllerDiffblueTest {
  @Autowired
  private BroadleafPageController broadleafPageController;

  @MockBean(name = "blTemplateOverrideExtensionManager")
  private TemplateOverrideExtensionManager templateOverrideExtensionManager;

  /**
   * Test {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ModelAndView BroadleafPageController.handleRequest(HttpServletRequest, HttpServletResponse)"})
  public void testHandleRequest() throws Exception {
    // Arrange
    TemplateOverrideExtensionHandler templateOverrideExtensionHandler = mock(TemplateOverrideExtensionHandler.class);
    when(templateOverrideExtensionHandler.getOverrideTemplate(Mockito.<ExtensionResultHolder<String>>any(),
        Mockito.<Object>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOverrideExtensionManager.getProxy()).thenReturn(templateOverrideExtensionHandler);
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    NullPageDTO nullPageDTO = new NullPageDTO();
    when(request.getAttribute(Mockito.<String>any())).thenReturn(nullPageDTO);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    ModelAndView actualHandleRequestResult = broadleafPageController.handleRequest(request,
        new MockHttpServletResponse());

    // Assert
    verify(templateOverrideExtensionManager).getProxy();
    verify(templateOverrideExtensionHandler).getOverrideTemplate(isA(ExtensionResultHolder.class), isA(Object.class));
    verify(request).addParameter(eq("https://example.org/example"), eq("https://example.org/example"));
    verify(request).getAttribute(eq("BLC_PAGE"));
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertEquals(3, model.size());
    Object getResult = model.get("pageFields");
    assertTrue(getResult instanceof Map);
    Object getResult2 = model.get("page");
    assertTrue(getResult2 instanceof NullPageDTO);
    assertEquals("page", model.get("BLC_PAGE_TYPE"));
    assertNull(actualHandleRequestResult.getViewName());
    assertNull(actualHandleRequestResult.getStatus());
    assertNull(actualHandleRequestResult.getView());
    assertFalse(actualHandleRequestResult.hasView());
    assertFalse(actualHandleRequestResult.isEmpty());
    assertFalse(actualHandleRequestResult.isReference());
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
    assertSame(nullPageDTO, getResult2);
    assertSame(model, actualHandleRequestResult.getModelMap());
  }

  /**
   * Test {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ModelAndView BroadleafPageController.handleRequest(HttpServletRequest, HttpServletResponse)"})
  public void testHandleRequest2() throws Exception {
    // Arrange
    TemplateOverrideExtensionHandler templateOverrideExtensionHandler = mock(TemplateOverrideExtensionHandler.class);
    when(templateOverrideExtensionHandler.getOverrideTemplate(Mockito.<ExtensionResultHolder<String>>any(),
        Mockito.<Object>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(templateOverrideExtensionManager.getProxy()).thenReturn(templateOverrideExtensionHandler);
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    NullPageDTO nullPageDTO = new NullPageDTO();
    when(request.getAttribute(Mockito.<String>any())).thenReturn(nullPageDTO);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    ModelAndView actualHandleRequestResult = broadleafPageController.handleRequest(request,
        new MockHttpServletResponse());

    // Assert
    verify(templateOverrideExtensionManager).getProxy();
    verify(templateOverrideExtensionHandler).getOverrideTemplate(isA(ExtensionResultHolder.class), isA(Object.class));
    verify(request).addParameter(eq("https://example.org/example"), eq("https://example.org/example"));
    verify(request).getAttribute(eq("BLC_PAGE"));
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertEquals(3, model.size());
    Object getResult = model.get("pageFields");
    assertTrue(getResult instanceof Map);
    Object getResult2 = model.get("page");
    assertTrue(getResult2 instanceof NullPageDTO);
    assertEquals("page", model.get("BLC_PAGE_TYPE"));
    assertNull(actualHandleRequestResult.getViewName());
    assertNull(actualHandleRequestResult.getStatus());
    assertNull(actualHandleRequestResult.getView());
    assertFalse(actualHandleRequestResult.hasView());
    assertFalse(actualHandleRequestResult.isEmpty());
    assertFalse(actualHandleRequestResult.isReference());
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
    assertSame(nullPageDTO, getResult2);
    assertSame(model, actualHandleRequestResult.getModelMap());
  }

  /**
   * Test {@link BroadleafPageController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafPageController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TemplateType BroadleafPageController.getTemplateType(HttpServletRequest)"})
  public void testGetTemplateType() {
    // Arrange and Act
    TemplateType actualTemplateType = broadleafPageController.getTemplateType(new MockHttpServletRequest());

    // Assert
    assertSame(actualTemplateType.PAGE, actualTemplateType);
  }

  /**
   * Test new {@link BroadleafPageController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafPageController}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafPageController.<init>()"})
  public void testNewBroadleafPageController() {
    // Arrange and Act
    BroadleafPageController actualBroadleafPageController = new BroadleafPageController();

    // Assert
    assertNull(actualBroadleafPageController.templateOverrideManager);
    assertNull(actualBroadleafPageController.deepLinkService);
  }
}
