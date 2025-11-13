package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class BLCSystemPropertyResourceResolverDiffblueTest {
  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String,
   * List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCSystemPropertyResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        blcSystemPropertyResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String,
   * List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCSystemPropertyResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        blcSystemPropertyResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String,
   * List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCSystemPropertyResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_whenArrayList_thenReturnNull() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        blcSystemPropertyResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}.
   *
   * <p>Method under test: {@link
   * BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    ClassPathResource classPathResource = new ClassPathResource("BLC-system-property.js");
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(classPathResource);

    // Act
    Resource actualResolveResourceInternalResult =
        blcSystemPropertyResourceResolver.resolveResourceInternal(
            request, "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertSame(classPathResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return Description is {@code BLC-system-property.js}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenA_thenReturnDescriptionIsBlcSystemPropertyJs()
      throws IOException {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    ByteArrayResource byteArrayResource =
        new ByteArrayResource(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(byteArrayResource);

    // Act
    Resource actualResolveResourceInternalResult =
        blcSystemPropertyResourceResolver.resolveResourceInternal(
            request, "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals("BLC-system-property.js", actualResolveResourceInternalResult.getDescription());
    assertEquals("BLC-system-property.js", actualResolveResourceInternalResult.getFilename());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualResolveResourceInternalResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceInternalResult.isFile());
    assertArrayEquals(
        new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3},
        ((GeneratedResource) actualResolveResourceInternalResult).getBytes());
    assertArrayEquals(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3}, byteArray);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenGeneratedResource_thenReturnGeneratedResource() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    GeneratedResource generatedResource = new GeneratedResource();
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(generatedResource);

    // Act
    Resource actualResolveResourceInternalResult =
        blcSystemPropertyResourceResolver.resolveResourceInternal(
            request, "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_whenArrayListAddGeneratedResource() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    GeneratedResource generatedResource = new GeneratedResource();
    locations.add(generatedResource);

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(new GeneratedResource());

    // Act
    Resource actualResolveResourceInternalResult =
        blcSystemPropertyResourceResolver.resolveResourceInternal(
            request, "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_whenArrayListAddGeneratedResource2() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    GeneratedResource generatedResource = new GeneratedResource();
    locations.add(generatedResource);
    locations.add(new GeneratedResource());

    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(new GeneratedResource());

    // Act
    Resource actualResolveResourceInternalResult =
        blcSystemPropertyResourceResolver.resolveResourceInternal(
            request, "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain)
        .resolveResource(
            isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@code Request Path}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_whenRequestPath_thenReturnNull() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        blcSystemPropertyResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Description is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BLCSystemPropertyResourceResolver#convertResource(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.convertResource(Resource, String)"
  })
  public void testConvertResource_whenA_thenReturnDescriptionIsFooTxt() throws IOException {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    ByteArrayResource origResource =
        new ByteArrayResource(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Resource actualConvertResourceResult =
        blcSystemPropertyResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals("foo.txt", actualConvertResourceResult.getDescription());
    assertEquals("foo.txt", actualConvertResourceResult.getFilename());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualConvertResourceResult.getInputStream().read(byteArray));
    assertFalse(actualConvertResourceResult.isFile());
    assertFalse(actualConvertResourceResult.isOpen());
    assertArrayEquals(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
        ((GeneratedResource) actualConvertResourceResult).getBytes());
    assertArrayEquals(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, byteArray);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}.
   *
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCSystemPropertyResourceResolver#convertResource(Resource,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCSystemPropertyResourceResolver.convertResource(Resource, String)"
  })
  public void testConvertResource_whenGeneratedResource_thenReturnGeneratedResource()
      throws IOException {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();
    GeneratedResource origResource = new GeneratedResource();

    // Act
    Resource actualConvertResourceResult =
        blcSystemPropertyResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals(origResource, actualConvertResourceResult);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#addVersion(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code Request Path1.0.2.null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCSystemPropertyResourceResolver#addVersion(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCSystemPropertyResourceResolver.addVersion(String, String)"})
  public void testAddVersion_thenReturnRequestPath102Null() {
    // Arrange, Act and Assert
    assertEquals(
        "Request Path1.0.2.null",
        new BLCSystemPropertyResourceResolver().addVersion("Request Path", "1.0.2"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BLCSystemPropertyResourceResolver#setOrder(int)}
   *   <li>{@link BLCSystemPropertyResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BLCSystemPropertyResourceResolver.getOrder()",
    "void BLCSystemPropertyResourceResolver.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver =
        new BLCSystemPropertyResourceResolver();

    // Act
    blcSystemPropertyResourceResolver.setOrder(1);

    // Assert
    assertEquals(1, blcSystemPropertyResourceResolver.getOrder());
  }
}
