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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchFacetImplDiffblueTest {
  @Autowired private SearchFacetImpl searchFacetImpl;

  /**
   * Test {@link SearchFacetImpl#getField()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getField()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Field SearchFacetImpl.getField()"})
  public void testGetField_thenReturnNull() {
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
   *
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor) FieldType is {@link
   *       FieldType#BOOLEAN}.
   *   <li>Then return {@code b}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getFacetFieldType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetImpl.getFacetFieldType()"})
  public void testGetFacetFieldType_givenIndexFieldTypeImplFieldTypeIsBoolean_thenReturnB() {
    // Arrange
    IndexFieldTypeImpl fieldType = new IndexFieldTypeImpl();
    fieldType.setFieldType(FieldType.BOOLEAN);

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

    // Act and Assert
    assertEquals("b", searchFacetImpl.getFacetFieldType());
  }

  /**
   * Test {@link SearchFacetImpl#getName()}.
   *
   * <p>Method under test: {@link SearchFacetImpl#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(searchFacetImpl.getName());
  }

  /**
   * Test {@link SearchFacetImpl#getLabel()}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} Label is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetImpl.getLabel()"})
  public void testGetLabel_givenSearchFacetImplLabelIsFoo_thenReturnFoo() {
    // Arrange
    searchFacetImpl.setLabel("foo");

    // Act and Assert
    assertEquals("foo", searchFacetImpl.getLabel());
  }

  /**
   * Test {@link SearchFacetImpl#getLabel()}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getLabel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetImpl.getLabel()"})
  public void testGetLabel_givenSearchFacetImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(searchFacetImpl.getLabel());
  }

  /**
   * Test {@link SearchFacetImpl#getRequiresAllDependentFacets()}.
   *
   * <p>Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SearchFacetImpl.getRequiresAllDependentFacets()"})
  public void testGetRequiresAllDependentFacets() {
    // Arrange
    searchFacetImpl.setRequiresAllDependentFacets(null);

    // Act and Assert
    assertFalse(searchFacetImpl.getRequiresAllDependentFacets());
  }

  /**
   * Test {@link SearchFacetImpl#getRequiresAllDependentFacets()}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SearchFacetImpl.getRequiresAllDependentFacets()"})
  public void testGetRequiresAllDependentFacets_givenSearchFacetImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(searchFacetImpl.getRequiresAllDependentFacets());
  }

  /**
   * Test {@link SearchFacetImpl#getRequiresAllDependentFacets()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getRequiresAllDependentFacets()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SearchFacetImpl.getRequiresAllDependentFacets()"})
  public void testGetRequiresAllDependentFacets_thenReturnTrue() {
    // Arrange
    searchFacetImpl.setRequiresAllDependentFacets(true);

    // Act and Assert
    assertTrue(searchFacetImpl.getRequiresAllDependentFacets());
  }

  /**
   * Test {@link SearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new SearchFacetImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SearchFacet> actualCreateOrRetrieveCopyInstanceResult =
        searchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    IndexFieldTypeImpl fieldType = mock(IndexFieldTypeImpl.class);
    when(fieldType.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new IndexFieldTypeImpl(), true));

    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setFieldType(fieldType);

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
    CreateResponse<Object> createResponse = new CreateResponse<>(searchFacetImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SearchFacet> actualCreateOrRetrieveCopyInstanceResult =
        searchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(fieldType).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SearchFacetImpl#equals(Object)}, and {@link SearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SearchFacetImpl#equals(Object)}
   *   <li>{@link SearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchFacetImpl.equals(Object)", "int SearchFacetImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(null);
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
    searchFacetImpl2.setFieldType(null);
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
    assertEquals(searchFacetImpl, searchFacetImpl2);
    assertEquals(searchFacetImpl.hashCode(), searchFacetImpl2.hashCode());
  }

  /**
   * Test {@link SearchFacetImpl#equals(Object)}, and {@link SearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SearchFacetImpl#equals(Object)}
   *   <li>{@link SearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchFacetImpl.equals(Object)", "int SearchFacetImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchFacetImpl.equals(Object)", "int SearchFacetImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchFacetImpl.equals(Object)", "int SearchFacetImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchFacetImpl.equals(Object)", "int SearchFacetImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} Label is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenSearchFacetImplLabelIsFoo_thenReturnFoo() {
    // Arrange
    searchFacetImpl.setLabel("foo");

    // Act and Assert
    assertEquals("foo", searchFacetImpl.getMainEntityName());
  }

  /**
   * Test {@link SearchFacetImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenSearchFacetImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(searchFacetImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchFacetImpl.<init>()",
    "Boolean SearchFacetImpl.getCanMultiselect()",
    "IndexFieldType SearchFacetImpl.getFieldType()",
    "Long SearchFacetImpl.getId()",
    "List SearchFacetImpl.getRequiredFacets()",
    "Integer SearchFacetImpl.getSearchDisplayPriority()",
    "List SearchFacetImpl.getSearchFacetRanges()",
    "Boolean SearchFacetImpl.getShowOnSearch()",
    "Boolean SearchFacetImpl.getUseFacetRanges()",
    "void SearchFacetImpl.setCanMultiselect(Boolean)",
    "void SearchFacetImpl.setFieldType(IndexFieldType)",
    "void SearchFacetImpl.setId(Long)",
    "void SearchFacetImpl.setLabel(String)",
    "void SearchFacetImpl.setName(String)",
    "void SearchFacetImpl.setRequiredFacets(List)",
    "void SearchFacetImpl.setRequiresAllDependentFacets(Boolean)",
    "void SearchFacetImpl.setSearchDisplayPriority(Integer)",
    "void SearchFacetImpl.setSearchFacetRanges(List)",
    "void SearchFacetImpl.setShowOnSearch(Boolean)",
    "void SearchFacetImpl.setUseFacetRanges(Boolean)"
  })
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

    // Assert
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
