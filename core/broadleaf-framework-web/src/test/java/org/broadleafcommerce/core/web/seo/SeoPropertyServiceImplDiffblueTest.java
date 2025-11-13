package org.broadleafcommerce.core.web.seo;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SeoPropertyServiceImplDiffblueTest {
  @Mock private List<SeoPropertyGenerator> list;

  @InjectMocks private SeoPropertyServiceImpl seoPropertyServiceImpl;

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then calls {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoPropertyServiceImpl#getSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SeoPropertyServiceImpl.getSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetSeoPropertiesWithCategory_thenCallsGatherSeoProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        mock(BasicSeoPropertyGeneratorImpl.class);
    when(basicSeoPropertyGeneratorImpl.gatherSeoProperties(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(new HashMap<>());

    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    seoPropertyGeneratorList.add(basicSeoPropertyGeneratorImpl);
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties =
        seoPropertyServiceImpl.getSeoProperties(new CategoryImpl());

    // Assert
    verify(list).iterator();
    verify(basicSeoPropertyGeneratorImpl)
        .gatherSeoProperties(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoPropertyServiceImpl#getSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SeoPropertyServiceImpl.getSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetSeoPropertiesWithCategory_thenReturnEmpty() {
    // Arrange
    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties =
        seoPropertyServiceImpl.getSeoProperties(new CategoryImpl());

    // Assert
    verify(list).iterator();
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Then calls {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)}.
   * </ul>
   *
   * <p>Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(PageDTO)"})
  public void testGetSeoPropertiesWithPage_thenCallsGatherSeoProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        mock(BasicSeoPropertyGeneratorImpl.class);
    when(basicSeoPropertyGeneratorImpl.gatherSeoProperties(Mockito.<PageDTO>any()))
        .thenReturn(new HashMap<>());

    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    seoPropertyGeneratorList.add(basicSeoPropertyGeneratorImpl);
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties =
        seoPropertyServiceImpl.getSeoProperties(new PageDTO());

    // Assert
    verify(list).iterator();
    verify(basicSeoPropertyGeneratorImpl).gatherSeoProperties(isA(PageDTO.class));
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(PageDTO)"})
  public void testGetSeoPropertiesWithPage_thenReturnEmpty() {
    // Arrange
    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties =
        seoPropertyServiceImpl.getSeoProperties(new PageDTO());

    // Assert
    verify(list).iterator();
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Then calls {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)}.
   * </ul>
   *
   * <p>Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(Product)"})
  public void testGetSeoPropertiesWithProduct_thenCallsGatherSeoProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        mock(BasicSeoPropertyGeneratorImpl.class);
    when(basicSeoPropertyGeneratorImpl.gatherSeoProperties(Mockito.<Product>any()))
        .thenReturn(new HashMap<>());

    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    seoPropertyGeneratorList.add(basicSeoPropertyGeneratorImpl);
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties =
        seoPropertyServiceImpl.getSeoProperties(new ProductBundleImpl());

    // Assert
    verify(list).iterator();
    verify(basicSeoPropertyGeneratorImpl).gatherSeoProperties(isA(Product.class));
    assertTrue(actualSeoProperties.isEmpty());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SeoPropertyServiceImpl.getSeoProperties(Product)"})
  public void testGetSeoPropertiesWithProduct_thenReturnEmpty() {
    // Arrange
    ArrayList<SeoPropertyGenerator> seoPropertyGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(seoPropertyGeneratorList.iterator());

    // Act
    Map<String, String> actualSeoProperties =
        seoPropertyServiceImpl.getSeoProperties(new ProductBundleImpl());

    // Assert
    verify(list).iterator();
    assertTrue(actualSeoProperties.isEmpty());
  }
}
