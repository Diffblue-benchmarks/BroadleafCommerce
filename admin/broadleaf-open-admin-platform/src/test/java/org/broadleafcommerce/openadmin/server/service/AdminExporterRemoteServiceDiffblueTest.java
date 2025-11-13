package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.AdminExporterDTO;
import org.broadleafcommerce.openadmin.server.service.export.AdminExporter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminExporterRemoteService.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminExporterRemoteServiceDiffblueTest {
  @Autowired private AdminExporterRemoteService adminExporterRemoteService;

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   *
   * <p>Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString() {
    // Arrange
    AdminExporter adminExporter = mock(AdminExporter.class);
    Class<Object> type = Object.class;
    when(adminExporter.getType()).thenThrow(new NoSuchBeanDefinitionException(type));

    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(adminExporter);
    adminExporterRemoteService.setExporters(exporters);

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class, () -> adminExporterRemoteService.getExporters("Type"));
    verify(adminExporter).getType();
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   *
   * <p>Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString2() {
    // Arrange
    AdminExporter adminExporter = mock(AdminExporter.class);
    Class<Object> type = Object.class;
    when(adminExporter.getName()).thenThrow(new NoSuchBeanDefinitionException(type));
    when(adminExporter.getType()).thenReturn("Type");

    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(adminExporter);
    adminExporterRemoteService.setExporters(exporters);

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class, () -> adminExporterRemoteService.getExporters("Type"));
    verify(adminExporter).getName();
    verify(adminExporter).getType();
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   *
   * <p>Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString3() {
    // Arrange, Act and Assert
    assertTrue(
        adminExporterRemoteService
            .getExporters(
                "org.broadleafcommerce.openadmin.server.service.AdminExporterRemoteService")
            .isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link AdminExporterRemoteService}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString_givenAdminExporterRemoteService_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminExporterRemoteService.getExporters("Type").isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminExporterRemoteService.getExporters(String)"})
  public void testGetExportersWithString_thenReturnEmpty() {
    // Arrange
    adminExporterRemoteService.setExporters(new ArrayList<>());

    // Act and Assert
    assertTrue(adminExporterRemoteService.getExporters("Type").isEmpty());
  }

  /**
   * Test {@link AdminExporterRemoteService#getExporters(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminExporterRemoteService#getExporters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminExporterRemoteService#setExporters(List)}
   *   <li>{@link AdminExporterRemoteService#getExporters()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminExporterRemoteService.getExporters()",
    "void AdminExporterRemoteService.setExporters(List)"
  })
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
