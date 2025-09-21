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
package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ResourceMinificationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceMinificationServiceImplDiffblueTest {
  @MockBean private CssMinificationService cssMinificationService;

  @MockBean private Environment environment;

  @MockBean private JavascriptMinificationService javascriptMinificationService;

  @Autowired private ResourceMinificationServiceImpl resourceMinificationServiceImpl;

  /**
   * Test {@link ResourceMinificationServiceImpl#getEnabled()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#getEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceMinificationServiceImpl.getEnabled()"})
  public void testGetEnabled_givenEnvironmentGetPropertyReturnFalse_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(false);

    // Act
    boolean actualEnabled = resourceMinificationServiceImpl.getEnabled();

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertFalse(actualEnabled);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getEnabled()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#getEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceMinificationServiceImpl.getEnabled()"})
  public void testGetEnabled_givenEnvironmentGetPropertyReturnTrue_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    // Act
    boolean actualEnabled = resourceMinificationServiceImpl.getEnabled();

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertTrue(actualEnabled);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(String, byte[])} with {@code filename},
   * {@code bytes}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(String, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceMinificationServiceImpl.minify(String, byte[])"})
  public void testMinifyWithFilenameBytes()
      throws UnsupportedEncodingException, ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doThrow(new ResourceMinificationException("An error occurred"))
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());

    // Act
    byte[] actualMinifyResult =
        resourceMinificationServiceImpl.minify(".js", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(String, byte[])} with {@code filename},
   * {@code bytes}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(String, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceMinificationServiceImpl.minify(String, byte[])"})
  public void testMinifyWithFilenameBytes2()
      throws UnsupportedEncodingException, ResourceMinificationException {
    // Arrange
    doThrow(new ResourceMinificationException("An error occurred"))
        .when(cssMinificationService)
        .minifyCss(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    // Act
    byte[] actualMinifyResult =
        resourceMinificationServiceImpl.minify(".css", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(cssMinificationService).minifyCss(eq(".css"), isA(Reader.class), isA(Writer.class));
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(String, byte[])} with {@code filename},
   * {@code bytes}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   *   <li>When {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(String, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceMinificationServiceImpl.minify(String, byte[])"})
  public void testMinifyWithFilenameBytes_givenEnvironmentGetPropertyReturnFalse_whenFooTxt()
      throws UnsupportedEncodingException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(false);

    // Act
    byte[] actualMinifyResult =
        resourceMinificationServiceImpl.minify("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(String, byte[])} with {@code filename},
   * {@code bytes}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(String, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceMinificationServiceImpl.minify(String, byte[])"})
  public void testMinifyWithFilenameBytes_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException, ResourceMinificationException {
    // Arrange
    doNothing()
        .when(cssMinificationService)
        .minifyCss(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    // Act
    byte[] actualMinifyResult =
        resourceMinificationServiceImpl.minify(".css", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(cssMinificationService).minifyCss(eq(".css"), isA(Reader.class), isA(Writer.class));
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    assertArrayEquals(new byte[] {}, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(String, byte[])} with {@code filename},
   * {@code bytes}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(String, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceMinificationServiceImpl.minify(String, byte[])"})
  public void testMinifyWithFilenameBytes_whenFooTxt_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    // Act
    byte[] actualMinifyResult =
        resourceMinificationServiceImpl.minify("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(String, byte[])} with {@code filename},
   * {@code bytes}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(String, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceMinificationServiceImpl.minify(String, byte[])"})
  public void testMinifyWithFilenameBytes_whenJs_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException, ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doNothing()
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());

    // Act
    byte[] actualMinifyResult =
        resourceMinificationServiceImpl.minify(".js", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    assertArrayEquals(new byte[] {}, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(BufferedReader, BufferedWriter, String,
   * String)} with {@code in}, {@code out}, {@code filename}, {@code type}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(BufferedReader,
   * BufferedWriter, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceMinificationServiceImpl.minify(BufferedReader, BufferedWriter, String, String)"
  })
  public void testMinifyWithInOutFilenameType() throws IOException, ResourceMinificationException {
    // Arrange
    doNothing()
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    BufferedReader in = new BufferedReader(new StringReader("foo"), 1);

    // Act
    resourceMinificationServiceImpl.minify(
        in, new BufferedWriter(new StringWriter(), 1), "foo.txt", "js");

    // Assert
    verify(javascriptMinificationService)
        .minifyJs(eq("foo.txt"), isA(Reader.class), isA(Writer.class));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(BufferedReader, BufferedWriter, String,
   * String)} with {@code in}, {@code out}, {@code filename}, {@code type}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(BufferedReader,
   * BufferedWriter, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceMinificationServiceImpl.minify(BufferedReader, BufferedWriter, String, String)"
  })
  public void testMinifyWithInOutFilenameType2() throws IOException, ResourceMinificationException {
    // Arrange
    doThrow(new ResourceMinificationException("An error occurred"))
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    BufferedReader in = new BufferedReader(new StringReader("foo"), 1);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            resourceMinificationServiceImpl.minify(
                in, new BufferedWriter(new StringWriter(), 1), "foo.txt", "js"));
    verify(javascriptMinificationService)
        .minifyJs(eq("foo.txt"), isA(Reader.class), isA(Writer.class));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(BufferedReader, BufferedWriter, String,
   * String)} with {@code in}, {@code out}, {@code filename}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JavascriptMinificationService}.
   *   <li>When {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(BufferedReader,
   * BufferedWriter, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceMinificationServiceImpl.minify(BufferedReader, BufferedWriter, String, String)"
  })
  public void testMinifyWithInOutFilenameType_givenJavascriptMinificationService_whenType()
      throws IOException {
    // Arrange
    BufferedReader in = new BufferedReader(new StringReader("foo"), 1);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            resourceMinificationServiceImpl.minify(
                in, new BufferedWriter(new StringWriter(), 1), "foo.txt", "Type"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource() throws UnsupportedEncodingException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    GeneratedResource originalResource =
        new GeneratedResource(
            "A\bA\bA\bA\b".getBytes("UTF-8"), "The characteristics of someone or something");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource2() throws UnsupportedEncodingException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    ByteArrayResource originalResource = new ByteArrayResource("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource3() throws IOException, ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doThrow(new ResourceMinificationException("An error occurred"))
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(originalResource.getFilename()).thenReturn(".js");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource, atLeast(1)).getFilename();
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename() throws ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doThrow(new ResourceMinificationException("An error occurred"))
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    GeneratedResource originalResource = new GeneratedResource();

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource, ".js");

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename2()
      throws UnsupportedEncodingException, ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doNothing()
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());

    // Act
    Resource actualMinifyResult =
        resourceMinificationServiceImpl.minify(
            new GeneratedResource(
                "A\bA\bA\bA\b".getBytes("UTF-8"), "The characteristics of someone or something"),
            ".js");

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertTrue(actualMinifyResult instanceof GeneratedResource);
    assertEquals(".js", actualMinifyResult.getDescription());
    assertEquals(".js", actualMinifyResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualMinifyResult).getBytes());
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename3()
      throws UnsupportedEncodingException, ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doNothing()
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());

    // Act
    Resource actualMinifyResult =
        resourceMinificationServiceImpl.minify(
            new ByteArrayResource("A\bA\bA\bA\b".getBytes("UTF-8")), ".js");

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertTrue(actualMinifyResult instanceof GeneratedResource);
    assertEquals(".js", actualMinifyResult.getDescription());
    assertEquals(".js", actualMinifyResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualMinifyResult).getBytes());
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename4()
      throws IOException, ResourceMinificationException {
    // Arrange
    doThrow(new ResourceMinificationException("An error occurred"))
        .when(cssMinificationService)
        .minifyCss(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource, ".css");

    // Assert
    verify(cssMinificationService).minifyCss(eq(".css"), isA(Reader.class), isA(Writer.class));
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource).getFilename();
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(false);
    GeneratedResource originalResource = new GeneratedResource();

    // Act
    Resource actualMinifyResult =
        resourceMinificationServiceImpl.minify(originalResource, "foo.txt");

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename_givenIOException() throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream()).thenThrow(new IOException());
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource, ".js");

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource).getFilename();
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename_givenNull() throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream()).thenReturn(null);
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource, ".js");

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource).getFilename();
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <ul>
   *   <li>Then return Description is {@code .css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename_thenReturnDescriptionIsCss()
      throws IOException, ResourceMinificationException {
    // Arrange
    doNothing()
        .when(cssMinificationService)
        .minifyCss(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource, ".css");

    // Assert
    verify(cssMinificationService).minifyCss(eq(".css"), isA(Reader.class), isA(Writer.class));
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource).getFilename();
    assertTrue(actualMinifyResult instanceof GeneratedResource);
    assertEquals(".css", actualMinifyResult.getDescription());
    assertEquals(".css", actualMinifyResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualMinifyResult).getBytes());
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <ul>
   *   <li>Then return Description is {@code .js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename_thenReturnDescriptionIsJs()
      throws IOException, ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doNothing()
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource, ".js");

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource).getFilename();
    assertTrue(actualMinifyResult instanceof GeneratedResource);
    assertEquals(".js", actualMinifyResult.getDescription());
    assertEquals(".js", actualMinifyResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualMinifyResult).getBytes());
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename_thenReturnGeneratedResource()
      throws ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doNothing()
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());
    GeneratedResource originalResource = new GeneratedResource();

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource, ".js");

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertTrue(actualMinifyResult instanceof GeneratedResource);
    assertEquals(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource, String)} with {@code
   * originalResource}, {@code filename}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource, String)"})
  public void testMinifyWithOriginalResourceFilename_whenFooTxt_thenReturnGeneratedResource() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    GeneratedResource originalResource = new GeneratedResource();

    // Act
    Resource actualMinifyResult =
        resourceMinificationServiceImpl.minify(originalResource, "foo.txt");

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(false);
    Resource originalResource = mock(Resource.class);

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <ul>
   *   <li>Given {@code foo.txt}.
   *   <li>When {@link Resource} {@link Resource#getFilename()} return {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource_givenFooTxt_whenResourceGetFilenameReturnFooTxt() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Resource originalResource = mock(Resource.class);
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource, atLeast(1)).getFilename();
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource_givenIOException() throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream()).thenThrow(new IOException());
    when(originalResource.getFilename()).thenReturn(".js");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource, atLeast(1)).getFilename();
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Resource} {@link Resource#getInputStream()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource_givenNull_whenResourceGetInputStreamReturnNull()
      throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream()).thenReturn(null);
    when(originalResource.getFilename()).thenReturn(".js");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource, atLeast(1)).getFilename();
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <ul>
   *   <li>Then return {@link GeneratedResource}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource_thenReturnGeneratedResource()
      throws IOException, ResourceMinificationException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    doNothing()
        .when(javascriptMinificationService)
        .minifyJs(Mockito.<String>any(), Mockito.<Reader>any(), Mockito.<Writer>any());

    Resource originalResource = mock(Resource.class);
    when(originalResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(originalResource.getFilename()).thenReturn(".js");

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(javascriptMinificationService).minifyJs(eq(".js"), isA(Reader.class), isA(Writer.class));
    verify(environment, atLeast(1)).getProperty(eq("minify.enabled"), isA(Class.class));
    verify(originalResource).getInputStream();
    verify(originalResource, atLeast(1)).getFilename();
    assertTrue(actualMinifyResult instanceof GeneratedResource);
    assertEquals(".js", actualMinifyResult.getDescription());
    assertEquals(".js", actualMinifyResult.getFilename());
    int actualReadResult = actualMinifyResult.getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualMinifyResult).getBytes());
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#minify(Resource)} with {@code originalResource}.
   *
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#minify(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceMinificationServiceImpl.minify(Resource)"})
  public void testMinifyWithOriginalResource_whenGeneratedResource_thenReturnGeneratedResource() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);
    GeneratedResource originalResource = new GeneratedResource();

    // Act
    Resource actualMinifyResult = resourceMinificationServiceImpl.minify(originalResource);

    // Assert
    verify(environment).getProperty(eq("minify.enabled"), isA(Class.class));
    assertSame(originalResource, actualMinifyResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceMinificationServiceImpl.getFileType(Resource, String)"})
  public void testGetFileType_whenCss_thenReturnCss() {
    // Arrange, Act and Assert
    assertEquals(
        "css", resourceMinificationServiceImpl.getFileType(new GeneratedResource(), ".css"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceMinificationServiceImpl.getFileType(Resource, String)"})
  public void testGetFileType_whenFooTxt_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(resourceMinificationServiceImpl.getFileType(new GeneratedResource(), "foo.txt"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return {@code js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceMinificationServiceImpl.getFileType(Resource, String)"})
  public void testGetFileType_whenJs_thenReturnJs() {
    // Arrange, Act and Assert
    assertEquals("js", resourceMinificationServiceImpl.getFileType(new GeneratedResource(), ".js"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   *
   * <p>Method under test: {@link
   * ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceMinificationServiceImpl.isPreviouslyMinifiedFile(Resource)"})
  public void testIsPreviouslyMinifiedFile() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        resourceMinificationServiceImpl.isPreviouslyMinifiedFile(
            new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   *
   * <ul>
   *   <li>Given {@code foo.txt}.
   *   <li>Then calls {@link ByteArrayResource#getFilename()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceMinificationServiceImpl.isPreviouslyMinifiedFile(Resource)"})
  public void testIsPreviouslyMinifiedFile_givenFooTxt_thenCallsGetFilename() {
    // Arrange
    ByteArrayResource originalResource = mock(ByteArrayResource.class);
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    boolean actualIsPreviouslyMinifiedFileResult =
        resourceMinificationServiceImpl.isPreviouslyMinifiedFile(originalResource);

    // Assert
    verify(originalResource).getFilename();
    assertFalse(actualIsPreviouslyMinifiedFileResult);
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   *
   * <ul>
   *   <li>When {@link ClassPathResource#ClassPathResource(String)} with {@code Path}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceMinificationServiceImpl.isPreviouslyMinifiedFile(Resource)"})
  public void testIsPreviouslyMinifiedFile_whenClassPathResourceWithPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new ClassPathResource("Path")));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   *
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceMinificationServiceImpl.isPreviouslyMinifiedFile(Resource)"})
  public void testIsPreviouslyMinifiedFile_whenGeneratedResource_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new GeneratedResource()));
  }
}
