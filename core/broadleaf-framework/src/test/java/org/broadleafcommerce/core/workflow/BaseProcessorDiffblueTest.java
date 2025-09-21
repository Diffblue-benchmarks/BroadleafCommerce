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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseProcessorDiffblueTest {
  /**
   * Test {@link BaseProcessor#setBeanName(String)}.
   *
   * <p>Method under test: {@link BaseProcessor#setBeanName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseProcessor.setBeanName(String)"})
  public void testSetBeanName() {
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
   *
   * <p>Method under test: {@link BaseProcessor#setBeanFactory(BeanFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseProcessor.setBeanFactory(BeanFactory)"})
  public void testSetBeanFactory() throws BeansException {
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
   *
   * <p>Method under test: {@link BaseProcessor#getAutoRollbackOnError()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseProcessor.getAutoRollbackOnError()"})
  public void testGetAutoRollbackOnError() {
    // Arrange, Act and Assert
    assertTrue(new EmptySequenceProcessor().getAutoRollbackOnError());
  }

  /**
   * Test {@link BaseProcessor#isAllowEmptyActivities()}.
   *
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseProcessor.isAllowEmptyActivities()"})
  public void testIsAllowEmptyActivities_givenEmptySequenceProcessor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmptySequenceProcessor().isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#isAllowEmptyActivities()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseProcessor#isAllowEmptyActivities()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseProcessor.isAllowEmptyActivities()"})
  public void testIsAllowEmptyActivities_thenReturnTrue() {
    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setAllowEmptyActivities(true);

    // Act and Assert
    assertTrue(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#setAllowEmptyActivities(boolean)}.
   *
   * <p>Method under test: {@link BaseProcessor#setAllowEmptyActivities(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseProcessor.setAllowEmptyActivities(boolean)"})
  public void testSetAllowEmptyActivities() {
    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act
    emptySequenceProcessor.setAllowEmptyActivities(true);

    // Assert
    assertTrue(emptySequenceProcessor.isAllowEmptyActivities());
  }

  /**
   * Test {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)} with {@code
   * ContextRefreshedEvent}.
   *
   * <p>Method under test: {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseProcessor.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent() {
    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();

    // Act and Assert
    assertThrows(
        BeanInitializationException.class,
        () ->
            emptySequenceProcessor.onApplicationEvent(
                new ContextRefreshedEvent(mock(ApplicationContext.class))));
  }

  /**
   * Test {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)} with {@code
   * ContextRefreshedEvent}.
   *
   * <p>Method under test: {@link BaseProcessor#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseProcessor.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent2() throws BeansException {
    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setBeanFactory(new StaticListableBeanFactory());

    // Act and Assert
    assertThrows(
        UnsatisfiedDependencyException.class,
        () ->
            emptySequenceProcessor.onApplicationEvent(
                new ContextRefreshedEvent(mock(ApplicationContext.class))));
  }

  /**
   * Test {@link BaseProcessor#getBeanDesc()}.
   *
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).
   *   <li>Then return {@code Workflow Processor: null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseProcessor#getBeanDesc()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseProcessor.getBeanDesc()"})
  public void testGetBeanDesc_givenEmptySequenceProcessor_thenReturnWorkflowProcessorNull() {
    // Arrange, Act and Assert
    assertEquals("Workflow Processor: null", new EmptySequenceProcessor().getBeanDesc());
  }

  /**
   * Test {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}.
   *
   * <p>Method under test: {@link BaseProcessor#setDefaultErrorHandler(ErrorHandler)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseProcessor.setDefaultErrorHandler(ErrorHandler)"})
  public void testSetDefaultErrorHandler() {
    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler();

    // Act
    emptySequenceProcessor.setDefaultErrorHandler(defaultErrorHandler);

    // Assert
    assertSame(defaultErrorHandler, emptySequenceProcessor.getDefaultErrorHandler());
  }

  /**
   * Test {@link BaseProcessor#getActivities()}.
   *
   * <p>Method under test: {@link BaseProcessor#getActivities()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List BaseProcessor.getActivities()"})
  public void testGetActivities() {
    // Arrange, Act and Assert
    assertTrue(new EmptySequenceProcessor().getActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getModuleActivities()}.
   *
   * <p>Method under test: {@link BaseProcessor#getModuleActivities()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List BaseProcessor.getModuleActivities()"})
  public void testGetModuleActivities() {
    // Arrange, Act and Assert
    assertTrue(new EmptySequenceProcessor().getModuleActivities().isEmpty());
  }

  /**
   * Test {@link BaseProcessor#getBeanName()}.
   *
   * <p>Method under test: {@link BaseProcessor#getBeanName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseProcessor.getBeanName()"})
  public void testGetBeanName() {
    // Arrange, Act and Assert
    assertNull(new EmptySequenceProcessor().getBeanName());
  }

  /**
   * Test {@link BaseProcessor#getDefaultErrorHandler()}.
   *
   * <p>Method under test: {@link BaseProcessor#getDefaultErrorHandler()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorHandler BaseProcessor.getDefaultErrorHandler()"})
  public void testGetDefaultErrorHandler() {
    // Arrange, Act and Assert
    assertNull(new EmptySequenceProcessor().getDefaultErrorHandler());
  }

  /**
   * Test {@link BaseProcessor#getBeanFactory()}.
   *
   * <p>Method under test: {@link BaseProcessor#getBeanFactory()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BeanFactory BaseProcessor.getBeanFactory()"})
  public void testGetBeanFactory() {
    // Arrange, Act and Assert
    assertNull(new EmptySequenceProcessor().getBeanFactory());
  }
}
