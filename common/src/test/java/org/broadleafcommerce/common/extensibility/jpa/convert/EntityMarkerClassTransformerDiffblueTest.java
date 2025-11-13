package org.broadleafcommerce.common.extensibility.jpa.convert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class EntityMarkerClassTransformerDiffblueTest {
  @InjectMocks private EntityMarkerClassTransformer entityMarkerClassTransformer;

  @Mock private List<DirectCopyIgnorePattern> list;

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform() throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"foo"});

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);
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
            entityMarkerClassTransformer.transform(
                loader,
                "Class Name",
                classBeingRedefined,
                protectionDomain,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform2() throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"foo"});

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);
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
            entityMarkerClassTransformer.transform(
                loader,
                "Patterns",
                classBeingRedefined,
                protectionDomain,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link DirectCopyIgnorePattern} (default constructor) TemplateTokenPatterns is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenDirectCopyIgnorePatternTemplateTokenPatternsIsNull()
      throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        entityMarkerClassTransformer.transform(
            loader,
            "Patterns",
            classBeingRedefined,
            protectionDomain,
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link EntityMarkerClassTransformer} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenEntityMarkerClassTransformer()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
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
            entityMarkerClassTransformer.transform(
                loader,
                "Class Name",
                classBeingRedefined,
                protectionDomain,
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link EntityMarkerClassTransformer} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenEntityMarkerClassTransformer_whenNull()
      throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
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
            entityMarkerClassTransformer.transform(
                loader, "Class Name", classBeingRedefined, protectionDomain, null));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Given {@link EntityMarkerClassTransformer} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_givenEntityMarkerClassTransformer_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        entityMarkerClassTransformer.transform(
            loader, null, classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] EntityMarkerClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_thenCallsIterator()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"An error has occurred "});
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
            entityMarkerClassTransformer.transform(
                loader,
                "An error has occurred ",
                classBeingRedefined,
                protectionDomain,
                "AXAXAXAX".getBytes("UTF-8")));
    verify(list).iterator();
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <p>Method under test: {@link
   * EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation() {
    // Arrange
    Annotation annotation = new Annotation("javax.persistence.Entity", new ConstPool("Thisclass"));

    // Act and Assert
    assertTrue(
        entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <p>Method under test: {@link
   * EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation2() {
    // Arrange
    Annotation annotation =
        new Annotation("javax.persistence.Embeddable", new ConstPool("Thisclass"));

    // Act and Assert
    assertTrue(
        entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <p>Method under test: {@link
   * EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation3() {
    // Arrange
    Annotation annotation =
        new Annotation("javax.persistence.MappedSuperclass", new ConstPool("Thisclass"));

    // Act and Assert
    assertTrue(
        entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation}));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityMarkerClassTransformer#containsTypeLevelPersistenceAnnotation(Annotation[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(Annotation[])"
  })
  public void testContainsTypeLevelPersistenceAnnotation_thenReturnFalse() {
    // Arrange
    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    Annotation annotation = new Annotation("Type Name", new ConstPool("Thisclass"));

    // Act
    boolean actualContainsTypeLevelPersistenceAnnotationResult =
        entityMarkerClassTransformer.containsTypeLevelPersistenceAnnotation(
            new Annotation[] {annotation});

    // Assert
    assertFalse(actualContainsTypeLevelPersistenceAnnotationResult);
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.isIgnored(String)"})
  public void testIsIgnored() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns", "42"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"foo"});

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act and Assert
    assertFalse(entityMarkerClassTransformer.isIgnored("42"));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>Given {@link EntityMarkerClassTransformer} (default constructor).
   *   <li>When {@code Converted Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.isIgnored(String)"})
  public void testIsIgnored_givenEntityMarkerClassTransformer_whenConvertedClassName() {
    // Arrange, Act and Assert
    assertFalse(new EntityMarkerClassTransformer().isIgnored("Converted Class Name"));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.isIgnored(String)"})
  public void testIsIgnored_thenReturnTrue() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act and Assert
    assertTrue(entityMarkerClassTransformer.isIgnored("Patterns"));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>When {@code Converted Class Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.isIgnored(String)"})
  public void testIsIgnored_whenConvertedClassName_thenReturnFalse() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"foo"});

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act and Assert
    assertFalse(entityMarkerClassTransformer.isIgnored("Converted Class Name"));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   *
   * <ul>
   *   <li>When {@code Patterns}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMarkerClassTransformer.isIgnored(String)"})
  public void testIsIgnored_whenPatterns_thenReturnFalse() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[] {"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[] {"foo"});

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act and Assert
    assertFalse(entityMarkerClassTransformer.isIgnored("Patterns"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityMarkerClassTransformer.<init>()",
    "void EntityMarkerClassTransformer.compileJPAProperties(Properties, Object)",
    "List EntityMarkerClassTransformer.getIgnorePatterns()",
    "HashSet EntityMarkerClassTransformer.getTransformedEntityClassNames()",
    "HashSet EntityMarkerClassTransformer.getTransformedNonEntityClassNames()",
    "void EntityMarkerClassTransformer.setIgnorePatterns(List)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    EntityMarkerClassTransformer actualEntityMarkerClassTransformer =
        new EntityMarkerClassTransformer();
    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    actualEntityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);
    actualEntityMarkerClassTransformer.compileJPAProperties(
        new Properties(), BLCFieldUtils.NULL_FIELD);
    List<DirectCopyIgnorePattern> actualIgnorePatterns =
        actualEntityMarkerClassTransformer.getIgnorePatterns();
    HashSet<String> actualTransformedEntityClassNames =
        actualEntityMarkerClassTransformer.getTransformedEntityClassNames();
    HashSet<String> actualTransformedNonEntityClassNames =
        actualEntityMarkerClassTransformer.getTransformedNonEntityClassNames();

    // Assert
    assertTrue(actualTransformedEntityClassNames.isEmpty());
    assertTrue(actualTransformedNonEntityClassNames.isEmpty());
    assertTrue(actualIgnorePatterns.isEmpty());
    assertSame(ignorePatterns, actualIgnorePatterns);
  }
}
