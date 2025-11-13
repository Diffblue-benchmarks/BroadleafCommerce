package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import org.apache.xerces.dom.DOMImplementationImpl;
import org.apache.xerces.jaxp.DocumentBuilderImpl;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.ResourceLoader;

public class ImportProcessorDiffblueTest {
  /**
   * Test {@link ImportProcessor#ImportProcessor(ResourceLoader)}.
   *
   * <p>Method under test: {@link ImportProcessor#ImportProcessor(ResourceLoader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImportProcessor.<init>(ResourceLoader)"})
  public void testNewImportProcessor() {
    // Arrange and Act
    ImportProcessor actualImportProcessor =
        new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    ResourceLoader resourceLoader = actualImportProcessor.loader;
    Collection<ApplicationListener<?>> applicationListeners =
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getApplicationListeners();
    assertTrue(applicationListeners instanceof Set);
    Collection<ProtocolResolver> protocolResolvers =
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    DocumentBuilder documentBuilder = actualImportProcessor.builder;
    assertTrue(documentBuilder.getDOMImplementation() instanceof DOMImplementationImpl);
    assertTrue(documentBuilder instanceof DocumentBuilderImpl);
    ConfigurableListableBeanFactory beanFactory =
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getBeanFactory();
    assertTrue(beanFactory instanceof DefaultListableBeanFactory);
    assertTrue(resourceLoader instanceof AnnotationConfigReactiveWebApplicationContext);
    assertTrue(
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getEnvironment()
            instanceof StandardReactiveWebEnvironment);
    assertEquals(
        "", ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getApplicationName());
    assertNull(documentBuilder.getSchema());
    assertNull(
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getParentBeanFactory());
    assertNull(((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getParent());
    assertEquals(
        0L, ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getStartupDate());
    assertEquals(
        6,
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getBeanDefinitionCount());
    assertEquals(
        6,
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader)
            .getBeanDefinitionNames()
            .length);
    assertFalse(documentBuilder.isNamespaceAware());
    assertFalse(documentBuilder.isValidating());
    assertFalse(documentBuilder.isXIncludeAware());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) resourceLoader).isActive());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) resourceLoader).isRunning());
    assertTrue(applicationListeners.isEmpty());
    assertTrue(protocolResolvers.isEmpty());
    assertTrue(
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader)
            .getBeanFactoryPostProcessors()
            .isEmpty());
    assertSame(
        beanFactory,
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader)
            .getDefaultListableBeanFactory());
  }

  /**
   * Test {@link ImportProcessor#extract(ResourceInputStream[])}.
   *
   * <ul>
   *   <li>Then throw {@link MergeException}.
   * </ul>
   *
   * <p>Method under test: {@link ImportProcessor#extract(ResourceInputStream[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceInputStream[] ImportProcessor.extract(ResourceInputStream[])"})
  public void testExtract_thenThrowMergeException()
      throws UnsupportedEncodingException, MergeException {
    // Arrange
    ImportProcessor importProcessor =
        new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertThrows(
        MergeException.class,
        () ->
            importProcessor.extract(
                new ResourceInputStream[] {
                  new ResourceInputStream(
                      new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")
                }));
  }

  /**
   * Test {@link ImportProcessor#extract(ResourceInputStream[])}.
   *
   * <ul>
   *   <li>When empty array of {@link ResourceInputStream}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImportProcessor#extract(ResourceInputStream[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceInputStream[] ImportProcessor.extract(ResourceInputStream[])"})
  public void testExtract_whenEmptyArrayOfResourceInputStream_thenReturnArrayLengthIsZero()
      throws MergeException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext())
            .extract(new ResourceInputStream[] {})
            .length);
  }

  /**
   * Test {@link ImportProcessor#extract(ResourceInputStream[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImportProcessor#extract(ResourceInputStream[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceInputStream[] ImportProcessor.extract(ResourceInputStream[])"})
  public void testExtract_whenNull_thenReturnNull() throws MergeException {
    // Arrange, Act and Assert
    assertNull(
        new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext()).extract(null));
  }
}
