package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LifecycleAwareJDBCServicesInitiatorDiffblueTest {
  /**
   * Test {@link LifecycleAwareJDBCServicesInitiator#initiateService(Map,
   * ServiceRegistryImplementor)}.
   *
   * <p>Method under test: {@link LifecycleAwareJDBCServicesInitiator#initiateService(Map,
   * ServiceRegistryImplementor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JdbcServices LifecycleAwareJDBCServicesInitiator.initiateService(Map, ServiceRegistryImplementor)"
  })
  public void testInitiateService() {
    // Arrange
    HashMap<Object, Object> configurationValues = new HashMap<>();

    // Act
    JdbcServices actualInitiateServiceResult =
        LifecycleAwareJDBCServicesInitiator.INSTANCE.initiateService(
            configurationValues, new BootstrapServiceRegistryImpl());

    // Assert
    assertTrue(actualInitiateServiceResult instanceof LifecycleAwareJDBCServices);
    assertNull(actualInitiateServiceResult.getDialect());
    assertNull(actualInitiateServiceResult.getExtractedMetaDataSupport());
    assertNull(actualInitiateServiceResult.getJdbcEnvironment());
    assertNull(actualInitiateServiceResult.getResultSetWrapper());
    assertNull(actualInitiateServiceResult.getSqlExceptionHelper());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LifecycleAwareJDBCServicesInitiator}
   *   <li>{@link LifecycleAwareJDBCServicesInitiator#getServiceInitiated()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleAwareJDBCServicesInitiator.<init>()",
    "Class LifecycleAwareJDBCServicesInitiator.getServiceInitiated()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Class<JdbcServices> actualServiceInitiated =
        new LifecycleAwareJDBCServicesInitiator().getServiceInitiated();

    // Assert
    Class<JdbcServices> expectedServiceInitiated = JdbcServices.class;
    assertEquals(expectedServiceInitiated, actualServiceInitiated);
  }
}
