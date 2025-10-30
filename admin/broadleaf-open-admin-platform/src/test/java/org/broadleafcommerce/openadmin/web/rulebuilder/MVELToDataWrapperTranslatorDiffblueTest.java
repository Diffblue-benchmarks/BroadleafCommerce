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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MVELToDataWrapperTranslator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MVELToDataWrapperTranslatorDiffblueTest {
  @Autowired
  private MVELToDataWrapperTranslator mVELToDataWrapperTranslator;

  /**
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)"})
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService2() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(null, "Mvel Property", "Quantity Property", "Id Property",
        "Contained Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)"})
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService3() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{}, "Mvel Property", "Quantity Property",
        "Id Property", "Contained Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)"})
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyContainedPropertyFieldService4() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{mock(Entity.class)}, null, "Quantity Property",
        "Id Property", "Contained Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code containedProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, String, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, RuleBuilderFieldService)"})
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService2() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(null, "Mvel Property", "Quantity Property", "Id Property",
        mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, RuleBuilderFieldService)"})
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService3() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{}, "Mvel Property", "Quantity Property",
        "Id Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, RuleBuilderFieldService)"})
  public void testCreateRuleDataWithEntitiesMvelPropertyQuantityPropertyIdPropertyFieldService4() {
    // Arrange, Act and Assert
    assertNull(mVELToDataWrapperTranslator.createRuleData(new Entity[]{mock(Entity.class)}, null, "Quantity Property",
        "Id Property", mock(RuleBuilderFieldService.class)));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)} with {@code entities}, {@code mvelProperty}, {@code quantityProperty}, {@code idProperty}, {@code fieldService}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleData(Entity[], String, String, String, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DataWrapper MVELToDataWrapperTranslator.createRuleData(Entity[], String, String, String, RuleBuilderFieldService)"})
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
   * Method under test: {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MVELToDataWrapperTranslator.checkForInvalidSubGroup(DataDTO)"})
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

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO");
    dataDTO2.setContainedPk(3L);
    dataDTO2.setCreatedFromSubGroup(false);
    dataDTO2.setPk(3L);
    dataDTO2.setPreviousContainedPk(3L);
    dataDTO2.setPreviousPk(3L);
    dataDTO2.setQuantity(3);
    dataDTO2.setRules(new ArrayList<>());

    ArrayList<DataDTO> rules = new ArrayList<>();
    rules.add(dataDTO2);
    rules.add(dataDTO);

    DataDTO dataDTO3 = new DataDTO();
    dataDTO3.setCondition("Condition");
    dataDTO3.setContainedPk(1L);
    dataDTO3.setCreatedFromSubGroup(true);
    dataDTO3.setPk(1L);
    dataDTO3.setPreviousContainedPk(1L);
    dataDTO3.setPreviousPk(1L);
    dataDTO3.setQuantity(1);
    dataDTO3.setRules(rules);

    // Act and Assert
    assertTrue(mvelToDataWrapperTranslator.checkForInvalidSubGroup(dataDTO3));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MVELToDataWrapperTranslator.checkForInvalidSubGroup(DataDTO)"})
  public void testCheckForInvalidSubGroup_givenArrayList_thenReturnFalse() {
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
   * Test {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}.
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code Condition}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MVELToDataWrapperTranslator.checkForInvalidSubGroup(DataDTO)"})
  public void testCheckForInvalidSubGroup_givenDataDTOConditionIsCondition_thenReturnTrue() {
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

    ArrayList<DataDTO> rules = new ArrayList<>();
    rules.add(dataDTO);

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("Condition");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(true);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(rules);

    // Act and Assert
    assertTrue(mvelToDataWrapperTranslator.checkForInvalidSubGroup(dataDTO2));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}.
   * <ul>
   *   <li>Given {@link ExpressionDTO} (default constructor) Condition is {@code Condition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#checkForInvalidSubGroup(DataDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MVELToDataWrapperTranslator.checkForInvalidSubGroup(DataDTO)"})
  public void testCheckForInvalidSubGroup_givenExpressionDTOConditionIsCondition() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

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
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> rules = new ArrayList<>();
    rules.add(expressionDTO);

    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(rules);

    // Act and Assert
    assertTrue(mvelToDataWrapperTranslator.checkForInvalidSubGroup(dataDTO));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isExpressionDTO(DataDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ExpressionDTO} (default constructor) Condition is {@code Condition}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isExpressionDTO(DataDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MVELToDataWrapperTranslator.isExpressionDTO(DataDTO)"})
  public void testIsExpressionDTO_given42_whenExpressionDTOConditionIsCondition_thenReturnTrue() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO rules = new ExpressionDTO();
    rules.setCondition("Condition");
    rules.setContainedPk(1L);
    rules.setCreatedFromSubGroup(true);
    rules.setId("42");
    rules.setOperator("Operator");
    rules.setPk(1L);
    rules.setPreviousContainedPk(1L);
    rules.setPreviousPk(1L);
    rules.setQuantity(1);
    rules.setRules(new ArrayList<>());
    rules.setValue("42");
    rules.setCondition("Condition");
    rules.setContainedPk(1L);
    rules.setCreatedFromSubGroup(true);
    rules.setPk(1L);
    rules.setPreviousContainedPk(1L);
    rules.setPreviousPk(1L);
    rules.setQuantity(1);
    rules.setRules(new ArrayList<>());

    // Act and Assert
    assertTrue(mvelToDataWrapperTranslator.isExpressionDTO(rules));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isExpressionDTO(DataDTO)}.
   * <ul>
   *   <li>When {@link DataDTO} (default constructor) Condition is {@code Condition}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isExpressionDTO(DataDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MVELToDataWrapperTranslator.isExpressionDTO(DataDTO)"})
  public void testIsExpressionDTO_whenDataDTOConditionIsCondition_thenReturnFalse() {
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
   * Test {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}.
   * <ul>
   *   <li>Given {@code EQUALS}.</li>
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code EQUALS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataDTO MVELToDataWrapperTranslator.createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code AND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataDTO MVELToDataWrapperTranslator.createRuleDataDTO(DataDTO, Group, RuleBuilderFieldService)"})
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
   * Test {@link MVELToDataWrapperTranslator#createExpressionDTO(Expression)}.
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#createExpressionDTO(Expression)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExpressionDTO MVELToDataWrapperTranslator.createExpressionDTO(Expression)"})
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
   * <ul>
   *   <li>When {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isProjection(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isProjection(Object)"})
  public void testIsProjection_whenLeftSquareBracket() {
    // Arrange, Act and Assert
    assertFalse((new MVELToDataWrapperTranslator()).isProjection("["));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isProjection(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isProjection(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isProjection(Object)"})
  public void testIsProjection_whenValue() {
    // Arrange, Act and Assert
    assertFalse((new MVELToDataWrapperTranslator()).isProjection("Value"));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link ExpressionDTO} (default constructor) Id is {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MVELToDataWrapperTranslator.postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)"})
  public void testPostProcessCriteria_givenExpressionDTOIdIsLeftSquareBracket() {
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

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("[");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("[");
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
    assertEquals(2, myCriteriaList.size());
    assertSame(expressionDTO, myCriteriaList.get(0));
    assertSame(temp, myCriteriaList.get(1));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link ExpressionDTO} (default constructor) Operator is {@code GREATER_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MVELToDataWrapperTranslator.postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)"})
  public void testPostProcessCriteria_givenExpressionDTOOperatorIsGreaterOrEqual() {
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

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("[");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("GREATER_OR_EQUAL");
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
    assertEquals(2, myCriteriaList.size());
    assertSame(expressionDTO, myCriteriaList.get(0));
    assertSame(temp, myCriteriaList.get(1));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link ExpressionDTO} (default constructor) Operator is {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MVELToDataWrapperTranslator.postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)"})
  public void testPostProcessCriteria_givenExpressionDTOOperatorIsLeftSquareBracket() {
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
    assertEquals(2, myCriteriaList.size());
    assertSame(expressionDTO, myCriteriaList.get(0));
    assertSame(temp, myCriteriaList.get(1));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link ExpressionDTO} (default constructor) Operator is {@code LESS_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MVELToDataWrapperTranslator.postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)"})
  public void testPostProcessCriteria_givenExpressionDTOOperatorIsLessOrEqual() {
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

    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("[");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("LESS_OR_EQUAL");
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
    assertEquals(2, myCriteriaList.size());
    assertSame(expressionDTO, myCriteriaList.get(0));
    assertSame(temp, myCriteriaList.get(1));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link ExpressionDTO} (default constructor) Value is {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MVELToDataWrapperTranslator.postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)"})
  public void testPostProcessCriteria_givenExpressionDTOValueIsLeftSquareBracket() {
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
    expressionDTO.setValue("[");

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
    assertEquals(2, myCriteriaList.size());
    assertSame(expressionDTO, myCriteriaList.get(0));
    assertSame(temp, myCriteriaList.get(1));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MVELToDataWrapperTranslator.postProcessCriteria(DataDTO, List, ExpressionDTO, SupportedFieldType)"})
  public void testPostProcessCriteria_whenArrayList_thenArrayListSizeIsOne() {
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
   * Test {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code 4242}.</li>
   *   <li>When {@link ExpressionDTO} (default constructor) Value is {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenOperator_given4242_whenExpressionDTOValueIs4242() {
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
    prev.setValue("4242");

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
   * Test {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code LESS_THAN}.</li>
   *   <li>When {@link ExpressionDTO} (default constructor) Operator is {@code LESS_THAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenOperator_givenLessThan_whenExpressionDTOOperatorIsLessThan() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO prev = new ExpressionDTO();
    prev.setCondition("Condition");
    prev.setContainedPk(1L);
    prev.setCreatedFromSubGroup(true);
    prev.setId("42");
    prev.setOperator("LESS_THAN");
    prev.setPk(1L);
    prev.setPreviousContainedPk(1L);
    prev.setPreviousPk(1L);
    prev.setQuantity(1);
    prev.setRules(new ArrayList<>());
    prev.setValue("4242");

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
   * Test {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   *   <li>When {@link ExpressionDTO} (default constructor) Value is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenOperator_givenValue_whenExpressionDTOValueIsValue() {
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
    prev.setValue("Value");

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
   * Test {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   *   <li>When {@link ExpressionDTO} (default constructor) Value is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenOperator_givenValue_whenExpressionDTOValueIsValue2() {
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
    temp.setValue("Value");

    // Act and Assert
    assertFalse(mvelToDataWrapperTranslator.isBetweenOperator(prev, temp));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>When {@link ExpressionDTO} (default constructor) Rules is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenOperator_whenExpressionDTORulesIsArrayList() {
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
   * Test {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code GREATER_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenInclusiveOperator_givenGreaterOrEqual() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO prev = new ExpressionDTO();
    prev.setCondition("Condition");
    prev.setContainedPk(1L);
    prev.setCreatedFromSubGroup(true);
    prev.setId("42");
    prev.setOperator("GREATER_OR_EQUAL");
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
   * Test {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code GREATER_OR_EQUAL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenInclusiveOperator_givenGreaterOrEqual_thenReturnTrue() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO prev = new ExpressionDTO();
    prev.setCondition("Condition");
    prev.setContainedPk(1L);
    prev.setCreatedFromSubGroup(true);
    prev.setId("42");
    prev.setOperator("GREATER_OR_EQUAL");
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
    temp.setOperator("LESS_OR_EQUAL");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act and Assert
    assertTrue(mvelToDataWrapperTranslator.isBetweenInclusiveOperator(prev, temp));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code LESS_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenInclusiveOperator_givenLessOrEqual() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO prev = new ExpressionDTO();
    prev.setCondition("Condition");
    prev.setContainedPk(1L);
    prev.setCreatedFromSubGroup(true);
    prev.setId("42");
    prev.setOperator("LESS_OR_EQUAL");
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
   * Test {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code LESS_OR_EQUAL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenInclusiveOperator_givenLessOrEqual_thenReturnTrue() {
    // Arrange
    MVELToDataWrapperTranslator mvelToDataWrapperTranslator = new MVELToDataWrapperTranslator();

    ExpressionDTO prev = new ExpressionDTO();
    prev.setCondition("Condition");
    prev.setContainedPk(1L);
    prev.setCreatedFromSubGroup(true);
    prev.setId("42");
    prev.setOperator("LESS_OR_EQUAL");
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
    temp.setOperator("GREATER_OR_EQUAL");
    temp.setPk(1L);
    temp.setPreviousContainedPk(1L);
    temp.setPreviousPk(1L);
    temp.setQuantity(1);
    temp.setRules(new ArrayList<>());
    temp.setValue("42");

    // Act and Assert
    assertTrue(mvelToDataWrapperTranslator.isBetweenInclusiveOperator(prev, temp));
  }

  /**
   * Test {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>Given {@code Operator}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenInclusiveOperator_givenOperator_thenReturnFalse() {
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
   * Test {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>When {@link ExpressionDTO} (default constructor) Value is {@code Operator}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenInclusiveOperator_whenExpressionDTOValueIsOperator_thenReturnFalse() {
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
    prev.setValue("Operator");

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
   * Test {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}.
   * <ul>
   *   <li>When {@link ExpressionDTO} (default constructor) Value is {@code Operator}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MVELToDataWrapperTranslator#isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MVELToDataWrapperTranslator.isBetweenInclusiveOperator(ExpressionDTO, ExpressionDTO)"})
  public void testIsBetweenInclusiveOperator_whenExpressionDTOValueIsOperator_thenReturnFalse2() {
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
    temp.setValue("Operator");

    // Act and Assert
    assertFalse(mvelToDataWrapperTranslator.isBetweenInclusiveOperator(prev, temp));
  }
}
