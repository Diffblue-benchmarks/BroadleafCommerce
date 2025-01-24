package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ImageStaticAssetImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImageStaticAssetImpl}
   *   <li>{@link ImageStaticAssetImpl#setHeight(Integer)}
   *   <li>{@link ImageStaticAssetImpl#setWidth(Integer)}
   *   <li>{@link ImageStaticAssetImpl#getHeight()}
   *   <li>{@link ImageStaticAssetImpl#getWidth()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ImageStaticAssetImpl actualImageStaticAssetImpl = new ImageStaticAssetImpl();
    actualImageStaticAssetImpl.setHeight(1);
    actualImageStaticAssetImpl.setWidth(1);
    Integer actualHeight = actualImageStaticAssetImpl.getHeight();
    Integer actualWidth = actualImageStaticAssetImpl.getWidth();

    // Assert that nothing has changed
    assertEquals(1, actualHeight.intValue());
    assertEquals(1, actualWidth.intValue());
    assertTrue(actualImageStaticAssetImpl.getContentMessageValues().isEmpty());
  }
}
