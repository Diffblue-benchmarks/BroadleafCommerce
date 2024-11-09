/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
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

public class ProductOptionValidationServiceImplDiffblueTest {
  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ProductOptionImpl}
   * {@link ProductOptionImpl#getValidationString()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_given42_whenProductOptionImplGetValidationStringReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("42");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

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
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("");
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertThrows(ProductOptionValidationException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, "42"));
    verify(productOption).getAttributeName();
    verify(productOption).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertThrows(ProductOptionValidationException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, "42"));
    verify(productOption).getAttributeName();
    verify(productOption).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getRequired()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_givenFalse_whenProductOptionImplGetRequiredReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

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
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ProductOptionImpl}
   * {@link ProductOptionImpl#getErrorMessage()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_givenNull_whenProductOptionImplGetErrorMessageReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn(null);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertThrows(ProductOptionValidationException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, "42"));
    verify(productOption).getAttributeName();
    verify(productOption).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ProductOptionImpl}
   * {@link ProductOptionImpl#getValidationString()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_givenNull_whenProductOptionImplGetValidationStringReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn(null);
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

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
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given
   * {@link ProductOptionValidationType#ProductOptionValidationType(String, String)}
   * with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_givenProductOptionValidationTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
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
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_givenTrue_whenNull_thenThrowRequiredAttributeNotProvidedException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, null));
    verify(productOption).getAttributeName();
    verify(productOption).getRequired();
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl}
   * {@link ProductOptionImpl#getErrorMessage()} return
   * {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate_whenProductOptionImplGetErrorMessageReturnAnErrorOccurred() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertThrows(ProductOptionValidationException.class,
        () -> productOptionValidationServiceImpl.validate(productOption, "42"));
    verify(productOption).getAttributeName();
    verify(productOption).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  public void testIsRequiredAttributeNotProvided_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);

    // Act
    boolean actualIsRequiredAttributeNotProvidedResult = productOptionValidationServiceImpl
        .isRequiredAttributeNotProvided(productOption, "42");

    // Assert
    verify(productOption).getRequired();
    assertFalse(actualIsRequiredAttributeNotProvidedResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  public void testIsRequiredAttributeNotProvided_givenTrue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);

    // Act
    boolean actualIsRequiredAttributeNotProvidedResult = productOptionValidationServiceImpl
        .isRequiredAttributeNotProvided(productOption, "42");

    // Assert
    verify(productOption).getRequired();
    assertFalse(actualIsRequiredAttributeNotProvidedResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  public void testIsRequiredAttributeNotProvided_givenTrue_whenEmptyString_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);

    // Act
    boolean actualIsRequiredAttributeNotProvidedResult = productOptionValidationServiceImpl
        .isRequiredAttributeNotProvided(productOption, "");

    // Assert
    verify(productOption).getRequired();
    assertTrue(actualIsRequiredAttributeNotProvidedResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getValidationString()).thenReturn("");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act
    boolean actualRequiresValidationResult = productOptionValidationServiceImpl.requiresValidation(productOption, "42");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertFalse(actualRequiresValidationResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_givenFalse_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act
    boolean actualRequiresValidationResult = productOptionValidationServiceImpl.requiresValidation(productOption, "");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertFalse(actualRequiresValidationResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getRequired()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_givenFalse_whenProductOptionImplGetRequiredReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act
    boolean actualRequiresValidationResult = productOptionValidationServiceImpl.requiresValidation(productOption, "42");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertTrue(actualRequiresValidationResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ProductOptionImpl} (default constructor) ValidationString is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_givenNull_whenProductOptionImplValidationStringIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString(null);

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.requiresValidation(productOption, null));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ProductOptionImpl} (default constructor) ValidationString is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_givenNull_whenProductOptionImplValidationStringIsNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString(null);

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.requiresValidation(productOption, "42"));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>Given {@code Product Option}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_givenProductOption() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    ProductOptionImpl productOption = new ProductOptionImpl();
    productOption.setAllowedValues(new ArrayList<>());
    productOption.setAttributeName("Attribute Name");
    productOption.setDisplayOrder(1);
    productOption.setErrorCode("An error occurred");
    productOption.setErrorMessage("An error occurred");
    productOption.setId(1L);
    productOption.setLabel("Label");
    productOption.setName("Name");
    productOption.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOption.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOption.setProductXrefs(new ArrayList<>());
    productOption.setRequired(true);
    productOption.setType(ProductOptionType.BOOLEAN);
    productOption.setUseInSkuGeneration(true);
    productOption.setValidationString("Product Option");

    // Act and Assert
    assertTrue(productOptionValidationServiceImpl.requiresValidation(productOption, null));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>Given
   * {@link ProductOptionValidationType#ProductOptionValidationType(String, String)}
   * with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_givenProductOptionValidationTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(new ProductOptionValidationType("Type", "Friendly Type"));

    // Act
    boolean actualRequiresValidationResult = productOptionValidationServiceImpl.requiresValidation(productOption, "42");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertFalse(actualRequiresValidationResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} {@link ProductOptionImpl#getRequired()}
   * return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation_whenProductOptionImplGetRequiredReturnTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);

    // Act
    boolean actualRequiresValidationResult = productOptionValidationServiceImpl.requiresValidation(productOption, "42");

    // Assert
    verify(productOption).getProductOptionValidationType();
    verify(productOption).getRequired();
    verify(productOption).getValidationString();
    assertTrue(actualRequiresValidationResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}.
   * <ul>
   *   <li>When {@code .*}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}
   */
  @Test
  public void testValidateRegex_whenDotAsterisk_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductOptionValidationServiceImpl()).validateRegex(".*", null));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}.
   * <ul>
   *   <li>When {@code .*}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}
   */
  @Test
  public void testValidateRegex_whenDotAsterisk_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductOptionValidationServiceImpl()).validateRegex(".*", "42"));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}.
   * <ul>
   *   <li>When {@code Regex}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}
   */
  @Test
  public void testValidateRegex_whenRegex_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductOptionValidationServiceImpl()).validateRegex("Regex", "42"));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}.
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#ADD_ITEM}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}
   */
  @Test
  public void testHasProductOptionValidationStrategy_givenAdd_item_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOption productOption = mock(ProductOption.class);
    when(productOption.getProductOptionValidationStrategyType())
        .thenReturn(ProductOptionValidationStrategyType.ADD_ITEM);

    // Act
    boolean actualHasProductOptionValidationStrategyResult = productOptionValidationServiceImpl
        .hasProductOptionValidationStrategy(productOption);

    // Assert
    verify(productOption).getProductOptionValidationStrategyType();
    assertTrue(actualHasProductOptionValidationStrategyResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}
   */
  @Test
  public void testHasProductOptionValidationStrategy_whenProductOptionImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.hasProductOptionValidationStrategy(new ProductOptionImpl()));
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}.
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#ADD_ITEM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType_givenAdd_item() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOption productOption = mock(ProductOption.class);
    when(productOption.getProductOptionValidationStrategyType())
        .thenReturn(ProductOptionValidationStrategyType.ADD_ITEM);

    // Act
    boolean actualIsSubmitTypeResult = productOptionValidationServiceImpl.isSubmitType(productOption);

    // Assert
    verify(productOption, atLeast(1)).getProductOptionValidationStrategyType();
    assertFalse(actualIsSubmitTypeResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}.
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#SUBMIT_ORDER}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType_givenSubmit_order_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOption productOption = mock(ProductOption.class);
    when(productOption.getProductOptionValidationStrategyType())
        .thenReturn(ProductOptionValidationStrategyType.SUBMIT_ORDER);

    // Act
    boolean actualIsSubmitTypeResult = productOptionValidationServiceImpl.isSubmitType(productOption);

    // Assert
    verify(productOption, atLeast(1)).getProductOptionValidationStrategyType();
    assertTrue(actualIsSubmitTypeResult);
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType_thenThrowRequiredAttributeNotProvidedException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionValidationStrategyType productOptionValidationStrategyType = mock(
        ProductOptionValidationStrategyType.class);
    when(productOptionValidationStrategyType.getRank())
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    ProductOption productOption = mock(ProductOption.class);
    when(productOption.getProductOptionValidationStrategyType()).thenReturn(productOptionValidationStrategyType);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> productOptionValidationServiceImpl.isSubmitType(productOption));
    verify(productOption, atLeast(1)).getProductOptionValidationStrategyType();
    verify(productOptionValidationStrategyType).getRank();
  }

  /**
   * Test {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType_whenProductOptionImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.isSubmitType(new ProductOptionImpl()));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}.
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#ADD_ITEM}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType_givenAdd_item_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOption productOption = mock(ProductOption.class);
    when(productOption.getProductOptionValidationStrategyType())
        .thenReturn(ProductOptionValidationStrategyType.ADD_ITEM);

    // Act
    boolean actualIsAddOrNoneTypeResult = productOptionValidationServiceImpl.isAddOrNoneType(productOption);

    // Assert
    verify(productOption, atLeast(1)).getProductOptionValidationStrategyType();
    assertTrue(actualIsAddOrNoneTypeResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}.
   * <ul>
   *   <li>Given {@link ProductOptionValidationStrategyType#SUBMIT_ORDER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType_givenSubmit_order() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOption productOption = mock(ProductOption.class);
    when(productOption.getProductOptionValidationStrategyType())
        .thenReturn(ProductOptionValidationStrategyType.SUBMIT_ORDER);

    // Act
    boolean actualIsAddOrNoneTypeResult = productOptionValidationServiceImpl.isAddOrNoneType(productOption);

    // Assert
    verify(productOption, atLeast(1)).getProductOptionValidationStrategyType();
    assertFalse(actualIsAddOrNoneTypeResult);
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType_thenThrowRequiredAttributeNotProvidedException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionValidationStrategyType productOptionValidationStrategyType = mock(
        ProductOptionValidationStrategyType.class);
    when(productOptionValidationStrategyType.getRank())
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    ProductOption productOption = mock(ProductOption.class);
    when(productOption.getProductOptionValidationStrategyType()).thenReturn(productOptionValidationStrategyType);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> productOptionValidationServiceImpl.isAddOrNoneType(productOption));
    verify(productOption, atLeast(1)).getProductOptionValidationStrategyType();
    verify(productOptionValidationStrategyType).getRank();
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType_whenProductOptionImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.isAddOrNoneType(new ProductOptionImpl()));
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);
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
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType())
        .thenReturn(new ProductOptionValidationType("Type", "Friendly Type"));
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(messages.getActivityMessages().isEmpty());
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, null, messages);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getRequired();
    List<ActivityMessageDTO> activityMessages = messages.getActivityMessages();
    assertEquals(1, activityMessages.size());
    ActivityMessageDTO getResult = activityMessages.get(0);
    assertEquals("PRODUCT_OPTION", getResult.getType());
    assertEquals("REQUIRED_ATTRIBUTE", getResult.getErrorCode());
    assertEquals("Required attribute, Attribute Name, not provided", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException_given42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("42");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(messages.getActivityMessages().isEmpty());
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("");
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);
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
    assertEquals("Value [42] does not match regex string [Validation String]", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(false);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);
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
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException_thenThrowRequiredAttributeNotProvidedException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn("An error occurred");
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);
    ActivityMessages messages = mock(ActivityMessages.class);
    when(messages.getActivityMessages()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages));
    verify(productOption).getAttributeName();
    verify(productOption, atLeast(1)).getErrorCode();
    verify(productOption).getErrorMessage();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    verify(messages).getActivityMessages();
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl}
   * {@link ProductOptionImpl#getErrorMessage()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException_whenProductOptionImplGetErrorMessageReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getErrorCode()).thenReturn("An error occurred");
    when(productOption.getErrorMessage()).thenReturn(null);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn("Validation String");
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);
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
    assertEquals("Value [42] does not match regex string [Validation String]", getResult.getMessage());
    assertEquals(1, getResult.getPriority().intValue());
  }

  /**
   * Test
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl}
   * {@link ProductOptionImpl#getValidationString()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException_whenProductOptionImplGetValidationStringReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.getRequired()).thenReturn(true);
    when(productOption.getAttributeName()).thenReturn("Attribute Name");
    when(productOption.getValidationString()).thenReturn(null);
    when(productOption.getProductOptionValidationType()).thenReturn(ProductOptionValidationType.REGEX);
    DefaultProcessContextImpl<Object> messages = new DefaultProcessContextImpl<>();

    // Act
    productOptionValidationServiceImpl.validateWithoutException(productOption, "42", messages);

    // Assert
    verify(productOption).getAttributeName();
    verify(productOption).getProductOptionValidationType();
    verify(productOption, atLeast(1)).getRequired();
    verify(productOption, atLeast(1)).getValidationString();
    assertTrue(messages.getActivityMessages().isEmpty());
  }
}
