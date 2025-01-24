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
import static org.junit.Assert.assertTrue;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.List;
import org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OptionalDirectCopyClassTransformer.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OptionalDirectCopyClassTransformerDiffblueTest {
  @MockBean
  private ConditionalDirectCopyTransformersManager conditionalDirectCopyTransformersManager;

  @MockBean
  private DirectCopyIgnorePattern directCopyIgnorePattern;

  @Autowired
  private List<DirectCopyIgnorePattern> list;

  @Autowired
  private OptionalDirectCopyClassTransformer optionalDirectCopyClassTransformer;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OptionalDirectCopyClassTransformer#OptionalDirectCopyClassTransformer(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setPropertyName(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#getPropertyName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    OptionalDirectCopyClassTransformer actualOptionalDirectCopyClassTransformer = new OptionalDirectCopyClassTransformer(
        "Module Name");
    actualOptionalDirectCopyClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    actualOptionalDirectCopyClassTransformer.setPropertyName("Property Name");

    // Assert that nothing has changed
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
   * Test
   * {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <p>
   * Method under test:
   * {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTransform() throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.common.extensibility.jpa.copy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.class,java.lang.String.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11279 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManager conditionalDirectCopyTransformersManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern directCopyIgnorePattern;
    //     @org.springframework.beans.factory.annotation.Autowired java.util.List<Lorg.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern;> list;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer optionalDirectCopyClassTransformer;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSource codeSource = new CodeSource(toURLResult, new CodeSigner[]{new CodeSigner(null, null)});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act
    optionalDirectCopyClassTransformer.transform(loader, "Class Name", classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8"));
  }
}
