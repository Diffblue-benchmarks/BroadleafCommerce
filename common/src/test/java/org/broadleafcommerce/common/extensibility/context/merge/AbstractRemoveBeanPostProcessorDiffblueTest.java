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
   * Method under test:
   * {@link AbstractRemoveBeanPostProcessor#setApplicationContext(ApplicationContext)}
   */
  @Test
  public void testSetApplicationContext2() throws BeansException {
    // Arrange
    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    // Act
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Assert
    ApplicationContext applicationContext2 = earlyStageRemoveBeanPostProcessor.applicationContext;
    assertTrue(applicationContext2 instanceof AnnotationConfigReactiveWebApplicationContext);
    assertEquals("", applicationContext2.getApplicationName());
    assertNull(applicationContext2.getParentBeanFactory());
    assertNull(applicationContext2.getParent());
    assertEquals(0L, applicationContext2.getStartupDate());
    assertEquals(6, applicationContext2.getBeanDefinitionCount());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext2).isActive());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext2).isRunning());
    assertArrayEquals(
        new String[]{"org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
            "org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
            "org.springframework.context.annotation.internalCommonAnnotationProcessor",
            "org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
            "org.springframework.context.event.internalEventListenerProcessor",
            "org.springframework.context.event.internalEventListenerFactory"},
        applicationContext2.getBeanDefinitionNames());
  }

  /**
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
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getBeanRef()}
   */
  @Test
  public void testGetBeanRef() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getBeanRef());
  }

  /**
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getBeanRef()}
   */
  @Test
  public void testGetBeanRef2() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getBeanRef());
  }

  /**
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
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getTargetRef()}
   */
  @Test
  public void testGetTargetRef() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getTargetRef());
  }

  /**
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getTargetRef()}
   */
  @Test
  public void testGetTargetRef2() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getTargetRef());
  }

  /**
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
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKey()}
   */
  @Test
  public void testGetMapKey() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getMapKey());
  }

  /**
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKey()}
   */
  @Test
  public void testGetMapKey2() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getMapKey());
  }

  /**
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
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKeyRef()}
   */
  @Test
  public void testGetMapKeyRef() {
    // Arrange, Act and Assert
    assertNull((new EarlyStageRemoveBeanPostProcessor()).getMapKeyRef());
  }

  /**
   * Method under test: {@link AbstractRemoveBeanPostProcessor#getMapKeyRef()}
   */
  @Test
  public void testGetMapKeyRef2() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    EarlyStageRemoveBeanPostProcessor earlyStageRemoveBeanPostProcessor = new EarlyStageRemoveBeanPostProcessor();
    earlyStageRemoveBeanPostProcessor.setApplicationContext(applicationContext);

    // Act and Assert
    assertNull(earlyStageRemoveBeanPostProcessor.getMapKeyRef());
  }

  /**
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
