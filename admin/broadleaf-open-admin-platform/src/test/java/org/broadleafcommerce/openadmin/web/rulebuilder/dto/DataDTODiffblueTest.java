package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class DataDTODiffblueTest {
  /**
   * Test {@link DataDTO#equals(Object)}, and {@link DataDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataDTO#equals(Object)}
   *   <li>{@link DataDTO#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = dataDTO.hashCode();
    assertEquals(expectedHashCodeResult, dataDTO2.hashCode());
  }

  /**
   * Test {@link DataDTO#equals(Object)}, and {@link DataDTO#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataDTO#equals(Object)}
   *   <li>{@link DataDTO#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());

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
    assertNotEquals(expressionDTO, dataDTO);
  }

  /**
   * Test {@link DataDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTO#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO.equals(DataDTO.java:114)
    //   See https://diff.blue/R013 to resolve this issue.

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
    ExpressionDTO expressionDTO = mock(ExpressionDTO.class);
    doNothing().when(expressionDTO).setCondition(Mockito.<String>any());
    doNothing().when(expressionDTO).setContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setCreatedFromSubGroup(anyBoolean());
    doNothing().when(expressionDTO).setPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousContainedPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setPreviousPk(Mockito.<Long>any());
    doNothing().when(expressionDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(expressionDTO).setRules(Mockito.<ArrayList<DataDTO>>any());
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());

    // Act and Assert
    assertThrows(NullPointerException.class, () -> dataDTO.equals(expressionDTO));
  }

  /**
   * Test {@link DataDTO#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTO#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDTO#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
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
