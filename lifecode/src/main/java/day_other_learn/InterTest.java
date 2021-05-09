package day_other_learn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class InterTest extends FileInputStream implements Runnable,ActionListener
{

    private int a;
    public String b;
    public InterTest(String name) throws FileNotFoundException {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
