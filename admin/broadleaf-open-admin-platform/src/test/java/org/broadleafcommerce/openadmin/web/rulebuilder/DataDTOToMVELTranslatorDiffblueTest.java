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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService2() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService3() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService4() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService5() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService6() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService7() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService8() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService9() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService10() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService11() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService12() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService13() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService14() throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <ul>
   *   <li>Given {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenBoolean()
      throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   * with {@code expressionDTO}, {@code sb}, {@code entityKey}, {@code operator},
   * {@code fieldService}.
   * <ul>
   *   <li>Given {@code ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenId()
      throws MVELTranslationException {
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
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value},
   * {@code type}, {@code secondaryType}, {@code operator},
   * {@code includeParenthesis}, {@code isFieldComparison}, {@code ignoreCase},
   * {@code isNegation}, {@code ignoreQuotes}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes()
      throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals("foo(?Entity Key.?FieldOperator(Entity Key.Value))", sb.toString());
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value},
   * {@code type}, {@code secondaryType}, {@code operator},
   * {@code includeParenthesis}, {@code isFieldComparison}, {@code ignoreCase},
   * {@code isNegation}, {@code ignoreQuotes}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes2()
      throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("(");

    // Act
    dataDTOToMVELTranslator.buildExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals("(?Entity Key.?FieldOperator(Entity Key.Value)", sb.toString());
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value},
   * {@code type}, {@code secondaryType}, {@code operator},
   * {@code includeParenthesis}, {@code isFieldComparison}, {@code ignoreCase},
   * {@code isNegation}, {@code ignoreQuotes}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes3()
      throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("");

    // Act
    dataDTOToMVELTranslator.buildExpression(sb, "Entity Key", "Field", new Object[]{"Value"},
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, "Operator", true, true, true, true, true);

    // Assert
    assertEquals("?Entity Key.?FieldOperator(Entity Key.Value)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName() {
    // Arrange, Act and Assert
    assertEquals("?.?.?.?", dataDTOToMVELTranslator.buildFieldName(".", "."));
    assertEquals("?.?.??", dataDTOToMVELTranslator.buildFieldName(".", "?"));
    assertEquals("?.?.?\\.?", dataDTOToMVELTranslator.buildFieldName(".", "\\."));
    assertEquals("?.?.?.??", dataDTOToMVELTranslator.buildFieldName(".", ".?"));
    assertEquals("?.?.?!", dataDTOToMVELTranslator.buildFieldName(".", "!"));
    assertEquals("?.?.?\"", dataDTOToMVELTranslator.buildFieldName(".", "\""));
    assertEquals("?.?.?)", dataDTOToMVELTranslator.buildFieldName(".", ")"));
    assertEquals("??.?.?", dataDTOToMVELTranslator.buildFieldName("?", "."));
    assertEquals("??.?\\.?", dataDTOToMVELTranslator.buildFieldName("?", "\\."));
    assertEquals("??.?.??", dataDTOToMVELTranslator.buildFieldName("?", ".?"));
    assertEquals("??.?!", dataDTOToMVELTranslator.buildFieldName("?", "!"));
    assertEquals("??.?\"", dataDTOToMVELTranslator.buildFieldName("?", "\""));
    assertEquals("??.?)", dataDTOToMVELTranslator.buildFieldName("?", ")"));
    assertEquals("?\\.?.?.?", dataDTOToMVELTranslator.buildFieldName("\\.", "."));
    assertEquals("?\\.?.??", dataDTOToMVELTranslator.buildFieldName("\\.", "?"));
    assertEquals("?\\.?.?\\.?", dataDTOToMVELTranslator.buildFieldName("\\.", "\\."));
    assertEquals("?\\.?.?.??", dataDTOToMVELTranslator.buildFieldName("\\.", ".?"));
    assertEquals("?\\.?.?!", dataDTOToMVELTranslator.buildFieldName("\\.", "!"));
    assertEquals("?\\.?.?\"", dataDTOToMVELTranslator.buildFieldName("\\.", "\""));
    assertEquals("?\\.?.?)", dataDTOToMVELTranslator.buildFieldName("\\.", ")"));
    assertEquals("?.??.?.?", dataDTOToMVELTranslator.buildFieldName(".?", "."));
    assertEquals("?.??.??", dataDTOToMVELTranslator.buildFieldName(".?", "?"));
    assertEquals("?.??.?\\.?", dataDTOToMVELTranslator.buildFieldName(".?", "\\."));
    assertEquals("?.??.?.??", dataDTOToMVELTranslator.buildFieldName(".?", ".?"));
    assertEquals("?.??.?!", dataDTOToMVELTranslator.buildFieldName(".?", "!"));
    assertEquals("?.??.?\"", dataDTOToMVELTranslator.buildFieldName(".?", "\""));
    assertEquals("?.??.?", dataDTOToMVELTranslator.buildFieldName(".?", ""));
    assertEquals("?.??.?)", dataDTOToMVELTranslator.buildFieldName(".?", ")"));
    assertEquals("?!.?.?", dataDTOToMVELTranslator.buildFieldName("!", "."));
    assertEquals("?!.??", dataDTOToMVELTranslator.buildFieldName("!", "?"));
    assertEquals("?!.?\\.?", dataDTOToMVELTranslator.buildFieldName("!", "\\."));
    assertEquals("?!.?.??", dataDTOToMVELTranslator.buildFieldName("!", ".?"));
    assertEquals("?!.?!", dataDTOToMVELTranslator.buildFieldName("!", "!"));
    assertEquals("?!.?\"", dataDTOToMVELTranslator.buildFieldName("!", "\""));
    assertEquals("?!.?)", dataDTOToMVELTranslator.buildFieldName("!", ")"));
    assertEquals("?\".?.?", dataDTOToMVELTranslator.buildFieldName("\"", "."));
    assertEquals("?\".??", dataDTOToMVELTranslator.buildFieldName("\"", "?"));
    assertEquals("?\".?\\.?", dataDTOToMVELTranslator.buildFieldName("\"", "\\."));
    assertEquals("?\".?.??", dataDTOToMVELTranslator.buildFieldName("\"", ".?"));
    assertEquals("?\".?!", dataDTOToMVELTranslator.buildFieldName("\"", "!"));
    assertEquals("?\".?\"", dataDTOToMVELTranslator.buildFieldName("\"", "\""));
    assertEquals("?\".?)", dataDTOToMVELTranslator.buildFieldName("\"", ")"));
    assertEquals("?).?.?", dataDTOToMVELTranslator.buildFieldName(")", "."));
    assertEquals("?).??", dataDTOToMVELTranslator.buildFieldName(")", "?"));
    assertEquals("?).?\\.?", dataDTOToMVELTranslator.buildFieldName(")", "\\."));
    assertEquals("?).?.??", dataDTOToMVELTranslator.buildFieldName(")", ".?"));
    assertEquals("?).?!", dataDTOToMVELTranslator.buildFieldName(")", "!"));
    assertEquals("?).?\"", dataDTOToMVELTranslator.buildFieldName(")", "\""));
    assertEquals("?).?)", dataDTOToMVELTranslator.buildFieldName(")", ")"));
    assertEquals("?,.?\\.?", dataDTOToMVELTranslator.buildFieldName(",", "\\."));
    assertEquals("?,.?.??", dataDTOToMVELTranslator.buildFieldName(",", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?\.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkBackslashDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?", dataDTOToMVELTranslator.buildFieldName("\\.", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?,.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?.?", dataDTOToMVELTranslator.buildFieldName(",", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?,.?!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?!", dataDTOToMVELTranslator.buildFieldName(",", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?,.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?,.??", dataDTOToMVELTranslator.buildFieldName(",", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?,.?"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?\"", dataDTOToMVELTranslator.buildFieldName(",", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?,.?)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("?,.?)", dataDTOToMVELTranslator.buildFieldName(",", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?.?\.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkBackslashDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?\\.?", dataDTOToMVELTranslator.buildFieldName("", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?.?", dataDTOToMVELTranslator.buildFieldName(".", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?.?.?,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?.?.?,", dataDTOToMVELTranslator.buildFieldName(".", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?.?!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("?.?!", dataDTOToMVELTranslator.buildFieldName("", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.??", dataDTOToMVELTranslator.buildFieldName("", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?.?"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("?.?\"", dataDTOToMVELTranslator.buildFieldName("", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?.?)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("?.?)", dataDTOToMVELTranslator.buildFieldName("", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?!.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkExclamationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?!.?", dataDTOToMVELTranslator.buildFieldName("!", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ??.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??.?", dataDTOToMVELTranslator.buildFieldName("?", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ??.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??.??", dataDTOToMVELTranslator.buildFieldName("?", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?".?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkQuotationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?\".?", dataDTOToMVELTranslator.buildFieldName("\"", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>Then return {@code ?).?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_thenReturnQuestionMarkRightParenthesisDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?).?", dataDTOToMVELTranslator.buildFieldName(")", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code ?42.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?42.?.?", dataDTOToMVELTranslator.buildFieldName("42", "."));
    assertEquals("?42.??", dataDTOToMVELTranslator.buildFieldName("42", "?"));
    assertEquals("?42.?\\.?", dataDTOToMVELTranslator.buildFieldName("42", "\\."));
    assertEquals("?42.?!", dataDTOToMVELTranslator.buildFieldName("42", "!"));
    assertEquals("?42.?\"", dataDTOToMVELTranslator.buildFieldName("42", "\""));
    assertEquals("?42.?)", dataDTOToMVELTranslator.buildFieldName("42", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code ?42.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_when42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("?42.?42", dataDTOToMVELTranslator.buildFieldName("42", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code \.}.</li>
   *   <li>Then return {@code ?\.?.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenBackslashDot_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?42", dataDTOToMVELTranslator.buildFieldName("\\.", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return {@code ?,.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenComma_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?,.?42", dataDTOToMVELTranslator.buildFieldName(",", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return {@code ?,.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenComma_thenReturnQuestionMarkCommaDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?", dataDTOToMVELTranslator.buildFieldName(",", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code .?}.</li>
   *   <li>Then return {@code ?.??.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenDotQuestionMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?.??.?42", dataDTOToMVELTranslator.buildFieldName(".?", "42"));
    assertEquals("?42.?.??", dataDTOToMVELTranslator.buildFieldName("42", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code ?.?.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenDot_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?.?.?42", dataDTOToMVELTranslator.buildFieldName(".", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code ?42.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenEmptyString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?42.?", dataDTOToMVELTranslator.buildFieldName("42", ""));
    assertEquals("?.?42", dataDTOToMVELTranslator.buildFieldName("", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code ?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenEmptyString_thenReturnQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?", dataDTOToMVELTranslator.buildFieldName("", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code Entity Key}.</li>
   *   <li>Then return {@code ?Entity Key.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", "."));
    assertEquals("?Entity Key.??", dataDTOToMVELTranslator.buildFieldName("Entity Key", "?"));
    assertEquals("?Entity Key.?\\.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", "\\."));
    assertEquals("?Entity Key.?.??", dataDTOToMVELTranslator.buildFieldName("Entity Key", ".?"));
    assertEquals("?Entity Key.?!", dataDTOToMVELTranslator.buildFieldName("Entity Key", "!"));
    assertEquals("?Entity Key.?\"", dataDTOToMVELTranslator.buildFieldName("Entity Key", "\""));
    assertEquals("?Entity Key.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", ""));
    assertEquals("?Entity Key.?)", dataDTOToMVELTranslator.buildFieldName("Entity Key", ")"));
    assertEquals("?Entity Key.?,", dataDTOToMVELTranslator.buildFieldName("Entity Key", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code Entity Key}.</li>
   *   <li>Then return {@code ?Entity Key.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey42() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?42", dataDTOToMVELTranslator.buildFieldName("Entity Key", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code Entity Key}.</li>
   *   <li>Then return {@code ?Entity Key.?Field Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKeyFieldName() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?Field Name", dataDTOToMVELTranslator.buildFieldName("Entity Key", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code !}.</li>
   *   <li>Then return {@code ?!.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenExclamationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?!.?42", dataDTOToMVELTranslator.buildFieldName("!", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code ?42.?Field Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenFieldName_thenReturn42FieldName() {
    // Arrange, Act and Assert
    assertEquals("?42.?Field Name", dataDTOToMVELTranslator.buildFieldName("42", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code ?.?.?Field Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenFieldName_thenReturnFieldName() {
    // Arrange, Act and Assert
    assertEquals("?.?.?Field Name", dataDTOToMVELTranslator.buildFieldName(".", "Field Name"));
    assertEquals("??.?Field Name", dataDTOToMVELTranslator.buildFieldName("?", "Field Name"));
    assertEquals("?\\.?.?Field Name", dataDTOToMVELTranslator.buildFieldName("\\.", "Field Name"));
    assertEquals("?.??.?Field Name", dataDTOToMVELTranslator.buildFieldName(".?", "Field Name"));
    assertEquals("?!.?Field Name", dataDTOToMVELTranslator.buildFieldName("!", "Field Name"));
    assertEquals("?\".?Field Name", dataDTOToMVELTranslator.buildFieldName("\"", "Field Name"));
    assertEquals("?.?Field Name", dataDTOToMVELTranslator.buildFieldName("", "Field Name"));
    assertEquals("?).?Field Name", dataDTOToMVELTranslator.buildFieldName(")", "Field Name"));
    assertEquals("?,.?Field Name", dataDTOToMVELTranslator.buildFieldName(",", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   *   <li>Then return {@code ??.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenQuestionMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("??.?42", dataDTOToMVELTranslator.buildFieldName("?", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return {@code ?".?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenQuotationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?\".?42", dataDTOToMVELTranslator.buildFieldName("\"", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   *   <li>Then return {@code ?).?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  public void testBuildFieldName_whenRightParenthesis_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?).?42", dataDTOToMVELTranslator.buildFieldName(")", "42"));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField() {
    // Arrange, Act and Assert
    assertEquals("?.?.?.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?.?.?\\.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?.?.?.??", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?.?.?!", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?.?.?\"", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?.?.?)", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?---.?\\.?", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?---.?.??", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?---.?)", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("??.?\\.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("??.?.??", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("??.?)", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?\\.?.?.?", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?\\.?.??", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?\\.?.?\\.?", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?\\.?.?.??", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?\\.?.?!", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?\\.?.?\"", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?\\.?.?)", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?.??.?.?", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?.??.??", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?.??.?\\.?", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?.??.?.??", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?.??.?!", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?.??.?\"", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?.??.?)", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?!.?.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?!.?\\.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?!.?.??", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?!.?!", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?!.?\"", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?!.?)", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?\".?.?", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?\".?\\.?", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?\".?.??", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?\".?!", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?\".?)", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ")", true));
    assertEquals("?).?.?", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?).??", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?).?\\.?", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?).?.??", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?).?!", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?).?\"", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?).?)", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?\.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkBackslashDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?---.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?---.?", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?---.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?---.?.?", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?---.?!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("?---.?!", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?---.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?---.??", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?---.?"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("?---.?\"", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.?\.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkBackslashDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?\\.?", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.?.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?.??", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.?!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("?.?!", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.??", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.??.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.??.?", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.?"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("?.?\"", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?.?)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("?.?)", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?!.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkExclamationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?!.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?!.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkExclamationMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?!.??", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ??.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ??.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??.?.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ??.?!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("??.?!", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ??.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??.??", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ??.?"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("??.?\"", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?".?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuotationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?\".?", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?".??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuotationMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?\".??", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?".?"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkQuotationMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("?\".?\"", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>Then return {@code ?).?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_thenReturnQuestionMarkRightParenthesisDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?).?", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code ?42.??}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?42.??", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?42.?\\.?", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?42.?!", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?42.?\"", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?42.?)", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code ?42.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_when42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("?42.?42", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code \.}.</li>
   *   <li>Then return {@code ?\.?.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenBackslashDot_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?42", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return
   * {@code MvelHelper.convertField("BOOLEAN",?Entity Key.?[""])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenBoolean_thenReturnMvelHelperConvertFieldBooleanEntityKey() {
    // Arrange, Act and Assert
    assertEquals("MvelHelper.convertField(\"BOOLEAN\",?Entity Key.?[\"\"])",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.BOOLEAN, "---", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return {@code ?Entity Key.?,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenComma_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?,",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ",", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return {@code ?,.?Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenComma_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals("?,.?Field", dataDTOToMVELTranslator.formatField(",", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code ---}.</li>
   *   <li>Then return {@code ?---.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenDashDashDash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?---.?42", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code ---}.</li>
   *   <li>Then return {@code ?---.?Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenDashDashDash_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals("?---.?Field", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code ---}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenDashDashDash_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "---", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code .?}.</li>
   *   <li>Then return {@code ?.??.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenDotQuestionMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?.??.?42", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?42.?.??", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code ?.?.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenDot_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?.?.?42", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "42", true));
    assertEquals("?42.?.?", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code ?42.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenEmptyString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?42.?", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?.?42", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code ?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenEmptyString_thenReturnQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code Entity Key}.</li>
   *   <li>Then return {@code ?Entity Key.?.?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenEntityKey_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ".", true));
    assertEquals("?Entity Key.??",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "?", true));
    assertEquals("?Entity Key.?\\.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "\\.", true));
    assertEquals("?Entity Key.?.??",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ".?", true));
    assertEquals("?Entity Key.?!",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "!", true));
    assertEquals("?Entity Key.?\"",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "\"", true));
    assertEquals("?Entity Key.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "", true));
    assertEquals("?Entity Key.?)",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code Entity Key}.</li>
   *   <li>Then return {@code ?Entity Key.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenEntityKey_thenReturnEntityKey42() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?42",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code !}.</li>
   *   <li>Then return {@code ?!.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenExclamationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?!.?42", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code Field}.</li>
   *   <li>Then return {@code ?42.?Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenField_thenReturn42Field() {
    // Arrange, Act and Assert
    assertEquals("?42.?Field", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code Field}.</li>
   *   <li>Then return {@code ?Entity Key.?Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenField_thenReturnEntityKeyField() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?Field",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code Field}.</li>
   *   <li>Then return {@code ?.?.?Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenField_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals("?.?.?Field", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("??.?Field", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?\\.?.?Field", dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?.??.?Field", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?!.?Field", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?\".?Field", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?.?Field", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "Field", true));
    assertEquals("?).?Field", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   *   <li>Then return {@code ??.?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenQuestionMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("??.?42", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return {@code ?".?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenQuotationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?\".?42", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   * <ul>
   *   <li>When {@code )}.</li>
   *   <li>Then return {@code ?).?42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}
   */
  @Test
  public void testFormatField_whenRightParenthesis_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?).?42", dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code MvelHelper.toUpperCase(\\")}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_thenReturnMvelHelperToUpperCase() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("MvelHelper.toUpperCase(\\\\\")", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"\\\""}, false, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return
   * {@code MvelHelper.toUpperCase(Value),MvelHelper.toUpperCase(Value)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_thenReturnMvelHelperToUpperCaseValueMvelHelperToUpperCaseValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("MvelHelper.toUpperCase(Value),MvelHelper.toUpperCase(Value)",
        dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.UNKNOWN,
            SupportedFieldType.UNKNOWN, new Object[]{"Value", "Value"}, false, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When array of {@link Object} with empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenArrayOfObjectWithEmptyString_thenReturnEmptyString() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN, new Object[]{""}, false, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When array of {@link Object} with forty-two.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenArrayOfObjectWithFortyTwo_thenReturn42() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("42", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.ID,
        SupportedFieldType.UNKNOWN, new Object[]{42}, false, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When array of {@link Object} with {@code Value}.</li>
   *   <li>Then return {@code Entity Key.Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenArrayOfObjectWithValue_thenReturnEntityKeyValue() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("Entity Key.Value", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, true, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When array of {@link Object} with {@code Value}.</li>
   *   <li>Then return {@code MvelHelper.toUpperCase(Value)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenArrayOfObjectWithValue_thenReturnMvelHelperToUpperCaseValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("MvelHelper.toUpperCase(Value)", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
    assertEquals("MvelHelper.toUpperCase(\"Value\")", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, false));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When array of {@link Object} with {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenArrayOfObjectWithValue_thenReturnValue() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("Value", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, false, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenBoolean_thenReturnValue() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals("Value", dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key", SupportedFieldType.BOOLEAN,
        SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code DATE}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenDate_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.DATE, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code ID}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenId_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.ID, SupportedFieldType.UNKNOWN, new Object[]{"Value"}, false, true, true));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  public void testFormatValue_whenNull_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> dataDTOToMVELTranslator.formatValue("Field Name", "Entity Key",
        SupportedFieldType.ID, null, new Object[]{"Value"}, false, true, true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#extractBasicValues(Object)}.
   * <ul>
   *   <li>Then return first element is {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  public void testExtractBasicValues_thenReturnFirstElementIsLeftSquareBracket() {
    // Arrange and Act
    Object[] actualExtractBasicValuesResult = (new DataDTOToMVELTranslator()).extractBasicValues("[");

    // Assert
    assertEquals("[", actualExtractBasicValuesResult[0]);
    assertEquals(1, actualExtractBasicValuesResult.length);
  }

  /**
   * Test {@link DataDTOToMVELTranslator#extractBasicValues(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  public void testExtractBasicValues_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DataDTOToMVELTranslator()).extractBasicValues(null));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#extractBasicValues(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return first element is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  public void testExtractBasicValues_whenValue_thenReturnFirstElementIsValue() {
    // Arrange and Act
    Object[] actualExtractBasicValuesResult = (new DataDTOToMVELTranslator()).extractBasicValues("Value");

    // Assert
    assertEquals("Value", actualExtractBasicValuesResult[0]);
    assertEquals(1, actualExtractBasicValuesResult.length);
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\""));
    assertEquals("\\\\\\\"\\\\\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\\\""));
    assertEquals("\\\\\\\"!", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"!"));
    assertEquals("\\\\\\\")", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\")"));
    assertEquals("\\\\\\\"---", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"---"));
    assertEquals("\\\\\\\"==", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"=="));
    assertEquals("\\\\\\\"[", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"["));
    assertEquals("\\\\\\\"\\\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\""));
    assertEquals("\\\\\\\"]", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"]"));
    assertEquals("\\\\\\\"||", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"||"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return {@code \\\",}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnBackslashBackslashBackslashQuotationMarkComma() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\",", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return {@code \\\"MvelHelper.toUpperCase(}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code \\\"org.apache.commons.lang3.StringUtils.contains}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsContains() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"org.apache.commons.lang3.StringUtils.contains"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code \\\"org.apache.commons.lang3.StringUtils.endsWith}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsEndsWith() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"org.apache.commons.lang3.StringUtils.endsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code \\\"org.apache.commons.lang3.StringUtils.startsWith}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsStartsWith() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)MvelHelper.toUpperCase(}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnSSMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)org.apache.commons.lang3.StringUtils.contains}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnSSOrgApacheCommonsLang3StringUtilsContains() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator
            .escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnSSOrgApacheCommonsLang3StringUtilsEndsWith() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator
            .escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_thenReturnSSOrgApacheCommonsLang3StringUtilsStartsWith() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator
            .escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code 42(?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return {@code 42(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_when42SS_thenReturn42SS() {
    // Arrange, Act and Assert
    assertEquals("42(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("42(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", dataDTOToMVELTranslator.escapeInternalQuotes("42"));
    assertEquals("\\\\\\\"42", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", dataDTOToMVELTranslator.escapeInternalQuotes(""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code Processed Value(?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return {@code Processed Value(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenProcessedValueSS_thenReturnProcessedValueSS() {
    // Arrange, Act and Assert
    assertEquals("Processed Value(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("Processed Value(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code \\"Processed Value}.</li>
   *   <li>Then return {@code \\\"Processed Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenProcessedValue_thenReturnProcessedValue() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"Processed Value", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", dataDTOToMVELTranslator.escapeInternalQuotes("\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)42}.</li>
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenSS42_thenReturnSS42() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)42",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)Processed Value}.</li>
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)Processed Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenSSProcessedValue_thenReturnSSProcessedValue() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)Processed Value",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)(?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return
   * {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenSSSS_thenReturnSSSS() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\\u0022}.</li>
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)\\u0022}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenSSU0022_thenReturnSSU0022() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenSS_thenReturnSS() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("\"(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\""));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\\\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\\""));
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
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)[",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)["));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\""));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)]",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)]"));
    assertEquals("(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)||",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)||"));
    assertEquals("\\\\\\\"(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("!(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("!(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(")(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes(")(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(",(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes(",(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   * <ul>
   *   <li>When {@code \\"\\u0022}.</li>
   *   <li>Then return {@code \\\"\\u0022}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  public void testEscapeInternalQuotes_whenU0022_thenReturnU0022() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"\\\\u0022", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator
            .escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator
            .escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>Then return {@code Processed Value(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_thenReturnProcessedValueSU0022S() {
    // Arrange, Act and Assert
    assertEquals("Processed Value(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("Processed Value(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>Then return
   * {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)MvelHelper.toUpperCase(}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_thenReturnSU0022SMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)Processed Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_thenReturnSU0022SProcessedValue() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)Processed Value",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>When {@code 42(?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return {@code 42(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_when42SS_thenReturn42SU0022S() {
    // Arrange, Act and Assert
    assertEquals("42(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("42(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", dataDTOToMVELTranslator.escapeInternalMiltyQuotes("42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)42}.</li>
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_whenSS42_thenReturnSU0022S42() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)42",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)(?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return
   * {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_whenSSSS_thenReturnSU0022SSU0022S() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)", dataDTOToMVELTranslator
        .escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\\\u0022}.</li>
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)\\\u0022}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_whenSSU0022_thenReturnSU0022SU0022() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\\\u0022"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S() {
    // Arrange, Act and Assert
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("\"(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\"",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\""));
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
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)[",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)["));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\"",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\""));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)]",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)]"));
    assertEquals("(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)||",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)||"));
    assertEquals("!(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("!(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(")(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(")(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
    assertEquals(",(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(",(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   * <ul>
   *   <li>When {@code \\\u0022(?<!^)(?<!^\s)"(?!\s$)(?!$)}.</li>
   *   <li>Then return {@code \\\u0022(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  public void testEscapeInternalMiltyQuotes_whenU0022SS_thenReturnU0022SU0022S() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\u0022(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("\\\\\\u0022(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#isProjection(Object)}.
   * <ul>
   *   <li>When {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTOToMVELTranslator#isProjection(Object)}
   */
  @Test
  public void testIsProjection_whenLeftSquareBracket() {
    // Arrange, Act and Assert
    assertFalse((new DataDTOToMVELTranslator()).isProjection("["));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#isProjection(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTOToMVELTranslator#isProjection(Object)}
   */
  @Test
  public void testIsProjection_whenValue() {
    // Arrange, Act and Assert
    assertFalse((new DataDTOToMVELTranslator()).isProjection("Value"));
  }

  /**
   * Test
   * {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}.
   * <p>
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
   * Test
   * {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}.
   * <p>
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
