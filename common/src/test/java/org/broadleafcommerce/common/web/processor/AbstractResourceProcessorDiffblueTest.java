package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.resource.service.ResourceBundlingService;
import org.broadleafcommerce.common.web.processor.attributes.ResourceTagAttributes;
import org.broadleafcommerce.common.web.request.ResourcesRequest;
import org.broadleafcommerce.common.web.request.ResourcesRequestBundle;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;

@RunWith(MockitoJUnitRunner.class)
public class AbstractResourceProcessorDiffblueTest {
  @Mock private Environment environment;

  @InjectMocks private ResourceBundleProcessor resourceBundleProcessor;

  @Mock private ResourceBundlingService resourceBundlingService;

  @Mock private ResourcesRequest resourcesRequest;

  /**
   * Test {@link AbstractResourceProcessor#getBundleEnabled()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code
   *       Property}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractResourceProcessor.getBundleEnabled()"})
  public void testGetBundleEnabled_givenEnvironmentGetPropertyReturnProperty_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    boolean actualBundleEnabled = resourceBundleProcessor.getBundleEnabled();

    // Assert
    verify(environment).getProperty("bundle.enabled");
    assertFalse(actualBundleEnabled);
  }

  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.getRequestedFileNames(String)"})
  public void testGetRequestedFileNames_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ResourceBundleProcessor().getRequestedFileNames("").isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.getRequestedFileNames(String)"})
  public void testGetRequestedFileNames_whenFooTxt_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualRequestedFileNames =
        new ResourceBundleProcessor().getRequestedFileNames("foo.txt");

    // Assert
    assertEquals(1, actualRequestedFileNames.size());
    assertEquals("foo.txt", actualRequestedFileNames.get(0));
  }

  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.getRequestedFileNames(String)"})
  public void testGetRequestedFileNames_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ResourceBundleProcessor().getRequestedFileNames(null).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.getRequestedFileNames(String)"})
  public void testGetRequestedFileNames_whenSpace_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ResourceBundleProcessor().getRequestedFileNames(" ").isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#buildResourceTagAttributes(Map)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#buildResourceTagAttributes(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceTagAttributes AbstractResourceProcessor.buildResourceTagAttributes(Map)"
  })
  public void testBuildResourceTagAttributes() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act
    ResourceTagAttributes actualBuildResourceTagAttributesResult =
        resourceBundleProcessor.buildResourceTagAttributes(new HashMap<>());

    // Assert
    assertNull(actualBuildResourceTagAttributesResult.bundleCompletedEvent());
    assertNull(actualBuildResourceTagAttributesResult.bundleDependencyEvent());
    assertNull(actualBuildResourceTagAttributesResult.files());
    assertNull(actualBuildResourceTagAttributesResult.mappingPrefix());
    assertNull(actualBuildResourceTagAttributesResult.name());
    assertNull(actualBuildResourceTagAttributesResult.src());
    assertFalse(actualBuildResourceTagAttributesResult.async());
    assertFalse(actualBuildResourceTagAttributesResult.defer());
    assertFalse(actualBuildResourceTagAttributesResult.includeAsyncDeferUnbundled());
  }

  /**
   * Test {@link AbstractResourceProcessor#getFullUnbundledFileName(String, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>Then return {@code Parse Expression}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getFullUnbundledFileName(String,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getFullUnbundledFileName(String, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testGetFullUnbundledFileName_givenParseExpression_thenReturnParseExpression() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualFullUnbundledFileName =
        resourceBundleProcessor.getFullUnbundledFileName("foo.txt", resourceTagAttributes, context);

    // Assert
    verify(context).parseExpression("@{'nullfoo.txt'}");
    assertEquals("Parse Expression", actualFullUnbundledFileName);
  }

  /**
   * Test {@link AbstractResourceProcessor#getFullUnbundledFileName(String, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getFullUnbundledFileName(String,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getFullUnbundledFileName(String, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testGetFullUnbundledFileName_thenThrowIllegalArgumentException() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.getFullUnbundledFileName(
                "foo.txt", resourceTagAttributes, context));
    verify(context).parseExpression("@{'nullfoo.txt'}");
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleUrl(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"
  })
  public void testGetBundleUrl() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    MockMultipartHttpServletRequest mockMultipartHttpServletRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    mockMultipartHttpServletRequest.setContextPath("");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(mockMultipartHttpServletRequest);

    // Act
    String actualBundleUrl =
        resourceBundleProcessor.getBundleUrl("https://example.org/example", context);

    // Assert
    verify(context).getRequest();
    assertEquals("/https://example.org/example", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleUrl(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"
  })
  public void testGetBundleUrl2() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    MockMultipartHttpServletRequest mockMultipartHttpServletRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    mockMultipartHttpServletRequest.setContextPath(null);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(mockMultipartHttpServletRequest);

    // Act
    String actualBundleUrl =
        resourceBundleProcessor.getBundleUrl("https://example.org/example", context);

    // Assert
    verify(context).getRequest();
    assertEquals("/https://example.org/example", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleUrl(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"
  })
  public void testGetBundleUrl_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.getBundleUrl("https://example.org/example", context));
    verify(context).getRequest();
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return {@code not empty/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleUrl(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"
  })
  public void testGetBundleUrl_thenReturnNotEmptyHttpsExampleOrgExample() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    MockMultipartHttpServletRequest mockMultipartHttpServletRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    mockMultipartHttpServletRequest.setContextPath("not empty");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(mockMultipartHttpServletRequest);

    // Act
    String actualBundleUrl =
        resourceBundleProcessor.getBundleUrl("https://example.org/example", context);

    // Assert
    verify(context).getRequest();
    assertEquals("not empty/https://example.org/example", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code not empty/}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleUrl(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"
  })
  public void testGetBundleUrl_whenEmptyString_thenReturnNotEmpty() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    MockMultipartHttpServletRequest mockMultipartHttpServletRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    mockMultipartHttpServletRequest.setContextPath("not empty");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(mockMultipartHttpServletRequest);

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("", context);

    // Assert
    verify(context).getRequest();
    assertEquals("not empty/", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code not empty/null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleUrl(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"
  })
  public void testGetBundleUrl_whenNull_thenReturnNotEmptyNull() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    MockMultipartHttpServletRequest mockMultipartHttpServletRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    mockMultipartHttpServletRequest.setContextPath("not empty");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(mockMultipartHttpServletRequest);

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl(null, context);

    // Assert
    verify(context).getRequest();
    assertEquals("not empty/null", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code not empty/}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundleUrl(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"
  })
  public void testGetBundleUrl_whenSlash_thenReturnNotEmpty() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    MockMultipartHttpServletRequest mockMultipartHttpServletRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    mockMultipartHttpServletRequest.setContextPath("not empty");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(mockMultipartHttpServletRequest);

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("/", context);

    // Assert
    verify(context).getRequest();
    assertEquals("not empty/", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_givenComma() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());
    tagAttributes.files(",");

    // Act and Assert
    assertTrue(resourceBundleProcessor.buildBundledFilesList(tagAttributes).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_givenEmptyString() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());
    tagAttributes.files("");

    // Act and Assert
    assertTrue(resourceBundleProcessor.buildBundledFilesList(tagAttributes).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_givenSpace() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());
    tagAttributes.files(" ");

    // Act and Assert
    assertTrue(resourceBundleProcessor.buildBundledFilesList(tagAttributes).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_thenReturnSizeIsOne() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());
    tagAttributes.files("not blank");

    // Act
    List<String> actualBuildBundledFilesListResult =
        resourceBundleProcessor.buildBundledFilesList(tagAttributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(null);
    assertEquals(1, actualBuildBundledFilesListResult.size());
    assertEquals("not blank", actualBuildBundledFilesListResult.get(0));
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_whenResourceTagAttributes_thenReturnEmpty() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertTrue(
        resourceBundleProcessor.buildBundledFilesList(new ResourceTagAttributes()).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath2() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), (String) null);
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            (String) isNull(),
            (String) isNull(),
            isA(List.class),
            eq("Resolve Bundle Resource Name"));
    assertEquals("Resolve Bundle Resource Name", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath3() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), (String) null);
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>()));
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath4() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>()));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code Bundle Path}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_given42_whenArrayListAdd42_thenReturnBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn("Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, files);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <ul>
   *   <li>Given Bean Name{blResourcesRequest} {@link ResourcesRequest#getBundle(String, String,
   *       List)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_givenBeanNameBlResourcesRequestGetBundleReturnNull() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            (String) isNull(),
            (String) isNull(),
            isA(List.class),
            eq("Resolve Bundle Resource Name"));
    assertEquals("Resolve Bundle Resource Name", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_givenEmptyString() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");

    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn(null);
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.mappingPrefix("Attributes");
    attributes.bundleCompletedEvent("");
    attributes.name(".js");

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourceBundlingService)
        .resolveBundleResourceName(eq(".js"), eq("Attributes"), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(eq(".js"), eq("Attributes"), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            eq(".js"), eq("Attributes"), isA(List.class), eq("Resolve Bundle Resource Name"));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Resolve Bundle Resource Name", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code Bundle Path}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_givenFoo_whenArrayListAddFoo_thenReturnBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn("Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, files);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <ul>
   *   <li>Given {@code .js}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_givenJs() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");

    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn(null);
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.mappingPrefix("Attributes");
    attributes.bundleCompletedEvent("Bundle Completed Event");
    attributes.name(".js");

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourceBundlingService)
        .resolveBundleResourceName(
            eq(".js"),
            eq("Attributes"),
            isA(List.class),
            eq(
                "var Bundle Completed EventEvent = new CustomEvent('Bundle Completed Event');document.dispatchEvent(Bundle Completed EventEvent);"));
    verify(resourcesRequest).getBundle(eq(".js"), eq("Attributes"), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            eq(".js"), eq("Attributes"), isA(List.class), eq("Resolve Bundle Resource Name"));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Resolve Bundle Resource Name", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <ul>
   *   <li>Given {@code var}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_givenVar() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");

    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn(null);
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.mappingPrefix("Attributes");
    attributes.bundleCompletedEvent("Bundle Completed Event");
    attributes.name("var ");

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourceBundlingService)
        .resolveBundleResourceName(eq("var "), eq("Attributes"), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(eq("var "), eq("Attributes"), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            eq("var "), eq("Attributes"), isA(List.class), eq("Resolve Bundle Resource Name"));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Resolve Bundle Resource Name", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   *
   * <ul>
   *   <li>Then return {@code Bundle Path}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_thenReturnBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn("Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList() {
    // Arrange
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult =
        resourceBundleProcessor.postProcessUnbundledFileList(
            attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList2() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", files, new ArrayList<>());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult =
        resourceBundleProcessor.postProcessUnbundledFileList(
            attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList3() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.postProcessUnbundledFileList(
                attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class)));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    attributeFiles.add("foo");

    // Act
    List<String> actualPostProcessUnbundledFileListResult =
        resourceBundleProcessor.postProcessUnbundledFileList(
            attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList_givenIllegalArgumentException() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("Attribute Files");

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());
    tagAttributes.mappingPrefix("Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.postProcessUnbundledFileList(
                attributeFiles, tagAttributes, context));
    verify(resourcesRequest).getBundle(isNull(), eq("Tag Attributes"), isA(List.class));
    verify(context).parseExpression("@{'Tag AttributesAttribute Files'}");
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList_givenParseExpression_thenReturnSizeIsOne() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("Attribute Files");

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());
    tagAttributes.mappingPrefix("Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    List<String> actualPostProcessUnbundledFileListResult =
        resourceBundleProcessor.postProcessUnbundledFileList(
            attributeFiles, tagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), eq("Tag Attributes"), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), eq("Tag Attributes"), isA(List.class), isA(List.class));
    verify(context).parseExpression("@{'Tag AttributesAttribute Files'}");
    assertEquals(1, actualPostProcessUnbundledFileListResult.size());
    assertEquals("Parse Expression", actualPostProcessUnbundledFileListResult.get(0));
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourcesRequestBundle#getBundleFilePaths()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList_thenCallsGetBundleFilePaths() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult =
        resourceBundleProcessor.postProcessUnbundledFileList(
            attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourcesRequest#saveBundle(String, String, List, List)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testPostProcessUnbundledFileList_thenCallsSaveBundle() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult =
        resourceBundleProcessor.postProcessUnbundledFileList(
            attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText_givenEmptyString() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.bundleCompletedEvent("");
    attributes.name(".js");

    // Act
    String actualBundleAppendText = resourceBundleProcessor.getBundleAppendText(attributes);

    // Assert
    assertNull(actualBundleAppendText);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#name()} return {@code
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText_givenName_whenResourceTagAttributesNameReturnName() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.name()).thenReturn("Name");
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");

    // Act
    String actualBundleAppendText = resourceBundleProcessor.getBundleAppendText(attributes);

    // Assert
    verify(attributes).bundleCompletedEvent();
    verify(attributes).name();
    assertNull(actualBundleAppendText);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#name()} return {@code
   *       .js}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText_whenResourceTagAttributesNameReturnJs_thenReturnAString() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.name()).thenReturn(".js");
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");

    // Act
    String actualBundleAppendText = resourceBundleProcessor.getBundleAppendText(attributes);

    // Assert
    verify(attributes, atLeast(1)).bundleCompletedEvent();
    verify(attributes).name();
    assertEquals(
        "var Bundle Completed EventEvent = new CustomEvent('Bundle Completed Event');document.dispatchEvent(Bundle"
            + " Completed EventEvent);",
        actualBundleAppendText);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText_whenResourceTagAttributes_thenReturnNull() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertNull(resourceBundleProcessor.getBundleAppendText(new ResourceTagAttributes()));
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleCompleteEventJavaScript(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#getBundleCompleteEventJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractResourceProcessor.getBundleCompleteEventJavaScript(ResourceTagAttributes)"
  })
  public void testGetBundleCompleteEventJavaScript() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertEquals(
        "var nullEvent = new CustomEvent('null');document.dispatchEvent(nullEvent);",
        resourceBundleProcessor.getBundleCompleteEventJavaScript(new ResourceTagAttributes()));
  }

  /**
   * Test {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractResourceProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name("");
    attributes.mappingPrefix("Resource Tag Attributes");
    attributes.files("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
  }

  /**
   * Test {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractResourceProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_whenResourceTagAttributes() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(new ResourceTagAttributes()));
  }
}
