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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StructuredContentDTODiffblueTest {
  @Autowired
  private StructuredContentDTO structuredContentDTO;

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentDTO} (default constructor).</li>
   *   <li>When {@code contentName}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenContentName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTO()).getPropertyValue("contentName"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentDTO} (default constructor).</li>
   *   <li>When {@code contentType}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenContentType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTO()).getPropertyValue("contentType"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentDTO} (default constructor).</li>
   *   <li>When {@code localeCode}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenLocaleCode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTO()).getPropertyValue("localeCode"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentDTO} (default constructor).</li>
   *   <li>When {@code priority}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenPriority_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTO()).getPropertyValue("priority"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentDTO} (default constructor).</li>
   *   <li>When {@code Property Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenPropertyName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTO()).getPropertyValue("Property Name"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentDTO}.</li>
   *   <li>When {@code Property Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenPropertyName_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(structuredContentDTO.getPropertyValue("Property Name"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_thenReturnNotAllWhoWanderAreLost() {
    // Arrange
    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Not all who wander are lost");

    // Act and Assert
    assertEquals("Not all who wander are lost", structuredContentDTO2.getPropertyValue("contentName"));
  }

  /**
   * Test {@link StructuredContentDTO#setContentName(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTO#setContentName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTO.setContentName(String)"})
  public void testSetContentName() {
    // Arrange
    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();

    // Act
    structuredContentDTO2.setContentName("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", structuredContentDTO2.getContentName());
    StructuredContentDTO clone = structuredContentDTO2.getClone();
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
    Map<String, Object> values = structuredContentDTO2.getValues();
    assertEquals(1, values.size());
    assertEquals("Not all who wander are lost", values.get("contentName"));
  }

  /**
   * Test {@link StructuredContentDTO#setContentType(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTO#setContentType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTO.setContentType(String)"})
  public void testSetContentType() {
    // Arrange
    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();

    // Act
    structuredContentDTO2.setContentType("text/plain");

    // Assert
    assertEquals("text/plain", structuredContentDTO2.getContentType());
    StructuredContentDTO clone = structuredContentDTO2.getClone();
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
    Map<String, Object> values = structuredContentDTO2.getValues();
    assertEquals(1, values.size());
    assertEquals("text/plain", values.get("contentType"));
  }

  /**
   * Test {@link StructuredContentDTO#setLocaleCode(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTO#setLocaleCode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTO.setLocaleCode(String)"})
  public void testSetLocaleCode() {
    // Arrange
    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();

    // Act
    structuredContentDTO2.setLocaleCode("en");

    // Assert
    assertEquals("en", structuredContentDTO2.getLocaleCode());
    StructuredContentDTO clone = structuredContentDTO2.getClone();
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
    Map<String, Object> values = structuredContentDTO2.getValues();
    assertEquals(1, values.size());
    assertEquals("en", values.get("localeCode"));
  }

  /**
   * Test {@link StructuredContentDTO#setPriority(Integer)}.
   * <p>
   * Method under test: {@link StructuredContentDTO#setPriority(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTO.setPriority(Integer)"})
  public void testSetPriority() {
    // Arrange
    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();

    // Act
    structuredContentDTO2.setPriority(1);

    // Assert
    assertEquals(1, structuredContentDTO2.getPriority().intValue());
    StructuredContentDTO clone = structuredContentDTO2.getClone();
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
    Map<String, Object> values = structuredContentDTO2.getValues();
    assertEquals(1, values.size());
    assertEquals(1, ((Integer) values.get("priority")).intValue());
  }

  /**
   * Test {@link StructuredContentDTO#getClone()}.
   * <ul>
   *   <li>Given {@link StructuredContentDTO} (default constructor).</li>
   *   <li>Then return Priority is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StructuredContentDTO StructuredContentDTO.getClone()"})
  public void testGetClone_givenStructuredContentDTO_thenReturnPriorityIsNull() {
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
  }

  /**
   * Test {@link StructuredContentDTO#getClone()}.
   * <ul>
   *   <li>Then return ContentName is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StructuredContentDTO StructuredContentDTO.getClone()"})
  public void testGetClone_thenReturnContentNameIsNotAllWhoWanderAreLost() {
    // Arrange
    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Not all who wander are lost");
    structuredContentDTO2.setContentType("text/plain");
    structuredContentDTO2.setId(1L);
    structuredContentDTO2.setLocaleCode("en");
    structuredContentDTO2.setPriority(1);
    structuredContentDTO2.setRuleExpression("Rule Expression");
    structuredContentDTO2.setValues(new HashMap<>());
    structuredContentDTO2.setItemCriteriaDTOList(new ArrayList<>());

    // Act
    StructuredContentDTO actualClone = structuredContentDTO2.getClone();

    // Assert
    assertEquals("Not all who wander are lost", actualClone.getContentName());
    assertEquals("Rule Expression", actualClone.getRuleExpression());
    assertEquals("en", actualClone.getLocaleCode());
    assertEquals("text/plain", actualClone.getContentType());
    assertEquals(1, actualClone.getPriority().intValue());
    assertEquals(1L, actualClone.getId().longValue());
    assertTrue(actualClone.getItemCriteriaDTOList().isEmpty());
  }

  /**
   * Test {@link StructuredContentDTO#getClone()}.
   * <ul>
   *   <li>Then return ItemCriteriaDTOList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StructuredContentDTO StructuredContentDTO.getClone()"})
  public void testGetClone_thenReturnItemCriteriaDTOListSizeIsOne() {
    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);

    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Not all who wander are lost");
    structuredContentDTO2.setContentType("text/plain");
    structuredContentDTO2.setId(1L);
    structuredContentDTO2.setLocaleCode("en");
    structuredContentDTO2.setPriority(1);
    structuredContentDTO2.setRuleExpression("Rule Expression");
    structuredContentDTO2.setValues(new HashMap<>());
    structuredContentDTO2.setItemCriteriaDTOList(itemCriteriaDTOList);

    // Act and Assert
    List<ItemCriteriaDTO> itemCriteriaDTOList2 = structuredContentDTO2.getClone().getItemCriteriaDTOList();
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
    assertEquals(1, getResult.getQty().intValue());
    assertEquals(1, clone.getQty().intValue());
    assertEquals(1, clone2.getQty().intValue());
    assertEquals(1, clone3.getQty().intValue());
    assertEquals(1, clone4.getQty().intValue());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentDTO.<init>()", "String StructuredContentDTO.getContentName()",
      "String StructuredContentDTO.getContentType()", "Long StructuredContentDTO.getId()",
      "List StructuredContentDTO.getItemCriteriaDTOList()", "String StructuredContentDTO.getLocaleCode()",
      "Integer StructuredContentDTO.getPriority()", "String StructuredContentDTO.getRuleExpression()",
      "Map StructuredContentDTO.getValues()", "void StructuredContentDTO.setId(Long)",
      "void StructuredContentDTO.setItemCriteriaDTOList(List)", "void StructuredContentDTO.setRuleExpression(String)",
      "void StructuredContentDTO.setValues(Map)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentDTO actualStructuredContentDTO = new StructuredContentDTO();
    actualStructuredContentDTO.setId(1L);
    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    actualStructuredContentDTO.setItemCriteriaDTOList(itemCriteriaDTOList);
    actualStructuredContentDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    actualStructuredContentDTO.setValues(values);
    String actualContentName = actualStructuredContentDTO.getContentName();
    String actualContentType = actualStructuredContentDTO.getContentType();
    Long actualId = actualStructuredContentDTO.getId();
    List<ItemCriteriaDTO> actualItemCriteriaDTOList = actualStructuredContentDTO.getItemCriteriaDTOList();
    String actualLocaleCode = actualStructuredContentDTO.getLocaleCode();
    Integer actualPriority = actualStructuredContentDTO.getPriority();
    String actualRuleExpression = actualStructuredContentDTO.getRuleExpression();
    Map<String, Object> actualValues = actualStructuredContentDTO.getValues();

    // Assert
    assertEquals("Rule Expression", actualRuleExpression);
    assertNull(actualPriority);
    assertNull(actualContentName);
    assertNull(actualContentType);
    assertNull(actualLocaleCode);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualItemCriteriaDTOList.isEmpty());
    assertTrue(actualValues.isEmpty());
    assertSame(itemCriteriaDTOList, actualItemCriteriaDTOList);
    assertSame(values, actualValues);
  }
}
