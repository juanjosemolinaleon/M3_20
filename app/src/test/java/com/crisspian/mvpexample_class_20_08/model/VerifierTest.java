package com.crisspian.mvpexample_class_20_08.model;

import com.google.j2objc.annotations.Weak;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class VerifierTest {

    private Verifier verifier;

    @Before
    public void setUp(){
        verifier = new Verifier();
    }

    @Test
    public void verifierWeak() {
        //given
        String password = "pass";
        //when
        int option = verifier.evaluatePass(password);
        //then
        assertThat(option).isEqualTo(-1);
    }
    @Test
    public void verifierMedium(){
        //given
        String password = "asados";
        //when
        int option = verifier.evaluatePass(password);
        //then
        assertThat(option).isEqualTo(-2);
    }
    @Test
    public void verifierStrong(){
        //given
        String password = "12Ycasa";
        //when
        int option = verifier.evaluatePass(password);
        //then
        assertThat(option).isEqualTo(-3);
    }





}
