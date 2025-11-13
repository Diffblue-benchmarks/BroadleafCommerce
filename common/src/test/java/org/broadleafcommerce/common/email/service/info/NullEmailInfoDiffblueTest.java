package org.broadleafcommerce.common.email.service.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullEmailInfoDiffblueTest {
  /**
   * Test {@link NullEmailInfo#NullEmailInfo()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link NullEmailInfo}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NullEmailInfo.<init>()"})
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
