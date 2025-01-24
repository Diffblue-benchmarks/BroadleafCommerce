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
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CrossSaleProductCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleAdd() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1547 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();

    // Act
    crossSaleProductCustomPersistenceHandler2.canHandleAdd(new PersistencePackage());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleAddResult = crossSaleProductCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.CrossSaleProduct");

    // Act
    Boolean actualCanHandleAddResult = crossSaleProductCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(crossSaleProductCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdd() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1438 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    crossSaleProductCustomPersistenceHandler2.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property(String, String)} with {@code Name} and value is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityFindPropertyReturnPropertyWithNameAndValueIs42() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ValidationException.class, () -> crossSaleProductCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
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
    assertThrows(ValidationException.class, () -> crossSaleProductCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateCrossSaleProduct() throws ValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1572 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();

    // Act
    crossSaleProductCustomPersistenceHandler2.validateCrossSaleProduct(new Entity());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  public void testValidateCrossSaleProduct_givenPropertyGetValueReturn42_thenCallsGetValue()
      throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(entity));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is
   * {@code product.id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  public void testValidateCrossSaleProduct_givenPropertyWithNameIsProductIdAndValueIs42() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("product.id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(entity));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProduct(Entity)}
   */
  @Test
  public void testValidateCrossSaleProduct_givenProperty_whenEntityFindPropertyReturnProperty()
      throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    crossSaleProductCustomPersistenceHandler.validateCrossSaleProduct(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateSelfLink() throws ValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1878 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();

    // Act
    crossSaleProductCustomPersistenceHandler2.validateSelfLink(new Entity(), "42", "42");
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}.
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}
   */
  @Test
  public void testValidateSelfLink_thenCallsAddGlobalValidationError() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateSelfLink(entity, "42", "42"));
    verify(entity).addGlobalValidationError(eq("validateProductSelfLink"));
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateSelfLink(Entity, String, String)}
   */
  @Test
  public void testValidateSelfLink_whenEntity_thenThrowValidationException() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> crossSaleProductCustomPersistenceHandler.validateSelfLink(new Entity(), "42", "42"));
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateDuplicateChild(Entity, Product, Product)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateDuplicateChild(Entity, Product, Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateDuplicateChild() throws ValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1706 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    ProductBundleImpl relatedProduct = new ProductBundleImpl();

    // Act
    crossSaleProductCustomPersistenceHandler2.validateDuplicateChild(entity, relatedProduct, new ProductBundleImpl());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  public void testValidateRecursiveRelationship() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(null);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    Product relatedProduct = mock(Product.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getCrossSaleProducts()).thenReturn(relatedProductList);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    crossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(entity, relatedProduct, product);

    // Assert
    verify(crossSaleProductImpl).getRelatedProduct();
    verify(relatedProduct).getCrossSaleProducts();
    verify(relatedProduct).getName();
    verify(product).getId();
    verify(product).getName();
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateRecursiveRelationship2() throws ValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1792 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    ProductBundleImpl relatedProduct = new ProductBundleImpl();

    // Act
    crossSaleProductCustomPersistenceHandler2.validateRecursiveRelationship(entity, relatedProduct,
        new ProductBundleImpl());
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Product#getCrossSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  public void testValidateRecursiveRelationship_givenArrayList_thenCallsGetCrossSaleProducts()
      throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    Product relatedProduct = mock(Product.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getCrossSaleProducts()).thenReturn(new ArrayList<>());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    crossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(entity, relatedProduct, product);

    // Assert
    verify(relatedProduct).getCrossSaleProducts();
    verify(relatedProduct).getName();
    verify(product).getId();
    verify(product).getName();
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}.
   * <ul>
   *   <li>Then calls {@link ProductImpl#getCrossSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateRecursiveRelationship(Entity, Product, Product)}
   */
  @Test
  public void testValidateRecursiveRelationship_thenCallsGetCrossSaleProducts() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(0L);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getCrossSaleProducts()).thenReturn(new ArrayList<>());
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    Product relatedProduct = mock(Product.class);
    when(relatedProduct.getName()).thenReturn("Name");
    when(relatedProduct.getCrossSaleProducts()).thenReturn(relatedProductList);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getName()).thenReturn("Name");

    // Act
    crossSaleProductCustomPersistenceHandler.validateRecursiveRelationship(entity, relatedProduct, product);

    // Assert
    verify(crossSaleProductImpl).getRelatedProduct();
    verify(relatedProduct).getCrossSaleProducts();
    verify(relatedProduct).getName();
    verify(productBundleImpl).getCrossSaleProducts();
    verify(productBundleImpl).getId();
    verify(product).getId();
    verify(productBundleImpl).getName();
    verify(product).getName();
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product, Long, StringBuilder)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#validateCrossSaleProducts(Entity, Product, Long, StringBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateCrossSaleProducts() throws ValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1594 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();
    Entity entity = new Entity();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    crossSaleProductCustomPersistenceHandler2.validateCrossSaleProducts(entity, product, 1L, new StringBuilder("foo"));
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddProductLink() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1492 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler2 = new CrossSaleProductCustomPersistenceHandler();

    // Act
    crossSaleProductCustomPersistenceHandler2.addProductLink(new StringBuilder("foo"), "Product Name");
  }

  /**
   * Test
   * {@link CrossSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo}
   * toString is {@code fooProduct Name ->}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CrossSaleProductCustomPersistenceHandler#addProductLink(StringBuilder, String)}
   */
  @Test
  public void testAddProductLink_thenStringBuilderWithFooToStringIsFooProductName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductCustomPersistenceHandler crossSaleProductCustomPersistenceHandler = new CrossSaleProductCustomPersistenceHandler();
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    crossSaleProductCustomPersistenceHandler.addProductLink(productLinks, "Product Name");

    // Assert
    assertEquals("fooProduct Name -> ", productLinks.toString());
  }
}
