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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.server.service.type.FetchType;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.junit.Test;

public class DynamicResultSetDiffblueTest {
  /**
   * Method under test: {@link DynamicResultSet#getTotalRecords()}
   */
  @Test
  public void testGetTotalRecords() {
    // Arrange, Act and Assert
    assertEquals(0, (new DynamicResultSet()).getTotalRecords().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getTotalRecords()}
   */
  @Test
  public void testGetTotalRecords2() {
    // Arrange
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setTotalRecords(1);

    // Act and Assert
    assertEquals(1, dynamicResultSet.getTotalRecords().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getTotalRecords()}
   */
  @Test
  public void testGetTotalRecords3() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(tabAndGroupMetadata);

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    // Act and Assert
    assertEquals(0, dynamicResultSet.getTotalRecords().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getRecords()}
   */
  @Test
  public void testGetRecords() {
    // Arrange, Act and Assert
    assertEquals(0, (new DynamicResultSet()).getRecords().length);
  }

  /**
   * Method under test: {@link DynamicResultSet#getRecords()}
   */
  @Test
  public void testGetRecords2() {
    // Arrange
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    Entity entity = new Entity();
    dynamicResultSet.setRecords(new Entity[]{entity});

    // Act
    Entity[] actualRecords = dynamicResultSet.getRecords();

    // Assert
    assertEquals(1, actualRecords.length);
    assertSame(entity, actualRecords[0]);
  }

  /**
   * Method under test: {@link DynamicResultSet#getRecords()}
   */
  @Test
  public void testGetRecords3() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(tabAndGroupMetadata);

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    // Act and Assert
    assertEquals(0, dynamicResultSet.getRecords().length);
  }

  /**
   * Method under test: {@link DynamicResultSet#getStartIndex()}
   */
  @Test
  public void testGetStartIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new DynamicResultSet()).getStartIndex().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getStartIndex()}
   */
  @Test
  public void testGetStartIndex2() {
    // Arrange
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setStartIndex(1);

    // Act and Assert
    assertEquals(1, dynamicResultSet.getStartIndex().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getStartIndex()}
   */
  @Test
  public void testGetStartIndex3() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(tabAndGroupMetadata);

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    // Act and Assert
    assertEquals(0, dynamicResultSet.getStartIndex().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getPageSize()}
   */
  @Test
  public void testGetPageSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new DynamicResultSet()).getPageSize().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getPageSize()}
   */
  @Test
  public void testGetPageSize2() {
    // Arrange
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setPageSize(1);

    // Act and Assert
    assertEquals(1, dynamicResultSet.getPageSize().intValue());
  }

  /**
   * Method under test: {@link DynamicResultSet#getPageSize()}
   */
  @Test
  public void testGetPageSize3() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(tabAndGroupMetadata);

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    // Act and Assert
    assertEquals(0, dynamicResultSet.getPageSize().intValue());
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet();
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[]{new Entity()});
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
    Boolean actualTotalCountLessThanPageSize = actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata = actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert that nothing has changed
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
   * Methods under test:
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
  public void testGettersAndSetters2() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    // Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet(classMetaData);
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[]{new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData2);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[]{new Entity()});
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
    Boolean actualTotalCountLessThanPageSize = actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata = actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert that nothing has changed
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DynamicResultSet#DynamicResultSet(ClassMetadata, Entity[], Integer)}
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
  public void testGettersAndSetters3() {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    // Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet(classMetaData, new Entity[]{new Entity()}, 1);
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[]{new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData2);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[]{new Entity()});
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
    Boolean actualTotalCountLessThanPageSize = actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata = actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert that nothing has changed
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
   * Methods under test:
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
  public void testGettersAndSetters4() {
    // Arrange and Act
    DynamicResultSet actualDynamicResultSet = new DynamicResultSet(new Entity[]{new Entity()}, 1);
    actualDynamicResultSet.setBatchId(1);
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    actualDynamicResultSet.setClassMetaData(classMetaData);
    actualDynamicResultSet.setFetchType(FetchType.LARGERESULTSET);
    actualDynamicResultSet.setFirstId(1L);
    actualDynamicResultSet.setLastId(1L);
    actualDynamicResultSet.setLowerCount(3);
    actualDynamicResultSet.setPageSize(3);
    actualDynamicResultSet.setPromptSearch(true);
    actualDynamicResultSet.setRecords(new Entity[]{new Entity()});
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
    Boolean actualTotalCountLessThanPageSize = actualDynamicResultSet.getTotalCountLessThanPageSize();
    Map<String, Tab> actualUnselectedTabMetadata = actualDynamicResultSet.getUnselectedTabMetadata();
    Integer actualUpperCount = actualDynamicResultSet.getUpperCount();

    // Assert that nothing has changed
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
}
