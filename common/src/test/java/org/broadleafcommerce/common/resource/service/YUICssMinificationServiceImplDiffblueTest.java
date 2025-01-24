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
import static org.junit.Assert.assertThrows;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml",
    "/bl-common-applicationContext-mbeans.xml", "/bl-common-applicationContext-persistence.xml",
    "/bl-common-applicationContext-servlet.xml", "/bl-common-applicationContext-wrapper.xml",
    "/bl-common-applicationContext.xml", "/bl-fake-applicationContext-ant.xml",
    "/blc-config/admin/framework/bl-common-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-common-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-common-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-common-applicationContext.xml",
    "/override-contexts/admin-root-autoconfiguration-overrides.xml",
    "/override-contexts/admin-servlet-autoconfiguration-overrides.xml",
    "/override-contexts/autoconfiguration-overrides.xml", "/override-contexts/autoconfiguration-servlet-overrides.xml",
    "/override-contexts/site-root-autoconfiguration-overrides.xml",
    "/override-contexts/site-servlet-autoconfiguration-overrides.xml",
    "/blc-config/admin/bl-admin-test-applicationContext.xml", "/blc-config/bl-test-applicationContext.xml",
    "/blc-config/site/bl-site-test-applicationContext.xml", "/context/config/client-override.xml",
    "/context/config/xml-import-override.xml", "/context/crossmodule/early-applicationContext.xml",
    "/context/crossmodule/early-xml-applicationContext.xml", "/context/crossmodule/late-applicationContext.xml",
    "/context/entityconfig/import-framework.xml", "/context/entityconfig/import-local.xml",
    "/context/importer/applicationContext.xml", "/context/importer/merge/applicationContext-servlet.xml",
    "/context/importer/merge/applicationContext.xml", "/context/merge/bl-framework.xml", "/context/merge/bl-module.xml",
    "/context/merge/local.xml", "/context/reader/bean-override-early-test-applicationContext.xml",
    "/context/reader/bean-override-framework-test-applicationContext.xml",
    "/context/reader/bean-override-local-test-applicationContext.xml", "/context/reader/merge/testbeans.xml",
    "/context/reader/merge/testbeans2.xml", "/context/reader/merge/testbeans3.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class YUICssMinificationServiceImplDiffblueTest {
  @Autowired
  private YUICssMinificationServiceImpl yUICssMinificationServiceImpl;

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMinifyCss() throws ResourceMinificationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: messageSource defined in bl-common-applicationContext.xml
    //   java.lang.IllegalStateException: Failed to load ApplicationContext
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:98)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'messageSource' defined in class path resource [bl-common-applicationContext.xml]: Initialization of bean failed; nested exception is org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'java.lang.String' to required type 'boolean' for property 'useCodeAsDefaultMessage'; nested exception is java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:628)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'java.lang.String' to required type 'boolean' for property 'useCodeAsDefaultMessage'; nested exception is java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertIfNecessary(AbstractNestablePropertyAccessor.java:600)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertForProperty(AbstractNestablePropertyAccessor.java:609)
    //       at org.springframework.beans.BeanWrapperImpl.convertForProperty(BeanWrapperImpl.java:219)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.convertForProperty(AbstractAutowireCapableBeanFactory.java:1756)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1712)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1452)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:619)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.propertyeditors.CustomBooleanEditor.setAsText(CustomBooleanEditor.java:154)
    //       at org.springframework.beans.TypeConverterDelegate.doConvertTextValue(TypeConverterDelegate.java:429)
    //       at org.springframework.beans.TypeConverterDelegate.doConvertValue(TypeConverterDelegate.java:402)
    //       at org.springframework.beans.TypeConverterDelegate.convertIfNecessary(TypeConverterDelegate.java:155)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertIfNecessary(AbstractNestablePropertyAccessor.java:590)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertForProperty(AbstractNestablePropertyAccessor.java:609)
    //       at org.springframework.beans.BeanWrapperImpl.convertForProperty(BeanWrapperImpl.java:219)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.convertForProperty(AbstractAutowireCapableBeanFactory.java:1756)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1712)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1452)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:619)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("foo");

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, new StringWriter());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code * /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_thenStringWriterToStringIsAsteriskSlash() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("*/ ");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("*/", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code :}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_thenStringWriterToStringIsColon() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("___YUICSSMIN_PSEUDOCLASSCOLON___");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(":", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code UUU:UUU:UUU:U{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String,
   * Reader, Writer)}
   */
  @Test
  public void testMinifyCss_thenStringWriterToStringIsUuuUuuUuuU() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("UUU:UUU:UUU:U{");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("UUU:UUU:UUU:U{", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link FileReader#FileReader(FileDescriptor)} with
   * {@link FileDescriptor#FileDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenFileReaderWithFileDescriptor() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    FileReader reader = new FileReader(new FileDescriptor());

    // Act and Assert
    assertThrows(ResourceMinificationException.class,
        () -> yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link PipedWriter#PipedWriter()}.</li>
   *   <li>Then throw {@link ResourceMinificationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenPipedWriter_thenThrowResourceMinificationException()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("foo");

    // Act and Assert
    assertThrows(ResourceMinificationException.class,
        () -> yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, new PipedWriter()));
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code :first-line{}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code :first-line
   * {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String,
   * Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithFirstLine_thenStringWriterToStringIsFirstLine()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader(":first-line{");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(":first-line {", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithFoo_thenStringWriterToStringIsFoo()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code !important}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code !important}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithImportant_thenStringWriterToStringIsImportant()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("!important");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("!important", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code ;}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithSemicolon_thenStringWriterToStringIsSemicolon()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader(" ;");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(";", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code U@charset "U";}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code @charset "U";U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithUCharsetU_thenStringWriterToStringIsCharsetUU()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("U@charset \"U\";");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("@charset \"U\";U", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code url( data:}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code url(data:}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithUrlData_thenStringWriterToStringIsUrlData()
      throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("url( data:");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("url(data:", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code "UU"}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code "UU"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  public void testMinifyCss_whenStringReaderWithUu_thenStringWriterToStringIsUu() throws ResourceMinificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl = new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("\"UU\"");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("\"UU\"", writer.toString());
  }
}
