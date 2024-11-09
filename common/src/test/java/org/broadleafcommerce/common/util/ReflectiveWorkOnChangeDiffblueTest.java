/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class ReflectiveWorkOnChangeDiffblueTest {
  /**
   * Test {@link ReflectiveWorkOnChange#doWork(Collection)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReflectiveWorkOnChange#doWork(Collection)}
   */
  @Test
  public void testDoWork_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange = new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");

    ArrayList<Object> changed = new ArrayList<>();
    changed.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> reflectiveWorkOnChange.doWork(changed));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#doWork(Collection)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReflectiveWorkOnChange#doWork(Collection)}
   */
  @Test
  public void testDoWork_givenNull_field_whenArrayListAddNull_field2() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange = new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");

    ArrayList<Object> changed = new ArrayList<>();
    changed.add(BLCFieldUtils.NULL_FIELD);
    changed.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> reflectiveWorkOnChange.doWork(changed));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#doWork(Collection)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReflectiveWorkOnChange#doWork(Collection)}
   */
  @Test
  public void testDoWork_thenThrowIllegalArgumentException() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange = new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> reflectiveWorkOnChange.doWork(new ArrayList<>()));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}
   */
  @Test
  public void testSearchForMethod_whenNull_field_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange = new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertNull(reflectiveWorkOnChange.searchForMethod(targetClass, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}
   */
  @Test
  public void testSearchForMethod_whenOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange = new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertNull(reflectiveWorkOnChange.searchForMethod(targetClass, 1));
  }
}
