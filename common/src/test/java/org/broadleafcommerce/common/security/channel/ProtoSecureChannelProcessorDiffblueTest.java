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
package org.broadleafcommerce.common.security.channel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.security.web.access.channel.RetryWithHttpsEntryPoint;

public class ProtoSecureChannelProcessorDiffblueTest {
  /**
   * Test new {@link ProtoSecureChannelProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProtoSecureChannelProcessor}
   */
  @Test
  public void testNewProtoSecureChannelProcessor() {
    // Arrange and Act
    ProtoSecureChannelProcessor actualProtoSecureChannelProcessor = new ProtoSecureChannelProcessor();

    // Assert
    assertTrue(actualProtoSecureChannelProcessor.getEntryPoint() instanceof RetryWithHttpsEntryPoint);
    assertEquals("REQUIRES_SECURE_CHANNEL", actualProtoSecureChannelProcessor.getSecureKeyword());
  }
}