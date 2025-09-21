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
public class LocaleFieldServiceImplDiffblueTest {
  @InjectMocks private LocaleFieldServiceImpl localeFieldServiceImpl;

  /**
   * Test {@link LocaleFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Given {@link LocaleFieldServiceImpl}.
   *   <li>Then {@link LocaleFieldServiceImpl} Fields size is two.
   * </ul>
   *
   * <p>Method under test: {@link LocaleFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocaleFieldServiceImpl.init()"})
  public void testInit_givenLocaleFieldServiceImpl_thenLocaleFieldServiceImplFieldsSizeIsTwo() {
    // Arrange and Act
    localeFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = localeFieldServiceImpl.getFields();
    assertEquals(2, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("friendlyName", getResult.getFieldName());
    assertEquals("localeCode", getResult2.getFieldName());
    assertEquals("rule_localeCode", getResult2.getFieldLabel());
    assertEquals("rule_localeName", getResult.getFieldLabel());
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
   * Test {@link LocaleFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link LocaleFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocaleFieldServiceImpl.init()"})
  public void testInit_thenLocaleFieldServiceImplFieldsIsArrayList() {
    // Arrange
    LocaleFieldServiceImpl localeFieldServiceImpl = new LocaleFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    localeFieldServiceImpl.setFields(fields);

    // Act
    localeFieldServiceImpl.init();

    // Assert
    assertEquals(fields, localeFieldServiceImpl.getFields());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleFieldServiceImpl#getDtoClassName()}
   *   <li>{@link LocaleFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String LocaleFieldServiceImpl.getDtoClassName()",
    "String LocaleFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LocaleFieldServiceImpl localeFieldServiceImpl = new LocaleFieldServiceImpl();

    // Act
    String actualDtoClassName = localeFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("LOCALE_FIELDS", localeFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.common.locale.domain.LocaleImpl", actualDtoClassName);
  }
}
