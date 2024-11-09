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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.junit.Test;

public class FetchExtractionRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FetchExtractionRequest#FetchExtractionRequest(PersistencePackage, CriteriaTransferObject, String, Map, List)}
   *   <li>
   * {@link FetchExtractionRequest#setAlternateUnfilteredMergedProperties(Map)}
   *   <li>{@link FetchExtractionRequest#setCeilingEntity(String)}
   *   <li>{@link FetchExtractionRequest#setCto(CriteriaTransferObject)}
   *   <li>{@link FetchExtractionRequest#setPathToTargetObject(String)}
   *   <li>{@link FetchExtractionRequest#setPersistencePackage(PersistencePackage)}
   *   <li>{@link FetchExtractionRequest#setPrimaryUnfilteredMergedProperties(Map)}
   *   <li>{@link FetchExtractionRequest#setRecords(List)}
   *   <li>{@link FetchExtractionRequest#getAlternateUnfilteredMergedProperties()}
   *   <li>{@link FetchExtractionRequest#getCeilingEntity()}
   *   <li>{@link FetchExtractionRequest#getCto()}
   *   <li>{@link FetchExtractionRequest#getPathToTargetObject()}
   *   <li>{@link FetchExtractionRequest#getPersistencePackage()}
   *   <li>{@link FetchExtractionRequest#getPrimaryUnfilteredMergedProperties()}
   *   <li>{@link FetchExtractionRequest#getRecords()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    // Act
    FetchExtractionRequest actualFetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());
    HashMap<String, FieldMetadata> alternateUnfilteredMergedProperties = new HashMap<>();
    actualFetchExtractionRequest.setAlternateUnfilteredMergedProperties(alternateUnfilteredMergedProperties);
    actualFetchExtractionRequest.setCeilingEntity("0123456789ABCDEF");
    CriteriaTransferObject cto2 = new CriteriaTransferObject();
    actualFetchExtractionRequest.setCto(cto2);
    actualFetchExtractionRequest.setPathToTargetObject("0123456789ABCDEF");
    PersistencePackage persistencePackage2 = new PersistencePackage();
    actualFetchExtractionRequest.setPersistencePackage(persistencePackage2);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties2 = new HashMap<>();
    actualFetchExtractionRequest.setPrimaryUnfilteredMergedProperties(primaryUnfilteredMergedProperties2);
    ArrayList<Serializable> records = new ArrayList<>();
    actualFetchExtractionRequest.setRecords(records);
    Map<String, FieldMetadata> actualAlternateUnfilteredMergedProperties = actualFetchExtractionRequest
        .getAlternateUnfilteredMergedProperties();
    String actualCeilingEntity = actualFetchExtractionRequest.getCeilingEntity();
    CriteriaTransferObject actualCto = actualFetchExtractionRequest.getCto();
    String actualPathToTargetObject = actualFetchExtractionRequest.getPathToTargetObject();
    PersistencePackage actualPersistencePackage = actualFetchExtractionRequest.getPersistencePackage();
    Map<String, FieldMetadata> actualPrimaryUnfilteredMergedProperties = actualFetchExtractionRequest
        .getPrimaryUnfilteredMergedProperties();
    List<? extends Serializable> actualRecords = actualFetchExtractionRequest.getRecords();

    // Assert that nothing has changed
    assertEquals("0123456789ABCDEF", actualCeilingEntity);
    assertEquals("0123456789ABCDEF", actualPathToTargetObject);
    assertTrue(actualRecords.isEmpty());
    assertTrue(actualAlternateUnfilteredMergedProperties.isEmpty());
    assertTrue(actualPrimaryUnfilteredMergedProperties.isEmpty());
    assertSame(records, actualRecords);
    assertSame(alternateUnfilteredMergedProperties, actualAlternateUnfilteredMergedProperties);
    assertSame(primaryUnfilteredMergedProperties2, actualPrimaryUnfilteredMergedProperties);
    assertSame(cto2, actualCto);
    assertSame(persistencePackage2, actualPersistencePackage);
  }

  /**
   * Test {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}.
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}
   */
  @Test
  public void testWithAlternateMergedProperties() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());
    HashMap<String, FieldMetadata> alternateUnfilteredMergedProperties = new HashMap<>();

    // Act
    FetchExtractionRequest actualWithAlternateMergedPropertiesResult = fetchExtractionRequest
        .withAlternateMergedProperties(alternateUnfilteredMergedProperties);

    // Assert
    assertSame(alternateUnfilteredMergedProperties, fetchExtractionRequest.getAlternateUnfilteredMergedProperties());
    assertSame(fetchExtractionRequest, actualWithAlternateMergedPropertiesResult);
  }

  /**
   * Test {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}
   */
  @Test
  public void testWithAlternateMergedProperties_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());
    HashMap<String, FieldMetadata> alternateUnfilteredMergedProperties = new HashMap<>();

    // Act
    FetchExtractionRequest actualWithAlternateMergedPropertiesResult = fetchExtractionRequest
        .withAlternateMergedProperties(alternateUnfilteredMergedProperties);

    // Assert
    assertSame(alternateUnfilteredMergedProperties, fetchExtractionRequest.getAlternateUnfilteredMergedProperties());
    assertSame(fetchExtractionRequest, actualWithAlternateMergedPropertiesResult);
  }

  /**
   * Test {@link FetchExtractionRequest#withPathToTargetObject(String)}.
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withPathToTargetObject(String)}
   */
  @Test
  public void testWithPathToTargetObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());

    // Act and Assert
    assertSame(fetchExtractionRequest, fetchExtractionRequest.withPathToTargetObject("0123456789ABCDEF"));
  }

  /**
   * Test {@link FetchExtractionRequest#withPathToTargetObject(String)}.
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withPathToTargetObject(String)}
   */
  @Test
  public void testWithPathToTargetObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());

    // Act
    FetchExtractionRequest actualWithPathToTargetObjectResult = fetchExtractionRequest
        .withPathToTargetObject("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", fetchExtractionRequest.getPathToTargetObject());
    assertSame(fetchExtractionRequest, actualWithPathToTargetObjectResult);
  }
}
