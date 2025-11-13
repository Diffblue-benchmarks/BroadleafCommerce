package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SimpleSearchBreadcrumbServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleSearchBreadcrumbServiceExtensionHandlerDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_givenCategoryId_thenHashMapContainsKeyCategoryId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_givenEmptyArrayOfString() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_givenFoo_whenHashMapFooIsArrayOfStringWithQ() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_givenNull_whenHashMapQIsNull_thenHashMapContainsKeyQ() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_givenSimpleSearchBreadcrumbServiceExtensionHandler() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_thenExtensionResultHolderContextMapSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.extension.ExtensionResultStatusType SimpleSearchBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_whenHashMap_thenExtensionResultHolderResultEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getBreadcrumbUrl(String, ExtensionResultHolder)"
  })
  public void testGetBreadcrumbUrl() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SimpleSearchBreadcrumbServiceExtensionHandler.getBreadcrumbParams(Map, ExtensionResultHolder)"
  })
  public void testGetBreadcrumbParams() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_givenCategoryId_thenHashMapSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_givenFoo_whenHashMapFooIsArrayOfStringWithQ() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_givenSimpleSearchBreadcrumbServiceExtensionHandler() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_thenExtensionResultHolderContextMapSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSearchBreadcrumbServiceExtensionHandler.updateContextMap(Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_whenHashMap_thenExtensionResultHolderContextMapEmpty() {
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
   *   <li>Given array of {@link String} with {@code q}.
   *   <li>Then return {@code q}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  public void testGetSearchKeyword_givenArrayOfStringWithQ_thenReturnQ() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("q", new String[] {"q"});

    // Act and Assert
    assertEquals(
        "q",
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  public void testGetSearchKeyword_givenEmptyArrayOfString_whenHashMapQIsEmptyArrayOfString() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
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
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code q} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleSearchBreadcrumbServiceExtensionHandler#getSearchKeyword(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  public void testGetSearchKeyword_givenNull_whenHashMapQIsNull_thenReturnNull() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  public void testGetSearchKeyword_whenHashMap_thenReturnNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleSearchBreadcrumbServiceExtensionHandler.getSearchKeyword(String, Map)"
  })
  public void testGetSearchKeyword_whenNull_thenReturnNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SimpleSearchBreadcrumbServiceExtensionHandler.getKeywordParam()"})
  public void testGetKeywordParam() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleSearchBreadcrumbServiceExtensionHandler.getDefaultPriority()"})
  public void testGetDefaultPriority() {
    // Arrange, Act and Assert
    assertEquals(3000, simpleSearchBreadcrumbServiceExtensionHandler.getDefaultPriority());
  }
}
