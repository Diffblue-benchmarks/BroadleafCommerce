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
package org.broadleafcommerce.openadmin.dto.visitor;

import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.GroupMetadata;
import org.broadleafcommerce.openadmin.dto.MapMetadata;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.junit.Test;

public class MetadataVisitorAdapterDiffblueTest {
  /**
   * Test {@link MetadataVisitorAdapter#visit(AdornedTargetCollectionMetadata)}
   * with {@code AdornedTargetCollectionMetadata}.
   * <p>
   * Method under test:
   * {@link MetadataVisitorAdapter#visit(AdornedTargetCollectionMetadata)}
   */
  @Test
  public void testVisitWithAdornedTargetCollectionMetadata() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> metadataVisitorAdapter.visit(new AdornedTargetCollectionMetadata()));
  }

  /**
   * Test {@link MetadataVisitorAdapter#visit(BasicCollectionMetadata)} with
   * {@code BasicCollectionMetadata}.
   * <p>
   * Method under test:
   * {@link MetadataVisitorAdapter#visit(BasicCollectionMetadata)}
   */
  @Test
  public void testVisitWithBasicCollectionMetadata() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new BasicCollectionMetadata()));
  }

  /**
   * Test {@link MetadataVisitorAdapter#visit(BasicFieldMetadata)} with
   * {@code BasicFieldMetadata}.
   * <p>
   * Method under test: {@link MetadataVisitorAdapter#visit(BasicFieldMetadata)}
   */
  @Test
  public void testVisitWithBasicFieldMetadata() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new BasicFieldMetadata()));
  }

  /**
   * Test {@link MetadataVisitorAdapter#visit(GroupMetadata)} with
   * {@code GroupMetadata}.
   * <p>
   * Method under test: {@link MetadataVisitorAdapter#visit(GroupMetadata)}
   */
  @Test
  public void testVisitWithGroupMetadata() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new GroupMetadata()));
  }

  /**
   * Test {@link MetadataVisitorAdapter#visit(MapMetadata)} with
   * {@code MapMetadata}.
   * <p>
   * Method under test: {@link MetadataVisitorAdapter#visit(MapMetadata)}
   */
  @Test
  public void testVisitWithMapMetadata() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new MapMetadata()));
  }

  /**
   * Test {@link MetadataVisitorAdapter#visit(TabMetadata)} with
   * {@code TabMetadata}.
   * <p>
   * Method under test: {@link MetadataVisitorAdapter#visit(TabMetadata)}
   */
  @Test
  public void testVisitWithTabMetadata() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new TabMetadata()));
  }
}
