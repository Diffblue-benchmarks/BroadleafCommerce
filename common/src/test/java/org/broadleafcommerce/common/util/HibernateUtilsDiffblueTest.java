/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.persistence.EntityManager;
import org.junit.Test;

public class HibernateUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   */
  @Test
  public void testExecuteWithCache() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithCache(operation, (EntityManager) null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Method under test:
   * {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   */
  @Test
  public void testExecuteWithCache2() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> HibernateUtils.executeWithCache(operation, (EntityManager) null));
    verify(operation).execute();
  }

  /**
   * Method under test:
   * {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)}
   */
  @Test
  public void testExecuteWithoutCache() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithoutCache(operation, (EntityManager) null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Method under test:
   * {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)}
   */
  @Test
  public void testExecuteWithoutCache2() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> HibernateUtils.executeWithoutCache(operation, (EntityManager) null));
    verify(operation).execute();
  }
}
