/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
