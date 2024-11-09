/*-
 * #%L
 * BroadleafCommerce Framework
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
   * Test {@link Weight#getWeightUnitOfMeasure()}.
   * <p>
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
   * Test {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>Given {@link Weight} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  public void testSetWeightUnitOfMeasure_givenWeight() {
    // Arrange
    Weight weight = new Weight();
    WeightUnitOfMeasureType weightUnitOfMeasure = new WeightUnitOfMeasureType("Type", "Friendly Type");

    // Act
    weight.setWeightUnitOfMeasure(weightUnitOfMeasure);

    // Assert
    assertEquals("Type", weight.weightUnitOfMeasure);
    assertEquals(weightUnitOfMeasure, weight.getWeightUnitOfMeasure());
  }

  /**
   * Test {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>Given {@link Weight} (default constructor) Weight is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  public void testSetWeightUnitOfMeasure_givenWeightWeightIsBigDecimalWith23_whenNull() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    WeightUnitOfMeasureType weightUnitOfMeasure = new WeightUnitOfMeasureType("Type", "Friendly Type");

    weight.setWeightUnitOfMeasure(weightUnitOfMeasure);

    // Act
    weight.setWeightUnitOfMeasure(null);

    // Assert that nothing has changed
    assertEquals("Type", weight.weightUnitOfMeasure);
    assertEquals(weightUnitOfMeasure, weight.getWeightUnitOfMeasure());
  }

  /**
   * Test {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    Weight weight = new Weight();
    WeightUnitOfMeasureType weightUnitOfMeasure = new WeightUnitOfMeasureType("ThreadLocalManager.notify.orphans",
        "ThreadLocalManager.notify.orphans");

    weight.setWeightUnitOfMeasure(weightUnitOfMeasure);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    Weight clone = weight
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()))
        .getClone();
    assertEquals("ThreadLocalManager.notify.orphans", clone.weightUnitOfMeasure);
    assertEquals(weightUnitOfMeasure, clone.getWeightUnitOfMeasure());
  }

  /**
   * Test {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link DeferredOperation}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenDeferredOperation() throws CloneNotSupportedException {
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
   * Test {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then return not AlreadyPopulated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenReturnNotAlreadyPopulated() throws CloneNotSupportedException {
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
   * Test {@link Weight#equals(Object)}, and {@link Weight#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}, and {@link Weight#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}, and {@link Weight#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link Weight#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test getters and setters.
   * <p>
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
