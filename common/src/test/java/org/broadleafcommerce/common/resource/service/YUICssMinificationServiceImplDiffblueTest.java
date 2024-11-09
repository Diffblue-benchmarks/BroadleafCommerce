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
import static org.junit.Assert.assertThrows;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.Test;

public class YUICssMinificationServiceImplDiffblueTest {
  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code * /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_thenStringWriterToStringIsAsteriskSlash() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("*/ ");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("*/", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code :}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_thenStringWriterToStringIsColon() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("___YUICSSMIN_PSEUDOCLASSCOLON___");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(":", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code UUU:UUU:UUU:U{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String,
   * Reader, Writer)}
   */
  @Test
  public void testMinifyCss_thenStringWriterToStringIsUuuUuuUuuU() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("UUU:UUU:UUU:U{");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("UUU:UUU:UUU:U{", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link FileReader#FileReader(FileDescriptor)} with
   * {@link FileDescriptor#FileDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenFileReaderWithFileDescriptor() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    FileReader reader = new FileReader(new FileDescriptor());

    // Act and Assert
    assertThrows(ResourceMinificationException.class,
        () -> yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link PipedWriter#PipedWriter()}.</li>
   *   <li>Then throw {@link ResourceMinificationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenPipedWriter_thenThrowResourceMinificationException()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("foo");

    // Act and Assert
    assertThrows(ResourceMinificationException.class,
        () -> yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, new PipedWriter()));
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code :first-line{}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code :first-line
   * {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String,
   * Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithFirstLine_thenStringWriterToStringIsFirstLine()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader(":first-line{");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(":first-line {", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithFoo_thenStringWriterToStringIsFoo()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code !important}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code !important}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithImportant_thenStringWriterToStringIsImportant()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("!important");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("!important", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code ;}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithSemicolon_thenStringWriterToStringIsSemicolon()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader(" ;");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(";", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code U@charset "U";}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code @charset "U";U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithUCharsetU_thenStringWriterToStringIsCharsetUU()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("U@charset \"U\";");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("@charset \"U\";U", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code url( data:}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code url(data:}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithUrlData_thenStringWriterToStringIsUrlData()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("url( data:");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("url(data:", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code "UU"}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code "UU"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithUu_thenStringWriterToStringIsUu() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("\"UU\"");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("\"UU\"", writer.toString());
  }
}
