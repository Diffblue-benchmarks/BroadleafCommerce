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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.search.service.solr.SolrConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AbstractSolrIndexUpdateCommandHandlerImplDiffblueTest {
  @InjectMocks
  private CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;

  @Mock private SolrConfiguration solrConfiguration;

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#getCommandGroup()}.
   *
   * <p>Method under test: {@link AbstractSolrIndexUpdateCommandHandlerImpl#getCommandGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractSolrIndexUpdateCommandHandlerImpl.getCommandGroup()"})
  public void testGetCommandGroup() {
    // Arrange, Act and Assert
    assertEquals("catalog", new CatalogSolrIndexUpdateCommandHandlerImpl().getCommandGroup());
  }

  /**
   * Test {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)} with {@code command}, {@code collectionName}.
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"
  })
  public void testExecuteCommandInternalWithCommandCollectionName() throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Delete Queries");

    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(stringList);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(command, atLeast(1)).getDeleteQueries();
  }

  /**
   * Test {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)} with {@code command}, {@code collectionName}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"
  })
  public void testExecuteCommandInternalWithCommandCollectionName_givenArrayList()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

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
   * Test {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)} with {@code command}, {@code collectionName}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"
  })
  public void testExecuteCommandInternalWithCommandCollectionName_givenNull()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenReturn(null);
    when(command.getSolrInputDocuments()).thenReturn(null);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(command).getDeleteQueries();
    verify(command).getSolrInputDocuments();
  }

  /**
   * Test {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)} with {@code command}, {@code collectionName}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand, String)"
  })
  public void testExecuteCommandInternalWithCommandCollectionName_givenRuntimeException()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    IncrementalUpdateCommand command = mock(IncrementalUpdateCommand.class);
    when(command.getDeleteQueries()).thenThrow(new RuntimeException());

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command, "Collection Name");

    // Assert
    verify(command).getDeleteQueries();
  }

  /**
   * Test {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   * with {@code command}.
   *
   * <ul>
   *   <li>Then calls {@link SolrConfiguration#getPrimaryName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"
  })
  public void testExecuteCommandInternalWithCommand_thenCallsGetPrimaryName()
      throws ServiceException {
    // Arrange
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");
    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    IncrementalUpdateCommand command = new IncrementalUpdateCommand(docs, new ArrayList<>());

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command);

    // Assert
    verify(solrConfiguration).getPrimaryName();
  }

  /**
   * Test {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   * with {@code command}.
   *
   * <ul>
   *   <li>Then calls {@link SolrConfiguration#getPrimaryName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(IncrementalUpdateCommand)"
  })
  public void testExecuteCommandInternalWithCommand_thenCallsGetPrimaryName2()
      throws ServiceException {
    // Arrange
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");
    IncrementalUpdateCommand command = new IncrementalUpdateCommand(null, null);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeCommandInternal(command);

    // Assert
    verify(solrConfiguration).getPrimaryName();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#getForegroundCollectionName()}.
   *
   * <ul>
   *   <li>Then return {@code Primary Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#getForegroundCollectionName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractSolrIndexUpdateCommandHandlerImpl.getForegroundCollectionName()"
  })
  public void testGetForegroundCollectionName_thenReturnPrimaryName() {
    // Arrange
    when(solrConfiguration.getPrimaryName()).thenReturn("Primary Name");

    // Act
    String actualForegroundCollectionName =
        catalogSolrIndexUpdateCommandHandlerImpl.getForegroundCollectionName();

    // Assert
    verify(solrConfiguration).getPrimaryName();
    assertEquals("Primary Name", actualForegroundCollectionName);
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#getBackgroundCollectionName()}.
   *
   * <ul>
   *   <li>Then return {@code Reindex Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSolrIndexUpdateCommandHandlerImpl#getBackgroundCollectionName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractSolrIndexUpdateCommandHandlerImpl.getBackgroundCollectionName()"
  })
  public void testGetBackgroundCollectionName_thenReturnReindexName() {
    // Arrange
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act
    String actualBackgroundCollectionName =
        catalogSolrIndexUpdateCommandHandlerImpl.getBackgroundCollectionName();

    // Assert
    verify(solrConfiguration).getReindexName();
    assertEquals("Reindex Name", actualBackgroundCollectionName);
  }
}
