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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletResponse;

public class FileSystemResponseWrapperDiffblueTest {
  /**
   * Test {@link FileSystemResponseWrapper#FileSystemResponseWrapper(HttpServletResponse, File)}.
   *
   * <p>Method under test: {@link
   * FileSystemResponseWrapper#FileSystemResponseWrapper(HttpServletResponse, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileSystemResponseWrapper.<init>(HttpServletResponse, File)"})
  public void testNewFileSystemResponseWrapper() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    FileSystemResponseWrapper actualFileSystemResponseWrapper =
        new FileSystemResponseWrapper(
            response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertSame(response, actualFileSystemResponseWrapper.getResponse());
  }
}
