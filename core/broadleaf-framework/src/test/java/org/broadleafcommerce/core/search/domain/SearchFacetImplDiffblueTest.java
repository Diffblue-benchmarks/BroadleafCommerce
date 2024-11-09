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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.mockito.Mockito;

public class SearchFacetImplDiffblueTest {
  /**
   * Test {@link SearchFacetImpl#getField()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getField()}
   */
  @Test
  public void testGetField_thenReturnNull() {
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
   * Test {@link SearchFacetImpl#getFacetFieldType()}.
   * <ul>
   *   <li>Given {@link IndexFieldType} {@link IndexFieldType#getFieldType()} return
   * {@link FieldType#BOOLEAN}.</li>
   *   <li>Then return {@code b}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getFacetFieldType()}
   */
  @Test
  public void testGetFacetFieldType_givenIndexFieldTypeGetFieldTypeReturnBoolean_thenReturnB() {
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
   * Test {@link SearchFacetImpl#getName()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getName()}
   */
  @Test
  public void testGetName_givenSearchFacetImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SearchFacetImpl()).getName());
  }

  /**
   * Test {@link SearchFacetImpl#getName()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor) FieldType is
   * {@link IndexFieldTypeImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getName()}
   */
  @Test
  public void testGetName_givenSearchFacetImplFieldTypeIsIndexFieldTypeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setFieldType(mock(IndexFieldTypeImpl.class));

    // Act and Assert
    assertNull(searchFacetImpl.getName());
  }

  /**
   * Test {@link SearchFacetImpl#getLabel()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor) FieldType is
   * {@link IndexFieldTypeImpl} (default constructor).</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  public void testGetLabel_givenSearchFacetImplFieldTypeIsIndexFieldTypeImpl_thenReturnFoo() {
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
   * Test {@link SearchFacetImpl#getLabel()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor) FieldType is
   * {@link IndexFieldType}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  public void testGetLabel_givenSearchFacetImplFieldTypeIsIndexFieldType_thenReturnFoo() {
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
   * Test {@link SearchFacetImpl#getLabel()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  public void testGetLabel_givenSearchFacetImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SearchFacetImpl()).getLabel());
  }

  /**
   * Test {@link SearchFacetImpl#getRequiresAllDependentFacets()}.
   * <p>
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets() {
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
   * Test {@link SearchFacetImpl#getRequiresAllDependentFacets()}.
   * <p>
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets2() {
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
   * Test {@link SearchFacetImpl#getRequiresAllDependentFacets()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets_givenSearchFacetImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SearchFacetImpl()).getRequiresAllDependentFacets());
  }

  /**
   * Test {@link SearchFacetImpl#getRequiresAllDependentFacets()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  public void testGetRequiresAllDependentFacets_thenReturnTrue() {
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
   * Test
   * {@link SearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
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
   * Test {@link SearchFacetImpl#equals(Object)}, and
   * {@link SearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SearchFacetImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor) FieldType is
   * {@link IndexFieldType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSearchFacetImplFieldTypeIsIndexFieldType() {
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
   * Test {@link SearchFacetImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor) FieldType is
   * {@link IndexFieldTypeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSearchFacetImplFieldTypeIsIndexFieldTypeImpl() {
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
   * Test {@link SearchFacetImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSearchFacetImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SearchFacetImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
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
