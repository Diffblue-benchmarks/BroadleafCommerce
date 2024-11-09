/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class SearchFacetCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetCustomPersistenceHandler searchFacetCustomPersistenceHandler = new SearchFacetCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(searchFacetCustomPersistenceHandler.canHandleRemove(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetCustomPersistenceHandler searchFacetCustomPersistenceHandler = new SearchFacetCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleRemoveResult = searchFacetCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetCustomPersistenceHandler searchFacetCustomPersistenceHandler = new SearchFacetCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.search.domain.SearchFacet");

    // Act
    Boolean actualCanHandleRemoveResult = searchFacetCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetCustomPersistenceHandler searchFacetCustomPersistenceHandler = new SearchFacetCustomPersistenceHandler();

    // Act and Assert
    assertFalse(searchFacetCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link SearchFacetCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()} Entity is
   * {@link Entity}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove_whenPersistencePackageEntityIsEntity_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetCustomPersistenceHandler searchFacetCustomPersistenceHandler = new SearchFacetCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> searchFacetCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.search.domain.SearchFacetRange"), isNull());
  }
}
