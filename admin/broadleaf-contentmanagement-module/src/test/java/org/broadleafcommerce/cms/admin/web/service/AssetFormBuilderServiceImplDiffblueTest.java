/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Test;

public class AssetFormBuilderServiceImplDiffblueTest {
  /**
   * Test
   * {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid, String)}.
   * <p>
   * Method under test:
   * {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid, String)}
   */
  @Test
  public void testAddImageThumbnailField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetFormBuilderServiceImpl assetFormBuilderServiceImpl = new AssetFormBuilderServiceImpl();
    ListGrid listGrid = new ListGrid();

    // Act
    assetFormBuilderServiceImpl.addImageThumbnailField(listGrid, "https://example.org/example");

    // Assert
    assertEquals("Asset_thumbnail", listGrid.getFirstSearchableFieldFriendlyName());
    assertEquals(1, listGrid.getHeaderFields().size());
  }

  /**
   * Test
   * {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ListGrid#getHeaderFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid, String)}
   */
  @Test
  public void testAddImageThumbnailField_givenArrayList_thenCallsGetHeaderFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetFormBuilderServiceImpl assetFormBuilderServiceImpl = new AssetFormBuilderServiceImpl();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getRecords()).thenReturn(new ArrayList<>());
    when(listGrid.getHeaderFields()).thenReturn(new HashSet<>());

    // Act
    assetFormBuilderServiceImpl.addImageThumbnailField(listGrid, "https://example.org/example");

    // Assert
    verify(listGrid).getHeaderFields();
    verify(listGrid).getRecords();
  }
}
