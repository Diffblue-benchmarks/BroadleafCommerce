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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.server.service.export.AdminExporter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminExporterRemoteService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminExporterRemoteServiceDiffblueTest {
  @Autowired
  private AdminExporterRemoteService adminExporterRemoteService;

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString() {
    // Arrange, Act and Assert
    assertTrue(adminExporterRemoteService.getExporters("Type").isEmpty());
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
