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
package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
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
  @InjectMocks
  private RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver;

  @Mock
  private List<RuleBuilderEnumOptionsExtensionListener> list;

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource() throws IOException {
    // Arrange
    RuleBuilderEnumOptionsExtensionListener ruleBuilderEnumOptionsExtensionListener = mock(
        RuleBuilderEnumOptionsExtensionListener.class);
    when(ruleBuilderEnumOptionsExtensionListener.getOptionValues()).thenReturn("42");

    ArrayList<RuleBuilderEnumOptionsExtensionListener> ruleBuilderEnumOptionsExtensionListenerList = new ArrayList<>();
    ruleBuilderEnumOptionsExtensionListenerList.add(ruleBuilderEnumOptionsExtensionListener);
    when(list.iterator()).thenReturn(ruleBuilderEnumOptionsExtensionListenerList.iterator());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    Resource actualResolveResourceResult = ruleBuilderOptionsResourceResolver.resolveResource(request,
        "admin/components/ruleBuilder-options.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(list).iterator();
    verify(ruleBuilderEnumOptionsExtensionListener).getOptionValues();
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getDescription());
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getFilename());
    byte[] byteArray = new byte[4];
    assertEquals(4, actualResolveResourceResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
    byte[] expectedBytes = "42\r\n".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((GeneratedResource) actualResolveResourceResult).getBytes());
    assertArrayEquals("42\r\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource2() throws IOException {
    // Arrange
    RuleBuilderEnumOptionsExtensionListener ruleBuilderEnumOptionsExtensionListener = mock(
        RuleBuilderEnumOptionsExtensionListener.class);
    when(ruleBuilderEnumOptionsExtensionListener.getOptionValues()).thenReturn("42");

    ArrayList<RuleBuilderEnumOptionsExtensionListener> ruleBuilderEnumOptionsExtensionListenerList = new ArrayList<>();
    ruleBuilderEnumOptionsExtensionListenerList.add(ruleBuilderEnumOptionsExtensionListener);
    when(list.iterator()).thenReturn(ruleBuilderEnumOptionsExtensionListenerList.iterator());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    Resource actualResolveResourceResult = ruleBuilderOptionsResourceResolver.resolveResource(request,
        "admin/components/ruleBuilder-options.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(list).iterator();
    verify(ruleBuilderEnumOptionsExtensionListener).getOptionValues();
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getDescription());
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getFilename());
    byte[] byteArray = new byte[4];
    assertEquals(4, actualResolveResourceResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
    byte[] expectedBytes = "42\r\n".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((GeneratedResource) actualResolveResourceResult).getBytes());
    assertArrayEquals("42\r\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return InputStream read is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_thenReturnInputStreamReadIsFour() throws IOException {
    // Arrange
    RuleBuilderEnumOptionsExtensionListener ruleBuilderEnumOptionsExtensionListener = mock(
        RuleBuilderEnumOptionsExtensionListener.class);
    when(ruleBuilderEnumOptionsExtensionListener.getOptionValues()).thenReturn("42");

    ArrayList<RuleBuilderEnumOptionsExtensionListener> ruleBuilderEnumOptionsExtensionListenerList = new ArrayList<>();
    ruleBuilderEnumOptionsExtensionListenerList.add(ruleBuilderEnumOptionsExtensionListener);
    when(list.iterator()).thenReturn(ruleBuilderEnumOptionsExtensionListenerList.iterator());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceResult = ruleBuilderOptionsResourceResolver.resolveResource(request,
        "admin/components/ruleBuilder-options.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(list).iterator();
    verify(ruleBuilderEnumOptionsExtensionListener).getOptionValues();
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getDescription());
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getFilename());
    byte[] byteArray = new byte[4];
    assertEquals(4, actualResolveResourceResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
    byte[] expectedBytes = "42\r\n".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((GeneratedResource) actualResolveResourceResult).getBytes());
    assertArrayEquals("42\r\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return InputStream read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_whenArrayList_thenReturnInputStreamReadIsMinusOne() throws IOException {
    // Arrange
    ArrayList<RuleBuilderEnumOptionsExtensionListener> ruleBuilderEnumOptionsExtensionListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleBuilderEnumOptionsExtensionListenerList.iterator());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceResult = ruleBuilderOptionsResourceResolver.resolveResource(request,
        "admin/components/ruleBuilder-options.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(list).iterator();
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getDescription());
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getFilename());
    assertEquals(-1, actualResolveResourceResult.getInputStream().read(new byte[]{}));
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
    assertArrayEquals(new byte[]{}, ((GeneratedResource) actualResolveResourceResult).getBytes());
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource RuleBuilderOptionsResourceResolver.resolveResource(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResource_whenRequestPath_thenReturnNull() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveResource(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@code admin/components/ruleBuilder-options.js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_thenReturnAdminComponentsRuleBuilderOptionsJs() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals("admin/components/ruleBuilder-options.js",
        ruleBuilderOptionsResourceResolver.resolveUrlPath("admin/components/ruleBuilder-options.js", locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RuleBuilderOptionsResourceResolver.resolveUrlPath(String, List, ResourceResolverChain)"})
  public void testResolveUrlPath_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }
}
