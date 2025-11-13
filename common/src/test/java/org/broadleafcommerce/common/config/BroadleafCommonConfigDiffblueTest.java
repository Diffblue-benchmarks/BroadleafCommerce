package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class BroadleafCommonConfigDiffblueTest {
  /**
   * Test {@link BroadleafCommonConfig#blJpaVendorAdapter()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCommonConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCommonConfig#blJpaVendorAdapter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JpaVendorAdapter BroadleafCommonConfig.blJpaVendorAdapter()"})
  public void testBlJpaVendorAdapter_givenBroadleafCommonConfig() {
    // Arrange and Act
    JpaVendorAdapter actualBlJpaVendorAdapterResult =
        new BroadleafCommonConfig().blJpaVendorAdapter();
    actualBlJpaVendorAdapterResult.getPersistenceProvider();

    // Assert
    Map<String, ?> jpaPropertyMap = actualBlJpaVendorAdapterResult.getJpaPropertyMap();
    assertEquals(1, jpaPropertyMap.size());
    Object getResult = jpaPropertyMap.get("hibernate.connection.handling_mode");
    assertTrue(getResult instanceof PhysicalConnectionHandlingMode);
    assertTrue(actualBlJpaVendorAdapterResult instanceof HibernateJpaVendorAdapter);
    assertEquals(
        "org.hibernate", actualBlJpaVendorAdapterResult.getPersistenceProviderRootPackage());
    assertEquals(PhysicalConnectionHandlingMode.DELAYED_ACQUISITION_AND_HOLD, getResult);
    Class<Session> expectedEntityManagerInterface = Session.class;
    assertEquals(
        expectedEntityManagerInterface, actualBlJpaVendorAdapterResult.getEntityManagerInterface());
    Class<SessionFactory> expectedEntityManagerFactoryInterface = SessionFactory.class;
    assertEquals(
        expectedEntityManagerFactoryInterface,
        actualBlJpaVendorAdapterResult.getEntityManagerFactoryInterface());
  }
}
