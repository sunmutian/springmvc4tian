package com.tian.springmvc.servlet;

import com.tian.springmvc.annotation.*;
import com.tian.springmvc.controller.DemoController;
import com.tian.springmvc.controller.LoginController;
import com.tian.springmvc.controller.RegisterController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模仿spring的DispatcherServlet
 *
 * @Author tianweichang
 * @Date 2018-08-08 10:47
 **/
@WebServlet(name = "dispatcherServlet", urlPatterns = "/*", loadOnStartup = 1
        , initParams = {@WebInitParam(name = "base-package", value = "com.tian.springmvc")})
public class DispatcherServlet extends HttpServlet {
    /**
     * 扫描的基包
     */
    private String basePackage = "";
    /**
     * 扫描的基包下所有的带包路径的全限定名称
     */
    private List<String> packageNames = new ArrayList<>();
    /**
     * 实例存放在map中
     */
    private Map<String, Object> instanceMap = new HashMap<>();
    /**
     * bean名称
     */
    private Map<String, String> nameMap = new HashMap<>();
    /**
     * url映射method
     */
    private Map<String, Method> urlMethodMap = new HashMap<>();
    /**
     * key=方法,value=类全限定名
     */
    private Map<Method, String> methodStringMap = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.replace(contextPath, "");

        Method method = urlMethodMap.get(path);
        if (method != null) {
            String packageName = methodStringMap.get(method);
            String controllerName = nameMap.get(packageName);
            method.setAccessible(true);
            try {
                Object result = method.invoke(instanceMap.get(controllerName));
                resp.setCharacterEncoding("utf-8");
                PrintWriter out = resp.getWriter();
                out.println(result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            //获取包路径
            basePackage = config.getInitParameter("base-package");
            //扫描包路径下的全部全限定名
            scanBasePackage(basePackage);
            //把加了出借Controller,Service,Repository实例化
            instance(packageNames);
            //bean注册--IOC和注入
            autowired();
            //获取controller，执行controller类的某个方法
            handlerUrlMapping();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    //处理映射关系
    private void handlerUrlMapping() throws ClassNotFoundException {
        if (packageNames.size() < 1) {
            return;
        }
        for (String name : packageNames) {
            Class c = Class.forName(name);
            //遍历所有Controller类
            if (c.isAnnotationPresent(Controller.class)) {
                //该类的所有方法
                Method[] methods = c.getMethods();
                StringBuilder baseUrl = new StringBuilder();
                //再坚持该类上是否有RequestMapping注解
                if (c.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping = (RequestMapping) c.getAnnotation(RequestMapping.class);
                    baseUrl.append(requestMapping.value());
                }
                //遍历该类的所有方法，如果方法上有RequestMapping注解就拼装url，最后把url和方法放在一个map中
                for (Method m : methods) {
                    if (m.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping requestMapping = (RequestMapping) m.getAnnotation(RequestMapping.class);
                        baseUrl = baseUrl.append(requestMapping.value());

                        urlMethodMap.put(baseUrl.toString(), m);
                        methodStringMap.put(m, name);
                    }
                }
            }
        }
        System.out.println("===============methodStringMap===============");
        System.out.println(urlMethodMap);
        System.out.println("===============methodStringMap===============");
        System.out.println(methodStringMap);
    }

    /**
     * 注入
     */
    private void autowired() throws IllegalAccessException {
        for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Qualifier.class)) {
                    String name = field.getAnnotation(Qualifier.class).value();
                    //设置访问权限
                    field.setAccessible(true);
                    field.set(entry.getValue(), instanceMap.get(name));
                }
            }
        }
    }

    /**
     * 实例化
     */
    private void instance(List<String> packageNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (packageNames.size() < 1) {
            return;
        }
        for (String packageName : packageNames) {
            Class c = Class.forName(packageName);
            //如果类上有Controller注解
            if (c.isAnnotationPresent(Controller.class)) {
                //获取注解
                Controller controller = (Controller) c.getAnnotation(Controller.class);
                //获取@Con他roller("controller")中的"controller"
                String controllerName = controller.value();
                if (controllerName != null && !controllerName.trim().equals("")) {
                    instanceMap.put(controllerName, c.newInstance());
                    nameMap.put(packageName, controllerName);
                    System.out.println("Controller" + controllerName + ",value" + controller.value() == null ? "" : controller.value());
                }

            } else if (c.isAnnotationPresent(Service.class)) {
                Service service = (Service) c.getAnnotation(Service.class);
                String serviceName = service.value();
                if (serviceName != null && !serviceName.trim().equals("")) {
                    instanceMap.put(serviceName, c.newInstance());
                    nameMap.put(packageName, serviceName);
                    System.out.println("Service=" + serviceName + ",value=" + service.value());
                }
            } else if (c.isAnnotationPresent(Repository.class)) {
                Repository service = (Repository) c.getAnnotation(Repository.class);
                String repositoryName = service.value();
                if (repositoryName != null && !repositoryName.trim().equals("")) {
                    instanceMap.put(repositoryName, c.newInstance());
                    nameMap.put(packageName, repositoryName);
                    System.out.println("Repository=" + repositoryName + ",value=" + service.value());
                }
            }
        }
        System.out.println("===============instanceMap===============");
        System.out.println(instanceMap);
        System.out.println("===============nameMap===============");
        System.out.println(nameMap);
    }

    /**
     * 扫描基包
     */
    private void scanBasePackage(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
        File basePackageFile = new File(url.getPath());
        File[] childFIle = basePackageFile.listFiles();
        for (File file : childFIle) {
            if (file.isDirectory()) {
                scanBasePackage(basePackage + "." + file.getName());
            } else if (file.isFile()) {
                packageNames.add(basePackage + "." + file.getName().split("\\.")[0]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
