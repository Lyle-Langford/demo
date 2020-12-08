package com.nio.selector;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * @author: Lyle
 * @date: 2020/12/2
 * @description:
 **/
public class SelectorTest {

    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
