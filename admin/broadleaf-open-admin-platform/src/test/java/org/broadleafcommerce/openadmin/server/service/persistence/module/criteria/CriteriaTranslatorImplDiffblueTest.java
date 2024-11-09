/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.exception.NoPossibleResultsException;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class CriteriaTranslatorImplDiffblueTest {
  /**
   * Test
   * {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  public void testDetermineRoot() throws NoPossibleResultsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, new ArrayList<>()));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  public void testGetAppropriateLargeSortingValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    Class<Object> javaType = Object.class;

    // Act and Assert
    assertNull(criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType));
  }
}
