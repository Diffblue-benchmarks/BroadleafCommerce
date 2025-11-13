package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CatalogStructureDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CatalogStructure}
   *   <li>{@link CatalogStructure#setDisplayOrdersByCategoryProduct(Map)}
   *   <li>{@link CatalogStructure#setParentCategoriesByCategory(Map)}
   *   <li>{@link CatalogStructure#setParentCategoriesByProduct(Map)}
   *   <li>{@link CatalogStructure#getDisplayOrdersByCategoryProduct()}
   *   <li>{@link CatalogStructure#getParentCategoriesByCategory()}
   *   <li>{@link CatalogStructure#getParentCategoriesByProduct()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogStructure.<init>()",
    "Map CatalogStructure.getDisplayOrdersByCategoryProduct()",
    "Map CatalogStructure.getParentCategoriesByCategory()",
    "Map CatalogStructure.getParentCategoriesByProduct()",
    "void CatalogStructure.setDisplayOrdersByCategoryProduct(Map)",
    "void CatalogStructure.setParentCategoriesByCategory(Map)",
    "void CatalogStructure.setParentCategoriesByProduct(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CatalogStructure actualCatalogStructure = new CatalogStructure();
    HashMap<String, BigDecimal> displayOrdersByCategoryProduct = new HashMap<>();
    actualCatalogStructure.setDisplayOrdersByCategoryProduct(displayOrdersByCategoryProduct);
    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    actualCatalogStructure.setParentCategoriesByCategory(parentCategoriesByCategory);
    HashMap<Long, Set<Long>> parentCategoriesByProduct = new HashMap<>();
    actualCatalogStructure.setParentCategoriesByProduct(parentCategoriesByProduct);
    Map<String, BigDecimal> actualDisplayOrdersByCategoryProduct =
        actualCatalogStructure.getDisplayOrdersByCategoryProduct();
    Map<Long, Set<Long>> actualParentCategoriesByCategory =
        actualCatalogStructure.getParentCategoriesByCategory();
    Map<Long, Set<Long>> actualParentCategoriesByProduct =
        actualCatalogStructure.getParentCategoriesByProduct();

    // Assert
    assertTrue(actualDisplayOrdersByCategoryProduct.isEmpty());
    assertTrue(actualParentCategoriesByCategory.isEmpty());
    assertTrue(actualParentCategoriesByProduct.isEmpty());
    assertTrue(actualCatalogStructure.productsByCategory.isEmpty());
    assertSame(displayOrdersByCategoryProduct, actualDisplayOrdersByCategoryProduct);
    assertSame(parentCategoriesByCategory, actualParentCategoriesByCategory);
    assertSame(parentCategoriesByProduct, actualParentCategoriesByProduct);
  }
}
