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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {EarlyStageRemoveBeanPostProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractRemoveBeanPostProcessorDiffblueTest {
  @Autowired
  private AbstractRemoveBeanPostProcessor abstractRemoveBeanPostProcessor;

  /**
   * Test
   * {@link AbstractRemoveBeanPostProcessor#setApplicationContext(ApplicationContext)}.
   * <p>
   * Method under test:
   * {@link AbstractRemoveBeanPostProcessor#setApplicationContext(ApplicationContext)}
   */
  @Test
  public void testSetApplicationContext() throws BeansException {
    // Arrange
    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();

    // Act
    earlyStageRemoveBeanPostProcessor.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    ApplicationContext applicationContext = earlyStageRemoveBeanPostProcessor.applicationContext;
    assertTrue(applicationContext instanceof AnnotationConfigReactiveWebApplicationContext);
    assertEquals("", applicationContext.getApplicationName());
    assertNull(applicationContext.getParentBeanFactory());
    assertNull(applicationContext.getParent());
    assertEquals(0L, applicationContext.getStartupDate());
    assertEquals(6, applicationContext.getBeanDefinitionCount());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext).isActive());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext).isRunning());
    assertArrayEquals(
        new String[]{"org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
            "org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
            "org.springframework.context.annotation.internalCommonAnnotationProcessor",
            "org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
            "org.springframework.context.event.internalEventListenerProcessor",
            "org.springframework.context.event.internalEventListenerFactory"},
        applicationContext.getBeanDefinitionNames());
  }

  /**
   * Test
   * {@link AbstractRemoveBeanPostProcessor#postProcessAfterInitialization(Object, String)}.
   * <p>
   * Method under test:
   * {@link AbstractRemoveBeanPostProcessor#postProcessAfterInitialization(Object, String)}
   */
  @Test
  public void testPostProcessAfterInitialization() throws BeansException {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, abstractRemoveBeanPostProcessor.postProcessAfterInitialization(object, "Bean Name"));
  }

  /**
   * Test
   * {@link AbstractRemoveBeanPostProcessor#postProcessBeforeInitialization(Object, String)}.
   * <p>
   * Method under test:
   * {@link AbstractRemoveBeanPostProcessor#postProcessBeforeInitialization(Object, String)}
   */
  @Test
  public void testPostProcessBeforeInitialization() throws BeansException {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, abstractRemoveBeanPostProcessor.postProcessBeforeInitialization(object, "Bean Name"));
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getBeanRef()}.
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getBeanRef()}
   */
  @Test
  public void testGetBeanRef() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getBeanRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getBeanRef()}.
   * <ul>
   *   <li>Given {@link EarlyStageRemoveBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getBeanRef()}
   */
  @Test
  public void testGetBeanRef_givenEarlyStageRemoveBeanPostProcessor() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getBeanRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#setBeanRef(String)}.
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#setBeanRef(String)}
   */
  @Test
  public void testSetBeanRef() {
    // Arrange and Act
    abstractRemoveBeanPostProcessor.setBeanRef("Bean Ref");

    // Assert
    assertTrue(abstractRemoveBeanPostProcessor instanceof EarlyStageRemoveBeanPostProcessor);
    assertEquals("Bean Ref", abstractRemoveBeanPostProcessor.getBeanRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getTargetRef()}.
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getTargetRef()}
   */
  @Test
  public void testGetTargetRef() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getTargetRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getTargetRef()}.
   * <ul>
   *   <li>Given {@link EarlyStageRemoveBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getTargetRef()}
   */
  @Test
  public void testGetTargetRef_givenEarlyStageRemoveBeanPostProcessor() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getTargetRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#setTargetRef(String)}.
   * <p>
   * Method under test:
   * {@link AbstractRemoveBeanPostProcessor#setTargetRef(String)}
   */
  @Test
  public void testSetTargetRef() {
    // Arrange and Act
    abstractRemoveBeanPostProcessor.setTargetRef("Target Ref");

    // Assert
    assertTrue(abstractRemoveBeanPostProcessor instanceof EarlyStageRemoveBeanPostProcessor);
    assertEquals("Target Ref", abstractRemoveBeanPostProcessor.getTargetRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getMapKey()}.
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKey()}
   */
  @Test
  public void testGetMapKey() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getMapKey());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getMapKey()}.
   * <ul>
   *   <li>Given {@link EarlyStageRemoveBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKey()}
   */
  @Test
  public void testGetMapKey_givenEarlyStageRemoveBeanPostProcessor() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getMapKey());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#setMapKey(String)}.
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#setMapKey(String)}
   */
  @Test
  public void testSetMapKey() {
    // Arrange and Act
    abstractRemoveBeanPostProcessor.setMapKey("Map Key");

    // Assert
    assertTrue(abstractRemoveBeanPostProcessor instanceof EarlyStageRemoveBeanPostProcessor);
    assertEquals("Map Key", abstractRemoveBeanPostProcessor.getMapKey());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getMapKeyRef()}.
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKeyRef()}
   */
  @Test
  public void testGetMapKeyRef() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getMapKeyRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#getMapKeyRef()}.
   * <ul>
   *   <li>Given {@link EarlyStageRemoveBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKeyRef()}
   */
  @Test
  public void testGetMapKeyRef_givenEarlyStageRemoveBeanPostProcessor() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getMapKeyRef());
  }

  /**
   * Test {@link AbstractRemoveBeanPostProcessor#setMapKeyRef(String)}.
   * <p>
   * Method under test:
   * {@link AbstractRemoveBeanPostProcessor#setMapKeyRef(String)}
   */
  @Test
  public void testSetMapKeyRef() {
    // Arrange and Act
    abstractRemoveBeanPostProcessor.setMapKeyRef("Map Key Ref");

    // Assert
    assertTrue(abstractRemoveBeanPostProcessor instanceof EarlyStageRemoveBeanPostProcessor);
    assertEquals("Map Key Ref", abstractRemoveBeanPostProcessor.getMapKeyRef());
  }
}
