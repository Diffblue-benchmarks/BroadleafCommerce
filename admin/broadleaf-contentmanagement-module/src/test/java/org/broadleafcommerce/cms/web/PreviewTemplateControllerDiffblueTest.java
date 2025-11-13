package org.broadleafcommerce.cms.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.FileUploadExceptionAdvice;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PreviewTemplateController.class, FileUploadExceptionAdvice.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PreviewTemplateControllerDiffblueTest {
  @Autowired private FileUploadExceptionAdvice fileUploadExceptionAdvice;

  @Autowired private PreviewTemplateController previewTemplateController;

  /**
   * Test {@link PreviewTemplateController#displayPreview(HttpServletRequest)}.
   *
   * <p>Method under test: {@link PreviewTemplateController#displayPreview(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String PreviewTemplateController.displayPreview(HttpServletRequest)"
  })
  public void testDisplayPreview() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/preview/**");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(previewTemplateController)
        .setControllerAdvice(fileUploadExceptionAdvice)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(0))
        .andExpect(view().name("templates/**"))
        .andExpect(forwardedUrl("templates/**"));
  }
}
