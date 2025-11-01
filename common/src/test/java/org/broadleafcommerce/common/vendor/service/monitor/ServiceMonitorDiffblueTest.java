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
import org.aspectj.lang.ProceedingJoinPoint;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler;
import org.broadleafcommerce.common.vendor.service.type.ServiceStatusType;
import org.junit.Test;
import org.mockito.Mockito;

public class ServiceMonitorDiffblueTest {
  /**
   * Method under test: {@link ServiceMonitor#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();

    // Act
    serviceMonitor.init();

    // Assert that nothing has changed
    assertTrue(serviceMonitor.statusMap.isEmpty());
  }

  /**
   * Method under test: {@link ServiceMonitor#init()}
   */
  @Test
  public void testInit2() {
    // Arrange
    ServiceMonitor serviceMonitor = new ServiceMonitor();
    serviceMonitor.setDefaultHandler(mock(StatusHandler.class));

    // Act
    serviceMonitor.init();

    // Assert that nothing has changed
    assertTrue(serviceMonitor.statusMap.isEmpty());
  }

  /**
   * Method under test: {@link ServiceMonitor#init()}
   */
  @Test
  public void testInit3() {
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
   * Method under test:
   * {@link ServiceMonitor#checkServiceAOP(ProceedingJoinPoint)}
   */
  @Test
  public void testCheckServiceAOP() throws Throwable {
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
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService() {
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
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService2() {
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
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService3() {
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
   * Method under test:
   * {@link ServiceMonitor#checkService(ServiceStatusDetectable)}
   */
  @Test
  public void testCheckService4() {
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
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange() {
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
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange2() {
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
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange3() {
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
   * Method under test:
   * {@link ServiceMonitor#handleStatusChange(ServiceStatusDetectable, ServiceStatusType)}
   */
  @Test
  public void testHandleStatusChange4() {
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
