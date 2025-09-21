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
package org.broadleafcommerce.common.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.service.PersistenceService;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

@RunWith(MockitoJUnitRunner.class)
public class GenericEntityDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private GenericEntityDaoImpl genericEntityDaoImpl;

  @Mock private PersistenceService persistenceService;

  /**
   * Test {@link GenericEntityDaoImpl#getGenericEntityDao()}.
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getGenericEntityDao()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericEntityDaoImpl GenericEntityDaoImpl.getGenericEntityDao()"})
  public void testGetGenericEntityDao() {
    // Arrange, Act and Assert
    assertNull(GenericEntityDaoImpl.getGenericEntityDao());
  }

  /**
   * Test {@link GenericEntityDaoImpl#readGenericEntity(Class, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#readGenericEntity(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GenericEntityDaoImpl.readGenericEntity(Class, Object)"})
  public void testReadGenericEntity_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () -> genericEntityDaoImpl.readGenericEntity(clazz, BLCFieldUtils.NULL_FIELD));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getImplClass(String)}.
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> genericEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link GenericEntityDaoImpl#getImplClass(String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Class Name}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_givenJavaLangObject_whenClassName_thenReturnObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualImplClass = genericEntityDaoImpl.getImplClass("Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass("Class Name");
    Class<Object> expectedImplClass = Object.class;
    assertEquals(expectedImplClass, actualImplClass);
  }

  /**
   * Test {@link GenericEntityDaoImpl#getImplClass(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> genericEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link GenericEntityDaoImpl#getCeilingImplClass(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass_whenClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> genericEntityDaoImpl.getCeilingImplClass("Class Name"));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getIdentifier(Object)}.
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getIdentifier(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.Serializable GenericEntityDaoImpl.getIdentifier(Object)"})
  public void testGetIdentifier() {
    // Arrange, Act and Assert
    assertNull(genericEntityDaoImpl.getIdentifier(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link GenericEntityDaoImpl#idAssigned(Object)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#idAssigned(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GenericEntityDaoImpl.idAssigned(Object)"})
  public void testIdAssigned_whenNull_field_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(genericEntityDaoImpl.idAssigned(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getEntityManager()}.
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getEntityManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityManager GenericEntityDaoImpl.getEntityManager()",
    "void GenericEntityDaoImpl.setApplicationContext(org.springframework.context.ApplicationContext)"
  })
  public void testGetEntityManager() {
    // Arrange, Act and Assert
    assertNull(new GenericEntityDaoImpl().getEntityManager());
  }

  /**
   * Test {@link GenericEntityDaoImpl#getEntityManager(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getEntityManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager GenericEntityDaoImpl.getEntityManager(Class)"})
  public void testGetEntityManagerWithClass_thenReturnNull() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any())).thenReturn(null);
    Class<Object> clazz = Object.class;

    // Act
    EntityManager actualEntityManager = genericEntityDaoImpl.getEntityManager(clazz);

    // Assert
    verify(persistenceService).identifyEntityManager(isA(Class.class));
    assertNull(actualEntityManager);
  }

  /**
   * Test {@link GenericEntityDaoImpl#getEntityManager(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link GenericEntityDaoImpl#getEntityManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager GenericEntityDaoImpl.getEntityManager(Class)"})
  public void testGetEntityManagerWithClass_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class, () -> genericEntityDaoImpl.getEntityManager(clazz));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
  }
}
