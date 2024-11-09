/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link StructuredContentDTOWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#equals(Object)}
   */
  @Test
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
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentDTOWrapper(new StructuredContentDTO()),
        "Different type to StructuredContentDTOWrapper");
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPropertyValue(String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTOWrapper(new StructuredContentDTO())))
        .getPropertyValue("Property Name"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getPropertyValue(String)}.
   * <ul>
   *   <li>Then calls {@link StructuredContentDTO#getPropertyValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue_thenCallsGetPropertyValue() {
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
   * Test {@link StructuredContentDTOWrapper#getPropertyValue(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDTOWrapper#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getPropertyValue("Property Name"));
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getId()}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#getId()}
   */
  @Test
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
  public void testGetRuleExpression_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentDTOWrapper(new StructuredContentDTO())).getRuleExpression());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}.
   * <p>
   * Method under test:
   * {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}
   */
  @Test
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
   * Method under test:
   * {@link StructuredContentDTOWrapper#getItemCriteriaDTOList()}
   */
  @Test
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
  public void testSetContentName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act
    structuredContentDTOWrapper.setContentName("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", structuredContentDTOWrapper.getContentName());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals("Not all who wander are lost", values.get("contentName"));
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
   * Test {@link StructuredContentDTOWrapper#setContentName(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setContentName(String)}
   */
  @Test
  public void testSetContentName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act
    structuredContentDTOWrapper.setContentName("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", structuredContentDTOWrapper.getContentName());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals("Not all who wander are lost", values.get("contentName"));
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
   * Test {@link StructuredContentDTOWrapper#setContentName(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setContentName(String)}
   */
  @Test
  public void testSetContentName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setContentName("Not all who wander are lost");

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
    assertNull(structuredContentDTOWrapper.getContentName());
    Map values = structuredContentDTOWrapper.getValues();
    assertTrue(values.isEmpty());
    assertEquals(values,
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
   * Test {@link StructuredContentDTOWrapper#setContentType(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setContentType(String)}
   */
  @Test
  public void testSetContentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act
    structuredContentDTOWrapper.setContentType("text/plain");

    // Assert
    assertEquals("text/plain", structuredContentDTOWrapper.getContentType());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals("text/plain", values.get("contentType"));
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
   * Test {@link StructuredContentDTOWrapper#setContentType(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setContentType(String)}
   */
  @Test
  public void testSetContentType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act
    structuredContentDTOWrapper.setContentType("text/plain");

    // Assert
    assertEquals("text/plain", structuredContentDTOWrapper.getContentType());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals("text/plain", values.get("contentType"));
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
   * Test {@link StructuredContentDTOWrapper#setContentType(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setContentType(String)}
   */
  @Test
  public void testSetContentType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setContentType("text/plain");

    // Assert
    verify(structuredContentDTO).setContentType(eq("text/plain"));
    assertNull(structuredContentDTOWrapper.getContentType());
    Map values = structuredContentDTOWrapper.getValues();
    assertTrue(values.isEmpty());
    assertEquals(values,
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
   * Test {@link StructuredContentDTOWrapper#setLocaleCode(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setLocaleCode(String)}
   */
  @Test
  public void testSetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTO());

    // Act
    structuredContentDTOWrapper.setLocaleCode("en");

    // Assert
    assertEquals("en", structuredContentDTOWrapper.getLocaleCode());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals("en", values.get("localeCode"));
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
   * Test {@link StructuredContentDTOWrapper#setLocaleCode(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setLocaleCode(String)}
   */
  @Test
  public void testSetLocaleCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(
        new StructuredContentDTOWrapper(new StructuredContentDTO()));

    // Act
    structuredContentDTOWrapper.setLocaleCode("en");

    // Assert
    assertEquals("en", structuredContentDTOWrapper.getLocaleCode());
    Map values = structuredContentDTOWrapper.getValues();
    assertEquals(1, values.size());
    assertEquals("en", values.get("localeCode"));
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
   * Test {@link StructuredContentDTOWrapper#setLocaleCode(String)}.
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setLocaleCode(String)}
   */
  @Test
  public void testSetLocaleCode3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setLocaleCode("en");

    // Assert
    verify(structuredContentDTO).setLocaleCode(eq("en"));
    assertNull(structuredContentDTOWrapper.getLocaleCode());
    Map values = structuredContentDTOWrapper.getValues();
    assertTrue(values.isEmpty());
    assertEquals(values,
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
    assertTrue(values.containsKey("priority"));
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
    assertTrue(values.containsKey("priority"));
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
   * Test {@link StructuredContentDTOWrapper#setValues(Map)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent
   * {@link BLCFieldUtils#NULL_FIELD} and {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDTOWrapper#setValues(Map)}
   */
  @Test
  public void testSetValues_givenNull_field_whenHashMapComputeIfPresentNull_fieldAndBiFunction() {
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
   * Test {@link StructuredContentDTOWrapper#setRuleExpression(String)}.
   * <p>
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
   * Test {@link StructuredContentDTOWrapper#setRuleExpression(String)}.
   * <p>
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
   * Test {@link StructuredContentDTOWrapper#setRuleExpression(String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentDTOWrapper#setRuleExpression(String)}
   */
  @Test
  public void testSetRuleExpression3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());
    StructuredContentDTOWrapper structuredContentDTOWrapper = new StructuredContentDTOWrapper(structuredContentDTO);

    // Act
    structuredContentDTOWrapper.setRuleExpression("Rule Expression");

    // Assert
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
    assertNull(structuredContentDTOWrapper.getRuleExpression());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <p>
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
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <p>
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
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <p>
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
    assertTrue(structuredContentDTOWrapper.getItemCriteriaDTOList().isEmpty());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <ul>
   *   <li>Given {@link ItemCriteriaDTO} (default constructor) MatchRule is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  public void testSetItemCriteriaDTOList_givenItemCriteriaDTOMatchRuleIs42() {
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
    assertTrue(structuredContentDTOWrapper.getItemCriteriaDTOList().isEmpty());
  }

  /**
   * Test {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}.
   * <ul>
   *   <li>Given {@link ItemCriteriaDTO} (default constructor) MatchRule is
   * {@code Match Rule}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDTOWrapper#setItemCriteriaDTOList(List)}
   */
  @Test
  public void testSetItemCriteriaDTOList_givenItemCriteriaDTOMatchRuleIsMatchRule() {
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
    assertTrue(structuredContentDTOWrapper.getItemCriteriaDTOList().isEmpty());
  }
}
