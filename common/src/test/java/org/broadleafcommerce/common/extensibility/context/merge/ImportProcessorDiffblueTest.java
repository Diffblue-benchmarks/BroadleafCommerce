/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Set;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ResourceLoader;

public class ImportProcessorDiffblueTest {
  /**
   * Test {@link ImportProcessor#ImportProcessor(ResourceLoader)}.
   * <ul>
   *   <li>Then return {@link ImportProcessor#loader} ApplicationListeners
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportProcessor#ImportProcessor(ResourceLoader)}
   */
  @Test
  public void testNewImportProcessor_thenReturnLoaderApplicationListenersEmpty() {
    // Arrange, Act and Assert
    ResourceLoader resourceLoader = (new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext())).loader;
    Collection<ApplicationListener<?>> applicationListeners = ((AnnotationConfigReactiveWebApplicationContext) resourceLoader)
        .getApplicationListeners();
    assertTrue(applicationListeners instanceof Set);
    assertTrue(resourceLoader instanceof AnnotationConfigReactiveWebApplicationContext);
    assertTrue(applicationListeners.isEmpty());
    assertEquals(applicationListeners,
        ((AnnotationConfigReactiveWebApplicationContext) resourceLoader).getProtocolResolvers());
  }

  /**
   * Test {@link ImportProcessor#ImportProcessor(ResourceLoader)}.
   * <ul>
   *   <li>Then return {@link ImportProcessor#loader} ApplicationListeners size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportProcessor#ImportProcessor(ResourceLoader)}
   */
  @Test
  public void testNewImportProcessor_thenReturnLoaderApplicationListenersSizeIsOne() {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext loader = new AnnotationConfigReactiveWebApplicationContext();
    loader.addApplicationListener(mock(ApplicationListener.class));

    // Act and Assert
    ResourceLoader resourceLoader = (new ImportProcessor(loader)).loader;
    Collection<ApplicationListener<?>> applicationListeners = ((AnnotationConfigReactiveWebApplicationContext) resourceLoader)
        .getApplicationListeners();
    assertEquals(1, applicationListeners.size());
    assertTrue(applicationListeners instanceof Set);
    assertTrue(resourceLoader instanceof AnnotationConfigReactiveWebApplicationContext);
  }

  /**
   * Test {@link ImportProcessor#extract(ResourceInputStream[])}.
   * <ul>
   *   <li>Then throw {@link MergeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportProcessor#extract(ResourceInputStream[])}
   */
  @Test
  public void testExtract_thenThrowMergeException() throws UnsupportedEncodingException, MergeException {
    // Arrange
    ImportProcessor importProcessor = new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertThrows(MergeException.class, () -> importProcessor.extract(new ResourceInputStream[]{
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")}));
  }

  /**
   * Test {@link ImportProcessor#extract(ResourceInputStream[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportProcessor#extract(ResourceInputStream[])}
   */
  @Test
  public void testExtract_whenNull_thenReturnNull() throws MergeException {
    // Arrange, Act and Assert
    assertNull((new ImportProcessor(new AnnotationConfigReactiveWebApplicationContext())).extract(null));
  }
}
