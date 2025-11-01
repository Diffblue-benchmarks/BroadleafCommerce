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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentDTOWrapperDiffblueTest {
  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getPropertyValue("Property Name"));
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getPropertyValue("Property Name"));
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    when(structuredContentDTO.getPropertyValue(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).getPropertyValue("Property Name");

    // Assert
    verify(structuredContentDTO).getPropertyValue(eq("Property Name"));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#getId()}
   */
  @Test
  public void testGetId() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getId());
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO()))).getId());
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act and Assert
    assertNotEquals(structuredContentDTOWrapper, new StructuredContentDTOWrapper(new StructuredContentDTO()));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#getContentName()}
   */
  @Test
  public void testGetContentName() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getContentName());
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getContentName());
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#getContentType()}
   */
  @Test
  public void testGetContentType() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getContentType());
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getContentType());
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#getLocaleCode()}
   */
  @Test
  public void testGetLocaleCode() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getLocaleCode());
    assertNull(
        (new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO()))).getLocaleCode());
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getPriority());
    assertNull(
        (new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO()))).getPriority());
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#getValues()}
   */
  @Test
  public void testGetValues() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();

    // Act
    Map actualValues = (new StructuredContentDTOWrapper(structuredContentDTO)).getValues();

    // Assert
    assertTrue(actualValues.isEmpty());
    assertSame(structuredContentDTO.values, actualValues);
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#getValues()}
   */
  @Test
  public void testGetValues2() {
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
   * Method under test: {@link StructuredContentDTOWrapper#getRuleExpression()}
   */
  @Test
  public void testGetRuleExpression() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getRuleExpression());
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getRuleExpression());
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}
   */
  @Test
  public void testGetItemCriteriaDTOList() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getItemCriteriaDTOList());
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getItemCriteriaDTOList());
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#setId(Long)}
   */
  @Test
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
   * Method under test: {@link StructuredContentDTOWrapper#setId(Long)}
   */
  @Test
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
   * Method under test: {@link StructuredContentDTOWrapper#setContentName(String)}
   */
  @Test
  public void testSetContentName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setContentName("Not all who wander are lost");

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#setContentType(String)}
   */
  @Test
  public void testSetContentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setContentType("text/plain");

    // Assert
    verify(structuredContentDTO).setContentType(eq("text/plain"));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#setLocaleCode(String)}
   */
  @Test
  public void testSetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setLocaleCode("en");

    // Assert
    verify(structuredContentDTO).setLocaleCode(eq("en"));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#setValues(Map)}
   */
  @Test
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
   * Method under test: {@link StructuredContentDTOWrapper#setValues(Map)}
   */
  @Test
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
   * Method under test: {@link StructuredContentDTOWrapper#setValues(Map)}
   */
  @Test
  public void testSetValues3() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    HashMap<Object, Object> values = new HashMap<>();
    values.computeIfPresent(BLCFieldUtils.NULL_FIELD, mock(BiFunction.class));

    // Act
    structuredContentDTOWrapper.setValues((Map) values);

    // Assert
    assertSame(values, structuredContentDTOWrapper.getValues());
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#setRuleExpression(String)}
   */
  @Test
  public void testSetRuleExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act
    structuredContentDTOWrapper.setRuleExpression("Rule Expression");

    // Assert
    assertEquals("Rule Expression", structuredContentDTOWrapper.getRuleExpression());
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#setRuleExpression(String)}
   */
  @Test
  public void testSetRuleExpression2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act
    structuredContentDTOWrapper.setRuleExpression("Rule Expression");

    // Assert
    assertEquals("Rule Expression", structuredContentDTOWrapper.getRuleExpression());
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#setRuleExpression(String)}
   */
  @Test
  public void testSetRuleExpression3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setRuleExpression("Rule Expression");

    // Assert
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  public void testSetItemCriteriaDTOList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());
    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();

    // Act
    structuredContentDTOWrapper.setItemCriteriaDTOList(itemCriteriaDTOList);

    // Assert
    assertSame(itemCriteriaDTOList, structuredContentDTOWrapper.getItemCriteriaDTOList());
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  public void testSetItemCriteriaDTOList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));
    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();

    // Act
    structuredContentDTOWrapper.setItemCriteriaDTOList(itemCriteriaDTOList);

    // Assert
    assertSame(itemCriteriaDTOList, structuredContentDTOWrapper.getItemCriteriaDTOList());
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  public void testSetItemCriteriaDTOList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setItemCriteriaDTOList(new ArrayList<>());

    // Assert
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
  }

  /**
   * Method under test:
   * {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  public void testSetItemCriteriaDTOList4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(structuredContentDTO);

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
   * Method under test:
   * {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  public void testSetItemCriteriaDTOList5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(structuredContentDTO);

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
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act and Assert
    assertNotEquals(structuredContentDTOWrapper, new StructuredContentDTOWrapper(new StructuredContentDTO()));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        mock(StructuredContentDTO.class));

    // Act and Assert
    assertNotEquals(structuredContentDTOWrapper, new StructuredContentDTOWrapper(new StructuredContentDTO()));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(new StructuredContentDTO()), null);
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(new StructuredContentDTO()),
        new StructuredContentDTOWrapper(new StructuredContentDTO()));
  }

  /**
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(new StructuredContentDTO()),
        "Different type to StructuredContentDTOWrapper");
  }
}
