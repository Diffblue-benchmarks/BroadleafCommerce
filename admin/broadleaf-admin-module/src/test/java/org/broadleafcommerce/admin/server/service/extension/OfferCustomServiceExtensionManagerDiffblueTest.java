/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferCustomServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferCustomServiceExtensionManagerDiffblueTest {
  @Autowired
  private OfferCustomServiceExtensionManager offerCustomServiceExtensionManager;

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"})
  public void testClearHiddenQualifiers() {
    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(new AbstractOfferCustomServiceExtensionHandler());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"})
  public void testClearHiddenQualifiers2() {
    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager = new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(new OfferCustomServiceExtensionManager());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"})
  public void testClearHiddenQualifiers3() {
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
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"})
  public void testClearHiddenQualifiers4() {
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
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"})
  public void testClearHiddenQualifiers5() {
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
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Given {@link OfferCustomServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"})
  public void testClearHiddenQualifiers_givenOfferCustomServiceExtensionManager() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Given {@link OfferCustomServiceExtensionManager}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"})
  public void testClearHiddenQualifiers_givenOfferCustomServiceExtensionManager_whenNull() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, offerCustomServiceExtensionManager.clearHiddenQualifiers(null));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link OfferCustomServiceExtensionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferCustomServiceExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OfferCustomServiceExtensionManager()).isEnabled());
  }
}
