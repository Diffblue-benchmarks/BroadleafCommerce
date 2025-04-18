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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.override.MetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AbstractMetadataProviderDiffblueTest {
  @InjectMocks
  private AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;

  @Mock
  private Map map;

  /**
   * Test {@link AbstractMetadataProvider#setMetadataOverrides(Map)}.
   * <p>
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMetadataProvider.setMetadataOverrides(Map)"})
  public void testSetMetadataOverrides() {
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
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(),
        "Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Test {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractMetadataProvider.getTargetedOverride(DynamicEntityDao, String, String)"})
  public void testGetTargetedOverride_givenMapGetReturnHashMap_thenReturnEmpty() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act
    Map<String, MetadataOverride> actualTargetedOverride = adornedTargetCollectionFieldMetadataProvider
        .getTargetedOverride(new DynamicEntityDaoImpl(), "Configuration Key", "Dr Jane Doe");

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertTrue(actualTargetedOverride.isEmpty());
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
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractMetadataProvider.getTargetedOverride(DynamicEntityDao, String, String)"})
  public void testGetTargetedOverride_thenThrowRuntimeException() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .getTargetedOverride(new DynamicEntityDaoImpl(), null, "Dr Jane Doe"));
  }
}
