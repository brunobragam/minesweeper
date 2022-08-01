package com.brunobraga.minesweeper.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationConsumerCOnfiguration {


    public final FieldActionComponent fieldActionComponent;


    public void locationConsumer(){

        //genericObject -> DispatchMessageLocationDto
        var genericObject = new DispatchMessageLocationDto();
        fieldActionComponent.execute(genericObject);

    }

}
