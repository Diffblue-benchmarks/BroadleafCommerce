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
package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue;
import org.broadleafcommerce.common.enumeration.service.DataDrivenEnumerationService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataDrivenEnumVariableExpressionDiffblueTest {
  @InjectMocks private DataDrivenEnumVariableExpression dataDrivenEnumVariableExpression;

  @Mock private DataDrivenEnumerationService dataDrivenEnumerationService;

  /**
   * Test {@link DataDrivenEnumVariableExpression#getName()}.
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDrivenEnumVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("enumeration", new DataDrivenEnumVariableExpression().getName());
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with {@code key}.
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String)"})
  public void testGetEnumValuesWithKey() {
    // Arrange
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues("Key"));
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with {@code key}.
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String)"})
  public void testGetEnumValuesWithKey2() {
    // Arrange
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues("Key"));
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)} with {@code key},
   * {@code sort}.
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String, String)"})
  public void testGetEnumValuesWithKeySort() {
    // Arrange
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues("Key", "Sort"));
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)} with {@code key},
   * {@code sort}.
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String, String)"})
  public void testGetEnumValuesWithKeySort2() {
    // Arrange
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues("Key", "Sort"));
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)} with {@code key},
   * {@code sort}.
   *
   * <ul>
   *   <li>Then calls {@link DataDrivenEnumeration#getEnumValues()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String, String)"})
  public void testGetEnumValuesWithKeySort_thenCallsGetEnumValues() {
    // Arrange
    DataDrivenEnumeration dataDrivenEnumeration = mock(DataDrivenEnumeration.class);
    when(dataDrivenEnumeration.getEnumValues()).thenThrow(new IllegalArgumentException());
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any()))
        .thenReturn(dataDrivenEnumeration);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues("Key", "Sort"));
    verify(dataDrivenEnumeration).getEnumValues();
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)} with {@code key},
   * {@code sort}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String, String)"})
  public void testGetEnumValuesWithKeySort_thenReturnEmpty() {
    // Arrange
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any()))
        .thenReturn(new DataDrivenEnumerationImpl());

    // Act
    List<DataDrivenEnumerationValue> actualEnumValues =
        dataDrivenEnumVariableExpression.getEnumValues("Key", "Sort");

    // Assert
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
    assertTrue(actualEnumValues.isEmpty());
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)} with {@code key},
   * {@code sort}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String, String)"})
  public void testGetEnumValuesWithKeySort_thenReturnEmpty2() {
    // Arrange
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any()))
        .thenReturn(new DataDrivenEnumerationImpl());

    // Act
    List<DataDrivenEnumerationValue> actualEnumValues =
        dataDrivenEnumVariableExpression.getEnumValues("Key", null);

    // Assert
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
    assertTrue(actualEnumValues.isEmpty());
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)} with {@code key},
   * {@code sort}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String, String)"})
  public void testGetEnumValuesWithKeySort_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues("", "not empty"));
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)} with {@code key},
   * {@code sort}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String, String)"})
  public void testGetEnumValuesWithKeySort_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues(null, "not empty"));
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then calls {@link DataDrivenEnumeration#getEnumValues()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String)"})
  public void testGetEnumValuesWithKey_thenCallsGetEnumValues() {
    // Arrange
    DataDrivenEnumeration dataDrivenEnumeration = mock(DataDrivenEnumeration.class);
    when(dataDrivenEnumeration.getEnumValues()).thenThrow(new IllegalArgumentException());
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any()))
        .thenReturn(dataDrivenEnumeration);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataDrivenEnumVariableExpression.getEnumValues("Key"));
    verify(dataDrivenEnumeration).getEnumValues();
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String)"})
  public void testGetEnumValuesWithKey_thenReturnEmpty() {
    // Arrange
    when(dataDrivenEnumerationService.findEnumByKey(Mockito.<String>any()))
        .thenReturn(new DataDrivenEnumerationImpl());

    // Act
    List<DataDrivenEnumerationValue> actualEnumValues =
        dataDrivenEnumVariableExpression.getEnumValues("Key");

    // Assert
    verify(dataDrivenEnumerationService).findEnumByKey("Key");
    assertTrue(actualEnumValues.isEmpty());
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with {@code key}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String)"})
  public void testGetEnumValuesWithKey_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> dataDrivenEnumVariableExpression.getEnumValues(""));
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumVariableExpression.getEnumValues(String)"})
  public void testGetEnumValuesWithKey_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> dataDrivenEnumVariableExpression.getEnumValues(null));
  }
}
