/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class IndexFieldCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleAddResult = indexFieldCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.search.domain.IndexField");

    // Act
    Boolean actualCanHandleAddResult = indexFieldCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();

    // Act and Assert
    assertFalse(indexFieldCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleUpdateResult = indexFieldCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.search.domain.IndexField");

    // Act
    Boolean actualCanHandleUpdateResult = indexFieldCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();

    // Act and Assert
    assertFalse(indexFieldCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleRemoveResult = indexFieldCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();

    // Act and Assert
    assertFalse(indexFieldCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = indexFieldCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.search.domain.IndexField");

    // Act
    Boolean actualCanHandleFetchResult = indexFieldCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();

    // Act and Assert
    assertFalse(indexFieldCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> indexFieldCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.search.domain.IndexField"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> indexFieldCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity).getType();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.search.domain.IndexField"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of
   * {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> indexFieldCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test
   * {@link IndexFieldCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldCustomPersistenceHandler indexFieldCustomPersistenceHandler = new IndexFieldCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = indexFieldCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }
}
