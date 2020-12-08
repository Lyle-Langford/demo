package com.nio.clone;

import com.pojo.TaskClick;

import java.io.*;

/**
 * @author: Lyle
 * @date: 2020/12/8
 * @description:
 **/
public class CloneTest {

    public static void main(String[] args) {
        try {
            TaskClick click1 = new TaskClick(1, "sb");
            ByteArrayOutputStream outs = new ByteArrayOutputStream();
            ObjectOutputStream objOuts = new ObjectOutputStream(outs);
            objOuts.writeObject(click1);

            ByteArrayInputStream ints = new ByteArrayInputStream(outs.toByteArray());
            ObjectInputStream objIns = new ObjectInputStream(ints);
            TaskClick click2 = (TaskClick) objIns.readObject();

            System.out.println(click2.getUserName());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
