package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RestrictionFactoryImplDiffblueTest {
  @Mock private Map<String, Restriction> map;

  @InjectMocks private RestrictionFactoryImpl restrictionFactoryImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RestrictionFactoryImpl#setRestrictions(Map)}
   *   <li>{@link RestrictionFactoryImpl#getRestrictions()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map RestrictionFactoryImpl.getRestrictions()",
    "void RestrictionFactoryImpl.setRestrictions(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange
    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    HashMap<String, Restriction> restrictions = new HashMap<>();

    // Act
    restrictionFactoryImpl.setRestrictions(restrictions);
    Map<String, Restriction> actualRestrictions = restrictionFactoryImpl.getRestrictions();

    // Assert
    assertTrue(actualRestrictions.isEmpty());
    assertSame(restrictions, actualRestrictions);
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   *
   * <p>Method under test: {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction RestrictionFactoryImpl.getRestriction(String, String)"})
  public void testGetRestriction() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new Restriction());

    // Act
    Restriction actualRestriction = restrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(map).get(isA(Object.class));
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertTrue(fieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualRestriction.getFilterValueConverter());
    assertNull(actualRestriction.getPredicateProvider());
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   *
   * <ul>
   *   <li>Given {@link Restriction} {@link Restriction#clone()} return {@link Restriction} (default
   *       constructor).
   *   <li>Then return {@link Restriction} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction RestrictionFactoryImpl.getRestriction(String, String)"})
  public void testGetRestriction_givenRestrictionCloneReturnRestriction_thenReturnRestriction() {
    // Arrange
    Restriction restriction = mock(Restriction.class);
    Restriction restriction2 = new Restriction();
    when(restriction.clone()).thenReturn(restriction2);
    when(map.get(Mockito.<Object>any())).thenReturn(restriction);

    // Act
    Restriction actualRestriction = restrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(map).get(isA(Object.class));
    verify(restriction).clone();
    assertSame(restriction2, actualRestriction);
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Restriction#setFieldPathBuilder(FieldPathBuilder)}.
   * </ul>
   *
   * <p>Method under test: {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction RestrictionFactoryImpl.getRestriction(String, String)"})
  public void testGetRestriction_thenCallsSetFieldPathBuilder() {
    // Arrange
    Restriction restriction = mock(Restriction.class);
    doNothing().when(restriction).setFieldPathBuilder(Mockito.<FieldPathBuilder>any());

    Restriction restriction2 = mock(Restriction.class);
    when(restriction2.clone()).thenReturn(restriction);
    when(map.get(Mockito.<Object>any())).thenReturn(restriction2);

    // Act
    restrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(map).get(isA(Object.class));
    verify(restriction2).clone();
    verify(restriction).setFieldPathBuilder(isA(FieldPathBuilder.class));
  }
}
