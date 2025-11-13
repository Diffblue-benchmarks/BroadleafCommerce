package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCFileSystemUtilsDiffblueTest {
  /**
   * Test {@link BLCFileSystemUtils#getClasspathFileContents(String)}.
   *
   * <ul>
   *   <li>When {@code /directory/foo.txt}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCFileSystemUtils#getClasspathFileContents(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCFileSystemUtils.getClasspathFileContents(String)"})
  public void testGetClasspathFileContents_whenDirectoryFooTxt_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCFileSystemUtils.getClasspathFileContents("/directory/foo.txt"));
  }

  /**
   * Test {@link BLCFileSystemUtils#getClasspathFileInputStream(String)}.
   *
   * <ul>
   *   <li>When {@code /directory/foo.txt}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCFileSystemUtils#getClasspathFileInputStream(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream BLCFileSystemUtils.getClasspathFileInputStream(String)"})
  public void testGetClasspathFileInputStream_whenDirectoryFooTxt_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCFileSystemUtils.getClasspathFileInputStream("/directory/foo.txt"));
  }
}
