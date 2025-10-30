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
package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@ContextConfiguration(classes = {BLCJSUrlPathResolver.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BLCJSUrlPathResolverDiffblueTest {
  @Autowired
  private BLCJSUrlPathResolver bLCJSUrlPathResolver;

  /**
   * Test {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCJSUrlPathResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCJSUrlPathResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCJSUrlPathResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCJSUrlPathResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code BLC.js}.</li>
   *   <li>Then return {@code BLC.js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCJSUrlPathResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_whenBlcJs_thenReturnBlcJs() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals("BLC.js", bLCJSUrlPathResolver.resolveUrlPathInternal("BLC.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCJSUrlPathResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_whenHttpsExampleOrgExample_thenReturnNull() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(bLCJSUrlPathResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCJSUrlPathResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_givenGeneratedResource() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCJSUrlPathResolver.resolveResourceInternal(request, "https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCJSUrlPathResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_givenGeneratedResource2() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCJSUrlPathResolver.resolveResourceInternal(request, "https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCJSUrlPathResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_whenArrayList_thenReturnNull() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(bLCJSUrlPathResolver.resolveResourceInternal(request, "https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#addVersion(String, String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/examplehttps://example.org/example.null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#addVersion(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCJSUrlPathResolver.addVersion(String, String)"})
  public void testAddVersion_thenReturnHttpsExampleOrgExamplehttpsExampleOrgExampleNull() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplehttps://example.org/example.null",
        bLCJSUrlPathResolver.addVersion("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BLCJSUrlPathResolver#setOrder(int)}
   *   <li>{@link BLCJSUrlPathResolver#getOrder()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BLCJSUrlPathResolver.getOrder()", "void BLCJSUrlPathResolver.setOrder(int)"})
  public void testGettersAndSetters() {
    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();

    // Act
    blcjsUrlPathResolver.setOrder(1);

    // Assert
    assertEquals(1, blcjsUrlPathResolver.getOrder());
  }
}
