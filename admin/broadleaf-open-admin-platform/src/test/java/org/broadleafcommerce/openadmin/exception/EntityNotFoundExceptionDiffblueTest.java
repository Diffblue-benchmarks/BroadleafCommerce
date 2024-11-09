/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EntityNotFoundExceptionDiffblueTest {
  /**
   * Test {@link EntityNotFoundException#EntityNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNotFoundException#EntityNotFoundException()}
   */
  @Test
  public void testNewEntityNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    EntityNotFoundException actualEntityNotFoundException = new EntityNotFoundException();

    // Assert
    assertNull(actualEntityNotFoundException.getMessage());
    assertNull(actualEntityNotFoundException.getCause());
    assertEquals(0, actualEntityNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link EntityNotFoundException#EntityNotFoundException(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return Message is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityNotFoundException#EntityNotFoundException(String)}
   */
  @Test
  public void testNewEntityNotFoundException_whenFoo_thenReturnMessageIsFoo() {
    // Arrange and Act
    EntityNotFoundException actualEntityNotFoundException = new EntityNotFoundException("foo");

    // Assert
    assertEquals("foo", actualEntityNotFoundException.getMessage());
    assertNull(actualEntityNotFoundException.getCause());
    assertEquals(0, actualEntityNotFoundException.getSuppressed().length);
  }
}
