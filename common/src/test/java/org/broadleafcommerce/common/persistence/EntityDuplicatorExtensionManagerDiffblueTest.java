/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.extension.ExtensionHandler;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class EntityDuplicatorExtensionManagerDiffblueTest {
  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_givenEntityDuplicatorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_thenCallsSetResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    ExtensionResultHolder<Boolean> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Boolean>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult = entityDuplicatorExtensionManager
        .validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(resultHolder).setResult(eq(true));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualValidateDuplicateResult);
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    resultHolder.setResult(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager()));
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate_givenEntityDuplicatorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    resultHolder.setResult(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager()));
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager} (default constructor)
   * addToSandbox {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate_givenEntityDuplicatorExtensionManagerAddToSandboxNull_field() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    resultHolder.setResult(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager()));
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate_thenCallsSetResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<MultiTenantCopyContext>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    resultHolder.setResult(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager()));
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualSetupDuplicateResult = entityDuplicatorExtensionManager
        .setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(MultiTenantCopyContext.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualSetupDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link EntityDuplicatorExtensionHandler}
   * {@link EntityDuplicatorExtensionHandler#addToSandbox(Object)} return
   * {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox_givenEntityDuplicatorExtensionHandlerAddToSandboxReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link EntityDuplicatorExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox_givenEntityDuplicatorExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link EntityDuplicatorExtensionManager} (default
   * constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox_givenEntityDuplicatorExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new EntityDuplicatorExtensionManager()).addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.tearDownDuplicate()).thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualTearDownDuplicateResult = entityDuplicatorExtensionManager.tearDownDuplicate();

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).tearDownDuplicate();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTearDownDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.tearDownDuplicate()).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualTearDownDuplicateResult = entityDuplicatorExtensionManager.tearDownDuplicate();

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).tearDownDuplicate();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTearDownDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate_givenEntityDuplicatorExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualTearDownDuplicateResult = entityDuplicatorExtensionManager.tearDownDuplicate();

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTearDownDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager} (default
   * constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate_givenEntityDuplicatorExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, (new EntityDuplicatorExtensionManager()).tearDownDuplicate());
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getCatalogsForPropagation(Mockito.<MultiTenantCopyContext>any(),
        Mockito.<ExtensionResultHolder<List<MultiTenantCopyContext>>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualCatalogsForPropagation = entityDuplicatorExtensionManager
        .getCatalogsForPropagation(context, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).getCatalogsForPropagation(isA(MultiTenantCopyContext.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualCatalogsForPropagation);
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getCatalogsForPropagation(Mockito.<MultiTenantCopyContext>any(),
        Mockito.<ExtensionResultHolder<List<MultiTenantCopyContext>>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualCatalogsForPropagation = entityDuplicatorExtensionManager
        .getCatalogsForPropagation(context, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).getCatalogsForPropagation(isA(MultiTenantCopyContext.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualCatalogsForPropagation);
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualCatalogsForPropagation = entityDuplicatorExtensionManager
        .getCatalogsForPropagation(context, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualCatalogsForPropagation);
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation_givenEntityDuplicatorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getClonesByCatalogs(Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<MultiTenantCopyContext>any(), Mockito.<ExtensionResultHolder<Map<Long, Map<Long, Long>>>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualClonesByCatalogs = entityDuplicatorExtensionManager
        .getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).getClonesByCatalogs(eq("Table Name"), eq(1L),
        isA(MultiTenantCopyContext.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualClonesByCatalogs);
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getClonesByCatalogs(Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<MultiTenantCopyContext>any(), Mockito.<ExtensionResultHolder<Map<Long, Map<Long, Long>>>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualClonesByCatalogs = entityDuplicatorExtensionManager
        .getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).getClonesByCatalogs(eq("Table Name"), eq(1L),
        isA(MultiTenantCopyContext.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualClonesByCatalogs);
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler = mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualClonesByCatalogs = entityDuplicatorExtensionManager
        .getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualClonesByCatalogs);
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs_givenEntityDuplicatorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new EntityDuplicatorExtensionManager()).isEnabled());
  }
}
