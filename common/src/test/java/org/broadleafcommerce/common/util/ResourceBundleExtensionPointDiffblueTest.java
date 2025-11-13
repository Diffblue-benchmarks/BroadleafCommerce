package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResourceBundleExtensionPointDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceBundleExtensionPoint#setBasenameExtensions(String[])}
   *   <li>{@link ResourceBundleExtensionPoint#getBasenameExtensions()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] ResourceBundleExtensionPoint.getBasenameExtensions()",
    "void ResourceBundleExtensionPoint.setBasenameExtensions(String[])"
  })
  public void testGettersAndSetters() {
    // Arrange
    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    String[] basenameExtensions = new String[] {"Basename Extensions"};

    // Act
    resourceBundleExtensionPoint.setBasenameExtensions(basenameExtensions);
    String[] actualBasenameExtensions = resourceBundleExtensionPoint.getBasenameExtensions();

    // Assert
    assertSame(basenameExtensions, actualBasenameExtensions);
    assertArrayEquals(new String[] {"Basename Extensions"}, actualBasenameExtensions);
  }

  /**
   * Test new {@link ResourceBundleExtensionPoint} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ResourceBundleExtensionPoint}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleExtensionPoint.<init>()"})
  public void testNewResourceBundleExtensionPoint() {
    // Arrange, Act and Assert
    assertEquals(0, new ResourceBundleExtensionPoint().getBasenameExtensions().length);
  }
}
