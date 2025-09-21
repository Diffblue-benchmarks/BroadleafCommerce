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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DecimalFilterValueConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DecimalFilterValueConverterDiffblueTest {
  @Autowired private DecimalFilterValueConverter decimalFilterValueConverter;

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal DecimalFilterValueConverter.convert(String)"})
  public void testConvert_when42_thenReturnBigDecimalWith42() {
    // Arrange and Act
    BigDecimal actualConvertResult = decimalFilterValueConverter.convert("42");

    // Assert
    assertEquals(new BigDecimal("42"), actualConvertResult);
  }

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal DecimalFilterValueConverter.convert(String)"})
  public void testConvert_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(decimalFilterValueConverter.convert(""));
  }

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal DecimalFilterValueConverter.convert(String)"})
  public void testConvert_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(decimalFilterValueConverter.convert(null));
  }

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code String Value}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal DecimalFilterValueConverter.convert(String)"})
  public void testConvert_whenStringValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(decimalFilterValueConverter.convert("String Value"));
  }
}
