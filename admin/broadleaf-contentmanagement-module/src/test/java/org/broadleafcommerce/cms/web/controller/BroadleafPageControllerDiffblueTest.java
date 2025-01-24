package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.template.TemplateOverrideExtensionManager;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.common.web.deeplink.DeepLinkService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafPageController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafPageControllerDiffblueTest {
  @Autowired
  private BroadleafPageController broadleafPageController;

  @MockBean(name = "blPageDeepLinkService")
  private DeepLinkService<PageDTO> deepLinkService;

  @MockBean(name = "blTemplateOverrideExtensionManager")
  private TemplateOverrideExtensionManager templateOverrideExtensionManager;

  /**
   * Test
   * {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link BroadleafPageController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleRequest() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.web.controller.BroadleafPageController.handleRequest(BroadleafPageController.java:60)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    broadleafPageController.handleRequest(null, new MockHttpServletResponse());
  }

  /**
   * Test
   * {@link BroadleafPageController#getExpectedTemplateName(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafPageController#getExpectedTemplateName(HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetExpectedTemplateName_whenMockHttpServletRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.web.controller.BroadleafPageController.getExpectedTemplateName(BroadleafPageController.java:111)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    broadleafPageController.getExpectedTemplateName(new MockHttpServletRequest());
  }

  /**
   * Test {@link BroadleafPageController#getTemplateType(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafPageController#getTemplateType(HttpServletRequest)}
   */
  @Test
  public void testGetTemplateType_whenDefaultMultipartHttpServletRequest() {
    // Arrange and Act
    TemplateType actualTemplateType = broadleafPageController
        .getTemplateType(mock(DefaultMultipartHttpServletRequest.class));

    // Assert
    assertSame(actualTemplateType.PAGE, actualTemplateType);
  }

  /**
   * Test {@link BroadleafPageController#getTemplateType(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafPageController#getTemplateType(HttpServletRequest)}
   */
  @Test
  public void testGetTemplateType_whenMockHttpServletRequest() {
    // Arrange and Act
    TemplateType actualTemplateType = broadleafPageController.getTemplateType(new MockHttpServletRequest());

    // Assert
    assertSame(actualTemplateType.PAGE, actualTemplateType);
  }

  /**
   * Test new {@link BroadleafPageController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafPageController}
   */
  @Test
  public void testNewBroadleafPageController() {
    // Arrange and Act
    BroadleafPageController actualBroadleafPageController = new BroadleafPageController();

    // Assert
    assertNull(actualBroadleafPageController.templateOverrideManager);
    assertNull(actualBroadleafPageController.deepLinkService);
  }
}
