package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.extension.AbstractExtensionHandler;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferCustomServiceExtensionManagerDiffblueTest {
  @Autowired
  private OfferCustomServiceExtensionManager offerCustomServiceExtensionManager;

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(new AbstractOfferCustomServiceExtensionHandler());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(new OfferCustomServiceExtensionManager());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler = mock(
        AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult = offerCustomServiceExtensionManager
        .clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler = mock(
        AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult = offerCustomServiceExtensionManager
        .clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearHiddenQualifiers5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass362 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.extension.OfferCustomServiceExtensionManager offerCustomServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager2 = new OfferCustomServiceExtensionManager();

    // Act
    offerCustomServiceExtensionManager2.clearHiddenQualifiers(new Entity());
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Given {@link OfferCustomServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers_givenOfferCustomServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Given {@link OfferCustomServiceExtensionManager} (default
   * constructor).</li>
   *   <li>When {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers_givenOfferCustomServiceExtensionManager_whenEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new OfferCustomServiceExtensionManager()).clearHiddenQualifiers(mock(Entity.class)));
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Then calls {@link AbstractExtensionHandler#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers_thenCallsGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler = mock(
        AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.getPriority()).thenReturn(1);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    ArrayList<OfferCustomServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(new AbstractOfferCustomServiceExtensionHandler());

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.setHandlers(handlers);
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult = offerCustomServiceExtensionManager
        .clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).getPriority();
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Then calls {@link AbstractExtensionHandler#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers_thenCallsGetPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler = mock(
        AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.getPriority()).thenReturn(1);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    ArrayList<OfferCustomServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(new AbstractOfferCustomServiceExtensionHandler());
    handlers.add(new AbstractOfferCustomServiceExtensionHandler());

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.setHandlers(handlers);
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult = offerCustomServiceExtensionManager
        .clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).getPriority();
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler = mock(
        AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult = offerCustomServiceExtensionManager
        .clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OfferCustomServiceExtensionManager()).isEnabled());
  }
}
