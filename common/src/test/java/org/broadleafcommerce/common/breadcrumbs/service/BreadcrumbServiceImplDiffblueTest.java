package org.broadleafcommerce.common.breadcrumbs.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BreadcrumbServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BreadcrumbServiceImplDiffblueTest {
  @MockBean(name = "blBreadcrumbServiceExtensionManager")
  private BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager;

  @Autowired private BreadcrumbServiceImpl breadcrumbServiceImpl;

  /**
   * Test {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}.
   *
   * <ul>
   *   <li>Given {@link BreadcrumbServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BreadcrumbServiceImpl.buildBreadcrumbDTOs(String, Map)"})
  public void testBuildBreadcrumbDTOs_givenBreadcrumbServiceImpl() {
    // Arrange
    BreadcrumbServiceImpl breadcrumbServiceImpl = new BreadcrumbServiceImpl();

    // Act and Assert
    assertTrue(
        breadcrumbServiceImpl
            .buildBreadcrumbDTOs("https://example.org/example", new HashMap<>())
            .isEmpty());
  }

  /**
   * Test {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link BreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BreadcrumbServiceImpl.buildBreadcrumbDTOs(String, Map)"})
  public void testBuildBreadcrumbDTOs_thenCallsModifyBreadcrumbList() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.modifyBreadcrumbList(
            Mockito.<String>any(),
            Mockito.<Map<String, String[]>>any(),
            Mockito.<ExtensionResultHolder<List<BreadcrumbDTO>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(breadcrumbServiceExtensionManager.getProxy())
        .thenReturn(breadcrumbServiceExtensionHandler);

    // Act
    List<BreadcrumbDTO> actualBuildBreadcrumbDTOsResult =
        breadcrumbServiceImpl.buildBreadcrumbDTOs("https://example.org/example", new HashMap<>());

    // Assert
    verify(breadcrumbServiceExtensionHandler)
        .modifyBreadcrumbList(
            eq("https://example.org/example"), isA(Map.class), isA(ExtensionResultHolder.class));
    verify(breadcrumbServiceExtensionManager).getProxy();
    assertTrue(actualBuildBreadcrumbDTOsResult.isEmpty());
  }
}
