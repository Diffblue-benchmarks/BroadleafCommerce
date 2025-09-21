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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionHandler;
import org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdornedTargetMaintainedFieldPropertyValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdornedTargetMaintainedFieldPropertyValidatorDiffblueTest {
  @MockBean(name = "blAdornedTargetAutoPopulateExtensionManager")
  private AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;

  @Autowired
  private AdornedTargetMaintainedFieldPropertyValidator
      adornedTargetMaintainedFieldPropertyValidator;

  /**
   * Test {@link AdornedTargetMaintainedFieldPropertyValidator#validate(Entity, Serializable, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <p>Method under test: {@link AdornedTargetMaintainedFieldPropertyValidator#validate(Entity,
   * Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult AdornedTargetMaintainedFieldPropertyValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate() {
    // Arrange
    AdornedTargetAutoPopulateExtensionHandler adornedTargetAutoPopulateExtensionHandler =
        mock(AdornedTargetAutoPopulateExtensionHandler.class);
    when(adornedTargetAutoPopulateExtensionHandler.validateSubmittedAdornedTargetManagedFields(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<BasicFieldMetadata>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adornedTargetAutoPopulateExtensionManager.getProxy())
        .thenReturn(adornedTargetAutoPopulateExtensionHandler);
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        adornedTargetMaintainedFieldPropertyValidator.validate(
            entity, instance, entityFieldMetadata, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(adornedTargetAutoPopulateExtensionManager).getProxy();
    verify(adornedTargetAutoPopulateExtensionHandler)
        .validateSubmittedAdornedTargetManagedFields(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(BasicFieldMetadata.class),
            eq("Property Name"),
            eq("42"),
            isA(ExtensionResultHolder.class));
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("adornedTargetMaintainedFieldValidationFailure", errorMessages.get(0));
    assertEquals(
        "adornedTargetMaintainedFieldValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link AdornedTargetMaintainedFieldPropertyValidator#validate(Entity, Serializable, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <p>Method under test: {@link AdornedTargetMaintainedFieldPropertyValidator#validate(Entity,
   * Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult AdornedTargetMaintainedFieldPropertyValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate2() {
    // Arrange
    AdornedTargetAutoPopulateExtensionHandler adornedTargetAutoPopulateExtensionHandler =
        mock(AdornedTargetAutoPopulateExtensionHandler.class);
    when(adornedTargetAutoPopulateExtensionHandler.validateSubmittedAdornedTargetManagedFields(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<BasicFieldMetadata>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(adornedTargetAutoPopulateExtensionManager.getProxy())
        .thenReturn(adornedTargetAutoPopulateExtensionHandler);
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        adornedTargetMaintainedFieldPropertyValidator.validate(
            entity, instance, entityFieldMetadata, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(adornedTargetAutoPopulateExtensionManager).getProxy();
    verify(adornedTargetAutoPopulateExtensionHandler)
        .validateSubmittedAdornedTargetManagedFields(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(BasicFieldMetadata.class),
            eq("Property Name"),
            eq("42"),
            isA(ExtensionResultHolder.class));
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("adornedTargetMaintainedFieldValidationFailure", errorMessages.get(0));
    assertEquals(
        "adornedTargetMaintainedFieldValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }
}
