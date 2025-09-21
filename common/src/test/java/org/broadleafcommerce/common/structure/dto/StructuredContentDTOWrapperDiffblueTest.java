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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class StructuredContentDTOWrapperDiffblueTest {
  @Mock private StructuredContentDTO structuredContentDTO;

  @InjectMocks private StructuredContentDTOWrapper structuredContentDTOWrapper;

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDTOWrapper.equals(Object)",
    "int StructuredContentDTOWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    StructuredContentDTOWrapper structuredContentDTOWrapper =
        new StructuredContentDTOWrapper(structuredContentDTO);

    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Not all who wander are lost");
    structuredContentDTO2.setContentType("text/plain");
    structuredContentDTO2.setId(1L);
    structuredContentDTO2.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO2.setLocaleCode("en");
    structuredContentDTO2.setPriority(1);
    structuredContentDTO2.setRuleExpression("Rule Expression");
    structuredContentDTO2.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        structuredContentDTOWrapper, new StructuredContentDTOWrapper(structuredContentDTO2));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDTOWrapper.equals(Object)",
    "int StructuredContentDTOWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(structuredContentDTO), null);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDTOWrapper.equals(Object)",
    "int StructuredContentDTOWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        new StructuredContentDTOWrapper(structuredContentDTO),
        new StructuredContentDTOWrapper(structuredContentDTO));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDTOWrapper.equals(Object)",
    "int StructuredContentDTOWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        new StructuredContentDTOWrapper(structuredContentDTO),
        "Different type to StructuredContentDTOWrapper");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Then calls {@link StructuredContentDTO#getPropertyValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTOWrapper.getPropertyValue(String)"})
  public void testGetPropertyValue_thenCallsGetPropertyValue() {
    // Arrange
    when(structuredContentDTO.getPropertyValue(Mockito.<String>any()))
        .thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    structuredContentDTOWrapper.getPropertyValue("Property Name");

    // Assert
    verify(structuredContentDTO).getPropertyValue("Property Name");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object StructuredContentDTOWrapper.getPropertyValue(String)"})
  public void testGetPropertyValue_thenReturnNull() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertNull(
        new StructuredContentDTOWrapper(structuredContentDTO).getPropertyValue("Property Name"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getId()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long StructuredContentDTOWrapper.getId()"})
  public void testGetId() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(1L, new StructuredContentDTOWrapper(structuredContentDTO).getId().longValue());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getContentName()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getContentName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getContentName()"})
  public void testGetContentName() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(
        "Not all who wander are lost",
        new StructuredContentDTOWrapper(structuredContentDTO).getContentName());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getContentType()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getContentType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getContentType()"})
  public void testGetContentType() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(
        "text/plain", new StructuredContentDTOWrapper(structuredContentDTO).getContentType());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getLocaleCode()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getLocaleCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getLocaleCode()"})
  public void testGetLocaleCode() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertEquals("en", new StructuredContentDTOWrapper(structuredContentDTO).getLocaleCode());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPriority()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer StructuredContentDTOWrapper.getPriority()"})
  public void testGetPriority() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(1, new StructuredContentDTOWrapper(structuredContentDTO).getPriority().intValue());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getValues()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StructuredContentDTOWrapper.getValues()"})
  public void testGetValues() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    structuredContentDTO.setValues(values);

    // Act
    Map actualValues = new StructuredContentDTOWrapper(structuredContentDTO).getValues();

    // Assert
    assertTrue(actualValues.isEmpty());
    assertSame(values, actualValues);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getRuleExpression()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getRuleExpression()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentDTOWrapper.getRuleExpression()"})
  public void testGetRuleExpression() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(
        "Rule Expression",
        new StructuredContentDTOWrapper(structuredContentDTO).getRuleExpression());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentDTOWrapper.getItemCriteriaDTOList()"})
  public void testGetItemCriteriaDTOList() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(
        new StructuredContentDTOWrapper(structuredContentDTO).getItemCriteriaDTOList().isEmpty());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setContentName(String)}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setContentName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setContentName(String)"})
  public void testSetContentName() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    structuredContentDTO.setValues(values);
    StructuredContentDTOWrapper structuredContentDTOWrapper =
        new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setContentName("Not all who wander are lost");

    // Assert
    Map values2 = structuredContentDTOWrapper.getValues();
    assertEquals(1, values2.size());
    assertEquals("Not all who wander are lost", values2.get("contentName"));
    assertEquals(
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues(),
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues());
    assertSame(values, values2);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setContentName(String)}.
   *
   * <ul>
   *   <li>Then calls {@link StructuredContentDTO#setContentName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setContentName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setContentName(String)"})
  public void testSetContentName_thenCallsSetContentName() {
    // Arrange
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setContentName("Not all who wander are lost");

    // Assert
    verify(structuredContentDTO).setContentName("Not all who wander are lost");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setContentType(String)}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setContentType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setContentType(String)"})
  public void testSetContentType() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    structuredContentDTO.setValues(values);
    StructuredContentDTOWrapper structuredContentDTOWrapper =
        new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setContentType("text/plain");

    // Assert
    Map values2 = structuredContentDTOWrapper.getValues();
    assertEquals(1, values2.size());
    assertEquals("text/plain", values2.get("contentType"));
    assertEquals(
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues(),
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues());
    assertSame(values, values2);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setContentType(String)}.
   *
   * <ul>
   *   <li>Then calls {@link StructuredContentDTO#setContentType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setContentType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setContentType(String)"})
  public void testSetContentType_thenCallsSetContentType() {
    // Arrange
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setContentType("text/plain");

    // Assert
    verify(structuredContentDTO).setContentType("text/plain");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setLocaleCode(String)}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setLocaleCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setLocaleCode(String)"})
  public void testSetLocaleCode() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    structuredContentDTO.setValues(values);
    StructuredContentDTOWrapper structuredContentDTOWrapper =
        new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setLocaleCode("en");

    // Assert
    Map values2 = structuredContentDTOWrapper.getValues();
    assertEquals(1, values2.size());
    assertEquals("en", values2.get("localeCode"));
    assertEquals(
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues(),
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues());
    assertSame(values, values2);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setLocaleCode(String)}.
   *
   * <ul>
   *   <li>Then calls {@link StructuredContentDTO#setLocaleCode(String)}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setLocaleCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setLocaleCode(String)"})
  public void testSetLocaleCode_thenCallsSetLocaleCode() {
    // Arrange
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setLocaleCode("en");

    // Assert
    verify(structuredContentDTO).setLocaleCode("en");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setPriority(Integer)}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setPriority(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setPriority(Integer)"})
  public void testSetPriority() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    structuredContentDTO.setValues(values);
    StructuredContentDTOWrapper structuredContentDTOWrapper =
        new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setPriority(1);

    // Assert
    Map values2 = structuredContentDTOWrapper.getValues();
    assertEquals(1, values2.size());
    assertEquals(1, ((Integer) values2.get("priority")).intValue());
    assertEquals(
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues(),
        structuredContentDTOWrapper
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getClone()
            .getValues());
    assertSame(values, values2);
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setValues(Map)}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setValues(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setValues(Map)"})
  public void testSetValues() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    StructuredContentDTOWrapper structuredContentDTOWrapper =
        new StructuredContentDTOWrapper(structuredContentDTO);
    HashMap<Object, Object> values = new HashMap<>();

    // Act
    structuredContentDTOWrapper.setValues((Map) values);

    // Assert
    assertSame(values, structuredContentDTOWrapper.getValues());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setRuleExpression(String)}.
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setRuleExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setRuleExpression(String)"})
  public void testSetRuleExpression() {
    // Arrange
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());

    // Act
    structuredContentDTOWrapper.setRuleExpression("Rule Expression");

    // Assert
    verify(structuredContentDTO).setRuleExpression("Rule Expression");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   *
   * <ul>
   *   <li>Given {@link ItemCriteriaDTO} (default constructor) MatchRule is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setItemCriteriaDTOList(List)"})
  public void testSetItemCriteriaDTOList_givenItemCriteriaDTOMatchRuleIs42() {
    // Arrange
    doNothing()
        .when(structuredContentDTO)
        .setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());

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
   *
   * <ul>
   *   <li>Given {@link ItemCriteriaDTO} (default constructor) MatchRule is {@code Match Rule}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setItemCriteriaDTOList(List)"})
  public void testSetItemCriteriaDTOList_givenItemCriteriaDTOMatchRuleIsMatchRule() {
    // Arrange
    doNothing()
        .when(structuredContentDTO)
        .setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentDTOWrapper.setItemCriteriaDTOList(List)"})
  public void testSetItemCriteriaDTOList_whenArrayList() {
    // Arrange
    doNothing()
        .when(structuredContentDTO)
        .setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());

    // Act
    structuredContentDTOWrapper.setItemCriteriaDTOList(new ArrayList<>());

    // Assert
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
  }
}
