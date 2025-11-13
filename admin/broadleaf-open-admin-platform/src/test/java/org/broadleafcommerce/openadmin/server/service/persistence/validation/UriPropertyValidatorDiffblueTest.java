package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {UriPropertyValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UriPropertyValidatorDiffblueTest {
  @Autowired private UriPropertyValidator uriPropertyValidator;

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   *
   * <ul>
   *   <li>When {@code ftp}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UriPropertyValidator.isFullUrl(String)"})
  public void testIsFullUrl_whenFtp_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uriPropertyValidator.isFullUrl("ftp"));
  }

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UriPropertyValidator.isFullUrl(String)"})
  public void testIsFullUrl_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(uriPropertyValidator.isFullUrl("https://example.org/example"));
  }

  /**
   * Test {@link UriPropertyValidator#isFullUrl(String)}.
   *
   * <ul>
   *   <li>When {@code Url}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UriPropertyValidator#isFullUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UriPropertyValidator.isFullUrl(String)"})
  public void testIsFullUrl_whenUrl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(uriPropertyValidator.isFullUrl("Url"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UriPropertyValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link UriPropertyValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UriPropertyValidator.isSucceedForNullValues()",
    "void UriPropertyValidator.setSucceedForNullValues(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    UriPropertyValidator uriPropertyValidator = new UriPropertyValidator();

    // Act
    uriPropertyValidator.setSucceedForNullValues(true);

    // Assert
    assertTrue(uriPropertyValidator.isSucceedForNullValues());
  }
}
