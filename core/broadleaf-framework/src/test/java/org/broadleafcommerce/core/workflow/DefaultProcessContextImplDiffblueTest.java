/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.service.call.ActivityMessageDTO;
import org.junit.Test;

public class DefaultProcessContextImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultProcessContextImpl}
   *   <li>{@link DefaultProcessContextImpl#setActivityMessages(List)}
   *   <li>{@link DefaultProcessContextImpl#setSeedData(Object)}
   *   <li>{@link DefaultProcessContextImpl#stopProcess()}
   *   <li>{@link DefaultProcessContextImpl#getActivityMessages()}
   *   <li>{@link DefaultProcessContextImpl#getSeedData()}
   *   <li>{@link DefaultProcessContextImpl#isStopped()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DefaultProcessContextImpl<Object> actualDefaultProcessContextImpl = new DefaultProcessContextImpl<>();
    ArrayList<ActivityMessageDTO> activityMessages = new ArrayList<>();
    actualDefaultProcessContextImpl.setActivityMessages(activityMessages);
    actualDefaultProcessContextImpl.setSeedData("Seed Object");
    boolean actualStopProcessResult = actualDefaultProcessContextImpl.stopProcess();
    List<ActivityMessageDTO> actualActivityMessages = actualDefaultProcessContextImpl.getActivityMessages();
    Object actualSeedData = actualDefaultProcessContextImpl.getSeedData();
    boolean actualIsStoppedResult = actualDefaultProcessContextImpl.isStopped();

    // Assert that nothing has changed
    assertEquals("Seed Object", actualSeedData);
    assertTrue(actualActivityMessages.isEmpty());
    assertTrue(actualIsStoppedResult);
    assertTrue(actualStopProcessResult);
    assertSame(activityMessages, actualActivityMessages);
  }
}
