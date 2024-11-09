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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.junit.Test;

public class DimensionDiffblueTest {
  /**
   * Test {@link Dimension#getDimensionString()}.
   * <p>
   * Method under test: {@link Dimension#getDimensionString()}
   */
  @Test
  public void testGetDimensionString() {
    // Arrange, Act and Assert
    assertEquals("nullHxnullWxnullD\"", (new Dimension()).getDimensionString());
  }

  /**
   * Test {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}.
   * <ul>
   *   <li>Then {@link Dimension} (default constructor)
   * {@link Dimension#dimensionUnitOfMeasure} is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}
   */
  @Test
  public void testSetDimensionUnitOfMeasure_thenDimensionDimensionUnitOfMeasureIsType() {
    // Arrange
    Dimension dimension = new Dimension();
    DimensionUnitOfMeasureType dimensionUnitOfMeasure = new DimensionUnitOfMeasureType("Type", "Friendly Type");

    // Act
    dimension.setDimensionUnitOfMeasure(dimensionUnitOfMeasure);

    // Assert
    assertEquals("Type", dimension.dimensionUnitOfMeasure);
    assertEquals(dimensionUnitOfMeasure, dimension.getDimensionUnitOfMeasure());
  }

  /**
   * Test {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Dimension} (default constructor)
   * {@link Dimension#dimensionUnitOfMeasure} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}
   */
  @Test
  public void testSetDimensionUnitOfMeasure_whenNull_thenDimensionDimensionUnitOfMeasureIsNull() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setDimensionUnitOfMeasure(null);

    // Assert that nothing has changed
    assertNull(dimension.dimensionUnitOfMeasure);
  }

  /**
   * Test {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    Dimension dimension = new Dimension();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    CreateResponse<Dimension> actualCreateOrRetrieveCopyInstanceResult = dimension
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(dimension, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    Dimension dimension = new Dimension();
    Catalog fromCatalog = mock(Catalog.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    CreateResponse<Dimension> actualCreateOrRetrieveCopyInstanceResult = dimension
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(dimension, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Dimension}
   *   <li>{@link Dimension#setDepth(BigDecimal)}
   *   <li>{@link Dimension#setGirth(BigDecimal)}
   *   <li>{@link Dimension#setHeight(BigDecimal)}
   *   <li>{@link Dimension#setWidth(BigDecimal)}
   *   <li>{@link Dimension#getDepth()}
   *   <li>{@link Dimension#getGirth()}
   *   <li>{@link Dimension#getHeight()}
   *   <li>{@link Dimension#getWidth()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Dimension actualDimension = new Dimension();
    BigDecimal depth = new BigDecimal("2.3");
    actualDimension.setDepth(depth);
    BigDecimal girth = new BigDecimal("2.3");
    actualDimension.setGirth(girth);
    BigDecimal height = new BigDecimal("2.3");
    actualDimension.setHeight(height);
    BigDecimal width = new BigDecimal("2.3");
    actualDimension.setWidth(width);
    BigDecimal actualDepth = actualDimension.getDepth();
    BigDecimal actualGirth = actualDimension.getGirth();
    BigDecimal actualHeight = actualDimension.getHeight();
    BigDecimal actualWidth = actualDimension.getWidth();

    // Assert that nothing has changed
    assertEquals(new BigDecimal("2.3"), actualDepth);
    assertEquals(new BigDecimal("2.3"), actualGirth);
    assertEquals(new BigDecimal("2.3"), actualHeight);
    assertEquals(new BigDecimal("2.3"), actualWidth);
    assertSame(depth, actualDepth);
    assertSame(girth, actualGirth);
    assertSame(height, actualHeight);
    assertSame(width, actualWidth);
  }
}
