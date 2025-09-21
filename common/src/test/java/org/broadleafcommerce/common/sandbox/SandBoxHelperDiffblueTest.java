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
package org.broadleafcommerce.common.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SandBoxHelperDiffblueTest {
  /**
   * Test OriginalIdResponse getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OriginalIdResponse}
   *   <li>{@link OriginalIdResponse#setOriginalId(Long)}
   *   <li>{@link OriginalIdResponse#setRecordFound(boolean)}
   *   <li>{@link OriginalIdResponse#getOriginalId()}
   *   <li>{@link OriginalIdResponse#isRecordFound()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OriginalIdResponse.<init>()",
    "Long OriginalIdResponse.getOriginalId()",
    "boolean OriginalIdResponse.isRecordFound()",
    "void OriginalIdResponse.setOriginalId(Long)",
    "void OriginalIdResponse.setRecordFound(boolean)"
  })
  public void testOriginalIdResponseGettersAndSetters() {
    // Arrange and Act
    OriginalIdResponse actualOriginalIdResponse = new OriginalIdResponse();
    actualOriginalIdResponse.setOriginalId(1L);
    actualOriginalIdResponse.setRecordFound(true);
    Long actualOriginalId = actualOriginalIdResponse.getOriginalId();
    boolean actualIsRecordFoundResult = actualOriginalIdResponse.isRecordFound();

    // Assert
    assertEquals(1L, actualOriginalId.longValue());
    assertTrue(actualIsRecordFoundResult);
  }
}
