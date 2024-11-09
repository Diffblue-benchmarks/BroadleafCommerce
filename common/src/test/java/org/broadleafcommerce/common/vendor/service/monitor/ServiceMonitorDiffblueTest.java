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
package org.broadleafcommerce.common.vendor.service.monitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler;
import org.broadleafcommerce.common.vendor.service.type.ServiceStatusType;
import org.junit.Test;
import org.mockito.Mockito;

public class ServiceMonitorDiffblueTest {
  /**
   * Test {@link ServiceMonitor#init()}.
   * <ul>
   *   <li>Given {@link ServiceMonitor} (default constructor) DefaultHandler is
   * {@link StatusHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceMonitor#init()}
   */
  @Test
  public void testInit_givenServiceMonitorDefaultHandlerIsStatusHandler() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    serviceMonitor.setDefaultHandler(mock(StatusHandler.class));

    // Act
    serviceMonitor.init();

    // Assert that nothing has changed
    assertTrue(serviceMonitor.statusMap.isEmpty());
  }

  /**
   * Test {@link ServiceMonitor#init()}.
   * <ul>
   *   <li>Given {@link ServiceMonitor} (default constructor).</li>
   *   <li>Then {@link ServiceMonitor} (default constructor)
   * {@link ServiceMonitor#statusMap} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceMonitor#init()}
   */
  @Test
  public void testInit_givenServiceMonitor_thenServiceMonitorStatusMapEmpty() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();

    // Act
    serviceMonitor.init();

    // Assert that nothing has changed
    assertTrue(serviceMonitor.statusMap.isEmpty());
  }

  /**
   * Test {@link ServiceMonitor#init()}.
   * <ul>
   *   <li>Then {@link ServiceMonitor} (default constructor)
   * {@link ServiceMonitor#statusMap} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceMonitor#init()}
   */
  @Test
  public void testInit_thenServiceMonitorStatusMapSizeIsOne() {
    // Arrange
    ServiceStatusDetectable serviceStatusDetectable = mock(ServiceStatusDetectable.class);
    when(serviceStatusDetectable.getServiceName()).thenReturn("Service Name");
    when(serviceStatusDetectable.getServiceStatus()).thenReturn(ServiceStatusType.DOWN);
    StatusHandler statusHandler = mock(StatusHandler.class);
    doNothing().when(statusHandler).handleStatus(Mockito.<String>any(), Mockito.<ServiceStatusType>any());

    HashMap<ServiceStatusDetectable, StatusHandler> serviceHandlers = new HashMap<>();
    serviceHandlers.put(serviceStatusDetectable, statusHandler);

    ServiceMonitor serviceMonitor = new ServiceMonitor();
    serviceMonitor.setServiceHandlers(serviceHandlers);

    // Act
    serviceMonitor.init();

    // Assert
    verify(serviceStatusDetectable).getServiceName();
    verify(serviceStatusDetectable).getServiceStatus();
    verify(statusHandler).handleStatus(eq("Service Name"), isA(ServiceStatusType.class));
    assertEquals(1, serviceMonitor.statusMap.size());
  }

  /**
   * Test {@link ServiceMonitor#checkServiceAOP(ProceedingJoinPoint)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link JoinPoint#getThis()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#checkServiceAOP(ProceedingJoinPoint)}
   */
  @Test
  public void testCheckServiceAOP_givenNull_field_thenCallsGetThis() throws Throwable {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    ProceedingJoinPoint call = mock(ProceedingJoinPoint.class);
    when(call.getThis()).thenReturn(BLCFieldUtils.NULL_FIELD);
    when(call.proceed()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    serviceMonitor.checkServiceAOP(call);

    // Assert
    verify(call).getThis();
    verify(call).proceed();
  }

  /**
   * Test {@link ServiceMonitor#checkService(ServiceStatusDetectable)}.
   * <ul>
   *   <li>Given {@link ServiceStatusType#DOWN}.</li>
   *   <li>Then calls {@link ServiceStatusDetectable#getServiceName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService_givenDown_thenCallsGetServiceName() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    ServiceStatusDetectable statusDetectable = mock(ServiceStatusDetectable.class);
    when(statusDetectable.getServiceName()).thenReturn("Service Name");
    when(statusDetectable.getServiceStatus()).thenReturn(ServiceStatusType.DOWN);

    // Act
    serviceMonitor.checkService(statusDetectable);

    // Assert
    verify(statusDetectable).getServiceName();
    verify(statusDetectable).getServiceStatus();
    assertEquals(1, serviceMonitor.statusMap.size());
  }

  /**
   * Test {@link ServiceMonitor#checkService(ServiceStatusDetectable)}.
   * <ul>
   *   <li>Given {@link ServiceStatusType#PAUSED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService_givenPaused() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    ServiceStatusDetectable statusDetectable = mock(ServiceStatusDetectable.class);
    when(statusDetectable.getServiceStatus()).thenReturn(ServiceStatusType.PAUSED);

    // Act
    serviceMonitor.checkService(statusDetectable);

    // Assert
    verify(statusDetectable).getServiceStatus();
    assertEquals(1, serviceMonitor.statusMap.size());
  }

  /**
   * Test {@link ServiceMonitor#checkService(ServiceStatusDetectable)}.
   * <ul>
   *   <li>Given {@link ServiceStatusType#ServiceStatusType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService_givenServiceStatusType() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    ServiceStatusDetectable statusDetectable = mock(ServiceStatusDetectable.class);
    when(statusDetectable.getServiceStatus()).thenReturn(new ServiceStatusType());

    // Act
    serviceMonitor.checkService(statusDetectable);

    // Assert
    verify(statusDetectable).getServiceStatus();
    assertEquals(1, serviceMonitor.statusMap.size());
  }

  /**
   * Test {@link ServiceMonitor#checkService(ServiceStatusDetectable)}.
   * <ul>
   *   <li>Given {@link StatusHandler}
   * {@link StatusHandler#handleStatus(String, ServiceStatusType)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link StatusHandler#handleStatus(String, ServiceStatusType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService_givenStatusHandlerHandleStatusDoesNothing_thenCallsHandleStatus() {
    // Arrange
    StatusHandler defaultHandler = mock(StatusHandler.class);
    doNothing().when(defaultHandler).handleStatus(Mockito.<String>any(), Mockito.<ServiceStatusType>any());

    ServiceMonitor serviceMonitor = new ServiceMonitor();
    serviceMonitor.setDefaultHandler(defaultHandler);
    ServiceStatusDetectable statusDetectable = mock(ServiceStatusDetectable.class);
    when(statusDetectable.getServiceName()).thenReturn("Service Name");
    when(statusDetectable.getServiceStatus()).thenReturn(ServiceStatusType.DOWN);

    // Act
    serviceMonitor.checkService(statusDetectable);

    // Assert
    verify(statusDetectable).getServiceName();
    verify(statusDetectable).getServiceStatus();
    verify(defaultHandler).handleStatus(eq("Service Name"), isA(ServiceStatusType.class));
    assertEquals(1, serviceMonitor.statusMap.size());
  }

  /**
   * Test
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}.
   * <ul>
   *   <li>Given {@link ServiceMonitor} (default constructor).</li>
   *   <li>When {@link ServiceStatusType#DOWN}.</li>
   *   <li>Then calls {@link ServiceStatusDetectable#getServiceName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange_givenServiceMonitor_whenDown_thenCallsGetServiceName() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    ServiceStatusDetectable serviceStatus = mock(ServiceStatusDetectable.class);
    when(serviceStatus.getServiceName()).thenReturn("Service Name");

    // Act
    serviceMonitor.handleStatusChange(serviceStatus, ServiceStatusType.DOWN);

    // Assert
    verify(serviceStatus).getServiceName();
  }

  /**
   * Test
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}.
   * <ul>
   *   <li>Given {@link ServiceMonitor} (default constructor).</li>
   *   <li>When {@link ServiceStatusType#PAUSED}.</li>
   *   <li>Then calls {@link ServiceStatusDetectable#getServiceName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange_givenServiceMonitor_whenPaused_thenCallsGetServiceName() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    ServiceStatusDetectable serviceStatus = mock(ServiceStatusDetectable.class);
    when(serviceStatus.getServiceName()).thenReturn("Service Name");

    // Act
    serviceMonitor.handleStatusChange(serviceStatus, ServiceStatusType.PAUSED);

    // Assert
    verify(serviceStatus).getServiceName();
  }

  /**
   * Test
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}.
   * <ul>
   *   <li>Then calls
   * {@link StatusHandler#handleStatus(String, ServiceStatusType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange_thenCallsHandleStatus() {
    // Arrange
    StatusHandler defaultHandler = mock(StatusHandler.class);
    doNothing().when(defaultHandler).handleStatus(Mockito.<String>any(), Mockito.<ServiceStatusType>any());

    ServiceMonitor serviceMonitor = new ServiceMonitor();
    serviceMonitor.setDefaultHandler(defaultHandler);
    ServiceStatusDetectable serviceStatus = mock(ServiceStatusDetectable.class);
    when(serviceStatus.getServiceName()).thenReturn("Service Name");

    // Act
    serviceMonitor.handleStatusChange(serviceStatus, ServiceStatusType.DOWN);

    // Assert
    verify(serviceStatus).getServiceName();
    verify(defaultHandler).handleStatus(eq("Service Name"), isA(ServiceStatusType.class));
  }

  /**
   * Test
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}.
   * <ul>
   *   <li>When {@link ServiceStatusType#ServiceStatusType()}.</li>
   *   <li>Then calls {@link ServiceStatusDetectable#getServiceName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange_whenServiceStatusType_thenCallsGetServiceName() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    ServiceStatusDetectable serviceStatus = mock(ServiceStatusDetectable.class);
    when(serviceStatus.getServiceName()).thenReturn("Service Name");

    // Act
    serviceMonitor.handleStatusChange(serviceStatus, new ServiceStatusType());

    // Assert
    verify(serviceStatus).getServiceName();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ServiceMonitor#setDefaultHandler(StatusHandler)}
   *   <li>{@link ServiceMonitor#setServiceHandlers(Map)}
   *   <li>{@link ServiceMonitor#getDefaultHandler()}
   *   <li>{@link ServiceMonitor#getServiceHandlers()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    StatusHandler defaultHandler = mock(StatusHandler.class);

    // Act
    serviceMonitor.setDefaultHandler(defaultHandler);
    HashMap<ServiceStatusDetectable, StatusHandler> serviceHandlers = new HashMap<>();
    serviceMonitor.setServiceHandlers(serviceHandlers);
    StatusHandler actualDefaultHandler = serviceMonitor.getDefaultHandler();
    Map<ServiceStatusDetectable, StatusHandler> actualServiceHandlers = serviceMonitor.getServiceHandlers();

    // Assert that nothing has changed
    assertTrue(actualServiceHandlers.isEmpty());
    assertSame(serviceHandlers, actualServiceHandlers);
    assertSame(defaultHandler, actualDefaultHandler);
  }

  /**
   * Test new {@link ServiceMonitor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ServiceMonitor}
   */
  @Test
  public void testNewServiceMonitor() {
    // Arrange and Act
    ServiceMonitor actualServiceMonitor = new ServiceMonitor();

    // Assert
    assertTrue(actualServiceMonitor.getDefaultHandler() instanceof LogStatusHandler);
    assertTrue(actualServiceMonitor.getServiceHandlers().isEmpty());
    assertTrue(actualServiceMonitor.statusMap.isEmpty());
  }
}
