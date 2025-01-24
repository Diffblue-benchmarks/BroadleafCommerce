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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertSame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;

public class FileSystemResponseWrapperDiffblueTest {
  /**
   * Test
   * {@link FileSystemResponseWrapper#FileSystemResponseWrapper(HttpServletResponse, File)}.
   * <p>
   * Method under test:
   * {@link FileSystemResponseWrapper#FileSystemResponseWrapper(HttpServletResponse, File)}
   */
  @Test
  public void testNewFileSystemResponseWrapper() throws IOException {
    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    StatusExposingServletResponse response = new StatusExposingServletResponse(
        htmlMinifyFilter.new CharResponseWrapper(new MockHttpServletResponse()));

    // Act and Assert
    assertSame(response,
        (new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getResponse());
  }

  /**
   * Test {@link FileSystemResponseWrapper#getOutputStream()}.
   * <p>
   * Method under test: {@link FileSystemResponseWrapper#getOutputStream()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOutputStream() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Temporary files were created but not deleted.
    //   The method under test created the following temporary files without deleting
    //   them:
    //     /var/folders/ck/xvkf1bcd5f1d2vy5qdng_6l80000gp/T/test.txt
    //   Please ensure that temporary files are deleted in the method under test.
    //   See https://diff.blue/R020

    // Arrange
    StatusExposingServletResponse response = new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    (new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
        .getOutputStream();
  }

  /**
   * Test {@link FileSystemResponseWrapper#getOutputStream()}.
   * <p>
   * Method under test: {@link FileSystemResponseWrapper#getOutputStream()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOutputStream2() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access files (file '/var/folders/ck/xvkf1bcd5f1d2vy5qdng_6l80000gp/T', permission 'write').
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    StatusExposingServletResponse response = new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    (new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "").toFile()))
        .getOutputStream();
  }

  /**
   * Test {@link FileSystemResponseWrapper#getWriter()}.
   * <p>
   * Method under test: {@link FileSystemResponseWrapper#getWriter()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWriter() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Temporary files were created but not deleted.
    //   The method under test created the following temporary files without deleting
    //   them:
    //     /var/folders/ck/xvkf1bcd5f1d2vy5qdng_6l80000gp/T/test.txt
    //   Please ensure that temporary files are deleted in the method under test.
    //   See https://diff.blue/R020

    // Arrange
    StatusExposingServletResponse response = new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    (new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
        .getWriter();
  }

  /**
   * Test {@link FileSystemResponseWrapper#getWriter()}.
   * <p>
   * Method under test: {@link FileSystemResponseWrapper#getWriter()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWriter2() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access files (file '/var/folders/ck/xvkf1bcd5f1d2vy5qdng_6l80000gp/T', permission 'write').
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    StatusExposingServletResponse response = new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    (new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "").toFile())).getWriter();
  }

  /**
   * Test {@link FileSystemResponseWrapper#closeFileOutputStream()}.
   * <p>
   * Method under test: {@link FileSystemResponseWrapper#closeFileOutputStream()}
   */
  @Test
  public void testCloseFileOutputStream() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    StatusExposingServletResponse response = new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    (new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
        .closeFileOutputStream();
  }
}
