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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.RelatedProduct;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class UpSaleProductCustomPersistenceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(upSaleProductCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleAddResult = upSaleProductCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.UpSaleProduct");

    // Act
    Boolean actualCanHandleAddResult = upSaleProductCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ValidationException.class, () -> upSaleProductCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ValidationException.class, () -> upSaleProductCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}
   */
  @Test
  public void testValidateUpSaleProduct() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    upSaleProductCustomPersistenceHandler.validateUpSaleProduct(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}
   */
  @Test
  public void testValidateUpSaleProduct2() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("product.id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class, () -> upSaleProductCustomPersistenceHandler.validateUpSaleProduct(entity));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateUpSaleProduct(Entity)}
   */
  @Test
  public void testValidateUpSaleProduct3() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(ValidationException.class, () -> upSaleProductCustomPersistenceHandler.validateUpSaleProduct(entity));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}
   */
  @Test
  public void testValidateSelfLink() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> upSaleProductCustomPersistenceHandler.validateSelfLink(new Entity(), "42", "42"));
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}
   */
  @Test
  public void testValidateSelfLink2() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> upSaleProductCustomPersistenceHandler.validateSelfLink(entity, "42", "42"));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  public void testValidateRecursiveRelationship() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    Product relatedProduct = mock(Product.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getUpSaleProducts()).thenReturn(new ArrayList<>());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    upSaleProductCustomPersistenceHandler.validateRecursiveRelationship(entity, relatedProduct, product);

    // Assert
    verify(relatedProduct).getName();
    verify(relatedProduct).getUpSaleProducts();
    verify(product).getId();
    verify(product).getName();
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  public void testValidateRecursiveRelationship2() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(null);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    Product relatedProduct = mock(Product.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getUpSaleProducts()).thenReturn(relatedProductList);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    upSaleProductCustomPersistenceHandler.validateRecursiveRelationship(entity, relatedProduct, product);

    // Assert
    verify(crossSaleProductImpl).getRelatedProduct();
    verify(relatedProduct).getName();
    verify(relatedProduct).getUpSaleProducts();
    verify(product).getId();
    verify(product).getName();
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  public void testValidateRecursiveRelationship3() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(0L);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getUpSaleProducts()).thenReturn(new ArrayList<>());
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    Product relatedProduct = mock(Product.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getUpSaleProducts()).thenReturn(relatedProductList);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    upSaleProductCustomPersistenceHandler.validateRecursiveRelationship(entity, relatedProduct, product);

    // Assert
    verify(crossSaleProductImpl).getRelatedProduct();
    verify(relatedProduct).getName();
    verify(relatedProduct).getUpSaleProducts();
    verify(productBundleImpl).getId();
    verify(product).getId();
    verify(productBundleImpl).getName();
    verify(product).getName();
    verify(productBundleImpl).getUpSaleProducts();
  }

  /**
   * Method under test:
   * {@link UpSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}
   */
  @Test
  public void testAddProductLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductCustomPersistenceHandler upSaleProductCustomPersistenceHandler = new UpSaleProductCustomPersistenceHandler();
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    upSaleProductCustomPersistenceHandler.addProductLink(productLinks, "Product Name");

    // Assert
    assertEquals("fooProduct Name -> ", productLinks.toString());
  }
}
