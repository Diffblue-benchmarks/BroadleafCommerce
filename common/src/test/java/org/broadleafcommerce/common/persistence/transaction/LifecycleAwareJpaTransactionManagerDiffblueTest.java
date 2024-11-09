/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.orm.jpa.DefaultJpaDialect;

public class LifecycleAwareJpaTransactionManagerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
   * Test {@link LifecycleAwareJpaTransactionManager#isEnabled()}.
   * <ul>
   *   <li>Given {@link LifecycleAwareJpaTransactionManager} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleAwareJpaTransactionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled_givenLifecycleAwareJpaTransactionManager_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new LifecycleAwareJpaTransactionManager()).isEnabled());
  }

  /**
   * Test {@link LifecycleAwareJpaTransactionManager#isEnabled()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleAwareJpaTransactionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager = new LifecycleAwareJpaTransactionManager();
    lifecycleAwareJpaTransactionManager.setLogEvents(true);

    // Act and Assert
    assertTrue(lifecycleAwareJpaTransactionManager.isEnabled());
  }

  /**
   * Test new {@link LifecycleAwareJpaTransactionManager} (default constructor).
   * <p>
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
