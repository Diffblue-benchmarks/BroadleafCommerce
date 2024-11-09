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
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceTransformerChain;

public class MinifyResourceTransformerDiffblueTest {
  /**
   * Test
   * {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource, ResourceTransformerChain)}
   */
  @Test
  public void testTransform_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MinifyResourceTransformer minifyResourceTransformer = new MinifyResourceTransformer();
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MinifyResourceTransformer#setOrder(int)}
   *   <li>{@link MinifyResourceTransformer#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MinifyResourceTransformer minifyResourceTransformer = new MinifyResourceTransformer();

    // Act
    minifyResourceTransformer.setOrder(1);

    // Assert that nothing has changed
    assertEquals(1, minifyResourceTransformer.getOrder());
  }
}
