package org.broadleafcommerce.openadmin.server.service.artifact.image;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ImageMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImageMetadata}
   *   <li>{@link ImageMetadata#setHeight(int)}
   *   <li>{@link ImageMetadata#setWidth(int)}
   *   <li>{@link ImageMetadata#getHeight()}
   *   <li>{@link ImageMetadata#getWidth()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImageMetadata.<init>()",
    "int ImageMetadata.getHeight()",
    "int ImageMetadata.getWidth()",
    "void ImageMetadata.setHeight(int)",
    "void ImageMetadata.setWidth(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ImageMetadata actualImageMetadata = new ImageMetadata();
    actualImageMetadata.setHeight(1);
    actualImageMetadata.setWidth(1);
    int actualHeight = actualImageMetadata.getHeight();

    // Assert
    assertEquals(1, actualHeight);
    assertEquals(1, actualImageMetadata.getWidth());
  }
}
