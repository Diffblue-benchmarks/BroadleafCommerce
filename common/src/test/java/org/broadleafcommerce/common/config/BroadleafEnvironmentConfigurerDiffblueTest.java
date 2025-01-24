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
package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.test.common.properties.sources.CommonFrameworkTestProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareSharedProperties;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafEnvironmentConfigurer.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafEnvironmentConfigurerDiffblueTest {
  @Autowired
  private BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer;

  /**
   * Test {@link BroadleafEnvironmentConfigurer#getFrameworkSources()}.
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#getFrameworkSources()}
   */
  @Test
  public void testGetFrameworkSources() {
    // Arrange and Act
    List<FrameworkCommonClasspathPropertySource> actualFrameworkSources = (new BroadleafEnvironmentConfigurer())
        .getFrameworkSources();

    // Assert
    assertEquals(2, actualFrameworkSources.size());
    FrameworkCommonClasspathPropertySource getResult = actualFrameworkSources.get(0);
    assertTrue(getResult instanceof BroadleafCommonPropertySource);
    FrameworkCommonClasspathPropertySource getResult2 = actualFrameworkSources.get(1);
    assertTrue(getResult2 instanceof CommonFrameworkTestProperties);
    assertEquals("common-test-properties", getResult2.getClasspathFolder());
    assertEquals("config/bc/", getResult.getClasspathFolder());
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        ((CommonFrameworkTestProperties) getResult2).getOrder());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#getProfileAwareSources()}.
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#getProfileAwareSources()}
   */
  @Test
  public void testGetProfileAwareSources() {
    // Arrange and Act
    List<BroadleafSharedOverrideProfileAwarePropertySource> actualProfileAwareSources = (new BroadleafEnvironmentConfigurer())
        .getProfileAwareSources();

    // Assert
    assertEquals(3, actualProfileAwareSources.size());
    BroadleafSharedOverrideProfileAwarePropertySource getResult = actualProfileAwareSources.get(0);
    assertTrue(getResult instanceof DefaultRuntimeEnvironmentProfileAwarePropertySource);
    BroadleafSharedOverrideProfileAwarePropertySource getResult2 = actualProfileAwareSources.get(1);
    assertTrue(getResult2 instanceof ProfileAwareProperties);
    BroadleafSharedOverrideProfileAwarePropertySource getResult3 = actualProfileAwareSources.get(2);
    assertTrue(getResult3 instanceof ProfileAwareSharedProperties);
    assertEquals("common-test-properties/profile-aware-properties", getResult2.getClasspathFolder());
    assertEquals("common-test-properties/profile-aware-shared-properties", getResult3.getClasspathFolder());
    assertEquals("runtime-properties", getResult.getClasspathFolder());
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConfigure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer = new BroadleafEnvironmentConfigurer();
    StandardReactiveWebEnvironment environment = new StandardReactiveWebEnvironment();

    // Act
    broadleafEnvironmentConfigurer.configure(environment);

    // Assert
    String[] defaultProfiles = environment.getDefaultProfiles();
    MutablePropertySources propertySources = environment.getPropertySources();
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(4, collectResult.size());
    PropertySource<?> getResult = collectResult.get(3);
    Collection<PropertySource<?>> propertySources2 = ((CompositePropertySource) getResult).getPropertySources();
    assertEquals(2, propertySources2.size());
    assertTrue(propertySources2 instanceof Set);
    Iterator<PropertySource<?>> iteratorResult = propertySources.iterator();
    PropertySource<?> nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof CompositePropertySource);
    assertTrue(getResult instanceof CompositePropertySource);
    assertEquals("development", defaultProfiles[1]);
    assertEquals(2, defaultProfiles.length);
    assertEquals(4, propertySources.size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    assertTrue(iteratorResult.hasNext());
    assertEquals(BroadleafEnvironmentConfigurer.FRAMEWORK_SOURCES_NAME, getResult.getName());
    assertEquals(BroadleafEnvironmentConfigurer.PROFILE_AWARE_SOURCES_NAME, nextResult.getName());
    assertArrayEquals(new String[]{"test.property.source", "dev.only.property"},
        ((CompositePropertySource) nextResult).getPropertyNames());
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
        ((CompositePropertySource) getResult).getPropertyNames());
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConfigure_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.config.BroadleafEnvironmentConfigurer.addToEnvironment(BroadleafEnvironmentConfigurer.java:228)
    //       at org.broadleafcommerce.common.config.BroadleafEnvironmentConfigurer.configure(BroadleafEnvironmentConfigurer.java:113)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new BroadleafEnvironmentConfigurer()).configure(null);
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}
   */
  @Test
  public void testCreateClasspathResource() {
    // Arrange and Act
    Resource actualCreateClasspathResourceResult = broadleafEnvironmentConfigurer
        .createClasspathResource("Root Location", "Property Name", "Suffix");

    // Assert
    assertTrue(actualCreateClasspathResourceResult instanceof ClassPathResource);
    assertEquals("Property Name-Suffix.properties", actualCreateClasspathResourceResult.getFilename());
    assertEquals("Root Location/Property Name-Suffix.properties",
        ((ClassPathResource) actualCreateClasspathResourceResult).getPath());
    assertEquals("class path resource [Root Location/Property Name-Suffix.properties]",
        actualCreateClasspathResourceResult.getDescription());
    assertFalse(actualCreateClasspathResourceResult.isFile());
    assertFalse(actualCreateClasspathResourceResult.isOpen());
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   * <ul>
   *   <li>Then return Filename is {@code Property Name.properties}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}
   */
  @Test
  public void testCreateClasspathResource_thenReturnFilenameIsPropertyNameProperties() {
    // Arrange and Act
    Resource actualCreateClasspathResourceResult = broadleafEnvironmentConfigurer
        .createClasspathResource("Root Location", "Property Name", "");

    // Assert
    assertTrue(actualCreateClasspathResourceResult instanceof ClassPathResource);
    assertEquals("Property Name.properties", actualCreateClasspathResourceResult.getFilename());
    assertEquals("Root Location/Property Name.properties",
        ((ClassPathResource) actualCreateClasspathResourceResult).getPath());
    assertEquals("class path resource [Root Location/Property Name.properties]",
        actualCreateClasspathResourceResult.getDescription());
    assertFalse(actualCreateClasspathResourceResult.isFile());
    assertFalse(actualCreateClasspathResourceResult.isOpen());
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   * <ul>
   *   <li>Then return Path is {@code Property Name-Suffix.properties}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}
   */
  @Test
  public void testCreateClasspathResource_thenReturnPathIsPropertyNameSuffixProperties() {
    // Arrange and Act
    Resource actualCreateClasspathResourceResult = broadleafEnvironmentConfigurer.createClasspathResource("",
        "Property Name", "Suffix");

    // Assert
    assertTrue(actualCreateClasspathResourceResult instanceof ClassPathResource);
    assertEquals("Property Name-Suffix.properties",
        ((ClassPathResource) actualCreateClasspathResourceResult).getPath());
    assertEquals("Property Name-Suffix.properties", actualCreateClasspathResourceResult.getFilename());
    assertEquals("class path resource [Property Name-Suffix.properties]",
        actualCreateClasspathResourceResult.getDescription());
    assertFalse(actualCreateClasspathResourceResult.isFile());
    assertFalse(actualCreateClasspathResourceResult.isOpen());
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  public void testAddToEnvironment() {
    // Arrange
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(new CompositePropertySource("Name"));
    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(new GeneratedResource());

    // Act
    broadleafEnvironmentConfigurer.addToEnvironment(environment, resources, "Composite Source Name",
        "Add Before Source Name");

    // Assert
    verify(environment).getPropertySources();
    verify(mutablePropertySources).get(eq("Composite Source Name"));
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <ul>
   *   <li>Given {@link MutablePropertySources}
   * {@link MutablePropertySources#get(String)} return {@code null}.</li>
   *   <li>Then calls
   * {@link MutablePropertySources#addBefore(String, PropertySource)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  public void testAddToEnvironment_givenMutablePropertySourcesGetReturnNull_thenCallsAddBefore() {
    // Arrange
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any())).thenReturn(null);
    doNothing().when(mutablePropertySources).addBefore(Mockito.<String>any(), Mockito.<PropertySource<Object>>any());
    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(new GeneratedResource());

    // Act
    broadleafEnvironmentConfigurer.addToEnvironment(environment, resources, "Composite Source Name",
        "Add Before Source Name");

    // Assert
    verify(environment, atLeast(1)).getPropertySources();
    verify(mutablePropertySources).addBefore(eq("Add Before Source Name"), isA(PropertySource.class));
    verify(mutablePropertySources).get(eq("Composite Source Name"));
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <ul>
   *   <li>Then calls
   * {@link CompositePropertySource#addFirstPropertySource(PropertySource)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  public void testAddToEnvironment_thenCallsAddFirstPropertySource() {
    // Arrange
    CompositePropertySource compositePropertySource = mock(CompositePropertySource.class);
    doThrow(new RuntimeException("foo")).when(compositePropertySource)
        .addFirstPropertySource(Mockito.<PropertySource<Object>>any());
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(compositePropertySource);
    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(new GeneratedResource());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafEnvironmentConfigurer.addToEnvironment(environment, resources,
        "Composite Source Name", "Add Before Source Name"));
    verify(environment).getPropertySources();
    verify(compositePropertySource).addFirstPropertySource(isA(PropertySource.class));
    verify(mutablePropertySources).get(eq("Composite Source Name"));
  }

  /**
   * Test
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <ul>
   *   <li>Then calls {@link AbstractResource#getFilename()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  public void testAddToEnvironment_thenCallsGetFilename() throws IOException {
    // Arrange
    StandardEnvironment environment = mock(StandardEnvironment.class);
    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.getInputStream()).thenReturn(new FileInputStream(new FileDescriptor()));
    when(byteArrayResource.getFilename()).thenReturn("foo.txt");
    when(byteArrayResource.exists()).thenReturn(true);
    when(byteArrayResource.getDescription()).thenReturn("The characteristics of someone or something");

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(byteArrayResource);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafEnvironmentConfigurer.addToEnvironment(environment, resources,
        "Composite Source Name", "Add Before Source Name"));
    verify(byteArrayResource).getFilename();
    verify(byteArrayResource).exists();
    verify(byteArrayResource).getDescription();
    verify(byteArrayResource).getInputStream();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafEnvironmentConfigurer}
   *   <li>{@link BroadleafEnvironmentConfigurer#getDeprecatedDefaultProfileKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("development", (new BroadleafEnvironmentConfigurer()).getDeprecatedDefaultProfileKey());
  }
}
