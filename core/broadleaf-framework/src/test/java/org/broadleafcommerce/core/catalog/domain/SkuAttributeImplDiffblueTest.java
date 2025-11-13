package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuAttributeImplDiffblueTest {
  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(null);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName(null);
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName(null);
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(null);
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(null);
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue(null);

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl);
    int expectedHashCodeResult = skuAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAttributeImpl.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(2L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName(null);
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(null);
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(mock(SkuImpl.class));
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("Name");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue(null);

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, null);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, "Different type to SkuAttributeImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuAttributeImpl}
   *   <li>{@link SkuAttributeImpl#setId(Long)}
   *   <li>{@link SkuAttributeImpl#setName(String)}
   *   <li>{@link SkuAttributeImpl#setSku(Sku)}
   *   <li>{@link SkuAttributeImpl#setValue(String)}
   *   <li>{@link SkuAttributeImpl#getId()}
   *   <li>{@link SkuAttributeImpl#getSku()}
   *   <li>{@link SkuAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuAttributeImpl.<init>()",
    "Long SkuAttributeImpl.getId()",
    "Sku SkuAttributeImpl.getSku()",
    "void SkuAttributeImpl.setId(Long)",
    "void SkuAttributeImpl.setName(String)",
    "void SkuAttributeImpl.setSku(Sku)",
    "void SkuAttributeImpl.setValue(String)",
    "String SkuAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuAttributeImpl actualSkuAttributeImpl = new SkuAttributeImpl();
    actualSkuAttributeImpl.setId(1L);
    actualSkuAttributeImpl.setName("Name");
    SkuImpl sku = new SkuImpl();
    actualSkuAttributeImpl.setSku(sku);
    actualSkuAttributeImpl.setValue("42");
    Long actualId = actualSkuAttributeImpl.getId();
    Sku actualSku = actualSkuAttributeImpl.getSku();

    // Assert
    assertEquals("42", actualSkuAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(sku, actualSku);
  }
}
