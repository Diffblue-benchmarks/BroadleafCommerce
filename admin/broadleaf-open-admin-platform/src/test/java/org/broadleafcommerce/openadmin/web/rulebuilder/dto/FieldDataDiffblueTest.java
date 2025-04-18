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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData.Builder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Builder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldDataDiffblueTest {
  @Autowired
  private Builder builder;

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#label(String)}
   *   <li>{@link Builder#name(String)}
   *   <li>{@link Builder#operators(String)}
   *   <li>{@link Builder#options(String)}
   *   <li>{@link Builder#overrideEntityKey(String)}
   *   <li>{@link Builder#secondaryType(SupportedFieldType)}
   *   <li>{@link Builder#selectizeSectionKey(String)}
   *   <li>{@link Builder#skipValidation(boolean)}
   *   <li>{@link Builder#type(SupportedFieldType)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Builder.<init>()", "FieldData Builder.build()", "Builder Builder.label(String)",
      "Builder Builder.name(String)", "Builder Builder.operators(String)", "Builder Builder.options(String)",
      "Builder Builder.overrideDtoClassName(String)", "Builder Builder.overrideEntityKey(String)",
      "Builder Builder.secondaryType(SupportedFieldType)", "Builder Builder.selectizeSectionKey(String)",
      "Builder Builder.skipValidation(boolean)", "Builder Builder.type(SupportedFieldType)"})
  public void testBuilderBuild() {
    // Arrange and Act
    FieldData actualBuildResult = (new Builder()).label("Field Label")
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldData.getFieldLabel()", "String FieldData.getFieldName()",
      "SupportedFieldType FieldData.getFieldType()", "String FieldData.getOperators()", "String FieldData.getOptions()",
      "String FieldData.getOverrideDtoClassName()", "String FieldData.getOverrideEntityKey()",
      "SupportedFieldType FieldData.getSecondaryFieldType()", "String FieldData.getSelectizeSectionKey()",
      "boolean FieldData.getSkipValidation()", "void FieldData.setSkipValidation(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    FieldData buildResult = (new Builder()).label("Field Label")
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
    String actualOverrideDtoClassName = buildResult.getOverrideDtoClassName();
    String actualOverrideEntityKey = buildResult.getOverrideEntityKey();
    SupportedFieldType actualSecondaryFieldType = buildResult.getSecondaryFieldType();
    String actualSelectizeSectionKey = buildResult.getSelectizeSectionKey();

    // Assert
    assertEquals("Field Label", actualFieldLabel);
    assertEquals("Field Name", actualFieldName);
    assertEquals("Operators", actualOperators);
    assertEquals("Options", actualOptions);
    assertEquals("Override Entity Key", actualOverrideEntityKey);
    assertEquals("Selectize Section Key", actualSelectizeSectionKey);
    assertNull(actualOverrideDtoClassName);
    assertEquals(SupportedFieldType.UNKNOWN, actualFieldType);
    assertEquals(SupportedFieldType.UNKNOWN, actualSecondaryFieldType);
    assertTrue(buildResult.getSkipValidation());
  }
}
