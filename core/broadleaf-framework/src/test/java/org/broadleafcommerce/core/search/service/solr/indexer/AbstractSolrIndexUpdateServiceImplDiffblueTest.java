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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AbstractSolrIndexUpdateServiceImplDiffblueTest {
  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractSolrIndexUpdateServiceImpl.isRunning(String)"})
  public void testIsRunning() {
    // Arrange, Act and Assert
    assertFalse(AbstractSolrIndexUpdateServiceImpl.isRunning("42"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)} with {@code indexable}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument AbstractSolrIndexUpdateServiceImpl.buildDocument(Indexable)"})
  public void testBuildDocumentWithIndexable_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl
        .buildDocument(new ProductBundleImpl());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AbstractSolrIndexUpdateServiceImpl.getQueuePollTime()"})
  public void testGetQueuePollTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals(60000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueuePollTime());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AbstractSolrIndexUpdateServiceImpl.getQueueOfferTime()"})
  public void testGetQueueOfferTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals(1000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueueOfferTime());
  }
}
