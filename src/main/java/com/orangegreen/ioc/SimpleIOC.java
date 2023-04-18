package com.orangegreen.ioc;

import com.orangegreen.ioc.bean.BeanDefinition;
import com.orangegreen.ioc.factory.AutowireBeanFactory;
import com.orangegreen.ioc.factory.BeanFactory;
import com.orangegreen.ioc.io.ResourceLoader;
import com.orangegreen.ioc.test.Classroom;
import com.orangegreen.ioc.test.Student;
import com.orangegreen.ioc.test.Teacher;
import com.orangegreen.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wuxj
 * @since 2023/4/14 17:30:31
 */

public class SimpleIOC {

    public static void main(String[] args) throws Exception {

        // 获取ioc容器 BeanFactory
        BeanFactory beanFactory = XmlApplicationContext("spring.xml");

        // 通过beanFactory 这个ioc容器获取装配好的Bean
        Classroom classroom = (Classroom)beanFactory.getBean("classroom");
        System.out.println("Classroom roomCode : " + classroom.getRoomCode() + " Classroom Obejct: "+ classroom);
        Student student = (Student)beanFactory.getBean("student");
        Classroom classroom1 = student.getClassroom();
        System.out.println("Student name: "+ student.getName() + " roomCode: "+ classroom1.getRoomCode() + " Classroom Obejct: "+ classroom1);

        Teacher teacher = (Teacher)beanFactory.getBean("teacher");
        Classroom classroom2 = teacher.getClassroom();
        System.out.println("Teacher name: "+ teacher.getName() + " roomCode: "+ classroom2.getRoomCode() + " Classroom Obejct: "+ classroom2);
    }



    public static BeanFactory XmlApplicationContext(String xmlPath) throws Exception {
        // 读取xml文件,解析成BeanDefinition
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.XMLReader(xmlPath);

        // 根据BeanDefinition创建Bean和Bean的属性赋值
        Map<String, BeanDefinition> beanDefinitionMap = xmlBeanDefinitionReader.getBeanDefinitionMap();
        AutowireBeanFactory beanFactory = new AutowireBeanFactory();
        beanFactory.createBeansFromBeanDefinitions(beanDefinitionMap);

        return beanFactory;
    }
}
