/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.dao.ProductOptionDao;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationType;
import org.broadleafcommerce.core.order.service.call.ActivityMessageDTO;
import org.broadleafcommerce.core.order.service.exception.ProductOptionValidationException;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.workflow.ActivityMessages;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductOptionValidationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionValidationServiceImplDiffblueTest {
  @MockBean private ProductOptionDao productOptionDao;

  @Autowired private ProductOptionValidationServiceImpl productOptionValidationServiceImpl;

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@code not empty}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_givenArrayList_whenNotEmpty_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");

    // Act and Assert
    assertTrue(productOptionValidationServiceImpl.validate(productOption, "not empty"));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_givenFalse() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertThrows(
        ProductOptionValidationException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, "42"));
    verify(productOption).getAttributeName();
    verify(productOption).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getRequired()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_givenFalse_whenProductOptionImplGetRequiredReturnFalse() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);

    // Act
    Boolean actualValidateResult = productOptionValidationServiceImpl.validate(productOption, null);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_givenProductOptionValidationServiceImpl() {
    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl =
        new ProductOptionValidationServiceImpl();

    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName(null);
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, ""));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationType#ProductOptionValidationType(String, String)}
   *       with {@code Type} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_givenProductOptionValidationTypeWithTypeAndFriendlyType() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(new ProductOptionValidationType("Type", "Friendly Type"));

    // Act
    Boolean actualValidateResult = productOptionValidationServiceImpl.validate(productOption, "42");

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, ""));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getErrorMessage()} return {@code
   *       An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_whenProductOptionImplGetErrorMessageReturnAnErrorOccurred() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertThrows(
        ProductOptionValidationException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, "42"));
    verify(productOption).getAttributeName();
    verify(productOption).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getErrorMessage()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_whenProductOptionImplGetErrorMessageReturnNull() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn(null);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertThrows(
        ProductOptionValidationException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, "42"));
    verify(productOption).getAttributeName();
    verify(productOption).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getValidationString()} return
   *       {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validate(ProductOption,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validate(ProductOption, String)"})
  public void testValidate_whenProductOptionImplGetValidationStringReturnNull_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn(null);
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);

    // Act
    Boolean actualValidateResult = productOptionValidationServiceImpl.validate(productOption, "42");

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.isRequiredAttributeNotProvided(ProductOption, String)"
  })
  public void testIsRequiredAttributeNotProvided_givenFalse() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);

    // Act
    boolean actualIsRequiredAttributeNotProvidedResult =
        productOptionValidationServiceImpl.isRequiredAttributeNotProvided(productOption, "42");

    // Assert
    verify(productOption).getRequired();
    assertFalse(actualIsRequiredAttributeNotProvidedResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.isRequiredAttributeNotProvided(ProductOption, String)"
  })
  public void testIsRequiredAttributeNotProvided_givenTrue_thenReturnFalse() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);

    // Act
    boolean actualIsRequiredAttributeNotProvidedResult =
        productOptionValidationServiceImpl.isRequiredAttributeNotProvided(productOption, "42");

    // Assert
    verify(productOption).getRequired();
    assertFalse(actualIsRequiredAttributeNotProvidedResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.isRequiredAttributeNotProvided(ProductOption, String)"
  })
  public void testIsRequiredAttributeNotProvided_givenTrue_whenEmptyString_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);

    // Act
    boolean actualIsRequiredAttributeNotProvidedResult =
        productOptionValidationServiceImpl.isRequiredAttributeNotProvided(productOption, "");

    // Assert
    verify(productOption).getRequired();
    assertTrue(actualIsRequiredAttributeNotProvidedResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.requiresValidation(ProductOption, String)"
  })
  public void testRequiresValidation_givenEmptyString() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("");

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.requiresValidation(productOption, "not empty"));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getRequired()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.requiresValidation(ProductOption, String)"
  })
  public void testRequiresValidation_givenFalse_whenProductOptionImplGetRequiredReturnFalse() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);

    // Act
    boolean actualRequiresValidationResult =
        productOptionValidationServiceImpl.requiresValidation(productOption, "42");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertTrue(actualRequiresValidationResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getRequired()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.requiresValidation(ProductOption, String)"
  })
  public void testRequiresValidation_givenFalse_whenProductOptionImplGetRequiredReturnFalse2() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);

    // Act
    boolean actualRequiresValidationResult =
        productOptionValidationServiceImpl.requiresValidation(productOption, "");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertFalse(actualRequiresValidationResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@code not empty}.
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.requiresValidation(ProductOption, String)"
  })
  public void testRequiresValidation_givenNotEmpty_whenEmptyString_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");

    // Act and Assert
    assertTrue(productOptionValidationServiceImpl.requiresValidation(productOption, ""));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@code not empty}.
   *   <li>When {@code not empty}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.requiresValidation(ProductOption, String)"
  })
  public void testRequiresValidation_givenNotEmpty_whenNotEmpty_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");

    // Act and Assert
    assertTrue(productOptionValidationServiceImpl.requiresValidation(productOption, "not empty"));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@code not empty}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.requiresValidation(ProductOption, String)"
  })
  public void testRequiresValidation_givenNotEmpty_whenNull_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");

    // Act and Assert
    assertTrue(productOptionValidationServiceImpl.requiresValidation(productOption, null));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationType#ProductOptionValidationType(String, String)}
   *       with {@code Type} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.requiresValidation(ProductOption, String)"
  })
  public void testRequiresValidation_givenProductOptionValidationTypeWithTypeAndFriendlyType() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(new ProductOptionValidationType("Type", "Friendly Type"));

    // Act
    boolean actualRequiresValidationResult =
        productOptionValidationServiceImpl.requiresValidation(productOption, "42");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertFalse(actualRequiresValidationResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}.
   *
   * <ul>
   *   <li>When {@code .*}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validateRegex(String, String)"})
  public void testValidateRegex_whenDotAsterisk_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productOptionValidationServiceImpl.validateRegex(".*", null));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}.
   *
   * <ul>
   *   <li>When {@code .*}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validateRegex(String, String)"})
  public void testValidateRegex_whenDotAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(productOptionValidationServiceImpl.validateRegex(".*", "42"));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}.
   *
   * <ul>
   *   <li>When {@code Regex}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionValidationServiceImpl.validateRegex(String, String)"})
  public void testValidateRegex_whenRegex_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productOptionValidationServiceImpl.validateRegex("Regex", "42"));
  }

  /**
   * Test {@link
   * ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#ADD_ITEM}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.hasProductOptionValidationStrategy(ProductOption)"
  })
  public void testHasProductOptionValidationStrategy_givenAdd_item_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);

    // Act and Assert
    assertTrue(
        productOptionValidationServiceImpl.hasProductOptionValidationStrategy(productOption));
  }

  /**
   * Test {@link
   * ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationServiceImpl.hasProductOptionValidationStrategy(ProductOption)"
  })
  public void testHasProductOptionValidationStrategy_whenProductOptionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        productOptionValidationServiceImpl.hasProductOptionValidationStrategy(
            new ProductOptionImpl()));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#ADD_ITEM}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionValidationServiceImpl.isSubmitType(ProductOption)"})
  public void testIsSubmitType_givenAdd_item() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.isSubmitType(productOption));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#SUBMIT_ORDER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionValidationServiceImpl.isSubmitType(ProductOption)"})
  public void testIsSubmitType_givenSubmit_order_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.SUBMIT_ORDER);

    // Act and Assert
    assertTrue(productOptionValidationServiceImpl.isSubmitType(productOption));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionValidationServiceImpl.isSubmitType(ProductOption)"})
  public void testIsSubmitType_whenProductOptionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productOptionValidationServiceImpl.isSubmitType(new ProductOptionImpl()));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#ADD_ITEM}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionValidationServiceImpl.isAddOrNoneType(ProductOption)"})
  public void testIsAddOrNoneType_givenAdd_item_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);

    // Act and Assert
    assertTrue(productOptionValidationServiceImpl.isAddOrNoneType(productOption));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#SUBMIT_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionValidationServiceImpl.isAddOrNoneType(ProductOption)"})
  public void testIsAddOrNoneType_givenSubmit_order() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.SUBMIT_ORDER);

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.isAddOrNoneType(productOption));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionValidationServiceImpl.isAddOrNoneType(ProductOption)"})
  public void testIsAddOrNoneType_whenProductOptionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productOptionValidationServiceImpl.isAddOrNoneType(new ProductOptionImpl()));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "", messages);

    // Assert
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals("REQUIRED_ATTRIBUTE", getResult.getErrorCode());
    assertEquals("Required attribute, Attribute Name, not provided", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException2() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, null, messages);

    // Assert
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals("REQUIRED_ATTRIBUTE", getResult.getErrorCode());
    assertEquals("Required attribute, Attribute Name, not provided", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException3() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("An error occurred", getResult.getErrorCode());
    assertEquals("An error occurred", getResult.getMessage());
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException4() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getAttributeName())
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    verify(productOption).getAttributeName();
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals("REQUIRED_ATTRIBUTE", getResult.getErrorCode());
    assertEquals("The attribute Attribute Name was not provided", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException5() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorMessage())
        .thenThrow(new RequiredAttributeNotProvidedException("Value ["));
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals("REQUIRED_ATTRIBUTE", getResult.getErrorCode());
    assertEquals("The attribute Value [ was not provided", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException6() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("");
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption, atLeast(1)).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("An error occurred", getResult.getErrorCode());
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals(
        "Value [42] does not match regex string [Validation String]", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException7() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption, atLeast(1)).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("An error occurred", getResult.getErrorCode());
    assertEquals("An error occurred", getResult.getMessage());
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException8() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert that nothing has changed
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(messages.getActivityMessages().isEmpty());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException9() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(new ProductOptionValidationType("Type", "Friendly Type"));
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert that nothing has changed
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(messages.getActivityMessages().isEmpty());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException10() {
    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl =
        new ProductOptionValidationServiceImpl();

    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName(null);
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "", messages);

    // Assert
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals("REQUIRED_ATTRIBUTE", getResult.getErrorCode());
    assertEquals("Required attribute, NULL, not provided", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException_givenFalse() {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(ProductOptionValidationType.REGEX);
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, null, messages);

    // Assert that nothing has changed
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(messages.getActivityMessages().isEmpty());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationServiceImpl.validateWithoutException(ProductOption, String, ActivityMessages)"
  })
  public void testValidateWithoutException_whenNotEmpty() {
    // Arrange
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("not empty");
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(
        productOption, "not empty", messages);

    // Assert that nothing has changed
    assertTrue(messages.getActivityMessages().isEmpty());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String,
   * String, List)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductOptionValidationServiceImpl.findSkuIdsForProductOptionValues(Long, String, String, List)"
  })
  public void testFindSkuIdsForProductOptionValues() {
    // Arrange
    when(productOptionDao.readSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () ->
            productOptionValidationServiceImpl.findSkuIdsForProductOptionValues(
                1L, "Attribute Name", "42", new ArrayList<>()));
    verify(productOptionDao)
        .readSkuIdsForProductOptionValues(eq(1L), eq("Attribute Name"), eq("42"), isA(List.class));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String,
   * String, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductOptionValidationServiceImpl.findSkuIdsForProductOptionValues(Long, String, String, List)"
  })
  public void testFindSkuIdsForProductOptionValues_givenOne_whenArrayListAddOne() {
    // Arrange
    when(productOptionDao.readSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> possibleSkuIds = new ArrayList<>();
    possibleSkuIds.add(1L);

    // Act
    List<Long> actualFindSkuIdsForProductOptionValuesResult =
        productOptionValidationServiceImpl.findSkuIdsForProductOptionValues(
            1L, "Attribute Name", "42", possibleSkuIds);

    // Assert
    verify(productOptionDao)
        .readSkuIdsForProductOptionValues(eq(1L), eq("Attribute Name"), eq("42"), isA(List.class));
    assertTrue(actualFindSkuIdsForProductOptionValuesResult.isEmpty());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String,
   * String, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductOptionValidationServiceImpl.findSkuIdsForProductOptionValues(Long, String, String, List)"
  })
  public void testFindSkuIdsForProductOptionValues_givenZero_whenArrayListAddZero() {
    // Arrange
    when(productOptionDao.readSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> possibleSkuIds = new ArrayList<>();
    possibleSkuIds.add(0L);
    possibleSkuIds.add(1L);

    // Act
    List<Long> actualFindSkuIdsForProductOptionValuesResult =
        productOptionValidationServiceImpl.findSkuIdsForProductOptionValues(
            1L, "Attribute Name", "42", possibleSkuIds);

    // Assert
    verify(productOptionDao)
        .readSkuIdsForProductOptionValues(eq(1L), eq("Attribute Name"), eq("42"), isA(List.class));
    assertTrue(actualFindSkuIdsForProductOptionValuesResult.isEmpty());
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String,
   * String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValidationServiceImpl#findSkuIdsForProductOptionValues(Long, String, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductOptionValidationServiceImpl.findSkuIdsForProductOptionValues(Long, String, String, List)"
  })
  public void testFindSkuIdsForProductOptionValues_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(productOptionDao.readSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Long> actualFindSkuIdsForProductOptionValuesResult =
        productOptionValidationServiceImpl.findSkuIdsForProductOptionValues(
            1L, "Attribute Name", "42", new ArrayList<>());

    // Assert
    verify(productOptionDao)
        .readSkuIdsForProductOptionValues(eq(1L), eq("Attribute Name"), eq("42"), isA(List.class));
    assertTrue(actualFindSkuIdsForProductOptionValuesResult.isEmpty());
  }
}
