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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceMinificationServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#minify(BufferedReader, BufferedWriter, String, String)}
   */
  @Test
  public void testMinify() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();
    BufferedReader in = new BufferedReader(new StringReader("foo"), 1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> resourceMinificationServiceImpl.minify(in, new BufferedWriter(new StringWriter(), 1), "foo.txt", "Type"));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertNull(resourceMinificationServiceImpl.getFileType(new GeneratedResource(), "foo.txt"));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertEquals("js", resourceMinificationServiceImpl.getFileType(new GeneratedResource(), ".js"));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertEquals("css", resourceMinificationServiceImpl.getFileType(new GeneratedResource(), ".css"));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#getFileType(Resource, String)}
   */
  @Test
  public void testGetFileType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceMinificationServiceImpl()).getFileType(mock(ByteArrayResource.class), "foo.txt"));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertFalse(resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new GeneratedResource()));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertFalse(
        resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMinificationServiceImpl resourceMinificationServiceImpl = new ResourceMinificationServiceImpl();

    // Act and Assert
    assertFalse(resourceMinificationServiceImpl.isPreviouslyMinifiedFile(new ClassPathResource("Path")));
  }

  /**
   * Method under test:
   * {@link ResourceMinificationServiceImpl#isPreviouslyMinifiedFile(Resource)}
   */
  @Test
  public void testIsPreviouslyMinifiedFile4() {
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
}
