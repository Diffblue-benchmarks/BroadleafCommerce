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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.Test;

class UncacheableDataProcessorDiffblueTest {
  /**
   * Method under test: {@link UncacheableDataProcessor#getPrecedence()}
   */
  @Test
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new UncacheableDataProcessor()).getPrecedence());
  }

  /**
   * Method under test: {@link UncacheableDataProcessor#isBundle(Product)}
   */
  @Test
  void testIsBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

    // Act and Assert
    assertFalse(uncacheableDataProcessor.isBundle(new ProductBundleImpl()));
  }

  /**
   * Method under test: {@link UncacheableDataProcessor#addCartData(Map)}
   */
  @Test
  void testAddCartData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    HashMap<String, Object> attrMap = new HashMap<>();

    // Act
    uncacheableDataProcessor.addCartData(attrMap);

    // Assert
    assertEquals(3, attrMap.size());
    Object getResult = attrMap.get("cartItemIdsWithOptions");
    assertTrue(getResult instanceof List);
    Object getResult2 = attrMap.get("cartItemIdsWithoutOptions");
    assertTrue(getResult2 instanceof List);
    assertTrue(attrMap.containsKey("cartItemCount"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((List<Object>) getResult2).isEmpty());
  }

  /**
   * Method under test: {@link UncacheableDataProcessor#addCustomerData(Map)}
   */
  @Test
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
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  void testGetUncacheableDataFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act and Assert
    assertEquals("updateUncacheableData(params);\n",
        uncacheableDataProcessor.getUncacheableDataFunction(context, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  void testGetUncacheableDataFunction2() {
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
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  void testGetUncacheableDataFunction3() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link UncacheableDataProcessor#setDefaultCallbackFunction(String)}
   *   <li>{@link UncacheableDataProcessor#getDefaultCallbackFunction()}
   *   <li>{@link UncacheableDataProcessor#getName()}
   * </ul>
   */
  @Test
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
