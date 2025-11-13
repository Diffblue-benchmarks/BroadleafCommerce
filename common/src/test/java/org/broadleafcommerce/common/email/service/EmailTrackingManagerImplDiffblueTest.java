package org.broadleafcommerce.common.email.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.email.dao.EmailReportingDao;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailTrackingManagerImplDiffblueTest {
  @Mock private EmailReportingDao emailReportingDao;

  @InjectMocks private EmailTrackingManagerImpl emailTrackingManagerImpl;

  /**
   * Test {@link EmailTrackingManagerImpl#createTrackedEmail(String, String, String)}.
   *
   * <p>Method under test: {@link EmailTrackingManagerImpl#createTrackedEmail(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long EmailTrackingManagerImpl.createTrackedEmail(String, String, String)"})
  public void testCreateTrackedEmail() {
    // Arrange
    when(emailReportingDao.createTracking(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act
    Long actualCreateTrackedEmailResult =
        emailTrackingManagerImpl.createTrackedEmail("42 Main St", "Type", "42");

    // Assert
    verify(emailReportingDao).createTracking("42 Main St", "Type", "42");
    assertEquals(1L, actualCreateTrackedEmailResult.longValue());
  }

  /**
   * Test {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}.
   *
   * <ul>
   *   <li>Given {@code email_id}.
   *   <li>When {@link HashMap#HashMap()} IfAbsent {@code email_id} is {@code requestUri}.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailTrackingManagerImpl.recordClick(Long, Map, String, Map)"})
  public void testRecordClick_givenEmailId_whenHashMapIfAbsentEmailIdIsRequestUri() {
    // Arrange
    doNothing()
        .when(emailReportingDao)
        .recordClick(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());

    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");
    parameterMap.putIfAbsent("email_id", "requestUri");

    // Act
    emailTrackingManagerImpl.recordClick(1L, parameterMap, "42", new HashMap<>());

    // Assert
    verify(emailReportingDao).recordClick(1L, "42", null, "foo=foo");
  }

  /**
   * Test {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} IfAbsent {@code requestUri} is {@code requestUri}.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailTrackingManagerImpl.recordClick(Long, Map, String, Map)"})
  public void testRecordClick_givenFoo_whenHashMapIfAbsentRequestUriIsRequestUri() {
    // Arrange
    doNothing()
        .when(emailReportingDao)
        .recordClick(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());

    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");
    parameterMap.putIfAbsent("requestUri", "requestUri");

    // Act
    emailTrackingManagerImpl.recordClick(1L, parameterMap, "42", new HashMap<>());

    // Assert
    verify(emailReportingDao).recordClick(1L, "42", null, "foo=foo&requestUri=requestUri");
  }

  /**
   * Test {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}.
   *
   * <ul>
   *   <li>Given {@code requestUri}.
   *   <li>When {@link HashMap#HashMap()} {@code requestUri} is {@code requestUri}.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailTrackingManagerImpl.recordClick(Long, Map, String, Map)"})
  public void testRecordClick_givenRequestUri_whenHashMapRequestUriIsRequestUri() {
    // Arrange
    doNothing()
        .when(emailReportingDao)
        .recordClick(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());

    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("requestUri", "requestUri");

    // Act
    emailTrackingManagerImpl.recordClick(1L, parameterMap, "42", new HashMap<>());

    // Assert
    verify(emailReportingDao).recordClick(1L, "42", null, "requestUri=requestUri");
  }

  /**
   * Test {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingManagerImpl#recordClick(Long, Map, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailTrackingManagerImpl.recordClick(Long, Map, String, Map)"})
  public void testRecordClick_whenHashMap() {
    // Arrange
    doNothing()
        .when(emailReportingDao)
        .recordClick(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act
    emailTrackingManagerImpl.recordClick(1L, parameterMap, "42", new HashMap<>());

    // Assert
    verify(emailReportingDao).recordClick(1L, "42", null, null);
  }

  /**
   * Test {@link EmailTrackingManagerImpl#recordOpen(Long, Map)}.
   *
   * <p>Method under test: {@link EmailTrackingManagerImpl#recordOpen(Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailTrackingManagerImpl.recordOpen(Long, Map)"})
  public void testRecordOpen() {
    // Arrange
    doNothing().when(emailReportingDao).recordOpen(Mockito.<Long>any(), Mockito.<String>any());

    // Act
    emailTrackingManagerImpl.recordOpen(1L, new HashMap<>());

    // Assert
    verify(emailReportingDao).recordOpen(1L, null);
  }
}
