package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UncacheableDataProcessorDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UncacheableDataProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, new UncacheableDataProcessor().getPrecedence());
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel() throws ServiceException {
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
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel_givenCallbackBlock() throws ServiceException {
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

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getVariable(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    uncacheableDataProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
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
  }

  /**
   * Test {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link UncacheableDataProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel_givenUncacheableDataProcessor() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
   *   <li>Then calls {@link ExploitProtectionService#getCsrfTokenParameter()}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel UncacheableDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel_thenCallsGetCsrfTokenParameter() throws ServiceException {
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

    // Assert
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
  }

  /**
   * Test {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  public void testBuildContentMap() throws ServiceException {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  public void testBuildContentMap_givenExploitProtectionServiceGetCSRFTokenReturnAbc123()
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  public void testBuildContentMap_givenExploitProtectionServiceGetCSRFTokenReturnNull()
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
   *   <li>Given {@link UncacheableDataProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UncacheableDataProcessor.buildContentMap(BroadleafTemplateContext)"})
  public void testBuildContentMap_givenUncacheableDataProcessor() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  public void testAddProductInventoryData() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  public void testAddProductInventoryData2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  public void testAddProductInventoryData_givenHashSetAdd42_thenThrowRuntimeException() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  public void testAddProductInventoryData_givenNull() {
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
   *   <li>Given {@link UncacheableDataProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addProductInventoryData(Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  public void testAddProductInventoryData_givenUncacheableDataProcessor() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncacheableDataProcessor.addProductInventoryData(Map, BroadleafTemplateContext)"
  })
  public void testAddProductInventoryData_thenHashMapSizeIsTwo() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  public void testIsBlockingAvailabilityOfProduct() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  public void testIsBlockingAvailabilityOfProduct2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  public void testIsBlockingAvailabilityOfProduct3() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UncacheableDataProcessor.isBlockingAvailabilityOfProduct(Product, Product)"
  })
  public void testIsBlockingAvailabilityOfProduct4() {
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
   *   <li>Given {@link UncacheableDataProcessor} (default constructor).
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UncacheableDataProcessor#isBundle(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UncacheableDataProcessor.isBundle(Product)"})
  public void testIsBundle_givenUncacheableDataProcessor_whenProductBundleImpl_thenReturnFalse() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

    // Act and Assert
    assertFalse(uncacheableDataProcessor.isBundle(new ProductBundleImpl()));
  }

  /**
   * Test {@link UncacheableDataProcessor#addCartData(Map)}.
   *
   * <p>Method under test: {@link UncacheableDataProcessor#addCartData(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UncacheableDataProcessor.addCartData(Map)"})
  public void testAddCartData() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UncacheableDataProcessor.addCustomerData(Map)"})
  public void testAddCustomerData() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"
  })
  public void testGetUncacheableDataFunction_givenCallbackBlock_thenReturnTagAttributes() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"
  })
  public void testGetUncacheableDataFunction_givenFoo_thenReturnTagAttributes() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getUncacheableDataFunction(BroadleafTemplateContext, Map)"
  })
  public void testGetUncacheableDataFunction_whenHashMap_thenReturnUpdateUncacheableDataParams() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UncacheableDataProcessor.getDefaultCallbackFunction()",
    "String UncacheableDataProcessor.getName()",
    "void UncacheableDataProcessor.setDefaultCallbackFunction(String)"
  })
  public void testGettersAndSetters() {
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
