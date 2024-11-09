/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class SilentErrorHandlerDiffblueTest {
  /**
   * Test {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>When {@link Throwable#Throwable()} initCause
   * {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}
   */
  @Test
  public void testHandleError_givenThrowable_whenThrowableInitCauseThrowable() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SilentErrorHandler silentErrorHandler = new SilentErrorHandler();
    DefaultProcessContextImpl context = new DefaultProcessContextImpl();

    Throwable th = new Throwable();
    th.initCause(new Throwable());

    // Act and Assert
    assertThrows(WorkflowException.class, () -> silentErrorHandler.handleError(context, th));
  }

  /**
   * Test {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link WorkflowException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}
   */
  @Test
  public void testHandleError_whenNull_thenThrowWorkflowException() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SilentErrorHandler silentErrorHandler = new SilentErrorHandler();

    // Act and Assert
    assertThrows(WorkflowException.class, () -> silentErrorHandler.handleError(new DefaultProcessContextImpl(), null));
  }

  /**
   * Test {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then throw {@link WorkflowException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}
   */
  @Test
  public void testHandleError_whenThrowable_thenThrowWorkflowException() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SilentErrorHandler silentErrorHandler = new SilentErrorHandler();
    DefaultProcessContextImpl context = new DefaultProcessContextImpl();

    // Act and Assert
    assertThrows(WorkflowException.class, () -> silentErrorHandler.handleError(context, new Throwable()));
  }
}
