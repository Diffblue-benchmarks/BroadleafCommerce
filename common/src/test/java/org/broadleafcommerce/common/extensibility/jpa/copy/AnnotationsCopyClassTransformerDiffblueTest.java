package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AnnotationsCopyClassTransformer.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationsCopyClassTransformerDiffblueTest {
  @Autowired private AnnotationsCopyClassTransformer annotationsCopyClassTransformer;

  /**
   * Test {@link AnnotationsCopyClassTransformer#AnnotationsCopyClassTransformer(String)}.
   *
   * <p>Method under test: {@link
   * AnnotationsCopyClassTransformer#AnnotationsCopyClassTransformer(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AnnotationsCopyClassTransformer.<init>(String)"})
  public void testNewAnnotationsCopyClassTransformer() {
    // Arrange and Act
    AnnotationsCopyClassTransformer actualAnnotationsCopyClassTransformer =
        new AnnotationsCopyClassTransformer("Module Name");

    // Assert
    assertEquals("Module Name", actualAnnotationsCopyClassTransformer.moduleName);
    assertTrue(actualAnnotationsCopyClassTransformer.getXformTemplates().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnnotationsCopyClassTransformer#setXformTemplates(Map)}
   *   <li>{@link AnnotationsCopyClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link AnnotationsCopyClassTransformer#getXformTemplates()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AnnotationsCopyClassTransformer.compileJPAProperties(Properties, Object)",
    "Map AnnotationsCopyClassTransformer.getXformTemplates()",
    "void AnnotationsCopyClassTransformer.setXformTemplates(Map)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange
    AnnotationsCopyClassTransformer annotationsCopyClassTransformer =
        new AnnotationsCopyClassTransformer("Module Name");
    HashMap<String, String> xformTemplates = new HashMap<>();

    // Act
    annotationsCopyClassTransformer.setXformTemplates(xformTemplates);
    annotationsCopyClassTransformer.compileJPAProperties(
        new Properties(), BLCFieldUtils.NULL_FIELD);
    Map<String, String> actualXformTemplates = annotationsCopyClassTransformer.getXformTemplates();

    // Assert
    assertTrue(actualXformTemplates.isEmpty());
    assertSame(xformTemplates, actualXformTemplates);
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationsCopyClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AnnotationsCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenClassName_thenReturnNull()
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
        annotationsCopyClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationsCopyClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AnnotationsCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
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
        annotationsCopyClassTransformer.transform(
            loader, null, classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AnnotationsCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenClassName_thenReturnClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", annotationsCopyClassTransformer.getImplementationType("Class Name"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.List}.
   *   <li>Then return {@code java.util.ArrayList}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AnnotationsCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenJavaUtilList_thenReturnJavaUtilArrayList() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.ArrayList",
        annotationsCopyClassTransformer.getImplementationType("java.util.List"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   *
   * <ul>
   *   <li>When {@code Map}.
   *   <li>Then return {@code HashMap}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AnnotationsCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenJavaUtilMap_thenReturnJavaUtilHashMap() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.HashMap",
        annotationsCopyClassTransformer.getImplementationType("java.util.Map"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.Set}.
   *   <li>Then return {@code java.util.HashSet}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AnnotationsCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenJavaUtilSet_thenReturnJavaUtilHashSet() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.HashSet",
        annotationsCopyClassTransformer.getImplementationType("java.util.Set"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   *
   * <ul>
   *   <li>When {@code [}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AnnotationsCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenLeftSquareBracket_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(annotationsCopyClassTransformer.getImplementationType("["));
  }
}
