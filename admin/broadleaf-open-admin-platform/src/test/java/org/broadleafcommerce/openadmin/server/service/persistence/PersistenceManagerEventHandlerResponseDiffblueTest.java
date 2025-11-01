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
package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;

public class PersistenceManagerEventHandlerResponseDiffblueTest {
  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withEntity(Entity)}
   */
  @Test
  public void testWithEntity() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualWithEntityResult = persistenceManagerEventHandlerResponse
        .withEntity(entity);

    // Assert
    assertSame(entity, persistenceManagerEventHandlerResponse.getEntity());
    assertSame(persistenceManagerEventHandlerResponse, actualWithEntityResult);
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withEntity(Entity)}
   */
  @Test
  public void testWithEntity2() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();

    Entity entity = new Entity();
    entity.setDeployDate(mock(Date.class));

    // Act
    PersistenceManagerEventHandlerResponse actualWithEntityResult = persistenceManagerEventHandlerResponse
        .withEntity(entity);

    // Assert
    assertSame(entity, persistenceManagerEventHandlerResponse.getEntity());
    assertSame(persistenceManagerEventHandlerResponse, actualWithEntityResult);
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withStatus(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus)}
   */
  @Test
  public void testWithStatus() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();

    // Act
    PersistenceManagerEventHandlerResponse actualWithStatusResult = persistenceManagerEventHandlerResponse
        .withStatus(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.HANDLED);

    // Assert
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.HANDLED,
        persistenceManagerEventHandlerResponse.getStatus());
    assertSame(persistenceManagerEventHandlerResponse, actualWithStatusResult);
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withStatus(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus)}
   */
  @Test
  public void testWithStatus2() {
    // Arrange
    HashMap<String, Object> additionalData = new HashMap<>();
    additionalData.computeIfPresent("foo", mock(BiFunction.class));

    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();
    persistenceManagerEventHandlerResponse.setAdditionalData(additionalData);

    // Act
    PersistenceManagerEventHandlerResponse actualWithStatusResult = persistenceManagerEventHandlerResponse
        .withStatus(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.HANDLED);

    // Assert
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.HANDLED,
        persistenceManagerEventHandlerResponse.getStatus());
    assertSame(persistenceManagerEventHandlerResponse, actualWithStatusResult);
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withDynamicResultSet(DynamicResultSet)}
   */
  @Test
  public void testWithDynamicResultSet() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();
    DynamicResultSet dynamicResultSet = new DynamicResultSet();

    // Act
    PersistenceManagerEventHandlerResponse actualWithDynamicResultSetResult = persistenceManagerEventHandlerResponse
        .withDynamicResultSet(dynamicResultSet);

    // Assert
    assertSame(dynamicResultSet, persistenceManagerEventHandlerResponse.getDynamicResultSet());
    assertSame(persistenceManagerEventHandlerResponse, actualWithDynamicResultSetResult);
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withDynamicResultSet(DynamicResultSet)}
   */
  @Test
  public void testWithDynamicResultSet2() {
    // Arrange
    HashMap<String, Object> additionalData = new HashMap<>();
    additionalData.computeIfPresent("foo", mock(BiFunction.class));

    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();
    persistenceManagerEventHandlerResponse.setAdditionalData(additionalData);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();

    // Act
    PersistenceManagerEventHandlerResponse actualWithDynamicResultSetResult = persistenceManagerEventHandlerResponse
        .withDynamicResultSet(dynamicResultSet);

    // Assert
    assertSame(dynamicResultSet, persistenceManagerEventHandlerResponse.getDynamicResultSet());
    assertSame(persistenceManagerEventHandlerResponse, actualWithDynamicResultSetResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link PersistenceManagerEventHandlerResponse}
   *   <li>{@link PersistenceManagerEventHandlerResponse#setAdditionalData(Map)}
   *   <li>
   * {@link PersistenceManagerEventHandlerResponse#setDynamicResultSet(DynamicResultSet)}
   *   <li>{@link PersistenceManagerEventHandlerResponse#setEntity(Entity)}
   *   <li>
   * {@link PersistenceManagerEventHandlerResponse#setStatus(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus)}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getAdditionalData()}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getDynamicResultSet()}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getEntity()}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getStatus()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PersistenceManagerEventHandlerResponse actualPersistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();
    HashMap<String, Object> additionalData = new HashMap<>();
    actualPersistenceManagerEventHandlerResponse.setAdditionalData(additionalData);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    actualPersistenceManagerEventHandlerResponse.setDynamicResultSet(dynamicResultSet);
    Entity entity = new Entity();
    actualPersistenceManagerEventHandlerResponse.setEntity(entity);
    actualPersistenceManagerEventHandlerResponse
        .setStatus(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.HANDLED);
    Map<String, Object> actualAdditionalData = actualPersistenceManagerEventHandlerResponse.getAdditionalData();
    DynamicResultSet actualDynamicResultSet = actualPersistenceManagerEventHandlerResponse.getDynamicResultSet();
    Entity actualEntity = actualPersistenceManagerEventHandlerResponse.getEntity();

    // Assert that nothing has changed
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.HANDLED,
        actualPersistenceManagerEventHandlerResponse.getStatus());
    assertTrue(actualAdditionalData.isEmpty());
    assertSame(additionalData, actualAdditionalData);
    assertSame(dynamicResultSet, actualDynamicResultSet);
    assertSame(entity, actualEntity);
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withAdditionalData(Map)}
   */
  @Test
  public void testWithAdditionalData() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();
    HashMap<String, Object> additionalData = new HashMap<>();

    // Act
    PersistenceManagerEventHandlerResponse actualWithAdditionalDataResult = persistenceManagerEventHandlerResponse
        .withAdditionalData(additionalData);

    // Assert
    assertSame(additionalData, persistenceManagerEventHandlerResponse.getAdditionalData());
    assertSame(persistenceManagerEventHandlerResponse, actualWithAdditionalDataResult);
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerResponse#withAdditionalData(Map)}
   */
  @Test
  public void testWithAdditionalData2() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse = new PersistenceManagerEventHandlerResponse();

    HashMap<String, Object> additionalData = new HashMap<>();
    additionalData.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    PersistenceManagerEventHandlerResponse actualWithAdditionalDataResult = persistenceManagerEventHandlerResponse
        .withAdditionalData(additionalData);

    // Assert
    assertSame(additionalData, persistenceManagerEventHandlerResponse.getAdditionalData());
    assertSame(persistenceManagerEventHandlerResponse, actualWithAdditionalDataResult);
  }
}
