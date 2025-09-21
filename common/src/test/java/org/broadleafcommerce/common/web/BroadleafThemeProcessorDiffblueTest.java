/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.web;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.site.domain.ThemeDTO;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
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
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafThemeProcessor.process(new ServletWebRequest(request));

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
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafThemeProcessor.process(new ServletWebRequest(request));

    // Assert
    verify(broadleafThemeResolver).resolveTheme(isA(WebRequest.class));
  }
}
