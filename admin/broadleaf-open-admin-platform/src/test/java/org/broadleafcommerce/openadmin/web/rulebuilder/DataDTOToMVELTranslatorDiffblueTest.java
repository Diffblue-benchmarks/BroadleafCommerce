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
package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DataDTOToMVELTranslator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataDTOToMVELTranslatorDiffblueTest {
  @Autowired
  private DataDTOToMVELTranslator dataDTOToMVELTranslator;

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildExpression() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals("foo(?Entity Key.?FieldOperator(Entity Key.Value))", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildExpression2() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("(");

    // Act
    dataDTOToMVELTranslator.buildExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals("(?Entity Key.?FieldOperator(Entity Key.Value)", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildExpression3() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("");

    // Act
    dataDTOToMVELTranslator.buildExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals("?Entity Key.?FieldOperator(Entity Key.Value)", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression4() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42==\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression5() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("foo");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("foo"));
    verify(fieldService).getSecondaryFieldType(eq("foo"));
    verify(fieldService).getSupportedFieldType(eq("foo"));
    assertEquals("foo(?Override Field Entity Key.?foo==\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression6() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService)
        .getOverrideFieldEntityKey(eq("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO"));
    verify(fieldService).getSecondaryFieldType(eq("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO"));
    verify(fieldService).getSupportedFieldType(eq("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO"));
    assertEquals(
        "foo(?Override Field Entity Key.?org.?broadleafcommerce.?openadmin.?web.?rulebuilder.?dto.?ExpressionDTO"
            + "==\"42\")",
        sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression7() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq(""));
    verify(fieldService).getSecondaryFieldType(eq(""));
    verify(fieldService).getSupportedFieldType(eq(""));
    assertEquals("foo(?Override Field Entity Key.?==\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression8() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42==)", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression9() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("?Override Field Entity Key.?42==\"42\"", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression10() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.NOT_EQUAL, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42!=\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression11() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.IEQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42==MvelHelper.toUpperCase(\"42\"))", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression12() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.INOT_EQUAL, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42!=MvelHelper.toUpperCase(\"42\"))", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression13() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("foo");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?foo.?42==\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression14() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("42");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?42.?42==\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression15() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?.?42==\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression16() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.ID);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42==42)", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression17() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.BOOLEAN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42==42)", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression18() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(expressionDTO, sb, "Entity Key", BLCOperator.GREATER_THAN, fieldService);

    // Assert
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
    assertEquals("foo(?Override Field Entity Key.?42>\"42\")", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpression19() throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getId()).thenReturn("42");
    when(expressionDTO.getValue()).thenReturn("42");
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(expressionDTO).setId(Mockito.<String>any());
    doNothing().when(expressionDTO).setOperator(Mockito.<String>any());
    doNothing().when(expressionDTO).setValue(Mockito.<String>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(SupportedFieldType.DATE);

    // Act and Assert
    assertThrows(MVELTranslationException.class, () -> dataDTOToMVELTranslator.buildExpression(expressionDTO, sb,
        "Entity Key", BLCOperator.EQUALS, fieldService));
    verify(expressionDTO).setCondition(eq("Condition"));
    verify(expressionDTO).setContainedPk(eq(1L));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(1L));
    verify(expressionDTO).setQuantity(eq(1));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(expressionDTO).getValue();
    verify(expressionDTO).setId(eq("42"));
    verify(expressionDTO).setOperator(eq("Operator"));
    verify(expressionDTO).setValue(eq("42"));
    verify(fieldService).getOverrideFieldEntityKey(eq("42"));
    verify(fieldService).getSecondaryFieldType(eq("42"));
    verify(fieldService).getSupportedFieldType(eq("42"));
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?Field Name", dataDTOToMVELTranslator.buildFieldName("Entity Key", "Field Name"));
    assertEquals("?.?.?Field Name", dataDTOToMVELTranslator.buildFieldName(".", "Field Name"));
    assertEquals("??.?Field Name", dataDTOToMVELTranslator.buildFieldName("?", "Field Name"));
    assertEquals("?\\.?.?Field Name", dataDTOToMVELTranslator.buildFieldName("\\.", "Field Name"));
    assertEquals("?.??.?Field Name", dataDTOToMVELTranslator.buildFieldName(".?", "Field Name"));
    assertEquals("?!.?Field Name", dataDTOToMVELTranslator.buildFieldName("!", "Field Name"));
    assertEquals("?42.?Field Name", dataDTOToMVELTranslator.buildFieldName("42", "Field Name"));
    assertEquals("?\".?Field Name", dataDTOToMVELTranslator.buildFieldName("\"", "Field Name"));
    assertEquals("?.?Field Name", dataDTOToMVELTranslator.buildFieldName("", "Field Name"));
    assertEquals("?).?Field Name", dataDTOToMVELTranslator.buildFieldName(")", "Field Name"));
    assertEquals("?Entity Key.?.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", "."));
    assertEquals("?Entity Key.??", dataDTOToMVELTranslator.buildFieldName("Entity Key", "?"));
    assertEquals("?Entity Key.?\\.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", "\\."));
    assertEquals("?Entity Key.?.??", dataDTOToMVELTranslator.buildFieldName("Entity Key", ".?"));
    assertEquals("?Entity Key.?!", dataDTOToMVELTranslator.buildFieldName("Entity Key", "!"));
    assertEquals("?Entity Key.?42", dataDTOToMVELTranslator.buildFieldName("Entity Key", "42"));
    assertEquals("?Entity Key.?\"", dataDTOToMVELTranslator.buildFieldName("Entity Key", "\""));
    assertEquals("?Entity Key.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", ""));
    assertEquals("?Entity Key.?)", dataDTOToMVELTranslator.buildFieldName("Entity Key", ")"));
    assertEquals("?,.?Field Name", dataDTOToMVELTranslator.buildFieldName(",", "Field Name"));
    assertEquals("?.?.?.?", dataDTOToMVELTranslator.buildFieldName(".", "."));
    assertEquals("?.?.??", dataDTOToMVELTranslator.buildFieldName(".", "?"));
    assertEquals("?.?.?\\.?", dataDTOToMVELTranslator.buildFieldName(".", "\\."));
    assertEquals("?.?.?.??", dataDTOToMVELTranslator.buildFieldName(".", ".?"));
    assertEquals("?.?.?!", dataDTOToMVELTranslator.buildFieldName(".", "!"));
    assertEquals("?.?.?42", dataDTOToMVELTranslator.buildFieldName(".", "42"));
    assertEquals("?.?.?\"", dataDTOToMVELTranslator.buildFieldName(".", "\""));
    assertEquals("?.?.?", dataDTOToMVELTranslator.buildFieldName(".", ""));
    assertEquals("?.?.?)", dataDTOToMVELTranslator.buildFieldName(".", ")"));
    assertEquals("??.?.?", dataDTOToMVELTranslator.buildFieldName("?", "."));
    assertEquals("??.??", dataDTOToMVELTranslator.buildFieldName("?", "?"));
    assertEquals("??.?\\.?", dataDTOToMVELTranslator.buildFieldName("?", "\\."));
    assertEquals("??.?.??", dataDTOToMVELTranslator.buildFieldName("?", ".?"));
    assertEquals("??.?!", dataDTOToMVELTranslator.buildFieldName("?", "!"));
    assertEquals("??.?42", dataDTOToMVELTranslator.buildFieldName("?", "42"));
    assertEquals("??.?\"", dataDTOToMVELTranslator.buildFieldName("?", "\""));
    assertEquals("??.?", dataDTOToMVELTranslator.buildFieldName("?", ""));
    assertEquals("??.?)", dataDTOToMVELTranslator.buildFieldName("?", ")"));
    assertEquals("?\\.?.?.?", dataDTOToMVELTranslator.buildFieldName("\\.", "."));
    assertEquals("?\\.?.??", dataDTOToMVELTranslator.buildFieldName("\\.", "?"));
    assertEquals("?\\.?.?\\.?", dataDTOToMVELTranslator.buildFieldName("\\.", "\\."));
    assertEquals("?\\.?.?.??", dataDTOToMVELTranslator.buildFieldName("\\.", ".?"));
    assertEquals("?\\.?.?!", dataDTOToMVELTranslator.buildFieldName("\\.", "!"));
    assertEquals("?\\.?.?42", dataDTOToMVELTranslator.buildFieldName("\\.", "42"));
    assertEquals("?\\.?.?\"", dataDTOToMVELTranslator.buildFieldName("\\.", "\""));
    assertEquals("?\\.?.?", dataDTOToMVELTranslator.buildFieldName("\\.", ""));
    assertEquals("?\\.?.?)", dataDTOToMVELTranslator.buildFieldName("\\.", ")"));
    assertEquals("?.??.?.?", dataDTOToMVELTranslator.buildFieldName(".?", "."));
    assertEquals("?.??.??", dataDTOToMVELTranslator.buildFieldName(".?", "?"));
    assertEquals("?.??.?\\.?", dataDTOToMVELTranslator.buildFieldName(".?", "\\."));
    assertEquals("?.??.?.??", dataDTOToMVELTranslator.buildFieldName(".?", ".?"));
    assertEquals("?.??.?!", dataDTOToMVELTranslator.buildFieldName(".?", "!"));
    assertEquals("?.??.?42", dataDTOToMVELTranslator.buildFieldName(".?", "42"));
    assertEquals("?.??.?\"", dataDTOToMVELTranslator.buildFieldName(".?", "\""));
    assertEquals("?.??.?", dataDTOToMVELTranslator.buildFieldName(".?", ""));
    assertEquals("?.??.?)", dataDTOToMVELTranslator.buildFieldName(".?", ")"));
    assertEquals("?!.?.?", dataDTOToMVELTranslator.buildFieldName("!", "."));
    assertEquals("?!.??", dataDTOToMVELTranslator.buildFieldName("!", "?"));
    assertEquals("?!.?\\.?", dataDTOToMVELTranslator.buildFieldName("!", "\\."));
    assertEquals("?!.?.??", dataDTOToMVELTranslator.buildFieldName("!", ".?"));
    assertEquals("?!.?!", dataDTOToMVELTranslator.buildFieldName("!", "!"));
    assertEquals("?!.?42", dataDTOToMVELTranslator.buildFieldName("!", "42"));
    assertEquals("?!.?\"", dataDTOToMVELTranslator.buildFieldName("!", "\""));
    assertEquals("?!.?", dataDTOToMVELTranslator.buildFieldName("!", ""));
    assertEquals("?!.?)", dataDTOToMVELTranslator.buildFieldName("!", ")"));
    assertEquals("?42.?.?", dataDTOToMVELTranslator.buildFieldName("42", "."));
    assertEquals("?42.??", dataDTOToMVELTranslator.buildFieldName("42", "?"));
    assertEquals("?42.?\\.?", dataDTOToMVELTranslator.buildFieldName("42", "\\."));
    assertEquals("?42.?.??", dataDTOToMVELTranslator.buildFieldName("42", ".?"));
    assertEquals("?42.?!", dataDTOToMVELTranslator.buildFieldName("42", "!"));
    assertEquals("?42.?42", dataDTOToMVELTranslator.buildFieldName("42", "42"));
    assertEquals("?42.?\"", dataDTOToMVELTranslator.buildFieldName("42", "\""));
    assertEquals("?42.?", dataDTOToMVELTranslator.buildFieldName("42", ""));
    assertEquals("?42.?)", dataDTOToMVELTranslator.buildFieldName("42", ")"));
    assertEquals("?\".?.?", dataDTOToMVELTranslator.buildFieldName("\"", "."));
    assertEquals("?\".??", dataDTOToMVELTranslator.buildFieldName("\"", "?"));
    assertEquals("?\".?\\.?", dataDTOToMVELTranslator.buildFieldName("\"", "\\."));
    assertEquals("?\".?.??", dataDTOToMVELTranslator.buildFieldName("\"", ".?"));
    assertEquals("?\".?!", dataDTOToMVELTranslator.buildFieldName("\"", "!"));
    assertEquals("?\".?42", dataDTOToMVELTranslator.buildFieldName("\"", "42"));
    assertEquals("?\".?\"", dataDTOToMVELTranslator.buildFieldName("\"", "\""));
    assertEquals("?\".?", dataDTOToMVELTranslator.buildFieldName("\"", ""));
    assertEquals("?\".?)", dataDTOToMVELTranslator.buildFieldName("\"", ")"));
    assertEquals("?.??", dataDTOToMVELTranslator.buildFieldName("", "?"));
    assertEquals("?.?\\.?", dataDTOToMVELTranslator.buildFieldName("", "\\."));
    assertEquals("?.?!", dataDTOToMVELTranslator.buildFieldName("", "!"));
    assertEquals("?.?42", dataDTOToMVELTranslator.buildFieldName("", "42"));
    assertEquals("?.?\"", dataDTOToMVELTranslator.buildFieldName("", "\""));
    assertEquals("?.?", dataDTOToMVELTranslator.buildFieldName("", ""));
    assertEquals("?.?)", dataDTOToMVELTranslator.buildFieldName("", ")"));
    assertEquals("?).?.?", dataDTOToMVELTranslator.buildFieldName(")", "."));
    assertEquals("?).??", dataDTOToMVELTranslator.buildFieldName(")", "?"));
    assertEquals("?).?\\.?", dataDTOToMVELTranslator.buildFieldName(")", "\\."));
    assertEquals("?).?.??", dataDTOToMVELTranslator.buildFieldName(")", ".?"));
    assertEquals("?).?!", dataDTOToMVELTranslator.buildFieldName(")", "!"));
    assertEquals("?).?42", dataDTOToMVELTranslator.buildFieldName(")", "42"));
    assertEquals("?).?\"", dataDTOToMVELTranslator.buildFieldName(")", "\""));
    assertEquals("?).?", dataDTOToMVELTranslator.buildFieldName(")", ""));
    assertEquals("?).?)", dataDTOToMVELTranslator.buildFieldName(")", ")"));
    assertEquals("?Entity Key.?,", dataDTOToMVELTranslator.buildFieldName("Entity Key", ","));
    assertEquals("?,.?.?", dataDTOToMVELTranslator.buildFieldName(",", "."));
    assertEquals("?,.??", dataDTOToMVELTranslator.buildFieldName(",", "?"));
    assertEquals("?,.?\\.?", dataDTOToMVELTranslator.buildFieldName(",", "\\."));
    assertEquals("?,.?.??", dataDTOToMVELTranslator.buildFieldName(",", ".?"));
    assertEquals("?,.?!", dataDTOToMVELTranslator.buildFieldName(",", "!"));
    assertEquals("?,.?42", dataDTOToMVELTranslator.buildFieldName(",", "42"));
    assertEquals("?,.?\"", dataDTOToMVELTranslator.buildFieldName(",", "\""));
    assertEquals("?,.?", dataDTOToMVELTranslator.buildFieldName(",", ""));
    assertEquals("?,.?)", dataDTOToMVELTranslator.buildFieldName(",", ")"));
    assertEquals("?.?.?,", dataDTOToMVELTranslator.buildFieldName(".", ","));
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?Field",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?.?.?Field", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?---.?Field", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("??.?Field", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?\\.?.?Field", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?.??.?Field", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?!.?Field", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?42.?Field", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?\".?Field", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?.?Field", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?).?Field", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?Entity Key.?.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ".", true));
    assertThrows(UnsupportedOperationException.class,
        () -> dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "---", true));
    assertEquals("?Entity Key.??",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?Entity Key.?\\.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?Entity Key.?.??",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?Entity Key.?!",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?Entity Key.?42",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?Entity Key.?\"",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?Entity Key.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?Entity Key.?)",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?,.?Field", dataDTOToMVELTranslator.formatField(",", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?.?.?.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?.?.??", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?.?.?\\.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?.?.?.??", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?.?.?!", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?.?.?42", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?.?.?\"", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?.?.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?.?.?)", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?---.?.?", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?---.??", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?---.?\\.?", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?---.?.??", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?---.?!", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?---.?42", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?---.?\"", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?---.?", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?---.?)", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("??.?.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("??.??", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("??.?\\.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("??.?.??", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("??.?!", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("??.?42", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("??.?\"", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("??.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("??.?)", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?\\.?.?.?", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?\\.?.??", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?\\.?.?\\.?", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?\\.?.?.??", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?\\.?.?!", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?\\.?.?42", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?\\.?.?\"", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?\\.?.?", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?\\.?.?)", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?.??.?.?", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?.??.??", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?.??.?\\.?", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?.??.?.??", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?.??.?!", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?.??.?42", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?.??.?\"", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?.??.?", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?.??.?)", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?!.?.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?!.??", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?!.?\\.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?!.?.??", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?!.?!", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?!.?42", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?!.?\"", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?!.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?!.?)", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?42.?.?", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?42.??", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?42.?\\.?", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?42.?.??", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?42.?!", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?42.?42", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?42.?\"", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?42.?", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?42.?)", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?\".?.?", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?\".??", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?\".?\\.?", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?\".?.??", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?\".?!", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?\".?42", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?\".?\"", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?\".?", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?\".?)", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?.??", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?.?\\.?", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?.?!", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?.?42", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?.?\"", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?.?", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?.?)", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?).?.?", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?).??", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?).?\\.?", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?).?.??", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?).?!", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?).?42", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?).?\"", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?).?", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?).?)", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?Entity Key.?,",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ",", true));
    assertEquals("MvelHelper.convertField(\"BOOLEAN\",?Entity Key.?[\"\"])",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.BOOLEAN, "---", true));
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("Entity Key.Value", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, true, true, true));
    assertEquals("MvelHelper.toUpperCase(Value)", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
    assertThrows(MVELTranslationException.class, () -> dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.ID, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
    assertEquals("Value", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.BOOLEAN,
        SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
    assertEquals("MvelHelper.toUpperCase(\\\\\")", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"\\\""}, false, true, true));
    assertEquals("", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN, new Object[]{""}, false, true, true));
    assertEquals("MvelHelper.toUpperCase(Value),MvelHelper.toUpperCase(Value)",
        dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.UNKNOWN,
            SupportedFieldType.UNKNOWN, new Object[]{"Value", "Value"}, false, true, true));
    assertEquals("Value", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, false, true));
    assertEquals("MvelHelper.toUpperCase(\"Value\")", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, false));
    assertThrows(MVELTranslationException.class, () -> dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.DATE, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
    assertThrows(MVELTranslationException.class, () -> dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.ID, null, new Object[]{"Value"}, false, true, true));
    assertEquals("42", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.ID,
        SupportedFieldType.UNKNOWN, new Object[]{42}, false, true, true));
  }

  /**
   * Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  public void testExtractBasicValues() {
    // Arrange and Act
    Object[] actualExtractBasicValuesResult = (new DataDTOToMVELTranslator()).extractBasicValues("Value");

    // Assert
    assertEquals("Value", actualExtractBasicValuesResult[0]);
    assertEquals(1, actualExtractBasicValuesResult.length);
  }

  /**
   * Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  public void testExtractBasicValues2() {
    // Arrange, Act and Assert
    assertNull((new DataDTOToMVELTranslator()).extractBasicValues(null));
  }

  /**
   * Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  public void testExtractBasicValues3() {
    // Arrange and Act
    Object[] actualExtractBasicValuesResult = (new DataDTOToMVELTranslator()).extractBasicValues("[");

    // Assert
    assertEquals("[", actualExtractBasicValuesResult[0]);
    assertEquals(1, actualExtractBasicValuesResult.length);
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes() {
    // Arrange, Act and Assert
    assertEquals("42", dataDTOToMVELTranslator.escapeInternalQuotes("42"));
    assertEquals("\"", dataDTOToMVELTranslator.escapeInternalQuotes("\""));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("", dataDTOToMVELTranslator.escapeInternalQuotes(""));
    assertEquals("42(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("42(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("\"(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)42",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)42"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\""));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\\\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\\""));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)Processed Value",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)Processed Value"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)!",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)!"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$))",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$))"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$),",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$),"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)---",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)---"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)==",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)=="));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)MvelHelper.toUpperCase("));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)[",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)["));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\""));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\u0022"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)]",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)]"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator
            .escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator
            .escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator
            .escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)||",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)||"));
    assertEquals("\\\\\\\"42", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"42"));
    assertEquals("\\\\\\\"\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\""));
    assertEquals("\\\\\\\"(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("\\\\\\\"\\\\\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\\\""));
    assertEquals("\\\\\\\"Processed Value", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"Processed Value"));
    assertEquals("\\\\\\\"!", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"!"));
    assertEquals("\\\\\\\")", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\")"));
    assertEquals("\\\\\\\",", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\","));
    assertEquals("\\\\\\\"---", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"---"));
    assertEquals("\\\\\\\"==", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"=="));
    assertEquals("\\\\\\\"MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"MvelHelper.toUpperCase("));
    assertEquals("\\\\\\\"[", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"["));
    assertEquals("\\\\\\\"\\\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\""));
    assertEquals("\\\\\\\"\\\\u0022", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\\u0022"));
    assertEquals("\\\\\\\"]", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"]"));
    assertEquals("\\\\\\\"org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"org.apache.commons.lang3.StringUtils.contains"));
    assertEquals("\\\\\\\"org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"org.apache.commons.lang3.StringUtils.endsWith"));
    assertEquals("\\\\\\\"org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"org.apache.commons.lang3.StringUtils.startsWith"));
    assertEquals("\\\\\\\"||", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"||"));
    assertEquals("Processed Value(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("Processed Value(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("!(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("!(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(")(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes(")(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(",(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes(",(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes() {
    // Arrange, Act and Assert
    assertEquals("42", dataDTOToMVELTranslator.escapeInternalMiltyQuotes("42"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("42(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("42(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("\"(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)42",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)42"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\"",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\""));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)", dataDTOToMVELTranslator
        .escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\\\u0022"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)Processed Value",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)Processed Value"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)!",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)!"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$))",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$))"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$),",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$),"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)---",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)---"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)==",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)=="));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)MvelHelper.toUpperCase("));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)[",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)["));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\"",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\""));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\u0022"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)]",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)]"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator
            .escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator
            .escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)||",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)||"));
    assertEquals("\\\\\\u0022(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("\\\\\\u0022(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("Processed Value(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("Processed Value(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("!(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("!(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(")(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(")(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(",(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(",(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Method under test: {@link DataDTOToMVELTranslator#isProjection(Object)}
   */
  @Test
  public void testIsProjection() {
    // Arrange, Act and Assert
    assertFalse((new DataDTOToMVELTranslator()).isProjection("Value"));
    assertFalse((new DataDTOToMVELTranslator()).isProjection("["));
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildCollectionExpression() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?Entity Key.?Field,[Entity Key.Value])Operator", sb.toString());
  }

  /**
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildCollectionExpression2() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer(".");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals(".CollectionUtils.intersection(?Entity Key.?Field,[Entity Key.Value])Operator", sb.toString());
  }
}
