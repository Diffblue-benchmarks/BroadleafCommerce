package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityDuplicatorExtensionManagerDiffblueTest {
  @Autowired private EntityDuplicatorExtensionManager entityDuplicatorExtensionManager;

  /**
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"
  })
  public void testValidateDuplicate() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"
  })
  public void testValidateDuplicate2() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.validateDuplicate(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult =
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .validateDuplicate(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualValidateDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"
  })
  public void testValidateDuplicate3() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.validateDuplicate(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult =
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .validateDuplicate(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualValidateDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler} {@link
   *       EntityDuplicatorExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"
  })
  public void testValidateDuplicate_givenEntityDuplicatorExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult =
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualValidateDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"
  })
  public void testValidateDuplicate_givenEntityDuplicatorExtensionManager_thenReturnNotHandled() {
    // Arrange
    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"
  })
  public void testValidateDuplicate_thenReturnNotHandled() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"
  })
  public void testSetupDuplicate() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());
    resultHolder.setResult(multiTenantCopyContext);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"
  })
  public void testSetupDuplicate2() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.setupDuplicate(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<MultiTenantCopyContext>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());
    resultHolder.setResult(multiTenantCopyContext);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualSetupDuplicateResult =
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .setupDuplicate(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualSetupDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"
  })
  public void testSetupDuplicate3() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.setupDuplicate(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<MultiTenantCopyContext>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());
    resultHolder.setResult(multiTenantCopyContext);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualSetupDuplicateResult =
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .setupDuplicate(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualSetupDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler} {@link
   *       EntityDuplicatorExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"
  })
  public void testSetupDuplicate_givenEntityDuplicatorExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());
    resultHolder.setResult(multiTenantCopyContext);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualSetupDuplicateResult =
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualSetupDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"
  })
  public void testSetupDuplicate_givenEntityDuplicatorExtensionManager_thenReturnNotHandled() {
    // Arrange
    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());
    resultHolder.setResult(multiTenantCopyContext);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"
  })
  public void testSetupDuplicate_thenReturnNotHandled() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());
    resultHolder.setResult(multiTenantCopyContext);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.setupDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"
  })
  public void testAddToSandbox() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"
  })
  public void testAddToSandbox2() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualAddToSandboxResult =
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler, atLeast(1)).addToSandbox(isA(Object.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddToSandboxResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler} {@link
   *       EntityDuplicatorExtensionHandler#addToSandbox(Object)} return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"
  })
  public void testAddToSandbox_givenEntityDuplicatorExtensionHandlerAddToSandboxReturnHandled() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualAddToSandboxResult =
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler, atLeast(1)).addToSandbox(isA(Object.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddToSandboxResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler} {@link
   *       EntityDuplicatorExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"
  })
  public void testAddToSandbox_givenEntityDuplicatorExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualAddToSandboxResult =
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddToSandboxResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"
  })
  public void testAddToSandbox_givenEntityDuplicatorExtensionManager_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"
  })
  public void testAddToSandbox_givenEntityDuplicatorExtensionManager_whenLock_object() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(DynamicDaoHelperImpl.LOCK_OBJECT));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.tearDownDuplicate()"
  })
  public void testTearDownDuplicate() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.tearDownDuplicate()"
  })
  public void testTearDownDuplicate2() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.tearDownDuplicate())
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualTearDownDuplicateResult =
        entityDuplicatorExtensionManager.tearDownDuplicate();

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).tearDownDuplicate();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTearDownDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.tearDownDuplicate()"
  })
  public void testTearDownDuplicate3() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.tearDownDuplicate())
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualTearDownDuplicateResult =
        entityDuplicatorExtensionManager.tearDownDuplicate();

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler).tearDownDuplicate();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTearDownDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionHandler} {@link
   *       EntityDuplicatorExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.tearDownDuplicate()"
  })
  public void testTearDownDuplicate_givenEntityDuplicatorExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act
    ExtensionResultStatusType actualTearDownDuplicateResult =
        entityDuplicatorExtensionManager.tearDownDuplicate();

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTearDownDuplicateResult);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.tearDownDuplicate()"
  })
  public void testTearDownDuplicate_givenEntityDuplicatorExtensionManager_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.tearDownDuplicate()"
  })
  public void testTearDownDuplicate_thenReturnNotHandled() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetCatalogsForPropagation() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder =
        new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetCatalogsForPropagation2() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getCatalogsForPropagation(
            Mockito.<MultiTenantCopyContext>any(),
            Mockito.<ExtensionResultHolder<List<MultiTenantCopyContext>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder =
        new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualCatalogsForPropagation =
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .getCatalogsForPropagation(
            isA(MultiTenantCopyContext.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualCatalogsForPropagation);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetCatalogsForPropagation3() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getCatalogsForPropagation(
            Mockito.<MultiTenantCopyContext>any(),
            Mockito.<ExtensionResultHolder<List<MultiTenantCopyContext>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder =
        new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualCatalogsForPropagation =
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .getCatalogsForPropagation(
            isA(MultiTenantCopyContext.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualCatalogsForPropagation);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetCatalogsForPropagation4() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder =
        new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualCatalogsForPropagation =
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualCatalogsForPropagation);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetCatalogsForPropagation_givenEntityDuplicatorExtensionManager() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder =
        new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetCatalogsForPropagation_thenReturnNotHandled() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder =
        new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetClonesByCatalogs() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(new EntityDuplicatorExtensionManager());
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getClonesByCatalogs(
            "Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetClonesByCatalogs2() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getClonesByCatalogs(
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<MultiTenantCopyContext>any(),
            Mockito.<ExtensionResultHolder<Map<Long, Map<Long, Long>>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualClonesByCatalogs =
        entityDuplicatorExtensionManager.getClonesByCatalogs(
            "Table Name", 1L, multiTenantCopyContext, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .getClonesByCatalogs(
            eq("Table Name"),
            eq(1L),
            isA(MultiTenantCopyContext.class),
            isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualClonesByCatalogs);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetClonesByCatalogs3() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.addToSandbox(Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(entityDuplicatorExtensionHandler.getClonesByCatalogs(
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<MultiTenantCopyContext>any(),
            Mockito.<ExtensionResultHolder<Map<Long, Map<Long, Long>>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(true);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualClonesByCatalogs =
        entityDuplicatorExtensionManager.getClonesByCatalogs(
            "Table Name", 1L, multiTenantCopyContext, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    verify(entityDuplicatorExtensionHandler).addToSandbox(isA(Object.class));
    verify(entityDuplicatorExtensionHandler)
        .getClonesByCatalogs(
            eq("Table Name"),
            eq(1L),
            isA(MultiTenantCopyContext.class),
            isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualClonesByCatalogs);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetClonesByCatalogs4() {
    // Arrange
    EntityDuplicatorExtensionHandler entityDuplicatorExtensionHandler =
        mock(EntityDuplicatorExtensionHandler.class);
    when(entityDuplicatorExtensionHandler.isEnabled()).thenReturn(false);

    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.registerHandler(entityDuplicatorExtensionHandler);
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualClonesByCatalogs =
        entityDuplicatorExtensionManager.getClonesByCatalogs(
            "Table Name", 1L, multiTenantCopyContext, resultHolder);

    // Assert
    verify(entityDuplicatorExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualClonesByCatalogs);
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetClonesByCatalogs_givenEntityDuplicatorExtensionManager() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getClonesByCatalogs(
            "Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long,
   * MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"
  })
  public void testGetClonesByCatalogs_thenReturnNotHandled() {
    // Arrange
    EntityDuplicatorExtensionManager entityDuplicatorExtensionManager =
        new EntityDuplicatorExtensionManager();
    entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getClonesByCatalogs(
            "Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#isEnabled()}.
   *
   * <p>Method under test: {@link EntityDuplicatorExtensionManager#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDuplicatorExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue(new EntityDuplicatorExtensionManager().isEnabled());
  }
}
