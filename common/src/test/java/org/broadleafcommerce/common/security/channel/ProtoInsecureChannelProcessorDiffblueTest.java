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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.servlet.ServletException;
import org.junit.Test;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.channel.RetryWithHttpEntryPoint;

public class ProtoInsecureChannelProcessorDiffblueTest {
  /**
   * Test
   * {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add
   * {@link SecurityConfig#SecurityConfig(String)} with {@code Config}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}
   */
  @Test
  public void testDecide_whenLinkedHashSetAddSecurityConfigWithConfig() throws IOException, ServletException {
    // Arrange
    ProtoInsecureChannelProcessor protoInsecureChannelProcessor = new ProtoInsecureChannelProcessor();

    LinkedHashSet<ConfigAttribute> config = new LinkedHashSet<>();
    config.add(new SecurityConfig("Config"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> protoInsecureChannelProcessor.decide(null, config));
  }

  /**
   * Test
   * {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}
   */
  @Test
  public void testDecide_whenNull_thenThrowIllegalArgumentException() throws IOException, ServletException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ProtoInsecureChannelProcessor()).decide(null, null));
  }

  /**
   * Test
   * {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}
   */
  @Test
  public void testDecide_whenNull_thenThrowIllegalArgumentException2() throws IOException, ServletException {
    // Arrange
    ProtoInsecureChannelProcessor protoInsecureChannelProcessor = new ProtoInsecureChannelProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> protoInsecureChannelProcessor.decide(new FilterInvocation("Servlet Path", "Method"), null));
  }

  /**
   * Test new {@link ProtoInsecureChannelProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProtoInsecureChannelProcessor}
   */
  @Test
  public void testNewProtoInsecureChannelProcessor() {
    // Arrange and Act
    ProtoInsecureChannelProcessor actualProtoInsecureChannelProcessor = new ProtoInsecureChannelProcessor();

    // Assert
    assertTrue(actualProtoInsecureChannelProcessor.getEntryPoint() instanceof RetryWithHttpEntryPoint);
    assertEquals("REQUIRES_INSECURE_CHANNEL", actualProtoInsecureChannelProcessor.getInsecureKeyword());
  }
}
