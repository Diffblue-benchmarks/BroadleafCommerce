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
package org.broadleafcommerce.common.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafModuleRegistration.BroadleafModuleEnum.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafModuleRegistrationDiffblueTest {
  @Autowired
  private BroadleafModuleRegistration.BroadleafModuleEnum broadleafModuleEnum;

  /**
   * Test BroadleafModuleEnum
   * {@link BroadleafModuleEnum#equalsModuleName(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafModuleRegistration.BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBroadleafModuleEnumEqualsModuleName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:98)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   org.mockito.exceptions.base.MockitoException: 
    //   Cannot mock/spy int
    //   Mockito cannot mock/spy because :
    //    - primitive type
    //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:158)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:185)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:167)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:141)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:129)
    //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:325)
    //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:191)
    //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:756)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:573)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT.equalsModuleName("Name");
  }

  /**
   * Test BroadleafModuleEnum
   * {@link BroadleafModuleEnum#equalsModuleName(String)}.
   * <ul>
   *   <li>When {@code ACCOUNT}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafModuleRegistration.BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  public void testBroadleafModuleEnumEqualsModuleName_whenAccount_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT.equalsModuleName("ACCOUNT"));
  }

  /**
   * Test BroadleafModuleEnum
   * {@link BroadleafModuleEnum#equalsModuleName(String)}.
   * <ul>
   *   <li>When {@code Account}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafModuleRegistration.BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  public void testBroadleafModuleEnumEqualsModuleName_whenAccount_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT.equalsModuleName("Account"));
  }

  /**
   * Test BroadleafModuleEnum
   * {@link BroadleafModuleEnum#equalsModuleName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafModuleRegistration.BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  public void testBroadleafModuleEnumEqualsModuleName_whenName_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT.equalsModuleName("Name"));
  }

  /**
   * Test BroadleafModuleEnum getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafModuleRegistration.BroadleafModuleEnum#getName()}
   *   <li>{@link BroadleafModuleRegistration.BroadleafModuleEnum#toString()}
   * </ul>
   */
  @Test
  public void testBroadleafModuleEnumGettersAndSetters() {
    // Arrange
    BroadleafModuleRegistration.BroadleafModuleEnum valueOfResult = BroadleafModuleRegistration.BroadleafModuleEnum
        .valueOf("ACCOUNT");

    // Act
    String actualName = valueOfResult.getName();

    // Assert
    assertEquals("Account", actualName);
    assertEquals("Account", valueOfResult.toString());
  }
}
