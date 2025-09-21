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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentDTODiffblueTest {
  @Autowired private StructuredContentDTO structuredContentDTO;

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentDTO} (default constructor) Values is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTOValuesIsHashMap() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(
        "Not all who wander are lost", structuredContentDTO.getPropertyValue("contentName"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentDTO}.
   *   <li>When {@code contentName}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenContentName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(structuredContentDTO.getPropertyValue("contentName"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentDTO}.
   *   <li>When {@code contentType}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenContentType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(structuredContentDTO.getPropertyValue("contentType"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentDTO}.
   *   <li>When {@code localeCode}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenLocaleCode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(structuredContentDTO.getPropertyValue("localeCode"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentDTO}.
   *   <li>When {@code priority}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenPriority_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(structuredContentDTO.getPropertyValue("priority"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentDTO}.
   *   <li>When {@code Property Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_givenStructuredContentDTO_whenPropertyName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(structuredContentDTO.getPropertyValue("Property Name"));
  }

  /**
   * Test {@link StructuredContentDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_thenReturnNotAllWhoWanderAreLost() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");

    // Act and Assert
    assertEquals(
        "Not all who wander are lost", structuredContentDTO.getPropertyValue("contentName"));
  }

  /**
   * Test {@link StructuredContentDTO#setContentName(String)}.
   *
   * <p>Method under test: {@link StructuredContentDTO#setContentName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTO.setContentName(String)"})
  public void testSetContentName() {
    // Arrange and Act
    structuredContentDTO.setContentName("Not all who wander are lost");

    // Assert
    StructuredContentDTO clone = structuredContentDTO.getClone();
    StructuredContentDTO clone2 = clone.getClone();
    StructuredContentDTO clone3 = clone2.getClone();
    StructuredContentDTO clone4 = clone3.getClone();
    StructuredContentDTO clone5 = clone4.getClone();
    StructuredContentDTO clone6 = clone5.getClone();
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals("Not all who wander are lost", clone7.getClone().getContentName());
    assertEquals("Not all who wander are lost", clone7.getContentName());
    assertEquals("Not all who wander are lost", clone6.getContentName());
    assertEquals("Not all who wander are lost", clone5.getContentName());
    assertEquals("Not all who wander are lost", clone4.getContentName());
    assertEquals("Not all who wander are lost", clone3.getContentName());
    assertEquals("Not all who wander are lost", clone2.getContentName());
    assertEquals("Not all who wander are lost", clone.getContentName());
    assertEquals("Not all who wander are lost", structuredContentDTO.getContentName());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    assertEquals("Not all who wander are lost", values.get("contentName"));
  }

  /**
   * Test {@link StructuredContentDTO#setContentType(String)}.
   *
   * <p>Method under test: {@link StructuredContentDTO#setContentType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTO.setContentType(String)"})
  public void testSetContentType() {
    // Arrange and Act
    structuredContentDTO.setContentType("text/plain");

    // Assert
    StructuredContentDTO clone = structuredContentDTO.getClone();
    StructuredContentDTO clone2 = clone.getClone();
    StructuredContentDTO clone3 = clone2.getClone();
    StructuredContentDTO clone4 = clone3.getClone();
    StructuredContentDTO clone5 = clone4.getClone();
    StructuredContentDTO clone6 = clone5.getClone();
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals("text/plain", clone7.getClone().getContentType());
    assertEquals("text/plain", clone7.getContentType());
    assertEquals("text/plain", clone6.getContentType());
    assertEquals("text/plain", clone5.getContentType());
    assertEquals("text/plain", clone4.getContentType());
    assertEquals("text/plain", clone3.getContentType());
    assertEquals("text/plain", clone2.getContentType());
    assertEquals("text/plain", clone.getContentType());
    assertEquals("text/plain", structuredContentDTO.getContentType());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    assertEquals("text/plain", values.get("contentType"));
  }

  /**
   * Test {@link StructuredContentDTO#setLocaleCode(String)}.
   *
   * <p>Method under test: {@link StructuredContentDTO#setLocaleCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTO.setLocaleCode(String)"})
  public void testSetLocaleCode() {
    // Arrange and Act
    structuredContentDTO.setLocaleCode("en");

    // Assert
    StructuredContentDTO clone = structuredContentDTO.getClone();
    StructuredContentDTO clone2 = clone.getClone();
    StructuredContentDTO clone3 = clone2.getClone();
    StructuredContentDTO clone4 = clone3.getClone();
    StructuredContentDTO clone5 = clone4.getClone();
    StructuredContentDTO clone6 = clone5.getClone();
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals("en", clone7.getClone().getLocaleCode());
    assertEquals("en", clone7.getLocaleCode());
    assertEquals("en", clone6.getLocaleCode());
    assertEquals("en", clone5.getLocaleCode());
    assertEquals("en", clone4.getLocaleCode());
    assertEquals("en", clone3.getLocaleCode());
    assertEquals("en", clone2.getLocaleCode());
    assertEquals("en", clone.getLocaleCode());
    assertEquals("en", structuredContentDTO.getLocaleCode());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    assertEquals("en", values.get("localeCode"));
  }

  /**
   * Test {@link StructuredContentDTO#setPriority(Integer)}.
   *
   * <p>Method under test: {@link StructuredContentDTO#setPriority(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTO.setPriority(Integer)"})
  public void testSetPriority() {
    // Arrange and Act
    structuredContentDTO.setPriority(1);

    // Assert
    StructuredContentDTO clone = structuredContentDTO.getClone();
    StructuredContentDTO clone2 = clone.getClone();
    StructuredContentDTO clone3 = clone2.getClone();
    StructuredContentDTO clone4 = clone3.getClone();
    StructuredContentDTO clone5 = clone4.getClone();
    StructuredContentDTO clone6 = clone5.getClone();
    StructuredContentDTO clone7 = clone6.getClone();
    assertEquals(1, clone7.getClone().getPriority().intValue());
    assertEquals(1, clone7.getPriority().intValue());
    assertEquals(1, clone6.getPriority().intValue());
    assertEquals(1, clone5.getPriority().intValue());
    assertEquals(1, clone4.getPriority().intValue());
    assertEquals(1, clone3.getPriority().intValue());
    assertEquals(1, clone2.getPriority().intValue());
    assertEquals(1, clone.getPriority().intValue());
    assertEquals(1, structuredContentDTO.getPriority().intValue());
    Map<String, Object> values = structuredContentDTO.getValues();
    assertEquals(1, values.size());
    assertEquals(1, ((Integer) values.get("priority")).intValue());
  }

  /**
   * Test {@link StructuredContentDTO#getClone()}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentDTO}.
   *   <li>Then return ItemCriteriaDTOList is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StructuredContentDTO StructuredContentDTO.getClone()"})
  public void testGetClone_givenStructuredContentDTO_thenReturnItemCriteriaDTOListIsNull() {
    // Arrange and Act
    StructuredContentDTO actualClone = structuredContentDTO.getClone();

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
   * Test {@link StructuredContentDTO#getClone()}.
   *
   * <ul>
   *   <li>Then return ItemCriteriaDTOList Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StructuredContentDTO StructuredContentDTO.getClone()"})
  public void testGetClone_thenReturnItemCriteriaDTOListEmpty() {
    // Arrange
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());

    // Act
    StructuredContentDTO actualClone = structuredContentDTO.getClone();

    // Assert
    assertNull(actualClone.getPriority());
    assertNull(actualClone.getId());
    assertNull(actualClone.getContentName());
    assertNull(actualClone.getContentType());
    assertNull(actualClone.getLocaleCode());
    assertNull(actualClone.getRuleExpression());
    assertTrue(actualClone.getItemCriteriaDTOList().isEmpty());
    assertTrue(actualClone.getValues().isEmpty());
  }

  /**
   * Test {@link StructuredContentDTO#getClone()}.
   *
   * <ul>
   *   <li>Then return ItemCriteriaDTOList size is one.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTO#getClone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StructuredContentDTO StructuredContentDTO.getClone()"})
  public void testGetClone_thenReturnItemCriteriaDTOListSizeIsOne() {
    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);
    structuredContentDTO.setItemCriteriaDTOList(itemCriteriaDTOList);

    // Act and Assert
    List<ItemCriteriaDTO> itemCriteriaDTOList2 =
        structuredContentDTO.getClone().getItemCriteriaDTOList();
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentDTO.<init>()",
    "String StructuredContentDTO.getContentName()",
    "String StructuredContentDTO.getContentType()",
    "Long StructuredContentDTO.getId()",
    "List StructuredContentDTO.getItemCriteriaDTOList()",
    "String StructuredContentDTO.getLocaleCode()",
    "Integer StructuredContentDTO.getPriority()",
    "String StructuredContentDTO.getRuleExpression()",
    "Map StructuredContentDTO.getValues()",
    "void StructuredContentDTO.setId(Long)",
    "void StructuredContentDTO.setItemCriteriaDTOList(List)",
    "void StructuredContentDTO.setRuleExpression(String)",
    "void StructuredContentDTO.setValues(Map)"
  })
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
    List<ItemCriteriaDTO> actualItemCriteriaDTOList =
        actualStructuredContentDTO.getItemCriteriaDTOList();
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
