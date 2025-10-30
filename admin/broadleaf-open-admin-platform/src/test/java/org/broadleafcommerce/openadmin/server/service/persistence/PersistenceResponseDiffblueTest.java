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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PersistenceResponseDiffblueTest {
  /**
   * Test {@link PersistenceResponse#withDynamicResultSet(DynamicResultSet)}.
   * <p>
   * Method under test: {@link PersistenceResponse#withDynamicResultSet(DynamicResultSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse PersistenceResponse.withDynamicResultSet(DynamicResultSet)"})
  public void testWithDynamicResultSet() {
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
   * <p>
   * Method under test: {@link PersistenceResponse#withEntity(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse PersistenceResponse.withEntity(Entity)"})
  public void testWithEntity() {
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
   * <p>
   * Method under test: {@link PersistenceResponse#withAdditionalData(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse PersistenceResponse.withAdditionalData(Map)"})
  public void testWithAdditionalData() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PersistenceResponse.<init>()", "Map PersistenceResponse.getAdditionalData()",
      "DynamicResultSet PersistenceResponse.getDynamicResultSet()", "Entity PersistenceResponse.getEntity()",
      "void PersistenceResponse.setAdditionalData(Map)",
      "void PersistenceResponse.setDynamicResultSet(DynamicResultSet)", "void PersistenceResponse.setEntity(Entity)"})
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

    // Assert
    assertTrue(actualAdditionalData.isEmpty());
    assertSame(additionalData, actualAdditionalData);
    assertSame(dynamicResultSet, actualDynamicResultSet);
    assertSame(entity, actualEntity);
  }
}
