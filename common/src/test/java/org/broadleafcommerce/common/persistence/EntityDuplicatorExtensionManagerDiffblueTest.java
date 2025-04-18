/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionHandler;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityDuplicatorExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityDuplicatorExtensionManagerDiffblueTest {
  @Autowired
  private EntityDuplicatorExtensionManager entityDuplicatorExtensionManager;

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox2() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualAddToSandboxResult = entityDuplicatorExtensionManager
        .addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler, atLeast(1)).addToSandbox(isA(Object.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddToSandboxResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler} {@link EntityDuplicatorExtensionHandler#addToSandbox(Object)} return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox_givenEntityDuplicatorExtensionHandlerAddToSandboxReturnHandled() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualAddToSandboxResult = entityDuplicatorExtensionManager
        .addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler, atLeast(1)).addToSandbox(isA(Object.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddToSandboxResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler} {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox_givenEntityDuplicatorExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualAddToSandboxResult = entityDuplicatorExtensionManager
        .addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddToSandboxResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox_givenEntityDuplicatorExtensionManager_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.</li>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox_givenEntityDuplicatorExtensionManager_whenLock_object() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(DynamicDaoHelperImpl.LOCK_OBJECT));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityDuplicatorExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new EntityDuplicatorExtensionManager()).isEnabled());
  }
}
