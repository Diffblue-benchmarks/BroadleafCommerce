package org.broadleafcommerce.common.config.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.cache.CacheManager;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.config.domain.NullSystemProperty;
import org.broadleafcommerce.common.config.domain.SystemProperty;
import org.broadleafcommerce.common.config.domain.SystemPropertyImpl;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SystemPropertiesDaoImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private SystemPropertiesDaoImpl systemPropertiesDaoImpl;

  @Mock private SystemProperty systemProperty;

  /**
   * Test {@link SystemPropertiesDaoImpl#readSystemPropertyByName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#readSystemPropertyByName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.readSystemPropertyByName(String)"})
  public void testReadSystemPropertyByName_thenThrowNoResultException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(
        NoResultException.class, () -> systemPropertiesDaoImpl.readSystemPropertyByName("Name"));
    verify(cacheManager).getCache("blSystemPropertyNullCheckCache");
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#readSystemPropertyByName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#readSystemPropertyByName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.readSystemPropertyByName(String)"})
  public void testReadSystemPropertyByName_whenNull_thenThrowNoResultException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(
        NoResultException.class, () -> systemPropertiesDaoImpl.readSystemPropertyByName(null));
    verify(cacheManager).getCache("blSystemPropertyNullCheckCache");
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#removeFromCache(SystemProperty)}.
   *
   * <ul>
   *   <li>Given {@link SystemProperty} {@link SystemProperty#getName()} throw {@link
   *       NoResultException#NoResultException()}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#removeFromCache(SystemProperty)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SystemPropertiesDaoImpl.removeFromCache(SystemProperty)"})
  public void testRemoveFromCache_givenSystemPropertyGetNameThrowNoResultException() {
    // Arrange
    when(systemProperty.getName()).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(
        NoResultException.class, () -> systemPropertiesDaoImpl.removeFromCache(systemProperty));
    verify(systemProperty).getName();
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#removeFromCache(SystemProperty)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheManager#getCache(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#removeFromCache(SystemProperty)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SystemPropertiesDaoImpl.removeFromCache(SystemProperty)"})
  public void testRemoveFromCache_thenCallsGetCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new NoResultException());
    when(systemProperty.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        NoResultException.class, () -> systemPropertiesDaoImpl.removeFromCache(systemProperty));
    verify(cacheManager).getCache("blSystemPropertyNullCheckCache");
    verify(systemProperty).getName();
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#createNewSystemProperty()}.
   *
   * <ul>
   *   <li>Then return {@link SystemPropertyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#createNewSystemProperty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.createNewSystemProperty()"})
  public void testCreateNewSystemProperty_thenReturnSystemPropertyImpl() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl.setValue("42");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(systemPropertyImpl);

    // Act
    SystemProperty actualCreateNewSystemPropertyResult =
        systemPropertiesDaoImpl.createNewSystemProperty();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.config.domain.SystemProperty");
    assertSame(systemPropertyImpl, actualCreateNewSystemPropertyResult);
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#createNewSystemProperty()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#createNewSystemProperty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.createNewSystemProperty()"})
  public void testCreateNewSystemProperty_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> systemPropertiesDaoImpl.createNewSystemProperty());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.config.domain.SystemProperty");
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getLogger()}.
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#getLogger()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.commons.logging.Log SystemPropertiesDaoImpl.getLogger()"})
  public void testGetLogger() {
    // Arrange, Act and Assert
    assertSame(SystemPropertiesDaoImpl.LOG, new SystemPropertiesDaoImpl().getLogger());
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getSite()}.
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#getSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesDaoImpl.getSite()"})
  public void testGetSite() {
    // Arrange, Act and Assert
    assertEquals("", new SystemPropertiesDaoImpl().getSite());
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getNullObject(Class)}.
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#getNullObject(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.getNullObject(Class)"})
  public void testGetNullObject() {
    // Arrange
    SystemPropertiesDaoImpl systemPropertiesDaoImpl = new SystemPropertiesDaoImpl();
    Class<SystemProperty> responseClass = SystemProperty.class;

    // Act
    SystemProperty actualNullObject = systemPropertiesDaoImpl.getNullObject(responseClass);

    // Assert
    assertTrue(actualNullObject instanceof NullSystemProperty);
    assertNull(actualNullObject.getOverrideGeneratedPropertyName());
    assertNull(actualNullObject.getId());
    assertNull(actualNullObject.getFriendlyGroup());
    assertNull(actualNullObject.getFriendlyName());
    assertNull(actualNullObject.getFriendlyTab());
    assertNull(actualNullObject.getName());
    assertNull(actualNullObject.getValue());
    assertNull(actualNullObject.getPropertyType());
  }
}
