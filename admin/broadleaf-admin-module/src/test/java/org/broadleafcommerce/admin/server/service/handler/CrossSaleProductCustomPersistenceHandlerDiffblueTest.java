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
import org.mockito.Mockito;

public class CrossSaleProductCustomPersistenceHandlerDiffblueTest {
  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link CrossSaleProductCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CrossSaleProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_givenCrossSaleProductCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(crossSaleProductCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetListPersistenceModule} {@link
   *       AdornedTargetListPersistenceModule#add(PersistencePackage)} return {@link Entity}
   *       (default constructor).
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CrossSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenAdornedTargetListPersistenceModuleAddReturnEntity_thenReturnEntity()
      throws ServiceException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

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
        crossSaleProductCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property).getValue();
    verify(adornedTargetListPersistenceModule).add(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(entity2, actualAddResult);
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CrossSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

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
            crossSaleProductCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CrossSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

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
            crossSaleProductCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CrossSaleProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowValidationException() throws ServiceException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

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
            crossSaleProductCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(Entity)"
  })
  public void testValidateCrossSaleProduct_givenPropertyGetValueReturn42_thenCallsGetValue()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(entity));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(Entity)"
  })
  public void testValidateCrossSaleProduct_givenPropertyWithNameAndValueIs42()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(entity));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(Entity)"
  })
  public void testValidateCrossSaleProduct_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    crossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(Entity)"
  })
  public void testValidateCrossSaleProduct_whenEntity_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

    // Act and Assert
    crossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(new Entity());
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateSelfLink(Entity, String, String)"
  })
  public void testValidateSelfLink_thenCallsAddGlobalValidationError() throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateSelfLink(entity, "42", "42"));
    verify(entity).addGlobalValidationError("validateProductSelfLink");
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateSelfLink(Entity, String, String)"
  })
  public void testValidateSelfLink_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    new CrossSaleProductCustomPersistenceHandler()
        .validateSelfLink(mock(Entity.class), "validateProductSelfLink", "42");
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateSelfLink(Entity, String, String)"
  })
  public void testValidateSelfLink_whenEntity_thenThrowValidationException()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateSelfLink(new Entity(), "42", "42"));
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateDuplicateChild(Entity, Product,
   * Product)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateDuplicateChild(Entity, Product, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateDuplicateChild(Entity, Product, Product)"
  })
  public void testValidateDuplicateChild_thenDoesNotThrow() throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    ProductBundleImpl relatedProduct = new ProductBundleImpl();

    // Act and Assert
    crossSaleProductCustomPersistenceHandler.validateDuplicateChild(
        entity, relatedProduct, new ProductBundleImpl());
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity,
   * Product, Product)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ProductImpl#getCrossSaleProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product,
   * Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(Entity, Product, Product)"
  })
  public void testValidateRecursiveRelationship_givenArrayList_thenCallsGetCrossSaleProducts()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();

    ProductImpl relatedProduct = mock(ProductImpl.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getCrossSaleProducts()).thenReturn(new ArrayList<>());
    doNothing().when(relatedProduct).setDefaultSku(Mockito.<Sku>any());
    relatedProduct.setDefaultSku(new SkuImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    crossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(
        entity, relatedProduct, product);

    // Assert
    verify(relatedProduct).getCrossSaleProducts();
    verify(product).getId();
    verify(product).getName();
    verify(relatedProduct).getName();
    verify(relatedProduct).setDefaultSku(isA(Sku.class));
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity,
   * Product, Product)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProduct} {@link RelatedProduct#getRelatedProduct()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product,
   * Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(Entity, Product, Product)"
  })
  public void testValidateRecursiveRelationship_givenRelatedProductGetRelatedProductReturnNull()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(null);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    ProductImpl relatedProduct2 = mock(ProductImpl.class);
    when(relatedProduct2.getName()).thenReturn("Name");
    when(relatedProduct2.getCrossSaleProducts()).thenReturn(relatedProductList);
    doNothing().when(relatedProduct2).setDefaultSku(Mockito.<Sku>any());
    relatedProduct2.setDefaultSku(new SkuImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    crossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(
        entity, relatedProduct2, product);

    // Assert
    verify(relatedProduct2).getCrossSaleProducts();
    verify(product).getId();
    verify(product).getName();
    verify(relatedProduct2).getName();
    verify(relatedProduct2).setDefaultSku(isA(Sku.class));
    verify(relatedProduct).getRelatedProduct();
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity,
   * Product, Product)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductBundleImpl#getCrossSaleProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product,
   * Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(Entity, Product, Product)"
  })
  public void testValidateRecursiveRelationship_thenCallsGetCrossSaleProducts()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(0L);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getCrossSaleProducts()).thenReturn(new ArrayList<>());

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    ProductImpl relatedProduct2 = mock(ProductImpl.class);
    when(relatedProduct2.getName()).thenReturn("Name");
    when(relatedProduct2.getCrossSaleProducts()).thenReturn(relatedProductList);
    doNothing().when(relatedProduct2).setDefaultSku(Mockito.<Sku>any());
    relatedProduct2.setDefaultSku(new SkuImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    crossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(
        entity, relatedProduct2, product);

    // Assert
    verify(productBundleImpl).getCrossSaleProducts();
    verify(relatedProduct2).getCrossSaleProducts();
    verify(productBundleImpl).getId();
    verify(product).getId();
    verify(productBundleImpl).getName();
    verify(product).getName();
    verify(relatedProduct2).getName();
    verify(relatedProduct2).setDefaultSku(isA(Sku.class));
    verify(relatedProduct).getRelatedProduct();
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity,
   * Product, Product)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor) DefaultSku is {@link SkuImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product,
   * Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(Entity, Product, Product)"
  })
  public void testValidateRecursiveRelationship_whenProductBundleImplDefaultSkuIsSkuImpl()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();

    ProductBundleImpl relatedProduct = new ProductBundleImpl();
    relatedProduct.setDefaultSku(new SkuImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    crossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(
        entity, relatedProduct, product);

    // Assert
    verify(product).getId();
    verify(product).getName();
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product,
   * Long, StringBuilder)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getCrossSaleProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product, Long,
   * StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateCrossSaleProducts(Entity, Product, Long, StringBuilder)"
  })
  public void testValidateCrossSaleProducts_thenCallsGetCrossSaleProducts()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
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
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);

    // Act
    crossSaleProductCustomPersistenceHandler.validateCrossSaleProducts(
        entity, product, 1L, new StringBuilder("foo"));

    // Assert
    verify(product).getCrossSaleProducts();
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product,
   * Long, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product, Long,
   * StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateCrossSaleProducts(Entity, Product, Long, StringBuilder)"
  })
  public void testValidateCrossSaleProducts_whenNull_thenDoesNotThrow() throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    crossSaleProductCustomPersistenceHandler.validateCrossSaleProducts(
        entity, null, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product,
   * Long, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product, Long,
   * StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.validateCrossSaleProducts(Entity, Product, Long, StringBuilder)"
  })
  public void testValidateCrossSaleProducts_whenProductBundleImpl_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    crossSaleProductCustomPersistenceHandler.validateCrossSaleProducts(
        entity, product, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link CrossSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       fooProduct Name ->}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CrossSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CrossSaleProductCustomPersistenceHandler.addProductLink(StringBuilder, String)"
  })
  public void testAddProductLink_thenStringBuilderWithFooToStringIsFooProductName() {
    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler =
        new CrossSaleProductCustomPersistenceHandler();
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    crossSaleProductCustomPersistenceHandler.addProductLink(productLinks, "Product Name");

    // Assert
    assertEquals("fooProduct Name -> ", productLinks.toString());
  }
}
