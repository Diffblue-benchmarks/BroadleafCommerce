package org.broadleafcommerce.common.security.channel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.servlet.ServletException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.channel.RetryWithHttpEntryPoint;

public class ProtoInsecureChannelProcessorDiffblueTest {
  /**
   * Test {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SecurityConfig#SecurityConfig(String)} with
   *       {@code Config}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ProtoInsecureChannelProcessor#decide(FilterInvocation,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtoInsecureChannelProcessor.decide(FilterInvocation, Collection)"})
  public void testDecide_whenArrayListAddSecurityConfigWithConfig_thenDoesNotThrow()
      throws IOException, ServletException {
    // Arrange
    ProtoInsecureChannelProcessor protoInsecureChannelProcessor =
        new ProtoInsecureChannelProcessor();
    FilterInvocation invocation = new FilterInvocation("Servlet Path", "Method");

    ArrayList<ConfigAttribute> config = new ArrayList<>();
    config.add(new SecurityConfig("Config"));
    config.add(new SecurityConfig("Config"));

    // Act and Assert
    protoInsecureChannelProcessor.decide(invocation, config);
  }

  /**
   * Test {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ProtoInsecureChannelProcessor#decide(FilterInvocation,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtoInsecureChannelProcessor.decide(FilterInvocation, Collection)"})
  public void testDecide_whenArrayList_thenDoesNotThrow() throws IOException, ServletException {
    // Arrange
    ProtoInsecureChannelProcessor protoInsecureChannelProcessor =
        new ProtoInsecureChannelProcessor();
    FilterInvocation invocation = new FilterInvocation("Servlet Path", "Method");

    // Act and Assert
    protoInsecureChannelProcessor.decide(invocation, new ArrayList<>());
  }

  /**
   * Test {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   *
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       SecurityConfig#SecurityConfig(String)} with {@code Config}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ProtoInsecureChannelProcessor#decide(FilterInvocation,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtoInsecureChannelProcessor.decide(FilterInvocation, Collection)"})
  public void testDecide_whenLinkedHashSetAddSecurityConfigWithConfig_thenDoesNotThrow()
      throws IOException, ServletException {
    // Arrange
    ProtoInsecureChannelProcessor protoInsecureChannelProcessor =
        new ProtoInsecureChannelProcessor();
    FilterInvocation invocation = new FilterInvocation("Servlet Path", "Method");

    LinkedHashSet<ConfigAttribute> config = new LinkedHashSet<>();
    config.add(new SecurityConfig("Config"));

    // Act and Assert
    protoInsecureChannelProcessor.decide(invocation, config);
  }

  /**
   * Test {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoInsecureChannelProcessor#decide(FilterInvocation,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtoInsecureChannelProcessor.decide(FilterInvocation, Collection)"})
  public void testDecide_whenNull_thenThrowIllegalArgumentException()
      throws IOException, ServletException {
    // Arrange
    ProtoInsecureChannelProcessor protoInsecureChannelProcessor =
        new ProtoInsecureChannelProcessor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            protoInsecureChannelProcessor.decide(
                new FilterInvocation("Servlet Path", "Method"), null));
  }

  /**
   * Test {@link ProtoInsecureChannelProcessor#decide(FilterInvocation, Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoInsecureChannelProcessor#decide(FilterInvocation,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtoInsecureChannelProcessor.decide(FilterInvocation, Collection)"})
  public void testDecide_whenNull_thenThrowIllegalArgumentException2()
      throws IOException, ServletException {
    // Arrange
    ProtoInsecureChannelProcessor protoInsecureChannelProcessor =
        new ProtoInsecureChannelProcessor();

    LinkedHashSet<ConfigAttribute> config = new LinkedHashSet<>();
    config.add(new SecurityConfig("Config"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> protoInsecureChannelProcessor.decide(null, config));
  }

  /**
   * Test new {@link ProtoInsecureChannelProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ProtoInsecureChannelProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtoInsecureChannelProcessor.<init>()"})
  public void testNewProtoInsecureChannelProcessor() {
    // Arrange and Act
    ProtoInsecureChannelProcessor actualProtoInsecureChannelProcessor =
        new ProtoInsecureChannelProcessor();

    // Assert
    assertTrue(
        actualProtoInsecureChannelProcessor.getEntryPoint() instanceof RetryWithHttpEntryPoint);
    assertEquals(
        "REQUIRES_INSECURE_CHANNEL", actualProtoInsecureChannelProcessor.getInsecureKeyword());
  }
}
