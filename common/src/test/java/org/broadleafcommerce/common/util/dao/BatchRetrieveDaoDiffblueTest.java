package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BatchRetrieveDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BatchRetrieveDaoDiffblueTest {
  @Autowired private BatchRetrieveDao batchRetrieveDao;

  /**
   * Test {@link BatchRetrieveDao#batchExecuteReadQuery(Query, List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BatchRetrieveDao#batchExecuteReadQuery(Query, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BatchRetrieveDao.batchExecuteReadQuery(Query, List, String)"})
  public void testBatchExecuteReadQuery_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        batchRetrieveDao
            .batchExecuteReadQuery(null, new ArrayList<>(), "0123456789ABCDEF")
            .isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BatchRetrieveDao}
   *   <li>{@link BatchRetrieveDao#setInClauseBatchSize(int)}
   *   <li>{@link BatchRetrieveDao#getInClauseBatchSize()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BatchRetrieveDao.<init>()",
    "int BatchRetrieveDao.getInClauseBatchSize()",
    "void BatchRetrieveDao.setInClauseBatchSize(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BatchRetrieveDao actualBatchRetrieveDao = new BatchRetrieveDao();
    actualBatchRetrieveDao.setInClauseBatchSize(3);

    // Assert
    assertEquals(3, actualBatchRetrieveDao.getInClauseBatchSize());
  }
}
