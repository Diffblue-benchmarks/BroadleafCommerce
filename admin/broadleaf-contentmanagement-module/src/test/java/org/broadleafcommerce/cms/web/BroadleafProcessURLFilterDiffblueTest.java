package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {BroadleafProcessURLFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafProcessURLFilterDiffblueTest {
  @Autowired
  private BroadleafProcessURLFilter broadleafProcessURLFilter;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blSandBoxService")
  private SandBoxService sandBoxService;

  /**
   * Test
   * {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_thenThrowNumberFormatException() throws IOException, ServletException {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new NumberFormatException("org.broadleafcommerce.admin")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> broadleafProcessURLFilter.doFilterInternal(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(localeService).findDefaultLocale();
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code blcadmin}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenBlcadmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "blcadmin"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenDefaultMultipartHttpServletRequest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(broadleafProcessURLFilter.shouldProcessURL(mock(DefaultMultipartHttpServletRequest.class),
        "https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenDot_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "."));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenOrgBroadleafcommerceAdmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "org.broadleafcommerce.admin"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code .service}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenService_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), ".service"));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#getIgnoreSuffixes()}.
   * <p>
   * Method under test: {@link BroadleafProcessURLFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes() {
    // Arrange, Act and Assert
    assertEquals(44, broadleafProcessURLFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafProcessURLFilter#setCacheExpirationSeconds(int)}
   *   <li>{@link BroadleafProcessURLFilter#setMaxCacheConcurrency(int)}
   *   <li>{@link BroadleafProcessURLFilter#setMaxCacheElements(int)}
   *   <li>{@link BroadleafProcessURLFilter#setSandBoxPreviewEnabled(Boolean)}
   *   <li>{@link BroadleafProcessURLFilter#setUrlProcessorList(List)}
   *   <li>{@link BroadleafProcessURLFilter#getCacheExpirationSeconds()}
   *   <li>{@link BroadleafProcessURLFilter#getMaxCacheConcurrency()}
   *   <li>{@link BroadleafProcessURLFilter#getMaxCacheElements()}
   *   <li>{@link BroadleafProcessURLFilter#getSandBoxPreviewEnabled()}
   *   <li>{@link BroadleafProcessURLFilter#getUrlProcessorList()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafProcessURLFilter broadleafProcessURLFilter = new BroadleafProcessURLFilter();

    // Act
    broadleafProcessURLFilter.setCacheExpirationSeconds(1);
    broadleafProcessURLFilter.setMaxCacheConcurrency(3);
    broadleafProcessURLFilter.setMaxCacheElements(3);
    broadleafProcessURLFilter.setSandBoxPreviewEnabled(true);
    ArrayList<URLProcessor> urlProcessorList = new ArrayList<>();
    broadleafProcessURLFilter.setUrlProcessorList(urlProcessorList);
    int actualCacheExpirationSeconds = broadleafProcessURLFilter.getCacheExpirationSeconds();
    int actualMaxCacheConcurrency = broadleafProcessURLFilter.getMaxCacheConcurrency();
    int actualMaxCacheElements = broadleafProcessURLFilter.getMaxCacheElements();
    Boolean actualSandBoxPreviewEnabled = broadleafProcessURLFilter.getSandBoxPreviewEnabled();
    List<URLProcessor> actualUrlProcessorList = broadleafProcessURLFilter.getUrlProcessorList();

    // Assert that nothing has changed
    assertEquals(1, actualCacheExpirationSeconds);
    assertEquals(3, actualMaxCacheConcurrency);
    assertEquals(3, actualMaxCacheElements);
    assertTrue(actualUrlProcessorList.isEmpty());
    assertTrue(actualSandBoxPreviewEnabled);
    assertSame(urlProcessorList, actualUrlProcessorList);
  }

  /**
   * Test new {@link BroadleafProcessURLFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafProcessURLFilter}
   */
  @Test
  public void testNewBroadleafProcessURLFilter() {
    // Arrange and Act
    BroadleafProcessURLFilter actualBroadleafProcessURLFilter = new BroadleafProcessURLFilter();

    // Assert
    Environment environment = actualBroadleafProcessURLFilter.getEnvironment();
    assertTrue(((StandardServletEnvironment) environment).getConversionService() instanceof DefaultConversionService);
    MutablePropertySources propertySources = ((StandardServletEnvironment) environment).getPropertySources();
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(4, collectResult.size());
    PropertySource<?> getResult = collectResult.get(2);
    assertTrue(getResult instanceof PropertiesPropertySource);
    Iterator<PropertySource<?>> iteratorResult = propertySources.iterator();
    PropertySource<?> nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof PropertySource.StubPropertySource);
    PropertySource<?> nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof PropertySource.StubPropertySource);
    PropertySource<?> getResult2 = collectResult.get(3);
    assertTrue(getResult2 instanceof SystemEnvironmentPropertySource);
    assertTrue(environment instanceof StandardServletEnvironment);
    Map<String, Object> systemEnvironment = ((StandardServletEnvironment) environment).getSystemEnvironment();
    assertEquals(37, systemEnvironment.size());
    assertEquals("/opt/homebrew/share/man::", systemEnvironment.get("MANPATH"));
    Map<String, Object> systemProperties = ((StandardServletEnvironment) environment).getSystemProperties();
    assertEquals(65, systemProperties.size());
    assertEquals("11", systemProperties.get("java.specification.version"));
    String[] propertyNames = ((PropertiesPropertySource) getResult).getPropertyNames();
    assertEquals("awt.toolkit", propertyNames[2]);
    assertEquals("com.diffblue.assertionSuggestionJar", propertyNames[12]);
    assertEquals("com.diffblue.cover.launcher.Launcher", systemEnvironment.get("JAVA_MAIN_CLASS_76361"));
    assertEquals("com.diffblue.logging.directory", propertyNames[48]);
    assertEquals("com.diffblue.springIsolationJar", propertyNames[56]);
    assertEquals("cover.jar.path", propertyNames[1]);
    assertEquals("cover.main.class", propertyNames[46]);
    assertEquals("file.encoding", propertyNames[45]);
    assertEquals("gopherProxySet", propertyNames[0]);
    assertEquals("http.nonProxyHosts", propertyNames[19]);
    assertEquals("java.awt.printerjob", propertyNames[55]);
    assertEquals("java.class.path", propertyNames[6]);
    assertEquals("java.class.version", propertyNames[63]);
    assertEquals("java.io.tmpdir", propertyNames[50]);
    assertEquals("java.library.path", propertyNames[58]);
    assertEquals("java.runtime.name", propertyNames[44]);
    assertEquals("java.specification.vendor", propertyNames[24]);
    assertEquals("java.specification.version", propertyNames[3]);
    assertEquals("java.vendor", propertyNames[60]);
    assertEquals("java.vendor.url", propertyNames[10]);
    assertEquals("java.vendor.url.bug", propertyNames[49]);
    assertEquals("java.version", propertyNames[51]);
    assertEquals("java.vm.info", propertyNames[59]);
    assertEquals("java.vm.name", propertyNames[47]);
    assertEquals("java.vm.specification.name", propertyNames[54]);
    assertEquals("java.vm.specification.version", propertyNames[14]);
    assertEquals("java.vm.vendor", propertyNames[7]);
    assertEquals("java.vm.version", propertyNames[61]);
    assertEquals("jdk.debug", propertyNames[20]);
    assertEquals("mvel2.disable.jit", propertyNames[9]);
    assertEquals("org.springframework.boot.logging.LoggingSystem", propertyNames[41]);
    assertEquals("os.arch", propertyNames[53]);
    assertEquals("os.name", propertyNames[13]);
    assertEquals("os.version", propertyNames[43]);
    assertEquals("path.separator", propertyNames[42]);
    assertEquals("servletConfigInitParams", nextResult.getName());
    assertEquals("servletContextInitParams", nextResult2.getName());
    assertEquals("socksNonProxyHosts", propertyNames[Double.SIZE]);
    assertEquals("sun.arch.data.model", propertyNames[8]);
    assertEquals("sun.boot.library.path", propertyNames[17]);
    assertEquals("sun.cpu.endian", propertyNames[21]);
    assertEquals("sun.cpu.isalist", propertyNames[4]);
    assertEquals("sun.io.unicode.encoding", propertyNames[62]);
    assertEquals("sun.java.command", propertyNames[18]);
    assertEquals("sun.java.launcher", propertyNames[15]);
    assertEquals("sun.jnu.encoding", propertyNames[5]);
    assertEquals("sun.os.patch.level", propertyNames[57]);
    assertEquals("systemEnvironment", getResult2.getName());
    assertEquals("systemProperties", getResult.getName());
    assertEquals("user.country", propertyNames[Short.SIZE]);
    assertEquals("user.dir", propertyNames[52]);
    assertEquals("user.home", propertyNames[22]);
    assertEquals("user.language", propertyNames[23]);
    assertEquals("user.name", propertyNames[40]);
    assertEquals("user.timezone", propertyNames[11]);
    assertNull(actualBroadleafProcessURLFilter.getFilterConfig());
    assertEquals(0, environment.getActiveProfiles().length);
    assertEquals(10000, actualBroadleafProcessURLFilter.getMaxCacheElements());
    assertEquals(14400, actualBroadleafProcessURLFilter.getCacheExpirationSeconds());
    assertEquals(3, actualBroadleafProcessURLFilter.getMaxCacheConcurrency());
    assertEquals(4, propertySources.size());
    assertEquals(44, actualBroadleafProcessURLFilter.getIgnoreSuffixes().size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    Object source = getResult.getSource();
    assertEquals(65, ((Map<String, Object>) source).size());
    assertEquals(65, propertyNames.length);
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualBroadleafProcessURLFilter.getUrlProcessorList().isEmpty());
    assertTrue(actualBroadleafProcessURLFilter.getSandBoxPreviewEnabled());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, systemProperties.get("gopherProxySet"));
    String expectedString2 = Boolean.FALSE.toString();
    assertEquals(expectedString2, ((Map<String, Object>) source).get("gopherProxySet"));
    String expectedString3 = Paths.get(System.getProperty("user.home"), ".sdkman", "candidates", "java", "current")
        .toString();
    assertEquals(expectedString3, systemEnvironment.get("JAVA_HOME"));
    String expectedString4 = Paths
        .get(System.getProperty("user.home"), "Documents", "dcover", "diffblue-cover-cli-2024.10.02",
            "cover-service-analyzer.jar")
        .toString();
    assertEquals(expectedString4, systemProperties.get("cover.jar.path"));
    String expectedString5 = Paths
        .get(System.getProperty("user.home"), "Documents", "dcover", "diffblue-cover-cli-2024.10.02",
            "cover-service-analyzer.jar")
        .toString();
    assertEquals(expectedString5, ((Map<String, Object>) source).get("cover.jar.path"));
    String toStringResult = Paths.get(System.getProperty("user.home"), ".docker", "bin").toString();
    String toStringResult2 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "springboot", "current", "bin")
        .toString();
    String toStringResult3 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "maven", "current", "bin")
        .toString();
    String toStringResult4 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "java", "current", "bin")
        .toString();
    String toStringResult5 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "gradle", "current", "bin")
        .toString();
    String expectedString6 = String.join("", toStringResult, ":", toStringResult2, ":", toStringResult3, ":",
        toStringResult4, ":", toStringResult5,
        ":/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr"
            + "/sbin:/sbin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/local/bin:/var/run/com"
            + ".apple.security.cryptexd/codex.system/bootstrap/usr/bin:/var/run/com.apple.security.cryptexd/codex"
            + ".system/bootstrap/usr/appleinternal/bin:",
        Paths.get(System.getProperty("user.home"), "Library", "Python", "3.9", "bin").toString());
    assertEquals(expectedString6, systemEnvironment.get("PATH"));
    String expectedString7 = System.getProperty("awt.toolkit");
    assertEquals(expectedString7, systemProperties.get("awt.toolkit"));
    assertSame(systemEnvironment, getResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(new String[]{"PATH", "MANPATH", "JAVA_MAIN_CLASS_76361", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX",
        "LANG", "GRADLE_HOME", "MAVEN_HOME", "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY",
        "XPC_SERVICE_NAME", "PWD", "TERM_PROGRAM_VERSION", "INFOPATH", "SPRINGBOOT_HOME", "_", "SDKMAN_CANDIDATES_DIR",
        "__CFBundleIdentifier", "SHELL", "TERM_PROGRAM", "JAVA_MAIN_CLASS_17836", "SDKMAN_CANDIDATES_API",
        "SECURITYSESSIONID", "HOMEBREW_CELLAR", "SDKMAN_PLATFORM", "USER", "LaunchInstanceID", "TMPDIR",
        "SSH_AUTH_SOCK", "XPC_FLAGS", "TERM_SESSION_ID", "__CF_USER_TEXT_ENCODING", "HOME", "SHLVL"},
        ((SystemEnvironmentPropertySource) getResult2).getPropertyNames());
  }
}
