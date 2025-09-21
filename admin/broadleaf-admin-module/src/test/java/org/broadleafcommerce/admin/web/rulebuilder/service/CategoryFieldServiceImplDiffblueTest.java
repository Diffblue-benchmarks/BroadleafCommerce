/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CategoryFieldServiceImplDiffblueTest {
  @InjectMocks private CategoryFieldServiceImpl categoryFieldServiceImpl;

  /**
   * Test {@link CategoryFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link CategoryFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryFieldServiceImpl.init()"})
  public void testInit_thenCategoryFieldServiceImplFieldsIsArrayList() {
    // Arrange
    CategoryFieldServiceImpl categoryFieldServiceImpl = new CategoryFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    categoryFieldServiceImpl.setFields(fields);

    // Act
    categoryFieldServiceImpl.init();

    // Assert
    assertEquals(fields, categoryFieldServiceImpl.getFields());
  }

  /**
   * Test {@link CategoryFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link CategoryFieldServiceImpl} Fields size is two.
   * </ul>
   *
   * <p>Method under test: {@link CategoryFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryFieldServiceImpl.init()"})
  public void testInit_thenCategoryFieldServiceImplFieldsSizeIsTwo() {
    // Arrange and Act
    categoryFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = categoryFieldServiceImpl.getFields();
    assertEquals(2, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("name", getResult.getFieldName());
    assertEquals("rule_categoryName", getResult.getFieldLabel());
    assertEquals("rule_categoryUrl", getResult2.getFieldLabel());
    assertEquals("url", getResult2.getFieldName());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult2.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryFieldServiceImpl#getDtoClassName()}
   *   <li>{@link CategoryFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CategoryFieldServiceImpl.getDtoClassName()",
    "String CategoryFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CategoryFieldServiceImpl categoryFieldServiceImpl = new CategoryFieldServiceImpl();

    // Act
    String actualDtoClassName = categoryFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("CATEGORY_FIELDS", categoryFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.catalog.domain.CategoryImpl", actualDtoClassName);
  }
}
