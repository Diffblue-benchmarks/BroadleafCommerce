/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

public class BroadleafRequestProcessorDiffblueTest {
  /**
   * Test {@link BroadleafRequestProcessor#isSandboxIdValid(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  public void testIsSandboxIdValid_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafRequestProcessor()).isSandboxIdValid(""));
  }

  /**
   * Test {@link BroadleafRequestProcessor#isSandboxIdValid(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  public void testIsSandboxIdValid_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafRequestProcessor()).isSandboxIdValid(null));
  }

  /**
   * Test
   * {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link WebRequest}
   * {@link RequestAttributes#getAttribute(String, int)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}
   */
  @Test
  public void testClearBroadleafSessionAttrs_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestProcessor broadleafRequestProcessor = new BroadleafRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    broadleafRequestProcessor.clearBroadleafSessionAttrs(request);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
  }

  /**
   * Test
   * {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link RequestAttributes#removeAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}
   */
  @Test
  public void testClearBroadleafSessionAttrs_givenTrue_thenCallsRemoveAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestProcessor broadleafRequestProcessor = new BroadleafRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).removeAttribute(Mockito.<String>any(), anyInt());

    // Act
    broadleafRequestProcessor.clearBroadleafSessionAttrs(request);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request, atLeast(1)).removeAttribute(Mockito.<String>any(), eq(1));
  }
}
