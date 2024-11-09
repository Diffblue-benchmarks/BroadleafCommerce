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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class CatalogReindexCommandDiffblueTest {
  /**
   * Test {@link CatalogReindexCommand#CatalogReindexCommand(Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return CatalogId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogReindexCommand#CatalogReindexCommand(Long)}
   */
  @Test
  public void testNewCatalogReindexCommand_whenOne_thenReturnCatalogIdLongValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1L, (new CatalogReindexCommand(1L)).getCatalogId().longValue());
  }

  /**
   * Test {@link CatalogReindexCommand#getCatalogId()}.
   * <p>
   * Method under test: {@link CatalogReindexCommand#getCatalogId()}
   */
  @Test
  public void testGetCatalogId() {
    // Arrange, Act and Assert
    assertEquals(1L, (new CatalogReindexCommand(1L)).getCatalogId().longValue());
  }

  /**
   * Test {@link CatalogReindexCommand#equals(Object)}, and
   * {@link CatalogReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogReindexCommand#equals(Object)}
   *   <li>{@link CatalogReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CatalogReindexCommand catalogReindexCommand = new CatalogReindexCommand(1L);
    CatalogReindexCommand catalogReindexCommand2 = new CatalogReindexCommand(1L);

    // Act and Assert
    assertEquals(catalogReindexCommand, catalogReindexCommand2);
    int expectedHashCodeResult = catalogReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, catalogReindexCommand2.hashCode());
  }

  /**
   * Test {@link CatalogReindexCommand#equals(Object)}, and
   * {@link CatalogReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogReindexCommand#equals(Object)}
   *   <li>{@link CatalogReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CatalogReindexCommand catalogReindexCommand = new CatalogReindexCommand(1L);

    // Act and Assert
    assertEquals(catalogReindexCommand, catalogReindexCommand);
    int expectedHashCodeResult = catalogReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, catalogReindexCommand.hashCode());
  }

  /**
   * Test {@link CatalogReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CatalogReindexCommand catalogReindexCommand = new CatalogReindexCommand(2L);

    // Act and Assert
    assertNotEquals(catalogReindexCommand, new CatalogReindexCommand(1L));
  }

  /**
   * Test {@link CatalogReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CatalogReindexCommand(1L), null);
  }

  /**
   * Test {@link CatalogReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CatalogReindexCommand(1L), "Different type to CatalogReindexCommand");
  }
}
