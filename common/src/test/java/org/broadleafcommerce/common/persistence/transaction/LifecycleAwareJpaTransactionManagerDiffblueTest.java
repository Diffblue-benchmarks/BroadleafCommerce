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
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.orm.jpa.DefaultJpaDialect;

public class LifecycleAwareJpaTransactionManagerDiffblueTest {
  /**
   * Method under test: {@link LifecycleAwareJpaTransactionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new LifecycleAwareJpaTransactionManager()).isEnabled());
  }

  /**
   * Method under test: {@link LifecycleAwareJpaTransactionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager = new LifecycleAwareJpaTransactionManager();
    lifecycleAwareJpaTransactionManager.setLogEvents(true);

    // Act and Assert
    assertTrue(lifecycleAwareJpaTransactionManager.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleAwareJpaTransactionManager#setLogEvents(Boolean)}
   *   <li>{@link LifecycleAwareJpaTransactionManager#getLogEvents()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager = new LifecycleAwareJpaTransactionManager();

    // Act
    lifecycleAwareJpaTransactionManager.setLogEvents(true);

    // Assert that nothing has changed
    assertTrue(lifecycleAwareJpaTransactionManager.getLogEvents());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link LifecycleAwareJpaTransactionManager}
   */
  @Test
  public void testNewLifecycleAwareJpaTransactionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    LifecycleAwareJpaTransactionManager actualLifecycleAwareJpaTransactionManager = new LifecycleAwareJpaTransactionManager();

    // Assert
    assertTrue(actualLifecycleAwareJpaTransactionManager.getJpaDialect() instanceof DefaultJpaDialect);
    assertNull(actualLifecycleAwareJpaTransactionManager.getLogEvents());
    assertNull(actualLifecycleAwareJpaTransactionManager.getPersistenceUnitName());
    assertNull(actualLifecycleAwareJpaTransactionManager.getEntityManagerFactory());
    assertNull(actualLifecycleAwareJpaTransactionManager.getDataSource());
    assertNull(actualLifecycleAwareJpaTransactionManager.publisher);
    assertEquals(-1, actualLifecycleAwareJpaTransactionManager.getDefaultTimeout());
    assertEquals(0, actualLifecycleAwareJpaTransactionManager.getTransactionSynchronization());
    assertFalse(actualLifecycleAwareJpaTransactionManager.isFailEarlyOnGlobalRollbackOnly());
    assertFalse(actualLifecycleAwareJpaTransactionManager.isRollbackOnCommitFailure());
    assertFalse(actualLifecycleAwareJpaTransactionManager.isValidateExistingTransaction());
    assertFalse(actualLifecycleAwareJpaTransactionManager.defaultLogEvents);
    assertTrue(actualLifecycleAwareJpaTransactionManager.getJpaPropertyMap().isEmpty());
    assertTrue(actualLifecycleAwareJpaTransactionManager.isGlobalRollbackOnParticipationFailure());
    assertTrue(actualLifecycleAwareJpaTransactionManager.isNestedTransactionAllowed());
  }
}
