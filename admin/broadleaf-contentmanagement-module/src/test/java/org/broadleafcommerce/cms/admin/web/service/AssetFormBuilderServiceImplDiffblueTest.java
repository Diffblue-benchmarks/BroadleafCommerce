package org.broadleafcommerce.cms.admin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AssetFormBuilderServiceImplDiffblueTest {
  @Autowired
  private AssetFormBuilderServiceImpl assetFormBuilderServiceImpl;

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
   * <p>
   * Method under test:
   * {@link AssetFormBuilderServiceImpl#addImageThumbnailField(ListGrid, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddImageThumbnailField2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3786 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderServiceImpl assetFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AssetFormBuilderServiceImpl assetFormBuilderServiceImpl2 = new AssetFormBuilderServiceImpl();

    // Act
    assetFormBuilderServiceImpl2.addImageThumbnailField(new ListGrid(), "https://example.org/example");
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
