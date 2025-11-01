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
package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.sql.Date;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ValidationExceptionDiffblueTest {
  @MockBean
  private ValidationException validationException;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationException#setEntity(Entity)}
   *   <li>{@link ValidationException#getEntity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ValidationException validationException = new ValidationException(new Entity());
    Entity entity = new Entity();

    // Act
    validationException.setEntity(entity);

    // Assert that nothing has changed
    assertSame(entity, validationException.getEntity());
  }

  /**
   * Method under test: {@link ValidationException#ValidationException(Entity)}
   */
  @Test
  public void testNewValidationException() {
    // Arrange
    Entity entity = new Entity();

    // Act
    ValidationException actualValidationException = new ValidationException(entity);

    // Assert
    assertNull(actualValidationException.getLocalizedMessage());
    assertNull(actualValidationException.getMessage());
    assertNull(actualValidationException.getCause());
    assertEquals(0, actualValidationException.getSuppressed().length);
    assertSame(entity, actualValidationException.getEntity());
  }

  /**
   * Method under test: {@link ValidationException#ValidationException(Entity)}
   */
  @Test
  public void testNewValidationException2() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeployDate(mock(Date.class));

    // Act
    ValidationException actualValidationException = new ValidationException(entity);

    // Assert
    assertNull(actualValidationException.getLocalizedMessage());
    assertNull(actualValidationException.getMessage());
    assertNull(actualValidationException.getCause());
    assertEquals(0, actualValidationException.getSuppressed().length);
    assertSame(entity, actualValidationException.getEntity());
  }

  /**
   * Method under test:
   * {@link ValidationException#ValidationException(Entity, String)}
   */
  @Test
  public void testNewValidationException3() {
    // Arrange
    Entity entity = new Entity();

    // Act
    ValidationException actualValidationException = new ValidationException(entity, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualValidationException.getLocalizedMessage());
    assertEquals("An error occurred", actualValidationException.getMessage());
    assertNull(actualValidationException.getCause());
    assertEquals(0, actualValidationException.getSuppressed().length);
    assertSame(entity, actualValidationException.getEntity());
  }

  /**
   * Method under test:
   * {@link ValidationException#ValidationException(Entity, String)}
   */
  @Test
  public void testNewValidationException4() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    ValidationException actualValidationException = new ValidationException(entity, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualValidationException.getLocalizedMessage());
    assertEquals("An error occurred", actualValidationException.getMessage());
    assertNull(actualValidationException.getCause());
    assertEquals(0, actualValidationException.getSuppressed().length);
    assertSame(entity, actualValidationException.getEntity());
  }
}
