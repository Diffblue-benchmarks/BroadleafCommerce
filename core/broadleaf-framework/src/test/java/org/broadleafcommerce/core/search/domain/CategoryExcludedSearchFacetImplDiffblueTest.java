package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryExcludedSearchFacetImplDiffblueTest {
  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(null);
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(null);
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(null);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(null);
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(null);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(null);

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl);
    int expectedHashCodeResult = categoryExcludedSearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryExcludedSearchFacetImpl.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(null);
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(mock(CategoryImpl.class));
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    searchFacet.setId(1L);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(null);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(null);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(BigDecimal.valueOf(1L));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, null);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        categoryExcludedSearchFacetImpl, "Different type to CategoryExcludedSearchFacetImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CategoryExcludedSearchFacetImpl}
   *   <li>{@link
   *       CategoryExcludedSearchFacetImpl#setCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#setId(Long)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#setSearchFacet(SearchFacet)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#setSequence(BigDecimal)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getCategory()}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getId()}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getSearchFacet()}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getSequence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryExcludedSearchFacetImpl.<init>()",
    "org.broadleafcommerce.core.catalog.domain.Category CategoryExcludedSearchFacetImpl.getCategory()",
    "Long CategoryExcludedSearchFacetImpl.getId()",
    "SearchFacet CategoryExcludedSearchFacetImpl.getSearchFacet()",
    "BigDecimal CategoryExcludedSearchFacetImpl.getSequence()",
    "void CategoryExcludedSearchFacetImpl.setCategory(org.broadleafcommerce.core.catalog.domain.Category)",
    "void CategoryExcludedSearchFacetImpl.setId(Long)",
    "void CategoryExcludedSearchFacetImpl.setSearchFacet(SearchFacet)",
    "void CategoryExcludedSearchFacetImpl.setSequence(BigDecimal)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryExcludedSearchFacetImpl actualCategoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategoryExcludedSearchFacetImpl.setCategory(category);
    actualCategoryExcludedSearchFacetImpl.setId(1L);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    actualCategoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    BigDecimal sequence = new BigDecimal("2.3");
    actualCategoryExcludedSearchFacetImpl.setSequence(sequence);
    org.broadleafcommerce.core.catalog.domain.Category actualCategory =
        actualCategoryExcludedSearchFacetImpl.getCategory();
    Long actualId = actualCategoryExcludedSearchFacetImpl.getId();
    SearchFacet actualSearchFacet = actualCategoryExcludedSearchFacetImpl.getSearchFacet();
    BigDecimal actualSequence = actualCategoryExcludedSearchFacetImpl.getSequence();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(searchFacet, actualSearchFacet);
  }
}
