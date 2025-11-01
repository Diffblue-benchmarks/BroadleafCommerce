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
package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleSearchBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, simpleSearchBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder));
    assertTrue(params.isEmpty());
    List<BreadcrumbDTO> result = holder.getResult();
    assertTrue(result.isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
    assertSame(breadcrumbDTOList, result);
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[]{"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = simpleSearchBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
    assertTrue(params.isEmpty());
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("q", mock(BiFunction.class));
    params.put("q", new String[]{"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = simpleSearchBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
    assertTrue(params.isEmpty());
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = simpleSearchBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    assertEquals(1, params.size());
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
    assertTrue(params.containsKey("q"));
    List<BreadcrumbDTO> result = holder.getResult();
    assertTrue(result.isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
    assertSame(breadcrumbDTOList, result);
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[]{});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = simpleSearchBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    assertEquals(1, params.size());
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
    assertTrue(params.containsKey("q"));
    List<BreadcrumbDTO> result = holder.getResult();
    assertTrue(result.isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
    assertSame(breadcrumbDTOList, result);
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String, ExtensionResultHolder)}
   */
  @Test
  void testGetBreadcrumbUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals("https://example.org/example",
        simpleSearchBreadcrumbServiceExtensionHandler.getBreadcrumbUrl("https://example.org/example", holder));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String, ExtensionResultHolder)}
   */
  @Test
  void testGetBreadcrumbUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    when(holder.getContextMap()).thenReturn(new HashMap<>());
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    String actualBreadcrumbUrl = simpleSearchBreadcrumbServiceExtensionHandler
        .getBreadcrumbUrl("https://example.org/example", holder);

    // Assert
    verify(holder).getContextMap();
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertEquals("https://example.org/example", actualBreadcrumbUrl);
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map, ExtensionResultHolder)}
   */
  @Test
  void testGetBreadcrumbParams() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    Map<String, String[]> actualBreadcrumbParams = simpleSearchBreadcrumbServiceExtensionHandler
        .getBreadcrumbParams(params, holder);

    // Assert
    assertTrue(actualBreadcrumbParams.isEmpty());
    assertSame(params, actualBreadcrumbParams);
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map, ExtensionResultHolder)}
   */
  @Test
  void testGetBreadcrumbParams2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    when(holder.getContextMap()).thenReturn(new HashMap<>());
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    Map<String, String[]> actualBreadcrumbParams = simpleSearchBreadcrumbServiceExtensionHandler
        .getBreadcrumbParams(params, holder);

    // Assert
    verify(holder).getContextMap();
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertTrue(actualBreadcrumbParams.isEmpty());
    assertSame(params, actualBreadcrumbParams);
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(params, holder);

    // Assert that nothing has changed
    assertTrue(params.isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[]{"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("q", mock(BiFunction.class));
    params.put("q", new String[]{"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  void testGetSearchKeyword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword("https://example.org/example", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  void testGetSearchKeyword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new SimpleSearchBreadcrumbServiceExtensionHandler()).getSearchKeyword("https://example.org/example", null));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  void testGetSearchKeyword3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);
    params.put("q", new String[]{"Params"});

    // Act and Assert
    assertEquals("Params",
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword("https://example.org/example", params));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  void testGetSearchKeyword4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("q", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword("https://example.org/example", params));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  void testGetSearchKeyword5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);
    params.put("foo", new String[]{"Params"});

    // Act and Assert
    assertNull(simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword("https://example.org/example", params));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  void testGetSearchKeyword6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);
    params.put("q", new String[]{});

    // Act and Assert
    assertNull(simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword("https://example.org/example", params));
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getKeywordParam()}
   */
  @Test
  void testGetKeywordParam() {
    // Arrange, Act and Assert
    assertEquals("q", (new SimpleSearchBreadcrumbServiceExtensionHandler()).getKeywordParam());
  }

  /**
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  void testGetDefaultPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(3000, (new SimpleSearchBreadcrumbServiceExtensionHandler()).getDefaultPriority());
  }
}
