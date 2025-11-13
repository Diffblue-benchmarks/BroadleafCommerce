package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RequestDTOCustomPersistenceHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RequestDTOCustomPersistenceHandlerDiffblueTest {
  @Autowired private RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler;

  /**
   * Test {@link RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean RequestDTOCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }
}
