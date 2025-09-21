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
package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.ImmutableMap;
import com.google.javascript.jscomp.AnonymousFunctionNamingPolicy;
import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.ClosureCodingConvention;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.Environment;
import com.google.javascript.jscomp.CompilerOptions.Es6ModuleTranspilation;
import com.google.javascript.jscomp.CompilerOptions.InstrumentOption;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.jscomp.CompilerOptions.PropertyCollapseLevel;
import com.google.javascript.jscomp.CompilerOptions.Reach;
import com.google.javascript.jscomp.CompilerOptions.TracerMode;
import com.google.javascript.jscomp.CompilerOptions.TweakProcessing;
import com.google.javascript.jscomp.ErrorFormat;
import com.google.javascript.jscomp.PropertyRenamingPolicy;
import com.google.javascript.jscomp.SourceMap;
import com.google.javascript.jscomp.SourceMap.DetailLevel;
import com.google.javascript.jscomp.SourceMap.Format;
import com.google.javascript.jscomp.VariableRenamingPolicy;
import com.google.javascript.jscomp.deps.ModuleLoader;
import com.google.javascript.jscomp.deps.ModuleLoader.PathEscaper;
import com.google.javascript.jscomp.deps.ModuleLoader.ResolutionMode;
import com.google.javascript.jscomp.parsing.Config;
import com.google.javascript.jscomp.parsing.Config.JsDocParsing;
import java.io.CharArrayReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(
    classes = {GoogleClosureJavascriptMinificationServiceImpl.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoogleClosureJavascriptMinificationServiceImplDiffblueTest {
  @Autowired
  private GoogleClosureJavascriptMinificationServiceImpl
      googleClosureJavascriptMinificationServiceImpl;

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code A;}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_thenStringWriterToStringIsA()
      throws IOException, ResourceMinificationException {
    // Arrange
    CharArrayReader reader = new CharArrayReader("\u0001A\u0001A".toCharArray(), 1, 1);
    StringWriter writer = new StringWriter();

    // Act
    googleClosureJavascriptMinificationServiceImpl.minifyJs("foo.txt", reader, writer);

    // Assert
    assertEquals("A;", writer.toString());
    assertFalse(reader.ready());
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@code '\'\''}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenApostropheBackslashApostropheBackslashApostropheApostrophe()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    googleClosureJavascriptMinificationServiceImpl.minifyJs(" '\\'\\'' ", reader, writer);

    // Assert
    assertEquals("foo;", writer.toString());
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link CharArrayReader#CharArrayReader(char[])} with A start of heading A
   *       toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenCharArrayReaderWithAStartOfHeadingAToCharArray()
      throws ResourceMinificationException {
    // Arrange
    CharArrayReader reader = new CharArrayReader("\u0001A\u0001A".toCharArray());

    // Act and Assert
    assertThrows(
        ResourceMinificationException.class,
        () ->
            googleClosureJavascriptMinificationServiceImpl.minifyJs(
                "foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@code ./}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo;}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenDotSlash_thenStringWriterToStringIsFoo()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    googleClosureJavascriptMinificationServiceImpl.minifyJs("./", reader, writer);

    // Assert
    assertEquals("foo;", writer.toString());
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link FileReader#FileReader(FileDescriptor)} with {@link
   *       FileDescriptor#FileDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenFileReaderWithFileDescriptor() throws ResourceMinificationException {
    // Arrange
    FileReader reader = new FileReader(new FileDescriptor());

    // Act and Assert
    assertThrows(
        ResourceMinificationException.class,
        () ->
            googleClosureJavascriptMinificationServiceImpl.minifyJs(
                "foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with cr.
   *   <li>Then throw {@link ResourceMinificationException}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenStringReaderWithCr_thenThrowResourceMinificationException()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("\r");

    // Act and Assert
    assertThrows(
        ResourceMinificationException.class,
        () ->
            googleClosureJavascriptMinificationServiceImpl.minifyJs(
                "foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo;}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenStringReaderWithFoo_thenStringWriterToStringIsFoo()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    googleClosureJavascriptMinificationServiceImpl.minifyJs("foo.txt", reader, writer);

    // Assert
    assertEquals("foo;", writer.toString());
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code import Ufrom "U" ;}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenStringReaderWithImportUfromU() throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("import Ufrom \"U\" ;");

    // Act and Assert
    assertThrows(
        ResourceMinificationException.class,
        () ->
            googleClosureJavascriptMinificationServiceImpl.minifyJs(
                "foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code U= goog.provide (UU)}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleClosureJavascriptMinificationServiceImpl#minifyJs(String,
   * Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoogleClosureJavascriptMinificationServiceImpl.minifyJs(String, Reader, Writer)"
  })
  public void testMinifyJs_whenStringReaderWithUGoogProvideUu()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("U= goog.provide (UU)");

    // Act and Assert
    assertThrows(
        ResourceMinificationException.class,
        () ->
            googleClosureJavascriptMinificationServiceImpl.minifyJs(
                "foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link GoogleClosureJavascriptMinificationServiceImpl#getCompilerOptions()}.
   *
   * <p>Method under test: {@link
   * GoogleClosureJavascriptMinificationServiceImpl#getCompilerOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompilerOptions GoogleClosureJavascriptMinificationServiceImpl.getCompilerOptions()"
  })
  public void testGetCompilerOptions() {
    // Arrange and Act
    CompilerOptions actualCompilerOptions =
        googleClosureJavascriptMinificationServiceImpl.getCompilerOptions();

    // Assert
    assertTrue(actualCompilerOptions.getCodingConvention() instanceof ClosureCodingConvention);
    assertEquals("", actualCompilerOptions.getProductionInstrumentationArrayName());
    assertEquals("", actualCompilerOptions.aliasStringsBlacklist);
    assertEquals("// Input %num%", actualCompilerOptions.inputDelimiter);
    assertNull(actualCompilerOptions.getPropertyReservedNamingFirstChars());
    assertNull(actualCompilerOptions.getPropertyReservedNamingNonFirstChars());
    assertNull(actualCompilerOptions.cssRenamingMap);
    assertNull(actualCompilerOptions.messageBundle);
    assertNull(actualCompilerOptions.getRenamePrefixNamespace());
    assertNull(actualCompilerOptions.locale);
    assertNull(actualCompilerOptions.renamePrefix);
    assertNull(actualCompilerOptions.sourceMapOutputPath);
    assertNull(actualCompilerOptions.syntheticBlockEndMarker);
    assertNull(actualCompilerOptions.syntheticBlockStartMarker);
    assertNull(actualCompilerOptions.getDebugLogDirectory());
    assertEquals(0, actualCompilerOptions.getBrowserFeaturesetYear().intValue());
    assertEquals(1, actualCompilerOptions.getConformanceConfigs().size());
    assertEquals(3, actualCompilerOptions.getPackageJsonEntryNames().size());
    assertEquals(500, actualCompilerOptions.getLineLengthThreshold());
    assertEquals(AnonymousFunctionNamingPolicy.OFF, actualCompilerOptions.anonymousFunctionNaming);
    assertEquals(CheckLevel.ERROR, actualCompilerOptions.brokenClosureRequiresLevel);
    assertEquals(CheckLevel.OFF, actualCompilerOptions.checkGlobalNamesLevel);
    assertEquals(Environment.BROWSER, actualCompilerOptions.getEnvironment());
    assertEquals(Es6ModuleTranspilation.COMPILE, actualCompilerOptions.getEs6ModuleTranspilation());
    assertEquals(InstrumentOption.NONE, actualCompilerOptions.getInstrumentForCoverageOption());
    assertEquals(LanguageMode.ECMASCRIPT5, actualCompilerOptions.getLanguageIn());
    assertEquals(PropertyCollapseLevel.NONE, actualCompilerOptions.getPropertyCollapseLevel());
    assertEquals(Reach.LOCAL_ONLY, actualCompilerOptions.getInlineFunctionsLevel());
    assertEquals(TracerMode.OFF, actualCompilerOptions.getTracerMode());
    assertEquals(TweakProcessing.OFF, actualCompilerOptions.getTweakProcessing());
    assertEquals(ErrorFormat.FULL, actualCompilerOptions.getErrorFormat());
    assertEquals(PropertyRenamingPolicy.OFF, actualCompilerOptions.getPropertyRenaming());
    assertEquals(DetailLevel.ALL, actualCompilerOptions.sourceMapDetailLevel);
    assertEquals(Format.DEFAULT, actualCompilerOptions.sourceMapFormat);
    assertEquals(VariableRenamingPolicy.LOCAL, actualCompilerOptions.variableRenaming);
    assertEquals(PathEscaper.ESCAPE, actualCompilerOptions.getPathEscaper());
    assertEquals(ResolutionMode.BROWSER, actualCompilerOptions.getModuleResolutionMode());
    assertEquals(JsDocParsing.TYPES_ONLY, actualCompilerOptions.isParseJsDocDocumentation());
    assertFalse(actualCompilerOptions.assumeClosuresOnlyCaptureReferences());
    assertFalse(actualCompilerOptions.assumeStrictThis());
    assertFalse(actualCompilerOptions.getAssumeStaticInheritanceRequired());
    assertFalse(actualCompilerOptions.getCheckDeterminism());
    assertFalse(actualCompilerOptions.getInferTypes());
    assertFalse(actualCompilerOptions.getInstrumentForCoverageOnly());
    assertFalse(actualCompilerOptions.getIsolatePolyfills());
    assertFalse(actualCompilerOptions.getPreferLineBreakAtEndOfFile());
    assertFalse(actualCompilerOptions.getProcessCommonJSModules());
    assertFalse(actualCompilerOptions.getRewritePolyfills());
    assertFalse(actualCompilerOptions.getUseOriginalNamesInOutput());
    assertFalse(actualCompilerOptions.isChromePassEnabled());
    assertFalse(actualCompilerOptions.isExternExportsEnabled());
    assertFalse(actualCompilerOptions.isPrettyPrint());
    assertFalse(actualCompilerOptions.isRemoveUnusedClassProperties());
    assertFalse(actualCompilerOptions.isTypecheckingEnabled());
    assertFalse(actualCompilerOptions.aliasAllStrings);
    assertFalse(actualCompilerOptions.checkSuspiciousCode);
    assertFalse(actualCompilerOptions.checkSymbols);
    assertFalse(actualCompilerOptions.collapseAnonymousFunctions);
    assertFalse(actualCompilerOptions.computeFunctionSideEffects);
    assertFalse(actualCompilerOptions.devirtualizeMethods);
    assertFalse(actualCompilerOptions.exportTestFunctions);
    assertFalse(actualCompilerOptions.flowSensitiveInlineVariables);
    assertFalse(actualCompilerOptions.gatherCssNames);
    assertFalse(actualCompilerOptions.generateExports);
    assertFalse(actualCompilerOptions.generatePseudoNames);
    assertFalse(actualCompilerOptions.inlineConstantVars);
    assertFalse(actualCompilerOptions.inlineVariables);
    assertFalse(actualCompilerOptions.lineBreak);
    assertFalse(actualCompilerOptions.markAsCompiled);
    assertFalse(actualCompilerOptions.optimizeCalls);
    assertFalse(actualCompilerOptions.preserveTypeAnnotations);
    assertFalse(actualCompilerOptions.printInputDelimiter);
    assertFalse(actualCompilerOptions.removeUnusedPrototypeProperties);
    assertFalse(actualCompilerOptions.removeUnusedVars);
    assertFalse(actualCompilerOptions.reserveRawExports);
    assertFalse(actualCompilerOptions.rewriteFunctionExpressions);
    assertFalse(actualCompilerOptions.rewriteGlobalDeclarationsForTryCatchWrapping);
    assertFalse(actualCompilerOptions.smartNameRemoval);
    ImmutableMap<String, String> browserResolverPrefixReplacements =
        actualCompilerOptions.getBrowserResolverPrefixReplacements();
    assertTrue(browserResolverPrefixReplacements.isEmpty());
    assertTrue(actualCompilerOptions.getAssumeGettersArePure());
    assertTrue(actualCompilerOptions.getCollapseObjectLiterals());
    assertTrue(actualCompilerOptions.sourceMapLocationMappings.isEmpty());
    assertTrue(actualCompilerOptions.aliasableStrings.isEmpty());
    assertTrue(actualCompilerOptions.stripNamePrefixes.isEmpty());
    assertTrue(actualCompilerOptions.stripNameSuffixes.isEmpty());
    assertTrue(actualCompilerOptions.stripTypePrefixes.isEmpty());
    assertTrue(actualCompilerOptions.stripTypes.isEmpty());
    assertTrue(actualCompilerOptions.closurePass);
    assertTrue(actualCompilerOptions.coalesceVariableNames);
    assertTrue(actualCompilerOptions.collapseVariableDeclarations);
    assertTrue(actualCompilerOptions.convertToDottedProperties);
    assertTrue(actualCompilerOptions.deadAssignmentElimination);
    assertTrue(actualCompilerOptions.foldConstants);
    assertTrue(actualCompilerOptions.labelRenaming);
    assertTrue(actualCompilerOptions.optimizeArgumentsArray);
    assertTrue(actualCompilerOptions.removeDeadCode);
    assertTrue(actualCompilerOptions.removeUnusedLocalVars);
    assertSame(browserResolverPrefixReplacements, actualCompilerOptions.getDefineReplacements());
    assertSame(browserResolverPrefixReplacements, actualCompilerOptions.getTweakReplacements());
  }
}
