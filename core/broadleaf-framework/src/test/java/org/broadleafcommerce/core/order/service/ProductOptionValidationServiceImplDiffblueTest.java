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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate2() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate3() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate4() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate5() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate6() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate7() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate8() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validate(ProductOption, String)}
   */
  @Test
  public void testValidate9() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  public void testIsRequiredAttributeNotProvided() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  public void testIsRequiredAttributeNotProvided2() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isRequiredAttributeNotProvided(ProductOption, String)}
   */
  @Test
  public void testIsRequiredAttributeNotProvided3() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation2() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation3() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation4() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation5() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation6() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation7() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#requiresValidation(ProductOption, String)}
   */
  @Test
  public void testRequiresValidation8() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateRegex(String, String)}
   */
  @Test
  public void testValidateRegex() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductOptionValidationServiceImpl()).validateRegex(".*", "42"));
    assertFalse((new ProductOptionValidationServiceImpl()).validateRegex(".*", null));
    assertFalse((new ProductOptionValidationServiceImpl()).validateRegex("Regex", "42"));
  }

  /**
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}
   */
  @Test
  public void testHasProductOptionValidationStrategy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.hasProductOptionValidationStrategy(new ProductOptionImpl()));
  }

  /**
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#hasProductOptionValidationStrategy(ProductOption)}
   */
  @Test
  public void testHasProductOptionValidationStrategy2() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.isSubmitType(new ProductOptionImpl()));
  }

  /**
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType2() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType3() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isSubmitType(ProductOption)}
   */
  @Test
  public void testIsSubmitType4() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationServiceImpl productOptionValidationServiceImpl = new ProductOptionValidationServiceImpl();

    // Act and Assert
    assertFalse(productOptionValidationServiceImpl.isAddOrNoneType(new ProductOptionImpl()));
  }

  /**
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType2() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType3() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#isAddOrNoneType(ProductOption)}
   */
  @Test
  public void testIsAddOrNoneType4() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException2() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException3() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException4() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException5() {
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

  /**
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException6() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException7() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException8() {
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
   * Method under test:
   * {@link ProductOptionValidationServiceImpl#validateWithoutException(ProductOption, String, ActivityMessages)}
   */
  @Test
  public void testValidateWithoutException9() {
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
}
