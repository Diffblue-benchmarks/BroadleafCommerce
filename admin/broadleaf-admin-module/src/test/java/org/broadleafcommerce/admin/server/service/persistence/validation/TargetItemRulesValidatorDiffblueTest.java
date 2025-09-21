/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.persistence.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PropertyValidationResult;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TargetItemRulesValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TargetItemRulesValidatorDiffblueTest {
  @Autowired private TargetItemRulesValidator targetItemRulesValidator;

  /**
   * Test {@link TargetItemRulesValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>When {@code org.broadleafcommerce.core.offer.domain.Offer}.
   * </ul>
   *
   * <p>Method under test: {@link TargetItemRulesValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult TargetItemRulesValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenOrgBroadleafcommerceCoreOfferDomainOffer() {
    // Arrange
    Entity entity = new Entity();
    OfferImpl instance = new OfferImpl();
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        targetItemRulesValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "org.broadleafcommerce.core.offer.domain.Offer",
            "42");

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link TargetItemRulesValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>When {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link TargetItemRulesValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult TargetItemRulesValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenPropertyName() {
    // Arrange
    Entity entity = new Entity();
    OfferImpl instance = new OfferImpl();
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        targetItemRulesValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }
}
