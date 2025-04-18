/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.domain.Product;
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
  @Mock
  private EntityConfiguration entityConfiguration;

  @Mock
  private ProductDaoExtensionManager productDaoExtensionManager;

  @InjectMocks
  private ProductDaoImpl productDaoImpl;

  @Mock
  private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductDaoImpl.readProductsByIds(List)"})
  public void testReadProductsByIds_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productDaoImpl.readProductsByIds(new ArrayList<>()));
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductDaoImpl.readProductsByIds(List)"})
  public void testReadProductsByIds_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productDaoImpl.readProductsByIds(null));
  }

  /**
   * Test {@link ProductDaoImpl#create(ProductType)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#create(ProductType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product ProductDaoImpl.create(ProductType)"})
  public void testCreate_thenReturnNull() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(null);

    // Act
    Product actualCreateResult = productDaoImpl.create(ProductType.BUNDLE);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.catalog.domain.ProductBundle"));
    assertNull(actualCreateResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link ProductDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long ProductDaoImpl.getCurrentDateResolution()",
      "void ProductDaoImpl.setCurrentDateResolution(Long)"})
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#findProductByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductDaoImpl.findProductByURI(String)"})
  public void testFindProductByURI_thenReturnNull() {
    // Arrange
    ProductDaoExtensionHandler productDaoExtensionHandler = mock(ProductDaoExtensionHandler.class);
    when(productDaoExtensionHandler.findProductByURI(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(productDaoExtensionManager.getProxy()).thenReturn(productDaoExtensionHandler);

    // Act
    List<Product> actualFindProductByURIResult = productDaoImpl.findProductByURI("Uri");

    // Assert
    verify(productDaoExtensionManager).getProxy();
    verify(productDaoExtensionHandler).findProductByURI(eq("Uri"), isA(ExtensionResultHolder.class));
    assertNull(actualFindProductByURIResult);
  }

  /**
   * Test {@link ProductDaoImpl#findProductByURI(String)}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#findProductByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductDaoImpl.findProductByURI(String)"})
  public void testFindProductByURI_thenThrowNoResultException() {
    // Arrange
    ProductDaoExtensionHandler productDaoExtensionHandler = mock(ProductDaoExtensionHandler.class);
    when(productDaoExtensionHandler.findProductByURI(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenThrow(new NoResultException("An error occurred"));
    when(productDaoExtensionManager.getProxy()).thenReturn(productDaoExtensionHandler);

    // Act and Assert
    assertThrows(NoResultException.class, () -> productDaoImpl.findProductByURI("Uri"));
    verify(productDaoExtensionManager).getProxy();
    verify(productDaoExtensionHandler).findProductByURI(eq("Uri"), isA(ExtensionResultHolder.class));
  }
}
