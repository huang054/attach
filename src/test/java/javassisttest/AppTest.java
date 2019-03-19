package javassisttest;


import com.sun.tools.attach.*;
;

import java.io.IOException;
import java.net.URISyntaxException;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    public static void main(String[] args) throws URISyntaxException {

        //new service().say("hello world");
   /*     final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class vrmClass=null;
        try {
            vrmClass=classLoader.loadClass("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object vrm =null;*/
        try {
            List<VirtualMachineDescriptor> list = VirtualMachine.list();
            for (VirtualMachineDescriptor vmd : list) {
                if (vmd.displayName().endsWith("App")) {
                    VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                    System.out.println(vmd.id());
                    try {
                        virtualMachine.loadAgent("D:/ChromeCoreDownloads/ssittest/target/my-agent.jar");

                        System.out.println("ok");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                       virtualMachine.detach();
                    }
                }
            }
           /* VirtualMachine vime= VirtualMachine.attach("7292");
            vime.loadAgent("D:/ChromeCoreDownloads/ssittest/target/ssittest-1.0-SNAPSHOT.jar");
            vime.detach();*/
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
