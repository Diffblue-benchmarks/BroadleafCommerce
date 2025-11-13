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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.test.common.properties.sources.CommonFrameworkTestProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareSharedProperties;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafEnvironmentConfigurer.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafEnvironmentConfigurerDiffblueTest {
  @Autowired private BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer;

  /**
   * Test {@link BroadleafEnvironmentConfigurer#getFrameworkSources()}.
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#getFrameworkSources()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BroadleafEnvironmentConfigurer.getFrameworkSources()"})
  public void testGetFrameworkSources() {
    // Arrange and Act
    List<FrameworkCommonClasspathPropertySource> actualFrameworkSources =
        new BroadleafEnvironmentConfigurer().getFrameworkSources();

    // Assert
    assertEquals(2, actualFrameworkSources.size());
    FrameworkCommonClasspathPropertySource getResult = actualFrameworkSources.get(0);
    assertTrue(getResult instanceof BroadleafCommonPropertySource);
    FrameworkCommonClasspathPropertySource getResult2 = actualFrameworkSources.get(1);
    assertTrue(getResult2 instanceof CommonFrameworkTestProperties);
    assertEquals("common-test-properties", getResult2.getClasspathFolder());
    assertEquals("config/bc/", getResult.getClasspathFolder());
    assertEquals(
        FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        ((CommonFrameworkTestProperties) getResult2).getOrder());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#getProfileAwareSources()}.
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#getProfileAwareSources()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BroadleafEnvironmentConfigurer.getProfileAwareSources()"})
  public void testGetProfileAwareSources() {
    // Arrange and Act
    List<BroadleafSharedOverrideProfileAwarePropertySource> actualProfileAwareSources =
        new BroadleafEnvironmentConfigurer().getProfileAwareSources();

    // Assert
    assertEquals(3, actualProfileAwareSources.size());
    BroadleafSharedOverrideProfileAwarePropertySource getResult = actualProfileAwareSources.get(0);
    assertTrue(getResult instanceof DefaultRuntimeEnvironmentProfileAwarePropertySource);
    BroadleafSharedOverrideProfileAwarePropertySource getResult2 = actualProfileAwareSources.get(1);
    assertTrue(getResult2 instanceof ProfileAwareProperties);
    BroadleafSharedOverrideProfileAwarePropertySource getResult3 = actualProfileAwareSources.get(2);
    assertTrue(getResult3 instanceof ProfileAwareSharedProperties);
    assertEquals(
        "common-test-properties/profile-aware-properties", getResult2.getClasspathFolder());
    assertEquals(
        "common-test-properties/profile-aware-shared-properties", getResult3.getClasspathFolder());
    assertEquals("runtime-properties", getResult.getClasspathFolder());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Active Profiles}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_givenArrayOfStringWithActiveProfiles() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer =
        new BroadleafEnvironmentConfigurer();

    AbstractEnvironment environment = mock(AbstractEnvironment.class);
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getActiveProfiles()).thenReturn(new String[] {"Active Profiles"});
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("config/bc/");

    // Act
    broadleafEnvironmentConfigurer.configure(environment);

    // Assert
    verify(environment, atLeast(1)).addActiveProfile(Mockito.<String>any());
    verify(environment, atLeast(1)).getActiveProfiles();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment, atLeast(1)).getPropertySources();
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Default Profiles}.
   *   <li>Then calls {@link AbstractEnvironment#getDefaultProfiles()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_givenArrayOfStringWithDefaultProfiles_thenCallsGetDefaultProfiles() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer =
        new BroadleafEnvironmentConfigurer();

    AbstractEnvironment environment = mock(AbstractEnvironment.class);
    doNothing().when(environment).setDefaultProfiles((String[]) Mockito.any());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getActiveProfiles()).thenReturn(null);
    when(environment.getDefaultProfiles()).thenReturn(new String[] {"Default Profiles"});
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("config/bc/");

    // Act
    broadleafEnvironmentConfigurer.configure(environment);

    // Assert
    verify(environment, atLeast(1)).addActiveProfile(Mockito.<String>any());
    verify(environment, atLeast(1)).getActiveProfiles();
    verify(environment, atLeast(1)).getDefaultProfiles();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(environment, atLeast(1)).getPropertySources();
    verify(environment, atLeast(1)).setDefaultProfiles((String[]) Mockito.any());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   *
   * <ul>
   *   <li>Then calls {@link CompositePropertySource#addFirstPropertySource(PropertySource)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_thenCallsAddFirstPropertySource() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer =
        new BroadleafEnvironmentConfigurer();

    CompositePropertySource compositePropertySource = mock(CompositePropertySource.class);
    doThrow(new RuntimeException())
        .when(compositePropertySource)
        .addFirstPropertySource(Mockito.<PropertySource<?>>any());

    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(compositePropertySource);

    AbstractEnvironment environment = mock(AbstractEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("config/bc/");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> broadleafEnvironmentConfigurer.configure(environment));
    verify(environment).addActiveProfile("config/bc/");
    verify(environment).getPropertySources();
    verify(compositePropertySource).addFirstPropertySource(isA(PropertySource.class));
    verify(mutablePropertySources).get("broadleafFrameworkSources");
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   *
   * <ul>
   *   <li>When {@link AbstractEnvironment} {@link AbstractEnvironment#getProperty(String)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_whenAbstractEnvironmentGetPropertyThrowRuntimeException() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer =
        new BroadleafEnvironmentConfigurer();

    AbstractEnvironment environment = mock(AbstractEnvironment.class);
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new RuntimeException());
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("config/bc/");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> broadleafEnvironmentConfigurer.configure(environment));
    verify(environment).addActiveProfile("config/bc/");
    verify(environment).getProperty("runtime.environment");
    verify(environment, atLeast(1)).getPropertySources();
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}.
   *
   * <ul>
   *   <li>When {@link AbstractEnvironment} {@link AbstractEnvironment#setDefaultProfiles(String[])}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#configure(ConfigurableEnvironment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafEnvironmentConfigurer.configure(ConfigurableEnvironment)"})
  public void testConfigure_whenAbstractEnvironmentSetDefaultProfilesThrowRuntimeException() {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer =
        new BroadleafEnvironmentConfigurer();

    AbstractEnvironment environment = mock(AbstractEnvironment.class);
    doThrow(new RuntimeException()).when(environment).setDefaultProfiles((String[]) Mockito.any());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getActiveProfiles()).thenReturn(null);
    when(environment.getDefaultProfiles()).thenReturn(new String[] {"Default Profiles"});
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("config/bc/");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> broadleafEnvironmentConfigurer.configure(environment));
    verify(environment, atLeast(1)).addActiveProfile(Mockito.<String>any());
    verify(environment, atLeast(1)).getActiveProfiles();
    verify(environment, atLeast(1)).getDefaultProfiles();
    verify(environment).getProperty("runtime.environment");
    verify(environment, atLeast(1)).getPropertySources();
    verify(environment).setDefaultProfiles((String[]) Mockito.any());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#createClasspathResource(String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BroadleafEnvironmentConfigurer.createClasspathResource(String, String, String)"
  })
  public void testCreateClasspathResource() {
    // Arrange and Act
    Resource actualCreateClasspathResourceResult =
        broadleafEnvironmentConfigurer.createClasspathResource(
            "Root Location", "Property Name", "Suffix");

    // Assert
    assertTrue(actualCreateClasspathResourceResult instanceof ClassPathResource);
    assertEquals(
        "Property Name-Suffix.properties", actualCreateClasspathResourceResult.getFilename());
    assertEquals(
        "Root Location/Property Name-Suffix.properties",
        ((ClassPathResource) actualCreateClasspathResourceResult).getPath());
    assertEquals(
        "class path resource [Root Location/Property Name-Suffix.properties]",
        actualCreateClasspathResourceResult.getDescription());
    assertFalse(actualCreateClasspathResourceResult.isOpen());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   *
   * <ul>
   *   <li>Then return Filename is {@code Property Name.properties}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#createClasspathResource(String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BroadleafEnvironmentConfigurer.createClasspathResource(String, String, String)"
  })
  public void testCreateClasspathResource_thenReturnFilenameIsPropertyNameProperties() {
    // Arrange and Act
    Resource actualCreateClasspathResourceResult =
        broadleafEnvironmentConfigurer.createClasspathResource(
            "Root Location", "Property Name", "");

    // Assert
    assertTrue(actualCreateClasspathResourceResult instanceof ClassPathResource);
    assertEquals("Property Name.properties", actualCreateClasspathResourceResult.getFilename());
    assertEquals(
        "Root Location/Property Name.properties",
        ((ClassPathResource) actualCreateClasspathResourceResult).getPath());
    assertEquals(
        "class path resource [Root Location/Property Name.properties]",
        actualCreateClasspathResourceResult.getDescription());
    assertFalse(actualCreateClasspathResourceResult.isOpen());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   *
   * <ul>
   *   <li>Then return Path is {@code Property Name-Suffix.properties}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#createClasspathResource(String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BroadleafEnvironmentConfigurer.createClasspathResource(String, String, String)"
  })
  public void testCreateClasspathResource_thenReturnPathIsPropertyNameSuffixProperties() {
    // Arrange and Act
    Resource actualCreateClasspathResourceResult =
        broadleafEnvironmentConfigurer.createClasspathResource("", "Property Name", "Suffix");

    // Assert
    assertTrue(actualCreateClasspathResourceResult instanceof ClassPathResource);
    assertEquals(
        "Property Name-Suffix.properties",
        ((ClassPathResource) actualCreateClasspathResourceResult).getPath());
    assertEquals(
        "Property Name-Suffix.properties", actualCreateClasspathResourceResult.getFilename());
    assertEquals(
        "class path resource [Property Name-Suffix.properties]",
        actualCreateClasspathResourceResult.getDescription());
    assertFalse(actualCreateClasspathResourceResult.isOpen());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#createClasspathResource(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Filename is {@code Property Name.properties}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnvironmentConfigurer#createClasspathResource(String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BroadleafEnvironmentConfigurer.createClasspathResource(String, String, String)"
  })
  public void testCreateClasspathResource_whenNull_thenReturnFilenameIsPropertyNameProperties() {
    // Arrange and Act
    Resource actualCreateClasspathResourceResult =
        broadleafEnvironmentConfigurer.createClasspathResource(
            "Root Location", "Property Name", null);

    // Assert
    assertTrue(actualCreateClasspathResourceResult instanceof ClassPathResource);
    assertEquals("Property Name.properties", actualCreateClasspathResourceResult.getFilename());
    assertEquals(
        "Root Location/Property Name.properties",
        ((ClassPathResource) actualCreateClasspathResourceResult).getPath());
    assertEquals(
        "class path resource [Root Location/Property Name.properties]",
        actualCreateClasspathResourceResult.getDescription());
    assertFalse(actualCreateClasspathResourceResult.isOpen());
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List,
   * String, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"
  })
  public void testAddToEnvironment() throws IOException {
    // Arrange
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(new CompositePropertySource("Name"));

    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(byteArrayResource.getFilename()).thenReturn("foo.txt");
    when(byteArrayResource.exists()).thenReturn(true);
    when(byteArrayResource.getDescription())
        .thenReturn("The characteristics of someone or something");

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(byteArrayResource);

    // Act
    broadleafEnvironmentConfigurer.addToEnvironment(
        environment, resources, "Composite Source Name", "Add Before Source Name");

    // Assert
    verify(environment).getPropertySources();
    verify(mutablePropertySources).get("Composite Source Name");
    verify(byteArrayResource).getFilename();
    verify(byteArrayResource).exists();
    verify(byteArrayResource).getDescription();
    verify(byteArrayResource).getInputStream();
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List,
   * String, String)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafEnvironmentConfigurer} (default constructor).
   *   <li>When {@link StandardEnvironment}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"
  })
  public void testAddToEnvironment_givenBroadleafEnvironmentConfigurer_whenStandardEnvironment()
      throws IOException {
    // Arrange
    BroadleafEnvironmentConfigurer broadleafEnvironmentConfigurer =
        new BroadleafEnvironmentConfigurer();
    StandardReactiveWebEnvironment environment = new StandardReactiveWebEnvironment();
    broadleafEnvironmentConfigurer.addToEnvironment(
        environment, new ArrayList<>(), "Composite Source Name", "Add Before Source Name");
    StandardEnvironment environment2 = mock(StandardEnvironment.class);

    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.getInputStream()).thenReturn(new FileInputStream(new FileDescriptor()));
    when(byteArrayResource.getFilename()).thenReturn("foo.txt");
    when(byteArrayResource.exists()).thenReturn(true);
    when(byteArrayResource.getDescription())
        .thenReturn("The characteristics of someone or something");

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(byteArrayResource);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            broadleafEnvironmentConfigurer.addToEnvironment(
                environment2, resources, "Composite Source Name", "Add Before Source Name"));
    verify(byteArrayResource).getFilename();
    verify(byteArrayResource).exists();
    verify(byteArrayResource).getDescription();
    verify(byteArrayResource).getInputStream();
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List,
   * String, String)}.
   *
   * <ul>
   *   <li>Given {@link ClassPathResource#ClassPathResource(String)} with {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"
  })
  public void testAddToEnvironment_givenClassPathResourceWithPath() {
    // Arrange
    StandardReactiveWebEnvironment environment = new StandardReactiveWebEnvironment();

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(new ClassPathResource("Path"));

    // Act and Assert
    broadleafEnvironmentConfigurer.addToEnvironment(
        environment, resources, "Composite Source Name", "Add Before Source Name");
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List,
   * String, String)}.
   *
   * <ul>
   *   <li>Given {@link MutablePropertySources} {@link MutablePropertySources#get(String)} return
   *       {@code null}.
   *   <li>Then calls {@link MutablePropertySources#addBefore(String, PropertySource)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"
  })
  public void testAddToEnvironment_givenMutablePropertySourcesGetReturnNull_thenCallsAddBefore()
      throws IOException {
    // Arrange
    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(null);
    doNothing()
        .when(mutablePropertySources)
        .addBefore(Mockito.<String>any(), Mockito.<PropertySource<?>>any());

    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(byteArrayResource.getFilename()).thenReturn("foo.txt");
    when(byteArrayResource.exists()).thenReturn(true);
    when(byteArrayResource.getDescription())
        .thenReturn("The characteristics of someone or something");

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(byteArrayResource);

    // Act
    broadleafEnvironmentConfigurer.addToEnvironment(
        environment, resources, "Composite Source Name", "Add Before Source Name");

    // Assert
    verify(environment, atLeast(1)).getPropertySources();
    verify(mutablePropertySources)
        .addBefore(eq("Add Before Source Name"), isA(PropertySource.class));
    verify(mutablePropertySources).get("Composite Source Name");
    verify(byteArrayResource).getFilename();
    verify(byteArrayResource).exists();
    verify(byteArrayResource).getDescription();
    verify(byteArrayResource).getInputStream();
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List,
   * String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link CompositePropertySource#addFirstPropertySource(PropertySource)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"
  })
  public void testAddToEnvironment_thenCallsAddFirstPropertySource() throws IOException {
    // Arrange
    CompositePropertySource compositePropertySource = mock(CompositePropertySource.class);
    doThrow(new RuntimeException())
        .when(compositePropertySource)
        .addFirstPropertySource(Mockito.<PropertySource<?>>any());

    MutablePropertySources mutablePropertySources = mock(MutablePropertySources.class);
    Mockito.<PropertySource<?>>when(mutablePropertySources.get(Mockito.<String>any()))
        .thenReturn(compositePropertySource);

    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(mutablePropertySources);

    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(byteArrayResource.getFilename()).thenReturn("foo.txt");
    when(byteArrayResource.exists()).thenReturn(true);
    when(byteArrayResource.getDescription())
        .thenReturn("The characteristics of someone or something");

    ArrayList<Resource> resources = new ArrayList<>();
    resources.add(byteArrayResource);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            broadleafEnvironmentConfigurer.addToEnvironment(
                environment, resources, "Composite Source Name", "Add Before Source Name"));
    verify(environment).getPropertySources();
    verify(compositePropertySource).addFirstPropertySource(isA(PropertySource.class));
    verify(mutablePropertySources).get("Composite Source Name");
    verify(byteArrayResource).getFilename();
    verify(byteArrayResource).exists();
    verify(byteArrayResource).getDescription();
    verify(byteArrayResource).getInputStream();
  }

  /**
   * Test {@link BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafEnvironmentConfigurer#addToEnvironment(ConfigurableEnvironment, List, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafEnvironmentConfigurer.addToEnvironment(ConfigurableEnvironment, List, String, String)"
  })
  public void testAddToEnvironment_whenArrayList_thenDoesNotThrow() {
    // Arrange
    StandardReactiveWebEnvironment environment = new StandardReactiveWebEnvironment();

    // Act and Assert
    broadleafEnvironmentConfigurer.addToEnvironment(
        environment, new ArrayList<>(), "Composite Source Name", "Add Before Source Name");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafEnvironmentConfigurer}
   *   <li>{@link BroadleafEnvironmentConfigurer#getDeprecatedDefaultProfileKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafEnvironmentConfigurer.<init>()",
    "String BroadleafEnvironmentConfigurer.getDeprecatedDefaultProfileKey()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "development", new BroadleafEnvironmentConfigurer().getDeprecatedDefaultProfileKey());
  }
}
