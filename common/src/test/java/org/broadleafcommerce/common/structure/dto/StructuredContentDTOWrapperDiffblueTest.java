/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.structure.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
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
public class StructuredContentDTOWrapperDiffblueTest {
  @Mock
  private StructuredContentDTO structuredContentDTO;

  @InjectMocks
  private StructuredContentDTOWrapper structuredContentDTOWrapper;

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDTOWrapper.equals(Object)",
      "int StructuredContentDTOWrapper.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act and Assert
    assertNotEquals(structuredContentDTOWrapper, new StructuredContentDTOWrapper(new StructuredContentDTO()));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDTOWrapper.equals(Object)",
      "int StructuredContentDTOWrapper.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act and Assert
    assertNotEquals(structuredContentDTOWrapper, new StructuredContentDTOWrapper(new StructuredContentDTO()));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDTOWrapper.equals(Object)",
      "int StructuredContentDTOWrapper.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(new StructuredContentDTO()), null);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDTOWrapper.equals(Object)",
      "int StructuredContentDTOWrapper.hashCode()"})
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(new StructuredContentDTO()),
        new StructuredContentDTOWrapper(new StructuredContentDTO()));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDTOWrapper.equals(Object)",
      "int StructuredContentDTOWrapper.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(new StructuredContentDTO()),
        "Different type to StructuredContentDTOWrapper");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPropertyValue(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTOWrapper.getPropertyValue(String)"})
  public void testGetPropertyValue() {
    // Arrange
    when(structuredContentDTO.getPropertyValue(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    structuredContentDTOWrapper.getPropertyValue("Property Name");

    // Assert
    verify(structuredContentDTO).getPropertyValue(eq("Property Name"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getId()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long StructuredContentDTOWrapper.getId()"})
  public void testGetId() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO()))).getId());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long StructuredContentDTOWrapper.getId()"})
  public void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getId());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getContentName()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getContentName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getContentName()"})
  public void testGetContentName() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getContentName());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getContentName()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getContentName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getContentName()"})
  public void testGetContentName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getContentName());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getContentType()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getContentType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getContentType()"})
  public void testGetContentType() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getContentType());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getContentType()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getContentType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getContentType()"})
  public void testGetContentType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getContentType());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getLocaleCode()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getLocaleCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getLocaleCode()"})
  public void testGetLocaleCode() {
    // Arrange, Act and Assert
    assertNull(
        (new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO()))).getLocaleCode());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getLocaleCode()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getLocaleCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getLocaleCode()"})
  public void testGetLocaleCode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getLocaleCode());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPriority()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer StructuredContentDTOWrapper.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertNull(
        (new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO()))).getPriority());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPriority()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer StructuredContentDTOWrapper.getPriority()"})
  public void testGetPriority_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getPriority());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getValues()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map StructuredContentDTOWrapper.getValues()"})
  public void testGetValues() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();

    // Act
    Map actualValues = (new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(structuredContentDTO)))
        .getValues();

    // Assert
    assertTrue(actualValues.isEmpty());
    assertSame(structuredContentDTO.values, actualValues);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getValues()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map StructuredContentDTOWrapper.getValues()"})
  public void testGetValues_thenReturnEmpty() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();

    // Act
    Map actualValues = (new StructuredContentDTOWrapper(structuredContentDTO)).getValues();

    // Assert
    assertTrue(actualValues.isEmpty());
    assertSame(structuredContentDTO.values, actualValues);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getRuleExpression()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getRuleExpression()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getRuleExpression()"})
  public void testGetRuleExpression() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getRuleExpression());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getRuleExpression()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getRuleExpression()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getRuleExpression()"})
  public void testGetRuleExpression_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getRuleExpression());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentDTOWrapper.getItemCriteriaDTOList()"})
  public void testGetItemCriteriaDTOList() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getItemCriteriaDTOList());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentDTOWrapper.getItemCriteriaDTOList()"})
  public void testGetItemCriteriaDTOList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getItemCriteriaDTOList());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setId(Long)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setId(Long)"})
  public void testSetId() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act
    structuredContentDTOWrapper.setId(1L);

    // Assert
    assertEquals(1L, structuredContentDTOWrapper.getId().longValue());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setId(Long)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setId(Long)"})
  public void testSetId2() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act
    structuredContentDTOWrapper.setId(1L);

    // Assert
    assertEquals(1L, structuredContentDTOWrapper.getId().longValue());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setContentName(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setContentName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setContentName(String)"})
  public void testSetContentName() {
    // Arrange
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setContentName("Not all who wander are lost");

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setContentType(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setContentType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setContentType(String)"})
  public void testSetContentType() {
    // Arrange
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setContentType("text/plain");

    // Assert
    verify(structuredContentDTO).setContentType(eq("text/plain"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setLocaleCode(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setLocaleCode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setLocaleCode(String)"})
  public void testSetLocaleCode() {
    // Arrange
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setLocaleCode("en");

    // Assert
    verify(structuredContentDTO).setLocaleCode(eq("en"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setPriority(Integer)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setPriority(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setPriority(Integer)"})
  public void testSetPriority() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act
    structuredContentDTOWrapper.setPriority(1);

    // Assert
    assertEquals(1, structuredContentDTOWrapper.getPriority().intValue());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals(1, ((Integer) values.get("priority")).intValue());
    assertEquals(
        structuredContentDTOWrapper.getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues(),
        structuredContentDTOWrapper.getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setPriority(Integer)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setPriority(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setPriority(Integer)"})
  public void testSetPriority2() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act
    structuredContentDTOWrapper.setPriority(1);

    // Assert
    assertEquals(1, structuredContentDTOWrapper.getPriority().intValue());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals(1, ((Integer) values.get("priority")).intValue());
    assertEquals(
        structuredContentDTOWrapper.getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues(),
        structuredContentDTOWrapper.getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setValues(Map)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setValues(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setValues(Map)"})
  public void testSetValues() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());
    HashMap<Object, Object> values = new HashMap<>();

    // Act
    structuredContentDTOWrapper.setValues((Map) values);

    // Assert
    assertSame(values, structuredContentDTOWrapper.getValues());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setValues(Map)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setValues(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setValues(Map)"})
  public void testSetValues2() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));
    HashMap<Object, Object> values = new HashMap<>();

    // Act
    structuredContentDTOWrapper.setValues((Map) values);

    // Assert
    assertSame(values, structuredContentDTOWrapper.getValues());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setRuleExpression(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setRuleExpression(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setRuleExpression(String)"})
  public void testSetRuleExpression() {
    // Arrange
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setRuleExpression("Rule Expression");

    // Assert
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <ul>
   *   <li>Given {@link ItemCriteriaDTO} (default constructor) MatchRule is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setItemCriteriaDTOList(List)"})
  public void testSetItemCriteriaDTOList_givenItemCriteriaDTOMatchRuleIs42() {
    // Arrange
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());

    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ItemCriteriaDTO itemCriteriaDTO2 = new ItemCriteriaDTO();
    itemCriteriaDTO2.setMatchRule("42");
    itemCriteriaDTO2.setQty(0);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO2);
    itemCriteriaDTOList.add(itemCriteriaDTO);

    // Act
    structuredContentDTOWrapper.setItemCriteriaDTOList(itemCriteriaDTOList);

    // Assert
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <ul>
   *   <li>Given {@link ItemCriteriaDTO} (default constructor) MatchRule is {@code Match Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setItemCriteriaDTOList(List)"})
  public void testSetItemCriteriaDTOList_givenItemCriteriaDTOMatchRuleIsMatchRule() {
    // Arrange
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());

    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);

    // Act
    structuredContentDTOWrapper.setItemCriteriaDTOList(itemCriteriaDTOList);

    // Assert
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setItemCriteriaDTOList(List)"})
  public void testSetItemCriteriaDTOList_whenArrayList() {
    // Arrange
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());

    // Act
    structuredContentDTOWrapper.setItemCriteriaDTOList(new ArrayList<>());

    // Assert
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
  }
}
