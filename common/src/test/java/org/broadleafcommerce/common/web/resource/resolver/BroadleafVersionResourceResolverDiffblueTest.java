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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;
import org.springframework.web.servlet.resource.VersionStrategy;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafVersionResourceResolverDiffblueTest {
  @InjectMocks
  private BroadleafVersionResourceResolver broadleafVersionResourceResolver;

  @Mock
  private Map<String, VersionStrategy> map;

  /**
   * Test {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafVersionResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_givenGeneratedResource() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafVersionResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_givenGeneratedResource2() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafVersionResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_whenArrayList_thenReturnNull() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BroadleafVersionResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BroadleafVersionResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BroadleafVersionResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafVersionResourceResolver#setOrder(int)}
   *   <li>{@link BroadleafVersionResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BroadleafVersionResourceResolver.getOrder()",
      "void BroadleafVersionResourceResolver.setOrder(int)"})
  public void testGettersAndSetters() {
    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();

    // Act
    broadleafVersionResourceResolver.setOrder(1);

    // Assert
    assertEquals(1, broadleafVersionResourceResolver.getOrder());
  }

  /**
   * Test {@link BroadleafVersionResourceResolver#initIt()}.
   * <ul>
   *   <li>Then calls {@link Map#entrySet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafVersionResourceResolver#initIt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafVersionResourceResolver.initIt()"})
  public void testInitIt_thenCallsEntrySet() throws Exception {
    // Arrange
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);

    // Act
    broadleafVersionResourceResolver.initIt();

    // Assert
    verify(map).entrySet();
    verify(map).size();
  }
}
