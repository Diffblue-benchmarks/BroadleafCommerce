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
package org.broadleafcommerce.common.extensibility.jpa.convert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
import java.util.Properties;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AlterTableNameClassTransformer.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AlterTableNameClassTransformerDiffblueTest {
  @Autowired private AlterTableNameClassTransformer alterTableNameClassTransformer;

  /**
   * Test {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}.
   *
   * <p>Method under test: {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlterTableNameClassTransformer.<init>()"})
  public void testNewAlterTableNameClassTransformer() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer =
        new AlterTableNameClassTransformer();

    // Assert
    assertNull(actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}.
   *
   * <p>Method under test: {@link
   * AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlterTableNameClassTransformer.<init>(String)"})
  public void testNewAlterTableNameClassTransformer2() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer =
        new AlterTableNameClassTransformer("Table Name");

    // Assert
    assertEquals("Table Name", actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}.
   *
   * <p>Method under test: {@link
   * AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlterTableNameClassTransformer.<init>(String, String)"})
  public void testNewAlterTableNameClassTransformer3() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer =
        new AlterTableNameClassTransformer("Table Name", "Targeted Class");

    // Assert
    assertEquals("Table Name", actualAlterTableNameClassTransformer.getTableName());
    assertEquals("Targeted Class", actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlterTableNameClassTransformer#setTableName(String)}
   *   <li>{@link AlterTableNameClassTransformer#setTargetedClass(String)}
   *   <li>{@link AlterTableNameClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link AlterTableNameClassTransformer#getTableName()}
   *   <li>{@link AlterTableNameClassTransformer#getTargetedClass()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlterTableNameClassTransformer.compileJPAProperties(Properties, Object)",
    "String AlterTableNameClassTransformer.getTableName()",
    "String AlterTableNameClassTransformer.getTargetedClass()",
    "void AlterTableNameClassTransformer.setTableName(String)",
    "void AlterTableNameClassTransformer.setTargetedClass(String)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange
    AlterTableNameClassTransformer alterTableNameClassTransformer =
        new AlterTableNameClassTransformer();

    // Act
    alterTableNameClassTransformer.setTableName("Table Name");
    alterTableNameClassTransformer.setTargetedClass("Targeted Class");
    alterTableNameClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    String actualTableName = alterTableNameClassTransformer.getTableName();

    // Assert
    assertEquals("Table Name", actualTableName);
    assertEquals("Targeted Class", alterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <p>Method under test: {@link AlterTableNameClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AlterTableNameClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform() throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    AlterTableNameClassTransformer alterTableNameClassTransformer =
        new AlterTableNameClassTransformer(" ");
    alterTableNameClassTransformer.setTargetedClass(" ");
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        alterTableNameClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}
   *       TargetedClass is {@code Targeted Class}.
   * </ul>
   *
   * <p>Method under test: {@link AlterTableNameClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AlterTableNameClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenAlterTableNameClassTransformerTargetedClassIsTargetedClass()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    AlterTableNameClassTransformer alterTableNameClassTransformer =
        new AlterTableNameClassTransformer();
    alterTableNameClassTransformer.setTargetedClass("Targeted Class");
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        alterTableNameClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String,
   *       String)} with {@code Table Name} and {@code Targeted Class}.
   * </ul>
   *
   * <p>Method under test: {@link AlterTableNameClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AlterTableNameClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenAlterTableNameClassTransformerWithTableNameAndTargetedClass()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    AlterTableNameClassTransformer alterTableNameClassTransformer =
        new AlterTableNameClassTransformer("Table Name", "Targeted Class");
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        alterTableNameClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link AlterTableNameClassTransformer}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlterTableNameClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AlterTableNameClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenAlterTableNameClassTransformer_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        alterTableNameClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link AlterTableNameClassTransformer}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlterTableNameClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AlterTableNameClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenAlterTableNameClassTransformer_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        alterTableNameClassTransformer.transform(
            loader, null, classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
  }
}
