package org.broadleafcommerce.common.security.channel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.security.web.access.channel.RetryWithHttpsEntryPoint;

public class ProtoSecureChannelProcessorDiffblueTest {
  /**
   * Test new {@link ProtoSecureChannelProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ProtoSecureChannelProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtoSecureChannelProcessor.<init>()"})
  public void testNewProtoSecureChannelProcessor() {
    // Arrange and Act
    ProtoSecureChannelProcessor actualProtoSecureChannelProcessor =
        new ProtoSecureChannelProcessor();

    // Assert
    assertTrue(
        actualProtoSecureChannelProcessor.getEntryPoint() instanceof RetryWithHttpsEntryPoint);
    assertEquals("REQUIRES_SECURE_CHANNEL", actualProtoSecureChannelProcessor.getSecureKeyword());
  }
}
