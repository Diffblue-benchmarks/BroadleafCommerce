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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.StringValueResolver;

public class BaseProcessorDiffblueTest {
  /**
   * Method under test: {@link BaseProcessor#setBeanName(String)}
   */
  @Test
  public void testSetBeanName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act
    emptySequenceProcessor.setBeanName("Bean Name");

    // Assert
    assertEquals("Bean Name", emptySequenceProcessor.getBeanName());
    assertEquals("Workflow Processor: Bean Name", emptySequenceProcessor.getBeanDesc());
  }

  /**
   * Method under test: {@link BaseProcessor#setBeanName(String)}
   */
  @Test
  public void testSetBeanName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act
    emptySequenceProcessor.setBeanName("Bean Name");

    // Assert
    assertEquals("Bean Name", emptySequenceProcessor.getBeanName());
    assertEquals("Workflow Processor: Bean Name", emptySequenceProcessor.getBeanDesc());
  }

  /**
   * Method under test: {@link BaseProcessor#setBeanFactory(BeanFactory)}
   */
  @Test
  public void testSetBeanFactory() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // Act
    emptySequenceProcessor.setBeanFactory(beanFactory);

    // Assert
    assertSame(beanFactory, emptySequenceProcessor.getBeanFactory());
  }

  /**
   * Method under test: {@link BaseProcessor#setBeanFactory(BeanFactory)}
   */
  @Test
  public void testSetBeanFactory2() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    // Act
    emptySequenceProcessor.setBeanFactory(beanFactory);

    // Assert
    assertSame(beanFactory, emptySequenceProcessor.getBeanFactory());
  }

  /**
   * Method under test: {@link BaseProcessor#getAutoRollbackOnError()}
   */
  @Test
  public void testGetAutoRollbackOnError() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new EmptySequenceProcessor()).getAutoRollbackOnError());
  }

  /**
   * Method under test: {@link BaseProcessor#getAutoRollbackOnError()}
   */
  @Test
  public void testGetAutoRollbackOnError2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertTrue(emptySequenceProcessor.getAutoRollbackOnError());
  }

  /**
   * Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  public void testIsAllowEmptyActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new EmptySequenceProcessor()).isAllowEmptyActivities());
  }

  /**
   * Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  public void testIsAllowEmptyActivities2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertFalse(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  public void testIsAllowEmptyActivities3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setAllowEmptyActivities(true);

    // Act and Assert
    assertTrue(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Method under test: {@link BaseProcessor#setAllowEmptyActivities(boolean)}
   */
  @Test
  public void testSetAllowEmptyActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act
    emptySequenceProcessor.setAllowEmptyActivities(true);

    // Assert
    assertTrue(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Method under test: {@link BaseProcessor#setAllowEmptyActivities(boolean)}
   */
  @Test
  public void testSetAllowEmptyActivities2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act
    emptySequenceProcessor.setAllowEmptyActivities(true);

    // Assert
    assertTrue(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Method under test:
   * {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  public void testOnApplicationEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act and Assert
    assertThrows(BeanInitializationException.class, () -> emptySequenceProcessor
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext())));
  }

  /**
   * Method under test: {@link BaseProcessor#getBeanDesc()}
   */
  @Test
  public void testGetBeanDesc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Workflow Processor: null", (new EmptySequenceProcessor()).getBeanDesc());
  }

  /**
   * Method under test: {@link BaseProcessor#getBeanDesc()}
   */
  @Test
  public void testGetBeanDesc2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertEquals("Workflow Processor: null", emptySequenceProcessor.getBeanDesc());
  }

  /**
   * Method under test: {@link BaseProcessor#setActivities(List)}
   */
  @Test
  public void testSetActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    ArrayList<Activity<ProcessContext<?>>> activities = new ArrayList<>();

    // Act
    emptySequenceProcessor.setActivities(activities);

    // Assert
    assertSame(activities, emptySequenceProcessor.getActivities());
  }

  /**
   * Method under test: {@link BaseProcessor#setActivities(List)}
   */
  @Test
  public void testSetActivities2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));
    ArrayList<Activity<ProcessContext<?>>> activities = new ArrayList<>();

    // Act
    emptySequenceProcessor.setActivities(activities);

    // Assert
    assertSame(activities, emptySequenceProcessor.getActivities());
  }

  /**
   * Method under test: {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}
   */
  @Test
  public void testSetDefaultErrorHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler();

    // Act
    emptySequenceProcessor.setDefaultErrorHandler(defaultErrorHandler);

    // Assert
    assertSame(defaultErrorHandler, emptySequenceProcessor.getDefaultErrorHandler());
  }

  /**
   * Method under test: {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}
   */
  @Test
  public void testSetDefaultErrorHandler2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    DefaultErrorHandler defaultErrorHandler = mock(DefaultErrorHandler.class);

    // Act
    emptySequenceProcessor.setDefaultErrorHandler(defaultErrorHandler);

    // Assert
    assertSame(defaultErrorHandler, emptySequenceProcessor.getDefaultErrorHandler());
  }

  /**
   * Method under test: {@link BaseProcessor#getActivities()}
   */
  @Test
  public void testGetActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act
    List<Activity<ProcessContext<?>>> actualActivities = emptySequenceProcessor.getActivities();

    // Assert
    assertTrue(actualActivities.isEmpty());
    assertSame(emptySequenceProcessor.activities, actualActivities);
  }

  /**
   * Method under test: {@link BaseProcessor#getActivities()}
   */
  @Test
  public void testGetActivities2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act
    List<Activity<ProcessContext<?>>> actualActivities = emptySequenceProcessor.getActivities();

    // Assert
    assertTrue(actualActivities.isEmpty());
    assertSame(emptySequenceProcessor.activities, actualActivities);
  }

  /**
   * Method under test: {@link BaseProcessor#getModuleActivities()}
   */
  @Test
  public void testGetModuleActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act
    List<ModuleActivity> actualModuleActivities = emptySequenceProcessor.getModuleActivities();

    // Assert
    assertTrue(actualModuleActivities.isEmpty());
    assertSame(emptySequenceProcessor.moduleActivities, actualModuleActivities);
  }

  /**
   * Method under test: {@link BaseProcessor#getModuleActivities()}
   */
  @Test
  public void testGetModuleActivities2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act
    List<ModuleActivity> actualModuleActivities = emptySequenceProcessor.getModuleActivities();

    // Assert
    assertTrue(actualModuleActivities.isEmpty());
    assertSame(emptySequenceProcessor.moduleActivities, actualModuleActivities);
  }

  /**
   * Method under test: {@link BaseProcessor#getBeanName()}
   */
  @Test
  public void testGetBeanName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).getBeanName());
  }

  /**
   * Method under test: {@link BaseProcessor#getBeanName()}
   */
  @Test
  public void testGetBeanName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.getBeanName());
  }

  /**
   * Method under test: {@link BaseProcessor#getDefaultErrorHandler()}
   */
  @Test
  public void testGetDefaultErrorHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).getDefaultErrorHandler());
  }

  /**
   * Method under test: {@link BaseProcessor#getDefaultErrorHandler()}
   */
  @Test
  public void testGetDefaultErrorHandler2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.getDefaultErrorHandler());
  }

  /**
   * Method under test: {@link BaseProcessor#getBeanFactory()}
   */
  @Test
  public void testGetBeanFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).getBeanFactory());
  }

  /**
   * Method under test: {@link BaseProcessor#getBeanFactory()}
   */
  @Test
  public void testGetBeanFactory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.getBeanFactory());
  }
}
