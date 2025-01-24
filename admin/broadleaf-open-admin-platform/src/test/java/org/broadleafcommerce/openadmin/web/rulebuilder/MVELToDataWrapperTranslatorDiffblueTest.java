package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.grouping.Group;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldService;
import org.broadleafcommerce.openadmin.web.rulebuilder.statement.Expression;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MVELToDataWrapperTranslator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MVELToDataWrapperTranslatorDiffblueTest {
  @Autowired
  private MVELToDataWrapperTranslator mVELToDataWrapperTranslator;

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    DataWrapper actualCreateRuleDataResult = mVELToDataWrapperTranslator.createRuleData(new Entity[]{entity},
        "Mvel Property", "Quantity Property", "Id Property", "Contained Property", mock(RuleBuilderFieldService.class));

    // Assert
    verify(entity).getProperties();
    assertNull(actualCreateRuleDataResult.getError());
    assertNull(actualCreateRuleDataResult.getRawMvel());
    assertTrue(actualCreateRuleDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService2() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(null, "Mvel Property", "Quantity Property", "Id Property",
        "Contained Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService3() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{}, "Mvel Property", "Quantity Property",
        "Id Property", "Contained Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService4() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{mock(Entity.class)}, null, "Quantity Property",
        "Id Property", "Contained Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService5() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    DataWrapper actualCreateRuleDataResult = mVELToDataWrapperTranslator.createRuleData(new Entity[]{entity},
        "Mvel Property", null, "Id Property", "Contained Property", mock(RuleBuilderFieldService.class));

    // Assert
    verify(entity).getProperties();
    assertNull(actualCreateRuleDataResult.getError());
    assertNull(actualCreateRuleDataResult.getRawMvel());
    assertTrue(actualCreateRuleDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService6() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    DataWrapper actualCreateRuleDataResult = mVELToDataWrapperTranslator.createRuleData(new Entity[]{entity},
        "Mvel Property", "Quantity Property", null, "Contained Property", mock(RuleBuilderFieldService.class));

    // Assert
    verify(entity).getProperties();
    assertNull(actualCreateRuleDataResult.getError());
    assertNull(actualCreateRuleDataResult.getRawMvel());
    assertTrue(actualCreateRuleDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService7() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    DataWrapper actualCreateRuleDataResult = mVELToDataWrapperTranslator.createRuleData(new Entity[]{entity},
        "Mvel Property", "Quantity Property", "Id Property", null, mock(RuleBuilderFieldService.class));

    // Assert
    verify(entity).getProperties();
    assertNull(actualCreateRuleDataResult.getError());
    assertNull(actualCreateRuleDataResult.getRawMvel());
    assertTrue(actualCreateRuleDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    DataWrapper actualCreateRuleDataResult = mVELToDataWrapperTranslator.createRuleData(new Entity[]{entity},
        "Mvel Property", "Quantity Property", "Id Property", mock(RuleBuilderFieldService.class));

    // Assert
    verify(entity).getProperties();
    assertNull(actualCreateRuleDataResult.getError());
    assertNull(actualCreateRuleDataResult.getRawMvel());
    assertTrue(actualCreateRuleDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService2() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(null, "Mvel Property", "Quantity Property", "Id Property",
        mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService3() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{}, "Mvel Property", "Quantity Property",
        "Id Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService4() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{mock(Entity.class)}, null, "Quantity Property",
        "Id Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService5() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    DataWrapper actualCreateRuleDataResult = mVELToDataWrapperTranslator.createRuleData(new Entity[]{entity},
        "Mvel Property", null, "Id Property", mock(RuleBuilderFieldService.class));

    // Assert
    verify(entity).getProperties();
    assertNull(actualCreateRuleDataResult.getError());
    assertNull(actualCreateRuleDataResult.getRawMvel());
    assertTrue(actualCreateRuleDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   * with {@code entities}, {@code mvelProperty}, {@code quantityProperty},
   * {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService6() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    DataWrapper actualCreateRuleDataResult = mVELToDataWrapperTranslator.createRuleData(new Entity[]{entity},
        "Mvel Property", "Quantity Property", null, mock(RuleBuilderFieldService.class));

    // Assert
    verify(entity).getProperties();
    assertNull(actualCreateRuleDataResult.getError());
    assertNull(actualCreateRuleDataResult.getRawMvel());
    assertTrue(actualCreateRuleDataResult.getData().isEmpty());
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}
   */
  @Test
  public void testCheckForInvalidSubGroup() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    // Act and Assert
    assertFalse(mvelToDataWrapperTranslator.checkForInvalidSubGroup(dataDTO));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isExpressionDTO(DataDTO)}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#isExpressionDTO(DataDTO)}
   */
  @Test
  public void testIsExpressionDTO() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    DataDTO rules = new DataDTO();
    rules.setCondition("Condition");
    rules.setContainedPk(1L);
    rules.setCreatedFromSubGroup(true);
    rules.setPk(1L);
    rules.setPreviousContainedPk(1L);
    rules.setPreviousPk(1L);
    rules.setQuantity(1);
    rules.setRules(new ArrayList<>());

    // Act and Assert
    assertFalse(mvelToDataWrapperTranslator.isExpressionDTO(rules));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}.
   * <ul>
   *   <li>Given {@code EQUALS}.</li>
   *   <li>Then {@link Group} (default constructor) OperatorType is
   * {@code EQUALS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataDTO_givenEquals_thenGroupOperatorTypeIsEquals() throws MVELTranslationException {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    DataDTO parentDTO = new DataDTO();
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());

    Group group = new Group();
    group.setIsTopGroup(true);
    group.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertNull(mvelToDataWrapperTranslator.createRuleDataDTO(parentDTO, group, mock(RuleBuilderFieldService.class)));
    assertEquals(BLCOperator.EQUALS, group.getOperatorType());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link Group} (default constructor) OperatorType is
   * {@code AND}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}
   */
  @Test
  public void testCreateRuleDataDTO_givenNull_thenGroupOperatorTypeIsAnd() throws MVELTranslationException {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    DataDTO parentDTO = new DataDTO();
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());

    Group group = new Group();
    group.setIsTopGroup(true);
    group.setOperatorType(null);

    // Act and Assert
    assertNull(mvelToDataWrapperTranslator.createRuleDataDTO(parentDTO, group, mock(RuleBuilderFieldService.class)));
    assertEquals(BLCOperator.AND, group.getOperatorType());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#appendExpression(String, RuleBuilderFieldService, DataDTO, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#appendExpression(String, RuleBuilderFieldService, DataDTO, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAppendExpression_whenArrayList() throws MVELTranslationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException: Could not parse the MVEL expression to a compatible form for the rules builder (Phrase)
    //       at org.broadleafcommerce.openadmin.web.rulebuilder.statement.PhraseTranslator.extractComponents(PhraseTranslator.java:254)
    //       at org.broadleafcommerce.openadmin.web.rulebuilder.statement.PhraseTranslator.createExpression(PhraseTranslator.java:61)
    //       at org.broadleafcommerce.openadmin.web.rulebuilder.MVELToDataWrapperTranslator.appendExpression(MVELToDataWrapperTranslator.java:203)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    RuleBuilderFieldService fieldService = mock(RuleBuilderFieldService.class);

    DataDTO parentDTO = new DataDTO();
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());

    // Act
    mVELToDataWrapperTranslator.appendExpression("Phrase", fieldService, parentDTO, new ArrayList<>());
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#createExpressionDTO(Expression)}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#createExpressionDTO(Expression)}
   */
  @Test
  public void testCreateExpressionDTO() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    Expression expression = new Expression();
    expression.setEntityKey("Entity Key");
    expression.setField("Field");
    expression.setOperator(BLCOperator.EQUALS);
    expression.setValue("42");

    // Act
    ExpressionDTO actualCreateExpressionDTOResult = mvelToDataWrapperTranslator.createExpressionDTO(expression);

    // Assert
    assertEquals("42", actualCreateExpressionDTOResult.getValue());
    assertEquals("EQUALS", actualCreateExpressionDTOResult.getOperator());
    assertEquals("Field", actualCreateExpressionDTOResult.getId());
    assertNull(actualCreateExpressionDTOResult.getQuantity());
    assertNull(actualCreateExpressionDTOResult.getContainedPk());
    assertNull(actualCreateExpressionDTOResult.getPk());
    assertNull(actualCreateExpressionDTOResult.getPreviousContainedPk());
    assertNull(actualCreateExpressionDTOResult.getPreviousPk());
    assertNull(actualCreateExpressionDTOResult.getCondition());
    assertFalse(actualCreateExpressionDTOResult.isCreatedFromSubGroup());
    assertTrue(actualCreateExpressionDTOResult.getRules().isEmpty());
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isProjection(Object)}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isProjection(Object)}
   */
  @Test
  public void testIsProjection() {
    // Arrange, Act and Assert
    assertFalse((new MVELToDataWrapperTranslator()).isProjection("Value"));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second is {@link ExpressionDTO}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  public void testPostProcessCriteria_thenArrayListSecondIsExpressionDTO() {
    // Arrange
    DataDTO parentDTO = mock(DataDTO.class);
    doNothing().when(parentDTO).setCondition(Mockito.<String>any());
    doNothing().when(parentDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(parentDTO).setPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(parentDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("[");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("[");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");

    ArrayList<ExpressionDTO> myCriteriaList = new ArrayList<>();
    myCriteriaList.add(expressionDTO);

    ExpressionDTO temp = new ExpressionDTO();
    temp.setCondition("Condition");
    temp.setContainedPk(1L);
    temp.setCreatedFromSubGroup(true);
    temp.setId("42");
    temp.setOperator("Operator");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act
    mVELToDataWrapperTranslator.postProcessCriteria(parentDTO, myCriteriaList, temp, SupportedFieldType.UNKNOWN);

    // Assert
    verify(parentDTO).setCondition(eq("Condition"));
    verify(parentDTO).setContainedPk(eq(1L));
    verify(parentDTO).setCreatedFromSubGroup(eq(true));
    verify(parentDTO).setPk(eq(1L));
    verify(parentDTO).setPreviousContainedPk(eq(1L));
    verify(parentDTO).setPreviousPk(eq(1L));
    verify(parentDTO).setQuantity(eq(1));
    verify(parentDTO).setRules(isA(ArrayList.class));
    assertEquals(2, myCriteriaList.size());
    assertSame(temp, myCriteriaList.get(1));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second is {@link ExpressionDTO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  public void testPostProcessCriteria_thenArrayListSecondIsExpressionDTO2() {
    // Arrange
    DataDTO parentDTO = mock(DataDTO.class);
    doNothing().when(parentDTO).setCondition(Mockito.<String>any());
    doNothing().when(parentDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(parentDTO).setPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(parentDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("42");
    expressionDTO.setContainedPk(Long.MAX_VALUE);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");
    expressionDTO.setOperator("42");
    expressionDTO.setPk(Long.MAX_VALUE);
    expressionDTO.setPreviousContainedPk(Long.MAX_VALUE);
    expressionDTO.setPreviousPk(Long.MAX_VALUE);
    expressionDTO.setQuantity(Integer.MIN_VALUE);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");

    ArrayList<ExpressionDTO> myCriteriaList = new ArrayList<>();
    myCriteriaList.add(expressionDTO);
    ExpressionDTO temp = mock(ExpressionDTO.class);
    when(temp.getId()).thenReturn("42");
    when(temp.getValue()).thenReturn("42");
    doNothing().when(temp).setCondition(Mockito.<String>any());
    doNothing().when(temp).setContainedPk(Mockito.<Long>any());
    doNothing().when(temp).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(temp).setPk(Mockito.<Long>any());
    doNothing().when(temp).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(temp).setPreviousPk(Mockito.<Long>any());
    doNothing().when(temp).setQuantity(Mockito.<Integer>any());
    doNothing().when(temp).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(temp).setId(Mockito.<String>any());
    doNothing().when(temp).setOperator(Mockito.<String>any());
    doNothing().when(temp).setValue(Mockito.<String>any());
    temp.setCondition("Condition");
    temp.setContainedPk(1L);
    temp.setCreatedFromSubGroup(true);
    temp.setId("42");
    temp.setOperator("Operator");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act
    mVELToDataWrapperTranslator.postProcessCriteria(parentDTO, myCriteriaList, temp, SupportedFieldType.UNKNOWN);

    // Assert
    verify(parentDTO).setCondition(eq("Condition"));
    verify(temp).setCondition(eq("Condition"));
    verify(parentDTO).setContainedPk(eq(1L));
    verify(temp).setContainedPk(eq(1L));
    verify(parentDTO).setCreatedFromSubGroup(eq(true));
    verify(temp).setCreatedFromSubGroup(eq(true));
    verify(parentDTO).setPk(eq(1L));
    verify(temp).setPk(eq(1L));
    verify(parentDTO).setPreviousContainedPk(eq(1L));
    verify(temp).setPreviousContainedPk(eq(1L));
    verify(parentDTO).setPreviousPk(eq(1L));
    verify(temp).setPreviousPk(eq(1L));
    verify(parentDTO).setQuantity(eq(1));
    verify(temp).setQuantity(eq(1));
    verify(parentDTO).setRules(isA(ArrayList.class));
    verify(temp).setRules(isA(ArrayList.class));
    verify(temp).getId();
    verify(temp).getValue();
    verify(temp).setId(eq("42"));
    verify(temp).setOperator(eq("Operator"));
    verify(temp).setValue(eq("42"));
    assertEquals(2, myCriteriaList.size());
    assertSame(expressionDTO, myCriteriaList.get(0));
    assertSame(temp, myCriteriaList.get(1));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Then calls {@link ExpressionDTO#getOperator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  public void testPostProcessCriteria_thenCallsGetOperator() {
    // Arrange
    DataDTO parentDTO = mock(DataDTO.class);
    doNothing().when(parentDTO).setCondition(Mockito.<String>any());
    doNothing().when(parentDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(parentDTO).setPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(parentDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    when(expressionDTO.getOperator()).thenReturn("Operator");
    when(expressionDTO.getId()).thenReturn("42");
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
    expressionDTO.setCondition("42");
    expressionDTO.setContainedPk(Long.MAX_VALUE);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");
    expressionDTO.setOperator("42");
    expressionDTO.setPk(Long.MAX_VALUE);
    expressionDTO.setPreviousContainedPk(Long.MAX_VALUE);
    expressionDTO.setPreviousPk(Long.MAX_VALUE);
    expressionDTO.setQuantity(Integer.MIN_VALUE);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO");

    ArrayList<ExpressionDTO> myCriteriaList = new ArrayList<>();
    myCriteriaList.add(expressionDTO);
    ExpressionDTO temp = mock(ExpressionDTO.class);
    when(temp.getOperator()).thenThrow(new NumberFormatException("42"));
    when(temp.getId()).thenReturn("42");
    doNothing().when(temp).setCondition(Mockito.<String>any());
    doNothing().when(temp).setContainedPk(Mockito.<Long>any());
    doNothing().when(temp).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(temp).setPk(Mockito.<Long>any());
    doNothing().when(temp).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(temp).setPreviousPk(Mockito.<Long>any());
    doNothing().when(temp).setQuantity(Mockito.<Integer>any());
    doNothing().when(temp).setRules(Mockito.<ArrayList<DataDTO>>any());
    doNothing().when(temp).setId(Mockito.<String>any());
    doNothing().when(temp).setOperator(Mockito.<String>any());
    doNothing().when(temp).setValue(Mockito.<String>any());
    temp.setCondition("Condition");
    temp.setContainedPk(1L);
    temp.setCreatedFromSubGroup(true);
    temp.setId("42");
    temp.setOperator("Operator");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act
    mVELToDataWrapperTranslator.postProcessCriteria(parentDTO, myCriteriaList, temp, SupportedFieldType.UNKNOWN);

    // Assert
    verify(expressionDTO).setCondition(eq("42"));
    verify(parentDTO).setCondition(eq("Condition"));
    verify(temp).setCondition(eq("Condition"));
    verify(parentDTO).setContainedPk(eq(1L));
    verify(temp).setContainedPk(eq(1L));
    verify(expressionDTO).setContainedPk(eq(9223372036854775807L));
    verify(parentDTO).setCreatedFromSubGroup(eq(true));
    verify(expressionDTO).setCreatedFromSubGroup(eq(true));
    verify(temp).setCreatedFromSubGroup(eq(true));
    verify(parentDTO).setPk(eq(1L));
    verify(temp).setPk(eq(1L));
    verify(expressionDTO).setPk(eq(9223372036854775807L));
    verify(parentDTO).setPreviousContainedPk(eq(1L));
    verify(temp).setPreviousContainedPk(eq(1L));
    verify(expressionDTO).setPreviousContainedPk(eq(9223372036854775807L));
    verify(parentDTO).setPreviousPk(eq(1L));
    verify(temp).setPreviousPk(eq(1L));
    verify(expressionDTO).setPreviousPk(eq(9223372036854775807L));
    verify(expressionDTO).setQuantity(eq(-2147483648));
    verify(parentDTO).setQuantity(eq(1));
    verify(temp).setQuantity(eq(1));
    verify(parentDTO).setRules(isA(ArrayList.class));
    verify(expressionDTO).setRules(isA(ArrayList.class));
    verify(temp).setRules(isA(ArrayList.class));
    verify(expressionDTO).getId();
    verify(temp).getId();
    verify(expressionDTO).getOperator();
    verify(temp).getOperator();
    verify(temp).setId(eq("42"));
    verify(expressionDTO).setId(eq("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO"));
    verify(expressionDTO).setOperator(eq("42"));
    verify(temp).setOperator(eq("Operator"));
    verify(temp).setValue(eq("42"));
    verify(expressionDTO).setValue(eq("org.broadleafcommerce.openadmin.web.rulebuilder.dto.ExpressionDTO"));
    assertEquals(1, myCriteriaList.size());
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  public void testPostProcessCriteria_whenArrayList_thenArrayListSizeIsOne() {
    // Arrange
    DataDTO parentDTO = mock(DataDTO.class);
    doNothing().when(parentDTO).setCondition(Mockito.<String>any());
    doNothing().when(parentDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(parentDTO).setPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(parentDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(parentDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());
    ArrayList<ExpressionDTO> myCriteriaList = new ArrayList<>();

    ExpressionDTO temp = new ExpressionDTO();
    temp.setCondition("Condition");
    temp.setContainedPk(1L);
    temp.setCreatedFromSubGroup(true);
    temp.setId("42");
    temp.setOperator("Operator");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act
    mVELToDataWrapperTranslator.postProcessCriteria(parentDTO, myCriteriaList, temp, SupportedFieldType.UNKNOWN);

    // Assert
    verify(parentDTO).setCondition(eq("Condition"));
    verify(parentDTO).setContainedPk(eq(1L));
    verify(parentDTO).setCreatedFromSubGroup(eq(true));
    verify(parentDTO).setPk(eq(1L));
    verify(parentDTO).setPreviousContainedPk(eq(1L));
    verify(parentDTO).setPreviousPk(eq(1L));
    verify(parentDTO).setQuantity(eq(1));
    verify(parentDTO).setRules(isA(ArrayList.class));
    assertEquals(1, myCriteriaList.size());
    assertSame(temp, myCriteriaList.get(0));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>When {@link DataDTO} (default constructor) Condition is
   * {@code Condition}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  public void testPostProcessCriteria_whenDataDTOConditionIsCondition_thenArrayListSizeIsOne() {
    // Arrange
    DataDTO parentDTO = new DataDTO();
    parentDTO.setCondition("Condition");
    parentDTO.setContainedPk(1L);
    parentDTO.setCreatedFromSubGroup(true);
    parentDTO.setPk(1L);
    parentDTO.setPreviousContainedPk(1L);
    parentDTO.setPreviousPk(1L);
    parentDTO.setQuantity(1);
    parentDTO.setRules(new ArrayList<>());
    ArrayList<ExpressionDTO> myCriteriaList = new ArrayList<>();

    ExpressionDTO temp = new ExpressionDTO();
    temp.setCondition("Condition");
    temp.setContainedPk(1L);
    temp.setCreatedFromSubGroup(true);
    temp.setId("42");
    temp.setOperator("Operator");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act
    mVELToDataWrapperTranslator.postProcessCriteria(parentDTO, myCriteriaList, temp, SupportedFieldType.UNKNOWN);

    // Assert
    assertEquals(1, myCriteriaList.size());
    assertSame(temp, myCriteriaList.get(0));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  public void testIsBetweenOperator() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO prev = new ExpressionDTO();
    prev.setCondition("Condition");
    prev.setContainedPk(1L);
    prev.setCreatedFromSubGroup(true);
    prev.setId("42");
    prev.setOperator("Operator");
    prev.setPk(1L);
    prev.setPreviousContainedPk(1L);
    prev.setPreviousPk(1L);
    prev.setQuantity(1);
    prev.setRules(new ArrayList<>());
    prev.setValue("42");

    ExpressionDTO temp = new ExpressionDTO();
    temp.setCondition("Condition");
    temp.setContainedPk(1L);
    temp.setCreatedFromSubGroup(true);
    temp.setId("42");
    temp.setOperator("Operator");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act and Assert
    assertFalse(mvelToDataWrapperTranslator.isBetweenOperator(prev, temp));
  }

  /**
   * Test
   * {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <p>
   * Method under test:
   * {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  public void testIsBetweenInclusiveOperator() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO prev = new ExpressionDTO();
    prev.setCondition("Condition");
    prev.setContainedPk(1L);
    prev.setCreatedFromSubGroup(true);
    prev.setId("42");
    prev.setOperator("Operator");
    prev.setPk(1L);
    prev.setPreviousContainedPk(1L);
    prev.setPreviousPk(1L);
    prev.setQuantity(1);
    prev.setRules(new ArrayList<>());
    prev.setValue("42");

    ExpressionDTO temp = new ExpressionDTO();
    temp.setCondition("Condition");
    temp.setContainedPk(1L);
    temp.setCreatedFromSubGroup(true);
    temp.setId("42");
    temp.setOperator("Operator");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act and Assert
    assertFalse(mvelToDataWrapperTranslator.isBetweenInclusiveOperator(prev, temp));
  }

  /**
   * Test new {@link MVELToDataWrapperTranslator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MVELToDataWrapperTranslator}
   */
  @Test
  public void testNewMVELToDataWrapperTranslator() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    new MVELToDataWrapperTranslator();
  }
}
