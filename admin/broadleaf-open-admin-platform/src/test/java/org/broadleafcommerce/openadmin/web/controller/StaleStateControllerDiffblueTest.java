package org.broadleafcommerce.openadmin.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {StaleStateController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StaleStateControllerDiffblueTest {
  @Autowired
  private StaleStateController staleStateController;

  /**
   * Test {@link StaleStateController#viewConflictPage(Model)}.
   * <p>
   * Method under test: {@link StaleStateController#viewConflictPage(Model)}
   */
  @Test
  public void testViewConflictPage() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sc_conflict");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(staleStateController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("customView"))
        .andExpect(MockMvcResultMatchers.view().name("modules/emptyContainer"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("modules/emptyContainer"));
  }
}
