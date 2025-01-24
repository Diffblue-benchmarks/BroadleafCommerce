package org.broadleafcommerce.profile.web.email;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.email.service.EmailTrackingManager;
import org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailClickTrackingFilter.class})
@ExtendWith(SpringExtension.class)
class EmailClickTrackingFilterDiffblueTest {
  @MockBean(name = "blCustomerState")
  private CustomerState customerState;

  @Autowired
  private EmailClickTrackingFilter emailClickTrackingFilter;

  /**
   * Test
   * {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain); when MockHttpServletRequest(); then calls doFilter(ServletRequest, ServletResponse)")
  void testDoFilter_whenMockHttpServletRequest_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    emailClickTrackingFilter.doFilter(request, response, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailClickTrackingFilter}
   *   <li>
   * {@link EmailClickTrackingFilter#setEmailTrackingManager(EmailTrackingManager)}
   *   <li>{@link EmailClickTrackingFilter#destroy()}
   *   <li>{@link EmailClickTrackingFilter#init(FilterConfig)}
   *   <li>{@link EmailClickTrackingFilter#getEmailTrackingManager()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws ServletException {
    // Arrange and Act
    EmailClickTrackingFilter actualEmailClickTrackingFilter = new EmailClickTrackingFilter();
    EmailTrackingManagerImpl emailTrackingManager = new EmailTrackingManagerImpl();
    actualEmailClickTrackingFilter.setEmailTrackingManager(emailTrackingManager);
    actualEmailClickTrackingFilter.destroy();
    actualEmailClickTrackingFilter.init(new MockFilterConfig());
    EmailTrackingManager actualEmailTrackingManager = actualEmailClickTrackingFilter.getEmailTrackingManager();

    // Assert that nothing has changed
    assertTrue(actualEmailTrackingManager instanceof EmailTrackingManagerImpl);
    assertSame(emailTrackingManager, actualEmailTrackingManager);
  }
}
