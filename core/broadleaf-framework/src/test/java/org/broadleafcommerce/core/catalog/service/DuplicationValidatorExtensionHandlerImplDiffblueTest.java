/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.service;

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
import org.junit.Test;
import org.mockito.Mockito;

public class DuplicationValidatorExtensionHandlerImplDiffblueTest {
  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#getPriority()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new DuplicationValidatorExtensionHandlerImpl()).getPriority());
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#isEnabled()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new DuplicationValidatorExtensionHandlerImpl()).isEnabled());
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code HANDLED_STOP}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_givenFalse_thenReturnHandledStop() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    ExtensionResultHolder<Boolean> resultHolder = mock(ExtensionResultHolder.class);
    when(resultHolder.getResult()).thenReturn(false);
    doNothing().when(resultHolder).setResult(Mockito.<Boolean>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult = duplicationValidatorExtensionHandlerImpl
        .validateDuplicate("Entity", resultHolder);

    // Assert
    verify(resultHolder).getResult();
    verify(resultHolder, atLeast(1)).setResult(eq(true));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_STOP, actualValidateDuplicateResult);
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder}
   * {@link ExtensionResultHolder#getResult()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_whenExtensionResultHolderGetResultReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    ExtensionResultHolder<Boolean> resultHolder = mock(ExtensionResultHolder.class);
    when(resultHolder.getResult()).thenReturn(true);
    doNothing().when(resultHolder).setResult(Mockito.<Boolean>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult = duplicationValidatorExtensionHandlerImpl
        .validateDuplicate("Entity", resultHolder);

    // Assert
    verify(resultHolder).getResult();
    verify(resultHolder, atLeast(1)).setResult(eq(true));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualValidateDuplicateResult);
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_whenExtensionResultHolderResultIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.validateDuplicate("Entity", resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();

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
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.setupDuplicate("Entity", resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate_thenCallsSetResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
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
    ExtensionResultStatusType actualSetupDuplicateResult = duplicationValidatorExtensionHandlerImpl
        .setupDuplicate("Entity", resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(MultiTenantCopyContext.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualSetupDuplicateResult);
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#addToSandbox(Object)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        (new DuplicationValidatorExtensionHandlerImpl()).addToSandbox("Entity"));
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#tearDownDuplicate()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        (new DuplicationValidatorExtensionHandlerImpl()).tearDownDuplicate());
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
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
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
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
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
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
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, duplicationValidatorExtensionHandlerImpl
        .getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
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
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, duplicationValidatorExtensionHandlerImpl
        .getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }
}
