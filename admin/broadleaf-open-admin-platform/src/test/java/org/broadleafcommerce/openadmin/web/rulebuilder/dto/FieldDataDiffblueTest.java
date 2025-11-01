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
package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.junit.Test;

public class FieldDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldData.Builder#build()}
   *   <li>default or parameterless constructor of {@link FieldData.Builder}
   *   <li>{@link FieldData.Builder#label(String)}
   *   <li>{@link FieldData.Builder#name(String)}
   *   <li>{@link FieldData.Builder#operators(String)}
   *   <li>{@link FieldData.Builder#options(String)}
   *   <li>{@link FieldData.Builder#overrideEntityKey(String)}
   *   <li>{@link FieldData.Builder#secondaryType(SupportedFieldType)}
   *   <li>{@link FieldData.Builder#selectizeSectionKey(String)}
   *   <li>{@link FieldData.Builder#skipValidation(boolean)}
   *   <li>{@link FieldData.Builder#type(SupportedFieldType)}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange and Act
    FieldData actualBuildResult = (new FieldData.Builder()).label("Field Label")
        .name("Field Name")
        .operators("Operators")
        .options("Options")
        .overrideEntityKey("Override Entity Key")
        .secondaryType(SupportedFieldType.UNKNOWN)
        .selectizeSectionKey("Selectize Section Key")
        .skipValidation(true)
        .type(SupportedFieldType.UNKNOWN)
        .build();

    // Assert
    assertEquals("Field Label", actualBuildResult.getFieldLabel());
    assertEquals("Field Name", actualBuildResult.getFieldName());
    assertEquals("Operators", actualBuildResult.getOperators());
    assertEquals("Options", actualBuildResult.getOptions());
    assertEquals("Override Entity Key", actualBuildResult.getOverrideEntityKey());
    assertEquals("Selectize Section Key", actualBuildResult.getSelectizeSectionKey());
    assertNull(actualBuildResult.getOverrideDtoClassName());
    assertEquals(SupportedFieldType.UNKNOWN, actualBuildResult.getFieldType());
    assertEquals(SupportedFieldType.UNKNOWN, actualBuildResult.getSecondaryFieldType());
    assertTrue(actualBuildResult.getSkipValidation());
  }
}
