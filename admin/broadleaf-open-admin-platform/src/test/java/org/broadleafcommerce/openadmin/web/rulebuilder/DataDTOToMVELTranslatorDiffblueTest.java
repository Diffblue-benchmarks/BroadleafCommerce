package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DataDTOToMVELTranslator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataDTOToMVELTranslatorDiffblueTest {
  @Autowired private DataDTOToMVELTranslator dataDTOToMVELTranslator;

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService2()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService));
    verify(fieldService).getOverrideFieldEntityKey("42");
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService3()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId(".");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey(".");
    verify(fieldService).getSecondaryFieldType(".");
    verify(fieldService).getSupportedFieldType(".");
    assertEquals("foo(?Override Field Entity Key.?.?==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService4()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("\"");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("\"");
    verify(fieldService).getSecondaryFieldType("\"");
    verify(fieldService).getSupportedFieldType("\"");
    assertEquals("foo(?Override Field Entity Key.?\"==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService5()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("[");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("[");
    verify(fieldService).getSecondaryFieldType("[");
    verify(fieldService).getSupportedFieldType("[");
    assertEquals("foo(?Override Field Entity Key.?[==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService6()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId(DataDTOToMVELTranslator.EQUALS_OPERATOR);
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("==");
    verify(fieldService).getSecondaryFieldType("==");
    verify(fieldService).getSupportedFieldType("==");
    assertEquals("foo(?Override Field Entity Key.?====\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService7()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId(DataDTOToMVELTranslator.CONTAINS_OPERATOR);
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("org.apache.commons.lang3.StringUtils.contains");
    verify(fieldService).getSecondaryFieldType("org.apache.commons.lang3.StringUtils.contains");
    verify(fieldService).getSupportedFieldType("org.apache.commons.lang3.StringUtils.contains");
    assertEquals(
        "foo(?Override Field Entity Key.?org.?apache.?commons.?lang3.?StringUtils.?contains==\"42\")",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService8()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId(DataDTOToMVELTranslator.STARTS_WITH_OPERATOR);
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService)
        .getOverrideFieldEntityKey("org.apache.commons.lang3.StringUtils.startsWith");
    verify(fieldService).getSecondaryFieldType("org.apache.commons.lang3.StringUtils.startsWith");
    verify(fieldService).getSupportedFieldType("org.apache.commons.lang3.StringUtils.startsWith");
    assertEquals(
        "foo(?Override Field Entity Key.?org.?apache.?commons.?lang3.?StringUtils.?startsWith==\"42\")",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService9()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("Id");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("Id");
    verify(fieldService).getSecondaryFieldType("Id");
    verify(fieldService).getSupportedFieldType("Id");
    assertEquals("foo(?Override Field Entity Key.?Id==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService10()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId(DataDTOToMVELTranslator.ENDS_WITH_OPERATOR);
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("org.apache.commons.lang3.StringUtils.endsWith");
    verify(fieldService).getSecondaryFieldType("org.apache.commons.lang3.StringUtils.endsWith");
    verify(fieldService).getSupportedFieldType("org.apache.commons.lang3.StringUtils.endsWith");
    assertEquals(
        "foo(?Override Field Entity Key.?org.?apache.?commons.?lang3.?StringUtils.?endsWith==\"42\")",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService11()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService)
        .getOverrideFieldEntityKey(
            "org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");
    verify(fieldService)
        .getSecondaryFieldType("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");
    verify(fieldService)
        .getSupportedFieldType("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");
    assertEquals(
        "foo(?Override Field Entity Key.?org.?broadleafcommerce.?openadmin.?web.?rulebuilder.?dto.?ExpressionDTO"
            + "==\"42\")",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService12()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("(");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("(");
    verify(fieldService).getSecondaryFieldType("(");
    verify(fieldService).getSupportedFieldType("(");
    assertEquals("foo(?Override Field Entity Key.?(==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService13()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("");
    verify(fieldService).getSecondaryFieldType("");
    verify(fieldService).getSupportedFieldType("");
    assertEquals("foo(?Override Field Entity Key.?==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService14()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("---");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService));
    verify(fieldService).getOverrideFieldEntityKey("---");
    verify(fieldService).getSecondaryFieldType("---");
    verify(fieldService).getSupportedFieldType("---");
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService15()
      throws MVELTranslationException {
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
    expressionDTO.setValue("[");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==\"[\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService16()
      throws MVELTranslationException {
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
    expressionDTO.setValue("");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService17()
      throws MVELTranslationException {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("?");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("?");
    verify(fieldService).getSecondaryFieldType("?");
    verify(fieldService).getSupportedFieldType("?");
    assertEquals("foo(?Override Field Entity Key.??==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService18()
      throws MVELTranslationException {
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
    StringBuffer sb = new StringBuffer("(");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("(?Override Field Entity Key.?42==\"42\"", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService19()
      throws MVELTranslationException {
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
    StringBuffer sb = new StringBuffer("");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("?Override Field Entity Key.?42==\"42\"", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService20()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.NOT_EQUAL, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42!=\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService21()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.IEQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals(
        "foo(?Override Field Entity Key.?42==MvelHelper.toUpperCase(\"42\"))", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService22()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn(".");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?.?.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService23()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("\"");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?\".?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService24()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("[");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?[.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService25()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn(DataDTOToMVELTranslator.EQUALS_OPERATOR);
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?==.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService26()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn(DataDTOToMVELTranslator.CONTAINS_OPERATOR);
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals(
        "foo(?org.?apache.?commons.?lang3.?StringUtils.?contains.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService27()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn(DataDTOToMVELTranslator.STARTS_WITH_OPERATOR);
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals(
        "foo(?org.?apache.?commons.?lang3.?StringUtils.?startsWith.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService28()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("foo");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?foo.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService29()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn(DataDTOToMVELTranslator.ENDS_WITH_OPERATOR);
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals(
        "foo(?org.?apache.?commons.?lang3.?StringUtils.?endsWith.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService30()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn(null);
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Entity Key.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService31()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("42");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?42.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService32()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("(");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?(.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService33()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService34()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService));
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService35()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("\\.");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("\\.");
    verify(fieldService).getSecondaryFieldType("\\.");
    verify(fieldService).getSupportedFieldType("\\.");
    assertEquals("foo(?Override Field Entity Key.?\\.?==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService36()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.INOT_EQUAL, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals(
        "foo(?Override Field Entity Key.?42!=MvelHelper.toUpperCase(\"42\"))", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService37()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("---");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?---.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService38()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId(".?");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey(".?");
    verify(fieldService).getSecondaryFieldType(".?");
    verify(fieldService).getSupportedFieldType(".?");
    assertEquals("foo(?Override Field Entity Key.?.??==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService39()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.GREATER_THAN, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42>\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService40()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("?");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(??.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService41()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("^\"|\"$");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("^\"|\"$");
    verify(fieldService).getSecondaryFieldType("^\"|\"$");
    verify(fieldService).getSupportedFieldType("^\"|\"$");
    assertEquals("foo(?Override Field Entity Key.?^\"|\"$==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService42()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.LESS_THAN, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42<\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService43()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("\\.");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?\\.?.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService44()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("4242");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("4242");
    verify(fieldService).getSecondaryFieldType("4242");
    verify(fieldService).getSupportedFieldType("4242");
    assertEquals("foo(?Override Field Entity Key.?4242==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService45()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.GREATER_OR_EQUAL, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42>=\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService46()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn(".?");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?.??.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService47()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("\\\"");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("\\\"");
    verify(fieldService).getSecondaryFieldType("\\\"");
    verify(fieldService).getSupportedFieldType("\\\"");
    assertEquals("foo(?Override Field Entity Key.?\\\"==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService48()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42.");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42.");
    verify(fieldService).getSecondaryFieldType("42.");
    verify(fieldService).getSupportedFieldType("42.");
    assertEquals("foo(?Override Field Entity Key.?42.?==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService49()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    expressionDTO.setValue("\\\"");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==\"\\\\\"\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService50()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.LESS_OR_EQUAL, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42<=\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService51()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any())).thenReturn("^\"|\"$");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?^\"|\"$.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService52()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId(")");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey(")");
    verify(fieldService).getSecondaryFieldType(")");
    verify(fieldService).getSupportedFieldType(")");
    assertEquals("foo(?Override Field Entity Key.?)==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService53()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42\"");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    StringBuffer sb = new StringBuffer("foo");

    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42\"");
    verify(fieldService).getSecondaryFieldType("42\"");
    verify(fieldService).getSupportedFieldType("42\"");
    assertEquals("foo(?Override Field Entity Key.?42\"==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <ul>
   *   <li>Given {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenBoolean()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.BOOLEAN);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==42)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <ul>
   *   <li>Given {@code DATE}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenDate()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.DATE);

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService));
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <ul>
   *   <li>Given {@code DECIMAL}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenDecimal()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.DECIMAL);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==42)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <ul>
   *   <li>Given {@code ID}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenId()
      throws MVELTranslationException {
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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.ID);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==42)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <ul>
   *   <li>Given {@code INTEGER}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenInteger()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.INTEGER);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==42)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO, StringBuffer, String,
   * BLCOperator, RuleBuilderFieldService)} with {@code expressionDTO}, {@code sb}, {@code
   * entityKey}, {@code operator}, {@code fieldService}.
   *
   * <ul>
   *   <li>Given {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(ExpressionDTO,
   * StringBuffer, String, BLCOperator, RuleBuilderFieldService)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(ExpressionDTO, StringBuffer, String, BLCOperator, RuleBuilderFieldService)"
  })
  public void testBuildExpressionWithExpressionDTOSbEntityKeyOperatorFieldService_givenString()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

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
    when(fieldService.getOverrideFieldEntityKey(Mockito.<String>any()))
        .thenReturn("Override Field Entity Key");
    when(fieldService.getSecondaryFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.UNKNOWN);
    when(fieldService.getSupportedFieldType(Mockito.<String>any()))
        .thenReturn(SupportedFieldType.STRING);

    // Act
    dataDTOToMVELTranslator.buildExpression(
        expressionDTO, sb, "Entity Key", BLCOperator.EQUALS, fieldService);

    // Assert
    verify(fieldService).getOverrideFieldEntityKey("42");
    verify(fieldService).getSecondaryFieldType("42");
    verify(fieldService).getSupportedFieldType("42");
    assertEquals("foo(?Override Field Entity Key.?42==\"42\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes()
          throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(
        sb,
        "Entity Key",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("foo(?Entity Key.?FieldOperator(Entity Key.Value))", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes2()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes3()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes4()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes5()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes6()
          throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(
        sb,
        "Entity Key",
        "---",
        new Object[] {"Value"},
        SupportedFieldType.STRING,
        SupportedFieldType.UNKNOWN,
        DataDTOToMVELTranslator.EQUALS_OPERATOR,
        false,
        false,
        false,
        false,
        false);

    // Assert
    assertEquals("foo(?Entity Key.?[\"\"]==\"Value\")", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes7()
          throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(
        sb,
        "Entity Key",
        "---",
        new Object[] {"Value"},
        SupportedFieldType.STRING,
        SupportedFieldType.UNKNOWN,
        DataDTOToMVELTranslator.CONTAINS_OPERATOR,
        false,
        false,
        false,
        false,
        false);

    // Assert
    assertEquals(
        "fooorg.apache.commons.lang3.StringUtils.contains(?Entity Key.?[\"\"],\"Value\")",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes8()
          throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(
        sb,
        "Entity Key",
        "---",
        new Object[] {"Value"},
        SupportedFieldType.BOOLEAN,
        SupportedFieldType.UNKNOWN,
        DataDTOToMVELTranslator.EQUALS_OPERATOR,
        false,
        false,
        false,
        false,
        false);

    // Assert
    assertEquals(
        "foo(MvelHelper.convertField(\"BOOLEAN\",?Entity Key.?[\"\"])==Value)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes9()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.INTEGER,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes10()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.DECIMAL,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes11()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.DATE,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes12()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("("),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes13()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer(""),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes14()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes15()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes16()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes17()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes18()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes19()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes20()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes21()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "!",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes22()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "42",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes23()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "---",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes24()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes25()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes26()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes27()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes28()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes29()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes30()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes31()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes32()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes33()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes34()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes35()
          throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(
        sb,
        "Entity Key",
        "---",
        new Object[] {42},
        SupportedFieldType.MONEY,
        SupportedFieldType.UNKNOWN,
        DataDTOToMVELTranslator.EQUALS_OPERATOR,
        false,
        false,
        false,
        false,
        false);

    // Assert
    assertEquals(
        "foo(MvelHelper.convertField(\"DECIMAL\",?Entity Key.?[\"\"])==42)", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes36()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"\""},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes37()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.UNKNOWN,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes38()
          throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildExpression(
        sb,
        "Entity Key",
        "---",
        new Object[] {"Value"},
        SupportedFieldType.MONEY,
        SupportedFieldType.UNKNOWN,
        DataDTOToMVELTranslator.EQUALS_OPERATOR,
        false,
        true,
        false,
        false,
        false);

    // Assert
    assertEquals(
        "foo(MvelHelper.convertField(\"DECIMAL\",?Entity Key.?[\"\"])==Entity Key.Value.getAmount())",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes39()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("("),
                "[\"",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes40()
          throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("("),
                "Entity Key",
                "[\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes41()
          throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("(");

    // Act
    dataDTOToMVELTranslator.buildExpression(
        sb,
        "Entity Key",
        "---",
        new Object[] {42},
        SupportedFieldType.MONEY,
        SupportedFieldType.UNKNOWN,
        DataDTOToMVELTranslator.EQUALS_OPERATOR,
        false,
        false,
        false,
        false,
        false);

    // Assert
    assertEquals("(MvelHelper.convertField(\"DECIMAL\",?Entity Key.?[\"\"])==42", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes42()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ")",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes43()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes44()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes45()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes46()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes47()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes48()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes49()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                "Field",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes50()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes51()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes52()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes53()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                ".",
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes54()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes55()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes56()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes57()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes58()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes59()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes60()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                "Field",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes61()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes62()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes63()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes64()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "\"",
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes65()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes66()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes67()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes68()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes69()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes70()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes71()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                "Field",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes72()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes73()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes74()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes75()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes76()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes77()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes78()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes79()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes80()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes81()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes82()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                "Field",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes83()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes84()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes85()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes86()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes87()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes88()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes89()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes90()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes91()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes92()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes93()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                "Field",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes94()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes95()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes96()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes97()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes98()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes99()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes100()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes101()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes102()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes103()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes104()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                "Field",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes105()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes106()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes107()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes108()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes109()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                ".",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes110()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                "\"",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes111()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes112()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                DataDTOToMVELTranslator.CONTAINS_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes113()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                DataDTOToMVELTranslator.STARTS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes114()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                DataDTOToMVELTranslator.ENDS_WITH_OPERATOR,
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes115()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                "Field",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes116()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                "(",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes117()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                "!",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes118()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                "42",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String, String, Object[],
   * SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)}
   * with {@code sb}, {@code entityKey}, {@code field}, {@code value}, {@code type}, {@code
   * secondaryType}, {@code operator}, {@code includeParenthesis}, {@code isFieldComparison}, {@code
   * ignoreCase}, {@code isNegation}, {@code ignoreQuotes}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildExpression(StringBuffer, String,
   * String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void
      testBuildExpressionWithSbEntityKeyFieldValueTypeSecondaryTypeOperatorIncludeParenthesisIsFieldComparisonIgnoreCaseIsNegationIgnoreQuotes119()
          throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.buildExpression(
                new StringBuffer("foo"),
                "(",
                "",
                new Object[] {"Value"},
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                DataDTOToMVELTranslator.EQUALS_OPERATOR,
                false,
                false,
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName() {
    // Arrange, Act and Assert
    assertEquals("?.?.?.?", dataDTOToMVELTranslator.buildFieldName(".", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName2() {
    // Arrange, Act and Assert
    assertEquals("?.?.??", dataDTOToMVELTranslator.buildFieldName(".", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName3() {
    // Arrange, Act and Assert
    assertEquals("?.?.?\\.?", dataDTOToMVELTranslator.buildFieldName(".", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName4() {
    // Arrange, Act and Assert
    assertEquals("?.?.?.??", dataDTOToMVELTranslator.buildFieldName(".", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName5() {
    // Arrange, Act and Assert
    assertEquals("?.?.?!", dataDTOToMVELTranslator.buildFieldName(".", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName6() {
    // Arrange, Act and Assert
    assertEquals("?.?.?\"", dataDTOToMVELTranslator.buildFieldName(".", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName7() {
    // Arrange, Act and Assert
    assertEquals("??.?.?", dataDTOToMVELTranslator.buildFieldName("?", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName8() {
    // Arrange, Act and Assert
    assertEquals("??.?\\.?", dataDTOToMVELTranslator.buildFieldName("?", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName9() {
    // Arrange, Act and Assert
    assertEquals("??.?.??", dataDTOToMVELTranslator.buildFieldName("?", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName10() {
    // Arrange, Act and Assert
    assertEquals("??.?!", dataDTOToMVELTranslator.buildFieldName("?", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName11() {
    // Arrange, Act and Assert
    assertEquals("??.?\"", dataDTOToMVELTranslator.buildFieldName("?", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName12() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?.?", dataDTOToMVELTranslator.buildFieldName("\\.", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName13() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.??", dataDTOToMVELTranslator.buildFieldName("\\.", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName14() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?\\.?", dataDTOToMVELTranslator.buildFieldName("\\.", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName15() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?.??", dataDTOToMVELTranslator.buildFieldName("\\.", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName16() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?!", dataDTOToMVELTranslator.buildFieldName("\\.", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName17() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?\"", dataDTOToMVELTranslator.buildFieldName("\\.", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName18() {
    // Arrange, Act and Assert
    assertEquals("?.??.?.?", dataDTOToMVELTranslator.buildFieldName(".?", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName19() {
    // Arrange, Act and Assert
    assertEquals("?.??.??", dataDTOToMVELTranslator.buildFieldName(".?", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName20() {
    // Arrange, Act and Assert
    assertEquals("?.??.?\\.?", dataDTOToMVELTranslator.buildFieldName(".?", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName21() {
    // Arrange, Act and Assert
    assertEquals("?.??.?.??", dataDTOToMVELTranslator.buildFieldName(".?", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName22() {
    // Arrange, Act and Assert
    assertEquals("?.??.?!", dataDTOToMVELTranslator.buildFieldName(".?", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName23() {
    // Arrange, Act and Assert
    assertEquals("?.??.?\"", dataDTOToMVELTranslator.buildFieldName(".?", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName24() {
    // Arrange, Act and Assert
    assertEquals("?.??.?", dataDTOToMVELTranslator.buildFieldName(".?", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName25() {
    // Arrange, Act and Assert
    assertEquals("?!.?.?", dataDTOToMVELTranslator.buildFieldName("!", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName26() {
    // Arrange, Act and Assert
    assertEquals("?!.??", dataDTOToMVELTranslator.buildFieldName("!", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName27() {
    // Arrange, Act and Assert
    assertEquals("?!.?\\.?", dataDTOToMVELTranslator.buildFieldName("!", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName28() {
    // Arrange, Act and Assert
    assertEquals("?!.?.??", dataDTOToMVELTranslator.buildFieldName("!", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName29() {
    // Arrange, Act and Assert
    assertEquals("?!.?!", dataDTOToMVELTranslator.buildFieldName("!", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName30() {
    // Arrange, Act and Assert
    assertEquals("?!.?\"", dataDTOToMVELTranslator.buildFieldName("!", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName31() {
    // Arrange, Act and Assert
    assertEquals("?\".?.?", dataDTOToMVELTranslator.buildFieldName("\"", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName32() {
    // Arrange, Act and Assert
    assertEquals("?\".??", dataDTOToMVELTranslator.buildFieldName("\"", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName33() {
    // Arrange, Act and Assert
    assertEquals("?\".?\\.?", dataDTOToMVELTranslator.buildFieldName("\"", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName34() {
    // Arrange, Act and Assert
    assertEquals("?\".?.??", dataDTOToMVELTranslator.buildFieldName("\"", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName35() {
    // Arrange, Act and Assert
    assertEquals("?\".?!", dataDTOToMVELTranslator.buildFieldName("\"", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName36() {
    // Arrange, Act and Assert
    assertEquals("?\".?\"", dataDTOToMVELTranslator.buildFieldName("\"", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName37() {
    // Arrange, Act and Assert
    assertEquals("?).?.?", dataDTOToMVELTranslator.buildFieldName(")", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName38() {
    // Arrange, Act and Assert
    assertEquals("?).??", dataDTOToMVELTranslator.buildFieldName(")", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName39() {
    // Arrange, Act and Assert
    assertEquals("?).?\\.?", dataDTOToMVELTranslator.buildFieldName(")", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName40() {
    // Arrange, Act and Assert
    assertEquals("?).?.??", dataDTOToMVELTranslator.buildFieldName(")", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName41() {
    // Arrange, Act and Assert
    assertEquals("?).?!", dataDTOToMVELTranslator.buildFieldName(")", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName42() {
    // Arrange, Act and Assert
    assertEquals("?).?\"", dataDTOToMVELTranslator.buildFieldName(")", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName43() {
    // Arrange, Act and Assert
    assertEquals("?.?.?)", dataDTOToMVELTranslator.buildFieldName(".", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName44() {
    // Arrange, Act and Assert
    assertEquals("??.?)", dataDTOToMVELTranslator.buildFieldName("?", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName45() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?)", dataDTOToMVELTranslator.buildFieldName("\\.", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName46() {
    // Arrange, Act and Assert
    assertEquals("?.??.?)", dataDTOToMVELTranslator.buildFieldName(".?", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName47() {
    // Arrange, Act and Assert
    assertEquals("?!.?)", dataDTOToMVELTranslator.buildFieldName("!", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName48() {
    // Arrange, Act and Assert
    assertEquals("?\".?)", dataDTOToMVELTranslator.buildFieldName("\"", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName49() {
    // Arrange, Act and Assert
    assertEquals("?).?)", dataDTOToMVELTranslator.buildFieldName(")", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName50() {
    // Arrange, Act and Assert
    assertEquals("?,.?\\.?", dataDTOToMVELTranslator.buildFieldName(",", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName51() {
    // Arrange, Act and Assert
    assertEquals("?,.?.??", dataDTOToMVELTranslator.buildFieldName(",", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName52() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?,", new DataDTOToMVELTranslator().buildFieldName("\\.", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName53() {
    // Arrange, Act and Assert
    assertEquals("?.??.?,", new DataDTOToMVELTranslator().buildFieldName(".?", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName54() {
    // Arrange, Act and Assert
    assertEquals("?---.?.?", new DataDTOToMVELTranslator().buildFieldName("---", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName55() {
    // Arrange, Act and Assert
    assertEquals("?---.?\\.?", new DataDTOToMVELTranslator().buildFieldName("---", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName56() {
    // Arrange, Act and Assert
    assertEquals("?---.?.??", new DataDTOToMVELTranslator().buildFieldName("---", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName57() {
    // Arrange, Act and Assert
    assertEquals("?---.?!", new DataDTOToMVELTranslator().buildFieldName("---", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName58() {
    // Arrange, Act and Assert
    assertEquals("?---.?\"", new DataDTOToMVELTranslator().buildFieldName("---", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName59() {
    // Arrange, Act and Assert
    assertEquals("?---.?)", new DataDTOToMVELTranslator().buildFieldName("---", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName60() {
    // Arrange, Act and Assert
    assertEquals("?.?.?---", new DataDTOToMVELTranslator().buildFieldName(".", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName61() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?---", new DataDTOToMVELTranslator().buildFieldName("\\.", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName62() {
    // Arrange, Act and Assert
    assertEquals("?.??.?---", new DataDTOToMVELTranslator().buildFieldName(".?", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName63() {
    // Arrange, Act and Assert
    assertEquals("?!.?---", new DataDTOToMVELTranslator().buildFieldName("!", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName64() {
    // Arrange, Act and Assert
    assertEquals("?\".?---", new DataDTOToMVELTranslator().buildFieldName("\"", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName65() {
    // Arrange, Act and Assert
    assertEquals("?).?---", new DataDTOToMVELTranslator().buildFieldName(")", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName66() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?.?",
        new DataDTOToMVELTranslator().buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName67() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.??",
        new DataDTOToMVELTranslator().buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName68() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?\\.?",
        new DataDTOToMVELTranslator()
            .buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName69() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?.??",
        new DataDTOToMVELTranslator()
            .buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName70() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?!",
        new DataDTOToMVELTranslator().buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName71() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?\"",
        new DataDTOToMVELTranslator()
            .buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName72() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?)",
        new DataDTOToMVELTranslator().buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName73() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?,",
        new DataDTOToMVELTranslator().buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName74() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?---",
        new DataDTOToMVELTranslator()
            .buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName75() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?==",
        new DataDTOToMVELTranslator().buildFieldName(".", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName76() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?==",
        new DataDTOToMVELTranslator().buildFieldName("?", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName77() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?==",
        new DataDTOToMVELTranslator()
            .buildFieldName("\\.", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName78() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?==",
        new DataDTOToMVELTranslator()
            .buildFieldName(".?", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName79() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?==",
        new DataDTOToMVELTranslator().buildFieldName("!", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName80() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?==",
        new DataDTOToMVELTranslator()
            .buildFieldName("\"", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName81() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?==",
        new DataDTOToMVELTranslator().buildFieldName(")", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName82() {
    // Arrange, Act and Assert
    assertEquals(
        "?,.?==",
        new DataDTOToMVELTranslator().buildFieldName(",", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName83() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?==",
        new DataDTOToMVELTranslator()
            .buildFieldName("---", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName84() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?==",
        new DataDTOToMVELTranslator()
            .buildFieldName(
                DataDTOToMVELTranslator.EQUALS_OPERATOR, DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?42.??", dataDTOToMVELTranslator.buildFieldName("42", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?\.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("?42.?\\.?", dataDTOToMVELTranslator.buildFieldName("42", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("?42.?!", dataDTOToMVELTranslator.buildFieldName("42", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("?42.?\"", dataDTOToMVELTranslator.buildFieldName("42", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("?42.?)", dataDTOToMVELTranslator.buildFieldName("42", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("?42.?,", new DataDTOToMVELTranslator().buildFieldName("42", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("?42.?---", new DataDTOToMVELTranslator().buildFieldName("42", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?==}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?==",
        new DataDTOToMVELTranslator()
            .buildFieldName("42", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_when42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("?42.?42", dataDTOToMVELTranslator.buildFieldName("42", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code \.}.
   *   <li>Then return {@code ?\.?.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenBackslashDot_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?42", dataDTOToMVELTranslator.buildFieldName("\\.", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code ,}.
   *   <li>Then return {@code ?,.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenComma_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?,.?42", dataDTOToMVELTranslator.buildFieldName(",", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ---}.
   *   <li>Then return {@code ?---.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenDashDashDash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?---.?42", new DataDTOToMVELTranslator().buildFieldName("---", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code .?}.
   *   <li>Then return {@code ?.??.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenDotQuestionMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?.??.?42", dataDTOToMVELTranslator.buildFieldName(".?", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code .?}.
   *   <li>Then return {@code ?42.?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenDotQuestionMark_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("?42.?.??", dataDTOToMVELTranslator.buildFieldName("42", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code .}.
   *   <li>Then return {@code ?.?.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenDot_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?.?.?42", dataDTOToMVELTranslator.buildFieldName(".", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code .}.
   *   <li>Then return {@code ?42.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenDot_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("?42.?.?", dataDTOToMVELTranslator.buildFieldName("42", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When empty string.
   *   <li>Then return {@code ?42.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenEmptyString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?42.?", dataDTOToMVELTranslator.buildFieldName("42", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When empty string.
   *   <li>Then return {@code ?.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenEmptyString_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("?.?42", dataDTOToMVELTranslator.buildFieldName("", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@link DataDTOToMVELTranslator#EQUALS_OPERATOR}.
   *   <li>Then return {@code ?==.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenEquals_operator_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?42",
        new DataDTOToMVELTranslator()
            .buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code !}.
   *   <li>Then return {@code ?!.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenExclamationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?!.?42", dataDTOToMVELTranslator.buildFieldName("!", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code ?}.
   *   <li>Then return {@code ??.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenQuestionMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("??.?42", dataDTOToMVELTranslator.buildFieldName("?", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code "}.
   *   <li>Then return {@code ?".?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_givenDataDTOToMVELTranslator_whenQuotationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?\".?42", dataDTOToMVELTranslator.buildFieldName("\"", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?\.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkBackslashDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?", dataDTOToMVELTranslator.buildFieldName("\\.", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?,.?---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("?,.?---", new DataDTOToMVELTranslator().buildFieldName(",", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?,.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?.?", dataDTOToMVELTranslator.buildFieldName(",", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?,.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?!", dataDTOToMVELTranslator.buildFieldName(",", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?,.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?,.??", dataDTOToMVELTranslator.buildFieldName(",", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?,.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?\"", dataDTOToMVELTranslator.buildFieldName(",", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?,.?)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkCommaDotQuestionMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("?,.?)", dataDTOToMVELTranslator.buildFieldName(",", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDashDashDashDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?---.?", dataDTOToMVELTranslator.buildFieldName("---", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDashDashDashDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?---.?,", new DataDTOToMVELTranslator().buildFieldName("---", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.?---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDashDashDashDotQuestionMarkDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("?---.?---", new DataDTOToMVELTranslator().buildFieldName("---", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDashDashDashDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?---.??", new DataDTOToMVELTranslator().buildFieldName("---", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?\.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkBackslashDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?\\.?", dataDTOToMVELTranslator.buildFieldName("", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("?.?---", new DataDTOToMVELTranslator().buildFieldName("", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?.?", dataDTOToMVELTranslator.buildFieldName(".", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?.?.?,", new DataDTOToMVELTranslator().buildFieldName(".", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?==}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkEqualsSignEqualsSign() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?==",
        new DataDTOToMVELTranslator().buildFieldName("", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("?.?!", dataDTOToMVELTranslator.buildFieldName("", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.??", dataDTOToMVELTranslator.buildFieldName("", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("?.?\"", dataDTOToMVELTranslator.buildFieldName("", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkDotQuestionMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("?.?)", dataDTOToMVELTranslator.buildFieldName("", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?==.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkEqualsSignEqualsSignDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?",
        new DataDTOToMVELTranslator().buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?!.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkExclamationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?!.?", dataDTOToMVELTranslator.buildFieldName("!", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?!.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkExclamationMarkDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?!.?,", new DataDTOToMVELTranslator().buildFieldName("!", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ??.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??.?", dataDTOToMVELTranslator.buildFieldName("?", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ??.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkQuestionMarkDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("??.?,", new DataDTOToMVELTranslator().buildFieldName("?", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ??.?---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkQuestionMarkDotQuestionMarkDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("??.?---", new DataDTOToMVELTranslator().buildFieldName("?", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ??.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??.??", dataDTOToMVELTranslator.buildFieldName("?", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?".?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkQuotationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?\".?", dataDTOToMVELTranslator.buildFieldName("\"", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?".?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkQuotationMarkDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?\".?,", new DataDTOToMVELTranslator().buildFieldName("\"", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?).?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkRightParenthesisDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?).?", dataDTOToMVELTranslator.buildFieldName(")", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ?).?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_thenReturnQuestionMarkRightParenthesisDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?).?,", new DataDTOToMVELTranslator().buildFieldName(")", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return {@code ?,.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenComma_thenReturnQuestionMarkCommaDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?,.?,", new DataDTOToMVELTranslator().buildFieldName(",", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code .?}.
   *   <li>Then return {@code ?.??.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenDotQuestionMark_thenReturnMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName(".?", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code ?.?.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenDot_thenReturnMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName(".", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEmptyString_thenReturnMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code ?.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEmptyString_thenReturnMvelHelperToUpperCase2() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code ?,.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEmptyString_thenReturnQuestionMarkCommaDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?,.?", dataDTOToMVELTranslator.buildFieldName(",", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code ?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEmptyString_thenReturnQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?.?", dataDTOToMVELTranslator.buildFieldName("", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code ?.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEmptyString_thenReturnQuestionMarkDotQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?.?,", new DataDTOToMVELTranslator().buildFieldName("", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey2() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.??", dataDTOToMVELTranslator.buildFieldName("Entity Key", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?\.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey3() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?\\.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey4() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?.??", dataDTOToMVELTranslator.buildFieldName("Entity Key", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey5() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?!", dataDTOToMVELTranslator.buildFieldName("Entity Key", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey6() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?\"", dataDTOToMVELTranslator.buildFieldName("Entity Key", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey7() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?", dataDTOToMVELTranslator.buildFieldName("Entity Key", ""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey8() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?)", dataDTOToMVELTranslator.buildFieldName("Entity Key", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey9() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?,", new DataDTOToMVELTranslator().buildFieldName("Entity Key", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey10() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?---", new DataDTOToMVELTranslator().buildFieldName("Entity Key", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?==}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey11() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?==",
        new DataDTOToMVELTranslator()
            .buildFieldName("Entity Key", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKey42() {
    // Arrange, Act and Assert
    assertEquals("?Entity Key.?42", dataDTOToMVELTranslator.buildFieldName("Entity Key", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKeyFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?Field Name",
        dataDTOToMVELTranslator.buildFieldName("Entity Key", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Key}.
   *   <li>Then return {@code ?Entity Key.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenEntityKey_thenReturnEntityKeyMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("Entity Key", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?42.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturn42FieldName() {
    // Arrange, Act and Assert
    assertEquals("?42.?Field Name", dataDTOToMVELTranslator.buildFieldName("42", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?.?.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName() {
    // Arrange, Act and Assert
    assertEquals("?.?.?Field Name", dataDTOToMVELTranslator.buildFieldName(".", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ??.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName2() {
    // Arrange, Act and Assert
    assertEquals("??.?Field Name", dataDTOToMVELTranslator.buildFieldName("?", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?\.?.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName3() {
    // Arrange, Act and Assert
    assertEquals("?\\.?.?Field Name", dataDTOToMVELTranslator.buildFieldName("\\.", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?.??.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName4() {
    // Arrange, Act and Assert
    assertEquals("?.??.?Field Name", dataDTOToMVELTranslator.buildFieldName(".?", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?!.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName5() {
    // Arrange, Act and Assert
    assertEquals("?!.?Field Name", dataDTOToMVELTranslator.buildFieldName("!", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?".?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName6() {
    // Arrange, Act and Assert
    assertEquals("?\".?Field Name", dataDTOToMVELTranslator.buildFieldName("\"", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName7() {
    // Arrange, Act and Assert
    assertEquals("?.?Field Name", dataDTOToMVELTranslator.buildFieldName("", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?).?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName8() {
    // Arrange, Act and Assert
    assertEquals("?).?Field Name", dataDTOToMVELTranslator.buildFieldName(")", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?,.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName9() {
    // Arrange, Act and Assert
    assertEquals("?,.?Field Name", dataDTOToMVELTranslator.buildFieldName(",", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?---.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName10() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?Field Name", new DataDTOToMVELTranslator().buildFieldName("---", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?==.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnFieldName11() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?Field Name",
        new DataDTOToMVELTranslator()
            .buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenFieldName_thenReturnMvelHelperToUpperCaseFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?Field Name",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "Field Name"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?42.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturn42MvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("42", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?.?",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase2() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.??",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?\.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase3() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?\\.?",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "\\."));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase4() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?.??",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", ".?"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase5() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?!",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase6() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?\"",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase7() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?)",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", ")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase8() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?,",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", ","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase9() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?---",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?==}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase10() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?==",
        new DataDTOToMVELTranslator()
            .buildFieldName("MvelHelper.toUpperCase(", DataDTOToMVELTranslator.EQUALS_OPERATOR));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ??.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase11() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("?", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?\.?.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase12() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("\\.", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?!.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase13() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("!", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?".?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase14() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("\"", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?).?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase15() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName(")", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?,.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase16() {
    // Arrange, Act and Assert
    assertEquals(
        "?,.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName(",", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?---.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase17() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator().buildFieldName("---", "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?==.?MvelHelper.?toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase18() {
    // Arrange, Act and Assert
    assertEquals(
        "?==.?MvelHelper.?toUpperCase(",
        new DataDTOToMVELTranslator()
            .buildFieldName(DataDTOToMVELTranslator.EQUALS_OPERATOR, "MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code MvelHelper.toUpperCase(}.
   *   <li>Then return {@code ?MvelHelper.?toUpperCase(.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenMvelHelperToUpperCase_thenReturnMvelHelperToUpperCase42() {
    // Arrange, Act and Assert
    assertEquals(
        "?MvelHelper.?toUpperCase(.?42",
        new DataDTOToMVELTranslator().buildFieldName("MvelHelper.toUpperCase(", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildFieldName(String, String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@code ?).?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildFieldName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.buildFieldName(String, String)"})
  public void testBuildFieldName_whenRightParenthesis_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("?).?42", dataDTOToMVELTranslator.buildFieldName(")", "42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField2() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?\\.?",
        dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField3() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?.??",
        dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField4() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?!", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField5() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?\"",
        dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField6() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?\\.?",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField7() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?.??",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField8() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?\\.?",
        dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField9() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?.??",
        dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField10() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?.?",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField11() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.??",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField12() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?\\.?",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField13() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?.??",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField14() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?!",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField15() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?\"",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField16() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?.?",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField17() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.??",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField18() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?\\.?",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField19() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?.??",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField20() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?!",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField21() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?\"",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField22() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField23() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?\\.?",
        dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField24() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?.??",
        dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField25() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?!", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField26() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?\"", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField27() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?.?",
        dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField28() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?\\.?",
        dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField29() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?.??",
        dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField30() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?!", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField31() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?.?",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField32() {
    // Arrange, Act and Assert
    assertEquals(
        "?).??",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField33() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?\\.?",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField34() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?.??",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField35() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?!",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField36() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?\"",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField37() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?)",
        new DataDTOToMVELTranslator().formatField(".", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField38() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?)",
        new DataDTOToMVELTranslator().formatField("---", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField39() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?)",
        new DataDTOToMVELTranslator().formatField("?", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField40() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?)",
        new DataDTOToMVELTranslator().formatField("\\.", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField41() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?)",
        new DataDTOToMVELTranslator().formatField(".?", SupportedFieldType.UNKNOWN, ")", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ??.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?42", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?\.?.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?42",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?.?",
        dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.??", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?\.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?\\.?",
        dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?.??",
        dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?!", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?\"",
        dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?42.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?42",
        dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code ?Entity Key.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_when42_thenReturnEntityKey42() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?42",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code ---}.
   *   <li>Then return {@code ?---.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenDashDashDash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?42",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code ---}.
   *   <li>Then return {@code ?---.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenDashDashDash_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?Field",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code .?}.
   *   <li>Then return {@code ?.??.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenDotQuestionMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?42",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code .}.
   *   <li>Then return {@code ?.?.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenDot_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?42",
        dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code .}.
   *   <li>Then return {@code ?Entity Key.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenDot_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When empty string.
   *   <li>Then return {@code ?42.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenEmptyString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?", dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When empty string.
   *   <li>Then return {@code ?.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenEmptyString_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?42", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When empty string.
   *   <li>Then return {@code ?Entity Key.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenEmptyString_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When empty string.
   *   <li>Then return {@code ?.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenEmptyString_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?Field",
        dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code !}.
   *   <li>Then return {@code ?!.?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenExclamationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?42", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ?42.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturn42Field() {
    // Arrange, Act and Assert
    assertEquals(
        "?42.?Field",
        dataDTOToMVELTranslator.formatField("42", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ?Entity Key.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturnEntityKeyField() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?Field",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ?.?.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?Field",
        dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ??.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturnField2() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?Field",
        dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ?\.?.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturnField3() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?Field",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ?.??.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturnField4() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?Field",
        dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ?!.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturnField5() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?Field",
        dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code ?".?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenField_thenReturnField6() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?Field",
        dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code "}.
   *   <li>Then return {@code ?".?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenQuotationMark_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?42",
        dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code )}.
   *   <li>Then return {@code ?).?42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenRightParenthesis_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?42",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, "42", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code STRING_LIST}.
   *   <li>Then return {@code ?Entity Key.?[""]}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenStringList_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?[\"\"]",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.STRING_LIST, "---", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code STRING}.
   *   <li>Then return {@code ?Entity Key.?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_givenDataDTOToMVELTranslator_whenString_thenReturnEntityKeyField() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?Field",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.STRING, "Field", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code MvelHelper.toUpperCase(?Entity Key.?MvelHelper.?toUpperCase()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnMvelHelperToUpperCaseEntityKeyMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(?Entity Key.?MvelHelper.?toUpperCase()",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.STRING, "MvelHelper.toUpperCase(", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code MvelHelper.toUpperCase(?MvelHelper.?toUpperCase(.?Field)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnMvelHelperToUpperCaseMvelHelperToUpperCaseField() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(?MvelHelper.?toUpperCase(.?Field)",
        dataDTOToMVELTranslator.formatField(
            "MvelHelper.toUpperCase(", SupportedFieldType.STRING, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?\.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkBackslashDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?\\.?.?",
        dataDTOToMVELTranslator.formatField("\\.", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?", dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?.?",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?!",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.??",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?---.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDashDashDashDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?---.?\"",
        dataDTOToMVELTranslator.formatField("---", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?\.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkBackslashDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?\\.?",
        dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.?", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?.??", dataDTOToMVELTranslator.formatField(".", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?!", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?.??.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.??.?", dataDTOToMVELTranslator.formatField(".?", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?\"", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?!.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkExclamationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.?", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?!.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkExclamationMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?!.??", dataDTOToMVELTranslator.formatField("!", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ??.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ??.?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?.?", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, ".", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ??.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkExclamationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?!", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ??.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "??.??", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ??.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuestionMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "??.?\"", dataDTOToMVELTranslator.formatField("?", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?".?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuotationMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?".??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuotationMarkDotQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".??", dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?".?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkQuotationMarkDotQuestionMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?\".?\"",
        dataDTOToMVELTranslator.formatField("\"", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ?).?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_thenReturnQuestionMarkRightParenthesisDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?",
        new DataDTOToMVELTranslator().formatField(")", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code \.}.
   *   <li>Then return {@code ?Entity Key.?\.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenBackslashDot_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?\\.?",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "\\.", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code MvelHelper.convertField("BOOLEAN",?Entity Key.?[""])}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenBoolean_thenReturnMvelHelperConvertFieldBooleanEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.convertField(\"BOOLEAN\",?Entity Key.?[\"\"])",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.BOOLEAN, "---", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code BROADLEAF_ENUMERATION}.
   *   <li>Then return {@code ?Entity Key.?Field.getType()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenBroadleafEnumeration_thenReturnEntityKeyFieldGetType() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?Field.getType()",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.BROADLEAF_ENUMERATION, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code BROADLEAF_ENUMERATION}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenBroadleafEnumeration_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataDTOToMVELTranslator.formatField(
                "Entity Key", SupportedFieldType.BROADLEAF_ENUMERATION, "---", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code DATA_DRIVEN_ENUMERATION}.
   *   <li>Then return {@code ?Entity Key.?[""]}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenDataDrivenEnumeration_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?[\"\"]",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.DATA_DRIVEN_ENUMERATION, "---", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then return {@code MvelHelper.convertField("DATE",?Entity Key.?[""])}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenDate_thenReturnMvelHelperConvertFieldDateEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.convertField(\"DATE\",?Entity Key.?[\"\"])",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.DATE, "---", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then return {@code MvelHelper.convertField("DECIMAL",?Entity Key.?[""])}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenDecimal_thenReturnMvelHelperConvertFieldDecimalEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.convertField(\"DECIMAL\",?Entity Key.?[\"\"])",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.DECIMAL, "---", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code .?}.
   *   <li>Then return {@code ?Entity Key.?.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenDotQuestionMark_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?.??",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, ".?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code ?.?}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenEmptyString_thenReturnQuestionMarkDotQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?", dataDTOToMVELTranslator.formatField("", SupportedFieldType.UNKNOWN, "", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code !}.
   *   <li>Then return {@code ?Entity Key.?!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenExclamationMark_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?!",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "!", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code .getAmount()}.
   *   <li>Then return {@code ?Entity Key.?.?getAmount().getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenGetAmount_thenReturnEntityKeyGetAmountGetAmount() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?.?getAmount().getAmount()",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.MONEY, ".getAmount()", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code .getAmount()}.
   *   <li>Then return {@code ?.?getAmount().?Field.getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenGetAmount_thenReturnGetAmountFieldGetAmount() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?getAmount().?Field.getAmount()",
        dataDTOToMVELTranslator.formatField(
            ".getAmount()", SupportedFieldType.MONEY, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code .getType()}.
   *   <li>Then return {@code ?Entity Key.?.?getType().getType()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenGetType_thenReturnEntityKeyGetTypeGetType() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?.?getType().getType()",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.BROADLEAF_ENUMERATION, ".getType()", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code .getType()}.
   *   <li>Then return {@code ?.?getType().?Field.getType()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenGetType_thenReturnGetTypeFieldGetType() {
    // Arrange, Act and Assert
    assertEquals(
        "?.?getType().?Field.getType()",
        dataDTOToMVELTranslator.formatField(
            ".getType()", SupportedFieldType.BROADLEAF_ENUMERATION, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return {@code MvelHelper.convertField("INTEGER",?Entity Key.?[""])}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenInteger_thenReturnMvelHelperConvertFieldIntegerEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.convertField(\"INTEGER\",?Entity Key.?[\"\"])",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.INTEGER, "---", false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code MONEY}.
   *   <li>Then return {@code ?Entity Key.?Field.getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenMoney_thenReturnEntityKeyFieldGetAmount() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?Field.getAmount()",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.MONEY, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   *   <li>Then return {@code ?Entity Key.??}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenQuestionMark_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.??",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "?", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code "}.
   *   <li>Then return {@code ?Entity Key.?"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenQuotationMark_thenReturnEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "?Entity Key.?\"",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.UNKNOWN, "\"", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@code ?).?Field}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenRightParenthesis_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals(
        "?).?Field",
        dataDTOToMVELTranslator.formatField(")", SupportedFieldType.UNKNOWN, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@code MvelHelper.toUpperCase(?Entity Key.?[""])}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenString_thenReturnMvelHelperToUpperCaseEntityKey() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(?Entity Key.?[\"\"])",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.STRING, "---", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@code MvelHelper.toUpperCase(?Entity Key.?))}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenString_thenReturnMvelHelperToUpperCaseEntityKey2() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(?Entity Key.?))",
        dataDTOToMVELTranslator.formatField("Entity Key", SupportedFieldType.STRING, ")", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@code MvelHelper.toUpperCase(?Entity Key.?Field)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatField(String, SupportedFieldType,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatField(String, SupportedFieldType, String, boolean)"
  })
  public void testFormatField_whenString_thenReturnMvelHelperToUpperCaseEntityKeyField() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(?Entity Key.?Field)",
        dataDTOToMVELTranslator.formatField(
            "Entity Key", SupportedFieldType.STRING, "Field", true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenBoolean_thenReturnValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "Value",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.BOOLEAN,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value"},
            false,
            false,
            false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code DECIMAL}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenDecimal_thenReturn42()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new DataDTOToMVELTranslator()
            .formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.DECIMAL,
                SupportedFieldType.UNKNOWN,
                new Object[] {42},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ID}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenId_thenReturn42()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new DataDTOToMVELTranslator()
            .formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.ID,
                SupportedFieldType.UNKNOWN,
                new Object[] {42},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ID}.
   *   <li>Then return {@code "42"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenId_thenReturn422()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "\"42\"",
        new DataDTOToMVELTranslator()
            .formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.ID,
                SupportedFieldType.STRING,
                new Object[] {42},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ID}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenId_thenReturn423()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new DataDTOToMVELTranslator()
            .formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.ID,
                SupportedFieldType.STRING,
                new Object[] {42},
                false,
                false,
                true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code INTEGER}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenInteger_thenReturn42()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new DataDTOToMVELTranslator()
            .formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.INTEGER,
                SupportedFieldType.UNKNOWN,
                new Object[] {42},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code MONEY}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenMoney_thenReturn42()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new DataDTOToMVELTranslator()
            .formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                new Object[] {42},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code STRING}.
   *   <li>Then return {@code Entity Key.Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenString_thenReturnEntityKeyValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "Entity Key.Value",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.STRING,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value"},
            true,
            false,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code STRING}.
   *   <li>Then return {@code "Value"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_givenDataDTOToMVELTranslator_whenString_thenReturnValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "\"Value\"",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.STRING,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value"},
            false,
            false,
            false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code MvelHelper.toUpperCase(\\")}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_thenReturnMvelHelperToUpperCase() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(\\\\\")",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.UNKNOWN,
            SupportedFieldType.UNKNOWN,
            new Object[] {"\\\""},
            false,
            true,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code MvelHelper.toUpperCase(Value),MvelHelper.toUpperCase(Value)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_thenReturnMvelHelperToUpperCaseValueMvelHelperToUpperCaseValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(Value),MvelHelper.toUpperCase(Value)",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.UNKNOWN,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value", "Value"},
            false,
            true,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When array of {@link Object} with empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenArrayOfObjectWithEmptyString_thenReturnEmptyString()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.UNKNOWN,
            SupportedFieldType.UNKNOWN,
            new Object[] {""},
            false,
            true,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Value}.
   *   <li>Then return {@code Entity Key.Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenArrayOfObjectWithValue_thenReturnEntityKeyValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "Entity Key.Value",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.UNKNOWN,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value"},
            true,
            true,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Value}.
   *   <li>Then return {@code MvelHelper.toUpperCase(Value)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenArrayOfObjectWithValue_thenReturnMvelHelperToUpperCaseValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(Value)",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.UNKNOWN,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value"},
            false,
            true,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenDate_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.DATE,
                SupportedFieldType.UNKNOWN,
                new Object[] {"Value"},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenDecimal_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.DECIMAL,
                SupportedFieldType.UNKNOWN,
                new Object[] {"Value"},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code ID}.
   *   <li>Then return {@code MvelHelper.toUpperCase("42")}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenId_thenReturnMvelHelperToUpperCase42()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(\"42\")",
        new DataDTOToMVELTranslator()
            .formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.ID,
                SupportedFieldType.STRING,
                new Object[] {42},
                false,
                true,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code ID}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenId_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.ID,
                SupportedFieldType.UNKNOWN,
                new Object[] {"Value"},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenInteger_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.INTEGER,
                SupportedFieldType.UNKNOWN,
                new Object[] {"Value"},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code MONEY}.
   *   <li>Then return {@code Entity Key.Value.getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenMoney_thenReturnEntityKeyValueGetAmount()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "Entity Key.Value.getAmount()",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.MONEY,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value"},
            true,
            true,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code MONEY}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenMoney_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.MONEY,
                SupportedFieldType.UNKNOWN,
                new Object[] {"Value"},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenNull_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            dataDTOToMVELTranslator.formatValue(
                "Field Name",
                "Entity Key",
                SupportedFieldType.ID,
                null,
                new Object[] {"Value"},
                false,
                false,
                false));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#formatValue(String, String, SupportedFieldType,
   * SupportedFieldType, Object[], boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@code MvelHelper.toUpperCase(Entity Key.Value)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#formatValue(String, String,
   * SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DataDTOToMVELTranslator.formatValue(String, String, SupportedFieldType, SupportedFieldType, Object[], boolean, boolean, boolean)"
  })
  public void testFormatValue_whenString_thenReturnMvelHelperToUpperCaseEntityKeyValue()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase(Entity Key.Value)",
        dataDTOToMVELTranslator.formatValue(
            "Field Name",
            "Entity Key",
            SupportedFieldType.STRING,
            SupportedFieldType.UNKNOWN,
            new Object[] {"Value"},
            true,
            true,
            true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#extractBasicValues(Object)}.
   *
   * <ul>
   *   <li>Then return first element is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] DataDTOToMVELTranslator.extractBasicValues(Object)"})
  public void testExtractBasicValues_thenReturnFirstElementIsLeftSquareBracket() {
    // Arrange and Act
    Object[] actualExtractBasicValuesResult = new DataDTOToMVELTranslator().extractBasicValues("[");

    // Assert
    assertEquals("[", actualExtractBasicValuesResult[0]);
    assertEquals(1, actualExtractBasicValuesResult.length);
  }

  /**
   * Test {@link DataDTOToMVELTranslator#extractBasicValues(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] DataDTOToMVELTranslator.extractBasicValues(Object)"})
  public void testExtractBasicValues_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DataDTOToMVELTranslator().extractBasicValues(null));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#extractBasicValues(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return first element is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#extractBasicValues(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] DataDTOToMVELTranslator.extractBasicValues(Object)"})
  public void testExtractBasicValues_whenValue_thenReturnFirstElementIsValue() {
    // Arrange and Act
    Object[] actualExtractBasicValuesResult =
        new DataDTOToMVELTranslator().extractBasicValues("Value");

    // Assert
    assertEquals("Value", actualExtractBasicValuesResult[0]);
    assertEquals(1, actualExtractBasicValuesResult.length);
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes2() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"\\\\\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes3() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"!", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes4() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\")", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes5() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"---", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes6() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"==", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"=="));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes7() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"[", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"["));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes8() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"\\\"", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes9() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"]", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"]"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes10() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"||", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"||"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes11() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"\\\\\"", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"\\\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes12() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"!", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes13() {
    // Arrange, Act and Assert
    assertEquals("\\\\\")", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes14() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"==", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"=="));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes15() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"[", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"["));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes16() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"\\\"", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes17() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"]", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"]"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes18() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"||", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"||"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code 42(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_when42SS_thenReturn42SS() {
    // Arrange, Act and Assert
    assertEquals(
        "42(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("42(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", dataDTOToMVELTranslator.escapeInternalQuotes("42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code \\"42}.
   *   <li>Then return {@code \\\"42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\"42", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code \"42}.
   *   <li>Then return {@code \\"42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"42", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)42}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS42_thenReturnSS42() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)42",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSSSS_thenReturnSSSS() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code "(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code "(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS2() {
    // Arrange, Act and Assert
    assertEquals(
        "\"(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)"}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS3() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\\"}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)\\"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS4() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\\\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)!}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS5() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)!",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$))}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$))}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS6() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$))",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$))"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$),}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$),}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS7() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$),",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$),"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)---}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS8() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)---",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)==}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)==}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS9() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)==",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)=="));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)[}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)[}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS10() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)[",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)["));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\"}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)\"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS11() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\"",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)]}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)]}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS12() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)]",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)]"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)||}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)||}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS13() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)||",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)||"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code \\"(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code \\\"(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS14() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\\"(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code !(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code !(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS15() {
    // Arrange, Act and Assert
    assertEquals(
        "!(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes("!(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code )(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code )(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS16() {
    // Arrange, Act and Assert
    assertEquals(
        ")(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes(")(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ,(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ,(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS17() {
    // Arrange, Act and Assert
    assertEquals(
        ",(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes(",(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ---(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ---(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS18() {
    // Arrange, Act and Assert
    assertEquals(
        "---(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes("---(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ==(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ==(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS19() {
    // Arrange, Act and Assert
    assertEquals(
        "==(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes("==(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code [(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code [(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS20() {
    // Arrange, Act and Assert
    assertEquals(
        "[(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes("[(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code \"(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code \\"(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS21() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\"(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code ](?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ](?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenSS_thenReturnSS22() {
    // Arrange, Act and Assert
    assertEquals(
        "](?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalQuotes("](?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code \\"\\u0022}.
   *   <li>Then return {@code \\\"\\u0022}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenU0022_thenReturnU0022() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\\"\\\\u0022", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator} (default constructor).
   *   <li>When {@code \"\\u0022}.
   *   <li>Then return {@code \\"\\u0022}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_givenDataDTOToMVELTranslator_whenU0022_thenReturnU00222() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\"\\\\u0022", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\",}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnBackslashBackslashBackslashQuotationMarkComma() {
    // Arrange, Act and Assert
    assertEquals("\\\\\\\",", dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\",}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnBackslashBackslashQuotationMarkComma() {
    // Arrange, Act and Assert
    assertEquals("\\\\\",", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\"---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnBackslashBackslashQuotationMarkDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"---", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\""}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnBackslashBackslashQuotationMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\\\\"\"", new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\"MvelHelper.toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\\"MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\"MvelHelper.toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnMvelHelperToUpperCase2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\"MvelHelper.toUpperCase(",
        new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code MvelHelper.toUpperCase((?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnMvelHelperToUpperCaseSS() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase((?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalQuotes("MvelHelper.toUpperCase((?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\"org.apache.commons.lang3.StringUtils.contains}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsContains() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\\"org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "\\\\\"org.apache.commons.lang3.StringUtils.contains"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\"org.apache.commons.lang3.StringUtils.contains}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsContains2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\"org.apache.commons.lang3.StringUtils.contains",
        new DataDTOToMVELTranslator()
            .escapeInternalQuotes("\\\"org.apache.commons.lang3.StringUtils.contains"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code
   *       org.apache.commons.lang3.StringUtils.contains(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsContainsSS() {
    // Arrange, Act and Assert
    assertEquals(
        "org.apache.commons.lang3.StringUtils.contains(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalQuotes(
                "org.apache.commons.lang3.StringUtils.contains(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\"org.apache.commons.lang3.StringUtils.endsWith}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsEndsWith() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\\"org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "\\\\\"org.apache.commons.lang3.StringUtils.endsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\"org.apache.commons.lang3.StringUtils.endsWith}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsEndsWith2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\"org.apache.commons.lang3.StringUtils.endsWith",
        new DataDTOToMVELTranslator()
            .escapeInternalQuotes("\\\"org.apache.commons.lang3.StringUtils.endsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\\"org.apache.commons.lang3.StringUtils.startsWith}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsStartsWith() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\\"org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "\\\\\"org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\"org.apache.commons.lang3.StringUtils.startsWith}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnOrgApacheCommonsLang3StringUtilsStartsWith2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\"org.apache.commons.lang3.StringUtils.startsWith",
        new DataDTOToMVELTranslator()
            .escapeInternalQuotes("\\\"org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)MvelHelper.toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnSSMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code
   *       (?<!^)(?<!^\s)\"(?!\s$)(?!$)org.apache.commons.lang3.StringUtils.contains}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnSSOrgApacheCommonsLang3StringUtilsContains() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code
   *       (?<!^)(?<!^\s)\"(?!\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnSSOrgApacheCommonsLang3StringUtilsEndsWith() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code
   *       (?<!^)(?<!^\s)\"(?!\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_thenReturnSSOrgApacheCommonsLang3StringUtilsStartsWith() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", dataDTOToMVELTranslator.escapeInternalQuotes(""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code Processed Value(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code Processed Value(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenProcessedValueSS_thenReturnProcessedValueSS() {
    // Arrange, Act and Assert
    assertEquals(
        "Processed Value(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "Processed Value(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \\"Processed Value}.
   *   <li>Then return {@code \\\"Processed Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenProcessedValue_thenReturnProcessedValue() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\\"Processed Value",
        dataDTOToMVELTranslator.escapeInternalQuotes("\\\\\"Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \"Processed Value}.
   *   <li>Then return {@code \\"Processed Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenProcessedValue_thenReturnProcessedValue2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\"Processed Value",
        new DataDTOToMVELTranslator().escapeInternalQuotes("\\\"Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code "}.
   *   <li>Then return {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", dataDTOToMVELTranslator.escapeInternalQuotes("\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)Processed Value}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)Processed Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenSSProcessedValue_thenReturnSSProcessedValue() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)Processed Value",
        dataDTOToMVELTranslator.escapeInternalQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\\u0022}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\"(?!\s$)(?!$)\\u0022}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenSSU0022_thenReturnSSU0022() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \\u0022(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code \\u0022(?<!^)(?<!^\s)\"(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalQuotes(String)"})
  public void testEscapeInternalQuotes_whenU0022SS_thenReturnU0022SS() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022(?<!^)(?<!^\\s)\\\"(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalQuotes("\\\\u0022(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.contains"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes2() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.endsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes3() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes4() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022org.apache.commons.lang3.StringUtils.contains",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("\\\"org.apache.commons.lang3.StringUtils.contains"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes5() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022org.apache.commons.lang3.StringUtils.endsWith",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("\\\"org.apache.commons.lang3.StringUtils.endsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes6() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022org.apache.commons.lang3.StringUtils.startsWith",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("\\\"org.apache.commons.lang3.StringUtils.startsWith"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes7() {
    // Arrange, Act and Assert
    assertEquals(
        "org.apache.commons.lang3.StringUtils.contains(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes(
                "org.apache.commons.lang3.StringUtils.contains(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTOToMVELTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_givenDataDTOToMVELTranslator_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", dataDTOToMVELTranslator.escapeInternalMiltyQuotes("42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code MvelHelper.toUpperCase((?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnMvelHelperToUpperCaseSU0022S() {
    // Arrange, Act and Assert
    assertEquals(
        "MvelHelper.toUpperCase((?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("MvelHelper.toUpperCase((?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code Processed Value(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnProcessedValueSU0022S() {
    // Arrange, Act and Assert
    assertEquals(
        "Processed Value(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "Processed Value(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)MvelHelper.toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnSU0022SMvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)MvelHelper.toUpperCase(",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)Processed Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnSU0022SProcessedValue() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)Processed Value",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU0022() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022\"", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022MvelHelper.toUpperCase(}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU0022MvelHelperToUpperCase() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022MvelHelper.toUpperCase(",
        new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"MvelHelper.toUpperCase("));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00222() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022!", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00223() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022)", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\")"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00224() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022---", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022==}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00225() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022==", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"=="));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022[}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00226() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022[", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"["));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022\"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00227() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022\\\"", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022]}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00228() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022]", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"]"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\u0022||}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_thenReturnU00229() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022||", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"||"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code 42(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code 42(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_when42SS_thenReturn42SU0022S() {
    // Arrange, Act and Assert
    assertEquals(
        "42(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("42(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \"42}.
   *   <li>Then return {@code \\u002242}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_when42_thenReturnU002242() {
    // Arrange, Act and Assert
    assertEquals("\\\\u002242", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \",}.
   *   <li>Then return {@code \\u0022,}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenBackslashQuotationMarkComma_thenReturnU0022() {
    // Arrange, Act and Assert
    assertEquals("\\\\u0022,", new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\","));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \"Processed Value}.
   *   <li>Then return {@code \\u0022Processed Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenProcessedValue_thenReturnU0022ProcessedValue() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022Processed Value",
        new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"Processed Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)42}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)42}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS42_thenReturnSU0022S42() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)42",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)42"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSSSS_thenReturnSU0022SSU0022S() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\\\u0022}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)\\\u0022}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSSU0022_thenReturnSU0022SU0022() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\\u0022}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)\\u0022}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSSU0022_thenReturnSU0022SU00222() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\\u0022",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code "(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code "(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S2() {
    // Arrange, Act and Assert
    assertEquals(
        "\"(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)"}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S3() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\"",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)!}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)!}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S4() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)!",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)!"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$))}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$))}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S5() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$))",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$))"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$),}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$),}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S6() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$),",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$),"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)---}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)---}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S7() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)---",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)---"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)==}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)==}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S8() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)==",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)=="));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)[}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)[}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S9() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)[",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)["));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)\"}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)\"}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S10() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)\\\"",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)\\\""));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)]}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)]}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S11() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)]",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)]"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code (?<!^)(?<!^\s)"(?!\s$)(?!$)||}.
   *   <li>Then return {@code (?<!^)(?<!^\s)\u0022(?!\s$)(?!$)||}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S12() {
    // Arrange, Act and Assert
    assertEquals(
        "(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)||",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)||"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code !(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code !(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S13() {
    // Arrange, Act and Assert
    assertEquals(
        "!(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes("!(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code )(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code )(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S14() {
    // Arrange, Act and Assert
    assertEquals(
        ")(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(")(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code ,(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ,(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S15() {
    // Arrange, Act and Assert
    assertEquals(
        ",(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(",(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code ---(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ---(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S16() {
    // Arrange, Act and Assert
    assertEquals(
        "---(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("---(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code ==(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ==(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S17() {
    // Arrange, Act and Assert
    assertEquals(
        "==(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("==(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code [(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code [(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S18() {
    // Arrange, Act and Assert
    assertEquals(
        "[(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("[(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code ](?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code ](?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnSU0022S19() {
    // Arrange, Act and Assert
    assertEquals(
        "](?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("](?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \"(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code \\u0022(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenSS_thenReturnU0022SU0022S() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("\\\"(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \\\u0022(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code \\\u0022(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenU0022SS_thenReturnU0022SU0022S() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\\\u0022(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        dataDTOToMVELTranslator.escapeInternalMiltyQuotes(
            "\\\\\\u0022(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \\u0022(?<!^)(?<!^\s)"(?!\s$)(?!$)}.
   *   <li>Then return {@code \\u0022(?<!^)(?<!^\s)\u0022(?!\s$)(?!$)}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenU0022SS_thenReturnU0022SU0022S2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022(?<!^)(?<!^\\s)\\u0022(?!\\s$)(?!$)",
        new DataDTOToMVELTranslator()
            .escapeInternalMiltyQuotes("\\\\u0022(?<!^)(?<!^\\s)\"(?!\\s$)(?!$)"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \"\\\u0022}.
   *   <li>Then return {@code \\u0022\\\u0022}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenU0022_thenReturnU0022U0022() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022\\\\\\u0022",
        new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"\\\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}.
   *
   * <ul>
   *   <li>When {@code \"\\u0022}.
   *   <li>Then return {@code \\u0022\\u0022}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#escapeInternalMiltyQuotes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTOToMVELTranslator.escapeInternalMiltyQuotes(String)"})
  public void testEscapeInternalMiltyQuotes_whenU0022_thenReturnU0022U00222() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\u0022\\\\u0022",
        new DataDTOToMVELTranslator().escapeInternalMiltyQuotes("\\\"\\\\u0022"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#isProjection(Object)}.
   *
   * <ul>
   *   <li>When {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#isProjection(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataDTOToMVELTranslator.isProjection(Object)"})
  public void testIsProjection_whenLeftSquareBracket() {
    // Arrange, Act and Assert
    assertFalse(new DataDTOToMVELTranslator().isProjection("["));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#isProjection(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#isProjection(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataDTOToMVELTranslator.isProjection(Object)"})
  public void testIsProjection_whenValue() {
    // Arrange, Act and Assert
    assertFalse(new DataDTOToMVELTranslator().isProjection("Value"));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?Field,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression2() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "Field",
        new Object[] {"Value", "Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?Field,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression3() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        ".",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?.?.?Field,[..Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression4() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "(",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?(.?Field,[(.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression5() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "---",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?---.?Field,[---.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression6() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "?",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(??.?Field,[?.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression7() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "\\.",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?\\.?.?Field,[\\..Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression8() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        ".?",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?.??.?Field,[.?.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression9() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "!",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?!.?Field,[!.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression10() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "42",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?42.?Field,[42.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression11() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        ",",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?,.?Field,[,.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression12() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "\"",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?\".?Field,[\".Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression13() throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?.?Field,[.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression14() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        ".",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?.?,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression15() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "(",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?(,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression16() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "?",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.??,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression17() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "\\.",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?\\.?,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression18() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        ".?",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?.??,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression19() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "!",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?!,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression20() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "42",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?42,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression21() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        ",",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?,,[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression22() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "\"",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?\",[Entity Key.Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression23() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?,[Entity Key.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression24() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        false,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?Field,[MvelHelper.toUpperCase(Value)])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression25() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "[",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?[.?Field,[[.Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression26() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        ")",
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals("fooCollectionUtils.intersection(?).?Field,[).Value])Operator", sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression_thenThrowUnsupportedOperationException()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataDTOToMVELTranslator.buildCollectionExpression(
                new StringBuffer("foo"),
                "Entity Key",
                "---",
                new Object[] {"Value"},
                SupportedFieldType.UNKNOWN,
                SupportedFieldType.UNKNOWN,
                "Operator",
                true,
                true,
                true,
                true,
                true));
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Value} and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression_whenArrayOfObjectWithValueAndValue()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        "Field",
        new Object[] {"Value", "Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        false,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?Field,[MvelHelper.toUpperCase(Value),MvelHelper.toUpperCase"
            + "(Value)])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link DataDTOToMVELTranslator#COLLECTION_OPERATOR}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression_whenCollection_operator()
      throws MVELTranslationException {
    // Arrange
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        DataDTOToMVELTranslator.COLLECTION_OPERATOR,
        "Field",
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?CollectionUtils.?intersection.?Field,[CollectionUtils.intersection"
            + ".Value])Operator",
        sb.toString());
  }

  /**
   * Test {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer, String, String,
   * Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link DataDTOToMVELTranslator#COLLECTION_OPERATOR}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTOToMVELTranslator#buildCollectionExpression(StringBuffer,
   * String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean,
   * boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTOToMVELTranslator.buildCollectionExpression(StringBuffer, String, String, Object[], SupportedFieldType, SupportedFieldType, String, boolean, boolean, boolean, boolean, boolean)"
  })
  public void testBuildCollectionExpression_whenCollection_operator2()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator dataDTOToMVELTranslator = new DataDTOToMVELTranslator();
    StringBuffer sb = new StringBuffer("foo");

    // Act
    dataDTOToMVELTranslator.buildCollectionExpression(
        sb,
        "Entity Key",
        DataDTOToMVELTranslator.COLLECTION_OPERATOR,
        new Object[] {"Value"},
        SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN,
        "Operator",
        true,
        true,
        true,
        true,
        true);

    // Assert
    assertEquals(
        "fooCollectionUtils.intersection(?Entity Key.?CollectionUtils.?intersection,[Entity Key.Value"
            + "])Operator",
        sb.toString());
  }
}
