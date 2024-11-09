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
   * Test {@link BaseActivity#shouldExecute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute_givenCompositeActivity() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act and Assert
    assertTrue(compositeActivity.shouldExecute(new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link BaseActivity#shouldExecute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertTrue(compositeActivity.shouldExecute(new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link BaseActivity#getErrorHandler()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getErrorHandler()}
   */
  @Test
  public void testGetErrorHandler_givenCompositeActivity() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getErrorHandler());
  }

  /**
   * Test {@link BaseActivity#getErrorHandler()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getErrorHandler()}
   */
  @Test
  public void testGetErrorHandler_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getErrorHandler());
  }

  /**
   * Test {@link BaseActivity#setBeanName(String)}.
   * <p>
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
   * Test {@link BaseActivity#setBeanName(String)}.
   * <p>
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
   * Test {@link BaseActivity#setErrorHandler(ErrorHandler)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#setErrorHandler(ErrorHandler)}
   */
  @Test
  public void testSetErrorHandler_givenCompositeActivity() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    DefaultErrorHandler errorHandler = new DefaultErrorHandler();

    // Act
    compositeActivity.setErrorHandler(errorHandler);

    // Assert
    assertSame(errorHandler, compositeActivity.getErrorHandler());
  }

  /**
   * Test {@link BaseActivity#setErrorHandler(ErrorHandler)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#setErrorHandler(ErrorHandler)}
   */
  @Test
  public void testSetErrorHandler_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
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
   * Test {@link BaseActivity#getBeanName()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getBeanName()}
   */
  @Test
  public void testGetBeanName_givenCompositeActivity() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getBeanName());
  }

  /**
   * Test {@link BaseActivity#getBeanName()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getBeanName()}
   */
  @Test
  public void testGetBeanName_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getBeanName());
  }

  /**
   * Test {@link BaseActivity#getRollbackRegion()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getRollbackRegion()}
   */
  @Test
  public void testGetRollbackRegion_givenCompositeActivity() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getRollbackRegion());
  }

  /**
   * Test {@link BaseActivity#getRollbackRegion()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getRollbackRegion()}
   */
  @Test
  public void testGetRollbackRegion_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getRollbackRegion());
  }

  /**
   * Test {@link BaseActivity#setRollbackRegion(String)}.
   * <p>
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
   * Test {@link BaseActivity#setRollbackRegion(String)}.
   * <p>
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
   * Test {@link BaseActivity#getStateConfiguration()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getStateConfiguration()}
   */
  @Test
  public void testGetStateConfiguration_givenCompositeActivity() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getStateConfiguration());
  }

  /**
   * Test {@link BaseActivity#getStateConfiguration()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getStateConfiguration()}
   */
  @Test
  public void testGetStateConfiguration_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertNull(compositeActivity.getStateConfiguration());
  }

  /**
   * Test {@link BaseActivity#setStateConfiguration(Map)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#setStateConfiguration(Map)}
   */
  @Test
  public void testSetStateConfiguration_givenCompositeActivity() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    HashMap<String, Object> stateConfiguration = new HashMap<>();

    // Act
    compositeActivity.setStateConfiguration(stateConfiguration);

    // Assert
    assertSame(stateConfiguration, compositeActivity.getStateConfiguration());
  }

  /**
   * Test {@link BaseActivity#setStateConfiguration(Map)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#setStateConfiguration(Map)}
   */
  @Test
  public void testSetStateConfiguration_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
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
   * Test {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}.
   * <p>
   * Method under test:
   * {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}
   */
  @Test
  public void testGetAutomaticallyRegisterRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertFalse(compositeActivity.getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}
   */
  @Test
  public void testGetAutomaticallyRegisterRollbackHandler_givenCompositeActivity() {
    // Arrange, Act and Assert
    assertFalse((new CompositeActivity()).getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}
   */
  @Test
  public void testGetAutomaticallyRegisterRollbackHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new CommitTaxActivity(new CommitTaxRollbackHandler())).getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}.
   * <p>
   * Method under test:
   * {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}
   */
  @Test
  public void testSetAutomaticallyRegisterRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act
    compositeActivity.setAutomaticallyRegisterRollbackHandler(true);

    // Assert
    assertTrue(compositeActivity.getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}
   */
  @Test
  public void testSetAutomaticallyRegisterRollbackHandler_givenCompositeActivity() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act
    compositeActivity.setAutomaticallyRegisterRollbackHandler(true);

    // Assert
    assertTrue(compositeActivity.getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#getOrder()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getOrder()}
   */
  @Test
  public void testGetOrder_givenCompositeActivity() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new CompositeActivity()).getOrder());
  }

  /**
   * Test {@link BaseActivity#getOrder()}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getOrder()}
   */
  @Test
  public void testGetOrder_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, compositeActivity.getOrder());
  }

  /**
   * Test {@link BaseActivity#setOrder(int)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#setOrder(int)}
   */
  @Test
  public void testSetOrder_givenCompositeActivity() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act
    compositeActivity.setOrder(1);

    // Assert
    assertEquals(1, compositeActivity.getOrder());
  }

  /**
   * Test {@link BaseActivity#setOrder(int)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor) RollbackHandler is
   * {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#setOrder(int)}
   */
  @Test
  public void testSetOrder_givenCompositeActivityRollbackHandlerIsRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act
    compositeActivity.setOrder(1);

    // Assert
    assertEquals(1, compositeActivity.getOrder());
  }
}
