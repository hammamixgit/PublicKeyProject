package com.tda.publickey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.spongycastle.asn1.*
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo
import java.security.KeyPair
import java.security.KeyPairGenerator



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var kp: KeyPair? = null
        try {
            val kpg = KeyPairGenerator.getInstance("RSA")
            kpg.initialize(512)

            kp = kpg.generateKeyPair()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val pubBytes = kp!!.public.encoded

        val spkInfo = SubjectPublicKeyInfo.getInstance(pubBytes)
        val primitive = spkInfo.publicKeyData.encoded
txt.text="txt ="+DERUTF8String.fromByteArray(primitive).toString()
    //    Log.d("xxxx", DERUTF8String.fromByteArray(primitive).toString())
    }
}
