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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PersistenceManagerEventHandlerResponseDiffblueTest {
  /**
   * Test {@link PersistenceManagerEventHandlerResponse#withEntity(Entity)}.
   *
   * <p>Method under test: {@link PersistenceManagerEventHandlerResponse#withEntity(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerResponse.withEntity(Entity)"
  })
  public void testWithEntity() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse =
        new PersistenceManagerEventHandlerResponse();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualWithEntityResult =
        persistenceManagerEventHandlerResponse.withEntity(entity);

    // Assert
    assertSame(entity, persistenceManagerEventHandlerResponse.getEntity());
    assertSame(persistenceManagerEventHandlerResponse, actualWithEntityResult);
  }

  /**
   * Test {@link
   * PersistenceManagerEventHandlerResponse#withStatus(PersistenceManagerEventHandlerResponseStatus)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerResponse#withStatus(PersistenceManagerEventHandlerResponseStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerResponse.withStatus(PersistenceManagerEventHandlerResponseStatus)"
  })
  public void testWithStatus() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse =
        new PersistenceManagerEventHandlerResponse();

    // Act
    PersistenceManagerEventHandlerResponse actualWithStatusResult =
        persistenceManagerEventHandlerResponse.withStatus(
            PersistenceManagerEventHandlerResponseStatus.HANDLED);

    // Assert
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.HANDLED,
        persistenceManagerEventHandlerResponse.getStatus());
    assertSame(persistenceManagerEventHandlerResponse, actualWithStatusResult);
  }

  /**
   * Test {@link PersistenceManagerEventHandlerResponse#withDynamicResultSet(DynamicResultSet)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerResponse#withDynamicResultSet(DynamicResultSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerResponse.withDynamicResultSet(DynamicResultSet)"
  })
  public void testWithDynamicResultSet() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse =
        new PersistenceManagerEventHandlerResponse();
    DynamicResultSet dynamicResultSet = new DynamicResultSet();

    // Act
    PersistenceManagerEventHandlerResponse actualWithDynamicResultSetResult =
        persistenceManagerEventHandlerResponse.withDynamicResultSet(dynamicResultSet);

    // Assert
    assertSame(dynamicResultSet, persistenceManagerEventHandlerResponse.getDynamicResultSet());
    assertSame(persistenceManagerEventHandlerResponse, actualWithDynamicResultSetResult);
  }

  /**
   * Test {@link PersistenceManagerEventHandlerResponse#withAdditionalData(Map)}.
   *
   * <p>Method under test: {@link PersistenceManagerEventHandlerResponse#withAdditionalData(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerResponse.withAdditionalData(Map)"
  })
  public void testWithAdditionalData() {
    // Arrange
    PersistenceManagerEventHandlerResponse persistenceManagerEventHandlerResponse =
        new PersistenceManagerEventHandlerResponse();
    HashMap<String, Object> additionalData = new HashMap<>();

    // Act
    PersistenceManagerEventHandlerResponse actualWithAdditionalDataResult =
        persistenceManagerEventHandlerResponse.withAdditionalData(additionalData);

    // Assert
    assertSame(additionalData, persistenceManagerEventHandlerResponse.getAdditionalData());
    assertSame(persistenceManagerEventHandlerResponse, actualWithAdditionalDataResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PersistenceManagerEventHandlerResponse}
   *   <li>{@link PersistenceManagerEventHandlerResponse#setAdditionalData(Map)}
   *   <li>{@link PersistenceManagerEventHandlerResponse#setDynamicResultSet(DynamicResultSet)}
   *   <li>{@link PersistenceManagerEventHandlerResponse#setEntity(Entity)}
   *   <li>{@link
   *       PersistenceManagerEventHandlerResponse#setStatus(PersistenceManagerEventHandlerResponseStatus)}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getAdditionalData()}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getDynamicResultSet()}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getEntity()}
   *   <li>{@link PersistenceManagerEventHandlerResponse#getStatus()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistenceManagerEventHandlerResponse.<init>()",
    "Map PersistenceManagerEventHandlerResponse.getAdditionalData()",
    "DynamicResultSet PersistenceManagerEventHandlerResponse.getDynamicResultSet()",
    "Entity PersistenceManagerEventHandlerResponse.getEntity()",
    "PersistenceManagerEventHandlerResponseStatus PersistenceManagerEventHandlerResponse.getStatus()",
    "void PersistenceManagerEventHandlerResponse.setAdditionalData(Map)",
    "void PersistenceManagerEventHandlerResponse.setDynamicResultSet(DynamicResultSet)",
    "void PersistenceManagerEventHandlerResponse.setEntity(Entity)",
    "void PersistenceManagerEventHandlerResponse.setStatus(PersistenceManagerEventHandlerResponseStatus)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PersistenceManagerEventHandlerResponse actualPersistenceManagerEventHandlerResponse =
        new PersistenceManagerEventHandlerResponse();
    HashMap<String, Object> additionalData = new HashMap<>();
    actualPersistenceManagerEventHandlerResponse.setAdditionalData(additionalData);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    actualPersistenceManagerEventHandlerResponse.setDynamicResultSet(dynamicResultSet);
    Entity entity = new Entity();
    actualPersistenceManagerEventHandlerResponse.setEntity(entity);
    actualPersistenceManagerEventHandlerResponse.setStatus(
        PersistenceManagerEventHandlerResponseStatus.HANDLED);
    Map<String, Object> actualAdditionalData =
        actualPersistenceManagerEventHandlerResponse.getAdditionalData();
    DynamicResultSet actualDynamicResultSet =
        actualPersistenceManagerEventHandlerResponse.getDynamicResultSet();
    Entity actualEntity = actualPersistenceManagerEventHandlerResponse.getEntity();

    // Assert
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.HANDLED,
        actualPersistenceManagerEventHandlerResponse.getStatus());
    assertTrue(actualAdditionalData.isEmpty());
    assertSame(additionalData, actualAdditionalData);
    assertSame(dynamicResultSet, actualDynamicResultSet);
    assertSame(entity, actualEntity);
  }
}
