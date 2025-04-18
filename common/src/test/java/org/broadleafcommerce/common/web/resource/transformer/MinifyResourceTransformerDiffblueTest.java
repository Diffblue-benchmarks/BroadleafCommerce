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
package org.broadleafcommerce.common.web.resource.transformer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.resource.service.ResourceMinificationService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceTransformerChain;

@RunWith(MockitoJUnitRunner.class)
public class MinifyResourceTransformerDiffblueTest {
  @InjectMocks
  private MinifyResourceTransformer minifyResourceTransformer;

  @Mock
  private ResourceMinificationService resourceMinificationService;

  /**
   * Test {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}.
   * <ul>
   *   <li>Given {@link ResourceMinificationService}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource MinifyResourceTransformer.transform(HttpServletRequest, Resource, ResourceTransformerChain)"})
  public void testTransform_givenResourceMinificationService_thenThrowIOException() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    GeneratedResource resource = new GeneratedResource();
    ResourceTransformerChain transformerChain = mock(ResourceTransformerChain.class);
    when(transformerChain.transform(Mockito.<HttpServletRequest>any(), Mockito.<Resource>any()))
        .thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> minifyResourceTransformer.transform(request, resource, transformerChain));
    verify(transformerChain).transform(isA(HttpServletRequest.class), isA(Resource.class));
  }

  /**
   * Test {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}.
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource MinifyResourceTransformer.transform(HttpServletRequest, Resource, ResourceTransformerChain)"})
  public void testTransform_thenReturnGeneratedResource() throws IOException {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceMinificationService.minify(Mockito.<Resource>any())).thenReturn(generatedResource);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    GeneratedResource resource = new GeneratedResource();
    ResourceTransformerChain transformerChain = mock(ResourceTransformerChain.class);
    when(transformerChain.transform(Mockito.<HttpServletRequest>any(), Mockito.<Resource>any()))
        .thenReturn(new GeneratedResource());

    // Act
    Resource actualTransformResult = minifyResourceTransformer.transform(request, resource, transformerChain);

    // Assert
    verify(resourceMinificationService).minify(isA(Resource.class));
    verify(transformerChain).transform(isA(HttpServletRequest.class), isA(Resource.class));
    assertSame(generatedResource, actualTransformResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MinifyResourceTransformer#setOrder(int)}
   *   <li>{@link MinifyResourceTransformer#getOrder()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MinifyResourceTransformer.getOrder()", "void MinifyResourceTransformer.setOrder(int)"})
  public void testGettersAndSetters() {
    // Arrange
    MinifyResourceTransformer minifyResourceTransformer = new MinifyResourceTransformer();

    // Act
    minifyResourceTransformer.setOrder(1);

    // Assert
    assertEquals(1, minifyResourceTransformer.getOrder());
  }
}
