package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.dao.PhoneDao;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceImplDiffblueTest {
  @Mock private PhoneDao phoneDao;

  @InjectMocks private PhoneServiceImpl phoneServiceImpl;

  /**
   * Test {@link PhoneServiceImpl#savePhone(Phone)}.
   *
   * <p>Method under test: {@link PhoneServiceImpl#savePhone(Phone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.savePhone(Phone)"})
  public void testSavePhone() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneDao.save(Mockito.<Phone>any())).thenReturn(phoneImpl);

    // Act
    Phone actualSavePhoneResult = phoneServiceImpl.savePhone(new PhoneImpl());

    // Assert
    verify(phoneDao).save(isA(Phone.class));
    assertSame(phoneImpl, actualSavePhoneResult);
  }

  /**
   * Test {@link PhoneServiceImpl#readPhoneById(Long)}.
   *
   * <p>Method under test: {@link PhoneServiceImpl#readPhoneById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.readPhoneById(Long)"})
  public void testReadPhoneById() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneDao.readPhoneById(Mockito.<Long>any())).thenReturn(phoneImpl);

    // Act
    Phone actualReadPhoneByIdResult = phoneServiceImpl.readPhoneById(1L);

    // Assert
    verify(phoneDao).readPhoneById(1L);
    assertSame(phoneImpl, actualReadPhoneByIdResult);
  }

  /**
   * Test {@link PhoneServiceImpl#create()}.
   *
   * <p>Method under test: {@link PhoneServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneDao.create()).thenReturn(phoneImpl);

    // Act
    Phone actualCreateResult = phoneServiceImpl.create();

    // Assert
    verify(phoneDao).create();
    assertSame(phoneImpl, actualCreateResult);
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest}, {@code orig}.
   *
   * <ul>
   *   <li>Given {@link PhoneDao} {@link PhoneDao#create()} return {@link PhoneImpl} (default
   *       constructor).
   *   <li>Then calls {@link PhoneDao#create()}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.copyPhone(Phone, Phone)"})
  public void testCopyPhoneWithDestOrig_givenPhoneDaoCreateReturnPhoneImpl_thenCallsCreate() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneDao.create()).thenReturn(phoneImpl);

    // Act
    Phone actualCopyPhoneResult = phoneServiceImpl.copyPhone(null, new PhoneImpl());

    // Assert
    verify(phoneDao).create();
    assertSame(phoneImpl, actualCopyPhoneResult);
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest}, {@code orig}.
   *
   * <ul>
   *   <li>Given {@link PhoneServiceImpl} (default constructor).
   *   <li>Then return {@link PhoneImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.copyPhone(Phone, Phone)"})
  public void testCopyPhoneWithDestOrig_givenPhoneServiceImpl_thenReturnPhoneImpl() {
    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
    PhoneImpl dest = new PhoneImpl();

    // Act
    Phone actualCopyPhoneResult = phoneServiceImpl.copyPhone(dest, new PhoneImpl());

    // Assert
    assertSame(dest, actualCopyPhoneResult);
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest}, {@code orig}.
   *
   * <ul>
   *   <li>Given {@link PhoneServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.copyPhone(Phone, Phone)"})
  public void testCopyPhoneWithDestOrig_givenPhoneServiceImpl_whenNull_thenReturnNull() {
    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();

    // Act and Assert
    assertNull(phoneServiceImpl.copyPhone(new PhoneImpl(), null));
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone)} with {@code orig}.
   *
   * <ul>
   *   <li>Given {@link PhoneDao} {@link PhoneDao#create()} return {@link PhoneImpl} (default
   *       constructor).
   *   <li>Then return {@link PhoneImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PhoneServiceImpl#copyPhone(Phone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.copyPhone(Phone)"})
  public void testCopyPhoneWithOrig_givenPhoneDaoCreateReturnPhoneImpl_thenReturnPhoneImpl() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneDao.create()).thenReturn(phoneImpl);

    // Act
    Phone actualCopyPhoneResult = phoneServiceImpl.copyPhone(new PhoneImpl());

    // Assert
    verify(phoneDao).create();
    assertSame(phoneImpl, actualCopyPhoneResult);
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone)} with {@code orig}.
   *
   * <ul>
   *   <li>Given {@link PhoneDao} {@link PhoneDao#create()} return {@link PhoneImpl} (default
   *       constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneServiceImpl#copyPhone(Phone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Phone PhoneServiceImpl.copyPhone(Phone)"})
  public void testCopyPhoneWithOrig_givenPhoneDaoCreateReturnPhoneImpl_whenNull_thenReturnNull() {
    // Arrange
    when(phoneDao.create()).thenReturn(new PhoneImpl());

    // Act
    Phone actualCopyPhoneResult = phoneServiceImpl.copyPhone(null);

    // Assert
    verify(phoneDao).create();
    assertNull(actualCopyPhoneResult);
  }
}
