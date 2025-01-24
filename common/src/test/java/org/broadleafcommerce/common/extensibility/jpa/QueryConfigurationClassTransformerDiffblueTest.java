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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.ArrayMemberValue;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {QueryConfigurationClassTransformer.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryConfigurationClassTransformerDiffblueTest {
  @Autowired
  private List<NamedQuery> list;

  @Autowired
  private List<NamedNativeQuery> list2;

  @Autowired
  private List<String> list3;

  @MockBean
  private NamedNativeQuery namedNativeQuery;

  @MockBean
  private NamedQuery namedQuery;

  @Autowired
  private QueryConfigurationClassTransformer queryConfigurationClassTransformer;

  @MockBean
  private String string;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link QueryConfigurationClassTransformer#QueryConfigurationClassTransformer(List, List, List)}
   *   <li>
   * {@link QueryConfigurationClassTransformer#compileJPAProperties(Properties, Object)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();

    // Act
    QueryConfigurationClassTransformer actualQueryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    actualQueryConfigurationClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);

    // Assert that nothing has changed
    assertTrue(actualQueryConfigurationClassTransformer.managedClassNames.isEmpty());
    assertTrue(actualQueryConfigurationClassTransformer.namedQueries.isEmpty());
    assertTrue(actualQueryConfigurationClassTransformer.nativeQueries.isEmpty());
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTransform() throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
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
    //   Cannot mock/spy class java.lang.String
    //   Mockito cannot mock/spy because :
    //    - final class
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
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSource codeSource = new CodeSource(toURLResult, new CodeSigner[]{new CodeSigner(null, null)});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act
    queryConfigurationClassTransformer.transform(loader, "Class Name", classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8"));
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#processClassLevelAnnotations(ConstPool, ClassPool, Object)}.
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#processClassLevelAnnotations(ConstPool, ClassPool, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessClassLevelAnnotations() throws NotFoundException {
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
    //   Cannot mock/spy class java.lang.String
    //   Mockito cannot mock/spy because :
    //    - final class
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
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    queryConfigurationClassTransformer.processClassLevelAnnotations(constantPool, ClassPool.getDefault(),
        BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#processClassLevelAnnotations(ConstPool, ClassPool, Object)}.
   * <ul>
   *   <li>Then calls {@link CtClass#getComponentType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#processClassLevelAnnotations(ConstPool, ClassPool, Object)}
   */
  @Test
  public void testProcessClassLevelAnnotations_thenCallsGetComponentType() throws NotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();
    QueryConfigurationClassTransformer queryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    CtClass c = mock(CtClass.class);
    when(c.getComponentType()).thenThrow(new NotFoundException("Msg"));
    when(c.isArray()).thenReturn(true);
    when(c.getName()).thenReturn("Name");

    ConstPool constantPool = new ConstPool("Thisclass");
    constantPool.addClassInfo(c);

    // Act
    queryConfigurationClassTransformer.processClassLevelAnnotations(constantPool, ClassPool.getDefault(),
        BLCFieldUtils.NULL_FIELD);

    // Assert that nothing has changed
    verify(c).getComponentType();
    verify(c).getName();
    verify(c, atLeast(1)).isArray();
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#prepareNativeQueries(ConstPool, ClassPool, ArrayMemberValue)}.
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#prepareNativeQueries(ConstPool, ClassPool, ArrayMemberValue)}
   */
  @Test
  public void testPrepareNativeQueries() throws NotFoundException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();
    QueryConfigurationClassTransformer queryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    ConstPool constantPool = new ConstPool("Thisclass");
    ClassPool pool = ClassPool.getDefault();
    ArrayMemberValue queryArray = new ArrayMemberValue(new ConstPool("Thisclass"));

    // Act
    queryConfigurationClassTransformer.prepareNativeQueries(constantPool, pool, queryArray);

    // Assert
    assertEquals(0, queryArray.getValue().length);
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#prepareNamedQueries(ConstPool, ClassPool, ArrayMemberValue)}.
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#prepareNamedQueries(ConstPool, ClassPool, ArrayMemberValue)}
   */
  @Test
  public void testPrepareNamedQueries() throws NotFoundException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();
    QueryConfigurationClassTransformer queryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    ConstPool constantPool = new ConstPool("Thisclass");
    ClassPool pool = ClassPool.getDefault();
    ArrayMemberValue queryArray = new ArrayMemberValue(new ConstPool("Thisclass"));

    // Act
    queryConfigurationClassTransformer.prepareNamedQueries(constantPool, pool, queryArray);

    // Assert
    assertEquals(0, queryArray.getValue().length);
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#prepareQueryHints(ConstPool, List, QueryHint)}.
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#prepareQueryHints(ConstPool, List, QueryHint)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPrepareQueryHints() {
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
    //   Cannot mock/spy class java.lang.String
    //   Mockito cannot mock/spy because :
    //    - final class
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
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    queryConfigurationClassTransformer.prepareQueryHints(constantPool, new ArrayList<>(), null);
  }
}
