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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate2() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate3() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate4() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate2() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate3() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate4() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new EntityDuplicatorExtensionManager()).addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox3() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox4() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox5() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox6() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, (new EntityDuplicatorExtensionManager()).tearDownDuplicate());
  }

  /**
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager = new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate4() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate5() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate6() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation2() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation3() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation4() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation5() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation6() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation7() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs2() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs3() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs4() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs5() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs6() {
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
   * Method under test:
   * {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs7() {
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
   * Method under test: {@link EntityDuplicatorExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new EntityDuplicatorExtensionManager()).isEnabled());
  }
}
