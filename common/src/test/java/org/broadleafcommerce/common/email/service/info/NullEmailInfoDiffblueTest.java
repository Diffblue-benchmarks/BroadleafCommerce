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
package org.broadleafcommerce.common.email.service.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Test;

public class NullEmailInfoDiffblueTest {
  /**
   * Test {@link NullEmailInfo#NullEmailInfo()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link NullEmailInfo}
   */
  @Test
  public void testNewNullEmailInfo() throws IOException {
    // Arrange and Act
    NullEmailInfo actualNullEmailInfo = new NullEmailInfo();

    // Assert
    assertEquals("UTF8", actualNullEmailInfo.getEncoding());
    assertNull(actualNullEmailInfo.getEmailTemplate());
    assertNull(actualNullEmailInfo.getEmailType());
    assertNull(actualNullEmailInfo.getFromAddress());
    assertNull(actualNullEmailInfo.getMessageBody());
    assertNull(actualNullEmailInfo.getSendAsyncPriority());
    assertNull(actualNullEmailInfo.getSendEmailReliableAsync());
    assertNull(actualNullEmailInfo.getSubject());
    assertTrue(actualNullEmailInfo.getAttachments().isEmpty());
    assertTrue(actualNullEmailInfo.getHeaders().isEmpty());
  }
}
