package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
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
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
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
public class ProductParentCategoryFieldPersistenceProviderDiffblueTest {
  @Autowired
  private ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10691 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider2 = new ProductParentCategoryFieldPersistenceProvider();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    productParentCategoryFieldPersistenceProvider2.populateValue(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

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
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10391 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider2 = new ProductParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    productParentCategoryFieldPersistenceProvider2.extractValue(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

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
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    ProductBundleImpl instance = mock(ProductBundleImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult = productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl instance = mock(ProductBundleImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult = productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl instance = mock(ProductBundleImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult = productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl instance = mock(ProductBundleImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult = productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckDirtyStateWithInstanceCheckValue5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10353 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider2 = new ProductParentCategoryFieldPersistenceProvider();

    // Act
    productParentCategoryFieldPersistenceProvider2.checkDirtyState(new ProductBundleImpl(), 42L);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    ProductBundleImpl instance = mock(ProductBundleImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    boolean actualCheckDirtyStateResult = productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.isActive()).thenReturn(true);
    doNothing().when(categoryImpl).setActiveStartDate(Mockito.<Date>any());
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl instance = mock(ProductBundleImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult = productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(categoryImpl).getId();
    verify(categoryImpl).isActive();
    verify(categoryImpl).setActiveStartDate(isA(Date.class));
    verify(categoryProductXrefImpl, atLeast(1)).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductParentCategoryFieldPersistenceProvider()).checkDirtyState(null, 42L));
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.isActive()).thenReturn(true);
    doNothing().when(categoryImpl).setActiveStartDate(Mockito.<Date>any());
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl instance = mock(ProductBundleImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult = productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 1L);

    // Assert
    verify(categoryImpl).getId();
    verify(categoryImpl).isActive();
    verify(categoryImpl).setActiveStartDate(isA(Date.class));
    verify(categoryProductXrefImpl, atLeast(1)).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(instance).getAllParentCategoryXrefs();
    assertFalse(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    // Act and Assert
    assertTrue(productParentCategoryFieldPersistenceProvider.checkDirtyState(new ProductBundleImpl(), 42L));
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenProductBundleImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(
        (new ProductParentCategoryFieldPersistenceProvider()).checkDirtyState(mock(ProductBundleImpl.class), null));
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10658 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider2 = new ProductParentCategoryFieldPersistenceProvider();

    // Act
    productParentCategoryFieldPersistenceProvider2.getDefaultCategory(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl}
   * (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  public void testGetDefaultCategory_givenArrayListAddCategoryProductXrefImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    Category actualDefaultCategory = productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  public void testGetDefaultCategory_givenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    Category actualDefaultCategory = productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <ul>
   *   <li>Then calls {@link CategoryProductXrefImpl#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  public void testGetDefaultCategory_thenCallsGetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(product).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <ul>
   *   <li>Then calls {@link CategoryProductXrefImpl#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  public void testGetDefaultCategory_thenCallsGetCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    Category actualDefaultCategory = productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <ul>
   *   <li>Then calls {@link CategoryProductXrefImpl#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  public void testGetDefaultCategory_thenCallsGetCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    Category actualDefaultCategory = productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  public void testGetDefaultCategory_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();

    // Act and Assert
    assertNull(productParentCategoryFieldPersistenceProvider.getDefaultCategory(new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandlePersistence() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10049 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider2 = new ProductParentCategoryFieldPersistenceProvider();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    productParentCategoryFieldPersistenceProvider2.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

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
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleExtraction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9782 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider2 = new ProductParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    productParentCategoryFieldPersistenceProvider2.canHandleExtraction(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider = new ProductParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

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
   * Method under test:
   * {@link ProductParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, (new ProductParentCategoryFieldPersistenceProvider()).getOrder());
  }
}
