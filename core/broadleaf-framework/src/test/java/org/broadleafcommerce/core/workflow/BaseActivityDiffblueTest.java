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
package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxActivity;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxRollbackHandler;
import org.broadleafcommerce.core.checkout.service.workflow.CompositeActivity;
import org.broadleafcommerce.core.workflow.state.RollbackHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CompositeActivity.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseActivityDiffblueTest {
  @Autowired
  private BaseActivity<ProcessContext<?>> baseActivity;

  /**
   * Method under test: {@link BaseActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act and Assert
    assertTrue(compositeActivity.shouldExecute(new DefaultProcessContextImpl<>()));
  }

  /**
   * Method under test: {@link BaseActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertTrue(compositeActivity.shouldExecute(new DefaultProcessContextImpl<>()));
  }

  /**
   * Method under test: {@link BaseActivity#getErrorHandler()}
   */
  @Test
  public void testGetErrorHandler() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getErrorHandler());
  }

  /**
   * Method under test: {@link BaseActivity#getErrorHandler()}
   */
  @Test
  public void testGetErrorHandler2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getErrorHandler());
  }

  /**
   * Method under test: {@link BaseActivity#setBeanName(String)}
   */
  @Test
  public void testSetBeanName() {
    // Arrange
    CommitTaxActivity commitTaxActivity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    // Act
    commitTaxActivity.setBeanName("Bean Name");

    // Assert
    assertEquals("Bean Name", commitTaxActivity.getBeanName());
  }

  /**
   * Method under test: {@link BaseActivity#setBeanName(String)}
   */
  @Test
  public void testSetBeanName2() {
    // Arrange
    CommitTaxActivity commitTaxActivity = new CommitTaxActivity(mock(CommitTaxRollbackHandler.class));

    // Act
    commitTaxActivity.setBeanName("Bean Name");

    // Assert
    assertEquals("Bean Name", commitTaxActivity.getBeanName());
  }

  /**
   * Method under test: {@link BaseActivity#setErrorHandler(ErrorHandler)}
   */
  @Test
  public void testSetErrorHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    DefaultErrorHandler errorHandler = new DefaultErrorHandler();

    // Act
    compositeActivity.setErrorHandler(errorHandler);

    // Assert
    assertSame(errorHandler, compositeActivity.getErrorHandler());
  }

  /**
   * Method under test: {@link BaseActivity#setErrorHandler(ErrorHandler)}
   */
  @Test
  public void testSetErrorHandler2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));
    DefaultErrorHandler errorHandler = new DefaultErrorHandler();

    // Act
    compositeActivity.setErrorHandler(errorHandler);

    // Assert
    assertSame(errorHandler, compositeActivity.getErrorHandler());
  }

  /**
   * Method under test: {@link BaseActivity#getBeanName()}
   */
  @Test
  public void testGetBeanName() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getBeanName());
  }

  /**
   * Method under test: {@link BaseActivity#getBeanName()}
   */
  @Test
  public void testGetBeanName2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getBeanName());
  }

  /**
   * Method under test: {@link BaseActivity#getRollbackRegion()}
   */
  @Test
  public void testGetRollbackRegion() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getRollbackRegion());
  }

  /**
   * Method under test: {@link BaseActivity#getRollbackRegion()}
   */
  @Test
  public void testGetRollbackRegion2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getRollbackRegion());
  }

  /**
   * Method under test: {@link BaseActivity#setRollbackRegion(String)}
   */
  @Test
  public void testSetRollbackRegion() {
    // Arrange
    CommitTaxActivity commitTaxActivity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    // Act
    commitTaxActivity.setRollbackRegion("us-east-2");

    // Assert
    assertEquals("us-east-2", commitTaxActivity.getRollbackRegion());
  }

  /**
   * Method under test: {@link BaseActivity#setRollbackRegion(String)}
   */
  @Test
  public void testSetRollbackRegion2() {
    // Arrange
    CommitTaxActivity commitTaxActivity = new CommitTaxActivity(mock(CommitTaxRollbackHandler.class));

    // Act
    commitTaxActivity.setRollbackRegion("us-east-2");

    // Assert
    assertEquals("us-east-2", commitTaxActivity.getRollbackRegion());
  }

  /**
   * Method under test: {@link BaseActivity#getStateConfiguration()}
   */
  @Test
  public void testGetStateConfiguration() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getStateConfiguration());
  }

  /**
   * Method under test: {@link BaseActivity#getStateConfiguration()}
   */
  @Test
  public void testGetStateConfiguration2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getStateConfiguration());
  }

  /**
   * Method under test: {@link BaseActivity#setStateConfiguration(Map)}
   */
  @Test
  public void testSetStateConfiguration() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    HashMap<String, Object> stateConfiguration = new HashMap<>();

    // Act
    compositeActivity.setStateConfiguration(stateConfiguration);

    // Assert
    assertSame(stateConfiguration, compositeActivity.getStateConfiguration());
  }

  /**
   * Method under test: {@link BaseActivity#setStateConfiguration(Map)}
   */
  @Test
  public void testSetStateConfiguration2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));
    HashMap<String, Object> stateConfiguration = new HashMap<>();

    // Act
    compositeActivity.setStateConfiguration(stateConfiguration);

    // Assert
    assertSame(stateConfiguration, compositeActivity.getStateConfiguration());
  }

  /**
   * Method under test:
   * {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}
   */
  @Test
  public void testGetAutomaticallyRegisterRollbackHandler() {
    // Arrange, Act and Assert
    assertFalse((new CompositeActivity()).getAutomaticallyRegisterRollbackHandler());
    assertTrue((new CommitTaxActivity(new CommitTaxRollbackHandler())).getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Method under test:
   * {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}
   */
  @Test
  public void testGetAutomaticallyRegisterRollbackHandler2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertFalse(compositeActivity.getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Method under test:
   * {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}
   */
  @Test
  public void testSetAutomaticallyRegisterRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act
    compositeActivity.setAutomaticallyRegisterRollbackHandler(true);

    // Assert
    assertTrue(compositeActivity.getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Method under test:
   * {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}
   */
  @Test
  public void testSetAutomaticallyRegisterRollbackHandler2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act
    compositeActivity.setAutomaticallyRegisterRollbackHandler(true);

    // Assert
    assertTrue(compositeActivity.getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Method under test: {@link BaseActivity#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new CompositeActivity()).getOrder());
  }

  /**
   * Method under test: {@link BaseActivity#getOrder()}
   */
  @Test
  public void testGetOrder2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, compositeActivity.getOrder());
  }

  /**
   * Method under test: {@link BaseActivity#setOrder(int)}
   */
  @Test
  public void testSetOrder() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act
    compositeActivity.setOrder(1);

    // Assert
    assertEquals(1, compositeActivity.getOrder());
  }

  /**
   * Method under test: {@link BaseActivity#setOrder(int)}
   */
  @Test
  public void testSetOrder2() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act
    compositeActivity.setOrder(1);

    // Assert
    assertEquals(1, compositeActivity.getOrder());
  }
}
