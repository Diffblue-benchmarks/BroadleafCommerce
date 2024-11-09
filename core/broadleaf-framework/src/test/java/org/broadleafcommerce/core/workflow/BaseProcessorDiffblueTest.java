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
   * Test {@link BaseProcessor#setBeanName(String)}.
   * <p>
   * Method under test: {@link BaseProcessor#setBeanName(String)}
   */
  @Test
  public void testSetBeanName() {
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
   * Test {@link BaseProcessor#setBeanName(String)}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#setBeanName(String)}
   */
  @Test
  public void testSetBeanName_givenEmptySequenceProcessor() {
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
   * Test {@link BaseProcessor#setBeanFactory(BeanFactory)}.
   * <ul>
   *   <li>Given {@link StringValueResolver}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#setBeanFactory(BeanFactory)}
   */
  @Test
  public void testSetBeanFactory_givenStringValueResolver() throws BeansException {
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
   * Test {@link BaseProcessor#setBeanFactory(BeanFactory)}.
   * <ul>
   *   <li>When
   * {@link DefaultListableBeanFactory#DefaultListableBeanFactory()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#setBeanFactory(BeanFactory)}
   */
  @Test
  public void testSetBeanFactory_whenDefaultListableBeanFactory() throws BeansException {
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
   * Test {@link BaseProcessor#getAutoRollbackOnError()}.
   * <p>
   * Method under test: {@link BaseProcessor#getAutoRollbackOnError()}
   */
  @Test
  public void testGetAutoRollbackOnError() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertTrue(emptySequenceProcessor.getAutoRollbackOnError());
  }

  /**
   * Test {@link BaseProcessor#getAutoRollbackOnError()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getAutoRollbackOnError()}
   */
  @Test
  public void testGetAutoRollbackOnError_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new EmptySequenceProcessor()).getAutoRollbackOnError());
  }

  /**
   * Test {@link BaseProcessor#isAllowEmptyActivities()}.
   * <p>
   * Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  public void testIsAllowEmptyActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertFalse(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#isAllowEmptyActivities()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  public void testIsAllowEmptyActivities_givenEmptySequenceProcessor_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new EmptySequenceProcessor()).isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#isAllowEmptyActivities()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  public void testIsAllowEmptyActivities_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setAllowEmptyActivities(true);

    // Act and Assert
    assertTrue(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#setAllowEmptyActivities(boolean)}.
   * <p>
   * Method under test: {@link BaseProcessor#setAllowEmptyActivities(boolean)}
   */
  @Test
  public void testSetAllowEmptyActivities() {
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
   * Test {@link BaseProcessor#setAllowEmptyActivities(boolean)}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#setAllowEmptyActivities(boolean)}
   */
  @Test
  public void testSetAllowEmptyActivities_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act
    emptySequenceProcessor.setAllowEmptyActivities(true);

    // Assert
    assertTrue(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)} with
   * {@code ContextRefreshedEvent}.
   * <p>
   * Method under test:
   * {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  public void testOnApplicationEventWithContextRefreshedEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act and Assert
    assertThrows(BeanInitializationException.class, () -> emptySequenceProcessor
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext())));
  }

  /**
   * Test {@link BaseProcessor#getBeanDesc()}.
   * <p>
   * Method under test: {@link BaseProcessor#getBeanDesc()}
   */
  @Test
  public void testGetBeanDesc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertEquals("Workflow Processor: null", emptySequenceProcessor.getBeanDesc());
  }

  /**
   * Test {@link BaseProcessor#getBeanDesc()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   *   <li>Then return {@code Workflow Processor: null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getBeanDesc()}
   */
  @Test
  public void testGetBeanDesc_givenEmptySequenceProcessor_thenReturnWorkflowProcessorNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Workflow Processor: null", (new EmptySequenceProcessor()).getBeanDesc());
  }

  /**
   * Test {@link BaseProcessor#setActivities(List)}.
   * <p>
   * Method under test: {@link BaseProcessor#setActivities(List)}
   */
  @Test
  public void testSetActivities() {
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
   * Test {@link BaseProcessor#setActivities(List)}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#setActivities(List)}
   */
  @Test
  public void testSetActivities_givenEmptySequenceProcessor_whenArrayList() {
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
   * Test {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}.
   * <p>
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
   * Test {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}.
   * <p>
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
   * Test {@link BaseProcessor#getActivities()}.
   * <p>
   * Method under test: {@link BaseProcessor#getActivities()}
   */
  @Test
  public void testGetActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertTrue(emptySequenceProcessor.getActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getActivities()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getActivities()}
   */
  @Test
  public void testGetActivities_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new EmptySequenceProcessor()).getActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getModuleActivities()}.
   * <p>
   * Method under test: {@link BaseProcessor#getModuleActivities()}
   */
  @Test
  public void testGetModuleActivities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertTrue(emptySequenceProcessor.getModuleActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getModuleActivities()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getModuleActivities()}
   */
  @Test
  public void testGetModuleActivities_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new EmptySequenceProcessor()).getModuleActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getBeanName()}.
   * <p>
   * Method under test: {@link BaseProcessor#getBeanName()}
   */
  @Test
  public void testGetBeanName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.getBeanName());
  }

  /**
   * Test {@link BaseProcessor#getBeanName()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getBeanName()}
   */
  @Test
  public void testGetBeanName_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).getBeanName());
  }

  /**
   * Test {@link BaseProcessor#getDefaultErrorHandler()}.
   * <p>
   * Method under test: {@link BaseProcessor#getDefaultErrorHandler()}
   */
  @Test
  public void testGetDefaultErrorHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.getDefaultErrorHandler());
  }

  /**
   * Test {@link BaseProcessor#getDefaultErrorHandler()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getDefaultErrorHandler()}
   */
  @Test
  public void testGetDefaultErrorHandler_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).getDefaultErrorHandler());
  }

  /**
   * Test {@link BaseProcessor#getBeanFactory()}.
   * <p>
   * Method under test: {@link BaseProcessor#getBeanFactory()}
   */
  @Test
  public void testGetBeanFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.getBeanFactory());
  }

  /**
   * Test {@link BaseProcessor#getBeanFactory()}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getBeanFactory()}
   */
  @Test
  public void testGetBeanFactory_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).getBeanFactory());
  }
}
