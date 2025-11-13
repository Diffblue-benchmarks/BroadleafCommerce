package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {HomePageBreadcrumbServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class HomePageBreadcrumbServiceExtensionHandlerDiffblueTest {
  @MockBean(name = "blBreadcrumbServiceExtensionManager")
  private BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager;

  @Autowired
  private HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler;

  /**
   * Test {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType HomePageBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED_CONTINUE,
        homePageBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
            "https://example.org/example", params, holder));
    assertSame(breadcrumbDTOList, holder.getResult());
  }

  /**
   * Test {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   *
   * <p>Method under test: {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int HomePageBreadcrumbServiceExtensionHandler.getDefaultPriority()"})
  public void testGetDefaultPriority() {
    // Arrange, Act and Assert
    assertEquals(-1000, homePageBreadcrumbServiceExtensionHandler.getDefaultPriority());
  }
}
