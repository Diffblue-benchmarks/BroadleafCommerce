package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class AdminOfferControllerDiffblueTest {
  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminOfferController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminOfferController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link AdminOfferController#SECTION_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminOfferController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    // Act and Assert
    assertEquals(
        AdminOfferController.SECTION_KEY, adminOfferController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminOfferController#getSectionCustomCriteria()}.
   *
   * <p>Method under test: {@link AdminOfferController#getSectionCustomCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminOfferController.getSectionCustomCriteria()"})
  public void testGetSectionCustomCriteria() {
    // Arrange and Act
    String[] actualSectionCustomCriteria = new AdminOfferController().getSectionCustomCriteria();

    // Assert
    assertEquals(0, actualSectionCustomCriteria.length);
    assertSame(AdminOfferController.customCriteria, actualSectionCustomCriteria);
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   *
   * <p>Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminOfferController.modifyModelAttributes(Model)"})
  public void testModifyModelAttributes() {
    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminOfferController.modifyModelAttributes(model);

    // Assert
    assertEquals(1, model.size());
    assertEquals("offer-form", model.get("additionalControllerClasses"));
  }
}
