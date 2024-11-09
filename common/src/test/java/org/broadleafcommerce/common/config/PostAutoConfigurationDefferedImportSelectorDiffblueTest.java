/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.LinkedMultiValueMap;

public class PostAutoConfigurationDefferedImportSelectorDiffblueTest {
  /**
   * Test
   * {@link PostAutoConfigurationDefferedImportSelector#selectImports(AnnotationMetadata)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PostAutoConfigurationDefferedImportSelector#selectImports(AnnotationMetadata)}
   */
  @Test
  public void testSelectImports_thenReturnArrayLengthIsZero() {
    // Arrange
    PostAutoConfigurationDefferedImportSelector postAutoConfigurationDefferedImportSelector = new PostAutoConfigurationDefferedImportSelector();

    LinkedMultiValueMap<String, Object> stringObjectMap = new LinkedMultiValueMap<>();
    stringObjectMap.addAll("value", new ArrayList<>());
    StandardAnnotationMetadata importingClassMetadata = mock(StandardAnnotationMetadata.class);
    when(importingClassMetadata.getAllAnnotationAttributes(Mockito.<String>any(), anyBoolean()))
        .thenReturn(stringObjectMap);

    // Act
    String[] actualSelectImportsResult = postAutoConfigurationDefferedImportSelector
        .selectImports(importingClassMetadata);

    // Assert
    verify(importingClassMetadata)
        .getAllAnnotationAttributes(eq("org.broadleafcommerce.common.config.PostAutoConfigurationImport"), eq(true));
    assertEquals(0, actualSelectImportsResult.length);
  }

  /**
   * Test new {@link PostAutoConfigurationDefferedImportSelector} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PostAutoConfigurationDefferedImportSelector}
   */
  @Test
  public void testNewPostAutoConfigurationDefferedImportSelector() {
    // Arrange and Act
    PostAutoConfigurationDefferedImportSelector actualPostAutoConfigurationDefferedImportSelector = new PostAutoConfigurationDefferedImportSelector();

    // Assert
    assertNull(actualPostAutoConfigurationDefferedImportSelector.getImportGroup());
    assertNull(actualPostAutoConfigurationDefferedImportSelector.getExclusionFilter());
  }
}
