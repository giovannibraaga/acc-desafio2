package acc.br.bean.life.cycle.config;

import acc.br.bean.life.cycle.beans.Item;
import acc.br.bean.life.cycle.processor.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public Item kite() {
        return new Item("kite");
    }

    @Bean
    public ItemProcessor itemProcessor() {
        return new ItemProcessor();
    }
}
