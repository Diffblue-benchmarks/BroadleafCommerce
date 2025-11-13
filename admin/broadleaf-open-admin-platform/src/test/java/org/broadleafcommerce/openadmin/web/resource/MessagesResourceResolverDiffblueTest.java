package org.broadleafcommerce.openadmin.web.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@ContextConfiguration(classes = {MessagesResourceResolver.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessagesResourceResolverDiffblueTest {
  @Autowired private MessagesResourceResolver messagesResourceResolver;

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link ClassPathResource#ClassPathResource(String)} with {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_givenClassPathResourceWithPath() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(new ClassPathResource("Path"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            messagesResourceResolver.resolveResource(
                request, "admin/ui/messages.js", locations, chain));
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("admin/ui/messages.js"), isA(List.class));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@code Path}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_givenGeneratedResource_whenPath_thenReturnNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveResource(
            request,
            "Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@code Path}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_givenGeneratedResource_whenPath_thenReturnNull2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveResource(
            request,
            "Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_givenRuntimeException() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            messagesResourceResolver.resolveResource(
                request, "admin/ui/messages.js", locations, chain));
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("admin/ui/messages.js"), isA(List.class));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteArrayResource#getInputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_thenCallsGetInputStream() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.getInputStream()).thenThrow(new RuntimeException());

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(byteArrayResource);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            messagesResourceResolver.resolveResource(
                request, "admin/ui/messages.js", locations, chain));
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("admin/ui/messages.js"), isA(List.class));
    verify(byteArrayResource).getInputStream();
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return Description is {@code admin/ui/messages.js}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_thenReturnDescriptionIsAdminUiMessagesJs() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8")));

    // Act
    Resource actualResolveResourceResult =
        messagesResourceResolver.resolveResource(request, "admin/ui/messages.js", locations, chain);

    // Assert
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("admin/ui/messages.js"), isA(List.class));
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals("admin/ui/messages.js", actualResolveResourceResult.getDescription());
    assertEquals("admin/ui/messages.js", actualResolveResourceResult.getFilename());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualResolveResourceResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), ((GeneratedResource) actualResolveResourceResult).getBytes());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_thenReturnGeneratedResource() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    GeneratedResource generatedResource = new GeneratedResource();
    locations.add(generatedResource);

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(new GeneratedResource());

    // Act
    Resource actualResolveResourceResult =
        messagesResourceResolver.resolveResource(request, "admin/ui/messages.js", locations, chain);

    // Assert
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("admin/ui/messages.js"), isA(List.class));
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualResolveResourceResult);
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_whenArrayList_thenReturnNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveResource(
            request,
            "Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResource_whenArrayList_thenReturnNull2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveResource(
            request,
            "admin/ui/messages.js",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   *
   * <p>Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables() {
    // Arrange
    GeneratedResource resource =
        new GeneratedResource(
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            "The characteristics of someone or something");

    // Act
    Resource actualUpdateMessagesVariablesResult =
        messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals(resource, actualUpdateMessagesVariablesResult);
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_givenIOException() throws IOException {
    // Arrange
    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> messagesResourceResolver.updateMessagesVariables(resource, "Path"));
    verify(resource).getInputStream();
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_givenRuntimeException() throws IOException {
    // Arrange
    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> messagesResourceResolver.updateMessagesVariables(resource, "Path"));
    verify(resource).getInputStream();
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   *
   * <ul>
   *   <li>Then return Description is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_thenReturnDescriptionIsPath() {
    // Arrange
    ByteArrayResource resource = new ByteArrayResource(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Resource actualUpdateMessagesVariablesResult =
        messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals("Path", actualUpdateMessagesVariablesResult.getDescription());
    assertEquals("Path", actualUpdateMessagesVariablesResult.getFilename());
    assertFalse(actualUpdateMessagesVariablesResult.isFile());
    assertFalse(actualUpdateMessagesVariablesResult.isOpen());
    assertArrayEquals(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
        ((GeneratedResource) actualUpdateMessagesVariablesResult).getBytes());
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   *
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_whenGeneratedResource_thenReturnGeneratedResource() {
    // Arrange
    GeneratedResource resource = new GeneratedResource();

    // Act
    Resource actualUpdateMessagesVariablesResult =
        messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals(resource, actualUpdateMessagesVariablesResult);
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(messagesResourceResolver.updateMessagesVariables(null, "Path"));
  }

  /**
   * Test {@link MessagesResourceResolver#getResourceContents(Resource)}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#getResourceContents(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessagesResourceResolver.getResourceContents(Resource)"})
  public void testGetResourceContents_thenReturnAxaxaxax() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        "AXAXAXAX",
        messagesResourceResolver.getResourceContents(
            new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link MessagesResourceResolver#getResourceContents(Resource)}.
   *
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#getResourceContents(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessagesResourceResolver.getResourceContents(Resource)"})
  public void testGetResourceContents_whenGeneratedResource_thenReturnEmptyString()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals("", messagesResourceResolver.getResourceContents(new GeneratedResource()));
  }

  /**
   * Test {@link MessagesResourceResolver#replaceResourceContents(String)}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#replaceResourceContents(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessagesResourceResolver.replaceResourceContents(String)"})
  public void testReplaceResourceContents_thenReturnNotAllWhoWanderAreLost() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        messagesResourceResolver.replaceResourceContents("Not all who wander are lost"));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveUrlPath(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveUrlPath(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link MessagesResourceResolver} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_givenMessagesResourceResolver() {
    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new MessagesResourceResolver());

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveUrlPath(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link MessagesResourceResolver}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_givenMessagesResourceResolver_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveUrlPath(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@code admin/ui/messages.js}.
   *   <li>Then return {@code admin/ui/messages.js}.
   * </ul>
   *
   * <p>Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPath_whenAdminUiMessagesJs_thenReturnAdminUiMessagesJs() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals(
        "admin/ui/messages.js",
        messagesResourceResolver.resolveUrlPath(
            "admin/ui/messages.js",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessagesResourceResolver#getMessagesJsPath()}
   *   <li>{@link MessagesResourceResolver#getOpenAdminMessagesProperties()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MessagesResourceResolver.getMessagesJsPath()",
    "String MessagesResourceResolver.getOpenAdminMessagesProperties()"
  })
  public void testGettersAndSetters() {
    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();

    // Act
    String actualMessagesJsPath = messagesResourceResolver.getMessagesJsPath();

    // Assert
    assertEquals("admin/ui/messages.js", actualMessagesJsPath);
    assertEquals(
        "messages/OpenAdminJavascriptMessages.properties",
        messagesResourceResolver.getOpenAdminMessagesProperties());
  }
}
