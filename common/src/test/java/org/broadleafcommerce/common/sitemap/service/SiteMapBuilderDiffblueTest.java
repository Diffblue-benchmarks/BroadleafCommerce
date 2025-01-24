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
package org.broadleafcommerce.common.sitemap.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLSetWrapper;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SiteMapBuilder.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteMapBuilderDiffblueTest {
  @MockBean
  private FileWorkArea fileWorkArea;

  @Autowired
  private SiteMapBuilder siteMapBuilder;

  @MockBean
  private SiteMapConfiguration siteMapConfiguration;

  /**
   * Test
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}.
   * <p>
   * Method under test:
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewSiteMapBuilder() {
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

    // Arrange and Act
    new SiteMapBuilder(siteMapConfiguration, new FileWorkArea(), "https://example.org/example", true);

  }

  /**
   * Test
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}.
   * <ul>
   *   <li>Then return BaseUrl is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}
   */
  @Test
  public void testNewSiteMapBuilder_thenReturnBaseUrlIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = mock(SiteMapConfigurationImpl.class);

    // Act
    SiteMapBuilder actualSiteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(),
        "https://example.org/example", true);

    // Assert
    assertEquals("https://example.org/example", actualSiteMapBuilder.getBaseUrl());
    assertTrue(actualSiteMapBuilder.getIndexedFileNames().isEmpty());
    assertTrue(actualSiteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
    assertTrue(actualSiteMapBuilder.gzipSiteMapFiles);
  }

  /**
   * Test
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}.
   * <ul>
   *   <li>Then {@link SiteMapBuilder#siteMapConfig} return
   * {@link SiteMapConfigurationImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}
   */
  @Test
  public void testNewSiteMapBuilder_thenSiteMapConfigReturnSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act and Assert
    SiteMapConfiguration siteMapConfiguration = (new SiteMapBuilder(siteMapConfig, new FileWorkArea(),
        "https://example.org/example", true)).siteMapConfig;
    assertTrue(siteMapConfiguration instanceof SiteMapConfigurationImpl);
    ModuleConfigurationType moduleConfigurationType = siteMapConfiguration.getModuleConfigurationType();
    assertEquals("SITE_MAP", moduleConfigurationType.getType());
    assertEquals("Site Map Generator", moduleConfigurationType.getFriendlyType());
    assertEquals("sitemap###.xml", siteMapConfiguration.getSiteMapIndexFilePattern());
    assertEquals("sitemap.xml", siteMapConfiguration.getIndexedSiteMapFileName());
    assertEquals("sitemap.xml", siteMapConfiguration.getSiteMapFileName());
    assertEquals('N', ((SiteMapConfigurationImpl) siteMapConfiguration).getArchived().charValue());
    Auditable auditable = siteMapConfiguration.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(siteMapConfiguration.getId());
    assertNull(siteMapConfiguration.getModuleName());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(siteMapConfiguration.getActiveEndDate());
    assertNull(siteMapConfiguration.getActiveStartDate());
    assertEquals(100, siteMapConfiguration.getPriority().intValue());
    assertEquals(50000, siteMapConfiguration.getMaximumUrlEntriesPerFile().intValue());
    assertFalse(siteMapConfiguration.getIsDefault());
    assertTrue(siteMapConfiguration.getSiteMapGeneratorConfigurations().isEmpty());
  }

  /**
   * Test {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}.
   * <p>
   * Method under test: {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}
   */
  @Test
  public void testAddUrl() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);
    SiteMapURLWrapper urlWrapper = new SiteMapURLWrapper();

    // Act
    siteMapBuilder.addUrl(urlWrapper);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    assertSame(urlWrapper, siteMapUrlWrappers.get(0));
  }

  /**
   * Test {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is
   * {@code 50000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}
   */
  @Test
  public void testAddUrl_givenAuditableCreatedByIs50000() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(50000L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(50000L);

    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setAuditable(auditable);
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);
    SiteMapURLWrapper urlWrapper = new SiteMapURLWrapper();

    // Act
    siteMapBuilder.addUrl(urlWrapper);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    assertSame(urlWrapper, siteMapUrlWrappers.get(0));
  }

  /**
   * Test {@link SiteMapBuilder#persistXMLDocument(String, Object)}.
   * <p>
   * Method under test: {@link SiteMapBuilder#persistXMLDocument(String, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistXMLDocument() {
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

    // Arrange and Act
    siteMapBuilder.persistXMLDocument("foo.txt", BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link SiteMapBuilder#persistIndexedURLSetWrapper(SiteMapURLSetWrapper)}.
   * <p>
   * Method under test:
   * {@link SiteMapBuilder#persistIndexedURLSetWrapper(SiteMapURLSetWrapper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistIndexedURLSetWrapper() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.file.domain.FileWorkArea.getFilePathLocation(FileWorkArea.java:39)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistXMLDocument(SiteMapBuilder.java:95)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistIndexedURLSetWrapper(SiteMapBuilder.java:124)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLSetWrapper urlSetWrapper = new SiteMapURLSetWrapper();
    urlSetWrapper.setSiteMapUrlWrappers(new ArrayList<>());

    // Act
    siteMapBuilder.persistIndexedURLSetWrapper(urlSetWrapper);
  }

  /**
   * Test
   * {@link SiteMapBuilder#persistIndexedURLSetWrapper(SiteMapURLSetWrapper)}.
   * <p>
   * Method under test:
   * {@link SiteMapBuilder#persistIndexedURLSetWrapper(SiteMapURLSetWrapper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistIndexedURLSetWrapper2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access files (file '/directory/foo.txt/sitemap1.xml', permission 'write').
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea,
        "https://example.org/example", true);

    SiteMapURLSetWrapper urlSetWrapper = new SiteMapURLSetWrapper();
    urlSetWrapper.setSiteMapUrlWrappers(new ArrayList<>());

    // Act
    siteMapBuilder.persistIndexedURLSetWrapper(urlSetWrapper);
  }

  /**
   * Test {@link SiteMapBuilder#persistNonIndexedSiteMap()}.
   * <p>
   * Method under test: {@link SiteMapBuilder#persistNonIndexedSiteMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistNonIndexedSiteMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.file.domain.FileWorkArea.getFilePathLocation(FileWorkArea.java:39)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistXMLDocument(SiteMapBuilder.java:95)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistNonIndexedSiteMap(SiteMapBuilder.java:134)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .persistNonIndexedSiteMap();
  }

  /**
   * Test {@link SiteMapBuilder#persistNonIndexedSiteMap()}.
   * <ul>
   *   <li>Given {@link FileWorkArea} (default constructor) FilePathLocation is
   * {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#persistNonIndexedSiteMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistNonIndexedSiteMap_givenFileWorkAreaFilePathLocationIsDirectoryFooTxt() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access files (file '/directory/foo.txt/sitemap.xml', permission 'write').
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    // Act
    (new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true))
        .persistNonIndexedSiteMap();
  }

  /**
   * Test {@link SiteMapBuilder#persistIndexedSiteMap()}.
   * <p>
   * Method under test: {@link SiteMapBuilder#persistIndexedSiteMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistIndexedSiteMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.file.domain.FileWorkArea.getFilePathLocation(FileWorkArea.java:39)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistXMLDocument(SiteMapBuilder.java:95)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistIndexedURLSetWrapper(SiteMapBuilder.java:124)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistIndexedSiteMap(SiteMapBuilder.java:146)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .persistIndexedSiteMap();
  }

  /**
   * Test {@link SiteMapBuilder#persistIndexedSiteMap()}.
   * <ul>
   *   <li>Given {@link FileWorkArea} (default constructor) FilePathLocation is
   * {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#persistIndexedSiteMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistIndexedSiteMap_givenFileWorkAreaFilePathLocationIsDirectoryFooTxt() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access files (file '/directory/foo.txt/sitemap1.xml', permission 'write').
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    // Act
    (new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true))
        .persistIndexedSiteMap();
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code sitemap1.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_givenAuditableCreatedByIsOne_thenReturnSitemap1Xml() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setAuditable(auditable);

    // Act and Assert
    assertEquals("sitemap1.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturn1() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###");

    // Act and Assert
    assertEquals("1", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1Indexed Site Map File Pattern}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturn1IndexedSiteMapFilePattern() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###Indexed Site Map File Pattern");

    // Act and Assert
    assertEquals("1Indexed Site Map File Pattern",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturn1Xml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###.xml");

    // Act and Assert
    assertEquals("1.xml", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1sitemap.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturn1sitemapXml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###sitemap.xml");

    // Act and Assert
    assertEquals("1sitemap.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1###}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturn12() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("######");

    // Act and Assert
    assertEquals("1###", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturn13() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###/");

    // Act and Assert
    assertEquals("1/", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 142}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturn142() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###42");

    // Act and Assert
    assertEquals("142", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code Indexed Site Map File Pattern1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturnIndexedSiteMapFilePattern1() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern###");

    // Act and Assert
    assertEquals("Indexed Site Map File Pattern1",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code sitemap1.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName_thenReturnSitemap1Xml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act and Assert
    assertEquals("sitemap1.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#persistSiteMap()}.
   * <p>
   * Method under test: {@link SiteMapBuilder#persistSiteMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistSiteMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.file.domain.FileWorkArea.getFilePathLocation(FileWorkArea.java:39)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistXMLDocument(SiteMapBuilder.java:95)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistNonIndexedSiteMap(SiteMapBuilder.java:134)
    //       at org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.persistSiteMap(SiteMapBuilder.java:188)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true)).persistSiteMap();
  }

  /**
   * Test {@link SiteMapBuilder#persistSiteMap()}.
   * <ul>
   *   <li>Given {@link FileWorkArea} (default constructor) FilePathLocation is
   * {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#persistSiteMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistSiteMap_givenFileWorkAreaFilePathLocationIsDirectoryFooTxt() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access files (file '/directory/foo.txt/sitemap.xml', permission 'write').
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    // Act
    (new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true))
        .persistSiteMap();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapBuilder#getBaseUrl()}
   *   <li>{@link SiteMapBuilder#getIndexedFileNames()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    String actualBaseUrl = siteMapBuilder.getBaseUrl();

    // Assert
    assertEquals("https://example.org/example", actualBaseUrl);
    assertTrue(siteMapBuilder.getIndexedFileNames().isEmpty());
  }
}
