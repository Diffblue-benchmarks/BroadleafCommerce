/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.broadleafcommerce.test.common.properties.sources.CommonFrameworkTestProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareSharedProperties;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

public class BroadleafEnvironmentConfiguringApplicationListenerDiffblueTest {
  /**
   * Test
   * {@link BroadleafEnvironmentConfiguringApplicationListener#initialize(ConfigurableApplicationContext)}.
   * <ul>
   *   <li>Given {@link ApplicationListener}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfiguringApplicationListener#initialize(ConfigurableApplicationContext)}
   */
  @Test
  public void testInitialize_givenApplicationListener() {
    // Arrange
    BroadleafEnvironmentConfiguringApplicationListener broadleafEnvironmentConfiguringApplicationListener = new BroadleafEnvironmentConfiguringApplicationListener();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    // Act
    broadleafEnvironmentConfiguringApplicationListener.initialize(applicationContext);

    // Assert
    ConfigurableEnvironment environment = applicationContext.getEnvironment();
    MutablePropertySources propertySources = environment.getPropertySources();
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(4, collectResult.size());
    PropertySource<?> getResult = collectResult.get(2);
    Collection<PropertySource<?>> propertySources2 = ((CompositePropertySource) getResult).getPropertySources();
    assertEquals(2, propertySources2.size());
    assertTrue(propertySources2 instanceof Set);
    PropertySource<?> getResult2 = collectResult.get(3);
    Collection<PropertySource<?>> propertySources3 = ((CompositePropertySource) getResult2).getPropertySources();
    assertEquals(2, propertySources3.size());
    assertTrue(propertySources3 instanceof Set);
    assertTrue(environment instanceof StandardReactiveWebEnvironment);
    assertTrue(getResult instanceof CompositePropertySource);
    assertTrue(getResult2 instanceof CompositePropertySource);
    String[] defaultProfiles = environment.getDefaultProfiles();
    assertEquals("development", defaultProfiles[1]);
    assertEquals(2, defaultProfiles.length);
    assertEquals(4, propertySources.size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    assertEquals(BroadleafEnvironmentConfigurer.FRAMEWORK_SOURCES_NAME, getResult2.getName());
    assertEquals(BroadleafEnvironmentConfigurer.PROFILE_AWARE_SOURCES_NAME, getResult.getName());
    assertArrayEquals(new String[]{"test.property.source", "dev.only.property"},
        ((CompositePropertySource) getResult).getPropertyNames());
    assertArrayEquals(new String[]{"shared.override.test", "test.property.source",
        "spring.main.allow-circular-references", "global.admin.url",
        "asset.server.max.generated.file.system.directories", "site.domain.resolver.strip.subdomains",
        "i18n.translation.enabled", "stateless.request.path", "sitemap.createIfNotFound",
        "seo.category.description.pattern", "staticResourceBrowserCacheSeconds", "thymeleaf.threadLocalCleanup.enabled",
        "messages.useCodeAsDefaultMessage", "streaming.transaction.lock.retry.max", "messages.cacheSeconds",
        "default.schema.sequence.generator", "site.strict.validate.production.changes", "bundle.enabled",
        "ignore.no.process.detail.logger.configuration", "url.fragment.separator", "seo.product.description.pattern",
        "admin.strict.validate.production.changes", "enterprise.use.production.sandbox.mode",
        "allow.product.parent.category.sorting", "cache.page.templates", "exploitProtection.xssEnabled",
        "seo.category.title.pattern", "minify.closure.compiler.warningLevel", "seo.product.title.pattern",
        "workflow.auto.rollback.on.error", "cache.page.templates.ttl", "spring.main.allow-bean-definition-overriding",
        "exploitProtection.xsrfEnabled", "admin.baseurl", "cache.stat.log.resolution", "googleAnalytics.testLocal",
        "file.service.temp.file.base.directory", "minify.enabled", "asset.server.file.classpath.directory",
        "resource.transformer.caching.enabled", "hibernate.id.generator.stored_last_used",
        "auto.correct.sequence.generator.inconsistencies", "site.baseurl", "asset.server.file.system.path",
        "minify.closure.compiler.languageOut", "detect.sequence.generator.inconsistencies",
        "streaming.transaction.item.page.size", "resource.versioning.enabled", "query.cacheable",
        "spring.cache.jcache.config", "disable.all.process.detail.logging", "cookies.use.secure",
        "sitemap.cache.seconds", "thymeleaf.useLayoutDialect", "sitemap.gzip.files", "system.property.cache.timeout",
        "minify.closure.compiler.languageIn", "resource.caching.enabled", "global.admin.prefix"},
        ((CompositePropertySource) getResult2).getPropertyNames());
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfiguringApplicationListener#initialize(ConfigurableApplicationContext)}.
   * <ul>
   *   <li>When
   * {@link AnnotationConfigReactiveWebApplicationContext#AnnotationConfigReactiveWebApplicationContext()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfiguringApplicationListener#initialize(ConfigurableApplicationContext)}
   */
  @Test
  public void testInitialize_whenAnnotationConfigReactiveWebApplicationContext() {
    // Arrange
    BroadleafEnvironmentConfiguringApplicationListener broadleafEnvironmentConfiguringApplicationListener = new BroadleafEnvironmentConfiguringApplicationListener();
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();

    // Act
    broadleafEnvironmentConfiguringApplicationListener.initialize(applicationContext);

    // Assert
    ConfigurableEnvironment environment = applicationContext.getEnvironment();
    MutablePropertySources propertySources = environment.getPropertySources();
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(4, collectResult.size());
    PropertySource<?> getResult = collectResult.get(2);
    Collection<PropertySource<?>> propertySources2 = ((CompositePropertySource) getResult).getPropertySources();
    assertEquals(2, propertySources2.size());
    assertTrue(propertySources2 instanceof Set);
    PropertySource<?> getResult2 = collectResult.get(3);
    Collection<PropertySource<?>> propertySources3 = ((CompositePropertySource) getResult2).getPropertySources();
    assertEquals(2, propertySources3.size());
    assertTrue(propertySources3 instanceof Set);
    assertTrue(environment instanceof StandardReactiveWebEnvironment);
    assertTrue(getResult instanceof CompositePropertySource);
    assertTrue(getResult2 instanceof CompositePropertySource);
    String[] defaultProfiles = environment.getDefaultProfiles();
    assertEquals("development", defaultProfiles[1]);
    assertEquals(2, defaultProfiles.length);
    assertEquals(4, propertySources.size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    assertEquals(BroadleafEnvironmentConfigurer.FRAMEWORK_SOURCES_NAME, getResult2.getName());
    assertEquals(BroadleafEnvironmentConfigurer.PROFILE_AWARE_SOURCES_NAME, getResult.getName());
    assertArrayEquals(new String[]{"test.property.source", "dev.only.property"},
        ((CompositePropertySource) getResult).getPropertyNames());
    assertArrayEquals(new String[]{"shared.override.test", "test.property.source",
        "spring.main.allow-circular-references", "global.admin.url",
        "asset.server.max.generated.file.system.directories", "site.domain.resolver.strip.subdomains",
        "i18n.translation.enabled", "stateless.request.path", "sitemap.createIfNotFound",
        "seo.category.description.pattern", "staticResourceBrowserCacheSeconds", "thymeleaf.threadLocalCleanup.enabled",
        "messages.useCodeAsDefaultMessage", "streaming.transaction.lock.retry.max", "messages.cacheSeconds",
        "default.schema.sequence.generator", "site.strict.validate.production.changes", "bundle.enabled",
        "ignore.no.process.detail.logger.configuration", "url.fragment.separator", "seo.product.description.pattern",
        "admin.strict.validate.production.changes", "enterprise.use.production.sandbox.mode",
        "allow.product.parent.category.sorting", "cache.page.templates", "exploitProtection.xssEnabled",
        "seo.category.title.pattern", "minify.closure.compiler.warningLevel", "seo.product.title.pattern",
        "workflow.auto.rollback.on.error", "cache.page.templates.ttl", "spring.main.allow-bean-definition-overriding",
        "exploitProtection.xsrfEnabled", "admin.baseurl", "cache.stat.log.resolution", "googleAnalytics.testLocal",
        "file.service.temp.file.base.directory", "minify.enabled", "asset.server.file.classpath.directory",
        "resource.transformer.caching.enabled", "hibernate.id.generator.stored_last_used",
        "auto.correct.sequence.generator.inconsistencies", "site.baseurl", "asset.server.file.system.path",
        "minify.closure.compiler.languageOut", "detect.sequence.generator.inconsistencies",
        "streaming.transaction.item.page.size", "resource.versioning.enabled", "query.cacheable",
        "spring.cache.jcache.config", "disable.all.process.detail.logging", "cookies.use.secure",
        "sitemap.cache.seconds", "thymeleaf.useLayoutDialect", "sitemap.gzip.files", "system.property.cache.timeout",
        "minify.closure.compiler.languageIn", "resource.caching.enabled", "global.admin.prefix"},
        ((CompositePropertySource) getResult2).getPropertyNames());
  }

  /**
   * Test new {@link BroadleafEnvironmentConfiguringApplicationListener} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafEnvironmentConfiguringApplicationListener}
   */
  @Test
  public void testNewBroadleafEnvironmentConfiguringApplicationListener() {
    // Arrange and Act
    BroadleafEnvironmentConfiguringApplicationListener actualBroadleafEnvironmentConfiguringApplicationListener = new BroadleafEnvironmentConfiguringApplicationListener();

    // Assert
    List<FrameworkCommonClasspathPropertySource> frameworkSources = actualBroadleafEnvironmentConfiguringApplicationListener
        .getFrameworkSources();
    assertEquals(2, frameworkSources.size());
    FrameworkCommonClasspathPropertySource getResult = frameworkSources.get(0);
    assertTrue(getResult instanceof BroadleafCommonPropertySource);
    List<BroadleafSharedOverrideProfileAwarePropertySource> profileAwareSources = actualBroadleafEnvironmentConfiguringApplicationListener
        .getProfileAwareSources();
    assertEquals(3, profileAwareSources.size());
    BroadleafSharedOverrideProfileAwarePropertySource getResult2 = profileAwareSources.get(0);
    assertTrue(getResult2 instanceof DefaultRuntimeEnvironmentProfileAwarePropertySource);
    FrameworkCommonClasspathPropertySource getResult3 = frameworkSources.get(1);
    assertTrue(getResult3 instanceof CommonFrameworkTestProperties);
    BroadleafSharedOverrideProfileAwarePropertySource getResult4 = profileAwareSources.get(1);
    assertTrue(getResult4 instanceof ProfileAwareProperties);
    BroadleafSharedOverrideProfileAwarePropertySource getResult5 = profileAwareSources.get(2);
    assertTrue(getResult5 instanceof ProfileAwareSharedProperties);
    assertEquals("common-test-properties", getResult3.getClasspathFolder());
    assertEquals("common-test-properties/profile-aware-properties", getResult4.getClasspathFolder());
    assertEquals("common-test-properties/profile-aware-shared-properties", getResult5.getClasspathFolder());
    assertEquals("config/bc/", getResult.getClasspathFolder());
    assertEquals("development",
        actualBroadleafEnvironmentConfiguringApplicationListener.getDeprecatedDefaultProfileKey());
    assertEquals("runtime-properties", getResult2.getClasspathFolder());
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        ((CommonFrameworkTestProperties) getResult3).getOrder());
  }
}
