package org.broadleafcommerce.common.email.service.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.email.service.message.Attachment;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/context/config/client-override.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailInfoDiffblueTest {
  @Autowired private EmailInfo emailInfo;

  /**
   * Test {@link EmailInfo#addHeader(String, String)}.
   *
   * <p>Method under test: {@link EmailInfo#addHeader(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailInfo.addHeader(String, String)"})
  public void testAddHeader() {
    // Arrange and Act
    emailInfo.addHeader("Key", "42");

    // Assert
    Map<String, String> headers = emailInfo.getHeaders();
    assertEquals(1, headers.size());
    assertEquals("42", headers.get("Key"));
  }

  /**
   * Test {@link EmailInfo#clone()}.
   *
   * <p>Method under test: {@link EmailInfo#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EmailInfo EmailInfo.clone()"})
  public void testClone() {
    // Arrange and Act
    EmailInfo actualCloneResult = emailInfo.clone();

    // Assert
    assertEquals("UTF8", actualCloneResult.getEncoding());
    assertEquals("framework", actualCloneResult.getFromAddress());
    assertNull(actualCloneResult.getEmailTemplate());
    assertNull(actualCloneResult.getEmailType());
    assertNull(actualCloneResult.getMessageBody());
    assertNull(actualCloneResult.getSendAsyncPriority());
    assertNull(actualCloneResult.getSendEmailReliableAsync());
    assertNull(actualCloneResult.getSubject());
    assertTrue(actualCloneResult.getAttachments().isEmpty());
    assertTrue(actualCloneResult.getHeaders().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailInfo.<init>()",
    "List EmailInfo.getAttachments()",
    "String EmailInfo.getEmailTemplate()",
    "String EmailInfo.getEmailType()",
    "String EmailInfo.getEncoding()",
    "String EmailInfo.getFromAddress()",
    "Map EmailInfo.getHeaders()",
    "String EmailInfo.getMessageBody()",
    "String EmailInfo.getSendAsyncPriority()",
    "String EmailInfo.getSendEmailReliableAsync()",
    "String EmailInfo.getSubject()",
    "void EmailInfo.setAttachments(List)",
    "void EmailInfo.setEmailTemplate(String)",
    "void EmailInfo.setEmailType(String)",
    "void EmailInfo.setEncoding(String)",
    "void EmailInfo.setFromAddress(String)",
    "void EmailInfo.setHeaders(Map)",
    "void EmailInfo.setMessageBody(String)",
    "void EmailInfo.setSendAsyncPriority(String)",
    "void EmailInfo.setSendEmailReliableAsync(String)",
    "void EmailInfo.setSubject(String)"
  })
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

    // Assert
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
