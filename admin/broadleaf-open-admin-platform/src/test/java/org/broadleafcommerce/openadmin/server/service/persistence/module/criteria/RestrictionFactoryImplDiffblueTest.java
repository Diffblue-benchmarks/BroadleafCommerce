package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RestrictionFactoryImplDiffblueTest {
  @Autowired
  private RestrictionFactoryImpl restrictionFactoryImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionFactoryImpl#setRestrictions(Map)}
   *   <li>{@link RestrictionFactoryImpl#getRestrictions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    HashMap<String, Restriction> restrictions = new HashMap<>();

    // Act
    restrictionFactoryImpl.setRestrictions(restrictions);
    Map<String, Restriction> actualRestrictions = restrictionFactoryImpl.getRestrictions();

    // Assert that nothing has changed
    assertTrue(actualRestrictions.isEmpty());
    assertSame(restrictions, actualRestrictions);
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   * <p>
   * Method under test:
   * {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, Restriction> restrictions = new HashMap<>();
    restrictions.put("42", new Restriction());
    restrictions.computeIfPresent("foo", mock(BiFunction.class));

    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    restrictionFactoryImpl.setRestrictions(restrictions);

    // Act
    Restriction actualRestriction = restrictionFactoryImpl.getRestriction("42", "42");

    // Assert
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertTrue(fieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualRestriction.getFilterValueConverter());
    assertNull(actualRestriction.getPredicateProvider());
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   * <p>
   * Method under test:
   * {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRestriction2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7776 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactoryImpl restrictionFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RestrictionFactoryImpl()).getRestriction("Type", "42");
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   * <ul>
   *   <li>Given {@link Restriction} {@link Restriction#clone()} return
   * {@link Restriction} (default constructor).</li>
   *   <li>Then return {@link Restriction} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction_givenRestrictionCloneReturnRestriction_thenReturnRestriction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = mock(Restriction.class);
    Restriction restriction2 = new Restriction();
    when(restriction.clone()).thenReturn(restriction2);

    HashMap<String, Restriction> restrictions = new HashMap<>();
    restrictions.put("42", restriction);
    restrictions.computeIfPresent("foo", mock(BiFunction.class));

    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    restrictionFactoryImpl.setRestrictions(restrictions);

    // Act
    Restriction actualRestriction = restrictionFactoryImpl.getRestriction("42", "42");

    // Assert
    verify(restriction).clone();
    assertSame(restriction2, actualRestriction);
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   * <ul>
   *   <li>Then calls
   * {@link Restriction#setFieldPathBuilder(FieldPathBuilder)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction_thenCallsSetFieldPathBuilder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = mock(Restriction.class);
    doNothing().when(restriction).setFieldPathBuilder(Mockito.<FieldPathBuilder>any());
    Restriction restriction2 = mock(Restriction.class);
    when(restriction2.clone()).thenReturn(restriction);

    HashMap<String, Restriction> restrictions = new HashMap<>();
    restrictions.put("42", restriction2);
    restrictions.computeIfPresent("foo", mock(BiFunction.class));

    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    restrictionFactoryImpl.setRestrictions(restrictions);

    // Act
    restrictionFactoryImpl.getRestriction("42", "42");

    // Assert
    verify(restriction2).clone();
    verify(restriction).setFieldPathBuilder(isA(FieldPathBuilder.class));
  }
}
