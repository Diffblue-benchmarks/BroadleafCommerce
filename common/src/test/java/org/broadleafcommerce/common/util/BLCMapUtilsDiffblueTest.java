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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class BLCMapUtilsDiffblueTest {
  /**
   * Test {@link BLCMapUtils#valueSortedMap(Map, Comparator)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMapUtils#valueSortedMap(Map, Comparator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map BLCMapUtils.valueSortedMap(Map, Comparator)"})
  public void testValueSortedMap_givenNull_field_thenReturnHashMap() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    map.put(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD);
    Comparator<Entry<Object, Object>> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Entry<Object, Object>>any(), Mockito.<Entry<Object, Object>>any())).thenReturn(1);

    // Act
    Map<Object, Object> actualValueSortedMapResult = BLCMapUtils.valueSortedMap(map, comparator);

    // Assert
    verify(comparator).compare(isA(Entry.class), isA(Entry.class));
    assertEquals(map, actualValueSortedMapResult);
  }

  /**
   * Test {@link BLCMapUtils#valueSortedMap(Map, Comparator)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMapUtils#valueSortedMap(Map, Comparator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map BLCMapUtils.valueSortedMap(Map, Comparator)"})
  public void testValueSortedMap_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualValueSortedMapResult = BLCMapUtils.valueSortedMap(new HashMap<>(),
        mock(Comparator.class));

    // Assert
    assertTrue(actualValueSortedMapResult.isEmpty());
  }
}
