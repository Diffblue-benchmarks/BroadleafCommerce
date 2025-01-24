package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SearchFacetDTODiffblueTest {
  /**
   * Test {@link SearchFacetDTO#getAbbreviation()}.
   * <ul>
   *   <li>Given {@link SearchFacetDTO} (default constructor) Active is
   * {@code true}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetDTO#getAbbreviation()}
   */
  @Test
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
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertTrue(actualFacetValues.isEmpty());
    assertTrue(actualIsActiveResult);
    assertTrue(actualIsShowQuantityResult);
    assertSame(facetValues, actualFacetValues);
    assertSame(facet, actualFacet);
  }
}
