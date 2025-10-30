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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.dao.GenericEntityDao;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GenericEntityServiceImplDiffblueTest {
  @Mock
  private GenericEntityDao genericEntityDao;

  @InjectMocks
  private GenericEntityServiceImpl genericEntityServiceImpl;

  /**
   * Test {@link GenericEntityServiceImpl#readGenericEntity(String, Object)} with {@code className}, {@code id}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#readGenericEntity(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GenericEntityServiceImpl.readGenericEntity(String, Object)"})
  public void testReadGenericEntityWithClassNameId() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(genericEntityDao.readGenericEntity(Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(BLCFieldUtils.NULL_FIELD);
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualReadGenericEntityResult = genericEntityServiceImpl.readGenericEntity("Class Name", object);

    // Assert
    verify(genericEntityDao).getImplClass(eq("Class Name"));
    verify(genericEntityDao).readGenericEntity(isA(Class.class), isA(Object.class));
    assertSame(object, actualReadGenericEntityResult);
  }

  /**
   * Test {@link GenericEntityServiceImpl#readGenericEntity(Class, Object)} with {@code clazz}, {@code id}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#readGenericEntity(Class, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GenericEntityServiceImpl.readGenericEntity(Class, Object)"})
  public void testReadGenericEntityWithClazzId() {
    // Arrange
    when(genericEntityDao.readGenericEntity(Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(BLCFieldUtils.NULL_FIELD);
    Class<Object> clazz = Object.class;
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualReadGenericEntityResult = genericEntityServiceImpl.readGenericEntity(clazz, object);

    // Assert
    verify(genericEntityDao).readGenericEntity(isA(Class.class), isA(Object.class));
    assertSame(object, actualReadGenericEntityResult);
  }

  /**
   * Test {@link GenericEntityServiceImpl#save(Object)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#save(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GenericEntityServiceImpl.save(Object)"})
  public void testSave() {
    // Arrange
    when(genericEntityDao.save(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualSaveResult = genericEntityServiceImpl.save(object);

    // Assert
    verify(genericEntityDao).save(isA(Object.class));
    assertSame(object, actualSaveResult);
  }

  /**
   * Test {@link GenericEntityServiceImpl#persist(Object)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#persist(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenericEntityServiceImpl.persist(Object)"})
  public void testPersist() {
    // Arrange
    doNothing().when(genericEntityDao).persist(Mockito.<Object>any());

    // Act
    genericEntityServiceImpl.persist(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityDao).persist(isA(Object.class));
  }

  /**
   * Test {@link GenericEntityServiceImpl#readCountGenericEntity(Class)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#readCountGenericEntity(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long GenericEntityServiceImpl.readCountGenericEntity(Class)"})
  public void testReadCountGenericEntity() {
    // Arrange
    when(genericEntityDao.readCountGenericEntity(Mockito.<Class<Object>>any())).thenReturn(3L);
    Class<Object> clazz = Object.class;

    // Act
    Long actualReadCountGenericEntityResult = genericEntityServiceImpl.readCountGenericEntity(clazz);

    // Assert
    verify(genericEntityDao).readCountGenericEntity(isA(Class.class));
    assertEquals(3L, actualReadCountGenericEntityResult.longValue());
  }

  /**
   * Test {@link GenericEntityServiceImpl#readAllGenericEntity(Class, int, int)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#readAllGenericEntity(Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List GenericEntityServiceImpl.readAllGenericEntity(Class, int, int)"})
  public void testReadAllGenericEntity() {
    // Arrange
    when(genericEntityDao.readAllGenericEntity(Mockito.<Class<Object>>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());
    Class<Object> clazz = Object.class;

    // Act
    List<Object> actualReadAllGenericEntityResult = genericEntityServiceImpl.readAllGenericEntity(clazz, 1, 2);

    // Assert
    verify(genericEntityDao).readAllGenericEntity(isA(Class.class), eq(1), eq(2));
    assertTrue(actualReadAllGenericEntityResult.isEmpty());
  }

  /**
   * Test {@link GenericEntityServiceImpl#readAllGenericEntityId(Class)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#readAllGenericEntityId(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List GenericEntityServiceImpl.readAllGenericEntityId(Class)"})
  public void testReadAllGenericEntityId() {
    // Arrange
    when(genericEntityDao.readAllGenericEntityId(Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    Class<Object> clazz = Object.class;

    // Act
    List<Long> actualReadAllGenericEntityIdResult = genericEntityServiceImpl.readAllGenericEntityId(clazz);

    // Assert
    verify(genericEntityDao).readAllGenericEntityId(isA(Class.class));
    assertTrue(actualReadAllGenericEntityIdResult.isEmpty());
  }

  /**
   * Test {@link GenericEntityServiceImpl#getIdentifier(Object)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#getIdentifier(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Serializable GenericEntityServiceImpl.getIdentifier(Object)"})
  public void testGetIdentifier() {
    // Arrange
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    when(genericEntityDao.getIdentifier(Mockito.<Object>any())).thenReturn(simpleDateFormat);

    // Act
    Serializable actualIdentifier = genericEntityServiceImpl.getIdentifier(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityDao).getIdentifier(isA(Object.class));
    assertSame(simpleDateFormat, actualIdentifier);
  }

  /**
   * Test {@link GenericEntityServiceImpl#flush()}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#clearAutoFlushMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#enableAutoFlushMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#clear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link GenericEntityServiceImpl#sessionContains(Object)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#sessionContains(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GenericEntityServiceImpl.sessionContains(Object)"})
  public void testSessionContains_thenReturnFalse() {
    // Arrange
    when(genericEntityDao.sessionContains(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualSessionContainsResult = genericEntityServiceImpl.sessionContains(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityDao).sessionContains(isA(Object.class));
    assertFalse(actualSessionContainsResult);
  }

  /**
   * Test {@link GenericEntityServiceImpl#sessionContains(Object)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#sessionContains(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GenericEntityServiceImpl.sessionContains(Object)"})
  public void testSessionContains_thenReturnTrue() {
    // Arrange
    when(genericEntityDao.sessionContains(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualSessionContainsResult = genericEntityServiceImpl.sessionContains(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityDao).sessionContains(isA(Object.class));
    assertTrue(actualSessionContainsResult);
  }

  /**
   * Test {@link GenericEntityServiceImpl#getCeilingImplClass(String)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class GenericEntityServiceImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityDao.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);

    // Act
    Class<?> actualCeilingImplClass = genericEntityServiceImpl.getCeilingImplClass("Class Name");

    // Assert
    verify(genericEntityDao).getCeilingImplClass(eq("Class Name"));
    Class<Object> expectedCeilingImplClass = Object.class;
    assertEquals(expectedCeilingImplClass, actualCeilingImplClass);
  }

  /**
   * Test {@link GenericEntityServiceImpl#idAssigned(Object)}.
   * <ul>
   *   <li>Given {@link GenericEntityDao} {@link GenericEntityDao#idAssigned(Object)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#idAssigned(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GenericEntityServiceImpl.idAssigned(Object)"})
  public void testIdAssigned_givenGenericEntityDaoIdAssignedReturnFalse_thenReturnFalse() {
    // Arrange
    when(genericEntityDao.idAssigned(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualIdAssignedResult = genericEntityServiceImpl.idAssigned(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityDao).idAssigned(isA(Object.class));
    assertFalse(actualIdAssignedResult);
  }

  /**
   * Test {@link GenericEntityServiceImpl#idAssigned(Object)}.
   * <ul>
   *   <li>Given {@link GenericEntityDao} {@link GenericEntityDao#idAssigned(Object)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#idAssigned(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GenericEntityServiceImpl.idAssigned(Object)"})
  public void testIdAssigned_givenGenericEntityDaoIdAssignedReturnTrue_thenReturnTrue() {
    // Arrange
    when(genericEntityDao.idAssigned(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualIdAssignedResult = genericEntityServiceImpl.idAssigned(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityDao).idAssigned(isA(Object.class));
    assertTrue(actualIdAssignedResult);
  }

  /**
   * Test {@link GenericEntityServiceImpl#getEntityManager()}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#getEntityManager()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

  /**
   * Test {@link GenericEntityServiceImpl#remove(Object)}.
   * <p>
   * Method under test: {@link GenericEntityServiceImpl#remove(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenericEntityServiceImpl.remove(Object)"})
  public void testRemove() {
    // Arrange
    doNothing().when(genericEntityDao).remove(Mockito.<Object>any());

    // Act
    genericEntityServiceImpl.remove(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityDao).remove(isA(Object.class));
  }
}
