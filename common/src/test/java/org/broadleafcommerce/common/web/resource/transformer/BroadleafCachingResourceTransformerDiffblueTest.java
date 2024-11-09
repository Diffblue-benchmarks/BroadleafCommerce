/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.resource.transformer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceTransformerChain;

public class BroadleafCachingResourceTransformerDiffblueTest {
  /**
   * Test
   * {@link BroadleafCachingResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCachingResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}
   */
  @Test
  public void testTransform_givenGeneratedResource_thenReturnGeneratedResource() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceTransformer broadleafCachingResourceTransformer = new BroadleafCachingResourceTransformer(
        new ConcurrentMapCache("Name"));
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    GeneratedResource resource = new GeneratedResource();
    ResourceTransformerChain transformerChain = mock(ResourceTransformerChain.class);
    GeneratedResource generatedResource = new GeneratedResource();
    when(transformerChain.transform(Mockito.<HttpServletRequest>any(), Mockito.<Resource>any()))
        .thenReturn(generatedResource);

    // Act
    Resource actualTransformResult = broadleafCachingResourceTransformer.transform(request, resource, transformerChain);

    // Assert
    verify(transformerChain).transform(isA(HttpServletRequest.class), isA(Resource.class));
    assertSame(generatedResource, actualTransformResult);
  }

  /**
   * Test
   * {@link BroadleafCachingResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCachingResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}
   */
  @Test
  public void testTransform_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceTransformer broadleafCachingResourceTransformer = new BroadleafCachingResourceTransformer(
        new ConcurrentMapCache("Name"));
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    GeneratedResource resource = new GeneratedResource();
    ResourceTransformerChain transformerChain = mock(ResourceTransformerChain.class);
    when(transformerChain.transform(Mockito.<HttpServletRequest>any(), Mockito.<Resource>any()))
        .thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> broadleafCachingResourceTransformer.transform(request, resource, transformerChain));
    verify(transformerChain).transform(isA(HttpServletRequest.class), isA(Resource.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafCachingResourceTransformer#setOrder(int)}
   *   <li>{@link BroadleafCachingResourceTransformer#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafCachingResourceTransformer broadleafCachingResourceTransformer = new BroadleafCachingResourceTransformer(
        new ConcurrentMapCache("Name"));

    // Act
    broadleafCachingResourceTransformer.setOrder(1);

    // Assert that nothing has changed
    assertEquals(1, broadleafCachingResourceTransformer.getOrder());
  }
}
