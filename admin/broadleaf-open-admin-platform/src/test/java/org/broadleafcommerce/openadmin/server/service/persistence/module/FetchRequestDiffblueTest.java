package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.junit.Test;

public class FetchRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FetchRequest#FetchRequest(PersistencePackage, CriteriaTransferObject, String, List)}
   *   <li>{@link FetchRequest#setCeilingEntity(String)}
   *   <li>{@link FetchRequest#setCto(CriteriaTransferObject)}
   *   <li>{@link FetchRequest#setFilterMappings(List)}
   *   <li>{@link FetchRequest#setPersistencePackage(PersistencePackage)}
   *   <li>{@link FetchRequest#getCeilingEntity()}
   *   <li>{@link FetchRequest#getCto()}
   *   <li>{@link FetchRequest#getFilterMappings()}
   *   <li>{@link FetchRequest#getPersistencePackage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    FetchRequest actualFetchRequest = new FetchRequest(persistencePackage, cto, "Ceiling Entity", new ArrayList<>());
    actualFetchRequest.setCeilingEntity("Ceiling Entity");
    CriteriaTransferObject cto2 = new CriteriaTransferObject();
    actualFetchRequest.setCto(cto2);
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    actualFetchRequest.setFilterMappings(filterMappings);
    PersistencePackage persistencePackage2 = new PersistencePackage();
    actualFetchRequest.setPersistencePackage(persistencePackage2);
    String actualCeilingEntity = actualFetchRequest.getCeilingEntity();
    CriteriaTransferObject actualCto = actualFetchRequest.getCto();
    List<FilterMapping> actualFilterMappings = actualFetchRequest.getFilterMappings();
    PersistencePackage actualPersistencePackage = actualFetchRequest.getPersistencePackage();

    // Assert that nothing has changed
    assertEquals("Ceiling Entity", actualCeilingEntity);
    assertTrue(actualFilterMappings.isEmpty());
    assertSame(filterMappings, actualFilterMappings);
    assertSame(cto2, actualCto);
    assertSame(persistencePackage2, actualPersistencePackage);
  }
}
