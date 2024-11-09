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
package org.broadleafcommerce.openadmin.server.service.persistence;

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

public class PersistenceResponseDiffblueTest {
  /**
   * Test {@link PersistenceResponse#withDynamicResultSet(DynamicResultSet)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceResponse#withDynamicResultSet(DynamicResultSet)}
   */
  @Test
  public void testWithDynamicResultSet_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Object> additionalData = new HashMap<>();
    additionalData.computeIfPresent("foo", mock(BiFunction.class));

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setAdditionalData(additionalData);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();

    // Act
    PersistenceResponse actualWithDynamicResultSetResult = persistenceResponse.withDynamicResultSet(dynamicResultSet);

    // Assert
    assertSame(dynamicResultSet, persistenceResponse.getDynamicResultSet());
    assertSame(persistenceResponse, actualWithDynamicResultSetResult);
  }

  /**
   * Test {@link PersistenceResponse#withDynamicResultSet(DynamicResultSet)}.
   * <ul>
   *   <li>Given {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceResponse#withDynamicResultSet(DynamicResultSet)}
   */
  @Test
  public void testWithDynamicResultSet_givenPersistenceResponse() {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    DynamicResultSet dynamicResultSet = new DynamicResultSet();

    // Act
    PersistenceResponse actualWithDynamicResultSetResult = persistenceResponse.withDynamicResultSet(dynamicResultSet);

    // Assert
    assertSame(dynamicResultSet, persistenceResponse.getDynamicResultSet());
    assertSame(persistenceResponse, actualWithDynamicResultSetResult);
  }

  /**
   * Test {@link PersistenceResponse#withEntity(Entity)}.
   * <ul>
   *   <li>Given {@link Date}.</li>
   *   <li>When {@link Entity} (default constructor) DeployDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceResponse#withEntity(Entity)}
   */
  @Test
  public void testWithEntity_givenDate_whenEntityDeployDateIsDate() {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    Entity entity = new Entity();
    entity.setDeployDate(mock(Date.class));

    // Act
    PersistenceResponse actualWithEntityResult = persistenceResponse.withEntity(entity);

    // Assert
    assertSame(entity, persistenceResponse.getEntity());
    assertSame(persistenceResponse, actualWithEntityResult);
  }

  /**
   * Test {@link PersistenceResponse#withEntity(Entity)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceResponse#withEntity(Entity)}
   */
  @Test
  public void testWithEntity_whenEntity() {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    Entity entity = new Entity();

    // Act
    PersistenceResponse actualWithEntityResult = persistenceResponse.withEntity(entity);

    // Assert
    assertSame(entity, persistenceResponse.getEntity());
    assertSame(persistenceResponse, actualWithEntityResult);
  }

  /**
   * Test {@link PersistenceResponse#withAdditionalData(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceResponse#withAdditionalData(Map)}
   */
  @Test
  public void testWithAdditionalData_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    HashMap<String, Object> additionalData = new HashMap<>();
    additionalData.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    PersistenceResponse actualWithAdditionalDataResult = persistenceResponse.withAdditionalData(additionalData);

    // Assert
    assertSame(additionalData, persistenceResponse.getAdditionalData());
    assertSame(persistenceResponse, actualWithAdditionalDataResult);
  }

  /**
   * Test {@link PersistenceResponse#withAdditionalData(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceResponse#withAdditionalData(Map)}
   */
  @Test
  public void testWithAdditionalData_whenHashMap() {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    HashMap<String, Object> additionalData = new HashMap<>();

    // Act
    PersistenceResponse actualWithAdditionalDataResult = persistenceResponse.withAdditionalData(additionalData);

    // Assert
    assertSame(additionalData, persistenceResponse.getAdditionalData());
    assertSame(persistenceResponse, actualWithAdditionalDataResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PersistenceResponse}
   *   <li>{@link PersistenceResponse#setAdditionalData(Map)}
   *   <li>{@link PersistenceResponse#setDynamicResultSet(DynamicResultSet)}
   *   <li>{@link PersistenceResponse#setEntity(Entity)}
   *   <li>{@link PersistenceResponse#getAdditionalData()}
   *   <li>{@link PersistenceResponse#getDynamicResultSet()}
   *   <li>{@link PersistenceResponse#getEntity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PersistenceResponse actualPersistenceResponse = new PersistenceResponse();
    HashMap<String, Object> additionalData = new HashMap<>();
    actualPersistenceResponse.setAdditionalData(additionalData);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    actualPersistenceResponse.setDynamicResultSet(dynamicResultSet);
    Entity entity = new Entity();
    actualPersistenceResponse.setEntity(entity);
    Map<String, Object> actualAdditionalData = actualPersistenceResponse.getAdditionalData();
    DynamicResultSet actualDynamicResultSet = actualPersistenceResponse.getDynamicResultSet();
    Entity actualEntity = actualPersistenceResponse.getEntity();

    // Assert that nothing has changed
    assertTrue(actualAdditionalData.isEmpty());
    assertSame(additionalData, actualAdditionalData);
    assertSame(dynamicResultSet, actualDynamicResultSet);
    assertSame(entity, actualEntity);
  }
}
