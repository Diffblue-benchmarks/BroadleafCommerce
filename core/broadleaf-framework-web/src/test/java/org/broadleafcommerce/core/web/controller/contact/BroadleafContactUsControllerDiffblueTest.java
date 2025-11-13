package org.broadleafcommerce.core.web.controller.contact;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafContactUsController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafContactUsControllerDiffblueTest {
  @Autowired private BroadleafContactUsController broadleafContactUsController;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  /**
   * Test {@link BroadleafContactUsController#sendConfirmationEmail(String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code contactus/success}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafContactUsController#sendConfirmationEmail(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafContactUsController.sendConfirmationEmail(String, String, String)"
  })
  public void testSendConfirmationEmail_thenReturnContactusSuccess() throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    // Act
    String actualSendConfirmationEmailResult =
        broadleafContactUsController.sendConfirmationEmail("Name", "42 Main St", "Comments");

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
    assertEquals("contactus/success", actualSendConfirmationEmailResult);
  }

  /**
   * Test {@link BroadleafContactUsController#sendConfirmationEmail(String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code redirect:/contactus}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafContactUsController#sendConfirmationEmail(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafContactUsController.sendConfirmationEmail(String, String, String)"
  })
  public void testSendConfirmationEmail_thenReturnRedirectContactus() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    // Act
    String actualSendConfirmationEmailResult =
        broadleafContactUsController.sendConfirmationEmail("Name", "42 Main St", "Comments");

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
    assertEquals("redirect:/contactus", actualSendConfirmationEmailResult);
  }

  /**
   * Test {@link BroadleafContactUsController#index()}.
   *
   * <p>Method under test: {@link BroadleafContactUsController#index()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafContactUsController.index()"})
  public void testIndex() {
    // Arrange, Act and Assert
    assertEquals("contactus/contactus", broadleafContactUsController.index());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafContactUsController}
   *   <li>{@link BroadleafContactUsController#getPath()}
   *   <li>{@link BroadleafContactUsController#getSuccessView()}
   *   <li>{@link BroadleafContactUsController#getView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafContactUsController.<init>()",
    "String BroadleafContactUsController.getPath()",
    "String BroadleafContactUsController.getSuccessView()",
    "String BroadleafContactUsController.getView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafContactUsController actualBroadleafContactUsController =
        new BroadleafContactUsController();
    String actualPath = actualBroadleafContactUsController.getPath();
    String actualSuccessView = actualBroadleafContactUsController.getSuccessView();

    // Assert
    assertEquals("/contactus", actualPath);
    assertEquals("contactus/contactus", actualBroadleafContactUsController.getView());
    assertEquals("contactus/success", actualSuccessView);
  }
}
