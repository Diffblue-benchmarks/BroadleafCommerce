package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.server.service.export.AdminExporter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class AdminExportControllerDiffblueTest {
  /**
   * Test {@link AdminExportController#export(HttpServletRequest, HttpServletResponse, Map)}.
   *
   * <ul>
   *   <li>Given {@link AdminExporter} {@link AdminExporter#getName()} return {@code Name}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminExportController#export(HttpServletRequest,
   * HttpServletResponse, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.servlet.ModelAndView AdminExportController.export(HttpServletRequest, HttpServletResponse, Map)"
  })
  public void testExport_givenAdminExporterGetNameReturnName_thenThrowRuntimeException()
      throws IOException {
    // Arrange
    AdminExporter adminExporter = mock(AdminExporter.class);
    when(adminExporter.getName()).thenReturn("Name");

    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(adminExporter);

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    HashMap<String, String> params = new HashMap<>();
    params.put("exporter", "Params");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> adminExportController.export(request, response, params));
    verify(adminExporter).getName();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminExportController}
   *   <li>{@link AdminExportController#setExporters(List)}
   *   <li>{@link AdminExportController#getExporters()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExportController.<init>()",
    "List AdminExportController.getExporters()",
    "void AdminExportController.setExporters(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminExportController actualAdminExportController = new AdminExportController();
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    actualAdminExportController.setExporters(exporters);
    List<AdminExporter> actualExporters = actualAdminExportController.getExporters();

    // Assert
    assertTrue(actualExporters.isEmpty());
    assertSame(exporters, actualExporters);
  }
}
