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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import org.apache.xerces.dom.DOMImplementationImpl;
import org.apache.xerces.jaxp.DocumentBuilderImpl;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

public class ImportProcessorDiffblueTest {
  /**
   * Method under test: {@link ImportProcessor#extract(ResourceInputStream[])}
   */
  @Test
  public void testExtract() throws UnsupportedEncodingException, MergeException {
    // Arrange
    ImportProcessor importProcessor = new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertThrows(MergeException.class, () -> importProcessor.extract(new ResourceInputStream[]{
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")}));
  }

  /**
   * Method under test: {@link ImportProcessor#extract(ResourceInputStream[])}
   */
  @Test
  public void testExtract2() throws MergeException {
    // Arrange, Act and Assert
    assertNull((new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext())).extract(null));
  }

  /**
   * Method under test: {@link ImportProcessor#ImportProcessor(ResourceLoader)}
   */
  @Test
  public void testNewImportProcessor() {
    // Arrange, Act and Assert
    DocumentBuilder documentBuilder = (new ImportProcessor(mock(DefaultResourceLoader.class))).builder;
    assertTrue(documentBuilder.getDOMImplementation() instanceof DOMImplementationImpl);
    assertTrue(documentBuilder instanceof DocumentBuilderImpl);
    assertNull(documentBuilder.getSchema());
    assertFalse(documentBuilder.isNamespaceAware());
    assertFalse(documentBuilder.isValidating());
    assertFalse(documentBuilder.isXIncludeAware());
  }
}
