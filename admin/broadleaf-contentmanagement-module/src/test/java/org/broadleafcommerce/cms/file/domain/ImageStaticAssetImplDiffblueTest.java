/*-
 * #%L
 * BroadleafCommerce CMS Module
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
