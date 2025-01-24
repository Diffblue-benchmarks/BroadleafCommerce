package org.broadleafcommerce.openadmin.server.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.junit.Test;

public class PersistencePackageRequestDiffblueTest {
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
}
