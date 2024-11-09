/*-
 * #%L
 * BroadleafCommerce Admin Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.Test;
import org.mockito.Mockito;

public class OfferCustomServiceExtensionManagerDiffblueTest {
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
