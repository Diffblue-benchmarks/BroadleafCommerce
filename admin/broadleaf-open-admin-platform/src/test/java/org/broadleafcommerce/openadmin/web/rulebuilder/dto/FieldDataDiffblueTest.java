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
package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData.Builder;
import org.junit.Test;

public class FieldDataDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
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

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldData#setSkipValidation(boolean)}
   *   <li>{@link FieldData#getFieldLabel()}
   *   <li>{@link FieldData#getFieldName()}
   *   <li>{@link FieldData#getFieldType()}
   *   <li>{@link FieldData#getOperators()}
   *   <li>{@link FieldData#getOptions()}
   *   <li>{@link FieldData#getOverrideDtoClassName()}
   *   <li>{@link FieldData#getOverrideEntityKey()}
   *   <li>{@link FieldData#getSecondaryFieldType()}
   *   <li>{@link FieldData#getSelectizeSectionKey()}
   *   <li>{@link FieldData#getSkipValidation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FieldData buildResult = (new FieldData.Builder()).label("Field Label")
        .name("Field Name")
        .type(SupportedFieldType.UNKNOWN)
        .operators("Operators")
        .options("Options")
        .overrideEntityKey("Override Entity Key")
        .secondaryType(SupportedFieldType.UNKNOWN)
        .selectizeSectionKey("Selectize Section Key")
        .skipValidation(true)
        .build();

    // Act
    buildResult.setSkipValidation(true);
    String actualFieldLabel = buildResult.getFieldLabel();
    String actualFieldName = buildResult.getFieldName();
    SupportedFieldType actualFieldType = buildResult.getFieldType();
    String actualOperators = buildResult.getOperators();
    String actualOptions = buildResult.getOptions();
    buildResult.getOverrideDtoClassName();
    String actualOverrideEntityKey = buildResult.getOverrideEntityKey();
    SupportedFieldType actualSecondaryFieldType = buildResult.getSecondaryFieldType();
    String actualSelectizeSectionKey = buildResult.getSelectizeSectionKey();

    // Assert that nothing has changed
    assertEquals("Field Label", actualFieldLabel);
    assertEquals("Field Name", actualFieldName);
    assertEquals("Operators", actualOperators);
    assertEquals("Options", actualOptions);
    assertEquals("Override Entity Key", actualOverrideEntityKey);
    assertEquals("Selectize Section Key", actualSelectizeSectionKey);
    assertEquals(SupportedFieldType.UNKNOWN, actualFieldType);
    assertEquals(SupportedFieldType.UNKNOWN, actualSecondaryFieldType);
    assertTrue(buildResult.getSkipValidation());
  }
}
