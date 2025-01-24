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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.Field;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelper;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BLCFieldUtils.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BLCFieldUtilsDiffblueTest {
  @Autowired
  private BLCFieldUtils bLCFieldUtils;

  @MockBean
  private DynamicDaoHelper dynamicDaoHelper;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  /**
   * Test
   * {@link BLCFieldUtils#BLCFieldUtils(boolean, boolean, EntityConfiguration, DynamicDaoHelper)}.
   * <p>
   * Method under test:
   * {@link BLCFieldUtils#BLCFieldUtils(boolean, boolean, EntityConfiguration, DynamicDaoHelper)}
   */
  @Test
  public void testNewBLCFieldUtils() {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act and Assert
    assertNull((new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl())).entityConfiguration
        .getEntityContexts());
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  public void testGetSingleField_whenBLCFieldUtils_thenReturnNull() throws IllegalStateException {
    // Arrange
    Class<BLCFieldUtils> clazz = BLCFieldUtils.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  public void testGetSingleField_whenBLCFieldUtils_thenReturnNull2() throws IllegalStateException {
    // Arrange
    Class<BLCFieldUtils> clazz = BLCFieldUtils.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "org.broadleafcommerce.common.util.BLCFieldUtils"));
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  public void testGetSingleField_whenJavaLangObject_thenReturnNull() throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  public void testGetSingleField_whenJavaLangObject_thenReturnNull2() throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "org.broadleafcommerce.common.util.BLCFieldUtils"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField2() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(false, true, entityConfiguration, new DynamicDaoHelperImpl());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField3() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, false, entityConfiguration, new DynamicDaoHelperImpl());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField4() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField5() throws IllegalStateException, BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    entityConfiguration.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean())).thenReturn(null);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, helper);
    Class<Object> clazz = Object.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetField6() throws IllegalStateException {
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
    //   Cannot mock/spy boolean
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

    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    bLCFieldUtils.getField(clazz, "Field Name");
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <ul>
   *   <li>Given {@link DynamicDaoHelper}
   * {@link DynamicDaoHelper#getUpDownInheritance(Class, boolean, boolean)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField_givenDynamicDaoHelperGetUpDownInheritanceReturnNull() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean())).thenReturn(null);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, new EntityConfiguration(), helper);
    Class<Object> clazz = Object.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then calls
   * {@link DynamicDaoHelper#getUpDownInheritance(Class, boolean, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField_givenJavaLangObject_thenCallsGetUpDownInheritance() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    Class<Object> forNameResult = Object.class;
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[]{forNameResult});
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, new EntityConfiguration(), helper);
    Class<Object> clazz = Object.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.util.BLCFieldUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  public void testGetField_whenOrgBroadleafcommerceCommonUtilBLCFieldUtils() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean())).thenReturn(null);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, new EntityConfiguration(), helper);
    Class<BLCFieldUtils> clazz = BLCFieldUtils.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test
   * {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}.
   * <p>
   * Method under test:
   * {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}
   */
  @Test
  public void testGetClassForField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl());
    DynamicDaoHelperImpl helper = new DynamicDaoHelperImpl();
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getClassForField(helper, "ABC123", null, new Class[]{forNameResult}));
  }

  /**
   * Test
   * {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}.
   * <p>
   * Method under test:
   * {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetClassForField2() {
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
    //   Cannot mock/spy boolean
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

    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    bLCFieldUtils.getClassForField(dynamicDaoHelper, "ABC123", null, new Class[]{forNameResult});
  }

  /**
   * Test
   * {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}
   */
  @Test
  public void testGetClassForField_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl());
    DynamicDaoHelperImpl helper = new DynamicDaoHelperImpl();
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getClassForField(helper, "ABC123", null, new Class[]{forNameResult}));
  }
}
