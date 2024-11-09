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
package org.broadleafcommerce.common.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractMultiTenantCopierExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractMultiTenantCopierExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler;

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#transformCopy(MultiTenantCopyContext, Object, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#transformCopy(MultiTenantCopyContext, Object, Object)}
   */
  @Test
  public void testTransformCopy() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.transformCopy(new MultiTenantCopyContext(fromCatalog, toCatalog,
            fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()), BLCFieldUtils.NULL_FIELD,
            BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#transformCopy(MultiTenantCopyContext, Object, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#transformCopy(MultiTenantCopyContext, Object, Object)}
   */
  @Test
  public void testTransformCopy2() {
    // Arrange
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.transformCopy(new MultiTenantCopyContext(fromCatalog, toCatalog,
            fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()), BLCFieldUtils.NULL_FIELD,
            BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#prepareForSave(MultiTenantCopyContext, Object, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#prepareForSave(MultiTenantCopyContext, Object, Object)}
   */
  @Test
  public void testPrepareForSave() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.prepareForSave(new MultiTenantCopyContext(fromCatalog, toCatalog,
            fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()), BLCFieldUtils.NULL_FIELD,
            BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#prepareForSave(MultiTenantCopyContext, Object, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#prepareForSave(MultiTenantCopyContext, Object, Object)}
   */
  @Test
  public void testPrepareForSave2() {
    // Arrange
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.prepareForSave(new MultiTenantCopyContext(fromCatalog, toCatalog,
            fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()), BLCFieldUtils.NULL_FIELD,
            BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#postSave(MultiTenantCopyContext, Object, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#postSave(MultiTenantCopyContext, Object, Object)}
   */
  @Test
  public void testPostSave() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.postSave(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
            toSite, genericEntityService, new MultiTenantCopierExtensionManager()), BLCFieldUtils.NULL_FIELD,
            BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#postSave(MultiTenantCopyContext, Object, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#postSave(MultiTenantCopyContext, Object, Object)}
   */
  @Test
  public void testPostSave2() {
    // Arrange
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.postSave(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
            toSite, genericEntityService, new MultiTenantCopierExtensionManager()), BLCFieldUtils.NULL_FIELD,
            BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#shouldClone(MultiTenantCopyContext, Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#shouldClone(MultiTenantCopyContext, Object, ExtensionResultHolder)}
   */
  @Test
  public void testShouldClone() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Boolean> result = new ExtensionResultHolder<>();
    result.setResult(true);
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.shouldClone(context, BLCFieldUtils.NULL_FIELD, result));
  }

  /**
   * Test
   * {@link AbstractMultiTenantCopierExtensionHandler#shouldClone(MultiTenantCopyContext, Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractMultiTenantCopierExtensionHandler#shouldClone(MultiTenantCopyContext, Object, ExtensionResultHolder)}
   */
  @Test
  public void testShouldClone2() {
    // Arrange
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Boolean> result = new ExtensionResultHolder<>();
    result.setResult(true);
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractMultiTenantCopierExtensionHandler.shouldClone(context, BLCFieldUtils.NULL_FIELD, result));
  }

  /**
   * Test new {@link AbstractMultiTenantCopierExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractMultiTenantCopierExtensionHandler}
   */
  @Test
  public void testNewAbstractMultiTenantCopierExtensionHandler() {
    // Arrange and Act
    AbstractMultiTenantCopierExtensionHandler actualAbstractMultiTenantCopierExtensionHandler = new AbstractMultiTenantCopierExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractMultiTenantCopierExtensionHandler.getPriority());
    assertTrue(actualAbstractMultiTenantCopierExtensionHandler.isEnabled());
  }
}
