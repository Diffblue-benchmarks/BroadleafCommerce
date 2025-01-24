package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.procedure.internal.ProcedureCallImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultOfferCodeDaoExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultOfferCodeDaoExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultOfferCodeDaoExtensionHandler defaultOfferCodeDaoExtensionHandler;

  /**
   * Test
   * {@link DefaultOfferCodeDaoExtensionHandler#createReadOfferCodeByCodeQuery(EntityManager, ExtensionResultHolder, String, boolean, String)}.
   * <p>
   * Method under test:
   * {@link DefaultOfferCodeDaoExtensionHandler#createReadOfferCodeByCodeQuery(EntityManager, ExtensionResultHolder, String, boolean, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateReadOfferCodeByCodeQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from a null delegate object
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:94)
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:107)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);
    SessionDelegatorBaseImpl em = new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null));

    ExtensionResultHolder<Query> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ProcedureCallImpl<>(new SessionDelegatorBaseImpl(null, null), "Procedure Name"));
    resultHolder.setThrowable(new Throwable());

    // Act
    defaultOfferCodeDaoExtensionHandler.createReadOfferCodeByCodeQuery(em, resultHolder, "Code", true, "us-east-2");
  }

  /**
   * Test new {@link DefaultOfferCodeDaoExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DefaultOfferCodeDaoExtensionHandler}
   */
  @Test
  public void testNewDefaultOfferCodeDaoExtensionHandler() {
    // Arrange and Act
    DefaultOfferCodeDaoExtensionHandler actualDefaultOfferCodeDaoExtensionHandler = new DefaultOfferCodeDaoExtensionHandler();

    // Assert
    assertEquals(0, actualDefaultOfferCodeDaoExtensionHandler.getPriority());
    assertTrue(actualDefaultOfferCodeDaoExtensionHandler.isEnabled());
  }
}
