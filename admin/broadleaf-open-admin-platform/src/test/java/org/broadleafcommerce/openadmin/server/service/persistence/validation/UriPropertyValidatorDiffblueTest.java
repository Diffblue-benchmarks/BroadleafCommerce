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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {UriPropertyValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UriPropertyValidatorDiffblueTest {
  @Autowired private UriPropertyValidator uriPropertyValidator;

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   *
   * <ul>
   *   <li>When {@code ftp}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UriPropertyValidator.isFullUrl(String)"})
  public void testIsFullUrl_whenFtp_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uriPropertyValidator.isFullUrl("ftp"));
  }

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UriPropertyValidator.isFullUrl(String)"})
  public void testIsFullUrl_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uriPropertyValidator.isFullUrl("https://example.org/example"));
  }

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   *
   * <ul>
   *   <li>When {@code Url}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UriPropertyValidator.isFullUrl(String)"})
  public void testIsFullUrl_whenUrl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(uriPropertyValidator.isFullUrl("Url"));
  }

  /**
   * Test {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult UriPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenNull_thenReturnErrorMessageIsNull() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        uriPropertyValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            null);

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata,
   * String, String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return ErrorMessages size is one.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult UriPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenSpace_thenReturnErrorMessagesSizeIsOne() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        uriPropertyValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            " ");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("uriPropertyValidatorCannotContainSpacesError", errorMessages.get(0));
    assertEquals(
        "uriPropertyValidatorCannotContainSpacesError", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UriPropertyValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link UriPropertyValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UriPropertyValidator.isSucceedForNullValues()",
    "void UriPropertyValidator.setSucceedForNullValues(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    UriPropertyValidator uriPropertyValidator = new UriPropertyValidator();

    // Act
    uriPropertyValidator.setSucceedForNullValues(true);

    // Assert
    assertTrue(uriPropertyValidator.isSucceedForNullValues());
  }
}
