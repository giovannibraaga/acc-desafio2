package acc.br.bean.life.cycle.processor;

import acc.br.bean.life.cycle.beans.Item;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ItemProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof Item) {
            System.out.println("5. BeanPostProcessor: Adding a touch of magic to " + ((Item) bean).getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Item) {
            System.out.println("9. BeanPostProcessor: Magic continues for " + ((Item) bean).getName());
        }
        return bean;
    }

}
