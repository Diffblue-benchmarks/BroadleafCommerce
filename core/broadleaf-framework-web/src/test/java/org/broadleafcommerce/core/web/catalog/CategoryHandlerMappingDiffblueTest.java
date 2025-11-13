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
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
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
public class CategoryHandlerMappingDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private CategoryHandlerMapping categoryHandlerMapping;

  /**
   * Test {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findCategoryById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryHandlerMapping.findCategoryUsingIdParam(HttpServletRequest)"
  })
  public void testFindCategoryUsingIdParam_givenCatalogServiceFindCategoryByIdReturnNull()
      throws ServletRequestBindingException {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(null);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("categoryId", "42");

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryUsingIdParamResult =
        categoryHandlerMapping.findCategoryUsingIdParam(request);

    // Assert
    verify(catalogService).findCategoryById(42L);
    assertNull(actualFindCategoryUsingIdParamResult);
  }

  /**
   * Test {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link CategoryHandlerMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryHandlerMapping.findCategoryUsingIdParam(HttpServletRequest)"
  })
  public void testFindCategoryUsingIdParam_givenCategoryHandlerMapping()
      throws ServletRequestBindingException {
    // Arrange
    CategoryHandlerMapping categoryHandlerMapping = new CategoryHandlerMapping();

    // Act and Assert
    assertNull(categoryHandlerMapping.findCategoryUsingIdParam(new MockHttpServletRequest()));
  }

  /**
   * Test {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryHandlerMapping.findCategoryUsingIdParam(HttpServletRequest)"
  })
  public void testFindCategoryUsingIdParam_thenReturnCategoryImpl()
      throws ServletRequestBindingException {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("categoryId", "42");

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryUsingIdParamResult =
        categoryHandlerMapping.findCategoryUsingIdParam(request);

    // Assert
    verify(catalogService).findCategoryById(42L);
    assertSame(categoryImpl, actualFindCategoryUsingIdParamResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link CategoryHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CategoryHandlerMapping.getDefaultTemplateName()",
    "void CategoryHandlerMapping.setDefaultTemplateName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CategoryHandlerMapping categoryHandlerMapping = new CategoryHandlerMapping();

    // Act
    categoryHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert
    assertEquals("Default Template Name", categoryHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link CategoryHandlerMapping} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CategoryHandlerMapping}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryHandlerMapping.<init>()"})
  public void testNewCategoryHandlerMapping() {
    // Arrange and Act
    CategoryHandlerMapping actualCategoryHandlerMapping = new CategoryHandlerMapping();

    // Assert
    assertTrue(actualCategoryHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualCategoryHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/category", actualCategoryHandlerMapping.getDefaultTemplateName());
    assertNull(actualCategoryHandlerMapping.getDefaultHandler());
    assertNull(actualCategoryHandlerMapping.getControllerName());
    assertNull(actualCategoryHandlerMapping.charEncoding);
    assertNull(actualCategoryHandlerMapping.getCorsConfigurationSource());
    assertNull(actualCategoryHandlerMapping.getPatternParser());
    assertTrue(actualCategoryHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualCategoryHandlerMapping.getOrder());
  }
}
