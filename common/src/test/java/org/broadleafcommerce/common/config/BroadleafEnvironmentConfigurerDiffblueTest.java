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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.test.common.properties.sources.CommonFrameworkTestProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareSharedProperties;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
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
   * Method under test: {@link BroadleafEnvironmentConfigurer#getFrameworkSources()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafEnvironmentConfigurer.getFrameworkSources()"})
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
   * Method under test: {@link BroadleafEnvironmentConfigurer#getProfileAwareSources()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafEnvironmentConfigurer.getProfileAwareSources()"})
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
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Active Profiles}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_givenArrayOfStringWithActiveProfiles() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer = new BroadleafEnvironmentConfigurer();
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getActiveProfiles()).thenReturn(new String[]{"Active Profiles"});
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());

    // Act
    broadleafEnvironmentConfigurer.configure(environment);

    // Assert
    verify(environment).addActiveProfile(eq("Property"));
    verify(environment, atLeast(1)).getPropertySources();
    verify(environment, atLeast(1)).getActiveProfiles();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Default Profiles}.</li>
   *   <li>Then calls {@link ConfigurableEnvironment#setDefaultProfiles(String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_givenArrayOfStringWithDefaultProfiles_thenCallsSetDefaultProfiles() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer = new BroadleafEnvironmentConfigurer();
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
    doNothing().when(environment).setDefaultProfiles((String[]) Mockito.any());
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getActiveProfiles()).thenReturn(null);
    when(environment.getDefaultProfiles()).thenReturn(new String[]{"Default Profiles"});
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());

    // Act
    broadleafEnvironmentConfigurer.configure(environment);

    // Assert
    verify(environment).addActiveProfile(eq("Property"));
    verify(environment, atLeast(1)).getPropertySources();
    verify(environment, atLeast(1)).setDefaultProfiles((String[]) Mockito.any());
    verify(environment, atLeast(1)).getActiveProfiles();
    verify(environment, atLeast(1)).getDefaultProfiles();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code config/bc/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_givenRuntimeExceptionWithConfigBc() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer = new BroadleafEnvironmentConfigurer();
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
    doThrow(new RuntimeException("config/bc/")).when(environment).addActiveProfile(Mockito.<String>any());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafEnvironmentConfigurer.configure(environment));
    verify(environment).addActiveProfile(eq("Property"));
    verify(environment, atLeast(1)).getPropertySources();
    verify(environment).getProperty(eq("runtime.environment"));
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   * <ul>
   *   <li>Given {@code to the environment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_givenToTheEnvironment() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer = new BroadleafEnvironmentConfigurer();
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    when(environment.getProperty(Mockito.<String>any())).thenReturn(" to the environment");
    when(environment.getActiveProfiles()).thenReturn(new String[]{"Active Profiles"});
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());

    // Act
    broadleafEnvironmentConfigurer.configure(environment);

    // Assert
    verify(environment).addActiveProfile(eq(" to the environment"));
    verify(environment, atLeast(1)).getPropertySources();
    verify(environment, atLeast(1)).getActiveProfiles();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   * <ul>
   *   <li>Then calls {@link CompositePropertySource#addFirstPropertySource(PropertySource)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_thenCallsAddFirstPropertySource() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer = new BroadleafEnvironmentConfigurer();
    CompositePropertySource compositePropertySource = mock(CompositePropertySource.class);
    doThrow(new RuntimeException("foo")).when(compositePropertySource)
        .addFirstPropertySource(Mockito.<PropertySource<Object>>any());
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(compositePropertySource);
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafEnvironmentConfigurer.configure(environment));
    verify(compositePropertySource).addFirstPropertySource(isA(PropertySource.class));
    verify(environment).getPropertySources();
    verify(mutablePropertySources).get(eq("broadleafFrameworkSources"));
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource BroadleafEnvironmentConfigurer.createClasspathResource(String, String, String)"})
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
   * Test {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   * <ul>
   *   <li>Then return Filename is {@code Property Name.properties}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource BroadleafEnvironmentConfigurer.createClasspathResource(String, String, String)"})
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
   * Test {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   * <ul>
   *   <li>Then return Path is {@code Property Name-Suffix.properties}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource BroadleafEnvironmentConfigurer.createClasspathResource(String, String, String)"})
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
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"})
  public void testAddToEnvironment() {
    // Arrange
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(new CompositePropertySource("Name"));
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
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
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <ul>
   *   <li>Given {@link MutablePropertySources} {@link MutablePropertySources#get(String)} return {@code null}.</li>
   *   <li>Then calls {@link MutablePropertySources#addBefore(String, PropertySource)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"})
  public void testAddToEnvironment_givenMutablePropertySourcesGetReturnNull_thenCallsAddBefore() {
    // Arrange
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any())).thenReturn(null);
    doNothing().when(mutablePropertySources).addBefore(Mockito.<String>any(), Mockito.<PropertySource<Object>>any());
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
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
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <ul>
   *   <li>Then calls {@link CompositePropertySource#addFirstPropertySource(PropertySource)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"})
  public void testAddToEnvironment_thenCallsAddFirstPropertySource() {
    // Arrange
    CompositePropertySource compositePropertySource = mock(CompositePropertySource.class);
    doThrow(new RuntimeException("foo")).when(compositePropertySource)
        .addFirstPropertySource(Mockito.<PropertySource<Object>>any());
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(compositePropertySource);
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(new GeneratedResource());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafEnvironmentConfigurer.addToEnvironment(environment, resources,
        "Composite Source Name", "Add Before Source Name"));
    verify(compositePropertySource).addFirstPropertySource(isA(PropertySource.class));
    verify(environment).getPropertySources();
    verify(mutablePropertySources).get(eq("Composite Source Name"));
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}.
   * <ul>
   *   <li>Then calls {@link AbstractResource#getFilename()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"})
  public void testAddToEnvironment_thenCallsGetFilename() throws IOException {
    // Arrange
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
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
   *   <li>default or parameterless constructor of {@link BroadleafEnvironmentConfigurer}
   *   <li>{@link BroadleafEnvironmentConfigurer#getDeprecatedDefaultProfileKey()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.<init>()",
      "String BroadleafEnvironmentConfigurer.getDeprecatedDefaultProfileKey()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("development", (new BroadleafEnvironmentConfigurer()).getDeprecatedDefaultProfileKey());
  }
}
