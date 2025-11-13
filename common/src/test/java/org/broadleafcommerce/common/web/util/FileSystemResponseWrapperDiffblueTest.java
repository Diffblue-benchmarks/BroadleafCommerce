package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
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
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    FileSystemResponseWrapper actualFileSystemResponseWrapper =
        new FileSystemResponseWrapper(
            response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertSame(response, actualFileSystemResponseWrapper.getResponse());
  }
}
