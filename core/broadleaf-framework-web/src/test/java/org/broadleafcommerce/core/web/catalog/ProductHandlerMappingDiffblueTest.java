package org.broadleafcommerce.core.web.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.cors.DefaultCorsProcessor;

@RunWith(MockitoJUnitRunner.class)
public class ProductHandlerMappingDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private ProductHandlerMapping productHandlerMapping;

  /**
   * Test {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ProductHandlerMapping.findProductUsingIdParam(HttpServletRequest)"})
  public void testFindProductUsingIdParam_givenCatalogServiceFindProductByIdReturnNull()
      throws ServletRequestBindingException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("productId", "42");

    // Act
    Product actualFindProductUsingIdParamResult =
        productHandlerMapping.findProductUsingIdParam(request);

    // Assert
    verify(catalogService).findProductById(42L);
    assertNull(actualFindProductUsingIdParamResult);
  }

  /**
   * Test {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link ProductHandlerMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ProductHandlerMapping.findProductUsingIdParam(HttpServletRequest)"})
  public void testFindProductUsingIdParam_givenProductHandlerMapping()
      throws ServletRequestBindingException {
    // Arrange
    ProductHandlerMapping productHandlerMapping = new ProductHandlerMapping();

    // Act and Assert
    assertNull(productHandlerMapping.findProductUsingIdParam(new MockHttpServletRequest()));
  }

  /**
   * Test {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ProductHandlerMapping.findProductUsingIdParam(HttpServletRequest)"})
  public void testFindProductUsingIdParam_thenReturnProductBundleImpl()
      throws ServletRequestBindingException {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("productId", "42");

    // Act
    Product actualFindProductUsingIdParamResult =
        productHandlerMapping.findProductUsingIdParam(request);

    // Assert
    verify(catalogService).findProductById(42L);
    assertSame(productBundleImpl, actualFindProductUsingIdParamResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link ProductHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ProductHandlerMapping.getDefaultTemplateName()",
    "void ProductHandlerMapping.setDefaultTemplateName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProductHandlerMapping productHandlerMapping = new ProductHandlerMapping();

    // Act
    productHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert
    assertEquals("Default Template Name", productHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link ProductHandlerMapping} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ProductHandlerMapping}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductHandlerMapping.<init>()"})
  public void testNewProductHandlerMapping() {
    // Arrange and Act
    ProductHandlerMapping actualProductHandlerMapping = new ProductHandlerMapping();

    // Assert
    assertTrue(actualProductHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualProductHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/product", actualProductHandlerMapping.getDefaultTemplateName());
    assertNull(actualProductHandlerMapping.getDefaultHandler());
    assertNull(actualProductHandlerMapping.getControllerName());
    assertNull(actualProductHandlerMapping.charEncoding);
    assertNull(actualProductHandlerMapping.catalogService);
    assertNull(actualProductHandlerMapping.getCorsConfigurationSource());
    assertNull(actualProductHandlerMapping.getPatternParser());
    assertTrue(actualProductHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualProductHandlerMapping.getOrder());
  }
}
