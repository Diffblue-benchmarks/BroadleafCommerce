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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxActivity;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxRollbackHandler;
import org.broadleafcommerce.core.checkout.service.workflow.CompositeActivity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CompositeActivity.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseActivityDiffblueTest {
  @Autowired
  private BaseActivity<ProcessContext<CheckoutSeed>> baseActivity;

  /**
   * Test {@link BaseActivity#shouldExecute(ProcessContext)}.
   * <p>
   * Method under test: {@link BaseActivity#shouldExecute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseActivity.shouldExecute(ProcessContext)"})
  public void testShouldExecute() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act and Assert
    assertTrue(compositeActivity.shouldExecute(new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link BaseActivity#getErrorHandler()}.
   * <p>
   * Method under test: {@link BaseActivity#getErrorHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ErrorHandler BaseActivity.getErrorHandler()"})
  public void testGetErrorHandler() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getErrorHandler());
  }

  /**
   * Test {@link BaseActivity#setBeanName(String)}.
   * <p>
   * Method under test: {@link BaseActivity#setBeanName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseActivity.setBeanName(String)"})
  public void testSetBeanName() {
    // Arrange and Act
    baseActivity.setBeanName("Bean Name");

    // Assert
    assertTrue(baseActivity instanceof CompositeActivity);
    assertEquals("Bean Name", baseActivity.getBeanName());
  }

  /**
   * Test {@link BaseActivity#setErrorHandler(ErrorHandler)}.
   * <p>
   * Method under test: {@link BaseActivity#setErrorHandler(ErrorHandler)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseActivity.setErrorHandler(ErrorHandler)"})
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
   * Test {@link BaseActivity#getBeanName()}.
   * <p>
   * Method under test: {@link BaseActivity#getBeanName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseActivity.getBeanName()"})
  public void testGetBeanName() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getBeanName());
  }

  /**
   * Test {@link BaseActivity#getRollbackRegion()}.
   * <p>
   * Method under test: {@link BaseActivity#getRollbackRegion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseActivity.getRollbackRegion()"})
  public void testGetRollbackRegion() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getRollbackRegion());
  }

  /**
   * Test {@link BaseActivity#setRollbackRegion(String)}.
   * <p>
   * Method under test: {@link BaseActivity#setRollbackRegion(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseActivity.setRollbackRegion(String)"})
  public void testSetRollbackRegion() {
    // Arrange and Act
    baseActivity.setRollbackRegion("us-east-2");

    // Assert
    assertTrue(baseActivity instanceof CompositeActivity);
    assertEquals("us-east-2", baseActivity.getRollbackRegion());
  }

  /**
   * Test {@link BaseActivity#getStateConfiguration()}.
   * <p>
   * Method under test: {@link BaseActivity#getStateConfiguration()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map BaseActivity.getStateConfiguration()"})
  public void testGetStateConfiguration() {
    // Arrange, Act and Assert
    assertNull((new CompositeActivity()).getStateConfiguration());
  }

  /**
   * Test {@link BaseActivity#setStateConfiguration(Map)}.
   * <p>
   * Method under test: {@link BaseActivity#setStateConfiguration(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseActivity.setStateConfiguration(Map)"})
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
   * Test {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseActivity.getAutomaticallyRegisterRollbackHandler()"})
  public void testGetAutomaticallyRegisterRollbackHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CompositeActivity()).getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseActivity#getAutomaticallyRegisterRollbackHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseActivity.getAutomaticallyRegisterRollbackHandler()"})
  public void testGetAutomaticallyRegisterRollbackHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new CommitTaxActivity(new CommitTaxRollbackHandler())).getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}.
   * <p>
   * Method under test: {@link BaseActivity#setAutomaticallyRegisterRollbackHandler(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseActivity.setAutomaticallyRegisterRollbackHandler(boolean)"})
  public void testSetAutomaticallyRegisterRollbackHandler() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act
    compositeActivity.setAutomaticallyRegisterRollbackHandler(true);

    // Assert
    assertTrue(compositeActivity.getAutomaticallyRegisterRollbackHandler());
  }

  /**
   * Test {@link BaseActivity#getOrder()}.
   * <p>
   * Method under test: {@link BaseActivity#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BaseActivity.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new CompositeActivity()).getOrder());
  }

  /**
   * Test {@link BaseActivity#setOrder(int)}.
   * <p>
   * Method under test: {@link BaseActivity#setOrder(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseActivity.setOrder(int)"})
  public void testSetOrder() {
    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act
    compositeActivity.setOrder(1);

    // Assert
    assertEquals(1, compositeActivity.getOrder());
  }
}
