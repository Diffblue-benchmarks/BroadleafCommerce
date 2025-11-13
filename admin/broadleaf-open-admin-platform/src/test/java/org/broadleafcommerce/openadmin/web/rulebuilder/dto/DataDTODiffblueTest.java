package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataDTODiffblueTest {
  /**
   * Test {@link DataDTO#equals(Object)}, and {@link DataDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataDTO#equals(Object)}
   *   <li>{@link DataDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataDTO.equals(Object)", "int DataDTO.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("Condition");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(true);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(new ArrayList<>());

    // Act and Assert
    assertEquals(dataDTO, dataDTO2);
    assertEquals(dataDTO.hashCode(), dataDTO2.hashCode());
  }

  /**
   * Test {@link DataDTO#equals(Object)}, and {@link DataDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataDTO#equals(Object)}
   *   <li>{@link DataDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataDTO.equals(Object)", "int DataDTO.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    // Act and Assert
    assertEquals(dataDTO, dataDTO);
    int expectedHashCodeResult = dataDTO.hashCode();
    assertEquals(expectedHashCodeResult, dataDTO.hashCode());
  }

  /**
   * Test {@link DataDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataDTO.equals(Object)", "int DataDTO.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition(null);
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("Condition");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(true);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(new ArrayList<>());

    // Act and Assert
    assertNotEquals(dataDTO, dataDTO2);
  }

  /**
   * Test {@link DataDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataDTO.equals(Object)", "int DataDTO.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    // Act and Assert
    assertNotEquals(dataDTO, null);
  }

  /**
   * Test {@link DataDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataDTO.equals(Object)", "int DataDTO.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    // Act and Assert
    assertNotEquals(dataDTO, "Different type to DataDTO");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DataDTO}
   *   <li>{@link DataDTO#setCondition(String)}
   *   <li>{@link DataDTO#setContainedPk(Long)}
   *   <li>{@link DataDTO#setCreatedFromSubGroup(boolean)}
   *   <li>{@link DataDTO#setPk(Long)}
   *   <li>{@link DataDTO#setPreviousContainedPk(Long)}
   *   <li>{@link DataDTO#setPreviousPk(Long)}
   *   <li>{@link DataDTO#setQuantity(Integer)}
   *   <li>{@link DataDTO#setRules(ArrayList)}
   *   <li>{@link DataDTO#getCondition()}
   *   <li>{@link DataDTO#getContainedPk()}
   *   <li>{@link DataDTO#getPk()}
   *   <li>{@link DataDTO#getPreviousContainedPk()}
   *   <li>{@link DataDTO#getPreviousPk()}
   *   <li>{@link DataDTO#getQuantity()}
   *   <li>{@link DataDTO#getRules()}
   *   <li>{@link DataDTO#isCreatedFromSubGroup()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDTO.<init>()",
    "String DataDTO.getCondition()",
    "Long DataDTO.getContainedPk()",
    "Long DataDTO.getPk()",
    "Long DataDTO.getPreviousContainedPk()",
    "Long DataDTO.getPreviousPk()",
    "Integer DataDTO.getQuantity()",
    "ArrayList DataDTO.getRules()",
    "boolean DataDTO.isCreatedFromSubGroup()",
    "void DataDTO.setCondition(String)",
    "void DataDTO.setContainedPk(Long)",
    "void DataDTO.setCreatedFromSubGroup(boolean)",
    "void DataDTO.setPk(Long)",
    "void DataDTO.setPreviousContainedPk(Long)",
    "void DataDTO.setPreviousPk(Long)",
    "void DataDTO.setQuantity(Integer)",
    "void DataDTO.setRules(ArrayList)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DataDTO actualDataDTO = new DataDTO();
    actualDataDTO.setCondition("Condition");
    actualDataDTO.setContainedPk(1L);
    actualDataDTO.setCreatedFromSubGroup(true);
    actualDataDTO.setPk(1L);
    actualDataDTO.setPreviousContainedPk(1L);
    actualDataDTO.setPreviousPk(1L);
    actualDataDTO.setQuantity(1);
    ArrayList<DataDTO> rules = new ArrayList<>();
    actualDataDTO.setRules(rules);
    String actualCondition = actualDataDTO.getCondition();
    Long actualContainedPk = actualDataDTO.getContainedPk();
    Long actualPk = actualDataDTO.getPk();
    Long actualPreviousContainedPk = actualDataDTO.getPreviousContainedPk();
    Long actualPreviousPk = actualDataDTO.getPreviousPk();
    Integer actualQuantity = actualDataDTO.getQuantity();
    ArrayList<DataDTO> actualRules = actualDataDTO.getRules();
    boolean actualIsCreatedFromSubGroupResult = actualDataDTO.isCreatedFromSubGroup();

    // Assert
    assertEquals("Condition", actualCondition);
    assertEquals(1, actualQuantity.intValue());
    assertEquals(1L, actualContainedPk.longValue());
    assertEquals(1L, actualPk.longValue());
    assertEquals(1L, actualPreviousContainedPk.longValue());
    assertEquals(1L, actualPreviousPk.longValue());
    assertTrue(actualIsCreatedFromSubGroupResult);
    assertSame(rules, actualRules);
  }
}
