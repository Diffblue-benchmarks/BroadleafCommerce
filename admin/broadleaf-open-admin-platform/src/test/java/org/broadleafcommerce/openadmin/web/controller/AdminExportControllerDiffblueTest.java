/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.server.service.export.AdminExporter;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class AdminExportControllerDiffblueTest {
  /**
   * Test
   * {@link AdminExportController#export(HttpServletRequest, HttpServletResponse, Map)}.
   * <ul>
   *   <li>Given {@link AdminExporter} {@link AdminExporter#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link AdminExporter#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExportController#export(HttpServletRequest, HttpServletResponse, Map)}
   */
  @Test
  public void testExport_givenAdminExporterGetNameReturnName_thenCallsGetName() throws IOException {
    // Arrange
    AdminExporter adminExporter = mock(AdminExporter.class);
    when(adminExporter.getName()).thenReturn("Name");

    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(adminExporter);

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminExportController.export(request, response, new HashMap<>()));
    verify(adminExporter).getName();
  }

  /**
   * Test
   * {@link AdminExportController#export(HttpServletRequest, HttpServletResponse, Map)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExportController#export(HttpServletRequest, HttpServletResponse, Map)}
   */
  @Test
  public void testExport_thenThrowRuntimeException() throws IOException {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(new ArrayList<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminExportController.export(request, response, new HashMap<>()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminExportController}
   *   <li>{@link AdminExportController#setExporters(List)}
   *   <li>{@link AdminExportController#getExporters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminExportController actualAdminExportController = new AdminExportController();
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    actualAdminExportController.setExporters(exporters);
    List<AdminExporter> actualExporters = actualAdminExportController.getExporters();

    // Assert that nothing has changed
    assertTrue(actualExporters.isEmpty());
    assertSame(exporters, actualExporters);
  }
}
