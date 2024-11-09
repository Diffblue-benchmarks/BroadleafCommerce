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
import org.springframework.boot.test.mock.mockito.MockBean;

public class RequiredAttributeNotProvidedExceptionDiffblueTest {
  @MockBean
  private RequiredAttributeNotProvidedException requiredAttributeNotProvidedException;

  /**
   * Test
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String)}.
   * <p>
   * Method under test:
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String)}
   */
  @Test
  public void testNewRequiredAttributeNotProvidedException() {
    // Arrange and Act
    RequiredAttributeNotProvidedException actualRequiredAttributeNotProvidedException = new RequiredAttributeNotProvidedException(
        "Attribute Name");

    // Assert
    assertEquals("Attribute Name", actualRequiredAttributeNotProvidedException.getAttributeName());
    assertEquals("The attribute Attribute Name was not provided",
        actualRequiredAttributeNotProvidedException.getLocalizedMessage());
    assertEquals("The attribute Attribute Name was not provided",
        actualRequiredAttributeNotProvidedException.getMessage());
    assertNull(actualRequiredAttributeNotProvidedException.getProductId());
    assertNull(actualRequiredAttributeNotProvidedException.getCause());
    assertEquals(0, actualRequiredAttributeNotProvidedException.getSuppressed().length);
  }

  /**
   * Test
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String, String)}.
   * <p>
   * Method under test:
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String, String)}
   */
  @Test
  public void testNewRequiredAttributeNotProvidedException2() {
    // Arrange and Act
    RequiredAttributeNotProvidedException actualRequiredAttributeNotProvidedException = new RequiredAttributeNotProvidedException(
        "An error occurred", "Attribute Name");

    // Assert
    assertEquals("An error occurred", actualRequiredAttributeNotProvidedException.getLocalizedMessage());
    assertEquals("An error occurred", actualRequiredAttributeNotProvidedException.getMessage());
    assertEquals("Attribute Name", actualRequiredAttributeNotProvidedException.getAttributeName());
    assertNull(actualRequiredAttributeNotProvidedException.getProductId());
    assertNull(actualRequiredAttributeNotProvidedException.getCause());
    assertEquals(0, actualRequiredAttributeNotProvidedException.getSuppressed().length);
  }

  /**
   * Test
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String, String, String)}.
   * <p>
   * Method under test:
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String, String, String)}
   */
  @Test
  public void testNewRequiredAttributeNotProvidedException3() {
    // Arrange and Act
    RequiredAttributeNotProvidedException actualRequiredAttributeNotProvidedException = new RequiredAttributeNotProvidedException(
        "An error occurred", "Attribute Name", "42");

    // Assert
    assertEquals("42", actualRequiredAttributeNotProvidedException.getProductId());
    assertEquals("An error occurred", actualRequiredAttributeNotProvidedException.getLocalizedMessage());
    assertEquals("An error occurred", actualRequiredAttributeNotProvidedException.getMessage());
    assertEquals("Attribute Name", actualRequiredAttributeNotProvidedException.getAttributeName());
    assertNull(actualRequiredAttributeNotProvidedException.getCause());
    assertEquals(0, actualRequiredAttributeNotProvidedException.getSuppressed().length);
  }

  /**
   * Test
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String, String, Throwable)}.
   * <p>
   * Method under test:
   * {@link RequiredAttributeNotProvidedException#RequiredAttributeNotProvidedException(String, String, Throwable)}
   */
  @Test
  public void testNewRequiredAttributeNotProvidedException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RequiredAttributeNotProvidedException actualRequiredAttributeNotProvidedException = new RequiredAttributeNotProvidedException(
        "An error occurred", "Attribute Name", cause);

    // Assert
    assertEquals("An error occurred", actualRequiredAttributeNotProvidedException.getLocalizedMessage());
    assertEquals("An error occurred", actualRequiredAttributeNotProvidedException.getMessage());
    assertEquals("Attribute Name", actualRequiredAttributeNotProvidedException.getAttributeName());
    assertNull(actualRequiredAttributeNotProvidedException.getProductId());
    assertEquals(0, actualRequiredAttributeNotProvidedException.getSuppressed().length);
    assertSame(cause, actualRequiredAttributeNotProvidedException.getCause());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RequiredAttributeNotProvidedException#setAttributeName(String)}
   *   <li>{@link RequiredAttributeNotProvidedException#setProductId(String)}
   *   <li>{@link RequiredAttributeNotProvidedException#getAttributeName()}
   *   <li>{@link RequiredAttributeNotProvidedException#getProductId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RequiredAttributeNotProvidedException requiredAttributeNotProvidedException = new RequiredAttributeNotProvidedException(
        "Attribute Name");

    // Act
    requiredAttributeNotProvidedException.setAttributeName("Attribute Name");
    requiredAttributeNotProvidedException.setProductId("42");
    String actualAttributeName = requiredAttributeNotProvidedException.getAttributeName();

    // Assert that nothing has changed
    assertEquals("42", requiredAttributeNotProvidedException.getProductId());
    assertEquals("Attribute Name", actualAttributeName);
  }
}
