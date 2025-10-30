/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Autowired
  private BatchRetrieveDao batchRetrieveDao;

  /**
   * Test {@link BatchRetrieveDao#batchExecuteReadQuery(Query, List, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchRetrieveDao#batchExecuteReadQuery(Query, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BatchRetrieveDao.batchExecuteReadQuery(Query, List, String)"})
  public void testBatchExecuteReadQuery_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(batchRetrieveDao.batchExecuteReadQuery(null, new ArrayList<>(), "0123456789ABCDEF").isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BatchRetrieveDao}
   *   <li>{@link BatchRetrieveDao#setInClauseBatchSize(int)}
   *   <li>{@link BatchRetrieveDao#getInClauseBatchSize()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BatchRetrieveDao.<init>()", "int BatchRetrieveDao.getInClauseBatchSize()",
      "void BatchRetrieveDao.setInClauseBatchSize(int)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    BatchRetrieveDao actualBatchRetrieveDao = new BatchRetrieveDao();
    actualBatchRetrieveDao.setInClauseBatchSize(3);

    // Assert
    assertEquals(3, actualBatchRetrieveDao.getInClauseBatchSize());
  }
}
