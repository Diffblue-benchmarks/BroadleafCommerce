package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StateImplDiffblueTest {
  /**
   * Test {@link StateImpl#equals(Object)}, and {@link StateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StateImpl#equals(Object)}
   *   <li>{@link StateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertEquals(stateImpl, stateImpl2);
    assertEquals(stateImpl.hashCode(), stateImpl2.hashCode());
  }

  /**
   * Test {@link StateImpl#equals(Object)}, and {@link StateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StateImpl#equals(Object)}
   *   <li>{@link StateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation(null);
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation(null);
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertEquals(stateImpl, stateImpl2);
    assertEquals(stateImpl.hashCode(), stateImpl2.hashCode());
  }

  /**
   * Test {@link StateImpl#equals(Object)}, and {@link StateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StateImpl#equals(Object)}
   *   <li>{@link StateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(null);
    stateImpl.setName("Name");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(null);
    stateImpl2.setName("Name");

    // Act and Assert
    assertEquals(stateImpl, stateImpl2);
    assertEquals(stateImpl.hashCode(), stateImpl2.hashCode());
  }

  /**
   * Test {@link StateImpl#equals(Object)}, and {@link StateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StateImpl#equals(Object)}
   *   <li>{@link StateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName(null);

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName(null);

    // Act and Assert
    assertEquals(stateImpl, stateImpl2);
    assertEquals(stateImpl.hashCode(), stateImpl2.hashCode());
  }

  /**
   * Test {@link StateImpl#equals(Object)}, and {@link StateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StateImpl#equals(Object)}
   *   <li>{@link StateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");

    // Act and Assert
    assertEquals(stateImpl, stateImpl);
    int expectedHashCodeResult = stateImpl.hashCode();
    assertEquals(expectedHashCodeResult, stateImpl.hashCode());
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Name");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, stateImpl2);
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation(null);
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, stateImpl2);
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(null);
    stateImpl.setName("Name");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, stateImpl2);
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(mock(Country.class));
    stateImpl.setName("Name");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, stateImpl2);
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Abbreviation");

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, stateImpl2);
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName(null);

    StateImpl stateImpl2 = new StateImpl();
    stateImpl2.setAbbreviation("Abbreviation");
    stateImpl2.setCountry(new CountryImpl());
    stateImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, stateImpl2);
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, null);
  }

  /**
   * Test {@link StateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateImpl.equals(Object)", "int StateImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");

    // Act and Assert
    assertNotEquals(stateImpl, "Different type to StateImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StateImpl}
   *   <li>{@link StateImpl#setAbbreviation(String)}
   *   <li>{@link StateImpl#setCountry(Country)}
   *   <li>{@link StateImpl#setName(String)}
   *   <li>{@link StateImpl#getAbbreviation()}
   *   <li>{@link StateImpl#getCountry()}
   *   <li>{@link StateImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StateImpl.<init>()",
    "String StateImpl.getAbbreviation()",
    "Country StateImpl.getCountry()",
    "String StateImpl.getName()",
    "void StateImpl.setAbbreviation(String)",
    "void StateImpl.setCountry(Country)",
    "void StateImpl.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StateImpl actualStateImpl = new StateImpl();
    actualStateImpl.setAbbreviation("Abbreviation");
    CountryImpl country = new CountryImpl();
    actualStateImpl.setCountry(country);
    actualStateImpl.setName("Name");
    String actualAbbreviation = actualStateImpl.getAbbreviation();
    Country actualCountry = actualStateImpl.getCountry();

    // Assert
    assertEquals("Abbreviation", actualAbbreviation);
    assertEquals("Name", actualStateImpl.getName());
    assertSame(country, actualCountry);
  }
}
