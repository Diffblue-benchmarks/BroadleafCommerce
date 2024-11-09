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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class UriPropertyValidatorDiffblueTest {
  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   * <ul>
   *   <li>When {@code ftp}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  public void testIsFullUrl_whenFtp_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new UriPropertyValidator()).isFullUrl("ftp"));
  }

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  public void testIsFullUrl_whenHttpsExampleOrgExample_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new UriPropertyValidator()).isFullUrl("https://example.org/example"));
  }

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  public void testIsFullUrl_whenUrl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new UriPropertyValidator()).isFullUrl("Url"));
  }

  /**
   * Test
   * {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenNull_thenReturnErrorMessageIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UriPropertyValidator uriPropertyValidator = new UriPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = uriPropertyValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", null);

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenSpace_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UriPropertyValidator uriPropertyValidator = new UriPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = uriPropertyValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", " ");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("uriPropertyValidatorCannotContainSpacesError", errorMessages.get(0));
    assertEquals("uriPropertyValidatorCannotContainSpacesError", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UriPropertyValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link UriPropertyValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    UriPropertyValidator uriPropertyValidator = new UriPropertyValidator();

    // Act
    uriPropertyValidator.setSucceedForNullValues(true);

    // Assert that nothing has changed
    assertTrue(uriPropertyValidator.isSucceedForNullValues());
  }
}
