package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractSolrIndexUpdateServiceImplDiffblueTest {
  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}.
   *
   * <ul>
   *   <li>Then return one thousand.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractSolrIndexUpdateServiceImpl.getQueueOfferTime()"})
  public void testGetQueueOfferTime_thenReturnOneThousand() {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler =
        mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl =
        new CatalogSolrIndexUpdateServiceImpl(new DefaultSolrIndexQueueProvider(), commandHandler);

    // Act
    long actualQueueOfferTime = catalogSolrIndexUpdateServiceImpl.getQueueOfferTime();

    // Assert
    verify(commandHandler).getCommandGroup();
    assertEquals(1000L, actualQueueOfferTime);
  }
}
