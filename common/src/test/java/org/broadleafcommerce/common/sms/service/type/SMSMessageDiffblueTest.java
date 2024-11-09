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
package org.broadleafcommerce.common.sms.service.type;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SMSMessageDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SMSMessage#SMSMessage()}
   *   <li>{@link SMSMessage#setBody(String)}
   *   <li>{@link SMSMessage#setFrom(String)}
   *   <li>{@link SMSMessage#setMediaUrl(String)}
   *   <li>{@link SMSMessage#setTo(String)}
   *   <li>{@link SMSMessage#getBody()}
   *   <li>{@link SMSMessage#getFrom()}
   *   <li>{@link SMSMessage#getMediaUrl()}
   *   <li>{@link SMSMessage#getTo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SMSMessage actualSmsMessage = new SMSMessage();
    actualSmsMessage.setBody("Not all who wander are lost");
    actualSmsMessage.setFrom("jane.doe@example.org");
    actualSmsMessage.setMediaUrl("https://example.org/example");
    actualSmsMessage.setTo("alice.liddell@example.org");
    String actualBody = actualSmsMessage.getBody();
    String actualFrom = actualSmsMessage.getFrom();
    String actualMediaUrl = actualSmsMessage.getMediaUrl();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("alice.liddell@example.org", actualSmsMessage.getTo());
    assertEquals("https://example.org/example", actualMediaUrl);
    assertEquals("jane.doe@example.org", actualFrom);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code alice.liddell@example.org}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SMSMessage#SMSMessage(String, String, String)}
   *   <li>{@link SMSMessage#setBody(String)}
   *   <li>{@link SMSMessage#setFrom(String)}
   *   <li>{@link SMSMessage#setMediaUrl(String)}
   *   <li>{@link SMSMessage#setTo(String)}
   *   <li>{@link SMSMessage#getBody()}
   *   <li>{@link SMSMessage#getFrom()}
   *   <li>{@link SMSMessage#getMediaUrl()}
   *   <li>{@link SMSMessage#getTo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenAliceLiddellExampleOrg() {
    // Arrange and Act
    SMSMessage actualSmsMessage = new SMSMessage("alice.liddell@example.org", "jane.doe@example.org",
        "Not all who wander are lost");
    actualSmsMessage.setBody("Not all who wander are lost");
    actualSmsMessage.setFrom("jane.doe@example.org");
    actualSmsMessage.setMediaUrl("https://example.org/example");
    actualSmsMessage.setTo("alice.liddell@example.org");
    String actualBody = actualSmsMessage.getBody();
    String actualFrom = actualSmsMessage.getFrom();
    String actualMediaUrl = actualSmsMessage.getMediaUrl();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("alice.liddell@example.org", actualSmsMessage.getTo());
    assertEquals("https://example.org/example", actualMediaUrl);
    assertEquals("jane.doe@example.org", actualFrom);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SMSMessage#SMSMessage(String, String, String, String)}
   *   <li>{@link SMSMessage#setBody(String)}
   *   <li>{@link SMSMessage#setFrom(String)}
   *   <li>{@link SMSMessage#setMediaUrl(String)}
   *   <li>{@link SMSMessage#setTo(String)}
   *   <li>{@link SMSMessage#getBody()}
   *   <li>{@link SMSMessage#getFrom()}
   *   <li>{@link SMSMessage#getMediaUrl()}
   *   <li>{@link SMSMessage#getTo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenHttpsExampleOrgExample() {
    // Arrange and Act
    SMSMessage actualSmsMessage = new SMSMessage("alice.liddell@example.org", "jane.doe@example.org",
        "Not all who wander are lost", "https://example.org/example");
    actualSmsMessage.setBody("Not all who wander are lost");
    actualSmsMessage.setFrom("jane.doe@example.org");
    actualSmsMessage.setMediaUrl("https://example.org/example");
    actualSmsMessage.setTo("alice.liddell@example.org");
    String actualBody = actualSmsMessage.getBody();
    String actualFrom = actualSmsMessage.getFrom();
    String actualMediaUrl = actualSmsMessage.getMediaUrl();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("alice.liddell@example.org", actualSmsMessage.getTo());
    assertEquals("https://example.org/example", actualMediaUrl);
    assertEquals("jane.doe@example.org", actualFrom);
  }
}
