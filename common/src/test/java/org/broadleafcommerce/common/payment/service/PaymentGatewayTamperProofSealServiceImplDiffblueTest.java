package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentGatewayTamperProofSealServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentGatewayTamperProofSealServiceImplDiffblueTest {
  @Autowired
  private PaymentGatewayTamperProofSealServiceImpl paymentGatewayTamperProofSealServiceImpl;

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 0cTiUxuvZqKt3MjpP-1MASO2KNY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn0cTiUxuvZqKt3MjpP1maso2kny()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "0cTiUxuvZqKt3MjpP-1MASO2KNY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 0xuCa4XmNlvaNCW-hGHhYtcAfII}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn0xuCa4XmNlvaNCWHGHhYtcAfII()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "0xuCa4XmNlvaNCW-hGHhYtcAfII",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 1FG2gnnvrVQ5SpyDxaD3_gTv-us}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn1FG2gnnvrVQ5SpyDxaD3GTvUs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "1FG2gnnvrVQ5SpyDxaD3_gTv-us",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 1oV__tbpXGKi0rq0dDh97i_HHuQ}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn1oVTbpXGKi0rq0dDh97iHHuQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "1oV__tbpXGKi0rq0dDh97i_HHuQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 3BS7a4LwmaD1l6lqK8LBjHr-vgA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn3BS7a4LwmaD1l6lqK8LBjHrVgA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "3BS7a4LwmaD1l6lqK8LBjHr-vgA",
        new PaymentGatewayTamperProofSealServiceImpl().createTamperProofSeal("42", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 3NX10gZmJvHiufpD0-CcPiap4IM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn3NX10gZmJvHiufpD0CcPiap4IM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "3NX10gZmJvHiufpD0-CcPiap4IM",
        new PaymentGatewayTamperProofSealServiceImpl().createTamperProofSeal("Secret Key", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 5YKBudoB1KzRuw9CZ_u5i1Z6VpI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn5YKBudoB1KzRuw9CZU5i1Z6VpI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "5YKBudoB1KzRuw9CZ_u5i1Z6VpI",
        new PaymentGatewayTamperProofSealServiceImpl().createTamperProofSeal("42", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 7f0cgKmhwUd_tPNoRpfDt_3XL2o}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn7f0cgKmhwUdTPNoRpfDt3XL2o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "7f0cgKmhwUd_tPNoRpfDt_3XL2o",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 240sUHqX-D8nXPbQTqIGyJ9tanI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn240sUHqXD8nXPbQTqIGyJ9tanI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "240sUHqX-D8nXPbQTqIGyJ9tanI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code 944XXw0vCyFbIE4-QfJ3HWzXWME}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturn944XXw0vCyFbIE4QfJ3HWzXWME()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "944XXw0vCyFbIE4-QfJ3HWzXWME",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code aLmtqIfRgKMqNUtNJmVhwsMnCSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnALmtqIfRgKMqNUtNJmVhwsMnCSE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "aLmtqIfRgKMqNUtNJmVhwsMnCSE",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code Af-VMmIUYJ8hSeTiz8sZxnFAu-0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnAfVMmIUYJ8hSeTiz8sZxnFAu0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Af-VMmIUYJ8hSeTiz8sZxnFAu-0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code CAp7B9ynYEs6skxV6Q3_FjfCxkg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnCAp7B9ynYEs6skxV6Q3FjfCxkg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "CAp7B9ynYEs6skxV6Q3_FjfCxkg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code CbSCTyjPn5vF0OgyXrRXj5B3VKM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnCbSCTyjPn5vF0OgyXrRXj5B3VKM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "CbSCTyjPn5vF0OgyXrRXj5B3VKM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code cbYPFheiOZmJ4tmPvSqdxF8SeYU}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnCbYPFheiOZmJ4tmPvSqdxF8SeYU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "cbYPFheiOZmJ4tmPvSqdxF8SeYU",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("Secret Key", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code CzYF3m-tO6XGaLgv59f_-gFkcX0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnCzYF3mTO6XGaLgv59fGFkcX0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "CzYF3m-tO6XGaLgv59f_-gFkcX0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code dQ-MTlBbXwNfXcLGA84YP9T9cXs}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnDQMTlBbXwNfXcLGA84YP9T9cXs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "dQ-MTlBbXwNfXcLGA84YP9T9cXs",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code E8uB0wx9qTV5boBcN00CH66s_cw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnE8uB0wx9qTV5boBcN00CH66sCw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "E8uB0wx9qTV5boBcN00CH66s_cw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code FcXvaeATPdTjsRW1_oBz5ED3ckY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnFcXvaeATPdTjsRW1OBz5ED3ckY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "FcXvaeATPdTjsRW1_oBz5ED3ckY",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code GAn4gYYGpYQsc88VJztrF_v8W4c}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnGAn4gYYGpYQsc88VJztrFV8W4c()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "GAn4gYYGpYQsc88VJztrF_v8W4c",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code gO7ojKOcGuRaE7Ve5whET2sRimI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnGO7ojKOcGuRaE7Ve5whET2sRimI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "gO7ojKOcGuRaE7Ve5whET2sRimI",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("Secret Key", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code h9iN8mYez-IDmhMPRI0W60ofKt8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnH9iN8mYezIDmhMPRI0W60ofKt8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "h9iN8mYez-IDmhMPRI0W60ofKt8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code HZ8Q5Jv9Tgcpc1LJc0NiKqnrOfo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnHZ8Q5Jv9Tgcpc1LJc0NiKqnrOfo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "HZ8Q5Jv9Tgcpc1LJc0NiKqnrOfo",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnHaTqhQ4C8ZHUrFsNEZnmPH6Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code hyr6f0l6i3shGZ-tBIVtsmlGPGk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnHyr6f0l6i3shGZTBIVtsmlGPGk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "hyr6f0l6i3shGZ-tBIVtsmlGPGk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code jU-zOu3QBocS8YOGlKpC9q6SKmo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnJUZOu3QBocS8YOGlKpC9q6SKmo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "jU-zOu3QBocS8YOGlKpC9q6SKmo",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code k3WhDJbk7t8-T1RYtwnCNnW0w1k}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnK3WhDJbk7t8T1RYtwnCNnW0w1k()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "k3WhDJbk7t8-T1RYtwnCNnW0w1k",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code k_DJ5Vkfw6QlT8qVQfiqTjudhSM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnKDJ5Vkfw6QlT8qVQfiqTjudhSM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "k_DJ5Vkfw6QlT8qVQfiqTjudhSM",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code kLqBNAOTfi1Oe9teyghts6jlfe8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnKLqBNAOTfi1Oe9teyghts6jlfe8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "kLqBNAOTfi1Oe9teyghts6jlfe8",
        new PaymentGatewayTamperProofSealServiceImpl().createTamperProofSeal("42", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code KTmbTv_qZAdQlX41cQTV3FMqeGA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnKTmbTvQZAdQlX41cQTV3FMqeGA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "KTmbTv_qZAdQlX41cQTV3FMqeGA",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code Kd2X8f8X2FS1DbGrE4Prsnya22w}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnKd2X8f8X2FS1DbGrE4Prsnya22w()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Kd2X8f8X2FS1DbGrE4Prsnya22w",
        new PaymentGatewayTamperProofSealServiceImpl().createTamperProofSeal("42", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code L__ngKnTQDrBl8pDTvvt15QjcmA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnLNgKnTQDrBl8pDTvvt15QjcmA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "L__ngKnTQDrBl8pDTvvt15QjcmA",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code m3GIMULiACYDokdOqmpnmlLGDTs}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnM3GIMULiACYDokdOqmpnmlLGDTs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "m3GIMULiACYDokdOqmpnmlLGDTs",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code Nh5cUzNCCqFA38q4QksMVXlNQE0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnNh5cUzNCCqFA38q4QksMVXlNQE0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Nh5cUzNCCqFA38q4QksMVXlNQE0",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("Secret Key", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code OYSa-F1TykPsyT3j-mUVrZADxsw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnOYSaF1TykPsyT3jMUVrZADxsw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "OYSa-F1TykPsyT3j-mUVrZADxsw",
        new PaymentGatewayTamperProofSealServiceImpl().createTamperProofSeal("42", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code pPHhTOX7bpS3zBzZgPHIGFinME8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnPPHhTOX7bpS3zBzZgPHIGFinME8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "pPHhTOX7bpS3zBzZgPHIGFinME8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code PPbOlss1kJA_6Aez09SlKVCThO8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnPPbOlss1kJA6Aez09SlKVCThO8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "PPbOlss1kJA_6Aez09SlKVCThO8",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code pi7Z6_OLowr63TFhzpEi2-vcrgk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnPi7Z6OLowr63TFhzpEi2Vcrgk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "pi7Z6_OLowr63TFhzpEi2-vcrgk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code pvbmP5Y3jlUvZ8yjaAbNYKkz9us}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnPvbmP5Y3jlUvZ8yjaAbNYKkz9us()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "pvbmP5Y3jlUvZ8yjaAbNYKkz9us",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code Q3dYmgPS1YUEB4x-qeMDS6EBsGY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnQ3dYmgPS1YUEB4xQeMDS6EBsGY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Q3dYmgPS1YUEB4x-qeMDS6EBsGY",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("Secret Key", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code q6pjVjanGrLn0-FHk2SWXBSi5aE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnQ6pjVjanGrLn0FHk2SWXBSi5aE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "q6pjVjanGrLn0-FHk2SWXBSi5aE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code r8qFzFsWTHudoGqSwmoWZj0g4xo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnR8qFzFsWTHudoGqSwmoWZj0g4xo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "r8qFzFsWTHudoGqSwmoWZj0g4xo",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code SNqY6ufenJLOT51LeJyKLF5XsHY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnSNqY6ufenJLOT51LeJyKLF5XsHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "SNqY6ufenJLOT51LeJyKLF5XsHY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnSNqsTSzcdqtIvTFHUEVghnf0xHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code sbU42dGCepiXJcDpu6LAYd7bZR0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnSbU42dGCepiXJcDpu6LAYd7bZR0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "sbU42dGCepiXJcDpu6LAYd7bZR0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code syis3762QsgnWmaaBsLqBDPNQ3M}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnSyis3762QsgnWmaaBsLqBDPNQ3M()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "syis3762QsgnWmaaBsLqBDPNQ3M",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code t4O7JXDlKRm_Z6yxPWhnawAzS3c}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnT4O7JXDlKRmZ6yxPWhnawAzS3c()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "t4O7JXDlKRm_Z6yxPWhnawAzS3c",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code TZ_g0Hkz9b5skaqHXRWD73nymX0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnTzG0Hkz9b5skaqHXRWD73nymX0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "TZ_g0Hkz9b5skaqHXRWD73nymX0",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("Secret Key", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code uSgW-GUHcUxlkXUs40cppvJsmw0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnUSgWGUHcUxlkXUs40cppvJsmw0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "uSgW-GUHcUxlkXUs40cppvJsmw0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code unwoUqLrNg8O9Bae56ELJ3Uqb1Q}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnUnwoUqLrNg8O9Bae56ELJ3Uqb1Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "unwoUqLrNg8O9Bae56ELJ3Uqb1Q",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code V0fZCg5pMaPIYBqmrG0Y3gMZbns}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnV0fZCg5pMaPIYBqmrG0Y3gMZbns()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "V0fZCg5pMaPIYBqmrG0Y3gMZbns",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code vhSwWFhvNbKEmyaP_jvB97d2R38}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnVhSwWFhvNbKEmyaPJvB97d2R38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "vhSwWFhvNbKEmyaP_jvB97d2R38",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code w9zO-4-eV0Z4LTKIjubXI9zeaz0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnW9zO4EV0Z4LTKIjubXI9zeaz0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "w9zO-4-eV0Z4LTKIjubXI9zeaz0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code xhp6XDhmH1Dc2d9xYCesihrX_D4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnXhp6XDhmH1Dc2d9xYCesihrXD4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "xhp6XDhmH1Dc2d9xYCesihrX_D4",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code YEGXTyELVHUPQ1wAAF28Wi8clsE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnYEGXTyELVHUPQ1wAAF28Wi8clsE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "YEGXTyELVHUPQ1wAAF28Wi8clsE",
        new PaymentGatewayTamperProofSealServiceImpl().createTamperProofSeal("42", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code YT5LaGhSGi98t1LY_3DTbqbpYOo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnYT5LaGhSGi98t1LY3DTbqbpYOo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "YT5LaGhSGi98t1LY_3DTbqbpYOo",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code Yc3IfLaBbSqp9kuxL58YZRlu0hI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnYc3IfLaBbSqp9kuxL58YZRlu0hI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Yc3IfLaBbSqp9kuxL58YZRlu0hI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code zEhbW5bsG5OQ9DZUNKGW-yxjVoY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnZEhbW5bsG5OQ9DZUNKGWYxjVoY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "zEhbW5bsG5OQ9DZUNKGW-yxjVoY",
        new PaymentGatewayTamperProofSealServiceImpl()
            .createTamperProofSeal("42", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code ZatE8KJTwTBQ7jlSjw-ZoR7x2XI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnZatE8KJTwTBQ7jlSjwZoR7x2XI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "ZatE8KJTwTBQ7jlSjw-ZoR7x2XI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code zhuzagJl7J1hq_o1mUMKPDK2hkw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_thenReturnZhuzagJl7J1hqO1mUMKPDK2hkw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "zhuzagJl7J1hq_o1mUMKPDK2hkw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_when42_thenReturnJtaejkMTk2LMEqShMFY1GTRYxp0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "JtaejkMTk2LMEqShMFY1GTRYxp0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code 4af_i5eWdzpsBvBoD9A_vptOhxA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturn4afI5eWdzpsBvBoD9AVptOhxA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "4af_i5eWdzpsBvBoD9A_vptOhxA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code 6fVQO8Iz_cH_Da3lajTtaaNLiHY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturn6fVQO8IzCHDa3lajTtaaNLiHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "6fVQO8Iz_cH_Da3lajTtaaNLiHY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code 79-icLuv45Um14pDOoK2S7kht-Y}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturn79IcLuv45Um14pDOoK2S7khtY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "79-icLuv45Um14pDOoK2S7kht-Y",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code CZRHEvvDmdIJ6XCGZD_DrBL_sDw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnCZRHEvvDmdIJ6XCGZDDrBLSDw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "CZRHEvvDmdIJ6XCGZD_DrBL_sDw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code eQhspWHVS5CqB-S5mY1haaKyyxk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnEQhspWHVS5CqBS5mY1haaKyyxk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "eQhspWHVS5CqB-S5mY1haaKyyxk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code ETyIyJs7lK1ykyUGjuwqPhvtBAo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnETyIyJs7lK1ykyUGjuwqPhvtBAo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "ETyIyJs7lK1ykyUGjuwqPhvtBAo",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code GbAGpzDDR4HbrQkT9Ae-l1OIUTc}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnGbAGpzDDR4HbrQkT9AeL1OIUTc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "GbAGpzDDR4HbrQkT9Ae-l1OIUTc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code k_8FS97EthV3pxCOfGSyXd1RjZA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnK8FS97EthV3pxCOfGSyXd1RjZA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "k_8FS97EthV3pxCOfGSyXd1RjZA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code LYVGmwZjXmI0USYv8DjWFNoFZLc}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnLYVGmwZjXmI0USYv8DjWFNoFZLc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "LYVGmwZjXmI0USYv8DjWFNoFZLc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code Ln6nNiLKww163oSX6vHrv3NuyaE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnLn6nNiLKww163oSX6vHrv3NuyaE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Ln6nNiLKww163oSX6vHrv3NuyaE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code nRuc5Dw1SGLVEldnmtqPKIjA_yg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnNRuc5Dw1SGLVEldnmtqPKIjAYg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "nRuc5Dw1SGLVEldnmtqPKIjA_yg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnOQbDLn8zttlxvxVF7DhTFV1jdY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code RiPpb2KwscLxTcKvAY239R9Dr1o}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnRiPpb2KwscLxTcKvAY239R9Dr1o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "RiPpb2KwscLxTcKvAY239R9Dr1o",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code -SlQFjnDqiHsBfW8zGZMu1tUaK0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnSlQFjnDqiHsBfW8zGZMu1tUaK0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "-SlQFjnDqiHsBfW8zGZMu1tUaK0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code Tt_3gK3DnJVt3Qy0Ra1bNuZVbCM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnTt3gK3DnJVt3Qy0Ra1bNuZVbCM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Tt_3gK3DnJVt3Qy0Ra1bNuZVbCM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code WseeBqcg5S3cdiIcoBJx14auFcs}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnWseeBqcg5S3cdiIcoBJx14auFcs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "WseeBqcg5S3cdiIcoBJx14auFcs",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code x1n7atITF0SqSdwCRifqoNxPMew}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnX1n7atITF0SqSdwCRifqoNxPMew()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "x1n7atITF0SqSdwCRifqoNxPMew",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code xSgXnRtQjjrSTPwOWSBNcl0H4h8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCr_thenReturnXSgXnRtQjjrSTPwOWSBNcl0H4h8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "xSgXnRtQjjrSTPwOWSBNcl0H4h8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code 1QWOEuh3iLj4ZBjz_pgwqFuWlDg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn1QWOEuh3iLj4ZBjzPgwqFuWlDg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "1QWOEuh3iLj4ZBjz_pgwqFuWlDg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code 1amYbQZvHgCZLYtK8eg0CivLfdQ}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn1amYbQZvHgCZLYtK8eg0CivLfdQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "1amYbQZvHgCZLYtK8eg0CivLfdQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code 6cgj6FzexH5PElZa2zfOgccYZkA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn6cgj6FzexH5PElZa2zfOgccYZkA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "6cgj6FzexH5PElZa2zfOgccYZkA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code 6P0_pyBuAWAE5fcFbgp__aHbx2k}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn6p0PyBuAWAE5fcFbgpAHbx2k()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "6P0_pyBuAWAE5fcFbgp__aHbx2k",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code 57_xUZQ4O5-vUs2oScOrdlFtoyE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn57XUZQ4O5VUs2oScOrdlFtoyE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "57_xUZQ4O5-vUs2oScOrdlFtoyE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code aILCXCOZX7wqasHbiQI1Pe6ie8s}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnAILCXCOZX7wqasHbiQI1Pe6ie8s()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "aILCXCOZX7wqasHbiQI1Pe6ie8s",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code AK1QP7g5usw8quMcMHU7PPgXdU4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnAK1QP7g5usw8quMcMHU7PPgXdU4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "AK1QP7g5usw8quMcMHU7PPgXdU4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code HhSbrjIWn4WOgkwctW646uWf4Zg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnHhSbrjIWn4WOgkwctW646uWf4Zg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "HhSbrjIWn4WOgkwctW646uWf4Zg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code IzEdrUsmDR1OZpb7QPnursck8VM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnIzEdrUsmDR1OZpb7QPnursck8VM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "IzEdrUsmDR1OZpb7QPnursck8VM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code k4iqQQ4gJsE-d3OJMS86PuaWJfM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnK4iqQQ4gJsED3OJMS86PuaWJfM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "k4iqQQ4gJsE-d3OJMS86PuaWJfM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code ncvvM7lzC6pX-oRzr_QReoMRuY8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnNcvvM7lzC6pXORzrQReoMRuY8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "ncvvM7lzC6pX-oRzr_QReoMRuY8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code QDFXJ8lrRWasejqgFqu6GaXU7XA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnQDFXJ8lrRWasejqgFqu6GaXU7XA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "QDFXJ8lrRWasejqgFqu6GaXU7XA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code STGAgqhH7U4EU5wmR7UMKpvM8RM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnSTGAgqhH7U4EU5wmR7UMKpvM8RM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "STGAgqhH7U4EU5wmR7UMKpvM8RM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code tb-_zjqDr08WuaSpvpFJ-K-mvuY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnTbZjqDr08WuaSpvpFJKMvuY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "tb-_zjqDr08WuaSpvpFJ-K-mvuY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code u1zevV4-jxVinvk2Vw0CX7JJE38}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnU1zevV4JxVinvk2Vw0CX7JJE38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "u1zevV4-jxVinvk2Vw0CX7JJE38",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code u7Cn8yIBSmbfmFJ4AKuvIyTzhGk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnU7Cn8yIBSmbfmFJ4AKuvIyTzhGk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "u7Cn8yIBSmbfmFJ4AKuvIyTzhGk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code UzDK6P_NGwsY7jYY9idqgt9QnG0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnUzDK6PNGwsY7jYY9idqgt9QnG0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "UzDK6P_NGwsY7jYY9idqgt9QnG0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code X3hva1xmdWKX2P1I0wLj2TpczuE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnX3hva1xmdWKX2P1I0wLj2TpczuE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "X3hva1xmdWKX2P1I0wLj2TpczuE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Customer Id}.
   *   <li>Then return {@code y7e5MkvHkO1g0bekZwSegC9TNcM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnY7e5MkvHkO1g0bekZwSegC9TNcM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "y7e5MkvHkO1g0bekZwSegC9TNcM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code 7TfFqE43gT4uk0foYCMo9JKk4zw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturn7TfFqE43gT4uk0foYCMo9JKk4zw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "7TfFqE43gT4uk0foYCMo9JKk4zw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code auuhV1xDnb8ktZzd8tff-UZ92uM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnAuuhV1xDnb8ktZzd8tffUZ92uM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "auuhV1xDnb8ktZzd8tff-UZ92uM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code B355E25AoLrFMrmvjn__ahU0fa4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnB355E25AoLrFMrmvjnAhU0fa4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "B355E25AoLrFMrmvjn__ahU0fa4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code eeJj8ru73d0-4iECLNthWYbBHXw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnEeJj8ru73d04iECLNthWYbBHXw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "eeJj8ru73d0-4iECLNthWYbBHXw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code hN2eppko516z5VaLAgXcrkYphQs}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnHN2eppko516z5VaLAgXcrkYphQs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "hN2eppko516z5VaLAgXcrkYphQs",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code JQjvhNx-FpTbRHJi1qBhld59Olw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnJQjvhNxFpTbRHJi1qBhld59Olw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "JQjvhNx-FpTbRHJi1qBhld59Olw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code kUMPgvAgA5T0Kj2bleKR-9PVbZg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnKUMPgvAgA5T0Kj2bleKR9PVbZg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "kUMPgvAgA5T0Kj2bleKR-9PVbZg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code lN0PO7CIrk2Wl462LHgxAEqAIXk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnLN0PO7CIrk2Wl462LHgxAEqAIXk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "lN0PO7CIrk2Wl462LHgxAEqAIXk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code MRciCXfeaElXsZa_WipdCZXl2ZI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnMRciCXfeaElXsZaWipdCZXl2ZI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "MRciCXfeaElXsZa_WipdCZXl2ZI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code NmJzZUVEdaMhlP68n-vvAQt7Res}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnNmJzZUVEdaMhlP68nVvAQt7Res()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "NmJzZUVEdaMhlP68n-vvAQt7Res",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code QALRtNESDXJ7AiDaXTaV-4WnWeo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnQALRtNESDXJ7AiDaXTaV4WnWeo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "QALRtNESDXJ7AiDaXTaV-4WnWeo",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code qLpyinyyNQ0JNfbSrYA-_FEYcmY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnQLpyinyyNQ0JNfbSrYAFEYcmY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "qLpyinyyNQ0JNfbSrYA-_FEYcmY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code u-s6ttrQER2E7F9lnys74vdU7VI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnUS6ttrQER2E7F9lnys74vdU7VI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "u-s6ttrQER2E7F9lnys74vdU7VI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code v1L5FBjl32VmI2fHiwYaLvPwsK0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnV1L5FBjl32VmI2fHiwYaLvPwsK0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "v1L5FBjl32VmI2fHiwYaLvPwsK0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code y2-djIQ8IuU9uX9_0v8gq1jJHjE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnY2DjIQ8IuU9uX90v8gq1jJHjE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "y2-djIQ8IuU9uX9_0v8gq1jJHjE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code yEx9BbISXzx3z3OyBExvrMr7-Vs}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnYEx9BbISXzx3z3OyBExvrMr7Vs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "yEx9BbISXzx3z3OyBExvrMr7-Vs",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code 6sPG1MdgV0yWMccYU786xZL4zII}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn6sPG1MdgV0yWMccYU786xZL4zII()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "6sPG1MdgV0yWMccYU786xZL4zII",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code 29cZvFHL1BiopnxiDKwl-gfbgls}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn29cZvFHL1BiopnxiDKwlGfbgls()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "29cZvFHL1BiopnxiDKwl-gfbgls",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code 80oK7Knum6cOjZRb4Oxa2ATox3U}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn80oK7Knum6cOjZRb4Oxa2ATox3U()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "80oK7Knum6cOjZRb4Oxa2ATox3U",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code ADKW7x46hnNb1EHbrnw_5TnRGsk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnADKW7x46hnNb1EHbrnw5TnRGsk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "ADKW7x46hnNb1EHbrnw_5TnRGsk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code C5jjBlb6QlM7Cc4-irOOMgeUWTY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnC5jjBlb6QlM7Cc4IrOOMgeUWTY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "C5jjBlb6QlM7Cc4-irOOMgeUWTY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code CrzNAPnHy9G_waOATyKAE0ZRTBk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnCrzNAPnHy9GWaOATyKAE0ZRTBk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "CrzNAPnHy9G_waOATyKAE0ZRTBk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code eMdhaldlNjPK0VTwcRCCjQzJfkE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnEMdhaldlNjPK0VTwcRCCjQzJfkE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "eMdhaldlNjPK0VTwcRCCjQzJfkE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code hRz2dH3-ibGiESQ2kZHr3EC6TvI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnHRz2dH3IbGiESQ2kZHr3EC6TvI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "hRz2dH3-ibGiESQ2kZHr3EC6TvI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnIgPuvGE50jePFMloMJXfiXBkB8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "IgPuvGE5_0jePFMloMJXfiXBkB8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code lLqvQD4NaAu4YacPPoVW4Kk9JGA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnLLqvQD4NaAu4YacPPoVW4Kk9JGA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "lLqvQD4NaAu4YacPPoVW4Kk9JGA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code RH45VxwkybzBn5fd_zP-yn7u1Og}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnRH45VxwkybzBn5fdZPYn7u1Og()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "RH45VxwkybzBn5fd_zP-yn7u1Og",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code s9TvOu9HAuD1uNWOWs9Aqn6Q_e0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnS9TvOu9HAuD1uNWOWs9Aqn6QE0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "s9TvOu9HAuD1uNWOWs9Aqn6Q_e0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code sM5V8ywc2a0KV8IKYIh54Xkpklk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnSM5V8ywc2a0KV8IKYIh54Xkpklk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "sM5V8ywc2a0KV8IKYIh54Xkpklk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code t20sMpGd9nJzrEA7rULqdrpVKBc}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnT20sMpGd9nJzrEA7rULqdrpVKBc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "t20sMpGd9nJzrEA7rULqdrpVKBc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code tBT9IkrBlGo_aaGw7GjJA3Sf6n4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnTBT9IkrBlGoAaGw7GjJA3Sf6n4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "tBT9IkrBlGo_aaGw7GjJA3Sf6n4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code vwWXvQHEVfDexI1q-190cl43Jr8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnVwWXvQHEVfDexI1q190cl43Jr8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "vwWXvQHEVfDexI1q-190cl43Jr8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code YEe8Zbj12HXypdlqW5fpA9MASjI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnYEe8Zbj12HXypdlqW5fpA9MASjI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "YEe8Zbj12HXypdlqW5fpA9MASjI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code HmacSHA1}.
   *   <li>Then return {@code zuo52h9A9V5XAzI_zpznypMw6Vw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnZuo52h9A9V5XAzIZpznypMw6Vw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "zuo52h9A9V5XAzI_zpznypMw6Vw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code 1VfOoYCXAKA2P3M-R_e4mltDZSk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturn1VfOoYCXAKA2P3MRE4mltDZSk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "1VfOoYCXAKA2P3M-R_e4mltDZSk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code AX8b4TYA9MpsLrTZLxj-mKFXliQ}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnAX8b4TYA9MpsLrTZLxjMKFXliQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "AX8b4TYA9MpsLrTZLxj-mKFXliQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\r", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code CX-3_rrPPwmmqMEr281LSo8QQGU}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnCx3RrPPwmmqMEr281LSo8QQGU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "CX-3_rrPPwmmqMEr281LSo8QQGU",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code EIkRJNg0TZE1TzshK9upv4BjtcY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnEIkRJNg0TZE1TzshK9upv4BjtcY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "EIkRJNg0TZE1TzshK9upv4BjtcY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code hVa4apvKTYIaIC2umOFItoBD3v0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnHVa4apvKTYIaIC2umOFItoBD3v0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "hVa4apvKTYIaIC2umOFItoBD3v0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code kqxM8Tzfwsum2nyJr7JwYEFV3n8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnKqxM8Tzfwsum2nyJr7JwYEFV3n8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "kqxM8Tzfwsum2nyJr7JwYEFV3n8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code NQyD_thR-_aaQBJt1B4fxXeg6bY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnNQyDThRAaQBJt1B4fxXeg6bY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "NQyD_thR-_aaQBJt1B4fxXeg6bY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code NWTMzqcB908ioU4LVaQ1yic21Hs}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnNWTMzqcB908ioU4LVaQ1yic21Hs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "NWTMzqcB908ioU4LVaQ1yic21Hs",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code rjEgg7TrjD21YbF1Pj2HpuzFD8U}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnRjEgg7TrjD21YbF1Pj2HpuzFD8U()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "rjEgg7TrjD21YbF1Pj2HpuzFD8U",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code RsHATo0gMfYPN-9nn7e2W7PJrvQ}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnRsHATo0gMfYPN9nn7e2W7PJrvQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "RsHATo0gMfYPN-9nn7e2W7PJrvQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code SScqF1YWaUdqIahBm5YPCWZW7g8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnSScqF1YWaUdqIahBm5YPCWZW7g8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "SScqF1YWaUdqIahBm5YPCWZW7g8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code SUHDXUtU6vGkVPFl8Lnl5iOPaYM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnSUHDXUtU6vGkVPFl8Lnl5iOPaYM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "SUHDXUtU6vGkVPFl8Lnl5iOPaYM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "HmacSHA1", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code TApyTv5MGy2w7o1fHiPLsjzcnxU}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnTApyTv5MGy2w7o1fHiPLsjzcnxU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "TApyTv5MGy2w7o1fHiPLsjzcnxU",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code zOSq2hpABr-LLc1G46RW-8beL1o}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZOSq2hpABrLLc1G46RW8beL1o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "zOSq2hpABr-LLc1G46RW-8beL1o",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code zSzsiPkWG1rrMqfODpjYnHIg1K4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZSzsiPkWG1rrMqfODpjYnHIg1K4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "zSzsiPkWG1rrMqfODpjYnHIg1K4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Order Id}.
   *   <li>Then return {@code zth0bsNh58_HOtwKcXJaZnWc4pg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZth0bsNh58HOtwKcXJaZnWc4pg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "zth0bsNh58_HOtwKcXJaZnWc4pg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code 4T9ViMN9kPm2eOfw_lmPTltEpvc}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturn4T9ViMN9kPm2eOfwLmPTltEpvc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "4T9ViMN9kPm2eOfw_lmPTltEpvc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code 7p9RiPGXWv2m6JJmm4FL7WyrTvk}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturn7p9RiPGXWv2m6JJmm4FL7WyrTvk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "7p9RiPGXWv2m6JJmm4FL7WyrTvk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code BVA1ih2GRXJd5IYwBfK1JMlaD08}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnBVA1ih2GRXJd5IYwBfK1JMlaD08()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "BVA1ih2GRXJd5IYwBfK1JMlaD08",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code bbvm6hUe446B2WGX20DzQlKkcxI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnBbvm6hUe446B2WGX20DzQlKkcxI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "bbvm6hUe446B2WGX20DzQlKkcxI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code bcPjL2TRZ5CZBHntd9JYEieUl2s}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnBcPjL2TRZ5CZBHntd9JYEieUl2s()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "bcPjL2TRZ5CZBHntd9JYEieUl2s",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code BnYRKOfRIC9DMJLtCE-2UkiGYak}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnBnYRKOfRIC9DMJLtCE2UkiGYak()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "BnYRKOfRIC9DMJLtCE-2UkiGYak",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code cAj578aKEA1-EcROx0HTKoc3P-M}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnCAj578aKEA1EcROx0HTKoc3PM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "cAj578aKEA1-EcROx0HTKoc3P-M",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code cFW-4rT4eP0vgYH2yiPj36-l2a0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnCFW4rT4eP0vgYH2yiPj36L2a0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "cFW-4rT4eP0vgYH2yiPj36-l2a0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code ihVrSsnC8fiu8SiPivzbAEJj2TI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnIhVrSsnC8fiu8SiPivzbAEJj2TI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "ihVrSsnC8fiu8SiPivzbAEJj2TI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code M17yZV_JzszrkxItmiPnRZtQjf4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnM17yZVJzszrkxItmiPnRZtQjf4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "M17yZV_JzszrkxItmiPnRZtQjf4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code Mcn6nvm1hXpbc9ysXYm3ZfdFB3I}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnMcn6nvm1hXpbc9ysXYm3ZfdFB3I()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Mcn6nvm1hXpbc9ysXYm3ZfdFB3I",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code nKyXjLcwJ3UGxa7qhAf9EyzKKa4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnNKyXjLcwJ3UGxa7qhAf9EyzKKa4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "nKyXjLcwJ3UGxa7qhAf9EyzKKa4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code -p9bs-jEtuJAinfLljFDNPVsFUM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnP9bsJEtuJAinfLljFDNPVsFUM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "-p9bs-jEtuJAinfLljFDNPVsFUM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code pdbTTbesJ_schLtfBx1nS23XkDQ}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnPdbTTbesJSchLtfBx1nS23XkDQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "pdbTTbesJ_schLtfBx1nS23XkDQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code tlcsbzqr-08sTrthRJsE08u3v68}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnTlcsbzqr08sTrthRJsE08u3v68()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "tlcsbzqr-08sTrthRJsE08u3v68",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code UP_Ef_7OOdAY8T863w-yy7Nv3ew}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnUpEf7OOdAY8T863wYy7Nv3ew()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "UP_Ef_7OOdAY8T863w-yy7Nv3ew",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code vRD_le7AoG35mJ8TlUxA0CPwcU4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnVRDLe7AoG35mJ8TlUxA0CPwcU4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "vRD_le7AoG35mJ8TlUxA0CPwcU4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code \r|\n}.
   *   <li>Then return {@code WLGwVF86PU5LE9WeuR5R7xswJ0w}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenRN_thenReturnWLGwVF86PU5LE9WeuR5R7xswJ0w()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "WLGwVF86PU5LE9WeuR5R7xswJ0w",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "\\r|\\n", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 1gedig7UNOPvzoo0mOLaHAjrZr4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn1gedig7UNOPvzoo0mOLaHAjrZr4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "1gedig7UNOPvzoo0mOLaHAjrZr4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 2Exqd7Qu7Il63qyQgE8NZuWKfto}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn2Exqd7Qu7Il63qyQgE8NZuWKfto()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "2Exqd7Qu7Il63qyQgE8NZuWKfto",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 6IYHxQarxBQRGHiE8fs5-gQG6yo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn6IYHxQarxBQRGHiE8fs5GQG6yo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "6IYHxQarxBQRGHiE8fs5-gQG6yo",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 7bl62f3uLkgt8Md0c9MlB9EMHIs}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn7bl62f3uLkgt8Md0c9MlB9EMHIs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "7bl62f3uLkgt8Md0c9MlB9EMHIs",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 8VL8c4t0AWnRsN6qijgBKXwzS6A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn8VL8c4t0AWnRsN6qijgBKXwzS6A()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "8VL8c4t0AWnRsN6qijgBKXwzS6A",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 9vA79KFt3hmcQZ3L3O5QS9P-wqI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn9vA79KFt3hmcQZ3L3O5QS9PWqI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "9vA79KFt3hmcQZ3L3O5QS9P-wqI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 27pH0rnaUQwJj8kiENtGSSFlcvQ}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn27pH0rnaUQwJj8kiENtGSSFlcvQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "27pH0rnaUQwJj8kiENtGSSFlcvQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn406MqqcTBSOi1sEXVvQWDti9SM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "406Mqqc-tBSOi1sEXVvQWDti9SM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code bgnemZQbnzDK5XEOGDjLPUFnt-c}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnBgnemZQbnzDK5XEOGDjLPUFntC()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "bgnemZQbnzDK5XEOGDjLPUFnt-c",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code F7aq_FAL-_pyNs64_mctc-U71go}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnF7aqFalPyNs64MctcU71go()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "F7aq_FAL-_pyNs64_mctc-U71go",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code HZpMLN4MpN49mrtmiBxWaaIOBRA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnHZpMLN4MpN49mrtmiBxWaaIOBRA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "HZpMLN4MpN49mrtmiBxWaaIOBRA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code JJXwLj2TpuC-FWTlZkKZ8qbtKzQ}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnJJXwLj2TpuCFWTlZkKZ8qbtKzQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "JJXwLj2TpuC-FWTlZkKZ8qbtKzQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code _KbBWddFwcwYG8m4LPuRNAyA1H4}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnKbBWddFwcwYG8m4LPuRNAyA1H4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "_KbBWddFwcwYG8m4LPuRNAyA1H4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code kveMHfkkjyikoL1CzAUD6NOUxXY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnKveMHfkkjyikoL1CzAUD6NOUxXY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "kveMHfkkjyikoL1CzAUD6NOUxXY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code M43QalGWxRXNEX-dPA-mc0TjNJU}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnM43QalGWxRXNEXDPAMc0TjNJU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "M43QalGWxRXNEX-dPA-mc0TjNJU",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code -M96SmqBBfSlx8Kn-JdFnMyJmp8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnM96SmqBBfSlx8KnJdFnMyJmp8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "-M96SmqBBfSlx8Kn-JdFnMyJmp8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code mxRCpfGtSfGHtQxPXhZjf1T65dY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnMxRCpfGtSfGHtQxPXhZjf1T65dY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "mxRCpfGtSfGHtQxPXhZjf1T65dY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code OKmQ8uPR9xWh8p_vLCC6ZAvFDXw}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnOKmQ8uPR9xWh8pVLCC6ZAvFDXw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "OKmQ8uPR9xWh8p_vLCC6ZAvFDXw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code Ptmxmr_uLGUtOzEIIuyVxPT5sWU}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnPtmxmrULGUtOzEIIuyVxPT5sWU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Ptmxmr_uLGUtOzEIIuyVxPT5sWU",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code Q13TRmXqw17rFbL7RkOVUSNR6tI}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnQ13TRmXqw17rFbL7RkOVUSNR6tI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "Q13TRmXqw17rFbL7RkOVUSNR6tI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code qRZ_ovQP6XPR1gB1Qo_7CjG_FpM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnQRZOvQP6XPR1gB1Qo7CjGFpM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "qRZ_ovQP6XPR1gB1Qo_7CjG_FpM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code rS2pgvBS1swthmwG6od86tcenrM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnRS2pgvBS1swthmwG6od86tcenrM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "rS2pgvBS1swthmwG6od86tcenrM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code S3oYZm3Id-Pcddl-XpkH9pWuX1I}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnS3oYZm3IdPcddlXpkH9pWuX1I()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "S3oYZm3Id-Pcddl-XpkH9pWuX1I",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code tYic8o_A1X8PmAnH4YODNbmBJjo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnTYic8oA1X8PmAnH4YODNbmBJjo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "tYic8o_A1X8PmAnH4YODNbmBJjo",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code TzOgIV5L0ZJVu9OilTHjWVhbM0A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnTzOgIV5L0ZJVu9OilTHjWVhbM0A()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "TzOgIV5L0ZJVu9OilTHjWVhbM0A",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Secret Key}.
   *   <li>Then return {@code yagqdk_vYDXHPy9dv45-VLnkcoE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"
  })
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnYagqdkVYDXHPy9dv45VLnkcoE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "yagqdk_vYDXHPy9dv45-VLnkcoE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(
            "Secret Key", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_when42()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_when422()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_when423()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_when424()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_when425()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_when426()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\r", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "Seal", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When cr.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCr13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "Seal", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "HmacSHA1", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "\\r|\\n", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "Customer Id",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId20()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId21()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId22()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId23()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId24()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId25()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Customer Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenCustomerId26()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "Seal", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", null, ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString20()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString21()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "HmacSHA1", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString22()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString23()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString24()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "HmacSHA1", "Seal", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenEmptyString25()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "HmacSHA1", null, ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA1()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA110()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA111()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA112()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA113()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA114()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA115()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA116()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA117()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "HmacSHA1", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA118()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Seal", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA119()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "HmacSHA1", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA120()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA121()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\r", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA122()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA123()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA124()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA125()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Seal", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA126()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Seal", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code HmacSHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenHmacSHA127()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Seal", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            null, "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull20()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull21()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull22()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull23()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\r", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull24()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "HmacSHA1", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull25()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\\r|\\n", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull26()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "Seal", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull27()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", null, "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull28()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", null, "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull29()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", null, "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull30()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", null, "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull31()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", null, null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull32()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "HmacSHA1", "\r", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull33()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull34()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull35()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Seal", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull36()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "HmacSHA1", null, "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull37()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", null, "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", null, "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull39()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", null, "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenNull40()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "HmacSHA1", null, null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Seal", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId20()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId21()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", null, "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId22()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId23()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId24()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId25()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId26()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Seal", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId27()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId28()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", null, "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Order Id}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenOrderId29()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN20()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN21()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN22()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN23()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN24()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN25()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN26()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN27()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN28()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN29()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN30()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN31()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN32()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "\\r|\\n", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN33()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl().verifySeal("Seal", "\r", "Seal", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN34()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN35()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN36()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN37()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN39()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code \r|\n}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenRN40()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Seal", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Secret Key", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Secret Key", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Secret Key", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Secret Key", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl}.
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Secret Key", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Secret Key", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Secret Key", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PaymentGatewayTamperProofSealServiceImpl} (default constructor).
   *   <li>When {@code Secret Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_givenPaymentGatewayTamperProofSealServiceImpl_whenSecretKey18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Secret Key", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 4OLe0d5c2uJKjCKKf-z6Qe2IlME}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when4OLe0d5c2uJKjCKKfZ6Qe2IlME()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "4OLe0d5c2uJKjCKKf-z6Qe2IlME", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 4OLe0d5c2uJKjCKKf-z6Qe2IlME}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when4OLe0d5c2uJKjCKKfZ6Qe2IlME2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "4OLe0d5c2uJKjCKKf-z6Qe2IlME",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 7TfFqE43gT4uk0foYCMo9JKk4zw}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when7TfFqE43gT4uk0foYCMo9JKk4zw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "7TfFqE43gT4uk0foYCMo9JKk4zw", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 7TfFqE43gT4uk0foYCMo9JKk4zw}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when7TfFqE43gT4uk0foYCMo9JKk4zw2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "", "7TfFqE43gT4uk0foYCMo9JKk4zw"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 7f0cgKmhwUd_tPNoRpfDt_3XL2o}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when7f0cgKmhwUdTPNoRpfDt3XL2o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "7f0cgKmhwUd_tPNoRpfDt_3XL2o", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 7f0cgKmhwUd_tPNoRpfDt_3XL2o}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when7f0cgKmhwUdTPNoRpfDt3XL2o2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal",
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
            "HmacSHA1",
            "7f0cgKmhwUd_tPNoRpfDt_3XL2o"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 7helzpZSnhza-7W92tJ4mhPlQsg}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when7helzpZSnhza7W92tJ4mhPlQsg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "7helzpZSnhza-7W92tJ4mhPlQsg", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 7helzpZSnhza-7W92tJ4mhPlQsg}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when7helzpZSnhza7W92tJ4mhPlQsg2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "7helzpZSnhza-7W92tJ4mhPlQsg",
                null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 9QhgtAKF_iOyZrixWR4ZXLr2wa0}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when9QhgtAKFIOyZrixWR4ZXLr2wa0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "9QhgtAKF_iOyZrixWR4ZXLr2wa0", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 9QhgtAKF_iOyZrixWR4ZXLr2wa0}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when9QhgtAKFIOyZrixWR4ZXLr2wa02()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "9QhgtAKF_iOyZrixWR4ZXLr2wa0", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 79-icLuv45Um14pDOoK2S7kht-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when79IcLuv45Um14pDOoK2S7khtY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "79-icLuv45Um14pDOoK2S7kht-Y", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 79-icLuv45Um14pDOoK2S7kht-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when79IcLuv45Um14pDOoK2S7khtY2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "79-icLuv45Um14pDOoK2S7kht-Y", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when406MqqcTBSOi1sEXVvQWDti9SM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Secret Key", "406Mqqc-tBSOi1sEXVvQWDti9SM", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_when406MqqcTBSOi1sEXVvQWDti9SM2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Secret Key", "42", "406Mqqc-tBSOi1sEXVvQWDti9SM"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code AK__Dht6Kh9LJgsFSixaNw7owOU}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenAkDht6Kh9LJgsFSixaNw7owOU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "AK__Dht6Kh9LJgsFSixaNw7owOU", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code AK__Dht6Kh9LJgsFSixaNw7owOU}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenAkDht6Kh9LJgsFSixaNw7owOU2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "AK__Dht6Kh9LJgsFSixaNw7owOU"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code ByPp6oyyYtSpNy-glhed81Se1G8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenByPp6oyyYtSpNyGlhed81Se1G8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "ByPp6oyyYtSpNy-glhed81Se1G8", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code ByPp6oyyYtSpNy-glhed81Se1G8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenByPp6oyyYtSpNyGlhed81Se1G82()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Seal", "ByPp6oyyYtSpNy-glhed81Se1G8"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code CZRHEvvDmdIJ6XCGZD_DrBL_sDw}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenCZRHEvvDmdIJ6XCGZDDrBLSDw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "CZRHEvvDmdIJ6XCGZD_DrBL_sDw", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code CZRHEvvDmdIJ6XCGZD_DrBL_sDw}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenCZRHEvvDmdIJ6XCGZDDrBLSDw2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "CZRHEvvDmdIJ6XCGZD_DrBL_sDw", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code E8uB0wx9qTV5boBcN00CH66s_cw}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenE8uB0wx9qTV5boBcN00CH66sCw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "E8uB0wx9qTV5boBcN00CH66s_cw", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code E8uB0wx9qTV5boBcN00CH66s_cw}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenE8uB0wx9qTV5boBcN00CH66sCw2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "E8uB0wx9qTV5boBcN00CH66s_cw",
                "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EIkRJNg0TZE1TzshK9upv4BjtcY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEIkRJNg0TZE1TzshK9upv4BjtcY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EIkRJNg0TZE1TzshK9upv4BjtcY", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EIkRJNg0TZE1TzshK9upv4BjtcY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEIkRJNg0TZE1TzshK9upv4BjtcY2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "EIkRJNg0TZE1TzshK9upv4BjtcY", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code eMdhaldlNjPK0VTwcRCCjQzJfkE}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEMdhaldlNjPK0VTwcRCCjQzJfkE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "eMdhaldlNjPK0VTwcRCCjQzJfkE", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code eMdhaldlNjPK0VTwcRCCjQzJfkE}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEMdhaldlNjPK0VTwcRCCjQzJfkE2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\r", "eMdhaldlNjPK0VTwcRCCjQzJfkE"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code FevQ0jx5od5v1RTYmR3fUt4ToKQ}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenFevQ0jx5od5v1RTYmR3fUt4ToKQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "FevQ0jx5od5v1RTYmR3fUt4ToKQ", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code FevQ0jx5od5v1RTYmR3fUt4ToKQ}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenFevQ0jx5od5v1RTYmR3fUt4ToKQ2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "FevQ0jx5od5v1RTYmR3fUt4ToKQ"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Ff6aGAHES23cGXBCdxMO_YrjyGo}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenFf6aGAHES23cGXBCdxMOYrjyGo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Ff6aGAHES23cGXBCdxMO_YrjyGo", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Ff6aGAHES23cGXBCdxMO_YrjyGo}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenFf6aGAHES23cGXBCdxMOYrjyGo2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Seal", "Ff6aGAHES23cGXBCdxMO_YrjyGo"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code hJeYn1zwf0Hvuq-tiTfkbrClUDM}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenHJeYn1zwf0HvuqTiTfkbrClUDM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "hJeYn1zwf0Hvuq-tiTfkbrClUDM", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code hJeYn1zwf0Hvuq-tiTfkbrClUDM}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenHJeYn1zwf0HvuqTiTfkbrClUDM2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "\r", "hJeYn1zwf0Hvuq-tiTfkbrClUDM", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code hRz2dH3-ibGiESQ2kZHr3EC6TvI}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenHRz2dH3IbGiESQ2kZHr3EC6TvI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "hRz2dH3-ibGiESQ2kZHr3EC6TvI", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code hRz2dH3-ibGiESQ2kZHr3EC6TvI}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenHRz2dH3IbGiESQ2kZHr3EC6TvI2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "HmacSHA1", "hRz2dH3-ibGiESQ2kZHr3EC6TvI"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenHaTqhQ4C8ZHUrFsNEZnmPH6Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenHaTqhQ4C8ZHUrFsNEZnmPH6Q2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal",
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
            "\\r|\\n",
            "Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code idRxGCR4HFCuZFP5t1ZPRbbos8Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIdRxGCR4HFCuZFP5t1ZPRbbos8Y()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "idRxGCR4HFCuZFP5t1ZPRbbos8Y", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code idRxGCR4HFCuZFP5t1ZPRbbos8Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIdRxGCR4HFCuZFP5t1ZPRbbos8Y2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                null,
                "idRxGCR4HFCuZFP5t1ZPRbbos8Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB82()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "HmacSHA1", "42", "IgPuvGE5_0jePFMloMJXfiXBkB8"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB83()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "IgPuvGE5_0jePFMloMJXfiXBkB8",
                "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB84()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB85()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\\r|\\n", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB86()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Seal", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB87()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Secret Key", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB88()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "42", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB89()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB810()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB811()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB812()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB813()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB814()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB815()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code JB7zSIUCiH7vyuKRZRP4sVR02S8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenJB7zSIUCiH7vyuKRZRP4sVR02S8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "JB7zSIUCiH7vyuKRZRP4sVR02S8", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code JB7zSIUCiH7vyuKRZRP4sVR02S8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenJB7zSIUCiH7vyuKRZRP4sVR02S82()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", null, "JB7zSIUCiH7vyuKRZRP4sVR02S8"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenJtaejkMTk2LMEqShMFY1GTRYxp0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenJtaejkMTk2LMEqShMFY1GTRYxp02()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "42", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code LLtjqx89gh4mgZX3UphEL5-HiRY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenLLtjqx89gh4mgZX3UphEL5HiRY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "LLtjqx89gh4mgZX3UphEL5-HiRY", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code LLtjqx89gh4mgZX3UphEL5-HiRY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenLLtjqx89gh4mgZX3UphEL5HiRY2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "LLtjqx89gh4mgZX3UphEL5-HiRY",
                "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code LYVGmwZjXmI0USYv8DjWFNoFZLc}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenLYVGmwZjXmI0USYv8DjWFNoFZLc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "LYVGmwZjXmI0USYv8DjWFNoFZLc", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code LYVGmwZjXmI0USYv8DjWFNoFZLc}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenLYVGmwZjXmI0USYv8DjWFNoFZLc2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "HmacSHA1", "LYVGmwZjXmI0USYv8DjWFNoFZLc"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code m2OPkyFhK9VWTDERnsu3_n0dHWo}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenM2OPkyFhK9VWTDERnsu3N0dHWo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "m2OPkyFhK9VWTDERnsu3_n0dHWo", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code m2OPkyFhK9VWTDERnsu3_n0dHWo}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenM2OPkyFhK9VWTDERnsu3N0dHWo2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", null, "m2OPkyFhK9VWTDERnsu3_n0dHWo"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code m3GIMULiACYDokdOqmpnmlLGDTs}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenM3GIMULiACYDokdOqmpnmlLGDTs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "m3GIMULiACYDokdOqmpnmlLGDTs", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code m3GIMULiACYDokdOqmpnmlLGDTs}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenM3GIMULiACYDokdOqmpnmlLGDTs2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "m3GIMULiACYDokdOqmpnmlLGDTs",
                "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code nRuc5Dw1SGLVEldnmtqPKIjA_yg}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenNRuc5Dw1SGLVEldnmtqPKIjAYg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "nRuc5Dw1SGLVEldnmtqPKIjA_yg", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code nRuc5Dw1SGLVEldnmtqPKIjA_yg}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenNRuc5Dw1SGLVEldnmtqPKIjAYg2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "\r", "nRuc5Dw1SGLVEldnmtqPKIjA_yg"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "\r", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
                "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\\r|\\n", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Seal", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "42",
                "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\\r|\\n", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Seal", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "42", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY20()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY21()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "HmacSHA1", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY22()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "\\r|\\n", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY23()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Seal", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY24()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY25()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", null, "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code pPHhTOX7bpS3zBzZgPHIGFinME8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenPPHhTOX7bpS3zBzZgPHIGFinME8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "pPHhTOX7bpS3zBzZgPHIGFinME8", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code pPHhTOX7bpS3zBzZgPHIGFinME8}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenPPHhTOX7bpS3zBzZgPHIGFinME82()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal",
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
            "\r",
            "pPHhTOX7bpS3zBzZgPHIGFinME8"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code pi7Z6_OLowr63TFhzpEi2-vcrgk}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenPi7Z6OLowr63TFhzpEi2Vcrgk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "pi7Z6_OLowr63TFhzpEi2-vcrgk", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code pi7Z6_OLowr63TFhzpEi2-vcrgk}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenPi7Z6OLowr63TFhzpEi2Vcrgk2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "Customer Id",
                "pi7Z6_OLowr63TFhzpEi2-vcrgk"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code q6pjVjanGrLn0-FHk2SWXBSi5aE}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQ6pjVjanGrLn0FHk2SWXBSi5aE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "q6pjVjanGrLn0-FHk2SWXBSi5aE", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code q6pjVjanGrLn0-FHk2SWXBSi5aE}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQ6pjVjanGrLn0FHk2SWXBSi5aE2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "q6pjVjanGrLn0-FHk2SWXBSi5aE",
                "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code QALRtNESDXJ7AiDaXTaV-4WnWeo}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQALRtNESDXJ7AiDaXTaV4WnWeo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "QALRtNESDXJ7AiDaXTaV-4WnWeo", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code QALRtNESDXJ7AiDaXTaV-4WnWeo}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQALRtNESDXJ7AiDaXTaV4WnWeo2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "", "QALRtNESDXJ7AiDaXTaV-4WnWeo"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code QDFXJ8lrRWasejqgFqu6GaXU7XA}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQDFXJ8lrRWasejqgFqu6GaXU7XA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "QDFXJ8lrRWasejqgFqu6GaXU7XA", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code QDFXJ8lrRWasejqgFqu6GaXU7XA}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQDFXJ8lrRWasejqgFqu6GaXU7XA2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "Customer Id", "QDFXJ8lrRWasejqgFqu6GaXU7XA"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Qlhc0pVdt8Nr3oGNzmxhH8_fyeI}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQlhc0pVdt8Nr3oGNzmxhH8FyeI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Qlhc0pVdt8Nr3oGNzmxhH8_fyeI", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Qlhc0pVdt8Nr3oGNzmxhH8_fyeI}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenQlhc0pVdt8Nr3oGNzmxhH8FyeI2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Qlhc0pVdt8Nr3oGNzmxhH8_fyeI", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code RiPpb2KwscLxTcKvAY239R9Dr1o}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenRiPpb2KwscLxTcKvAY239R9Dr1o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "RiPpb2KwscLxTcKvAY239R9Dr1o", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code RiPpb2KwscLxTcKvAY239R9Dr1o}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenRiPpb2KwscLxTcKvAY239R9Dr1o2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "RiPpb2KwscLxTcKvAY239R9Dr1o", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sM5V8ywc2a0KV8IKYIh54Xkpklk}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSM5V8ywc2a0KV8IKYIh54Xkpklk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "sM5V8ywc2a0KV8IKYIh54Xkpklk", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sM5V8ywc2a0KV8IKYIh54Xkpklk}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSM5V8ywc2a0KV8IKYIh54Xkpklk2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "\\r|\\n", "sM5V8ywc2a0KV8IKYIh54Xkpklk"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code SNqY6ufenJLOT51LeJyKLF5XsHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqY6ufenJLOT51LeJyKLF5XsHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "SNqY6ufenJLOT51LeJyKLF5XsHY", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code SNqY6ufenJLOT51LeJyKLF5XsHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqY6ufenJLOT51LeJyKLF5XsHY2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "",
                "SNqY6ufenJLOT51LeJyKLF5XsHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal",
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
            "sNqsTSzcdqtIvTFHUEVghnf0xHY",
            "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal",
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
            "42",
            "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY15()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY16()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\\r|\\n", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY17()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY18()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY19()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY20()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY21()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY22()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY23()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY24()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY25()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "HmacSHA1", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY26()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\\r|\\n", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY27()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "Seal", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY28()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "42", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY29()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "\r",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY30()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "HmacSHA1",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY31()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "\\r|\\n",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY32()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "Seal",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY33()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                null,
                "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnTrue()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertTrue(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "sNqsTSzcdqtIvTFHUEVghnf0xHY", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code -SlQFjnDqiHsBfW8zGZMu1tUaK0}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSlQFjnDqiHsBfW8zGZMu1tUaK0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "-SlQFjnDqiHsBfW8zGZMu1tUaK0", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code -SlQFjnDqiHsBfW8zGZMu1tUaK0}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenSlQFjnDqiHsBfW8zGZMu1tUaK02()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "\\r|\\n", "-SlQFjnDqiHsBfW8zGZMu1tUaK0"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code tlcsbzqr-08sTrthRJsE08u3v68}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenTlcsbzqr08sTrthRJsE08u3v68()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "\\r|\\n", "tlcsbzqr-08sTrthRJsE08u3v68", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code tlcsbzqr-08sTrthRJsE08u3v68}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenTlcsbzqr08sTrthRJsE08u3v682()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "\\r|\\n", "42", "tlcsbzqr-08sTrthRJsE08u3v68"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code u1zevV4-jxVinvk2Vw0CX7JJE38}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenU1zevV4JxVinvk2Vw0CX7JJE38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "u1zevV4-jxVinvk2Vw0CX7JJE38", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code u1zevV4-jxVinvk2Vw0CX7JJE38}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenU1zevV4JxVinvk2Vw0CX7JJE382()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "\r", "Customer Id", "u1zevV4-jxVinvk2Vw0CX7JJE38"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code unwoUqLrNg8O9Bae56ELJ3Uqb1Q}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenUnwoUqLrNg8O9Bae56ELJ3Uqb1Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "unwoUqLrNg8O9Bae56ELJ3Uqb1Q", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code unwoUqLrNg8O9Bae56ELJ3Uqb1Q}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenUnwoUqLrNg8O9Bae56ELJ3Uqb1Q2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "unwoUqLrNg8O9Bae56ELJ3Uqb1Q",
                "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code V1Oaskbwz5r8boXQvlgvPDK8a14}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenV1Oaskbwz5r8boXQvlgvPDK8a14()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "V1Oaskbwz5r8boXQvlgvPDK8a14", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code V1Oaskbwz5r8boXQvlgvPDK8a14}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenV1Oaskbwz5r8boXQvlgvPDK8a142()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "V1Oaskbwz5r8boXQvlgvPDK8a14"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code YSAJgMDwzoythpbAJ550dp2jGgI}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenYSAJgMDwzoythpbAJ550dp2jGgI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal("Seal", "YSAJgMDwzoythpbAJ550dp2jGgI", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code YSAJgMDwzoythpbAJ550dp2jGgI}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenYSAJgMDwzoythpbAJ550dp2jGgI2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "Seal",
                "YSAJgMDwzoythpbAJ550dp2jGgI"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code ztaecluhjjaSQ7VKdgb97gJ-o2Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenZtaecluhjjaSQ7VKdgb97gJO2Y()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Seal", "ztaecluhjjaSQ7VKdgb97gJ-o2Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code ztaecluhjjaSQ7VKdgb97gJ-o2Y}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenZtaecluhjjaSQ7VKdgb97gJO2Y2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal(
            "Seal", "Seal", "42", "ztaecluhjjaSQ7VKdgb97gJ-o2Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code ZyPgyE_wWCyj2sHBmProMtVNsh4}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenZyPgyEWWCyj2sHBmProMtVNsh4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal", "ZyPgyE_wWCyj2sHBmProMtVNsh4", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code ZyPgyE_wWCyj2sHBmProMtVNsh4}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"
  })
  public void testVerifySeal_whenZyPgyEWWCyj2sHBmProMtVNsh42()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        new PaymentGatewayTamperProofSealServiceImpl()
            .verifySeal(
                "Seal",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                "sNqsTSzcdqtIvTFHUEVghnf0xHY",
                "ZyPgyE_wWCyj2sHBmProMtVNsh4"));
  }
}
