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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullAwareLongFilterValueConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullAwareLongFilterValueConverterDiffblueTest {
  @Autowired
  private NullAwareLongFilterValueConverter nullAwareLongFilterValueConverter;

  /**
   * Test {@link NullAwareLongFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareLongFilterValueConverter#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long NullAwareLongFilterValueConverter.convert(String)"})
  public void testConvert_when42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, nullAwareLongFilterValueConverter.convert("42").longValue());
  }

  /**
   * Test {@link NullAwareLongFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareLongFilterValueConverter#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long NullAwareLongFilterValueConverter.convert(String)"})
  public void testConvert_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullAwareLongFilterValueConverter.convert(""));
  }

  /**
   * Test {@link NullAwareLongFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareLongFilterValueConverter#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long NullAwareLongFilterValueConverter.convert(String)"})
  public void testConvert_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullAwareLongFilterValueConverter.convert("null"));
  }

  /**
   * Test {@link NullAwareLongFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareLongFilterValueConverter#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long NullAwareLongFilterValueConverter.convert(String)"})
  public void testConvert_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(nullAwareLongFilterValueConverter.convert(null));
  }

  /**
   * Test {@link NullAwareLongFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code String Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareLongFilterValueConverter#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long NullAwareLongFilterValueConverter.convert(String)"})
  public void testConvert_whenStringValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullAwareLongFilterValueConverter.convert("String Value"));
  }
}
