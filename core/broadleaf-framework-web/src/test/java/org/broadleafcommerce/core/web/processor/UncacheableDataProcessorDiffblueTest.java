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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.inventory.service.InventoryServiceExtensionHandler;
import org.broadleafcommerce.core.inventory.service.InventoryServiceExtensionManager;
import org.broadleafcommerce.core.web.processor.extension.UncacheableDataProcessorExtensionHandler;
import org.broadleafcommerce.core.web.processor.extension.UncacheableDataProcessorExtensionManager;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UncacheableDataProcessorDiffblueTest {
  @Mock private ExploitProtectionService exploitProtectionService;

  @Mock private InventoryServiceExtensionManager inventoryServiceExtensionManager;

  @InjectMocks private UncacheableDataProcessor uncacheableDataProcessor;

  @Mock private UncacheableDataProcessorExtensionManager uncacheableDataProcessorExtensionManager;

  /**
   * Test {@link UncacheableDataProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UncacheableDataProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, uncacheableDataProcessor.getPrecedence());
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken())
        .thenThrow(new ServiceException("An error occurred"));

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context));
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code callbackBlock}.
   *   <li>Then {@link HashMap#HashMap()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test getReplacementModel(String, Map, BroadleafTemplateContext); given 'callbackBlock'; then HashMap() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel_givenCallbackBlock_thenHashMapSizeIsTwo() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert that nothing has changed
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context).createModel();
    verify(context)
        .createTextElement(
            "<SCRIPT>\n  var params = \n  {\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\",\"outOfStockSkus\":[]};\n  Tag Attributes</SCRIPT>");
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    assertEquals(2, tagAttributes.size());
    assertEquals("Tag Attributes", tagAttributes.get("callback"));
    assertEquals("Tag Attributes", tagAttributes.get("callbackBlock"));
    assertEquals("blc", uncacheableDataProcessor.getPrefix());
    assertEquals("uncacheabledata", uncacheableDataProcessor.getName());
    assertEquals(
        "updateUncacheableData(params);\n", uncacheableDataProcessor.getDefaultCallbackFunction());
    assertEquals(100, uncacheableDataProcessor.getPrecedence());
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel_givenNull() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(null);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    uncacheableDataProcessor
        .getReplacementModel("Tag Name", tagAttributes, context)
        .addElement(mock(BroadleafTemplateElement.class));

    // Assert that nothing has changed
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context).createModel();
    verify(context)
        .createTextElement(
            "<SCRIPT>\n  var params = \n  {\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\",\"outOfStockSkus\":[]};\n  updateUncacheableData(params);\n</SCRIPT>");
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    verify(broadleafTemplateModel, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    assertEquals("blc", uncacheableDataProcessor.getPrefix());
    assertEquals("uncacheabledata", uncacheableDataProcessor.getName());
    assertEquals(
        "updateUncacheableData(params);\n", uncacheableDataProcessor.getDefaultCallbackFunction());
    assertEquals(100, uncacheableDataProcessor.getPrecedence());
    assertTrue(tagAttributes.isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test getReplacementModel(String, Map, BroadleafTemplateContext); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel_givenRuntimeException() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context));
    verify(context).getVariable("blcAllDisplayedProducts");
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test getReplacementModel(String, Map, BroadleafTemplateContext); then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel_thenHashMapEmpty() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert that nothing has changed
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context).createModel();
    verify(context)
        .createTextElement(
            "<SCRIPT>\n  var params = \n  {\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\",\"outOfStockSkus\":[]};\n  updateUncacheableData(params);\n</SCRIPT>");
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    assertEquals("blc", uncacheableDataProcessor.getPrefix());
    assertEquals("uncacheabledata", uncacheableDataProcessor.getName());
    assertEquals(
        "updateUncacheableData(params);\n", uncacheableDataProcessor.getDefaultCallbackFunction());
    assertEquals(100, uncacheableDataProcessor.getPrecedence());
    assertTrue(tagAttributes.isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test buildContentMap(BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken())
        .thenThrow(new ServiceException("An error occurred"));

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uncacheableDataProcessor.buildContentMap(context));
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ExploitProtectionService} {@link ExploitProtectionService#getCSRFToken()}
   *       return {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test buildContentMap(BroadleafTemplateContext); given ExploitProtectionService getCSRFToken() return 'ABC123'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap_givenExploitProtectionServiceGetCSRFTokenReturnAbc123()
      throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    String actualBuildContentMapResult = uncacheableDataProcessor.buildContentMap(context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    assertEquals(
        "{\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions"
            + "\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\","
            + "\"outOfStockSkus\":[]}",
        actualBuildContentMapResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ExploitProtectionService} {@link ExploitProtectionService#getCSRFToken()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test buildContentMap(BroadleafTemplateContext); given ExploitProtectionService getCSRFToken() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap_givenExploitProtectionServiceGetCSRFTokenReturnNull()
      throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn(null);
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    String actualBuildContentMapResult = uncacheableDataProcessor.buildContentMap(context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    assertEquals(
        "{\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":null,\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions"
            + "\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\","
            + "\"outOfStockSkus\":[]}",
        actualBuildContentMapResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BroadleafTemplateContext} {@link
   *       BroadleafTemplateContext#getVariable(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test buildContentMap(BroadleafTemplateContext); given 'null'; when BroadleafTemplateContext getVariable(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap_givenNull_whenBroadleafTemplateContextGetVariableReturnNull()
      throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(null);

    // Act
    String actualBuildContentMapResult = uncacheableDataProcessor.buildContentMap(context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    assertEquals(
        "{\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions"
            + "\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\","
            + "\"outOfStockSkus\":[]}",
        actualBuildContentMapResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test buildContentMap(BroadleafTemplateContext); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap_givenRuntimeException() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uncacheableDataProcessor.buildContentMap(context));
    verify(context).getVariable("blcAllDisplayedProducts");
  }

  /**
   * Test {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test addProductInventoryData(Map, BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  void testAddProductInventoryData() {
    // Arrange
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenThrow(new RuntimeException());
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, Object> attrMap = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> uncacheableDataProcessor.addProductInventoryData(attrMap, context));
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
  }

  /**
   * Test {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test addProductInventoryData(Map, BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  void testAddProductInventoryData2() {
    // Arrange
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenThrow(new RuntimeException());

    HashMap<String, Object> attrMap = new HashMap<>();
    attrMap.put("outOfStockProducts", "Attr Map");
    attrMap.put("outOfStockSkus", "Attr Map");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> uncacheableDataProcessor.addProductInventoryData(attrMap, context));
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
  }

  /**
   * Test {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test addProductInventoryData(Map, BroadleafTemplateContext); given HashSet() add '42'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  void testAddProductInventoryData_givenHashSetAdd42_thenThrowRuntimeException() {
    // Arrange
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenThrow(new RuntimeException());
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, Object> attrMap = new HashMap<>();

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add("42");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(objectSet);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> uncacheableDataProcessor.addProductInventoryData(attrMap, context));
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
  }

  /**
   * Test {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test addProductInventoryData(Map, BroadleafTemplateContext); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  void testAddProductInventoryData_givenNull() {
    // Arrange
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, Object> attrMap = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(null);

    // Act
    uncacheableDataProcessor.addProductInventoryData(attrMap, context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    assertEquals(2, attrMap.size());
    Object getResult = attrMap.get("outOfStockSkus");
    assertTrue(getResult instanceof List);
    Object getResult2 = attrMap.get("outOfStockProducts");
    assertTrue(getResult2 instanceof Set);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Set<Object>) getResult2).isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test addProductInventoryData(Map, BroadleafTemplateContext); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  void testAddProductInventoryData_givenRuntimeException() {
    // Arrange
    HashMap<String, Object> attrMap = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> uncacheableDataProcessor.addProductInventoryData(attrMap, context));
    verify(context).getVariable("blcAllDisplayedProducts");
  }

  /**
   * Test {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test addProductInventoryData(Map, BroadleafTemplateContext); then HashMap() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  void testAddProductInventoryData_thenHashMapSizeIsTwo() {
    // Arrange
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler =
        mock(UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Set<Product>>any(),
            Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy())
        .thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, Object> attrMap = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    uncacheableDataProcessor.addProductInventoryData(attrMap, context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(
            isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    assertEquals(2, attrMap.size());
    Object getResult = attrMap.get("outOfStockSkus");
    assertTrue(getResult instanceof List);
    Object getResult2 = attrMap.get("outOfStockProducts");
    assertTrue(getResult2 instanceof Set);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Set<Object>) getResult2).isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product,
   * Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  void testIsBlockingAvailabilityOfProduct() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            uncacheableDataProcessor.isBlockingAvailabilityOfProduct(
                baseProduct, new ProductBundleImpl()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product,
   * Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  void testIsBlockingAvailabilityOfProduct2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.isBlockingAvailabilityOfProduct(
            Mockito.<Product>any(),
            Mockito.<Product>any(),
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act
    boolean actualIsBlockingAvailabilityOfProductResult =
        uncacheableDataProcessor.isBlockingAvailabilityOfProduct(
            baseProduct, new ProductBundleImpl());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .isBlockingAvailabilityOfProduct(
            isA(Product.class), isA(Product.class), isA(ExtensionResultHolder.class));
    assertFalse(actualIsBlockingAvailabilityOfProductResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product,
   * Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  void testIsBlockingAvailabilityOfProduct3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.isBlockingAvailabilityOfProduct(
            Mockito.<Product>any(),
            Mockito.<Product>any(),
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenThrow(new RuntimeException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            uncacheableDataProcessor.isBlockingAvailabilityOfProduct(
                baseProduct, new ProductBundleImpl()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .isBlockingAvailabilityOfProduct(
            isA(Product.class), isA(Product.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product,
   * Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  void testIsBlockingAvailabilityOfProduct4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.isBlockingAvailabilityOfProduct(
            Mockito.<Product>any(),
            Mockito.<Product>any(),
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act
    boolean actualIsBlockingAvailabilityOfProductResult =
        uncacheableDataProcessor.isBlockingAvailabilityOfProduct(
            baseProduct, new ProductBundleImpl());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .isBlockingAvailabilityOfProduct(
            isA(Product.class), isA(Product.class), isA(ExtensionResultHolder.class));
    assertFalse(actualIsBlockingAvailabilityOfProductResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#isBundle(Product)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#isBundle(Product)}
   */
  @Test
  @DisplayName(
      "Test isBundle(Product); when ProductBundleImpl (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UncacheableDataProcessor.isBundle(Product)"})
  void testIsBundle_whenProductBundleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(uncacheableDataProcessor.isBundle(new ProductBundleImpl()));
  }

  /**
   * Test {@link UncacheableDataProcessor#addCartData(Map)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addCartData(Map)}
   */
  @Test
  @DisplayName("Test addCartData(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UncacheableDataProcessor.addCartData(Map)"})
  void testAddCartData() {
    // Arrange
    HashMap<String, Object> attrMap = new HashMap<>();

    // Act
    uncacheableDataProcessor.addCartData(attrMap);

    // Assert
    assertEquals(3, attrMap.size());
    Object getResult = attrMap.get("cartItemIdsWithoutOptions");
    assertTrue(getResult instanceof List);
    assertEquals(0, ((Integer) attrMap.get("cartItemCount")).intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
    assertEquals(getResult, attrMap.get("cartItemIdsWithOptions"));
  }

  /**
   * Test {@link UncacheableDataProcessor#addCustomerData(Map)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addCustomerData(Map)}
   */
  @Test
  @DisplayName("Test addCustomerData(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UncacheableDataProcessor.addCustomerData(Map)"})
  void testAddCustomerData() {
    // Arrange
    HashMap<String, Object> attrMap = new HashMap<>();

    // Act
    uncacheableDataProcessor.addCustomerData(attrMap);

    // Assert
    assertEquals(3, attrMap.size());
    assertEquals("", attrMap.get("firstName"));
    assertEquals("", attrMap.get("lastName"));
    assertFalse((Boolean) attrMap.get("anonymous"));
  }

  /**
   * Test {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@code callbackBlock}.
   *   <li>Then return {@code Tag Attributes}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName(
      "Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'callbackBlock'; then return 'Tag Attributes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"
  })
  void testGetUncacheableDataFunction_givenCallbackBlock_thenReturnTagAttributes() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");

    // Act and Assert
    assertEquals(
        "Tag Attributes",
        uncacheableDataProcessor.getUncacheableDataFunction(context, tagAttributes));
  }

  /**
   * Test {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@code Tag Attributes;}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName(
      "Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'foo'; then return 'Tag Attributes;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"
  })
  void testGetUncacheableDataFunction_givenFoo_thenReturnTagAttributes() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("foo", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");
    tagAttributes.put("foo", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");

    // Act and Assert
    assertEquals(
        "Tag Attributes;\n",
        uncacheableDataProcessor.getUncacheableDataFunction(context, tagAttributes));
  }

  /**
   * Test {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext,
   * Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code updateUncacheableData(params);}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName(
      "Test getUncacheableDataFunction(BroadleafTemplateContext, Map); when HashMap(); then return 'updateUncacheableData(params);'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"
  })
  void testGetUncacheableDataFunction_whenHashMap_thenReturnUpdateUncacheableDataParams() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act and Assert
    assertEquals(
        "updateUncacheableData(params);\n",
        uncacheableDataProcessor.getUncacheableDataFunction(context, new HashMap<>()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UncacheableDataProcessor#setDefaultCallbackFunction(String)}
   *   <li>{@link UncacheableDataProcessor#getDefaultCallbackFunction()}
   *   <li>{@link UncacheableDataProcessor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getDefaultCallbackFunction()",
    "String UncacheableDataProcessor.getName()",
    "void UncacheableDataProcessor.setDefaultCallbackFunction(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor.setDefaultCallbackFunction("Default Callback Function");
    String actualDefaultCallbackFunction = uncacheableDataProcessor.getDefaultCallbackFunction();

    // Assert
    assertEquals("Default Callback Function", actualDefaultCallbackFunction);
    assertEquals("uncacheabledata", uncacheableDataProcessor.getName());
  }
}
