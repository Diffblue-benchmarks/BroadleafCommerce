package org.broadleafcommerce.profile.web.email;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.email.service.EmailTrackingManager;
import org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailClickTrackingFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class EmailClickTrackingFilterDiffblueTest {
  @MockBean(name = "blCustomerState")
  private CustomerState customerState;

  @Autowired private EmailClickTrackingFilter emailClickTrackingFilter;

  /**
   * Test {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailClickTrackingFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_givenIOException_thenThrowIOException() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class, () -> emailClickTrackingFilter.doFilter(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); then calls recordClick(Long, Map, String, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailClickTrackingFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_thenCallsRecordClick() throws IOException, ServletException {
    // Arrange
    EmailTrackingManagerImpl emailTrackingManager = mock(EmailTrackingManagerImpl.class);
    doNothing()
        .when(emailTrackingManager)
        .recordClick(
            Mockito.<Long>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any());

    EmailClickTrackingFilter emailClickTrackingFilter = new EmailClickTrackingFilter();
    emailClickTrackingFilter.setEmailTrackingManager(emailTrackingManager);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("customerId", "email_id");
    request.addParameter("email_id", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    emailClickTrackingFilter.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(emailTrackingManager)
        .recordClick(eq(42L), isA(Map.class), eq("email_id"), isA(Map.class));
  }

  /**
   * Test {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link EmailClickTrackingFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); when MockHttpServletRequest(); then calls doFilter(ServletRequest, ServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailClickTrackingFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_whenMockHttpServletRequest_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    emailClickTrackingFilter.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailClickTrackingFilter}
   *   <li>{@link EmailClickTrackingFilter#setEmailTrackingManager(EmailTrackingManager)}
   *   <li>{@link EmailClickTrackingFilter#destroy()}
   *   <li>{@link EmailClickTrackingFilter#init(FilterConfig)}
   *   <li>{@link EmailClickTrackingFilter#getEmailTrackingManager()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailClickTrackingFilter.<init>()",
    "void EmailClickTrackingFilter.destroy()",
    "EmailTrackingManager EmailClickTrackingFilter.getEmailTrackingManager()",
    "void EmailClickTrackingFilter.init(FilterConfig)",
    "void EmailClickTrackingFilter.setEmailTrackingManager(EmailTrackingManager)"
  })
  void testGettersAndSetters() throws ServletException {
    // Arrange and Act
    EmailClickTrackingFilter actualEmailClickTrackingFilter = new EmailClickTrackingFilter();
    EmailTrackingManagerImpl emailTrackingManager = new EmailTrackingManagerImpl();
    actualEmailClickTrackingFilter.setEmailTrackingManager(emailTrackingManager);
    actualEmailClickTrackingFilter.destroy();
    actualEmailClickTrackingFilter.init(new MockFilterConfig());
    EmailTrackingManager actualEmailTrackingManager =
        actualEmailClickTrackingFilter.getEmailTrackingManager();

    // Assert
    assertTrue(actualEmailTrackingManager instanceof EmailTrackingManagerImpl);
    assertSame(emailTrackingManager, actualEmailTrackingManager);
  }
}
