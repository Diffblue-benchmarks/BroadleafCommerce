/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;

public class I18nSolrIndexServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  public void testAddPropertyValues_whenFieldImpl_thenReturnNotHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", new ArrayList<>()));
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  public void testAddPropertyValues_whenProductBundleImpl_thenReturnNotHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", new ArrayList<>()));
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  public void testGetLocalePrefix_whenFieldImpl_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
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
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new I18nSolrIndexServiceExtensionHandler()).getPriority());
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority2() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();
    i18nSolrIndexServiceExtensionHandler.addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name",
        new ArrayList<>());

    // Act and Assert
    assertEquals(1000, i18nSolrIndexServiceExtensionHandler.getPriority());
  }
}
