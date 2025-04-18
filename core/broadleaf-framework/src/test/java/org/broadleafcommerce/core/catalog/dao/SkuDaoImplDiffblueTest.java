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
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuDaoImplDiffblueTest {
  @Mock
  private EntityConfiguration entityConfiguration;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private SkuDaoExtensionManager skuDaoExtensionManager;

  @InjectMocks
  private SkuDaoImpl skuDaoImpl;

  /**
   * Test {@link SkuDaoImpl#readSkusByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#readSkusByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuDaoImpl.readSkusByIds(List)"})
  public void testReadSkusByIds_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(skuDaoImpl.readSkusByIds(new ArrayList<>()));
  }

  /**
   * Test {@link SkuDaoImpl#readSkusByIds(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#readSkusByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuDaoImpl.readSkusByIds(List)"})
  public void testReadSkusByIds_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(skuDaoImpl.readSkusByIds(null));
  }

  /**
   * Test {@link SkuDaoImpl#create()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku SkuDaoImpl.create()"})
  public void testCreate_thenReturnNull() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(null);

    // Act
    Sku actualCreateResult = skuDaoImpl.create();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.catalog.domain.Sku"));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link SkuDaoImpl#create()}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku SkuDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> skuDaoImpl.create());
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.catalog.domain.Sku"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link SkuDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SkuDaoImpl.getCurrentDateResolution()", "void SkuDaoImpl.setCurrentDateResolution(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    SkuDaoImpl skuDaoImpl = new SkuDaoImpl();

    // Act
    skuDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, skuDaoImpl.getCurrentDateResolution().longValue());
  }

  /**
   * Test {@link SkuDaoImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#findSkuByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuDaoImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_thenReturnNull() {
    // Arrange
    SkuDaoExtensionHandler skuDaoExtensionHandler = mock(SkuDaoExtensionHandler.class);
    when(skuDaoExtensionHandler.findSkuByURI(Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(skuDaoExtensionManager.getProxy()).thenReturn(skuDaoExtensionHandler);

    // Act
    List<Sku> actualFindSkuByURIResult = skuDaoImpl.findSkuByURI("Uri");

    // Assert
    verify(skuDaoExtensionManager).getProxy();
    verify(skuDaoExtensionHandler).findSkuByURI(eq("Uri"), isA(ExtensionResultHolder.class));
    assertNull(actualFindSkuByURIResult);
  }

  /**
   * Test {@link SkuDaoImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#findSkuByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuDaoImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_thenThrowNoResultException() {
    // Arrange
    SkuDaoExtensionHandler skuDaoExtensionHandler = mock(SkuDaoExtensionHandler.class);
    when(skuDaoExtensionHandler.findSkuByURI(Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenThrow(new NoResultException("An error occurred"));
    when(skuDaoExtensionManager.getProxy()).thenReturn(skuDaoExtensionHandler);

    // Act and Assert
    assertThrows(NoResultException.class, () -> skuDaoImpl.findSkuByURI("Uri"));
    verify(skuDaoExtensionManager).getProxy();
    verify(skuDaoExtensionHandler).findSkuByURI(eq("Uri"), isA(ExtensionResultHolder.class));
  }
}
