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
package org.broadleafcommerce.common.vendor.service.monitor.handler;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.vendor.service.monitor.StatusHandler;
import org.broadleafcommerce.common.vendor.service.type.ServiceStatusType;
import org.junit.Test;
import org.mockito.Mockito;

public class CompositeStatusHandlerDiffblueTest {
  /**
   * Test {@link CompositeStatusHandler#handleStatus(String, ServiceStatusType)}.
   * <ul>
   *   <li>Given {@link StatusHandler}
   * {@link StatusHandler#handleStatus(String, ServiceStatusType)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link StatusHandler#handleStatus(String, ServiceStatusType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CompositeStatusHandler#handleStatus(String, ServiceStatusType)}
   */
  @Test
  public void testHandleStatus_givenStatusHandlerHandleStatusDoesNothing_thenCallsHandleStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatusHandler statusHandler = mock(StatusHandler.class);
    doNothing().when(statusHandler).handleStatus(Mockito.<String>any(), Mockito.<ServiceStatusType>any());

    ArrayList<StatusHandler> handlers = new ArrayList<>();
    handlers.add(statusHandler);

    CompositeStatusHandler compositeStatusHandler = new CompositeStatusHandler();
    compositeStatusHandler.setHandlers(handlers);

    // Act
    compositeStatusHandler.handleStatus("Service Name", ServiceStatusType.DOWN);

    // Assert
    verify(statusHandler).handleStatus(eq("Service Name"), isA(ServiceStatusType.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CompositeStatusHandler}
   *   <li>{@link CompositeStatusHandler#setHandlers(List)}
   *   <li>{@link CompositeStatusHandler#getHandlers()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CompositeStatusHandler actualCompositeStatusHandler = new CompositeStatusHandler();
    ArrayList<StatusHandler> handlers = new ArrayList<>();
    actualCompositeStatusHandler.setHandlers(handlers);
    List<StatusHandler> actualHandlers = actualCompositeStatusHandler.getHandlers();

    // Assert that nothing has changed
    assertTrue(actualHandlers.isEmpty());
    assertSame(handlers, actualHandlers);
  }
}
