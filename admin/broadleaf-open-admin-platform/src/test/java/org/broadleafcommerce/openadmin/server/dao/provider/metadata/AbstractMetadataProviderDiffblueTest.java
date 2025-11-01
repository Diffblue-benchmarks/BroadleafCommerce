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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class AbstractMetadataProviderDiffblueTest {
  /**
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  public void testSetMetadataOverrides() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Assert
    assertTrue(adornedTargetCollectionFieldMetadataProvider.metadataOverrides.isEmpty());
  }

  /**
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  public void testSetMetadataOverrides2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    HashMap<Object, Object> metadataOverrides = new HashMap<>();
    metadataOverrides.computeIfPresent("42", mock(BiFunction.class));

    // Act
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(metadataOverrides);

    // Assert
    assertTrue(adornedTargetCollectionFieldMetadataProvider.metadataOverrides.isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(),
        "Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(
        adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(), null, null));
  }

  /**
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .getTargetedOverride(new DynamicEntityDaoImpl(), null, "Dr Jane Doe"));
  }

  /**
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionFieldMetadataProvider())
        .getTargetedOverride(mock(DynamicEntityDaoImpl.class), "Configuration Key", "Dr Jane Doe"));
  }
}
