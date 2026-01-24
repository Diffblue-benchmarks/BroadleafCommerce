package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.ArrayMemberValue;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class QueryConfigurationClassTransformerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueryConfigurationClassTransformer#QueryConfigurationClassTransformer(List, List,
   *       List)}
   *   <li>{@link QueryConfigurationClassTransformer#compileJPAProperties(Properties, Object)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QueryConfigurationClassTransformer.<init>(List, List, List)",
    "void QueryConfigurationClassTransformer.compileJPAProperties(Properties, Object)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();

    // Act
    QueryConfigurationClassTransformer actualQueryConfigurationClassTransformer =
        new QueryConfigurationClassTransformer(namedQueries, nativeQueries, new ArrayList<>());
    actualQueryConfigurationClassTransformer.compileJPAProperties(
        new Properties(), BLCFieldUtils.NULL_FIELD);

    // Assert
    assertTrue(actualQueryConfigurationClassTransformer.managedClassNames.isEmpty());
    assertTrue(actualQueryConfigurationClassTransformer.namedQueries.isEmpty());
    assertTrue(actualQueryConfigurationClassTransformer.nativeQueries.isEmpty());
  }

  /**
   * Test {@link QueryConfigurationClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueryConfigurationClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] QueryConfigurationClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenClassName_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();

    QueryConfigurationClassTransformer queryConfigurationClassTransformer =
        new QueryConfigurationClassTransformer(namedQueries, nativeQueries, new ArrayList<>());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        queryConfigurationClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link QueryConfigurationClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueryConfigurationClassTransformer#transform(ClassLoader, String,
   * Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] QueryConfigurationClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();

    QueryConfigurationClassTransformer queryConfigurationClassTransformer =
        new QueryConfigurationClassTransformer(namedQueries, nativeQueries, new ArrayList<>());
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        queryConfigurationClassTransformer.transform(
            loader, null, classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link QueryConfigurationClassTransformer#prepareNativeQueries(ConstPool, ClassPool,
   * ArrayMemberValue)}.
   *
   * <ul>
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link QueryConfigurationClassTransformer#prepareNativeQueries(ConstPool,
   * ClassPool, ArrayMemberValue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QueryConfigurationClassTransformer.prepareNativeQueries(ConstPool, ClassPool, ArrayMemberValue)"
  })
  public void testPrepareNativeQueries_thenArrayLengthIsZero() throws NotFoundException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();

    QueryConfigurationClassTransformer queryConfigurationClassTransformer =
        new QueryConfigurationClassTransformer(namedQueries, nativeQueries, new ArrayList<>());
    ConstPool constantPool = new ConstPool("Thisclass");
    ClassPool pool = ClassPool.getDefault();
    ArrayMemberValue queryArray = new ArrayMemberValue(new ConstPool("Thisclass"));

    // Act
    queryConfigurationClassTransformer.prepareNativeQueries(constantPool, pool, queryArray);

    // Assert
    assertEquals(0, queryArray.getValue().length);
  }

  /**
   * Test {@link QueryConfigurationClassTransformer#prepareNamedQueries(ConstPool, ClassPool,
   * ArrayMemberValue)}.
   *
   * <ul>
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link QueryConfigurationClassTransformer#prepareNamedQueries(ConstPool,
   * ClassPool, ArrayMemberValue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QueryConfigurationClassTransformer.prepareNamedQueries(ConstPool, ClassPool, ArrayMemberValue)"
  })
  public void testPrepareNamedQueries_thenArrayLengthIsZero() throws NotFoundException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();

    QueryConfigurationClassTransformer queryConfigurationClassTransformer =
        new QueryConfigurationClassTransformer(namedQueries, nativeQueries, new ArrayList<>());
    ConstPool constantPool = new ConstPool("Thisclass");
    ClassPool pool = ClassPool.getDefault();
    ArrayMemberValue queryArray = new ArrayMemberValue(new ConstPool("Thisclass"));

    // Act
    queryConfigurationClassTransformer.prepareNamedQueries(constantPool, pool, queryArray);

    // Assert
    assertEquals(0, queryArray.getValue().length);
  }
}
