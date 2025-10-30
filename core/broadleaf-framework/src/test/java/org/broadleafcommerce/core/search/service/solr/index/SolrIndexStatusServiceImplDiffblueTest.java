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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SolrIndexStatusServiceImplDiffblueTest {
  /**
   * Test {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}.
   * <p>
   * Method under test: {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IndexStatusInfo SolrIndexStatusServiceImpl.getSeedStatusInstance()"})
  public void testGetSeedStatusInstance() {
    // Arrange and Act
    IndexStatusInfo actualSeedStatusInstance = (new SolrIndexStatusServiceImpl()).getSeedStatusInstance();

    // Assert
    assertTrue(actualSeedStatusInstance instanceof IndexStatusInfoImpl);
    assertNull(actualSeedStatusInstance.getLastIndexDate());
    assertTrue(actualSeedStatusInstance.getAdditionalInfo().isEmpty());
    assertTrue(actualSeedStatusInstance.getDeadIndexEvents().isEmpty());
    assertTrue(actualSeedStatusInstance.getIndexErrors().isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List SolrIndexStatusServiceImpl.isEventIdInError(Collection, IndexStatusInfo)"})
  public void testIsEventIdInError_whenArrayList_thenReturnEmpty() {
    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();
    ArrayList<String> additionalInfoIds = new ArrayList<>();

    // Act and Assert
    assertTrue(solrIndexStatusServiceImpl.isEventIdInError(additionalInfoIds, new IndexStatusInfoImpl()).isEmpty());
  }
}
