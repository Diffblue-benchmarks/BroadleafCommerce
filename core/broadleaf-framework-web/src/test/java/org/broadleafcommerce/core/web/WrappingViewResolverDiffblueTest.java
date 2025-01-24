package org.broadleafcommerce.core.web;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.View;

class WrappingViewResolverDiffblueTest {
  /**
   * Test {@link WrappingViewResolver#WrappingViewResolver(View)}.
   * <p>
   * Method under test: {@link WrappingViewResolver#WrappingViewResolver(View)}
   */
  @Test
  @DisplayName("Test new WrappingViewResolver(View)")
  void testNewWrappingViewResolver() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     WrappingViewResolver.view

    // Arrange and Act
    new WrappingViewResolver(mock(View.class));
  }

  /**
   * Test {@link WrappingViewResolver#resolveViewName(String, Locale)}.
   * <p>
   * Method under test:
   * {@link WrappingViewResolver#resolveViewName(String, Locale)}
   */
  @Test
  @DisplayName("Test resolveViewName(String, Locale)")
  void testResolveViewName() throws Exception {
    // Arrange
    View view = mock(View.class);
    doNothing().when(view)
        .render(Mockito.<Map<String, Object>>any(), Mockito.<HttpServletRequest>any(),
            Mockito.<HttpServletResponse>any());
    WrappingViewResolver wrappingViewResolver = new WrappingViewResolver(view);

    // Act
    View actualResolveViewNameResult = wrappingViewResolver.resolveViewName("Arg0", Locale.getDefault());
    HashMap<String, Object> model = new HashMap<>();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    actualResolveViewNameResult.render(model, request, response);

    // Assert
    verify(view).render(isA(Map.class), isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertTrue(headerNames.isEmpty());
  }
}
