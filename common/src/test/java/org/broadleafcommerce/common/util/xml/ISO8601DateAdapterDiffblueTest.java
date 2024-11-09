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
package org.broadleafcommerce.common.util.xml;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class ISO8601DateAdapterDiffblueTest {
  /**
   * Test {@link ISO8601DateAdapter#marshal(Date)} with {@code Date}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISO8601DateAdapter#marshal(java.util.Date)}
   */
  @Test
  public void testMarshalWithDate_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() throws Exception {
    // Arrange
    ISO8601DateAdapter iso8601DateAdapter = new ISO8601DateAdapter();
    java.sql.Date arg0 = mock(java.sql.Date.class);
    when(arg0.getTime()).thenReturn(10L);

    // Act
    iso8601DateAdapter.marshal(arg0);

    // Assert
    verify(arg0).getTime();
  }
}
