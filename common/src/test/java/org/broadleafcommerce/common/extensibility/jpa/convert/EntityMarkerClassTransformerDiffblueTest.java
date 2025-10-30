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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityMarkerClassTransformerDiffblueTest {
  @InjectMocks
  private EntityMarkerClassTransformer entityMarkerClassTransformer;

  @Mock
  private List<DirectCopyIgnorePattern> list;

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform() throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[]{"An error has occurred "});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[]{"ABC123"});

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(IllegalClassFormatException.class, () -> entityMarkerClassTransformer.transform(loader, "Class Name",
        classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
    verify(list).iterator();
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>Then throw {@link IllegalClassFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_thenThrowIllegalClassFormatException()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(IllegalClassFormatException.class, () -> entityMarkerClassTransformer.transform(loader, "Class Name",
        classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
    verify(list).iterator();
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(entityMarkerClassTransformer.transform(loader, null, classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalClassFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenNull_thenThrowIllegalClassFormatException()
      throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    // Act and Assert
    assertThrows(IllegalClassFormatException.class, () -> entityMarkerClassTransformer.transform(loader, "Class Name",
        classBeingRedefined, new ProtectionDomain(codeSource, new Permissions()), null));
    verify(list).iterator();
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"})
  public void testContainsTypeLevelPersistenceAnnotation() {
    // Arrange, Act and Assert
    assertTrue(entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
        new Annotation[]{new Annotation("javax.persistence.Entity", new ConstPool("Thisclass"))}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"})
  public void testContainsTypeLevelPersistenceAnnotation2() {
    // Arrange, Act and Assert
    assertTrue(entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
        new Annotation[]{new Annotation("javax.persistence.Embeddable", new ConstPool("Thisclass"))}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"})
  public void testContainsTypeLevelPersistenceAnnotation3() {
    // Arrange, Act and Assert
    assertTrue(entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
        new Annotation[]{new Annotation("javax.persistence.MappedSuperclass", new ConstPool("Thisclass"))}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"})
  public void testContainsTypeLevelPersistenceAnnotation_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
        new Annotation[]{new Annotation("Type Name", new ConstPool("Thisclass"))}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.isIgnored(String)"})
  public void testIsIgnored() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act and Assert
    assertFalse(entityMarkerClassTransformer.isIgnored("Converted Class Name"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityMarkerClassTransformer}
   *   <li>{@link EntityMarkerClassTransformer#setIgnorePatterns(List)}
   *   <li>{@link EntityMarkerClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link EntityMarkerClassTransformer#getIgnorePatterns()}
   *   <li>{@link EntityMarkerClassTransformer#getTransformedEntityClassNames()}
   *   <li>{@link EntityMarkerClassTransformer#getTransformedNonEntityClassNames()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityMarkerClassTransformer.<init>()",
      "void EntityMarkerClassTransformer.compileJPAProperties(Properties, Object)",
      "List EntityMarkerClassTransformer.getIgnorePatterns()",
      "HashSet EntityMarkerClassTransformer.getTransformedEntityClassNames()",
      "HashSet EntityMarkerClassTransformer.getTransformedNonEntityClassNames()",
      "void EntityMarkerClassTransformer.setIgnorePatterns(List)"})
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    EntityMarkerClassTransformer actualEntityMarkerClassTransformer = new EntityMarkerClassTransformer();
    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    actualEntityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);
    actualEntityMarkerClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    List<DirectCopyIgnorePattern> actualIgnorePatterns = actualEntityMarkerClassTransformer.getIgnorePatterns();
    HashSet<String> actualTransformedEntityClassNames = actualEntityMarkerClassTransformer
        .getTransformedEntityClassNames();
    HashSet<String> actualTransformedNonEntityClassNames = actualEntityMarkerClassTransformer
        .getTransformedNonEntityClassNames();

    // Assert
    assertTrue(actualTransformedEntityClassNames.isEmpty());
    assertTrue(actualTransformedNonEntityClassNames.isEmpty());
    assertTrue(actualIgnorePatterns.isEmpty());
    assertSame(ignorePatterns, actualIgnorePatterns);
  }
}
