package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OptionalDirectCopyClassTransformerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OptionalDirectCopyClassTransformer#OptionalDirectCopyClassTransformer(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setPropertyName(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#getPropertyName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptionalDirectCopyClassTransformer.<init>(String)",
    "String OptionalDirectCopyClassTransformer.getPropertyName()",
    "void OptionalDirectCopyClassTransformer.setBeanFactory(BeanFactory)",
    "void OptionalDirectCopyClassTransformer.setPropertyName(String)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    OptionalDirectCopyClassTransformer actualOptionalDirectCopyClassTransformer =
        new OptionalDirectCopyClassTransformer("Module Name");
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
   * Test {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <p>Method under test: {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] OptionalDirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException,
          BeansException {
    // Arrange
    OptionalDirectCopyClassTransformer optionalDirectCopyClassTransformer =
        new OptionalDirectCopyClassTransformer("Module Name");
    optionalDirectCopyClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        optionalDirectCopyClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link
   *       OptionalDirectCopyClassTransformer#OptionalDirectCopyClassTransformer(String)} with
   *       {@code Module Name}.
   * </ul>
   *
   * <p>Method under test: {@link OptionalDirectCopyClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] OptionalDirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenOptionalDirectCopyClassTransformerWithModuleName()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    OptionalDirectCopyClassTransformer optionalDirectCopyClassTransformer =
        new OptionalDirectCopyClassTransformer("Module Name");
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        optionalDirectCopyClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }
}
