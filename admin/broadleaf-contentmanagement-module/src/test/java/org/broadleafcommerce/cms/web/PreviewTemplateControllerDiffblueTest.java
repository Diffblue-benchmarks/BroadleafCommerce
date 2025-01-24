package org.broadleafcommerce.cms.web;

import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PreviewTemplateController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PreviewTemplateControllerDiffblueTest {
  @Autowired
  private PreviewTemplateController previewTemplateController;

  /**
   * Test {@link PreviewTemplateController#displayPreview(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link PreviewTemplateController#displayPreview(HttpServletRequest)}
   */
  @Test
  public void testDisplayPreview() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/preview/**");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(previewTemplateController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("templates/**"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("templates/**"));
  }
}
