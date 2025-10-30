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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.InventoryService;
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
  @InjectMocks
  private UncacheableDataProcessor uncacheableDataProcessor;

  @Mock
  private UncacheableDataProcessorExtensionManager uncacheableDataProcessorExtensionManager;

  @Mock
  private ExploitProtectionService exploitProtectionService;

  @Mock
  private InventoryService inventoryService;

  @Mock
  private InventoryServiceExtensionManager inventoryServiceExtensionManager;

  /**
   * Test {@link UncacheableDataProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int UncacheableDataProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, uncacheableDataProcessor.getPrecedence());
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ExploitProtectionService} {@link ExploitProtectionService#getCSRFToken()} return {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext); given ExploitProtectionService getCSRFToken() return 'ABC123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  void testGetReplacementModel_givenExploitProtectionServiceGetCSRFTokenReturnAbc123() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler = mock(
        UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
        Mockito.<BroadleafTemplateContext>any(), Mockito.<Set<Product>>any(), Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context).createModel();
    verify(context).createTextElement(eq(
        "<SCRIPT>\n  var params = \n  {\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\",\"outOfStockSkus\":[]};\n  updateUncacheableData(params);\n</SCRIPT>"));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ExploitProtectionService} {@link ExploitProtectionService#getCSRFToken()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext); given ExploitProtectionService getCSRFToken() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  void testGetReplacementModel_givenExploitProtectionServiceGetCSRFTokenReturnNull() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn(null);
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler = mock(
        UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
        Mockito.<BroadleafTemplateContext>any(), Mockito.<Set<Product>>any(), Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context).createModel();
    verify(context).createTextElement(eq(
        "<SCRIPT>\n  var params = \n  {\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":null,\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\",\"outOfStockSkus\":[]};\n  updateUncacheableData(params);\n</SCRIPT>"));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ExploitProtectionService} {@link ExploitProtectionService#getCSRFToken()} return {@code <SCRIPT>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext); given ExploitProtectionService getCSRFToken() return '<SCRIPT>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  void testGetReplacementModel_givenExploitProtectionServiceGetCSRFTokenReturnScript() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("<SCRIPT>\n");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler = mock(
        UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
        Mockito.<BroadleafTemplateContext>any(), Mockito.<Set<Product>>any(), Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context).createModel();
    verify(context).createTextElement(eq(
        "<SCRIPT>\n  var params = \n  {\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"<SCRIPT>\\n\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\",\"outOfStockSkus\":[]};\n  updateUncacheableData(params);\n</SCRIPT>"));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  void testGetReplacementModel_thenThrowRuntimeException() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenThrow(new RuntimeException("<SCRIPT>\n"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context));
    verify(context).getVariable(eq("blcAllDisplayedProducts"));
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test buildContentMap(BroadleafTemplateContext); given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap_givenHashSet() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler = mock(
        UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
        Mockito.<BroadleafTemplateContext>any(), Mockito.<Set<Product>>any(), Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenReturn(uncacheableDataProcessorExtensionHandler);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    String actualBuildContentMapResult = uncacheableDataProcessor.buildContentMap(context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    assertEquals(
        "{\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions"
            + "\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\","
            + "\"outOfStockSkus\":[]}",
        actualBuildContentMapResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BroadleafTemplateContext} {@link BroadleafTemplateContext#getVariable(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test buildContentMap(BroadleafTemplateContext); given 'null'; when BroadleafTemplateContext getVariable(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap_givenNull_whenBroadleafTemplateContextGetVariableReturnNull() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler = mock(
        UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
        Mockito.<BroadleafTemplateContext>any(), Mockito.<Set<Product>>any(), Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenReturn(uncacheableDataProcessorExtensionHandler);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(null);

    // Act
    String actualBuildContentMapResult = uncacheableDataProcessor.buildContentMap(context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
    verify(context, atLeast(1)).getVariable(Mockito.<String>any());
    assertEquals(
        "{\"firstName\":\"\",\"lastName\":\"\",\"csrfToken\":\"ABC123\",\"cartItemIdsWithoutOptions\":[],\"cartItemIdsWithOptions"
            + "\":[],\"anonymous\":false,\"cartItemCount\":0,\"outOfStockProducts\":[],\"csrfTokenParameter\":\"ABC123\","
            + "\"outOfStockSkus\":[]}",
        actualBuildContentMapResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test buildContentMap(BroadleafTemplateContext); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  void testBuildContentMap_thenThrowRuntimeException() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any()))
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uncacheableDataProcessor.buildContentMap(context));
    verify(context).getVariable(eq("blcAllDisplayedProducts"));
  }

  /**
   * Test {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test addProductInventoryData(Map, BroadleafTemplateContext); given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"})
  void testAddProductInventoryData_givenHashSet() {
    // Arrange
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler = mock(
        UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
        Mockito.<BroadleafTemplateContext>any(), Mockito.<Set<Product>>any(), Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, Object> attrMap = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    uncacheableDataProcessor.addProductInventoryData(attrMap, context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
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
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test addProductInventoryData(Map, BroadleafTemplateContext); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"})
  void testAddProductInventoryData_givenNull() {
    // Arrange
    UncacheableDataProcessorExtensionHandler uncacheableDataProcessorExtensionHandler = mock(
        UncacheableDataProcessorExtensionHandler.class);
    when(uncacheableDataProcessorExtensionHandler.modifyProductListForInventoryCheck(
        Mockito.<BroadleafTemplateContext>any(), Mockito.<Set<Product>>any(), Mockito.<Set<Sku>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(uncacheableDataProcessorExtensionManager.getProxy()).thenReturn(uncacheableDataProcessorExtensionHandler);
    HashMap<String, Object> attrMap = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(null);

    // Act
    uncacheableDataProcessor.addProductInventoryData(attrMap, context);

    // Assert
    verify(uncacheableDataProcessorExtensionManager).getProxy();
    verify(uncacheableDataProcessorExtensionHandler)
        .modifyProductListForInventoryCheck(isA(BroadleafTemplateContext.class), isA(Set.class), isA(Set.class));
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
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test addProductInventoryData(Map, BroadleafTemplateContext); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"})
  void testAddProductInventoryData_thenThrowRuntimeException() {
    // Arrange
    HashMap<String, Object> attrMap = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenThrow(new RuntimeException("blcAllDisplayedProducts"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uncacheableDataProcessor.addProductInventoryData(attrMap, context));
    verify(context).getVariable(eq("blcAllDisplayedProducts"));
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenThrow(new RuntimeException("product"));
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(productBundleImpl);
    HashSet<Product> allProducts = new HashSet<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, new HashSet<>()));
    verify(productBundleImpl).getId();
    verify(context).getVariable(eq("product"));
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts2() {
    // Arrange
    when(inventoryService.isAvailable(Mockito.<Sku>any(), anyInt())).thenThrow(new RuntimeException("product"));
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(mock(ProductBundleImpl.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());

    HashSet<Product> allProducts = new HashSet<>();
    allProducts.add(productBundleImpl);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, new HashSet<>()));
    verify(productBundleImpl, atLeast(1)).getDefaultSku();
    verify(inventoryService).isAvailable(isA(Sku.class), eq(1));
    verify(context).getVariable(eq("product"));
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts3() {
    // Arrange
    when(inventoryService.isAvailable(Mockito.<Sku>any(), anyInt())).thenReturn(true);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(mock(ProductBundleImpl.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    ProductBundleImpl productBundleImpl2 = mock(ProductBundleImpl.class);
    when(productBundleImpl2.getDefaultSku()).thenThrow(new RuntimeException("foo"));

    HashSet<Product> allProducts = new HashSet<>();
    allProducts.add(productBundleImpl2);
    allProducts.add(productBundleImpl);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, new HashSet<>()));
    verify(productBundleImpl2).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getDefaultSku();
    verify(inventoryService).isAvailable(isA(Sku.class), eq(1));
    verify(context).getVariable(eq("product"));
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set); given ProductBundleImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts_givenProductBundleImpl() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(mock(ProductBundleImpl.class));

    HashSet<Product> allProducts = new HashSet<>();
    allProducts.add(new ProductBundleImpl());
    HashSet<Long> outOfStockProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, outOfStockProducts);

    // Assert that nothing has changed
    verify(context).getVariable(eq("product"));
    assertTrue(outOfStockProducts.isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set); given ProductBundleImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts_givenProductBundleImpl2() {
    // Arrange
    when(inventoryService.isAvailable(Mockito.<Sku>any(), anyInt())).thenReturn(true);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(mock(ProductBundleImpl.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());

    HashSet<Product> allProducts = new HashSet<>();
    allProducts.add(new ProductBundleImpl());
    allProducts.add(productBundleImpl);
    HashSet<Long> outOfStockProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, outOfStockProducts);

    // Assert that nothing has changed
    verify(productBundleImpl, atLeast(1)).getDefaultSku();
    verify(inventoryService).isAvailable(isA(Sku.class), eq(1));
    verify(context).getVariable(eq("product"));
    assertTrue(outOfStockProducts.isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} contains zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set); then HashSet() contains zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts_thenHashSetContainsZero() {
    // Arrange
    when(inventoryService.isAvailable(Mockito.<Sku>any(), anyInt())).thenReturn(false);
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.isBlockingAvailabilityOfProduct(Mockito.<Product>any(),
        Mockito.<Product>any(), Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(0L);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(productBundleImpl);
    ProductBundleImpl productBundleImpl2 = mock(ProductBundleImpl.class);
    when(productBundleImpl2.getId()).thenReturn(1L);
    when(productBundleImpl2.getDefaultSku()).thenReturn(new SkuImpl());

    HashSet<Product> allProducts = new HashSet<>();
    allProducts.add(productBundleImpl2);
    HashSet<Long> outOfStockProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, outOfStockProducts);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(productBundleImpl2, atLeast(1)).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getId();
    verify(productBundleImpl2, atLeast(1)).getId();
    verify(inventoryService).isAvailable(isA(Sku.class), eq(1));
    verify(inventoryServiceExtensionHandler).isBlockingAvailabilityOfProduct(isA(Product.class), isA(Product.class),
        isA(ExtensionResultHolder.class));
    verify(context).getVariable(eq("product"));
    assertEquals(2, outOfStockProducts.size());
    assertTrue(outOfStockProducts.contains(0L));
    assertTrue(outOfStockProducts.contains(1L));
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set); then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts_thenHashSetEmpty() {
    // Arrange
    when(inventoryService.isAvailable(Mockito.<Sku>any(), anyInt())).thenReturn(true);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(mock(ProductBundleImpl.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());

    HashSet<Product> allProducts = new HashSet<>();
    allProducts.add(productBundleImpl);
    HashSet<Long> outOfStockProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, outOfStockProducts);

    // Assert that nothing has changed
    verify(productBundleImpl, atLeast(1)).getDefaultSku();
    verify(inventoryService).isAvailable(isA(Sku.class), eq(1));
    verify(context).getVariable(eq("product"));
    assertTrue(outOfStockProducts.isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set); then HashSet() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts_thenHashSetSizeIsOne() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(1L);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(productBundleImpl);
    HashSet<Product> allProducts = new HashSet<>();
    HashSet<Long> outOfStockProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, outOfStockProducts);

    // Assert
    verify(productBundleImpl).getId();
    verify(context).getVariable(eq("product"));
    assertEquals(1, outOfStockProducts.size());
    assertTrue(outOfStockProducts.contains(1L));
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set); then HashSet() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts_thenHashSetSizeIsOne2() {
    // Arrange
    when(inventoryService.isAvailable(Mockito.<Sku>any(), anyInt())).thenReturn(false);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(1L);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(productBundleImpl);
    ProductBundleImpl productBundleImpl2 = mock(ProductBundleImpl.class);
    when(productBundleImpl2.getId()).thenReturn(1L);
    when(productBundleImpl2.getDefaultSku()).thenReturn(new SkuImpl());

    HashSet<Product> allProducts = new HashSet<>();
    allProducts.add(productBundleImpl2);
    HashSet<Long> outOfStockProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, outOfStockProducts);

    // Assert
    verify(productBundleImpl2, atLeast(1)).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getId();
    verify(productBundleImpl2, atLeast(1)).getId();
    verify(inventoryService).isAvailable(isA(Sku.class), eq(1));
    verify(context).getVariable(eq("product"));
    assertEquals(1, outOfStockProducts.size());
    assertTrue(outOfStockProducts.contains(1L));
  }

  /**
   * Test {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <ul>
   *   <li>When {@link BroadleafTemplateContext} {@link BroadleafTemplateContext#getVariable(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set); when BroadleafTemplateContext getVariable(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UncacheableDataProcessor.defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)"})
  void testDefineOutOfStockProducts_whenBroadleafTemplateContextGetVariableReturnNull() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(null);
    HashSet<Product> allProducts = new HashSet<>();
    HashSet<Long> outOfStockProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor.defineOutOfStockProducts(context, allProducts, outOfStockProducts);

    // Assert that nothing has changed
    verify(context).getVariable(eq("product"));
    assertTrue(outOfStockProducts.isEmpty());
  }

  /**
   * Test {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"})
  void testIsBlockingAvailabilityOfProduct() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.isBlockingAvailabilityOfProduct(Mockito.<Product>any(),
        Mockito.<Product>any(), Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act
    boolean actualIsBlockingAvailabilityOfProductResult = uncacheableDataProcessor
        .isBlockingAvailabilityOfProduct(baseProduct, new ProductBundleImpl());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).isBlockingAvailabilityOfProduct(isA(Product.class), isA(Product.class),
        isA(ExtensionResultHolder.class));
    assertFalse(actualIsBlockingAvailabilityOfProductResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"})
  void testIsBlockingAvailabilityOfProduct2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.isBlockingAvailabilityOfProduct(Mockito.<Product>any(),
        Mockito.<Product>any(), Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act
    boolean actualIsBlockingAvailabilityOfProductResult = uncacheableDataProcessor
        .isBlockingAvailabilityOfProduct(baseProduct, new ProductBundleImpl());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).isBlockingAvailabilityOfProduct(isA(Product.class), isA(Product.class),
        isA(ExtensionResultHolder.class));
    assertFalse(actualIsBlockingAvailabilityOfProductResult);
  }

  /**
   * Test {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"})
  void testIsBlockingAvailabilityOfProduct_thenThrowRuntimeException() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.isBlockingAvailabilityOfProduct(Mockito.<Product>any(),
        Mockito.<Product>any(), Mockito.<ExtensionResultHolder<Boolean>>any())).thenThrow(new RuntimeException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uncacheableDataProcessor.isBlockingAvailabilityOfProduct(baseProduct, new ProductBundleImpl()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).isBlockingAvailabilityOfProduct(isA(Product.class), isA(Product.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link UncacheableDataProcessor#isBundle(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#isBundle(Product)}
   */
  @Test
  @DisplayName("Test isBundle(Product); when ProductBundleImpl (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UncacheableDataProcessor.isBundle(Product)"})
  void testIsBundle_whenProductBundleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(uncacheableDataProcessor.isBundle(new ProductBundleImpl()));
  }

  /**
   * Test {@link UncacheableDataProcessor#addCartData(Map)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addCartData(Map)}
   */
  @Test
  @DisplayName("Test addCartData(Map)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addCustomerData(Map)}
   */
  @Test
  @DisplayName("Test addCustomerData(Map)")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>Given {@code callbackBlock}.</li>
   *   <li>Then return {@code Tag Attributes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'callbackBlock'; then return 'Tag Attributes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"})
  void testGetUncacheableDataFunction_givenCallbackBlock_thenReturnTagAttributes() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");

    // Act and Assert
    assertEquals("Tag Attributes", uncacheableDataProcessor.getUncacheableDataFunction(context, tagAttributes));
  }

  /**
   * Test {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code Tag Attributes;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'foo'; then return 'Tag Attributes;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"})
  void testGetUncacheableDataFunction_givenFoo_thenReturnTagAttributes() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("foo", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");
    tagAttributes.put("foo", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");

    // Act and Assert
    assertEquals("Tag Attributes;\n", uncacheableDataProcessor.getUncacheableDataFunction(context, tagAttributes));
  }

  /**
   * Test {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code updateUncacheableData(params);}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); when HashMap(); then return 'updateUncacheableData(params);'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"})
  void testGetUncacheableDataFunction_whenHashMap_thenReturnUpdateUncacheableDataParams() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act and Assert
    assertEquals("updateUncacheableData(params);\n",
        uncacheableDataProcessor.getUncacheableDataFunction(context, new HashMap<>()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UncacheableDataProcessor#setDefaultCallbackFunction(String)}
   *   <li>{@link UncacheableDataProcessor#getDefaultCallbackFunction()}
   *   <li>{@link UncacheableDataProcessor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UncacheableDataProcessor.getDefaultCallbackFunction()",
      "String UncacheableDataProcessor.getName()", "void UncacheableDataProcessor.setDefaultCallbackFunction(String)"})
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
