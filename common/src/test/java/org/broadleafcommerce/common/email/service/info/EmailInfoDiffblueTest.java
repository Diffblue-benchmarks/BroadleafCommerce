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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.email.service.message.Attachment;
import org.junit.Test;

public class EmailInfoDiffblueTest {
  /**
   * Test {@link EmailInfo#addHeader(String, String)}.
   * <ul>
   *   <li>Given {@link EmailInfo} (default constructor).</li>
   *   <li>Then {@link EmailInfo} (default constructor) Headers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailInfo#addHeader(String, String)}
   */
  @Test
  public void testAddHeader_givenEmailInfo_thenEmailInfoHeadersSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailInfo emailInfo = new EmailInfo();

    // Act
    emailInfo.addHeader("Key", "42");

    // Assert
    Map<String, String> headers = emailInfo.getHeaders();
    assertEquals(1, headers.size());
    assertEquals("42", headers.get("Key"));
  }

  /**
   * Test {@link EmailInfo#addHeader(String, String)}.
   * <ul>
   *   <li>Then {@link EmailInfo} (default constructor) Headers is
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailInfo#addHeader(String, String)}
   */
  @Test
  public void testAddHeader_thenEmailInfoHeadersIsHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.computeIfPresent("foo", mock(BiFunction.class));
    headers.put("Delivered-To", "alice.liddell@example.org");

    EmailInfo emailInfo = new EmailInfo();
    emailInfo.setHeaders(headers);

    // Act
    emailInfo.addHeader("Key", "42");

    // Assert
    assertSame(headers, emailInfo.getHeaders());
  }

  /**
   * Test {@link EmailInfo#clone()}.
   * <ul>
   *   <li>Given {@link EmailInfo} (default constructor).</li>
   *   <li>Then return Headers Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailInfo#clone()}
   */
  @Test
  public void testClone_givenEmailInfo_thenReturnHeadersEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EmailInfo actualCloneResult = (new EmailInfo()).clone();

    // Assert
    assertEquals("UTF8", actualCloneResult.getEncoding());
    assertNull(actualCloneResult.getEmailTemplate());
    assertNull(actualCloneResult.getEmailType());
    assertNull(actualCloneResult.getFromAddress());
    assertNull(actualCloneResult.getMessageBody());
    assertNull(actualCloneResult.getSendAsyncPriority());
    assertNull(actualCloneResult.getSendEmailReliableAsync());
    assertNull(actualCloneResult.getSubject());
    assertTrue(actualCloneResult.getAttachments().isEmpty());
    assertTrue(actualCloneResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link EmailInfo#clone()}.
   * <ul>
   *   <li>Then return Headers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailInfo#clone()}
   */
  @Test
  public void testClone_thenReturnHeadersSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.computeIfPresent("foo", mock(BiFunction.class));
    headers.put("Delivered-To", "alice.liddell@example.org");

    EmailInfo emailInfo = new EmailInfo();
    emailInfo.setHeaders(headers);

    // Act
    EmailInfo actualCloneResult = emailInfo.clone();

    // Assert
    assertEquals("UTF8", actualCloneResult.getEncoding());
    Map<String, String> headers2 = actualCloneResult.getHeaders();
    assertEquals(1, headers2.size());
    assertEquals("alice.liddell@example.org", headers2.get("Delivered-To"));
    assertNull(actualCloneResult.getEmailTemplate());
    assertNull(actualCloneResult.getEmailType());
    assertNull(actualCloneResult.getFromAddress());
    assertNull(actualCloneResult.getMessageBody());
    assertNull(actualCloneResult.getSendAsyncPriority());
    assertNull(actualCloneResult.getSendEmailReliableAsync());
    assertNull(actualCloneResult.getSubject());
    assertTrue(actualCloneResult.getAttachments().isEmpty());
    assertSame(headers, headers2);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailInfo}
   *   <li>{@link EmailInfo#setAttachments(List)}
   *   <li>{@link EmailInfo#setEmailTemplate(String)}
   *   <li>{@link EmailInfo#setEmailType(String)}
   *   <li>{@link EmailInfo#setEncoding(String)}
   *   <li>{@link EmailInfo#setFromAddress(String)}
   *   <li>{@link EmailInfo#setHeaders(Map)}
   *   <li>{@link EmailInfo#setMessageBody(String)}
   *   <li>{@link EmailInfo#setSendAsyncPriority(String)}
   *   <li>{@link EmailInfo#setSendEmailReliableAsync(String)}
   *   <li>{@link EmailInfo#setSubject(String)}
   *   <li>{@link EmailInfo#getAttachments()}
   *   <li>{@link EmailInfo#getEmailTemplate()}
   *   <li>{@link EmailInfo#getEmailType()}
   *   <li>{@link EmailInfo#getEncoding()}
   *   <li>{@link EmailInfo#getFromAddress()}
   *   <li>{@link EmailInfo#getHeaders()}
   *   <li>{@link EmailInfo#getMessageBody()}
   *   <li>{@link EmailInfo#getSendAsyncPriority()}
   *   <li>{@link EmailInfo#getSendEmailReliableAsync()}
   *   <li>{@link EmailInfo#getSubject()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailInfo actualEmailInfo = new EmailInfo();
    ArrayList<Attachment> attachments = new ArrayList<>();
    actualEmailInfo.setAttachments(attachments);
    actualEmailInfo.setEmailTemplate("jane.doe@example.org");
    actualEmailInfo.setEmailType("jane.doe@example.org");
    actualEmailInfo.setEncoding("UTF-8");
    actualEmailInfo.setFromAddress("42 Main St");
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");
    actualEmailInfo.setHeaders(headers);
    actualEmailInfo.setMessageBody("Not all who wander are lost");
    actualEmailInfo.setSendAsyncPriority("Send Async Priority");
    actualEmailInfo.setSendEmailReliableAsync("jane.doe@example.org");
    actualEmailInfo.setSubject("Hello from the Dreaming Spires");
    List<Attachment> actualAttachments = actualEmailInfo.getAttachments();
    String actualEmailTemplate = actualEmailInfo.getEmailTemplate();
    String actualEmailType = actualEmailInfo.getEmailType();
    String actualEncoding = actualEmailInfo.getEncoding();
    String actualFromAddress = actualEmailInfo.getFromAddress();
    Map<String, String> actualHeaders = actualEmailInfo.getHeaders();
    String actualMessageBody = actualEmailInfo.getMessageBody();
    String actualSendAsyncPriority = actualEmailInfo.getSendAsyncPriority();
    String actualSendEmailReliableAsync = actualEmailInfo.getSendEmailReliableAsync();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualFromAddress);
    assertEquals("Hello from the Dreaming Spires", actualEmailInfo.getSubject());
    assertEquals("Not all who wander are lost", actualMessageBody);
    assertEquals("Send Async Priority", actualSendAsyncPriority);
    assertEquals("UTF-8", actualEncoding);
    assertEquals(1, actualHeaders.size());
    assertEquals("alice.liddell@example.org", actualHeaders.get("Delivered-To"));
    assertEquals("jane.doe@example.org", actualEmailTemplate);
    assertEquals("jane.doe@example.org", actualEmailType);
    assertEquals("jane.doe@example.org", actualSendEmailReliableAsync);
    assertTrue(actualAttachments.isEmpty());
    assertSame(attachments, actualAttachments);
    assertSame(headers, actualHeaders);
  }
}
