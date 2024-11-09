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
   * Test {@link AbstractMetadataProvider#setMetadataOverrides(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code 42} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  public void testSetMetadataOverrides_given42_whenHashMapComputeIfPresent42AndBiFunction() {
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
   * Test {@link AbstractMetadataProvider#setMetadataOverrides(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  public void testSetMetadataOverrides_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Assert
    assertTrue(adornedTargetCollectionFieldMetadataProvider.metadataOverrides.isEmpty());
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionFieldMetadataProvider} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_givenAdornedTargetCollectionFieldMetadataProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(),
        "Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(
        adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(), null, null));
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .getTargetedOverride(new DynamicEntityDaoImpl(), null, "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>When {@link DynamicEntityDaoImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_whenDynamicEntityDaoImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionFieldMetadataProvider())
        .getTargetedOverride(mock(DynamicEntityDaoImpl.class), "Configuration Key", "Dr Jane Doe"));
  }
}
