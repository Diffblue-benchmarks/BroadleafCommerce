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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RelatedProductDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedProductDTO#setCategoryId(Long)}
   *   <li>{@link RelatedProductDTO#setCumulativeResults(boolean)}
   *   <li>{@link RelatedProductDTO#setProductId(Long)}
   *   <li>{@link RelatedProductDTO#setQuantity(Integer)}
   *   <li>{@link RelatedProductDTO#setType(RelatedProductTypeEnum)}
   *   <li>{@link RelatedProductDTO#getCategoryId()}
   *   <li>{@link RelatedProductDTO#getProductId()}
   *   <li>{@link RelatedProductDTO#getQuantity()}
   *   <li>{@link RelatedProductDTO#getType()}
   *   <li>{@link RelatedProductDTO#isCumulativeResults()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();

    // Act
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    Long actualCategoryId = relatedProductDTO.getCategoryId();
    Long actualProductId = relatedProductDTO.getProductId();
    Integer actualQuantity = relatedProductDTO.getQuantity();
    RelatedProductTypeEnum actualType = relatedProductDTO.getType();
    boolean actualIsCumulativeResultsResult = relatedProductDTO.isCumulativeResults();

    // Assert that nothing has changed
    assertEquals(1, actualQuantity.intValue());
    assertEquals(1L, actualCategoryId.longValue());
    assertEquals(1L, actualProductId.longValue());
    assertTrue(actualIsCumulativeResultsResult);
    assertSame(actualType.CROSS_SALE, actualType);
  }

  /**
   * Test new {@link RelatedProductDTO} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link RelatedProductDTO}
   */
  @Test
  public void testNewRelatedProductDTO() {
    // Arrange and Act
    RelatedProductDTO actualRelatedProductDTO = new RelatedProductDTO();

    // Assert
    RelatedProductTypeEnum type = actualRelatedProductDTO.getType();
    assertEquals("FEATURED", type.getType());
    assertEquals("Featured", type.getFriendlyType());
    assertNull(actualRelatedProductDTO.getQuantity());
    assertNull(actualRelatedProductDTO.getCategoryId());
    assertNull(actualRelatedProductDTO.getProductId());
    assertTrue(actualRelatedProductDTO.isCumulativeResults());
  }
}
