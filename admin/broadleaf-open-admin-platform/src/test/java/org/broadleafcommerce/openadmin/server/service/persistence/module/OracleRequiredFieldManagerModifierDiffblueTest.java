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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.RequiredOverride;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.util.DialectHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OracleRequiredFieldManagerModifier.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OracleRequiredFieldManagerModifierDiffblueTest {
  @MockBean(name = "blDialectHelper")
  private DialectHelper dialectHelper;

  @Autowired
  private OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;

  /**
   * Test {@link OracleRequiredFieldManagerModifier#canHandle(Field, Object, EntityManager)}.
   * <ul>
   *   <li>Given Bean Name{blDialectHelper} {@link DialectHelper#isOracle(EntityManager)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#canHandle(Field, Object, EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OracleRequiredFieldManagerModifier.canHandle(Field, Object, EntityManager)"})
  public void testCanHandle_givenBeanNameBlDialectHelperIsOracleReturnFalse_thenReturnFalse() {
    // Arrange
    when(dialectHelper.isOracle(Mockito.<EntityManager>any())).thenReturn(false);

    // Act
    boolean actualCanHandleResult = oracleRequiredFieldManagerModifier.canHandle(null, "Value", null);

    // Assert
    verify(dialectHelper).isOracle(isNull());
    assertFalse(actualCanHandleResult);
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OracleRequiredFieldManagerModifier.isRequiredField(AdminPresentation, Column)"})
  public void testIsRequiredField_given42_thenReturnFalse() {
    // Arrange
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn("42");
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertFalse(actualIsRequiredFieldResult);
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OracleRequiredFieldManagerModifier.isRequiredField(AdminPresentation, Column)"})
  public void testIsRequiredField_givenEmptyString() {
    // Arrange
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn("");
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertTrue(actualIsRequiredFieldResult);
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given {@code NOT_REQUIRED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OracleRequiredFieldManagerModifier.isRequiredField(AdminPresentation, Column)"})
  public void testIsRequiredField_givenNotRequired() {
    // Arrange
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn("42");
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.NOT_REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertFalse(actualIsRequiredFieldResult);
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>When {@link AdminPresentation} {@link AdminPresentation#defaultValue()} return {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OracleRequiredFieldManagerModifier.isRequiredField(AdminPresentation, Column)"})
  public void testIsRequiredField_whenAdminPresentationDefaultValueReturnNull_thenReturnTrue() {
    // Arrange
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn(null);
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertTrue(actualIsRequiredFieldResult);
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}.
   * <ul>
   *   <li>Given {@code ID}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OracleRequiredFieldManagerModifier.isStringFieldType(Field, AdminPresentation)"})
  public void testIsStringFieldType_givenId_thenReturnFalse() {
    // Arrange
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.fieldType()).thenReturn(SupportedFieldType.ID);

    // Act
    boolean actualIsStringFieldTypeResult = oracleRequiredFieldManagerModifier.isStringFieldType(null,
        adminPresentation);

    // Assert
    verify(adminPresentation).fieldType();
    assertFalse(actualIsStringFieldTypeResult);
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}.
   * <ul>
   *   <li>Given {@code STRING}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OracleRequiredFieldManagerModifier.isStringFieldType(Field, AdminPresentation)"})
  public void testIsStringFieldType_givenString_thenReturnTrue() {
    // Arrange
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.fieldType()).thenReturn(SupportedFieldType.STRING);

    // Act
    boolean actualIsStringFieldTypeResult = oracleRequiredFieldManagerModifier.isStringFieldType(null,
        adminPresentation);

    // Assert
    verify(adminPresentation).fieldType();
    assertTrue(actualIsStringFieldTypeResult);
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return space.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getModifiedWriteValue(Field, Object, Object, EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object OracleRequiredFieldManagerModifier.getModifiedWriteValue(Field, Object, Object, EntityManager)"})
  public void testGetModifiedWriteValue_whenEmptyString_thenReturnSpace() throws IllegalAccessException {
    // Arrange, Act and Assert
    assertEquals(" ", oracleRequiredFieldManagerModifier.getModifiedWriteValue(null, "Value", "", null));
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   * <ul>
   *   <li>When {@code New Value}.</li>
   *   <li>Then return {@code New Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getModifiedWriteValue(Field, Object, Object, EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object OracleRequiredFieldManagerModifier.getModifiedWriteValue(Field, Object, Object, EntityManager)"})
  public void testGetModifiedWriteValue_whenNewValue_thenReturnNewValue() throws IllegalAccessException {
    // Arrange, Act and Assert
    assertEquals("New Value",
        oracleRequiredFieldManagerModifier.getModifiedWriteValue(null, "Value", "New Value", null));
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object OracleRequiredFieldManagerModifier.getModifiedReadValue(Field, Object, EntityManager)"})
  public void testGetModifiedReadValue_whenNull_thenReturnNull() throws IllegalAccessException {
    // Arrange, Act and Assert
    assertNull(oracleRequiredFieldManagerModifier.getModifiedReadValue(null, null, null));
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object OracleRequiredFieldManagerModifier.getModifiedReadValue(Field, Object, EntityManager)"})
  public void testGetModifiedReadValue_whenSpace_thenReturnEmptyString() throws IllegalAccessException {
    // Arrange, Act and Assert
    assertEquals("", oracleRequiredFieldManagerModifier.getModifiedReadValue(null, " ", null));
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object OracleRequiredFieldManagerModifier.getModifiedReadValue(Field, Object, EntityManager)"})
  public void testGetModifiedReadValue_whenValue_thenReturnValue() throws IllegalAccessException {
    // Arrange, Act and Assert
    assertEquals("Value", oracleRequiredFieldManagerModifier.getModifiedReadValue(null, "Value", null));
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getOrder()}.
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OracleRequiredFieldManagerModifier.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000, oracleRequiredFieldManagerModifier.getOrder());
  }
}
