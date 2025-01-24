package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductImplDiffblueTest {
  @Autowired
  private ProductImpl productImpl;

  /**
   * Test {@link ProductImpl#getName()}.
   * <p>
   * Method under test: {@link ProductImpl#getName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7497 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getName();
  }

  /**
   * Test {@link ProductImpl#getName()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getName()}
   */
  @Test
  public void testGetName_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getName());
  }

  /**
   * Test {@link ProductImpl#getName()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getName()}
   */
  @Test
  public void testGetName_givenSkuGetNameReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualName = productImpl.getName();

    // Assert
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Name", actualName);
  }

  /**
   * Test new {@link ProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductImpl}
   */
  @Test
  public void testNewProductImpl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductImpl actualProductImpl = new ProductImpl();

    // Assert
    FieldEntity fieldEntityType = actualProductImpl.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', actualProductImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualProductImpl.getArchived().charValue());
    assertNull(actualProductImpl.getId());
    assertNull(actualProductImpl.getCanonicalUrl());
    assertNull(actualProductImpl.getDisplayTemplate());
    assertNull(actualProductImpl.getGeneratedUrl());
    assertNull(actualProductImpl.getLocation());
    assertNull(actualProductImpl.getManufacturer());
    assertNull(actualProductImpl.getMetaDescription());
    assertNull(actualProductImpl.getMetaTitle());
    assertNull(actualProductImpl.getModel());
    assertNull(actualProductImpl.getPromoMessage());
    assertNull(actualProductImpl.getUrl());
    assertNull(actualProductImpl.url);
    assertNull(actualProductImpl.urlKey);
    assertNull(actualProductImpl.getPrice());
    assertNull(actualProductImpl.getRetailPrice());
    assertNull(actualProductImpl.getRetailPriceInternal());
    assertNull(actualProductImpl.getSalePrice());
    assertNull(actualProductImpl.getSalePriceInternal());
    assertNull(actualProductImpl.getCategory());
    assertNull(actualProductImpl.getDefaultCategory());
    assertNull(actualProductImpl.defaultCategory);
    List<Sku> allSellableSkus = actualProductImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(actualProductImpl.getDefaultSku());
    assertFalse(actualProductImpl.getCanSellWithoutOptions());
    assertFalse(actualProductImpl.getOverrideGeneratedUrl());
    assertFalse(actualProductImpl.hasRetailPrice());
    assertFalse(actualProductImpl.canSellWithoutOptions);
    assertFalse(actualProductImpl.isFeaturedProduct);
    assertFalse(actualProductImpl.overrideGeneratedUrl);
    assertTrue(actualProductImpl.getAdditionalSkus().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategories().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = actualProductImpl.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = actualProductImpl.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(actualProductImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(actualProductImpl.getProductOptionXrefs().isEmpty());
    assertTrue(actualProductImpl.getProductOptions().isEmpty());
    assertTrue(actualProductImpl.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualProductImpl.productAttributes.isEmpty());
    assertTrue(actualProductImpl.productOptions.isEmpty());
    assertTrue(actualProductImpl.skus.isEmpty());
    assertTrue(actualProductImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(actualProductImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap = actualProductImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    assertEquals(allSellableSkus, actualProductImpl.getAllSkus());
    assertSame(crossSaleProducts, actualProductImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductImpl.productOptionMap);
  }

  /**
   * Test new {@link ProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewProductImpl4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new ProductImpl();
  }

  /**
   * Test {@link ProductImpl#setName(String)}.
   * <p>
   * Method under test: {@link ProductImpl#setName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10306 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).setName("Name");
  }

  /**
   * Test {@link ProductImpl#setName(String)}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setName(String)}
   */
  @Test
  public void testSetName_givenProductImplDefaultSkuIsSkuImpl_thenProductImplDefaultSkuSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    productImpl.setName("Name");

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertEquals("Name", productImpl.getMainEntityName());
    assertEquals("Name", productImpl.getName());
    assertEquals("Name", defaultSku.getName());
    assertEquals("Name", ((SkuImpl) defaultSku).name);
    assertEquals("name", productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#setName(String)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) MainEntityName is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setName(String)}
   */
  @Test
  public void testSetName_thenProductImplMainEntityNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());
    doNothing().when(defaultSku).setName(Mockito.<String>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setName("Name");

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(defaultSku).setName(eq("Name"));
    assertNull(productImpl.getMainEntityName());
    assertNull(productImpl.getName());
    assertNull(productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#getDescription()}.
   * <p>
   * Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDescription() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7185 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getDescription();
  }

  /**
   * Test {@link ProductImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getDescription());
  }

  /**
   * Test {@link ProductImpl#getDescription()}.
   * <ul>
   *   <li>Then return {@code The characteristics of someone or something}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  public void testGetDescription_thenReturnTheCharacteristicsOfSomeoneOrSomething() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getDescription()).thenReturn("The characteristics of someone or something");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualDescription = productImpl.getDescription();

    // Assert
    verify(defaultSku).getDescription();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("The characteristics of someone or something", actualDescription);
  }

  /**
   * Test {@link ProductImpl#setDescription(String)}.
   * <p>
   * Method under test: {@link ProductImpl#setDescription(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetDescription() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8709 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).setDescription("The characteristics of someone or something");
  }

  /**
   * Test {@link ProductImpl#setDescription(String)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDescription(String)}
   */
  @Test
  public void testSetDescription_thenProductImplDefaultSkuSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    productImpl.setDescription("The characteristics of someone or something");

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertEquals("The characteristics of someone or something", productImpl.getDescription());
    assertEquals("The characteristics of someone or something", defaultSku.getDescription());
    assertEquals("The characteristics of someone or something", ((SkuImpl) defaultSku).description);
  }

  /**
   * Test {@link ProductImpl#setDescription(String)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Description is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDescription(String)}
   */
  @Test
  public void testSetDescription_thenProductImplDescriptionIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());
    doNothing().when(defaultSku).setDescription(Mockito.<String>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setDescription("The characteristics of someone or something");

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(defaultSku).setDescription(eq("The characteristics of someone or something"));
    assertNull(productImpl.getDescription());
  }

  /**
   * Test {@link ProductImpl#getLongDescription()}.
   * <p>
   * Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLongDescription() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7377 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getLongDescription();
  }

  /**
   * Test {@link ProductImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getLongDescription());
  }

  /**
   * Test {@link ProductImpl#getLongDescription()}.
   * <ul>
   *   <li>Then return {@code Long Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_thenReturnLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getLongDescription()).thenReturn("Long Description");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualLongDescription = productImpl.getLongDescription();

    // Assert
    verify(defaultSku).getLongDescription();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Long Description", actualLongDescription);
  }

  /**
   * Test {@link ProductImpl#setLongDescription(String)}.
   * <p>
   * Method under test: {@link ProductImpl#setLongDescription(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetLongDescription() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9944 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).setLongDescription("Long Description");
  }

  /**
   * Test {@link ProductImpl#setLongDescription(String)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setLongDescription(String)}
   */
  @Test
  public void testSetLongDescription_thenProductImplDefaultSkuSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    productImpl.setLongDescription("Long Description");

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertEquals("Long Description", productImpl.getLongDescription());
    assertEquals("Long Description", defaultSku.getLongDescription());
    assertEquals("Long Description", ((SkuImpl) defaultSku).longDescription);
  }

  /**
   * Test {@link ProductImpl#setLongDescription(String)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) LongDescription is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setLongDescription(String)}
   */
  @Test
  public void testSetLongDescription_thenProductImplLongDescriptionIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());
    doNothing().when(defaultSku).setLongDescription(Mockito.<String>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setLongDescription("Long Description");

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(defaultSku).setLongDescription(eq("Long Description"));
    assertNull(productImpl.getLongDescription());
  }

  /**
   * Test {@link ProductImpl#getActiveStartDate()}.
   * <p>
   * Method under test: {@link ProductImpl#getActiveStartDate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetActiveStartDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6824 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getActiveStartDate();
  }

  /**
   * Test {@link ProductImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getActiveStartDate());
  }

  /**
   * Test {@link ProductImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getActiveStartDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_thenCallsGetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getActiveStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.getActiveStartDate();

    // Assert
    verify(defaultSku).getActiveStartDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#setActiveStartDate(Date)}.
   * <p>
   * Method under test: {@link ProductImpl#setActiveStartDate(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetActiveStartDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8086 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductImpl#setActiveStartDate(Date)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setActiveStartDate(Date)}
   */
  @Test
  public void testSetActiveStartDate_thenProductImplDefaultSkuSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    Date activeStartDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productImpl.setActiveStartDate(activeStartDate);

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertSame(activeStartDate, productImpl.getActiveStartDate());
    assertSame(activeStartDate, defaultSku.getActiveStartDate());
    assertSame(activeStartDate, ((SkuImpl) defaultSku).activeStartDate);
  }

  /**
   * Test {@link ProductImpl#getActiveEndDate()}.
   * <p>
   * Method under test: {@link ProductImpl#getActiveEndDate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetActiveEndDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6800 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getActiveEndDate();
  }

  /**
   * Test {@link ProductImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getActiveEndDate());
  }

  /**
   * Test {@link ProductImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getActiveEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_thenCallsGetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getActiveEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.getActiveEndDate();

    // Assert
    verify(defaultSku).getActiveEndDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#setActiveEndDate(Date)}.
   * <p>
   * Method under test: {@link ProductImpl#setActiveEndDate(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetActiveEndDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8049 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductImpl#setActiveEndDate(Date)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setActiveEndDate(Date)}
   */
  @Test
  public void testSetActiveEndDate_thenProductImplDefaultSkuSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    Date activeEndDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productImpl.setActiveEndDate(activeEndDate);

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertSame(activeEndDate, productImpl.getActiveEndDate());
    assertSame(activeEndDate, defaultSku.getActiveEndDate());
    assertSame(activeEndDate, ((SkuImpl) defaultSku).activeEndDate);
  }

  /**
   * Test {@link ProductImpl#isActive()}.
   * <p>
   * Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getActiveEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(defaultSku.getActiveStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    boolean actualIsActiveResult = productImpl.isActive();

    // Assert
    verify(defaultSku).getActiveEndDate();
    verify(defaultSku).getActiveStartDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link ProductImpl#isActive()}.
   * <p>
   * Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsActive2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7977 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).isActive();
  }

  /**
   * Test {@link ProductImpl#isActive()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  public void testIsActive_givenProductImplDefaultSkuIsSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.isActive());
  }

  /**
   * Test {@link ProductImpl#isActive()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getActiveEndDate()} return
   * {@code null}.</li>
   *   <li>Then calls {@link Sku#getActiveEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  public void testIsActive_givenSkuGetActiveEndDateReturnNull_thenCallsGetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getActiveEndDate()).thenReturn(null);
    when(defaultSku.getActiveStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.isActive();

    // Assert
    verify(defaultSku).getActiveEndDate();
    verify(defaultSku).getActiveStartDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#isFeaturedProduct()}.
   * <p>
   * Method under test: {@link ProductImpl#isFeaturedProduct()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsFeaturedProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8001 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).isFeaturedProduct();
  }

  /**
   * Test {@link ProductImpl#isFeaturedProduct()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) FeaturedProduct is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#isFeaturedProduct()}
   */
  @Test
  public void testIsFeaturedProduct_givenProductImplFeaturedProductIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setFeaturedProduct(true);

    // Act and Assert
    assertTrue(productImpl.isFeaturedProduct());
  }

  /**
   * Test {@link ProductImpl#isFeaturedProduct()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#isFeaturedProduct()}
   */
  @Test
  public void testIsFeaturedProduct_givenProductImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).isFeaturedProduct());
  }

  /**
   * Test {@link ProductImpl#setFeaturedProduct(boolean)}.
   * <p>
   * Method under test: {@link ProductImpl#setFeaturedProduct(boolean)}
   */
  @Test
  public void testSetFeaturedProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setFeaturedProduct(true);

    // Assert
    assertTrue(productImpl.isFeaturedProduct);
  }

  /**
   * Test {@link ProductImpl#setFeaturedProduct(boolean)}.
   * <p>
   * Method under test: {@link ProductImpl#setFeaturedProduct(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetFeaturedProduct2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9338 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).setFeaturedProduct(true);
  }

  /**
   * Test {@link ProductImpl#hasRetailPrice()}.
   * <p>
   * Method under test: {@link ProductImpl#hasRetailPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasRetailPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7953 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).hasRetailPrice();
  }

  /**
   * Test {@link ProductImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenProductImplDefaultSkuIsSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.hasRetailPrice());
  }

  /**
   * Test {@link ProductImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenProductImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).hasRetailPrice());
  }

  /**
   * Test {@link ProductImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenSkuGetRetailPriceReturnMoney_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getRetailPrice()).thenReturn(new Money());
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    boolean actualHasRetailPriceResult = productImpl.hasRetailPrice();

    // Assert
    verify(defaultSku).getRetailPrice();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualHasRetailPriceResult);
  }

  /**
   * Test {@link ProductImpl#getRetailPrice()}.
   * <p>
   * Method under test: {@link ProductImpl#getRetailPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRetailPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7689 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getRetailPrice();
  }

  /**
   * Test {@link ProductImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getRetailPrice());
  }

  /**
   * Test {@link ProductImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getRetailPrice());
  }

  /**
   * Test {@link ProductImpl#getSalePrice()}.
   * <p>
   * Method under test: {@link ProductImpl#getSalePrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSalePrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7737 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getSalePrice();
  }

  /**
   * Test {@link ProductImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getSalePrice());
  }

  /**
   * Test {@link ProductImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getSalePrice());
  }

  /**
   * Test {@link ProductImpl#getRetailPriceInternal()}.
   * <p>
   * Method under test: {@link ProductImpl#getRetailPriceInternal()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRetailPriceInternal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7713 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getRetailPriceInternal();
  }

  /**
   * Test {@link ProductImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getRetailPriceInternal());
  }

  /**
   * Test {@link ProductImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getRetailPriceInternal());
  }

  /**
   * Test {@link ProductImpl#getSalePriceInternal()}.
   * <p>
   * Method under test: {@link ProductImpl#getSalePriceInternal()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSalePriceInternal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7761 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getSalePriceInternal();
  }

  /**
   * Test {@link ProductImpl#getSalePriceInternal()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getSalePriceInternal()}
   */
  @Test
  public void testGetSalePriceInternal_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getSalePriceInternal());
  }

  /**
   * Test {@link ProductImpl#getSalePriceInternal()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getSalePriceInternal()}
   */
  @Test
  public void testGetSalePriceInternal_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getSalePriceInternal());
  }

  /**
   * Test {@link ProductImpl#getPrice()}.
   * <p>
   * Method under test: {@link ProductImpl#getPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7569 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getPrice();
  }

  /**
   * Test {@link ProductImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getPrice());
  }

  /**
   * Test {@link ProductImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getPrice());
  }

  /**
   * Test {@link ProductImpl#isOnSale()}.
   * <p>
   * Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsOnSale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8025 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).isOnSale();
  }

  /**
   * Test {@link ProductImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenProductImplDefaultSkuIsSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.isOnSale());
  }

  /**
   * Test {@link ProductImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#isOnSale()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuIsOnSaleReturnTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.isOnSale()).thenReturn(true);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    boolean actualIsOnSaleResult = productImpl.isOnSale();

    // Assert
    verify(defaultSku).isOnSale();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductImpl#getMargin()}.
   * <p>
   * Method under test: {@link ProductImpl#getMargin()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMargin() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7425 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getMargin();
  }

  /**
   * Test {@link ProductImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getMargin()} return
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenSkuGetMarginReturnMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    Money money = new Money();
    when(defaultSku.getMargin()).thenReturn(money);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Money actualMargin = productImpl.getMargin();

    // Assert
    verify(defaultSku).getMargin();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(money, actualMargin);
  }

  /**
   * Test {@link ProductImpl#getExternalId()}.
   * <p>
   * Method under test: {@link ProductImpl#getExternalId()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetExternalId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7257 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getExternalId();
  }

  /**
   * Test {@link ProductImpl#getExternalId()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getExternalId()}
   */
  @Test
  public void testGetExternalId_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getExternalId());
  }

  /**
   * Test {@link ProductImpl#getExternalId()}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getExternalId()} return
   * {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getExternalId()}
   */
  @Test
  public void testGetExternalId_givenSkuImplGetExternalIdReturn42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getExternalId()).thenReturn("42");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualExternalId = productImpl.getExternalId();

    // Assert
    verify(defaultSku).getExternalId();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("42", actualExternalId);
  }

  /**
   * Test {@link ProductImpl#getCanSellWithoutOptions()}.
   * <p>
   * Method under test: {@link ProductImpl#getCanSellWithoutOptions()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCanSellWithoutOptions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7017 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getCanSellWithoutOptions();
  }

  /**
   * Test {@link ProductImpl#getCanSellWithoutOptions()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) CanSellWithoutOptions is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCanSellWithoutOptions()}
   */
  @Test
  public void testGetCanSellWithoutOptions_givenProductImplCanSellWithoutOptionsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(null);

    // Act and Assert
    assertFalse(productImpl.getCanSellWithoutOptions());
  }

  /**
   * Test {@link ProductImpl#getCanSellWithoutOptions()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCanSellWithoutOptions()}
   */
  @Test
  public void testGetCanSellWithoutOptions_givenProductImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).getCanSellWithoutOptions());
  }

  /**
   * Test {@link ProductImpl#getCanSellWithoutOptions()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCanSellWithoutOptions()}
   */
  @Test
  public void testGetCanSellWithoutOptions_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);

    // Act and Assert
    assertTrue(productImpl.getCanSellWithoutOptions());
  }

  /**
   * Test {@link ProductImpl#setDefaultSku(Sku)}.
   * <p>
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetDefaultSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8356 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setDefaultSku(new SkuImpl());
  }

  /**
   * Test {@link ProductImpl#setDefaultSku(Sku)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Description is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku_thenProductImplDescriptionIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    // Act
    productImpl.setDefaultSku(defaultSku);

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(productImpl.getDescription());
    assertNull(productImpl.getExternalId());
    assertNull(productImpl.getLongDescription());
    assertNull(productImpl.getMainEntityName());
    assertNull(productImpl.getName());
    assertNull(productImpl.getTaxCode());
    assertNull(productImpl.getUrlKey());
    assertNull(productImpl.getActiveEndDate());
    assertNull(productImpl.getActiveStartDate());
    assertNull(productImpl.getMargin());
    assertNull(productImpl.getDimension());
    assertNull(productImpl.getWeight());
    List<Sku> allSellableSkus = productImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertFalse(productImpl.isOnSale());
    assertTrue(productImpl.getAllSkuMedia().isEmpty());
    assertTrue(productImpl.getMedia().isEmpty());
    assertSame(defaultSku, allSellableSkus.get(0));
    assertSame(defaultSku, productImpl.getDefaultSku());
  }

  /**
   * Test {@link ProductImpl#setDefaultSku(Sku)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor)
   * {@link ProductImpl#productOptions} is {@link ProductImpl} (default
   * constructor) {@link ProductImpl#productAttributes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku_thenProductImplProductOptionsIsProductImplProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();

    // Act
    productImpl.setDefaultSku(defaultSku);

    // Assert
    assertEquals(productImpl.productAttributes, productImpl.productOptions);
    assertSame(productImpl, defaultSku.getDefaultProduct());
    assertSame(productImpl, defaultSku.getProduct());
  }

  /**
   * Test {@link ProductImpl#setDefaultSku(Sku)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = mock(SkuImpl.class);
    doThrow(new UnsupportedOperationException("foo")).when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setDefaultSku(defaultSku));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#setDefaultSku(Sku)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ProductImpl} (default constructor) AllSellableSkus first is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku_whenNull_thenProductImplAllSellableSkusFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setDefaultSku(null);

    // Assert
    List<Sku> allSellableSkus = productImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(productImpl.getDefaultSku());
    assertTrue(productImpl.productOptions.isEmpty());
    assertTrue(productImpl.skus.isEmpty());
  }

  /**
   * Test {@link ProductImpl#getAllSkus()}.
   * <p>
   * Method under test: {@link ProductImpl#getAllSkus()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllSkus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6944 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getAllSkus();
  }

  /**
   * Test {@link ProductImpl#getAllSkus(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link ProductImpl#getAllSkus(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllSkusWithBoolean() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6968 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getAllSkus(true);
  }

  /**
   * Test {@link ProductImpl#getAllSkus(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSkus(boolean)}
   */
  @Test
  public void testGetAllSkusWithBoolean_givenProductImpl_whenFalse_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getAllSkus(false).isEmpty());
  }

  /**
   * Test {@link ProductImpl#getAllSkus(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSkus(boolean)}
   */
  @Test
  public void testGetAllSkusWithBoolean_givenProductImpl_whenTrue_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Sku> actualAllSkus = (new ProductImpl()).getAllSkus(true);

    // Assert
    assertEquals(1, actualAllSkus.size());
    assertNull(actualAllSkus.get(0));
  }

  /**
   * Test {@link ProductImpl#getAllSkus(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#setDefaultProduct(Product)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSkus(boolean)}
   */
  @Test
  public void testGetAllSkusWithBoolean_thenCallsSetDefaultProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    List<Sku> actualAllSkus = productImpl.getAllSkus(true);

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(1, actualAllSkus.size());
  }

  /**
   * Test {@link ProductImpl#getAllSkus()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSkus()}
   */
  @Test
  public void testGetAllSkus_givenProductImpl_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Sku> actualAllSkus = (new ProductImpl()).getAllSkus();

    // Assert
    assertEquals(1, actualAllSkus.size());
    assertNull(actualAllSkus.get(0));
  }

  /**
   * Test {@link ProductImpl#getAllSkus()}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#setDefaultProduct(Product)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSkus()}
   */
  @Test
  public void testGetAllSkus_thenCallsSetDefaultProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    List<Sku> actualAllSkus = productImpl.getAllSkus();

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(1, actualAllSkus.size());
  }

  /**
   * Test {@link ProductImpl#getSkus()}.
   * <p>
   * Method under test: {@link ProductImpl#getSkus()}
   */
  @Test
  public void testGetSkus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getSkus().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getSkus()}.
   * <p>
   * Method under test: {@link ProductImpl#getSkus()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSkus2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7809 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getSkus();
  }

  /**
   * Test {@link ProductImpl#getAllSellableSkus()}.
   * <p>
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllSellableSkus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6896 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getAllSellableSkus();
  }

  /**
   * Test {@link ProductImpl#getAllSellableSkus()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) CanSellWithoutOptions is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus_givenProductImplCanSellWithoutOptionsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(null);

    // Act
    List<Sku> actualAllSellableSkus = productImpl.getAllSellableSkus();

    // Assert
    assertEquals(1, actualAllSellableSkus.size());
    assertNull(actualAllSellableSkus.get(0));
  }

  /**
   * Test {@link ProductImpl#getAllSellableSkus()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) CanSellWithoutOptions is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus_givenProductImplCanSellWithoutOptionsIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);

    // Act
    List<Sku> actualAllSellableSkus = productImpl.getAllSellableSkus();

    // Assert
    assertEquals(1, actualAllSellableSkus.size());
    assertNull(actualAllSellableSkus.get(0));
  }

  /**
   * Test {@link ProductImpl#getAllSellableSkus()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus_givenProductImpl_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Sku> actualAllSellableSkus = (new ProductImpl()).getAllSellableSkus();

    // Assert
    assertEquals(1, actualAllSellableSkus.size());
    assertNull(actualAllSellableSkus.get(0));
  }

  /**
   * Test {@link ProductImpl#getAllSellableSkus()}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#setDefaultProduct(Product)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus_thenCallsSetDefaultProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    List<Sku> actualAllSellableSkus = productImpl.getAllSellableSkus();

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(1, actualAllSellableSkus.size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductImpl#setCanSellWithoutOptions(Boolean)}
   *   <li>{@link ProductImpl#setCanonicalUrl(String)}
   *   <li>{@link ProductImpl#setDefaultCategory(Category)}
   *   <li>{@link ProductImpl#setDisplayTemplate(String)}
   *   <li>{@link ProductImpl#setId(Long)}
   *   <li>{@link ProductImpl#setManufacturer(String)}
   *   <li>{@link ProductImpl#setMetaDescription(String)}
   *   <li>{@link ProductImpl#setMetaTitle(String)}
   *   <li>{@link ProductImpl#setModel(String)}
   *   <li>{@link ProductImpl#setProductOptionXrefs(List)}
   *   <li>{@link ProductImpl#setPromoMessage(String)}
   *   <li>{@link ProductImpl#setUrl(String)}
   *   <li>{@link ProductImpl#setUrlKey(String)}
   *   <li>{@link ProductImpl#getAdditionalSkus()}
   *   <li>{@link ProductImpl#getAllParentCategoryXrefs()}
   *   <li>{@link ProductImpl#getCanonicalUrl()}
   *   <li>{@link ProductImpl#getCrossSaleProducts()}
   *   <li>{@link ProductImpl#getDefaultSku()}
   *   <li>{@link ProductImpl#getDisplayTemplate()}
   *   <li>{@link ProductImpl#getFieldEntityType()}
   *   <li>{@link ProductImpl#getId()}
   *   <li>{@link ProductImpl#getManufacturer()}
   *   <li>{@link ProductImpl#getMetaDescription()}
   *   <li>{@link ProductImpl#getMetaTitle()}
   *   <li>{@link ProductImpl#getModel()}
   *   <li>{@link ProductImpl#getPromoMessage()}
   *   <li>{@link ProductImpl#getUpSaleProducts()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    List<Sku> actualAdditionalSkus = productImpl.getAdditionalSkus();
    List<CategoryProductXref> actualAllParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    String actualCanonicalUrl = productImpl.getCanonicalUrl();
    List<RelatedProduct> actualCrossSaleProducts = productImpl.getCrossSaleProducts();
    productImpl.getDefaultSku();
    String actualDisplayTemplate = productImpl.getDisplayTemplate();
    FieldEntity actualFieldEntityType = productImpl.getFieldEntityType();
    Long actualId = productImpl.getId();
    String actualManufacturer = productImpl.getManufacturer();
    String actualMetaDescription = productImpl.getMetaDescription();
    String actualMetaTitle = productImpl.getMetaTitle();
    String actualModel = productImpl.getModel();
    String actualPromoMessage = productImpl.getPromoMessage();
    List<RelatedProduct> actualUpSaleProducts = productImpl.getUpSaleProducts();

    // Assert that nothing has changed
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Manufacturer", actualManufacturer);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("Model", actualModel);
    assertEquals("Promo Message", actualPromoMessage);
    assertEquals("https://example.org/example", actualCanonicalUrl);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalSkus.isEmpty());
    assertTrue(actualAllParentCategoryXrefs.isEmpty());
    assertTrue(actualCrossSaleProducts.isEmpty());
    assertTrue(actualUpSaleProducts.isEmpty());
    assertSame(actualFieldEntityType.PRODUCT, actualFieldEntityType);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductImpl#setCanSellWithoutOptions(Boolean)}
   *   <li>{@link ProductImpl#setCanonicalUrl(String)}
   *   <li>{@link ProductImpl#setDefaultCategory(Category)}
   *   <li>{@link ProductImpl#setDisplayTemplate(String)}
   *   <li>{@link ProductImpl#setId(Long)}
   *   <li>{@link ProductImpl#setManufacturer(String)}
   *   <li>{@link ProductImpl#setMetaDescription(String)}
   *   <li>{@link ProductImpl#setMetaTitle(String)}
   *   <li>{@link ProductImpl#setModel(String)}
   *   <li>{@link ProductImpl#setProductOptionXrefs(List)}
   *   <li>{@link ProductImpl#setPromoMessage(String)}
   *   <li>{@link ProductImpl#setUrl(String)}
   *   <li>{@link ProductImpl#setUrlKey(String)}
   *   <li>{@link ProductImpl#getAdditionalSkus()}
   *   <li>{@link ProductImpl#getAllParentCategoryXrefs()}
   *   <li>{@link ProductImpl#getCanonicalUrl()}
   *   <li>{@link ProductImpl#getCrossSaleProducts()}
   *   <li>{@link ProductImpl#getDefaultSku()}
   *   <li>{@link ProductImpl#getDisplayTemplate()}
   *   <li>{@link ProductImpl#getFieldEntityType()}
   *   <li>{@link ProductImpl#getId()}
   *   <li>{@link ProductImpl#getManufacturer()}
   *   <li>{@link ProductImpl#getMetaDescription()}
   *   <li>{@link ProductImpl#getMetaTitle()}
   *   <li>{@link ProductImpl#getModel()}
   *   <li>{@link ProductImpl#getPromoMessage()}
   *   <li>{@link ProductImpl#getUpSaleProducts()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    List<Sku> actualAdditionalSkus = productImpl.getAdditionalSkus();
    List<CategoryProductXref> actualAllParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    String actualCanonicalUrl = productImpl.getCanonicalUrl();
    List<RelatedProduct> actualCrossSaleProducts = productImpl.getCrossSaleProducts();
    productImpl.getDefaultSku();
    String actualDisplayTemplate = productImpl.getDisplayTemplate();
    FieldEntity actualFieldEntityType = productImpl.getFieldEntityType();
    Long actualId = productImpl.getId();
    String actualManufacturer = productImpl.getManufacturer();
    String actualMetaDescription = productImpl.getMetaDescription();
    String actualMetaTitle = productImpl.getMetaTitle();
    String actualModel = productImpl.getModel();
    String actualPromoMessage = productImpl.getPromoMessage();
    List<RelatedProduct> actualUpSaleProducts = productImpl.getUpSaleProducts();

    // Assert that nothing has changed
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Manufacturer", actualManufacturer);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("Model", actualModel);
    assertEquals("Promo Message", actualPromoMessage);
    assertEquals("https://example.org/example", actualCanonicalUrl);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalSkus.isEmpty());
    assertTrue(actualAllParentCategoryXrefs.isEmpty());
    assertTrue(actualCrossSaleProducts.isEmpty());
    assertTrue(actualUpSaleProducts.isEmpty());
    assertSame(actualFieldEntityType.PRODUCT, actualFieldEntityType);
  }

  /**
   * Test {@link ProductImpl#setAdditionalSkus(List)}.
   * <p>
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAdditionalSkus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8123 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setAdditionalSkus(new ArrayList<>());
  }

  /**
   * Test {@link ProductImpl#setAdditionalSkus(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then {@link ProductImpl} (default constructor) AdditionalSkus is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus_givenSkuImpl_thenProductImplAdditionalSkusIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    productImpl.setAdditionalSkus(skus);

    // Assert
    assertEquals(skus, productImpl.getAdditionalSkus());
  }

  /**
   * Test {@link ProductImpl#setAdditionalSkus(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl}.</li>
   *   <li>Then {@link ProductImpl} (default constructor) AdditionalSkus size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus_givenSkuImpl_thenProductImplAdditionalSkusSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(mock(SkuImpl.class));

    // Act
    productImpl.setAdditionalSkus(skus);

    // Assert
    assertEquals(1, productImpl.getAdditionalSkus().size());
  }

  /**
   * Test {@link ProductImpl#setAdditionalSkus(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then {@link ProductImpl} (default constructor) AdditionalSkus size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus_givenSkuImpl_thenProductImplAdditionalSkusSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Sku> skus = new ArrayList<>();
    SkuImpl skuImpl = new SkuImpl();
    skus.add(skuImpl);
    SkuImpl skuImpl2 = new SkuImpl();
    skus.add(skuImpl2);

    // Act
    productImpl.setAdditionalSkus(skus);

    // Assert
    List<Sku> additionalSkus = productImpl.getAdditionalSkus();
    assertEquals(2, additionalSkus.size());
    assertSame(skuImpl, additionalSkus.get(0));
    assertSame(skuImpl2, additionalSkus.get(1));
  }

  /**
   * Test {@link ProductImpl#setAdditionalSkus(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ProductImpl} (default constructor) AdditionalSkus Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus_whenArrayList_thenProductImplAdditionalSkusEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setAdditionalSkus(new ArrayList<>());

    // Assert
    assertTrue(productImpl.getAdditionalSkus().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getDefaultCategory()}.
   * <p>
   * Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7137 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getDefaultCategory();
  }

  /**
   * Test {@link ProductImpl#getDefaultCategory()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  public void testGetDefaultCategory_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getDefaultCategory());
  }

  /**
   * Test {@link ProductImpl#getDefaultCategory()}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor)
   * {@link ProductImpl#defaultCategory} {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  public void testGetDefaultCategory_thenProductImplDefaultCategoryCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    CategoryImpl defaultCategory = new CategoryImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    Category actualDefaultCategory = productImpl.getDefaultCategory();

    // Assert
    Category category = productImpl.defaultCategory;
    assertTrue(category instanceof CategoryImpl);
    assertSame(defaultCategory, actualDefaultCategory);
    assertSame(((CategoryImpl) actualDefaultCategory).allLegacyChildCategories,
        ((CategoryImpl) category).allLegacyChildCategories);
    assertSame(((CategoryImpl) actualDefaultCategory).archiveStatus, ((CategoryImpl) category).archiveStatus);
    assertSame(((CategoryImpl) actualDefaultCategory).childCategoryXrefs, ((CategoryImpl) category).childCategoryXrefs);
    assertSame(((CategoryImpl) actualDefaultCategory).legacyCategoryMedia,
        ((CategoryImpl) category).legacyCategoryMedia);
    assertSame(((CategoryImpl) actualDefaultCategory).legacyChildCategories,
        ((CategoryImpl) category).legacyChildCategories);
  }

  /**
   * Test {@link ProductImpl#getDefaultCategory()}.
   * <ul>
   *   <li>Then return {@link ProductImpl} (default constructor)
   * {@link ProductImpl#defaultCategory}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  public void testGetDefaultCategory_thenReturnProductImplDefaultCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(mock(CategoryImpl.class));

    // Act and Assert
    assertSame(productImpl.defaultCategory, productImpl.getDefaultCategory());
  }

  /**
   * Test {@link ProductImpl#getCategory()}.
   * <p>
   * Method under test: {@link ProductImpl#getCategory()}
   */
  @Test
  public void testGetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getCategory());
  }

  /**
   * Test {@link ProductImpl#getCategory()}.
   * <p>
   * Method under test: {@link ProductImpl#getCategory()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategory2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7041 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getCategory();
  }

  /**
   * Test {@link ProductImpl#setCategory(Category)}.
   * <p>
   * Method under test: {@link ProductImpl#setCategory(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8239 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setCategory(new CategoryImpl());
  }

  /**
   * Test {@link ProductImpl#setCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   *   <li>Then {@link ProductImpl} (default constructor) AllParentCategoryIds first
   * is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setCategory(Category)}
   */
  @Test
  public void testSetCategory_whenCategoryImpl_thenProductImplAllParentCategoryIdsFirstIs0() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    CategoryImpl category = mock(CategoryImpl.class);

    // Act
    productImpl.setCategory(category);

    // Assert
    List<CategoryProductXref> allParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    CategoryProductXref getResult = allParentCategoryXrefs.get(0);
    assertTrue(getResult instanceof CategoryProductXrefImpl);
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(1, allParentCategoryIds.size());
    assertEquals("0", allParentCategoryIds.get(0));
    List<Category> allParentCategories = productImpl.getAllParentCategories();
    assertEquals(1, allParentCategories.size());
    assertSame(category, allParentCategories.get(0));
    assertSame(category, getResult.getCategory());
  }

  /**
   * Test {@link ProductImpl#setCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link ProductImpl} (default constructor) AllParentCategoryIds first
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setCategory(Category)}
   */
  @Test
  public void testSetCategory_whenCategoryImpl_thenProductImplAllParentCategoryIdsFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    productImpl.setCategory(category);

    // Assert
    List<CategoryProductXref> allParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    CategoryProductXref getResult = allParentCategoryXrefs.get(0);
    assertTrue(getResult instanceof CategoryProductXrefImpl);
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(1, allParentCategoryIds.size());
    assertEquals("null", allParentCategoryIds.get(0));
    List<Category> allParentCategories = productImpl.getAllParentCategories();
    assertEquals(1, allParentCategories.size());
    assertSame(category, allParentCategories.get(0));
    assertSame(category, getResult.getCategory());
  }

  /**
   * Test {@link ProductImpl#setCategory(Category)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ProductImpl} (default constructor) AllParentCategories
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setCategory(Category)}
   */
  @Test
  public void testSetCategory_whenNull_thenProductImplAllParentCategoriesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCategory(null);

    // Assert that nothing has changed
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(productImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getMedia()}.
   * <p>
   * Method under test: {@link ProductImpl#getMedia()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMedia() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7449 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getMedia();
  }

  /**
   * Test {@link ProductImpl#getMedia()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getMedia()}
   */
  @Test
  public void testGetMedia_givenProductImplDefaultSkuIsSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertTrue(productImpl.getMedia().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getSkuMedia()} return
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link SkuImpl#getSkuMedia()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getMedia()}
   */
  @Test
  public void testGetMedia_givenSkuImplGetSkuMediaReturnHashMap_thenCallsGetSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getSkuMedia()).thenReturn(new HashMap<>());
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Map<String, Media> actualMedia = productImpl.getMedia();

    // Assert
    verify(defaultSku).getSkuMedia();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualMedia.isEmpty());
  }

  /**
   * Test {@link ProductImpl#setMedia(Map)}.
   * <p>
   * Method under test: {@link ProductImpl#setMedia(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetMedia() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10275 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setMedia(new HashMap<>());
  }

  /**
   * Test {@link ProductImpl#getAllSkuMedia()}.
   * <p>
   * Method under test: {@link ProductImpl#getAllSkuMedia()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllSkuMedia() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6920 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getAllSkuMedia();
  }

  /**
   * Test {@link ProductImpl#getAllSkuMedia()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSkuMedia()}
   */
  @Test
  public void testGetAllSkuMedia_givenProductImplDefaultSkuIsSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertTrue(productImpl.getAllSkuMedia().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getAllSkuMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getSkuMedia()} return
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link SkuImpl#getSkuMedia()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getAllSkuMedia()}
   */
  @Test
  public void testGetAllSkuMedia_givenSkuImplGetSkuMediaReturnHashMap_thenCallsGetSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getSkuMedia()).thenReturn(new HashMap<>());
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Map<String, Media> actualAllSkuMedia = productImpl.getAllSkuMedia();

    // Assert
    verify(defaultSku).getSkuMedia();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualAllSkuMedia.isEmpty());
  }

  /**
   * Test {@link ProductImpl#setAllParentCategoryXrefs(List)}.
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAllParentCategoryXrefs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8179 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setAllParentCategoryXrefs(new ArrayList<>());
  }

  /**
   * Test {@link ProductImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) AllParentCategories
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs_thenProductImplAllParentCategoriesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setAllParentCategoryXrefs(new ArrayList<>());

    // Assert
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(productImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
  }

  /**
   * Test {@link ProductImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor)
   * {@link ProductImpl#allParentCategoryIds} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs_thenProductImplAllParentCategoryIdsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<CategoryProductXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(mock(CategoryProductXrefImpl.class));

    // Act
    productImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertNull(productImpl.allParentCategoryIds);
    List<Category> allParentCategories2 = productImpl.getAllParentCategories();
    assertEquals(1, allParentCategories2.size());
    assertNull(allParentCategories2.get(0));
    assertEquals(allParentCategories2, productImpl.getAllSellableSkus());
    assertEquals(allParentCategories2, productImpl.getAllSkus());
  }

  /**
   * Test {@link ProductImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) AllParentCategoryIds size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs_thenProductImplAllParentCategoryIdsSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<CategoryProductXref> allParentCategories = new ArrayList<>();
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    allParentCategories.add(categoryProductXrefImpl);

    // Act
    productImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(1, allParentCategoryIds.size());
    assertEquals("null", allParentCategoryIds.get(0));
    assertEquals(1, productImpl.getAllParentCategories().size());
    List<CategoryProductXref> allParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    assertSame(categoryProductXrefImpl, allParentCategoryXrefs.get(0));
  }

  /**
   * Test {@link ProductImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) AllParentCategoryIds size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs_thenProductImplAllParentCategoryIdsSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<CategoryProductXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryProductXrefImpl());
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    allParentCategories.add(categoryProductXrefImpl);

    // Act
    productImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(2, allParentCategoryIds.size());
    assertEquals("null", allParentCategoryIds.get(1));
    List<Long> parentCategoryHierarchyIds = productImpl.getParentCategoryHierarchyIds();
    assertEquals(2, parentCategoryHierarchyIds.size());
    assertNull(parentCategoryHierarchyIds.get(0));
    assertNull(parentCategoryHierarchyIds.get(1));
    assertEquals(2, productImpl.getAllParentCategories().size());
    List<CategoryProductXref> allParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    assertEquals(2, allParentCategoryXrefs.size());
    assertSame(categoryProductXrefImpl, allParentCategoryXrefs.get(1));
  }

  /**
   * Test {@link ProductImpl#getParentCategoryHierarchyIds()}.
   * <p>
   * Method under test: {@link ProductImpl#getParentCategoryHierarchyIds()}
   */
  @Test
  public void testGetParentCategoryHierarchyIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getParentCategoryHierarchyIds().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getParentCategoryHierarchyIds()}.
   * <p>
   * Method under test: {@link ProductImpl#getParentCategoryHierarchyIds()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetParentCategoryHierarchyIds2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7545 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getParentCategoryHierarchyIds();
  }

  /**
   * Test {@link ProductImpl#getAllParentCategoryIds()}.
   * <p>
   * Method under test: {@link ProductImpl#getAllParentCategoryIds()}
   */
  @Test
  public void testGetAllParentCategoryIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getAllParentCategoryIds().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getAllParentCategoryIds()}.
   * <p>
   * Method under test: {@link ProductImpl#getAllParentCategoryIds()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllParentCategoryIds2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6872 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getAllParentCategoryIds();
  }

  /**
   * Test {@link ProductImpl#getAllParentCategories()}.
   * <p>
   * Method under test: {@link ProductImpl#getAllParentCategories()}
   */
  @Test
  public void testGetAllParentCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getAllParentCategories().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getAllParentCategories()}.
   * <p>
   * Method under test: {@link ProductImpl#getAllParentCategories()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllParentCategories2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6848 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getAllParentCategories();
  }

  /**
   * Test {@link ProductImpl#setAllParentCategories(List)}.
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategories(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAllParentCategories() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8151 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setAllParentCategories(new ArrayList<>());
  }

  /**
   * Test {@link ProductImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories_givenCategoryImpl_whenArrayListAddCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link ProductImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories_givenCategoryImpl_whenArrayListAddCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link ProductImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setAllParentCategories(new ArrayList<>()));
  }

  /**
   * Test {@link ProductImpl#getDimension()}.
   * <p>
   * Method under test: {@link ProductImpl#getDimension()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDimension() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7209 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getDimension();
  }

  /**
   * Test {@link ProductImpl#getDimension()}.
   * <ul>
   *   <li>Given {@link Dimension} {@link Dimension#setSize(ContainerSizeType)} does
   * nothing.</li>
   *   <li>Then calls {@link Dimension#setContainer(ContainerShapeType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDimension()}
   */
  @Test
  public void testGetDimension_givenDimensionSetSizeDoesNothing_thenCallsSetContainer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.getDimension();

    // Assert
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#getDimension()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl} (default constructor)
   * {@link SkuImpl#dimension}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDimension()}
   */
  @Test
  public void testGetDimension_givenProductImplDefaultSkuIsSkuImpl_thenReturnSkuImplDimension() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertSame(defaultSku.dimension, productImpl.getDimension());
  }

  /**
   * Test {@link ProductImpl#setDimension(Dimension)}.
   * <p>
   * Method under test: {@link ProductImpl#setDimension(Dimension)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetDimension() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9040 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType("Type", "Friendly Type"));
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl2.setDimension(dimension);
  }

  /**
   * Test {@link ProductImpl#setDimension(Dimension)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDimension(Dimension)}
   */
  @Test
  public void testSetDimension_thenProductImplDefaultSkuSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    Dimension dimension = mock(Dimension.class);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.setDimension(dimension);

    // Assert
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertNull(productImpl.getDimensionString());
    assertNull(productImpl.getContainer());
    assertNull(productImpl.getSize());
    Money margin = productImpl.getMargin();
    Money zeroResult = margin.zero().abs().abs().zero().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(margin, absResult.abs());
    Money absResult2 = zeroResult.abs();
    Money zeroResult3 = absResult2.zero();
    assertEquals(margin, zeroResult3.abs());
    Money zeroResult4 = zeroResult2.zero();
    assertEquals(margin, zeroResult4.abs());
    assertEquals(margin, absResult2.abs().zero());
    assertEquals(margin, absResult.zero());
    assertEquals(margin, zeroResult3.zero());
    assertEquals(margin, zeroResult4.zero());
    assertSame(dimension, productImpl.getDimension());
    assertSame(dimension, defaultSku.getDimension());
    assertSame(dimension, ((SkuImpl) defaultSku).dimension);
  }

  /**
   * Test {@link ProductImpl#getWidth()}.
   * <p>
   * Method under test: {@link ProductImpl#getWidth()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWidth() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7929 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getWidth();
  }

  /**
   * Test {@link ProductImpl#getWidth()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getWidth()}
   */
  @Test
  public void testGetWidth_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getWidth());
  }

  /**
   * Test {@link ProductImpl#getWidth()}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getWidth()}
   */
  @Test
  public void testGetWidth_thenReturnBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    when(dimension.getWidth()).thenReturn(new BigDecimal("2.3"));
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualWidth = productImpl.getWidth();

    // Assert
    verify(dimension).getWidth();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualWidth);
  }

  /**
   * Test {@link ProductImpl#getHeight()}.
   * <p>
   * Method under test: {@link ProductImpl#getHeight()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetHeight() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7329 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getHeight();
  }

  /**
   * Test {@link ProductImpl#getHeight()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getHeight()}
   */
  @Test
  public void testGetHeight_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getHeight());
  }

  /**
   * Test {@link ProductImpl#getHeight()}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getHeight()}
   */
  @Test
  public void testGetHeight_thenReturnBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    when(dimension.getHeight()).thenReturn(new BigDecimal("2.3"));
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualHeight = productImpl.getHeight();

    // Assert
    verify(dimension).getHeight();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualHeight);
  }

  /**
   * Test {@link ProductImpl#setHeight(BigDecimal)}.
   * <p>
   * Method under test: {@link ProductImpl#setHeight(BigDecimal)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetHeight() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9653 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setHeight(new BigDecimal("2.3"));
  }

  /**
   * Test {@link ProductImpl#setHeight(BigDecimal)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Dimension DimensionString
   * is {@code 2.3HxnullWxnullD"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setHeight(BigDecimal)}
   */
  @Test
  public void testSetHeight_thenProductImplDimensionDimensionStringIs23HxnullWxnullD() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    BigDecimal height = new BigDecimal("2.3");

    // Act
    productImpl.setHeight(height);

    // Assert
    Dimension dimension = productImpl.getDimension();
    assertEquals("2.3HxnullWxnullD\"", dimension.getDimensionString());
    assertEquals("2.3HxnullWxnullD\"", productImpl.getDimensionString());
    assertSame(height, dimension.getHeight());
    assertSame(height, productImpl.getHeight());
  }

  /**
   * Test {@link ProductImpl#getDepth()}.
   * <p>
   * Method under test: {@link ProductImpl#getDepth()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDepth() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7161 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getDepth();
  }

  /**
   * Test {@link ProductImpl#getDepth()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDepth()}
   */
  @Test
  public void testGetDepth_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getDepth());
  }

  /**
   * Test {@link ProductImpl#getDepth()}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDepth()}
   */
  @Test
  public void testGetDepth_thenReturnBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    when(dimension.getDepth()).thenReturn(new BigDecimal("2.3"));
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualDepth = productImpl.getDepth();

    // Assert
    verify(dimension).getDepth();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualDepth);
  }

  /**
   * Test {@link ProductImpl#setDepth(BigDecimal)}.
   * <p>
   * Method under test: {@link ProductImpl#setDepth(BigDecimal)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetDepth() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8418 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setDepth(new BigDecimal("2.3"));
  }

  /**
   * Test {@link ProductImpl#setDepth(BigDecimal)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Dimension DimensionString
   * is {@code nullHxnullWx2.3D"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setDepth(BigDecimal)}
   */
  @Test
  public void testSetDepth_thenProductImplDimensionDimensionStringIsNullHxnullWx23d() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    BigDecimal depth = new BigDecimal("2.3");

    // Act
    productImpl.setDepth(depth);

    // Assert
    Dimension dimension = productImpl.getDimension();
    assertEquals("nullHxnullWx2.3D\"", dimension.getDimensionString());
    assertEquals("nullHxnullWx2.3D\"", productImpl.getDimensionString());
    assertSame(depth, dimension.getDepth());
    assertSame(depth, productImpl.getDepth());
  }

  /**
   * Test {@link ProductImpl#getGirth()}.
   * <p>
   * Method under test: {@link ProductImpl#getGirth()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetGirth() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7305 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getGirth();
  }

  /**
   * Test {@link ProductImpl#getGirth()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGirth()}
   */
  @Test
  public void testGetGirth_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getGirth());
  }

  /**
   * Test {@link ProductImpl#getGirth()}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGirth()}
   */
  @Test
  public void testGetGirth_thenReturnBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    when(dimension.getGirth()).thenReturn(new BigDecimal("2.3"));
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualGirth = productImpl.getGirth();

    // Assert
    verify(dimension).getGirth();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualGirth);
  }

  /**
   * Test {@link ProductImpl#setGirth(BigDecimal)}.
   * <p>
   * Method under test: {@link ProductImpl#setGirth(BigDecimal)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetGirth() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9362 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setGirth(new BigDecimal("2.3"));
  }

  /**
   * Test {@link ProductImpl#setGirth(BigDecimal)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Dimension Girth is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setGirth(BigDecimal)}
   */
  @Test
  public void testSetGirth_thenProductImplDimensionGirthIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    BigDecimal girth = new BigDecimal("2.3");

    // Act
    productImpl.setGirth(girth);

    // Assert
    assertSame(girth, productImpl.getDimension().getGirth());
    assertSame(girth, productImpl.getGirth());
  }

  /**
   * Test {@link ProductImpl#getSize()}.
   * <p>
   * Method under test: {@link ProductImpl#getSize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7785 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getSize();
  }

  /**
   * Test {@link ProductImpl#getSize()}.
   * <ul>
   *   <li>Then return {@link ContainerSizeType#ContainerSizeType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getSize()}
   */
  @Test
  public void testGetSize_thenReturnContainerSizeType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    ContainerSizeType containerSizeType = new ContainerSizeType();
    when(dimension.getSize()).thenReturn(containerSizeType);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    ContainerSizeType actualSize = productImpl.getSize();

    // Assert
    verify(dimension).getSize();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(containerSizeType, actualSize);
  }

  /**
   * Test {@link ProductImpl#getSize()}.
   * <ul>
   *   <li>Then return FriendlyType is
   * {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getSize()}
   */
  @Test
  public void testGetSize_thenReturnFriendlyTypeIsThreadLocalManagerNotifyOrphans() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    ContainerSizeType actualSize = productImpl.getSize();

    // Assert
    assertEquals("ThreadLocalManager.notify.orphans", actualSize.getFriendlyType());
    assertNull(actualSize.getType());
  }

  /**
   * Test {@link ProductImpl#setSize(ContainerSizeType)}.
   * <p>
   * Method under test: {@link ProductImpl#setSize(ContainerSizeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10719 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setSize(new ContainerSizeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link ProductImpl#getContainer()}.
   * <p>
   * Method under test: {@link ProductImpl#getContainer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetContainer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7065 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getContainer();
  }

  /**
   * Test {@link ProductImpl#getContainer()}.
   * <ul>
   *   <li>Then return {@link ContainerShapeType#ContainerShapeType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getContainer()}
   */
  @Test
  public void testGetContainer_thenReturnContainerShapeType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    ContainerShapeType containerShapeType = new ContainerShapeType();
    when(dimension.getContainer()).thenReturn(containerShapeType);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    ContainerShapeType actualContainer = productImpl.getContainer();

    // Assert
    verify(dimension).getContainer();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(containerShapeType, actualContainer);
  }

  /**
   * Test {@link ProductImpl#getContainer()}.
   * <ul>
   *   <li>Then return FriendlyType is
   * {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getContainer()}
   */
  @Test
  public void testGetContainer_thenReturnFriendlyTypeIsThreadLocalManagerNotifyOrphans() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    ContainerShapeType actualContainer = productImpl.getContainer();

    // Assert
    assertEquals("ThreadLocalManager.notify.orphans", actualContainer.getFriendlyType());
    assertNull(actualContainer.getType());
  }

  /**
   * Test {@link ProductImpl#setContainer(ContainerShapeType)}.
   * <p>
   * Method under test: {@link ProductImpl#setContainer(ContainerShapeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetContainer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8297 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setContainer(new ContainerShapeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link ProductImpl#getDimensionString()}.
   * <p>
   * Method under test: {@link ProductImpl#getDimensionString()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDimensionString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7233 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getDimensionString();
  }

  /**
   * Test {@link ProductImpl#getDimensionString()}.
   * <ul>
   *   <li>Then return {@code Dimension String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDimensionString()}
   */
  @Test
  public void testGetDimensionString_thenReturnDimensionString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    when(dimension.getDimensionString()).thenReturn("Dimension String");
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualDimensionString = productImpl.getDimensionString();

    // Assert
    verify(dimension).getDimensionString();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Dimension String", actualDimensionString);
  }

  /**
   * Test {@link ProductImpl#getDimensionString()}.
   * <ul>
   *   <li>Then return {@code nullHxnullWxnullD"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getDimensionString()}
   */
  @Test
  public void testGetDimensionString_thenReturnNullHxnullWxnullD() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertEquals("nullHxnullWxnullD\"", productImpl.getDimensionString());
  }

  /**
   * Test {@link ProductImpl#getWeight()}.
   * <p>
   * Method under test: {@link ProductImpl#getWeight()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWeight() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7905 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getWeight();
  }

  /**
   * Test {@link ProductImpl#getWeight()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl} (default constructor)
   * {@link SkuImpl#weight}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getWeight()}
   */
  @Test
  public void testGetWeight_givenProductImplDefaultSkuIsSkuImpl_thenReturnSkuImplWeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertSame(defaultSku.weight, productImpl.getWeight());
  }

  /**
   * Test {@link ProductImpl#getWeight()}.
   * <ul>
   *   <li>Given {@link Weight} (default constructor) Weight is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link Weight} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getWeight()}
   */
  @Test
  public void testGetWeight_givenWeightWeightIsBigDecimalWith23_thenReturnWeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getWeight()).thenReturn(weight);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Weight actualWeight = productImpl.getWeight();

    // Assert
    verify(defaultSku).getWeight();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(weight, actualWeight);
  }

  /**
   * Test {@link ProductImpl#setCrossSaleProducts(List)}.
   * <p>
   * Method under test: {@link ProductImpl#setCrossSaleProducts(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetCrossSaleProducts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8328 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setCrossSaleProducts(new ArrayList<>());
  }

  /**
   * Test {@link ProductImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) CrossSaleProducts size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts_thenProductImplCrossSaleProductsSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    crossSaleProducts.add(mock(CrossSaleProductImpl.class));

    // Act
    productImpl.setCrossSaleProducts(crossSaleProducts);

    // Assert
    assertEquals(1, productImpl.getCrossSaleProducts().size());
  }

  /**
   * Test {@link ProductImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ProductImpl} (default constructor) CrossSaleProducts
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts_whenArrayList_thenProductImplCrossSaleProductsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCrossSaleProducts(new ArrayList<>());

    // Assert
    assertTrue(productImpl.getCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCumulativeCrossSaleProducts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7089 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getCumulativeCrossSaleProducts();
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CrossSaleProductImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_givenArrayListAddCrossSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = productImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultCategory is
   * {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_givenProductImplDefaultCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(productImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_givenProductImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenReturn(new ArrayList<>());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = productImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getCumulativeCrossSaleProducts());
    verify(defaultCategory).getCumulativeCrossSaleProducts();
  }

  /**
   * Test {@link ProductImpl#getCumulativeUpSaleProducts()}.
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCumulativeUpSaleProducts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7113 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getCumulativeUpSaleProducts();
  }

  /**
   * Test {@link ProductImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CrossSaleProductImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_givenArrayListAddCrossSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = productImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeUpSaleProducts();
    assertTrue(actualCumulativeUpSaleProducts.isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultCategory is
   * {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_givenProductImplDefaultCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(productImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_givenProductImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeUpSaleProducts()).thenReturn(new ArrayList<>());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = productImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeUpSaleProducts();
    assertTrue(actualCumulativeUpSaleProducts.isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeUpSaleProducts()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getCumulativeUpSaleProducts());
    verify(defaultCategory).getCumulativeUpSaleProducts();
  }

  /**
   * Test {@link ProductImpl#getProductAttributes()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductAttributes()}
   */
  @Test
  public void testGetProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getProductAttributes().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getProductAttributes()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductAttributes()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProductAttributes2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7593 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getProductAttributes();
  }

  /**
   * Test {@link ProductImpl#getMultiValueProductAttributes()}.
   * <p>
   * Method under test: {@link ProductImpl#getMultiValueProductAttributes()}
   */
  @Test
  public void testGetMultiValueProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getMultiValueProductAttributes().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getMultiValueProductAttributes()}.
   * <p>
   * Method under test: {@link ProductImpl#getMultiValueProductAttributes()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMultiValueProductAttributes2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7473 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getMultiValueProductAttributes();
  }

  /**
   * Test {@link ProductImpl#setProductAttributes(Map)}.
   * <p>
   * Method under test: {@link ProductImpl#setProductAttributes(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetProductAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10661 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setProductAttributes(new HashMap<>());
  }

  /**
   * Test {@link ProductImpl#setProductAttributes(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setProductAttributes(Map)}
   */
  @Test
  public void testSetProductAttributes_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    productAttributes.computeIfPresent("foo", mock(BiFunction.class));
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributes.put("foo", productAttributeImpl);

    // Act
    productImpl.setProductAttributes(productAttributes);

    // Assert
    List<ProductAttribute> productAttributeList = productImpl.productAttributes;
    assertEquals(1, productAttributeList.size());
    Map<String, ProductAttribute> multiValueProductAttributes = productImpl.getMultiValueProductAttributes();
    assertEquals(1, multiValueProductAttributes.size());
    Map<String, ProductAttribute> productAttributes2 = productImpl.getProductAttributes();
    assertEquals(1, productAttributes2.size());
    List<ProductAttribute> expectedGetResult = productImpl.productAttributes;
    assertEquals(expectedGetResult, multiValueProductAttributes.get(null));
    assertSame(productAttributeImpl, productAttributeList.get(0));
    assertSame(productAttributeImpl, productAttributes2.get(null));
  }

  /**
   * Test {@link ProductImpl#setProductAttributes(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link ProductImpl} (default constructor)
   * {@link ProductImpl#productAttributes} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setProductAttributes(Map)}
   */
  @Test
  public void testSetProductAttributes_givenFoo_thenProductImplProductAttributesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributes.put("foo", productAttributeImpl);

    // Act
    productImpl.setProductAttributes(productAttributes);

    // Assert
    List<ProductAttribute> productAttributeList = productImpl.productAttributes;
    assertEquals(1, productAttributeList.size());
    Map<String, ProductAttribute> multiValueProductAttributes = productImpl.getMultiValueProductAttributes();
    assertEquals(1, multiValueProductAttributes.size());
    Map<String, ProductAttribute> productAttributes2 = productImpl.getProductAttributes();
    assertEquals(1, productAttributes2.size());
    List<ProductAttribute> expectedGetResult = productImpl.productAttributes;
    assertEquals(expectedGetResult, multiValueProductAttributes.get(null));
    assertSame(productAttributeImpl, productAttributeList.get(0));
    assertSame(productAttributeImpl, productAttributes2.get(null));
  }

  /**
   * Test {@link ProductImpl#setProductAttributes(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ProductImpl} (default constructor)
   * {@link ProductImpl#productAttributes} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setProductAttributes(Map)}
   */
  @Test
  public void testSetProductAttributes_whenHashMap_thenProductImplProductAttributesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setProductAttributes(new HashMap<>());

    // Assert
    assertTrue(productImpl.productAttributes.isEmpty());
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getProductOptionXrefs()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductOptionXrefs()}
   */
  @Test
  public void testGetProductOptionXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getProductOptionXrefs().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getProductOptionXrefs()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductOptionXrefs()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProductOptionXrefs2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7641 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getProductOptionXrefs();
  }

  /**
   * Test {@link ProductImpl#getProductOptions()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductOptions()}
   */
  @Test
  public void testGetProductOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getProductOptions().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getProductOptions()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductOptions()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProductOptions2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7665 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getProductOptions();
  }

  /**
   * Test {@link ProductImpl#setProductOptions(List)}.
   * <p>
   * Method under test: {@link ProductImpl#setProductOptions(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetProductOptions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10691 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();

    // Act
    productImpl2.setProductOptions(new ArrayList<>());
  }

  /**
   * Test {@link ProductImpl#setProductOptions(List)}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductOptionImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setProductOptions(List)}
   */
  @Test
  public void testSetProductOptions_givenProductOptionImpl_whenArrayListAddProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<ProductOption> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setProductOptions(productOptions));
  }

  /**
   * Test {@link ProductImpl#setProductOptions(List)}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductOptionImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setProductOptions(List)}
   */
  @Test
  public void testSetProductOptions_givenProductOptionImpl_whenArrayListAddProductOptionImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<ProductOption> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionImpl());
    productOptions.add(new ProductOptionImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setProductOptions(productOptions));
  }

  /**
   * Test {@link ProductImpl#setProductOptions(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setProductOptions(List)}
   */
  @Test
  public void testSetProductOptions_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setProductOptions(new ArrayList<>()));
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7857 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getUrl();
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenCategoryImplGetGeneratedUrlReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn(null);
    Sku defaultSku = mock(Sku.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory).getGeneratedUrl();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return
   * {@code //}.</li>
   *   <li>Then return {@code //name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenCategoryImplGetGeneratedUrlReturnSlashSlash_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//name", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getUrl());
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return
   * {@code [^A-Za-z0-9/-]}.</li>
   *   <li>Then return {@code https://example.org/example//a-za-z0-9/-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenSkuGetNameReturnAZaZ09_thenReturnHttpsExampleOrgExampleAZaZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//a-za-z0-9/-", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.</li>
   *   <li>Then return {@code https://example.org/example//name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenSkuGetNameReturnName_thenReturnHttpsExampleOrgExampleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//name", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return space.</li>
   *   <li>Then return {@code https://example.org/example//-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenSkuGetNameReturnSpace_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//-", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getUrl());
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example//https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//https://example.org/example", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example//null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_thenReturnHttpsExampleOrgExampleNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getUrl());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Test {@link ProductImpl#getOverrideGeneratedUrl()}.
   * <p>
   * Method under test: {@link ProductImpl#getOverrideGeneratedUrl()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOverrideGeneratedUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7521 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getOverrideGeneratedUrl();
  }

  /**
   * Test {@link ProductImpl#getOverrideGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl_givenProductImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).getOverrideGeneratedUrl());
  }

  /**
   * Test {@link ProductImpl#getOverrideGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setOverrideGeneratedUrl(true);

    // Act and Assert
    assertTrue(productImpl.getOverrideGeneratedUrl());
  }

  /**
   * Test {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}.
   * <p>
   * Method under test: {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetOverrideGeneratedUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10637 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).setOverrideGeneratedUrl(true);
  }

  /**
   * Test {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then not {@link ProductImpl} (default constructor)
   * OverrideGeneratedUrl.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl_whenNull_thenNotProductImplOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setOverrideGeneratedUrl(null);

    // Assert
    assertFalse(productImpl.getOverrideGeneratedUrl());
    assertFalse(productImpl.overrideGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link ProductImpl} (default constructor) OverrideGeneratedUrl.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl_whenTrue_thenProductImplOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setOverrideGeneratedUrl(true);

    // Assert
    assertTrue(productImpl.getOverrideGeneratedUrl());
    assertTrue(productImpl.overrideGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getArchived()}.
   * <p>
   * Method under test: {@link ProductImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new ProductImpl()).getArchived().charValue());
  }

  /**
   * Test {@link ProductImpl#getArchived()}.
   * <p>
   * Method under test: {@link ProductImpl#getArchived()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetArchived2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6993 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getArchived();
  }

  /**
   * Test {@link ProductImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link ProductImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setArchived('A');

    // Assert
    assertEquals('A', productImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', productImpl.getArchived().charValue());
  }

  /**
   * Test {@link ProductImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link ProductImpl#setArchived(Character)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetArchived2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8207 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).setArchived('A');
  }

  /**
   * Test {@link ProductImpl#getProductOptionValuesMap()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductOptionValuesMap()}
   */
  @Test
  public void testGetProductOptionValuesMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getProductOptionValuesMap().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getProductOptionValuesMap()}.
   * <p>
   * Method under test: {@link ProductImpl#getProductOptionValuesMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProductOptionValuesMap2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7617 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getProductOptionValuesMap();
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: Cannot add the type: (Type). It already exists as a type via org.broadleafcommerce.common.vendor.service.type.ContainerShapeType
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.setType(ContainerShapeType.java:66)
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.<init>(ContainerShapeType.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    ProductImpl productImpl2 = new ProductImpl();
    productImpl2.setCanSellWithoutOptions(true);
    productImpl2.setCanonicalUrl("https://example.org/example");
    productImpl2.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl2.setDefaultCategory(new CategoryImpl());
    productImpl2.setDefaultSku(new SkuImpl());
    productImpl2.setDepth(new BigDecimal("2.3"));
    productImpl2.setDisplayTemplate("Display Template");
    productImpl2.setFeaturedProduct(true);
    productImpl2.setGirth(new BigDecimal("2.3"));
    productImpl2.setHeight(new BigDecimal("2.3"));
    productImpl2.setId(1L);
    productImpl2.setManufacturer("Manufacturer");
    productImpl2.setMetaDescription("Meta Description");
    productImpl2.setMetaTitle("Dr");
    productImpl2.setModel("Model");
    productImpl2.setOverrideGeneratedUrl(true);
    productImpl2.setProductAttributes(new HashMap<>());
    productImpl2.setProductOptionXrefs(new ArrayList<>());
    productImpl2.setPromoMessage("Promo Message");
    productImpl2.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl2.setUpSaleProducts(new ArrayList<>());
    productImpl2.setUrl("https://example.org/example");
    productImpl2.setUrlKey("https://example.org/example");
    productImpl2.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals(productImpl2);
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: Cannot add the type: (Type). It already exists as a type via org.broadleafcommerce.common.vendor.service.type.ContainerShapeType
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.setType(ContainerShapeType.java:66)
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.<init>(ContainerShapeType.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    ProductImpl productImpl2 = new ProductImpl();
    productImpl2.setCanSellWithoutOptions(true);
    productImpl2.setCanonicalUrl("https://example.org/example");
    productImpl2.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl2.setDefaultCategory(new CategoryImpl());
    productImpl2.setDefaultSku(new SkuImpl());
    productImpl2.setDepth(new BigDecimal("2.3"));
    productImpl2.setDisplayTemplate("Display Template");
    productImpl2.setFeaturedProduct(true);
    productImpl2.setGirth(new BigDecimal("2.3"));
    productImpl2.setHeight(new BigDecimal("2.3"));
    productImpl2.setId(1L);
    productImpl2.setManufacturer("Manufacturer");
    productImpl2.setMetaDescription("Meta Description");
    productImpl2.setMetaTitle("Dr");
    productImpl2.setModel("Model");
    productImpl2.setOverrideGeneratedUrl(true);
    productImpl2.setProductAttributes(new HashMap<>());
    productImpl2.setProductOptionXrefs(new ArrayList<>());
    productImpl2.setPromoMessage("Promo Message");
    productImpl2.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl2.setUpSaleProducts(new ArrayList<>());
    productImpl2.setUrl("https://example.org/example");
    productImpl2.setUrlKey("https://example.org/example");
    productImpl2.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals(productImpl2);
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals(null);
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsNull2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals(null);
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsSame() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals(productImpl);
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsSame2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals(productImpl);
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsWrongType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals("Different type to ProductImpl");
  }

  /**
   * Test {@link ProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsWrongType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDepth(new BigDecimal("2.3"));
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setFeaturedProduct(true);
    productImpl.setGirth(new BigDecimal("2.3"));
    productImpl.setHeight(new BigDecimal("2.3"));
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setOverrideGeneratedUrl(true);
    productImpl.setProductAttributes(new HashMap<>());
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setSize(new ContainerSizeType("Type", "Friendly Type"));
    productImpl.setUpSaleProducts(new ArrayList<>());
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.equals("Different type to ProductImpl");
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   * <p>
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetUrlKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7881 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getUrlKey();
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return
   * {@code [^A-Za-z0-9/-]}.</li>
   *   <li>Then return {@code a-za-z0-9/-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey_givenSkuGetNameReturnAZaZ09_thenReturnAZaZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualUrlKey = productImpl.getUrlKey();

    // Assert
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("a-za-z0-9/-", actualUrlKey);
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey_givenSkuGetNameReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualUrlKey = productImpl.getUrlKey();

    // Assert
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("name", actualUrlKey);
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return space.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey_givenSkuGetNameReturnSpace_thenReturnDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualUrlKey = productImpl.getUrlKey();

    // Assert
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("-", actualUrlKey);
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetGeneratedUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7281 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getGeneratedUrl();
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplGetGeneratedUrlReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn(null);
    Sku defaultSku = mock(Sku.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory).getGeneratedUrl();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getGeneratedUrl());
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return space.</li>
   *   <li>Then return {@code https://example.org/example//-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenSkuGetNameReturnSpace_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//-", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example//a-za-z0-9/-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExampleAZaZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//a-za-z0-9/-", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example//https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//https://example.org/example", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example//name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExampleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//name", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example//null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExampleNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code //name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//name", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getGeneratedUrl());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Test {@link ProductImpl#clearDynamicPrices()}.
   * <p>
   * Method under test: {@link ProductImpl#clearDynamicPrices()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearDynamicPrices() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6694 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).clearDynamicPrices();
  }

  /**
   * Test {@link ProductImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#clearDynamicPrices()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices_thenCallsClearDynamicPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).clearDynamicPrices();
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.clearDynamicPrices();

    // Assert
    verify(defaultSku).clearDynamicPrices();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7401 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getMainEntityName();
  }

  /**
   * Test {@link ProductImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getMainEntityName());
  }

  /**
   * Test {@link ProductImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSkuGetNameReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualMainEntityName = productImpl.getMainEntityName();

    // Assert
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Name", actualMainEntityName);
  }

  /**
   * Test
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Product> actualCreateOrRetrieveCopyInstanceResult = productImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6718 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductImpl productImpl2 = new ProductImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    productImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code PROPAGATION} is
   * {@code PROPAGATION}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenHashMapPropagationIsPropagation()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", "PROPAGATION");
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Product> actualCreateOrRetrieveCopyInstanceResult = productImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context, atLeast(1)).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductImpl#getTaxCode()}.
   * <p>
   * Method under test: {@link ProductImpl#getTaxCode()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTaxCode() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7833 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getTaxCode();
  }

  /**
   * Test {@link ProductImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getTaxCode());
  }

  /**
   * Test {@link ProductImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getTaxCode()} return
   * {@code Tax Code}.</li>
   *   <li>Then return {@code Tax Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode_givenSkuImplGetTaxCodeReturnTaxCode_thenReturnTaxCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getTaxCode()).thenReturn("Tax Code");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualTaxCode = productImpl.getTaxCode();

    // Assert
    verify(defaultSku).getTaxCode();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Tax Code", actualTaxCode);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7353 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductImpl()).getLocation();
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenCategoryImplGetGeneratedUrlReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn(null);
    Sku defaultSku = mock(Sku.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory).getGeneratedUrl();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return
   * {@code //}.</li>
   *   <li>Then return {@code //name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenCategoryImplGetGeneratedUrlReturnSlashSlash_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//name", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenProductImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getLocation());
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.</li>
   *   <li>Then return {@code https://example.org/example//name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenSkuGetNameReturnName_thenReturnHttpsExampleOrgExampleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//name", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return space.</li>
   *   <li>Then return {@code https://example.org/example//-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenSkuGetNameReturnSpace_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//-", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getLocation());
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example//a-za-z0-9/-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_thenReturnHttpsExampleOrgExampleAZaZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//a-za-z0-9/-", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example//https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//https://example.org/example", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example//null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_thenReturnHttpsExampleOrgExampleNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getLocation());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Test new {@link ProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductImpl}
   */
  @Test
  public void testNewProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductImpl actualProductImpl = new ProductImpl();

    // Assert
    FieldEntity fieldEntityType = actualProductImpl.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', actualProductImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualProductImpl.getArchived().charValue());
    assertNull(actualProductImpl.getId());
    assertNull(actualProductImpl.getCanonicalUrl());
    assertNull(actualProductImpl.getDisplayTemplate());
    assertNull(actualProductImpl.getGeneratedUrl());
    assertNull(actualProductImpl.getLocation());
    assertNull(actualProductImpl.getManufacturer());
    assertNull(actualProductImpl.getMetaDescription());
    assertNull(actualProductImpl.getMetaTitle());
    assertNull(actualProductImpl.getModel());
    assertNull(actualProductImpl.getPromoMessage());
    assertNull(actualProductImpl.getUrl());
    assertNull(actualProductImpl.url);
    assertNull(actualProductImpl.urlKey);
    assertNull(actualProductImpl.getPrice());
    assertNull(actualProductImpl.getRetailPrice());
    assertNull(actualProductImpl.getRetailPriceInternal());
    assertNull(actualProductImpl.getSalePrice());
    assertNull(actualProductImpl.getSalePriceInternal());
    assertNull(actualProductImpl.getCategory());
    assertNull(actualProductImpl.getDefaultCategory());
    assertNull(actualProductImpl.defaultCategory);
    List<Sku> allSellableSkus = actualProductImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(actualProductImpl.getDefaultSku());
    assertFalse(actualProductImpl.getCanSellWithoutOptions());
    assertFalse(actualProductImpl.getOverrideGeneratedUrl());
    assertFalse(actualProductImpl.hasRetailPrice());
    assertFalse(actualProductImpl.canSellWithoutOptions);
    assertFalse(actualProductImpl.isFeaturedProduct);
    assertFalse(actualProductImpl.overrideGeneratedUrl);
    assertTrue(actualProductImpl.getAdditionalSkus().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategories().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = actualProductImpl.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = actualProductImpl.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(actualProductImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(actualProductImpl.getProductOptionXrefs().isEmpty());
    assertTrue(actualProductImpl.getProductOptions().isEmpty());
    assertTrue(actualProductImpl.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualProductImpl.productAttributes.isEmpty());
    assertTrue(actualProductImpl.productOptions.isEmpty());
    assertTrue(actualProductImpl.skus.isEmpty());
    assertTrue(actualProductImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(actualProductImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap = actualProductImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    assertEquals(allSellableSkus, actualProductImpl.getAllSkus());
    assertSame(crossSaleProducts, actualProductImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductImpl.productOptionMap);
  }

  /**
   * Test new {@link ProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewProductImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6693 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.ProductImpl productImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new ProductImpl();
  }
}
