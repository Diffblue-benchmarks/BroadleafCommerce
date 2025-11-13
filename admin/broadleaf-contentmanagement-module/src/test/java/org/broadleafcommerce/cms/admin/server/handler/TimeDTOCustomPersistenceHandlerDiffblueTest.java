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

@ContextConfiguration(classes = {TimeDTOCustomPersistenceHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TimeDTOCustomPersistenceHandlerDiffblueTest {
  @Autowired private TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler;

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_givenRequestDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler =
        new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link TimeDTOCustomPersistenceHandler}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_givenTimeDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_givenRequestDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler =
        new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link TimeDTOCustomPersistenceHandler}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_givenTimeDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_givenRequestDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler =
        new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link TimeDTOCustomPersistenceHandler}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_givenTimeDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_givenRequestDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler =
        new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link TimeDTOCustomPersistenceHandler}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_givenTimeDTOCustomPersistenceHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TimeDTOCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }
}
