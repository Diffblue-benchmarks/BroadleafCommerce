package org.broadleafcommerce.openadmin.server.service.artifact.image;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ImageMetadataDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImageMetadata}
   *   <li>{@link ImageMetadata#setHeight(int)}
   *   <li>{@link ImageMetadata#setWidth(int)}
   *   <li>{@link ImageMetadata#getHeight()}
   *   <li>{@link ImageMetadata#getWidth()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ImageMetadata actualImageMetadata = new ImageMetadata();
    actualImageMetadata.setHeight(1);
    actualImageMetadata.setWidth(1);
    int actualHeight = actualImageMetadata.getHeight();

    // Assert that nothing has changed
    assertEquals(1, actualHeight);
    assertEquals(1, actualImageMetadata.getWidth());
  }
}
