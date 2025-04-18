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

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityDuplicatorImplDiffblueTest {
  @Mock
  private Collection collection;

  @InjectMocks
  private EntityDuplicatorImpl entityDuplicatorImpl;

  @Mock
  private GenericEntityService genericEntityService;

  /**
   * Test {@link EntityDuplicatorImpl#copy(Class, Long)} with {@code entityClass}, {@code id}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorImpl#copy(Class, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object EntityDuplicatorImpl.copy(Class, Long)"})
  public void testCopyWithEntityClassId_thenThrowIllegalArgumentException() {
    // Arrange
    when(genericEntityService.readGenericEntity(Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(BLCFieldUtils.NULL_FIELD);
    doNothing().when(genericEntityService).clear();
    doNothing().when(genericEntityService).flush();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityDuplicatorImpl.copy(entityClass, 1L));
    verify(genericEntityService).clear();
    verify(genericEntityService).flush();
    verify(genericEntityService).readGenericEntity(isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link EntityDuplicatorImpl#copy(Class, Long)} with {@code entityClass}, {@code id}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDuplicatorImpl#copy(Class, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object EntityDuplicatorImpl.copy(Class, Long)"})
  public void testCopyWithEntityClassId_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException("Entity not valid for duplication - %s:%s")).when(genericEntityService).flush();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityDuplicatorImpl.copy(entityClass, 1L));
    verify(genericEntityService).flush();
  }
}
