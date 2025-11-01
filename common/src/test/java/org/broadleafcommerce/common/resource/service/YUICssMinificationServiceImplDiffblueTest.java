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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss2() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss3() throws ResourceMinificationException {
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

  /**
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss4() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss5() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss6() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss7() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss8() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss9() throws ResourceMinificationException {
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
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss10() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    FileReader reader = new FileReader(new FileDescriptor());

    // Act and Assert
    assertThrows(ResourceMinificationException.class,
        () -> yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, new StringWriter()));
  }

  /**
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss11() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("foo");

    // Act and Assert
    assertThrows(ResourceMinificationException.class,
        () -> yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, new PipedWriter()));
  }

  /**
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss12() throws ResourceMinificationException {
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
}
