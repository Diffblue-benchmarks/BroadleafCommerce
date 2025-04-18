/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.i18n.service.TranslationService;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class I18nSolrIndexServiceExtensionHandlerDiffblueTest {
  @InjectMocks
  private I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;

  @Mock
  private LocaleService localeService;

  @Mock
  private SolrHelperService solrHelperService;

  @Mock
  private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  @Mock
  private TranslationService translationService;

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#init()}.
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void I18nSolrIndexServiceExtensionHandler.init()"})
  public void testInit() {
    // Arrange
    when(solrIndexServiceExtensionManager.registerHandler(Mockito.<SolrIndexServiceExtensionHandler>any()))
        .thenReturn(true);

    // Act
    i18nSolrIndexServiceExtensionHandler.init();

    // Assert
    verify(solrIndexServiceExtensionManager).registerHandler(isA(SolrIndexServiceExtensionHandler.class));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType I18nSolrIndexServiceExtensionHandler.addPropertyValues(Indexable, Field, FieldType, Map, String, List)"})
  public void testAddPropertyValues_whenFieldImpl_thenReturnNotHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", new ArrayList<>()));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType I18nSolrIndexServiceExtensionHandler.getLocalePrefix(Field, List)"})
  public void testGetLocalePrefix_whenFieldImpl_thenReturnNotHandled() {
    // Arrange
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.getLocalePrefix(field, new ArrayList<>()));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int I18nSolrIndexServiceExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1000, i18nSolrIndexServiceExtensionHandler.getPriority());
  }
}
