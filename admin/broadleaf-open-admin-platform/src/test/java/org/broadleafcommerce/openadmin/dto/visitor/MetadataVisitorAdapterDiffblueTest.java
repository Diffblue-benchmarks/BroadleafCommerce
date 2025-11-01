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
   * Method under test:
   * {@link MetadataVisitorAdapter#visit(AdornedTargetCollectionMetadata)}
   */
  @Test
  public void testVisit() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> metadataVisitorAdapter.visit(new AdornedTargetCollectionMetadata()));
  }

  /**
   * Method under test:
   * {@link MetadataVisitorAdapter#visit(BasicCollectionMetadata)}
   */
  @Test
  public void testVisit2() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new BasicCollectionMetadata()));
  }

  /**
   * Method under test: {@link MetadataVisitorAdapter#visit(BasicFieldMetadata)}
   */
  @Test
  public void testVisit3() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new BasicFieldMetadata()));
  }

  /**
   * Method under test: {@link MetadataVisitorAdapter#visit(GroupMetadata)}
   */
  @Test
  public void testVisit4() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new GroupMetadata()));
  }

  /**
   * Method under test: {@link MetadataVisitorAdapter#visit(MapMetadata)}
   */
  @Test
  public void testVisit5() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new MapMetadata()));
  }

  /**
   * Method under test: {@link MetadataVisitorAdapter#visit(TabMetadata)}
   */
  @Test
  public void testVisit6() {
    // Arrange
    MetadataVisitorAdapter metadataVisitorAdapter = new MetadataVisitorAdapter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metadataVisitorAdapter.visit(new TabMetadata()));
  }
}
