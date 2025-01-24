package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractMetadataProviderDiffblueTest {
  @Autowired
  private AbstractMetadataProvider abstractMetadataProvider;

  /**
   * Test {@link AbstractMetadataProvider#setMetadataOverrides(Map)}.
   * <p>
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetMetadataOverrides() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16404 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractMetadataProvider abstractMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());
  }

  /**
   * Test {@link AbstractMetadataProvider#setMetadataOverrides(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code 42} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  public void testSetMetadataOverrides_given42_whenHashMapComputeIfPresent42AndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    HashMap<Object, Object> metadataOverrides = new HashMap<>();
    metadataOverrides.computeIfPresent("42", mock(BiFunction.class));

    // Act
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(metadataOverrides);

    // Assert
    assertTrue(adornedTargetCollectionFieldMetadataProvider.metadataOverrides.isEmpty());
  }

  /**
   * Test {@link AbstractMetadataProvider#setMetadataOverrides(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMetadataProvider#setMetadataOverrides(Map)}
   */
  @Test
  public void testSetMetadataOverrides_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Assert
    assertTrue(adornedTargetCollectionFieldMetadataProvider.metadataOverrides.isEmpty());
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTargetedOverride() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16381 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractMetadataProvider abstractMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(), "Configuration Key",
        "Dr Jane Doe");
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionFieldMetadataProvider} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_givenAdornedTargetCollectionFieldMetadataProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(),
        "Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(
        adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(new DynamicEntityDaoImpl(), null, null));
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .getTargetedOverride(new DynamicEntityDaoImpl(), null, "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}.
   * <ul>
   *   <li>When {@link DynamicEntityDaoImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMetadataProvider#getTargetedOverride(DynamicEntityDao, String, String)}
   */
  @Test
  public void testGetTargetedOverride_whenDynamicEntityDaoImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionFieldMetadataProvider())
        .getTargetedOverride(mock(DynamicEntityDaoImpl.class), "Configuration Key", "Dr Jane Doe"));
  }
}
