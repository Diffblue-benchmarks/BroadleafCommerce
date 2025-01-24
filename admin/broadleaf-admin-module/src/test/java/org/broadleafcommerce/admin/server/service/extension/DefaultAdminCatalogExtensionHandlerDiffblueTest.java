package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultAdminCatalogExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler;

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#init()}.
   * <p>
   * Method under test: {@link DefaultAdminCatalogExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass276 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.extension.DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultAdminCatalogExtensionHandler()).init();
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistSkuPermutation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass279 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.extension.DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler2 = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act
    defaultAdminCatalogExtensionHandler2.persistSkuPermutation(product, permutationsToGenerate, erh);
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_givenArrayList_whenProductBundleImpl_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();
    permutationsToGenerate.add(new ArrayList<>());

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED,
        defaultAdminCatalogExtensionHandler.persistSkuPermutation(product, permutationsToGenerate, erh));
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) Result intValue
   * is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_thenExtensionResultHolderResultIntValueIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPersistSkuPermutationResult = defaultAdminCatalogExtensionHandler
        .persistSkuPermutation(product, permutationsToGenerate, erh);

    // Assert
    assertEquals(0, erh.getResult().intValue());
    assertEquals(ExtensionResultStatusType.HANDLED, actualPersistSkuPermutationResult);
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) Result intValue
   * is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_thenExtensionResultHolderResultIntValueIsZero2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();
    permutationsToGenerate.add(new ArrayList<>());
    permutationsToGenerate.add(new ArrayList<>());

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPersistSkuPermutationResult = defaultAdminCatalogExtensionHandler
        .persistSkuPermutation(product, permutationsToGenerate, erh);

    // Assert
    assertEquals(0, erh.getResult().intValue());
    assertEquals(ExtensionResultStatusType.HANDLED, actualPersistSkuPermutationResult);
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_whenArrayList_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED,
        defaultAdminCatalogExtensionHandler.persistSkuPermutation(product, permutationsToGenerate, erh));
  }

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link DefaultAdminCatalogExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(AdminCatalogServiceExtensionHandler.DEFAULT_PRIORITY,
        (new DefaultAdminCatalogExtensionHandler()).getPriority());
  }

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link DefaultAdminCatalogExtensionHandler#getPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriority2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass273 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.extension.DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultAdminCatalogExtensionHandler()).getPriority();
  }
}
