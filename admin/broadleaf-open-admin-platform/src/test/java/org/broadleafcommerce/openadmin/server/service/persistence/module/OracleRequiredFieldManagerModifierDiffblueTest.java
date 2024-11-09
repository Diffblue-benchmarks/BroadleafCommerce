/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.Field;
import javax.persistence.Column;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.RequiredOverride;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.junit.Test;

public class OracleRequiredFieldManagerModifierDiffblueTest {
  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_given42_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
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
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
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
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given {@code NOT_REQUIRED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_givenNotRequired() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
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
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>When {@link AdminPresentation} {@link AdminPresentation#defaultValue()}
   * return {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_whenAdminPresentationDefaultValueReturnNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
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
   * Test
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}.
   * <ul>
   *   <li>Given {@code ID}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}
   */
  @Test
  public void testIsStringFieldType_givenId_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
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
   * Test
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}.
   * <ul>
   *   <li>Given {@code STRING}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}
   */
  @Test
  public void testIsStringFieldType_givenString_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
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
   * Test {@link OracleRequiredFieldManagerModifier#getOrder()}.
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new OracleRequiredFieldManagerModifier()).getOrder());
  }
}
