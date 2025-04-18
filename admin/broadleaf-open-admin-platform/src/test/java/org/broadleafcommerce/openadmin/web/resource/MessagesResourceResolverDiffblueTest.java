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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
  @Autowired
  private MessagesResourceResolver messagesResourceResolver;

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link MessagesResourceResolver} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_givenMessagesResourceResolver() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new MessagesResourceResolver());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code admin/ui/messages.js}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_whenAdminUiMessagesJs_thenReturnNull() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "admin/ui/messages.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource MessagesResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_whenArrayList_thenReturnNull() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(messagesResourceResolver.resolveResource(request, "Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <p>
   * Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables() {
    // Arrange
    GeneratedResource resource = new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        "The characteristics of someone or something");

    // Act
    Resource actualUpdateMessagesVariablesResult = messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals(resource, actualUpdateMessagesVariablesResult);
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>Then return Description is {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_thenReturnDescriptionIsPath() {
    // Arrange and Act
    Resource actualUpdateMessagesVariablesResult = messagesResourceResolver
        .updateMessagesVariables(new ByteArrayResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals("Path", actualUpdateMessagesVariablesResult.getDescription());
    assertEquals("Path", actualUpdateMessagesVariablesResult.getFilename());
    assertFalse(actualUpdateMessagesVariablesResult.isFile());
    assertFalse(actualUpdateMessagesVariablesResult.isOpen());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        ((GeneratedResource) actualUpdateMessagesVariablesResult).getBytes());
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_whenGeneratedResource_thenReturnGeneratedResource() {
    // Arrange
    GeneratedResource resource = new GeneratedResource();

    // Act
    Resource actualUpdateMessagesVariablesResult = messagesResourceResolver.updateMessagesVariables(resource, "Path");

    // Assert
    assertTrue(actualUpdateMessagesVariablesResult instanceof GeneratedResource);
    assertEquals(resource, actualUpdateMessagesVariablesResult);
  }

  /**
   * Test {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#updateMessagesVariables(Resource, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource MessagesResourceResolver.updateMessagesVariables(Resource, String)"})
  public void testUpdateMessagesVariables_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(messagesResourceResolver.updateMessagesVariables(null, "Path"));
  }

  /**
   * Test {@link MessagesResourceResolver#getResourceContents(Resource)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#getResourceContents(Resource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.getResourceContents(Resource)"})
  public void testGetResourceContents_thenReturnAxaxaxax() throws IOException {
    // Arrange, Act and Assert
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
   * Method under test: {@link MessagesResourceResolver#getResourceContents(Resource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.getResourceContents(Resource)"})
  public void testGetResourceContents_whenGeneratedResource_thenReturnEmptyString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", messagesResourceResolver.getResourceContents(new GeneratedResource()));
  }

  /**
   * Test {@link MessagesResourceResolver#replaceResourceContents(String)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#replaceResourceContents(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.replaceResourceContents(String)"})
  public void testReplaceResourceContents_thenReturnNotAllWhoWanderAreLost() throws IOException {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        messagesResourceResolver.replaceResourceContents("Not all who wander are lost"));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link MessagesResourceResolver} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_givenMessagesResourceResolver() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new MessagesResourceResolver());

    // Act and Assert
    assertNull(messagesResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code admin/ui/messages.js}.</li>
   *   <li>Then return {@code admin/ui/messages.js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_whenAdminUiMessagesJs_thenReturnAdminUiMessagesJs() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals("admin/ui/messages.js", messagesResourceResolver.resolveUrlPath("admin/ui/messages.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagesResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_whenArrayList_thenReturnNull() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessagesResourceResolver.getMessagesJsPath()",
      "String MessagesResourceResolver.getOpenAdminMessagesProperties()"})
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
