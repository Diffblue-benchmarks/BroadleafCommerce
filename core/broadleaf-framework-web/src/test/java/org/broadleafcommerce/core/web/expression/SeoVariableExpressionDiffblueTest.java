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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.web.seo.SeoPropertyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SeoVariableExpressionDiffblueTest {
  @Mock
  private SeoPropertyService seoPropertyService;

  @InjectMocks
  private SeoVariableExpression seoVariableExpression;

  /**
   * Test {@link SeoVariableExpression#getName()}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("seo", (new SeoVariableExpression()).getName());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(Category)} with {@code category}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getMetaProperties(Category)}
   */
  @Test
  @DisplayName("Test getMetaProperties(Category) with 'category'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoVariableExpression.getMetaProperties(Category)"})
  void testGetMetaPropertiesWithCategory() {
    // Arrange
    when(seoPropertyService.getSeoProperties(Mockito.<Category>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualMetaProperties = seoVariableExpression.getMetaProperties(new CategoryImpl());

    // Assert
    verify(seoPropertyService).getSeoProperties(isA(Category.class));
    assertTrue(actualMetaProperties.isEmpty());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(PageDTO)} with {@code page}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getMetaProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getMetaProperties(PageDTO) with 'page'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoVariableExpression.getMetaProperties(PageDTO)"})
  void testGetMetaPropertiesWithPage() {
    // Arrange
    when(seoPropertyService.getSeoProperties(Mockito.<PageDTO>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualMetaProperties = seoVariableExpression.getMetaProperties(new PageDTO());

    // Assert
    verify(seoPropertyService).getSeoProperties(isA(PageDTO.class));
    assertTrue(actualMetaProperties.isEmpty());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(Product)} with {@code product}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getMetaProperties(Product)}
   */
  @Test
  @DisplayName("Test getMetaProperties(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoVariableExpression.getMetaProperties(Product)"})
  void testGetMetaPropertiesWithProduct() {
    // Arrange
    when(seoPropertyService.getSeoProperties(Mockito.<Product>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualMetaProperties = seoVariableExpression.getMetaProperties(new ProductBundleImpl());

    // Assert
    verify(seoPropertyService).getSeoProperties(isA(Product.class));
    assertTrue(actualMetaProperties.isEmpty());
  }
}
