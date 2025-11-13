package org.broadleafcommerce.core.web.seo;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.CategoryAttribute;
import org.broadleafcommerce.core.catalog.domain.CategoryAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductAttribute;
import org.broadleafcommerce.core.catalog.domain.ProductAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractSeoPropertyGeneratorDiffblueTest {
  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link CategoryAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSeoPropertyGenerator#getSimpleProperties(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetSimplePropertiesWithCategory_givenHashMapFooIsCategoryAttributeImpl() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", new CategoryAttributeImpl());

    CategoryImpl category = new CategoryImpl();
    category.setCategoryAttributesMap(categoryAttributes);

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(category).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSeoPropertyGenerator#getSimpleProperties(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetSimplePropertiesWithCategory_whenCategoryImpl_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new CategoryImpl()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(PageDTO)"})
  public void testGetSimplePropertiesWithPage_givenHashMapFooIsFoo() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> pageAttributes = new HashMap<>();
    pageAttributes.put("foo", "foo");

    PageDTO page = new PageDTO();
    page.setPageAttributes(pageAttributes);

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(page).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(PageDTO)"})
  public void testGetSimplePropertiesWithPage_whenPageDTO_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new PageDTO()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ProductAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(Product)"})
  public void testGetSimplePropertiesWithProduct_givenHashMapFooIsProductAttributeImpl() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    productAttributes.put("foo", new ProductAttributeImpl());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductAttributes(productAttributes);

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(product).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with {@code product}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AbstractSeoPropertyGenerator.getSimpleProperties(Product)"})
  public void testGetSimplePropertiesWithProduct_whenProductBundleImpl_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(
        basicSeoPropertyGeneratorImpl.getSimpleProperties(new ProductBundleImpl()).isEmpty());
  }
}
