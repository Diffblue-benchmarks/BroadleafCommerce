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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertSame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
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
}
