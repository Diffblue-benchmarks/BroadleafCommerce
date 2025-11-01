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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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

public class StructuredContentDTODiffblueTest {
  /**
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentDTO()).getPropertyValue("Property Name"));
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getPropertyValue("Property Name"));
    assertNull((new StructuredContentDTO()).getPropertyValue("contentName"));
    assertNull((new StructuredContentDTO()).getPropertyValue("contentType"));
    assertNull((new StructuredContentDTO()).getPropertyValue("localeCode"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTO = mock(StructuredContentDTOWrapper.class);
    when(structuredContentDTO.getPropertyValue(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).getPropertyValue("Property Name");

    // Assert
    verify(structuredContentDTO).getPropertyValue(eq("Property Name"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setContentName(String)}
   */
  @Test
  public void testSetContentName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();

    // Act
    structuredContentDTO.setContentName("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", structuredContentDTO.getContentName());
    StructuredContentDTO clone = structuredContentDTO.getClone();
    assertEquals("Not all who wander are lost", clone.getContentName());
    StructuredContentDTO clone2 = clone.getClone();
    assertEquals("Not all who wander are lost", clone2.getContentName());
    StructuredContentDTO clone3 = clone2.getClone();
    assertEquals("Not all who wander are lost", clone3.getContentName());
    StructuredContentDTO clone4 = clone3.getClone();
    assertEquals("Not all who wander are lost", clone4.getContentName());
    StructuredContentDTO clone5 = clone4.getClone();
    assertEquals("Not all who wander are lost", clone5.getContentName());
    StructuredContentDTO clone6 = clone5.getClone();
    assertEquals("Not all who wander are lost", clone6.getContentName());
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals("Not all who wander are lost", clone7.getContentName());
    assertEquals("Not all who wander are lost", clone7.getClone().getContentName());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    assertEquals("Not all who wander are lost", values.get("contentName"));
    Map<String, Object> values2 = clone.getValues();
    assertEquals(1, values2.size());
    assertEquals("Not all who wander are lost", values2.get("contentName"));
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(1, values3.size());
    assertEquals("Not all who wander are lost", values3.get("contentName"));
    Map<String, Object> values4 = clone3.getValues();
    assertEquals(1, values4.size());
    assertEquals("Not all who wander are lost", values4.get("contentName"));
    Map<String, Object> values5 = clone4.getValues();
    assertEquals(1, values5.size());
    assertEquals("Not all who wander are lost", values5.get("contentName"));
    Map<String, Object> values6 = clone5.getValues();
    assertEquals(1, values6.size());
    assertEquals("Not all who wander are lost", values6.get("contentName"));
    Map<String, Object> values7 = clone6.getValues();
    assertEquals(1, values7.size());
    assertEquals("Not all who wander are lost", values7.get("contentName"));
    Map<String, Object> values8 = clone7.getValues();
    assertEquals(1, values8.size());
    assertEquals("Not all who wander are lost", values8.get("contentName"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setContentName(String)}
   */
  @Test
  public void testSetContentName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTO = mock(StructuredContentDTOWrapper.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setContentName("Not all who wander are lost");

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setContentType(String)}
   */
  @Test
  public void testSetContentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();

    // Act
    structuredContentDTO.setContentType("text/plain");

    // Assert
    assertEquals("text/plain", structuredContentDTO.getContentType());
    StructuredContentDTO clone = structuredContentDTO.getClone();
    assertEquals("text/plain", clone.getContentType());
    StructuredContentDTO clone2 = clone.getClone();
    assertEquals("text/plain", clone2.getContentType());
    StructuredContentDTO clone3 = clone2.getClone();
    assertEquals("text/plain", clone3.getContentType());
    StructuredContentDTO clone4 = clone3.getClone();
    assertEquals("text/plain", clone4.getContentType());
    StructuredContentDTO clone5 = clone4.getClone();
    assertEquals("text/plain", clone5.getContentType());
    StructuredContentDTO clone6 = clone5.getClone();
    assertEquals("text/plain", clone6.getContentType());
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals("text/plain", clone7.getContentType());
    assertEquals("text/plain", clone7.getClone().getContentType());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    assertEquals("text/plain", values.get("contentType"));
    Map<String, Object> values2 = clone.getValues();
    assertEquals(1, values2.size());
    assertEquals("text/plain", values2.get("contentType"));
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(1, values3.size());
    assertEquals("text/plain", values3.get("contentType"));
    Map<String, Object> values4 = clone3.getValues();
    assertEquals(1, values4.size());
    assertEquals("text/plain", values4.get("contentType"));
    Map<String, Object> values5 = clone4.getValues();
    assertEquals(1, values5.size());
    assertEquals("text/plain", values5.get("contentType"));
    Map<String, Object> values6 = clone5.getValues();
    assertEquals(1, values6.size());
    assertEquals("text/plain", values6.get("contentType"));
    Map<String, Object> values7 = clone6.getValues();
    assertEquals(1, values7.size());
    assertEquals("text/plain", values7.get("contentType"));
    Map<String, Object> values8 = clone7.getValues();
    assertEquals(1, values8.size());
    assertEquals("text/plain", values8.get("contentType"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setContentType(String)}
   */
  @Test
  public void testSetContentType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTO = mock(StructuredContentDTOWrapper.class);
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setContentType("text/plain");

    // Assert
    verify(structuredContentDTO).setContentType(eq("text/plain"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setLocaleCode(String)}
   */
  @Test
  public void testSetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();

    // Act
    structuredContentDTO.setLocaleCode("en");

    // Assert
    assertEquals("en", structuredContentDTO.getLocaleCode());
    StructuredContentDTO clone = structuredContentDTO.getClone();
    assertEquals("en", clone.getLocaleCode());
    StructuredContentDTO clone2 = clone.getClone();
    assertEquals("en", clone2.getLocaleCode());
    StructuredContentDTO clone3 = clone2.getClone();
    assertEquals("en", clone3.getLocaleCode());
    StructuredContentDTO clone4 = clone3.getClone();
    assertEquals("en", clone4.getLocaleCode());
    StructuredContentDTO clone5 = clone4.getClone();
    assertEquals("en", clone5.getLocaleCode());
    StructuredContentDTO clone6 = clone5.getClone();
    assertEquals("en", clone6.getLocaleCode());
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals("en", clone7.getLocaleCode());
    assertEquals("en", clone7.getClone().getLocaleCode());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    assertEquals("en", values.get("localeCode"));
    Map<String, Object> values2 = clone.getValues();
    assertEquals(1, values2.size());
    assertEquals("en", values2.get("localeCode"));
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(1, values3.size());
    assertEquals("en", values3.get("localeCode"));
    Map<String, Object> values4 = clone3.getValues();
    assertEquals(1, values4.size());
    assertEquals("en", values4.get("localeCode"));
    Map<String, Object> values5 = clone4.getValues();
    assertEquals(1, values5.size());
    assertEquals("en", values5.get("localeCode"));
    Map<String, Object> values6 = clone5.getValues();
    assertEquals(1, values6.size());
    assertEquals("en", values6.get("localeCode"));
    Map<String, Object> values7 = clone6.getValues();
    assertEquals(1, values7.size());
    assertEquals("en", values7.get("localeCode"));
    Map<String, Object> values8 = clone7.getValues();
    assertEquals(1, values8.size());
    assertEquals("en", values8.get("localeCode"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setLocaleCode(String)}
   */
  @Test
  public void testSetLocaleCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTO = mock(StructuredContentDTOWrapper.class);
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setLocaleCode("en");

    // Assert
    verify(structuredContentDTO).setLocaleCode(eq("en"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setPriority(Integer)}
   */
  @Test
  public void testSetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();

    // Act
    structuredContentDTO.setPriority(1);

    // Assert
    assertEquals(1, structuredContentDTO.getPriority().intValue());
    StructuredContentDTO clone = structuredContentDTO.getClone();
    assertEquals(1, clone.getPriority().intValue());
    StructuredContentDTO clone2 = clone.getClone();
    assertEquals(1, clone2.getPriority().intValue());
    StructuredContentDTO clone3 = clone2.getClone();
    assertEquals(1, clone3.getPriority().intValue());
    StructuredContentDTO clone4 = clone3.getClone();
    assertEquals(1, clone4.getPriority().intValue());
    StructuredContentDTO clone5 = clone4.getClone();
    assertEquals(1, clone5.getPriority().intValue());
    StructuredContentDTO clone6 = clone5.getClone();
    assertEquals(1, clone6.getPriority().intValue());
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals(1, clone7.getPriority().intValue());
    assertEquals(1, clone7.getClone().getPriority().intValue());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    Map<String, Object> values2 = clone.getValues();
    assertEquals(1, values2.size());
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(1, values3.size());
    Map<String, Object> values4 = clone3.getValues();
    assertEquals(1, values4.size());
    Map<String, Object> values5 = clone4.getValues();
    assertEquals(1, values5.size());
    Map<String, Object> values6 = clone5.getValues();
    assertEquals(1, values6.size());
    Map<String, Object> values7 = clone6.getValues();
    assertEquals(1, values7.size());
    Map<String, Object> values8 = clone7.getValues();
    assertEquals(1, values8.size());
    assertTrue(values.containsKey("priority"));
    assertTrue(values2.containsKey("priority"));
    assertTrue(values3.containsKey("priority"));
    assertTrue(values4.containsKey("priority"));
    assertTrue(values5.containsKey("priority"));
    assertTrue(values6.containsKey("priority"));
    assertTrue(values7.containsKey("priority"));
    assertTrue(values8.containsKey("priority"));
  }

  /**
   * Method under test: {@link StructuredContentDTO#setPriority(Integer)}
   */
  @Test
  public void testSetPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTO = mock(StructuredContentDTOWrapper.class);
    doNothing().when(structuredContentDTO).setPriority(Mockito.<Integer>any());

    // Act
    (new StructuredContentDTOWrapper(structuredContentDTO)).setPriority(1);

    // Assert
    verify(structuredContentDTO).setPriority(eq(1));
  }

  /**
   * Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  public void testGetClone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StructuredContentDTO actualClone = (new StructuredContentDTO()).getClone();

    // Assert
    assertNull(actualClone.getPriority());
    assertNull(actualClone.getId());
    assertNull(actualClone.getContentName());
    assertNull(actualClone.getContentType());
    assertNull(actualClone.getLocaleCode());
    assertNull(actualClone.getRuleExpression());
    assertNull(actualClone.getItemCriteriaDTOList());
    assertTrue(actualClone.getValues().isEmpty());
  }

  /**
   * Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  public void testGetClone2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());

    // Act
    StructuredContentDTO actualClone = structuredContentDTO.getClone();

    // Assert
    assertEquals("Not all who wander are lost", actualClone.getContentName());
    assertEquals("Rule Expression", actualClone.getRuleExpression());
    assertEquals("en", actualClone.getLocaleCode());
    assertEquals("text/plain", actualClone.getContentType());
    assertEquals(1, actualClone.getPriority().intValue());
    assertEquals(1L, actualClone.getId().longValue());
    assertTrue(actualClone.getItemCriteriaDTOList().isEmpty());
    assertTrue(actualClone.getValues().isEmpty());
  }

  /**
   * Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  public void testGetClone3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    structuredContentDTO.setItemCriteriaDTOList(itemCriteriaDTOList);

    // Act
    StructuredContentDTO actualClone = structuredContentDTO.getClone();

    // Assert
    List<ItemCriteriaDTO> itemCriteriaDTOList2 = actualClone.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList2.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList2.get(0);
    assertEquals("Match Rule", getResult.getMatchRule());
    ItemCriteriaDTO clone = getResult.getClone();
    assertEquals("Match Rule", clone.getMatchRule());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertEquals("Match Rule", clone2.getMatchRule());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertEquals("Match Rule", clone3.getMatchRule());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertEquals("Match Rule", clone4.getMatchRule());
    ItemCriteriaDTO clone5 = clone4.getClone();
    assertEquals("Match Rule", clone5.getMatchRule());
    ItemCriteriaDTO clone6 = clone5.getClone();
    assertEquals("Match Rule", clone6.getMatchRule());
    assertEquals("Not all who wander are lost", actualClone.getContentName());
    assertEquals("Rule Expression", actualClone.getRuleExpression());
    assertEquals("en", actualClone.getLocaleCode());
    assertEquals("text/plain", actualClone.getContentType());
    assertEquals(1, getResult.getQty().intValue());
    assertEquals(1, clone.getQty().intValue());
    assertEquals(1, clone2.getQty().intValue());
    assertEquals(1, clone3.getQty().intValue());
    assertEquals(1, clone4.getQty().intValue());
    assertEquals(1, clone5.getQty().intValue());
    assertEquals(1, clone6.getQty().intValue());
    assertEquals(1, actualClone.getPriority().intValue());
    assertEquals(1L, actualClone.getId().longValue());
    assertTrue(actualClone.getValues().isEmpty());
  }

  /**
   * Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  public void testGetClone4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, Object> values = new HashMap<>();
    values.computeIfPresent("contentName", mock(BiFunction.class));

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(values);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());

    // Act
    StructuredContentDTO actualClone = structuredContentDTO.getClone();

    // Assert
    assertEquals("Not all who wander are lost", actualClone.getContentName());
    assertEquals("Rule Expression", actualClone.getRuleExpression());
    assertEquals("en", actualClone.getLocaleCode());
    assertEquals("text/plain", actualClone.getContentType());
    assertEquals(1, actualClone.getPriority().intValue());
    assertEquals(1L, actualClone.getId().longValue());
    assertTrue(actualClone.getItemCriteriaDTOList().isEmpty());
    assertTrue(actualClone.getValues().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentDTO}
   *   <li>{@link StructuredContentDTO#setId(Long)}
   *   <li>{@link StructuredContentDTO#setItemCriteriaDTOList(List)}
   *   <li>{@link StructuredContentDTO#setRuleExpression(String)}
   *   <li>{@link StructuredContentDTO#setValues(Map)}
   *   <li>{@link StructuredContentDTO#getContentName()}
   *   <li>{@link StructuredContentDTO#getContentType()}
   *   <li>{@link StructuredContentDTO#getId()}
   *   <li>{@link StructuredContentDTO#getItemCriteriaDTOList()}
   *   <li>{@link StructuredContentDTO#getLocaleCode()}
   *   <li>{@link StructuredContentDTO#getPriority()}
   *   <li>{@link StructuredContentDTO#getRuleExpression()}
   *   <li>{@link StructuredContentDTO#getValues()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentDTO actualStructuredContentDTO = new StructuredContentDTO();
    actualStructuredContentDTO.setId(1L);
    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    actualStructuredContentDTO.setItemCriteriaDTOList(itemCriteriaDTOList);
    actualStructuredContentDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    actualStructuredContentDTO.setValues(values);
    actualStructuredContentDTO.getContentName();
    actualStructuredContentDTO.getContentType();
    Long actualId = actualStructuredContentDTO.getId();
    List<ItemCriteriaDTO> actualItemCriteriaDTOList = actualStructuredContentDTO.getItemCriteriaDTOList();
    actualStructuredContentDTO.getLocaleCode();
    actualStructuredContentDTO.getPriority();
    String actualRuleExpression = actualStructuredContentDTO.getRuleExpression();
    Map<String, Object> actualValues = actualStructuredContentDTO.getValues();

    // Assert that nothing has changed
    assertEquals("Rule Expression", actualRuleExpression);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualItemCriteriaDTOList.isEmpty());
    assertTrue(actualValues.isEmpty());
    assertSame(itemCriteriaDTOList, actualItemCriteriaDTOList);
    assertSame(values, actualValues);
  }
}
