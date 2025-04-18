/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.AdminExporterDTO;
import org.broadleafcommerce.openadmin.server.service.export.AdminExporter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminExporterRemoteService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminExporterRemoteServiceDiffblueTest {
  @Autowired
  private AdminExporterRemoteService adminExporterRemoteService;

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link AdminExporterRemoteService}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString_givenAdminExporterRemoteService_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminExporterRemoteService.getExporters("Type").isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString_thenReturnEmpty() {
    // Arrange
    AdminExporterRemoteService adminExporterRemoteService = new AdminExporterRemoteService();
    adminExporterRemoteService.setExporters(new ArrayList<>());

    // Act and Assert
    assertTrue(adminExporterRemoteService.getExporters("Type").isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString_thenReturnSizeIsOne() {
    // Arrange
    AdminExporter adminExporter = mock(AdminExporter.class);
    when(adminExporter.getFriendlyName()).thenReturn("Friendly Name");
    when(adminExporter.getName()).thenReturn("Name");
    when(adminExporter.getCriteriaFields()).thenReturn(new ArrayList<>());
    when(adminExporter.getType()).thenReturn("Type");

    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(adminExporter);

    AdminExporterRemoteService adminExporterRemoteService = new AdminExporterRemoteService();
    adminExporterRemoteService.setExporters(exporters);

    // Act
    List<AdminExporterDTO> actualExporters = adminExporterRemoteService.getExporters("Type");

    // Assert
    verify(adminExporter).getCriteriaFields();
    verify(adminExporter).getFriendlyName();
    verify(adminExporter).getName();
    verify(adminExporter).getType();
    assertEquals(1, actualExporters.size());
    AdminExporterDTO getResult = actualExporters.get(0);
    assertEquals("Friendly Name", getResult.getFriendlyName());
    assertEquals("Name", getResult.getName());
    assertTrue(getResult.getAdditionalCriteriaProperties().isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString_thenThrowFactoryBeanNotInitializedException() {
    // Arrange
    AdminExporter adminExporter = mock(AdminExporter.class);
    when(adminExporter.getName()).thenThrow(new FactoryBeanNotInitializedException("Type"));
    when(adminExporter.getType()).thenReturn("Type");

    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(adminExporter);

    AdminExporterRemoteService adminExporterRemoteService = new AdminExporterRemoteService();
    adminExporterRemoteService.setExporters(exporters);

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class, () -> adminExporterRemoteService.getExporters("Type"));
    verify(adminExporter).getName();
    verify(adminExporter).getType();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminExporterRemoteService#setExporters(List)}
   *   <li>{@link AdminExporterRemoteService#getExporters()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters()",
      "void AdminExporterRemoteService.setExporters(List)"})
  public void testGettersAndSetters() {
    // Arrange
    AdminExporterRemoteService adminExporterRemoteService = new AdminExporterRemoteService();
    ArrayList<AdminExporter> exporters = new ArrayList<>();

    // Act
    adminExporterRemoteService.setExporters(exporters);
    List<AdminExporter> actualExporters = adminExporterRemoteService.getExporters();

    // Assert
    assertTrue(actualExporters.isEmpty());
    assertSame(exporters, actualExporters);
  }
}
