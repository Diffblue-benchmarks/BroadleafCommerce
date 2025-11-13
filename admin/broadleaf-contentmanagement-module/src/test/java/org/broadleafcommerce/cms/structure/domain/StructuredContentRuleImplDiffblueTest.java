package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentRuleImplDiffblueTest {
  @Autowired private StructuredContentRuleImpl structuredContentRuleImpl;

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and {@link
   * StructuredContentRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
    assertEquals(structuredContentRuleImpl.hashCode(), structuredContentRuleImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and {@link
   * StructuredContentRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(null);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
    assertNotEquals(structuredContentRuleImpl.hashCode(), structuredContentRuleImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and {@link
   * StructuredContentRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(null);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
    assertNotEquals(structuredContentRuleImpl.hashCode(), structuredContentRuleImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and {@link
   * StructuredContentRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl);
    int expectedHashCodeResult = structuredContentRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleImpl.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(2L);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(null);
    structuredContentRuleImpl.setMatchRule("42");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, null);
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleImpl.equals(Object)",
    "int StructuredContentRuleImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, "Different type to StructuredContentRuleImpl");
  }

  /**
   * Test {@link StructuredContentRuleImpl#cloneEntity()}.
   *
   * <p>Method under test: {@link StructuredContentRuleImpl#cloneEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StructuredContentRule StructuredContentRuleImpl.cloneEntity()"})
  public void testCloneEntity() {
    // Arrange and Act
    StructuredContentRule actualCloneEntityResult = structuredContentRuleImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StructuredContentRuleImpl);
    assertEquals(structuredContentRuleImpl, actualCloneEntityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentRuleImpl}
   *   <li>{@link StructuredContentRuleImpl#setId(Long)}
   *   <li>{@link StructuredContentRuleImpl#setMatchRule(String)}
   *   <li>{@link StructuredContentRuleImpl#getId()}
   *   <li>{@link StructuredContentRuleImpl#getMatchRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentRuleImpl.<init>()",
    "Long StructuredContentRuleImpl.getId()",
    "String StructuredContentRuleImpl.getMatchRule()",
    "void StructuredContentRuleImpl.setId(Long)",
    "void StructuredContentRuleImpl.setMatchRule(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentRuleImpl actualStructuredContentRuleImpl = new StructuredContentRuleImpl();
    actualStructuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentRuleImpl.setMatchRule("Match Rule");
    Long actualId = actualStructuredContentRuleImpl.getId();

    // Assert
    assertEquals("Match Rule", actualStructuredContentRuleImpl.getMatchRule());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
  }
}
