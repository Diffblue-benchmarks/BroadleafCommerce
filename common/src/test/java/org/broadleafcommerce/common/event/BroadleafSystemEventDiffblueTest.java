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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class BroadleafSystemEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
}
