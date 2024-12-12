package acc.br.bean.life.cycle.config;

import acc.br.bean.life.cycle.beans.Weapon;
import acc.br.bean.life.cycle.processor.WeaponProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeaponConfig {
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public Weapon knife() {
        return new Weapon("knife");
    }

    @Bean
    public WeaponProcessor weaponProcessor() {
        return new WeaponProcessor();
    }
}
