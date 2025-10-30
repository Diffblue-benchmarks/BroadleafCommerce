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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class I18nSolrSearchServiceExtensionHandlerDiffblueTest {
  @InjectMocks
  private I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler;

  @Mock
  private SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#init()}.
   * <p>
   * Method under test: {@link I18nSolrSearchServiceExtensionHandler#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void I18nSolrSearchServiceExtensionHandler.init()"})
  public void testInit() {
    // Arrange
    when(solrSearchServiceExtensionManager.getHandlers()).thenReturn(new ArrayList<>());

    // Act
    i18nSolrSearchServiceExtensionHandler.init();

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getHandlers();
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#init()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link I18nSolrSearchServiceExtensionHandler} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link I18nSolrSearchServiceExtensionHandler#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void I18nSolrSearchServiceExtensionHandler.init()"})
  public void testInit_givenArrayListAddI18nSolrSearchServiceExtensionHandler() {
    // Arrange
    ArrayList<SolrSearchServiceExtensionHandler> solrSearchServiceExtensionHandlerList = new ArrayList<>();
    solrSearchServiceExtensionHandlerList.add(new I18nSolrSearchServiceExtensionHandler());
    when(solrSearchServiceExtensionManager.getHandlers()).thenReturn(solrSearchServiceExtensionHandlerList);

    // Act
    i18nSolrSearchServiceExtensionHandler.init();

    // Assert
    verify(solrSearchServiceExtensionManager).getHandlers();
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#init()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link I18nSolrSearchServiceExtensionHandler#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void I18nSolrSearchServiceExtensionHandler.init()"})
  public void testInit_givenArrayListAddNull() {
    // Arrange
    ArrayList<SolrSearchServiceExtensionHandler> solrSearchServiceExtensionHandlerList = new ArrayList<>();
    solrSearchServiceExtensionHandlerList.add(null);
    when(solrSearchServiceExtensionManager.getHandlers()).thenReturn(solrSearchServiceExtensionHandlerList);

    // Act
    i18nSolrSearchServiceExtensionHandler.init();

    // Assert
    verify(solrSearchServiceExtensionManager, atLeast(1)).getHandlers();
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#buildPrefixListForIndexField(IndexField, FieldType, List)}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link I18nSolrSearchServiceExtensionHandler#buildPrefixListForIndexField(IndexField, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType I18nSolrSearchServiceExtensionHandler.buildPrefixListForIndexField(IndexField, FieldType, List)"})
  public void testBuildPrefixListForIndexField_givenFieldImpl_thenReturnNotHandled() {
    // Arrange
    IndexFieldImpl field = mock(IndexFieldImpl.class);
    when(field.getField()).thenReturn(new FieldImpl());

    // Act
    ExtensionResultStatusType actualBuildPrefixListForIndexFieldResult = i18nSolrSearchServiceExtensionHandler
        .buildPrefixListForIndexField(field, FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(field).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildPrefixListForIndexFieldResult);
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#getLocalePrefix(Field, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link I18nSolrSearchServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType I18nSolrSearchServiceExtensionHandler.getLocalePrefix(Field, List)"})
  public void testGetLocalePrefix_whenFieldImpl_thenReturnNotHandled() {
    // Arrange
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getLocalePrefix(field, new ArrayList<>()));
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link I18nSolrSearchServiceExtensionHandler#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int I18nSolrSearchServiceExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1000, i18nSolrSearchServiceExtensionHandler.getPriority());
  }
}
