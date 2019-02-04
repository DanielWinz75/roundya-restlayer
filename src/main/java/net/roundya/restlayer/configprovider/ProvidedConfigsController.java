package net.roundya.restlayer.configprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvidedConfigsController {

    @GetMapping("/configs")
    public ProvidedConfigs provideConfigs() {
        return new ProvidedConfigs();
    }
}