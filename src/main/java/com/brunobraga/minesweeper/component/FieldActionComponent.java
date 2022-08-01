package com.brunobraga.minesweeper.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FieldActionComponent {

    public void execute(DispatchMessageLocationDto genericObject){

        {
          Eventtype,  FieldReason,FieldStatus
        }

        // MSG -- {
        //          Eventtype,  FieldReason,FieldStatus
        //        }

        // LOCATION_TIMETRAKKING == list(REASON,STATUS)

        var eventTypeEnum =
                EventTypeEnum.getEventType(Integer.parseInt(genericObject.getEventType()));

        //RECEIVED -- LOCATION STRATEGY

        CrudActionEnumStrategy.findCrudActionStrategy(eventTypeEnum.selectedDomainContext)
                .getProduceMessage()
                .accept(this, genericObject);
    }

    public FieldsStrategy getFieldStrategy(String message){

        message.

        return null;
    }

    public void create(DispatchMessageLocationDto message){
        //ProducerComponent
    }

    public void delete(DispatchMessageLocationDto message){
        //ProducerComponent
    }

    public void update(DispatchMessageLocationDto message){

        //receved message
        //kafka key: 123 - {EventType: 3, FieldStatus: 2}

        //foreach FieldsStrategy using field of message - FieldStatus





    }
}
