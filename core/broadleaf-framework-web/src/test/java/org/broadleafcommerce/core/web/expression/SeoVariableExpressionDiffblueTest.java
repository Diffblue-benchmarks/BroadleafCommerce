package org.broadleafcommerce.core.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.web.seo.SeoPropertyService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SeoVariableExpressionDiffblueTest {
  @Mock private SeoPropertyService seoPropertyService;

  @InjectMocks private SeoVariableExpression seoVariableExpression;

  /**
   * Test {@link SeoVariableExpression#getName()}.
   *
   * <p>Method under test: {@link SeoVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("seo", new SeoVariableExpression().getName());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(Category)} with {@code category}.
   *
   * <p>Method under test: {@link
   * SeoVariableExpression#getMetaProperties(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SeoVariableExpression.getMetaProperties(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetMetaPropertiesWithCategory() {
    // Arrange
    when(seoPropertyService.getSeoProperties(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualMetaProperties =
        seoVariableExpression.getMetaProperties(new CategoryImpl());

    // Assert
    verify(seoPropertyService)
        .getSeoProperties(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertTrue(actualMetaProperties.isEmpty());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(PageDTO)} with {@code page}.
   *
   * <p>Method under test: {@link SeoVariableExpression#getMetaProperties(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SeoVariableExpression.getMetaProperties(PageDTO)"})
  public void testGetMetaPropertiesWithPage() {
    // Arrange
    when(seoPropertyService.getSeoProperties(Mockito.<PageDTO>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualMetaProperties =
        seoVariableExpression.getMetaProperties(new PageDTO());

    // Assert
    verify(seoPropertyService).getSeoProperties(isA(PageDTO.class));
    assertTrue(actualMetaProperties.isEmpty());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoVariableExpression#getMetaProperties(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SeoVariableExpression.getMetaProperties(Product)"})
  public void testGetMetaPropertiesWithProduct() {
    // Arrange
    when(seoPropertyService.getSeoProperties(Mockito.<Product>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualMetaProperties =
        seoVariableExpression.getMetaProperties(new ProductBundleImpl());

    // Assert
    verify(seoPropertyService).getSeoProperties(isA(Product.class));
    assertTrue(actualMetaProperties.isEmpty());
  }
}
