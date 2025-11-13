package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchFacetRangeImplDiffblueTest {
  @Autowired private SearchFacetRangeImpl searchFacetRangeImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SearchFacetRangeImpl#setId(Long)}
   *   <li>{@link SearchFacetRangeImpl#setMaxValue(BigDecimal)}
   *   <li>{@link SearchFacetRangeImpl#setMinValue(BigDecimal)}
   *   <li>{@link SearchFacetRangeImpl#setSearchFacet(SearchFacet)}
   *   <li>{@link SearchFacetRangeImpl#getId()}
   *   <li>{@link SearchFacetRangeImpl#getMaxValue()}
   *   <li>{@link SearchFacetRangeImpl#getMinValue()}
   *   <li>{@link SearchFacetRangeImpl#getSearchFacet()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SearchFacetRangeImpl.getId()",
    "BigDecimal SearchFacetRangeImpl.getMaxValue()",
    "BigDecimal SearchFacetRangeImpl.getMinValue()",
    "SearchFacet SearchFacetRangeImpl.getSearchFacet()",
    "void SearchFacetRangeImpl.setId(Long)",
    "void SearchFacetRangeImpl.setMaxValue(BigDecimal)",
    "void SearchFacetRangeImpl.setMinValue(BigDecimal)",
    "void SearchFacetRangeImpl.setSearchFacet(SearchFacet)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();

    // Act
    searchFacetRangeImpl.setId(1L);
    BigDecimal maxValue = new BigDecimal("2.3");
    searchFacetRangeImpl.setMaxValue(maxValue);
    BigDecimal minValue = new BigDecimal("2.3");
    searchFacetRangeImpl.setMinValue(minValue);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    searchFacetRangeImpl.setSearchFacet(searchFacet);
    Long actualId = searchFacetRangeImpl.getId();
    BigDecimal actualMaxValue = searchFacetRangeImpl.getMaxValue();
    BigDecimal actualMinValue = searchFacetRangeImpl.getMinValue();
    SearchFacet actualSearchFacet = searchFacetRangeImpl.getSearchFacet();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualMaxValue);
    assertEquals(new BigDecimal("2.3"), actualMinValue);
    assertSame(maxValue, actualMaxValue);
    assertSame(minValue, actualMinValue);
    assertSame(searchFacet, actualSearchFacet);
  }

  /**
   * Test {@link SearchFacetRangeImpl#equals(Object)}, and {@link SearchFacetRangeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SearchFacetRangeImpl#equals(Object)}
   *   <li>{@link SearchFacetRangeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SearchFacetRangeImpl.equals(Object)",
    "int SearchFacetRangeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setId(1L);
    searchFacetRangeImpl.setMaxValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setSearchFacet(new SearchFacetImpl());

    SearchFacetRangeImpl searchFacetRangeImpl2 = new SearchFacetRangeImpl();
    searchFacetRangeImpl2.setId(1L);
    searchFacetRangeImpl2.setMaxValue(new BigDecimal("2.3"));
    searchFacetRangeImpl2.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl2.setSearchFacet(new SearchFacetImpl());

    // Act and Assert
    assertEquals(searchFacetRangeImpl, searchFacetRangeImpl2);
    assertEquals(searchFacetRangeImpl.hashCode(), searchFacetRangeImpl2.hashCode());
  }

  /**
   * Test {@link SearchFacetRangeImpl#equals(Object)}, and {@link SearchFacetRangeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SearchFacetRangeImpl#equals(Object)}
   *   <li>{@link SearchFacetRangeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SearchFacetRangeImpl.equals(Object)",
    "int SearchFacetRangeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setId(1L);
    searchFacetRangeImpl.setMaxValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setSearchFacet(new SearchFacetImpl());

    // Act and Assert
    assertEquals(searchFacetRangeImpl, searchFacetRangeImpl);
    int expectedHashCodeResult = searchFacetRangeImpl.hashCode();
    assertEquals(expectedHashCodeResult, searchFacetRangeImpl.hashCode());
  }

  /**
   * Test {@link SearchFacetRangeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetRangeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SearchFacetRangeImpl.equals(Object)",
    "int SearchFacetRangeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setId(1L);
    searchFacetRangeImpl.setMaxValue(null);
    searchFacetRangeImpl.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setSearchFacet(new SearchFacetImpl());

    SearchFacetRangeImpl searchFacetRangeImpl2 = new SearchFacetRangeImpl();
    searchFacetRangeImpl2.setId(1L);
    searchFacetRangeImpl2.setMaxValue(new BigDecimal("2.3"));
    searchFacetRangeImpl2.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl2.setSearchFacet(new SearchFacetImpl());

    // Act and Assert
    assertNotEquals(searchFacetRangeImpl, searchFacetRangeImpl2);
  }

  /**
   * Test {@link SearchFacetRangeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetRangeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SearchFacetRangeImpl.equals(Object)",
    "int SearchFacetRangeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setId(1L);
    searchFacetRangeImpl.setMaxValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setSearchFacet(new SearchFacetImpl());

    // Act and Assert
    assertNotEquals(searchFacetRangeImpl, null);
  }

  /**
   * Test {@link SearchFacetRangeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetRangeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SearchFacetRangeImpl.equals(Object)",
    "int SearchFacetRangeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setId(1L);
    searchFacetRangeImpl.setMaxValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setSearchFacet(new SearchFacetImpl());

    // Act and Assert
    assertNotEquals(searchFacetRangeImpl, "Different type to SearchFacetRangeImpl");
  }

  /**
   * Test new {@link SearchFacetRangeImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SearchFacetRangeImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchFacetRangeImpl.<init>()"})
  public void testNewSearchFacetRangeImpl() {
    // Arrange and Act
    SearchFacetRangeImpl actualSearchFacetRangeImpl = new SearchFacetRangeImpl();

    // Assert
    SearchFacet searchFacet = actualSearchFacetRangeImpl.getSearchFacet();
    assertTrue(searchFacet instanceof SearchFacetImpl);
    assertNull(searchFacet.getId());
    assertNull(actualSearchFacetRangeImpl.getId());
    assertNull(searchFacet.getLabel());
    assertNull(searchFacet.getName());
    assertNull(((SearchFacetImpl) searchFacet).getMainEntityName());
    assertNull(((SearchFacetImpl) searchFacet).label);
    assertNull(((SearchFacetImpl) searchFacet).name);
    assertNull(actualSearchFacetRangeImpl.getMaxValue());
    assertNull(actualSearchFacetRangeImpl.getMinValue());
    assertNull(searchFacet.getFieldType());
    assertEquals(1, searchFacet.getSearchDisplayPriority().intValue());
    assertFalse(searchFacet.getRequiresAllDependentFacets());
    assertFalse(searchFacet.getShowOnSearch());
    assertFalse(searchFacet.getUseFacetRanges());
    assertFalse(((SearchFacetImpl) searchFacet).requiresAllDependentFacets);
    assertTrue(searchFacet.getRequiredFacets().isEmpty());
    assertTrue(searchFacet.getSearchFacetRanges().isEmpty());
    assertTrue(searchFacet.getCanMultiselect());
  }
}
