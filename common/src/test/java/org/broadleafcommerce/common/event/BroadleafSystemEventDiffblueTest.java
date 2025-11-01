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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class BroadleafSystemEventDiffblueTest {
  @MockBean
  private BroadleafSystemEvent broadleafSystemEvent;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafSystemEvent#setDetailMap(Map)}
   *   <li>
   * {@link BroadleafSystemEvent#setScopeType(BroadleafSystemEvent.BroadleafEventScopeType)}
   *   <li>{@link BroadleafSystemEvent#setType(String)}
   *   <li>{@link BroadleafSystemEvent#setUniversal(boolean)}
   *   <li>
   * {@link BroadleafSystemEvent#setWorkerType(BroadleafSystemEvent.BroadleafEventWorkerType)}
   *   <li>{@link BroadleafSystemEvent#getDetailMap()}
   *   <li>{@link BroadleafSystemEvent#getScopeType()}
   *   <li>{@link BroadleafSystemEvent#getType()}
   *   <li>{@link BroadleafSystemEvent#getWorkerType()}
   *   <li>{@link BroadleafSystemEvent#isUniversal()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafSystemEvent broadleafSystemEvent = new BroadleafSystemEvent("Type",
        BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, BroadleafSystemEvent.BroadleafEventWorkerType.SITE, true);
    HashMap<String, BroadleafSystemEventDetail> detailMap = new HashMap<>();

    // Act
    broadleafSystemEvent.setDetailMap(detailMap);
    broadleafSystemEvent.setScopeType(BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL);
    broadleafSystemEvent.setType("Type");
    broadleafSystemEvent.setUniversal(true);
    broadleafSystemEvent.setWorkerType(BroadleafSystemEvent.BroadleafEventWorkerType.SITE);
    Map<String, BroadleafSystemEventDetail> actualDetailMap = broadleafSystemEvent.getDetailMap();
    BroadleafSystemEvent.BroadleafEventScopeType actualScopeType = broadleafSystemEvent.getScopeType();
    String actualType = broadleafSystemEvent.getType();
    BroadleafSystemEvent.BroadleafEventWorkerType actualWorkerType = broadleafSystemEvent.getWorkerType();
    boolean actualIsUniversalResult = broadleafSystemEvent.isUniversal();

    // Assert that nothing has changed
    assertEquals("Type", actualType);
    assertEquals(BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, actualScopeType);
    assertEquals(BroadleafSystemEvent.BroadleafEventWorkerType.SITE, actualWorkerType);
    assertTrue(actualDetailMap.isEmpty());
    assertTrue(actualIsUniversalResult);
    assertSame(detailMap, actualDetailMap);
  }

  /**
   * Method under test:
   * {@link BroadleafSystemEvent#BroadleafSystemEvent(String, Map, BroadleafSystemEvent.BroadleafEventScopeType, BroadleafSystemEvent.BroadleafEventWorkerType, boolean)}
   */
  @Test
  public void testNewBroadleafSystemEvent() {
    // Arrange
    HashMap<String, BroadleafSystemEventDetail> detailMap = new HashMap<>();

    // Act
    BroadleafSystemEvent actualBroadleafSystemEvent = new BroadleafSystemEvent("Type", detailMap,
        BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, BroadleafSystemEvent.BroadleafEventWorkerType.SITE, true);

    // Assert
    assertEquals("Type", actualBroadleafSystemEvent.getType());
    assertEquals("Type", actualBroadleafSystemEvent.getSource());
    assertNull(actualBroadleafSystemEvent.getCatalogId());
    assertNull(actualBroadleafSystemEvent.getProfileId());
    assertNull(actualBroadleafSystemEvent.getSiteId());
    assertNull(actualBroadleafSystemEvent.getCurrencyCode());
    assertNull(actualBroadleafSystemEvent.getLocaleCode());
    assertNull(actualBroadleafSystemEvent.getTimeZoneId());
    assertEquals(BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, actualBroadleafSystemEvent.getScopeType());
    assertEquals(BroadleafSystemEvent.BroadleafEventWorkerType.SITE, actualBroadleafSystemEvent.getWorkerType());
    assertTrue(actualBroadleafSystemEvent.getContext().isEmpty());
    Map<String, BroadleafSystemEventDetail> detailMap2 = actualBroadleafSystemEvent.getDetailMap();
    assertTrue(detailMap2.isEmpty());
    assertTrue(actualBroadleafSystemEvent.isUniversal());
    assertSame(detailMap, detailMap2);
  }

  /**
   * Method under test:
   * {@link BroadleafSystemEvent#BroadleafSystemEvent(String, Map, BroadleafSystemEvent.BroadleafEventScopeType, BroadleafSystemEvent.BroadleafEventWorkerType, boolean)}
   */
  @Test
  public void testNewBroadleafSystemEvent2() {
    // Arrange
    HashMap<String, BroadleafSystemEventDetail> detailMap = new HashMap<>();
    detailMap.computeIfPresent("ThreadLocalManager.notify.orphans", mock(BiFunction.class));

    // Act
    BroadleafSystemEvent actualBroadleafSystemEvent = new BroadleafSystemEvent("Type", detailMap,
        BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, BroadleafSystemEvent.BroadleafEventWorkerType.SITE, true);

    // Assert
    assertEquals("Type", actualBroadleafSystemEvent.getType());
    assertEquals("Type", actualBroadleafSystemEvent.getSource());
    assertNull(actualBroadleafSystemEvent.getCatalogId());
    assertNull(actualBroadleafSystemEvent.getProfileId());
    assertNull(actualBroadleafSystemEvent.getSiteId());
    assertNull(actualBroadleafSystemEvent.getCurrencyCode());
    assertNull(actualBroadleafSystemEvent.getLocaleCode());
    assertNull(actualBroadleafSystemEvent.getTimeZoneId());
    assertEquals(BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, actualBroadleafSystemEvent.getScopeType());
    assertEquals(BroadleafSystemEvent.BroadleafEventWorkerType.SITE, actualBroadleafSystemEvent.getWorkerType());
    assertTrue(actualBroadleafSystemEvent.getContext().isEmpty());
    Map<String, BroadleafSystemEventDetail> detailMap2 = actualBroadleafSystemEvent.getDetailMap();
    assertTrue(detailMap2.isEmpty());
    assertTrue(actualBroadleafSystemEvent.isUniversal());
    assertSame(detailMap, detailMap2);
  }

  /**
   * Method under test:
   * {@link BroadleafSystemEvent#BroadleafSystemEvent(String, BroadleafSystemEvent.BroadleafEventScopeType, BroadleafSystemEvent.BroadleafEventWorkerType, boolean)}
   */
  @Test
  public void testNewBroadleafSystemEvent3() {
    // Arrange and Act
    BroadleafSystemEvent actualBroadleafSystemEvent = new BroadleafSystemEvent("Type",
        BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, BroadleafSystemEvent.BroadleafEventWorkerType.SITE, true);

    // Assert
    assertEquals("Type", actualBroadleafSystemEvent.getType());
    assertEquals("Type", actualBroadleafSystemEvent.getSource());
    assertNull(actualBroadleafSystemEvent.getCatalogId());
    assertNull(actualBroadleafSystemEvent.getProfileId());
    assertNull(actualBroadleafSystemEvent.getSiteId());
    assertNull(actualBroadleafSystemEvent.getCurrencyCode());
    assertNull(actualBroadleafSystemEvent.getLocaleCode());
    assertNull(actualBroadleafSystemEvent.getTimeZoneId());
    assertNull(actualBroadleafSystemEvent.getDetailMap());
    assertEquals(BroadleafSystemEvent.BroadleafEventScopeType.GLOBAL, actualBroadleafSystemEvent.getScopeType());
    assertEquals(BroadleafSystemEvent.BroadleafEventWorkerType.SITE, actualBroadleafSystemEvent.getWorkerType());
    assertTrue(actualBroadleafSystemEvent.getContext().isEmpty());
    assertTrue(actualBroadleafSystemEvent.isUniversal());
  }
}
