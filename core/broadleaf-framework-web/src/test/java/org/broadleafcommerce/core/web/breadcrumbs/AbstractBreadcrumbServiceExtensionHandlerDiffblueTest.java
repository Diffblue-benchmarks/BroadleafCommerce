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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class AbstractBreadcrumbServiceExtensionHandlerDiffblueTest {
  @Mock
  private CatalogService catalogService;

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"})
  void testModifyBreadcrumbList() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   * <ul>
   *   <li>Given {@link CategoryBreadcrumbServiceExtensionHandler} (default constructor).</li>
   *   <li>Then return {@code 2000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority(); given CategoryBreadcrumbServiceExtensionHandler (default constructor); then return '2000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AbstractBreadcrumbServiceExtensionHandler.getPriority()"})
  void testGetPriority_givenCategoryBreadcrumbServiceExtensionHandler_thenReturn2000() {
    // Arrange, Act and Assert
    assertEquals(2000, (new CategoryBreadcrumbServiceExtensionHandler()).getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AbstractBreadcrumbServiceExtensionHandler.getPriority()"})
  void testGetPriority_thenReturnOne() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Act and Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}.
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}
   */
  @Test
  @DisplayName("Test setPriority(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractBreadcrumbServiceExtensionHandler.setPriority(Integer)"})
  void testSetPriority() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.priority.intValue());
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code https://example.org/example?foo=foo&42=foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); given '42'; then return 'https://example.org/example?foo=foo&42=foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_given42_thenReturnHttpsExampleOrgExampleFooFoo42Foo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("42", new String[]{"foo"});
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("https://example.org/example?foo=foo&42=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code ?foo=foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); given 'foo'; when empty string; then return '?foo=foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_givenFoo_whenEmptyString_thenReturnFooFoo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("?foo=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code Url?foo=foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); given 'foo'; when 'Url'; then return 'Url?foo=foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_givenFoo_whenUrl_thenReturnUrlFooFoo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("Url?foo=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example?foo=foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); then return 'https://example.org/example?foo=foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_thenReturnHttpsExampleOrgExampleFooFoo() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("https://example.org/example?foo=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_whenEmptyString_thenReturnEmptyString() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("", categoryBreadcrumbServiceExtensionHandler.buildLink("", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when HashMap(); then return 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_whenHashMap_thenReturnHttpsExampleOrgExample() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("https://example.org/example",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when 'null'; then return 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_whenNull_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new CategoryBreadcrumbServiceExtensionHandler()).buildLink("https://example.org/example", null));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code Url}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  @DisplayName("Test buildLink(String, Map); when 'Url'; then return 'Url'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractBreadcrumbServiceExtensionHandler.buildLink(String, Map)"})
  void testBuildLink_whenUrl_thenReturnUrl() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("Url", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   * <ul>
   *   <li>Given {@link CategoryBreadcrumbServiceExtensionHandler} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled(); given CategoryBreadcrumbServiceExtensionHandler (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractBreadcrumbServiceExtensionHandler.isEnabled()"})
  void testIsEnabled_givenCategoryBreadcrumbServiceExtensionHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new CategoryBreadcrumbServiceExtensionHandler()).isEnabled());
  }

  /**
   * Test {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractBreadcrumbServiceExtensionHandler.isEnabled()"})
  void testIsEnabled_thenReturnFalse() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setEnabled(false);

    // Act and Assert
    assertFalse(categoryBreadcrumbServiceExtensionHandler.isEnabled());
  }
}
