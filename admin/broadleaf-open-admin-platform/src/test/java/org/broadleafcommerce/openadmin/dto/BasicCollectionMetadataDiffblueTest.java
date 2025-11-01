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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicCollectionMetadataDiffblueTest {
  /**
   * Method under test: {@link BasicCollectionMetadata#accept(MetadataVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    MetadataVisitorAdapter visitor = mock(MetadataVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<BasicCollectionMetadata>any());

    // Act
    basicCollectionMetadata.accept(visitor);

    // Assert
    verify(visitor).visit(isA(BasicCollectionMetadata.class));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);
    BasicCollectionMetadata metadata = new BasicCollectionMetadata();

    // Act and Assert
    assertSame(metadata, basicCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[]{"foo"});

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);
    BasicCollectionMetadata metadata = new BasicCollectionMetadata();

    // Act and Assert
    assertSame(metadata, basicCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[]{"foo"});
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);
    BasicCollectionMetadata metadata = new BasicCollectionMetadata();

    // Act and Assert
    assertSame(metadata, basicCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);
    BasicCollectionMetadata metadata = new BasicCollectionMetadata();

    // Act and Assert
    assertSame(metadata, basicCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);
    BasicCollectionMetadata metadata = new BasicCollectionMetadata();

    // Act and Assert
    assertSame(metadata, basicCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);
    BasicCollectionMetadata metadata = new BasicCollectionMetadata();

    // Act and Assert
    assertSame(metadata, basicCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[]{"foo"});

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[]{"foo"});
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    ForeignKey foreignKey = new ForeignKey();
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{foreignKey});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    ForeignKey[] additionalForeignKeys = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata7() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertEquals(persistencePerspectiveItems, persistencePerspective2.getPersistencePerspectiveItems());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata8() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.computeIfPresent(PersistencePerspectiveItemType.FOREIGNKEY, mock(BiFunction.class));
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getSortProperty());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((BasicCollectionMetadata) actualCloneFieldMetadataResult).getAddMethodType());
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertEquals(persistencePerspectiveItems, persistencePerspective2.getPersistencePerspectiveItems());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicCollectionMetadata#equals(Object)}
   *   <li>{@link BasicCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();

    // Act and Assert
    assertEquals(basicCollectionMetadata, basicCollectionMetadata);
    int expectedHashCodeResult = basicCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicCollectionMetadata.hashCode());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);

    // Act and Assert
    assertNotEquals(basicCollectionMetadata, new BasicCollectionMetadata());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(basicCollectionMetadata, new BasicCollectionMetadata());
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), null);
  }

  /**
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), "Different type to BasicCollectionMetadata");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BasicCollectionMetadata}
   *   <li>{@link BasicCollectionMetadata#setAddMethodType(AddMethodType)}
   *   <li>{@link BasicCollectionMetadata#setSelectizeVisibleField(String)}
   *   <li>{@link BasicCollectionMetadata#setSortProperty(String)}
   *   <li>{@link BasicCollectionMetadata#getAddMethodType()}
   *   <li>{@link BasicCollectionMetadata#getSelectizeVisibleField()}
   *   <li>{@link BasicCollectionMetadata#getSortProperty()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BasicCollectionMetadata actualBasicCollectionMetadata = new BasicCollectionMetadata();
    actualBasicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    actualBasicCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    actualBasicCollectionMetadata.setSortProperty("Sort Property");
    AddMethodType actualAddMethodType = actualBasicCollectionMetadata.getAddMethodType();
    String actualSelectizeVisibleField = actualBasicCollectionMetadata.getSelectizeVisibleField();

    // Assert that nothing has changed
    assertEquals("Selectize Visible Field", actualSelectizeVisibleField);
    assertEquals("Sort Property", actualBasicCollectionMetadata.getSortProperty());
    assertEquals(AddMethodType.PERSIST, actualAddMethodType);
    assertTrue(actualBasicCollectionMetadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualBasicCollectionMetadata.isMutable());
  }
}
