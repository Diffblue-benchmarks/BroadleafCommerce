/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.encryption;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
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
  @MockBean
  private Environment environment;

  @Autowired
  private PassthroughEncryptionModule passthroughEncryptionModule;

  /**
   * Method under test: {@link PassthroughEncryptionModule#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    when(environment.acceptsProfiles((String[]) any())).thenReturn(true);

    // Act
    passthroughEncryptionModule.init();

    // Assert
    verify(environment).acceptsProfiles((String[]) any());
  }

  /**
   * Method under test: {@link PassthroughEncryptionModule#init()}
   */
  @Test
  public void testInit2() {
    // Arrange
    when(environment.acceptsProfiles((String[]) any())).thenReturn(false);

    // Act
    passthroughEncryptionModule.init();

    // Assert
    verify(environment).acceptsProfiles((String[]) any());
  }

  /**
   * Method under test: {@link PassthroughEncryptionModule#decrypt(String)}
   */
  @Test
  public void testDecrypt() {
    // Arrange, Act and Assert
    assertEquals("Cipher Text", passthroughEncryptionModule.decrypt("Cipher Text"));
  }

  /**
   * Method under test: {@link PassthroughEncryptionModule#encrypt(String)}
   */
  @Test
  public void testEncrypt() {
    // Arrange, Act and Assert
    assertEquals("Plain Text", passthroughEncryptionModule.encrypt("Plain Text"));
  }

  /**
   * Method under test:
   * {@link PassthroughEncryptionModule#matches(String, String)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse(passthroughEncryptionModule.matches("Raw", "Encrypted"));
    assertTrue(passthroughEncryptionModule.matches("Encrypted", "Encrypted"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PassthroughEncryptionModule}
   */
  @Test
  public void testNewPassthroughEncryptionModule() {
    // Arrange, Act and Assert
    assertNull((new PassthroughEncryptionModule()).env);
  }
}
