package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
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
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {SecurityBasedIgnoreFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SecurityBasedIgnoreFilterDiffblueTest {
  @Autowired private SecurityBasedIgnoreFilter securityBasedIgnoreFilter;

  /**
   * Test {@link SecurityBasedIgnoreFilter#init(ContextRefreshedEvent)} with {@code event}.
   *
   * <p>Method under test: {@link SecurityBasedIgnoreFilter#init(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityBasedIgnoreFilter.init(ContextRefreshedEvent)"})
  public void testInitWithEvent() throws BeansException {
    // Arrange
    ApplicationContext source = mock(ApplicationContext.class);
    when(source.getBean(Mockito.<String>any())).thenThrow(new FactoryBeanNotInitializedException());

    // Act
    securityBasedIgnoreFilter.init(new ContextRefreshedEvent(source));

    // Assert
    verify(source).getBean("springSecurityFilterChain");
  }

  /**
   * Test {@link SecurityBasedIgnoreFilter#init(ContextRefreshedEvent)} with {@code event}.
   *
   * <ul>
   *   <li>Then calls {@link ContextRefreshedEvent#getSource()}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityBasedIgnoreFilter#init(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityBasedIgnoreFilter.init(ContextRefreshedEvent)"})
  public void testInitWithEvent_thenCallsGetSource() {
    // Arrange
    ContextRefreshedEvent event = mock(ContextRefreshedEvent.class);
    when(event.getSource()).thenThrow(new FactoryBeanNotInitializedException());

    // Act
    securityBasedIgnoreFilter.init(event);

    // Assert
    verify(event).getSource();
  }

  /**
   * Test {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityBasedIgnoreFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_thenThrowFactoryBeanNotInitializedException()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new FactoryBeanNotInitializedException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> securityBasedIgnoreFilter.doFilter(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityBasedIgnoreFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_whenFilterChainDoFilterDoesNothing()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityBasedIgnoreFilter.doFilter(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SecurityBasedIgnoreFilter#getOrder()}.
   *
   * <p>Method under test: {@link SecurityBasedIgnoreFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SecurityBasedIgnoreFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1000500, new SecurityBasedIgnoreFilter().getOrder());
  }
}
