/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.extension.AbstractAdminSectionCustomCriteriaExtensionHandler;
import org.broadleafcommerce.openadmin.server.service.extension.AdminSectionCustomCriteriaExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminSectionCustomCriteriaServiceImplDiffblueTest {
  @Mock
  private AdminSectionCustomCriteriaExtensionManager adminSectionCustomCriteriaExtensionManager;

  @InjectMocks
  private AdminSectionCustomCriteriaServiceImpl adminSectionCustomCriteriaServiceImpl;

  @Mock
  private Map<String, ArrayList<String>> map;

  /**
   * Test {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(String, String[])"})
  public void testMergeSectionCustomCriteria_thenReturnArrayLengthIsZero() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new ArrayList<>());
    when(adminSectionCustomCriteriaExtensionManager.getProxy())
        .thenReturn(new AbstractAdminSectionCustomCriteriaExtensionHandler());

    // Act
    String[] actualMergeSectionCustomCriteriaResult = adminSectionCustomCriteriaServiceImpl
        .mergeSectionCustomCriteria("Ceiling Entity Class Name", null);

    // Assert
    verify(map).get(isA(Object.class));
    verify(adminSectionCustomCriteriaExtensionManager).getProxy();
    assertEquals(0, actualMergeSectionCustomCriteriaResult.length);
  }

  /**
   * Test {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code Controller Criteria}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(String, String[])"})
  public void testMergeSectionCustomCriteria_thenReturnArrayOfStringWithControllerCriteria() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new ArrayList<>());
    when(adminSectionCustomCriteriaExtensionManager.getProxy())
        .thenReturn(new AbstractAdminSectionCustomCriteriaExtensionHandler());

    // Act
    String[] actualMergeSectionCustomCriteriaResult = adminSectionCustomCriteriaServiceImpl
        .mergeSectionCustomCriteria("Ceiling Entity Class Name", new String[]{"Controller Criteria"});

    // Assert
    verify(map).get(isA(Object.class));
    verify(adminSectionCustomCriteriaExtensionManager).getProxy();
    assertArrayEquals(new String[]{"Controller Criteria"}, actualMergeSectionCustomCriteriaResult);
  }

  /**
   * Test {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code Controller Criteria}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(String, String[])"})
  public void testMergeSectionCustomCriteria_thenReturnArrayOfStringWithControllerCriteria2() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    String[] actualMergeSectionCustomCriteriaResult = adminSectionCustomCriteriaServiceImpl
        .mergeSectionCustomCriteria(null, new String[]{"Controller Criteria"});

    // Assert
    verify(map).get(isNull());
    assertArrayEquals(new String[]{"Controller Criteria"}, actualMergeSectionCustomCriteriaResult);
  }
}
