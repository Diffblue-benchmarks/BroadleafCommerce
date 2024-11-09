/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PersistencePackageRequest.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersistencePackageRequestDiffblueTest {
  @Autowired
  private PersistencePackageRequest persistencePackageRequest;

  /**
   * Test {@link PersistencePackageRequest#standard()}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#standard()}
   */
  @Test
  public void testStandard() {
    // Arrange and Act
    PersistencePackageRequest actualStandardResult = PersistencePackageRequest.standard();

    // Assert
    assertNull(actualStandardResult.getSectionCrumbs());
    assertNull(actualStandardResult.getPresentationFetch());
    assertNull(actualStandardResult.getLowerCount());
    assertNull(actualStandardResult.getMaxIndex());
    assertNull(actualStandardResult.getMaxResults());
    assertNull(actualStandardResult.getPageSize());
    assertNull(actualStandardResult.getStartIndex());
    assertNull(actualStandardResult.getUpperCount());
    assertNull(actualStandardResult.getFirstId());
    assertNull(actualStandardResult.getFolderId());
    assertNull(actualStandardResult.getLastId());
    assertNull(actualStandardResult.getCeilingEntityClassname());
    assertNull(actualStandardResult.getConfigKey());
    assertNull(actualStandardResult.getMsg());
    assertNull(actualStandardResult.getRequestingEntityName());
    assertNull(actualStandardResult.getSectionEntityField());
    assertNull(actualStandardResult.getSecurityCeilingEntityClassname());
    assertNull(actualStandardResult.securityCeilingEntityClassname);
    assertNull(actualStandardResult.getAdornedList());
    assertNull(actualStandardResult.getEntity());
    assertNull(actualStandardResult.getForeignKey());
    assertNull(actualStandardResult.getMapStructure());
    assertNull(actualStandardResult.getOperationTypesOverride());
    assertEquals(0, actualStandardResult.getAdditionalForeignKeys().length);
    assertEquals(0, actualStandardResult.getCustomCriteria().length);
    assertEquals(0, actualStandardResult.getFilterAndSortCriteria().length);
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualStandardResult.getType());
    assertFalse(actualStandardResult.hasSortCriteria());
    assertFalse(actualStandardResult.isAddOperationInspect());
    assertFalse(actualStandardResult.isFolderedLookup());
    assertFalse(actualStandardResult.isTreeCollection());
    assertFalse(actualStandardResult.isUpdateLookupType());
    assertTrue(actualStandardResult.additionalForeignKeys.isEmpty());
    assertTrue(actualStandardResult.customCriteria.isEmpty());
    assertTrue(actualStandardResult.filterAndSortCriteria.isEmpty());
    assertTrue(actualStandardResult.getSubRequests().isEmpty());
    assertTrue(actualStandardResult.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link PersistencePackageRequest#adorned()}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#adorned()}
   */
  @Test
  public void testAdorned() {
    // Arrange and Act
    PersistencePackageRequest actualAdornedResult = PersistencePackageRequest.adorned();

    // Assert
    assertNull(actualAdornedResult.getSectionCrumbs());
    assertNull(actualAdornedResult.getPresentationFetch());
    assertNull(actualAdornedResult.getLowerCount());
    assertNull(actualAdornedResult.getMaxIndex());
    assertNull(actualAdornedResult.getMaxResults());
    assertNull(actualAdornedResult.getPageSize());
    assertNull(actualAdornedResult.getStartIndex());
    assertNull(actualAdornedResult.getUpperCount());
    assertNull(actualAdornedResult.getFirstId());
    assertNull(actualAdornedResult.getFolderId());
    assertNull(actualAdornedResult.getLastId());
    assertNull(actualAdornedResult.getCeilingEntityClassname());
    assertNull(actualAdornedResult.getConfigKey());
    assertNull(actualAdornedResult.getMsg());
    assertNull(actualAdornedResult.getRequestingEntityName());
    assertNull(actualAdornedResult.getSectionEntityField());
    assertNull(actualAdornedResult.getSecurityCeilingEntityClassname());
    assertNull(actualAdornedResult.securityCeilingEntityClassname);
    assertNull(actualAdornedResult.getAdornedList());
    assertNull(actualAdornedResult.getEntity());
    assertNull(actualAdornedResult.getForeignKey());
    assertNull(actualAdornedResult.getMapStructure());
    assertNull(actualAdornedResult.getOperationTypesOverride());
    assertEquals(0, actualAdornedResult.getAdditionalForeignKeys().length);
    assertEquals(0, actualAdornedResult.getCustomCriteria().length);
    assertEquals(0, actualAdornedResult.getFilterAndSortCriteria().length);
    assertEquals(PersistencePackageRequest.Type.ADORNED, actualAdornedResult.getType());
    assertFalse(actualAdornedResult.hasSortCriteria());
    assertFalse(actualAdornedResult.isAddOperationInspect());
    assertFalse(actualAdornedResult.isFolderedLookup());
    assertFalse(actualAdornedResult.isTreeCollection());
    assertFalse(actualAdornedResult.isUpdateLookupType());
    assertTrue(actualAdornedResult.additionalForeignKeys.isEmpty());
    assertTrue(actualAdornedResult.customCriteria.isEmpty());
    assertTrue(actualAdornedResult.filterAndSortCriteria.isEmpty());
    assertTrue(actualAdornedResult.getSubRequests().isEmpty());
    assertTrue(actualAdornedResult.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link PersistencePackageRequest#map()}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#map()}
   */
  @Test
  public void testMap() {
    // Arrange and Act
    PersistencePackageRequest actualMapResult = PersistencePackageRequest.map();

    // Assert
    assertNull(actualMapResult.getSectionCrumbs());
    assertNull(actualMapResult.getPresentationFetch());
    assertNull(actualMapResult.getLowerCount());
    assertNull(actualMapResult.getMaxIndex());
    assertNull(actualMapResult.getMaxResults());
    assertNull(actualMapResult.getPageSize());
    assertNull(actualMapResult.getStartIndex());
    assertNull(actualMapResult.getUpperCount());
    assertNull(actualMapResult.getFirstId());
    assertNull(actualMapResult.getFolderId());
    assertNull(actualMapResult.getLastId());
    assertNull(actualMapResult.getCeilingEntityClassname());
    assertNull(actualMapResult.getConfigKey());
    assertNull(actualMapResult.getMsg());
    assertNull(actualMapResult.getRequestingEntityName());
    assertNull(actualMapResult.getSectionEntityField());
    assertNull(actualMapResult.getSecurityCeilingEntityClassname());
    assertNull(actualMapResult.securityCeilingEntityClassname);
    assertNull(actualMapResult.getAdornedList());
    assertNull(actualMapResult.getEntity());
    assertNull(actualMapResult.getForeignKey());
    assertNull(actualMapResult.getMapStructure());
    assertNull(actualMapResult.getOperationTypesOverride());
    assertEquals(0, actualMapResult.getAdditionalForeignKeys().length);
    assertEquals(0, actualMapResult.getCustomCriteria().length);
    assertEquals(0, actualMapResult.getFilterAndSortCriteria().length);
    assertEquals(PersistencePackageRequest.Type.MAP, actualMapResult.getType());
    assertFalse(actualMapResult.hasSortCriteria());
    assertFalse(actualMapResult.isAddOperationInspect());
    assertFalse(actualMapResult.isFolderedLookup());
    assertFalse(actualMapResult.isTreeCollection());
    assertFalse(actualMapResult.isUpdateLookupType());
    assertTrue(actualMapResult.additionalForeignKeys.isEmpty());
    assertTrue(actualMapResult.customCriteria.isEmpty());
    assertTrue(actualMapResult.filterAndSortCriteria.isEmpty());
    assertTrue(actualMapResult.getSubRequests().isEmpty());
    assertTrue(actualMapResult.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata md = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(md).accept(Mockito.<MetadataVisitor>any());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualFromMetadataResult = PersistencePackageRequest.fromMetadata(md, sectionCrumbs);

    // Assert
    verify(md).accept(isA(MetadataVisitor.class));
    SectionCrumb[] sectionCrumbs2 = actualFromMetadataResult.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("Original Section Identifier", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("Section Id", sectionCrumb3.getSectionId());
    assertEquals("Section Identifier", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}.
   * <ul>
   *   <li>Then return first element OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata_thenReturnFirstElementOriginalSectionIdentifierIs42() {
    // Arrange
    AdornedTargetCollectionMetadata md = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(md).accept(Mockito.<MetadataVisitor>any());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualFromMetadataResult = PersistencePackageRequest.fromMetadata(md, sectionCrumbs);

    // Assert
    verify(md).accept(isA(MetadataVisitor.class));
    SectionCrumb[] sectionCrumbs2 = actualFromMetadataResult.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}.
   * <ul>
   *   <li>Then return OperationTypesOverride AddType is {@code BASIC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata_thenReturnOperationTypesOverrideAddTypeIsBasic() {
    // Arrange
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    md.setPersistencePerspective(new PersistencePerspective());

    // Act
    PersistencePackageRequest actualFromMetadataResult = PersistencePackageRequest.fromMetadata(md, new ArrayList<>());

    // Assert
    OperationTypes operationTypesOverride = actualFromMetadataResult.getOperationTypesOverride();
    assertEquals(OperationType.BASIC, operationTypesOverride.getAddType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getFetchType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getInspectType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getUpdateType());
    assertEquals(PersistencePackageRequest.Type.ADORNED, actualFromMetadataResult.getType());
  }

  /**
   * Test {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}.
   * <ul>
   *   <li>Then return Type is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata_thenReturnTypeIsNull() {
    // Arrange
    AdornedTargetCollectionMetadata md = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(md).accept(Mockito.<MetadataVisitor>any());

    // Act
    PersistencePackageRequest actualFromMetadataResult = PersistencePackageRequest.fromMetadata(md, new ArrayList<>());

    // Assert
    verify(md).accept(isA(MetadataVisitor.class));
    assertNull(actualFromMetadataResult.getPresentationFetch());
    assertNull(actualFromMetadataResult.getLowerCount());
    assertNull(actualFromMetadataResult.getMaxIndex());
    assertNull(actualFromMetadataResult.getMaxResults());
    assertNull(actualFromMetadataResult.getPageSize());
    assertNull(actualFromMetadataResult.getStartIndex());
    assertNull(actualFromMetadataResult.getUpperCount());
    assertNull(actualFromMetadataResult.getFirstId());
    assertNull(actualFromMetadataResult.getFolderId());
    assertNull(actualFromMetadataResult.getLastId());
    assertNull(actualFromMetadataResult.getCeilingEntityClassname());
    assertNull(actualFromMetadataResult.getConfigKey());
    assertNull(actualFromMetadataResult.getMsg());
    assertNull(actualFromMetadataResult.getRequestingEntityName());
    assertNull(actualFromMetadataResult.getSectionEntityField());
    assertNull(actualFromMetadataResult.getSecurityCeilingEntityClassname());
    assertNull(actualFromMetadataResult.securityCeilingEntityClassname);
    assertNull(actualFromMetadataResult.getAdornedList());
    assertNull(actualFromMetadataResult.getEntity());
    assertNull(actualFromMetadataResult.getForeignKey());
    assertNull(actualFromMetadataResult.getMapStructure());
    assertNull(actualFromMetadataResult.getOperationTypesOverride());
    assertNull(actualFromMetadataResult.getType());
    assertEquals(0, actualFromMetadataResult.getAdditionalForeignKeys().length);
    assertEquals(0, actualFromMetadataResult.getCustomCriteria().length);
    assertEquals(0, actualFromMetadataResult.getFilterAndSortCriteria().length);
    assertEquals(0, actualFromMetadataResult.getSectionCrumbs().length);
    assertFalse(actualFromMetadataResult.hasSortCriteria());
    assertFalse(actualFromMetadataResult.isAddOperationInspect());
    assertFalse(actualFromMetadataResult.isFolderedLookup());
    assertFalse(actualFromMetadataResult.isTreeCollection());
    assertFalse(actualFromMetadataResult.isUpdateLookupType());
    assertTrue(actualFromMetadataResult.additionalForeignKeys.isEmpty());
    assertTrue(actualFromMetadataResult.customCriteria.isEmpty());
    assertTrue(actualFromMetadataResult.filterAndSortCriteria.isEmpty());
    assertTrue(actualFromMetadataResult.getSubRequests().isEmpty());
    assertTrue(actualFromMetadataResult.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return Type is {@code STANDARD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata_whenBasicFieldMetadata_thenReturnTypeIsStandard() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();

    // Act
    PersistencePackageRequest actualFromMetadataResult = PersistencePackageRequest.fromMetadata(md, new ArrayList<>());

    // Assert
    assertNull(actualFromMetadataResult.getPresentationFetch());
    assertNull(actualFromMetadataResult.getLowerCount());
    assertNull(actualFromMetadataResult.getMaxIndex());
    assertNull(actualFromMetadataResult.getMaxResults());
    assertNull(actualFromMetadataResult.getPageSize());
    assertNull(actualFromMetadataResult.getStartIndex());
    assertNull(actualFromMetadataResult.getUpperCount());
    assertNull(actualFromMetadataResult.getFirstId());
    assertNull(actualFromMetadataResult.getFolderId());
    assertNull(actualFromMetadataResult.getLastId());
    assertNull(actualFromMetadataResult.getCeilingEntityClassname());
    assertNull(actualFromMetadataResult.getConfigKey());
    assertNull(actualFromMetadataResult.getMsg());
    assertNull(actualFromMetadataResult.getRequestingEntityName());
    assertNull(actualFromMetadataResult.getSectionEntityField());
    assertNull(actualFromMetadataResult.getSecurityCeilingEntityClassname());
    assertNull(actualFromMetadataResult.securityCeilingEntityClassname);
    assertNull(actualFromMetadataResult.getAdornedList());
    assertNull(actualFromMetadataResult.getEntity());
    assertNull(actualFromMetadataResult.getForeignKey());
    assertNull(actualFromMetadataResult.getMapStructure());
    assertNull(actualFromMetadataResult.getOperationTypesOverride());
    assertEquals(0, actualFromMetadataResult.getAdditionalForeignKeys().length);
    assertEquals(0, actualFromMetadataResult.getCustomCriteria().length);
    assertEquals(0, actualFromMetadataResult.getFilterAndSortCriteria().length);
    assertEquals(0, actualFromMetadataResult.getSectionCrumbs().length);
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualFromMetadataResult.getType());
    assertFalse(actualFromMetadataResult.hasSortCriteria());
    assertFalse(actualFromMetadataResult.isAddOperationInspect());
    assertFalse(actualFromMetadataResult.isFolderedLookup());
    assertFalse(actualFromMetadataResult.isTreeCollection());
    assertFalse(actualFromMetadataResult.isUpdateLookupType());
    assertTrue(actualFromMetadataResult.additionalForeignKeys.isEmpty());
    assertTrue(actualFromMetadataResult.customCriteria.isEmpty());
    assertTrue(actualFromMetadataResult.filterAndSortCriteria.isEmpty());
    assertTrue(actualFromMetadataResult.getSubRequests().isEmpty());
    assertTrue(actualFromMetadataResult.isValidateUnsubmittedProperties());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePackageRequest#PersistencePackageRequest()}
   *   <li>{@link PersistencePackageRequest#setAddOperationInspect(boolean)}
   *   <li>{@link PersistencePackageRequest#setAdornedList(AdornedTargetList)}
   *   <li>{@link PersistencePackageRequest#setCeilingEntityClassname(String)}
   *   <li>{@link PersistencePackageRequest#setConfigKey(String)}
   *   <li>{@link PersistencePackageRequest#setEntity(Entity)}
   *   <li>{@link PersistencePackageRequest#setFirstId(Long)}
   *   <li>{@link PersistencePackageRequest#setFolderId(Long)}
   *   <li>{@link PersistencePackageRequest#setFolderedLookup(boolean)}
   *   <li>{@link PersistencePackageRequest#setForeignKey(ForeignKey)}
   *   <li>{@link PersistencePackageRequest#setIsTreeCollection(boolean)}
   *   <li>{@link PersistencePackageRequest#setLastId(Long)}
   *   <li>{@link PersistencePackageRequest#setLowerCount(Integer)}
   *   <li>{@link PersistencePackageRequest#setMapStructure(MapStructure)}
   *   <li>{@link PersistencePackageRequest#setMaxIndex(Integer)}
   *   <li>{@link PersistencePackageRequest#setMaxResults(Integer)}
   *   <li>{@link PersistencePackageRequest#setMsg(String)}
   *   <li>
   * {@link PersistencePackageRequest#setOperationTypesOverride(OperationTypes)}
   *   <li>{@link PersistencePackageRequest#setPageSize(Integer)}
   *   <li>{@link PersistencePackageRequest#setPresentationFetch(Boolean)}
   *   <li>{@link PersistencePackageRequest#setRequestingEntityName(String)}
   *   <li>{@link PersistencePackageRequest#setSectionCrumbs(SectionCrumb[])}
   *   <li>{@link PersistencePackageRequest#setSectionEntityField(String)}
   *   <li>
   * {@link PersistencePackageRequest#setSecurityCeilingEntityClassname(String)}
   *   <li>{@link PersistencePackageRequest#setStartIndex(Integer)}
   *   <li>{@link PersistencePackageRequest#setSubRequests(Map)}
   *   <li>{@link PersistencePackageRequest#setType(PersistencePackageRequest.Type)}
   *   <li>{@link PersistencePackageRequest#setUpdateLookupType(boolean)}
   *   <li>{@link PersistencePackageRequest#setUpperCount(Integer)}
   *   <li>
   * {@link PersistencePackageRequest#setValidateUnsubmittedProperties(boolean)}
   *   <li>{@link PersistencePackageRequest#withFolderId(Long)}
   *   <li>{@link PersistencePackageRequest#withIsFolderedLookup(boolean)}
   *   <li>{@link PersistencePackageRequest#getAdornedList()}
   *   <li>{@link PersistencePackageRequest#getCeilingEntityClassname()}
   *   <li>{@link PersistencePackageRequest#getConfigKey()}
   *   <li>{@link PersistencePackageRequest#getEntity()}
   *   <li>{@link PersistencePackageRequest#getFirstId()}
   *   <li>{@link PersistencePackageRequest#getFolderId()}
   *   <li>{@link PersistencePackageRequest#getForeignKey()}
   *   <li>{@link PersistencePackageRequest#getLastId()}
   *   <li>{@link PersistencePackageRequest#getLowerCount()}
   *   <li>{@link PersistencePackageRequest#getMapStructure()}
   *   <li>{@link PersistencePackageRequest#getMaxIndex()}
   *   <li>{@link PersistencePackageRequest#getMaxResults()}
   *   <li>{@link PersistencePackageRequest#getMsg()}
   *   <li>{@link PersistencePackageRequest#getOperationTypesOverride()}
   *   <li>{@link PersistencePackageRequest#getPageSize()}
   *   <li>{@link PersistencePackageRequest#getPresentationFetch()}
   *   <li>{@link PersistencePackageRequest#getRequestingEntityName()}
   *   <li>{@link PersistencePackageRequest#getSectionCrumbs()}
   *   <li>{@link PersistencePackageRequest#getSectionEntityField()}
   *   <li>{@link PersistencePackageRequest#getStartIndex()}
   *   <li>{@link PersistencePackageRequest#getSubRequests()}
   *   <li>{@link PersistencePackageRequest#getType()}
   *   <li>{@link PersistencePackageRequest#getUpperCount()}
   *   <li>{@link PersistencePackageRequest#isAddOperationInspect()}
   *   <li>{@link PersistencePackageRequest#isFolderedLookup()}
   *   <li>{@link PersistencePackageRequest#isTreeCollection()}
   *   <li>{@link PersistencePackageRequest#isUpdateLookupType()}
   *   <li>{@link PersistencePackageRequest#isValidateUnsubmittedProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PersistencePackageRequest actualPersistencePackageRequest = new PersistencePackageRequest();
    actualPersistencePackageRequest.setAddOperationInspect(true);
    AdornedTargetList adornedList = new AdornedTargetList();
    actualPersistencePackageRequest.setAdornedList(adornedList);
    actualPersistencePackageRequest.setCeilingEntityClassname("Ceiling Entity Classname");
    actualPersistencePackageRequest.setConfigKey("Config Key");
    Entity entity = new Entity();
    actualPersistencePackageRequest.setEntity(entity);
    actualPersistencePackageRequest.setFirstId(1L);
    actualPersistencePackageRequest.setFolderId(1L);
    actualPersistencePackageRequest.setFolderedLookup(true);
    ForeignKey foreignKey = new ForeignKey();
    actualPersistencePackageRequest.setForeignKey(foreignKey);
    actualPersistencePackageRequest.setIsTreeCollection(true);
    actualPersistencePackageRequest.setLastId(1L);
    actualPersistencePackageRequest.setLowerCount(3);
    MapStructure mapStructure = new MapStructure();
    actualPersistencePackageRequest.setMapStructure(mapStructure);
    actualPersistencePackageRequest.setMaxIndex(1);
    actualPersistencePackageRequest.setMaxResults(3);
    actualPersistencePackageRequest.setMsg("Msg");
    OperationTypes operationTypesOverride = new OperationTypes();
    actualPersistencePackageRequest.setOperationTypesOverride(operationTypesOverride);
    actualPersistencePackageRequest.setPageSize(3);
    actualPersistencePackageRequest.setPresentationFetch(true);
    actualPersistencePackageRequest.setRequestingEntityName("Requesting Entity Name");
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    SectionCrumb[] sectionCrumbs = new SectionCrumb[]{sectionCrumb};
    actualPersistencePackageRequest.setSectionCrumbs(sectionCrumbs);
    actualPersistencePackageRequest.setSectionEntityField("Section Entity Field");
    actualPersistencePackageRequest.setSecurityCeilingEntityClassname("Security Ceiling Entity Classname");
    actualPersistencePackageRequest.setStartIndex(1);
    HashMap<String, PersistencePackageRequest> subRequests = new HashMap<>();
    actualPersistencePackageRequest.setSubRequests(subRequests);
    actualPersistencePackageRequest.setType(PersistencePackageRequest.Type.STANDARD);
    actualPersistencePackageRequest.setUpdateLookupType(true);
    actualPersistencePackageRequest.setUpperCount(3);
    actualPersistencePackageRequest.setValidateUnsubmittedProperties(true);
    PersistencePackageRequest actualWithFolderIdResult = actualPersistencePackageRequest.withFolderId(1L);
    PersistencePackageRequest actualWithIsFolderedLookupResult = actualPersistencePackageRequest
        .withIsFolderedLookup(true);
    AdornedTargetList actualAdornedList = actualPersistencePackageRequest.getAdornedList();
    String actualCeilingEntityClassname = actualPersistencePackageRequest.getCeilingEntityClassname();
    String actualConfigKey = actualPersistencePackageRequest.getConfigKey();
    Entity actualEntity = actualPersistencePackageRequest.getEntity();
    Long actualFirstId = actualPersistencePackageRequest.getFirstId();
    Long actualFolderId = actualPersistencePackageRequest.getFolderId();
    ForeignKey actualForeignKey = actualPersistencePackageRequest.getForeignKey();
    Long actualLastId = actualPersistencePackageRequest.getLastId();
    Integer actualLowerCount = actualPersistencePackageRequest.getLowerCount();
    MapStructure actualMapStructure = actualPersistencePackageRequest.getMapStructure();
    Integer actualMaxIndex = actualPersistencePackageRequest.getMaxIndex();
    Integer actualMaxResults = actualPersistencePackageRequest.getMaxResults();
    String actualMsg = actualPersistencePackageRequest.getMsg();
    OperationTypes actualOperationTypesOverride = actualPersistencePackageRequest.getOperationTypesOverride();
    Integer actualPageSize = actualPersistencePackageRequest.getPageSize();
    Boolean actualPresentationFetch = actualPersistencePackageRequest.getPresentationFetch();
    String actualRequestingEntityName = actualPersistencePackageRequest.getRequestingEntityName();
    SectionCrumb[] actualSectionCrumbs = actualPersistencePackageRequest.getSectionCrumbs();
    String actualSectionEntityField = actualPersistencePackageRequest.getSectionEntityField();
    Integer actualStartIndex = actualPersistencePackageRequest.getStartIndex();
    Map<String, PersistencePackageRequest> actualSubRequests = actualPersistencePackageRequest.getSubRequests();
    PersistencePackageRequest.Type actualType = actualPersistencePackageRequest.getType();
    Integer actualUpperCount = actualPersistencePackageRequest.getUpperCount();
    boolean actualIsAddOperationInspectResult = actualPersistencePackageRequest.isAddOperationInspect();
    boolean actualIsFolderedLookupResult = actualPersistencePackageRequest.isFolderedLookup();
    boolean actualIsTreeCollectionResult = actualPersistencePackageRequest.isTreeCollection();
    boolean actualIsUpdateLookupTypeResult = actualPersistencePackageRequest.isUpdateLookupType();
    boolean actualIsValidateUnsubmittedPropertiesResult = actualPersistencePackageRequest
        .isValidateUnsubmittedProperties();

    // Assert that nothing has changed
    assertEquals("Ceiling Entity Classname", actualCeilingEntityClassname);
    assertEquals("Config Key", actualConfigKey);
    assertEquals("Msg", actualMsg);
    assertEquals("Requesting Entity Name", actualRequestingEntityName);
    assertEquals("Section Entity Field", actualSectionEntityField);
    assertEquals(1, actualMaxIndex.intValue());
    assertEquals(1, actualStartIndex.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualFolderId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualMaxResults.intValue());
    assertEquals(3, actualPageSize.intValue());
    assertEquals(3, actualUpperCount.intValue());
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualType);
    assertTrue(actualPersistencePackageRequest.additionalForeignKeys.isEmpty());
    assertTrue(actualPersistencePackageRequest.customCriteria.isEmpty());
    assertTrue(actualPersistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertTrue(actualSubRequests.isEmpty());
    assertTrue(actualPresentationFetch);
    assertTrue(actualIsAddOperationInspectResult);
    assertTrue(actualIsFolderedLookupResult);
    assertTrue(actualIsTreeCollectionResult);
    assertTrue(actualIsUpdateLookupTypeResult);
    assertTrue(actualIsValidateUnsubmittedPropertiesResult);
    assertSame(subRequests, actualSubRequests);
    assertSame(adornedList, actualAdornedList);
    assertSame(entity, actualEntity);
    assertSame(foreignKey, actualForeignKey);
    assertSame(mapStructure, actualMapStructure);
    assertSame(operationTypesOverride, actualOperationTypesOverride);
    assertSame(actualPersistencePackageRequest, actualWithFolderIdResult);
    assertSame(actualPersistencePackageRequest, actualWithIsFolderedLookupResult);
    assertSame(sectionCrumbs, actualSectionCrumbs);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code STANDARD}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PersistencePackageRequest#PersistencePackageRequest(PersistencePackageRequest.Type)}
   *   <li>{@link PersistencePackageRequest#setAddOperationInspect(boolean)}
   *   <li>{@link PersistencePackageRequest#setAdornedList(AdornedTargetList)}
   *   <li>{@link PersistencePackageRequest#setCeilingEntityClassname(String)}
   *   <li>{@link PersistencePackageRequest#setConfigKey(String)}
   *   <li>{@link PersistencePackageRequest#setEntity(Entity)}
   *   <li>{@link PersistencePackageRequest#setFirstId(Long)}
   *   <li>{@link PersistencePackageRequest#setFolderId(Long)}
   *   <li>{@link PersistencePackageRequest#setFolderedLookup(boolean)}
   *   <li>{@link PersistencePackageRequest#setForeignKey(ForeignKey)}
   *   <li>{@link PersistencePackageRequest#setIsTreeCollection(boolean)}
   *   <li>{@link PersistencePackageRequest#setLastId(Long)}
   *   <li>{@link PersistencePackageRequest#setLowerCount(Integer)}
   *   <li>{@link PersistencePackageRequest#setMapStructure(MapStructure)}
   *   <li>{@link PersistencePackageRequest#setMaxIndex(Integer)}
   *   <li>{@link PersistencePackageRequest#setMaxResults(Integer)}
   *   <li>{@link PersistencePackageRequest#setMsg(String)}
   *   <li>
   * {@link PersistencePackageRequest#setOperationTypesOverride(OperationTypes)}
   *   <li>{@link PersistencePackageRequest#setPageSize(Integer)}
   *   <li>{@link PersistencePackageRequest#setPresentationFetch(Boolean)}
   *   <li>{@link PersistencePackageRequest#setRequestingEntityName(String)}
   *   <li>{@link PersistencePackageRequest#setSectionCrumbs(SectionCrumb[])}
   *   <li>{@link PersistencePackageRequest#setSectionEntityField(String)}
   *   <li>
   * {@link PersistencePackageRequest#setSecurityCeilingEntityClassname(String)}
   *   <li>{@link PersistencePackageRequest#setStartIndex(Integer)}
   *   <li>{@link PersistencePackageRequest#setSubRequests(Map)}
   *   <li>{@link PersistencePackageRequest#setType(PersistencePackageRequest.Type)}
   *   <li>{@link PersistencePackageRequest#setUpdateLookupType(boolean)}
   *   <li>{@link PersistencePackageRequest#setUpperCount(Integer)}
   *   <li>
   * {@link PersistencePackageRequest#setValidateUnsubmittedProperties(boolean)}
   *   <li>{@link PersistencePackageRequest#withFolderId(Long)}
   *   <li>{@link PersistencePackageRequest#withIsFolderedLookup(boolean)}
   *   <li>{@link PersistencePackageRequest#getAdornedList()}
   *   <li>{@link PersistencePackageRequest#getCeilingEntityClassname()}
   *   <li>{@link PersistencePackageRequest#getConfigKey()}
   *   <li>{@link PersistencePackageRequest#getEntity()}
   *   <li>{@link PersistencePackageRequest#getFirstId()}
   *   <li>{@link PersistencePackageRequest#getFolderId()}
   *   <li>{@link PersistencePackageRequest#getForeignKey()}
   *   <li>{@link PersistencePackageRequest#getLastId()}
   *   <li>{@link PersistencePackageRequest#getLowerCount()}
   *   <li>{@link PersistencePackageRequest#getMapStructure()}
   *   <li>{@link PersistencePackageRequest#getMaxIndex()}
   *   <li>{@link PersistencePackageRequest#getMaxResults()}
   *   <li>{@link PersistencePackageRequest#getMsg()}
   *   <li>{@link PersistencePackageRequest#getOperationTypesOverride()}
   *   <li>{@link PersistencePackageRequest#getPageSize()}
   *   <li>{@link PersistencePackageRequest#getPresentationFetch()}
   *   <li>{@link PersistencePackageRequest#getRequestingEntityName()}
   *   <li>{@link PersistencePackageRequest#getSectionCrumbs()}
   *   <li>{@link PersistencePackageRequest#getSectionEntityField()}
   *   <li>{@link PersistencePackageRequest#getStartIndex()}
   *   <li>{@link PersistencePackageRequest#getSubRequests()}
   *   <li>{@link PersistencePackageRequest#getType()}
   *   <li>{@link PersistencePackageRequest#getUpperCount()}
   *   <li>{@link PersistencePackageRequest#isAddOperationInspect()}
   *   <li>{@link PersistencePackageRequest#isFolderedLookup()}
   *   <li>{@link PersistencePackageRequest#isTreeCollection()}
   *   <li>{@link PersistencePackageRequest#isUpdateLookupType()}
   *   <li>{@link PersistencePackageRequest#isValidateUnsubmittedProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenStandard() {
    // Arrange and Act
    PersistencePackageRequest actualPersistencePackageRequest = new PersistencePackageRequest(
        PersistencePackageRequest.Type.STANDARD);
    actualPersistencePackageRequest.setAddOperationInspect(true);
    AdornedTargetList adornedList = new AdornedTargetList();
    actualPersistencePackageRequest.setAdornedList(adornedList);
    actualPersistencePackageRequest.setCeilingEntityClassname("Ceiling Entity Classname");
    actualPersistencePackageRequest.setConfigKey("Config Key");
    Entity entity = new Entity();
    actualPersistencePackageRequest.setEntity(entity);
    actualPersistencePackageRequest.setFirstId(1L);
    actualPersistencePackageRequest.setFolderId(1L);
    actualPersistencePackageRequest.setFolderedLookup(true);
    ForeignKey foreignKey = new ForeignKey();
    actualPersistencePackageRequest.setForeignKey(foreignKey);
    actualPersistencePackageRequest.setIsTreeCollection(true);
    actualPersistencePackageRequest.setLastId(1L);
    actualPersistencePackageRequest.setLowerCount(3);
    MapStructure mapStructure = new MapStructure();
    actualPersistencePackageRequest.setMapStructure(mapStructure);
    actualPersistencePackageRequest.setMaxIndex(1);
    actualPersistencePackageRequest.setMaxResults(3);
    actualPersistencePackageRequest.setMsg("Msg");
    OperationTypes operationTypesOverride = new OperationTypes();
    actualPersistencePackageRequest.setOperationTypesOverride(operationTypesOverride);
    actualPersistencePackageRequest.setPageSize(3);
    actualPersistencePackageRequest.setPresentationFetch(true);
    actualPersistencePackageRequest.setRequestingEntityName("Requesting Entity Name");
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    SectionCrumb[] sectionCrumbs = new SectionCrumb[]{sectionCrumb};
    actualPersistencePackageRequest.setSectionCrumbs(sectionCrumbs);
    actualPersistencePackageRequest.setSectionEntityField("Section Entity Field");
    actualPersistencePackageRequest.setSecurityCeilingEntityClassname("Security Ceiling Entity Classname");
    actualPersistencePackageRequest.setStartIndex(1);
    HashMap<String, PersistencePackageRequest> subRequests = new HashMap<>();
    actualPersistencePackageRequest.setSubRequests(subRequests);
    actualPersistencePackageRequest.setType(PersistencePackageRequest.Type.STANDARD);
    actualPersistencePackageRequest.setUpdateLookupType(true);
    actualPersistencePackageRequest.setUpperCount(3);
    actualPersistencePackageRequest.setValidateUnsubmittedProperties(true);
    PersistencePackageRequest actualWithFolderIdResult = actualPersistencePackageRequest.withFolderId(1L);
    PersistencePackageRequest actualWithIsFolderedLookupResult = actualPersistencePackageRequest
        .withIsFolderedLookup(true);
    AdornedTargetList actualAdornedList = actualPersistencePackageRequest.getAdornedList();
    String actualCeilingEntityClassname = actualPersistencePackageRequest.getCeilingEntityClassname();
    String actualConfigKey = actualPersistencePackageRequest.getConfigKey();
    Entity actualEntity = actualPersistencePackageRequest.getEntity();
    Long actualFirstId = actualPersistencePackageRequest.getFirstId();
    Long actualFolderId = actualPersistencePackageRequest.getFolderId();
    ForeignKey actualForeignKey = actualPersistencePackageRequest.getForeignKey();
    Long actualLastId = actualPersistencePackageRequest.getLastId();
    Integer actualLowerCount = actualPersistencePackageRequest.getLowerCount();
    MapStructure actualMapStructure = actualPersistencePackageRequest.getMapStructure();
    Integer actualMaxIndex = actualPersistencePackageRequest.getMaxIndex();
    Integer actualMaxResults = actualPersistencePackageRequest.getMaxResults();
    String actualMsg = actualPersistencePackageRequest.getMsg();
    OperationTypes actualOperationTypesOverride = actualPersistencePackageRequest.getOperationTypesOverride();
    Integer actualPageSize = actualPersistencePackageRequest.getPageSize();
    Boolean actualPresentationFetch = actualPersistencePackageRequest.getPresentationFetch();
    String actualRequestingEntityName = actualPersistencePackageRequest.getRequestingEntityName();
    SectionCrumb[] actualSectionCrumbs = actualPersistencePackageRequest.getSectionCrumbs();
    String actualSectionEntityField = actualPersistencePackageRequest.getSectionEntityField();
    Integer actualStartIndex = actualPersistencePackageRequest.getStartIndex();
    Map<String, PersistencePackageRequest> actualSubRequests = actualPersistencePackageRequest.getSubRequests();
    PersistencePackageRequest.Type actualType = actualPersistencePackageRequest.getType();
    Integer actualUpperCount = actualPersistencePackageRequest.getUpperCount();
    boolean actualIsAddOperationInspectResult = actualPersistencePackageRequest.isAddOperationInspect();
    boolean actualIsFolderedLookupResult = actualPersistencePackageRequest.isFolderedLookup();
    boolean actualIsTreeCollectionResult = actualPersistencePackageRequest.isTreeCollection();
    boolean actualIsUpdateLookupTypeResult = actualPersistencePackageRequest.isUpdateLookupType();
    boolean actualIsValidateUnsubmittedPropertiesResult = actualPersistencePackageRequest
        .isValidateUnsubmittedProperties();

    // Assert that nothing has changed
    assertEquals("Ceiling Entity Classname", actualCeilingEntityClassname);
    assertEquals("Config Key", actualConfigKey);
    assertEquals("Msg", actualMsg);
    assertEquals("Requesting Entity Name", actualRequestingEntityName);
    assertEquals("Section Entity Field", actualSectionEntityField);
    assertEquals(1, actualMaxIndex.intValue());
    assertEquals(1, actualStartIndex.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualFolderId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualMaxResults.intValue());
    assertEquals(3, actualPageSize.intValue());
    assertEquals(3, actualUpperCount.intValue());
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualType);
    assertTrue(actualPersistencePackageRequest.additionalForeignKeys.isEmpty());
    assertTrue(actualPersistencePackageRequest.customCriteria.isEmpty());
    assertTrue(actualPersistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertTrue(actualSubRequests.isEmpty());
    assertTrue(actualPresentationFetch);
    assertTrue(actualIsAddOperationInspectResult);
    assertTrue(actualIsFolderedLookupResult);
    assertTrue(actualIsTreeCollectionResult);
    assertTrue(actualIsUpdateLookupTypeResult);
    assertTrue(actualIsValidateUnsubmittedPropertiesResult);
    assertSame(subRequests, actualSubRequests);
    assertSame(adornedList, actualAdornedList);
    assertSame(entity, actualEntity);
    assertSame(foreignKey, actualForeignKey);
    assertSame(mapStructure, actualMapStructure);
    assertSame(operationTypesOverride, actualOperationTypesOverride);
    assertSame(actualPersistencePackageRequest, actualWithFolderIdResult);
    assertSame(actualPersistencePackageRequest, actualWithIsFolderedLookupResult);
    assertSame(sectionCrumbs, actualSectionCrumbs);
  }

  /**
   * Test {@link PersistencePackageRequest#withType(Type)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withType(PersistencePackageRequest.Type)}
   */
  @Test
  public void testWithType() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithTypeResult = adornedResult.withType(PersistencePackageRequest.Type.STANDARD);

    // Assert
    assertEquals(PersistencePackageRequest.Type.STANDARD, adornedResult.getType());
    assertSame(adornedResult, actualWithTypeResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withCeilingEntityClassname(String)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withCeilingEntityClassname(String)}
   */
  @Test
  public void testWithCeilingEntityClassname() {
    // Arrange and Act
    PersistencePackageRequest actualWithCeilingEntityClassnameResult = persistencePackageRequest
        .withCeilingEntityClassname("Class Name");

    // Assert
    assertEquals("Class Name", persistencePackageRequest.getCeilingEntityClassname());
    assertEquals("Class Name", persistencePackageRequest.getSecurityCeilingEntityClassname());
    assertSame(persistencePackageRequest, actualWithCeilingEntityClassnameResult);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#withSecurityCeilingEntityClassname(String)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withSecurityCeilingEntityClassname(String)}
   */
  @Test
  public void testWithSecurityCeilingEntityClassname() {
    // Arrange and Act
    PersistencePackageRequest actualWithSecurityCeilingEntityClassnameResult = persistencePackageRequest
        .withSecurityCeilingEntityClassname("Class Name");

    // Assert
    assertEquals("Class Name", persistencePackageRequest.getSecurityCeilingEntityClassname());
    assertEquals("Class Name", persistencePackageRequest.securityCeilingEntityClassname);
    assertSame(persistencePackageRequest, actualWithSecurityCeilingEntityClassnameResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withForeignKey(ForeignKey)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withForeignKey(ForeignKey)}
   */
  @Test
  public void testWithForeignKey() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    ForeignKey foreignKey = new ForeignKey();

    // Act
    PersistencePackageRequest actualWithForeignKeyResult = adornedResult.withForeignKey(foreignKey);

    // Assert
    assertSame(foreignKey, adornedResult.getForeignKey());
    assertSame(adornedResult, actualWithForeignKeyResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withConfigKey(String)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withConfigKey(String)}
   */
  @Test
  public void testWithConfigKey() {
    // Arrange and Act
    PersistencePackageRequest actualWithConfigKeyResult = persistencePackageRequest.withConfigKey("Config Key");

    // Assert
    assertEquals("Config Key", persistencePackageRequest.getConfigKey());
    assertSame(persistencePackageRequest, actualWithConfigKeyResult);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#withFilterAndSortCriteria(FilterAndSortCriteria[])}.
   * <ul>
   *   <li>Then return {@link PersistencePackageRequest#filterAndSortCriteria} size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testWithFilterAndSortCriteria_thenReturnFilterAndSortCriteriaSizeIsOne() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    PersistencePackageRequest actualWithFilterAndSortCriteriaResult = adornedResult
        .withFilterAndSortCriteria(new FilterAndSortCriteria[]{filterAndSortCriteria});

    // Assert
    List<FilterAndSortCriteria> filterAndSortCriteriaList = actualWithFilterAndSortCriteriaResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    List<FilterAndSortCriteria> filterAndSortCriteriaList2 = adornedResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList2.size());
    FilterAndSortCriteria[] filterAndSortCriteria2 = actualWithFilterAndSortCriteriaResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria2.length);
    FilterAndSortCriteria[] filterAndSortCriteria3 = adornedResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria3.length);
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList2.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteria2[0]);
    assertSame(filterAndSortCriteria, filterAndSortCriteria3[0]);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#withFilterAndSortCriteria(FilterAndSortCriteria[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testWithFilterAndSortCriteria_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithFilterAndSortCriteriaResult = adornedResult.withFilterAndSortCriteria(null);

    // Assert
    assertEquals(0, actualWithFilterAndSortCriteriaResult.getFilterAndSortCriteria().length);
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(actualWithFilterAndSortCriteriaResult.filterAndSortCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#withAdornedList(AdornedTargetList)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withAdornedList(AdornedTargetList)}
   */
  @Test
  public void testWithAdornedList() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    AdornedTargetList adornedList = new AdornedTargetList();

    // Act
    PersistencePackageRequest actualWithAdornedListResult = adornedResult.withAdornedList(adornedList);

    // Assert
    assertSame(adornedList, adornedResult.getAdornedList());
    assertSame(adornedResult, actualWithAdornedListResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withMapStructure(MapStructure)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withMapStructure(MapStructure)}
   */
  @Test
  public void testWithMapStructure() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    MapStructure mapStructure = new MapStructure();

    // Act
    PersistencePackageRequest actualWithMapStructureResult = adornedResult.withMapStructure(mapStructure);

    // Assert
    assertSame(mapStructure, adornedResult.getMapStructure());
    assertSame(adornedResult, actualWithMapStructureResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withCustomCriteria(String[])}.
   * <ul>
   *   <li>Then return {@link PersistencePackageRequest#customCriteria} size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withCustomCriteria(String[])}
   */
  @Test
  public void testWithCustomCriteria_thenReturnCustomCriteriaSizeIsOne() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithCustomCriteriaResult = adornedResult
        .withCustomCriteria(new String[]{"Custom Criteria"});

    // Assert
    List<String> stringList = actualWithCustomCriteriaResult.customCriteria;
    assertEquals(1, stringList.size());
    assertEquals("Custom Criteria", stringList.get(0));
    List<String> stringList2 = adornedResult.customCriteria;
    assertEquals(1, stringList2.size());
    assertEquals("Custom Criteria", stringList2.get(0));
    assertArrayEquals(new String[]{"Custom Criteria"}, actualWithCustomCriteriaResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Custom Criteria"}, adornedResult.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackageRequest#withCustomCriteria(String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withCustomCriteria(String[])}
   */
  @Test
  public void testWithCustomCriteria_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithCustomCriteriaResult = adornedResult.withCustomCriteria(null);

    // Assert
    assertEquals(0, actualWithCustomCriteriaResult.getCustomCriteria().length);
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(actualWithCustomCriteriaResult.customCriteria.isEmpty());
    assertTrue(adornedResult.customCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#withEntity(Entity)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withEntity(Entity)}
   */
  @Test
  public void testWithEntity() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    Entity entity = new Entity();

    // Act
    PersistencePackageRequest actualWithEntityResult = adornedResult.withEntity(entity);

    // Assert
    assertSame(entity, adornedResult.getEntity());
    assertSame(adornedResult, actualWithEntityResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withStartIndex(Integer)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withStartIndex(Integer)}
   */
  @Test
  public void testWithStartIndex() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithStartIndexResult = adornedResult.withStartIndex(1);

    // Assert
    assertEquals(1, adornedResult.getStartIndex().intValue());
    assertSame(adornedResult, actualWithStartIndexResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withMaxIndex(Integer)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withMaxIndex(Integer)}
   */
  @Test
  public void testWithMaxIndex() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithMaxIndexResult = adornedResult.withMaxIndex(1);

    // Assert
    assertEquals(1, adornedResult.getMaxIndex().intValue());
    assertSame(adornedResult, actualWithMaxIndexResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withMaxResults(Integer)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withMaxResults(Integer)}
   */
  @Test
  public void testWithMaxResults() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithMaxResultsResult = adornedResult.withMaxResults(3);

    // Assert
    assertEquals(3, adornedResult.getMaxResults().intValue());
    assertSame(adornedResult, actualWithMaxResultsResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withLastId(Long)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withLastId(Long)}
   */
  @Test
  public void testWithLastId() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithLastIdResult = adornedResult.withLastId(1L);

    // Assert
    assertEquals(1L, adornedResult.getLastId().longValue());
    assertSame(adornedResult, actualWithLastIdResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withFirstId(Long)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withFirstId(Long)}
   */
  @Test
  public void testWithFirstId() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithFirstIdResult = adornedResult.withFirstId(1L);

    // Assert
    assertEquals(1L, adornedResult.getFirstId().longValue());
    assertSame(adornedResult, actualWithFirstIdResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withUpperCount(Integer)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withUpperCount(Integer)}
   */
  @Test
  public void testWithUpperCount() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithUpperCountResult = adornedResult.withUpperCount(3);

    // Assert
    assertEquals(3, adornedResult.getUpperCount().intValue());
    assertSame(adornedResult, actualWithUpperCountResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withLowerCount(Integer)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withLowerCount(Integer)}
   */
  @Test
  public void testWithLowerCount() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithLowerCountResult = adornedResult.withLowerCount(3);

    // Assert
    assertEquals(3, adornedResult.getLowerCount().intValue());
    assertSame(adornedResult, actualWithLowerCountResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withPageSize(Integer)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withPageSize(Integer)}
   */
  @Test
  public void testWithPageSize() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithPageSizeResult = adornedResult.withPageSize(3);

    // Assert
    assertEquals(3, adornedResult.getPageSize().intValue());
    assertSame(adornedResult, actualWithPageSizeResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withPresentationFetch(Boolean)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withPresentationFetch(Boolean)}
   */
  @Test
  public void testWithPresentationFetch() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithPresentationFetchResult = adornedResult.withPresentationFetch(true);

    // Assert
    assertTrue(adornedResult.getPresentationFetch());
    assertSame(adornedResult, actualWithPresentationFetchResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withSectionCrumbs(List)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    SectionCrumb[] sectionCrumbs2 = persistencePackageRequest.withSectionCrumbs(sectionCrumbs).getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("Original Section Identifier", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("Section Id", sectionCrumb3.getSectionId());
    assertEquals("Section Identifier", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link PersistencePackageRequest#withSectionCrumbs(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs_thenArrayListSizeIsOne() {
    // Arrange
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualWithSectionCrumbsResult = persistencePackageRequest
        .withSectionCrumbs(sectionCrumbs);

    // Assert
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertEquals(1, sectionCrumbs.size());
    assertSame(persistencePackageRequest, actualWithSectionCrumbsResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withSectionCrumbs(List)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs_thenReturnArrayLengthIsOne() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    SectionCrumb[] sectionCrumbs2 = persistencePackageRequest.withSectionCrumbs(sectionCrumbs).getSectionCrumbs();
    assertEquals(1, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[0]);
  }

  /**
   * Test {@link PersistencePackageRequest#withSectionCrumbs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act and Assert
    assertEquals(0, persistencePackageRequest.withSectionCrumbs(sectionCrumbs).getSectionCrumbs().length);
    assertTrue(sectionCrumbs.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#withSectionEntityField(String)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withSectionEntityField(String)}
   */
  @Test
  public void testWithSectionEntityField() {
    // Arrange and Act
    PersistencePackageRequest actualWithSectionEntityFieldResult = persistencePackageRequest
        .withSectionEntityField("Section Entity Field");

    // Assert
    assertEquals("Section Entity Field", persistencePackageRequest.getSectionEntityField());
    assertSame(persistencePackageRequest, actualWithSectionEntityFieldResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withRequestingEntityName(String)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withRequestingEntityName(String)}
   */
  @Test
  public void testWithRequestingEntityName() {
    // Arrange and Act
    PersistencePackageRequest actualWithRequestingEntityNameResult = persistencePackageRequest
        .withRequestingEntityName("Requesting Entity Name");

    // Assert
    assertEquals("Requesting Entity Name", persistencePackageRequest.getRequestingEntityName());
    assertSame(persistencePackageRequest, actualWithRequestingEntityNameResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withMsg(String)}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#withMsg(String)}
   */
  @Test
  public void testWithMsg() {
    // Arrange and Act
    PersistencePackageRequest actualWithMsgResult = persistencePackageRequest.withMsg("Msg");

    // Assert
    assertEquals("Msg", persistencePackageRequest.getMsg());
    assertSame(persistencePackageRequest, actualWithMsgResult);
  }

  /**
   * Test {@link PersistencePackageRequest#withIsUpdateLookupType(boolean)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#withIsUpdateLookupType(boolean)}
   */
  @Test
  public void testWithIsUpdateLookupType() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithIsUpdateLookupTypeResult = adornedResult.withIsUpdateLookupType(true);

    // Assert
    assertTrue(adornedResult.isUpdateLookupType());
    assertSame(adornedResult, actualWithIsUpdateLookupTypeResult);
  }

  /**
   * Test {@link PersistencePackageRequest#addAdditionalForeignKey(ForeignKey)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addAdditionalForeignKey(ForeignKey)}
   */
  @Test
  public void testAddAdditionalForeignKey() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    ForeignKey foreignKey = new ForeignKey();

    // Act
    PersistencePackageRequest actualAddAdditionalForeignKeyResult = adornedResult.addAdditionalForeignKey(foreignKey);

    // Assert
    List<ForeignKey> foreignKeyList = adornedResult.additionalForeignKeys;
    assertEquals(1, foreignKeyList.size());
    ForeignKey[] additionalForeignKeys = adornedResult.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertSame(foreignKey, foreignKeyList.get(0));
    assertSame(foreignKey, additionalForeignKeys[0]);
    assertSame(adornedResult, actualAddAdditionalForeignKeyResult);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#addSubRequest(String, PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addSubRequest(String, PersistencePackageRequest)}
   */
  @Test
  public void testAddSubRequest() {
    // Arrange, Act and Assert
    assertSame(persistencePackageRequest,
        persistencePackageRequest.addSubRequest("Info Property Name", persistencePackageRequest));
  }

  /**
   * Test {@link PersistencePackageRequest#addCustomCriteria(String[])} with
   * {@code customCriteriaList}.
   * <ul>
   *   <li>Given adorned CustomCriteria is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String[])}
   */
  @Test
  public void testAddCustomCriteriaWithCustomCriteriaList_givenAdornedCustomCriteriaIsNull() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.setCustomCriteria(null);

    // Act
    PersistencePackageRequest actualAddCustomCriteriaResult = adornedResult.addCustomCriteria((String[]) null);

    // Assert
    assertEquals(0, actualAddCustomCriteriaResult.getCustomCriteria().length);
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(actualAddCustomCriteriaResult.customCriteria.isEmpty());
    assertTrue(adornedResult.customCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#addCustomCriteria(String[])} with
   * {@code customCriteriaList}.
   * <ul>
   *   <li>Then return {@link PersistencePackageRequest#customCriteria} size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String[])}
   */
  @Test
  public void testAddCustomCriteriaWithCustomCriteriaList_thenReturnCustomCriteriaSizeIsOne() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualAddCustomCriteriaResult = adornedResult
        .addCustomCriteria(new String[]{"Custom Criteria List"});

    // Assert
    List<String> stringList = actualAddCustomCriteriaResult.customCriteria;
    assertEquals(1, stringList.size());
    assertEquals("Custom Criteria List", stringList.get(0));
    List<String> stringList2 = adornedResult.customCriteria;
    assertEquals(1, stringList2.size());
    assertEquals("Custom Criteria List", stringList2.get(0));
    assertArrayEquals(new String[]{"Custom Criteria List"}, actualAddCustomCriteriaResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Custom Criteria List"}, adornedResult.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackageRequest#addCustomCriteria(String[])} with
   * {@code customCriteriaList}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String[])}
   */
  @Test
  public void testAddCustomCriteriaWithCustomCriteriaList_whenEmptyArrayOfString() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualAddCustomCriteriaResult = adornedResult.addCustomCriteria(new String[]{});

    // Assert
    assertEquals(0, actualAddCustomCriteriaResult.getCustomCriteria().length);
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(actualAddCustomCriteriaResult.customCriteria.isEmpty());
    assertTrue(adornedResult.customCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#addCustomCriteria(String)} with
   * {@code customCriteria}.
   * <ul>
   *   <li>When {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String)}
   */
  @Test
  public void testAddCustomCriteriaWithCustomCriteria_whenCustomCriteria() {
    // Arrange and Act
    persistencePackageRequest.addCustomCriteria("Custom Criteria");

    // Assert
    List<String> stringList = persistencePackageRequest.customCriteria;
    assertEquals(1, stringList.size());
    assertEquals("Custom Criteria", stringList.get(0));
    assertArrayEquals(new String[]{"Custom Criteria"}, persistencePackageRequest.getCustomCriteria());
  }

  /**
   * Test
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria)}
   * with {@code FilterAndSortCriteria}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria)}
   */
  @Test
  public void testAddFilterAndSortCriteriaWithFilterAndSortCriteria() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = adornedResult
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    List<FilterAndSortCriteria> filterAndSortCriteriaList = adornedResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    FilterAndSortCriteria[] filterAndSortCriteria2 = adornedResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria2.length);
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteria2[0]);
    assertSame(adornedResult, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria[])}
   * with {@code FilterAndSortCriteria[]}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testAddFilterAndSortCriteriaWithFilterAndSortCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = adornedResult
        .addFilterAndSortCriteria(new FilterAndSortCriteria[]{filterAndSortCriteria});

    // Assert
    List<FilterAndSortCriteria> filterAndSortCriteriaList = actualAddFilterAndSortCriteriaResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    List<FilterAndSortCriteria> filterAndSortCriteriaList2 = adornedResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList2.size());
    FilterAndSortCriteria[] filterAndSortCriteria2 = actualAddFilterAndSortCriteriaResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria2.length);
    FilterAndSortCriteria[] filterAndSortCriteria3 = adornedResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria3.length);
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList2.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteria2[0]);
    assertSame(filterAndSortCriteria, filterAndSortCriteria3[0]);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria[])}
   * with {@code FilterAndSortCriteria[]}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testAddFilterAndSortCriteriaWithFilterAndSortCriteria3() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = adornedResult
        .addFilterAndSortCriteria((FilterAndSortCriteria[]) null);

    // Assert
    assertEquals(0, actualAddFilterAndSortCriteriaResult.getFilterAndSortCriteria().length);
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(actualAddFilterAndSortCriteriaResult.filterAndSortCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#addFilterAndSortCriteria(List)} with
   * {@code List}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteriaWithList() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();
    FilterAndSortCriteria filterAndSortCriteria2 = new FilterAndSortCriteria("42");
    filterAndSortCriteria.add(filterAndSortCriteria2);

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    assertEquals(1, filterAndSortCriteria.size());
    List<FilterAndSortCriteria> filterAndSortCriteriaList = actualAddFilterAndSortCriteriaResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    List<FilterAndSortCriteria> filterAndSortCriteriaList2 = persistencePackageRequest.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList2.size());
    FilterAndSortCriteria[] filterAndSortCriteria3 = actualAddFilterAndSortCriteriaResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria3.length);
    FilterAndSortCriteria[] filterAndSortCriteria4 = persistencePackageRequest.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria4.length);
    assertSame(filterAndSortCriteria2, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria2, filterAndSortCriteriaList2.get(0));
    assertSame(filterAndSortCriteria2, filterAndSortCriteria3[0]);
    assertSame(filterAndSortCriteria2, filterAndSortCriteria4[0]);
  }

  /**
   * Test {@link PersistencePackageRequest#addFilterAndSortCriteria(List)} with
   * {@code List}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteriaWithList_givenFilterAndSortCriteria() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();
    filterAndSortCriteria.add(mock(FilterAndSortCriteria.class));

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    assertEquals(1, filterAndSortCriteria.size());
    assertEquals(1, actualAddFilterAndSortCriteriaResult.filterAndSortCriteria.size());
    assertEquals(1, persistencePackageRequest.filterAndSortCriteria.size());
    assertEquals(1, actualAddFilterAndSortCriteriaResult.getFilterAndSortCriteria().length);
    assertEquals(1, persistencePackageRequest.getFilterAndSortCriteria().length);
  }

  /**
   * Test {@link PersistencePackageRequest#addFilterAndSortCriteria(List)} with
   * {@code List}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteriaWithList_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();
    filterAndSortCriteria.add(new FilterAndSortCriteria("42"));
    FilterAndSortCriteria filterAndSortCriteria2 = new FilterAndSortCriteria("42");
    filterAndSortCriteria.add(filterAndSortCriteria2);

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    assertEquals(2, filterAndSortCriteria.size());
    List<FilterAndSortCriteria> filterAndSortCriteriaList = actualAddFilterAndSortCriteriaResult.filterAndSortCriteria;
    assertEquals(2, filterAndSortCriteriaList.size());
    List<FilterAndSortCriteria> filterAndSortCriteriaList2 = persistencePackageRequest.filterAndSortCriteria;
    assertEquals(2, filterAndSortCriteriaList2.size());
    FilterAndSortCriteria[] filterAndSortCriteria3 = actualAddFilterAndSortCriteriaResult.getFilterAndSortCriteria();
    assertEquals(2, filterAndSortCriteria3.length);
    FilterAndSortCriteria[] filterAndSortCriteria4 = persistencePackageRequest.getFilterAndSortCriteria();
    assertEquals(2, filterAndSortCriteria4.length);
    assertSame(filterAndSortCriteria2, filterAndSortCriteriaList.get(1));
    assertSame(filterAndSortCriteria2, filterAndSortCriteriaList2.get(1));
    assertSame(filterAndSortCriteria2, filterAndSortCriteria3[1]);
    assertSame(filterAndSortCriteria2, filterAndSortCriteria4[1]);
  }

  /**
   * Test {@link PersistencePackageRequest#addFilterAndSortCriteria(List)} with
   * {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteriaWithList_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    assertEquals(0, actualAddFilterAndSortCriteriaResult.getFilterAndSortCriteria().length);
    assertEquals(0, persistencePackageRequest.getFilterAndSortCriteria().length);
    assertTrue(filterAndSortCriteria.isEmpty());
    assertTrue(actualAddFilterAndSortCriteriaResult.filterAndSortCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#removeFilterAndSortCriteria(String)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#removeFilterAndSortCriteria(String)}
   */
  @Test
  public void testRemoveFilterAndSortCriteria() {
    // Arrange, Act and Assert
    assertSame(persistencePackageRequest, persistencePackageRequest.removeFilterAndSortCriteria("Name"));
  }

  /**
   * Test {@link PersistencePackageRequest#clearFilterAndSortCriteria()}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#clearFilterAndSortCriteria()}
   */
  @Test
  public void testClearFilterAndSortCriteria() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    PersistencePackageRequest actualClearFilterAndSortCriteriaResult = adornedResult.clearFilterAndSortCriteria();

    // Assert
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualClearFilterAndSortCriteriaResult);
  }

  /**
   * Test {@link PersistencePackageRequest#clearFilterAndSortCriteria()}.
   * <ul>
   *   <li>Given adorned.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#clearFilterAndSortCriteria()}
   */
  @Test
  public void testClearFilterAndSortCriteria_givenAdorned() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualClearFilterAndSortCriteriaResult = adornedResult.clearFilterAndSortCriteria();

    // Assert
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualClearFilterAndSortCriteriaResult);
  }

  /**
   * Test {@link PersistencePackageRequest#hasSortCriteria()}.
   * <ul>
   *   <li>Given adorned.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageRequest#hasSortCriteria()}
   */
  @Test
  public void testHasSortCriteria_givenAdorned_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PersistencePackageRequest.adorned().hasSortCriteria());
  }

  /**
   * Test {@link PersistencePackageRequest#hasSortCriteria()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageRequest#hasSortCriteria()}
   */
  @Test
  public void testHasSortCriteria_thenReturnFalse() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act and Assert
    assertFalse(adornedResult.hasSortCriteria());
  }

  /**
   * Test {@link PersistencePackageRequest#hasSortCriteria()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageRequest#hasSortCriteria()}
   */
  @Test
  public void testHasSortCriteria_thenReturnTrue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(true);
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.addFilterAndSortCriteria(filterAndSortCriteria);

    // Act and Assert
    assertTrue(adornedResult.hasSortCriteria());
  }

  /**
   * Test {@link PersistencePackageRequest#getCustomCriteria()}.
   * <p>
   * Method under test: {@link PersistencePackageRequest#getCustomCriteria()}
   */
  @Test
  public void testGetCustomCriteria() {
    // Arrange, Act and Assert
    assertEquals(0, PersistencePackageRequest.adorned().getCustomCriteria().length);
  }

  /**
   * Test {@link PersistencePackageRequest#getAdditionalForeignKeys()}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#getAdditionalForeignKeys()}
   */
  @Test
  public void testGetAdditionalForeignKeys() {
    // Arrange, Act and Assert
    assertEquals(0, PersistencePackageRequest.adorned().getAdditionalForeignKeys().length);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#setAdditionalForeignKeys(ForeignKey[])}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#setAdditionalForeignKeys(ForeignKey[])}
   */
  @Test
  public void testSetAdditionalForeignKeys() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    ForeignKey foreignKey = new ForeignKey();

    // Act
    adornedResult.setAdditionalForeignKeys(new ForeignKey[]{foreignKey});

    // Assert
    List<ForeignKey> foreignKeyList = adornedResult.additionalForeignKeys;
    assertEquals(1, foreignKeyList.size());
    ForeignKey[] additionalForeignKeys = adornedResult.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertSame(foreignKey, foreignKeyList.get(0));
    assertSame(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link PersistencePackageRequest#setCustomCriteria(String[])}.
   * <ul>
   *   <li>Then adorned {@link PersistencePackageRequest#customCriteria} size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#setCustomCriteria(String[])}
   */
  @Test
  public void testSetCustomCriteria_thenAdornedCustomCriteriaSizeIsOne() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    adornedResult.setCustomCriteria(new String[]{"Custom Criteria"});

    // Assert
    List<String> stringList = adornedResult.customCriteria;
    assertEquals(1, stringList.size());
    assertEquals("Custom Criteria", stringList.get(0));
    assertArrayEquals(new String[]{"Custom Criteria"}, adornedResult.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackageRequest#setCustomCriteria(String[])}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#setCustomCriteria(String[])}
   */
  @Test
  public void testSetCustomCriteria_whenEmptyArrayOfString_thenArrayLengthIsZero() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    adornedResult.setCustomCriteria(new String[]{});

    // Assert
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#setCustomCriteria(String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#setCustomCriteria(String[])}
   */
  @Test
  public void testSetCustomCriteria_whenNull_thenArrayLengthIsZero() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    adornedResult.setCustomCriteria(null);

    // Assert
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
  }

  /**
   * Test {@link PersistencePackageRequest#getFilterAndSortCriteria()}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#getFilterAndSortCriteria()}
   */
  @Test
  public void testGetFilterAndSortCriteria() {
    // Arrange, Act and Assert
    assertEquals(0, PersistencePackageRequest.adorned().getFilterAndSortCriteria().length);
  }

  /**
   * Test
   * {@link PersistencePackageRequest#setFilterAndSortCriteria(FilterAndSortCriteria[])}.
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#setFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testSetFilterAndSortCriteria() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    adornedResult.setFilterAndSortCriteria(new FilterAndSortCriteria[]{filterAndSortCriteria});

    // Assert
    List<FilterAndSortCriteria> filterAndSortCriteriaList = adornedResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    FilterAndSortCriteria[] filterAndSortCriteria2 = adornedResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria2.length);
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteria2[0]);
  }

  /**
   * Test {@link PersistencePackageRequest#getSecurityCeilingEntityClassname()}.
   * <ul>
   *   <li>Given adorned.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#getSecurityCeilingEntityClassname()}
   */
  @Test
  public void testGetSecurityCeilingEntityClassname_givenAdorned_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PersistencePackageRequest.adorned().getSecurityCeilingEntityClassname());
  }

  /**
   * Test {@link PersistencePackageRequest#getSecurityCeilingEntityClassname()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageRequest#getSecurityCeilingEntityClassname()}
   */
  @Test
  public void testGetSecurityCeilingEntityClassname_thenReturnFoo() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.setSecurityCeilingEntityClassname("foo");

    // Act and Assert
    assertEquals("foo", adornedResult.getSecurityCeilingEntityClassname());
  }
}
