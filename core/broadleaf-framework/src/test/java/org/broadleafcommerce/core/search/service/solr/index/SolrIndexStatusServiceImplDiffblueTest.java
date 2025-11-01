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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class SolrIndexStatusServiceImplDiffblueTest {
  /**
   * Method under test: {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}
   */
  @Test
  public void testGetSeedStatusInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}
   */
  @Test
  public void testIsEventIdInError() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();
    ArrayList<String> additionalInfoIds = new ArrayList<>();

    // Act and Assert
    assertTrue(solrIndexStatusServiceImpl.isEventIdInError(additionalInfoIds, new IndexStatusInfoImpl()).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}
   */
  @Test
  public void testIsEventIdInError2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();

    // Act and Assert
    assertTrue(
        solrIndexStatusServiceImpl.isEventIdInError(new ArrayList<>(), mock(IndexStatusInfoImpl.class)).isEmpty());
  }
}
