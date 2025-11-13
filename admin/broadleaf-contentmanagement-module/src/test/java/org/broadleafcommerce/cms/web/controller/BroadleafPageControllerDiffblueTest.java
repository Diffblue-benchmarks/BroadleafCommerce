package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.template.TemplateOverrideExtensionManager;
import org.broadleafcommerce.common.template.TemplateType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafPageController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafPageControllerDiffblueTest {
  @Autowired private BroadleafPageController broadleafPageController;

  @MockBean(name = "blTemplateOverrideExtensionManager")
  private TemplateOverrideExtensionManager templateOverrideExtensionManager;

  /**
   * Test {@link BroadleafPageController#getTemplateType(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafPageController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType BroadleafPageController.getTemplateType(HttpServletRequest)"})
  public void testGetTemplateType() {
    // Arrange, Act and Assert
    assertSame(
        TemplateType.PAGE, broadleafPageController.getTemplateType(new MockHttpServletRequest()));
  }

  /**
   * Test new {@link BroadleafPageController} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BroadleafPageController}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafPageController.<init>()"})
  public void testNewBroadleafPageController() {
    // Arrange and Act
    BroadleafPageController actualBroadleafPageController = new BroadleafPageController();

    // Assert
    assertNull(actualBroadleafPageController.templateOverrideManager);
    assertNull(actualBroadleafPageController.deepLinkService);
  }
}
