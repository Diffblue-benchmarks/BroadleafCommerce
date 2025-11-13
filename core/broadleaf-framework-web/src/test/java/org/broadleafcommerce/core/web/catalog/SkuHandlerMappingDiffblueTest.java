package org.broadleafcommerce.core.web.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;

@RunWith(MockitoJUnitRunner.class)
public class SkuHandlerMappingDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private SkuHandlerMapping skuHandlerMapping;

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal() throws Exception {
    // Arrange
    SkuHandlerMapping skuHandlerMapping = new SkuHandlerMapping();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setRequestURI(null);
    request.setContextPath("Request");

    // Act
    Object actualHandlerInternal = skuHandlerMapping.getHandlerInternal(request);

    // Assert
    assertNull(actualHandlerInternal);
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal2() throws Exception {
    // Arrange
    when(catalogService.findSkuByURI(Mockito.<String>any())).thenReturn(new SkuImpl());

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setRequestURI(";");
    request.setContextPath(null);

    // Act
    Object actualHandlerInternal = skuHandlerMapping.getHandlerInternal(request);

    // Assert
    verify(catalogService).findSkuByURI("");
    assertEquals("blSkuController", actualHandlerInternal);
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuByURI(String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal_givenCatalogServiceFindSkuByURIReturnNull() throws Exception {
    // Arrange
    when(catalogService.findSkuByURI(Mockito.<String>any())).thenReturn(null);

    // Act
    Object actualHandlerInternal =
        skuHandlerMapping.getHandlerInternal(new MockHttpServletRequest());

    // Assert
    verify(catalogService).findSkuByURI("");
    assertNull(actualHandlerInternal);
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link SkuHandlerMapping} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal_givenSkuHandlerMapping_whenNull_thenReturnNull()
      throws Exception {
    // Arrange, Act and Assert
    assertNull(new SkuHandlerMapping().getHandlerInternal(null));
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code blSkuController}.
   * </ul>
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal_thenReturnBlSkuController() throws Exception {
    // Arrange
    when(catalogService.findSkuByURI(Mockito.<String>any())).thenReturn(new SkuImpl());

    // Act
    Object actualHandlerInternal =
        skuHandlerMapping.getHandlerInternal(new MockHttpServletRequest());

    // Assert
    verify(catalogService).findSkuByURI("");
    assertEquals("blSkuController", actualHandlerInternal);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link SkuHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SkuHandlerMapping.getDefaultTemplateName()",
    "void SkuHandlerMapping.setDefaultTemplateName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SkuHandlerMapping skuHandlerMapping = new SkuHandlerMapping();

    // Act
    skuHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert
    assertEquals("Default Template Name", skuHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link SkuHandlerMapping} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SkuHandlerMapping}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuHandlerMapping.<init>()"})
  public void testNewSkuHandlerMapping() {
    // Arrange and Act
    SkuHandlerMapping actualSkuHandlerMapping = new SkuHandlerMapping();

    // Assert
    assertTrue(actualSkuHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualSkuHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/sku", actualSkuHandlerMapping.getDefaultTemplateName());
    assertNull(actualSkuHandlerMapping.getDefaultHandler());
    assertNull(actualSkuHandlerMapping.getControllerName());
    assertNull(actualSkuHandlerMapping.getCorsConfigurationSource());
    assertNull(actualSkuHandlerMapping.getPatternParser());
    assertTrue(actualSkuHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualSkuHandlerMapping.getOrder());
  }
}
