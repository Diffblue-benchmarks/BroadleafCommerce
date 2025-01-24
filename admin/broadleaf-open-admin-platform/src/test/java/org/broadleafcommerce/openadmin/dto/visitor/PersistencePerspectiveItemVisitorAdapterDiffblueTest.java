package org.broadleafcommerce.openadmin.dto.visitor;

import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.ParentRecordStructure;
import org.broadleafcommerce.openadmin.dto.SimpleValueMapStructure;
import org.junit.Test;

public class PersistencePerspectiveItemVisitorAdapterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link PersistencePerspectiveItemVisitorAdapter}
   *   <li>{@link PersistencePerspectiveItemVisitorAdapter#visit(AdornedTargetList)}
   *   <li>{@link PersistencePerspectiveItemVisitorAdapter#visit(ForeignKey)}
   *   <li>{@link PersistencePerspectiveItemVisitorAdapter#visit(MapStructure)}
   *   <li>
   * {@link PersistencePerspectiveItemVisitorAdapter#visit(ParentRecordStructure)}
   *   <li>
   * {@link PersistencePerspectiveItemVisitorAdapter#visit(SimpleValueMapStructure)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    PersistencePerspectiveItemVisitorAdapter actualPersistencePerspectiveItemVisitorAdapter = new PersistencePerspectiveItemVisitorAdapter();
    actualPersistencePerspectiveItemVisitorAdapter.visit(new AdornedTargetList());
    actualPersistencePerspectiveItemVisitorAdapter.visit(new ForeignKey());
    actualPersistencePerspectiveItemVisitorAdapter.visit(new MapStructure());
    actualPersistencePerspectiveItemVisitorAdapter.visit(new ParentRecordStructure());
    actualPersistencePerspectiveItemVisitorAdapter.visit(new SimpleValueMapStructure());
  }
}
