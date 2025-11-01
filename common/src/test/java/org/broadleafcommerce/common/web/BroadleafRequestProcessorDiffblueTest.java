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
import org.springframework.web.context.request.WebRequest;

public class BroadleafRequestProcessorDiffblueTest {
  /**
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  public void testIsSandboxIdValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafRequestProcessor()).isSandboxIdValid(null));
    assertFalse((new BroadleafRequestProcessor()).isSandboxIdValid(""));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}
   */
  @Test
  public void testClearBroadleafSessionAttrs() {
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

  /**
   * Method under test:
   * {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}
   */
  @Test
  public void testClearBroadleafSessionAttrs2() {
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
}
