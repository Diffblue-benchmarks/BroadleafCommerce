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
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.junit.jupiter.api.Test;

class AbstractBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList2() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("ThreadLocalManager.notify.orphans", mock(BiFunction.class));

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(2000, (new CategoryBreadcrumbServiceExtensionHandler()).getPriority());
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  void testGetPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Act and Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#getPriority()}
   */
  @Test
  void testGetPriority3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    int actualPriority = categoryBreadcrumbServiceExtensionHandler.getPriority();

    // Assert
    verify(category).getParentCategory();
    assertEquals(2000, actualPriority);
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}
   */
  @Test
  void testSetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Assert
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.priority.intValue());
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setPriority(Integer)}
   */
  @Test
  void testSetPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    categoryBreadcrumbServiceExtensionHandler.setPriority(1);

    // Assert
    verify(category).getParentCategory();
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.priority.intValue());
    assertEquals(1, categoryBreadcrumbServiceExtensionHandler.getPriority());
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("https://example.org/example",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new CategoryBreadcrumbServiceExtensionHandler()).buildLink("https://example.org/example", null));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("Url", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertEquals("", categoryBreadcrumbServiceExtensionHandler.buildLink("", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("https://example.org/example?foo=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("foo", mock(BiFunction.class));
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("https://example.org/example?foo=foo",
        categoryBreadcrumbServiceExtensionHandler.buildLink("https://example.org/example", params));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("Url?foo=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("Url", params));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#buildLink(String, Map)}
   */
  @Test
  void testBuildLink9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("foo", new String[]{"foo"});

    // Act and Assert
    assertEquals("?foo=foo", categoryBreadcrumbServiceExtensionHandler.buildLink("", params));
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  void testIsEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryBreadcrumbServiceExtensionHandler()).isEnabled());
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  void testIsEnabled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    boolean actualIsEnabledResult = categoryBreadcrumbServiceExtensionHandler.isEnabled();

    // Assert
    verify(category).getParentCategory();
    assertTrue(actualIsEnabledResult);
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#isEnabled()}
   */
  @Test
  void testIsEnabled3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    categoryBreadcrumbServiceExtensionHandler.setEnabled(false);
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    boolean actualIsEnabledResult = categoryBreadcrumbServiceExtensionHandler.isEnabled();

    // Assert
    verify(category).getParentCategory();
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Method under test:
   * {@link AbstractBreadcrumbServiceExtensionHandler#setEnabled(boolean)}
   */
  @Test
  void testSetEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    categoryBreadcrumbServiceExtensionHandler.setEnabled(true);

    // Assert
    verify(category).getParentCategory();
  }
}
