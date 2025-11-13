package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ISOCountryImplDiffblueTest {
  @Autowired private ISOCountryImpl iSOCountryImpl;

  /**
   * Test {@link ISOCountryImpl#getStatus()}.
   *
   * <p>Method under test: {@link ISOCountryImpl#getStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISOCodeStatusType ISOCountryImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull(iSOCountryImpl.getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   *
   * <ul>
   *   <li>Then {@link ISOCountryImpl} {@link ISOCountryImpl#status} is {@code
   *       EXCEPTIONALLY_RESERVED}.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ISOCountryImpl.setStatus(ISOCodeStatusType)"})
  public void testSetStatus_thenISOCountryImplStatusIsExceptionallyReserved() {
    // Arrange and Act
    iSOCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Assert
    assertEquals("EXCEPTIONALLY_RESERVED", iSOCountryImpl.status);
    assertSame(ISOCodeStatusType.EXCEPTIONALLY_RESERVED, iSOCountryImpl.getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ISOCountryImpl} {@link ISOCountryImpl#status} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ISOCountryImpl.setStatus(ISOCodeStatusType)"})
  public void testSetStatus_whenNull_thenISOCountryImplStatusIsNull() {
    // Arrange and Act
    iSOCountryImpl.setStatus(null);

    // Assert that nothing has changed
    assertNull(iSOCountryImpl.status);
    assertNull(iSOCountryImpl.getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and {@link ISOCountryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    assertEquals(isoCountryImpl.hashCode(), isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and {@link ISOCountryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2(null);
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2(null);
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    assertEquals(isoCountryImpl.hashCode(), isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and {@link ISOCountryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3(null);
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3(null);
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    assertEquals(isoCountryImpl.hashCode(), isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and {@link ISOCountryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName(null);
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName(null);
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    assertEquals(isoCountryImpl.hashCode(), isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and {@link ISOCountryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(null);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(null);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    assertEquals(isoCountryImpl.hashCode(), isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and {@link ISOCountryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(new ISOCodeStatusType());

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(new ISOCodeStatusType());

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    assertEquals(isoCountryImpl.hashCode(), isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and {@link ISOCountryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl);
    int expectedHashCodeResult = isoCountryImpl.hashCode();
    assertEquals(expectedHashCodeResult, isoCountryImpl.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Name");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2(null);
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha2");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3(null);
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Alpha2");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName(null);
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(1);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(null);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.INDETERMINATELY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(new ISOCodeStatusType());

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, null);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ISOCountryImpl.equals(Object)", "int ISOCountryImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, "Different type to ISOCountryImpl");
  }

  /**
   * Test {@link ISOCountryImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link ISOCountryImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ISOCountryImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(iSOCountryImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ISOCountryImpl}
   *   <li>{@link ISOCountryImpl#setAlpha2(String)}
   *   <li>{@link ISOCountryImpl#setAlpha3(String)}
   *   <li>{@link ISOCountryImpl#setName(String)}
   *   <li>{@link ISOCountryImpl#setNumericCode(Integer)}
   *   <li>{@link ISOCountryImpl#getAlpha2()}
   *   <li>{@link ISOCountryImpl#getAlpha3()}
   *   <li>{@link ISOCountryImpl#getName()}
   *   <li>{@link ISOCountryImpl#getNumericCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ISOCountryImpl.<init>()",
    "String ISOCountryImpl.getAlpha2()",
    "String ISOCountryImpl.getAlpha3()",
    "String ISOCountryImpl.getName()",
    "Integer ISOCountryImpl.getNumericCode()",
    "void ISOCountryImpl.setAlpha2(String)",
    "void ISOCountryImpl.setAlpha3(String)",
    "void ISOCountryImpl.setName(String)",
    "void ISOCountryImpl.setNumericCode(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ISOCountryImpl actualIsoCountryImpl = new ISOCountryImpl();
    actualIsoCountryImpl.setAlpha2("Alpha2");
    actualIsoCountryImpl.setAlpha3("Alpha3");
    actualIsoCountryImpl.setName("Name");
    actualIsoCountryImpl.setNumericCode(10);
    String actualAlpha2 = actualIsoCountryImpl.getAlpha2();
    String actualAlpha3 = actualIsoCountryImpl.getAlpha3();
    String actualName = actualIsoCountryImpl.getName();

    // Assert
    assertEquals("Alpha2", actualAlpha2);
    assertEquals("Alpha3", actualAlpha3);
    assertEquals("Name", actualName);
    assertEquals(10, actualIsoCountryImpl.getNumericCode().intValue());
  }
}
