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
package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceMinificationServiceImplDiffblueTest {
  /**
   * Test
   * {@link ResourceMinificationServiceImpl#minify(BufferedReader, BufferedWriter, String, String)}
   * with {@code in}, {@code out}, {@code filename}, {@code type}.
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#minify(BufferedReader, BufferedWriter, String, String)}
   */
  @Test
  public void testMinifyWithInOutFilenameType() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();
    BufferedReader in = new BufferedReader(new StringReader("foo"), 1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> resourceMinificationServiceImpl.minify(in, new BufferedWriter(new StringWriter(), 1), "foo.txt", "Type"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}.
   * <ul>
   *   <li>When {@link ByteArrayResource}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType_whenByteArrayResource_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceMinificationServiceImpl()).getFileType(mock(ByteArrayResource.class), "foo.txt"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code css}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType_whenCss_thenReturnCss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertEquals("css", resourceMinificationServiceImpl.getFileType(new GeneratedResource(), ".css"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType_whenFooTxt_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertNull(resourceMinificationServiceImpl.getFileType(new GeneratedResource(), "foo.txt"));
  }

  /**
   * Test {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType_whenJs_thenReturnJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertEquals("js", resourceMinificationServiceImpl.getFileType(new GeneratedResource(), ".js"));
  }

  /**
   * Test
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertFalse(
        resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   * <ul>
   *   <li>Given {@code foo.txt}.</li>
   *   <li>Then calls {@link AbstractResource#getFilename()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile_givenFooTxt_thenCallsGetFilename() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();
    ByteArrayResource originalResource = mock(ByteArrayResource.class);
    when(originalResource.getFilename()).thenReturn("foo.txt");

    // Act
    boolean actualIsPreviouslyMinifiedFileResult = resourceMinificationServiceImpl
        .isPreviouslyMinifiedFile(originalResource);

    // Assert
    verify(originalResource).getFilename();
    assertFalse(actualIsPreviouslyMinifiedFileResult);
  }

  /**
   * Test
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   * <ul>
   *   <li>When {@link ClassPathResource#ClassPathResource(String)} with
   * {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile_whenClassPathResourceWithPath_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertFalse(resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new ClassPathResource("Path")));
  }

  /**
   * Test
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile_whenGeneratedResource_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertFalse(resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new GeneratedResource()));
  }
}
