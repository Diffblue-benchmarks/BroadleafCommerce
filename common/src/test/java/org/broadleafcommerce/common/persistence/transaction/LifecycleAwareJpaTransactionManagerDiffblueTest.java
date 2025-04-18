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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.EntityManagerFactory;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.orm.jpa.DefaultJpaDialect;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LifecycleAwareJpaTransactionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class LifecycleAwareJpaTransactionManagerDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @Autowired
  private LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean LifecycleAwareJpaTransactionManager.getLogEvents()",
      "void LifecycleAwareJpaTransactionManager.setLogEvents(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager = new LifecycleAwareJpaTransactionManager();

    // Act
    lifecycleAwareJpaTransactionManager.setLogEvents(true);

    // Assert
    assertTrue(lifecycleAwareJpaTransactionManager.getLogEvents());
  }

  /**
   * Test {@link LifecycleAwareJpaTransactionManager#isEnabled()}.
   * <ul>
   *   <li>Given {@link ApplicationEventPublisher}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleAwareJpaTransactionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LifecycleAwareJpaTransactionManager.isEnabled()"})
  public void testIsEnabled_givenApplicationEventPublisher_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(lifecycleAwareJpaTransactionManager.isEnabled());
  }

  /**
   * Test {@link LifecycleAwareJpaTransactionManager#isEnabled()}.
   * <ul>
   *   <li>Given {@link LifecycleAwareJpaTransactionManager} (default constructor) LogEvents is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleAwareJpaTransactionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LifecycleAwareJpaTransactionManager.isEnabled()"})
  public void testIsEnabled_givenLifecycleAwareJpaTransactionManagerLogEventsIsFalse() {
    // Arrange
    LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager = new LifecycleAwareJpaTransactionManager();
    lifecycleAwareJpaTransactionManager.setLogEvents(false);

    // Act and Assert
    assertFalse(lifecycleAwareJpaTransactionManager.isEnabled());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LifecycleAwareJpaTransactionManager.isEnabled()"})
  public void testIsEnabled_thenReturnTrue() {
    // Arrange
    LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager = new LifecycleAwareJpaTransactionManager();
    lifecycleAwareJpaTransactionManager.setLogEvents(true);

    // Act and Assert
    assertTrue(lifecycleAwareJpaTransactionManager.isEnabled());
  }

  /**
   * Test new {@link LifecycleAwareJpaTransactionManager} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link LifecycleAwareJpaTransactionManager}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LifecycleAwareJpaTransactionManager.<init>()"})
  public void testNewLifecycleAwareJpaTransactionManager() {
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
