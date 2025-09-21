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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.util.ArrayList;
import java.util.List;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaterializedClobTypeClassTransformerDiffblueTest {
  @Mock private List<DirectCopyIgnorePattern> list;

  @InjectMocks private MaterializedClobTypeClassTransformer materializedClobTypeClassTransformer;

  /**
   * Test {@link MaterializedClobTypeClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#transform(ClassLoader,
   * String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] MaterializedClobTypeClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Unable to convert "});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"ABC123"});

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(
        IllegalClassFormatException.class,
        () ->
            materializedClobTypeClassTransformer.transform(
                loader,
                "Class Name",
                classBeingRedefined,
                protectionDomain,
                "AXAXAXAX".getBytes("UTF-8")));
    verify(list).iterator();
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#transform(ClassLoader,
   * String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] MaterializedClobTypeClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform2()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Unable to convert "});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"ABC123"});

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(
        IllegalClassFormatException.class,
        () ->
            materializedClobTypeClassTransformer.transform(
                loader,
                "Unable to convert ",
                classBeingRedefined,
                protectionDomain,
                "AXAXAXAX".getBytes("UTF-8")));
    verify(list).iterator();
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link DirectCopyIgnorePattern} (default constructor) TemplateTokenPatterns is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#transform(ClassLoader,
   * String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] MaterializedClobTypeClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenDirectCopyIgnorePatternTemplateTokenPatternsIsNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Unable to convert "});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act
    byte[] actualTransformResult =
        materializedClobTypeClassTransformer.transform(
            loader,
            "Unable to convert ",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(list).iterator();
    assertNull(actualTransformResult);
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalClassFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#transform(ClassLoader,
   * String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] MaterializedClobTypeClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenClassName_thenThrowIllegalClassFormatException()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(
        IllegalClassFormatException.class,
        () ->
            materializedClobTypeClassTransformer.transform(
                loader,
                "Class Name",
                classBeingRedefined,
                protectionDomain,
                "AXAXAXAX".getBytes("UTF-8")));
    verify(list).iterator();
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link IllegalClassFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#transform(ClassLoader,
   * String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] MaterializedClobTypeClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenEmptyArrayOfByte_thenThrowIllegalClassFormatException()
      throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(
        IllegalClassFormatException.class,
        () ->
            materializedClobTypeClassTransformer.transform(
                loader, "Class Name", classBeingRedefined, protectionDomain, new byte[] {}));
    verify(list).iterator();
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#transform(ClassLoader,
   * String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] MaterializedClobTypeClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenNull_thenReturnNull()
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
        materializedClobTypeClassTransformer.transform(
            loader, null, classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalClassFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#transform(ClassLoader,
   * String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] MaterializedClobTypeClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenNull_thenThrowIllegalClassFormatException()
      throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(
        IllegalClassFormatException.class,
        () ->
            materializedClobTypeClassTransformer.transform(
                loader, "Class Name", classBeingRedefined, protectionDomain, null));
    verify(list).iterator();
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#isIgnored(String)}.
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterializedClobTypeClassTransformer.isIgnored(String)"})
  public void testIsIgnored() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns", "42"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"ABC123"});

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());

    // Act
    boolean actualIsIgnoredResult = materializedClobTypeClassTransformer.isIgnored("42");

    // Assert
    verify(list).iterator();
    assertFalse(actualIsIgnoredResult);
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>Given {@link DirectCopyIgnorePattern} (default constructor) Patterns is array of {@link
   *       String} with {@code Patterns}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterializedClobTypeClassTransformer.isIgnored(String)"})
  public void testIsIgnored_givenDirectCopyIgnorePatternPatternsIsArrayOfStringWithPatterns() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"ABC123"});

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());

    // Act
    boolean actualIsIgnoredResult = materializedClobTypeClassTransformer.isIgnored("Patterns");

    // Assert
    verify(list).iterator();
    assertFalse(actualIsIgnoredResult);
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterializedClobTypeClassTransformer.isIgnored(String)"})
  public void testIsIgnored_thenReturnTrue() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());

    // Act
    boolean actualIsIgnoredResult = materializedClobTypeClassTransformer.isIgnored("Patterns");

    // Assert
    verify(list).iterator();
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>When {@code Converted Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterializedClobTypeClassTransformer.isIgnored(String)"})
  public void testIsIgnored_whenConvertedClassName() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"ABC123"});

    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    directCopyIgnorePatternList.add(directCopyIgnorePattern);
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());

    // Act
    boolean actualIsIgnoredResult =
        materializedClobTypeClassTransformer.isIgnored("Converted Class Name");

    // Assert
    verify(list).iterator();
    assertFalse(actualIsIgnoredResult);
  }

  /**
   * Test {@link MaterializedClobTypeClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>When {@code Converted Class Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaterializedClobTypeClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterializedClobTypeClassTransformer.isIgnored(String)"})
  public void testIsIgnored_whenConvertedClassName_thenReturnFalse() {
    // Arrange
    ArrayList<DirectCopyIgnorePattern> directCopyIgnorePatternList = new ArrayList<>();
    when(list.iterator()).thenReturn(directCopyIgnorePatternList.iterator());

    // Act
    boolean actualIsIgnoredResult =
        materializedClobTypeClassTransformer.isIgnored("Converted Class Name");

    // Assert
    verify(list).iterator();
    assertFalse(actualIsIgnoredResult);
  }

  /**
   * Test {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <p>Method under test: {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaterializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation() {
    // Arrange
    Annotation annotation = new Annotation("Type Name", new ConstPool("Thisclass"));

    // Act and Assert
    assertFalse(
        materializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation}));
  }

  /**
   * Test {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <ul>
   *   <li>Given {@code javax.persistence.Embeddable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaterializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation_givenJavaxPersistenceEmbeddable() {
    // Arrange
    Annotation annotation = mock(Annotation.class);
    when(annotation.getTypeName()).thenReturn("javax.persistence.Embeddable");

    // Act
    boolean actualContainsTypeLevelPersistenceAnnotationResult =
        materializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation});

    // Assert
    verify(annotation, atLeast(1)).getTypeName();
    assertTrue(actualContainsTypeLevelPersistenceAnnotationResult);
  }

  /**
   * Test {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <ul>
   *   <li>Given {@code javax.persistence.Entity}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaterializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation_givenJavaxPersistenceEntity() {
    // Arrange
    Annotation annotation = mock(Annotation.class);
    when(annotation.getTypeName()).thenReturn("javax.persistence.Entity");

    // Act
    boolean actualContainsTypeLevelPersistenceAnnotationResult =
        materializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation});

    // Assert
    verify(annotation).getTypeName();
    assertTrue(actualContainsTypeLevelPersistenceAnnotationResult);
  }

  /**
   * Test {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <ul>
   *   <li>Given {@code javax.persistence.MappedSuperclass}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaterializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation_givenJavaxPersistenceMappedSuperclass() {
    // Arrange
    Annotation annotation = mock(Annotation.class);
    when(annotation.getTypeName()).thenReturn("javax.persistence.MappedSuperclass");

    // Act
    boolean actualContainsTypeLevelPersistenceAnnotationResult =
        materializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation});

    // Assert
    verify(annotation, atLeast(1)).getTypeName();
    assertTrue(actualContainsTypeLevelPersistenceAnnotationResult);
  }

  /**
   * Test {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <ul>
   *   <li>Given {@code Type Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MaterializedClobTypeClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaterializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation_givenTypeName() {
    // Arrange
    Annotation annotation = mock(Annotation.class);
    when(annotation.getTypeName()).thenReturn("Type Name");

    // Act
    boolean actualContainsTypeLevelPersistenceAnnotationResult =
        materializedClobTypeClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation});

    // Assert
    verify(annotation, atLeast(1)).getTypeName();
    assertFalse(actualContainsTypeLevelPersistenceAnnotationResult);
  }
}
