package org.broadleafcommerce.common.web;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.site.domain.ThemeDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafThemeProcessorDiffblueTest {
  @InjectMocks private BroadleafThemeProcessor broadleafThemeProcessor;

  @Mock private BroadleafThemeResolver broadleafThemeResolver;

  /**
   * Test {@link BroadleafThemeProcessor#process(WebRequest)}.
   *
   * <p>Method under test: {@link BroadleafThemeProcessor#process(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafThemeProcessor.process(WebRequest)"})
  public void testProcess() {
    // Arrange
    when(broadleafThemeResolver.resolveTheme(Mockito.<WebRequest>any()))
        .thenReturn(new ThemeDTO(null, "Path"));

    // Act
    broadleafThemeProcessor.process(new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(broadleafThemeResolver).resolveTheme(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafThemeProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafThemeResolver} {@link
   *       BroadleafThemeResolver#resolveTheme(WebRequest)} return {@link ThemeDTO#ThemeDTO(String,
   *       String)} with {@code Name} and {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeProcessor#process(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafThemeProcessor.process(WebRequest)"})
  public void testProcess_givenBroadleafThemeResolverResolveThemeReturnThemeDTOWithNameAndPath() {
    // Arrange
    when(broadleafThemeResolver.resolveTheme(Mockito.<WebRequest>any()))
        .thenReturn(new ThemeDTO("Name", "Path"));

    // Act
    broadleafThemeProcessor.process(new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(broadleafThemeResolver).resolveTheme(isA(WebRequest.class));
  }
}
