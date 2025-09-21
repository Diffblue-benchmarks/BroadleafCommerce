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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.service.PersistenceService;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;

@RunWith(MockitoJUnitRunner.class)
public class DefaultPostLoaderDaoDiffblueTest {
  @InjectMocks private DefaultPostLoaderDao defaultPostLoaderDao;

  @Mock private PersistenceService persistenceService;

  /**
   * Test {@link DefaultPostLoaderDao#getPostLoaderDao()}.
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#getPostLoaderDao()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.persistence.PostLoaderDao DefaultPostLoaderDao.getPostLoaderDao()"
  })
  public void testGetPostLoaderDao() {
    // Arrange, Act and Assert
    assertNull(DefaultPostLoaderDao.getPostLoaderDao());
  }

  /**
   * Test {@link DefaultPostLoaderDao#find(Class, Object)}.
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#find(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.find(Class, Object)"})
  public void testFind() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> defaultPostLoaderDao.find(clazz, BLCFieldUtils.NULL_FIELD));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
  }

  /**
   * Test {@link DefaultPostLoaderDao#find(Class, Object)}.
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#find(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.find(Class, Object)"})
  public void testFind2() {
    // Arrange
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.find(Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenReturn(sessionDelegatorBaseImpl);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> defaultPostLoaderDao.find(clazz, BLCFieldUtils.NULL_FIELD));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    verify(sessionDelegatorBaseImpl).find(isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link DefaultPostLoaderDao#find(Class, Object)}.
   *
   * <ul>
   *   <li>Given {@link PersistenceService} {@link PersistenceService#identifyEntityManager(Class)}
   *       return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#find(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.find(Class, Object)"})
  public void testFind_givenPersistenceServiceIdentifyEntityManagerReturnNull_thenReturnNull() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any())).thenReturn(null);
    Class<Object> clazz = Object.class;

    // Act
    Object actualFindResult = defaultPostLoaderDao.find(clazz, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    assertNull(actualFindResult);
  }

  /**
   * Test {@link DefaultPostLoaderDao#find(Class, Object)}.
   *
   * <ul>
   *   <li>Given {@link SessionDelegatorBaseImpl} {@link SessionDelegatorBaseImpl#find(Class,
   *       Object)} return {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#find(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.find(Class, Object)"})
  public void testFind_givenSessionDelegatorBaseImplFindReturnNull_field_thenReturnNull_field() {
    // Arrange
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.find(Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(BLCFieldUtils.NULL_FIELD);
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenReturn(sessionDelegatorBaseImpl);
    Class<Object> clazz = Object.class;
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualFindResult = defaultPostLoaderDao.find(clazz, object);

    // Assert
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    verify(sessionDelegatorBaseImpl).find(isA(Class.class), isA(Object.class));
    assertSame(object, actualFindResult);
  }

  /**
   * Test {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}.
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.findSandboxEntity(Class, Object)"})
  public void testFindSandboxEntity() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> defaultPostLoaderDao.findSandboxEntity(clazz, BLCFieldUtils.NULL_FIELD));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
  }

  /**
   * Test {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}.
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.findSandboxEntity(Class, Object)"})
  public void testFindSandboxEntity2() {
    // Arrange
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.find(Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenReturn(sessionDelegatorBaseImpl);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> defaultPostLoaderDao.findSandboxEntity(clazz, BLCFieldUtils.NULL_FIELD));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    verify(sessionDelegatorBaseImpl).find(isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.findSandboxEntity(Class, Object)"})
  public void testFindSandboxEntity_thenReturnNull() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any())).thenReturn(null);
    Class<Object> clazz = Object.class;

    // Act
    Object actualFindSandboxEntityResult =
        defaultPostLoaderDao.findSandboxEntity(clazz, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    assertNull(actualFindSandboxEntityResult);
  }

  /**
   * Test {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}.
   *
   * <ul>
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#findSandboxEntity(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultPostLoaderDao.findSandboxEntity(Class, Object)"})
  public void testFindSandboxEntity_thenReturnNull_field() {
    // Arrange
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.find(Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(BLCFieldUtils.NULL_FIELD);
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenReturn(sessionDelegatorBaseImpl);
    Class<Object> clazz = Object.class;
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualFindSandboxEntityResult = defaultPostLoaderDao.findSandboxEntity(clazz, object);

    // Assert
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    verify(sessionDelegatorBaseImpl).find(isA(Class.class), isA(Object.class));
    assertSame(object, actualFindSandboxEntityResult);
  }

  /**
   * Test {@link DefaultPostLoaderDao#getEntityManager(Class)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#getEntityManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager DefaultPostLoaderDao.getEntityManager(Class)"})
  public void testGetEntityManager_thenReturnNull() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any())).thenReturn(null);
    Class<Object> clazz = Object.class;

    // Act
    EntityManager actualEntityManager = defaultPostLoaderDao.getEntityManager(clazz);

    // Assert
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    assertNull(actualEntityManager);
  }

  /**
   * Test {@link DefaultPostLoaderDao#getEntityManager(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPostLoaderDao#getEntityManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager DefaultPostLoaderDao.getEntityManager(Class)"})
  public void testGetEntityManager_thenThrowFactoryBeanNotInitializedException() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> defaultPostLoaderDao.getEntityManager(clazz));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
  }
}
