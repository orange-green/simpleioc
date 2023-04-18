package com.orangegreen.ioc;

import com.orangegreen.ioc.bean.BeanDefinition;
import com.orangegreen.ioc.factory.AutowireBeanFactory;
import com.orangegreen.ioc.io.ResourceLoader;
import com.orangegreen.ioc.test.Classroom;
import com.orangegreen.ioc.test.Student;
import com.orangegreen.ioc.test.Teacher;
import com.orangegreen.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wuxj
 * @since 2023/4/17 10:59:18
 */

public class XmlBeanDefinitionReaderTest {
    @Test
    public void read() throws Exception {
        /**
         * 解析xml文件生成 BeanDefinition
         */
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.XMLReader("spring.xml");
        Map<String, BeanDefinition> beanDefinitionRegistryMap = xmlBeanDefinitionReader.getBeanDefinitionMap();

        /**
         * 根据BeanDefinition 生成Bean,并完成属性赋值
         */
        AutowireBeanFactory beanFactory = new AutowireBeanFactory();
        beanFactory.createBeansFromBeanDefinitions(beanDefinitionRegistryMap);


        /**
         * 通过 beanFactory获取设置完属性的bean
         */
        Classroom classroom = (Classroom)beanFactory.getBean("classroom");
        System.out.println("Classroom roomCode : " + classroom.getRoomCode() + " Classroom Obejct: "+ classroom);
        Student student = (Student)beanFactory.getBean("student");
        Classroom classroom1 = student.getClassroom();
        System.out.println("Student name: "+ student.getName() + " roomCode: "+ classroom1.getRoomCode() + " Classroom Obejct: "+ classroom1);

        Teacher teacher = (Teacher)beanFactory.getBean("teacher");
        Classroom classroom2 = teacher.getClassroom();
        System.out.println("Teacher name: "+ teacher.getName() + " roomCode: "+ classroom2.getRoomCode() + " Classroom Obejct: "+ classroom2);


    }
}
