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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractSeoPropertyGeneratorDiffblueTest {
  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'; when CategoryImpl (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(Category)"})
  void testGetSimplePropertiesWithCategory_whenCategoryImpl_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new CategoryImpl()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with {@code page}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; given HashMap() 'foo' is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(PageDTO)"})
  void testGetSimplePropertiesWithPage_givenHashMapFooIsFoo() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> pageAttributes = new HashMap<>();
    pageAttributes.put("foo", "foo");

    PageDTO page = new PageDTO();
    page.setPageAttributes(pageAttributes);

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(page).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; when PageDTO (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(PageDTO)"})
  void testGetSimplePropertiesWithPage_whenPageDTO_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new PageDTO()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'; when ProductBundleImpl (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(Product)"})
  void testGetSimplePropertiesWithProduct_whenProductBundleImpl_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new ProductBundleImpl()).isEmpty());
  }
}
