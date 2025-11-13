package org.broadleafcommerce.common.web.resource.transformer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.resource.service.ResourceMinificationService;
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
  @InjectMocks private MinifyResourceTransformer minifyResourceTransformer;

  @Mock private ResourceMinificationService resourceMinificationService;

  /**
   * Test {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource,
   * ResourceTransformerChain)}.
   *
   * <ul>
   *   <li>Given {@link MinifyResourceTransformer} (default constructor).
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource,
   * ResourceTransformerChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MinifyResourceTransformer.transform(HttpServletRequest, Resource, ResourceTransformerChain)"
  })
  public void testTransform_givenMinifyResourceTransformer_thenThrowIOException()
      throws IOException {
    // Arrange
    MinifyResourceTransformer minifyResourceTransformer = new MinifyResourceTransformer();
    MockHttpServletRequest request = new MockHttpServletRequest();
    GeneratedResource resource = new GeneratedResource();

    ResourceTransformerChain transformerChain = mock(ResourceTransformerChain.class);
    when(transformerChain.transform(Mockito.<HttpServletRequest>any(), Mockito.<Resource>any()))
        .thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> minifyResourceTransformer.transform(request, resource, transformerChain));
    verify(transformerChain).transform(isA(HttpServletRequest.class), isA(Resource.class));
  }

  /**
   * Test {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource,
   * ResourceTransformerChain)}.
   *
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link MinifyResourceTransformer#transform(HttpServletRequest, Resource,
   * ResourceTransformerChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource MinifyResourceTransformer.transform(HttpServletRequest, Resource, ResourceTransformerChain)"
  })
  public void testTransform_thenReturnGeneratedResource() throws IOException {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceMinificationService.minify(Mockito.<Resource>any())).thenReturn(generatedResource);
    MockHttpServletRequest request = new MockHttpServletRequest();
    GeneratedResource resource = new GeneratedResource();

    ResourceTransformerChain transformerChain = mock(ResourceTransformerChain.class);
    when(transformerChain.transform(Mockito.<HttpServletRequest>any(), Mockito.<Resource>any()))
        .thenReturn(new GeneratedResource());

    // Act
    Resource actualTransformResult =
        minifyResourceTransformer.transform(request, resource, transformerChain);

    // Assert
    verify(resourceMinificationService).minify(isA(Resource.class));
    verify(transformerChain).transform(isA(HttpServletRequest.class), isA(Resource.class));
    assertSame(generatedResource, actualTransformResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MinifyResourceTransformer#setOrder(int)}
   *   <li>{@link MinifyResourceTransformer#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int MinifyResourceTransformer.getOrder()",
    "void MinifyResourceTransformer.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    MinifyResourceTransformer minifyResourceTransformer = new MinifyResourceTransformer();

    // Act
    minifyResourceTransformer.setOrder(1);

    // Assert
    assertEquals(1, minifyResourceTransformer.getOrder());
  }
}
