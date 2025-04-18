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
package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.util.dao.CodeTypeDao;
import org.broadleafcommerce.core.util.domain.CodeType;
import org.broadleafcommerce.core.util.domain.CodeTypeImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CodeTypeServiceImplDiffblueTest {
  @Mock
  private CodeTypeDao codeTypeDao;

  @InjectMocks
  private CodeTypeServiceImpl codeTypeServiceImpl;

  /**
   * Test {@link CodeTypeServiceImpl#deleteCodeType(CodeType)}.
   * <p>
   * Method under test: {@link CodeTypeServiceImpl#deleteCodeType(CodeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeTypeServiceImpl.deleteCodeType(CodeType)"})
  public void testDeleteCodeType() {
    // Arrange
    doNothing().when(codeTypeDao).delete(Mockito.<CodeType>any());

    // Act
    codeTypeServiceImpl.deleteCodeType(new CodeTypeImpl());

    // Assert
    verify(codeTypeDao).delete(isA(CodeType.class));
  }

  /**
   * Test {@link CodeTypeServiceImpl#findAllCodeTypes()}.
   * <p>
   * Method under test: {@link CodeTypeServiceImpl#findAllCodeTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CodeTypeServiceImpl.findAllCodeTypes()"})
  public void testFindAllCodeTypes() {
    // Arrange
    when(codeTypeDao.readAllCodeTypes()).thenReturn(new ArrayList<>());

    // Act
    List<CodeType> actualFindAllCodeTypesResult = codeTypeServiceImpl.findAllCodeTypes();

    // Assert
    verify(codeTypeDao).readAllCodeTypes();
    assertTrue(actualFindAllCodeTypesResult.isEmpty());
  }

  /**
   * Test {@link CodeTypeServiceImpl#lookupCodeTypeById(Long)}.
   * <p>
   * Method under test: {@link CodeTypeServiceImpl#lookupCodeTypeById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CodeType CodeTypeServiceImpl.lookupCodeTypeById(Long)"})
  public void testLookupCodeTypeById() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    when(codeTypeDao.readCodeTypeById(Mockito.<Long>any())).thenReturn(codeTypeImpl);

    // Act
    CodeType actualLookupCodeTypeByIdResult = codeTypeServiceImpl.lookupCodeTypeById(1L);

    // Assert
    verify(codeTypeDao).readCodeTypeById(eq(1L));
    assertSame(codeTypeImpl, actualLookupCodeTypeByIdResult);
  }

  /**
   * Test {@link CodeTypeServiceImpl#lookupCodeTypeByKey(String)}.
   * <p>
   * Method under test: {@link CodeTypeServiceImpl#lookupCodeTypeByKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CodeTypeServiceImpl.lookupCodeTypeByKey(String)"})
  public void testLookupCodeTypeByKey() {
    // Arrange
    when(codeTypeDao.readCodeTypeByKey(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<CodeType> actualLookupCodeTypeByKeyResult = codeTypeServiceImpl.lookupCodeTypeByKey("Key");

    // Assert
    verify(codeTypeDao).readCodeTypeByKey(eq("Key"));
    assertTrue(actualLookupCodeTypeByKeyResult.isEmpty());
  }

  /**
   * Test {@link CodeTypeServiceImpl#save(CodeType)}.
   * <p>
   * Method under test: {@link CodeTypeServiceImpl#save(CodeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CodeType CodeTypeServiceImpl.save(CodeType)"})
  public void testSave() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    when(codeTypeDao.save(Mockito.<CodeType>any())).thenReturn(codeTypeImpl);

    // Act
    CodeType actualSaveResult = codeTypeServiceImpl.save(new CodeTypeImpl());

    // Assert
    verify(codeTypeDao).save(isA(CodeType.class));
    assertSame(codeTypeImpl, actualSaveResult);
  }
}
