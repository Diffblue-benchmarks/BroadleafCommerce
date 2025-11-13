package org.broadleafcommerce.common.security.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CsrfFilterDiffblueTest {
  @InjectMocks private CsrfFilter csrfFilter;

  @Mock private ExploitProtectionService exploitProtectionService;

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            csrfFilter.doFilter(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenArrayListAddNotBlank_whenMockHttpServletRequest()
      throws IOException, ServletException {
    // Arrange
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();
    excludedRequestPatterns.add("not blank");

    CsrfFilter csrfFilter = new CsrfFilter();
    csrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code /**}.
   * </ul>
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenArrayListAddSlashAsteriskAsterisk()
      throws IOException, ServletException {
    // Arrange
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();
    excludedRequestPatterns.add("/**");

    CsrfFilter csrfFilter = new CsrfFilter();
    csrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);

    MockMultipartHttpServletRequest baseRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link CsrfFilter} (default constructor) ExcludedRequestPatterns is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenCsrfFilterExcludedRequestPatternsIsArrayList()
      throws IOException, ServletException {
    // Arrange
    CsrfFilter csrfFilter = new CsrfFilter();
    csrfFilter.setExcludedRequestPatterns(new ArrayList<>());
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link CsrfFilter} (default constructor).
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenCsrfFilter_whenMockHttpServletRequest_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    CsrfFilter csrfFilter = new CsrfFilter();
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException()}.
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       throw {@link ServletException#ServletException()}.
   * </ul>
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenServletException_whenFilterChainDoFilterThrowServletException()
      throws IOException, ServletException {
    // Arrange
    CsrfFilter csrfFilter = new CsrfFilter();
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class, () -> csrfFilter.doFilter(baseRequest, baseResponse, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is four hundred three.
   * </ul>
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_thenMockHttpServletResponseStatusIsFourHundredThree()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new SecurityServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    assertEquals(403, baseResponse.getStatus());
    assertTrue(baseResponse.isCommitted());
  }

  /**
   * Test {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is two hundred.
   * </ul>
   *
   * <p>Method under test: {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_thenMockHttpServletResponseStatusIsTwoHundred()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    assertEquals(200, baseResponse.getStatus());
    assertFalse(baseResponse.isCommitted());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CsrfFilter#setExcludedRequestPatterns(List)}
   *   <li>{@link CsrfFilter#getExcludedRequestPatterns()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CsrfFilter.getExcludedRequestPatterns()",
    "void CsrfFilter.setExcludedRequestPatterns(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CsrfFilter csrfFilter = new CsrfFilter();
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();

    // Act
    csrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);
    List<String> actualExcludedRequestPatterns = csrfFilter.getExcludedRequestPatterns();

    // Assert
    assertTrue(actualExcludedRequestPatterns.isEmpty());
    assertSame(excludedRequestPatterns, actualExcludedRequestPatterns);
  }
}
