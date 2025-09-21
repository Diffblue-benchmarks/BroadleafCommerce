/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
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
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
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
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

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
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
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
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

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
   *   <li>Given {@link MessagesResourceResolver} (default constructor).
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
  public void testResolveResource_givenMessagesResourceResolver() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new MessagesResourceResolver());

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveResource(
            request, "Path", locations, new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link MessagesResourceResolver} (default constructor).
   *   <li>When {@code admin/ui/messages.js}.
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
  public void testResolveResource_givenMessagesResourceResolver_whenAdminUiMessagesJs() {
    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new MessagesResourceResolver());

    // Act and Assert
    assertNull(
        messagesResourceResolver.resolveResource(
            request,
            "admin/ui/messages.js",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link MessagesResourceResolver}.
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
  public void testResolveResource_givenMessagesResourceResolver_whenPath_thenReturnNull() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
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
   *   <li>When {@code admin/ui/messages.js}.
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
  public void testResolveResource_whenAdminUiMessagesJs_thenReturnNull() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
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
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   *
   * <ul>
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
  public void testResolveUrlPath_whenArrayList_thenReturnNull() {
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
