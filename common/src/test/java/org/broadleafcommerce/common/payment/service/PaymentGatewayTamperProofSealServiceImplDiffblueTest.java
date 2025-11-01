/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;

public class PaymentGatewayTamperProofSealServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("sNqsTSzcdqtIvTFHUEVghnf0xHY", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
    assertEquals("oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "42"));
    assertEquals("IgPuvGE5_0jePFMloMJXfiXBkB8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "42"));
    assertEquals("tlcsbzqr-08sTrthRJsE08u3v68",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "42"));
    assertEquals("406Mqqc-tBSOi1sEXVvQWDti9SM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "42"));
    assertEquals("JtaejkMTk2LMEqShMFY1GTRYxp0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "42"));
    assertEquals("pPHhTOX7bpS3zBzZgPHIGFinME8", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "42"));
    assertEquals("7f0cgKmhwUd_tPNoRpfDt_3XL2o", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "42"));
    assertEquals("Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "42"));
    assertEquals("pi7Z6_OLowr63TFhzpEi2-vcrgk", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "42"));
    assertEquals("SNqY6ufenJLOT51LeJyKLF5XsHY", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "42"));
    assertEquals("E8uB0wx9qTV5boBcN00CH66s_cw", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\r"));
    assertEquals("q6pjVjanGrLn0-FHk2SWXBSi5aE", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "HmacSHA1"));
    assertEquals("m3GIMULiACYDokdOqmpnmlLGDTs", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\\r|\\n"));
    assertEquals("unwoUqLrNg8O9Bae56ELJ3Uqb1Q", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Order Id"));
    assertEquals("nRuc5Dw1SGLVEldnmtqPKIjA_yg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "42"));
    assertEquals("LYVGmwZjXmI0USYv8DjWFNoFZLc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "42"));
    assertEquals("-SlQFjnDqiHsBfW8zGZMu1tUaK0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "42"));
    assertEquals("u1zevV4-jxVinvk2Vw0CX7JJE38",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "42"));
    assertEquals("7TfFqE43gT4uk0foYCMo9JKk4zw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "", "42"));
    assertEquals("79-icLuv45Um14pDOoK2S7kht-Y",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "\r"));
    assertEquals("RiPpb2KwscLxTcKvAY239R9Dr1o",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "HmacSHA1"));
    assertEquals("CZRHEvvDmdIJ6XCGZD_DrBL_sDw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "\\r|\\n"));
    assertEquals("EIkRJNg0TZE1TzshK9upv4BjtcY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "Order Id"));
    assertEquals("eMdhaldlNjPK0VTwcRCCjQzJfkE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "42"));
    assertEquals("hRz2dH3-ibGiESQ2kZHr3EC6TvI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "42"));
    assertEquals("sM5V8ywc2a0KV8IKYIh54Xkpklk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "42"));
    assertEquals("QDFXJ8lrRWasejqgFqu6GaXU7XA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "42"));
    assertEquals("QALRtNESDXJ7AiDaXTaV-4WnWeo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "", "42"));
    assertEquals("vwWXvQHEVfDexI1q-190cl43Jr8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "\r"));
    assertEquals("t20sMpGd9nJzrEA7rULqdrpVKBc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "HmacSHA1"));
    assertEquals("RH45VxwkybzBn5fd_zP-yn7u1Og",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "\\r|\\n"));
    assertEquals("RsHATo0gMfYPN-9nn7e2W7PJrvQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "Order Id"));
    assertEquals("BVA1ih2GRXJd5IYwBfK1JMlaD08",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "42"));
    assertEquals("7p9RiPGXWv2m6JJmm4FL7WyrTvk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "42"));
    assertEquals("nKyXjLcwJ3UGxa7qhAf9EyzKKa4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "42"));
    assertEquals("u7Cn8yIBSmbfmFJ4AKuvIyTzhGk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "42"));
    assertEquals("JQjvhNx-FpTbRHJi1qBhld59Olw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "", "42"));
    assertEquals("BnYRKOfRIC9DMJLtCE-2UkiGYak",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "\r"));
    assertEquals("4T9ViMN9kPm2eOfw_lmPTltEpvc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "HmacSHA1"));
    assertEquals("bbvm6hUe446B2WGX20DzQlKkcxI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "\\r|\\n"));
    assertEquals("zth0bsNh58_HOtwKcXJaZnWc4pg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "Order Id"));
    assertEquals("_KbBWddFwcwYG8m4LPuRNAyA1H4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "42"));
    assertEquals("HZpMLN4MpN49mrtmiBxWaaIOBRA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "42"));
    assertEquals("kveMHfkkjyikoL1CzAUD6NOUxXY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "42"));
    assertEquals("qRZ_ovQP6XPR1gB1Qo_7CjG_FpM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", "42"));
    assertEquals("JJXwLj2TpuC-FWTlZkKZ8qbtKzQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "", "42"));
    assertEquals("M43QalGWxRXNEX-dPA-mc0TjNJU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "\r"));
    assertEquals("rS2pgvBS1swthmwG6od86tcenrM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "HmacSHA1"));
    assertEquals("mxRCpfGtSfGHtQxPXhZjf1T65dY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "\\r|\\n"));
    assertEquals("-M96SmqBBfSlx8Kn-JdFnMyJmp8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "Order Id"));
    assertEquals("4af_i5eWdzpsBvBoD9A_vptOhxA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "42"));
    assertEquals("29cZvFHL1BiopnxiDKwl-gfbgls",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "42"));
    assertEquals("-p9bs-jEtuJAinfLljFDNPVsFUM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "42"));
    assertEquals("6cgj6FzexH5PElZa2zfOgccYZkA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "42"));
    assertEquals("y2-djIQ8IuU9uX9_0v8gq1jJHjE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "", "42"));
    assertEquals("k_8FS97EthV3pxCOfGSyXd1RjZA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "\r"));
    assertEquals("ADKW7x46hnNb1EHbrnw_5TnRGsk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "HmacSHA1"));
    assertEquals("cAj578aKEA1-EcROx0HTKoc3P-M",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "\\r|\\n"));
    assertEquals("zSzsiPkWG1rrMqfODpjYnHIg1K4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "Order Id"));
    assertEquals("hyr6f0l6i3shGZ-tBIVtsmlGPGk", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\r"));
    assertEquals("h9iN8mYez-IDmhMPRI0W60ofKt8", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "HmacSHA1"));
    assertEquals("ZatE8KJTwTBQ7jlSjw-ZoR7x2XI", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\\r|\\n"));
    assertEquals("CAp7B9ynYEs6skxV6Q3_FjfCxkg", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Order Id"));
    assertEquals("uSgW-GUHcUxlkXUs40cppvJsmw0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", ""));
    assertEquals("1FG2gnnvrVQ5SpyDxaD3_gTv-us", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\r"));
    assertEquals("vhSwWFhvNbKEmyaP_jvB97d2R38", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "HmacSHA1"));
    assertEquals("Yc3IfLaBbSqp9kuxL58YZRlu0hI", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\\r|\\n"));
    assertEquals("CzYF3m-tO6XGaLgv59f_-gFkcX0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Order Id"));
    assertEquals("w9zO-4-eV0Z4LTKIjubXI9zeaz0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", ""));
    assertEquals("CbSCTyjPn5vF0OgyXrRXj5B3VKM", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\r"));
    assertEquals("pvbmP5Y3jlUvZ8yjaAbNYKkz9us", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "HmacSHA1"));
    assertEquals("Af-VMmIUYJ8hSeTiz8sZxnFAu-0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\\r|\\n"));
    assertEquals("0cTiUxuvZqKt3MjpP-1MASO2KNY", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Order Id"));
    assertEquals("240sUHqX-D8nXPbQTqIGyJ9tanI", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", ""));
    assertEquals("0xuCa4XmNlvaNCW-hGHhYtcAfII", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\r"));
    assertEquals("sbU42dGCepiXJcDpu6LAYd7bZR0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "HmacSHA1"));
    assertEquals("t4O7JXDlKRm_Z6yxPWhnawAzS3c", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\\r|\\n"));
    assertEquals("1oV__tbpXGKi0rq0dDh97i_HHuQ", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Order Id"));
    assertEquals("zhuzagJl7J1hq_o1mUMKPDK2hkw", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", ""));
    assertEquals("GAn4gYYGpYQsc88VJztrF_v8W4c", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "Order Id"));
    assertEquals("944XXw0vCyFbIE4-QfJ3HWzXWME", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", ""));
    assertEquals("ETyIyJs7lK1ykyUGjuwqPhvtBAo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "\r"));
    assertEquals("x1n7atITF0SqSdwCRifqoNxPMew",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "HmacSHA1"));
    assertEquals("WseeBqcg5S3cdiIcoBJx14auFcs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "\\r|\\n"));
    assertEquals("CX-3_rrPPwmmqMEr281LSo8QQGU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "Order Id"));
    assertEquals("v1L5FBjl32VmI2fHiwYaLvPwsK0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", ""));
    assertEquals("xSgXnRtQjjrSTPwOWSBNcl0H4h8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "\r"));
    assertEquals("6fVQO8Iz_cH_Da3lajTtaaNLiHY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "HmacSHA1"));
    assertEquals("GbAGpzDDR4HbrQkT9Ae-l1OIUTc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "\\r|\\n"));
    assertEquals("AX8b4TYA9MpsLrTZLxj-mKFXliQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "Order Id"));
    assertEquals("MRciCXfeaElXsZa_WipdCZXl2ZI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", ""));
    assertEquals("Ln6nNiLKww163oSX6vHrv3NuyaE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "\r"));
    assertEquals("Tt_3gK3DnJVt3Qy0Ra1bNuZVbCM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "HmacSHA1"));
    assertEquals("eQhspWHVS5CqB-S5mY1haaKyyxk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "\\r|\\n"));
    assertEquals("1VfOoYCXAKA2P3M-R_e4mltDZSk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "Order Id"));
    assertEquals("kUMPgvAgA5T0Kj2bleKR-9PVbZg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", ""));
    assertEquals("1amYbQZvHgCZLYtK8eg0CivLfdQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "\r"));
    assertEquals("X3hva1xmdWKX2P1I0wLj2TpczuE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "HmacSHA1"));
    assertEquals("STGAgqhH7U4EU5wmR7UMKpvM8RM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "\\r|\\n"));
    assertEquals("IzEdrUsmDR1OZpb7QPnursck8VM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "Order Id"));
    assertEquals("AK1QP7g5usw8quMcMHU7PPgXdU4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", ""));
    assertEquals("NQyD_thR-_aaQBJt1B4fxXeg6bY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "", "Order Id"));
    assertEquals("eeJj8ru73d0-4iECLNthWYbBHXw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "", ""));
    assertEquals("tBT9IkrBlGo_aaGw7GjJA3Sf6n4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "\r"));
    assertEquals("6sPG1MdgV0yWMccYU786xZL4zII",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "HmacSHA1"));
    assertEquals("YEe8Zbj12HXypdlqW5fpA9MASjI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "\\r|\\n"));
    assertEquals("kqxM8Tzfwsum2nyJr7JwYEFV3n8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "Order Id"));
    assertEquals("yEx9BbISXzx3z3OyBExvrMr7-Vs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", ""));
    assertEquals("80oK7Knum6cOjZRb4Oxa2ATox3U",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "\r"));
    assertEquals("CrzNAPnHy9G_waOATyKAE0ZRTBk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "HmacSHA1"));
    assertEquals("lLqvQD4NaAu4YacPPoVW4Kk9JGA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "\\r|\\n"));
    assertEquals("hVa4apvKTYIaIC2umOFItoBD3v0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "Order Id"));
    assertEquals("qLpyinyyNQ0JNfbSrYA-_FEYcmY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", ""));
    assertEquals("C5jjBlb6QlM7Cc4-irOOMgeUWTY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "\r"));
    assertEquals("zuo52h9A9V5XAzI_zpznypMw6Vw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "HmacSHA1"));
    assertEquals("s9TvOu9HAuD1uNWOWs9Aqn6Q_e0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "\\r|\\n"));
    assertEquals("SUHDXUtU6vGkVPFl8Lnl5iOPaYM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "Order Id"));
    assertEquals("hN2eppko516z5VaLAgXcrkYphQs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", ""));
    assertEquals("aILCXCOZX7wqasHbiQI1Pe6ie8s",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "\r"));
    assertEquals("UzDK6P_NGwsY7jYY9idqgt9QnG0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "HmacSHA1"));
    assertEquals("k4iqQQ4gJsE-d3OJMS86PuaWJfM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "\\r|\\n"));
    assertEquals("ncvvM7lzC6pX-oRzr_QReoMRuY8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "Order Id"));
    assertEquals("57_xUZQ4O5-vUs2oScOrdlFtoyE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", ""));
    assertEquals("SScqF1YWaUdqIahBm5YPCWZW7g8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "", "Order Id"));
    assertEquals("lN0PO7CIrk2Wl462LHgxAEqAIXk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "", ""));
    assertEquals("vRD_le7AoG35mJ8TlUxA0CPwcU4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "\r"));
    assertEquals("WLGwVF86PU5LE9WeuR5R7xswJ0w",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "HmacSHA1"));
    assertEquals("Mcn6nvm1hXpbc9ysXYm3ZfdFB3I",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "\\r|\\n"));
    assertEquals("NWTMzqcB908ioU4LVaQ1yic21Hs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "Order Id"));
    assertEquals("u-s6ttrQER2E7F9lnys74vdU7VI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", ""));
    assertEquals("ihVrSsnC8fiu8SiPivzbAEJj2TI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "\r"));
    assertEquals("M17yZV_JzszrkxItmiPnRZtQjf4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "HmacSHA1"));
    assertEquals("cFW-4rT4eP0vgYH2yiPj36-l2a0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "\\r|\\n"));
    assertEquals("TApyTv5MGy2w7o1fHiPLsjzcnxU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "Order Id"));
    assertEquals("B355E25AoLrFMrmvjn__ahU0fa4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", ""));
    assertEquals("pdbTTbesJ_schLtfBx1nS23XkDQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "\r"));
    assertEquals("bcPjL2TRZ5CZBHntd9JYEieUl2s",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "HmacSHA1"));
    assertEquals("UP_Ef_7OOdAY8T863w-yy7Nv3ew",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "\\r|\\n"));
    assertEquals("zOSq2hpABr-LLc1G46RW-8beL1o",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "Order Id"));
    assertEquals("NmJzZUVEdaMhlP68n-vvAQt7Res",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", ""));
    assertEquals("HhSbrjIWn4WOgkwctW646uWf4Zg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "\r"));
    assertEquals("1QWOEuh3iLj4ZBjz_pgwqFuWlDg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "HmacSHA1"));
    assertEquals("6P0_pyBuAWAE5fcFbgp__aHbx2k",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "\\r|\\n"));
    assertEquals("y7e5MkvHkO1g0bekZwSegC9TNcM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "Order Id"));
    assertEquals("tb-_zjqDr08WuaSpvpFJ-K-mvuY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", ""));
    assertEquals("rjEgg7TrjD21YbF1Pj2HpuzFD8U",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "", "Order Id"));
    assertEquals("auuhV1xDnb8ktZzd8tff-UZ92uM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "", ""));
    assertEquals("bgnemZQbnzDK5XEOGDjLPUFnt-c",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "\r"));
    assertEquals("7bl62f3uLkgt8Md0c9MlB9EMHIs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "HmacSHA1"));
    assertEquals("yagqdk_vYDXHPy9dv45-VLnkcoE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "\\r|\\n"));
    assertEquals("Ptmxmr_uLGUtOzEIIuyVxPT5sWU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "Order Id"));
    assertEquals("tYic8o_A1X8PmAnH4YODNbmBJjo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", ""));
    assertEquals("S3oYZm3Id-Pcddl-XpkH9pWuX1I",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "\r"));
    assertEquals("2Exqd7Qu7Il63qyQgE8NZuWKfto",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "HmacSHA1"));
    assertEquals("TzOgIV5L0ZJVu9OilTHjWVhbM0A",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "\\r|\\n"));
    assertEquals("Q13TRmXqw17rFbL7RkOVUSNR6tI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "Order Id"));
    assertEquals("27pH0rnaUQwJj8kiENtGSSFlcvQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", ""));
    assertEquals("OKmQ8uPR9xWh8p_vLCC6ZAvFDXw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "\r"));
    assertEquals("6IYHxQarxBQRGHiE8fs5-gQG6yo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "HmacSHA1"));
    assertEquals("9vA79KFt3hmcQZ3L3O5QS9P-wqI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "\\r|\\n"));
    assertEquals("8VL8c4t0AWnRsN6qijgBKXwzS6A",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "Order Id"));
    assertEquals("1gedig7UNOPvzoo0mOLaHAjrZr4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", ""));
    assertEquals("F7aq_FAL-_pyNs64_mctc-U71go",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", "\r"));
    assertEquals("TZ_g0Hkz9b5skaqHXRWD73nymX0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("Secret Key", "Customer Id", "HmacSHA1"));
    assertEquals("Q3dYmgPS1YUEB4x-qeMDS6EBsGY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", "\\r|\\n"));
    assertEquals("Nh5cUzNCCqFA38q4QksMVXlNQE0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("Secret Key", "Customer Id", "Order Id"));
    assertEquals("gO7ojKOcGuRaE7Ve5whET2sRimI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", ""));
    assertEquals("cbYPFheiOZmJ4tmPvSqdxF8SeYU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "", "Order Id"));
    assertEquals("3NX10gZmJvHiufpD0-CcPiap4IM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "", ""));
    assertEquals("5YKBudoB1KzRuw9CZ_u5i1Z6VpI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "\r"));
    assertEquals("YT5LaGhSGi98t1LY_3DTbqbpYOo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "HmacSHA1"));
    assertEquals("FcXvaeATPdTjsRW1_oBz5ED3ckY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "\\r|\\n"));
    assertEquals("syis3762QsgnWmaaBsLqBDPNQ3M",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "Order Id"));
    assertEquals("kLqBNAOTfi1Oe9teyghts6jlfe8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", ""));
    assertEquals("KTmbTv_qZAdQlX41cQTV3FMqeGA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "\r"));
    assertEquals("L__ngKnTQDrBl8pDTvvt15QjcmA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "HmacSHA1"));
    assertEquals("dQ-MTlBbXwNfXcLGA84YP9T9cXs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "\\r|\\n"));
    assertEquals("PPbOlss1kJA_6Aez09SlKVCThO8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "Order Id"));
    assertEquals("OYSa-F1TykPsyT3j-mUVrZADxsw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", ""));
    assertEquals("aLmtqIfRgKMqNUtNJmVhwsMnCSE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "\r"));
    assertEquals("k_DJ5Vkfw6QlT8qVQfiqTjudhSM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "HmacSHA1"));
    assertEquals("jU-zOu3QBocS8YOGlKpC9q6SKmo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "\\r|\\n"));
    assertEquals("k3WhDJbk7t8-T1RYtwnCNnW0w1k",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "Order Id"));
    assertEquals("Kd2X8f8X2FS1DbGrE4Prsnya22w",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", ""));
    assertEquals("xhp6XDhmH1Dc2d9xYCesihrX_D4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "\r"));
    assertEquals("r8qFzFsWTHudoGqSwmoWZj0g4xo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "HmacSHA1"));
    assertEquals("V0fZCg5pMaPIYBqmrG0Y3gMZbns",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "\\r|\\n"));
    assertEquals("zEhbW5bsG5OQ9DZUNKGW-yxjVoY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "Order Id"));
    assertEquals("HZ8Q5Jv9Tgcpc1LJc0NiKqnrOfo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", ""));
    assertEquals("YEGXTyELVHUPQ1wAAF28Wi8clsE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "", "Order Id"));
    assertEquals("3BS7a4LwmaD1l6lqK8LBjHr-vgA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "", ""));
  }

  /**
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
    assertTrue((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal(null,
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "Seal"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1",
        "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42",
        "IgPuvGE5_0jePFMloMJXfiXBkB8"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n",
        "tlcsbzqr-08sTrthRJsE08u3v68", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42",
        "tlcsbzqr-08sTrthRJsE08u3v68"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal",
        "ztaecluhjjaSQ7VKdgb97gJ-o2Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42",
        "ztaecluhjjaSQ7VKdgb97gJ-o2Y"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", null));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "FevQ0jx5od5v1RTYmR3fUt4ToKQ", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "Customer Id", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", null, "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "FevQ0jx5od5v1RTYmR3fUt4ToKQ"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "Order Id"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key",
        "406Mqqc-tBSOi1sEXVvQWDti9SM", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42",
        "406Mqqc-tBSOi1sEXVvQWDti9SM"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "Seal", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "Seal"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", null));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "pPHhTOX7bpS3zBzZgPHIGFinME8", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "pPHhTOX7bpS3zBzZgPHIGFinME8"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "7f0cgKmhwUd_tPNoRpfDt_3XL2o",
        "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "7f0cgKmhwUd_tPNoRpfDt_3XL2o"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q",
        "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "YSAJgMDwzoythpbAJ550dp2jGgI",
        "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "YSAJgMDwzoythpbAJ550dp2jGgI"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", ""));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "ZyPgyE_wWCyj2sHBmProMtVNsh4",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "ZyPgyE_wWCyj2sHBmProMtVNsh4"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "pi7Z6_OLowr63TFhzpEi2-vcrgk",
        "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "pi7Z6_OLowr63TFhzpEi2-vcrgk"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", ""));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "idRxGCR4HFCuZFP5t1ZPRbbos8Y", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "idRxGCR4HFCuZFP5t1ZPRbbos8Y"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, ""));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "SNqY6ufenJLOT51LeJyKLF5XsHY", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "SNqY6ufenJLOT51LeJyKLF5XsHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", ""));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "E8uB0wx9qTV5boBcN00CH66s_cw", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "E8uB0wx9qTV5boBcN00CH66s_cw", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "q6pjVjanGrLn0-FHk2SWXBSi5aE", "42",
        "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "q6pjVjanGrLn0-FHk2SWXBSi5aE", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "m3GIMULiACYDokdOqmpnmlLGDTs", "42",
        "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "m3GIMULiACYDokdOqmpnmlLGDTs", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "LLtjqx89gh4mgZX3UphEL5-HiRY", "42",
        "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "LLtjqx89gh4mgZX3UphEL5-HiRY", "Seal"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "4OLe0d5c2uJKjCKKf-z6Qe2IlME", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "4OLe0d5c2uJKjCKKf-z6Qe2IlME", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "unwoUqLrNg8O9Bae56ELJ3Uqb1Q", "42",
        "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "unwoUqLrNg8O9Bae56ELJ3Uqb1Q", "Order Id"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "7helzpZSnhza-7W92tJ4mhPlQsg", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "7helzpZSnhza-7W92tJ4mhPlQsg", null));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "nRuc5Dw1SGLVEldnmtqPKIjA_yg", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "Seal"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "nRuc5Dw1SGLVEldnmtqPKIjA_yg"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "LYVGmwZjXmI0USYv8DjWFNoFZLc",
        "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1",
        "LYVGmwZjXmI0USYv8DjWFNoFZLc"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "-SlQFjnDqiHsBfW8zGZMu1tUaK0",
        "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n",
        "-SlQFjnDqiHsBfW8zGZMu1tUaK0"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "ByPp6oyyYtSpNy-glhed81Se1G8",
        "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal",
        "ByPp6oyyYtSpNy-glhed81Se1G8"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "AK__Dht6Kh9LJgsFSixaNw7owOU",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "AK__Dht6Kh9LJgsFSixaNw7owOU"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "Order Id"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", null));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "u1zevV4-jxVinvk2Vw0CX7JJE38",
        "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "\\r|\\n"));
  }
}
