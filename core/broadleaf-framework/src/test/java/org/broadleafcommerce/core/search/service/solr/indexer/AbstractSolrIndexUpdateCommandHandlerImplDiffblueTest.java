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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient.Builder;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.search.dao.IndexFieldDao;
import org.broadleafcommerce.core.search.dao.SolrIndexDao;
import org.broadleafcommerce.core.search.service.solr.SolrConfiguration;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class AbstractSolrIndexUpdateCommandHandlerImplDiffblueTest {
  @Mock
  private CatalogDocumentBuilder catalogDocumentBuilder;

  @InjectMocks
  private CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;

  @Mock
  private IndexFieldDao indexFieldDao;

  @Mock
  private LocaleService localeService;

  @Mock
  private PlatformTransactionManager platformTransactionManager;

  @Mock
  private ProductDao productDao;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private SiteService siteService;

  @Mock
  private SolrConfiguration solrConfiguration;

  @Mock
  private SolrHelperService solrHelperService;

  @Mock
  private SolrIndexDao solrIndexDao;

  @Mock
  private SolrIndexQueueProvider solrIndexQueueProvider;

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand() throws ServiceException {
    // Arrange
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");
    ArrayList<SolrInputDocument> docs = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl
        .executeCommandInternal(new IncrementalUpdateCommand(docs, new ArrayList<>()));

    // Assert
    verify(solrConfiguration).getPrimaryName();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand2() throws ServiceException {
    // Arrange
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl
        .executeCommandInternal(new IncrementalUpdateCommand(docs, new ArrayList<>()));

    // Assert
    verify(solrConfiguration).getPrimaryName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)} with {@code command}, {@code collectionName}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"})
  public void testExecuteCommandInternalWithCommandCollectionName() throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("The command cannot be null.");
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(stringList);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(command, atLeast(1)).getDeleteQueries();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)} with {@code command}, {@code collectionName}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"})
  public void testExecuteCommandInternalWithCommandCollectionName2() throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();
    solrInputDocumentList.add(mock(SolrInputDocument.class));
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(new ArrayList<>());
    when(command.getSolrInputDocuments()).thenReturn(solrInputDocumentList);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)} with {@code command}, {@code collectionName}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"})
  public void testExecuteCommandInternalWithCommandCollectionName3() throws ServiceException {
    // Arrange
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("The command cannot be null.");
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(stringList);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(command, atLeast(1)).getDeleteQueries();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)} with {@code command}, {@code collectionName}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"})
  public void testExecuteCommandInternalWithCommandCollectionName_givenArrayList() throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(new ArrayList<>());
    when(command.getSolrInputDocuments()).thenReturn(new ArrayList<>());

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)} with {@code command}, {@code collectionName}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"})
  public void testExecuteCommandInternalWithCommandCollectionName_givenArrayListAddNull()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(stringList);
    when(command.getSolrInputDocuments()).thenReturn(new ArrayList<>());

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(lbHttp2SolrClient).commit(eq("Collection Name"), eq(true), eq(true), eq(false));
    verify(solrConfiguration).getReindexServer();
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)} with {@code command}, {@code collectionName}.
   * <ul>
   *   <li>Then calls {@link SolrClient#add(String, Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"})
  public void testExecuteCommandInternalWithCommandCollectionName_thenCallsAdd()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("The command cannot be null.");

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();
    solrInputDocumentList.add(mock(SolrInputDocument.class));
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(stringList);
    when(command.getSolrInputDocuments()).thenReturn(solrInputDocumentList);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(lbHttp2SolrClient).add(eq("Collection Name"), isA(Collection.class));
    verify(lbHttp2SolrClient).commit(eq("Collection Name"), eq(true), eq(true), eq(false));
    verify(lbHttp2SolrClient).deleteByQuery(eq("Collection Name"), eq("The command cannot be null."));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)} with {@code command}, {@code collectionName}.
   * <ul>
   *   <li>Then calls {@link SolrClient#deleteByQuery(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"})
  public void testExecuteCommandInternalWithCommandCollectionName_thenCallsDeleteByQuery()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("The command cannot be null.");
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(stringList);
    when(command.getSolrInputDocuments()).thenReturn(new ArrayList<>());

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(lbHttp2SolrClient).commit(eq("Collection Name"), eq(true), eq(true), eq(false));
    verify(lbHttp2SolrClient).deleteByQuery(eq("Collection Name"), eq("The command cannot be null."));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand_givenArrayListAddSolrInputDocument()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();
    solrInputDocumentList.add(mock(SolrInputDocument.class));
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(new ArrayList<>());
    when(command.getSolrInputDocuments()).thenReturn(solrInputDocumentList);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command);

    // Assert
    verify(lbHttp2SolrClient).add(eq("Primary Name"), isA(Collection.class));
    verify(lbHttp2SolrClient).commit(eq("Primary Name"), eq(true), eq(true), eq(false));
    verify(solrConfiguration).getPrimaryName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code The command cannot be null.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand_givenArrayListAddTheCommandCannotBeNull()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("The command cannot be null.");
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(stringList);
    when(command.getSolrInputDocuments()).thenReturn(new ArrayList<>());

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command);

    // Assert
    verify(lbHttp2SolrClient).commit(eq("Primary Name"), eq(true), eq(true), eq(false));
    verify(lbHttp2SolrClient).deleteByQuery(eq("Primary Name"), eq("The command cannot be null."));
    verify(solrConfiguration).getPrimaryName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link IncrementalUpdateCommand#getDeleteQueries()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand_givenArrayList_thenCallsGetDeleteQueries() throws ServiceException {
    // Arrange
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");
    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(new ArrayList<>());
    when(command.getSolrInputDocuments()).thenReturn(new ArrayList<>());

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command);

    // Assert
    verify(solrConfiguration).getPrimaryName();
    verify(command, atLeast(1)).getDeleteQueries();
    verify(command, atLeast(1)).getSolrInputDocuments();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand_givenNull_whenArrayListAddNull()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    ArrayList<String> deleteQueries = new ArrayList<>();
    deleteQueries.add(null);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(new IncrementalUpdateCommand(docs, deleteQueries));

    // Assert
    verify(lbHttp2SolrClient).add(eq("Primary Name"), isA(Collection.class));
    verify(lbHttp2SolrClient).commit(eq("Primary Name"), eq(true), eq(true), eq(false));
    verify(solrConfiguration).getPrimaryName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <ul>
   *   <li>Given {@code The command cannot be null.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand_givenTheCommandCannotBeNull()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    ArrayList<String> deleteQueries = new ArrayList<>();
    deleteQueries.add("The command cannot be null.");

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(new IncrementalUpdateCommand(docs, deleteQueries));

    // Assert
    verify(lbHttp2SolrClient).add(eq("Primary Name"), isA(Collection.class));
    verify(lbHttp2SolrClient).commit(eq("Primary Name"), eq(true), eq(true), eq(false));
    verify(lbHttp2SolrClient).deleteByQuery(eq("Primary Name"), eq("The command cannot be null."));
    verify(solrConfiguration).getPrimaryName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)} with {@code command}.
   * <ul>
   *   <li>Then calls {@link SolrClient#add(String, Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"})
  public void testExecuteCommandInternalWithCommand_thenCallsAdd()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl
        .executeCommandInternal(new IncrementalUpdateCommand(docs, new ArrayList<>()));

    // Assert
    verify(lbHttp2SolrClient).add(eq("Primary Name"), isA(Collection.class));
    verify(lbHttp2SolrClient).commit(eq("Primary Name"), eq(true), eq(true), eq(false));
    verify(solrConfiguration).getPrimaryName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#commit(String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link LBHttp2SolrClient} {@link SolrClient#commit(String, boolean, boolean, boolean)} return {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#commit(String, boolean, boolean, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#commit(String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.commit(String, boolean, boolean, boolean)"})
  public void testCommit_givenLBHttp2SolrClientCommitReturnUpdateResponse_thenCallsCommit() throws Exception {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.commit("Collection Name", true, true, true);

    // Assert
    verify(lbHttp2SolrClient).commit(eq("Collection Name"), eq(true), eq(true), eq(true));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#addDocument(String, SolrInputDocument)}.
   * <ul>
   *   <li>Given {@link LBHttp2SolrClient} {@link SolrClient#add(SolrInputDocument)} return {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#add(SolrInputDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#addDocument(String, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.addDocument(String, SolrInputDocument)"})
  public void testAddDocument_givenLBHttp2SolrClientAddReturnUpdateResponse_thenCallsAdd() throws Exception {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<SolrInputDocument>any())).thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.addDocument("Collection", null);

    // Assert
    verify(lbHttp2SolrClient).add((SolrInputDocument) isNull());
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQuery(String, String)}.
   * <ul>
   *   <li>Then calls {@link SolrClient#deleteByQuery(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQuery(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.deleteByQuery(String, String)"})
  public void testDeleteByQuery_thenCallsDeleteByQuery() throws Exception {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.deleteByQuery("Collection", "Query");

    // Assert
    verify(lbHttp2SolrClient).deleteByQuery(eq("Collection"), eq("Query"));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQueries(String, List)}.
   * <ul>
   *   <li>Then calls {@link SolrClient#deleteByQuery(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQueries(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.deleteByQueries(String, List)"})
  public void testDeleteByQueries_thenCallsDeleteByQuery() throws Exception {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    ArrayList<String> queries = new ArrayList<>();
    queries.add("Queries");

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.deleteByQueries("Collection", queries);

    // Assert
    verify(lbHttp2SolrClient).deleteByQuery(eq("Collection"), eq("Queries"));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByIds(String, List)}.
   * <ul>
   *   <li>Then calls {@link SolrClient#deleteById(String, List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByIds(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractSolrIndexUpdateCommandHandlerImpl.deleteByIds(String, List)"})
  public void testDeleteByIds_thenCallsDeleteById() throws Exception {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteById(Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.deleteByIds("Collection", ids);

    // Assert
    verify(lbHttp2SolrClient).deleteById(eq("Collection"), isA(List.class));
    verify(solrConfiguration).getReindexServer();
  }
}
