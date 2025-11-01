/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import java.math.BigDecimal;
import org.junit.Test;

public class SearchFacetResultDTODiffblueTest {
  /**
   * Method under test: {@link SearchFacetResultDTO#getValueKey()}
   */
  @Test
  public void testGetValueKey() {
    // Arrange, Act and Assert
    assertEquals("range%5Bnull%3Anull%5D", (new SearchFacetResultDTO()).getValueKey());
  }

  /**
   * Method under test: {@link SearchFacetResultDTO#getValueKey()}
   */
  @Test
  public void testGetValueKey2() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("foo");

    // Act and Assert
    assertEquals("foo", searchFacetResultDTO.getValueKey());
  }

  /**
   * Method under test: {@link SearchFacetResultDTO#getUnencodedValueKey()}
   */
  @Test
  public void testGetUnencodedValueKey() {
    // Arrange, Act and Assert
    assertEquals("range[null:null]", (new SearchFacetResultDTO()).getUnencodedValueKey());
  }

  /**
   * Method under test: {@link SearchFacetResultDTO#getUnencodedValueKey()}
   */
  @Test
  public void testGetUnencodedValueKey2() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("foo");

    // Act and Assert
    assertEquals("foo", searchFacetResultDTO.getUnencodedValueKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchFacetResultDTO}
   *   <li>{@link SearchFacetResultDTO#setActive(boolean)}
   *   <li>{@link SearchFacetResultDTO#setFacet(SearchFacet)}
   *   <li>{@link SearchFacetResultDTO#setMaxValue(BigDecimal)}
   *   <li>{@link SearchFacetResultDTO#setMinValue(BigDecimal)}
   *   <li>{@link SearchFacetResultDTO#setQuantity(Integer)}
   *   <li>{@link SearchFacetResultDTO#setValue(String)}
   *   <li>{@link SearchFacetResultDTO#getFacet()}
   *   <li>{@link SearchFacetResultDTO#getMaxValue()}
   *   <li>{@link SearchFacetResultDTO#getMinValue()}
   *   <li>{@link SearchFacetResultDTO#getQuantity()}
   *   <li>{@link SearchFacetResultDTO#getValue()}
   *   <li>{@link SearchFacetResultDTO#isActive()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchFacetResultDTO actualSearchFacetResultDTO = new SearchFacetResultDTO();
    actualSearchFacetResultDTO.setActive(true);
    SearchFacetImpl facet = new SearchFacetImpl();
    actualSearchFacetResultDTO.setFacet(facet);
    BigDecimal maxValue = new BigDecimal("2.3");
    actualSearchFacetResultDTO.setMaxValue(maxValue);
    BigDecimal minValue = new BigDecimal("2.3");
    actualSearchFacetResultDTO.setMinValue(minValue);
    actualSearchFacetResultDTO.setQuantity(1);
    actualSearchFacetResultDTO.setValue("42");
    SearchFacet actualFacet = actualSearchFacetResultDTO.getFacet();
    BigDecimal actualMaxValue = actualSearchFacetResultDTO.getMaxValue();
    BigDecimal actualMinValue = actualSearchFacetResultDTO.getMinValue();
    Integer actualQuantity = actualSearchFacetResultDTO.getQuantity();
    String actualValue = actualSearchFacetResultDTO.getValue();
    boolean actualIsActiveResult = actualSearchFacetResultDTO.isActive();

    // Assert that nothing has changed
    assertEquals("42", actualValue);
    assertEquals(1, actualQuantity.intValue());
    assertTrue(actualIsActiveResult);
    assertEquals(new BigDecimal("2.3"), actualMaxValue);
    assertEquals(new BigDecimal("2.3"), actualMinValue);
    assertSame(maxValue, actualMaxValue);
    assertSame(minValue, actualMinValue);
    assertSame(facet, actualFacet);
  }
}
