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
package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AccountNumberMask.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountNumberMaskDiffblueTest {
  @Autowired
  private AccountNumberMask accountNumberMask;

  @Autowired
  private List<UnmaskRange> list;

  @MockBean
  private UnmaskRange unmaskRange;

  /**
   * Test {@link AccountNumberMask#AccountNumberMask(List, char)}.
   * <p>
   * Method under test: {@link AccountNumberMask#AccountNumberMask(List, char)}
   */
  @Test
  public void testNewAccountNumberMask() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     AccountNumberMask.maskCharacter
    //     AccountNumberMask.ranges

    // Arrange and Act
    new AccountNumberMask(new ArrayList<>(), '7');

  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   * <p>
   * Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMask() {
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
    //   Cannot mock/spy char
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
    accountNumberMask.mask("42");
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   * <ul>
   *   <li>Then return {@code 72}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  public void testMask_thenReturn72() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<UnmaskRange> ranges = new ArrayList<>();
    ranges.add(new UnmaskRange(1, 1));

    // Act and Assert
    assertEquals("72", (new AccountNumberMask(ranges, '7')).mask("42"));
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 77}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  public void testMask_when42_thenReturn77() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("77", (new AccountNumberMask(new ArrayList<>(), '7')).mask("42"));
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  public void testMask_whenNull_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new AccountNumberMask(new ArrayList<>(), '7')).mask(null));
  }
}
