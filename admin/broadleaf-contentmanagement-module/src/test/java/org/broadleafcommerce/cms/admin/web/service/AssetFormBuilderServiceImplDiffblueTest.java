package org.broadleafcommerce.cms.admin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AssetFormBuilderServiceImplDiffblueTest {
  /**
   * Test {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid, String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then {@link ListGrid} (default constructor) HeaderFields is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetFormBuilderServiceImpl.addImageThumbnailField(ListGrid, String)"})
  public void testAddImageThumbnailField_givenHashSet_thenListGridHeaderFieldsIsHashSet() {
    // Arrange
    AssetFormBuilderServiceImpl assetFormBuilderServiceImpl = new AssetFormBuilderServiceImpl();

    ListGrid listGrid = new ListGrid();
    HashSet<Field> headerFields = new HashSet<>();
    listGrid.setHeaderFields(headerFields);

    // Act
    assetFormBuilderServiceImpl.addImageThumbnailField(listGrid, "https://example.org/example");

    // Assert
    assertEquals("Asset_thumbnail", listGrid.getFirstSearchableFieldFriendlyName());
    Set<Field> headerFields2 = listGrid.getHeaderFields();
    assertEquals(1, headerFields2.size());
    assertSame(headerFields, headerFields2);
  }

  /**
   * Test {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid, String)}.
   *
   * <ul>
   *   <li>When {@link ListGrid} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetFormBuilderServiceImpl.addImageThumbnailField(ListGrid, String)"})
  public void testAddImageThumbnailField_whenListGrid() {
    // Arrange
    AssetFormBuilderServiceImpl assetFormBuilderServiceImpl = new AssetFormBuilderServiceImpl();
    ListGrid listGrid = new ListGrid();

    // Act
    assetFormBuilderServiceImpl.addImageThumbnailField(listGrid, "https://example.org/example");

    // Assert
    assertEquals("Asset_thumbnail", listGrid.getFirstSearchableFieldFriendlyName());
    assertEquals(1, listGrid.getHeaderFields().size());
  }
}
