package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.broadleafcommerce.openadmin.web.rulebuilder.enums.RuleBuilderEnumOptionsExtensionListener;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@RunWith(MockitoJUnitRunner.class)
public class RuleBuilderOptionsResourceResolverDiffblueTest {
  @Mock private List<RuleBuilderEnumOptionsExtensionListener> list;

  @InjectMocks private RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver;

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String,
   * List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        ruleBuilderOptionsResourceResolver.resolveResource(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String,
   * List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        ruleBuilderOptionsResourceResolver.resolveResource(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String,
   * List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link RuleBuilderOptionsResourceResolver} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_givenRuleBuilderOptionsResourceResolver_thenReturnNull() {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        ruleBuilderOptionsResourceResolver.resolveResource(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String,
   * List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return InputStream read is four.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_thenReturnInputStreamReadIsFour() throws IOException {
    // Arrange
    RuleBuilderEnumOptionsExtensionListener ruleBuilderEnumOptionsExtensionListener =
        mock(RuleBuilderEnumOptionsExtensionListener.class);
    when(ruleBuilderEnumOptionsExtensionListener.getOptionValues()).thenReturn("42");

    ArrayList<RuleBuilderEnumOptionsExtensionListener> ruleBuilderEnumOptionsExtensionListenerList =
        new ArrayList<>();
    ruleBuilderEnumOptionsExtensionListenerList.add(ruleBuilderEnumOptionsExtensionListener);
    when(list.iterator()).thenReturn(ruleBuilderEnumOptionsExtensionListenerList.iterator());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceResult =
        ruleBuilderOptionsResourceResolver.resolveResource(
            request,
            "admin/components/ruleBuilder-options.js",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(list).iterator();
    verify(ruleBuilderEnumOptionsExtensionListener).getOptionValues();
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals(
        "admin/components/ruleBuilder-options.js", actualResolveResourceResult.getDescription());
    assertEquals(
        "admin/components/ruleBuilder-options.js", actualResolveResourceResult.getFilename());
    byte[] byteArray = new byte[4];
    assertEquals(4, actualResolveResourceResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
    assertArrayEquals(
        "42\r\n".getBytes("UTF-8"), ((GeneratedResource) actualResolveResourceResult).getBytes());
    assertArrayEquals("42\r\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String,
   * List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return InputStream read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_thenReturnInputStreamReadIsMinusOne() throws IOException {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceResult =
        ruleBuilderOptionsResourceResolver.resolveResource(
            request,
            "admin/components/ruleBuilder-options.js",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals(
        "admin/components/ruleBuilder-options.js", actualResolveResourceResult.getDescription());
    assertEquals(
        "admin/components/ruleBuilder-options.js", actualResolveResourceResult.getFilename());
    int actualReadResult = actualResolveResourceResult.getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualResolveResourceResult).getBytes());
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        ruleBuilderOptionsResourceResolver.resolveUrlPath(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        ruleBuilderOptionsResourceResolver.resolveUrlPath(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return {@code admin/components/ruleBuilder-options.js}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_thenReturnAdminComponentsRuleBuilderOptionsJs() {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals(
        "admin/components/ruleBuilder-options.js",
        ruleBuilderOptionsResourceResolver.resolveUrlPath(
            "admin/components/ruleBuilder-options.js",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_whenArrayList_thenReturnNull() {
    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver =
        new RuleBuilderOptionsResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        ruleBuilderOptionsResourceResolver.resolveUrlPath(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }
}
