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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UncacheableDataProcessorDiffblueTest {
  /**
   * Test {@link UncacheableDataProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new UncacheableDataProcessor()).getPrecedence());
  }

  /**
   * Test {@link UncacheableDataProcessor#isBundle(Product)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#isBundle(Product)}
   */
  @Test
  @DisplayName("Test isBundle(Product)")
  void testIsBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

    // Act and Assert
    assertFalse(uncacheableDataProcessor.isBundle(new ProductBundleImpl()));
  }

  /**
   * Test {@link UncacheableDataProcessor#addCartData(Map)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addCartData(Map)}
   */
  @Test
  @DisplayName("Test addCartData(Map)")
  void testAddCartData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    HashMap<String, Object> attrMap = new HashMap<>();

    // Act
    uncacheableDataProcessor.addCartData(attrMap);

    // Assert
    assertEquals(3, attrMap.size());
    Object getResult = attrMap.get("cartItemIdsWithoutOptions");
    assertTrue(getResult instanceof List);
    assertTrue(attrMap.containsKey("cartItemCount"));
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
  void testAddCustomerData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    HashMap<String, Object> attrMap = new HashMap<>();

    // Act
    uncacheableDataProcessor.addCustomerData(attrMap);

    // Assert
    assertEquals(3, attrMap.size());
    assertEquals("", attrMap.get("firstName"));
    assertEquals("", attrMap.get("lastName"));
    assertTrue(attrMap.containsKey("anonymous"));
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>Given {@code callbackBlock}.</li>
   *   <li>Then return {@code Tag Attributes}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'callbackBlock'; then return 'Tag Attributes'")
  void testGetUncacheableDataFunction_givenCallbackBlock_thenReturnTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
   * Test
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code Tag Attributes;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'foo'; then return 'Tag Attributes;'")
  void testGetUncacheableDataFunction_givenFoo_thenReturnTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
   * Test
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code updateUncacheableData(params);}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); when HashMap(); then return 'updateUncacheableData(params);'")
  void testGetUncacheableDataFunction_whenHashMap_thenReturnUpdateUncacheableDataParams() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
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
  void testGettersAndSetters() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor.setDefaultCallbackFunction("Default Callback Function");
    String actualDefaultCallbackFunction = uncacheableDataProcessor.getDefaultCallbackFunction();

    // Assert that nothing has changed
    assertEquals("Default Callback Function", actualDefaultCallbackFunction);
    assertEquals("uncacheabledata", uncacheableDataProcessor.getName());
  }
}
