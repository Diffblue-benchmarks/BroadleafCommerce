package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @Mock private ProductDaoExtensionManager productDaoExtensionManager;

  @InjectMocks private ProductDaoImpl productDaoImpl;

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductDaoImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductDaoImpl.readProductsByIds(List)"})
  public void testReadProductsByIds_givenProductDaoImpl_whenArrayList_thenReturnNull() {
    // Arrange
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    // Act and Assert
    assertNull(productDaoImpl.readProductsByIds(new ArrayList<>()));
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductDaoImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductDaoImpl.readProductsByIds(List)"})
  public void testReadProductsByIds_givenProductDaoImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ProductDaoImpl().readProductsByIds(null));
  }

  /**
   * Test {@link ProductDaoImpl#create(ProductType)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductDaoImpl#create(ProductType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ProductDaoImpl.create(ProductType)"})
  public void testCreate_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(productBundleImpl);

    ProductType productType = mock(ProductType.class);
    when(productType.getType()).thenReturn("Type");

    // Act
    Product actualCreateResult = productDaoImpl.create(productType);

    // Assert
    verify(entityConfiguration).createEntityInstance("Type");
    verify(productType).getType();
    assertSame(productBundleImpl, actualCreateResult);
  }

  /**
   * Test {@link ProductDaoImpl#create(ProductType)}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductDaoImpl#create(ProductType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ProductDaoImpl.create(ProductType)"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> productDaoImpl.create(ProductType.BUNDLE));
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.catalog.domain.ProductBundle");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link ProductDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ProductDaoImpl.getCurrentDateResolution()",
    "void ProductDaoImpl.setCurrentDateResolution(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    // Act
    productDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, productDaoImpl.getCurrentDateResolution().longValue());
  }

  /**
   * Test {@link ProductDaoImpl#findProductByURI(String)}.
   *
   * <p>Method under test: {@link ProductDaoImpl#findProductByURI(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductDaoImpl.findProductByURI(String)"})
  public void testFindProductByURI() {
    // Arrange
    when(productDaoExtensionManager.getProxy()).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> productDaoImpl.findProductByURI("Uri"));
    verify(productDaoExtensionManager).getProxy();
  }

  /**
   * Test {@link ProductDaoImpl#findProductByURI(String)}.
   *
   * <p>Method under test: {@link ProductDaoImpl#findProductByURI(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductDaoImpl.findProductByURI(String)"})
  public void testFindProductByURI2() {
    // Arrange
    ProductDaoExtensionHandler productDaoExtensionHandler = mock(ProductDaoExtensionHandler.class);
    when(productDaoExtensionHandler.findProductByURI(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenThrow(new NoResultException());
    when(productDaoExtensionManager.getProxy()).thenReturn(productDaoExtensionHandler);

    // Act and Assert
    assertThrows(NoResultException.class, () -> productDaoImpl.findProductByURI("Uri"));
    verify(productDaoExtensionManager).getProxy();
    verify(productDaoExtensionHandler)
        .findProductByURI(eq("Uri"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link ProductDaoImpl#findProductByURI(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductDaoImpl#findProductByURI(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductDaoImpl.findProductByURI(String)"})
  public void testFindProductByURI_thenReturnNull() {
    // Arrange
    ProductDaoExtensionHandler productDaoExtensionHandler = mock(ProductDaoExtensionHandler.class);
    when(productDaoExtensionHandler.findProductByURI(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(productDaoExtensionManager.getProxy()).thenReturn(productDaoExtensionHandler);

    // Act
    List<Product> actualFindProductByURIResult = productDaoImpl.findProductByURI("Uri");

    // Assert
    verify(productDaoExtensionManager).getProxy();
    verify(productDaoExtensionHandler)
        .findProductByURI(eq("Uri"), isA(ExtensionResultHolder.class));
    assertNull(actualFindProductByURIResult);
  }
}
