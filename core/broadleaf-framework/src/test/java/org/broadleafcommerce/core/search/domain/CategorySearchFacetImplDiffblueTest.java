package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategorySearchFacetImplDiffblueTest {
  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}, and {@link
   * CategorySearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategorySearchFacetImpl#equals(Object)}
   *   <li>{@link CategorySearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategorySearchFacetImpl categorySearchFacetImpl2 = new CategorySearchFacetImpl();
    categorySearchFacetImpl2.setCategory(new CategoryImpl());
    categorySearchFacetImpl2.setId(1L);
    categorySearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categorySearchFacetImpl, categorySearchFacetImpl2);
    assertEquals(categorySearchFacetImpl.hashCode(), categorySearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}, and {@link
   * CategorySearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategorySearchFacetImpl#equals(Object)}
   *   <li>{@link CategorySearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categorySearchFacetImpl, categorySearchFacetImpl);
    int expectedHashCodeResult = categorySearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categorySearchFacetImpl.hashCode());
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(null);
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategorySearchFacetImpl categorySearchFacetImpl2 = new CategorySearchFacetImpl();
    categorySearchFacetImpl2.setCategory(new CategoryImpl());
    categorySearchFacetImpl2.setId(1L);
    categorySearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categorySearchFacetImpl, categorySearchFacetImpl2);
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categorySearchFacetImpl, null);
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categorySearchFacetImpl, "Different type to CategorySearchFacetImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CategorySearchFacetImpl}
   *   <li>{@link
   *       CategorySearchFacetImpl#setCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   *   <li>{@link CategorySearchFacetImpl#setId(Long)}
   *   <li>{@link CategorySearchFacetImpl#setSearchFacet(SearchFacet)}
   *   <li>{@link CategorySearchFacetImpl#setSequence(BigDecimal)}
   *   <li>{@link CategorySearchFacetImpl#getCategory()}
   *   <li>{@link CategorySearchFacetImpl#getId()}
   *   <li>{@link CategorySearchFacetImpl#getSearchFacet()}
   *   <li>{@link CategorySearchFacetImpl#getSequence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySearchFacetImpl.<init>()",
    "org.broadleafcommerce.core.catalog.domain.Category CategorySearchFacetImpl.getCategory()",
    "Long CategorySearchFacetImpl.getId()",
    "SearchFacet CategorySearchFacetImpl.getSearchFacet()",
    "BigDecimal CategorySearchFacetImpl.getSequence()",
    "void CategorySearchFacetImpl.setCategory(org.broadleafcommerce.core.catalog.domain.Category)",
    "void CategorySearchFacetImpl.setId(Long)",
    "void CategorySearchFacetImpl.setSearchFacet(SearchFacet)",
    "void CategorySearchFacetImpl.setSequence(BigDecimal)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CategorySearchFacetImpl actualCategorySearchFacetImpl = new CategorySearchFacetImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategorySearchFacetImpl.setCategory(category);
    actualCategorySearchFacetImpl.setId(1L);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    actualCategorySearchFacetImpl.setSearchFacet(searchFacet);
    BigDecimal sequence = new BigDecimal("2.3");
    actualCategorySearchFacetImpl.setSequence(sequence);
    org.broadleafcommerce.core.catalog.domain.Category actualCategory =
        actualCategorySearchFacetImpl.getCategory();
    Long actualId = actualCategorySearchFacetImpl.getId();
    SearchFacet actualSearchFacet = actualCategorySearchFacetImpl.getSearchFacet();
    BigDecimal actualSequence = actualCategorySearchFacetImpl.getSequence();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(searchFacet, actualSearchFacet);
  }
}
