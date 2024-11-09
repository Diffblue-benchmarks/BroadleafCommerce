/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleSearchBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given BiFunction")
  void testModifyBreadcrumbList_givenBiFunction() {
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
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given empty array of String")
  void testModifyBreadcrumbList_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[]{});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    assertEquals(1, params.size());
    assertTrue(params.containsKey("q"));
    assertTrue(holder.getResult().isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code q} is {@code null}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given 'null'; when HashMap() 'q' is 'null'; then HashMap() size is one")
  void testModifyBreadcrumbList_givenNull_whenHashMapQIsNull_thenHashMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    assertEquals(1, params.size());
    assertTrue(params.containsKey("q"));
    assertTrue(holder.getResult().isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) ContextMap size is one")
  void testModifyBreadcrumbList_thenExtensionResultHolderContextMapSizeIsOne() {
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
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); when HashMap(); then HashMap() Empty")
  void testModifyBreadcrumbList_whenHashMap_thenHashMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    assertTrue(params.isEmpty());
    assertTrue(holder.getResult().isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ExtensionResultHolder#getContextMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test getBreadcrumbUrl(String, ExtensionResultHolder); given HashMap(); then calls getContextMap()")
  void testGetBreadcrumbUrl_givenHashMap_thenCallsGetContextMap() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test getBreadcrumbUrl(String, ExtensionResultHolder); when ExtensionResultHolder (default constructor) Result is ArrayList()")
  void testGetBreadcrumbUrl_whenExtensionResultHolderResultIsArrayList() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ExtensionResultHolder#getContextMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test getBreadcrumbParams(Map, ExtensionResultHolder); given HashMap(); then calls getContextMap()")
  void testGetBreadcrumbParams_givenHashMap_thenCallsGetContextMap() {
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
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test getBreadcrumbParams(Map, ExtensionResultHolder); when ExtensionResultHolder (default constructor) Result is ArrayList()")
  void testGetBreadcrumbParams_whenExtensionResultHolderResultIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertTrue(simpleSearchBreadcrumbServiceExtensionHandler.getBreadcrumbParams(params, holder).isEmpty());
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code q} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(Map, ExtensionResultHolder); given BiFunction; when HashMap() computeIfPresent 'q' and BiFunction")
  void testUpdateContextMap_givenBiFunction_whenHashMapComputeIfPresentQAndBiFunction() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@code q}.</li>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(Map, ExtensionResultHolder); given 'q'; then ExtensionResultHolder (default constructor) ContextMap size is one")
  void testUpdateContextMap_givenQ_thenExtensionResultHolderContextMapSizeIsOne() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(Map, ExtensionResultHolder); when HashMap(); then ExtensionResultHolder (default constructor) ContextMap Empty")
  void testUpdateContextMap_whenHashMap_thenExtensionResultHolderContextMapEmpty() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code q} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); given BiFunction; when HashMap() computeIfPresent 'q' and BiFunction")
  void testGetSearchKeyword_givenBiFunction_whenHashMapComputeIfPresentQAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("q", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword("https://example.org/example", params));
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code q} is empty array of
   * {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); given empty array of String; when HashMap() 'q' is empty array of String")
  void testGetSearchKeyword_givenEmptyArrayOfString_whenHashMapQIsEmptyArrayOfString() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is array of {@link String}
   * with {@code Params}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); given 'foo'; when HashMap() 'foo' is array of String with 'Params'")
  void testGetSearchKeyword_givenFoo_whenHashMapFooIsArrayOfStringWithParams() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code q} is array of {@link String} with
   * {@code Params}.</li>
   *   <li>Then return {@code Params}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); when HashMap() 'q' is array of String with 'Params'; then return 'Params'")
  void testGetSearchKeyword_whenHashMapQIsArrayOfStringWithParams_thenReturnParams() {
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
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); when HashMap(); then return 'null'")
  void testGetSearchKeyword_whenHashMap_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler = new SimpleSearchBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword("https://example.org/example", new HashMap<>()));
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); when 'null'; then return 'null'")
  void testGetSearchKeyword_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new SimpleSearchBreadcrumbServiceExtensionHandler()).getSearchKeyword("https://example.org/example", null));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getKeywordParam()}.
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getKeywordParam()}
   */
  @Test
  @DisplayName("Test getKeywordParam()")
  void testGetKeywordParam() {
    // Arrange, Act and Assert
    assertEquals("q", (new SimpleSearchBreadcrumbServiceExtensionHandler()).getKeywordParam());
  }

  /**
   * Test
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   * <p>
   * Method under test:
   * {@link SimpleSearchBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  void testGetDefaultPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(3000, (new SimpleSearchBreadcrumbServiceExtensionHandler()).getDefaultPriority());
  }
}
