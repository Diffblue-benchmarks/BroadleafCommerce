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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseProcessorDiffblueTest {
  @InjectMocks
  private EmptySequenceProcessor emptySequenceProcessor;

  /**
   * Test {@link BaseProcessor#setBeanName(String)}.
   * <p>
   * Method under test: {@link BaseProcessor#setBeanName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseProcessor.setBeanName(String)"})
  public void testSetBeanName() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act
    sequenceProcessor.setBeanName("Bean Name");

    // Assert
    assertEquals("Bean Name", sequenceProcessor.getBeanName());
    assertEquals("Workflow Processor: Bean Name", sequenceProcessor.getBeanDesc());
  }

  /**
   * Test {@link BaseProcessor#setBeanFactory(BeanFactory)}.
   * <p>
   * Method under test: {@link BaseProcessor#setBeanFactory(BeanFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseProcessor.setBeanFactory(BeanFactory)"})
  public void testSetBeanFactory() throws BeansException {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // Act
    sequenceProcessor.setBeanFactory(beanFactory);

    // Assert
    assertSame(beanFactory, sequenceProcessor.getBeanFactory());
  }

  /**
   * Test {@link BaseProcessor#getAutoRollbackOnError()}.
   * <p>
   * Method under test: {@link BaseProcessor#getAutoRollbackOnError()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseProcessor.getAutoRollbackOnError()"})
  public void testGetAutoRollbackOnError() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.getAutoRollbackOnError());
  }

  /**
   * Test {@link BaseProcessor#isAllowEmptyActivities()}.
   * <ul>
   *   <li>Given {@link SequenceProcessor} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseProcessor.isAllowEmptyActivities()"})
  public void testIsAllowEmptyActivities_givenSequenceProcessor_thenReturnFalse() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertFalse(sequenceProcessor.isAllowEmptyActivities());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseProcessor.isAllowEmptyActivities()"})
  public void testIsAllowEmptyActivities_thenReturnTrue() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();
    sequenceProcessor.setAllowEmptyActivities(true);

    // Act and Assert
    assertTrue(sequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#setAllowEmptyActivities(boolean)}.
   * <p>
   * Method under test: {@link BaseProcessor#setAllowEmptyActivities(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseProcessor.setAllowEmptyActivities(boolean)"})
  public void testSetAllowEmptyActivities() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act
    sequenceProcessor.setAllowEmptyActivities(true);

    // Assert
    assertTrue(sequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)} with {@code ContextRefreshedEvent}.
   * <p>
   * Method under test: {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseProcessor.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertThrows(BeanInitializationException.class, () -> sequenceProcessor
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext())));
  }

  /**
   * Test {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)} with {@code ContextRefreshedEvent}.
   * <p>
   * Method under test: {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseProcessor.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent2() throws BeansException {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();
    sequenceProcessor.setBeanFactory(new StaticListableBeanFactory());

    // Act and Assert
    assertThrows(UnsatisfiedDependencyException.class, () -> sequenceProcessor
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext())));
  }

  /**
   * Test {@link BaseProcessor#getBeanDesc()}.
   * <ul>
   *   <li>Given {@link SequenceProcessor} (default constructor).</li>
   *   <li>Then return {@code Workflow Processor: null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseProcessor#getBeanDesc()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseProcessor.getBeanDesc()"})
  public void testGetBeanDesc_givenSequenceProcessor_thenReturnWorkflowProcessorNull() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertEquals("Workflow Processor: null", sequenceProcessor.getBeanDesc());
  }

  /**
   * Test {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}.
   * <p>
   * Method under test: {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseProcessor.setDefaultErrorHandler(ErrorHandler)"})
  public void testSetDefaultErrorHandler() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();
    DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler();

    // Act
    sequenceProcessor.setDefaultErrorHandler(defaultErrorHandler);

    // Assert
    assertSame(defaultErrorHandler, sequenceProcessor.getDefaultErrorHandler());
  }

  /**
   * Test {@link BaseProcessor#getActivities()}.
   * <p>
   * Method under test: {@link BaseProcessor#getActivities()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List BaseProcessor.getActivities()"})
  public void testGetActivities() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.getActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getModuleActivities()}.
   * <p>
   * Method under test: {@link BaseProcessor#getModuleActivities()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List BaseProcessor.getModuleActivities()"})
  public void testGetModuleActivities() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.getModuleActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getBeanName()}.
   * <p>
   * Method under test: {@link BaseProcessor#getBeanName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseProcessor.getBeanName()"})
  public void testGetBeanName() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertNull(sequenceProcessor.getBeanName());
  }

  /**
   * Test {@link BaseProcessor#getDefaultErrorHandler()}.
   * <p>
   * Method under test: {@link BaseProcessor#getDefaultErrorHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ErrorHandler BaseProcessor.getDefaultErrorHandler()"})
  public void testGetDefaultErrorHandler() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertNull(sequenceProcessor.getDefaultErrorHandler());
  }

  /**
   * Test {@link BaseProcessor#getBeanFactory()}.
   * <p>
   * Method under test: {@link BaseProcessor#getBeanFactory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BeanFactory BaseProcessor.getBeanFactory()"})
  public void testGetBeanFactory() {
    // Arrange
    SequenceProcessor<?, ?> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertNull(sequenceProcessor.getBeanFactory());
  }
}
