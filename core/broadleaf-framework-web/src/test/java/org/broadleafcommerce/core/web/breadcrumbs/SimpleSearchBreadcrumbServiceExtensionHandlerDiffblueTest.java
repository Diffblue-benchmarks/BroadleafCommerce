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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SimpleSearchBreadcrumbServiceExtensionHandler.class})
@ExtendWith(SpringExtension.class)
class SimpleSearchBreadcrumbServiceExtensionHandlerDiffblueTest {
  @MockBean(name = "blBreadcrumbServiceExtensionManager")
  private BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager;

  @Autowired
  private SimpleSearchBreadcrumbServiceExtensionHandler
      simpleSearchBreadcrumbServiceExtensionHandler;

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@code categoryId}.
   *   <li>Then {@link HashMap#HashMap()} containsKey {@code categoryId}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given 'categoryId'; then HashMap() containsKey 'categoryId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList_givenCategoryId_thenHashMapContainsKeyCategoryId() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("categoryId", new String[] {"q"});
    params.put("q", new String[] {"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert
    assertEquals(1, params.size());
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.containsKey("categoryId"));
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given empty array of String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList_givenEmptyArrayOfString() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[] {});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert that nothing has changed
    assertEquals(1, params.size());
    assertTrue(params.containsKey("q"));
    assertTrue(holder.getResult().isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is array of {@link String} with {@code q}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given 'foo'; when HashMap() 'foo' is array of String with 'q'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList_givenFoo_whenHashMapFooIsArrayOfStringWithQ() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[] {"q"});
    params.put("q", new String[] {"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code q} is {@code null}.
   *   <li>Then {@link HashMap#HashMap()} containsKey {@code q}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given 'null'; when HashMap() 'q' is 'null'; then HashMap() containsKey 'q'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList_givenNull_whenHashMapQIsNull_thenHashMapContainsKeyQ() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert that nothing has changed
    assertEquals(1, params.size());
    assertTrue(params.containsKey("q"));
    assertTrue(holder.getResult().isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link SimpleSearchBreadcrumbServiceExtensionHandler} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given SimpleSearchBreadcrumbServiceExtensionHandler (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList_givenSimpleSearchBreadcrumbServiceExtensionHandler() {
    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler =
        new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[] {"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) ContextMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList_thenExtensionResultHolderContextMapSizeIsOne() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[] {"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(breadcrumbDTOList, holder.getResult());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link ExtensionResultHolder} (default constructor) Result Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); when HashMap(); then ExtensionResultHolder (default constructor) Result Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList_whenHashMap_thenExtensionResultHolderResultEmpty() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert that nothing has changed
    assertTrue(params.isEmpty());
    assertTrue(holder.getResult().isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbUrl(String, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test getBreadcrumbUrl(String, ExtensionResultHolder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getBreadcrumbUrl(String, ExtensionResultHolder)"
  })
  void testGetBreadcrumbUrl() {
    // Arrange
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        "https://example.org/example",
        simpleSearchBreadcrumbServiceExtensionHandler.getBreadcrumbUrl(
            "https://example.org/example", holder));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getBreadcrumbParams(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test getBreadcrumbParams(Map, ExtensionResultHolder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SimpleSearchBreadcrumbServiceExtensionHandler.getBreadcrumbParams(Map, ExtensionResultHolder)"
  })
  void testGetBreadcrumbParams() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertTrue(
        simpleSearchBreadcrumbServiceExtensionHandler
            .getBreadcrumbParams(params, holder)
            .isEmpty());
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@code categoryId}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test updateContextMap(Map, ExtensionResultHolder); given 'categoryId'; then HashMap() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  void testUpdateContextMap_givenCategoryId_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("categoryId", new String[] {"q"});
    params.put("q", new String[] {"q"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    simpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(params, holder);

    // Assert
    assertEquals(1, params.size());
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.containsKey("categoryId"));
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is array of {@link String} with {@code q}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test updateContextMap(Map, ExtensionResultHolder); given 'foo'; when HashMap() 'foo' is array of String with 'q'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  void testUpdateContextMap_givenFoo_whenHashMapFooIsArrayOfStringWithQ() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[] {"q"});
    params.put("q", new String[] {"q"});

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
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link SimpleSearchBreadcrumbServiceExtensionHandler} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test updateContextMap(Map, ExtensionResultHolder); given SimpleSearchBreadcrumbServiceExtensionHandler (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  void testUpdateContextMap_givenSimpleSearchBreadcrumbServiceExtensionHandler() {
    // Arrange
    SimpleSearchBreadcrumbServiceExtensionHandler simpleSearchBreadcrumbServiceExtensionHandler =
        new SimpleSearchBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[] {"q"});

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
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test updateContextMap(Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) ContextMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  void testUpdateContextMap_thenExtensionResultHolderContextMapSizeIsOne() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[] {"q"});

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
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#updateContextMap(Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName(
      "Test updateContextMap(Map, ExtensionResultHolder); when HashMap(); then ExtensionResultHolder (default constructor) ContextMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  void testUpdateContextMap_whenHashMap_thenExtensionResultHolderContextMapEmpty() {
    // Arrange
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
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Params}.
   *   <li>Then return {@code Params}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName(
      "Test getSearchKeyword(String, Map); given array of String with 'Params'; then return 'Params'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  void testGetSearchKeyword_givenArrayOfStringWithParams_thenReturnParams() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);
    params.put("q", new String[] {"Params"});

    // Act and Assert
    assertEquals(
        "Params",
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(
            "https://example.org/example", params));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   *
   * <ul>
   *   <li>Given empty array of {@link String}.
   *   <li>When {@link HashMap#HashMap()} {@code q} is empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName(
      "Test getSearchKeyword(String, Map); given empty array of String; when HashMap() 'q' is empty array of String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  void testGetSearchKeyword_givenEmptyArrayOfString_whenHashMapQIsEmptyArrayOfString() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);
    params.put("q", new String[] {});

    // Act and Assert
    assertNull(
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(
            "https://example.org/example", params));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code q}.
   *   <li>When {@link HashMap#HashMap()} {@code q} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName(
      "Test getSearchKeyword(String, Map); given 'q'; when HashMap() 'q' is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  void testGetSearchKeyword_givenQ_whenHashMapQIsNull_thenReturnNull() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", null);
    params.put("q", null);

    // Act and Assert
    assertNull(
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(
            "https://example.org/example", params));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); when HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  void testGetSearchKeyword_whenHashMap_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(
            "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @DisplayName("Test getSearchKeyword(String, Map); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  void testGetSearchKeyword_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        simpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(
            "https://example.org/example", null));
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getKeywordParam()}.
   *
   * <p>Method under test: {@link SimpleSearchBreadcrumbServiceExtensionHandler#getKeywordParam()}
   */
  @Test
  @DisplayName("Test getKeywordParam()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SimpleSearchBreadcrumbServiceExtensionHandler.getKeywordParam()"})
  void testGetKeywordParam() {
    // Arrange, Act and Assert
    assertEquals("q", new SimpleSearchBreadcrumbServiceExtensionHandler().getKeywordParam());
  }

  /**
   * Test {@link SimpleSearchBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleSearchBreadcrumbServiceExtensionHandler.getDefaultPriority()"})
  void testGetDefaultPriority() {
    // Arrange, Act and Assert
    assertEquals(3000, simpleSearchBreadcrumbServiceExtensionHandler.getDefaultPriority());
  }
}
