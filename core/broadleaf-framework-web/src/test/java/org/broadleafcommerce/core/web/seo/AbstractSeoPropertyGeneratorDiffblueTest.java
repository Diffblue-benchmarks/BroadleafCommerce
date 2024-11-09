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
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractSeoPropertyGeneratorDiffblueTest {
  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'; given HashMap()")
  void testGetSimplePropertiesWithCategory_givenHashMap() {
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
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link CategoryAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'; given HashMap() 'foo' is CategoryAttributeImpl (default constructor)")
  void testGetSimplePropertiesWithCategory_givenHashMapFooIsCategoryAttributeImpl() {
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
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'; when CategoryImpl (default constructor); then return Empty")
  void testGetSimplePropertiesWithCategory_whenCategoryImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new CategoryImpl()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; given HashMap() 'foo' is 'foo'; then calls getPageAttributes()")
  void testGetSimplePropertiesWithPage_givenHashMapFooIsFoo_thenCallsGetPageAttributes() {
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
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; given HashMap(); then calls getPageAttributes()")
  void testGetSimplePropertiesWithPage_givenHashMap_thenCallsGetPageAttributes() {
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
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; when PageDTO (default constructor); then return Empty")
  void testGetSimplePropertiesWithPage_whenPageDTO_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new PageDTO()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link ProductAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'; given HashMap() 'foo' is ProductAttributeImpl (default constructor)")
  void testGetSimplePropertiesWithProduct_givenHashMapFooIsProductAttributeImpl() {
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

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ProductImpl#getProductAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'; given HashMap(); then calls getProductAttributes()")
  void testGetSimplePropertiesWithProduct_givenHashMap_thenCallsGetProductAttributes() {
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
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with
   * {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'; when ProductBundleImpl (default constructor); then return Empty")
  void testGetSimplePropertiesWithProduct_whenProductBundleImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new ProductBundleImpl()).isEmpty());
  }
}
