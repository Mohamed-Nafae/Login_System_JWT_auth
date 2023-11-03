package com.plcoding.jwtauthktorandroid

import java.io.FileInputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory

fun createCustomSSLContext(): SSLContext {
    val certificateFactory = CertificateFactory.getInstance("X.509")
    val certificateFile = FileInputStream("cert.crt")
    val certificate = certificateFactory.generateCertificate(certificateFile)

    val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
    keyStore.load(null)
    keyStore.setCertificateEntry("custom", certificate)

    val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
    trustManagerFactory.init(keyStore)

    val sslContext = SSLContext.getInstance("TLS")
    sslContext.init(null, trustManagerFactory.trustManagers, null)

    return sslContext
}
