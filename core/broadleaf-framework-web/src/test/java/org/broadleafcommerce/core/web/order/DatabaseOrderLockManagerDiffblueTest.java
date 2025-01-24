package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class DatabaseOrderLockManagerDiffblueTest {
  @Autowired
  private DatabaseOrderLockManager databaseOrderLockManager;

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order)")
  @Disabled("TODO: Complete this test")
  void testAcquireLock() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7457 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.DatabaseOrderLockManager databaseOrderLockManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    databaseOrderLockManager.acquireLock(new NullOrderImpl());
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); when NullOrderImpl (default constructor); then return NullOrderImpl (default constructor)")
  void testAcquireLock_whenNullOrderImpl_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLock(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); when NullOrderImpl; then return NullOrderImpl")
  void testAcquireLock_whenNullOrderImpl_thenReturnNullOrderImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertSame(order, (new DatabaseOrderLockManager()).acquireLock(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); when 'null'; then return 'null'")
  void testAcquireLock_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DatabaseOrderLockManager()).acquireLock(null));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order)")
  @Disabled("TODO: Complete this test")
  void testAcquireLockIfAvailable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7469 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.DatabaseOrderLockManager databaseOrderLockManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    databaseOrderLockManager.acquireLockIfAvailable(new NullOrderImpl());
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); when NullOrderImpl (default constructor); then return NullOrderImpl (default constructor)")
  void testAcquireLockIfAvailable_whenNullOrderImpl_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLockIfAvailable(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); when NullOrderImpl; then return NullOrderImpl")
  void testAcquireLockIfAvailable_whenNullOrderImpl_thenReturnNullOrderImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertSame(order, (new DatabaseOrderLockManager()).acquireLockIfAvailable(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); when 'null'; then return 'null'")
  void testAcquireLockIfAvailable_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DatabaseOrderLockManager()).acquireLockIfAvailable(null));
  }

  /**
   * Test {@link DatabaseOrderLockManager#releaseLock(Object)}.
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#releaseLock(Object)}
   */
  @Test
  @DisplayName("Test releaseLock(Object)")
  @Disabled("TODO: Complete this test")
  void testReleaseLock() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7483 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.DatabaseOrderLockManager databaseOrderLockManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    databaseOrderLockManager.releaseLock("Lock Object");
  }

  /**
   * Test {@link DatabaseOrderLockManager#getDatabaseLockPollingIntervalMs()}.
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#getDatabaseLockPollingIntervalMs()}
   */
  @Test
  @DisplayName("Test getDatabaseLockPollingIntervalMs()")
  @Disabled("TODO: Complete this test")
  void testGetDatabaseLockPollingIntervalMs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7482 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.DatabaseOrderLockManager databaseOrderLockManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    databaseOrderLockManager.getDatabaseLockPollingIntervalMs();
  }

  /**
   * Test {@link DatabaseOrderLockManager#getDatabaseLockAcquisitionNumRetries()}.
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#getDatabaseLockAcquisitionNumRetries()}
   */
  @Test
  @DisplayName("Test getDatabaseLockAcquisitionNumRetries()")
  @Disabled("TODO: Complete this test")
  void testGetDatabaseLockAcquisitionNumRetries() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7481 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.DatabaseOrderLockManager databaseOrderLockManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    databaseOrderLockManager.getDatabaseLockAcquisitionNumRetries();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DatabaseOrderLockManager}
   *   <li>{@link DatabaseOrderLockManager#isActive()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new DatabaseOrderLockManager()).isActive());
  }
}
