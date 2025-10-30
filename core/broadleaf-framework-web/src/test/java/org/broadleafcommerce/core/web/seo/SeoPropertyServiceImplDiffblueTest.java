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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SeoPropertyServiceImplDiffblueTest {
  @Mock
  private List<SeoPropertyGenerator> list;

  @InjectMocks
  private SeoPropertyServiceImpl seoPropertyServiceImpl;

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Category)} with {@code category}.
   * <ul>
   *   <li>Then calls {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Category)}
   */
  @Test
  @DisplayName("Test getSeoProperties(Category) with 'category'; then calls gatherSeoProperties(Category)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(Category)"})
  void testGetSeoPropertiesWithCategory_thenCallsGatherSeoProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = mock(BasicSeoPropertyGeneratorImpl.class);
    when(basicSeoPropertyGeneratorImpl.gatherSeoProperties(Mockito.<Category>any())).thenReturn(new HashMap<>());

    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    seoPropertyGeneratorList.add(basicSeoPropertyGeneratorImpl);
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties = seoPropertyServiceImpl.getSeoProperties(new CategoryImpl());

    // Assert
    verify(list).iterator();
    verify(basicSeoPropertyGeneratorImpl).gatherSeoProperties(isA(Category.class));
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Category)} with {@code category}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Category)}
   */
  @Test
  @DisplayName("Test getSeoProperties(Category) with 'category'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(Category)"})
  void testGetSeoPropertiesWithCategory_thenReturnEmpty() {
    // Arrange
    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties = seoPropertyServiceImpl.getSeoProperties(new CategoryImpl());

    // Assert
    verify(list).iterator();
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)} with {@code page}.
   * <ul>
   *   <li>Then calls {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSeoProperties(PageDTO) with 'page'; then calls gatherSeoProperties(PageDTO)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(PageDTO)"})
  void testGetSeoPropertiesWithPage_thenCallsGatherSeoProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = mock(BasicSeoPropertyGeneratorImpl.class);
    when(basicSeoPropertyGeneratorImpl.gatherSeoProperties(Mockito.<PageDTO>any())).thenReturn(new HashMap<>());

    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    seoPropertyGeneratorList.add(basicSeoPropertyGeneratorImpl);
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties = seoPropertyServiceImpl.getSeoProperties(new PageDTO());

    // Assert
    verify(list).iterator();
    verify(basicSeoPropertyGeneratorImpl).gatherSeoProperties(isA(PageDTO.class));
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)} with {@code page}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSeoProperties(PageDTO) with 'page'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(PageDTO)"})
  void testGetSeoPropertiesWithPage_thenReturnEmpty() {
    // Arrange
    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties = seoPropertyServiceImpl.getSeoProperties(new PageDTO());

    // Assert
    verify(list).iterator();
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Product)} with {@code product}.
   * <ul>
   *   <li>Then calls {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Product)}
   */
  @Test
  @DisplayName("Test getSeoProperties(Product) with 'product'; then calls gatherSeoProperties(Product)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(Product)"})
  void testGetSeoPropertiesWithProduct_thenCallsGatherSeoProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = mock(BasicSeoPropertyGeneratorImpl.class);
    when(basicSeoPropertyGeneratorImpl.gatherSeoProperties(Mockito.<Product>any())).thenReturn(new HashMap<>());

    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    seoPropertyGeneratorList.add(basicSeoPropertyGeneratorImpl);
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties = seoPropertyServiceImpl.getSeoProperties(new ProductBundleImpl());

    // Assert
    verify(list).iterator();
    verify(basicSeoPropertyGeneratorImpl).gatherSeoProperties(isA(Product.class));
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Product)} with {@code product}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Product)}
   */
  @Test
  @DisplayName("Test getSeoProperties(Product) with 'product'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(Product)"})
  void testGetSeoPropertiesWithProduct_thenReturnEmpty() {
    // Arrange
    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties = seoPropertyServiceImpl.getSeoProperties(new ProductBundleImpl());

    // Assert
    verify(list).iterator();
    assertTrue(actualSeoProperties.isEmpty());
  }
}
