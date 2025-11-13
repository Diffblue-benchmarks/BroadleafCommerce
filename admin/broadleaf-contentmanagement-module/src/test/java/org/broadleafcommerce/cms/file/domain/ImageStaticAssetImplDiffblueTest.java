package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ImageStaticAssetImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImageStaticAssetImpl}
   *   <li>{@link ImageStaticAssetImpl#setHeight(Integer)}
   *   <li>{@link ImageStaticAssetImpl#setWidth(Integer)}
   *   <li>{@link ImageStaticAssetImpl#getHeight()}
   *   <li>{@link ImageStaticAssetImpl#getWidth()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImageStaticAssetImpl.<init>()",
    "Integer ImageStaticAssetImpl.getHeight()",
    "Integer ImageStaticAssetImpl.getWidth()",
    "void ImageStaticAssetImpl.setHeight(Integer)",
    "void ImageStaticAssetImpl.setWidth(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ImageStaticAssetImpl actualImageStaticAssetImpl = new ImageStaticAssetImpl();
    actualImageStaticAssetImpl.setHeight(1);
    actualImageStaticAssetImpl.setWidth(1);
    Integer actualHeight = actualImageStaticAssetImpl.getHeight();
    Integer actualWidth = actualImageStaticAssetImpl.getWidth();

    // Assert
    assertNull(actualImageStaticAssetImpl.getFileSize());
    assertNull(actualImageStaticAssetImpl.getId());
    assertNull(actualImageStaticAssetImpl.getFileExtension());
    assertNull(actualImageStaticAssetImpl.getFullUrl());
    assertNull(actualImageStaticAssetImpl.getMimeType());
    assertNull(actualImageStaticAssetImpl.getName());
    assertEquals(1, actualHeight.intValue());
    assertEquals(1, actualWidth.intValue());
    assertTrue(actualImageStaticAssetImpl.getContentMessageValues().isEmpty());
  }
}
