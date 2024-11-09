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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.mockito.Mockito;

public class SearchFacetRangeImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualMaxValue);
    assertEquals(new BigDecimal("2.3"), actualMinValue);
    assertSame(maxValue, actualMaxValue);
    assertSame(minValue, actualMinValue);
    assertSame(searchFacet, actualSearchFacet);
  }

  /**
   * Test {@link SearchFacetRangeImpl#equals(Object)}, and
   * {@link SearchFacetRangeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SearchFacetRangeImpl#equals(Object)}
   *   <li>{@link SearchFacetRangeImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = searchFacetRangeImpl.hashCode();
    assertEquals(expectedHashCodeResult, searchFacetRangeImpl2.hashCode());
  }

  /**
   * Test {@link SearchFacetRangeImpl#equals(Object)}, and
   * {@link SearchFacetRangeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SearchFacetRangeImpl#equals(Object)}
   *   <li>{@link SearchFacetRangeImpl#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetRangeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setId(1L);
    searchFacetRangeImpl.setMaxValue(new BigDecimal("4.5"));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetRangeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setId(1L);
    searchFacetRangeImpl.setMaxValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setMinValue(new BigDecimal("2.3"));
    searchFacetRangeImpl.setSearchFacet(mock(SearchFacetImpl.class));

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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetRangeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetRangeImpl#equals(Object)}
   */
  @Test
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
   * Test
   * {@link SearchFacetRangeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SearchFacetRangeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SearchFacetRange> actualCreateOrRetrieveCopyInstanceResult = searchFacetRangeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link SearchFacetRangeImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SearchFacetRangeImpl}
   */
  @Test
  public void testNewSearchFacetRangeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
