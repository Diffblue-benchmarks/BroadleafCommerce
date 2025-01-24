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
import javassist.NotFoundException;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AlterTableNameClassTransformer.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AlterTableNameClassTransformerDiffblueTest {
  @Autowired
  private AlterTableNameClassTransformer alterTableNameClassTransformer;

  /**
   * Test {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}
   */
  @Test
  public void testNewAlterTableNameClassTransformer() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer();

    // Assert
    assertNull(actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}
   */
  @Test
  public void testNewAlterTableNameClassTransformer2() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer(
        "Table Name");

    // Assert
    assertEquals("Table Name", actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}
   */
  @Test
  public void testNewAlterTableNameClassTransformer3() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer(
        "Table Name", "Targeted Class");

    // Assert
    assertEquals("Table Name", actualAlterTableNameClassTransformer.getTableName());
    assertEquals("Targeted Class", actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlterTableNameClassTransformer#setTableName(String)}
   *   <li>{@link AlterTableNameClassTransformer#setTargetedClass(String)}
   *   <li>
   * {@link AlterTableNameClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link AlterTableNameClassTransformer#getTableName()}
   *   <li>{@link AlterTableNameClassTransformer#getTargetedClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange
    AlterTableNameClassTransformer alterTableNameClassTransformer = new AlterTableNameClassTransformer();

    // Act
    alterTableNameClassTransformer.setTableName("Table Name");
    alterTableNameClassTransformer.setTargetedClass("Targeted Class");
    alterTableNameClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    String actualTableName = alterTableNameClassTransformer.getTableName();

    // Assert that nothing has changed
    assertEquals("Table Name", actualTableName);
    assertEquals("Targeted Class", alterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test
   * {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTransform() throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.base/java.security.CodeSigner.<init>(CodeSigner.java:75)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSource codeSource = new CodeSource(toURLResult, new CodeSigner[]{new CodeSigner(null, null)});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act
    alterTableNameClassTransformer.transform(loader, "Class Name", classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8"));
  }

  /**
   * Test
   * {@link AlterTableNameClassTransformer#alterTableAnnotation(ClassFile, String, ConstPool)}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#alterTableAnnotation(ClassFile, String, ConstPool)}
   */
  @Test
  public void testAlterTableAnnotation() throws NotFoundException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ClassFile classFile = new ClassFile(true, "Classname", "Superclass");

    // Act
    alterTableNameClassTransformer.alterTableAnnotation(classFile, "Table Name", new ConstPool("Thisclass"));
  }

  /**
   * Test
   * {@link AlterTableNameClassTransformer#alterTableAnnotation(ClassFile, String, ConstPool)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#alterTableAnnotation(ClassFile, String, ConstPool)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAlterTableAnnotation_whenNull() throws NotFoundException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.alterTableAnnotation(AlterTableNameClassTransformer.java:153)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    alterTableNameClassTransformer.alterTableAnnotation(null, "Table Name", new ConstPool("Thisclass"));
  }
}
