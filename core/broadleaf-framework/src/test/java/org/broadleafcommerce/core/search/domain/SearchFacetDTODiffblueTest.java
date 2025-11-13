package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SearchFacetDTODiffblueTest {
  /**
   * Test {@link SearchFacetDTO#getAbbreviation()}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetDTO} (default constructor) Active is {@code true}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetDTO#getAbbreviation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetDTO.getAbbreviation()"})
  public void testGetAbbreviation_givenSearchFacetDTOActiveIsTrue_thenReturnFoo() {
    // Arrange
    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);
    searchFacetDTO.setAbbreviation("foo");

    // Act and Assert
    assertEquals("foo", searchFacetDTO.getAbbreviation());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchFacetDTO}
   *   <li>{@link SearchFacetDTO#setAbbreviation(String)}
   *   <li>{@link SearchFacetDTO#setActive(boolean)}
   *   <li>{@link SearchFacetDTO#setFacet(SearchFacet)}
   *   <li>{@link SearchFacetDTO#setFacetValues(List)}
   *   <li>{@link SearchFacetDTO#setShowQuantity(boolean)}
   *   <li>{@link SearchFacetDTO#getFacet()}
   *   <li>{@link SearchFacetDTO#getFacetValues()}
   *   <li>{@link SearchFacetDTO#isActive()}
   *   <li>{@link SearchFacetDTO#isShowQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchFacetDTO.<init>()",
    "SearchFacet SearchFacetDTO.getFacet()",
    "List SearchFacetDTO.getFacetValues()",
    "boolean SearchFacetDTO.isActive()",
    "boolean SearchFacetDTO.isShowQuantity()",
    "void SearchFacetDTO.setAbbreviation(String)",
    "void SearchFacetDTO.setActive(boolean)",
    "void SearchFacetDTO.setFacet(SearchFacet)",
    "void SearchFacetDTO.setFacetValues(List)",
    "void SearchFacetDTO.setShowQuantity(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchFacetDTO actualSearchFacetDTO = new SearchFacetDTO();
    actualSearchFacetDTO.setAbbreviation("Abbreviation");
    actualSearchFacetDTO.setActive(true);
    SearchFacetImpl facet = new SearchFacetImpl();
    actualSearchFacetDTO.setFacet(facet);
    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    actualSearchFacetDTO.setFacetValues(facetValues);
    actualSearchFacetDTO.setShowQuantity(true);
    SearchFacet actualFacet = actualSearchFacetDTO.getFacet();
    List<SearchFacetResultDTO> actualFacetValues = actualSearchFacetDTO.getFacetValues();
    boolean actualIsActiveResult = actualSearchFacetDTO.isActive();
    boolean actualIsShowQuantityResult = actualSearchFacetDTO.isShowQuantity();

    // Assert
    assertTrue(actualFacetValues.isEmpty());
    assertTrue(actualIsActiveResult);
    assertTrue(actualIsShowQuantityResult);
    assertSame(facetValues, actualFacetValues);
    assertSame(facet, actualFacet);
  }
}
