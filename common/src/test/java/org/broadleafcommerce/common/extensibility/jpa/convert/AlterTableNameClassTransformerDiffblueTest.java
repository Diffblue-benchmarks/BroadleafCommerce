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
import java.util.Properties;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Method under test: {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlterTableNameClassTransformer.<init>()"})
  public void testNewAlterTableNameClassTransformer() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer();

    // Assert
    assertNull(actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}.
   * <p>
   * Method under test: {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlterTableNameClassTransformer.<init>(String)"})
  public void testNewAlterTableNameClassTransformer2() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer(
        "Table Name");

    // Assert
    assertEquals("Table Name", actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}.
   * <p>
   * Method under test: {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlterTableNameClassTransformer.<init>(String, String)"})
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
   *   <li>{@link AlterTableNameClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link AlterTableNameClassTransformer#getTableName()}
   *   <li>{@link AlterTableNameClassTransformer#getTargetedClass()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlterTableNameClassTransformer.compileJPAProperties(Properties, Object)",
      "String AlterTableNameClassTransformer.getTableName()",
      "String AlterTableNameClassTransformer.getTargetedClass()",
      "void AlterTableNameClassTransformer.setTableName(String)",
      "void AlterTableNameClassTransformer.setTargetedClass(String)"})
  public void testGettersAndSetters() throws Exception {
    // Arrange
    AlterTableNameClassTransformer alterTableNameClassTransformer = new AlterTableNameClassTransformer();

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
   * Test {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] AlterTableNameClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenClassName_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(alterTableNameClassTransformer.transform(loader, "Class Name", classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterTableNameClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] AlterTableNameClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(alterTableNameClassTransformer.transform(loader, null, classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }
}
