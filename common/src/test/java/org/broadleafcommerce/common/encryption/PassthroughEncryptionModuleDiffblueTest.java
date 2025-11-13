package org.broadleafcommerce.common.encryption;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PassthroughEncryptionModule.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PassthroughEncryptionModuleDiffblueTest {
  @MockBean private Environment environment;

  @Autowired private PassthroughEncryptionModule passthroughEncryptionModule;

  /**
   * Test {@link PassthroughEncryptionModule#init()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#acceptsProfiles(String[])} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PassthroughEncryptionModule#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PassthroughEncryptionModule.init()"})
  public void testInit_givenEnvironmentAcceptsProfilesReturnFalse() {
    // Arrange
    when(environment.acceptsProfiles((String[]) Mockito.any())).thenReturn(false);

    // Act
    passthroughEncryptionModule.init();

    // Assert
    verify(environment).acceptsProfiles((String[]) Mockito.any());
  }

  /**
   * Test {@link PassthroughEncryptionModule#decrypt(String)}.
   *
   * <p>Method under test: {@link PassthroughEncryptionModule#decrypt(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PassthroughEncryptionModule.decrypt(String)"})
  public void testDecrypt() {
    // Arrange, Act and Assert
    assertEquals("Cipher Text", passthroughEncryptionModule.decrypt("Cipher Text"));
  }

  /**
   * Test {@link PassthroughEncryptionModule#encrypt(String)}.
   *
   * <p>Method under test: {@link PassthroughEncryptionModule#encrypt(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PassthroughEncryptionModule.encrypt(String)"})
  public void testEncrypt() {
    // Arrange, Act and Assert
    assertEquals("Plain Text", passthroughEncryptionModule.encrypt("Plain Text"));
  }

  /**
   * Test {@link PassthroughEncryptionModule#matches(String, String)}.
   *
   * <ul>
   *   <li>When {@code Encrypted}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PassthroughEncryptionModule#matches(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean PassthroughEncryptionModule.matches(String, String)"})
  public void testMatches_whenEncrypted_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(passthroughEncryptionModule.matches("Encrypted", "Encrypted"));
  }

  /**
   * Test {@link PassthroughEncryptionModule#matches(String, String)}.
   *
   * <ul>
   *   <li>When {@code Raw}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PassthroughEncryptionModule#matches(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean PassthroughEncryptionModule.matches(String, String)"})
  public void testMatches_whenRaw_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(passthroughEncryptionModule.matches("Raw", "Encrypted"));
  }

  /**
   * Test new {@link PassthroughEncryptionModule} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * PassthroughEncryptionModule}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PassthroughEncryptionModule.<init>()"})
  public void testNewPassthroughEncryptionModule() {
    // Arrange, Act and Assert
    assertNull(new PassthroughEncryptionModule().env);
  }
}
