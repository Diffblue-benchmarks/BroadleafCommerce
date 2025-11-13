package org.broadleafcommerce.openadmin.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.springframework.ui.Model;

@ContextConfiguration(classes = {StaleStateController.class, FileUploadExceptionAdvice.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StaleStateControllerDiffblueTest {
  @Autowired private FileUploadExceptionAdvice fileUploadExceptionAdvice;

  @Autowired private StaleStateController staleStateController;

  /**
   * Test {@link StaleStateController#viewConflictPage(Model)}.
   *
   * <p>Method under test: {@link StaleStateController#viewConflictPage(Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String StaleStateController.viewConflictPage(Model)"})
  public void testViewConflictPage() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sc_conflict");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(staleStateController)
        .setControllerAdvice(fileUploadExceptionAdvice)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("customView"))
        .andExpect(view().name("modules/emptyContainer"))
        .andExpect(forwardedUrl("modules/emptyContainer"));
  }
}
