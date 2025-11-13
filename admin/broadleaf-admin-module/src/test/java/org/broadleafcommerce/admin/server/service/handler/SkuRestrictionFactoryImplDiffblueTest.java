package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SkuRestrictionFactoryImplDiffblueTest {
  /**
   * Test {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Restriction#getFilterValueConverter()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction SkuRestrictionFactoryImpl.getRestriction(String, String)"})
  public void testGetRestriction_thenCallsGetFilterValueConverter() {
    // Arrange
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));

    RestrictionFactory delegate = mock(RestrictionFactory.class);
    when(delegate.getRestriction(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(restriction);

    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    skuRestrictionFactoryImpl.setDelegate(delegate);

    // Act
    Restriction actualRestriction = skuRestrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(restriction).getFilterValueConverter();
    verify(delegate).getRestriction("Type", "42");
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}.
   *
   * <ul>
   *   <li>Then return FilterValueConverter is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction SkuRestrictionFactoryImpl.getRestriction(String, String)"})
  public void testGetRestriction_thenReturnFilterValueConverterIsNull() {
    // Arrange
    RestrictionFactory delegate = mock(RestrictionFactory.class);
    when(delegate.getRestriction(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new Restriction());

    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    skuRestrictionFactoryImpl.setDelegate(delegate);

    // Act
    Restriction actualRestriction = skuRestrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(delegate).getRestriction("Type", "42");
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualRestriction.getFilterValueConverter());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuRestrictionFactoryImpl#setDelegate(RestrictionFactory)}
   *   <li>{@link SkuRestrictionFactoryImpl#getDelegate()}
   *   <li>{@link SkuRestrictionFactoryImpl#getSkuPropertyPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestrictionFactory SkuRestrictionFactoryImpl.getDelegate()",
    "String SkuRestrictionFactoryImpl.getSkuPropertyPrefix()",
    "void SkuRestrictionFactoryImpl.setDelegate(RestrictionFactory)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    RestrictionFactory delegate = mock(RestrictionFactory.class);

    // Act
    skuRestrictionFactoryImpl.setDelegate(delegate);
    RestrictionFactory actualDelegate = skuRestrictionFactoryImpl.getDelegate();

    // Assert
    assertNull(skuRestrictionFactoryImpl.getSkuPropertyPrefix());
    assertSame(delegate, actualDelegate);
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix() {
    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix("Sku Property Prefix");

    // Assert
    assertEquals("Sku Property Prefix.", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix2() {
    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix("");

    // Assert
    assertEquals("", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuRestrictionFactoryImpl} (default constructor) SkuPropertyPrefix is {@code
   *       .}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix_thenSkuRestrictionFactoryImplSkuPropertyPrefixIsDot() {
    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix(".");

    // Assert
    assertEquals(".", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuRestrictionFactoryImpl} (default constructor) SkuPropertyPrefix is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix_thenSkuRestrictionFactoryImplSkuPropertyPrefixIsNull() {
    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix(null);

    // Assert that nothing has changed
    assertNull(skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }
}
