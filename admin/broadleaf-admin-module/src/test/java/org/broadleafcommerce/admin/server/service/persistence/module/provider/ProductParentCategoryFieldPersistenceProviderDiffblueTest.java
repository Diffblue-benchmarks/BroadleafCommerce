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
package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.admin.server.service.persistence.module.provider.extension.ProductParentCategoryFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductParentCategoryFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductParentCategoryFieldPersistenceProviderDiffblueTest {
  @Autowired
  private ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;

  @MockBean(name = "blProductParentCategoryFieldPersistenceProviderExtensionManager")
  private ProductParentCategoryFieldPersistenceProviderExtensionManager productParentCategoryFieldPersistenceProviderExtensionManager;

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse ProductParentCategoryFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue_thenReturnNotHandled() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, productParentCategoryFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse ProductParentCategoryFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenReturnNotHandled() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        productParentCategoryFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"})
  public void testCheckDirtyStateWithInstanceCheckValue_whenFortyTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(productParentCategoryFieldPersistenceProvider.checkDirtyState(null, 42L));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"})
  public void testCheckDirtyStateWithInstanceCheckValue_whenProductBundleImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(productParentCategoryFieldPersistenceProvider.checkDirtyState(new ProductBundleImpl(), 42L));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"})
  public void testCheckDirtyStateWithInstanceCheckValue_whenProductBundleImpl_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(productParentCategoryFieldPersistenceProvider.checkDirtyState(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category ProductParentCategoryFieldPersistenceProvider.getDefaultCategory(Product)"})
  public void testGetDefaultCategory_whenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productParentCategoryFieldPersistenceProvider.getDefaultCategory(new ProductBundleImpl()));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ProductParentCategoryFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertFalse(productParentCategoryFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ProductParentCategoryFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_thenReturnFalse() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(productParentCategoryFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link ProductParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ProductParentCategoryFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, (new ProductParentCategoryFieldPersistenceProvider()).getOrder());
  }
}
