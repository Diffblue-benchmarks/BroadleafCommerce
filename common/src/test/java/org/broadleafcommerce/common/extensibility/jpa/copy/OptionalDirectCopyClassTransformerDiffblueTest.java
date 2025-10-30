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
package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

@RunWith(MockitoJUnitRunner.class)
public class OptionalDirectCopyClassTransformerDiffblueTest {
  @InjectMocks
  private OptionalDirectCopyClassTransformer optionalDirectCopyClassTransformer;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OptionalDirectCopyClassTransformer#OptionalDirectCopyClassTransformer(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setPropertyName(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#getPropertyName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OptionalDirectCopyClassTransformer.<init>(String)",
      "String OptionalDirectCopyClassTransformer.getPropertyName()",
      "void OptionalDirectCopyClassTransformer.setBeanFactory(BeanFactory)",
      "void OptionalDirectCopyClassTransformer.setPropertyName(String)"})
  public void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    OptionalDirectCopyClassTransformer actualOptionalDirectCopyClassTransformer = new OptionalDirectCopyClassTransformer(
        "Module Name");
    actualOptionalDirectCopyClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    actualOptionalDirectCopyClassTransformer.setPropertyName("Property Name");

    // Assert
    assertEquals("Property Name", actualOptionalDirectCopyClassTransformer.getPropertyName());
    assertEquals("__", actualOptionalDirectCopyClassTransformer.getRenameMethodPrefix());
    assertFalse(actualOptionalDirectCopyClassTransformer.getRenameMethodOverlaps());
    assertTrue(actualOptionalDirectCopyClassTransformer.getIgnorePatterns().isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.preLoadClassNamePatterns.isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.getTemplateTokens().isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.getXformTemplates().isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.getSkipOverlaps());
  }

  /**
   * Test {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] OptionalDirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(optionalDirectCopyClassTransformer.transform(loader, "Class Name", classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }
}
