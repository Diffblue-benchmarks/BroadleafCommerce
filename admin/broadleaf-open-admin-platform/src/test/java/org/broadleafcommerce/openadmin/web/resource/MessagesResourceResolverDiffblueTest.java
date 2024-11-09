/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class MessagesResourceResolverDiffblueTest {
  /**
   * Test
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code admin/ui/messages.js}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_whenAdminUiMessagesJs_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "admin/ui/messages.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link MessagesResourceResolver}
   * (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_whenArrayListAddMessagesResourceResolver_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new MessagesResourceResolver());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  public void testUpdateMessagesVariables() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    GeneratedResource resource = new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        "The characteristics of someone or something");

    // Act
    Resource actualUpdateMessagesVariablesResult = messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals(resource, actualUpdateMessagesVariablesResult);
  }

  /**
   * Test
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code UTF-8}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  public void testUpdateMessagesVariables_givenIOExceptionWithUtf8_thenThrowRuntimeException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException("UTF-8"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> messagesResourceResolver.updateMessagesVariables(resource, "Path"));
    verify(resource).getInputStream();
  }

  /**
   * Test
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>Then return second element is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  public void testUpdateMessagesVariables_thenReturnSecondElementIsOne() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();

    // Act
    Resource actualUpdateMessagesVariablesResult = messagesResourceResolver
        .updateMessagesVariables(new ByteArrayResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    byte[] bytes = ((GeneratedResource) actualUpdateMessagesVariablesResult).getBytes();
    assertEquals((byte) 1, bytes[1]);
    assertEquals((byte) 1, bytes[3]);
    assertEquals((byte) 1, bytes[5]);
    assertEquals((byte) 1, bytes[7]);
    byte[] byteArray = new byte[8];
    assertEquals(8, actualUpdateMessagesVariablesResult.getInputStream().read(byteArray));
    assertEquals(8, bytes.length);
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, byteArray);
  }

  /**
   * Test
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>Then return second element is {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  public void testUpdateMessagesVariables_thenReturnSecondElementIsX() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    Resource actualUpdateMessagesVariablesResult = messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    verify(resource).getInputStream();
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    byte[] byteArray = new byte[8];
    assertEquals(8, actualUpdateMessagesVariablesResult.getInputStream().read(byteArray));
    byte[] bytes = ((GeneratedResource) actualUpdateMessagesVariablesResult).getBytes();
    assertEquals(8, bytes.length);
    assertEquals('X', bytes[1]);
    assertEquals('X', bytes[3]);
    assertEquals('X', bytes[5]);
    assertEquals('X', bytes[7]);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  public void testUpdateMessagesVariables_whenGeneratedResource_thenReturnGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    GeneratedResource resource = new GeneratedResource();

    // Act
    Resource actualUpdateMessagesVariablesResult = messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals(resource, actualUpdateMessagesVariablesResult);
  }

  /**
   * Test
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  public void testUpdateMessagesVariables_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new MessagesResourceResolver()).updateMessagesVariables(null, "Path"));
  }

  /**
   * Test {@link MessagesResourceResolver#getResourceContents(Resource)}.
   * <ul>
   *   <li>Then calls {@link ByteArrayResource#getInputStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#getResourceContents(Resource)}
   */
  @Test
  public void testGetResourceContents_thenCallsGetInputStream() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    ByteArrayResource resource = mock(ByteArrayResource.class);
    when(resource.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    String actualResourceContents = messagesResourceResolver.getResourceContents(resource);

    // Assert
    verify(resource).getInputStream();
    assertEquals("AXAXAXAX", actualResourceContents);
  }

  /**
   * Test {@link MessagesResourceResolver#getResourceContents(Resource)}.
   * <ul>
   *   <li>When {@link ByteArrayResource#ByteArrayResource(byte[])} with byteArray
   * is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#getResourceContents(Resource)}
   */
  @Test
  public void testGetResourceContents_whenByteArrayResourceWithByteArrayIsAxaxaxaxBytesIsUtf8() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();

    // Act and Assert
    assertEquals("AXAXAXAX",
        messagesResourceResolver.getResourceContents(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link MessagesResourceResolver#getResourceContents(Resource)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#getResourceContents(Resource)}
   */
  @Test
  public void testGetResourceContents_whenGeneratedResource_thenReturnEmptyString() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();

    // Act and Assert
    assertEquals("", messagesResourceResolver.getResourceContents(new GeneratedResource()));
  }

  /**
   * Test {@link MessagesResourceResolver#replaceResourceContents(String)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#replaceResourceContents(String)}
   */
  @Test
  public void testReplaceResourceContents_thenReturnNotAllWhoWanderAreLost() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new MessagesResourceResolver()).replaceResourceContents("Not all who wander are lost"));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualResolveUrlPathResult = messagesResourceResolver.resolveUrlPath("https://example.org/example",
        locations, chain);

    // Assert
    verify(chain).resolveUrlPath(eq("https://example.org/example"), isA(List.class));
    assertEquals("https://example.org/example", actualResolveUrlPathResult);
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code admin/ui/messages.js}.</li>
   *   <li>Then return {@code admin/ui/messages.js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_whenAdminUiMessagesJs_thenReturnAdminUiMessagesJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals("admin/ui/messages.js", messagesResourceResolver.resolveUrlPath("admin/ui/messages.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link MessagesResourceResolver}
   * (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_whenArrayListAddMessagesResourceResolver_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new MessagesResourceResolver());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(messagesResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessagesResourceResolver#getMessagesJsPath()}
   *   <li>{@link MessagesResourceResolver#getOpenAdminMessagesProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MessagesResourceResolver messagesResourceResolver = new MessagesResourceResolver();

    // Act
    String actualMessagesJsPath = messagesResourceResolver.getMessagesJsPath();

    // Assert
    assertEquals("admin/ui/messages.js", actualMessagesJsPath);
    assertEquals("messages/OpenAdminJavascriptMessages.properties",
        messagesResourceResolver.getOpenAdminMessagesProperties());
  }
}
