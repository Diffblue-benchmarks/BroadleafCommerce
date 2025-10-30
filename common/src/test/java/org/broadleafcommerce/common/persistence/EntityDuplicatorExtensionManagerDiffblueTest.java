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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"})
  public void testValidateDuplicate_whenLock_object() {
    // Arrange
    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(DynamicDaoHelperImpl.LOCK_OBJECT, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.validateDuplicate(Object, ExtensionResultHolder)"})
  public void testValidateDuplicate_whenNull_field() {
    // Arrange
    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.validateDuplicate(BLCFieldUtils.NULL_FIELD, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"})
  public void testSetupDuplicate_whenLock_object() {
    // Arrange
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
        entityDuplicatorExtensionManager.setupDuplicate(DynamicDaoHelperImpl.LOCK_OBJECT, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.setupDuplicate(Object, ExtensionResultHolder)"})
  public void testSetupDuplicate_whenNull_field() {
    // Arrange
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
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox_whenLock_object() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(DynamicDaoHelperImpl.LOCK_OBJECT));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#addToSandbox(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.addToSandbox(Object)"})
  public void testAddToSandbox_whenNull_field() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.addToSandbox(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}.
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#tearDownDuplicate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType EntityDuplicatorExtensionManager.tearDownDuplicate()"})
  public void testTearDownDuplicate() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityDuplicatorExtensionManager.tearDownDuplicate());
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"})
  public void testGetCatalogsForPropagation() {
    // Arrange
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
   * Test {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)"})
  public void testGetCatalogsForPropagation2() {
    // Arrange
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(null, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityDuplicatorExtensionManager.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code priority}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"})
  public void testGetClonesByCatalogs_whenPriority() {
    // Arrange
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
        entityDuplicatorExtensionManager.getClonesByCatalogs("priority", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code Table Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorExtensionManager#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityDuplicatorExtensionManager.getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)"})
  public void testGetClonesByCatalogs_whenTableName() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityDuplicatorExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new EntityDuplicatorExtensionManager()).isEnabled());
  }
}
