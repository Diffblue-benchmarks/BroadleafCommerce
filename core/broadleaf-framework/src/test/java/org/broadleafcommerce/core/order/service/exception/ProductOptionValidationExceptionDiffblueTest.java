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
package org.broadleafcommerce.core.order.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductOptionValidationException.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionValidationExceptionDiffblueTest {
  @Autowired
  private ProductOptionValidationException productOptionValidationException;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProductOptionValidationException#ProductOptionValidationException()}
   *   <li>{@link ProductOptionValidationException#setAttributeName(String)}
   *   <li>{@link ProductOptionValidationException#setAttributeValue(String)}
   *   <li>{@link ProductOptionValidationException#setErrorCode(String)}
   *   <li>{@link ProductOptionValidationException#setErrorMessage(String)}
   *   <li>{@link ProductOptionValidationException#setValidationString(String)}
   *   <li>{@link ProductOptionValidationException#getAttributeName()}
   *   <li>{@link ProductOptionValidationException#getAttributeValue()}
   *   <li>{@link ProductOptionValidationException#getErrorCode()}
   *   <li>{@link ProductOptionValidationException#getErrorMessage()}
   *   <li>{@link ProductOptionValidationException#getValidationString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductOptionValidationException actualProductOptionValidationException = new ProductOptionValidationException();
    actualProductOptionValidationException.setAttributeName("Attribute Name");
    actualProductOptionValidationException.setAttributeValue("42");
    actualProductOptionValidationException.setErrorCode("An error occurred");
    actualProductOptionValidationException.setErrorMessage("An error occurred");
    actualProductOptionValidationException.setValidationString("Validation String");
    String actualAttributeName = actualProductOptionValidationException.getAttributeName();
    String actualAttributeValue = actualProductOptionValidationException.getAttributeValue();
    String actualErrorCode = actualProductOptionValidationException.getErrorCode();
    String actualErrorMessage = actualProductOptionValidationException.getErrorMessage();

    // Assert that nothing has changed
    assertEquals("42", actualAttributeValue);
    assertEquals("An error occurred", actualErrorCode);
    assertEquals("An error occurred", actualErrorMessage);
    assertEquals("Attribute Name", actualAttributeName);
    assertEquals("Validation String", actualProductOptionValidationException.getValidationString());
    assertEquals(0, actualProductOptionValidationException.getSuppressed().length);
  }

  /**
   * Test
   * {@link ProductOptionValidationException#ProductOptionValidationException(String, String, String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationException#ProductOptionValidationException(String, String, String, String, String, String)}
   */
  @Test
  public void testNewProductOptionValidationException() {
    // Arrange and Act
    ProductOptionValidationException actualProductOptionValidationException = new ProductOptionValidationException(
        "An error occurred", "An error occurred", "Attribute Name", "42", "Validation String", "An error occurred");

    // Assert
    assertEquals("42", actualProductOptionValidationException.getAttributeValue());
    assertEquals("An error occurred", actualProductOptionValidationException.getLocalizedMessage());
    assertEquals("An error occurred", actualProductOptionValidationException.getMessage());
    assertEquals("An error occurred", actualProductOptionValidationException.getErrorCode());
    assertEquals("An error occurred", actualProductOptionValidationException.getErrorMessage());
    assertEquals("Attribute Name", actualProductOptionValidationException.getAttributeName());
    assertEquals("Validation String", actualProductOptionValidationException.getValidationString());
    assertNull(actualProductOptionValidationException.getCause());
    assertEquals(0, actualProductOptionValidationException.getSuppressed().length);
  }

  /**
   * Test
   * {@link ProductOptionValidationException#ProductOptionValidationException(String, String, String, String, String, String, Throwable)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationException#ProductOptionValidationException(String, String, String, String, String, String, Throwable)}
   */
  @Test
  public void testNewProductOptionValidationException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProductOptionValidationException actualProductOptionValidationException = new ProductOptionValidationException(
        "An error occurred", "An error occurred", "Attribute Name", "42", "Validation String", "An error occurred",
        cause);

    // Assert
    assertEquals("42", actualProductOptionValidationException.getAttributeValue());
    assertEquals("An error occurred", actualProductOptionValidationException.getLocalizedMessage());
    assertEquals("An error occurred", actualProductOptionValidationException.getMessage());
    assertEquals("An error occurred", actualProductOptionValidationException.getErrorCode());
    assertEquals("An error occurred", actualProductOptionValidationException.getErrorMessage());
    assertEquals("Attribute Name", actualProductOptionValidationException.getAttributeName());
    assertEquals("Validation String", actualProductOptionValidationException.getValidationString());
    assertEquals(0, actualProductOptionValidationException.getSuppressed().length);
    assertSame(cause, actualProductOptionValidationException.getCause());
  }
}
