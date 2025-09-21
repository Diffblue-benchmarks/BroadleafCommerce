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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.type.FetchType;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DynamicResultSetDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicResultSet#DynamicResultSet()}
   *   <li>{@link DynamicResultSet#setBatchId(Integer)}
   *   <li>{@link DynamicResultSet#setClassMetaData(ClassMetadata)}
   *   <li>{@link DynamicResultSet#setFetchType(FetchType)}
   *   <li>{@link DynamicResultSet#setFirstId(Long)}
   *   <li>{@link DynamicResultSet#setLastId(Long)}
   *   <li>{@link DynamicResultSet#setLowerCount(Integer)}
   *   <li>{@link DynamicResultSet#setPageSize(Integer)}
   *   <li>{@link DynamicResultSet#setPromptSearch(Boolean)}
   *   <li>{@link DynamicResultSet#setRecords(Entity[])}
   *   <li>{@link DynamicResultSet#setStartIndex(Integer)}
   *   <li>{@link DynamicResultSet#setTotalCountLessThanPageSize(Boolean)}
   *   <li>{@link DynamicResultSet#setTotalRecords(Integer)}
   *   <li>{@link DynamicResultSet#setUnselectedTabMetadata(Map)}
   *   <li>{@link DynamicResultSet#setUpperCount(Integer)}
   *   <li>{@link DynamicResultSet#getBatchId()}
   *   <li>{@link DynamicResultSet#getClassMetaData()}
   *   <li>{@link DynamicResultSet#getFetchType()}
   *   <li>{@link DynamicResultSet#getFirstId()}
   *   <li>{@link DynamicResultSet#getLastId()}
   *   <li>{@link DynamicResultSet#getLowerCount()}
   *   <li>{@link DynamicResultSet#getPromptSearch()}
   *   <li>{@link DynamicResultSet#getTotalCountLessThanPageSize()}
   *   <li>{@link DynamicResultSet#getUnselectedTabMetadata()}
   *   <li>{@link DynamicResultSet#getUpperCount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicResultSet.<init>()",
    "void DynamicResultSet.<init>(ClassMetadata)",
    "void DynamicResultSet.<init>(ClassMetadata, Entity[], Integer)",
    "void DynamicResultSet.<init>(Entity[], Integer)",
    "Integer DynamicResultSet.getBatchId()",
    "ClassMetadata DynamicResultSet.getClassMetaData()",
    "FetchType DynamicResultSet.getFetchType()",
    "Long DynamicResultSet.getFirstId()",
    "Long DynamicResultSet.getLastId()",
    "Integer DynamicResultSet.getLowerCount()",
    "Boolean DynamicResultSet.getPromptSearch()",
    "Boolean DynamicResultSet.getTotalCountLessThanPageSize()",
    "Map DynamicResultSet.getUnselectedTabMetadata()",
    "Integer DynamicResultSet.getUpperCount()",
    "void DynamicResultSet.setBatchId(Integer)",
    "void DynamicResultSet.setClassMetaData(ClassMetadata)",
    "void DynamicResultSet.setFetchType(FetchType)",
    "void DynamicResultSet.setFirstId(Long)",
    "void DynamicResultSet.setLastId(Long)",
    "void DynamicResultSet.setLowerCount(Integer)",
    "void DynamicResultSet.setPageSize(Integer)",
    "void DynamicResultSet.setPromptSearch(Boolean)",
    "void DynamicResultSet.setRecords(Entity[])",
    "void DynamicResultSet.setStartIndex(Integer)",
    "void DynamicResultSet.setTotalCountLessThanPageSize(Boolean)",
    "void DynamicResultSet.setTotalRecords(Integer)",
    "void DynamicResultSet.setUnselectedTabMetadata(Map)",
    "void DynamicResultSet.setUpperCount(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet();
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[] {new Entity()});
    actualDynamicResultSet.setStartIndex(1);
    actualDynamicResultSet.setTotalCountLessThanPageSize(true);
    actualDynamicResultSet.setTotalRecords(1);
    HashMap<String, Tab> unselectedTabMetadata = new HashMap<>();
    actualDynamicResultSet.setUnselectedTabMetadata(unselectedTabMetadata);
    actualDynamicResultSet.setUpperCount(3);
    Integer actualBatchId = actualDynamicResultSet.getBatchId();
    ClassMetadata actualClassMetaData = actualDynamicResultSet.getClassMetaData();
    FetchType actualFetchType = actualDynamicResultSet.getFetchType();
    Long actualFirstId = actualDynamicResultSet.getFirstId();
    Long actualLastId = actualDynamicResultSet.getLastId();
    Integer actualLowerCount = actualDynamicResultSet.getLowerCount();
    Boolean actualPromptSearch = actualDynamicResultSet.getPromptSearch();
    Boolean actualTotalCountLessThanPageSize =
        actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata =
        actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert
    assertEquals(1, actualBatchId.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualUpperCount.intValue());
    assertEquals(FetchType.LARGERESULTSET, actualFetchType);
    assertTrue(actualUnselectedTabMetadata.isEmpty());
    assertTrue(actualPromptSearch);
    assertTrue(actualTotalCountLessThanPageSize);
    assertSame(unselectedTabMetadata, actualUnselectedTabMetadata);
    assertSame(classMetaData, actualClassMetaData);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicResultSet#DynamicResultSet(ClassMetadata)}
   *   <li>{@link DynamicResultSet#setBatchId(Integer)}
   *   <li>{@link DynamicResultSet#setClassMetaData(ClassMetadata)}
   *   <li>{@link DynamicResultSet#setFetchType(FetchType)}
   *   <li>{@link DynamicResultSet#setFirstId(Long)}
   *   <li>{@link DynamicResultSet#setLastId(Long)}
   *   <li>{@link DynamicResultSet#setLowerCount(Integer)}
   *   <li>{@link DynamicResultSet#setPageSize(Integer)}
   *   <li>{@link DynamicResultSet#setPromptSearch(Boolean)}
   *   <li>{@link DynamicResultSet#setRecords(Entity[])}
   *   <li>{@link DynamicResultSet#setStartIndex(Integer)}
   *   <li>{@link DynamicResultSet#setTotalCountLessThanPageSize(Boolean)}
   *   <li>{@link DynamicResultSet#setTotalRecords(Integer)}
   *   <li>{@link DynamicResultSet#setUnselectedTabMetadata(Map)}
   *   <li>{@link DynamicResultSet#setUpperCount(Integer)}
   *   <li>{@link DynamicResultSet#getBatchId()}
   *   <li>{@link DynamicResultSet#getClassMetaData()}
   *   <li>{@link DynamicResultSet#getFetchType()}
   *   <li>{@link DynamicResultSet#getFirstId()}
   *   <li>{@link DynamicResultSet#getLastId()}
   *   <li>{@link DynamicResultSet#getLowerCount()}
   *   <li>{@link DynamicResultSet#getPromptSearch()}
   *   <li>{@link DynamicResultSet#getTotalCountLessThanPageSize()}
   *   <li>{@link DynamicResultSet#getUnselectedTabMetadata()}
   *   <li>{@link DynamicResultSet#getUpperCount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicResultSet.<init>()",
    "void DynamicResultSet.<init>(ClassMetadata)",
    "void DynamicResultSet.<init>(ClassMetadata, Entity[], Integer)",
    "void DynamicResultSet.<init>(Entity[], Integer)",
    "Integer DynamicResultSet.getBatchId()",
    "ClassMetadata DynamicResultSet.getClassMetaData()",
    "FetchType DynamicResultSet.getFetchType()",
    "Long DynamicResultSet.getFirstId()",
    "Long DynamicResultSet.getLastId()",
    "Integer DynamicResultSet.getLowerCount()",
    "Boolean DynamicResultSet.getPromptSearch()",
    "Boolean DynamicResultSet.getTotalCountLessThanPageSize()",
    "Map DynamicResultSet.getUnselectedTabMetadata()",
    "Integer DynamicResultSet.getUpperCount()",
    "void DynamicResultSet.setBatchId(Integer)",
    "void DynamicResultSet.setClassMetaData(ClassMetadata)",
    "void DynamicResultSet.setFetchType(FetchType)",
    "void DynamicResultSet.setFirstId(Long)",
    "void DynamicResultSet.setLastId(Long)",
    "void DynamicResultSet.setLowerCount(Integer)",
    "void DynamicResultSet.setPageSize(Integer)",
    "void DynamicResultSet.setPromptSearch(Boolean)",
    "void DynamicResultSet.setRecords(Entity[])",
    "void DynamicResultSet.setStartIndex(Integer)",
    "void DynamicResultSet.setTotalCountLessThanPageSize(Boolean)",
    "void DynamicResultSet.setTotalRecords(Integer)",
    "void DynamicResultSet.setUnselectedTabMetadata(Map)",
    "void DynamicResultSet.setUpperCount(Integer)"
  })
  public void testGettersAndSetters_givenType_whenClassMetadataCeilingTypeIsType() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    // Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet(classMetaData);
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData2);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[] {new Entity()});
    actualDynamicResultSet.setStartIndex(1);
    actualDynamicResultSet.setTotalCountLessThanPageSize(true);
    actualDynamicResultSet.setTotalRecords(1);
    HashMap<String, Tab> unselectedTabMetadata = new HashMap<>();
    actualDynamicResultSet.setUnselectedTabMetadata(unselectedTabMetadata);
    actualDynamicResultSet.setUpperCount(3);
    Integer actualBatchId = actualDynamicResultSet.getBatchId();
    ClassMetadata actualClassMetaData = actualDynamicResultSet.getClassMetaData();
    FetchType actualFetchType = actualDynamicResultSet.getFetchType();
    Long actualFirstId = actualDynamicResultSet.getFirstId();
    Long actualLastId = actualDynamicResultSet.getLastId();
    Integer actualLowerCount = actualDynamicResultSet.getLowerCount();
    Boolean actualPromptSearch = actualDynamicResultSet.getPromptSearch();
    Boolean actualTotalCountLessThanPageSize =
        actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata =
        actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert
    assertEquals(1, actualBatchId.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualUpperCount.intValue());
    assertEquals(FetchType.LARGERESULTSET, actualFetchType);
    assertTrue(actualUnselectedTabMetadata.isEmpty());
    assertTrue(actualPromptSearch);
    assertTrue(actualTotalCountLessThanPageSize);
    assertSame(unselectedTabMetadata, actualUnselectedTabMetadata);
    assertSame(classMetaData2, actualClassMetaData);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicResultSet#DynamicResultSet(ClassMetadata, Entity[], Integer)}
   *   <li>{@link DynamicResultSet#setBatchId(Integer)}
   *   <li>{@link DynamicResultSet#setClassMetaData(ClassMetadata)}
   *   <li>{@link DynamicResultSet#setFetchType(FetchType)}
   *   <li>{@link DynamicResultSet#setFirstId(Long)}
   *   <li>{@link DynamicResultSet#setLastId(Long)}
   *   <li>{@link DynamicResultSet#setLowerCount(Integer)}
   *   <li>{@link DynamicResultSet#setPageSize(Integer)}
   *   <li>{@link DynamicResultSet#setPromptSearch(Boolean)}
   *   <li>{@link DynamicResultSet#setRecords(Entity[])}
   *   <li>{@link DynamicResultSet#setStartIndex(Integer)}
   *   <li>{@link DynamicResultSet#setTotalCountLessThanPageSize(Boolean)}
   *   <li>{@link DynamicResultSet#setTotalRecords(Integer)}
   *   <li>{@link DynamicResultSet#setUnselectedTabMetadata(Map)}
   *   <li>{@link DynamicResultSet#setUpperCount(Integer)}
   *   <li>{@link DynamicResultSet#getBatchId()}
   *   <li>{@link DynamicResultSet#getClassMetaData()}
   *   <li>{@link DynamicResultSet#getFetchType()}
   *   <li>{@link DynamicResultSet#getFirstId()}
   *   <li>{@link DynamicResultSet#getLastId()}
   *   <li>{@link DynamicResultSet#getLowerCount()}
   *   <li>{@link DynamicResultSet#getPromptSearch()}
   *   <li>{@link DynamicResultSet#getTotalCountLessThanPageSize()}
   *   <li>{@link DynamicResultSet#getUnselectedTabMetadata()}
   *   <li>{@link DynamicResultSet#getUpperCount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicResultSet.<init>()",
    "void DynamicResultSet.<init>(ClassMetadata)",
    "void DynamicResultSet.<init>(ClassMetadata, Entity[], Integer)",
    "void DynamicResultSet.<init>(Entity[], Integer)",
    "Integer DynamicResultSet.getBatchId()",
    "ClassMetadata DynamicResultSet.getClassMetaData()",
    "FetchType DynamicResultSet.getFetchType()",
    "Long DynamicResultSet.getFirstId()",
    "Long DynamicResultSet.getLastId()",
    "Integer DynamicResultSet.getLowerCount()",
    "Boolean DynamicResultSet.getPromptSearch()",
    "Boolean DynamicResultSet.getTotalCountLessThanPageSize()",
    "Map DynamicResultSet.getUnselectedTabMetadata()",
    "Integer DynamicResultSet.getUpperCount()",
    "void DynamicResultSet.setBatchId(Integer)",
    "void DynamicResultSet.setClassMetaData(ClassMetadata)",
    "void DynamicResultSet.setFetchType(FetchType)",
    "void DynamicResultSet.setFirstId(Long)",
    "void DynamicResultSet.setLastId(Long)",
    "void DynamicResultSet.setLowerCount(Integer)",
    "void DynamicResultSet.setPageSize(Integer)",
    "void DynamicResultSet.setPromptSearch(Boolean)",
    "void DynamicResultSet.setRecords(Entity[])",
    "void DynamicResultSet.setStartIndex(Integer)",
    "void DynamicResultSet.setTotalCountLessThanPageSize(Boolean)",
    "void DynamicResultSet.setTotalRecords(Integer)",
    "void DynamicResultSet.setUnselectedTabMetadata(Map)",
    "void DynamicResultSet.setUpperCount(Integer)"
  })
  public void testGettersAndSetters_givenType_whenClassMetadataCeilingTypeIsType2() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    Entity[] records = new Entity[] {new Entity()};

    // Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet(classMetaData, records, 1);
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData2);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[] {new Entity()});
    actualDynamicResultSet.setStartIndex(1);
    actualDynamicResultSet.setTotalCountLessThanPageSize(true);
    actualDynamicResultSet.setTotalRecords(1);
    HashMap<String, Tab> unselectedTabMetadata = new HashMap<>();
    actualDynamicResultSet.setUnselectedTabMetadata(unselectedTabMetadata);
    actualDynamicResultSet.setUpperCount(3);
    Integer actualBatchId = actualDynamicResultSet.getBatchId();
    ClassMetadata actualClassMetaData = actualDynamicResultSet.getClassMetaData();
    FetchType actualFetchType = actualDynamicResultSet.getFetchType();
    Long actualFirstId = actualDynamicResultSet.getFirstId();
    Long actualLastId = actualDynamicResultSet.getLastId();
    Integer actualLowerCount = actualDynamicResultSet.getLowerCount();
    Boolean actualPromptSearch = actualDynamicResultSet.getPromptSearch();
    Boolean actualTotalCountLessThanPageSize =
        actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata =
        actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert
    assertEquals(1, actualBatchId.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualUpperCount.intValue());
    assertEquals(FetchType.LARGERESULTSET, actualFetchType);
    assertTrue(actualUnselectedTabMetadata.isEmpty());
    assertTrue(actualPromptSearch);
    assertTrue(actualTotalCountLessThanPageSize);
    assertSame(unselectedTabMetadata, actualUnselectedTabMetadata);
    assertSame(classMetaData2, actualClassMetaData);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When array of {@link Entity} with {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicResultSet#DynamicResultSet(Entity[], Integer)}
   *   <li>{@link DynamicResultSet#setBatchId(Integer)}
   *   <li>{@link DynamicResultSet#setClassMetaData(ClassMetadata)}
   *   <li>{@link DynamicResultSet#setFetchType(FetchType)}
   *   <li>{@link DynamicResultSet#setFirstId(Long)}
   *   <li>{@link DynamicResultSet#setLastId(Long)}
   *   <li>{@link DynamicResultSet#setLowerCount(Integer)}
   *   <li>{@link DynamicResultSet#setPageSize(Integer)}
   *   <li>{@link DynamicResultSet#setPromptSearch(Boolean)}
   *   <li>{@link DynamicResultSet#setRecords(Entity[])}
   *   <li>{@link DynamicResultSet#setStartIndex(Integer)}
   *   <li>{@link DynamicResultSet#setTotalCountLessThanPageSize(Boolean)}
   *   <li>{@link DynamicResultSet#setTotalRecords(Integer)}
   *   <li>{@link DynamicResultSet#setUnselectedTabMetadata(Map)}
   *   <li>{@link DynamicResultSet#setUpperCount(Integer)}
   *   <li>{@link DynamicResultSet#getBatchId()}
   *   <li>{@link DynamicResultSet#getClassMetaData()}
   *   <li>{@link DynamicResultSet#getFetchType()}
   *   <li>{@link DynamicResultSet#getFirstId()}
   *   <li>{@link DynamicResultSet#getLastId()}
   *   <li>{@link DynamicResultSet#getLowerCount()}
   *   <li>{@link DynamicResultSet#getPromptSearch()}
   *   <li>{@link DynamicResultSet#getTotalCountLessThanPageSize()}
   *   <li>{@link DynamicResultSet#getUnselectedTabMetadata()}
   *   <li>{@link DynamicResultSet#getUpperCount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicResultSet.<init>()",
    "void DynamicResultSet.<init>(ClassMetadata)",
    "void DynamicResultSet.<init>(ClassMetadata, Entity[], Integer)",
    "void DynamicResultSet.<init>(Entity[], Integer)",
    "Integer DynamicResultSet.getBatchId()",
    "ClassMetadata DynamicResultSet.getClassMetaData()",
    "FetchType DynamicResultSet.getFetchType()",
    "Long DynamicResultSet.getFirstId()",
    "Long DynamicResultSet.getLastId()",
    "Integer DynamicResultSet.getLowerCount()",
    "Boolean DynamicResultSet.getPromptSearch()",
    "Boolean DynamicResultSet.getTotalCountLessThanPageSize()",
    "Map DynamicResultSet.getUnselectedTabMetadata()",
    "Integer DynamicResultSet.getUpperCount()",
    "void DynamicResultSet.setBatchId(Integer)",
    "void DynamicResultSet.setClassMetaData(ClassMetadata)",
    "void DynamicResultSet.setFetchType(FetchType)",
    "void DynamicResultSet.setFirstId(Long)",
    "void DynamicResultSet.setLastId(Long)",
    "void DynamicResultSet.setLowerCount(Integer)",
    "void DynamicResultSet.setPageSize(Integer)",
    "void DynamicResultSet.setPromptSearch(Boolean)",
    "void DynamicResultSet.setRecords(Entity[])",
    "void DynamicResultSet.setStartIndex(Integer)",
    "void DynamicResultSet.setTotalCountLessThanPageSize(Boolean)",
    "void DynamicResultSet.setTotalRecords(Integer)",
    "void DynamicResultSet.setUnselectedTabMetadata(Map)",
    "void DynamicResultSet.setUpperCount(Integer)"
  })
  public void testGettersAndSetters_whenArrayOfEntityWithEntity() {
    // Arrange
    Entity[] records = new Entity[] {new Entity()};

    // Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet(records, 1);
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[] {new Entity()});
    actualDynamicResultSet.setStartIndex(1);
    actualDynamicResultSet.setTotalCountLessThanPageSize(true);
    actualDynamicResultSet.setTotalRecords(1);
    HashMap<String, Tab> unselectedTabMetadata = new HashMap<>();
    actualDynamicResultSet.setUnselectedTabMetadata(unselectedTabMetadata);
    actualDynamicResultSet.setUpperCount(3);
    Integer actualBatchId = actualDynamicResultSet.getBatchId();
    ClassMetadata actualClassMetaData = actualDynamicResultSet.getClassMetaData();
    FetchType actualFetchType = actualDynamicResultSet.getFetchType();
    Long actualFirstId = actualDynamicResultSet.getFirstId();
    Long actualLastId = actualDynamicResultSet.getLastId();
    Integer actualLowerCount = actualDynamicResultSet.getLowerCount();
    Boolean actualPromptSearch = actualDynamicResultSet.getPromptSearch();
    Boolean actualTotalCountLessThanPageSize =
        actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata =
        actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert
    assertEquals(1, actualBatchId.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualUpperCount.intValue());
    assertEquals(FetchType.LARGERESULTSET, actualFetchType);
    assertTrue(actualUnselectedTabMetadata.isEmpty());
    assertTrue(actualPromptSearch);
    assertTrue(actualTotalCountLessThanPageSize);
    assertSame(unselectedTabMetadata, actualUnselectedTabMetadata);
    assertSame(classMetaData, actualClassMetaData);
  }

  /**
   * Test {@link DynamicResultSet#getTotalRecords()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getTotalRecords()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DynamicResultSet.getTotalRecords()"})
  public void testGetTotalRecords_givenClassMetadataCeilingTypeIsType_thenReturnIntValueIsOne() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);
    dynamicResultSet.setTotalRecords(1);

    // Act and Assert
    assertEquals(1, dynamicResultSet.getTotalRecords().intValue());
  }

  /**
   * Test {@link DynamicResultSet#getTotalRecords()}.
   *
   * <ul>
   *   <li>Given {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getTotalRecords()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DynamicResultSet.getTotalRecords()"})
  public void testGetTotalRecords_givenDynamicResultSet_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DynamicResultSet().getTotalRecords().intValue());
  }

  /**
   * Test {@link DynamicResultSet#getRecords()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getRecords()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] DynamicResultSet.getRecords()"})
  public void testGetRecords_givenClassMetadataCeilingTypeIsType_thenReturnArrayLengthIsOne() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);
    Entity entity = new Entity();
    dynamicResultSet.setRecords(new Entity[] {entity});

    // Act
    Entity[] actualRecords = dynamicResultSet.getRecords();

    // Assert
    assertEquals(1, actualRecords.length);
    assertSame(entity, actualRecords[0]);
  }

  /**
   * Test {@link DynamicResultSet#getRecords()}.
   *
   * <ul>
   *   <li>Given {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getRecords()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] DynamicResultSet.getRecords()"})
  public void testGetRecords_givenDynamicResultSet_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DynamicResultSet().getRecords().length);
  }

  /**
   * Test {@link DynamicResultSet#getStartIndex()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getStartIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DynamicResultSet.getStartIndex()"})
  public void testGetStartIndex_givenClassMetadataCeilingTypeIsType_thenReturnIntValueIsOne() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);
    dynamicResultSet.setStartIndex(1);

    // Act and Assert
    assertEquals(1, dynamicResultSet.getStartIndex().intValue());
  }

  /**
   * Test {@link DynamicResultSet#getStartIndex()}.
   *
   * <ul>
   *   <li>Given {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getStartIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DynamicResultSet.getStartIndex()"})
  public void testGetStartIndex_givenDynamicResultSet_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DynamicResultSet().getStartIndex().intValue());
  }

  /**
   * Test {@link DynamicResultSet#getPageSize()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getPageSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DynamicResultSet.getPageSize()"})
  public void testGetPageSize_givenClassMetadataCeilingTypeIsType_thenReturnIntValueIsOne() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);
    dynamicResultSet.setPageSize(1);

    // Act and Assert
    assertEquals(1, dynamicResultSet.getPageSize().intValue());
  }

  /**
   * Test {@link DynamicResultSet#getPageSize()}.
   *
   * <ul>
   *   <li>Given {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResultSet#getPageSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DynamicResultSet.getPageSize()"})
  public void testGetPageSize_givenDynamicResultSet_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DynamicResultSet().getPageSize().intValue());
  }
}
