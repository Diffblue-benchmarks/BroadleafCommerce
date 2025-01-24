package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.common.web.deeplink.DeepLinkService;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafSkuController.class})
@ExtendWith(SpringExtension.class)
class BroadleafSkuControllerDiffblueTest {
  @Autowired
  private BroadleafSkuController broadleafSkuController;

  @MockBean(name = "blSkuDeepLinkService")
  private DeepLinkService<Sku> deepLinkService;

  /**
   * Test
   * {@link BroadleafSkuController#getExpectedTemplateName(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafSkuController#getExpectedTemplateName(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getExpectedTemplateName(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testGetExpectedTemplateName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.catalog.BroadleafSkuController.getExpectedTemplateName(BroadleafSkuController.java:88)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    broadleafSkuController.getExpectedTemplateName(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    TemplateType actualTemplateType = broadleafSkuController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.SKU, actualTemplateType);
  }

  /**
   * Test {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType2() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act
    TemplateType actualTemplateType = broadleafSkuController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.SKU, actualTemplateType);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafSkuController}
   *   <li>{@link BroadleafSkuController#setDefaultSkuView(String)}
   *   <li>{@link BroadleafSkuController#getDefaultSkuView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafSkuController actualBroadleafSkuController = new BroadleafSkuController();
    actualBroadleafSkuController.setDefaultSkuView("Default Sku View");

    // Assert that nothing has changed
    assertEquals("Default Sku View", actualBroadleafSkuController.getDefaultSkuView());
  }
}
