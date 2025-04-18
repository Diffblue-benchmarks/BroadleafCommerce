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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class GenericEntityDaoImplDiffblueTest {
  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private GenericEntityDaoImpl genericEntityDaoImpl;

  @Mock
  private PersistenceService persistenceService;

  /**
   * Test {@link GenericEntityDaoImpl#getImplClass(String)}.
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> genericEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Given Bean Name{blEntityConfiguration} {@link EntityConfiguration#lookupEntityClass(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_givenBeanNameBlEntityConfigurationLookupEntityClassReturnNull() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> genericEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_givenJavaLangObject_whenClassName_thenReturnObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);

    // Act
    Class<?> actualImplClass = genericEntityDaoImpl.getImplClass("Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
    Class<Object> expectedImplClass = Object.class;
    assertEquals(expectedImplClass, actualImplClass);
  }

  /**
   * Test {@link GenericEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> genericEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getCeilingImplClass(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class GenericEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass_whenClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> genericEntityDaoImpl.getCeilingImplClass("Class Name"));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getIdentifier(Object)}.
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getIdentifier(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.Serializable GenericEntityDaoImpl.getIdentifier(Object)"})
  public void testGetIdentifier() {
    // Arrange, Act and Assert
    assertNull(genericEntityDaoImpl.getIdentifier(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link GenericEntityDaoImpl#idAssigned(Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#idAssigned(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GenericEntityDaoImpl.idAssigned(Object)"})
  public void testIdAssigned_whenNull_field_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(genericEntityDaoImpl.idAssigned(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link GenericEntityDaoImpl#getEntityManager(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getEntityManager(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityDaoImpl#getEntityManager(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityManager GenericEntityDaoImpl.getEntityManager(Class)"})
  public void testGetEntityManagerWithClass_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(persistenceService.identifyEntityManager(Mockito.<Class<Object>>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class, () -> genericEntityDaoImpl.getEntityManager(clazz));
    verify(persistenceService).identifyEntityManager(isA(Class.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GenericEntityDaoImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link GenericEntityDaoImpl#getEntityManager()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityManager GenericEntityDaoImpl.getEntityManager()",
      "void GenericEntityDaoImpl.setApplicationContext(ApplicationContext)"})
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    GenericEntityDaoImpl genericEntityDaoImpl = new GenericEntityDaoImpl();

    // Act
    genericEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    assertNull(genericEntityDaoImpl.getEntityManager());
  }
}
