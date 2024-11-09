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
package org.broadleafcommerce.common.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SandBoxHelperDiffblueTest {
  /**
   * Test OriginalIdResponse getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SandBoxHelper.OriginalIdResponse}
   *   <li>{@link SandBoxHelper.OriginalIdResponse#setOriginalId(Long)}
   *   <li>{@link SandBoxHelper.OriginalIdResponse#setRecordFound(boolean)}
   *   <li>{@link SandBoxHelper.OriginalIdResponse#getOriginalId()}
   *   <li>{@link SandBoxHelper.OriginalIdResponse#isRecordFound()}
   * </ul>
   */
  @Test
  public void testOriginalIdResponseGettersAndSetters() {
    // Arrange and Act
    SandBoxHelper.OriginalIdResponse actualOriginalIdResponse = new SandBoxHelper.OriginalIdResponse();
    actualOriginalIdResponse.setOriginalId(1L);
    actualOriginalIdResponse.setRecordFound(true);
    Long actualOriginalId = actualOriginalIdResponse.getOriginalId();
    boolean actualIsRecordFoundResult = actualOriginalIdResponse.isRecordFound();

    // Assert that nothing has changed
    assertEquals(1L, actualOriginalId.longValue());
    assertTrue(actualIsRecordFoundResult);
  }
}
