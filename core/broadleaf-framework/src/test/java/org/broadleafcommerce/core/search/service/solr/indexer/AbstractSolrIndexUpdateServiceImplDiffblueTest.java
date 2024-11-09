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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import org.apache.solr.common.SolrInputDocument;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;

public class AbstractSolrIndexUpdateServiceImplDiffblueTest {
  @MockBean
  private SolrIndexQueueProvider solrIndexQueueProvider;

  @MockBean
  private SolrIndexUpdateCommandHandler solrIndexUpdateCommandHandler;

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}
   */
  @Test
  public void testGetCommandGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals("catalog",
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getCommandGroup());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}
   */
  @Test
  public void testGetCommandGroup2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals("catalog",
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getCommandGroup());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}
   */
  @Test
  public void testIsRunning() {
    // Arrange, Act and Assert
    assertFalse(AbstractSolrIndexUpdateServiceImpl.isRunning("42"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)} with
   * {@code documents}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)}
   */
  @Test
  public void testUpdateIndexWithDocuments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new LinkedBlockingDeque<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act
    catalogSolrIndexUpdateServiceImpl.updateIndex(new ArrayList<>());

    // Assert
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)} with
   * {@code documents}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)}
   */
  @Test
  public void testUpdateIndexWithDocuments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new SynchronousQueue<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> catalogSolrIndexUpdateServiceImpl.updateIndex(new ArrayList<>()));
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)} with
   * {@code documents}, {@code deleteQueries}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)}
   */
  @Test
  public void testUpdateIndexWithDocumentsDeleteQueries() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new LinkedBlockingDeque<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateServiceImpl.updateIndex(documents, new ArrayList<>());

    // Assert
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)} with
   * {@code documents}, {@code deleteQueries}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)}
   */
  @Test
  public void testUpdateIndexWithDocumentsDeleteQueries2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new SynchronousQueue<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogSolrIndexUpdateServiceImpl.updateIndex(documents, new ArrayList<>()));
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        locales);

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        locales);

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)} with
   * {@code indexable}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)}
   */
  @Test
  public void testBuildDocumentWithIndexable_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}
   */
  @Test
  public void testGetQueuePollTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals(60000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueuePollTime());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}
   */
  @Test
  public void testGetQueuePollTime2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals(60000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueuePollTime());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}
   */
  @Test
  public void testGetQueueOfferTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals(1000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueueOfferTime());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}
   */
  @Test
  public void testGetQueueOfferTime2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals(1000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueueOfferTime());
  }
}
