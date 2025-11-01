/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    md.setPersistencePerspective(new PersistencePerspective());

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
    assertEquals(0, actualFromMetadataResult.getAdditionalForeignKeys().length);
    assertEquals(0, actualFromMetadataResult.getCustomCriteria().length);
    assertEquals(0, actualFromMetadataResult.getFilterAndSortCriteria().length);
    assertEquals(0, actualFromMetadataResult.getSectionCrumbs().length);
    OperationTypes operationTypesOverride = actualFromMetadataResult.getOperationTypesOverride();
    assertEquals(OperationType.BASIC, operationTypesOverride.getAddType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getFetchType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getInspectType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypesOverride.getUpdateType());
    assertEquals(PersistencePackageRequest.Type.ADORNED, actualFromMetadataResult.getType());
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
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata2() {
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
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata3() {
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
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata4() {
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
    SectionCrumb[] sectionCrumbs2 = actualFromMetadataResult.getSectionCrumbs();
    assertEquals(1, sectionCrumbs2.length);
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
    assertSame(sectionCrumb, sectionCrumbs2[0]);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#fromMetadata(FieldMetadata, List)}
   */
  @Test
  public void testFromMetadata5() {
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
    SectionCrumb[] sectionCrumbs2 = actualFromMetadataResult.getSectionCrumbs();
    assertEquals(2, sectionCrumbs2.length);
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
    assertSame(sectionCrumb2, sectionCrumbs2[0]);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithTypeResult);
  }

  /**
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
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithCeilingEntityClassnameResult);
  }

  /**
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
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithSecurityCeilingEntityClassnameResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(foreignKey, adornedResult.getForeignKey());
    assertSame(adornedResult, actualWithForeignKeyResult);
  }

  /**
   * Method under test: {@link PersistencePackageRequest#withConfigKey(String)}
   */
  @Test
  public void testWithConfigKey() {
    // Arrange and Act
    PersistencePackageRequest actualWithConfigKeyResult = persistencePackageRequest.withConfigKey("Config Key");

    // Assert
    assertEquals("Config Key", persistencePackageRequest.getConfigKey());
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithConfigKeyResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#withFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testWithFilterAndSortCriteria() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    PersistencePackageRequest actualWithFilterAndSortCriteriaResult = adornedResult
        .withFilterAndSortCriteria(new FilterAndSortCriteria[]{filterAndSortCriteria});

    // Assert
    List<FilterAndSortCriteria> filterAndSortCriteriaList = adornedResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    FilterAndSortCriteria[] filterAndSortCriteria2 = adornedResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria2.length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteria2[0]);
    assertSame(adornedResult, actualWithFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#withFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testWithFilterAndSortCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithFilterAndSortCriteriaResult = adornedResult.withFilterAndSortCriteria(null);

    // Assert
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithFilterAndSortCriteriaResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedList, adornedResult.getAdornedList());
    assertSame(adornedResult, actualWithAdornedListResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(mapStructure, adornedResult.getMapStructure());
    assertSame(adornedResult, actualWithMapStructureResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#withCustomCriteria(String[])}
   */
  @Test
  public void testWithCustomCriteria() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithCustomCriteriaResult = adornedResult
        .withCustomCriteria(new String[]{"Custom Criteria"});

    // Assert
    List<String> stringList = adornedResult.customCriteria;
    assertEquals(1, stringList.size());
    assertEquals("Custom Criteria", stringList.get(0));
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithCustomCriteriaResult);
    assertArrayEquals(new String[]{"Custom Criteria"}, adornedResult.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#withCustomCriteria(String[])}
   */
  @Test
  public void testWithCustomCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualWithCustomCriteriaResult = adornedResult.withCustomCriteria(null);

    // Assert
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithCustomCriteriaResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(entity, adornedResult.getEntity());
    assertSame(adornedResult, actualWithEntityResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithStartIndexResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithMaxIndexResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithMaxResultsResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithLastIdResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithFirstIdResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithUpperCountResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithLowerCountResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualWithPageSizeResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertTrue(adornedResult.getPresentationFetch());
    assertSame(adornedResult, actualWithPresentationFetchResult);
  }

  /**
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualWithSectionCrumbsResult = persistencePackageRequest
        .withSectionCrumbs(sectionCrumbs);

    // Assert
    assertTrue(sectionCrumbs.isEmpty());
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithSectionCrumbsResult);
  }

  /**
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs2() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualWithSectionCrumbsResult = persistencePackageRequest
        .withSectionCrumbs(sectionCrumbs);

    // Assert
    assertEquals(1, sectionCrumbs.size());
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithSectionCrumbsResult);
  }

  /**
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs3() {
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

    // Act
    PersistencePackageRequest actualWithSectionCrumbsResult = persistencePackageRequest
        .withSectionCrumbs(sectionCrumbs);

    // Assert
    assertEquals(2, sectionCrumbs.size());
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithSectionCrumbsResult);
  }

  /**
   * Method under test: {@link PersistencePackageRequest#withSectionCrumbs(List)}
   */
  @Test
  public void testWithSectionCrumbs4() {
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
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithSectionCrumbsResult);
  }

  /**
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
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithSectionEntityFieldResult);
  }

  /**
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
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithRequestingEntityNameResult);
  }

  /**
   * Method under test: {@link PersistencePackageRequest#withMsg(String)}
   */
  @Test
  public void testWithMsg() {
    // Arrange and Act
    PersistencePackageRequest actualWithMsgResult = persistencePackageRequest.withMsg("Msg");

    // Assert
    assertEquals("Msg", persistencePackageRequest.getMsg());
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualWithMsgResult);
  }

  /**
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
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertTrue(adornedResult.isUpdateLookupType());
    assertSame(adornedResult, actualWithIsUpdateLookupTypeResult);
  }

  /**
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
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(foreignKey, foreignKeyList.get(0));
    assertSame(foreignKey, additionalForeignKeys[0]);
    assertSame(adornedResult, actualAddAdditionalForeignKeyResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addSubRequest(String, PersistencePackageRequest)}
   */
  @Test
  public void testAddSubRequest() {
    // Arrange and Act
    PersistencePackageRequest actualAddSubRequestResult = persistencePackageRequest.addSubRequest("Info Property Name",
        persistencePackageRequest);

    // Assert
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualAddSubRequestResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String[])}
   */
  @Test
  public void testAddCustomCriteria() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualAddCustomCriteriaResult = adornedResult
        .addCustomCriteria(new String[]{"Custom Criteria List"});

    // Assert
    List<String> stringList = adornedResult.customCriteria;
    assertEquals(1, stringList.size());
    assertEquals("Custom Criteria List", stringList.get(0));
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualAddCustomCriteriaResult);
    assertArrayEquals(new String[]{"Custom Criteria List"}, adornedResult.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String[])}
   */
  @Test
  public void testAddCustomCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.setCustomCriteria(null);

    // Act
    PersistencePackageRequest actualAddCustomCriteriaResult = adornedResult.addCustomCriteria((String[]) null);

    // Assert
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualAddCustomCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String[])}
   */
  @Test
  public void testAddCustomCriteria3() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualAddCustomCriteriaResult = adornedResult.addCustomCriteria(new String[]{});

    // Assert
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualAddCustomCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addCustomCriteria(String)}
   */
  @Test
  public void testAddCustomCriteria4() {
    // Arrange and Act
    PersistencePackageRequest actualAddCustomCriteriaResult = persistencePackageRequest
        .addCustomCriteria("Custom Criteria");

    // Assert
    List<String> stringList = persistencePackageRequest.customCriteria;
    assertEquals(1, stringList.size());
    assertEquals("Custom Criteria", stringList.get(0));
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualAddCustomCriteriaResult);
    assertArrayEquals(new String[]{"Custom Criteria"}, persistencePackageRequest.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria)}
   */
  @Test
  public void testAddFilterAndSortCriteria() {
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
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteria2[0]);
    assertSame(adornedResult, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testAddFilterAndSortCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = adornedResult
        .addFilterAndSortCriteria(new FilterAndSortCriteria[]{filterAndSortCriteria});

    // Assert
    List<FilterAndSortCriteria> filterAndSortCriteriaList = adornedResult.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    FilterAndSortCriteria[] filterAndSortCriteria2 = adornedResult.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria2.length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertSame(filterAndSortCriteria, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria, filterAndSortCriteria2[0]);
    assertSame(adornedResult, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria[])}
   */
  @Test
  public void testAddFilterAndSortCriteria3() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = adornedResult
        .addFilterAndSortCriteria((FilterAndSortCriteria[]) null);

    // Assert
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteria4() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    assertEquals(0, persistencePackageRequest.getFilterAndSortCriteria().length);
    assertTrue(filterAndSortCriteria.isEmpty());
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteria5() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();
    FilterAndSortCriteria filterAndSortCriteria2 = new FilterAndSortCriteria("42");
    filterAndSortCriteria.add(filterAndSortCriteria2);

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    assertEquals(1, filterAndSortCriteria.size());
    List<FilterAndSortCriteria> filterAndSortCriteriaList = persistencePackageRequest.filterAndSortCriteria;
    assertEquals(1, filterAndSortCriteriaList.size());
    FilterAndSortCriteria[] filterAndSortCriteria3 = persistencePackageRequest.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria3.length);
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertSame(filterAndSortCriteria2, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria2, filterAndSortCriteria3[0]);
    assertSame(persistencePackageRequest, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteria6() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();
    FilterAndSortCriteria filterAndSortCriteria2 = new FilterAndSortCriteria("42");
    filterAndSortCriteria.add(filterAndSortCriteria2);
    FilterAndSortCriteria filterAndSortCriteria3 = new FilterAndSortCriteria("42");
    filterAndSortCriteria.add(filterAndSortCriteria3);

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    List<FilterAndSortCriteria> filterAndSortCriteriaList = persistencePackageRequest.filterAndSortCriteria;
    assertEquals(2, filterAndSortCriteriaList.size());
    FilterAndSortCriteria[] filterAndSortCriteria4 = persistencePackageRequest.getFilterAndSortCriteria();
    assertEquals(2, filterAndSortCriteria4.length);
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertEquals(actualAddFilterAndSortCriteriaResult.filterAndSortCriteria, filterAndSortCriteria);
    assertSame(filterAndSortCriteria2, filterAndSortCriteriaList.get(0));
    assertSame(filterAndSortCriteria3, filterAndSortCriteriaList.get(1));
    assertSame(filterAndSortCriteria2, filterAndSortCriteria4[0]);
    assertSame(filterAndSortCriteria3, filterAndSortCriteria4[1]);
    assertSame(persistencePackageRequest, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#addFilterAndSortCriteria(List)}
   */
  @Test
  public void testAddFilterAndSortCriteria7() {
    // Arrange
    ArrayList<FilterAndSortCriteria> filterAndSortCriteria = new ArrayList<>();
    filterAndSortCriteria.add(mock(FilterAndSortCriteria.class));

    // Act
    PersistencePackageRequest actualAddFilterAndSortCriteriaResult = persistencePackageRequest
        .addFilterAndSortCriteria(filterAndSortCriteria);

    // Assert
    assertEquals(1, filterAndSortCriteria.size());
    assertEquals(1, persistencePackageRequest.filterAndSortCriteria.size());
    assertEquals(1, persistencePackageRequest.getFilterAndSortCriteria().length);
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualAddFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#removeFilterAndSortCriteria(String)}
   */
  @Test
  public void testRemoveFilterAndSortCriteria() {
    // Arrange and Act
    PersistencePackageRequest actualRemoveFilterAndSortCriteriaResult = persistencePackageRequest
        .removeFilterAndSortCriteria("Name");

    // Assert
    assertTrue(persistencePackageRequest.customCriteria.isEmpty());
    assertTrue(persistencePackageRequest.filterAndSortCriteria.isEmpty());
    assertSame(persistencePackageRequest, actualRemoveFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#clearFilterAndSortCriteria()}
   */
  @Test
  public void testClearFilterAndSortCriteria() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    PersistencePackageRequest actualClearFilterAndSortCriteriaResult = adornedResult.clearFilterAndSortCriteria();

    // Assert
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualClearFilterAndSortCriteriaResult);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#clearFilterAndSortCriteria()}
   */
  @Test
  public void testClearFilterAndSortCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    PersistencePackageRequest actualClearFilterAndSortCriteriaResult = adornedResult.clearFilterAndSortCriteria();

    // Assert
    assertEquals(0, adornedResult.getFilterAndSortCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(adornedResult, actualClearFilterAndSortCriteriaResult);
  }

  /**
   * Method under test: {@link PersistencePackageRequest#hasSortCriteria()}
   */
  @Test
  public void testHasSortCriteria() {
    // Arrange, Act and Assert
    assertFalse(PersistencePackageRequest.adorned().hasSortCriteria());
  }

  /**
   * Method under test: {@link PersistencePackageRequest#hasSortCriteria()}
   */
  @Test
  public void testHasSortCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act and Assert
    assertFalse(adornedResult.hasSortCriteria());
  }

  /**
   * Method under test: {@link PersistencePackageRequest#hasSortCriteria()}
   */
  @Test
  public void testHasSortCriteria3() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(true);
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.addFilterAndSortCriteria(filterAndSortCriteria);

    // Act and Assert
    assertTrue(adornedResult.hasSortCriteria());
  }

  /**
   * Method under test: {@link PersistencePackageRequest#getCustomCriteria()}
   */
  @Test
  public void testGetCustomCriteria() {
    // Arrange, Act and Assert
    assertEquals(0, PersistencePackageRequest.adorned().getCustomCriteria().length);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#getAdditionalForeignKeys()}
   */
  @Test
  public void testGetAdditionalForeignKeys() {
    // Arrange, Act and Assert
    assertEquals(0, PersistencePackageRequest.adorned().getAdditionalForeignKeys().length);
  }

  /**
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
    assertTrue(adornedResult.filterAndSortCriteria.isEmpty());
    assertSame(foreignKey, foreignKeyList.get(0));
    assertSame(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#setCustomCriteria(String[])}
   */
  @Test
  public void testSetCustomCriteria() {
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
   * Method under test:
   * {@link PersistencePackageRequest#setCustomCriteria(String[])}
   */
  @Test
  public void testSetCustomCriteria2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    adornedResult.setCustomCriteria(null);

    // Assert
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#setCustomCriteria(String[])}
   */
  @Test
  public void testSetCustomCriteria3() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();

    // Act
    adornedResult.setCustomCriteria(new String[]{});

    // Assert
    assertEquals(0, adornedResult.getCustomCriteria().length);
    assertTrue(adornedResult.customCriteria.isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#getFilterAndSortCriteria()}
   */
  @Test
  public void testGetFilterAndSortCriteria() {
    // Arrange, Act and Assert
    assertEquals(0, PersistencePackageRequest.adorned().getFilterAndSortCriteria().length);
  }

  /**
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
   * Method under test:
   * {@link PersistencePackageRequest#getSecurityCeilingEntityClassname()}
   */
  @Test
  public void testGetSecurityCeilingEntityClassname() {
    // Arrange, Act and Assert
    assertNull(PersistencePackageRequest.adorned().getSecurityCeilingEntityClassname());
  }

  /**
   * Method under test:
   * {@link PersistencePackageRequest#getSecurityCeilingEntityClassname()}
   */
  @Test
  public void testGetSecurityCeilingEntityClassname2() {
    // Arrange
    PersistencePackageRequest adornedResult = PersistencePackageRequest.adorned();
    adornedResult.setSecurityCeilingEntityClassname("foo");

    // Act and Assert
    assertEquals("foo", adornedResult.getSecurityCeilingEntityClassname());
  }

  /**
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
  public void testGettersAndSetters2() {
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
}
