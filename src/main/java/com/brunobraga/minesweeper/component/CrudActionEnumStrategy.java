package com.brunobraga.minesweeper.component;

import jdk.jfr.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

@Getter
@RequiredArgsConstructor
public enum CrudActionEnumStrategy {
    CREATE(EventTypeEnum.CREATE, FieldActionComponent::create),
    DELETE(EventTypeEnum.DELETE, FieldActionComponent::delete),
    UPDATE(EventTypeEnum.UPDATE, FieldActionComponent::update);

    private final EventTypeEnum eventTypeEnum;
    private static final Map<EventTypeEnum, CrudActionEnumStrategy> mapFieldsStrategy = new HashMap<>();
    static {
        for (CrudActionEnumStrategy fieldsStrategy : CrudActionEnumStrategy.values()) {
            mapFieldsStrategy.put(fieldsStrategy.eventTypeEnum, fieldsStrategy);
        }
    }
    public static CrudActionEnumStrategy findCrudActionStrategy(EventTypeEnum eventType) {
        return Optional
                .ofNullable(mapFieldsStrategy.get(eventType))
                .orElseThrow();/*TODO throw exception*/
    }

    public final BiConsumer<FieldActionComponent, DispatchMessageLocationDto> produceMessage;

}
