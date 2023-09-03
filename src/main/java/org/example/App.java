package org.example;

import org.apache.log4j.Logger;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class App {
    private static String inputText;
    private static App app;
    private static final Logger logger = Logger.getLogger(MyMBeanImpl.class);

    public String getText() {
        return inputText;
    }

    public void setText(String text) {
        inputText = text;
    }

    public static synchronized App getInstance() {
        if (app == null)
            app = new App();
        return app;
    }

    private static MBeanServer madeMBeanServer() throws NotCompliantMBeanException, MalformedObjectNameException,
            InstanceAlreadyExistsException, MBeanRegistrationException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        StandardMBean mbean = new StandardMBean(new MyMBeanImpl(), MyMBean.class);

        ObjectName mbeanName = new ObjectName("org.example:type=MyMBean");

        mbs.registerMBean(mbean, mbeanName);
        return mbs;
    }

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        MBeanServer mbs = madeMBeanServer();

        logger.info("Input text, please.");

        Converter myApp = new Converter();

        logger.info("Result after converter = " + myApp.convertToUpperAndLowerCase());
    }
}