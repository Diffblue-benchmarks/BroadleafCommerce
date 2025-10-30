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
package org.broadleafcommerce.common.id.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.id.dao.IdGenerationDao;
import org.broadleafcommerce.common.id.domain.IdGeneration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdGenerationServiceImplDiffblueTest {
  @Mock
  private IdGenerationDao idGenerationDao;

  @InjectMocks
  private IdGenerationServiceImpl idGenerationServiceImpl;

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String, Long)} with {@code idType}, {@code batchSize}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationServiceImpl#findNextId(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String, Long)"})
  public void testFindNextIdWithIdTypeBatchSize_thenThrowRuntimeException() throws Exception {
    // Arrange
    IdGeneration idGeneration = mock(IdGeneration.class);
    when(idGeneration.getBatchStart()).thenThrow(new RuntimeException("foo"));
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(idGeneration);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> idGenerationServiceImpl.findNextId("Id Type", 3L));
    verify(idGenerationDao).findNextId(eq("Id Type"), eq(3L));
    verify(idGeneration).getBatchStart();
  }

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String)} with {@code idType}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationServiceImpl#findNextId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String)"})
  public void testFindNextIdWithIdType_thenThrowRuntimeException() throws Exception {
    // Arrange
    IdGeneration idGeneration = mock(IdGeneration.class);
    when(idGeneration.getBatchStart()).thenThrow(new RuntimeException("foo"));
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(idGeneration);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> idGenerationServiceImpl.findNextId("Id Type"));
    verify(idGenerationDao).findNextId(eq("Id Type"), isNull());
    verify(idGeneration).getBatchStart();
  }
}
