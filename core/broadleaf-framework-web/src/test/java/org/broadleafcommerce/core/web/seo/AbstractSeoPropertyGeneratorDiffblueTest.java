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
package org.broadleafcommerce.core.web.seo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryAttribute;
import org.broadleafcommerce.core.catalog.domain.CategoryAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductAttribute;
import org.broadleafcommerce.core.catalog.domain.ProductAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.jupiter.api.Test;

class AbstractSeoPropertyGeneratorDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  void testGetSimpleProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new PageDTO()).isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  void testGetSimpleProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getPageAttributes()).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(page);

    // Assert
    verify(page).getPageAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  void testGetSimpleProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getPageAttributes()).thenReturn(stringStringMap);

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(page);

    // Assert
    verify(page).getPageAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  void testGetSimpleProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new CategoryImpl()).isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  void testGetSimpleProperties5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryAttributesMap()).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(category);

    // Assert
    verify(category).getCategoryAttributesMap();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  void testGetSimpleProperties6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, CategoryAttribute> stringCategoryAttributeMap = new HashMap<>();
    stringCategoryAttributeMap.put("foo", new CategoryAttributeImpl());
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryAttributesMap()).thenReturn(stringCategoryAttributeMap);

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(category);

    // Assert
    verify(category).getCategoryAttributesMap();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  void testGetSimpleProperties7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new ProductBundleImpl()).isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  void testGetSimpleProperties8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductAttributes()).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(product);

    // Assert
    verify(product).getProductAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  void testGetSimpleProperties9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, ProductAttribute> stringProductAttributeMap = new HashMap<>();
    stringProductAttributeMap.put("foo", new ProductAttributeImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductAttributes()).thenReturn(stringProductAttributeMap);

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(product);

    // Assert
    verify(product).getProductAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }
}
