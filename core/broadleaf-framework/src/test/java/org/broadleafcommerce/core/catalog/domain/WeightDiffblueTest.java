/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.DeferredOperation;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.junit.Test;

public class WeightDiffblueTest {
  /**
   * Method under test: {@link Weight#getWeightUnitOfMeasure()}
   */
  @Test
  public void testGetWeightUnitOfMeasure() {
    // Arrange and Act
    WeightUnitOfMeasureType actualWeightUnitOfMeasure = (new Weight()).getWeightUnitOfMeasure();

    // Assert
    assertEquals("Friendly Type", actualWeightUnitOfMeasure.getFriendlyType());
    assertNull(actualWeightUnitOfMeasure.getType());
  }

  /**
   * Method under test:
   * {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  public void testSetWeightUnitOfMeasure() {
    // Arrange
    Weight weight = new Weight();

    // Act
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Assert
    assertEquals("Type", weight.getWeightUnitOfMeasure().getType());
    assertEquals("Type", weight.weightUnitOfMeasure);
  }

  /**
   * Method under test:
   * {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  public void testSetWeightUnitOfMeasure2() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act
    weight.setWeightUnitOfMeasure(null);

    // Assert that nothing has changed
    assertEquals("Type", weight.getWeightUnitOfMeasure().getType());
    assertEquals("Type", weight.weightUnitOfMeasure);
  }

  /**
   * Method under test:
   * {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    Weight weight = new Weight();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    CreateResponse<Weight> actualCreateOrRetrieveCopyInstanceResult = weight
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(weight, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Method under test:
   * {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    Weight weight = new Weight();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    context.addDeferredOperation(mock(DeferredOperation.class));

    // Act
    CreateResponse<Weight> actualCreateOrRetrieveCopyInstanceResult = weight.createOrRetrieveCopyInstance(context);

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(weight, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Method under test:
   * {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    Weight weight = new Weight();
    weight.setWeightUnitOfMeasure(
        new WeightUnitOfMeasureType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans"));
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    CreateResponse<Weight> actualCreateOrRetrieveCopyInstanceResult = weight
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(weight, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Weight#equals(Object)}
   *   <li>{@link Weight#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(weight, weight2);
    int expectedHashCodeResult = weight.hashCode();
    assertEquals(expectedHashCodeResult, weight2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Weight#equals(Object)}
   *   <li>{@link Weight#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasure = mock(WeightUnitOfMeasureType.class);
    when(weightUnitOfMeasure.getType()).thenReturn("Type");

    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(weightUnitOfMeasure);

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(weight, weight2);
    int expectedHashCodeResult = weight.hashCode();
    assertEquals(expectedHashCodeResult, weight2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Weight#equals(Object)}
   *   <li>{@link Weight#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(weight, weight);
    int expectedHashCodeResult = weight.hashCode();
    assertEquals(expectedHashCodeResult, weight.hashCode());
  }

  /**
   * Method under test: {@link Weight#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("4.5"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Method under test: {@link Weight#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(null);
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Method under test: {@link Weight#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType(null, "Friendly Type"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Method under test: {@link Weight#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("42", "Friendly Type"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Method under test: {@link Weight#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(weight, null);
  }

  /**
   * Method under test: {@link Weight#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(weight, "Different type to Weight");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Weight}
   *   <li>{@link Weight#setWeight(BigDecimal)}
   *   <li>{@link Weight#getWeight()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Weight actualWeight = new Weight();
    BigDecimal weight = new BigDecimal("2.3");
    actualWeight.setWeight(weight);
    BigDecimal actualWeight2 = actualWeight.getWeight();

    // Assert that nothing has changed
    assertEquals(new BigDecimal("2.3"), actualWeight2);
    assertSame(weight, actualWeight2);
  }
}
