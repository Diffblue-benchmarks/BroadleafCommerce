/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
