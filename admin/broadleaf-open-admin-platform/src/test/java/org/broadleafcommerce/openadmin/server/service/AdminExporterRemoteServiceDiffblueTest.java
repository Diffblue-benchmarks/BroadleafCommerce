package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.AdminExporterDTO;
import org.broadleafcommerce.openadmin.server.service.export.AdminExporter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminExporterRemoteServiceDiffblueTest {
  @Autowired
  private AdminExporterRemoteService adminExporterRemoteService;

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with
   * {@code String}.
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  public void testGetExportersWithString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AdminExporterRemoteService())
        .getExporters("org.broadleafcommerce.openadmin.server.service.AdminExporterRemoteService")
        .isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with
   * {@code String}.
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetExportersWithString2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminExporterRemoteService adminExporterRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminExporterRemoteService()).getExporters("Type");
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with
   * {@code String}.
   * <ul>
   *   <li>Given {@link AdminExporterRemoteService} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  public void testGetExportersWithString_givenAdminExporterRemoteService_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AdminExporterRemoteService()).getExporters("Type").isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with
   * {@code String}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  public void testGetExportersWithString_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminExporterRemoteService adminExporterRemoteService = new AdminExporterRemoteService();
    adminExporterRemoteService.setExporters(new ArrayList<>());

    // Act and Assert
    assertTrue(adminExporterRemoteService.getExporters("Type").isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with
   * {@code String}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  public void testGetExportersWithString_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test {@link AdminExporterRemoteService#getExporters(String)} with
   * {@code String}.
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  public void testGetExportersWithString_thenThrowFactoryBeanNotInitializedException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGettersAndSetters() {
    // Arrange
    AdminExporterRemoteService adminExporterRemoteService = new AdminExporterRemoteService();
    ArrayList<AdminExporter> exporters = new ArrayList<>();

    // Act
    adminExporterRemoteService.setExporters(exporters);
    List<AdminExporter> actualExporters = adminExporterRemoteService.getExporters();

    // Assert that nothing has changed
    assertTrue(actualExporters.isEmpty());
    assertSame(exporters, actualExporters);
  }
}
