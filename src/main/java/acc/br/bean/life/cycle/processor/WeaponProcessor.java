package acc.br.bean.life.cycle.processor;

import acc.br.bean.life.cycle.beans.Weapon;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class WeaponProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof Weapon) {
            System.out.println("5. BeanPostProcessor: Adding a touch of magic to " + ((Weapon) bean).getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Weapon) {
            System.out.println("9. BeanPostProcessor: Magic continues for " + ((Weapon) bean).getName());
        }
        return bean;
    }
}
