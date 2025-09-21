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
package org.broadleafcommerce.admin.persistence.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PropertyValidationResult;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductBundleSkuBundleItemValidatorDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private ProductBundleSkuBundleItemValidator productBundleSkuBundleItemValidator;

  @Mock private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   *   <li>Then calls {@link Entity#findProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable,
   * Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult ProductBundleSkuBundleItemValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenNull_whenEntityFindPropertyReturnNull_thenCallsFindProperty() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        productBundleSkuBundleItemValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable,
   * Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult ProductBundleSkuBundleItemValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyGetValueReturnNull_thenCallsGetValue() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        productBundleSkuBundleItemValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable,
   * Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult ProductBundleSkuBundleItemValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyWithNameAndValueIsNull() {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        productBundleSkuBundleItemValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SandBoxHelper#getOriginalId(Class, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable,
   * Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult ProductBundleSkuBundleItemValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_thenCallsGetOriginalId() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        productBundleSkuBundleItemValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Class.class), isNull());
    verify(productBundleImpl).getDefaultSku();
    verify(catalogService).findProductById(42L);
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then return ErrorMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleSkuBundleItemValidator#validate(Entity, Serializable,
   * Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult ProductBundleSkuBundleItemValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenEntity_thenReturnErrorMessageIsNull() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        productBundleSkuBundleItemValidator.validate(
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
