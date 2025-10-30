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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractMetadataProviderDiffblueTest {
  /**
   * Test {@link AbstractMetadataProvider#setMetadataOverrides(Map)}.
   * <p>
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMetadataProvider.setMetadataOverrides(Map)"})
  public void testSetMetadataOverrides() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Assert
    assertTrue(adornedTargetCollectionFieldMetadataProvider.metadataOverrides.isEmpty());
  }

  /**
   * Test {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionFieldMetadataProvider} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractMetadataProvider.getTargetedOverride(DynamicEntityDao, String, String)"})
  public void testGetTargetedOverride_givenAdornedTargetCollectionFieldMetadataProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(),
        "Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Test {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractMetadataProvider.getTargetedOverride(DynamicEntityDao, String, String)"})
  public void testGetTargetedOverride_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(
        adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(), null, null));
  }

  /**
   * Test {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>When {@code Dr Jane Doe}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractMetadataProvider.getTargetedOverride(DynamicEntityDao, String, String)"})
  public void testGetTargetedOverride_whenDrJaneDoe_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .getTargetedOverride(new DynamicEntityDaoImpl(), null, "Dr Jane Doe"));
  }
}
