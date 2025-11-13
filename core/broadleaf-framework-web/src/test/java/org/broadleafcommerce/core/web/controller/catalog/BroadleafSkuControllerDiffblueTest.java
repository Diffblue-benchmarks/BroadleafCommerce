package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.template.TemplateType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafSkuController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafSkuControllerDiffblueTest {
  @Autowired private BroadleafSkuController broadleafSkuController;

  /**
   * Test {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType BroadleafSkuController.getTemplateType(HttpServletRequest)"})
  public void testGetTemplateType() {
    // Arrange, Act and Assert
    assertSame(
        TemplateType.SKU, broadleafSkuController.getTemplateType(new MockHttpServletRequest()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafSkuController}
   *   <li>{@link BroadleafSkuController#setDefaultSkuView(String)}
   *   <li>{@link BroadleafSkuController#getDefaultSkuView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafSkuController.<init>()",
    "String BroadleafSkuController.getDefaultSkuView()",
    "void BroadleafSkuController.setDefaultSkuView(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafSkuController actualBroadleafSkuController = new BroadleafSkuController();
    actualBroadleafSkuController.setDefaultSkuView("Default Sku View");

    // Assert
    assertEquals("Default Sku View", actualBroadleafSkuController.getDefaultSkuView());
  }
}
