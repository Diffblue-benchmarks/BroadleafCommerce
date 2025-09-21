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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.RelatedProduct;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UpSaleProductCustomPersistenceHandlerDiffblueTest {
  @InjectMocks private UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler;

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean UpSaleProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(upSaleProductCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetListPersistenceModule} {@link
   *       AdornedTargetListPersistenceModule#add(PersistencePackage)} return {@link Entity}
   *       (default constructor).
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity UpSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenAdornedTargetListPersistenceModuleAddReturnEntity_thenReturnEntity()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"product.id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", new Entity(), persistencePerspective, customCriteria, "ABC123");
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity entity2 = new Entity();
    when(adornedTargetListPersistenceModule.add(Mockito.<PersistencePackage>any()))
        .thenReturn(entity2);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    Entity actualAddResult =
        upSaleProductCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property).getValue();
    verify(adornedTargetListPersistenceModule).add(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualAddResult);
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity UpSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            upSaleProductCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity UpSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException()).when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            upSaleProductCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity UpSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowValidationException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            upSaleProductCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpSaleProductCustomPersistenceHandler.validateUpSaleProduct(Entity)"})
  public void testValidateUpSaleProduct_givenNull_whenEntityFindPropertyReturnNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateUpSaleProduct(entity);
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpSaleProductCustomPersistenceHandler.validateUpSaleProduct(Entity)"})
  public void testValidateUpSaleProduct_givenPropertyGetValueReturnNull()
      throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateUpSaleProduct(entity);
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpSaleProductCustomPersistenceHandler.validateUpSaleProduct(Entity)"})
  public void testValidateUpSaleProduct_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateUpSaleProduct(entity);
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpSaleProductCustomPersistenceHandler.validateUpSaleProduct(Entity)"})
  public void testValidateUpSaleProduct_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    upSaleProductCustomPersistenceHandler.validateUpSaleProduct(new Entity());
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link UpSaleProductCustomPersistenceHandler#validateSelfLink(Entity,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateSelfLink(Entity, String, String)"
  })
  public void testValidateSelfLink_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    upSaleProductCustomPersistenceHandler.validateSelfLink(
        mock(Entity.class), "validateProductSelfLink", "42");
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateDuplicateChild(Entity, Product,
   * Product)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateDuplicateChild(Entity, Product, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateDuplicateChild(Entity, Product, Product)"
  })
  public void testValidateDuplicateChild_whenProductBundleImpl_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    Entity entity = new Entity();
    ProductBundleImpl relatedProduct = new ProductBundleImpl();

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateDuplicateChild(
        entity, relatedProduct, new ProductBundleImpl());
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity,
   * Product, Product)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ProductImpl#setDefaultSku(Sku)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateRecursiveRelationship(Entity, Product, Product)"
  })
  public void testValidateRecursiveRelationship_givenArrayList_thenCallsSetDefaultSku()
      throws ValidationException {
    // Arrange
    Entity entity = new Entity();

    ProductImpl relatedProduct = mock(ProductImpl.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getUpSaleProducts()).thenReturn(new ArrayList<>());
    doNothing().when(relatedProduct).setDefaultSku(Mockito.<Sku>any());
    relatedProduct.setDefaultSku(new SkuImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    upSaleProductCustomPersistenceHandler.validateRecursiveRelationship(
        entity, relatedProduct, product);

    // Assert
    verify(relatedProduct).setDefaultSku(isA(Sku.class));
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity,
   * Product, Product)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProduct} {@link RelatedProduct#getRelatedProduct()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateRecursiveRelationship(Entity, Product, Product)"
  })
  public void testValidateRecursiveRelationship_givenRelatedProductGetRelatedProductReturnNull()
      throws ValidationException {
    // Arrange
    Entity entity = new Entity();

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(null);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    ProductImpl relatedProduct2 = mock(ProductImpl.class);
    when(relatedProduct2.getName()).thenReturn("Name");
    when(relatedProduct2.getUpSaleProducts()).thenReturn(relatedProductList);
    doNothing().when(relatedProduct2).setDefaultSku(Mockito.<Sku>any());
    relatedProduct2.setDefaultSku(new SkuImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    upSaleProductCustomPersistenceHandler.validateRecursiveRelationship(
        entity, relatedProduct2, product);

    // Assert
    verify(relatedProduct2).setDefaultSku(isA(Sku.class));
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity,
   * Product, Product)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateRecursiveRelationship(Entity, Product, Product)"
  })
  public void testValidateRecursiveRelationship_thenDoesNotThrow() throws ValidationException {
    // Arrange
    Entity entity = new Entity();

    ProductBundleImpl relatedProduct = new ProductBundleImpl();
    relatedProduct.setDefaultSku(new SkuImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateRecursiveRelationship(
        entity, relatedProduct, product);
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProducts(Entity, Product, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateUpSaleProducts(Entity, Product, Long,
   * StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateUpSaleProducts(Entity, Product, Long, StringBuilder)"
  })
  public void testValidateUpSaleProducts_thenDoesNotThrow() throws ValidationException {
    // Arrange
    Entity entity = new Entity();

    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));
    crossSaleProductImpl.setRelatedProduct(null);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);

    Product product = mock(Product.class);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateUpSaleProducts(
        entity, product, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProducts(Entity, Product, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateUpSaleProducts(Entity, Product, Long,
   * StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateUpSaleProducts(Entity, Product, Long, StringBuilder)"
  })
  public void testValidateUpSaleProducts_whenNull_thenDoesNotThrow() throws ValidationException {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateUpSaleProducts(
        entity, null, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProducts(Entity, Product, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#validateUpSaleProducts(Entity, Product, Long,
   * StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.validateUpSaleProducts(Entity, Product, Long, StringBuilder)"
  })
  public void testValidateUpSaleProducts_whenProductBundleImpl_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    Entity entity = new Entity();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    upSaleProductCustomPersistenceHandler.validateUpSaleProducts(
        entity, product, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link UpSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       fooProduct Name ->}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpSaleProductCustomPersistenceHandler.addProductLink(StringBuilder, String)"
  })
  public void testAddProductLink_thenStringBuilderWithFooToStringIsFooProductName() {
    // Arrange
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    upSaleProductCustomPersistenceHandler.addProductLink(productLinks, "Product Name");

    // Assert
    assertEquals("fooProduct Name -> ", productLinks.toString());
  }
}
