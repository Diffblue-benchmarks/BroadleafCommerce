package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.web.BroadleafWebRequestProcessor;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceThreadManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {BroadleafAdminRequestFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AbstractBroadleafAdminRequestFilterDiffblueTest {
  @Autowired private AbstractBroadleafAdminRequestFilter abstractBroadleafAdminRequestFilter;

  @MockBean(name = "blAdminRequestProcessor")
  private BroadleafWebRequestProcessor broadleafWebRequestProcessor;

  @MockBean(name = "blClassNameRequestParamValidationService")
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @MockBean(name = "blPersistenceThreadManager")
  private PersistenceThreadManager persistenceThreadManager;

  @MockBean(name = "blStaleStateProtectionService")
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#shouldProcessURL(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractBroadleafAdminRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBroadleafAdminRequestFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURL_whenDot_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        abstractBroadleafAdminRequestFilter.shouldProcessURL(new MockHttpServletRequest(), "."));
  }

  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#shouldProcessURL(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractBroadleafAdminRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBroadleafAdminRequestFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURL_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        abstractBroadleafAdminRequestFilter.shouldProcessURL(
            new MockHttpServletRequest(), "https://example.org/example"));
  }

  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}.
   *
   * <p>Method under test: {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AbstractBroadleafAdminRequestFilter.getIgnoreSuffixes()"})
  public void testGetIgnoreSuffixes() {
    // Arrange, Act and Assert
    assertEquals(44, abstractBroadleafAdminRequestFilter.getIgnoreSuffixes().size());
  }
}
