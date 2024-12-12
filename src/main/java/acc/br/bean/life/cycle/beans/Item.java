package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Item implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Item(String name) {
        System.out.println("1 Instantiation - Um novo item '" + name + "' foi criado.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware - Adicionando nome ao Bean: " + name);
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware - Adicionando o Bean Factory: " + getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware - Adicionando o ApplicationContext: " + applicationContext);
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct - " + getName() + " esta se preparando pra iniciar.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization - " + getName() + " está iniciando.");
    }

    public void customInit() {
        System.out.println("8. Custom Initialization - Inicializacao customizada para " + getName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy - " + getName() + " esta se preparando para destruicao.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean - " + getName() + " está sendo destruida");
        restAndRecover();
    }

    private void restAndRecover() {
        System.out.println("12. DisposableBean - " + getName() + " esta quase la.");
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction - " + getName() + " foi pro beleleu.");

    }
}
