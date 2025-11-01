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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.mockito.Mockito;

public class SearchFacetImplDiffblueTest {
  /**
   * Method under test: {@link SearchFacetImpl#getField()}
   */
  @Test
  public void testGetField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl fieldType = mock(IndexFieldTypeImpl.class);
    when(fieldType.getIndexField()).thenReturn(new IndexFieldImpl());

    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(fieldType);
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);

    // Act
    Field actualField = searchFacetImpl.getField();

    // Assert
    verify(fieldType).getIndexField();
    assertNull(actualField);
  }

  /**
   * Method under test: {@link SearchFacetImpl#getFacetFieldType()}
   */
  @Test
  public void testGetFacetFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldType fieldType = mock(IndexFieldType.class);
    when(fieldType.getFieldType()).thenReturn(FieldType.BOOLEAN);

    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(fieldType);
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);

    // Act
    String actualFacetFieldType = searchFacetImpl.getFacetFieldType();

    // Assert
    verify(fieldType).getFieldType();
    assertEquals("b", actualFacetFieldType);
  }

  /**
   * Method under test: {@link SearchFacetImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SearchFacetImpl()).getName());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getName()}
   */
  @Test
  public void testGetName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setFieldType(mock(IndexFieldTypeImpl.class));

    // Act and Assert
    assertNull(searchFacetImpl.getName());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  public void testGetLabel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SearchFacetImpl()).getLabel());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  public void testGetLabel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setLabel("foo");

    // Act and Assert
    assertEquals("foo", searchFacetImpl.getLabel());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  public void testGetLabel3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(mock(IndexFieldType.class));
    searchFacetImpl.setId(1L);
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setLabel("foo");

    // Act and Assert
    assertEquals("foo", searchFacetImpl.getLabel());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SearchFacetImpl()).getRequiresAllDependentFacets());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setRequiresAllDependentFacets(null);

    // Act and Assert
    assertFalse(searchFacetImpl.getRequiresAllDependentFacets());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setRequiresAllDependentFacets(true);

    // Act and Assert
    assertTrue(searchFacetImpl.getRequiresAllDependentFacets());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(mock(IndexFieldTypeImpl.class));
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setRequiresAllDependentFacets(null);

    // Act and Assert
    assertFalse(searchFacetImpl.getRequiresAllDependentFacets());
  }

  /**
   * Method under test:
   * {@link SearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SearchFacet> actualCreateOrRetrieveCopyInstanceResult = searchFacetImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SearchFacetImpl#equals(Object)}
   *   <li>{@link SearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);

    // Act and Assert
    assertEquals(searchFacetImpl, searchFacetImpl);
    int expectedHashCodeResult = searchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, searchFacetImpl.hashCode());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SearchFacetImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setLabel("foo");

    // Act and Assert
    assertEquals("foo", searchFacetImpl.getMainEntityName());
  }

  /**
   * Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(mock(IndexFieldType.class));
    searchFacetImpl.setId(1L);
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setLabel("foo");

    // Act and Assert
    assertEquals("foo", searchFacetImpl.getMainEntityName());
  }

  /**
   * Method under test: {@link SearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);

    SearchFacetImpl searchFacetImpl2 = new SearchFacetImpl();
    searchFacetImpl2.setCanMultiselect(true);
    searchFacetImpl2.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl2.setId(1L);
    searchFacetImpl2.setLabel("Label");
    searchFacetImpl2.setName("Name");
    searchFacetImpl2.setRequiredFacets(new ArrayList<>());
    searchFacetImpl2.setRequiresAllDependentFacets(true);
    searchFacetImpl2.setSearchDisplayPriority(1);
    searchFacetImpl2.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl2.setShowOnSearch(true);
    searchFacetImpl2.setUseFacetRanges(true);

    // Act and Assert
    assertNotEquals(searchFacetImpl, searchFacetImpl2);
  }

  /**
   * Method under test: {@link SearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(mock(IndexFieldType.class));
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);

    SearchFacetImpl searchFacetImpl2 = new SearchFacetImpl();
    searchFacetImpl2.setCanMultiselect(true);
    searchFacetImpl2.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl2.setId(1L);
    searchFacetImpl2.setLabel("Label");
    searchFacetImpl2.setName("Name");
    searchFacetImpl2.setRequiredFacets(new ArrayList<>());
    searchFacetImpl2.setRequiresAllDependentFacets(true);
    searchFacetImpl2.setSearchDisplayPriority(1);
    searchFacetImpl2.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl2.setShowOnSearch(true);
    searchFacetImpl2.setUseFacetRanges(true);

    // Act and Assert
    assertNotEquals(searchFacetImpl, searchFacetImpl2);
  }

  /**
   * Method under test: {@link SearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);

    // Act and Assert
    assertNotEquals(searchFacetImpl, null);
  }

  /**
   * Method under test: {@link SearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setSearchFacetRanges(new ArrayList<>());
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);

    // Act and Assert
    assertNotEquals(searchFacetImpl, "Different type to SearchFacetImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchFacetImpl}
   *   <li>{@link SearchFacetImpl#setCanMultiselect(Boolean)}
   *   <li>{@link SearchFacetImpl#setFieldType(IndexFieldType)}
   *   <li>{@link SearchFacetImpl#setId(Long)}
   *   <li>{@link SearchFacetImpl#setLabel(String)}
   *   <li>{@link SearchFacetImpl#setName(String)}
   *   <li>{@link SearchFacetImpl#setRequiredFacets(List)}
   *   <li>{@link SearchFacetImpl#setRequiresAllDependentFacets(Boolean)}
   *   <li>{@link SearchFacetImpl#setSearchDisplayPriority(Integer)}
   *   <li>{@link SearchFacetImpl#setSearchFacetRanges(List)}
   *   <li>{@link SearchFacetImpl#setShowOnSearch(Boolean)}
   *   <li>{@link SearchFacetImpl#setUseFacetRanges(Boolean)}
   *   <li>{@link SearchFacetImpl#getCanMultiselect()}
   *   <li>{@link SearchFacetImpl#getFieldType()}
   *   <li>{@link SearchFacetImpl#getId()}
   *   <li>{@link SearchFacetImpl#getRequiredFacets()}
   *   <li>{@link SearchFacetImpl#getSearchDisplayPriority()}
   *   <li>{@link SearchFacetImpl#getSearchFacetRanges()}
   *   <li>{@link SearchFacetImpl#getShowOnSearch()}
   *   <li>{@link SearchFacetImpl#getUseFacetRanges()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchFacetImpl actualSearchFacetImpl = new SearchFacetImpl();
    actualSearchFacetImpl.setCanMultiselect(true);
    IndexFieldTypeImpl fieldType = new IndexFieldTypeImpl();
    actualSearchFacetImpl.setFieldType(fieldType);
    actualSearchFacetImpl.setId(1L);
    actualSearchFacetImpl.setLabel("Label");
    actualSearchFacetImpl.setName("Name");
    ArrayList<RequiredFacet> requiredFacets = new ArrayList<>();
    actualSearchFacetImpl.setRequiredFacets(requiredFacets);
    actualSearchFacetImpl.setRequiresAllDependentFacets(true);
    actualSearchFacetImpl.setSearchDisplayPriority(1);
    ArrayList<SearchFacetRange> searchFacetRanges = new ArrayList<>();
    actualSearchFacetImpl.setSearchFacetRanges(searchFacetRanges);
    actualSearchFacetImpl.setShowOnSearch(true);
    actualSearchFacetImpl.setUseFacetRanges(true);
    Boolean actualCanMultiselect = actualSearchFacetImpl.getCanMultiselect();
    IndexFieldType actualFieldType = actualSearchFacetImpl.getFieldType();
    Long actualId = actualSearchFacetImpl.getId();
    List<RequiredFacet> actualRequiredFacets = actualSearchFacetImpl.getRequiredFacets();
    Integer actualSearchDisplayPriority = actualSearchFacetImpl.getSearchDisplayPriority();
    List<SearchFacetRange> actualSearchFacetRanges = actualSearchFacetImpl.getSearchFacetRanges();
    Boolean actualShowOnSearch = actualSearchFacetImpl.getShowOnSearch();
    Boolean actualUseFacetRanges = actualSearchFacetImpl.getUseFacetRanges();

    // Assert that nothing has changed
    assertEquals(1, actualSearchDisplayPriority.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualRequiredFacets.isEmpty());
    assertTrue(actualSearchFacetRanges.isEmpty());
    assertTrue(actualCanMultiselect);
    assertTrue(actualShowOnSearch);
    assertTrue(actualUseFacetRanges);
    assertSame(requiredFacets, actualRequiredFacets);
    assertSame(searchFacetRanges, actualSearchFacetRanges);
    assertSame(fieldType, actualFieldType);
  }
}
