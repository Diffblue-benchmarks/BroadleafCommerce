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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
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
  @Autowired private BroadleafPageController broadleafPageController;

  @MockBean(name = "blTemplateOverrideExtensionManager")
  private TemplateOverrideExtensionManager templateOverrideExtensionManager;

  /**
   * Test {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link NullPageDTO} (default constructor).
   *   <li>Then return Model {@code pageFields} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPageController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafPageController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequest_givenNullPageDTO_thenReturnModelPageFieldsEmpty() throws Exception {
    // Arrange
    TemplateOverrideExtensionHandler templateOverrideExtensionHandler =
        mock(TemplateOverrideExtensionHandler.class);
    when(templateOverrideExtensionHandler.getOverrideTemplate(
            Mockito.<ExtensionResultHolder<String>>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOverrideExtensionManager.getProxy()).thenReturn(templateOverrideExtensionHandler);

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    NullPageDTO nullPageDTO = new NullPageDTO();
    when(request.getAttribute(Mockito.<String>any())).thenReturn(nullPageDTO);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafPageController.handleRequest(request, new MockHttpServletResponse());

    // Assert
    verify(templateOverrideExtensionManager).getProxy();
    verify(templateOverrideExtensionHandler)
        .getOverrideTemplate(isA(ExtensionResultHolder.class), isA(Object.class));
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    verify(request).getAttribute("BLC_PAGE");
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertEquals(3, model.size());
    Object getResult = model.get("pageFields");
    assertTrue(getResult instanceof Map);
    assertTrue(model.containsKey("BLC_PAGE_TYPE"));
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
    assertSame(nullPageDTO, model.get("page"));
  }

  /**
   * Test {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return Model {@code pageFields} {@code plainText} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPageController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafPageController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequest_thenReturnModelPageFieldsPlainTextIsEmptyString() throws Exception {
    // Arrange
    TemplateOverrideExtensionHandler templateOverrideExtensionHandler =
        mock(TemplateOverrideExtensionHandler.class);
    when(templateOverrideExtensionHandler.getOverrideTemplate(
            Mockito.<ExtensionResultHolder<String>>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOverrideExtensionManager.getProxy()).thenReturn(templateOverrideExtensionHandler);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("plainText", "");

    NullPageDTO nullPageDTO = mock(NullPageDTO.class);
    when(nullPageDTO.getPageFields()).thenReturn(stringObjectMap);
    when(nullPageDTO.getTemplatePath()).thenReturn("Template Path");

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(nullPageDTO);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafPageController.handleRequest(request, new MockHttpServletResponse());

    // Assert
    verify(templateOverrideExtensionManager).getProxy();
    verify(nullPageDTO, atLeast(1)).getPageFields();
    verify(nullPageDTO).getTemplatePath();
    verify(templateOverrideExtensionHandler)
        .getOverrideTemplate(isA(ExtensionResultHolder.class), isA(Object.class));
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    verify(request).getAttribute("BLC_PAGE");
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertEquals(3, model.size());
    Object getResult = model.get("pageFields");
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, String>) getResult).size());
    assertEquals("", ((Map<String, String>) getResult).get("plainText"));
    assertNull(actualHandleRequestResult.getViewName());
    assertFalse(actualHandleRequestResult.hasView());
    assertFalse(actualHandleRequestResult.isReference());
    assertTrue(model.containsKey("BLC_PAGE_TYPE"));
    assertTrue(model.containsKey("page"));
    assertSame(stringObjectMap, getResult);
  }

  /**
   * Test {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return Model {@code pageFields} {@code plainText} is {@code Page Fields}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPageController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafPageController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequest_thenReturnModelPageFieldsPlainTextIsPageFields() throws Exception {
    // Arrange
    TemplateOverrideExtensionHandler templateOverrideExtensionHandler =
        mock(TemplateOverrideExtensionHandler.class);
    when(templateOverrideExtensionHandler.getOverrideTemplate(
            Mockito.<ExtensionResultHolder<String>>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOverrideExtensionManager.getProxy()).thenReturn(templateOverrideExtensionHandler);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("plainText", "Page Fields");

    NullPageDTO nullPageDTO = mock(NullPageDTO.class);
    when(nullPageDTO.getPageFields()).thenReturn(stringObjectMap);
    when(nullPageDTO.getTemplatePath()).thenReturn("Template Path");

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(nullPageDTO);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafPageController.handleRequest(request, new MockHttpServletResponse());

    // Assert
    verify(templateOverrideExtensionManager).getProxy();
    verify(nullPageDTO, atLeast(1)).getPageFields();
    verify(nullPageDTO).getTemplatePath();
    verify(templateOverrideExtensionHandler)
        .getOverrideTemplate(isA(ExtensionResultHolder.class), isA(Object.class));
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    verify(request).getAttribute("BLC_PAGE");
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertEquals(3, model.size());
    Object getResult = model.get("pageFields");
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, String>) getResult).size());
    assertEquals("Page Fields", ((Map<String, String>) getResult).get("plainText"));
    assertNull(actualHandleRequestResult.getViewName());
    assertFalse(actualHandleRequestResult.hasView());
    assertFalse(actualHandleRequestResult.isReference());
    assertTrue(model.containsKey("BLC_PAGE_TYPE"));
    assertTrue(model.containsKey("page"));
    assertSame(stringObjectMap, getResult);
  }

  /**
   * Test {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return ViewName is {@code Template Path}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPageController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafPageController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequest_thenReturnViewNameIsTemplatePath() throws Exception {
    // Arrange
    TemplateOverrideExtensionHandler templateOverrideExtensionHandler =
        mock(TemplateOverrideExtensionHandler.class);
    when(templateOverrideExtensionHandler.getOverrideTemplate(
            Mockito.<ExtensionResultHolder<String>>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(templateOverrideExtensionManager.getProxy()).thenReturn(templateOverrideExtensionHandler);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("plainText", "Page Fields");

    NullPageDTO nullPageDTO = mock(NullPageDTO.class);
    when(nullPageDTO.getPageFields()).thenReturn(stringObjectMap);
    when(nullPageDTO.getTemplatePath()).thenReturn("Template Path");

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(nullPageDTO);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafPageController.handleRequest(request, new MockHttpServletResponse());

    // Assert
    verify(templateOverrideExtensionManager).getProxy();
    verify(nullPageDTO, atLeast(1)).getPageFields();
    verify(nullPageDTO).getTemplatePath();
    verify(templateOverrideExtensionHandler)
        .getOverrideTemplate(isA(ExtensionResultHolder.class), isA(Object.class));
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    verify(request).getAttribute("BLC_PAGE");
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertEquals(3, model.size());
    Object getResult = model.get("pageFields");
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, String>) getResult).size());
    assertEquals("Page Fields", ((Map<String, String>) getResult).get("plainText"));
    assertEquals("Template Path", actualHandleRequestResult.getViewName());
    assertTrue(model.containsKey("BLC_PAGE_TYPE"));
    assertTrue(model.containsKey("page"));
    assertTrue(actualHandleRequestResult.hasView());
    assertTrue(actualHandleRequestResult.isReference());
  }

  /**
   * Test {@link BroadleafPageController#getTemplateType(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafPageController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType BroadleafPageController.getTemplateType(HttpServletRequest)"})
  public void testGetTemplateType() {
    // Arrange, Act and Assert
    assertSame(
        TemplateType.PAGE, broadleafPageController.getTemplateType(new MockHttpServletRequest()));
  }

  /**
   * Test new {@link BroadleafPageController} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BroadleafPageController}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafPageController.<init>()"})
  public void testNewBroadleafPageController() {
    // Arrange and Act
    BroadleafPageController actualBroadleafPageController = new BroadleafPageController();

    // Assert
    assertNull(actualBroadleafPageController.templateOverrideManager);
    assertNull(actualBroadleafPageController.deepLinkService);
  }
}
