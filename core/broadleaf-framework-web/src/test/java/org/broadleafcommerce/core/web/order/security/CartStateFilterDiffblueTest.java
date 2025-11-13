package org.broadleafcommerce.core.web.order.security;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.order.service.OrderLockManager;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.web.order.security.exception.OrderLockAcquisitionFailureException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {CartStateFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CartStateFilterDiffblueTest {
  @Autowired private CartStateFilter cartStateFilter;

  @MockBean(name = "blCartStateRequestProcessor")
  private CartStateRequestProcessor cartStateRequestProcessor;

  @MockBean(name = "blOrderLockManager")
  private OrderLockManager orderLockManager;

  @MockBean(name = "blOrderService")
  private OrderService orderService;

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    doThrow(new OrderLockAcquisitionFailureException("An error occurred"))
        .when(cartStateRequestProcessor)
        .process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () ->
            cartStateFilter.doFilterInternalUnlessIgnored(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () ->
            cartStateFilter.doFilterInternalUnlessIgnored(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new OrderLockAcquisitionFailureException("An error occurred"))
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () -> cartStateFilter.doFilterInternalUnlessIgnored(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored4() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(false);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cartStateFilter.doFilterInternalUnlessIgnored(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cartStateFilter.doFilterInternalUnlessIgnored(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code not blank}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  public void testRequestRequiresLock_givenArrayListAddNotBlank_thenReturnTrue() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    ArrayList<String> excludedOrderLockRequestPatterns = new ArrayList<>();
    excludedOrderLockRequestPatterns.add("not blank");
    cartStateFilter.setExcludedOrderLockRequestPatterns(excludedOrderLockRequestPatterns);

    MockMultipartHttpServletRequest req =
        new MockMultipartHttpServletRequest(new MockServletContext());
    req.setMethod("post");

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter.requestRequiresLock(req);

    // Assert
    verify(orderLockManager).isActive();
    assertTrue(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code /**}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  public void testRequestRequiresLock_givenArrayListAddSlashAsteriskAsterisk_thenReturnFalse() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    ArrayList<String> excludedOrderLockRequestPatterns = new ArrayList<>();
    excludedOrderLockRequestPatterns.add("/**");
    cartStateFilter.setExcludedOrderLockRequestPatterns(excludedOrderLockRequestPatterns);

    MockMultipartHttpServletRequest req =
        new MockMultipartHttpServletRequest(new MockServletContext());
    req.setMethod("post");

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter.requestRequiresLock(req);

    // Assert
    verify(orderLockManager).isActive();
    assertFalse(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Given Bean Name{blOrderLockManager} {@link OrderLockManager#isActive()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  public void testRequestRequiresLock_givenBeanNameBlOrderLockManagerIsActiveReturnFalse() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(false);

    // Act
    boolean actualRequestRequiresLockResult =
        cartStateFilter.requestRequiresLock(new MockHttpServletRequest());

    // Assert
    verify(orderLockManager).isActive();
    assertFalse(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  public void testRequestRequiresLock_thenThrowOrderLockAcquisitionFailureException() {
    // Arrange
    when(orderLockManager.isActive())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () -> cartStateFilter.requestRequiresLock(new MockHttpServletRequest()));
    verify(orderLockManager).isActive();
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Method is {@code post}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  public void testRequestRequiresLock_whenMockHttpServletRequestMethodIsPost_thenReturnTrue() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    MockHttpServletRequest req = new MockHttpServletRequest();
    req.setMethod("post");

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter.requestRequiresLock(req);

    // Assert
    verify(orderLockManager).isActive();
    assertTrue(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  public void testRequestRequiresLock_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    // Act
    boolean actualRequestRequiresLockResult =
        cartStateFilter.requestRequiresLock(new MockHttpServletRequest());

    // Assert
    verify(orderLockManager).isActive();
    assertFalse(actualRequestRequiresLockResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CartStateFilter#setExcludedOrderLockRequestPatterns(List)}
   *   <li>{@link CartStateFilter#getExcludedOrderLockRequestPatterns()}
   *   <li>{@link CartStateFilter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CartStateFilter.getExcludedOrderLockRequestPatterns()",
    "int CartStateFilter.getOrder()",
    "void CartStateFilter.setExcludedOrderLockRequestPatterns(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CartStateFilter cartStateFilter = new CartStateFilter();
    ArrayList<String> excludedOrderLockRequestPatterns = new ArrayList<>();

    // Act
    cartStateFilter.setExcludedOrderLockRequestPatterns(excludedOrderLockRequestPatterns);
    List<String> actualExcludedOrderLockRequestPatterns =
        cartStateFilter.getExcludedOrderLockRequestPatterns();

    // Assert
    assertEquals(1000000, cartStateFilter.getOrder());
    assertTrue(actualExcludedOrderLockRequestPatterns.isEmpty());
    assertSame(excludedOrderLockRequestPatterns, actualExcludedOrderLockRequestPatterns);
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   *
   * <p>Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.shouldNotFilterErrorDispatch()"})
  public void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(cartStateFilter.shouldNotFilterErrorDispatch());
  }
}
