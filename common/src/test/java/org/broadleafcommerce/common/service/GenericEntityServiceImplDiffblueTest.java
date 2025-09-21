/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.dao.GenericEntityDao;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GenericEntityServiceImplDiffblueTest {
  @Mock private GenericEntityDao genericEntityDao;

  @InjectMocks private GenericEntityServiceImpl genericEntityServiceImpl;

  /**
   * Test {@link GenericEntityServiceImpl#flush()}.
   *
   * <p>Method under test: {@link GenericEntityServiceImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericEntityServiceImpl.flush()"})
  public void testFlush() {
    // Arrange
    doNothing().when(genericEntityDao).flush();

    // Act
    genericEntityServiceImpl.flush();

    // Assert
    verify(genericEntityDao).flush();
  }

  /**
   * Test {@link GenericEntityServiceImpl#clearAutoFlushMode()}.
   *
   * <p>Method under test: {@link GenericEntityServiceImpl#clearAutoFlushMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericEntityServiceImpl.clearAutoFlushMode()"})
  public void testClearAutoFlushMode() {
    // Arrange
    doNothing().when(genericEntityDao).clearAutoFlushMode();

    // Act
    genericEntityServiceImpl.clearAutoFlushMode();

    // Assert
    verify(genericEntityDao).clearAutoFlushMode();
  }

  /**
   * Test {@link GenericEntityServiceImpl#enableAutoFlushMode()}.
   *
   * <p>Method under test: {@link GenericEntityServiceImpl#enableAutoFlushMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericEntityServiceImpl.enableAutoFlushMode()"})
  public void testEnableAutoFlushMode() {
    // Arrange
    doNothing().when(genericEntityDao).enableAutoFlushMode();

    // Act
    genericEntityServiceImpl.enableAutoFlushMode();

    // Assert
    verify(genericEntityDao).enableAutoFlushMode();
  }

  /**
   * Test {@link GenericEntityServiceImpl#clear()}.
   *
   * <p>Method under test: {@link GenericEntityServiceImpl#clear()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericEntityServiceImpl.clear()"})
  public void testClear() {
    // Arrange
    doNothing().when(genericEntityDao).clear();

    // Act
    genericEntityServiceImpl.clear();

    // Assert
    verify(genericEntityDao).clear();
  }

  /**
   * Test {@link GenericEntityServiceImpl#getCeilingImplClass(String)}.
   *
   * <p>Method under test: {@link GenericEntityServiceImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class GenericEntityServiceImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityDao.getCeilingImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualCeilingImplClass = genericEntityServiceImpl.getCeilingImplClass("Class Name");

    // Assert
    verify(genericEntityDao).getCeilingImplClass("Class Name");
    Class<Object> expectedCeilingImplClass = Object.class;
    assertEquals(expectedCeilingImplClass, actualCeilingImplClass);
  }

  /**
   * Test {@link GenericEntityServiceImpl#getEntityManager()}.
   *
   * <p>Method under test: {@link GenericEntityServiceImpl#getEntityManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager GenericEntityServiceImpl.getEntityManager()"})
  public void testGetEntityManager() {
    // Arrange
    when(genericEntityDao.getEntityManager()).thenReturn(null);

    // Act
    EntityManager actualEntityManager = genericEntityServiceImpl.getEntityManager();

    // Assert
    verify(genericEntityDao).getEntityManager();
    assertNull(actualEntityManager);
  }
}
